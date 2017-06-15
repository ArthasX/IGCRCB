#!/bin/sh
cat swinfo.director.txt | while read PW IP NM
do
        (sleep 5;
        echo "admin";
        sleep 1;
        echo "$PW";
        sleep 4;
        echo "switchshow"
        sleep 3;
        echo "exit";)|telnet $IP > $NM.PortConf.temp.txt
        cat $NM.PortConf.temp.txt | awk '$7~/^Online/{print $2"/"$3}' > $NM.PortConf.txt
        rm $NM.PortConf.temp.txt
done
