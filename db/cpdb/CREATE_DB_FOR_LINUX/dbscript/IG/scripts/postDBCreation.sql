SET VERIFY OFF
connect "SYS"/"&&sysPassword" as SYSDBA
set echo on
spool /home/oracle/dbscript/IG/scripts/postDBCreation.log append
select 'utl_recomp_begin: ' || to_char(sysdate, 'HH:MI:SS') from dual;
execute utl_recomp.recomp_serial();
select 'utl_recomp_end: ' || to_char(sysdate, 'HH:MI:SS') from dual;
execute dbms_swrf_internal.cleanup_database(cleanup_local => FALSE);
commit;
connect "SYS"/"&&sysPassword" as SYSDBA
set echo on
create spfile='/u01/app/oracle/product/11.2.0/dbhome_1/dbs/spfileIG.ora' FROM pfile='/home/oracle/dbscript/IG/scripts/init.ora';
shutdown immediate;
connect "SYS"/"&&sysPassword" as SYSDBA
startup ;
host /u01/app/oracle/product/11.2.0/dbhome_1/bin/emca -config dbcontrol db -silent -DB_UNIQUE_NAME IG -PORT 1521 -EM_HOME /u01/app/oracle/product/11.2.0/dbhome_1 -LISTENER LISTENER -SERVICE_NAME IG -SID IG -ORACLE_HOME /u01/app/oracle/product/11.2.0/dbhome_1 -HOST localhost.localdomain -LISTENER_OH /u01/app/oracle/product/11.2.0/dbhome_1 -LOG_FILE /home/oracle/dbscript/IG/scripts/emConfig.log;
spool off
