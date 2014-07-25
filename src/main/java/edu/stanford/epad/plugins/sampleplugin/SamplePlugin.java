package edu.stanford.epad.plugins.sampleplugin;

import java.util.List;

public class SamplePlugin 
{
	private final static String _tempPath = "~/workspace/";
	
    public static void main( String[] args )
    {
    	AIMInformation aimInfo = new AIMInformation();
		double[] lesionPoints = aimInfo.getLesionPoints("3ix6byec1lkcsm8298rcuspjpq5rgydplix0z0u6");
		
//		lesionPoints.set(0, lesionPoints.get(0) + 5);
//		lesionPoints.set(2, lesionPoints.get(2) + 3);
//		
//		aimInfo.setLesionPoints("3ix6byec1lkcsm8298rcuspjpq5rgydplix0z0u6", lesionPoints);
		
		JWrapper jwr = new JWrapper();
		jwr.callPlugin(lesionPoints, _tempPath + "ankle.dcm");
    }
}
