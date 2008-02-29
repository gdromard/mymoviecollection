@echo off

call setenv.bat

set JAVA_OPTS=-server -Xms128m -Xmx512m
"%CATALINA_HOME%"/bin/shutdown.bat

pause