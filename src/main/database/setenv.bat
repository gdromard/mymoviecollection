set HOME=%CD%\..
rem set JAVA_HOME=D:\Program Files\Java\jre1.6.0_03
rem set ANT_HOME=C:\Home\st22085\tools\apache-ant-1.7.0
set PROJECT_HOME=%HOME%\..
set LIB_HOME=%PROJECT_HOME%\WEB-INF\lib
set CATALINA_HOME=%PROJECT_HOME%\..\..
set HSQLDB_HOME=%CD%\db\moviedb
set PATH=%JAVA_HOME%\bin;%ANT_HOME%\bin;%SYSTEMROOT%;%SYSTEMROOT%\System32;
rem JMX Activation
rem set JAVA_OPTS=-Dcom.sun.management.jmxremote -Dcom.sun.management.jmxremote.port=9004 -Dcom.sun.management.jmxremote.authenticate=false -Dcom.sun.management.jmxremote.ssl=false
