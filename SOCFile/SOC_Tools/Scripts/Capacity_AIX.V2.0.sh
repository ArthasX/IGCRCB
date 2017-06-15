cd /tmp/Capacity

sn=`uname -Mu|awk -F"," '{print $3}'`
DATE=`date +%Y%m%d%H%M`
name=`hostname`

if [ -d /usr/ios ]
	then
		echo "This is VIOServer Env!"
		lspv|grep power|awk '{print $1" "$2}'|while read pvname pvid
		do
			if [ $pvid = none ]
   			then
     			cfgmgr -l $pvname
			fi			
    done
    
    echo "###############sn-host-vgname-pvname-pvid-sid-lunid###############" >VIO_${name}_${sn}_$DATE.txt
    echo "sn host vgname pvname pvid sid lunid" >>VIO_${name}_${sn}_$DATE.txt
    lspv|grep hdiskpower|awk '{print $1"    "$2"    "$3}'|while read pv pvid vg
    do
    	storage=`powermt display dev=$pv |egrep  "Pseudo name|Symmetrix ID|Logical device ID" |awk '{printf("%s ",$0);}END{print}'|awk -F'[=+ ]' '{print $6" "$10}'`
    	echo $sn $name $vg $pv $pvid $storage  >>VIO_${name}_${sn}_$DATE.txt
    done
	else
		if [ -f /usr/sbin/powermt ]
			then
				echo "This is NonVIO Env!"
				echo "###############sn-host-vgname-pvname-pvid-sid-lunid###############" >Host_${name}_$DATE.txt
				echo "sn host vgname pvname pvid sid lunid" >>Host_${name}_$DATE.txt
				lspv|grep hdiskpower|awk '{print $1"	"$2"	"$3}'|while read pv pvid vg
				do
					storage=`powermt display dev=$pv |egrep  "Pseudo name|Symmetrix ID|Logical device ID" |awk '{printf("%s ",$0);}END{print}'|awk -F'[=+ ]' '{print $6" "$10}'`
					echo $sn $name $vg $pv $pvid $storage  >>Host_${name}_$DATE.txt
				done
     	else
				echo "This is VIOClient Env!"
				echo "###############sn-host-vgname-pvname-pvid-sid-lunid###############" >Host_${name}_$DATE.txt
				echo "sn host vgname pvname pvid sid lunid" >>Host_${name}_$DATE.txt
				lspv|grep hdisk|awk '{print $1" "$2"    "$3}'|while read pv pvid vg
				do
					echo $sn $name $vg $pv $pvid  >>Host_${name}_$DATE.txt
				done
		fi

    echo >>Host_${name}_$DATE.txt
    echo >>Host_${name}_$DATE.txt
    echo >>Host_${name}_$DATE.txt
    echo "###############Vgname Information#################" >>Host_${name}_$DATE.txt
		echo "vgname size(M)  free(M) used(M)" >>Host_${name}_$DATE.txt
		lsvg -o|egrep -vi 'rootvg|prog'|while read vg
		do
			vg_size=`lsvg $vg|grep "TOTAL PP"|awk '{print $7}'|tr -d '('` 
			vg_free=`lsvg $vg|grep "FREE PP"|awk '{print $7}'|tr -d '('` 
			vg_used=`lsvg $vg|grep "USED PP"|awk '{print $6}'|tr -d '('` 
			echo $vg $vg_size  $vg_free $vg_used  >>Host_${name}_$DATE.txt
		done
		echo "###############VG SUM###############" >>Host_${name}_$DATE.txt
		lsvg -o|lsvg -i|grep "TOTAL PP"|awk '{print $7}'|tr -d '('|awk '{sum+=$1};END{print "The total VG_size is: "sum}' >>Host_${name}_$DATE.txt
		lsvg -o|lsvg -i|grep "FREE PP"|awk '{print $7}'|tr -d '('|awk '{sum+=$1};END{print "The total VG_free_size is: "sum}' >>Host_${name}_$DATE.txt
		lsvg -o|lsvg -i|grep "USED PP"|awk '{print $6}'|tr -d '('|awk '{sum+=$1};END{print "The total VG_used_size is: "sum}' >>Host_${name}_$DATE.txt		
		echo >>Host_${name}_$DATE.txt
		echo >>Host_${name}_$DATE.txt
		echo >>Host_${name}_$DATE.txt
		echo "###############sn-host-vgname-lvname-lvtype-lvsize-lvstate-fs-fssize-fsused-used%###############" >>Host_${name}_$DATE.txt
		echo sn      host vgname lvname lvtype lvsize'(M)' lvstate fs fs_size'(K)' fsused usedpercent >>Host_${name}_$DATE.txt
		for i in `lspv|egrep 'hdisk|hdiskpower'|awk '{print $3}'|grep -v None|sort -k2n | awk '{if ($0!=line) print;line=$0}'`
		do
			vgname=$i
			case "`lsvg -l $i|sed -n '/MOUNT POINT/,// p'|grep -v TYPE`" in
			   "")echo $sn $name $vgname "N/A" "N/A" "N/A" "N/A" "N/A" "N/A" "N/A" "N/A" >> Host_${name}_$DATE.txt
			       ;;
			    *)lsvg -l $i|sed -n '/MOUNT POINT/,// p'|grep -v TYPE|awk '{print $1" "$2" "$6" "$7}'|while read lvname lvtype lvstate mountpoint
			       do
			       pp_size=`lslv $lvname|grep "PP SIZE"|awk '{print $6}'`
			       lp_count=`lslv $lvname|grep -v MAX|grep LPs|awk '{print $2}'`
			       lv_size=`expr $pp_size \* \$lp_count`
			         case $mountpoint in
			            "") echo $sn $name $vgname "N/A" "N/A" "N/A" "N/A" "N/A" "N/A" "N/A" "N/A" >> Host_${name}_$DATE.txt
			               ;;
			           "N/A") echo $sn $name $vgname $lvname $lvtype $lv_size $lvstate "N/A" "N/A" "N/A" "N/A" >>Host_${name}_$DATE.txt
			               ;;
			            *)
			               if [ $lvstate == "open/syncd" ]; then
			               echo $sn $name $vgname $lvname $lvtype $lv_size $lvstate $mountpoint "`df -tk $mountpoint|grep -v Filesystem|awk '{print $2}'`" "`df -tk $mountpoint|grep -v Filesystem|awk '{print $3}'`" "`df -tk $mountpoint|grep -v Filesystem|awk '{print $5}'`" >>Host_${name}_$DATE.txt
			               else echo $sn $name $vgname $lvname $lvtype $lv_size $lvstate "N/A" "N/A" "N/A" "N/A" >>Host_${name}_$DATE.txt
			               fi
			               ;;
			          esac
			         done
			       ;;
			  esac
		 done
				
		num=`ps -ef|grep ora_pmon|grep -v grep |wc -l`
		if [ $num -gt 0 ]
			then	
				echo >>Host_${name}_$DATE.txt
				echo >>Host_${name}_$DATE.txt
				echo >>Host_${name}_$DATE.txt			
				echo "########################### Oracle Database Infomation#######################################" >>Host_${name}_$DATE.txt
				ps -ef|grep ora_pmon|grep -v grep|awk '{a=NF} {print $1"_"$a}'|awk -F_ '{print $1" "$4}'|while read user inst_name
				do			
					su - $user -c "				
					export ORACLE_SID=$inst_name
					echo "=================================================================================================" >>/tmp/tbs.out
					echo "Instance Name:$inst_name" >>/tmp/tbs.out
					
					sqlplus '/as sysdba' << ! >>/tmp/dbname.out
					
					show parameter db_name
					
					exit;
					!
					"
					db_name=`cat /tmp/dbname.out|grep db_name|awk '{print $3}'`
					
					echo "=================================================================================================" >>/tmp/tbs.out
					echo "Database Name:$db_name" >>/tmp/tbs.out
					echo "=================================================================================================" >>/tmp/tbs.out
					
					su - $user -c "		
					export ORACLE_SID=$inst_name				
					sqlplus '/as sysdba' << ! >>/tmp/tbs.out
					
					COLUMN dummy NOPRINT
					COLUMN pct_used FORMAT 999.9            HEADING Used%
					COLUMN name     FORMAT a25              HEADING TablespaceName
					COLUMN Kbytes   FORMAT 999,999,999,999  HEADING KBytes
					COLUMN used     FORMAT 999,999,999,999  HEADING Used
					COLUMN free     FORMAT 999,999,999,999  HEADING Free
					BREAK ON report
					COMPUTE sum OF kbytes ON REPORT
					COMPUTE sum OF free   ON REPORT
					COMPUTE sum OF used   ON REPORT
					set pagesize 2000
					set linesize 200
					SELECT
					    NVL(b.tablespace_name,nvl(a.tablespace_name,'UNKOWN')) name
					  , kbytes_alloc                                           kbytes
					  , kbytes_alloc-NVL(kbytes_free,0)                        used
					  , NVL(kbytes_free,0)                                     free
					  , ((kbytes_alloc-NVL(kbytes_free,0))/kbytes_alloc)*100   pct_used
					FROM   ( SELECT   SUM(bytes)/1024 Kbytes_free
					                , MAX(bytes)/1024 largest
					                , tablespace_name
					         FROM sys.dba_free_space
					         GROUP BY tablespace_name
					       ) a
					     , ( SELECT   SUM(bytes)/1024 Kbytes_alloc
					                , tablespace_name
					         FROM sys.dba_data_files
					         GROUP BY tablespace_name
					       ) b
					WHERE a.tablespace_name (+) = b.tablespace_name
					order by name
					/
					exit;
					!
					"
				done				
				cat /tmp/tbs.out|egrep -p 'TablespaceName|Instance Name|Database Name'|grep -v ">"  >>Host_${name}_$DATE.txt
				rm /tmp/tbs.out
				rm /tmp/dbname.out
		fi
fi

