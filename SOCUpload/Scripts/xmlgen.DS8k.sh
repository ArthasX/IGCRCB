#!bin/sh
if [ $# = 2 ]
then



CONFDIR="."


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
echo "<Storage label=\"$1\">" >> $XMLFILE
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

do_ibmstor()
{
SECTION=IBM_Ds8k
begin_section $SECTION
run "./dscli -user admin -passwd passw0rd -hmc1 $2 lshba -l $1" "./dscli -user admin -passwd passw0rd -hmc1 $2 lshba -l $1"                          
run "./dscli -user admin -passwd passw0rd -hmc1 $2 lsioport -l -dev $1" "./dscli -user admin -passwd passw0rd -hmc1 $2 lsioport -l -dev $1"          
run "./dscli -user admin -passwd passw0rd -hmc1 $2 lsda -l $1" "./dscli -user admin -passwd passw0rd -hmc1 $2 lsda -l $1"                            
run "./dscli -user admin -passwd passw0rd -hmc1 $2 lsddm -l $1" "./dscli -user admin -passwd passw0rd -hmc1 $2 lsddm -l $1"                          
run "./dscli -user admin -passwd passw0rd -hmc1 $2 lsarray -l -dev $1" "./dscli -user admin -passwd passw0rd -hmc1 $2 lsarray -l -dev $1"            
run "./dscli -user admin -passwd passw0rd -hmc1 $2 lsfbvol -l -dev $1" "./dscli -user admin -passwd passw0rd -hmc1 $2 lsfbvol -l -dev $1"            
run "./dscli -user admin -passwd passw0rd -hmc1 $2 lsstgencl -l $1" "./dscli -user admin -passwd passw0rd -hmc1 $2 lsstgencl -l $1"                  
run "./dscli -user admin -passwd passw0rd -hmc1 $2 lshostconnect -l -dev $1" "./dscli -user admin -passwd passw0rd -hmc1 $2 lshostconnect -l -dev $1"
run "./dscli -user admin -passwd passw0rd -hmc1 $2 lsextpool -dev $1" "./dscli -user admin -passwd passw0rd -hmc1 $2 lsextpool -dev $1"              
run "./dscli -user admin -passwd passw0rd -hmc1 $2 lshostconnect -dev $1" "./dscli -user admin -passwd passw0rd -hmc1 $2 lshostconnect -dev $1"      
run "./dscli -user admin -passwd passw0rd -hmc1 $2 lsrank -l -dev $1" "./dscli -user admin -passwd passw0rd -hmc1 $2 lsrank -l -dev $1"              
run "./dscli -user admin -passwd passw0rd -hmc1 $2 lsvolgrp -dev $1" "./dscli -user admin -passwd passw0rd -hmc1 $2 lsvolgrp -dev $1"                        
for R in `./dscli -user admin -passwd passw0rd -hmc1 $2 lsrank -l -dev $1|grep -v RAID|grep R|awk '{print $1}'`
do
run "./dscli -user admin -passwd passw0rd -hmc1 $2 showrank -dev $1 $R" "./dscli -user admin -passwd passw0rd -hmc1 $2 showrank -dev $1 $R"
done
for V in `./dscli -user admin -passwd passw0rd -hmc1 $2 lsvolgrp -dev $1|grep SCSI|grep -v Fixed|awk '{print $2}'`
do
run "./dscli -user admin -passwd passw0rd -hmc1 $2 showvolgrp  -dev $1 $V" "./dscli -user admin -passwd passw0rd -hmc1 $2 showvolgrp  -dev $1 $V"
done
end_section $SECTION
}


XMLFILE=$1_`date +%y%m%d%H%M`.xml
do_config_begin
do_ibmstor
do_cfg_end

else
        echo "xmlgen.DS8k.sh IBMSN ConsoleIP"
fi
