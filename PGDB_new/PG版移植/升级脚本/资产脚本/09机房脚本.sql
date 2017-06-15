alter table ig.SOC0109 add CORDER integer;

DROP TABLE ig."comparetemplate";
commit;
CREATE TABLE ig.comparetemplate
(
  ctpid integer NOT NULL,
  ctcategory character varying(32), -- ���ID
  cttype character varying(32), -- ����
  cteiid character varying(32), -- ������
  ctx character varying(32),	--�豸xλ������
  cty character varying(32),	--�豸yλ������
  ctfloorx character varying(32),	--�豸�����ذ�x
  ctfloory character varying(32), 	--�豸�����ذ�y
  ctindex character varying(32),	--�豸������ 
  ctName character varying(128), 	--����
  ctInfo character varying(256), 	--˵��
  ctZoneId character varying(32), 	--�����������
  fingerprint character varying(256), -- ʱ���
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
fingerprint character varying(256), -- ʱ���
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




insert into ig.action(actname,actlabel,acturl,acttype,actroletype,actsortid,acturltype) values('ACT04CIM13','��������','','M2','IGCI01','0413','0');
insert into ig.action(actname,actlabel,acturl,acttype,actroletype,actsortid,acturltype) values('ACT04CIM1301','�����б�','/IGCOM0202.do?linkID=IGASM1101','M3','IGCI01','041301','0');
insert into ig.action(actname,actlabel,acturl,acttype,actroletype,actsortid,acturltype) values('ACT04CIM1302','�����Ǽ�','/IGCOM0202.do?linkID=IGASM1102','M3','IGCI01','041302','0');
insert into ig.action(actname,actlabel,acturl,acttype,actroletype,actsortid,acturltype) values('ACT04CIM1303','�����б�','/IGCOM0202.do?linkID=IGASM1111','M3','IGCI01','041303','0');
insert into ig.action(actname,actlabel,acturl,acttype,actroletype,actsortid,acturltype) values('ACT04CIM1304','����Ǽ�','/IGCOM0202.do?linkID=IGASM1112','M3','IGCI01','041304','0');
insert into ig.action(actname,actlabel,acturl,acttype,actroletype,actsortid,acturltype) values('ACT04CIM1305','�豸��ѯ','/IGCOM0202.do?linkID=IGASM1120','M3','IGCI01','041305','0');

insert into ig.SOC0117(eid,ename,elabel,edesc,estatus,ecategory,esyscoding,eparcoding) values('CM10000000','����','007','����С�ͻ����������������','1','007','999007','999');
insert into ig.SOC0117(eid,ename,elabel,edesc,estatus,ecategory,esyscoding,eparcoding) values('CM11000000','����','008','','1','008','999008','999');

insert into ig.SOC0117 values('CM01010061','�洢������','IGRES','','1','001','0','0','','999001028007','999001028','','1');
insert into ig.SOC0117 values('CM01010062','�洢������ģ��','','','2','001','0','0','','999001030','999001','','1');
insert into ig.SOC0117 values('CM01010063','�洢','','','1','001','0','0','','999001031','999001','','1');
insert into ig.SOC0117 values('CM01010064','EMC_DX','','','1','001','0','0','','999001031001','999001031','','1');
insert into ig.SOC0117 values('CM01010065','IBM_DS8000','','','1','001','0','0','','999001031002','999001031','','1');
insert into ig.SOC0117 values('CM01010066','ǰ�˿��ƿ�','','','2','001','0','0','','999001032','999001','','1');
insert into ig.SOC0117 values('CM01010067','���̿��ƿ�','','','2','001','0','0','','999001033','999001','','1');
insert into ig.SOC0117 values('CM01010068','Ӳ��','','','2','001','0','0','','999001033','999001','','1');
insert into ig.SOC0117 values('CM01010069','������','','','2','001','0','0','','999001034','999001','','1');
insert into ig.SOC0117 values('CM01010070','IBM������','','','2','001','0','0','','999001034001','999001','','1');
insert into ig.SOC0117 values('CM01010071','HP������','','','2','001','0','0','','999001034002','999001','','1');
insert into ig.SOC0117 values('CM01010072','�����豸','','','1','001','0','0','','999001035','999001','','1');
insert into ig.SOC0117 values('CM01010073','UPS','','','1','001','0','0','','999001035001','999001035','','1');
insert into ig.SOC0117 values('CM01010074','�յ�','','','1','001','0','0','','999001035002','999001035','','1');

insert into ig.SOC0109 values ('CI100000000001','CM10000000','�����(�ذ�)','IG_0017','','','1',0,'001','','0','999007','','1');
insert into ig.SOC0109 values ('CI100000000002','CM10000000','�����(�ذ�)','IG_0018','','','1',0,'001','','0','999007','','1');
insert into ig.SOC0109 values ('CI100000000003','CM10000000','������','IG_0019','','','1',0,'001','','0','999007','','');
insert into ig.SOC0109 values ('CI100000000004','CM10000000','��ϵ�绰','IG_0020','','','1',0,'001','','0','999007','','');
insert into ig.SOC0109 values ('CI100000000005','CM10000000','��������','IG_0101','','','1',2,'001','','7','999007','','0');
insert into ig.SOC0109 values ('CI100000000006','CM10000000','�����ذ�X','IG_0102','','','1',2,'001','','0','999007','','0');
insert into ig.SOC0109 values ('CI100000000007','CM10000000','�����ذ�Y','IG_0103','','','1',2,'001','','0','999007','','0');

insert into ig.SOC0109 values ('CI110000000001','CM11000000','λ��X','IG_0021','λ��X','','1',1,'001','','0','999008','','');
insert into ig.SOC0109 values ('CI110000000002','CM11000000','λ��Y','IG_0022','λ��Y','','1',1,'001','','0','999008','','');
insert into ig.SOC0109 values ('CI110000000003','CM11000000','�߶�U','IG_0023','�߶�U','','1',0,'001','','0','999008','','');
insert into ig.SOC0109 values ('CI110000000004','CM11000000','�����(�ذ�)','IG_0024','','','1',0,'001','','0','999008','','');
insert into ig.SOC0109 values ('CI110000000005','CM11000000','�����(�ذ�)','IG_0025','','','1',0,'001','','0','999008','','');
insert into ig.SOC0109 values ('CI110000000006','CM11000000','��ʾ��','IG_0030','������ʾͼ��','','1',1,'001','','0','999008','','');
insert into ig.SOC0109 values ('CI110000000007','CM11000000','�Ƿ�������','IG_0031','������ʾͼ��','','1',1,'001','','0','999008','','');
insert into ig.SOC0109 values ('CI110000000008','CM11000000','���ͱ�ʶ','IG_0032','������ʾͼ��','','1',1,'001','','0','999008','','');
insert into ig.SOC0109 values ('CI110000000009','CM11000000','��������','IG_0033','������ʾͼ��','','1',1,'001','','0','999008','','');
insert into ig.SOC0109 values ('CI110000000010','CM11000000','���ѹ','IG_0034','','','1',1,'001','','0','999008','','');
insert into ig.SOC0109 values ('CI110000000011','CM11000000','��������','IG_0035','','','1',1,'001','','0','999008','','');
insert into ig.SOC0109 values ('CI110000000012','CM11000000','������','IG_0036','','','1',1,'001','','0','999008','','');
insert into ig.SOC0109 values ('CI110000000013','CM11000000','���ͱ�ʶ','IG_0032','������ʾͼ��','','1',1,'001','','0','999008','','');
insert into ig.SOC0109 values ('CI110000000014','CM11000000','��������','IG_0033','������ʾͼ��','','1',1,'001','','0','999008','','');
insert into ig.SOC0109 values ('CI110000000015','CM11000000','���ѹ','IG_0034','','','1',1,'001','','0','999008','','');
insert into ig.SOC0109 values ('CI110000000016','CM11000000','��������','IG_0035','','','1',1,'001','','0','999008','','');
insert into ig.SOC0109 values ('CI110000000017','CM11000000','�����','IG_0030','','','1',1,'001','','0','999008','','');
insert into ig.SOC0109 values ('CI110000000018','CM11000000','���','IG_0104','���','','1',0,'001','','0','999008','','');
insert into ig.SOC0109 values ('CI110000000019','CM11000000','��������','IG_0105','��������','','1',0,'001','','0','999008','','');
insert into ig.SOC0109 values ('CI110000000020','CM11000000','������λ��','IG_0106','','','1',0,'001','','0','999008','','');
insert into ig.SOC0109 values ('CI110000000021','CM11000000','�����','IG_0201','','','1',0,'001','','0','999008','','');
insert into ig.SOC0109 values ('CI110000000022','CM11000000','������','IG_0202','','','1',0,'001','','0','999008','','');

insert into ig.SOC0109 values ('CI010000000012','CM01000000','����(W)','IG_0038','','','1',0,'001','','7','999001','','');
insert into ig.SOC0109 values ('CI010000000013','CM01000000','����(Kg)','IG_0039','','','1',0,'001','','7','999001','','');
insert into ig.SOC0109 values ('CI010000000006','CM01000000','λ��','IG_0015','������λ�ã�����Ҫ���','','1',0,'005','','0','999001','','');
insert into ig.SOC0109 values ('CI010000000007','CM01000000','�߶�(U)','IG_0016','�豸��ռU��','','1',0,'005','009','2','999001','','');
insert into ig.SOC0109 values ('CI010000000011','CM01000000','�Ƿ��ǻ����豸','IG_0037','�Ƿ��ǻ����豸','','1',0,'005','011','2','999001','','');
insert into ig.SOC0109 values ('CI010100610001','CM01010061','�ͺ�','IG_0026','','','1',0,'007','','0','999001028007','','');
insert into ig.SOC0109 values ('CI010100010070','CM01010001','�ͺ�','IG_0026','','','1',0,'007','','0','999001001','','');
insert into ig.SOC0109 values ('CI010100020010','CM01010002','�ͺ�','IG_0026','','','1',0,'007','','0','999001002','','');
insert into ig.SOC0109 values ('CI010100020011','CM01010002','�յ�����','IG_0108','','','1',2,'001','051','2','999001002','','');


--�޸��豸����ά�����е� "�Ƿ��ǻ����豸"��"�߶�(U)" �������б�ֵ
update ig.soc0109 set coption ='012' where cid ='CI010000000007' ;

--���������б�����
insert into ig.soc0151 (ccdid,ccdcategory,ccdlabel,ccdvalue,ccdstatus,ccdtype)
values (138,'011','�Ƿ��ǻ����豸','��','1','A');
insert into ig.soc0151 (ccdid,ccdcategory,ccdlabel,ccdvalue,ccdstatus,ccdtype)
values (139,'011','�Ƿ��ǻ����豸','��','1','A');

insert into ig.soc0151 (ccdid,ccdcategory,ccdlabel,ccdvalue,ccdstatus,ccdtype)
values (140,'012','�߶�(U)','1','1','A');
insert into ig.soc0151 (ccdid,ccdcategory,ccdlabel,ccdvalue,ccdstatus,ccdtype)
values (141,'012','�߶�(U)','2','1','A');
insert into ig.soc0151 (ccdid,ccdcategory,ccdlabel,ccdvalue,ccdstatus,ccdtype)
values (142,'012','�߶�(U)','3','1','A');
insert into ig.soc0151 (ccdid,ccdcategory,ccdlabel,ccdvalue,ccdstatus,ccdtype)
values (143,'012','�߶�(U)','4','1','A');


UPDATE IG.CODEDETAIL SET CVALUE = 'IBM����', psyscoding='999001001001' where CCID='274' AND CID ='0001';
UPDATE IG.CODEDETAIL SET CVALUE = 'Linux����', psyscoding='999001001005' where CCID='274' AND CID ='0002';
UPDATE IG.CODEDETAIL SET CVALUE = 'Windows����', psyscoding='999001001006' where CCID='274' AND CID ='0003';
UPDATE IG.CODEDETAIL SET CVALUE = 'SOCUnix����', psyscoding='999001001007' where CCID='274' AND CID ='0004';
DELETE FROM IG.CODEDETAIL WHERE CCID='274' AND CID ='0005';
