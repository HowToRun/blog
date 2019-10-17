#!/bin/sh
# 需要配置=======================
export JAVA_HOME=/opt/jdk1.8/jdk1.8.0_151
# 应用程序JAR包名称
JAR_NAME=blog.jar
# 应用程序包绝对目录
BASE_DIR=/opt/blog
# 服务英文名称，用于显示
SERVICE_NAME=blog
# ===============================

# 可执行程序完整路径
EXEC_JAR=${BASE_DIR}/${JAR_NAME}
# 依赖lib目录
MYLIB=$BASE_DIR/lib
# ClASSPATH
export CLASSPATH=$BASE_DIR/conf:$MYLIB/*

# TODO 根据不同的运行环境，自动获取PATH
export PATH=$JAVA_HOME/bin/:$PATH

echo 程序运行环境变量
echo $PATH

if [[ ! -f  '${BASE_DIR}/pid' ]];then
        mkdir -p  ${BASE_DIR}/pid
fi

if [[ ! -f  '${BASE_DIR}/logs' ]];then
        mkdir -p  ${BASE_DIR}/logs
fi

ERROR_LOG=${BASE_DIR}/logs/error.log
STD_LOG=${BASE_DIR}/logs/out.log

PID_FILE=${BASE_DIR}/pid/${SERVICE_NAME}.pid

if [[ -e ${PID_FILE} ]];then
    echo "${SERVICE_NAME}已经启动."
    echo "PID: `cat ${PID_FILE}`"
else
    echo  开始启动服务${SERVICE_NAME}
    nohup java -jar -Xms256m -Xmx1024m ${EXEC_JAR} 1>> ${STD_LOG} 2>>  ${ERROR_LOG} &
    PID=`ps -ef |grep ${EXEC_JAR} |grep -v grep |awk '{print $2}'`
    echo PID:${PID}
    if [[ -n "${PID}" ]]; then
        echo "启动服务成功,PID:${PID}"
        echo ${PID} > ${PID_FILE}
    else
        echo "服务启动失败，请查看日志 ${ERROR_LOG} "
    fi
fi

