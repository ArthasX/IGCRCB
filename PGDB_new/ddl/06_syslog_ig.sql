create table "ig".MSS00001
(
  DEVICEID    integer not null,
  TYPEID      character varying(8),
  DEVICEIP    character varying(16),
  DEVICENAME  character varying(32),
  DEVICEDESC  character varying(128),
  DEVICESTATE integer default 1,
  CREATETIME  character varying(16),
  FINGERPRINT character varying(256),
  DEVICEIP2   character varying(16),
  CONSTRAINT MSS00001_pkey PRIMARY KEY (DEVICEID)
);

create table "ig".MSS00002
(
  MAXALARMNUM  integer default 0,
  MAXALARMTIME integer default 0,
  CREATETIME   character varying(16),
  FINGERPRINT  character varying(256),
  RELATIONID   integer not null,
  DEVICEID     integer,
  RULETEMPID   integer,
  CONSTRAINT MSS00002_pkey PRIMARY KEY (RULETEMPID)
);


create table "ig".MSS00003
(
  RULECONDITIONID integer not null,
  RULETEMPID      integer not null,
  ALARMMSG        character varying(256),
  ALARMCONDITION  integer default 0,
  CREATETIME      character varying(16),
  FINGERPRINT     character varying(256),
  CONSTRAINT MSS00003_pkey PRIMARY KEY (RULECONDITIONID)
);

create table "ig".MSS00004
(
  RULETEMPID    integer not null,
  RULETEMPNAME  character varying(128),
  TYPEID        character varying(8),
  RULECONDITION integer,
  TEMPSTATE     integer default 1,
  CREATETIME    character varying(16),
  FINGERPRINT   character varying(256),
  TEMPDESC      character varying(256),
  CONSTRAINT MSS00004_pkey PRIMARY KEY (RULETEMPID)
);

create table "ig".MSS00006
(
  ALARMID         integer not null,
  DEVICEID        integer,
  DEVICEIP        character varying(16),
  DEVICENAME      character varying(128),
  RULEID          integer,
  RULECONDITIONID integer,
  RULELEVEL       character varying(16),
  ALARMTIME       character varying(16),
  SYSLOGMSG       character varying(4000),
  SYSLOGTIME      character varying(16),
  ALARMSTATE      integer,
  FINGERPRINT     character varying(256),
  CONSTRAINT MSS00006_pkey PRIMARY KEY (ALARMID)
);

create table "ig".MSS00007
(
  ALARMID         integer not null,
  DEVICEID        integer,
  DEVICEIP        character varying(16),
  DEVICENAME      character varying(128),
  RULEID          integer,
  RULECONDITIONID integer,
  RULELEVEL       character varying(16),
  ALARMTIME       character varying(16),
  SYSLOGMSG       character varying(4000),
  SYSLOGTIME      character varying(16),
  ALARMSTATE      integer,
  REMOVETIME      character varying(16),
  FINGERPRINT     character varying(256),
  CONSTRAINT MSS00007_pkey PRIMARY KEY (ALARMID)
);

create table "ig".MSS00009
(
  ID          integer not null,
  DEVICEID    integer,
  DEVICEIP    character varying(16),
  DEVICENAME  character varying(128),
  RULELEVEL   character varying(16),
  ALARMMSG    character varying(4000),
  ISALARM     integer default 0,
  CREATETIME  character varying(16),
  REMOVETIME  character varying(16),
  DETAIL      character varying(512),
  TYPE        character varying(100),
  SUBJECT     character varying(100),
  STATUS      character varying(100),
  RESOURCEID  integer,
  INSTANCEID  integer,
  FINGERPRINT character varying(256),
  TIMESTAMP   integer,
  CONSTRAINT MSS00009_pkey PRIMARY KEY (ID)
);

insert into "ig".ACTION (ACTNAME, ACTLABEL, ACTDESC, ACTURL, ACTTYPE, ACTL1ID, ACTL2ID, ACTL3ID, FINGERPRINT, 

ACTROLETYPE, ACTSORTID, ACTURLTYPE)
values ('ACT13MTM0105', '设备日志信息', null, '/IGCOM0202.do?linkID=IGLOG0101', 'M3', null, null, null, null, 

'IGMN01', '080305', '0');
insert into "ig".ACTION (ACTNAME, ACTLABEL, ACTDESC, ACTURL, ACTTYPE, ACTL1ID, ACTL2ID, ACTL3ID, FINGERPRINT, 

ACTROLETYPE, ACTSORTID, ACTURLTYPE)
values ('ACT13MTM0107', '告警规则录入', null, '/IGCOM0202.do?linkID=IGLOG0022', 'M3', null, null, null, null, 

'IGMN01', '080307', '0');
insert into "ig".ACTION (ACTNAME, ACTLABEL, ACTDESC, ACTURL, ACTTYPE, ACTL1ID, ACTL2ID, ACTL3ID, FINGERPRINT, 

ACTROLETYPE, ACTSORTID, ACTURLTYPE)
values ('ACT13MTM0106', '告警规则管理', null, '/IGCOM0202.do?linkID=IGLOG0021', 'M3', null, null, null, null, 

'IGMN01', '080306', '0');
insert into "ig".ACTION (ACTNAME, ACTLABEL, ACTDESC, ACTURL, ACTTYPE, ACTL1ID, ACTL2ID, ACTL3ID, FINGERPRINT, 

ACTROLETYPE, ACTSORTID, ACTURLTYPE)
values ('ACT13MTM0103', '规则模板管理', null, '/IGCOM0202.do?linkID=IGLOG0041', 'M3', null, null, null, null, 

'IGMN01', '080303', '0');
insert into "ig".ACTION (ACTNAME, ACTLABEL, ACTDESC, ACTURL, ACTTYPE, ACTL1ID, ACTL2ID, ACTL3ID, FINGERPRINT, 

ACTROLETYPE, ACTSORTID, ACTURLTYPE)
values ('ACT13MTM0104', '规则模板录入', null, '/IGCOM0202.do?linkID=IGLOG0043', 'M3', null, null, null, null, 

'IGMN01', '080304', '0');


insert into "ig".SEQUENCE_GENERATOR_TABLE(SEQUENCE_NAME, SEQUENCE_VALUE) values('MSS00002_SEQUENCE',1);
insert into "ig".SEQUENCE_GENERATOR_TABLE(SEQUENCE_NAME, SEQUENCE_VALUE) values('MSS00003_SEQUENCE',1);
insert into "ig".SEQUENCE_GENERATOR_TABLE(SEQUENCE_NAME, SEQUENCE_VALUE) values('MSS00004_SEQUENCE',1);
insert into "ig".SEQUENCE_GENERATOR_TABLE(SEQUENCE_NAME, SEQUENCE_VALUE) values('MSS00005_SEQUENCE',1);
insert into "ig".SEQUENCE_GENERATOR_TABLE(SEQUENCE_NAME, SEQUENCE_VALUE) values('MSS00006_SEQUENCE',1);
insert into "ig".SEQUENCE_GENERATOR_TABLE(SEQUENCE_NAME, SEQUENCE_VALUE) values('MSS00007_SEQUENCE',1);
insert into "ig".SEQUENCE_GENERATOR_TABLE(SEQUENCE_NAME, SEQUENCE_VALUE) values('MSS00008_SEQUENCE',1);
insert into "ig".SEQUENCE_GENERATOR_TABLE(SEQUENCE_NAME, SEQUENCE_VALUE) values('MSS00009_SEQUENCE',1);

insert into "ig".CODEDETAIL (CCID, CID, CVALUE, PCCID, PCID, UPDTIME, SYSCODING, PSYSCODING, CDSTATUS, BUSINESSCODE, FINGERPRINT, CDINFO, CDORDER)
values ('301', '0001', 'linux服务器', null, null, '2010/01/01 00:00', null, null, null, null, null, null, null);
insert into "ig".CODEDETAIL (CCID, CID, CVALUE, PCCID, PCID, UPDTIME, SYSCODING, PSYSCODING, CDSTATUS, BUSINESSCODE, FINGERPRINT, CDINFO, CDORDER)
values ('301', '0002', '小型机', null, null, '2010/01/01 00:00', null, null, null, null, null, null, null);
insert into "ig".CODEDETAIL (CCID, CID, CVALUE, PCCID, PCID, UPDTIME, SYSCODING, PSYSCODING, CDSTATUS, BUSINESSCODE, FINGERPRINT, CDINFO, CDORDER)
values ('301', '0003', '交换机', null, null, '2010/01/01 00:00', null, null, null, null, null, null, null);
insert into "ig".CODEDETAIL (CCID, CID, CVALUE, PCCID, PCID, UPDTIME, SYSCODING, PSYSCODING, CDSTATUS, BUSINESSCODE, FINGERPRINT, CDINFO, CDORDER)
values ('301', '0004', '路由器', null, null, '2010/01/01 00:00', null, null, null, null, null, null, null);

commit;


