@echo off

call setenv.bat

set JAVA_OPTS=-server -Xms128m -Xmx512m
rem set JAVA_OPTS=-server -Xms128m -Xmx512m -Djava.security.auth.login.config=C:/DtX/workspace/JAASAuthenticationExemple/jaas.conf
"%CATALINA_HOME%"/bin/startup.bat

pause