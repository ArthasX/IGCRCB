set verify off
ACCEPT sysPassword CHAR PROMPT 'Enter new password for SYS: ' HIDE
ACCEPT systemPassword CHAR PROMPT 'Enter new password for SYSTEM: ' HIDE
ACCEPT sysmanPassword CHAR PROMPT 'Enter new password for SYSMAN: ' HIDE
ACCEPT dbsnmpPassword CHAR PROMPT 'Enter new password for DBSNMP: ' HIDE
host /u01/app/oracle/product/11.2.0/dbhome_1/bin/orapwd file=/u01/app/oracle/product/11.2.0/dbhome_1/dbs/orapwIG force=y
@/home/oracle/dbscript/IG/scripts/CloneRmanRestore.sql
@/home/oracle/dbscript/IG/scripts/cloneDBCreation.sql
@/home/oracle/dbscript/IG/scripts/postScripts.sql
@/home/oracle/dbscript/IG/scripts/lockAccount.sql
@/home/oracle/dbscript/IG/scripts/postDBCreation.sql
