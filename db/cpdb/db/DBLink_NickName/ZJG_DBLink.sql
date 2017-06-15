connect sys/ig@IG AS SYSDBA

grant CREATE PUBLIC DATABASE LINK,DROP PUBLIC DATABASE LINK to igadmin;

connect igadmin/igadmin@IG

create public database link IG_HQ_DBLINK connect to hq identified by hq using 'HQ';
create public database link IG_DW_DBLINK connect to ig identified by zjgrcb using 'DW';

exit