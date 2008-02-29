@echo off

call setenv.bat

java -cp "%LIB_HOME%\hsqldb.jar" org.hsqldb.util.DatabaseManager