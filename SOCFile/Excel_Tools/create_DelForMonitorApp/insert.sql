connect to ig user db2admin using db2admin;

IMPORT FROM "./Del/codecategory.del" OF DEL INSERT_UPDATE INTO codecategory;
IMPORT FROM "./Del/codedetail.del" OF DEL INSERT_UPDATE INTO codedetail;

connect reset;
