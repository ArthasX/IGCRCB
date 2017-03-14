
/* Drop Tables */

DROP TABLE IF EXISTS ig.compareresult;
DROP TABLE IF EXISTS ig.compareobject;
DROP TABLE IF EXISTS ig.compareobject_h;
DROP TABLE IF EXISTS ig.CompareProcessRoleRelation;
DROP TABLE IF EXISTS ig.compareprocess;
DROP TABLE IF EXISTS ig.comparerole;
DROP TABLE IF EXISTS ig.comparescope;



CREATE TABLE ig.comparescope
(
	csid integer NOT NULL,
	csname varchar(36),
	createtime varchar(19),
	csversion integer,
	-- 时间戳
	fingerprint varchar(256),
	PRIMARY KEY (csid)
) WITHOUT OIDS;


CREATE TABLE ig.comparerole
(
	crid integer NOT NULL,
	fkCsid integer,
	crtype varchar(16),
	crname varchar(36),
	crsystemid integer,
	crsystemname varchar(36),
	crversion integer,
	fingerprint varchar(256),
	PRIMARY KEY (crid),
	FOREIGN KEY (fkCsid) REFERENCES ig.comparescope (csid) ON UPDATE NO ACTION ON DELETE CASCADE
) WITHOUT OIDS;

/* Create Tables */

CREATE TABLE ig.compareobject
(
	coid integer NOT NULL,
	fkCrid integer,
	coname varchar(100),
	cotarget integer,
	cosource integer,
	sourceIP varchar(20),
	targetIP varchar(20),
	crversion integer,
	fingerprint varchar(256),
	PRIMARY KEY (coid),
	FOREIGN KEY (fkCrid) REFERENCES ig.comparerole (crid) ON UPDATE NO ACTION ON DELETE CASCADE
) WITHOUT OIDS;


CREATE TABLE ig.compareobject_h
(
	cohid integer NOT NULL,
	coid integer NOT NULL,
	fkCrid integer,
	coname varchar(100),
	cotarget integer,
	cosource integer,
	sourceIP varchar(20),
	targetIP varchar(20),
	crversion integer,
	fingerprint varchar(256),
	PRIMARY KEY (cohid)
) WITHOUT OIDS;


CREATE TABLE ig.compareprocess
(
	cpid integer NOT NULL,
	fkCsid integer,
	cpstarttime varchar(19),
	cpschedule varchar(8),
	cpresulttype varchar(16),
	errorcaption varchar(512),
	cpendtime varchar(19),
	crversion integer,
	fingerprint varchar(256),
	PRIMARY KEY (cpid),
	FOREIGN KEY (fkCsid) REFERENCES ig.comparescope (csid) ON UPDATE NO ACTION ON DELETE CASCADE
) WITHOUT OIDS;


CREATE TABLE ig.CompareProcessRoleRelation
(
	id integer NOT NULL,
	cpid integer,
	crid integer,
	crversion integer,
	-- 时间戳
	fingerprint varchar(256),
	PRIMARY KEY (id),
	FOREIGN KEY (cpid) REFERENCES ig.compareprocess (cpid) ON UPDATE RESTRICT ON DELETE RESTRICT
) WITHOUT OIDS;


CREATE TABLE ig.compareresult
(
	crid integer NOT NULL,
	fkCoid integer,
	fkCpid integer,
	eid varchar,
	cid varchar,
	teiid integer,
	tciid varchar,
	seiid integer,
	sciid varchar,
	svalue varchar,
	tvalue varchar,
	-- 0.文本
	-- 2.附件
	configtype varchar(16),
	-- 0.是
	-- 1.否
	isbase integer,
	peid varchar(32),
	PRIMARY KEY (crid),
	FOREIGN KEY (fkCoid) REFERENCES ig.compareobject (coid) ON UPDATE NO ACTION ON DELETE CASCADE,
	FOREIGN KEY (fkCpid) REFERENCES ig.compareprocess (cpid) ON UPDATE NO ACTION ON DELETE CASCADE
) WITHOUT OIDS;

/* Comments */

COMMENT ON TABLE ig.compareobject IS '对比对象';
COMMENT ON COLUMN ig.compareobject.coid IS '主键';
COMMENT ON COLUMN ig.compareobject.coname IS '名称';
COMMENT ON COLUMN ig.compareobject.cosource IS '对比源主机id';
COMMENT ON COLUMN ig.compareobject.cotarget IS '对比目标主机id';
COMMENT ON COLUMN ig.compareobject.fkCrid IS '对比规则外键';
COMMENT ON COLUMN ig.compareobject.sourceIP IS '源主机IP';
COMMENT ON COLUMN ig.compareobject.targetIP IS 'targetIP';
COMMENT ON TABLE ig.comparerole IS '对比规则';
COMMENT ON COLUMN ig.comparerole.crid IS 'crid';
COMMENT ON COLUMN ig.comparerole.crtype IS '对比类型';
COMMENT ON COLUMN ig.comparerole.crname IS '名称';
COMMENT ON COLUMN ig.comparerole.fkCsid IS '对比域外键';
COMMENT ON COLUMN ig.comparerole.crsystemid IS '业务系统id';
COMMENT ON COLUMN ig.comparerole.crsystemname IS '业务系统名称';
COMMENT ON TABLE ig.comparescope IS '对比域';
COMMENT ON COLUMN ig.comparescope.csid IS '主键';
COMMENT ON COLUMN ig.comparescope.csname IS '名称';
COMMENT ON COLUMN ig.comparescope.createtime IS '创建时间';
COMMENT ON COLUMN ig.comparescope.csversion IS '版本';
COMMENT ON TABLE ig.compareprocess IS '对比记录';
COMMENT ON COLUMN ig.compareprocess.cpid IS '主键';
COMMENT ON COLUMN ig.compareprocess.fkCsid IS '比对域外键';
COMMENT ON COLUMN ig.compareprocess.cpstarttime IS '开始时间';
COMMENT ON COLUMN ig.compareprocess.cpendtime IS '结束时间';
COMMENT ON COLUMN ig.compareprocess.cpschedule IS '进度';
COMMENT ON COLUMN ig.compareprocess.cpresulttype IS '执行结果';
COMMENT ON COLUMN ig.compareprocess.errorcaption IS '错误提示';
COMMENT ON TABLE ig.compareresult IS '比对结果';
COMMENT ON COLUMN ig.compareresult.crid IS 'crid';
COMMENT ON COLUMN ig.compareresult.fkCoid IS '比较对象表id';
COMMENT ON COLUMN ig.compareresult.fkCpid IS '比较执行表ID';
COMMENT ON COLUMN ig.compareresult.eid IS 'eid';
COMMENT ON COLUMN ig.compareresult.cid IS 'cid';
COMMENT ON COLUMN ig.compareresult.teiid IS '目标eiid';
COMMENT ON COLUMN ig.compareresult.tciid IS '目标ciid';
COMMENT ON COLUMN ig.compareresult.seiid IS '源eiid';
COMMENT ON COLUMN ig.compareresult.sciid IS '源ciid';
COMMENT ON COLUMN ig.compareresult.svalue IS '源属性值';
COMMENT ON COLUMN ig.compareresult.tvalue IS '目标属性值';
COMMENT ON COLUMN ig.compareresult.configtype IS '属性类型';
COMMENT ON COLUMN ig.compareresult.isbase IS '是否是基本属性';
COMMENT ON COLUMN ig.compareresult.peid IS '父节点模型id';


CREATE SEQUENCE ig.compareprocess_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;

CREATE SEQUENCE ig.compareobject_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;

CREATE SEQUENCE ig.comparerole_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;

CREATE SEQUENCE ig.comparescope_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
  
CREATE SEQUENCE ig.compareresult_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;

CREATE SEQUENCE ig.CompareProcessRoleRelation_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
CREATE SEQUENCE ig.compareobject_h_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;

  --菜单
insert into ig.action (actname,actlabel,acturl,acttype,actroletype,actsortid,acturltype)
values('ACT22CIC','配置对比','/IGCOM0202.do?linkID=IGCIC0000','M1','IGCIC01','19','0');
insert into ig.action (actname,actlabel,acturl,acttype,actroletype,actsortid,acturltype)
values('ACT22CIC01','配置设定','','M2','IGCIC01','1901','0');
insert into ig.action (actname,actlabel,acturl,acttype,actroletype,actsortid,acturltype)
values('ACT22CIC0101','对比规则管理','/IGCOM0202.do?linkID=IGCIC0101','M3','IGCIC01','190101','0');
insert into ig.action (actname,actlabel,acturl,acttype,actroletype,actsortid,acturltype)
values('ACT22CIC02','比对执行管理','','M2','IGCIC01','1902','0');
insert into ig.action (actname,actlabel,acturl,acttype,actroletype,actsortid,acturltype)
values('ACT22CIC0201','对比执行情况','/IGCOM0202.do?linkID=IGCIC0201','M3','IGCIC01','190201','0');


--添加主机的 是否是集群属性
insert into "ig".SOC0151 (CCDID,CCDCATEGORY,CCDLABEL,CCDVALUE,CCDSTATUS,CCDTYPE,CCDINFO,FINGERPRINT) 
values (149,'015','是否属于集群','是','1','A','','');
insert into "ig".SOC0151 (CCDID,CCDCATEGORY,CCDLABEL,CCDVALUE,CCDSTATUS,CCDTYPE,CCDINFO,FINGERPRINT) 
values (150,'015','是否属于集群','否','1','A','','');
--添加主机的环境类型 管理属性
insert into "ig".SOC0151 (CCDID,CCDCATEGORY,CCDLABEL,CCDVALUE,CCDSTATUS,CCDTYPE,CCDINFO,FINGERPRINT) 
values (146,'010','环境类型','生产','1','A','','');
insert into "ig".SOC0151 (CCDID,CCDCATEGORY,CCDLABEL,CCDVALUE,CCDSTATUS,CCDTYPE,CCDINFO,FINGERPRINT) 
values (147,'010','环境类型','灾备','1','A','','');
insert into "ig".SOC0151 (CCDID,CCDCATEGORY,CCDLABEL,CCDVALUE,CCDSTATUS,CCDTYPE,CCDINFO,FINGERPRINT) 
values (148,'010','环境类型','异地','1','A','','');
--添加主机的属性
insert into ig.soc0109 values('CI010100010071','CM01010001','环境类型','1','该CI所属环境类型',null,'1',2,'006','010','2','999001001',null,'1');
insert into ig.soc0109 values('CI010100010075','CM01010001','是否属于数据库集群','1','该CI是否属于数据库集群',null,'1',2,'006','015','2','999001001',null,'1');
insert into ig.soc0109 values('CI010100010076','CM01010001','是否属于服务器集群','1','该CI是否属于服务器集群',null,'1',2,'006','015','2','999001001',null,'1');
insert into ig.soc0109 values('CI010100010077','CM01010001','是否属于其他集群','1','该CI是否属于其他集群',null,'1',2,'006','015','2','999001001',null,'1');
--对比类型基础数据
insert into ig.codedetail (ccid,cid,cvalue,updtime)
values ('360','147','同城对比','2014/04/23');
insert into ig.codedetail (ccid,cid,cvalue,updtime)
values ('360','148','异地对比','2014/04/23');
insert into ig.codedetail (ccid,cid,cvalue,updtime)
values ('360','1470','同城负载均衡对比','2014/04/23');
insert into ig.codedetail (ccid,cid,cvalue,updtime)
values ('360','1480','异地负载均衡对比','2014/04/23');
insert into ig.codedetail (ccid,cid,cvalue,updtime)
values ('360','1460','生产负载均衡对比','2014/04/23');

--添加主机的属性
insert into ig.comparescope values(1,'默认域','2014/05/15 12:00:00',1,'')