@echo off
set tomcat=C:\Archivos_de_programa\apache-tomcat-8.0.28
echo -----------------------------------------
echo . Start Shut Down Tomcat (C)MIW
echo -----------------------------------------
echo .
echo Workspace --- %workspace%
echo .
echo .

::Se arranca Tomcat en local
cd %tomcat%\bin
call startup.bat
pause

:shutdown
call shutdown.bat
timeout /t 20
::Se boora todo lo creado
cd %tomcat%
rd /s /q temp
mkdir temp
cd webapps
del *.war /q
rd /s /q JEE.Paddle.0.0.1-SNAPSHOT

exit
