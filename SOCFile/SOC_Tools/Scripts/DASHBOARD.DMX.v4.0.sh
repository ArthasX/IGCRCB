#!/bin/sh

SOCINTERVAL=10
SOCPERFPATH=/tmp/emc/soc

SOCFTPSRV=135.10.26.12
UPFOLDER=DashBoard
FTPUSER=socadmin
FTPPASS=socadmin@bpm2
FTPSCRIPT="ftpscript"
FTPLOGFILE="ftpupload.log"


SOCSYMSID=`/usr/symcli/bin/symcfg list | grep 000 | awk '{print $1}'`

for i in ${SOCSYMSID}
do
	>${SOCPERFPATH}/DynamicPerf_${i}_300.txt
        /usr/symcli/bin/symstat -sid ${i} -i ${SOCINTERVAL} -c 2 > ${SOCPERFPATH}/DynamicPerf_${i}_300.txt 2>&1
	SOCUPFILE="DynamicPerf_${i}_300_`date +%Y%m%d%H%M`.txt"
	cd $SOCPERFPATH
	tail -n 3 DynamicPerf_${i}_300.txt > $SOCUPFILE
	echo "user $FTPUSER $FTPPASS" >$FTPSCRIPT
	echo "bin" >>$FTPSCRIPT
	echo "prompt" >>$FTPSCRIPT
	echo "hash" >>$FTPSCRIPT
	echo "cd $UPFOLDER" >>$FTPSCRIPT
	echo "put $SOCUPFILE" >>$FTPSCRIPT
	echo "close" >>$FTPSCRIPT
	echo "bye" >>$FTPSCRIPT
	ftp -n $SOCFTPSRV < $FTPSCRIPT > $FTPLOGFILE 2>&1
	rm $SOCUPFILE
	rm $FTPSCRIPT
done
