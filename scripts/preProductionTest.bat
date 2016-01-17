@echo off
set workspace=C:\DatosJBB\WorkSpaces\Luna\JEE.Spring
echo -----------------------------------------
echo . Test Pre Production (C)MIW
echo -----------------------------------------
echo .
echo Workspace --- %workspace%
echo .
echo .

cd %workspace%

call mvn clean -Dmaven.test.skip=true verify -Denvironment.type=preproduction 

pause
exit
