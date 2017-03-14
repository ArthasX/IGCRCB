connect "SYS"/"&&sysPassword" as SYSDBA
set echo on
spool D:\IGLOGOR\postScripts.log
@D:\oracle\product\10.2.0\db_1\rdbms\admin\dbmssml.sql;
execute dbms_datapump_utl.replace_default_dir;
commit;
connect "SYS"/"&&sysPassword" as SYSDBA
alter session set current_schema=ORDSYS;
@D:\oracle\product\10.2.0\db_1\ord\im\admin\ordlib.sql;
alter session set current_schema=SYS;
connect "SYS"/"&&sysPassword" as SYSDBA
connect "SYS"/"&&sysPassword" as SYSDBA
alter user CTXSYS account unlock identified by change_on_install;
connect "CTXSYS"/"change_on_install"
@D:\oracle\product\10.2.0\db_1\ctx\admin\defaults\dr0defdp.sql;
@D:\oracle\product\10.2.0\db_1\ctx\admin\defaults\dr0defin.sql "SIMPLIFIED CHINESE";
connect "SYS"/"&&sysPassword" as SYSDBA
execute dbms_swrf_internal.cleanup_database(cleanup_local => FALSE);
commit;
spool off
