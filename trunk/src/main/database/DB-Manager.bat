@echo off

set CLASSPATH=%CD%/hsqldb.jar
call setenv.bat
cd %HSQLDB_HOME%

java -cp %CLASSPATH% org.hsqldb.util.DatabaseManager