INSERT INTO ig.sequence_generator_table(
            sequence_name, sequence_value)
    VALUES ('AUTOTASK_SEQUENCE', 1000);


INSERT INTO ig.sequence_generator_table(
            sequence_name, sequence_value)
    VALUES ('EXCUTERESULT_SEQUENCE', 1000);


CREATE SEQUENCE realtimedetail_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 100
  CACHE 1;
ALTER TABLE realtimedetail_seq OWNER TO postgres;



-- Table: ig.autotask

-- DROP TABLE ig.autotask;

CREATE TABLE ig.autotask
(
  id integer NOT NULL,
  taskname character varying(32),
  businesssystemid integer, -- ҵ��ϵͳID
  hosts character varying(256), -- Ҫ�������������������IP֮����#���
  excutetime character varying(32), -- ִ��ʱ��
  scriptpath character varying(256), -- �ű�����·��
  "version" character varying(16),
  scriptparam character varying(32), -- �ű�ִ�в���
  fingerprint character varying(256),
  rdpfilepath character varying(256), -- ����������·��
  resultlogpath character varying(256), -- ��ȡ��־·��
  currentfilepath character varying(256), -- ��ǰ�����ļ��ͽű���·��
  state integer DEFAULT 0,
  scriptname character varying(32),
  CONSTRAINT autotask_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE ig.autotask OWNER TO postgres;
COMMENT ON COLUMN ig.autotask.businesssystemid IS 'ҵ��ϵͳID';
COMMENT ON COLUMN ig.autotask.hosts IS 'Ҫ�������������������IP֮����#���';
COMMENT ON COLUMN ig.autotask.excutetime IS 'ִ��ʱ��';
COMMENT ON COLUMN ig.autotask.scriptpath IS '�ű�����·��';
COMMENT ON COLUMN ig.autotask.scriptparam IS '�ű�ִ�в���';
COMMENT ON COLUMN ig.autotask.rdpfilepath IS '����������·��';
COMMENT ON COLUMN ig.autotask.resultlogpath IS '��ȡ��־·��';
COMMENT ON COLUMN ig.autotask.currentfilepath IS '��ǰ�����ļ��ͽű���·��';


-- Table: ig.excuteresult

-- DROP TABLE ig.excuteresult;

CREATE TABLE ig.excuteresult
(
  taskid integer NOT NULL,
  result character varying(1024),
  resultdetail character varying(64),
  fingerprint character varying(256),
  state integer DEFAULT 0,
  hostid character varying(32) NOT NULL,
  realtimedetail character varying(256),
  CONSTRAINT excuteresult_pkey PRIMARY KEY (taskid, hostid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE ig.excuteresult OWNER TO postgres;




-- Table: realtimedetail

-- DROP TABLE realtimedetail;

CREATE TABLE realtimedetail
(
  id integer NOT NULL DEFAULT nextval('realtimedetail_seq'::regclass),
  taskid integer,
  hostip character varying(20),
  "content" character varying(1024),
  fingerprint character varying(256),
  CONSTRAINT realtimedetail_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE realtimedetail OWNER TO postgres;



