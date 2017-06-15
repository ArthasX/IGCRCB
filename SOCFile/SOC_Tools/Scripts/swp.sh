#!/bin/sh

SWIP=10.1.7.55
SWPASS=5-GETill

(sleep 2;
echo "admin";
sleep 1;
echo $SWPASS;
sleep 1;
echo "switchshow";
sleep 2;
echo exit;)|telnet $SWIP > sw.br.temp.txt

cat sw.br.temp.txt | awk '$7 ~/^Online/{print $2"/"$3}' >sw.temp.txt

(sleep 2;
echo "admin";
sleep 1;
echo $SWPASS;
sleep 1;
echo "switchshow";
sleep 2;
for i in `cat sw.temp.txt`
do
echo portstatsshow ${i};
sleep 1;
done
echo exit;)|telnet $SWIP > BRSW_${SWIP}_`date +%Y%m%d%H%M`.txt

