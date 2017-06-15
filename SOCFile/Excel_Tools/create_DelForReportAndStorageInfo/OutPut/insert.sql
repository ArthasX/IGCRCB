connect to ig user db2admin using db2admin;

EXPORT TO "C:\SOCFile\Excel_Tools\create_DelForReportAndStorageInfo\OutPut\codedetail.del" OF DEL MESSAGES "asd" SELECT cvalue,syscoding FROM DB2ADMIN.CODEDETAIL where CCID LIKE '913' order by syscoding ;

connect reset;
