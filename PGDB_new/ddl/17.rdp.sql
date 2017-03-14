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
  businesssystemid integer, -- 业务系统ID
  hosts character varying(256), -- 要升级的主机，多个主机IP之间用#间隔
  excutetime character varying(32), -- 执行时间
  scriptpath character varying(256), -- 脚本部署路径
  "version" character varying(16),
  scriptparam character varying(32), -- 脚本执行参数
  fingerprint character varying(256),
  rdpfilepath character varying(256), -- 升级包部署路径
  resultlogpath character varying(256), -- 获取日志路径
  currentfilepath character varying(256), -- 当前升级文件和脚本的路径
  state integer DEFAULT 0,
  scriptname character varying(32),
  CONSTRAINT autotask_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE ig.autotask OWNER TO postgres;
COMMENT ON COLUMN ig.autotask.businesssystemid IS '业务系统ID';
COMMENT ON COLUMN ig.autotask.hosts IS '要升级的主机，多个主机IP之间用#间隔';
COMMENT ON COLUMN ig.autotask.excutetime IS '执行时间';
COMMENT ON COLUMN ig.autotask.scriptpath IS '脚本部署路径';
COMMENT ON COLUMN ig.autotask.scriptparam IS '脚本执行参数';
COMMENT ON COLUMN ig.autotask.rdpfilepath IS '升级包部署路径';
COMMENT ON COLUMN ig.autotask.resultlogpath IS '获取日志路径';
COMMENT ON COLUMN ig.autotask.currentfilepath IS '当前升级文件和脚本的路径';


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



