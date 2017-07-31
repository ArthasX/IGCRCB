
/* Drop Tables */

DROP TABLE WORKDEFINITION;
DROP TABLE WORKINSTANCE;
DROP TABLE WORKLOG;

/* Create Tables */

-- 工作定义表
CREATE TABLE WORKDEFINITION
(
	-- 主键
	WDID INTEGER NOT NULL,
	-- 工作项名称
	WDNAME VARCHAR(128),
	-- 发起人（userid）
	INITIATORID VARCHAR(128),
	-- 周期/频率
	CYCLE VARCHAR(16),
	-- 发起时间
	WDCREATETIME VARCHAR(20),
	-- 工作项描述
	DESCRIPTION VARCHAR(4000),
	-- 开始日期
	BEGINDATE VARCHAR(20),
	-- 结束日期
	ENDDATE VARCHAR(20),
	-- 预计完成日期
	ESTIMATEFINISHDATE VARCHAR(20),
	-- 实际完成日期
	ACTUALFINISHDATE VARCHAR(20),
	-- 超时提醒时间（天）
	OVERTIMETIPSTIME VARCHAR(16),
	-- 超时停止处理时间（天）
	OVERTIMESTOPDEALTIME VARCHAR(16),
	-- 负责人（userid）
	LEADERID VARCHAR(128),
	-- 负责人（username）
	LEADERNAME VARCHAR(128),
	-- 执行人id（userid,userid,userid,...）
	EXCUTORID VARCHAR(4000),
	-- 执行人name（username,username,username,...）
	EXCUTORNAME VARCHAR(4000),
	-- 启用状态（0，未启用；1，已启用）
	WDSTATUS VARCHAR(16),
	-- 月
	WDMONTH VARCHAR(16),
	-- 每月最后一天发起（Y，是；N；否）
	MONTHLASTDAY VARCHAR(16),
	-- 周
	WDWEEK VARCHAR(16),
	-- 时
	WDHOUR VARCHAR(16),
	-- 分
	WDMINUTE VARCHAR(16),
	-- 是否短信通知（Y,是；N，否）
	ISMSGNOTICE VARCHAR(16),
	-- 备注
	REMARKS VARCHAR(4000),
	-- 表记录创建日期
	CRTDATE VARCHAR(20),
	FINGERPRINT VARCHAR(256),
	-- 预留字段
	RESERVEDFILED VARCHAR(128),
	PRIMARY KEY (WDID)
);


-- 工作实例表
CREATE TABLE WORKINSTANCE
(
	-- 工作实例主键
	WIID INTEGER NOT NULL,
	-- 工作项定义id（工作项表wdid）
	WDID INTEGER,
	--工作项名称
	wdname VARCHAR(128),
	--工作实例名称
	winame VARCHAR(128),
	-- 工作状态（0，未执行；1，执行中，12，已执行；3，结束；4，中止；）
	WISTATUS VARCHAR(16),
	--发起人
	initiatorId VARCHAR(16),
	-- 周期/频率
	CYCLE VARCHAR(16),
	-- 工作项描述
	DESCRIPTION VARCHAR(4000),
	-- 开始日期
	BEGINDATE VARCHAR(20),
	-- 负责人（userid）
	LEADERID VARCHAR(128),
	-- 负责人（username）
	LEADERNAME VARCHAR(128),
	-- 执行人id（userid,userid,userid,...）
	EXCUTORID VARCHAR(4000),
	-- 执行人name（username,username,username,...）
	EXCUTORNAME VARCHAR(4000),
	-- 发起类型（1，自动发起；2，手动发起）
	WILUNCHTYPE VARCHAR(16),
	-- 执行需所时间（小时）
	EXCUTETIME VARCHAR(16),
	-- 执行情况描述
	WIDESCRIPTION VARCHAR(4000),
	-- 工作确认日期
	CONFIRMDATE VARCHAR(20),
	-- 日期栏日期
	TITLEDATE VARCHAR(20),
	-- 表记录创建日期
	CRTDATE VARCHAR(20),
	FINGERPRINT VARCHAR(256),
	CONSTRAINT FK_WORKINSTANCE PRIMARY KEY (WIID),
	FOREIGN KEY (WDID) REFERENCES WORKDEFINITION (WDID) ON DELETE CASCADE
);


-- 工作日志表
CREATE TABLE WORKLOG
(
	-- 工作日志主键
	WLID INTEGER NOT NULL,
	-- 外键（工作实例wiid）
	WIID INTEGER,
	--执行人
	excutorId VARCHAR(4000),
	--执行人名称
	excutorName VARCHAR(4000),
	-- 日期栏日期
	TITLEDATE VARCHAR(20),
	-- 执行需所时间（小时）
	EXCUTETIME VARCHAR(16),
	-- 实际处理日期
	ACTUALDEALWITHDATE VARCHAR(20),
	-- 执行情况描述
	WLDESCRIPTION VARCHAR(4000),
	-- 表记录创建日期
	CRTDATE VARCHAR(20),
	FINGERPRINT VARCHAR(256),
	-- 按钮动作
	BTNACTION VARCHAR(32),
	CONSTRAINT FK_WORKLOG PRIMARY KEY (WLID),
	FOREIGN KEY (WIID) REFERENCES WORKINSTANCE (WIID)  ON DELETE CASCADE
);

--注释
COMMENT ON TABLE WorkDefinition IS '工作定义表'; 
--COMMENT ON COLUMN WorkDefinition.wdid		            is '主键';
--COMMENT ON COLUMN WorkDefinition.wdname		            is '工作项名称';
--COMMENT ON COLUMN WorkDefinition.initiatorId	            is '发起人（userid）';
--COMMENT ON COLUMN WorkDefinition.cycle		            is '周期/频率';
--COMMENT ON COLUMN WorkDefinition.wdcreateTime            is '发起时间';
--COMMENT ON COLUMN WorkDefinition.description	            is '工作项描述';
--COMMENT ON COLUMN WorkDefinition.beginDate	            is '开始日期';
--COMMENT ON COLUMN WorkDefinition.endDate		            is '结束日期';
--COMMENT ON COLUMN WorkDefinition.estimateFinishDate		is '预计完成日期';
--COMMENT ON COLUMN WorkDefinition.actualFinishDate		is '实际完成日期';
--COMMENT ON COLUMN WorkDefinition.overtimeTipsTime		is '超时提醒时间（天）';
--COMMENT ON COLUMN WorkDefinition.overtimeStopDealTime		is '超时停止处理时间（天）';
--COMMENT ON COLUMN WorkDefinition.LeaderId		        is '负责人（userid）';
--COMMENT ON COLUMN WorkDefinition.leaderName		        is '负责人（username）';
--COMMENT ON COLUMN WorkDefinition.excutorId		        is '执行人（userid,userid,userid,...）';
--COMMENT ON COLUMN WorkDefinition.excutorName		        is '执行人（username,username,username,...）';
--COMMENT ON COLUMN WorkDefinition.wdstatus		        is '启用状态（0，未启用；1，已启用）';
--COMMENT ON COLUMN WorkDefinition.wdmonth		            is '月';
--COMMENT ON COLUMN WorkDefinition.monthLastDay	        is '每月最后一天发起（Y，是；N；否）';
--COMMENT ON COLUMN WorkDefinition.wdweek		            is '周';
--COMMENT ON COLUMN WorkDefinition.wdhour		            is '时';
--COMMENT ON COLUMN WorkDefinition.wdminute		        is '分';
--COMMENT ON COLUMN WorkDefinition.isMsgNotice		        is '是否短信通知（Y,是；N，否）';
--COMMENT ON COLUMN WorkDefinition.remarks		            is '备注';
--COMMENT ON COLUMN WorkDefinition.crtDate		            is '表记录创建日期';
--COMMENT ON COLUMN WorkDefinition.reservedFiled		    is '预留字段';

COMMENT ON TABLE  workInstance IS '工作实例表'; 
--COMMENT ON COLUMN workInstance.wiid		       is '工作实例主键';
--COMMENT ON COLUMN workInstance.wdid		       is '工作项定义id（工作项表wdid）';
--COMMENT ON COLUMN workInstance.winame		       is '工作实例名称';
--COMMENT ON COLUMN workInstance.wistatus		   is '工作状态（0，未执行；1，执行中，2，已执行；3，结束；4，中止；）';
--COMMENT ON COLUMN workInstance.wiDepartmentid	   is '部门（id）';
--COMMENT ON COLUMN workInstance.wiuserid		   is '人员（userid）';
--COMMENT ON COLUMN workInstance.wiLunchType		   is '发起类型（1，自动发起；2，手动发起）';
--COMMENT ON COLUMN workInstance.excuteTime		   is '执行需所时间（小时）';
--COMMENT ON COLUMN workInstance.actualDealwithDate is '实际处理日期';
--COMMENT ON COLUMN workInstance.confirmDate		   is '工作确认日期';
--COMMENT ON COLUMN workInstance.wiDescription	   is '执行情况描述';
--COMMENT ON COLUMN workInstance.btnAction		   is '按钮动作';
--COMMENT ON COLUMN workInstance.titleDate		   is '日期栏日期';
--COMMENT ON COLUMN workInstance.crtDate		       is '表记录创建日期';
--COMMENT ON COLUMN workInstance.reservedFiled	   is '预留字段';

COMMENT ON TABLE  workLog IS '工作日志表'; 
--COMMENT ON COLUMN workLog.wlid		      is '工作日志主键';
--COMMENT ON COLUMN workLog.wiid		      is '外键（工作实例wiid）';
--COMMENT ON COLUMN workLog.wlname		      is '工作日志名称';
--COMMENT ON COLUMN workLog.excutorId		  is '执行人（userid）';
--COMMENT ON COLUMN workLog.operation		  is '操作';
--COMMENT ON COLUMN workLog.titleDate		  is '日期栏日期';
--COMMENT ON COLUMN workLog.excuteTime		  is '执行时间';
--COMMENT ON COLUMN workLog.ACTUALDEALWITHDATE is '实际处理日期';
--COMMENT ON COLUMN workLog.wlDescription	  is '执行情况描述';
--COMMENT ON COLUMN workLog.crtDate		      is '表记录创建日期';
--COMMENT ON COLUMN workLog.reservedFiled	  is '预留字段';


--[工作项短信提醒开关]基础数据分类脚本
INSERT INTO CODECATEGORY
(CCID, CCNAME, CCINFO, CCEDITABLE, PCCID, PCFLAG, FINGERPRINT)
VALUES('177','工作项短信提醒开关', NULL, '3', NULL, '0', NULL);

--[工作项短信提醒开关]基础数据详细脚本
INSERT INTO CODEDETAIL
(CCID, CID, CVALUE, PCCID, PCID, UPDTIME, SYSCODING, PSYSCODING, CDSTATUS, BUSINESSCODE, FINGERPRINT, CDINFO, CDORDER)
VALUES('177', '6', '0', NULL, NULL, '20170621 1632', NULL, NULL, NULL, NULL, NULL, NULL, NULL);

--[短信提醒时间]基础数据分类脚本
INSERT INTO CODECATEGORY
(CCID, CCNAME, CCINFO, CCEDITABLE, PCCID, PCFLAG, FINGERPRINT)
VALUES('178', '短信提醒时间（时）', NULL, '3', NULL, '0', NULL);

--[短信提醒时间]基础数据详细脚本
INSERT INTO CODEDETAIL
(CCID, CID, CVALUE, PCCID, PCID, UPDTIME, SYSCODING, PSYSCODING, CDSTATUS, BUSINESSCODE, FINGERPRINT, CDINFO, CDORDER)
VALUES('178', '1', '8', NULL, NULL, '2010/01/01 00:00', NULL, NULL, NULL, NULL, NULL, '工作项模块工作项实例每日提醒时间（单位：时）', NULL);

--修改流程管理-个人工作菜单为工作管理
UPDATE ACTION SET ACTLABEL = '工作管理' WHERE ACTNAME = 'ACT02SVC08';

--工作项管理
INSERT INTO ACTION
(ACTNAME, ACTLABEL, ACTDESC, ACTURL, ACTTYPE, ACTL1ID, ACTL2ID, ACTL3ID, FINGERPRINT, ACTROLETYPE, ACTSORTID, ACTURLTYPE)
VALUES('ACT02SVC0803', '工作项管理', '', '/IGWIM0102.do', 'M3', NULL, NULL, NULL, '', 'IGBP01,IGBP07,IGBP21,IGBP22,IGBP23,IGBP24,IGBP25,IGBP26,IGBP27,IGBP28,IGBP31', '020803', '0');

--工作项查询
INSERT INTO ACTION
(ACTNAME, ACTLABEL, ACTDESC, ACTURL, ACTTYPE, ACTL1ID, ACTL2ID, ACTL3ID, FINGERPRINT, ACTROLETYPE, ACTSORTID, ACTURLTYPE)
VALUES('ACT02SVC0804', '工作项查询', '', '/IGWIM0102_Search.do', 'M3', NULL, NULL, NULL, '', 'IGBP01,IGBP07,IGBP21,IGBP22,IGBP23,IGBP24,IGBP25,IGBP26,IGBP27,IGBP28,IGBP31', '020804', '0');

--工作项定义
INSERT INTO ACTION
(ACTNAME, ACTLABEL, ACTDESC, ACTURL, ACTTYPE, ACTL1ID, ACTL2ID, ACTL3ID, FINGERPRINT, ACTROLETYPE, ACTSORTID, ACTURLTYPE)
VALUES('ACT02SVC0805', '工作项定义', '', '/IGWIM0101_Disp.do', 'M3', NULL, NULL, NULL, '', 'IGBP01,IGBP07,IGBP21,IGBP22,IGBP23,IGBP24,IGBP25,IGBP26,IGBP27,IGBP28,IGBP31', '020805', '0');

--工作查看
INSERT INTO ACTION
(ACTNAME, ACTLABEL, ACTDESC, ACTURL, ACTTYPE, ACTL1ID, ACTL2ID, ACTL3ID, FINGERPRINT, ACTROLETYPE, ACTSORTID, ACTURLTYPE)
VALUES('ACT02SVC0806', '工作查看', '', '/IGWIM0201_Disp.do', 'M3', NULL, NULL, NULL, '', 'IGBP01,IGBP07,IGBP21,IGBP22,IGBP23,IGBP24,IGBP25,IGBP26,IGBP27,IGBP28,IGBP31', '020806', '0');

--工作统计分析
INSERT INTO ACTION
(ACTNAME, ACTLABEL, ACTDESC, ACTURL, ACTTYPE, ACTL1ID, ACTL2ID, ACTL3ID, FINGERPRINT, ACTROLETYPE, ACTSORTID, ACTURLTYPE)
VALUES('ACT02SVC0807', '工作统计分析', '', '/IGWIM0201_Count.do', 'M3', NULL, NULL, NULL, '', 'IGBP01,IGBP07,IGBP21,IGBP22,IGBP23,IGBP24,IGBP25,IGBP26,IGBP27,IGBP28,IGBP31', '020807', '0');

--更新工作项管理下菜单
update action set acturl='/IGCOM0202.do?linkID=IGWIM0101' where actname ='ACT02SVC0803';
update action set acturl='/IGCOM0202.do?linkID=IGWIM0102' where actname ='ACT02SVC0804';
update action set acturl='/IGCOM0202.do?linkID=IGWIM0201' where actname ='ACT02SVC0805';
update action set acturl='/IGCOM0202.do?linkID=IGWIM0202' where actname ='ACT02SVC0806';
update action set acturl='/IGCOM0202.do?linkID=IGWIM0301' where actname ='ACT02SVC0807';

