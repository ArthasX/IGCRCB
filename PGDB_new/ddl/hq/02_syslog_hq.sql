create table MSS00005
(
  ALARMID         integer not null,
  DEVCEID         integer,
  DEVICEIP        character varying(16),
  DEVICENAME      character varying(128),
  RULEID          integer,
  RULECONDITIONID integer,
  RULELEVEL       character varying(16),
  ALARMTIME       character varying(16),
  SYSLOGMSG       character varying(256),
  SYSLOGTIME      character varying(16),
  ALARMSTATE      integer default 0,
  FINGERPRINT     character varying(256),
  CONSTRAINT MSS00005_pkey PRIMARY KEY (ALARMID)
);

create table MSS00008
(
  ID          integer not null,
  DEVICEID    integer,
  DEVICEIP    character varying(16),
  DEVICENAME  character varying(128),
  RULELEVEL   character varying(16),
  ALARMMSG    character varying(256),
  ISALARM     integer default 0,
  CREATETIME  character varying(16),
  DETAIL      character varying(512),
  TYPE        character varying(100),
  SUBJECT     character varying(100),
  STATUS      character varying(100),
  RESOURCEID  integer,
  INSTANCEID  integer,
  FINGERPRINT character varying(256),
  CONSTRAINT MSS00008_pkey PRIMARY KEY (ID)
);
  
CREATE SEQUENCE SEQ_MSS00005_ALARMID
  INCREMENT 1
  MINVALUE 1
  no maxvalue
  START 1
  CACHE 20;
  
CREATE SEQUENCE SEQ_MSS00008_ID
  INCREMENT 1
  MINVALUE 1
  no maxvalue
  START 1
  CACHE 20;
