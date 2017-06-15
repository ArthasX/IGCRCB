#!/bin/sh

SWIP=10.1.7.88
SWPASS=5-GETill

(sleep 2;
echo "admin";
sleep 1;
echo $SWPASS;
sleep 1;
echo "switchshow";
sleep 2;
echo exit;)|telnet $SWIP > sw.br.temp2.txt

cat sw.br.temp2.txt | awk '$5 ~/^Online/{print 0"/"$2}' >sw.temp2.txt

(sleep 2;
echo "admin";
sleep 1;
echo $SWPASS;
sleep 1;
echo "switchshow";
sleep 2;
for i in `cat sw.temp2.txt`
do
echo portstatsshow ${i};
sleep 1;
done
echo exit;)|telnet $SWIP > BRSW_${SWIP}_`date +%Y%m%d%H%M`.txt


