#!/bin/sh

OLD_UMASK=`umask`
umask 0027
mkdir -p /u01/app/oracle/admin/IG/adump
mkdir -p /u01/app/oracle/admin/IG/dpdump
mkdir -p /u01/app/oracle/admin/IG/pfile
mkdir -p /u01/app/oracle/cfgtoollogs/dbca/IG
mkdir -p /u01/app/oracle/flash_recovery_area
mkdir -p /u01/app/oracle/flash_recovery_area/IG
mkdir -p /u01/app/oracle/oradata/IG
mkdir -p /u01/app/oracle/product/11.2.0/dbhome_1/dbs
umask ${OLD_UMASK}
ORACLE_SID=IG; export ORACLE_SID
PATH=$ORACLE_HOME/bin:$PATH; export PATH
echo 您应在 /etc/oratab 中添加此条目: IG:/u01/app/oracle/product/11.2.0/dbhome_1:Y
/u01/app/oracle/product/11.2.0/dbhome_1/bin/sqlplus /nolog @/home/oracle/dbscript/IG/scripts/IG.sql
