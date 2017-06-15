mkdir D:\oracle\product\10.2.0\admin\IG\adump
mkdir D:\oracle\product\10.2.0\admin\IG\bdump
mkdir D:\oracle\product\10.2.0\admin\IG\cdump
mkdir D:\oracle\product\10.2.0\admin\IG\dpdump
mkdir D:\oracle\product\10.2.0\admin\IG\pfile
mkdir D:\oracle\product\10.2.0\admin\IG\udump
mkdir D:\oracle\product\10.2.0\db_1\cfgtoollogs\dbca\IG
mkdir D:\oracle\product\10.2.0\db_1\dbs
mkdir D:\oracle\product\10.2.0\flash_recovery_area
mkdir D:\oracle\product\10.2.0\oradata\IG
set ORACLE_SID=IG
D:\oracle\product\10.2.0\db_1\bin\oradim.exe -new -sid IG -startmode manual -spfile 
D:\oracle\product\10.2.0\db_1\bin\oradim.exe -edit -sid IG -startmode auto -srvcstart system 
D:\oracle\product\10.2.0\db_1\bin\sqlplus /nolog @D:\IGLOGOR\IG.sql
