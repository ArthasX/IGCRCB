connect "SYS"/"&&sysPassword" as SYSDBA
set echo on
spool D:\IGLOGOR\CloneRmanRestore.log
startup nomount pfile="D:\IGLOGOR\init.ora";
@D:\IGLOGOR\rmanRestoreDatafiles.sql;
