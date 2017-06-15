connect to ig user db2admin using db2admin;

IMPORT FROM "./CSTReportDel/ReportFileDefinition.del" OF DEL INSERT_UPDATE INTO ReportFileDefinition;
IMPORT FROM "./CSTReportDel/ReportFileVersion.del" OF DEL INSERT_UPDATE INTO ReportFileVersion;

connect reset;
