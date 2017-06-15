--外包人员资产
insert into ig.action values('ACT16EPI04','外包人员管理',null,null,'M2',null,null,null,null,'IGAC12','1604','0');
insert into ig.action values('ACT16EPI0401','外包人员管理',null,'/IGCOM0202.do?linkID=IGASM1901','M3',null,null,null,null,'IGAC12','160401','0');
insert into ig.action values('ACT16EPI0402','外包人员查询',null,'/IGCOM0202.do?linkID=IGASM1903','M3',null,null,null,null,'IGAC12','160402','0');
insert into ig.action values('ACT16EPI0403','外包人员登记',null,'/IGCOM0202.do?linkID=IGASM1902','M3',null,null,null,null,'IGAC12','160403','0');
--更新外包管理一级菜单权限
update ig.action set actroletype = actroletype || ',IGAC12' where actname = 'ACT16EPI';

--外包人员管理角色类型
insert into ig.codedetail(ccid, cid, cvalue, updtime) values('100', 'IGAC12', '外包人员资产管理', '2010/01/01 00:00');

--外包人员资产关系
insert into ig.codedetail(ccid, cid, cvalue, updtime, businesscode) values('011', '51', '服务商-外包人员', '2012/10/29 00:00', '005-016');
insert into ig.codedetail(ccid, cid, cvalue, updtime, businesscode) values('011', '52', '合同-外包人员', '2012/10/29 00:00', '011-016');
insert into ig.codedetail(ccid, cid, cvalue, updtime, businesscode) values('011', '54', '设备-外包人员', '2012/10/29 00:00', '001-016');
insert into ig.codedetail(ccid, cid, cvalue, updtime, businesscode) values('011', '55', '文档-外包人员', '2012/10/29 00:00', '013-016');
insert into ig.codedetail(ccid, cid, cvalue, updtime, businesscode) values('011', '56', '应用-外包人员', '2012/10/29 00:00', '003-016');
insert into ig.codedetail(ccid, cid, cvalue, updtime, businesscode) values('011', '57', '系统-外包人员', '2012/10/29 00:00', '006-016');
insert into ig.codedetail(ccid, cid, cvalue, updtime, businesscode) values('011', '58', '服务记录-外包人员', '2012/10/29 00:00', '009-016');
insert into ig.codedetail(ccid, cid, cvalue, updtime, businesscode) values('011', '59', '外包人员-外包人员', '2012/10/29 00:00', '016-016');
insert into ig.codedetail(ccid, cid, cvalue, updtime, businesscode) values('011', '60', '软件-外包人员', '2012/10/29 00:00', '002-016');

--外包人员资产模型
insert into ig.soc0117 values( 'CM13000000', '外包人员资产', '016', '外包人员信息', '1', '016', null, null, null, '999016', '999', null, null);
--外包人员资产属性
insert into ig.soc0109 values('CI130000000001', 'CM13000000', '性别', null, null, null, '1', 0, '001', '040', '2', '999016', null, '1');
insert into ig.soc0109 values('CI130000000002', 'CM13000000', '出生日期', null, null, null, '1', 0, '001', null, '3', '999016', null, null);
insert into ig.soc0109 values('CI130000000003', 'CM13000000', '身份证号码', null, null, null, '1', 0, '001', null, '0', '999016', null, null);
insert into ig.soc0109 values('CI130000000004', 'CM13000000', '政治面貌', null, '党员、团员、群众等等', null, '1', 0, '001', null, '0', '999016', null, null);
insert into ig.soc0109 values('CI130000000005', 'CM13000000', '最高学历', null, '大专、本科等', null, '1', 0, '001', null, '0', '999016', null, null);
insert into ig.soc0109 values('CI130000000006', 'CM13000000', '最高学位', null, '学士、硕士、博士等', null, '1', 0, '001', null, '0', '999016', null, null);
insert into ig.soc0109 values('CI130000000007', 'CM13000000', '专业', null, null, null, '1', 0, '001', null, '0', '999016', null, null);
insert into ig.soc0109 values('CI130000000008', 'CM13000000', '最后学历教育方式', null, '全日制、半脱产等', null, '1', 0, '001', null, '0', '999016', null, null);
insert into ig.soc0109 values('CI130000000009', 'CM13000000', '最后学历毕业院校', null, null, null, '1', 0, '001', null, '0', '999016', null, null);
insert into ig.soc0109 values('CI130000000010', 'CM13000000', '员工编号', null, null, null, '1', 0, '001', null, '0', '999016', null, null);
insert into ig.soc0109 values('CI130000000011', 'CM13000000', '职称', null, null, null, '1', 0, '001', null, '0', '999016', null, null);
insert into ig.soc0109 values('CI130000000012', 'CM13000000', '岗位', null, null, null, '1', 0, '001', null, '0', '999016', null, null);
insert into ig.soc0109 values('CI130000000013', 'CM13000000', '备注', null, null, null, '1', 0, '001', null, '0', '999016', null, null);
insert into ig.soc0109 values('CI130000000014', 'CM13000000', '专业资质认证', null, null, null, '1', 0, '001', null, '0', '999016', null, null);
--外包人员性别取值范围
insert into ig.soc0151 values( 136, '040', '性别', '男', '1', 'A');
insert into ig.soc0151 values( 137, '040', '性别', '女', '1', 'A');

--统计导出
insert into ig.codedetail(ccid, cid, cvalue, updtime, cdinfo) values('284', 'ASM0420', 'IGASM0420', '2013/04/19 11:29', '应付款管理表');
insert into ig.codedetail(ccid, cid, cvalue, updtime, cdinfo) values('284', 'ASM0901', 'IGASM0901', '2013/04/19 11:29', '服务商管理');

--IG342VW
create or replace view ig.ig342 as
select
    ei.eiid ,
    ei.einame ,
    ei.eiinsdate ,
    ei.eiupdtime ,
    ci.civalue as address ,
    ci1.civalue as linkman ,
    ci2.civalue as phone ,
    ci3.civalue as fund ,
    ci4.civalue as aptitude ,
    ci5.civalue as succeedcase ,
    ci6.civalue
from ig.soc0118 ei 
left join ig.soc0107 ci on (ei.eiid = ci.eiid) and ci.cid = 'CI040000000008' and ei.eiupdtime = ci.ciupdtime 
left join ig.soc0107 ci1 on (ei.eiid = ci1.eiid) and ci1.cid = 'CI040000000009' and ei.eiupdtime = ci1.ciupdtime 
left join ig.soc0107 ci2 on (ei.eiid = ci2.eiid) and ci2.cid = 'CI040000000010' and ei.eiupdtime = ci2.ciupdtime 
left join ig.soc0107 ci3 on (ei.eiid = ci3.eiid) and ci3.cid = 'CI040000000006' and ei.eiupdtime = ci3.ciupdtime 
left join ig.soc0107 ci4 on (ei.eiid = ci4.eiid) and ci4.cid = 'CI040000000005' and ei.eiupdtime = ci4.ciupdtime 
left join ig.soc0107 ci5 on (ei.eiid = ci5.eiid) and ci5.cid = 'CI040000000013' and ei.eiupdtime = ci5.ciupdtime 
left join ig.soc0107 ci6 on (ei.eiid = ci6.eiid) and ci6.cid = 'CI040000000017' and ei.eiupdtime = ci6.ciupdtime
where ei.esyscoding like '999005%';

--IG343VW与ENTITYITEMRELATIONVW一致
create or replace view ig.ig343 as 
select ei.eiid, ei.einame, eir1.pareiid, ci.cid, ci.civalue, ci.esyscoding as esyscoding, ci1.ciid as ciid1, 
(case ci1.civalue when '很好' then 3 when '好' then 2 when '一般' then 1 else 0 end) as civalue1, ci2.ciid as ciid2, 
ci2.civalue as civalue2, ci2.esyscoding as esyscoding2, ci3.ciid as ciid3, 
(case ci3.civalue when '很好' then 3 when '好' then 2 when '一般' then 1 else 0 end) as civalue3, ei3.eiid as eiid3, 
ei3.einame as einame3, ci4.ciid as ciid4, (case ci4.civalue when '很好' then 3 when '好' then 2 when '一般' then 1 else 0 end ) as civalue4, 
ci4.esyscoding as esyscoding4 
from ig.soc0118 ei 
left join ig.soc0119 eir1 on (eir1.cldeiid = ei.eiid) and eir1.eirrelationcode = '005-009' 
left join ig.soc0118 ei1 on ei1.eiid = eir1.pareiid and ei1.esyscoding like '999009001%' 
left join (select * from ig.soc0107 c where c.cid = 'CI120000000004' and c.civalue like '001%') ci on (ci.eiid = ei1.eiid) 
left join ig.soc0107 ci1 on ci1.eiid = ci.eiid and ci1.cid = 'CI120000010005' 
left join ig.soc0118 ei2 on ei2.eiid = eir1.pareiid and ei2.esyscoding like '999009001%' 
left join (select * from ig.soc0107 c where c.cid = 'CI120000000004' and c.civalue like '003%') ci2 on (ci2.eiid = ei2.eiid) 
left join ig.soc0107 ci3 on ci3.eiid = ci2.eiid and ci3.cid = 'CI120000010005' 
left join ig.soc0118 ei3 on (ei3.eiid = eir1.pareiid) and ei3.esyscoding like '999009002%' 
left join ig.soc0107 ci4 on (ci4.eiid = ei3.eiid) and ci4.cid = 'CI120000010005'  
where ei.esyscoding like '999005%';

--IG344VW与ENTITYITEMRELATIONDETAILVW一致
create or replace view ig.ig344 as 
select ei.eiid,	
       ei.einame, 
       ei.eilabel, 
       ei.eiinsdate, 
       eir.cldeiid, 
       ci.civalue, 
       ci1.civalue as civalue1,	
       ci2.civalue as civalue2, 
       (case ci2.civalue when '很好' then 3 when '好' then 2 when '一般' then 1 else 0 end) as civalue3 
from ig.soc0118 ei 
left join ig.soc0119 eir on eir.pareiid = ei.eiid and eir.eirrelationcode = '005-009' 
left join ig.soc0107 ci on ci.eiid = eir.pareiid and ci.cid = 'CI120000010010' 
left join ig.soc0107 ci1 on ci1.eiid = eir.pareiid and ci1.cid = 'CI120000000009' 
left join ig.soc0107 ci2 on ci2.eiid = eir.pareiid and ci2.cid = 'CI120000010005' 
where ei.esyscoding like '999009%';
