connect igadmin/igadmin@IG
--变更数量、成功率统计表
CREATE TABLE ChangeTendency(
	CTYear CHAR(4) not null,
	CTMonth CHAR(2) not null,
	CTDay CHAR(2) not null,
	CTAmount INTEGER,
	CTSucRate Decimal(5,2),
	fingerprint VARCHAR(256),
  PRIMARY KEY (CTYear,CTMonth,CTDay)
) TABLESPACE IG_SPACE;
--事件数量、解决时间统计表
CREATE TABLE INCIDENTTENDENCY(
  ITYEAR	CHARACTER(4) not null,
  ITMONTH	CHARACTER(2) not null,
  ITAMOUNT	INTEGER,
  ITAVERAGETIME	INTEGER,
  FINGERPRINT	VARCHAR(256),
  ITDAY	CHARACTER(2) not null,
  PRIMARY KEY (ITYEAR,ITMONTH,ITDAY)
) TABLESPACE IG_SPACE;

exit