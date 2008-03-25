. setenv.sh

export CLASSPATH=$CD/hsqldb.jar
cd $HSQLDB_HOME

echo $PROJECT_HOME

java -cp $CLASSPATH org.hsqldb.Server
