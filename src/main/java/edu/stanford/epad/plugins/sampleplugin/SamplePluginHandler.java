/*******************************************************************************
 * Copyright (c) 2015 The Board of Trustees of the Leland Stanford Junior University
 * BY CLICKING ON "ACCEPT," DOWNLOADING, OR OTHERWISE USING EPAD, YOU AGREE TO THE FOLLOWING TERMS AND CONDITIONS:
 * STANFORD ACADEMIC SOFTWARE SOURCE CODE LICENSE FOR
 * "ePAD Annotation Platform for Radiology Images"
 *
 * This Agreement covers contributions to and downloads from the ePAD project ("ePAD") maintained by The Board of Trustees 
 * of the Leland Stanford Junior University ("Stanford"). 
 *
 * *	Part A applies to downloads of ePAD source code and/or data from ePAD. 
 *
 * *	Part B applies to contributions of software and/or data to ePAD (including making revisions of or additions to code 
 * and/or data already in ePAD), which may include source or object code. 
 *
 * Your download, copying, modifying, displaying, distributing or use of any ePAD software and/or data from ePAD 
 * (collectively, the "Software") is subject to Part A. Your contribution of software and/or data to ePAD (including any 
 * that occurred prior to the first publication of this Agreement) is a "Contribution" subject to Part B. Both Parts A and 
 * B shall be governed by and construed in accordance with the laws of the State of California without regard to principles 
 * of conflicts of law. Any legal action involving this Agreement or the Research Program will be adjudicated in the State 
 * of California. This Agreement shall supersede and replace any license terms that you may have agreed to previously with 
 * respect to ePAD.
 *
 * PART A. DOWNLOADING AGREEMENT - LICENSE FROM STANFORD WITH RIGHT TO SUBLICENSE ("SOFTWARE LICENSE").
 * 1. As used in this Software License, "you" means the individual downloading and/or using, reproducing, modifying, 
 * displaying and/or distributing Software and the institution or entity which employs or is otherwise affiliated with you. 
 * Stanford  hereby grants you, with right to sublicense, with respect to Stanford's rights in the Software, a 
 * royalty-free, non-exclusive license to use, reproduce, make derivative works of, display and distribute the Software, 
 * provided that: (a) you adhere to all of the terms and conditions of this Software License; (b) in connection with any 
 * copy, distribution of, or sublicense of all or any portion of the Software, the terms and conditions in this Software 
 * License shall appear in and shall apply to such copy and such sublicense, including without limitation all source and 
 * executable forms and on any user documentation, prefaced with the following words: "All or portions of this licensed 
 * product  have been obtained under license from The Board of Trustees of the Leland Stanford Junior University. and are 
 * subject to the following terms and conditions" AND any user interface to the Software or the "About" information display 
 * in the Software will display the following: "Powered by ePAD http://epad.stanford.edu;" (c) you preserve and maintain 
 * all applicable attributions, copyright notices and licenses included in or applicable to the Software; (d) modified 
 * versions of the Software must be clearly identified and marked as such, and must not be misrepresented as being the 
 * original Software; and (e) you consider making, but are under no obligation to make, the source code of any of your 
 * modifications to the Software freely available to others on an open source basis.
 *
 * 2. The license granted in this Software License includes without limitation the right to (i) incorporate the Software 
 * into your proprietary programs (subject to any restrictions applicable to such programs), (ii) add your own copyright 
 * statement to your modifications of the Software, and (iii) provide additional or different license terms and conditions 
 * in your sublicenses of modifications of the Software; provided that in each case your use, reproduction or distribution 
 * of such modifications otherwise complies with the conditions stated in this Software License.
 * 3. This Software License does not grant any rights with respect to third party software, except those rights that 
 * Stanford has been authorized by a third party to grant to you, and accordingly you are solely responsible for (i) 
 * obtaining any permissions from third parties that you need to use, reproduce, make derivative works of, display and 
 * distribute the Software, and (ii) informing your sublicensees, including without limitation your end-users, of their 
 * obligations to secure any such required permissions.
 * 4. You agree that you will use the Software in compliance with all applicable laws, policies and regulations including, 
 * but not limited to, those applicable to Personal Health Information ("PHI") and subject to the Institutional Review 
 * Board requirements of the your institution, if applicable. Licensee acknowledges and agrees that the Software is not 
 * FDA-approved, is intended only for research, and may not be used for clinical treatment purposes. Any commercialization 
 * of the Software is at the sole risk of you and the party or parties engaged in such commercialization. You further agree 
 * to use, reproduce, make derivative works of, display and distribute the Software in compliance with all applicable 
 * governmental laws, regulations and orders, including without limitation those relating to export and import control.
 * 5. You or your institution, as applicable, will indemnify, hold harmless, and defend Stanford against any third party 
 * claim of any kind made against Stanford arising out of or related to the exercise of any rights granted under this 
 * Agreement, the provision of Software, or the breach of this Agreement. Stanford provides the Software AS IS and WITH ALL 
 * FAULTS.  Stanford makes no representations and extends no warranties of any kind, either express or implied.  Among 
 * other things, Stanford disclaims any express or implied warranty in the Software:
 * (a)  of merchantability, of fitness for a particular purpose,
 * (b)  of non-infringement or 
 * (c)  arising out of any course of dealing.
 *
 * Title and copyright to the Program and any associated documentation shall at all times remain with Stanford, and 
 * Licensee agrees to preserve same. Stanford reserves the right to license the Program at any time for a fee.
 * 6. None of the names, logos or trademarks of Stanford or any of Stanford's affiliates or any of the Contributors, or any 
 * funding agency, may be used to endorse or promote products produced in whole or in part by operation of the Software or 
 * derived from or based on the Software without specific prior written permission from the applicable party.
 * 7. Any use, reproduction or distribution of the Software which is not in accordance with this Software License shall 
 * automatically revoke all rights granted to you under this Software License and render Paragraphs 1 and 2 of this 
 * Software License null and void.
 * 8. This Software License does not grant any rights in or to any intellectual property owned by Stanford or any 
 * Contributor except those rights expressly granted hereunder.
 *
 * PART B. CONTRIBUTION AGREEMENT - LICENSE TO STANFORD WITH RIGHT TO SUBLICENSE ("CONTRIBUTION AGREEMENT").
 * 1. As used in this Contribution Agreement, "you" means an individual providing a Contribution to ePAD and the 
 * institution or entity which employs or is otherwise affiliated with you.
 * 2. This Contribution Agreement applies to all Contributions made to ePAD at any time. By making a Contribution you 
 * represent that: (i) you are legally authorized and entitled by ownership or license to make such Contribution and to 
 * grant all licenses granted in this Contribution Agreement with respect to such Contribution; (ii) if your Contribution 
 * includes any patient data, all such data is de-identified in accordance with U.S. confidentiality and security laws and 
 * requirements, including but not limited to the Health Insurance Portability and Accountability Act (HIPAA) and its 
 * regulations, and your disclosure of such data for the purposes contemplated by this Agreement is properly authorized and 
 * in compliance with all applicable laws and regulations; and (iii) you have preserved in the Contribution all applicable 
 * attributions, copyright notices and licenses for any third party software or data included in the Contribution.
 * 3. Except for the licenses you grant in this Agreement, you reserve all right, title and interest in your Contribution.
 * 4. You hereby grant to Stanford, with the right to sublicense, a perpetual, worldwide, non-exclusive, no charge, 
 * royalty-free, irrevocable license to use, reproduce, make derivative works of, display and distribute the Contribution. 
 * If your Contribution is protected by patent, you hereby grant to Stanford, with the right to sublicense, a perpetual, 
 * worldwide, non-exclusive, no-charge, royalty-free, irrevocable license under your interest in patent rights embodied in 
 * the Contribution, to make, have made, use, sell and otherwise transfer your Contribution, alone or in combination with 
 * ePAD or otherwise.
 * 5. You acknowledge and agree that Stanford ham may incorporate your Contribution into ePAD and may make your 
 * Contribution as incorporated available to members of the public on an open source basis under terms substantially in 
 * accordance with the Software License set forth in Part A of this Agreement. You further acknowledge and agree that 
 * Stanford shall have no liability arising in connection with claims resulting from your breach of any of the terms of 
 * this Agreement.
 * 6. YOU WARRANT THAT TO THE BEST OF YOUR KNOWLEDGE YOUR CONTRIBUTION DOES NOT CONTAIN ANY CODE OBTAINED BY YOU UNDER AN 
 * OPEN SOURCE LICENSE THAT REQUIRES OR PRESCRIBES DISTRBUTION OF DERIVATIVE WORKS UNDER SUCH OPEN SOURCE LICENSE. (By way 
 * of non-limiting example, you will not contribute any code obtained by you under the GNU General Public License or other 
 * so-called "reciprocal" license.)
 *******************************************************************************/
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