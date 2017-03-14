alter table ig.SOC0109 add CORDER integer;

DROP TABLE ig."comparetemplate";
commit;
CREATE TABLE ig.comparetemplate
(
  ctpid integer NOT NULL,
  ctcategory character varying(32), -- 类别ID
  cttype character varying(32), -- 类型
  cteiid character varying(32), -- 横向宽度
  ctx character varying(32),	--设备x位置坐标
  cty character varying(32),	--设备y位置坐标
  ctfloorx character varying(32),	--设备所属地板x
  ctfloory character varying(32), 	--设备所属地板y
  ctindex character varying(32),	--设备所属层 
  ctName character varying(128), 	--名称
  ctInfo character varying(256), 	--说明
  ctZoneId character varying(32), 	--所属分区编号
  fingerprint character varying(256), -- 时间戳
  CONSTRAINT comparetemplate_pkey PRIMARY KEY (ctpid)
)

create  table ig.IndicatorLightsXml(
ixid integer not null,
ixtitle character varying(128),
ixplacex character varying(64),
ixplacey character varying(64),
ixwidth integer,
ixheight integer,
rotation character varying(256),
fingerprint character varying(256), -- 时间戳
CONSTRAINT IndicatorLightsXml_pkey PRIMARY KEY (ixid)
);

create table ig.INDICATORLIGHTSSYSTEM(
ILSID integer not null,
ILSNAME character varying(128),
ILSPLACEX character varying,
ILSPLACEY character varying,
ILSSTATUS character varying(1),
FINGERPRINT character varying(256),
CONSTRAINT INDICATORLIGHTSSYSTEM_pkey PRIMARY KEY (ILSID)
);




insert into ig.action(actname,actlabel,acturl,acttype,actroletype,actsortid,acturltype) values('ACT04CIM13','机房管理','','M2','IGCI01','0413','0');
insert into ig.action(actname,actlabel,acturl,acttype,actroletype,actsortid,acturltype) values('ACT04CIM1301','机房列表','/IGCOM0202.do?linkID=IGASM1101','M3','IGCI01','041301','0');
insert into ig.action(actname,actlabel,acturl,acttype,actroletype,actsortid,acturltype) values('ACT04CIM1302','机房登记','/IGCOM0202.do?linkID=IGASM1102','M3','IGCI01','041302','0');
insert into ig.action(actname,actlabel,acturl,acttype,actroletype,actsortid,acturltype) values('ACT04CIM1303','机柜列表','/IGCOM0202.do?linkID=IGASM1111','M3','IGCI01','041303','0');
insert into ig.action(actname,actlabel,acturl,acttype,actroletype,actsortid,acturltype) values('ACT04CIM1304','机柜登记','/IGCOM0202.do?linkID=IGASM1112','M3','IGCI01','041304','0');
insert into ig.action(actname,actlabel,acturl,acttype,actroletype,actsortid,acturltype) values('ACT04CIM1305','设备查询','/IGCOM0202.do?linkID=IGASM1120','M3','IGCI01','041305','0');

insert into ig.SOC0117(eid,ename,elabel,edesc,estatus,ecategory,esyscoding,eparcoding) values('CM10000000','机房','007','包括小型机机房、网络机房等','1','007','999007','999');
insert into ig.SOC0117(eid,ename,elabel,edesc,estatus,ecategory,esyscoding,eparcoding) values('CM11000000','机柜','008','','1','008','999008','999');

insert into ig.SOC0117 values('CM01010061','存储交换机','IGRES','','1','001','0','0','','999001028007','999001028','','1');
insert into ig.SOC0117 values('CM01010062','存储交换机模块','','','2','001','0','0','','999001030','999001','','1');
insert into ig.SOC0117 values('CM01010063','存储','','','1','001','0','0','','999001031','999001','','1');
insert into ig.SOC0117 values('CM01010064','EMC_DX','','','1','001','0','0','','999001031001','999001031','','1');
insert into ig.SOC0117 values('CM01010065','IBM_DS8000','','','1','001','0','0','','999001031002','999001031','','1');
insert into ig.SOC0117 values('CM01010066','前端控制卡','','','2','001','0','0','','999001032','999001','','1');
insert into ig.SOC0117 values('CM01010067','磁盘控制卡','','','2','001','0','0','','999001033','999001','','1');
insert into ig.SOC0117 values('CM01010068','硬盘','','','2','001','0','0','','999001033','999001','','1');
insert into ig.SOC0117 values('CM01010069','服务器','','','2','001','0','0','','999001034','999001','','1');
insert into ig.SOC0117 values('CM01010070','IBM服务器','','','2','001','0','0','','999001034001','999001','','1');
insert into ig.SOC0117 values('CM01010071','HP服务器','','','2','001','0','0','','999001034002','999001','','1');
insert into ig.SOC0117 values('CM01010072','机房设备','','','1','001','0','0','','999001035','999001','','1');
insert into ig.SOC0117 values('CM01010073','UPS','','','1','001','0','0','','999001035001','999001035','','1');
insert into ig.SOC0117 values('CM01010074','空调','','','1','001','0','0','','999001035002','999001035','','1');

insert into ig.SOC0109 values ('CI100000000001','CM10000000','横向宽(地板)','IG_0017','','','1',0,'001','','0','999007','','1');
insert into ig.SOC0109 values ('CI100000000002','CM10000000','纵向宽(地板)','IG_0018','','','1',0,'001','','0','999007','','1');
insert into ig.SOC0109 values ('CI100000000003','CM10000000','负责人','IG_0019','','','1',0,'001','','0','999007','','');
insert into ig.SOC0109 values ('CI100000000004','CM10000000','联系电话','IG_0020','','','1',0,'001','','0','999007','','');
insert into ig.SOC0109 values ('CI100000000005','CM10000000','关联机房','IG_0101','','','1',2,'001','','7','999007','','0');
insert into ig.SOC0109 values ('CI100000000006','CM10000000','关联地板X','IG_0102','','','1',2,'001','','0','999007','','0');
insert into ig.SOC0109 values ('CI100000000007','CM10000000','关联地板Y','IG_0103','','','1',2,'001','','0','999007','','0');

insert into ig.SOC0109 values ('CI110000000001','CM11000000','位置X','IG_0021','位置X','','1',1,'001','','0','999008','','');
insert into ig.SOC0109 values ('CI110000000002','CM11000000','位置Y','IG_0022','位置Y','','1',1,'001','','0','999008','','');
insert into ig.SOC0109 values ('CI110000000003','CM11000000','高度U','IG_0023','高度U','','1',0,'001','','0','999008','','');
insert into ig.SOC0109 values ('CI110000000004','CM11000000','横向宽(地板)','IG_0024','','','1',0,'001','','0','999008','','');
insert into ig.SOC0109 values ('CI110000000005','CM11000000','纵向宽(地板)','IG_0025','','','1',0,'001','','0','999008','','');
insert into ig.SOC0109 values ('CI110000000006','CM11000000','显示层','IG_0030','机房显示图用','','1',1,'001','','0','999008','','');
insert into ig.SOC0109 values ('CI110000000007','CM11000000','是否已设置','IG_0031','机房显示图用','','1',1,'001','','0','999008','','');
insert into ig.SOC0109 values ('CI110000000008','CM11000000','类型标识','IG_0032','机房显示图用','','1',1,'001','','0','999008','','');
insert into ig.SOC0109 values ('CI110000000009','CM11000000','类型名称','IG_0033','机房显示图用','','1',1,'001','','0','999008','','');
insert into ig.SOC0109 values ('CI110000000010','CM11000000','额定电压','IG_0034','','','1',1,'001','','0','999008','','');
insert into ig.SOC0109 values ('CI110000000011','CM11000000','机柜重量','IG_0035','','','1',1,'001','','0','999008','','');
insert into ig.SOC0109 values ('CI110000000012','CM11000000','机柜规格','IG_0036','','','1',1,'001','','0','999008','','');
insert into ig.SOC0109 values ('CI110000000013','CM11000000','类型标识','IG_0032','机房显示图用','','1',1,'001','','0','999008','','');
insert into ig.SOC0109 values ('CI110000000014','CM11000000','类型名称','IG_0033','机房显示图用','','1',1,'001','','0','999008','','');
insert into ig.SOC0109 values ('CI110000000015','CM11000000','额定电压','IG_0034','','','1',1,'001','','0','999008','','');
insert into ig.SOC0109 values ('CI110000000016','CM11000000','机柜重量','IG_0035','','','1',1,'001','','0','999008','','');
insert into ig.SOC0109 values ('CI110000000017','CM11000000','机柜层','IG_0030','','','1',1,'001','','0','999008','','');
insert into ig.SOC0109 values ('CI110000000018','CM11000000','宽度','IG_0104','宽度','','1',0,'001','','0','999008','','');
insert into ig.SOC0109 values ('CI110000000019','CM11000000','容器类型','IG_0105','容器类型','','1',0,'001','','0','999008','','');
insert into ig.SOC0109 values ('CI110000000020','CM11000000','机柜中位置','IG_0106','','','1',0,'001','','0','999008','','');
insert into ig.SOC0109 values ('CI110000000021','CM11000000','最大负载','IG_0201','','','1',0,'001','','0','999008','','');
insert into ig.SOC0109 values ('CI110000000022','CM11000000','最大电力','IG_0202','','','1',0,'001','','0','999008','','');

insert into ig.SOC0109 values ('CI010000000012','CM01000000','功率(W)','IG_0038','','','1',0,'001','','7','999001','','');
insert into ig.SOC0109 values ('CI010000000013','CM01000000','重量(Kg)','IG_0039','','','1',0,'001','','7','999001','','');
insert into ig.SOC0109 values ('CI010000000006','CM01000000','位置','IG_0015','机柜中位置，不需要添加','','1',0,'005','','0','999001','','');
insert into ig.SOC0109 values ('CI010000000007','CM01000000','高度(U)','IG_0016','设备所占U数','','1',0,'005','009','2','999001','','');
insert into ig.SOC0109 values ('CI010000000011','CM01000000','是否是机房设备','IG_0037','是否是机房设备','','1',0,'005','011','2','999001','','');
insert into ig.SOC0109 values ('CI010100610001','CM01010061','型号','IG_0026','','','1',0,'007','','0','999001028007','','');
insert into ig.SOC0109 values ('CI010100010070','CM01010001','型号','IG_0026','','','1',0,'007','','0','999001001','','');
insert into ig.SOC0109 values ('CI010100020010','CM01010002','型号','IG_0026','','','1',0,'007','','0','999001002','','');
insert into ig.SOC0109 values ('CI010100020011','CM01010002','空调分类','IG_0108','','','1',2,'001','051','2','999001002','','');


--修改设备的运维属性中的 "是否是机房设备"和"高度(U)" 的下拉列表值
update ig.soc0109 set coption ='012' where cid ='CI010000000007' ;

--插入下拉列表内容
insert into ig.soc0151 (ccdid,ccdcategory,ccdlabel,ccdvalue,ccdstatus,ccdtype)
values (138,'011','是否是机房设备','是','1','A');
insert into ig.soc0151 (ccdid,ccdcategory,ccdlabel,ccdvalue,ccdstatus,ccdtype)
values (139,'011','是否是机房设备','否','1','A');

insert into ig.soc0151 (ccdid,ccdcategory,ccdlabel,ccdvalue,ccdstatus,ccdtype)
values (140,'012','高度(U)','1','1','A');
insert into ig.soc0151 (ccdid,ccdcategory,ccdlabel,ccdvalue,ccdstatus,ccdtype)
values (141,'012','高度(U)','2','1','A');
insert into ig.soc0151 (ccdid,ccdcategory,ccdlabel,ccdvalue,ccdstatus,ccdtype)
values (142,'012','高度(U)','3','1','A');
insert into ig.soc0151 (ccdid,ccdcategory,ccdlabel,ccdvalue,ccdstatus,ccdtype)
values (143,'012','高度(U)','4','1','A');


UPDATE IG.CODEDETAIL SET CVALUE = 'IBM主机', psyscoding='999001001001' where CCID='274' AND CID ='0001';
UPDATE IG.CODEDETAIL SET CVALUE = 'Linux主机', psyscoding='999001001005' where CCID='274' AND CID ='0002';
UPDATE IG.CODEDETAIL SET CVALUE = 'Windows主机', psyscoding='999001001006' where CCID='274' AND CID ='0003';
UPDATE IG.CODEDETAIL SET CVALUE = 'SOCUnix主机', psyscoding='999001001007' where CCID='274' AND CID ='0004';
DELETE FROM IG.CODEDETAIL WHERE CCID='274' AND CID ='0005';
