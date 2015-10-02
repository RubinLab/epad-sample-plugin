% modifyROICoordinates()
%
% Sample of a MATLAB code to serve as an example for ePAD server-side plugins.
% The code simply modifies the coordinates of a ROI and
% write the DICOM series in sampleplugin.txt file.
%
% Input:
%       dicomPath           : dicom file path
%       xData               : x coordinates as double[] 
%       yData               : y coordinates as double[] 
%
% Output:
%       result              : struct {double[] xData, double[] yData}
%
% Output file:
%       sampleplugin.txt    : log file
%
%
% @autor Franco Lamping - lamping@stanford.edu

function result = modifyROICoordinates(dicomPath, xData, yData)

% Open and initialize log file
logID = fopen(strcat(pwd, '/sampleplugin.txt'), 'w');
starttime = now;
fprintf(logID, 'modifyROICoordinates has started\n');

result = {};

% Check the number of inputs
if (nargin == 3)
    info = dicominfo(dicomPath);
    fprintf(logID, '\nID: %s\n', info.SeriesInstanceUID);
    
    for i=1:size(xData, 2)
        xData(i) = xData(i) + 50;
        yData(i) = yData(i) + 50;
    end
    
    result{1,1}.xData = xData;
    result{1,1}.yData = yData;
    
else 
    result{1,1}.xData = -1;
    result{1,1}.yData = -1;
    fprintf(logID, 'invalid number of inputs\n');
end

% Close log file
fprintf(logID, 'modifyROICoordinates finished, total time %12.8f sec\n', (now - starttime)*3600*24);
fclose(logID);
