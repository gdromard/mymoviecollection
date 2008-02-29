@echo off

call setenv.bat

cd %HSQLDB_HOME%

echo %PATH%

java -cp "%LIB_HOME%\hsqldb.jar" org.hsqldb.Server

pause