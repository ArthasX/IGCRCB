#!/bin/sh
cat swinfo.switch.txt | while read PW IP NM
do
	(sleep 5;
        echo "admin";
        sleep 1;
        echo "$PW";
        sleep 4;
        echo "switchshow"
	sleep 3;
        echo "exit";)|telnet $IP > $NM.PortConf.temp.txt
	cat $NM.PortConf.temp.txt | awk '$5~/^Online/||$6~/^Online/{print 0"/"$2}' > $NM.PortConf.txt
	rm $NM.PortConf.temp.txt
done
