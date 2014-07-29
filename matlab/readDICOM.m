function header = readDICOM( path, lesionPoints )

% Open and initialize log file
logID = fopen(strcat(pwd, '/readDICOM.txt'), 'w');
starttime = now;
fprintf(logID, 'readDICOM has started\n');
header = lesionPoints(1);
if (nargin == 2)
    I = dicomread(path);
    info = dicominfo(path);

    fprintf(logID, '\nID:\n');
    fprintf(logID, info.SeriesInstanceUID);
    
    %http://www.mathworks.com/help/matlab/matlab_external/passing-data-to-a-java-method.html
    %http://www.mathworks.com/help/matlab/matlab_external/working-with-java-arrays.html
    
end
fprintf(logID, 'readDICOM finished, total time %12.8f sec\n', (now - starttime)*3600*24);
fclose(logID);
