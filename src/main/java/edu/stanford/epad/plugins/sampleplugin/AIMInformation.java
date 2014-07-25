/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.stanford.epad.plugins.sampleplugin;

import java.util.ArrayList;
import java.util.List;

import edu.stanford.hakan.aim4api.base.AimException;
import edu.stanford.hakan.aim4api.base.ImageAnnotationCollection;
import edu.stanford.hakan.aim4api.base.TwoDimensionMultiPoint;
import edu.stanford.hakan.aim4api.base.TwoDimensionSpatialCoordinate;
import edu.stanford.hakan.aim4api.usage.AnnotationBuilder;
import edu.stanford.hakan.aim4api.usage.AnnotationGetter;

public class AIMInformation {

    public AIMInformation() {
    
    }
    
    public double[] getLesionPoints(String UID) {
    	
    	double[] lesionPoints = new double[4];
    	ImageAnnotationCollection iac;
    	
		try {
			iac = AnnotationGetter.getImageAnnotationCollectionByUniqueIdentifier(ParamsV4.serverUrl, ParamsV4.namespace,
													ParamsV4.collection, ParamsV4.dbUserName, ParamsV4.dbUserPassword, UID);
			System.out.println(iac.getUniqueIdentifier().getRoot());
			System.out.println(iac.getPerson().getBirthDate());
			
			String xsiTypeOfMarkup = iac.getImageAnnotations().get(0).getMarkupEntityCollection().get(0).getXsiType();
	        if ("TwoDimensionMultiPoint".equals(xsiTypeOfMarkup)) {
	        	TwoDimensionMultiPoint twoDimensionMultiPoint = (TwoDimensionMultiPoint) iac.getImageAnnotations().get(0).getMarkupEntityCollection().get(0);
	            List<TwoDimensionSpatialCoordinate> listPoints = twoDimensionMultiPoint.getTwoDimensionSpatialCoordinateCollection().getTwoDimensionSpatialCoordinateList();
	            int j = 0;
	            for (int i = 0; i < listPoints.size(); i++) {
	            	lesionPoints[j++] = listPoints.get(i).getX();
	            	lesionPoints[j++] = listPoints.get(i).getY();
	                System.out.println(listPoints.get(i).getX());
	                System.out.println(listPoints.get(i).getY());
	            }
	        }
		
		} catch (AimException e) {
			e.printStackTrace();
		}        
        
        return lesionPoints;
    }
    
    public void setLesionPoints (String UID, List<Double> lesionPoints) {
    	ImageAnnotationCollection iac;
    	
		try {
			iac = AnnotationGetter.getImageAnnotationCollectionByUniqueIdentifier(ParamsV4.serverUrl, ParamsV4.namespace,
														ParamsV4.collection, ParamsV4.dbUserName, ParamsV4.dbUserPassword, UID);
			
			TwoDimensionMultiPoint twoDimensionMultiPoint = (TwoDimensionMultiPoint) iac.getImageAnnotations().get(0).getMarkupEntityCollection().get(0);
			
			int j = 0;
			for (int i=0; i<lesionPoints.size()/2; i++) {
				TwoDimensionSpatialCoordinate aux = twoDimensionMultiPoint.getTwoDimensionSpatialCoordinateCollection().get(i);
				aux.setX(lesionPoints.get(j++));
				aux.setY(lesionPoints.get(j++));
			}
			
			AnnotationBuilder.saveToServer(iac, ParamsV4.serverUrl, ParamsV4.namespace, ParamsV4.collection, ParamsV4.xsdFilePath, ParamsV4.dbUserName,
			            ParamsV4.dbUserPassword);
			System.out.println(AnnotationBuilder.getAimXMLsaveResult());
		
		} catch (AimException e) {
			e.printStackTrace();
		}
    }
}