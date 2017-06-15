
/* Create Tables */

-- 应急资源模型表
CREATE TABLE EMERGENCYRESOURCE
(
	-- 主键
	ERID INTEGER NOT NULL,
	-- 资产编码
	ESYSCODING VARCHAR(32) NOT NULL,
	--显示属性
	ERCIDS VARCHAR(3000) ,
	-- 应急资源模型名
	ERNAME VARCHAR(128),
	-- 应急资源描述
	ERDESC VARCHAR(3000),
	-- 应急资源模型状态
	ERSTATUS CHAR(1),
	-- 应急资源模型编号（预留）
	ERLABEL VARCHAR(32),
	-- 应急资源模型编码
	ERCODE VARCHAR(32),
	-- 应急资源上级编码
	ERPARCODE VARCHAR(32),
	-- 应急资源模型创建时间
	ERCREATETIME VARCHAR(19),
	-- 应急资源管理人id
	ERUSERID VARCHAR(16),
	-- 应急资源管理人名称
	ERUSERNAME VARCHAR(16),
	-- fingerprint
	FINGERPRINT VARCHAR(256),
	PRIMARY KEY (ERID)
);


-- 应急资源与资产关系表
CREATE TABLE ERRELATION
(
	-- 主键
	ERRID INTEGER NOT NULL,
	-- 应急资源模型id
	ERID INTEGER NOT NULL,
	-- 应急资源与资产关系码
	ERCODE VARCHAR(32) NOT NULL,
	-- 资产id（数据库id_eiid）
	EIID VARCHAR(32),
	-- 逻辑删除标识
	DELETEFLAG CHAR(1),
	-- fingerprint
	FINGERPRINT VARCHAR(256),
	PRIMARY KEY (ERRID),
    FOREIGN KEY (erid) REFERENCES emergencyresource (erid) ON DELETE CASCADE
);

--应急资源顶级模型
INSERT INTO EMERGENCYRESOURCE
(ERID, ESYSCODING, ERNAME, ERDESC, ERSTATUS, ERLABEL, ERCODE, ERPARCODE, ERCREATETIME, ERUSERID, ERUSERNAME, FINGERPRINT)
VALUES(0, '', '应急资源', '应急资源', '1', '', '000', '', '', '', '', '');

--远程连接数据库取资产相关表操作如下

主server: 192.168.1.20:50000/IG          用户：db2inst1/db2inst1
远程server: 192.168.1.116:50000/CSIG3      用户： igadmin/igadmin

1.用db2inst1登陆IG
connect to ig user db2inst1 using db2inst1
2. 编目远程数据库。
    catalog tcpip node train remote 192.168.1.116 server 50000
catalog db csig3 as csig at node train
db2 catalog database db_name as alias_name at node db2node

3. 设置数据库参数FEDERATE为YES
     UPDATE DBM CFG USING FEDERATED YES
4. 重启实例
    db2stop force， db2start
5. 连接csig 数据库
 connect to csig  user igadmin using igadmin
//测试完切换回ig
connect to ig user db2inst1 using db2inst1
6. 创建包装器
   CREATE WRAPPER DRDA
7. 创建server
    CREATE SERVER csig TYPE DB2/UDB VERSION '10.1.3' WRAPPER "DRDA" AUTHID "igadmin" PASSWORD "igadmin" OPTIONS( ADD NODE 'train',ADD DBNAME 'csig')

8. 创建用户映射
   CREATE USER MAPPING FOR db2inst1 SERVER csig OPTIONS ( ADD REMOTE_AUTHID 'igadmin', ADD REMOTE_PASSWORD 'igadmin')

9. 映射远程表到本地数据库(为远程表创建一个昵称)
    CREATE NICKNAME DB2INST1.temp0118 for csig.igadmin.soc0118
    CREATE NICKNAME DB2INST1.temp0107 for csig.igadmin.soc0107
    CREATE NICKNAME DB2INST1.temp0117 for csig.igadmin.soc0117
    CREATE NICKNAME DB2INST1.temp0109 for csig.igadmin.soc0109
    CREATE NICKNAME DB2INST1.temp0151 for csig.igadmin.soc0151
	CREATE NICKNAME DB2INST1.temp0167 for csig.igadmin.soc0167


 CREATE VIEW soc0118VW AS
 (
 select 
      0 as id,
    EIID            , 
    EID            , 
    EIDESC         , 
    EINAME         , 
    EILABEL        , 
    EIINSDATE      , 
    EIORGSYSCODING , 
    ESYSCODING     , 
    EIUPDTIME      , 
    EISTATUS       , 
    EIVERSION      , 
    FINGERPRINT    , 
    EIUSERID       , 
    EIUSERNAME     , 
    EISMALLVERSION , 
    EIROOTMARK   
 from soc0118
 UNION all 
 select 
      1 as id,
    EIID            , 
EID            , 
    EIDESC         , 
    EINAME         , 
    EILABEL        , 
    EIINSDATE      , 
    EIORGSYSCODING , 
    ESYSCODING     , 
    EIUPDTIME      , 
    EISTATUS       , 
    EIVERSION      , 
    FINGERPRINT    , 
    EIUSERID       , 
    EIUSERNAME     , 
    EISMALLVERSION , 
    EIROOTMARK   
 from temp0118
);

 CREATE VIEW soc0109VW AS
 (
 select 
      0 as id,
    CID        ,
    EID        ,
    CNAME      ,
    CLABEL     ,
    CDESC      ,
    CUNIT      ,
    CSTATUS    ,
    CSEQ       ,
    CCATEGORY  ,
    COPTION    ,
    CATTACH    ,
    ESYSCODING ,
    FINGERPRINT,
    CREQUIRED  ,
    CORDER      
from soc0109
union all 
 select 
      1 as id,
    CID        ,
    EID        ,
    CNAME      ,
    CLABEL     ,
    CDESC      ,
    CUNIT      ,
    CSTATUS    ,
    CSEQ       ,
    CCATEGORY  ,
    COPTION    ,
    CATTACH    ,
    ESYSCODING ,
    FINGERPRINT,
    CREQUIRED  ,
    CORDER      
from temp0109
);
 CREATE VIEW soc0107VW AS
 (
 select 
      0 as id,
     CIID          ,
    CID           ,
    EIID          ,
    EID           ,
    CIVALUE       ,
    CIUPDTIME     ,
    ESYSCODING    ,
    CIEXPIRE      ,
    CISTATUS      ,
    CICURVER      ,
    CIVERSION     ,
    CIVERINFO     ,
    FINGERPRINT   ,
    CISMALLVERSION 
from soc0107
union all
 select 
      1 as id,
    CIID          ,
    CID           ,
    EIID          ,
    EID           ,
    CIVALUE       ,
    CIUPDTIME     ,
    ESYSCODING    ,
    CIEXPIRE      ,
    CISTATUS      ,
    CICURVER      ,
    CIVERSION     ,
    CIVERINFO     ,
    FINGERPRINT   ,
    CISMALLVERSION 
from temp0107
);

 CREATE VIEW soc0117VW AS
 (
 select 
      0 as id,
    EID        ,
    ENAME      ,
    ELABEL     ,
    EDESC      ,
    ESTATUS    ,
    ECATEGORY  ,
    EKEY1      ,
    EKEY2      ,
    EKEY3      ,
    ESYSCODING ,
    EPARCODING ,
    FINGERPRINT,
    EMODELTYPE  

from soc0117
union all
 select 
      1 as id,
    EID        ,
    ENAME      ,
    ELABEL     ,
    EDESC      ,
    ESTATUS    ,
    ECATEGORY  ,
    EKEY1      ,
    EKEY2      ,
    EKEY3      ,
    ESYSCODING ,
    EPARCODING ,
    FINGERPRINT,
    EMODELTYPE  

from temp0117
);

CREATE VIEW soc0151VW AS
 (
 select 
      '0' as id,
    ccdid,
    ccdcategory,
    ccdlabel,
    ccdvalue,
    ccdstatus,
    ccdtype,
    ccdinfo,
    fingerprint
from soc0151
    union all 
select 
    '1' as id,
    ccdid,
    ccdcategory,
    ccdlabel,
    ccdvalue,
    ccdstatus,
    ccdtype,
    ccdinfo,
    fingerprint
from temp0151
);



