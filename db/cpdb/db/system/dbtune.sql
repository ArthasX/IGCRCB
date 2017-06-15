connect sys/ig@IG AS SYSDBA
create temporary tablespace user_temp tempfile 'D:\app\Administrator\oradata\IG\user_temp.dbf' size 50m autoextend on next 50 maxsize 20480m extent management local;
create tablespace IG_SPACE logging datafile 'D:\app\Administrator\oradata\IG\ig_space.dbf' size 50m autoextend on next 50m maxsize 20480m extent management local; 
create tablespace SOC_SPACE logging datafile 'D:\app\Administrator\oradata\IG\soc_space.dbf' size 50m autoextend on next 50m maxsize 20480m extent management local; 
create user igadmin identified by igadmin default tablespace IG_SPACE temporary tablespace user_temp;
grant create table,create view,create trigger, create sequence,create procedure to igadmin;
grant connect,resource,dba to igadmin;
exit