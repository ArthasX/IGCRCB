#!/bin/sh

cat swinfo.txt | while read PW IP NM
do
(sleep 10;
echo "admin";
sleep 1;
echo $PW;
sleep 8;
echo "switchshow";
sleep 2;
for i in `cat ../$NM.PortConf.txt`
do
echo portstatsshow ${i};
sleep 1;
done
echo exit;)|telnet $IP > BRSW"_"$IP"_"`date +%Y%m%d%H%M`.txt

done

ftp -n << EOF
open 135.10.26.12
user socadmin socadmin@bpm2
cd /SwitchPerf
bin
ha
prompt
mput BRSW*.txt 
bye
EOF

