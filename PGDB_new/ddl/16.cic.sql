
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
	-- ʱ���
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
	-- ʱ���
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
	-- 0.�ı�
	-- 2.����
	configtype varchar(16),
	-- 0.��
	-- 1.��
	isbase integer,
	peid varchar(32),
	PRIMARY KEY (crid),
	FOREIGN KEY (fkCoid) REFERENCES ig.compareobject (coid) ON UPDATE NO ACTION ON DELETE CASCADE,
	FOREIGN KEY (fkCpid) REFERENCES ig.compareprocess (cpid) ON UPDATE NO ACTION ON DELETE CASCADE
) WITHOUT OIDS;

/* Comments */

COMMENT ON TABLE ig.compareobject IS '�Աȶ���';
COMMENT ON COLUMN ig.compareobject.coid IS '����';
COMMENT ON COLUMN ig.compareobject.coname IS '����';
COMMENT ON COLUMN ig.compareobject.cosource IS '�Ա�Դ����id';
COMMENT ON COLUMN ig.compareobject.cotarget IS '�Ա�Ŀ������id';
COMMENT ON COLUMN ig.compareobject.fkCrid IS '�Աȹ������';
COMMENT ON COLUMN ig.compareobject.sourceIP IS 'Դ����IP';
COMMENT ON COLUMN ig.compareobject.targetIP IS 'targetIP';
COMMENT ON TABLE ig.comparerole IS '�Աȹ���';
COMMENT ON COLUMN ig.comparerole.crid IS 'crid';
COMMENT ON COLUMN ig.comparerole.crtype IS '�Ա�����';
COMMENT ON COLUMN ig.comparerole.crname IS '����';
COMMENT ON COLUMN ig.comparerole.fkCsid IS '�Ա������';
COMMENT ON COLUMN ig.comparerole.crsystemid IS 'ҵ��ϵͳid';
COMMENT ON COLUMN ig.comparerole.crsystemname IS 'ҵ��ϵͳ����';
COMMENT ON TABLE ig.comparescope IS '�Ա���';
COMMENT ON COLUMN ig.comparescope.csid IS '����';
COMMENT ON COLUMN ig.comparescope.csname IS '����';
COMMENT ON COLUMN ig.comparescope.createtime IS '����ʱ��';
COMMENT ON COLUMN ig.comparescope.csversion IS '�汾';
COMMENT ON TABLE ig.compareprocess IS '�Աȼ�¼';
COMMENT ON COLUMN ig.compareprocess.cpid IS '����';
COMMENT ON COLUMN ig.compareprocess.fkCsid IS '�ȶ������';
COMMENT ON COLUMN ig.compareprocess.cpstarttime IS '��ʼʱ��';
COMMENT ON COLUMN ig.compareprocess.cpendtime IS '����ʱ��';
COMMENT ON COLUMN ig.compareprocess.cpschedule IS '����';
COMMENT ON COLUMN ig.compareprocess.cpresulttype IS 'ִ�н��';
COMMENT ON COLUMN ig.compareprocess.errorcaption IS '������ʾ';
COMMENT ON TABLE ig.compareresult IS '�ȶԽ��';
COMMENT ON COLUMN ig.compareresult.crid IS 'crid';
COMMENT ON COLUMN ig.compareresult.fkCoid IS '�Ƚ϶����id';
COMMENT ON COLUMN ig.compareresult.fkCpid IS '�Ƚ�ִ�б�ID';
COMMENT ON COLUMN ig.compareresult.eid IS 'eid';
COMMENT ON COLUMN ig.compareresult.cid IS 'cid';
COMMENT ON COLUMN ig.compareresult.teiid IS 'Ŀ��eiid';
COMMENT ON COLUMN ig.compareresult.tciid IS 'Ŀ��ciid';
COMMENT ON COLUMN ig.compareresult.seiid IS 'Դeiid';
COMMENT ON COLUMN ig.compareresult.sciid IS 'Դciid';
COMMENT ON COLUMN ig.compareresult.svalue IS 'Դ����ֵ';
COMMENT ON COLUMN ig.compareresult.tvalue IS 'Ŀ������ֵ';
COMMENT ON COLUMN ig.compareresult.configtype IS '��������';
COMMENT ON COLUMN ig.compareresult.isbase IS '�Ƿ��ǻ�������';
COMMENT ON COLUMN ig.compareresult.peid IS '���ڵ�ģ��id';


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

  --�˵�
insert into ig.action (actname,actlabel,acturl,acttype,actroletype,actsortid,acturltype)
values('ACT22CIC','���öԱ�','/IGCOM0202.do?linkID=IGCIC0000','M1','IGCIC01','19','0');
insert into ig.action (actname,actlabel,acturl,acttype,actroletype,actsortid,acturltype)
values('ACT22CIC01','�����趨','','M2','IGCIC01','1901','0');
insert into ig.action (actname,actlabel,acturl,acttype,actroletype,actsortid,acturltype)
values('ACT22CIC0101','�Աȹ������','/IGCOM0202.do?linkID=IGCIC0101','M3','IGCIC01','190101','0');
insert into ig.action (actname,actlabel,acturl,acttype,actroletype,actsortid,acturltype)
values('ACT22CIC02','�ȶ�ִ�й���','','M2','IGCIC01','1902','0');
insert into ig.action (actname,actlabel,acturl,acttype,actroletype,actsortid,acturltype)
values('ACT22CIC0201','�Ա�ִ�����','/IGCOM0202.do?linkID=IGCIC0201','M3','IGCIC01','190201','0');


--��������� �Ƿ��Ǽ�Ⱥ����
insert into "ig".SOC0151 (CCDID,CCDCATEGORY,CCDLABEL,CCDVALUE,CCDSTATUS,CCDTYPE,CCDINFO,FINGERPRINT) 
values (149,'015','�Ƿ����ڼ�Ⱥ','��','1','A','','');
insert into "ig".SOC0151 (CCDID,CCDCATEGORY,CCDLABEL,CCDVALUE,CCDSTATUS,CCDTYPE,CCDINFO,FINGERPRINT) 
values (150,'015','�Ƿ����ڼ�Ⱥ','��','1','A','','');
--��������Ļ������� ��������
insert into "ig".SOC0151 (CCDID,CCDCATEGORY,CCDLABEL,CCDVALUE,CCDSTATUS,CCDTYPE,CCDINFO,FINGERPRINT) 
values (146,'010','��������','����','1','A','','');
insert into "ig".SOC0151 (CCDID,CCDCATEGORY,CCDLABEL,CCDVALUE,CCDSTATUS,CCDTYPE,CCDINFO,FINGERPRINT) 
values (147,'010','��������','�ֱ�','1','A','','');
insert into "ig".SOC0151 (CCDID,CCDCATEGORY,CCDLABEL,CCDVALUE,CCDSTATUS,CCDTYPE,CCDINFO,FINGERPRINT) 
values (148,'010','��������','���','1','A','','');
--�������������
insert into ig.soc0109 values('CI010100010071','CM01010001','��������','1','��CI������������',null,'1',2,'006','010','2','999001001',null,'1');
insert into ig.soc0109 values('CI010100010075','CM01010001','�Ƿ��������ݿ⼯Ⱥ','1','��CI�Ƿ��������ݿ⼯Ⱥ',null,'1',2,'006','015','2','999001001',null,'1');
insert into ig.soc0109 values('CI010100010076','CM01010001','�Ƿ����ڷ�������Ⱥ','1','��CI�Ƿ����ڷ�������Ⱥ',null,'1',2,'006','015','2','999001001',null,'1');
insert into ig.soc0109 values('CI010100010077','CM01010001','�Ƿ�����������Ⱥ','1','��CI�Ƿ�����������Ⱥ',null,'1',2,'006','015','2','999001001',null,'1');
--�Ա����ͻ�������
insert into ig.codedetail (ccid,cid,cvalue,updtime)
values ('360','147','ͬ�ǶԱ�','2014/04/23');
insert into ig.codedetail (ccid,cid,cvalue,updtime)
values ('360','148','��ضԱ�','2014/04/23');
insert into ig.codedetail (ccid,cid,cvalue,updtime)
values ('360','1470','ͬ�Ǹ��ؾ���Ա�','2014/04/23');
insert into ig.codedetail (ccid,cid,cvalue,updtime)
values ('360','1480','��ظ��ؾ���Ա�','2014/04/23');
insert into ig.codedetail (ccid,cid,cvalue,updtime)
values ('360','1460','�������ؾ���Ա�','2014/04/23');

--�������������
insert into ig.comparescope values(1,'Ĭ����','2014/05/15 12:00:00',1,'')