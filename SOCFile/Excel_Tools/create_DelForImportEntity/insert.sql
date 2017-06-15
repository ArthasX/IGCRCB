connect to ig user db2admin using db2admin;

IMPORT FROM "./importmanage/EIDOMAINDETAIL.del" OF DEL INSERT INTO EIDOMAINDETAIL;
IMPORT FROM "./importmanage/IMPORTVERSION.del" OF DEL INSERT INTO IMPORTVERSION;

connect reset;
