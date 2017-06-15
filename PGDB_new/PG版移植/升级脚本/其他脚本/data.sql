
************************************************************************ACTION*******************************************************************
--计划任务查询
insert into ig.action (actname,actlabel,acturl,acttype,actroletype,actsortid,acturltype)
values('ACT02SVC0802','工作计划查询','/IGCOM0202.do?linkID=IGSDL0112','M3','IGBP01,IGBP02,IGBP03,IGBP04,IGBP36,IGBP37','010802','0');

--信息安全模块菜单脚本
insert into ig.action (actname, actlabel, actdesc, acturl, acttype, actl1id, actl2id, actl3id, fingerprint, actroletype, actsortid, acturltype) 
values ('ACT19RIS',  '信息安全'  ,null,'/IGCOM0202.do?linkID=IGCOM0204','M1',null,null,null,null,'IGRI01,IGDU01,IGBP01,IGBP02,IGBP03,IGBP04,IGBP19','18','0');
insert into ig.action (actname, actlabel, actdesc, acturl, acttype, actl1id, actl2id, actl3id, fingerprint, actroletype, actsortid, acturltype) 
values ('ACT19RIS01','检查策略管理',null,null,'M2',null,null,null,null,'IGRI01,IGBP02,IGBP03,IGBP04,IGBP19','1801','0');
insert into ig.action (actname, actlabel, actdesc, acturl, acttype, actl1id, actl2id, actl3id, fingerprint, actroletype, actsortid, acturltype) 
values ('ACT19RIS0101','检查策略管理',null,'/IGCOM0202.do?linkID=IGRIS0201','M3',null,null,null,null,'IGRI01,IGBP02,IGBP03,IGBP04,IGBP19','180101','0');
insert into ig.action (actname, actlabel, actdesc, acturl, acttype, actl1id, actl2id, actl3id, fingerprint, actroletype, actsortid, acturltype) 
values ('ACT19RIS0102','检查策略设定',null,'/IGCOM0202.do?linkID=IGRIS0202','M3',null,null,null,null,'IGRI01,IGBP02,IGBP03,IGBP04,IGBP19','180102','0');
insert into ig.action (actname, actlabel, actdesc, acturl, acttype, actl1id, actl2id, actl3id, fingerprint, actroletype, actsortid, acturltype) 
values ('ACT19RIS02','检查问题管理',null,null,'M2',null,null,null,null,'IGBP01,IGBP02,IGBP03,IGBP04,IGBP19','1802','0');
insert into ig.action (actname, actlabel, actdesc, acturl, acttype, actl1id, actl2id, actl3id, fingerprint, actroletype, actsortid, acturltype) 
values ('ACT19RIS0201','检查问题查询',null,'/IGCOM0202.do?linkID=IGRIS0301&prtype=WD&prpdid=01020','M3',null,null,null,null,'IGBP01,IGBP02,IGBP03,IGBP04,IGBP19','180201','0');
insert into ig.action (actname, actlabel, actdesc, acturl, acttype, actl1id, actl2id, actl3id, fingerprint, actroletype, actsortid, acturltype) 
values ('ACT19RIS0202','检查问题发起',null,'/IGCOM0202.do?linkID=IGWKM0104&psdcode=Z&pdid=01020&ptid=8','M3',null,null,null,null,'IGBP01,IGBP02,IGBP03,IGBP04,IGBP19','180202','0');
insert into ig.action (actname, actlabel, actdesc, acturl, acttype, actl1id, actl2id, actl3id, fingerprint, actroletype, actsortid, acturltype) 
values ('ACT19RIS03','检查工作管理',null,null,'M2',null,null,null,null,'IGRI01,IGBP02,IGBP03,IGBP04,IGBP19','1803','0');
insert into ig.action (actname, actlabel, actdesc, acturl, acttype, actl1id, actl2id, actl3id, fingerprint, actroletype, actsortid, acturltype) 
values ('ACT19RIS0301','执行检查',null,'/IGCOM0202.do?linkID=IGRIS0203','M3',null,null,null,null,'IGRI01,IGBP02,IGBP03,IGBP04,IGBP19','180301','0');
insert into ig.action (actname, actlabel, actdesc, acturl, acttype, actl1id, actl2id, actl3id, fingerprint, actroletype, actsortid, acturltype) 
values ('ACT19RIS0302','检查工作查询',null,'/IGCOM0202.do?linkID=IGRIS0205','M3',null,null,null,null,'IGRI01,IGBP02,IGBP03,IGBP04,IGBP19','180302','0');
insert into ig.action (actname, actlabel, actdesc, acturl, acttype, actl1id, actl2id, actl3id, fingerprint, actroletype, actsortid, acturltype) 
values ('ACT19RIS0303','单项检查查询',null,'/IGCOM0202.do?linkID=IGRIS0206','M3',null,null,null,null,'IGRI01,IGBP02,IGBP03,IGBP04,IGBP19','180303','0');
insert into ig.action (actname, actlabel, actdesc, acturl, acttype, actl1id, actl2id, actl3id, fingerprint, actroletype, actsortid, acturltype) 
values ('ACT19RIS04','问题跟踪管理',null,null,'M2',null,null,null,null,'IGBP01,IGBP02,IGBP03,IGBP04,IGBP19','1805','0');
insert into ig.action (actname, actlabel, actdesc, acturl, acttype, actl1id, actl2id, actl3id, fingerprint, actroletype, actsortid, acturltype) 
values ('ACT19RIS0401','制定计划',null,'/IGCOM0202.do?linkID=IGRIS0304&prtype=WD&prpdid=01020&prstatus=Y','M3',null,null,null,null,'IGBP01,IGBP02,IGBP03,IGBP04,IGBP19','180501','0');
insert into ig.action (actname, actlabel, actdesc, acturl, acttype, actl1id, actl2id, actl3id, fingerprint, actroletype, actsortid, acturltype) 
values ('ACT19RIS0402','等待审批',null,'/IGCOM0202.do?linkID=IGRIS0304&prtype=WD&prpdid=01020&prstatus=X','M3',null,null,null,null,'IGBP01,IGBP02,IGBP03,IGBP04,IGBP19','180502','0');
insert into ig.action (actname, actlabel, actdesc, acturl, acttype, actl1id, actl2id, actl3id, fingerprint, actroletype, actsortid, acturltype) 
values ('ACT19RIS0403','等待执行',null,'/IGCOM0202.do?linkID=IGRIS0304&prtype=WD&prpdid=01020&prstatus=W','M3',null,null,null,null,'IGBP01,IGBP02,IGBP03,IGBP04,IGBP19','180503','0');
insert into ig.action (actname, actlabel, actdesc, acturl, acttype, actl1id, actl2id, actl3id, fingerprint, actroletype, actsortid, acturltype) 
values ('ACT19RIS0404','等待审核',null,'/IGCOM0202.do?linkID=IGRIS0304&prtype=WD&prpdid=01020&prstatus=V','M3',null,null,null,null,'IGBP01,IGBP02,IGBP03,IGBP04,IGBP19','180504','0');
insert into ig.action (actname, actlabel, actdesc, acturl, acttype, actl1id, actl2id, actl3id, fingerprint, actroletype, actsortid, acturltype) 
values ('ACT19RIS0405','本月问题',null,'/IGCOM0202.do?linkID=IGRIS0305&prtype=WD&prpdid=01020','M3',null,null,null,null,'IGBP01,IGBP02,IGBP03,IGBP04,IGBP19','180505','0');

--审计管理模块菜单脚本
insert into ig.action (actname, actlabel, actdesc, acturl, acttype, actl1id, actl2id, actl3id, fingerprint, actroletype, actsortid, acturltype)
values ('ACT14IAM', '审计管理', null, '/IGCOM0202.do?linkID=IGCOM0208', 'M1', null, null, null, null, 'IGBP18,IGBP02', '14', '0');
insert into ig.action (actname, actlabel, actdesc, acturl, acttype, actl1id, actl2id, actl3id, fingerprint, actroletype, actsortid, acturltype)
values ('ACT14IAM01', '内审项目管理', null, null, 'M2', null, null, null, null, 'IGBP18', '1401', '0');
insert into ig.action (actname, actlabel, actdesc, acturl, acttype, actl1id, actl2id, actl3id, fingerprint, actroletype, actsortid, acturltype)
values ('ACT14IAM0101', '内审项目管理', null, '/IGCOM0202.do?linkID=IGIAM0101', 'M3', null, null, null, null, 'IGBP18', '140101', '0');
insert into ig.action (actname, actlabel, actdesc, acturl, acttype, actl1id, actl2id, actl3id, fingerprint, actroletype, actsortid, acturltype)
values ('ACT14IAM0102', '内审项目登记', null, '/IGCOM0202.do?linkID=IGIAM0102', 'M3', null, null, null, null, 'IGBP18', '140102', '0');
insert into ig.action (actname, actlabel, actdesc, acturl, acttype, actl1id, actl2id, actl3id, fingerprint, actroletype, actsortid, acturltype)
values ('ACT14IAM0103', '内审项目确认', null, '/IGCOM0202.do?linkID=IGIAM0103', 'M3', null, null, null, null, 'IGBP18', '140103', '0');
insert into ig.action (actname, actlabel, actdesc, acturl, acttype, actl1id, actl2id, actl3id, fingerprint, actroletype, actsortid, acturltype)
values ('ACT14IAM0104', '内审项目查询', null, '/IGCOM0202.do?linkID=IGIAM0104', 'M3', null, null, null, null, 'IGBP18', '140104', '0');
insert into ig.action (actname, actlabel, actdesc, acturl, acttype, actl1id, actl2id, actl3id, fingerprint, actroletype, actsortid, acturltype)
values ('ACT14IAM02', '内审工作管理', null, null, 'M2', null, null, null, null, 'IGBP18', '1402', '0');
insert into ig.action (actname, actlabel, actdesc, acturl, acttype, actl1id, actl2id, actl3id, fingerprint, actroletype, actsortid, acturltype)
values ('ACT14IAM0201', '内审工作管理', null, '/IGCOM0202.do?linkID=IGIAM0201', 'M3', null, null, null, null, 'IGBP18', '140201', '0');
insert into ig.action (actname, actlabel, actdesc, acturl, acttype, actl1id, actl2id, actl3id, fingerprint, actroletype, actsortid, acturltype)
values ('ACT14IAM0202', '内审工作登记', null, '/IGCOM0202.do?linkID=IGIAM0202', 'M3', null, null, null, null, 'IGBP18', '140202', '0');
insert into ig.action (actname, actlabel, actdesc, acturl, acttype, actl1id, actl2id, actl3id, fingerprint, actroletype, actsortid, acturltype)
values ('ACT14IAM03', '外审项目管理', null, null, 'M2', null, null, null, null, 'IGBP18', '1403', '0');
insert into ig.action (actname, actlabel, actdesc, acturl, acttype, actl1id, actl2id, actl3id, fingerprint, actroletype, actsortid, acturltype)
values ('ACT14IAM0301', '外审项目管理', null, '/IGCOM0202.do?linkID=IGIAM0301', 'M3', null, null, null, null, 'IGBP18', '140301', '0');
insert into ig.action (actname, actlabel, actdesc, acturl, acttype, actl1id, actl2id, actl3id, fingerprint, actroletype, actsortid, acturltype)
values ('ACT14IAM0302', '外审项目登记', null, '/IGCOM0202.do?linkID=IGIAM0302', 'M3', null, null, null, null, 'IGBP18', '140302', '0');
insert into ig.action (actname, actlabel, actdesc, acturl, acttype, actl1id, actl2id, actl3id, fingerprint, actroletype, actsortid, acturltype)
values ('ACT14IAM0303', '外审项目查询', null, '/IGCOM0202.do?linkID=IGIAM0303', 'M3', null, null, null, null, 'IGBP18', '140303', '0');
insert into ig.action (actname, actlabel, actdesc, acturl, acttype, actl1id, actl2id, actl3id, fingerprint, actroletype, actsortid, acturltype)
values ('ACT14IAM04', '审计报告管理', null, null, 'M2', null, null, null, null, 'IGBP18', '1404', '0');
insert into ig.action (actname, actlabel, actdesc, acturl, acttype, actl1id, actl2id, actl3id, fingerprint, actroletype, actsortid, acturltype)
values ('ACT14IAM0401', '审计报告管理', null, '/IGCOM0202.do?linkID=IGIAM0401', 'M3', null, null, null, null, 'IGBP18', '140401', '0');
insert into ig.action (actname, actlabel, actdesc, acturl, acttype, actl1id, actl2id, actl3id, fingerprint, actroletype, actsortid, acturltype)
values ('ACT14IAM0402', '审计报告登记', null, '/IGCOM0202.do?linkID=IGIAM0402', 'M3', null, null, null, null, 'IGBP18', '140402', '0');
insert into ig.action (actname, actlabel, actdesc, acturl, acttype, actl1id, actl2id, actl3id, fingerprint, actroletype, actsortid, acturltype)
values ('ACT14IAM05', '检查问题管理', null, null, 'M2', null, null, null, null, 'IGBP01,IGBP02,IGBP03,IGBP04,IGBP18', '1405', '0');
insert into ig.action (actname, actlabel, actdesc, acturl, acttype, actl1id, actl2id, actl3id, fingerprint, actroletype, actsortid, acturltype)
values ('ACT14IAM0501', '问题管理', null, '/IGCOM0202.do?linkID=IGIAM0501'||'&'||'custom=0'||'&'||'prpdid_like_or=01183'||'&'||'prpdid_like_or=01206'||'&'||'prtype=WD', 'M3', null, null, null, null, 'IGBP01,IGBP02,IGBP03,IGBP04,IGBP18', '140501', '0');
insert into ig.action (actname, actlabel, actdesc, acturl, acttype, actl1id, actl2id, actl3id, fingerprint, actroletype, actsortid, acturltype)
values ('ACT14IAM0502', '制定计划', null, '/IGCOM0202.do?linkID=IGIAM0502'||'&'||'prtype=WD'||'&'||'pdid=01183;01206'||'&'||'ptid=8', 'M3', null, null, null, null, 'IGBP01,IGBP02,IGBP03,IGBP04,IGBP18', '140502', '1');

--统计分析菜单
insert into ig.ACTION (ACTNAME, ACTLABEL, ACTDESC, ACTURL, ACTTYPE, ACTL1ID, ACTL2ID, ACTL3ID, FINGERPRINT, ACTROLETYPE, ACTSORTID, ACTURLTYPE)
values ('ACT20VIR11', '资产统计分析', null, null, 'M2', null, null, null, null, 'IGAM01,IGTJ01', '1111', '0');
insert into ig.ACTION (ACTNAME, ACTLABEL, ACTDESC, ACTURL, ACTTYPE, ACTL1ID, ACTL2ID, ACTL3ID, FINGERPRINT, ACTROLETYPE, ACTSORTID, ACTURLTYPE)
values ('ACT20VIR1101', '资产通用查询', null, '/IGCOM0202.do?linkID=IGASM1001', 'M3', null, null, null, null,'IGAM01,IGTJ01', '111101', '0');
insert into ig.ACTION (ACTNAME, ACTLABEL, ACTDESC, ACTURL, ACTTYPE, ACTL1ID, ACTL2ID, ACTL3ID, FINGERPRINT, ACTROLETYPE, ACTSORTID, ACTURLTYPE)
values ('ACT20VIR1102', '设备存量统计', null, '/IGCOM0202.do?linkID=IGASM1301', 'M3', null, null, null, null, 'IGAM01,IGTJ01', '111102', '0');
insert into ig.ACTION (ACTNAME, ACTLABEL, ACTDESC, ACTURL, ACTTYPE, ACTL1ID, ACTL2ID, ACTL3ID, FINGERPRINT, ACTROLETYPE, ACTSORTID, ACTURLTYPE)
values ('ACT20VIR1103', '机房设备统计', null, '/IGCOM0202.do?linkID=IGASM1303', 'M3', null, null, null, null, 'IGAM01,IGTJ01', '111103', '0');
insert into ig.ACTION (ACTNAME, ACTLABEL, ACTDESC, ACTURL, ACTTYPE, ACTL1ID, ACTL2ID, ACTL3ID, FINGERPRINT, ACTROLETYPE, ACTSORTID, ACTURLTYPE)
values ('ACT20VIR12', '运维统计分析', null, null, 'M2', null, null, null, null, 'IGAM01,IGTJ01', '1112', '0');
insert into ig.ACTION (ACTNAME, ACTLABEL, ACTDESC, ACTURL, ACTTYPE, ACTL1ID, ACTL2ID, ACTL3ID, FINGERPRINT, ACTROLETYPE, ACTSORTID, ACTURLTYPE)
values ('ACT20VIR1201', '业务运行统计', null, '/IGCOM0202.do?linkID=IGSVC0602&type=003', 'M3', null, null, null, null, 'IGAM01,IGTJ01', '111201', '0');
insert into ig.ACTION (ACTNAME, ACTLABEL, ACTDESC, ACTURL, ACTTYPE, ACTL1ID, ACTL2ID, ACTL3ID, FINGERPRINT, ACTROLETYPE, ACTSORTID, ACTURLTYPE)
values ('ACT20VIR1202', '贡献数量统计', null, '/IGCOM0202.do?linkID=IGKGM0231', 'M3', null, null, null, null, 'IGAM01,IGTJ01', '111202', '0');
insert into ig.ACTION (ACTNAME, ACTLABEL, ACTDESC, ACTURL, ACTTYPE, ACTL1ID, ACTL2ID, ACTL3ID, FINGERPRINT, ACTROLETYPE, ACTSORTID, ACTURLTYPE)
values ('ACT20VIR13', '其他', null, null, 'M2', null, null, null, null, 'IGAM01,IGTJ01', '1113', '0');
insert into ig.ACTION (ACTNAME, ACTLABEL, ACTDESC, ACTURL, ACTTYPE, ACTL1ID, ACTL2ID, ACTL3ID, FINGERPRINT, ACTROLETYPE, ACTSORTID, ACTURLTYPE)
values ('ACT20VIR1301', '科技投入统计', null, '/IGCOM0202.do?linkID=IGSTA0103', 'M3', null, null, null, null, 'IGAM01,IGTJ01', '111301', '0');

--服务工单菜单升级
delete from ig.action where actname in ('ACT02SVC0115','ACT02SVC0116');
insert into ig.ACTION (ACTNAME, ACTLABEL, ACTDESC, ACTURL, ACTTYPE, ACTL1ID, ACTL2ID, ACTL3ID, FINGERPRINT, ACTROLETYPE, ACTSORTID, ACTURLTYPE)
values ('ACT02SVC0115', '服务工单查询', null, '/IGCOM0202.do?linkID=IGWKM0103&prtype=WD&prpdid=01380', 'M3', null, null, null, null, 'IGBP01,IGBP02,IGBP03,IGBP04,IGBP08', '010115', '0');
insert into ig.ACTION (ACTNAME, ACTLABEL, ACTDESC, ACTURL, ACTTYPE, ACTL1ID, ACTL2ID, ACTL3ID, FINGERPRINT, ACTROLETYPE, ACTSORTID, ACTURLTYPE)
values ('ACT02SVC0116', '服务工单登记', null, '/IGCOM0202.do?linkID=IGWKM0104&psdcode=Z&pdid=01380&ptid=8', 'M3', null, null, null, null, 'IGBP01,IGBP02,IGBP03,IGBP04,IGBP08', '010116', '0');

--日常工作计划
insert into IG.ACTION (ACTNAME, ACTLABEL, ACTDESC, ACTURL, ACTTYPE, ACTL1ID, ACTL2ID, ACTL3ID, FINGERPRINT, ACTROLETYPE, ACTSORTID, ACTURLTYPE)
values ('ACT02SVC08', '日常工作计划', null, null, 'M2', null, null, null, null, 'IGBP01,IGBP02,IGBP03,IGBP04,IGBP36,IGBP37', '0108', '0');
insert into IG.ACTION (ACTNAME, ACTLABEL, ACTDESC, ACTURL, ACTTYPE, ACTL1ID, ACTL2ID, ACTL3ID, FINGERPRINT, ACTROLETYPE, ACTSORTID, ACTURLTYPE)
values ('ACT02SVC0801', '个人任务', null, '/IGCOM0202.do?linkID=IGSCH0102', 'M3', null, null, null, null, 'IGBP01,IGBP02,IGBP03,IGBP04,IGBP36,IGBP37', '010801', '0');

--风险评估菜单
INSERT INTO ig."action" (ACTNAME,ACTLABEL,ACTDESC,ACTURL,ACTTYPE,ACTL1ID,ACTL2ID,ACTL3ID,FINGERPRINT,ACTROLETYPE,ACTSORTID,ACTURLTYPE) 
VALUES ('ACT16EPI','外包管理',NULL,'/IGCOM0202.do?linkID=IGCOM0206','M1',NULL,NULL,NULL,NULL,'IGAC02,IGAC04,IGAC15,IGBP01,IGBP25','16','0'
);
INSERT INTO ig."action" (ACTNAME,ACTLABEL,ACTDESC,ACTURL,ACTTYPE,ACTL1ID,ACTL2ID,ACTL3ID,FINGERPRINT,ACTROLETYPE,ACTSORTID,ACTURLTYPE)
 VALUES ('ACT16EPI01','资源池管理',NULL,NULL,'M2',NULL,NULL,NULL,NULL,'IGAC04','1601','0'
);
INSERT INTO ig."action" (ACTNAME,ACTLABEL,ACTDESC,ACTURL,ACTTYPE,ACTL1ID,ACTL2ID,ACTL3ID,FINGERPRINT,ACTROLETYPE,ACTSORTID,ACTURLTYPE) 
VALUES ('ACT16EPI0101','资源管理',NULL,'/IGCOM0202.do?linkID=IGASM0901','M3',NULL,NULL,NULL,NULL,'IGAC04','160101','0'
);
INSERT INTO ig."action" (ACTNAME,ACTLABEL,ACTDESC,ACTURL,ACTTYPE,ACTL1ID,ACTL2ID,ACTL3ID,FINGERPRINT,ACTROLETYPE,ACTSORTID,ACTURLTYPE)
 VALUES ('ACT16EPI0102','资源查询',NULL,'/IGCOM0202.do?linkID=IGASM0903','M3',NULL,NULL,NULL,NULL,'IGAC04','160102','0'
);
INSERT INTO ig."action" (ACTNAME,ACTLABEL,ACTDESC,ACTURL,ACTTYPE,ACTL1ID,ACTL2ID,ACTL3ID,FINGERPRINT,ACTROLETYPE,ACTSORTID,ACTURLTYPE)
 VALUES ('ACT16EPI0103','资源登记',NULL,'/IGCOM0202.do?linkID=IGASM0902','M3',NULL,NULL,NULL,NULL,'IGAC04','160103','0'
);
INSERT INTO ig."action" (ACTNAME,ACTLABEL,ACTDESC,ACTURL,ACTTYPE,ACTL1ID,ACTL2ID,ACTL3ID,FINGERPRINT,ACTROLETYPE,ACTSORTID,ACTURLTYPE)
 VALUES ('ACT16EPI0104','服务记录管理',NULL,'/IGCOM0202.do?linkID=IGASM1401','M3',NULL,NULL,NULL,NULL,'IGAC04','160104','0'
);
INSERT INTO ig."action" (ACTNAME,ACTLABEL,ACTDESC,ACTURL,ACTTYPE,ACTL1ID,ACTL2ID,ACTL3ID,FINGERPRINT,ACTROLETYPE,ACTSORTID,ACTURLTYPE)
 VALUES ('ACT16EPI0105','服务记录查询',NULL,'/IGCOM0202.do?linkID=IGASM1408','M3',NULL,NULL,NULL,NULL,'IGAC04','160105','0'
);
INSERT INTO ig."action" (ACTNAME,ACTLABEL,ACTDESC,ACTURL,ACTTYPE,ACTL1ID,ACTL2ID,ACTL3ID,FINGERPRINT,ACTROLETYPE,ACTSORTID,ACTURLTYPE) 
VALUES ('ACT16EPI0106','服务记录登记',NULL,'/IGCOM0202.do?linkID=IGASM1402','M3',NULL,NULL,NULL,NULL,'IGAC04','160106','0'
);
INSERT INTO ig."action" (ACTNAME,ACTLABEL,ACTDESC,ACTURL,ACTTYPE,ACTL1ID,ACTL2ID,ACTL3ID,FINGERPRINT,ACTROLETYPE,ACTSORTID,ACTURLTYPE)
 VALUES ('ACT16EPI0107','服务记录统计',NULL,'/IGCOM0202.do?linkID=IGASM2501','M3',NULL,NULL,NULL,NULL,'IGAC04','160107','0'
);
INSERT INTO ig."action" (ACTNAME,ACTLABEL,ACTDESC,ACTURL,ACTTYPE,ACTL1ID,ACTL2ID,ACTL3ID,FINGERPRINT,ACTROLETYPE,ACTSORTID,ACTURLTYPE)
 VALUES ('ACT16EPI0108','我行服务商',NULL,'/IGCOM0202.do?linkID=IGASM2601','M3',NULL,NULL,NULL,NULL,'IGAC04','160108','0'
);
INSERT INTO ig."action" (ACTNAME,ACTLABEL,ACTDESC,ACTURL,ACTTYPE,ACTL1ID,ACTL2ID,ACTL3ID,FINGERPRINT,ACTROLETYPE,ACTSORTID,ACTURLTYPE)
 VALUES ('ACT16EPI02','合同资产',NULL,NULL,'M2',NULL,NULL,NULL,NULL,'IGAC02','1602','0'
);
INSERT INTO ig."action" (ACTNAME,ACTLABEL,ACTDESC,ACTURL,ACTTYPE,ACTL1ID,ACTL2ID,ACTL3ID,FINGERPRINT,ACTROLETYPE,ACTSORTID,ACTURLTYPE)
 VALUES ('ACT16EPI0201','合同管理',NULL,'/IGCOM0202.do?linkID=IGASM0401','M3',NULL,NULL,NULL,NULL,'IGAC02','160201','0'
);
INSERT INTO ig."action" (ACTNAME,ACTLABEL,ACTDESC,ACTURL,ACTTYPE,ACTL1ID,ACTL2ID,ACTL3ID,FINGERPRINT,ACTROLETYPE,ACTSORTID,ACTURLTYPE)
 VALUES ('ACT16EPI0202','合同查询',NULL,'/IGCOM0202.do?linkID=IGASM0403','M3',NULL,NULL,NULL,NULL,'IGAC02','160202','0'
);
INSERT INTO ig."action" (ACTNAME,ACTLABEL,ACTDESC,ACTURL,ACTTYPE,ACTL1ID,ACTL2ID,ACTL3ID,FINGERPRINT,ACTROLETYPE,ACTSORTID,ACTURLTYPE) 
VALUES ('ACT16EPI0203','合同登记',NULL,'/IGCOM0202.do?linkID=IGASM0402','M3',NULL,NULL,NULL,NULL,'IGAC02','160203','0'
);
INSERT INTO ig."action" (ACTNAME,ACTLABEL,ACTDESC,ACTURL,ACTTYPE,ACTL1ID,ACTL2ID,ACTL3ID,FINGERPRINT,ACTROLETYPE,ACTSORTID,ACTURLTYPE)
 VALUES ('ACT16EPI0204','应付款登记',NULL,'/IGCOM0202.do?linkID=IGASM0420','M3',NULL,NULL,NULL,NULL,'IGAC02','160204','0'
);
INSERT INTO ig."action" (ACTNAME,ACTLABEL,ACTDESC,ACTURL,ACTTYPE,ACTL1ID,ACTL2ID,ACTL3ID,FINGERPRINT,ACTROLETYPE,ACTSORTID,ACTURLTYPE) 
VALUES ('ACT16EPI0205','应付款查询',NULL,'/IGCOM0202.do?linkID=IGASM0422','M3',NULL,NULL,NULL,NULL,'IGAC02','160205','0'
);
INSERT INTO ig."action" (ACTNAME,ACTLABEL,ACTDESC,ACTURL,ACTTYPE,ACTL1ID,ACTL2ID,ACTL3ID,FINGERPRINT,ACTROLETYPE,ACTSORTID,ACTURLTYPE) 
VALUES ('ACT16EPI0206','合同统计页',NULL,'/IGCOM0202.do?linkID=IGASM0424','M3',NULL,NULL,NULL,NULL,'IGAC02','160206','0'
);
INSERT INTO ig."action" (ACTNAME,ACTLABEL,ACTDESC,ACTURL,ACTTYPE,ACTL1ID,ACTL2ID,ACTL3ID,FINGERPRINT,ACTROLETYPE,ACTSORTID,ACTURLTYPE)
 VALUES ('ACT16EPI03','风险评估',NULL,NULL,'M2',NULL,NULL,NULL,NULL,'IGAC15,IGBP01,IGBP25','1603','0'
);
INSERT INTO ig."action" (ACTNAME,ACTLABEL,ACTDESC,ACTURL,ACTTYPE,ACTL1ID,ACTL2ID,ACTL3ID,FINGERPRINT,ACTROLETYPE,ACTSORTID,ACTURLTYPE)
 VALUES ('ACT16EPI0301','评估工作查询',NULL,'/IGCOM0202.do?linkID=IGRAM0501'||'&'||'prtype=WD4','M3',NULL,NULL,NULL,NULL,'IGAC15,IGBP01,IGBP25','160301','0'
);
INSERT INTO ig."action" (ACTNAME,ACTLABEL,ACTDESC,ACTURL,ACTTYPE,ACTL1ID,ACTL2ID,ACTL3ID,FINGERPRINT,ACTROLETYPE,ACTSORTID,ACTURLTYPE)
 VALUES ('ACT16EPI0302','评估工作发起',NULL,'/IGCOM0202.do?linkID=IGRAM0101'||'&'||'ptid=17','M3',NULL,NULL,NULL,NULL,'IGAC15,IGBP01,IGBP25','160302','1'
);
INSERT INTO ig."action" (ACTNAME,ACTLABEL,ACTDESC,ACTURL,ACTTYPE,ACTL1ID,ACTL2ID,ACTL3ID,FINGERPRINT,ACTROLETYPE,ACTSORTID,ACTURLTYPE) 
VALUES ('ACT16EPI0303','部门评估统计',NULL,'/IGCOM0202.do?linkID=IGRAM0301','M3',NULL,NULL,NULL,NULL,'IGAC15,IGBP01,IGBP25','160303','0'
);
INSERT INTO ig."action" (ACTNAME,ACTLABEL,ACTDESC,ACTURL,ACTTYPE,ACTL1ID,ACTL2ID,ACTL3ID,FINGERPRINT,ACTROLETYPE,ACTSORTID,ACTURLTYPE)
 VALUES ('ACT16EPI0304','年度评估统计',NULL,'/IGCOM0202.do?linkID=IGRAM0401','M3',NULL,NULL,NULL,NULL,'IGAC15,IGBP01,IGBP25','160304','0'
);


************************************************************************ ROLE *******************************************************************
--信息安全角色
INSERT INTO ig.role (roleid, rolename, roledesc, roleinfo, roletype, roledomain, assetdomain) 
values (1121,'信息安全员',null,null,'IGBP19','0002',null);
INSERT INTO ig.role (roleid, rolename, roledesc, roleinfo, roletype, roledomain, assetdomain) 
values (1127,'信息安全审批',null,null,'IGBP19','0002',null);

--审计角色脚本
--roledomain目前由于是产品版本所以变更成'0002'即'总机构'请参考实际客户情况在确认roledomain的范围
insert into ig.role (roleid, rolename, roledesc, roleinfo, roletype, roledomain, assetdomain, fingerprint)
values (1125, '审计确认', null, null, 'IGBP18', '0002', null, null);
insert into ig.role (roleid, rolename, roledesc, roleinfo, roletype, roledomain, assetdomain, fingerprint)
values (1126, '审计专员', null, null, 'IGBP18', '0002', null, null);


************************************************************************ CODECATEGORY *******************************************************************
INSERT INTO ig.codecategory(ccid, ccname, ccinfo, cceditable, pccid, pcflag, fingerprint)
values ('143','风险检查类型','风险检查类型','1',null,'0',null);

--审计基础数据
insert into ig.codecategory (ccid, ccname, ccinfo, cceditable, pccid, pcflag, fingerprint)
values ('853', '内审管理状态', '内审管理状态', '1', null, '1', null);
insert into ig.codecategory (ccid, ccname, ccinfo, cceditable, pccid, pcflag, fingerprint)
values ('854', '外审检查来源', '外审检查来源', '1', null, '0', null);
insert into ig.codecategory (ccid, ccname, ccinfo, cceditable, pccid, pcflag, fingerprint)
values ('855', '审计报告类型', '审计报告类型', '1', null, '0', null);

************************************************************************ CODEDETAIL *******************************************************************
INSERT INTO ig.codedetail(ccid, cid, cvalue, updtime) values ('143','1','日常工作','2014/02/24 00:00');
INSERT INTO ig.codedetail(ccid, cid, cvalue, updtime) values ('143','2','安全检查','2014/02/24 00:00');
INSERT INTO ig.codedetail(ccid, cid, cvalue, updtime) values ('100','IGBP19','信息安全管理','2014/04/08 00:00');
INSERT INTO ig.codedetail(ccid, cid, cvalue, updtime) values ('100','IGRI01','信息安全管理','2014/04/08 00:00');
--审计基础数据
insert into ig.codedetail (ccid, cid, cvalue, pccid, pcid, updtime, syscoding, psyscoding, cdstatus, businesscode, fingerprint, cdinfo, cdorder)
values ('100', 'IGBP18', '审计管理', null, null, '2014/04/10 11:30', null, null, null, null, null, null, null);
insert into ig.codedetail (ccid, cid, cvalue, pccid, pcid, updtime, syscoding, psyscoding, cdstatus, businesscode, fingerprint, cdinfo, cdorder)
values ('853', '0', '草稿', null, null, '2014/04/10 11:30', '853001', null, '1', null, null, null, null);
insert into ig.codedetail (ccid, cid, cvalue, pccid, pcid, updtime, syscoding, psyscoding, cdstatus, businesscode, fingerprint, cdinfo, cdorder)
values ('853', '1', '未确认', null, null, '2014/04/10 11:30', '853002', null, '1', null, null, null, null);
insert into ig.codedetail (ccid, cid, cvalue, pccid, pcid, updtime, syscoding, psyscoding, cdstatus, businesscode, fingerprint, cdinfo, cdorder)
values ('853', '2', '已确认', null, null, '2014/04/10 11:30', '853003', null, '1', null, null, null, null);
insert into ig.codedetail (ccid, cid, cvalue, pccid, pcid, updtime, syscoding, psyscoding, cdstatus, businesscode, fingerprint, cdinfo, cdorder)
values ('854', '0', '科技部', null, null, '2014/04/10 11:30', '854001', null, '1', null, null, null, null);
insert into ig.codedetail (ccid, cid, cvalue, pccid, pcid, updtime, syscoding, psyscoding, cdstatus, businesscode, fingerprint, cdinfo, cdorder)
values ('854', '1', '审计部', null, null, '2014/04/10 11:30', '854002', null, '1', null, null, null, null);
insert into ig.codedetail (ccid, cid, cvalue, pccid, pcid, updtime, syscoding, psyscoding, cdstatus, businesscode, fingerprint, cdinfo, cdorder)
values ('854', '2', '其他监管机构', null, null, '2014/04/10 11:30', '854003', null, '1', null, null, null, null);
insert into ig.codedetail (ccid, cid, cvalue, pccid, pcid, updtime, syscoding, psyscoding, cdstatus, businesscode, fingerprint, cdinfo, cdorder)
values ('854', '3', '人民银行', null, null, '2014/04/10 11:30', '854004', null, '1', null, null, null, null);
insert into ig.codedetail (ccid, cid, cvalue, pccid, pcid, updtime, syscoding, psyscoding, cdstatus, businesscode, fingerprint, cdinfo, cdorder)
values ('854', '4', '银监局', null, null, '2014/04/10 11:30', '854005', null, '1', null, null, null, null);
insert into ig.codedetail (ccid, cid, cvalue, pccid, pcid, updtime, syscoding, psyscoding, cdstatus, businesscode, fingerprint, cdinfo, cdorder)
values ('855', '0', '内审报告', null, null, '2014/04/10 11:30', null, null, null, null, null, null, null);
insert into ig.codedetail (ccid, cid, cvalue, pccid, pcid, updtime, syscoding, psyscoding, cdstatus, businesscode, fingerprint, cdinfo, cdorder)
values ('855', '1', '外审报告', null, null, '2014/04/10 11:30', null, null, null, null, null, null, null);
insert into ig.codedetail (ccid, cid, cvalue, pccid, pcid, updtime, syscoding, psyscoding, cdstatus, businesscode, fingerprint, cdinfo, cdorder)
values ('855', '2', '年度报告', null, null, '2014/04/10 11:30', null, null, null, null, null, null, null);

************************************************************************ CODECATEGORYDEF *******************************************************************
INSERT INTO ig.codecategorydef (ccid, ccname, ccinfo, cceditable, pccid, pcflag, fingerprint) 
values ('110','检查项类别','检查项类别','3',null,'4',null);

************************************************************************ CODEDETAILDEF *******************************************************************
INSERT INTO ig.codedetaildef(ccid, cid, cvalue, pccid, pcid, updtime, syscoding, psyscoding, cdstatus, businesscode, cdinfo, fingerprint) 
values ('110','0001','安全制度及组织管理','','','2014/04/08 15:15','110001','','1','','','');
INSERT INTO ig.codedetaildef(ccid, cid, cvalue, pccid, pcid, updtime, syscoding, psyscoding, cdstatus, businesscode, cdinfo, fingerprint) 
values ('110','0002','信息资产管理','','','2014/04/08 15:15','110002','','1','','','');
INSERT INTO ig.codedetaildef(ccid, cid, cvalue, pccid, pcid, updtime, syscoding, psyscoding, cdstatus, businesscode, cdinfo, fingerprint) 
values ('110','0003','人员安全管理','','','2014/04/08 15:15','110003','','1','','','');
INSERT INTO ig.codedetaildef(ccid, cid, cvalue, pccid, pcid, updtime, syscoding, psyscoding, cdstatus, businesscode, cdinfo, fingerprint) 
values ('110','0004','物理与环境安全管理','','','2014/04/08 15:15','110004','','1','','','');
INSERT INTO ig.codedetaildef(ccid, cid, cvalue, pccid, pcid, updtime, syscoding, psyscoding, cdstatus, businesscode, cdinfo, fingerprint) 
values ('110','0005','通信与运营管理','','','2014/04/08 15:15','110005','','1','','','');
INSERT INTO ig.codedetaildef(ccid, cid, cvalue, pccid, pcid, updtime, syscoding, psyscoding, cdstatus, businesscode, cdinfo, fingerprint) 
values ('110','0006','访问控制管理','','','2014/04/08 15:15','110006','','1','','','');
INSERT INTO ig.codedetaildef(ccid, cid, cvalue, pccid, pcid, updtime, syscoding, psyscoding, cdstatus, businesscode, cdinfo, fingerprint) 
values ('110','0007','系统开发与维护管理','','','2014/04/08 15:15','110007','','1','','','');
INSERT INTO ig.codedetaildef(ccid, cid, cvalue, pccid, pcid, updtime, syscoding, psyscoding, cdstatus, businesscode, cdinfo, fingerprint) 
values ('110','0008','信息安全事故管理','','','2014/04/08 15:15','110008','','1','','','');
INSERT INTO ig.codedetaildef(ccid, cid, cvalue, pccid, pcid, updtime, syscoding, psyscoding, cdstatus, businesscode, cdinfo, fingerprint) 
values ('110','0009','业务连续性管理','','','2014/04/08 15:15','110009','','1','','','');
INSERT INTO ig.codedetaildef(ccid, cid, cvalue, pccid, pcid, updtime, syscoding, psyscoding, cdstatus, businesscode, cdinfo, fingerprint) 
values ('110','0010','合规性管理','','','2014/04/08 15:15','110010','','1','','','');

--个人工作指派工作
DELETE FROM IG.IG259 WHERE PTID IN (6,7);
insert into IG.IG259 (PTID, PTNAME, PTTYPE, PTSTARTPG, PTDETAILPG, PTCRTDATE, PTPICINFO, PTSTATUS, PTSAVEPG, PTQRTZFLAG, FINGERPRINT, FIRSTSITE, PDSEQUENCE)
values (6, '个人工作', 'WB', 'IGEXTWB0102_Disp.do', 'IGEXTWB0103_Disp.do?prid=', '2009/07/17', 'images/wkm/extwb/extwb.gif', 'a', 'IGMTP0102.do,personTask.do', 'WP', null, null, null);
insert into IG.IG259 (PTID, PTNAME, PTTYPE, PTSTARTPG, PTDETAILPG, PTCRTDATE, PTPICINFO, PTSTATUS, PTSAVEPG, PTQRTZFLAG, FINGERPRINT, FIRSTSITE, PDSEQUENCE)
values (7, '指派工作', 'WA', 'IGEXTWA0102_Disp.do', 'IGEXTWA0103_Disp.do?prid=', '2009/07/17', 'images/wkm/extwa/extwa.gif', 'a', 'IGMTP0101.do,enterpriseTask.do', 'WE', null, null, null);
INSERT INTO IG.IG380 (PDID,PTID,PDNAME,PDCRTDATE,PDSTATUS) VALUES ('0001001','6','个人工作','2013/10/10','a');
INSERT INTO IG.IG380 (PDID,PTID,PDNAME,PDCRTDATE,PDSTATUS) VALUES ('0100001','7','指派工作','2013/10/10','a');
---------------------------------------------------------------------------------------------------------------------------------------------------------------
INSERT INTO ig.IG555 (JUMP,URL,DESCRIPTION,FINGERPRINT) VALUES (
'104','IGPRJ0501_BACK.do',NULL,NULL);
INSERT INTO ig.IG555 (JUMP,URL,DESCRIPTION,FINGERPRINT) VALUES (
'105','IGPRJ0506.do',NULL,NULL);
INSERT INTO ig.IG555 (JUMP,URL,DESCRIPTION,FINGERPRINT) VALUES (
'106','IGPRJ0401_BACK.do',NULL,NULL);
INSERT INTO ig.IG555 (JUMP,URL,DESCRIPTION,FINGERPRINT) VALUES (
'107','IGPRJ0402_BACK.do',NULL,NULL);
INSERT INTO ig.IG555 (JUMP,URL,DESCRIPTION,FINGERPRINT) VALUES (
'55','IGCOM0202.do?linkID=IGSVC0105&prid=${prid}&actname=ACT05STA0103',NULL,NULL);
INSERT INTO ig.IG555 (JUMP,URL,DESCRIPTION,FINGERPRINT) VALUES (
'0','IGCOM0201_Disp.do',NULL,NULL);
INSERT INTO ig.IG555 (JUMP,URL,DESCRIPTION,FINGERPRINT) VALUES (
'1','IGCOM0203_Disp.do',NULL,NULL);
INSERT INTO ig.IG555 (JUMP,URL,DESCRIPTION,FINGERPRINT) VALUES (
'2','IGSVC0801_Back.do',NULL,NULL);
INSERT INTO ig.IG555 (JUMP,URL,DESCRIPTION,FINGERPRINT) VALUES (
'3','IGSVC0801_Disp.do',NULL,NULL);
INSERT INTO ig.IG555 (JUMP,URL,DESCRIPTION,FINGERPRINT) VALUES (
'4','IGSVC0703.do',NULL,NULL);
INSERT INTO ig.IG555 (JUMP,URL,DESCRIPTION,FINGERPRINT) VALUES (
'5','IGWKM0101_BACK.do',NULL,NULL);
INSERT INTO ig.IG555 (JUMP,URL,DESCRIPTION,FINGERPRINT) VALUES (
'6','IGSVC0902.do?type=${IGSVC0902Form.type}&prorgid=${IGSVC0902Form.prorgid}&propentime_from=${IGSVC0902Form.propentime_from}&propentime_to=${propentime_to}&prpdid=${IGSVC0902Form.prpdid}',NULL,NULL);
INSERT INTO ig.IG555 (JUMP,URL,DESCRIPTION,FINGERPRINT) VALUES (
'77','IGCOM0105.do?index=1',NULL,NULL);
INSERT INTO ig.IG555 (JUMP,URL,DESCRIPTION,FINGERPRINT) VALUES (
'76','IGCOM0105.do?index=3',NULL,NULL);
INSERT INTO ig.IG555 (JUMP,URL,DESCRIPTION,FINGERPRINT) VALUES (
'78','IGWKM0103_BACK.do',NULL,NULL);
INSERT INTO ig.IG555 (JUMP,URL,DESCRIPTION,FINGERPRINT) VALUES (
'79','IGCOM0202.do?linkID=IGSVC0101&actname=ACT05STA0102',NULL,NULL);
INSERT INTO ig.IG555 (JUMP,URL,DESCRIPTION,FINGERPRINT) VALUES (
'80','IGPRT0101.do',NULL,NULL);
INSERT INTO ig.IG555 (JUMP,URL,DESCRIPTION,FINGERPRINT) VALUES (
'81','IGWKM0106_BACK.do',NULL,NULL);
INSERT INTO ig.IG555 (JUMP,URL,DESCRIPTION,FINGERPRINT) VALUES (
'82','IGWKM0107_BACK.do',NULL,NULL);
INSERT INTO ig.IG555 (JUMP,URL,DESCRIPTION,FINGERPRINT) VALUES (
'83','IGWKM0108_BACK.do',NULL,NULL);
INSERT INTO ig.IG555 (JUMP,URL,DESCRIPTION,FINGERPRINT) VALUES (
'84','IGSMR0301.do',NULL,NULL);
INSERT INTO ig.IG555 (JUMP,URL,DESCRIPTION,FINGERPRINT) VALUES (
'85','IGSMR0301_FIRST.do',NULL,NULL);
INSERT INTO ig.IG555 (JUMP,URL,DESCRIPTION,FINGERPRINT) VALUES (
'86','IGSMR0402_Disp.do?instanceID=${instanceID}',NULL,NULL);
INSERT INTO ig.IG555 (JUMP,URL,DESCRIPTION,FINGERPRINT) VALUES (
'87','IGSMR0302_DISP.do',NULL,NULL);
INSERT INTO ig.IG555 (JUMP,URL,DESCRIPTION,FINGERPRINT) VALUES (
'88','IGSMR0602_DISP.do',NULL,NULL);
INSERT INTO ig.IG555 (JUMP,URL,DESCRIPTION,FINGERPRINT) VALUES (
'89','IGSMR0602_FIRST.do',NULL,NULL);
INSERT INTO ig.IG555 (JUMP,URL,DESCRIPTION,FINGERPRINT) VALUES (
'90','IGSMR0604_Disp.do?instanceID=${instanceID}',NULL,NULL);
INSERT INTO ig.IG555 (JUMP,URL,DESCRIPTION,FINGERPRINT) VALUES (
'91','IGSMR0603_DISP.do',NULL,NULL);
INSERT INTO ig.IG555 (JUMP,URL,DESCRIPTION,FINGERPRINT) VALUES (
'92','IGSMR0702.do',NULL,NULL);
INSERT INTO ig.IG555 (JUMP,URL,DESCRIPTION,FINGERPRINT) VALUES (
'93','IGSMR0702_FIRST.do',NULL,NULL);
INSERT INTO ig.IG555 (JUMP,URL,DESCRIPTION,FINGERPRINT) VALUES (
'94','IGSMR0704_Disp.do?instanceID=${instanceID}',NULL,NULL);
INSERT INTO ig.IG555 (JUMP,URL,DESCRIPTION,FINGERPRINT) VALUES (
'95','IGSMR0703_DISP.do',NULL,NULL);
INSERT INTO ig.IG555 (JUMP,URL,DESCRIPTION,FINGERPRINT) VALUES (
'96','IGSMR0304_DISP.do',NULL,NULL);
INSERT INTO ig.IG555 (JUMP,URL,DESCRIPTION,FINGERPRINT) VALUES (
'98','IGCOM0105.do?index=2',NULL,NULL);
INSERT INTO ig.IG555 (JUMP,URL,DESCRIPTION,FINGERPRINT) VALUES (
'97','IGRAM0501_BACK.do',NULL,NULL);
INSERT INTO ig.IG555 (JUMP,URL,DESCRIPTION,FINGERPRINT) VALUES (
'99','IGIAM0501_BACK',NULL,NULL);
INSERT INTO ig.IG555 (JUMP,URL,DESCRIPTION,FINGERPRINT) VALUES (
'100','IGIAM0503_BACK',NULL,NULL);
INSERT INTO ig.IG555 (JUMP,URL,DESCRIPTION,FINGERPRINT) VALUES (
'102','IGCOM0202.do?linkID=IGDUT0203&actname=ACT03SDL0804',NULL,NULL);
INSERT INTO ig.IG555 (JUMP,URL,DESCRIPTION,FINGERPRINT) VALUES (
'103','IGDUT0302.do',NULL,NULL);
INSERT INTO ig.IG555 (JUMP,URL,DESCRIPTION,FINGERPRINT) VALUES (
'10','IGWKM0110_Back.do',NULL,NULL
);
INSERT INTO ig.IG555 (JUMP,URL,DESCRIPTION,FINGERPRINT) VALUES (
'101','IGCOM0202.do?linkID=IGRIS0203&actname=ACT19RIS0103',NULL,NULL
);

--我的工作
INSERT INTO ig.IG555 (JUMP,URL,DESCRIPTION,FINGERPRINT) VALUES (
'121','IGCOM0202.do?linkID=IGSVC0101&actname=ACT02SVC0101',NULL,NULL);
--相关工作
INSERT INTO ig.IG555 (JUMP,URL,DESCRIPTION,FINGERPRINT) VALUES (
'122','IGCOM0202.do?linkID=IGSVC0102&actname=ACT02SVC0102',NULL,NULL);
--我的发起
INSERT INTO ig.IG555 (JUMP,URL,DESCRIPTION,FINGERPRINT) VALUES (
'123','IGCOM0202.do?linkID=IGSVC0103&actname=ACT02SVC0103',NULL,NULL);
--工作监督
INSERT INTO ig.IG555 (JUMP,URL,DESCRIPTION,FINGERPRINT) VALUES (
'124','IGCOM0202.do?linkID=IGSVC0105&actname=ACT02SVC0105',NULL,NULL);
--历史工作
INSERT INTO ig.IG555 (JUMP,URL,DESCRIPTION,FINGERPRINT) VALUES (
'126','IGSVC0110.do',NULL,NULL);



--自定义流程序列号生产BL
update ig.ig380 set serialgenerator = 'igGENERATOR0113BLImpl' where pdid = '0100101';
update ig.ig380 set serialgenerator = 'igGENERATOR0102BLImpl' where pdid = '0100201';
update ig.ig380 set serialgenerator = 'igGENERATOR0103BLImpl' where pdid = '0100301';
update ig.ig380 set serialgenerator = 'igGENERATOR0104BLImpl' where pdid = '0100401';
update ig.ig380 set serialgenerator = 'igGENERATOR0105BLImpl' where pdid = '0102001';
update ig.ig380 set serialgenerator = 'igGENERATOR0114BLImpl' where pdid = '0108001';
update ig.ig380 set serialgenerator = 'igGENERATOR0112BLImpl' where pdid = '0108301';
update ig.ig380 set serialgenerator = 'igGENERATOR0108BLImpl' where pdid = '0108402';
update ig.ig380 set serialgenerator = 'igGENERATOR0109BLImpl' where pdid = '0110001';
update ig.ig380 set serialgenerator = 'igGENERATOR0111BLImpl' where pdid = '0132001';



----------------------------------------------------风险评估脚本----------------------------------------------------------------

--插入风险评估模板
insert into ig.IG259 (PTID, PTNAME, PTTYPE, PTSTARTPG, PTDETAILPG, PTCRTDATE, PTPICINFO, PTSTATUS, PTSAVEPG, PTQRTZFLAG, FINGERPRINT,firstsite,pdsequence)
values (17, '风险评估', 'WD4', 'IGPRR0102_Disp.do?psdcode=Z'|| chr(38) ||'ptid=17'|| chr(38) ||'pdid=', 'IGPRR0102_Disp.do?prtype=WD4'|| chr(38) || 'prid=', '2013/10/11', null, 'a', null, null, null,'4','PDID_WD4');

--添加风险评估管理菜单
INSERT INTO ig."action" (ACTNAME,ACTLABEL,ACTDESC,ACTURL,ACTTYPE,ACTL1ID,ACTL2ID,ACTL3ID,FINGERPRINT,ACTROLETYPE,ACTSORTID,ACTURLTYPE)
VALUES ('ACT09SYM14','评估定义',NULL,NULL,'M2',NULL,NULL,NULL,NULL,NULL,'1510','0');
INSERT INTO ig."action"(actname, actlabel, actdesc, acturl, acttype, actl1id, actl2id, actl3id, fingerprint, actroletype, actsortid, acturltype)
VALUES ('ACT09SYM1401', '评估管理', NULL, '/IGCOM0202.do?linkID=IGPRD0101'|| chr(38) || 'pttype=WD4', 'M3', NULL, NULL, NULL, NULL, NULL, '151001', '0');
INSERT INTO ig."action"(actname, actlabel, actdesc, acturl, acttype, actl1id, actl2id, actl3id, fingerprint, actroletype, actsortid, acturltype)
VALUES ('ACT09SYM1402', '评估登记', NULL, '/IGCOM0202.do?linkID=IGPRD0102'|| chr(38) || 'pttype=WD4', 'M3', NULL, NULL, NULL, NULL, NULL, '151002', '0');


--添加风险评估角色类型
INSERT INTO ig.CODEDETAIL (CCID,CID,CVALUE,PCCID,PCID,UPDTIME,SYSCODING,PSYSCODING,CDSTATUS,BUSINESSCODE,FINGERPRINT,CDINFO,CDORDER)
 VALUES ('100','IGBP25','评估管理',NULL,NULL,'2013/07/04 00:00',NULL,NULL,NULL,NULL,NULL,NULL,NULL);

--添加风险评估角色
insert into ig.ROLE (ROLEID, ROLENAME, ROLEDESC, ROLEINFO, ROLETYPE, ROLEDOMAIN, ASSETDOMAIN, FINGERPRINT)
values (100, '评估审批分派', null, null, 'IGBP25', '0002', null, null);
insert into ig.ROLE (ROLEID, ROLENAME, ROLEDESC, ROLEINFO, ROLETYPE, ROLEDOMAIN, ASSETDOMAIN, FINGERPRINT)
values (101, '评估工作执行', null, null, 'IGBP25', '0002', null, null);

--部门评估统计codedetail数据
insert into ig.codedetail (ccid,cid,cvalue,updtime,cdinfo) values(284,'RAM0301','IGRAM0301','2013/10/12 14:38','部门评估统计');
--年度评估统计codedetail数据
insert into ig.codedetail (ccid,cid,cvalue,updtime,cdinfo) values(284,'RAM0401','IGRAM0401','2013/10/12 14:38','年度评估统计');

----------------------------------------------------风险评估脚本----------------------------------------------------------------

INSERT INTO ig.CODEDETAIL(CCID, CID, CVALUE, PCCID, PCID, UPDTIME, SYSCODING, PSYSCODING, CDSTATUS, BUSINESSCODE, FINGERPRINT, CDINFO)
VALUES('272', 'month', '每月', '', '', '', '', '', ' ', '', '', '');
INSERT INTO ig.CODEDETAIL(CCID, CID, CVALUE, PCCID, PCID, UPDTIME, SYSCODING, PSYSCODING, CDSTATUS, BUSINESSCODE, FINGERPRINT, CDINFO)
VALUES('272', 'week', '每周', '', '', '', '', '', ' ', '', '', '');
INSERT INTO ig.CODEDETAIL(CCID, CID, CVALUE, PCCID, PCID, UPDTIME, SYSCODING, PSYSCODING, CDSTATUS, BUSINESSCODE, FINGERPRINT, CDINFO)
VALUES('272', 'halfyear', '每半年', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO ig.CODEDETAIL(CCID, CID, CVALUE, PCCID, PCID, UPDTIME, SYSCODING, PSYSCODING, CDSTATUS, BUSINESSCODE, FINGERPRINT, CDINFO)
VALUES('272', 'quarter', '每季度', '', '', '', '', '', ' ', '', '', '');
INSERT INTO ig.CODEDETAIL(CCID, CID, CVALUE, PCCID, PCID, UPDTIME, SYSCODING, PSYSCODING, CDSTATUS, BUSINESSCODE, FINGERPRINT, CDINFO)
VALUES('272', 'year', '每年', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO ig.CODEDETAIL(CCID, CID, CVALUE, PCCID, PCID, UPDTIME, SYSCODING, PSYSCODING, CDSTATUS, BUSINESSCODE, FINGERPRINT, CDINFO)
VALUES('272', 'day', '每日', '', '', '', '', '', ' ', '', '', '');

-----------------------------------更新统计分析授权菜单-------------------------------------------------------------
update ig.action set actroletype = 'IGCI01,IGTJ01' WHERE actsortid like '11%';

-----------------------------------删除多余信息安全角色类型--------------------------------------------
DELETE FROM IG.CODEDETAIL WHERE CCID='100' AND CID ='IGRI01'

delete from ig.ig380;
insert into ig.role (roleid,rolename,roletype,roledomain) values (3,'流程分派者','IGBP04','0002');
UPDATE IG.ACTION SET ACTURL ='/IGCOM0202.do?linkID=IGMTM0701' WHERE ACTNAME ='ACT13MTM0304';