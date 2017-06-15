--修改历史数据
update ig007 set pidmode = '0' where pidname = '跃迁条件';
update ig333 set psdtype = '0' where psdid = '';
--更改节点状态
alter table ig333 alter psdcode set data type varchar(2);
alter table ig500 alter prstatus set data type varchar(2);
alter table ig337 alter ppstatus set data type varchar(2);
alter table ig036 alter psdcode set data type varchar(2);
alter table ig224 alter prstatus set data type varchar(2);


--演练报告查询菜单以及演练报告--》演练报告发起
INSERT INTO ACTION
(ACTNAME, ACTLABEL, ACTDESC, ACTURL, ACTTYPE, ACTL1ID, ACTL2ID, ACTL3ID, FINGERPRINT, ACTROLETYPE, ACTSORTID, ACTURLTYPE)
VALUES('ACT29DRM0605', '演练报告查询', NULL, '/IGCOM0202.do?linkID=IGWKM0103&prpdid=01260&prtype=WD', 'M3', NULL, NULL, NULL, NULL, 'IGBP50', '080606', '0');

update action set actlabel = '演练报告发起',actsortid ='080605' where actname = 'ACT29DRM0606';





--20160829 评估查询
update action set acturl = '/IGCOM0202.do?linkID=IGDRM0704' where actname = 'ACT29DRM0902';
--20160830 演练处置菜单
INSERT INTO ACTION (actname,actlabel,acturl,acttype,actroletype,actsortid,acturltype)values('ACT29DRM0610','演练处置','/IGCOM0202.do?linkID=IGDRM1902&prtype=WDP','M3','IGBP50','080610','0');