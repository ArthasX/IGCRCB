#!/bin/sh

CONFDIR="."
XMLFILE=`hostname`_`date +%Y%m%d%H%M`(4).xml

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
echo "<HPUX-config label=\"`hostname`\">" >> $XMLFILE
echo "<DATE>$DATE</DATE>" >> $XMLFILE
echo "<VER>$VERSION</VER>" >> $XMLFILE
}



do_cfg_end()
{
echo "</HPUX-config>" >> $XMLFILE
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
run "model" "model"
run "hostname" "hostname"
run "dmesg" "dmesg"
run "getconf KERNEL_BITS" "getconf KERNEL_BITS"
run "getconf MACHINE_SERIAL" "getconf MACHINE_SERIAL"
end_section $SECTION
}

do_fs()
{
SECTION=File_System
begin_section $SECTION
run "bdf" "bdf"
end_section $SECTION
}


do_lsdev()
{
SECTION=LSDEV
begin_section $SECTION
run "ioscan -kfnC disk" "ioscan -kfnC disk" 
end_section $SECTION
}

do_env()
{
SECTION=SHELL_ENV
begin_section $SECTION
run "env_SHELL" "env" "SHELL ENVIRONMENT env"
end_section $SECTION
}

do_cstm()
{
SECTION=cstm_all
begin_section $SECTION

RC=0
cstm << END > "temp/cstm_all.txt"
selclass qualifier all
info
wait
infolog
done
END

run "cstm_all" "cat temp/cstm_all.txt"
end_section $SECTION
}


do_fibre_HBAs()
{
SECTION=Fibre_HBAs
begin_section $SECTION

run "/usr/symcli/bin/syminq hba -fibre" "/usr/symcli/bin/syminq hba -fibre"

	HBA_TD=`ls -l /dev | grep td | awk '$10 ~ /td/ { print $10 }'`
	HBA_FCM=`ls -l /dev | grep fcm | awk '$10 ~ /fcm/ { print $10 }'`
	HBA_FCD=`ls -l /dev | grep fcd | awk '$10 ~ /fcd/ { print $10 }'`

	FC="${HBA_TD} ${HBA_FCM} ${HBA_FCD}"

	if [ `echo ${FC} | awk '{ print NF }'` -eq 0 ]
       	then
		echo "\nNo known fibre channel adapters found" | tee -a ${RPT}
	else
		for i in ${FC}
		do
			run "Fibre_HBAs_Info" "fcmsutil /dev/${i}"
			run "Fibre_HBAs_Stat" "fcmsutil /dev/${i} stat"
		done
	fi

end_section $SECTION
}



do_lvm()
{
SECTION=LVM
begin_section $SECTION



	run "vgdisplay" "vgdisplay -v |awk '/^VG Name/{print $3}'|cut -d"/" -f3"
	VG=`vgdisplay -v | awk '/^VG Name/ { print $3 }' | cut -d"/" -f3`
	for i in ${VG}
	do 
		vgdisplay -v ${i} | awk '$1 ~ /LV/ && $2 ~ /Name/ { print $3 }' > temp/lv_${i}.txt
		run "${i} LV" "cat temp/lv_${i}.txt"
		vgdisplay -v ${i} | awk '$1 ~ /PV/ && $2 ~ /Name/ { print $3 }' > temp/pv_${i}.txt
		run "${i} PV" "cat temp/pv_${i}.txt"

	done


end_section $SECTION
}





do_lvm_detail()
{
SECTION=LVM_Detail
begin_section $SECTION



	run "vgdisplay -v" "vgdisplay -v"
	VG=`vgdisplay -v | awk '/^VG Name/ { print $3 }' | cut -d"/" -f3`
	for i in ${VG}
	do 

		LV=`vgdisplay -v ${i} | awk '$1 ~ /LV/ && $2 ~ /Name/ { print $3 }'`
		PV=`vgdisplay -v ${i} | awk '$1 ~ /PV/ && $2 ~ /Name/ { print $3 }'`


		for j in ${LV}
		do

			lvdisplay -v ${j} > "temp/lvdisplay_-v.txt" 
			
			run "lvdisplay -v ${j}" "cat temp/lvdisplay_-v.txt"

		done

		for k in ${PV}
		do

			pvdisplay -v ${k} > "temp/pvdisplay_-v.txt" 
			
			run "pvdisplay -v ${k}" "cat temp/pvdisplay_-v.txt"

		done

	done


end_section $SECTION
}


do_emclpp()
{
SECTION=EMC_Software
begin_section $SECTION
run "swlist | grep EMC*" "swlist | grep EMC*"
run "swlist | grep SYM*" "swlist | grep SYM*"
end_section $SECTION
}

do_emcpp()
{
SECTION=EMC_PowerPath
begin_section $SECTION
run "powermt check_registration" "powermt check_registration"
run "powermt display dev=all" "powermt display dev=all"
run "/usr/ecc/exec/MHR610/inq.hpux -no_dots -sym_wwn" "/usr/ecc/exec/MHR610/inq.hpux -no_dots -sym_wwn"
end_section $SECTION
}


do_config_begin
do_basic_config
do_fs
do_lsdev
do_env
do_cstm
do_fibre_HBAs
do_lvm
do_lvm_detail
do_emclpp
do_emcpp
do_cfg_end

ftp -n << EOF
open 10.1.7.109
user emcsoc emcsoc
cd /CMDB
bin
ha
put $XMLFILE
bye
EOF

rm $XMLFILE