CREATE TABLE "ig".VIM01(
	VCID INTEGER NOT NULL , 
	VCNAME VARCHAR(128) , 
	VCURL VARCHAR(128) , 
	VCUSERNAME VARCHAR(32) ,
	VCPASSWORD VARCHAR(32) ,
	VCSTATUS VARCHAR(2) ,
	FINGERPRINT VARCHAR(256),
	PRIMARY KEY (VCID)
);

CREATE TABLE "ig".VIM02
(
	ID INTEGER NOT NULL,
	PROJECTNAME VARCHAR(256),
	EXPECTDEPLOYTIME VARCHAR(16),
	PROJECTEXPIRETIME VARCHAR(16),
	PROJECTTYPE VARCHAR(128),
	PROJECTDESC VARCHAR(512),
	PROJECTAPPLYREASON VARCHAR(512),
	ORGSYSCODING VARCHAR(32),
	ORGNAME VARCHAR(128),
	PROGRESS VARCHAR(6),
	FINGERPRINT VARCHAR(256),
	PRIMARY KEY (ID)
);


CREATE TABLE "ig".VIM03
(
	ID INTEGER NOT NULL,
	PID INTEGER,
	PRID INTEGER,
	PNAME VARCHAR(256),
	VCID INTEGER,
	VCNAME VARCHAR(128) , 
	TEMPLATENAME VARCHAR(256),
	HOSTNAME VARCHAR(128),
	NETWORKNAME VARCHAR(128),
	VMNAME VARCHAR(256),
	VMCPUS INTEGER,
	VMMEM INTEGER,
	VMDISK INTEGER,
	IP VARCHAR(15),
	STATUS CHAR(1),
	PROGRESS VARCHAR(6),
	DATACENTERNAME VARCHAR(128),
	RESOURCEPOOLNAME VARCHAR(128),
	ORGSYSCODING VARCHAR(32),
	ORGNAME VARCHAR(128),
	USERID VARCHAR(16),
	USERNAME VARCHAR(32),
	APPLYTIME VARCHAR(16),
	EXPIRYTIME VARCHAR(16),
	FINGERPRINT VARCHAR(256),
	PRIMARY KEY (ID),
	FOREIGN KEY (PID) REFERENCES ig.VIM02 (ID) ON DELETE CASCADE,
	FOREIGN KEY (PRID) REFERENCES ig.IG500 (PRID) ON DELETE CASCADE
) ;

CREATE TABLE "ig".VIM04
(
	ID INTEGER NOT NULL,
	PID INTEGER NOT NULL,
	VMNAME VARCHAR(128),
	CONTENT VARCHAR(1024),
	UPDATETIME VARCHAR(16),
	FLAG VARCHAR(1),
	FINGERPRINT VARCHAR(256),
	PRIMARY KEY (ID),
	FOREIGN KEY (PID) REFERENCES ig.VIM02 (ID) ON DELETE CASCADE
) ;

insert into "ig".SEQUENCE_GENERATOR_TABLE (SEQUENCE_NAME, SEQUENCE_VALUE)
values ('VIM01_SEQUENCE', 1000);
insert into "ig".SEQUENCE_GENERATOR_TABLE (SEQUENCE_NAME, SEQUENCE_VALUE)
values ('VIM02_SEQUENCE', 1000);
insert into "ig".SEQUENCE_GENERATOR_TABLE (SEQUENCE_NAME, SEQUENCE_VALUE)
values ('VIM03_SEQUENCE', 1000);
insert into "ig".SEQUENCE_GENERATOR_TABLE (SEQUENCE_NAME, SEQUENCE_VALUE)
values ('VIM04_SEQUENCE', 1000);

delete from ig."action" where actname like 'ACT17VIR';
delete from ig."action" where actname like 'ACT17VIR02%';
delete from ig."action" where actname like 'ACT17VIR03%';
delete from ig."action" where actname like 'ACT17VIR04%';
delete from ig."action" where actname like 'ACT17VIR07%';
INSERT INTO ig."action" (actname,actlabel,actdesc,acturl,acttype,actl1id,actl2id,actl3id,fingerprint,actroletype,actsortid,acturltype) 
VALUES ('ACT17VIR','资源管理',NULL,'/IGCOM0202.do?linkID=IGVIR0600','M1',NULL,NULL,NULL,NULL,'IGCI01,IGBP09,IGBP10','07','0'
);
INSERT INTO ig."action" (actname,actlabel,actdesc,acturl,acttype,actl1id,actl2id,actl3id,fingerprint,actroletype,actsortid,acturltype)
VALUES ('ACT17VIR02','资源申请',NULL,NULL,'M2',NULL,NULL,NULL,NULL,'IGCI01,IGBP09,IGBP10','0702','0'
);
INSERT INTO ig."action" (actname,actlabel,actdesc,acturl,acttype,actl1id,actl2id,actl3id,fingerprint,actroletype,actsortid,acturltype) 
VALUES ('ACT17VIR0204','申请查询',NULL,'/IGCOM0202.do?linkID=IGWKM0103&prtype=WD&prpdid=01002','M3',NULL,NULL,NULL,NULL,'IGCI01,IGBP09,IGBP10','070204','0'
);
INSERT INTO ig."action" (actname,actlabel,actdesc,acturl,acttype,actl1id,actl2id,actl3id,fingerprint,actroletype,actsortid,acturltype)
VALUES ('ACT17VIR03','资源调整',NULL,NULL,'M2',NULL,NULL,NULL,NULL,'IGCI01,IGBP09,IGBP10','0703','0'
);
INSERT INTO ig."action" (actname,actlabel,actdesc,acturl,acttype,actl1id,actl2id,actl3id,fingerprint,actroletype,actsortid,acturltype)
VALUES ('ACT17VIR0301','资源调整',NULL,'/IGCOM0202.do?linkID=IGWKM0104&psdcode=Z&pdid=01003&ptid=8','M3',NULL,NULL,NULL,NULL,'IGCI01,IGBP09,IGBP10','070301','0'
);
INSERT INTO ig."action" (actname,actlabel,actdesc,acturl,acttype,actl1id,actl2id,actl3id,fingerprint,actroletype,actsortid,acturltype) 
VALUES ('ACT17VIR04','资源回收',NULL,NULL,'M2',NULL,NULL,NULL,NULL,'IGCI01,IGBP09,IGBP10','0704','0'
);
INSERT INTO ig."action" (actname,actlabel,actdesc,acturl,acttype,actl1id,actl2id,actl3id,fingerprint,actroletype,actsortid,acturltype) 
VALUES ('ACT17VIR0401','资源回收',NULL,'/IGCOM0202.do?linkID=IGWKM0104&psdcode=Z&pdid=01004&ptid=8','M3',NULL,NULL,NULL,NULL,'IGCI01,IGBP09,IGBP10','070401','0'
);
INSERT INTO ig."action" (actname,actlabel,actdesc,acturl,acttype,actl1id,actl2id,actl3id,fingerprint,actroletype,actsortid,acturltype) 
VALUES ('ACT17VIR0404','回收查询',NULL,'/IGCOM0202.do?linkID=IGWKM0103&prtype=WD&prpdid=01004','M3',NULL,NULL,NULL,NULL,'IGCI01,IGBP09,IGBP10','070404','0'
);
INSERT INTO ig."action" (actname,actlabel,actdesc,acturl,acttype,actl1id,actl2id,actl3id,fingerprint,actroletype,actsortid,acturltype) 
VALUES ('ACT17VIR0201','资源申请',NULL,'/IGCOM0202.do?linkID=IGWKM0104&psdcode=Z&pdid=01002&ptid=8','M3',NULL,NULL,NULL,NULL,'IGCI01,IGBP09,IGBP10','070201','0'
);
INSERT INTO ig."action" (actname,actlabel,actdesc,acturl,acttype,actl1id,actl2id,actl3id,fingerprint,actroletype,actsortid,acturltype) 
VALUES ('ACT17VIR0304','调整查询',NULL,'/IGCOM0202.do?linkID=IGWKM0103&prtype=WD&prpdid=01003','M3',NULL,NULL,NULL,NULL,'IGCI01,IGBP09,IGBP10','070304','0'
);




insert into ig.ACTION (ACTNAME, ACTLABEL, ACTDESC, ACTURL, ACTTYPE, ACTL1ID, ACTL2ID, ACTL3ID, FINGERPRINT, ACTROLETYPE, ACTSORTID, ACTURLTYPE)
values ('ACT17VIR13', '虚机资源管理', '', '', 'M2', null, null, null, '', 'IGCI01', '0713', '0');

insert into ig.ACTION (ACTNAME, ACTLABEL, ACTDESC, ACTURL, ACTTYPE, ACTL1ID, ACTL2ID, ACTL3ID, FINGERPRINT, ACTROLETYPE, ACTSORTID, ACTURLTYPE)
values ('ACT17VIR1301', '虚机资源管理', '', '/IGCOM0202.do?linkID=IGVIR1301', 'M3', null, null, null, '', 'IGCI01', '071301', '0');

insert into ig.ACTION (ACTNAME, ACTLABEL, ACTDESC, ACTURL, ACTTYPE, ACTL1ID, ACTL2ID, ACTL3ID, FINGERPRINT, ACTROLETYPE, ACTSORTID, ACTURLTYPE)
values ('ACT17VIR14', '统计分析', '', '', 'M2', null, null, null, '', 'IGCI01', '0714', '0');

insert into ig.ACTION (ACTNAME, ACTLABEL, ACTDESC, ACTURL, ACTTYPE, ACTL1ID, ACTL2ID, ACTL3ID, FINGERPRINT, ACTROLETYPE, ACTSORTID, ACTURLTYPE)
values ('ACT17VIR1401', '资源申请统计', '', '/IGCOM0202.do?linkID=IGVIR1401', 'M3', null, null, null, '', 'IGCI01', '071401', '0');

insert into ig.ACTION (ACTNAME, ACTLABEL, ACTDESC, ACTURL, ACTTYPE, ACTL1ID, ACTL2ID, ACTL3ID, FINGERPRINT, ACTROLETYPE, ACTSORTID, ACTURLTYPE)
values ('ACT17VIR1402', '资源使用情况统计', '', '/IGCOM0202.do?linkID=IGVIR1402', 'M3', null, null, null, '', 'IGCI01', '071402', '0');

insert into ig.ACTION (ACTNAME, ACTLABEL, ACTDESC, ACTURL, ACTTYPE, ACTL1ID, ACTL2ID, ACTL3ID, FINGERPRINT, ACTROLETYPE, ACTSORTID, ACTURLTYPE)
values ('ACT17VIR1403', '运行及运维情况', '', '/IGCOM0202.do?linkID=IGVIR1403', 'M3', null, null, null, '', 'IGCI01', '071403', '0');


insert into "ig".ACTION (ACTNAME, ACTLABEL, ACTDESC, ACTURL, ACTTYPE, ACTL1ID, ACTL2ID, ACTL3ID, FINGERPRINT, ACTROLETYPE, ACTSORTID, ACTURLTYPE)
values('ACT17VIR07','vCenter管理',null,null,'M2',null,null,null,null,'IGCI01','0707','0');
insert into "ig".ACTION (ACTNAME, ACTLABEL, ACTDESC, ACTURL, ACTTYPE, ACTL1ID, ACTL2ID, ACTL3ID, FINGERPRINT, ACTROLETYPE, ACTSORTID, ACTURLTYPE)
values('ACT17VIR0701','vCenter查询',null,'/IGCOM0202.do?linkID=IGVIR0701','M3',null,null,null,null,'IGCI01','070701','0');
insert into "ig".ACTION (ACTNAME, ACTLABEL, ACTDESC, ACTURL, ACTTYPE, ACTL1ID, ACTL2ID, ACTL3ID, FINGERPRINT, ACTROLETYPE, ACTSORTID, ACTURLTYPE)
values('ACT17VIR0702','vCenter新增',null,'/IGCOM0202.do?linkID=IGVIR0702','M3',null,null,null,null,'IGCI01','070702','0');


insert into ig.ACTION (ACTNAME, ACTLABEL, ACTDESC, ACTURL, ACTTYPE, ACTL1ID, ACTL2ID, ACTL3ID, FINGERPRINT, ACTROLETYPE, ACTSORTID, ACTURLTYPE)
values ('ACT17VIR12', '资源预测', '', '', 'M2', null, null, null, '', 'IGCI01', '0712', '0');

insert into ig.ACTION (ACTNAME, ACTLABEL, ACTDESC, ACTURL, ACTTYPE, ACTL1ID, ACTL2ID, ACTL3ID, FINGERPRINT, ACTROLETYPE, ACTSORTID, ACTURLTYPE)
values ('ACT17VIR1201', '资源分配情况', '', '/IGCOM0202.do?linkID=IGVIR1201', 'M3', null, null, null, '', 'IGCI01', '071201', '0');

insert into ig.ACTION (ACTNAME, ACTLABEL, ACTDESC, ACTURL, ACTTYPE, ACTL1ID, ACTL2ID, ACTL3ID, FINGERPRINT, ACTROLETYPE, ACTSORTID, ACTURLTYPE)
values ('ACT17VIR13', '虚机资源管理', '', '', 'M2', null, null, null, '', 'IGCI01', '0713', '0');

insert into ig.ACTION (ACTNAME, ACTLABEL, ACTDESC, ACTURL, ACTTYPE, ACTL1ID, ACTL2ID, ACTL3ID, FINGERPRINT, ACTROLETYPE, ACTSORTID, ACTURLTYPE)
values ('ACT17VIR1301', '虚机资源管理', '', '/IGCOM0202.do?linkID=IGVIR1301', 'M3', null, null, null, '', 'IGCI01', '071301', '0');

insert into "ig".ACTION (ACTNAME, ACTLABEL, ACTDESC, ACTURL, ACTTYPE, ACTL1ID, ACTL2ID, ACTL3ID, FINGERPRINT, ACTROLETYPE, ACTSORTID, ACTURLTYPE)
values('ACT20VIR','统计分析',null,'/IGCOM0202.do?linkID=IGVIR0800','M1',null,null,null,null,'IGCI01','11','0');
insert into "ig".ACTION (ACTNAME, ACTLABEL, ACTDESC, ACTURL, ACTTYPE, ACTL1ID, ACTL2ID, ACTL3ID, FINGERPRINT, ACTROLETYPE, ACTSORTID, ACTURLTYPE)
values('ACT20VIR08','资源统计',null,null,'M2',null,null,null,null,'IGCI01','1108','0');
insert into "ig".ACTION (ACTNAME, ACTLABEL, ACTDESC, ACTURL, ACTTYPE, ACTL1ID, ACTL2ID, ACTL3ID, FINGERPRINT, ACTROLETYPE, ACTSORTID, ACTURLTYPE)
values('ACT20VIR0801','我的个人资源',null,'/IGCOM0202.do?linkID=IGVIR0801','M3',null,null,null,null,'IGCI01','110801','0');
insert into "ig".ACTION (ACTNAME, ACTLABEL, ACTDESC, ACTURL, ACTTYPE, ACTL1ID, ACTL2ID, ACTL3ID, FINGERPRINT, ACTROLETYPE, ACTSORTID, ACTURLTYPE)
values('ACT20VIR0802','人员资源',null,'/IGCOM0202.do?linkID=IGVIR0802','M3',null,null,null,null,'IGCI01','110802','0');
insert into "ig".ACTION (ACTNAME, ACTLABEL, ACTDESC, ACTURL, ACTTYPE, ACTL1ID, ACTL2ID, ACTL3ID, FINGERPRINT, ACTROLETYPE, ACTSORTID, ACTURLTYPE)
values('ACT20VIR0803','我的部门资源',null,'/IGCOM0202.do?linkID=IGVIR0803','M3',null,null,null,null,'IGCI01','110803','0');
insert into "ig".ACTION (ACTNAME, ACTLABEL, ACTDESC, ACTURL, ACTTYPE, ACTL1ID, ACTL2ID, ACTL3ID, FINGERPRINT, ACTROLETYPE, ACTSORTID, ACTURLTYPE)
values('ACT20VIR0804','部门资源',null,'/IGCOM0202.do?linkID=IGVIR0804','M3',null,null,null,null,'IGCI01','110804','0');
insert into "ig".ACTION (ACTNAME, ACTLABEL, ACTDESC, ACTURL, ACTTYPE, ACTL1ID, ACTL2ID, ACTL3ID, FINGERPRINT, ACTROLETYPE, ACTSORTID, ACTURLTYPE)
values('ACT20VIR0805','项目资源',null,'/IGCOM0202.do?linkID=IGVIR0805','M3',null,null,null,null,'IGCI01','110805','0');

insert into "ig".ACTION (ACTNAME, ACTLABEL, ACTDESC, ACTURL, ACTTYPE, ACTL1ID, ACTL2ID, ACTL3ID, FINGERPRINT, ACTROLETYPE, ACTSORTID, ACTURLTYPE)
values('ACT02SVC1116','流程数量统计',null,'/IGCOM0202.do?linkID=IGSVC0642','M3',null,null,null,null,'IGBP01,IGBP02,IGBP03,IGBP04,IGBP08','011116','0');

CREATE TABLE "ig".VCD01(
	VCID INTEGER NOT NULL , 
	VCNAME VARCHAR(128) , 
	VCURL VARCHAR(128) , 
	VCUSERNAME VARCHAR(32) ,
	VCPASSWORD VARCHAR(32) ,
	VCSTATUS VARCHAR(2) ,
	FINGERPRINT VARCHAR(256),
	PRIMARY KEY (VCID)
);

CREATE TABLE "ig".VCD02
(
	ID INTEGER NOT NULL,
	PROJECTNAME VARCHAR(256),
	EXPECTDEPLOYTIME VARCHAR(16),
	PROJECTEXPIRETIME VARCHAR(16),
	PROJECTTYPE VARCHAR(128),
	PROJECTDESC VARCHAR(512),
	PROJECTAPPLYREASON VARCHAR(512),
	ORGSYSCODING VARCHAR(32),
	ORGNAME VARCHAR(128),
	PROGRESS VARCHAR(6),
	FINGERPRINT VARCHAR(256),
	PRIMARY KEY (ID)
);


CREATE TABLE "ig".VCD03
(
	ID INTEGER NOT NULL,
	PID INTEGER,
	VCID INTEGER,
	VCNAME VARCHAR(256),
	TEMPLATEID INTEGER,
	TEMPLATENAME VARCHAR(256),
	HOSTNAME VARCHAR(128),
	NETWORKNAME VARCHAR(128),
	VMNAME VARCHAR(256),
	VMCPUS INTEGER,
	VMMEM INTEGER,
	VMDISK INTEGER,
	PROGRESS VARCHAR(6),
	NETWORK VARCHAR(128),
	STORAGEPROFILE VARCHAR(128),
	ORGSYSCODING VARCHAR(32),
	ORGNAME VARCHAR(128),
	USERID VARCHAR(16),
	USERNAME VARCHAR(32),
	APPLYTIME VARCHAR(16),
	EXPIRYTIME VARCHAR(16),
	PRID INTEGER,
	FINGERPRINT VARCHAR(256),
	PRIMARY KEY (ID),
	FOREIGN KEY (PID) REFERENCES ig.VCD02 (ID) ON DELETE CASCADE
) ;

CREATE TABLE "ig".VCD04
(
	ID INTEGER NOT NULL,
	PID INTEGER NOT NULL,
	VMNAME VARCHAR(128),
	CONTENT VARCHAR(1024),
	UPDATETIME VARCHAR(16),
	FLAG VARCHAR(1),
	FINGERPRINT VARCHAR(256),
	PRIMARY KEY (ID),
	FOREIGN KEY (PID) REFERENCES ig.VCD02 (ID) ON DELETE CASCADE
) ;

CREATE TABLE "ig".VCD05
(
	ID INTEGER,
	TEMPLATENAME VARCHAR(128),
	VCLOUDID INTEGER,
	VAPPNAME VARCHAR(128),
	FINGERPRINT VARCHAR(256),
	PRIMARY KEY(ID)
);

CREATE TABLE "ig".VCD06
(
	ID INTEGER,
	VORG VARCHAR(128),
	ORGSYSCODING VARCHAR(32),
	ORGNAME VARCHAR(64),
	FINGERPRINT VARCHAR(256),
	PRIMARY KEY(ID)
);

--计费策略开始
INSERT INTO ig."action"(
            actname, actlabel, actdesc, acturl, acttype, actl1id, actl2id, 
            actl3id, fingerprint, actroletype, actsortid, acturltype)
    VALUES ('ACT19ACC', '计费管理', null, '/IGCOM0202.do?linkID=IGVIR0900', 'M1', null, null, 
            null, null, 'IGCI01', '10', '0');

INSERT INTO ig."action"(
            actname, actlabel, actdesc, acturl, acttype, actl1id, actl2id, 
            actl3id, fingerprint, actroletype, actsortid, acturltype)
    VALUES ('ACT19ACC01', '计费策略', null, null, 'M2', null, null, 
            null, null, 'IGCI01', '1001', '0');


INSERT INTO ig."action"(
            actname, actlabel, actdesc, acturl, acttype, actl1id, actl2id, 
            actl3id, fingerprint, actroletype, actsortid, acturltype)
    VALUES ('ACT19ACC0101', '策略设定', null, '/IGCOM0202.do?linkID=IGVIR0901', 'M3', null, null, 
            null, null, 'IGCI01', '100101', '0');

 INSERT INTO ig."action"(
            actname, actlabel, actdesc, acturl, acttype, actl1id, actl2id, 
            actl3id, fingerprint, actroletype, actsortid, acturltype)
    VALUES ('ACT19ACC0102', '策略管理', null, '/IGCOM0202.do?linkID=IGVIR0902', 'M3', null, null, 
            null, null, 'IGCI01', '100102', '0');



/* Drop Tables */

DROP TABLE IF EXISTS VIM05;
DROP TABLE IF EXISTS VIM06;

/* Create Tables */

CREATE TABLE ig.VIM05
(
	ID INTEGER NOT NULL,
	NAME VARCHAR(32),
	CREATETIME VARCHAR(32),
	fingerprint character varying(256),
	PRIMARY KEY (ID)
) ;


CREATE TABLE ig.VIM06
(
	ID INTEGER NOT NULL,
	RESOURCEITEM VARCHAR(16) NOT NULL,
	PRICE INTEGER DEFAULT 0,
	VERSION VARCHAR(8),
	STRATEGYID INTEGER,
	fingerprint character varying(256),
	PRIMARY KEY (ID)
) ;

create table ig.vim07
(
	id integer not null,
	vmid integer,
	pid integer,
	userid varchar(16),
	ctype char(1),
	prid integer,
	ctime char(16),
	atime char(16),
	fingerprint varchar(256),
	primary key(id),
	foreign key (vmid) references ig.vim03(ID),
	foreign key (pid) references ig.vim02(ID),
	foreign key (userid) references ig.iguser(userid),
	foreign key (prid) references ig.ig500(prid)
);



INSERT INTO ig.sequence_generator_table(
            sequence_name, sequence_value)
    VALUES ('VIM05_SEQUENCE', 1000);

INSERT INTO ig.sequence_generator_table(
            sequence_name, sequence_value)
    VALUES ('VIM06_SEQUENCE', 1000);
    
INSERT INTO ig.codedetail(
            ccid, cid, cvalue, pccid, pcid, updtime, syscoding, psyscoding, 
            cdstatus, businesscode, fingerprint, cdinfo, cdorder)
    VALUES ('100', 'IGBP09', '虚拟化资源管理', null, null, '2013/02/21 13:00', null, null, 
            null, null, null, null, null);
            
INSERT INTO ig.codedetail(
            ccid, cid, cvalue, pccid, pcid, updtime, syscoding, psyscoding, 
            cdstatus, businesscode, fingerprint, cdinfo, cdorder)
    VALUES ('100', 'IGBP10', '虚拟化资源申请', null, null, '2013/02/21 13:00', null, null, 
            null, null, null, null, null);

INSERT INTO ig.codedetail(
            ccid, cid, cvalue, pccid, pcid, updtime, syscoding, psyscoding, 
            cdstatus, businesscode, fingerprint, cdinfo, cdorder)
    VALUES ('700', '001', 'CPU价格', null, null, '2013/02/21 13:00', null, null, 
            null, null, null, null, null);

INSERT INTO ig.codedetail(
            ccid, cid, cvalue, pccid, pcid, updtime, syscoding, psyscoding, 
            cdstatus, businesscode, fingerprint, cdinfo, cdorder)
    VALUES ('700', '002', '内存价格', null, null, '2013/02/21 13:00', null, null, 
            null, null, null, null, null);

INSERT INTO ig.codedetail(
            ccid, cid, cvalue, pccid, pcid, updtime, syscoding, psyscoding, 
            cdstatus, businesscode, fingerprint, cdinfo, cdorder)
    VALUES ('700', '003', '硬盘价格', null, null, '2013/02/21 13:00', null, null, 
            null, null, null, null, null);
            
--计费策略结束
INSERT INTO ig.codedetail(
            ccid, cid, cvalue, pccid, pcid, updtime, syscoding, psyscoding, 
            cdstatus, businesscode, fingerprint, cdinfo, cdorder)
    VALUES ('284', 'SVC0642', 'IGSVC0642', null, null, '2014/04/02 13:00', null, null, 
            null, null, null, '流程数量统计', null);
INSERT INTO ig.codedetail(
            ccid, cid, cvalue, pccid, pcid, updtime, syscoding, psyscoding, 
            cdstatus, businesscode, fingerprint, cdinfo, cdorder)
    VALUES ('284', 'VIR1401', 'IGVIR1401', null, null, '2014/04/02 13:00', null, null, 
            null, null, null, '资源申请统计', null);
INSERT INTO ig.codedetail(
            ccid, cid, cvalue, pccid, pcid, updtime, syscoding, psyscoding, 
            cdstatus, businesscode, fingerprint, cdinfo, cdorder)
    VALUES ('284', 'VIR1402', 'IGVIR1402', null, null, '2014/04/02 13:00', null, null, 
            null, null, null, '资源使用情况统计', null);

--计费统计开始
insert into "ig".ACTION (ACTNAME, ACTLABEL, ACTDESC, ACTURL, ACTTYPE, ACTL1ID, ACTL2ID, ACTL3ID, FINGERPRINT, ACTROLETYPE, ACTSORTID, ACTURLTYPE)
values('ACT21VIR10','计费统计',null,null,'M2',null,null,null,null,'IGCI01','1109','0');

insert into "ig".ACTION (ACTNAME, ACTLABEL, ACTDESC, ACTURL, ACTTYPE, ACTL1ID, ACTL2ID, ACTL3ID, FINGERPRINT, ACTROLETYPE, ACTSORTID, ACTURLTYPE)
values('ACT21VIR1001','人员计费',null,'/IGCOM0202.do?linkID=IGVIR1104','M3',null,null,null,null,'IGCI01','110901','0');

insert into "ig".ACTION (ACTNAME, ACTLABEL, ACTDESC, ACTURL, ACTTYPE, ACTL1ID, ACTL2ID, ACTL3ID, FINGERPRINT, ACTROLETYPE, ACTSORTID, ACTURLTYPE)
values('ACT21VIR1002','部门计费',null,'/IGCOM0202.do?linkID=IGVIR1105','M3',null,null,null,null,'IGCI01','110902','0');

insert into "ig".ACTION (ACTNAME, ACTLABEL, ACTDESC, ACTURL, ACTTYPE, ACTL1ID, ACTL2ID, ACTL3ID, FINGERPRINT, ACTROLETYPE, ACTSORTID, ACTURLTYPE)
values('ACT21VIR1003','项目计费',null,'/IGCOM0202.do?linkID=IGVIR1103','M3',null,null,null,null,'IGCI01','110902','0');

--计费统计结束
insert into "ig".IG622 (HPID, HPLABEL, HPURL, FINGERPRINT, HPTITLE)
values ('v5', '虚拟化管理首页', '/IGVIR1005.do', null, '首页');
insert into "ig".IG622 (HPID, HPLABEL, HPURL, FINGERPRINT, HPTITLE)
values ('v6', '虚拟化用户首页', '/IGVIR1006.do', null, '首页');
insert into "ig".IG622 (HPID, HPLABEL, HPURL, FINGERPRINT, HPTITLE)
values ('v7', '虚拟化资源管理首页', '/IGVIR1007.do', null, '首页');
