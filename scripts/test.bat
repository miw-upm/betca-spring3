@echo off
set workspace=C:\DatosJBB\WorkSpaces\Luna\JEE.Paddle
echo -----------------------------------------
echo . Test (C)MIW
echo -----------------------------------------
echo .
echo Workspace --- %workspace%
echo .
echo .
cd %workspace%
call mvn clean test
pause
