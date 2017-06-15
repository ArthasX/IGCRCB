CREATE TABLE "ig".cr02
(
  collecttime character varying(14) NOT NULL,
  tablename character varying(32),
  status character(1),
  fingerprint character varying(256)
) TABLESPACE "SOC_SPACE";
  
CREATE TABLE  "ig".cr03
(
  collecttime character varying(14) NOT NULL,
  tablename character varying(32) NOT NULL,
  fingerprint character varying(256),
  host character varying(32),
  status character(1),
  type INTEGER
)TABLESPACE "SOC_SPACE";