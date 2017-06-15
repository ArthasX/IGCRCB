connect to cst user db2admin using db2admin;

IMPORT FROM "./SYMMETRIX_INFO/COLLECT_SYMMETRIX_INFO.del" OF DEL INSERT INTO COLLECT_SYMMETRIX_INFO;

connect reset;
