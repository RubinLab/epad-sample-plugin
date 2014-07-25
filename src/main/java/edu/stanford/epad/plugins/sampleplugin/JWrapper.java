package edu.stanford.epad.plugins.sampleplugin;

import java.util.List;




import com.mathworks.toolbox.javabuilder.MWException;
import com.mathworks.toolbox.javabuilder.MWNumericArray;
import com.mathworks.toolbox.javabuilder.remoting.AbstractMWArrayVisitor;

import readDICOM.ReadDICOM;

public class JWrapper {
	
	private ReadDICOM readDICOM = null; // MATLAB-generated Java class containing function ReadDICOM
	
	public JWrapper () {
		if (readDICOM == null) {
			try {
				readDICOM = new ReadDICOM();
			} catch (MWException t) {
				t.printStackTrace();
			}
		}
	}

	public void callPlugin(double[] lesionPoints, String DICOMpath) {
		try {
			
			Object[] outputMasks = readDICOM.readDICOM(1, DICOMpath, lesionPoints);
			System.out.println("Result: " + outputMasks[0]);

		} catch (Exception e) {
			System.out.println("NOT OK");
			System.out.println(e);
		}
	}
}