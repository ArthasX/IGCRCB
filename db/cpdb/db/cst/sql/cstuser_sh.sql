connect sys/ig@CST AS SYSDBA
create temporary tablespace user_temp tempfile '/u01/app/oracle/oradata/CST/user_temp.dbf'  size 50m   autoextend on next 50 maxsize 20480m  extent management local;
create tablespace SOC_SPACE logging  datafile '/u01/app/oracle/oradata/CST/user_data.dbf'  size 50m   autoextend on next 50m maxsize 20480m  extent management local; 
create user igadmin identified by igadmin default tablespace SOC_SPACE temporary tablespace user_temp;
grant create table,create view,create trigger, create sequence,create procedure to igadmin;
grant connect,resource,dba to igadmin;