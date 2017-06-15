--修改检查问题流程后处理
insert into IG413(pedid,pdid,psdid,pedtype,pedblid,pedorder) values('0102108005001','0102108','0102108005','1','igEVENT9904BL',1);

--发生地点更改类型，初始值。如果初始值为空，则需要在表单设置中点击包含空行
update ig007 set pidtype='2',pidoption = '中心机房#灾备机房 #异地机房',piduse = '1',piddisplay = '1' where pidid = '0138601008';
--更改影响范围的类型和初始值。如果初始值为空，则需要在表单设置中点击包含空行
update ig007 set pidtype='2',pidoption = '全行#分行#支行#分理处 ',piduse = '1',piddisplay = '1' where pidid = '0138601009';
--更改风险描述为不必填
update ig699 set pidrequired = '0' where pdvid = '0138601003010';
--删除业务受影响范围表单
delete from ig007 where pidid = '0138601012';
--在宣告节点更改为可见和必填
update ig699 set pidaccess = '3',pidrequired = '1' where pidid ='0138601026' and psdid = '0138601004';

--新增表应急指挥流程备选场景
CREATE TABLE OPTIONSENCES
(
	OSID INTEGER NOT NULL,
	PRID INTEGER,
	SENCEEIID INTEGER,
	FINGERPRINT VARCHAR(256),
	PRIMARY KEY (OSID)
);