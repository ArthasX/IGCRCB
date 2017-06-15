set verify off
PROMPT specify a password for sys as parameter 1;
DEFINE sysPassword = &1
PROMPT specify a password for system as parameter 2;
DEFINE systemPassword = &2
PROMPT specify a password for sysman as parameter 3;
DEFINE sysmanPassword = &3
PROMPT specify a password for dbsnmp as parameter 4;
DEFINE dbsnmpPassword = &4
host D:\oracle\product\10.2.0\db_1\bin\orapwd.exe file=D:\oracle\product\10.2.0\db_1\database\PWDIG.ora password=&&sysPassword force=y
@D:\IGLOGOR\CloneRmanRestore.sql
@D:\IGLOGOR\cloneDBCreation.sql
@D:\IGLOGOR\postScripts.sql
host "echo SPFILE='D:\oracle\product\10.2.0\db_1/dbs/spfileIG.ora' > D:\oracle\product\10.2.0\db_1\database\initIG.ora"
@D:\IGLOGOR\postDBCreation.sql
