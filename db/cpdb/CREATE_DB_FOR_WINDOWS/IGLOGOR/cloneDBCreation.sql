connect "SYS"/"&&sysPassword" as SYSDBA
set echo on
spool D:\IGLOGOR\cloneDBCreation.log
Create controlfile reuse set database "IG"
MAXINSTANCES 8
MAXLOGHISTORY 1
MAXLOGFILES 16
MAXLOGMEMBERS 3
MAXDATAFILES 100
Datafile 
'D:\oracle\product\10.2.0\oradata\IG\SYSTEM01.DBF',
'D:\oracle\product\10.2.0\oradata\IG\UNDOTBS01.DBF',
'D:\oracle\product\10.2.0\oradata\IG\SYSAUX01.DBF',
'D:\oracle\product\10.2.0\oradata\IG\USERS01.DBF'
LOGFILE GROUP 1 ('D:\oracle\product\10.2.0/oradata/IG/redo01.log') SIZE 51200K,
GROUP 2 ('D:\oracle\product\10.2.0/oradata/IG/redo02.log') SIZE 51200K,
GROUP 3 ('D:\oracle\product\10.2.0/oradata/IG/redo03.log') SIZE 51200K RESETLOGS;
exec dbms_backup_restore.zerodbid(0);
shutdown immediate;
startup nomount pfile="D:\IGLOGOR\initIGTemp.ora";
Create controlfile reuse set database "IG"
MAXINSTANCES 8
MAXLOGHISTORY 1
MAXLOGFILES 16
MAXLOGMEMBERS 3
MAXDATAFILES 100
Datafile 
'D:\oracle\product\10.2.0\oradata\IG\SYSTEM01.DBF',
'D:\oracle\product\10.2.0\oradata\IG\UNDOTBS01.DBF',
'D:\oracle\product\10.2.0\oradata\IG\SYSAUX01.DBF',
'D:\oracle\product\10.2.0\oradata\IG\USERS01.DBF'
LOGFILE GROUP 1 ('D:\oracle\product\10.2.0/oradata/IG/redo01.log') SIZE 51200K,
GROUP 2 ('D:\oracle\product\10.2.0/oradata/IG/redo02.log') SIZE 51200K,
GROUP 3 ('D:\oracle\product\10.2.0/oradata/IG/redo03.log') SIZE 51200K RESETLOGS;
alter system enable restricted session;
alter database "IG" open resetlogs;
alter database rename global_name to "IG";
ALTER TABLESPACE TEMP ADD TEMPFILE 'D:\oracle\product\10.2.0\oradata\IG\TEMP01.DBF' SIZE 20480K REUSE AUTOEXTEND ON NEXT 640K MAXSIZE UNLIMITED;
select tablespace_name from dba_tablespaces where tablespace_name='USERS';
select sid, program, serial#, username from v$session;
alter database character set INTERNAL_CONVERT AL32UTF8;
alter database national character set INTERNAL_CONVERT AL16UTF16;
alter user sys identified by "&&sysPassword";
alter user system identified by "&&systemPassword";
alter system disable restricted session;
