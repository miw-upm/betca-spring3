@echo off
set workspace=C:\DatosJBB\WorkSpaces\Luna\JEE.Spring
set tomcat=C:\Archivos_de_programa\apache-tomcat-8.0.28
echo -----------------------------------------
echo . Test (C)MIW
echo -----------------------------------------
echo .
echo Workspace --- %workspace%
echo .
echo .

cd %tomcat%\bin
call startup.bat

cd %workspace%

call mvn clean test

::timeout /t 50, sobra tiempo
call mvn -Dmaven.test.skip=true tomcat7:redeploy

call mvn -Dmaven.test.skip=true verify


:shutdown
pause
cd %tomcat%\bin
call shutdown.bat
timeout /t 10
::Se boora todo lo creado
cd %tomcat%
rd /s /q temp
mkdir temp
cd webapps
del *.war /q
rd /s /q JEE.Spring.0.0.1-SNAPSHOT

exit

:errorDevelop
echo .
echo .
echo .
echo ########  ERRORES...
goto shutdown
