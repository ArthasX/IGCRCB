connect "SYS"/"&&sysPassword" as SYSDBA
set echo on
spool D:\IGLOGOR\postDBCreation.log
connect "SYS"/"&&sysPassword" as SYSDBA
set echo on
create spfile='D:\oracle\product\10.2.0\db_1/dbs/spfileIG.ora' FROM pfile='D:\IGLOGOR\init.ora';
shutdown immediate;
connect "SYS"/"&&sysPassword" as SYSDBA
startup ;
alter user SYSMAN identified by "&&sysmanPassword" account unlock;
alter user DBSNMP identified by "&&dbsnmpPassword" account unlock;
select 'utl_recomp_begin: ' || to_char(sysdate, 'HH:MI:SS') from dual;
execute utl_recomp.recomp_serial();
select 'utl_recomp_end: ' || to_char(sysdate, 'HH:MI:SS') from dual;
host D:\oracle\product\10.2.0\db_1\bin\emca.bat -config dbcontrol db -silent -DB_UNIQUE_NAME IG -PORT 1521 -EM_HOME D:\oracle\product\10.2.0\db_1 -LISTENER LISTENER -SERVICE_NAME IG -SYS_PWD &&sysPassword -SID IG -ORACLE_HOME D:\oracle\product\10.2.0\db_1 -DBSNMP_PWD &&dbsnmpPassword -HOST chinese-e43fb84 -LISTENER_OH D:\oracle\product\10.2.0\db_1 -LOG_FILE D:\IGLOGOR\emConfig.log -SYSMAN_PWD &&sysmanPassword;
spool D:\IGLOGOR\postDBCreation.log
