This is a Sample Epad Plugin which can be imported into eclipse as a maven project. You can use it as a model to develop your own plugin for ePAD

Please rename the package and class to your own plugin name. 

This java class can call any MATLAB code that you create (the sample has some MATLAB code also). The java class can also call any of  the rest api documented on our site (using HTTPClient or something similar). A few of the AIM and dicom related api have some convenience methods available in PluginAIMUtil and DCM4CHEEUtil in epad-common (there are examples  of the calls in the sample code).

Use maven to build a jar for the java code and Builder JA to create the MATLAB jar. There are instructions on the ePAD website creating the MATLAB jar for the plugin. You also need to create a template xml for your plugin.

To install and test your plugin:

1.	First install an ePAD system using the current ePAD VM image on the ftp site or ePAD Docker images.
2.	Copy your generated jars (one for the java plugin and one for MATLAB code) into DicomProxy/lib/plugins (there is no need to copy the epad-common or aimapi jar file - they are in the repository just for linking your java code)
3.	Upload your template xml file to the ePAD system
4.	Define your new plugin through the ePAD UI 
5.	Restart epad (alias epad-start), in order to load your jars.

If you create an annotation using your new template, you should see your plugin being called (from the server log: DicomProxy/log/epad-ws.log)