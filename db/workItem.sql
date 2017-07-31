
/* Drop Tables */

DROP TABLE WORKDEFINITION;
DROP TABLE WORKINSTANCE;
DROP TABLE WORKLOG;

/* Create Tables */

-- ���������
CREATE TABLE WORKDEFINITION
(
	-- ����
	WDID INTEGER NOT NULL,
	-- ����������
	WDNAME VARCHAR(128),
	-- �����ˣ�userid��
	INITIATORID VARCHAR(128),
	-- ����/Ƶ��
	CYCLE VARCHAR(16),
	-- ����ʱ��
	WDCREATETIME VARCHAR(20),
	-- ����������
	DESCRIPTION VARCHAR(4000),
	-- ��ʼ����
	BEGINDATE VARCHAR(20),
	-- ��������
	ENDDATE VARCHAR(20),
	-- Ԥ���������
	ESTIMATEFINISHDATE VARCHAR(20),
	-- ʵ���������
	ACTUALFINISHDATE VARCHAR(20),
	-- ��ʱ����ʱ�䣨�죩
	OVERTIMETIPSTIME VARCHAR(16),
	-- ��ʱֹͣ����ʱ�䣨�죩
	OVERTIMESTOPDEALTIME VARCHAR(16),
	-- �����ˣ�userid��
	LEADERID VARCHAR(128),
	-- �����ˣ�username��
	LEADERNAME VARCHAR(128),
	-- ִ����id��userid,userid,userid,...��
	EXCUTORID VARCHAR(4000),
	-- ִ����name��username,username,username,...��
	EXCUTORNAME VARCHAR(4000),
	-- ����״̬��0��δ���ã�1�������ã�
	WDSTATUS VARCHAR(16),
	-- ��
	WDMONTH VARCHAR(16),
	-- ÿ�����һ�췢��Y���ǣ�N����
	MONTHLASTDAY VARCHAR(16),
	-- ��
	WDWEEK VARCHAR(16),
	-- ʱ
	WDHOUR VARCHAR(16),
	-- ��
	WDMINUTE VARCHAR(16),
	-- �Ƿ����֪ͨ��Y,�ǣ�N����
	ISMSGNOTICE VARCHAR(16),
	-- ��ע
	REMARKS VARCHAR(4000),
	-- ���¼��������
	CRTDATE VARCHAR(20),
	FINGERPRINT VARCHAR(256),
	-- Ԥ���ֶ�
	RESERVEDFILED VARCHAR(128),
	PRIMARY KEY (WDID)
);


-- ����ʵ����
CREATE TABLE WORKINSTANCE
(
	-- ����ʵ������
	WIID INTEGER NOT NULL,
	-- �������id���������wdid��
	WDID INTEGER,
	--����������
	wdname VARCHAR(128),
	--����ʵ������
	winame VARCHAR(128),
	-- ����״̬��0��δִ�У�1��ִ���У�12����ִ�У�3��������4����ֹ����
	WISTATUS VARCHAR(16),
	--������
	initiatorId VARCHAR(16),
	-- ����/Ƶ��
	CYCLE VARCHAR(16),
	-- ����������
	DESCRIPTION VARCHAR(4000),
	-- ��ʼ����
	BEGINDATE VARCHAR(20),
	-- �����ˣ�userid��
	LEADERID VARCHAR(128),
	-- �����ˣ�username��
	LEADERNAME VARCHAR(128),
	-- ִ����id��userid,userid,userid,...��
	EXCUTORID VARCHAR(4000),
	-- ִ����name��username,username,username,...��
	EXCUTORNAME VARCHAR(4000),
	-- �������ͣ�1���Զ�����2���ֶ�����
	WILUNCHTYPE VARCHAR(16),
	-- ִ������ʱ�䣨Сʱ��
	EXCUTETIME VARCHAR(16),
	-- ִ���������
	WIDESCRIPTION VARCHAR(4000),
	-- ����ȷ������
	CONFIRMDATE VARCHAR(20),
	-- ����������
	TITLEDATE VARCHAR(20),
	-- ���¼��������
	CRTDATE VARCHAR(20),
	FINGERPRINT VARCHAR(256),
	CONSTRAINT FK_WORKINSTANCE PRIMARY KEY (WIID),
	FOREIGN KEY (WDID) REFERENCES WORKDEFINITION (WDID) ON DELETE CASCADE
);


-- ������־��
CREATE TABLE WORKLOG
(
	-- ������־����
	WLID INTEGER NOT NULL,
	-- ���������ʵ��wiid��
	WIID INTEGER,
	--ִ����
	excutorId VARCHAR(4000),
	--ִ��������
	excutorName VARCHAR(4000),
	-- ����������
	TITLEDATE VARCHAR(20),
	-- ִ������ʱ�䣨Сʱ��
	EXCUTETIME VARCHAR(16),
	-- ʵ�ʴ�������
	ACTUALDEALWITHDATE VARCHAR(20),
	-- ִ���������
	WLDESCRIPTION VARCHAR(4000),
	-- ���¼��������
	CRTDATE VARCHAR(20),
	FINGERPRINT VARCHAR(256),
	-- ��ť����
	BTNACTION VARCHAR(32),
	CONSTRAINT FK_WORKLOG PRIMARY KEY (WLID),
	FOREIGN KEY (WIID) REFERENCES WORKINSTANCE (WIID)  ON DELETE CASCADE
);

--ע��
COMMENT ON TABLE WorkDefinition IS '���������'; 
--COMMENT ON COLUMN WorkDefinition.wdid		            is '����';
--COMMENT ON COLUMN WorkDefinition.wdname		            is '����������';
--COMMENT ON COLUMN WorkDefinition.initiatorId	            is '�����ˣ�userid��';
--COMMENT ON COLUMN WorkDefinition.cycle		            is '����/Ƶ��';
--COMMENT ON COLUMN WorkDefinition.wdcreateTime            is '����ʱ��';
--COMMENT ON COLUMN WorkDefinition.description	            is '����������';
--COMMENT ON COLUMN WorkDefinition.beginDate	            is '��ʼ����';
--COMMENT ON COLUMN WorkDefinition.endDate		            is '��������';
--COMMENT ON COLUMN WorkDefinition.estimateFinishDate		is 'Ԥ���������';
--COMMENT ON COLUMN WorkDefinition.actualFinishDate		is 'ʵ���������';
--COMMENT ON COLUMN WorkDefinition.overtimeTipsTime		is '��ʱ����ʱ�䣨�죩';
--COMMENT ON COLUMN WorkDefinition.overtimeStopDealTime		is '��ʱֹͣ����ʱ�䣨�죩';
--COMMENT ON COLUMN WorkDefinition.LeaderId		        is '�����ˣ�userid��';
--COMMENT ON COLUMN WorkDefinition.leaderName		        is '�����ˣ�username��';
--COMMENT ON COLUMN WorkDefinition.excutorId		        is 'ִ���ˣ�userid,userid,userid,...��';
--COMMENT ON COLUMN WorkDefinition.excutorName		        is 'ִ���ˣ�username,username,username,...��';
--COMMENT ON COLUMN WorkDefinition.wdstatus		        is '����״̬��0��δ���ã�1�������ã�';
--COMMENT ON COLUMN WorkDefinition.wdmonth		            is '��';
--COMMENT ON COLUMN WorkDefinition.monthLastDay	        is 'ÿ�����һ�췢��Y���ǣ�N����';
--COMMENT ON COLUMN WorkDefinition.wdweek		            is '��';
--COMMENT ON COLUMN WorkDefinition.wdhour		            is 'ʱ';
--COMMENT ON COLUMN WorkDefinition.wdminute		        is '��';
--COMMENT ON COLUMN WorkDefinition.isMsgNotice		        is '�Ƿ����֪ͨ��Y,�ǣ�N����';
--COMMENT ON COLUMN WorkDefinition.remarks		            is '��ע';
--COMMENT ON COLUMN WorkDefinition.crtDate		            is '���¼��������';
--COMMENT ON COLUMN WorkDefinition.reservedFiled		    is 'Ԥ���ֶ�';

COMMENT ON TABLE  workInstance IS '����ʵ����'; 
--COMMENT ON COLUMN workInstance.wiid		       is '����ʵ������';
--COMMENT ON COLUMN workInstance.wdid		       is '�������id���������wdid��';
--COMMENT ON COLUMN workInstance.winame		       is '����ʵ������';
--COMMENT ON COLUMN workInstance.wistatus		   is '����״̬��0��δִ�У�1��ִ���У�2����ִ�У�3��������4����ֹ����';
--COMMENT ON COLUMN workInstance.wiDepartmentid	   is '���ţ�id��';
--COMMENT ON COLUMN workInstance.wiuserid		   is '��Ա��userid��';
--COMMENT ON COLUMN workInstance.wiLunchType		   is '�������ͣ�1���Զ�����2���ֶ�����';
--COMMENT ON COLUMN workInstance.excuteTime		   is 'ִ������ʱ�䣨Сʱ��';
--COMMENT ON COLUMN workInstance.actualDealwithDate is 'ʵ�ʴ�������';
--COMMENT ON COLUMN workInstance.confirmDate		   is '����ȷ������';
--COMMENT ON COLUMN workInstance.wiDescription	   is 'ִ���������';
--COMMENT ON COLUMN workInstance.btnAction		   is '��ť����';
--COMMENT ON COLUMN workInstance.titleDate		   is '����������';
--COMMENT ON COLUMN workInstance.crtDate		       is '���¼��������';
--COMMENT ON COLUMN workInstance.reservedFiled	   is 'Ԥ���ֶ�';

COMMENT ON TABLE  workLog IS '������־��'; 
--COMMENT ON COLUMN workLog.wlid		      is '������־����';
--COMMENT ON COLUMN workLog.wiid		      is '���������ʵ��wiid��';
--COMMENT ON COLUMN workLog.wlname		      is '������־����';
--COMMENT ON COLUMN workLog.excutorId		  is 'ִ���ˣ�userid��';
--COMMENT ON COLUMN workLog.operation		  is '����';
--COMMENT ON COLUMN workLog.titleDate		  is '����������';
--COMMENT ON COLUMN workLog.excuteTime		  is 'ִ��ʱ��';
--COMMENT ON COLUMN workLog.ACTUALDEALWITHDATE is 'ʵ�ʴ�������';
--COMMENT ON COLUMN workLog.wlDescription	  is 'ִ���������';
--COMMENT ON COLUMN workLog.crtDate		      is '���¼��������';
--COMMENT ON COLUMN workLog.reservedFiled	  is 'Ԥ���ֶ�';


--[������������ѿ���]�������ݷ���ű�
INSERT INTO CODECATEGORY
(CCID, CCNAME, CCINFO, CCEDITABLE, PCCID, PCFLAG, FINGERPRINT)
VALUES('177','������������ѿ���', NULL, '3', NULL, '0', NULL);

--[������������ѿ���]����������ϸ�ű�
INSERT INTO CODEDETAIL
(CCID, CID, CVALUE, PCCID, PCID, UPDTIME, SYSCODING, PSYSCODING, CDSTATUS, BUSINESSCODE, FINGERPRINT, CDINFO, CDORDER)
VALUES('177', '6', '0', NULL, NULL, '20170621 1632', NULL, NULL, NULL, NULL, NULL, NULL, NULL);

--[��������ʱ��]�������ݷ���ű�
INSERT INTO CODECATEGORY
(CCID, CCNAME, CCINFO, CCEDITABLE, PCCID, PCFLAG, FINGERPRINT)
VALUES('178', '��������ʱ�䣨ʱ��', NULL, '3', NULL, '0', NULL);

--[��������ʱ��]����������ϸ�ű�
INSERT INTO CODEDETAIL
(CCID, CID, CVALUE, PCCID, PCID, UPDTIME, SYSCODING, PSYSCODING, CDSTATUS, BUSINESSCODE, FINGERPRINT, CDINFO, CDORDER)
VALUES('178', '1', '8', NULL, NULL, '2010/01/01 00:00', NULL, NULL, NULL, NULL, NULL, '������ģ�鹤����ʵ��ÿ������ʱ�䣨��λ��ʱ��', NULL);

--�޸����̹���-���˹����˵�Ϊ��������
UPDATE ACTION SET ACTLABEL = '��������' WHERE ACTNAME = 'ACT02SVC08';

--���������
INSERT INTO ACTION
(ACTNAME, ACTLABEL, ACTDESC, ACTURL, ACTTYPE, ACTL1ID, ACTL2ID, ACTL3ID, FINGERPRINT, ACTROLETYPE, ACTSORTID, ACTURLTYPE)
VALUES('ACT02SVC0803', '���������', '', '/IGWIM0102.do', 'M3', NULL, NULL, NULL, '', 'IGBP01,IGBP07,IGBP21,IGBP22,IGBP23,IGBP24,IGBP25,IGBP26,IGBP27,IGBP28,IGBP31', '020803', '0');

--�������ѯ
INSERT INTO ACTION
(ACTNAME, ACTLABEL, ACTDESC, ACTURL, ACTTYPE, ACTL1ID, ACTL2ID, ACTL3ID, FINGERPRINT, ACTROLETYPE, ACTSORTID, ACTURLTYPE)
VALUES('ACT02SVC0804', '�������ѯ', '', '/IGWIM0102_Search.do', 'M3', NULL, NULL, NULL, '', 'IGBP01,IGBP07,IGBP21,IGBP22,IGBP23,IGBP24,IGBP25,IGBP26,IGBP27,IGBP28,IGBP31', '020804', '0');

--�������
INSERT INTO ACTION
(ACTNAME, ACTLABEL, ACTDESC, ACTURL, ACTTYPE, ACTL1ID, ACTL2ID, ACTL3ID, FINGERPRINT, ACTROLETYPE, ACTSORTID, ACTURLTYPE)
VALUES('ACT02SVC0805', '�������', '', '/IGWIM0101_Disp.do', 'M3', NULL, NULL, NULL, '', 'IGBP01,IGBP07,IGBP21,IGBP22,IGBP23,IGBP24,IGBP25,IGBP26,IGBP27,IGBP28,IGBP31', '020805', '0');

--�����鿴
INSERT INTO ACTION
(ACTNAME, ACTLABEL, ACTDESC, ACTURL, ACTTYPE, ACTL1ID, ACTL2ID, ACTL3ID, FINGERPRINT, ACTROLETYPE, ACTSORTID, ACTURLTYPE)
VALUES('ACT02SVC0806', '�����鿴', '', '/IGWIM0201_Disp.do', 'M3', NULL, NULL, NULL, '', 'IGBP01,IGBP07,IGBP21,IGBP22,IGBP23,IGBP24,IGBP25,IGBP26,IGBP27,IGBP28,IGBP31', '020806', '0');

--����ͳ�Ʒ���
INSERT INTO ACTION
(ACTNAME, ACTLABEL, ACTDESC, ACTURL, ACTTYPE, ACTL1ID, ACTL2ID, ACTL3ID, FINGERPRINT, ACTROLETYPE, ACTSORTID, ACTURLTYPE)
VALUES('ACT02SVC0807', '����ͳ�Ʒ���', '', '/IGWIM0201_Count.do', 'M3', NULL, NULL, NULL, '', 'IGBP01,IGBP07,IGBP21,IGBP22,IGBP23,IGBP24,IGBP25,IGBP26,IGBP27,IGBP28,IGBP31', '020807', '0');

--���¹���������²˵�
update action set acturl='/IGCOM0202.do?linkID=IGWIM0101' where actname ='ACT02SVC0803';
update action set acturl='/IGCOM0202.do?linkID=IGWIM0102' where actname ='ACT02SVC0804';
update action set acturl='/IGCOM0202.do?linkID=IGWIM0201' where actname ='ACT02SVC0805';
update action set acturl='/IGCOM0202.do?linkID=IGWIM0202' where actname ='ACT02SVC0806';
update action set acturl='/IGCOM0202.do?linkID=IGWIM0301' where actname ='ACT02SVC0807';

