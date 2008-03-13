@echo off

set CLASSPATH=%CD%/hsqldb.jar
call setenv.bat
cd %HSQLDB_HOME%

echo %PATH%

java -cp %CLASSPATH% org.hsqldb.Server

pause