DATE=`date +%Y%m%d%H%M`
/usr/symcli/bin/symcfg list | grep Local | awk '{print $1}'|while read SID
do
RAWSUM=`/usr/symcli/bin/symdisk -sid $SID list|grep DF|awk '{a=NF} {print $a}'|grep -v -|awk '{sum+=$1} END {print  sum}'`
DISKNUM=`/usr/symcli/bin/symdisk -sid $SID list|grep DF|wc -l`
EFFESUM=`/usr/symcli/bin/symdev -sid $SID list|egrep 'Not Visible|/dev/'|awk '{a=NF} {print $a}'|grep -v -|awk '{sum+=$1} END {print  sum}'`
BEGIN=`/usr/symcli/bin/symdev -sid $SID list|egrep 'Not Visible|/dev/'|awk '{print $1}'|grep -v -|head -n1`
END=`/usr/symcli/bin/symdev -sid $SID list|egrep 'Not Visible|/dev/'|awk '{print $1}'|grep -v -|tail -n1`

echo "Symmetrix ID: $SID" > Storage_${SID}_$DATE.txt
echo >>Storage_${SID}_$DATE.txt
echo >>Storage_${SID}_$DATE.txt
echo "TYPE	Capacity(MB)" >>Storage_${SID}_$DATE.txt
/usr/symcli/bin/symdisk -sid $SID list|grep DF|awk '{print $6"       "$10}' >>Storage_${SID}_$DATE.txt
echo ---Raw Capacity Sum--- >>Storage_${SID}_$DATE.txt
echo $DISKNUM	$RAWSUM>>Storage_${SID}_$DATE.txt

echo >>Storage_${SID}_$DATE.txt
echo >>Storage_${SID}_$DATE.txt
echo >>Storage_${SID}_$DATE.txt

echo "LUNID	Capacity(MB)" >>Storage_${SID}_$DATE.txt
/usr/symcli/bin/symdev -sid $SID list|egrep 'Not Visible|/dev/'|awk '{a=NF} {print $1"     "$a}'|grep -v - >>Storage_${SID}_$DATE.txt

echo ---Effective Capacity Sum--- >>Storage_${SID}_$DATE.txt
echo $BEGIN-$END	$EFFESUM >>Storage_${SID}_$DATE.txt

done


