insert into ig.soc0117 values('CM02110001','SQL Server软件',null,null,'1','002','0','1',null,'999002001007','999002001',null,'1');
insert into ig.soc0117 values('CM02110002','SQL Server数据库',null,null,'1','002','0','1',null,'999002001007001','999002001007',null,'1');
insert into ig.soc0117 values('CM02110003','SQL Server用户',null,null,'1','002','0','1',null,'999002001007002','999002001007',null,'1');
insert into ig.soc0117 values('CM02110004','SQL Server表空间',null,null,'1','002','0','1',null,'999002001007003','999002001007',null,'1');
insert into ig.soc0117 values('CM02110005','SQL Server表',null,null,'1','002','0','1',null,'999002001007004','999002001007',null,'1');

insert into ig.soc0109 values('CI021100010001','CM02110001','SQL Server','IGRES','SQL Server软件','','1',2,'007','','0','999002001007','','0');
insert into ig.soc0109 values('CI021100010002','CM02110001','SQL Server安装路径','IGRES','SQL Server安装路径','','1',2,'007','','0','999002001007','','0');
insert into ig.soc0109 values('CI021100010003','CM02110001','SQL Server版本','IGRES','SQL Server版本','','1',2,'007','','0','999002001007','','0');
insert into ig.soc0109 values('CI021100010004','CM02110001','IP地址','IGRES','IP地址','','1',2,'007','','0','999002001007','','0');
insert into ig.soc0109 values('CI021100010005','CM02110001','Resource_id','IGRES','Resource_id','','1',1,'007','','0','999002001007','','0');

insert into ig.soc0109 values('CI021100020001','CM02110002','数据库名','IGRES','数据库名','','1',2,'007','','0','999002001007001','','0');
insert into ig.soc0109 values('CI021100020002','CM02110002','数据库容量','IGRES','数据库容量','','1',2,'007','','0','999002001007001','','0');
insert into ig.soc0109 values('CI021100020003','CM02110002','数据库所有者','IGRES','数据库所有者','','1',2,'007','','0','999002001007001','','0');
insert into ig.soc0109 values('CI021100020004','CM02110002','数据库ID','IGRES','数据库ID','','1',2,'007','','0','999002001007001','','0');
insert into ig.soc0109 values('CI021100020005','CM02110002','数据库创建时间','IGRES','数据库创建时间','','1',2,'007','','0','999002001007001','','0');
insert into ig.soc0109 values('CI021100020006','CM02110002','数据库状态','IGRES','数据库状态','','1',2,'007','','0','999002001007001','','0');
insert into ig.soc0109 values('CI021100020007','CM02110002','数据库兼容级别','IGRES','数据库兼容级别','','1',2,'007','','0','999002001007001','','0');
insert into ig.soc0109 values('CI021100020008','CM02110002','IP地址','IGRES','IP地址','','1',2,'007','','0','999002001007001','','0');

insert into ig.soc0109 values('CI021100030001','CM02110003','用户名','IGRES','用户名','','1',2,'007','','0','999002001007002','','0');
insert into ig.soc0109 values('CI021100030002','CM02110003','组名','IGRES','组名','','1',2,'007','','0','999002001007002','','0');
insert into ig.soc0109 values('CI021100030003','CM02110003','登录名','IGRES','登录名','','1',2,'007','','0','999002001007002','','0');
insert into ig.soc0109 values('CI021100030004','CM02110003','数据库名','IGRES','数据库名','','1',2,'007','','0','999002001007002','','0');

insert into ig.soc0109 values('CI021100040001','CM02110004','表空间名','IGRES','表空间名','','1',2,'007','','0','999002001007003','','0');
insert into ig.soc0109 values('CI021100040002','CM02110004','表空间容量','IGRES','表空间容量','','1',2,'007','','0','999002001007003','','0');
insert into ig.soc0109 values('CI021100040003','CM02110004','表空间组','IGRES','表空间组','','1',2,'007','','0','999002001007003','','0');
insert into ig.soc0109 values('CI021100040004','CM02110004','表空间最大使用量','IGRES','表空间最大使用量','','1',2,'007','','0','999002001007003','','0');
insert into ig.soc0109 values('CI021100040005','CM02110004','表空间增长大小','IGRES','表空间增长大小','','1',2,'007','','0','999002001007003','','0');
insert into ig.soc0109 values('CI021100040006','CM02110004','数据库名','IGRES','数据库名','','1',2,'007','','0','999002001007003','','0');
insert into ig.soc0109 values('CI021100040007','CM02110004','表空间文件','IGRES','表空间文件','','1',2,'007','','0','999002001007003','','0');
insert into ig.soc0109 values('CI021100040008','CM02110004','表空间用途','IGRES','表空间用途','','1',2,'007','','0','999002001007003','','0');

insert into ig.soc0109 values('CI021100050001','CM02110005','数据库名','IGRES','数据库名','','1',2,'007','','0','999002001007004','','0');
insert into ig.soc0109 values('CI021100050002','CM02110005','表所有者','IGRES','表所有者','','1',2,'007','','0','999002001007004','','0');
insert into ig.soc0109 values('CI021100050003','CM02110005','表名','IGRES','表名','','1',2,'007','','0','999002001007004','','0');
insert into ig.soc0109 values('CI021100050004','CM02110005','表类型','IGRES','表类型','','1',2,'007','','0','999002001007004','','0');

insert into "ig".SOC0152 (rlnCode,fromModelName,fromModelEid,toModelName,toModelEid,rlnDesc,rlnType,fingerprint) values ('CR010100010028','主机','CM01010001','SQL Server软件','CM02110001','主机-SQL Server软件','1',NULL);
insert into "ig".SOC0152 (rlnCode,fromModelName,fromModelEid,toModelName,toModelEid,rlnDesc,rlnType,fingerprint) values ('CR020004000001','SQL Server软件','CM02110001','SQL Server数据库','CM02110002','SQL Server软件-SQL Server数据库','1',NULL);
insert into "ig".SOC0152 (rlnCode,fromModelName,fromModelEid,toModelName,toModelEid,rlnDesc,rlnType,fingerprint) values ('CR021100020001','SQL Server数据库','CM02110002','SQL Server用户','CM02110003','SQL Server数据库-SQL Server用户','1',NULL);
insert into "ig".SOC0152 (rlnCode,fromModelName,fromModelEid,toModelName,toModelEid,rlnDesc,rlnType,fingerprint) values ('CR021100020002','SQL Server数据库','CM02110002','SQL Server表空间','CM02110004','SQL Server数据库-SQL Server表空间','1',NULL);
insert into "ig".SOC0152 (rlnCode,fromModelName,fromModelEid,toModelName,toModelEid,rlnDesc,rlnType,fingerprint) values ('CR021100020003','SQL Server数据库','CM02110002','SQL Server表','CM02110005','SQL Server数据库-SQL Server表','1',NULL);

insert into ig.codedetail VALUES ('165', '38', 'SQL Server', NULL, NULL, '2010/01/01 00:00', '999002001007001', NULL, NULL, NULL, NULL, 'CR020003000001', NULL);
insert into ig.codedetail VALUES ('165', '39', 'SQL Server', NULL, NULL, '2010/01/01 00:00', '999002001007001', NULL, NULL, NULL, NULL, 'CR030001000003', NULL);
insert into ig.codedetail VALUES ('165', '40', 'SQL Server', NULL, NULL, '2010/01/01 00:00', '999002001007001', NULL, NULL, NULL, NULL, 'CR021000010001', NULL);

insert into "ig".SOC0113 (IMPTYPEID,IMPTYPENAME,IMPPROGRAMME,IMPPROGRAMMEAUDIT,IMPPROGRAMMEUPDATE,FINGERPRINT,COLLECTTYPE,SHELLNAME) 
values (102,'SQL Server软件',null,null,null,'999002001007',null,null);



-- Sequence: ig.em

-- DROP SEQUENCE ig.em;

CREATE SEQUENCE ig.em_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE ig.em_seq OWNER TO postgres;


-- Table: ig.em

-- DROP TABLE ig.em;

CREATE TABLE ig.em
(
 em_id		   integer NOT NULL DEFAULT nextval('ig.em_seq'::regclass),
 em_type            character varying(1) not null, 
 em_sqlid           character varying(64), 
 em_sessionid       character varying(10), 
 em_sqltype         character varying(64), 
 em_sqlcontent      character varying(2048), 
 em_username        character varying(32), 
 em_program         character varying(128), 
 em_other           character varying(10), 
 em_network         character varying(10), 
 em_queueing        character varying(10), 
 em_idle            character varying(10), 
 em_cluster         character varying(10), 
 em_administrative  character varying(10), 
 em_configuraction  character varying(10), 
 em_commit          character varying(10), 
 em_application     character varying(10), 
 em_concurrency     character varying(10), 
 em_systemio        character varying(10), 
 em_userio          character varying(10), 
 em_scheduler       character varying(10), 
 em_cpu             character varying(10), 
 em_totail          character varying(10) not null, 
 em_collecttime     character varying(16), 
 fingerprint        character varying(256),
 CONSTRAINT em_pkey PRIMARY KEY (em_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE ig.em OWNER TO postgres;

insert into "ig".CODECATEGORY (CCID, CCNAME, CCINFO, CCEDITABLE, PCCID, PCFLAG, FINGERPRINT)
values ('162', 'DB顶级设定', null, '3', null, '0', null);
insert into "ig".CODEDETAIL (CCID, CID, CVALUE, PCCID, PCID, UPDTIME, SYSCODING, PSYSCODING, CDSTATUS, BUSINESSCODE, FINGERPRINT, CDINFO, CDORDER)
values ('162', '1', '70', null, null, '2010/01/01 00:00', null, null, null, null, null, '顶级SQL', null);
insert into "ig".CODEDETAIL (CCID, CID, CVALUE, PCCID, PCID, UPDTIME, SYSCODING, PSYSCODING, CDSTATUS, BUSINESSCODE, FINGERPRINT, CDINFO, CDORDER)
values ('162', '2', '80', null, null, '2010/01/01 00:00', null, null, null, null, null, '顶级会话', null);


