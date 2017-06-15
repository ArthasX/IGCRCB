#!/bin/sh

CONFDIR="."

SOCSYMSID=`/usr/symcli/bin/symcfg list | grep 000 | awk '{print $1}'`

commands_out="temp/commands_run"

export LANG=C
unset EXTSHM
export BIN=/usr/bin

DEBUG=0


do_config_begin()
{
mkdir temp
do_timestamp "config.sh begins"
DATE=`date`

echo "" > $commands_out 

echo "<?xml version=\"1.0\"?>" > $XMLFILE
echo "<Storage label=\"${i}\">" >> $XMLFILE
echo "<DATE>$DATE</DATE>" >> $XMLFILE
echo "<VER>$VERSION</VER>" >> $XMLFILE
}



do_cfg_end()
{
echo "</Storage>" >> $XMLFILE
do_timestamp "config.sh completed"
echo "     CONFIG.SH: Experimental XML is in file >>> $XMLFILE <<<"
rm -R temp
echo
}


do_timestamp()
{
        echo "`/bin/date +"%H:%M:%S-%D"` :\t$1"
}


begin_section()
{
SECTION=$1
do_timestamp "$SECTION"

echo "<SECTION label=\"$SECTION\">" >> $XMLFILE

}


end_section()
{
SECTION=$1
echo "</SECTION>" >> $XMLFILE
}


run()
{
if [ "$3" ]
then
  out=$3
else
  out=$2
fi
echo "$2" >> $commands_out 
if [ $DEBUG -ne 0 ]
then
  sync;sync
fi

label=$1
echo "<COMMAND label=\"$label\">" >> $XMLFILE
echo "<LBL>$1</LBL>" >> $XMLFILE
echo "<RUN_CMD>$2</RUN_CMD>" >> $XMLFILE
echo "<OUTPUT>\n<![CDATA[\n" >> $XMLFILE
eval "$2" >> $XMLFILE
echo "\n]]></OUTPUT>" >> $XMLFILE
echo "</COMMAND>" >> $XMLFILE
}

do_emcstor()
{
SECTION=EMC_Symmetrix
begin_section $SECTION
run "/usr/symcli/bin/symcfg -sid ${i} -dir all -v list" "/usr/symcli/bin/symcfg -sid ${i} -dir all -v list"
run "/usr/symcli/bin/symdev -sid ${i} list" "/usr/symcli/bin/symdev -sid ${i} list"
run "/usr/symcli/bin/symdev -sid ${i} list -meta" "/usr/symcli/bin/symdev -sid ${i} list -meta"
run "/usr/symcli/bin/symdev -sid ${i} list -v" "/usr/symcli/bin/symdev -sid ${i} list -v"
run "/usr/symcli/bin/symdev -sid ${i} -disk all list | grep -v ' - '" "/usr/symcli/bin/symdev -sid ${i} -disk all list | grep -v ' - '"
run "/usr/symcli/bin/symdisk -sid ${i} list -v" "/usr/symcli/bin/symdisk -sid ${i} list -v"
run "/usr/symcli/bin/symmaskdb -sid ${i} list database" "/usr/symcli/bin/symmaskdb -sid ${i} list database"
end_section $SECTION
}


for i in ${SOCSYMSID}
do

XMLFILE=${i}_`date +%Y%m%d%H%M`"("3")".xml


do_config_begin
do_emcstor
do_cfg_end

ftp -n << EOF
open 135.10.26.12
user socadmin socadmin@bpm2
cd /CMDB
bin
ha
put $XMLFILE
bye
EOF

done

rm *"("3")".xml
