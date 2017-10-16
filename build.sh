#!/usr/bin/env bash
PROJECT_HOME=/home/admin/app/
JAVA_OPTIONS="
    -XX:+UseConcMarkSweepGC -XX:CMSMaxAbortablePrecleanTime=5000
    -XX:+CMSClassUnloadingEnabled -XX:+UseCMSInitiatingOccupancyOnly -XX:CMSInitiatingOccupancyFraction=80
    -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/home/admin/app/logs/domo/online/java.hprof
    -verbose:gc -Xloggc:/home/admin/app/logs/domo/online/gc.log -XX:+PrintGCDetails
    -XX:+PrintGCDateStamps -Djava.awt.headless=true -Dsun.net.client.defaultConnectTimeout=10000
    -Dsun.net.client.defaultReadTimeout=30000 -XX:+DisableExplicitGC -Xdebug
    -agentlib:jdwp=transport=dt_socket,address=7080,server=y,suspend=n"

JAR_DIR=${PROJECT_NAME}-core/target
JAR_NAME=${PROJECT_NAME}.jar
cd ${PROJECT_HOME}
ls
mvn clean install -Dmaven.test.skip&& mvn package -Dmaven.test.skip
cd ${JAR_DIR}
DOMO_PID=`ps -ef | grep "domo" | grep -v grep | awk '{print $2}'`
echo "DOMO PID = $DOMO_PID"
echo "java_options = $JAVA_OPTIONS"
#kill -9 DOMO_PID
java ${JAVA_OPTIONS} -jar ${JAR_NAME} --spring.profiles.active=${ENV}
echo "========Build successful======="