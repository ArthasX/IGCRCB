#!/bin/sh

CONFDIR="."
XMLFILE=`hostname`_`date +%Y%m%d%H%M`"("1")".xml

commands_out="temp/commands_run"

export LANG=C
unset EXTSHM
export BIN=/usr/bin

DEBUG=0

OSLEV=`oslevel | cut -c 1-3`




do_config_begin()
{
mkdir temp
do_timestamp "config.sh begins"
DATE=`date`

echo "" > $commands_out 

echo "<?xml version=\"1.0\"?>" > $XMLFILE
echo "<AIX-config label=\"`hostname`\">" >> $XMLFILE
echo "<DATE>$DATE</DATE>" >> $XMLFILE
echo "<VER>$VERSION</VER>" >> $XMLFILE
}



do_cfg_end()
{
echo "</AIX-config>" >> $XMLFILE
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

do_basic_config()
{
SECTION=BASIC_CONFIG
begin_section $SECTION
run "uname -a" "uname -a"
run "oslevel | cut -c 1-3" "oslevel | cut -c 1-3"
run "oslevel -r" "oslevel -r"
run "oslevel -s" "oslevel -s"
[ "$OSLEV" != "5.2" ] && run "lparstat-i" "lparstat -i"
run "lsconf" "lsconf" 
end_section $SECTION
}

do_uname()
{
SECTION=UNAME_PROCTYPE
begin_section $SECTION
run "uname-m" 'uname -m; echo     "        ## = model"' "uname -m"
end_section $SECTION
}

do_fs()
{
SECTION=File_System
begin_section $SECTION
run "df -k" "df -k"
run "lsfs" "lsfs"
end_section $SECTION
}


do_lsdev()
{
SECTION=LSDEV
begin_section $SECTION
run "lsdev -Cc disk" "lsdev -Cc disk" 
run "lspv" "lspv"
end_section $SECTION
}


do_lsvg_l()
{
SECTION=LSVG
begin_section $SECTION
run "lsvg" "/usr/sbin/lsvg" "lsvg"
run "lsvg-o" "/usr/sbin/lsvg -o" "lsvg -o"
for i in `/usr/sbin/lsvg -o`; do
  run "lsvg_${i}_lsvg-l_$i_lsvg-p_$i" "/usr/sbin/lsvg $i;/usr/sbin/lsvg -l $i;/usr/sbin/lsvg -p $i" "VOLUME GROUP DETAILS .. /usr/sbin/lsvg $i , lsvg -l $i and lsvg -p $i"
done
end_section $SECTION
}

do_filesystems()
{
SECTION=FILESYSTEMS
begin_section $SECTION
run "mount" "/usr/sbin/mount" "MOUNTED FILESYSTEMS  .. mount"
run "lsfs-q" "/usr/sbin/lsfs -q" "FILE SYSTEM INFORMATION:  lsfs -q"
run "df-k" "df -k" "FILESYSTEM FREE SPACE .. df -k" &
dfpid=$!
dfi=0;dftimeout=30
while [ $dfi -lt $dftimeout ]; do
        /usr/bin/ps -p $dfpid >/dev/null
        if [ $? = 0 ]; then
                sleep 2
        else
                break
        fi
        let dfi=dfi+1
done
if [ "$dfi" = $dftimeout ]; then
        echo "Killing <df> process"
        kill -9 $dfpid
fi
end_section $SECTION
}


do_env()
{
SECTION=SHELL_ENV
begin_section $SECTION
run "env_SHELL" "env" "SHELL ENVIRONMENT env"
end_section $SECTION
}



do_vio()
{
SECTION=VIO
begin_section $SECTION
if [ -d /usr/ios ]; then
	run "ioslevel" "/usr/ios/cli/ioscli ioslevel"
	run "lsdev-virtual" "/usr/ios/cli/ioscli lsdev -virtual"
	run "lspath" "/usr/ios/cli/ioscli lspath"
	run "lsmap-all" "/usr/ios/cli/ioscli lsmap -all"
	run "lsmap-all-net" "/usr/ios/cli/ioscli lsmap -all -net"
# Go grab all the LUN and vhost information for recovery
# purposes.. This script runs on VIOS only, must be run
# as ROOT (oem_setup_env)...
#
# Daryl Scott - IBM June 1, 2007
#
echo " "
echo "Hostname Vhost Connection            VTarget_Name LUN Phy_Device" > vios.info
echo "------------------------------------------------------------------------------------------------" >> vios.info
VIOS=`hostname -s`
for VHOST in `lsdev -Cc adapter|grep vhost |awk '{print $1}'`
do
VHOST_CONN=`lscfg -vl $VHOST |head -1 | awk '{print $2}'`
for VTD in `lsdev -C -p $VHOST |awk '{print $1}'`
do
LUN=`lsattr -El $VTD -a LogicalUnitAddr | awk '{print $2}'`
DEV=`lsattr -El $VTD -a aix_tdev | awk '{print $2}'`
printf "$VIOS $VHOST $VHOST_CONN $VTD $LUN $DEV\n" >> vios.info
done
done
run "vios.info" "cat vios.info" "VIOS vhost and LUN info .. cat vios.info"	
fi
end_section $SECTION
}

do_microcode()
{
SECTION=MICROCODE
begin_section $SECTION
run "lsmcode-c" "lsmcode -c"
run "lsmcode-A" "lsmcode -A"
end_section $SECTION
}
	

do_fibre()
{
SECTION=FIBRE_CHANNEL
begin_section $SECTION
run "lsdev -C | grep '^fcs'" "lsdev -C | grep '^fcs'"
lsdev -C | grep '^fcs' | cut -f1 -d" "| while read fc
do
 run "lscfg -vl $fc" "lscfg -vl $fc"
done
run "/usr/lpp/EMC/Symmetrix/bin/inq.aix64_51 -hba" "/usr/lpp/EMC/Symmetrix/bin/inq.aix64_51 -hba"
end_section $SECTION
}


do_emclpp()
{
SECTION=EMC_Software
begin_section $SECTION
run "lslpp -L EMC*" "lslpp -L EMC*"
run "lslpp -L SYM*" "lslpp -L SYM*"
end_section $SECTION
}

do_emcpp()
{
SECTION=EMC_PowerPath
begin_section $SECTION
run "powermt check_registration" "powermt check_registration"
run "powermt display dev=all" "powermt display dev=all"
end_section $SECTION
}

do_ppversion()
{
SECTION=PowerPath_Ver
begin_section $SECTION
run "powermt version|cut -c 39-" "powermt version|cut -c 39-"
end_section $SECTION
}

do_emcstor()
{
SECTION=EMC_Symmetrix
begin_section $SECTION
run "/usr/lpp/EMC/Symmetrix/bin/inq.aix64_51 -no_dots -sym_wwn" "/usr/lpp/EMC/Symmetrix/bin/inq.aix64_51 -no_dots -sym_wwn"
run "/usr/symcli/bin/symcli" "/usr/symcli/bin/symcli"
end_section $SECTION
}


do_config_begin
do_basic_config
do_uname
do_fs
do_lsdev
do_lsvg_l
do_filesystems
do_env
do_vio
do_microcode
do_fibre
do_emclpp
do_ppversion
do_emcpp
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

rm $XMLFILE
