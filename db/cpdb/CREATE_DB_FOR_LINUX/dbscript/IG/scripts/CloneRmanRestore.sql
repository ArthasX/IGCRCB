SET VERIFY OFF
connect "SYS"/"&&sysPassword" as SYSDBA
set echo on
spool /home/oracle/dbscript/IG/scripts/CloneRmanRestore.log append
startup nomount pfile="/home/oracle/dbscript/IG/scripts/init.ora";
@/home/oracle/dbscript/IG/scripts/rmanRestoreDatafiles.sql;
spool off
