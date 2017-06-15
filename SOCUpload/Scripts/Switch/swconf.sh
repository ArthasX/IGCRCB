#!/bin/sh
SWDATE=`date +%Y%m%d%H%M`
cat swinfo.txt | while read PW IP NM
do
(sleep 7;
	echo "admin";
	sleep 2
	echo "$PW";
	sleep 3;
	echo "switchshow"
	sleep 2;
	echo "version"
	sleep 1;
	echo "cfgshow"
	sleep 2;
	echo "switchstatusshow"
	sleep 1;
	echo "chassisshow"
	sleep 1;
	echo "exit";)|telnet $IP > $NM"_"$SWDATE"("2")".txt
done

ftp -n << EOF
open 135.10.26.12
user socadmin socadmin@bpm2
cd /CMDB
bin
ha
prompt
mput *"("2")".txt 
bye
EOF

rm -f *"("2")".txt
