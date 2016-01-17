@echo off
set workspace=C:\DatosJBB\WorkSpaces\Luna\JEE.Spring
echo -----------------------------------------
echo . Deploy Pre Production (C)MIW
echo -----------------------------------------
echo .
echo Workspace --- %workspace%
echo .
echo .

cd %workspace%

call mvn clean

call mvn -Dmaven.test.skip=true tomcat7:redeploy -Denvironment.type=preproduction

call mvn -Dmaven.test.skip=true verify -Denvironment.type=preproduction 

pause
exit
