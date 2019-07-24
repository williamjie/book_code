#!/bin/sh
if [ ! $1 ]; then
 echo "提交标题 is empty"
 exit
fi

echo "提交标题:"$1
#send=`date '+%Y-%m-%d %H:%M:%S'`
#git pull origin master
#git add --all && git commit -a -m "$send" && git push origin master

#send=`date '+%Y-%m-%d %H:%M:%S'`
#A=$1
#git pull origin master && git add --all && git commit -a -m "$A time:$send" && git push origin master


send=`date '+%Y-%m-%d %H:%M:%S'`
git pull origin master && git add --all && git commit -a -m "$1" && git push origin master
