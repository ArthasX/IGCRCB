connect sys/ig@IG AS SYSDBA

grant CREATE PUBLIC DATABASE LINK,DROP PUBLIC DATABASE LINK to igadmin;

connect igadmin/igadmin@IG

create public database link IG_CST_DBLINK connect to igadmin identified by igadmin using 'CST';

exit