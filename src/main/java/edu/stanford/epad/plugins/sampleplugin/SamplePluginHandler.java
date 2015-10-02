package edu.stanford.epad.plugins.sampleplugin;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modifyroi_java.ModifyROI;

import com.mathworks.toolbox.javabuilder.MWCellArray;
import com.mathworks.toolbox.javabuilder.MWCharArray;
import com.mathworks.toolbox.javabuilder.MWClassID;
import com.mathworks.toolbox.javabuilder.MWException;
import com.mathworks.toolbox.javabuilder.MWNumericArray;
import com.mathworks.toolbox.javabuilder.MWStructArray;

import edu.stanford.epad.common.dicom.DCM4CHEEUtil;
import edu.stanford.epad.common.plugins.AbstractPluginServletHandler;
import edu.stanford.epad.common.plugins.PluginAIMUtil;
import edu.stanford.epad.common.plugins.PluginAIMUtil.ROIData;
import edu.stanford.epad.common.plugins.PluginEventPoster;
import edu.stanford.epad.common.plugins.PluginHandler;
import edu.stanford.epad.common.plugins.PluginXNATUtil;
import edu.stanford.epad.common.plugins.impl.PluginAIMOptions;
import edu.stanford.epad.common.util.EPADLogger;
import edu.stanford.hakan.aim4api.base.DicomImageReferenceEntity;
import edu.stanford.hakan.aim4api.base.ImageAnnotationCollection;
import edu.stanford.hakan.aim4api.base.ImageStudy;

@PluginHandler
public class SamplePluginHandler extends AbstractPluginServletHandler
{
	private static final EPADLogger log = EPADLogger.getInstance();

	private ModifyROI modifyROI = null; // MATLAB-generated Java class containing function sampleFunction

	@Override
	public void init() {
		log.info("sampleplugin: init");
		
		if (modifyROI == null) {
			try {
				modifyROI = new ModifyROI();
			} catch (MWException t) {
				log.warning("sampleplugin: warning - failed to initialize", t);
				t.printStackTrace();
			}
		}
	}
	
	
	@Override
	public void destroy()
	{
		log.info("sampleplugin: destroy");
		if (modifyROI != null) {
			modifyROI.dispose();
		}
	}

	@Override
	public int doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
	{
		return doGet(httpServletRequest, httpServletResponse);
	}

	@Override
	public String getVersion()
	{
		return "1.0 - 2014-08-21";
	}

	@Override
	public String getName()
	{
		return "sampleplugin";
	}

	@Override
	public String getAuthorsContactInfo()
	{
		return "Franco Lamping - lamping@stanford.edu";
	}

	@Override
	public String getDescription()
	{
		return "Sample plugin to test the plugin mechanism";
	}
	
	@Override
	public int doGet(HttpServletRequest request, HttpServletResponse response)
	{
		int statusCode;

		String aimID = request.getParameter("aimFile");
		String projectID = request.getParameter("projectID");
		if (aimID == null) {
			log.warning("sampleplugin: warning - missing aimFile parameter");
			statusCode = HttpServletResponse.SC_BAD_REQUEST;
		} else if (projectID == null) {
			log.warning("sampleplugin: warning - missing projectID parameter");
			statusCode = HttpServletResponse.SC_BAD_REQUEST;
		} else {
			PrintWriter responseStream = null;
			log.info("sampleplugin: AIM ID " + aimID);
			log.info("sampleplugin: Project ID " + projectID);
			
			try {
				ImageAnnotationCollection templateImageAnnotationCollection = PluginAIMUtil.getImageAnnotationCollectionFromServer(aimID, projectID);
				responseStream = response.getWriter();

				if (templateImageAnnotationCollection != null) {
					// String username = imageAnnotation.getListUser().get(0).getLoginName();
					String event_status = "Started";
					String pluginName = getName();
					String sessionID = PluginXNATUtil.getJSessionIDFromRequest(request);
					PluginAIMOptions pluginAIMOptions = new PluginAIMOptions(pluginName, sessionID, templateImageAnnotationCollection);

					// Notification for the GUI that the plugin has started
					PluginEventPoster.postPluginEvent(event_status, pluginAIMOptions);
					
					PluginAIMUtil.saveAnnotationToAnnotationsDirectory(templateImageAnnotationCollection);
					
					/* Prepare inputs to invoke the plugin */
					
					// Get DICOM path					
					DicomImageReferenceEntity dicomImageReferenceEntity = (DicomImageReferenceEntity) templateImageAnnotationCollection
																			.getImageAnnotations().get(0).getImageReferenceEntityCollection().get(0);
					ImageStudy imageStudy = dicomImageReferenceEntity.getImageStudy();
					String studyUID = imageStudy.getInstanceUid().getRoot();
					String seriesUID = imageStudy.getImageSeries().getInstanceUid().getRoot();
					String imageUID = imageStudy.getImageSeries().getImageCollection().get(0).getSopInstanceUid().getRoot();
					
					File dicomFile = File.createTempFile(imageUID + "_" + aimID, ".tmp");
					DCM4CHEEUtil.downloadDICOMFileFromWADO(studyUID, seriesUID, imageUID, dicomFile);
					
					boolean result = invokePlugin(templateImageAnnotationCollection, dicomFile, imageUID, projectID, true);						
					if (result) {
						event_status = "complete";
						log.info("sampleplugin: plugin execution complete");
					} else {
						event_status = "failed";
						log.warning("sampleplugin: plugin execution failed");
					}
					
					PluginEventPoster.postPluginEvent(event_status, pluginAIMOptions);
				} else {
					responseStream.println("AIM file not found");
					log.warning("sampleplugin: Could not find AIM file");
					statusCode = HttpServletResponse.SC_BAD_REQUEST;
				}
				statusCode = HttpServletResponse.SC_OK;
			} catch (IOException ioe) {
				printErrorPage(ioe, responseStream);
				log.warning("sampleplugin: IO error invoking plugin", ioe);
				statusCode = HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
			} catch (Exception e) {
				printErrorPage(e, responseStream);
				log.warning("sampleplugin: Error invoking plugin", e);
				statusCode = HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
			}
		}
		return statusCode;
	}

	private boolean invokePlugin (ImageAnnotationCollection imageAnnotationCollection, File dicomFile, String imageUID, String projectID, boolean saveAsAim) {
		
		
		try {
			edu.stanford.hakan.aim4api.compability.aimv3.ImageAnnotation imageAnnotation = 
					new edu.stanford.hakan.aim4api.compability.aimv3.ImageAnnotation(imageAnnotationCollection);
			
			log.info("sampleplugin: extracting ROI data from the AIM file");
			ROIData roiData = PluginAIMUtil.extractROIData(imageAnnotation);
			if (roiData.xData == null || roiData.yData == null) {
				log.warning("sampleplugin: plugin failed to get ROI in AIM file");
				return false;
			}
			
			MWCharArray dicomPath = new MWCharArray(getRealPath(dicomFile));
			MWNumericArray xData = new MWNumericArray(roiData.xData, MWClassID.DOUBLE);
			MWNumericArray yData = new MWNumericArray(roiData.yData, MWClassID.DOUBLE);

			log.info("sampleplugin: Invoking MATLAB-generated code...");
			Object[] outputMasks = modifyROI.modifyROICoordinates(1, dicomPath, xData, yData);
			log.info("sampleplugin: ....returned from MATLAB-generated code");
			
			MWCellArray resCell = (MWCellArray) outputMasks[0];
			MWStructArray resStruct = (MWStructArray) resCell.getCell(1);
			
			int ix = resStruct.fieldIndex("xData") + 1;
			int iy = resStruct.fieldIndex("yData") + 1;
			MWNumericArray xx = (MWNumericArray) resStruct.getField(ix);
			MWNumericArray yy = (MWNumericArray) resStruct.getField(iy);
			ROIData resROIData = new ROIData(xx.getDoubleData(), yy.getDoubleData());
			
			if (resROIData.xData[0] == -1 && resROIData.yData[0] == -1) {
				log.warning("sampleplugin: invalid number of inputs were passed to modifyROICoordinates()");
				return false;
			}
			
			if (saveAsAim) {
				if (PluginAIMUtil.setNewSegmentationPoints(imageAnnotation, imageUID, getName(), resROIData.xData, resROIData.yData)) {
					// Save 
					PluginAIMUtil.sendImageAnnotationToServer(imageAnnotation.toAimV4(), projectID);
					
					log.info("sampleplugin: succeed to set new segmentation points");
				} else {
					log.warning("sampleplugin: failed to set new segmentation points");
				}
			}

		} catch (Throwable t) {
			log.warning("sampleplugin: Failed invoking plugin", t);
			return false;
		}
		return true;
	}
	
	private void printErrorPage(Throwable throwable, PrintWriter out)
	{
		if (out != null) {
			out.println("ERROR");
			outputException(throwable, out);
			out.flush();
		}
	}
	
	/**
	 * Get the concurrent path if possible, otherwise get the absolute path.
	 * 
	 * @param file File
	 * @return String path of file. Concurrent path if possible.
	 */
	private static String getRealPath(File file)
	{
		try {
			return file.getCanonicalPath();
		} catch (IOException ioe) {
			return file.getAbsolutePath();
		}
	}


}