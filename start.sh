#!/bin/bash
rm -f tpid
nohup /home/xinhua/data/jdk1.8.0_111/bin/java -Xms4g -Xmx4g -Xmn1536m -server -jar cms_files_store.jar --spring.profiles.active=pro > /dev/null 2>&1 &
echo $! > tpid
echo Start Success!