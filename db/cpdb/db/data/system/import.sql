connect igadmin/igadmin@IG

spool 'import.log' append;

@organization.sql
@role.sql
@user.sql
@action.sql
@userrole.sql
@roleaction.sql
@codecategory.sql
@codedetail.sql
@IG545.sql
@IG117.sql
@IG225.sql
@IG259.sql
@IG380.sql
@IG007.sql
@IG622.sql
@sequence_generator_table.sql
@reportfiledefinition.sql
@reportfileversion.sql
@codecategorydef.sql
@codedetaildef.sql
@priority.sql
@collectparam.sql
@IG900.sql
@SOC0151.sql

@comment.sql
@SOC0117.sql
@SOC0109.sql
@SOC0111.sql
@SOC0113.sql
@SOC0122.sql
@SOC0303.sql
@SOC0424.sql

spool off
exit