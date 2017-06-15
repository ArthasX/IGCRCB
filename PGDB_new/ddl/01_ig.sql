CREATE TABLESPACE IG_SPACE OWNER postgres LOCATION '/opt/PostgreSQL/9.2/tablespace/IG_SPACE';

CREATE TABLE "ig".Role
(
	roleid  INTEGER  NOT NULL,
	rolename  VARCHAR(64),
	roledesc  VARCHAR(128),
	roleinfo  VARCHAR(256),
	roletype VARCHAR(8),
	roledomain  VARCHAR(32),
	assetdomain  VARCHAR(32),
	fingerprint varchar(256),
	 PRIMARY KEY (roleid)
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".Action
(
	actname VARCHAR(32) NOT NULL,
	actlabel  VARCHAR(32),
	actdesc  VARCHAR(128),
	acturl  VARCHAR(64),
	acttype  CHAR(2),
	actl1id  INTEGER,
	actl2id  INTEGER,
	actl3id  INTEGER,
	fingerprint varchar(256) ,
	actroletype  VARCHAR(256),
	actsortid  VARCHAR(8),
	acturltype VARCHAR(8),
	PRIMARY KEY (actname)
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".RoleAction
(
	raid  INTEGER  NOT NULL,
	roleid  INTEGER  NOT NULL,
	actname VARCHAR(32) NOT NULL,
	raperm  VARCHAR(2),
	radesc  VARCHAR(64),
	fingerprint varchar(256),
	PRIMARY KEY (raid),
	FOREIGN KEY (roleid) REFERENCES "ig".Role(roleid)
		ON DELETE CASCADE,
	FOREIGN KEY (actname) REFERENCES "ig".Action(actname)
		ON DELETE CASCADE
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".Organization
(
	orgid  INTEGER  NOT NULL,
	orgname  VARCHAR(128),
	orgpar  VARCHAR(32),
	orgparname VARCHAR(128),
	orgdesc  VARCHAR(256),
	orgtype  CHAR(2),
	orgaddr  VARCHAR(128),
	orgphone  VARCHAR(20),
	orgfax  VARCHAR(20),
	orgcontact  VARCHAR(32),
	orgstatus  CHAR,
	orginfo  VARCHAR(256),
	orgsyscoding VARCHAR(32),
	orgusercoding VARCHAR(32),
	fingerprint varchar(256),
	PRIMARY KEY (orgid)
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".IgUser
(
	userid  VARCHAR(16)  NOT NULL,
	orgid  VARCHAR(32)  NOT NULL,
	orgname VARCHAR(128),
	username  VARCHAR(32),
	userdesc  VARCHAR(128),
	userinfo  VARCHAR(256),
	password  VARCHAR(64),
	userstatus  VARCHAR(6),
	usertype  VARCHAR(3),
	userphone  VARCHAR(16),
	usermobile  VARCHAR(16),
	useremail  VARCHAR(40),
	fingerprint VARCHAR(256),
    deleteflag CHAR,
	PRIMARY KEY (userid)
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".IG622
(
	HPID VARCHAR(3) NOT NULL,
	HPLABEL VARCHAR(32),
	HPTITLE VARCHAR(32),
	HPURL VARCHAR(32),
	FINGERPRINT VARCHAR(256),
	PRIMARY KEY (HPID)
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".UserRole
(
	urid  INTEGER  NOT NULL,
	userid  VARCHAR(16)  NOT NULL,
	orgid  VARCHAR(32)  NOT NULL,
	roleid  INTEGER  NOT NULL,
	fingerprint varchar(256),
	rolemanager  CHAR,
    dutyflag CHAR,
	PRIMARY KEY (urid),
	FOREIGN KEY (userid) REFERENCES "ig".IgUser(userid)
		ON DELETE CASCADE,
	FOREIGN KEY (roleid) REFERENCES "ig".Role(roleid)
		ON DELETE CASCADE
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".Notice
(
	nid  INTEGER NOT NULL,
	nname  VARCHAR(128),
	ndesc  VARCHAR(256),
	ntime  CHAR(16),
	nuserid VARCHAR(16),
	nusername VARCHAR(32),
	norgid VARCHAR(32),
	norgname VARCHAR(128),
	nattkey  VARCHAR(32),
	fingerprint varchar(256),
	PRIMARY KEY (nid)
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".CodeCategory (
    ccid VARCHAR(3) not null,
	ccname VARCHAR(128),
	ccinfo VARCHAR(40),
	cceditable CHAR,
	pccid VARCHAR(3),
	pcflag CHAR,
	fingerprint varchar(256),
	PRIMARY KEY (ccid)
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".CodeDetail (
    ccid VARCHAR(3) not null,
    cid VARCHAR(32) not null,
	cvalue VARCHAR(128),
	pccid VARCHAR(3),
	pcid VARCHAR(8),
	updtime VARCHAR(16),
	syscoding VARCHAR(32),
	psyscoding VARCHAR(32),
	cdstatus CHAR,
	businesscode VARCHAR(32),
	fingerprint varchar(256),
	cdinfo VARCHAR(512),
	cdorder INTEGER,
	PRIMARY KEY (ccid,cid)
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".CODECATEGORYDEF  (
	CCID VARCHAR(3) NOT NULL, 
	CCNAME VARCHAR(128), 
	CCINFO VARCHAR(40), 
	CCEDITABLE CHAR(1), 
	PCCID VARCHAR(3), 
	PCFLAG CHAR(1), 
	FINGERPRINT VARCHAR(256),
	PRIMARY KEY (ccid)
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".CODEDETAILDEF  (
	CCID VARCHAR(3) NOT NULL, 
	CID VARCHAR(8) NOT NULL, 
	CVALUE VARCHAR(64), 
	PCCID VARCHAR(3), 
	PCID VARCHAR(8), 
	UPDTIME VARCHAR(16), 
	SYSCODING VARCHAR(32), 
	PSYSCODING VARCHAR(32), 
	CDSTATUS CHAR(1), 
	BUSINESSCODE VARCHAR(32), 
	CDINFO VARCHAR(128),
	FINGERPRINT VARCHAR(256), 
	PRIMARY KEY (ccid,cid),
	FOREIGN KEY (ccid) REFERENCES "ig".CODECATEGORYDEF(ccid)
		ON DELETE CASCADE 
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".IG117
(
	eid  INTEGER  NOT NULL,
	ename  VARCHAR(128),
	elabel  VARCHAR(32),
	edesc  VARCHAR(256),
	estatus  CHAR,
	ecategory  VARCHAR(16),
	ekey1  VARCHAR(16),
	ekey2  VARCHAR(16),
	ekey3  VARCHAR(16),
	esyscoding  VARCHAR(128),
	eparcoding  VARCHAR(128),
	fingerprint varchar(256),
	emodeltype CHAR,
	PRIMARY KEY (eid)
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".IG225
(
	cid  INTEGER  NOT NULL,
	eid  INTEGER  NOT NULL,
	cname  VARCHAR(128),
	clabel  VARCHAR(32),
	cdesc  VARCHAR(40),
	cunit  VARCHAR(16),
	cstatus  CHAR,
	cseq  INTEGER,
	ccategory  VARCHAR(16),
	coption  VARCHAR(64),
	cattach CHAR,
	esyscoding VARCHAR(128),
	fingerprint varchar(256),
	crequired  VARCHAR(8),
	corder INTEGER,
	PRIMARY KEY (cid),
	FOREIGN KEY (eid) REFERENCES "ig".IG117(eid)
		ON DELETE CASCADE
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".IG545
(
	ccdid  INTEGER  NOT NULL,
	ccdcategory  VARCHAR(3),
	ccdlabel  VARCHAR(32),
	ccdvalue  VARCHAR(32),
	ccdstatus  CHAR,
	ccdtype  CHAR,
	ccdinfo  VARCHAR(64),
	fingerprint varchar(256),
	PRIMARY KEY (ccdid)
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".IG611
(
	EID INTEGER NOT NULL,
	CID INTEGER NOT NULL,
	CVALUE VARCHAR(2000),
	FINGERPRINT VARCHAR(256),
	PRIMARY KEY (EID, CID),
	FOREIGN KEY (EID) REFERENCES "ig".IG117(EID)
		ON DELETE CASCADE,
	FOREIGN KEY (CID) REFERENCES "ig".IG225(CID)
		ON DELETE CASCADE
) tablespace "IG_SPACE";

CREATE TABLE "ig".IG013
(
	eiid  INTEGER  NOT NULL,
	eid  INTEGER  NOT NULL,
	eidesc  VARCHAR(256),
	einame  VARCHAR(128),
	eilabel  VARCHAR(128),
	eiinsdate  CHAR(10),
	eiorgsyscoding VARCHAR(32),
	esyscoding VARCHAR(128),
	eiupdtime  CHAR(16),
	eistatus  CHAR,
	eiversion  INTEGER,
	fingerprint varchar(256),
	eiuserid VARCHAR (16),
	eiusername VARCHAR (32),
	eismallversion integer,
	eirootmark integer,
	PRIMARY KEY (eiid),
	FOREIGN KEY (eid) REFERENCES "ig".IG117(eid)
		ON DELETE CASCADE,
	FOREIGN KEY (eirootmark) REFERENCES "ig".IG013(eiid)
	ON DELETE CASCADE
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".IG800
(
	ciid  INTEGER  NOT NULL,
	cid  INTEGER  NOT NULL,
	eiid  INTEGER  NOT NULL,
	eid  INTEGER  NOT NULL,
	civalue  VARCHAR(2000),
	ciupdtime  CHAR(16),
	esyscoding VARCHAR(128),
	ciexpire  CHAR(16),
	cistatus  CHAR,
	cicurver  CHAR,
	civersion  INTEGER,
	civerinfo  VARCHAR(128),
	fingerprint varchar(256),
	cismallversion integer,
	PRIMARY KEY (ciid),
	FOREIGN KEY (cid) REFERENCES "ig".IG225(cid)
		ON DELETE CASCADE,
	FOREIGN KEY (eiid) REFERENCES "ig".IG013(eiid)
		ON DELETE CASCADE
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".IG313
(
	eirid  INTEGER  NOT NULL,
	pareiid  INTEGER  NOT NULL,
	pareid  INTEGER  NOT NULL,
	cldeiid  INTEGER  NOT NULL,
	cldeid  INTEGER  NOT NULL,
	eirrelation  VARCHAR(4),
	eirrelationcode  VARCHAR(32),
	eirupdtime  CHAR(16),
	eirstatus  CHAR,
	eirdesc  VARCHAR(256),
	fingerprint varchar(256),
	eirinfo VARCHAR (32),
	parversion integer,
	parsmallversion integer,
	cldversion integer,
	cldsmallversion integer,
	deleteflag char,
	PRIMARY KEY (eirid),
	FOREIGN KEY (pareiid) REFERENCES "ig".IG013(eiid)
		ON DELETE CASCADE,
	FOREIGN KEY (cldeiid) REFERENCES "ig".IG013(eiid)
		ON DELETE CASCADE
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".IG809
(
	eirfid  INTEGER  NOT NULL,
	eiid  INTEGER  NOT NULL,
	eirftype  VARCHAR(4),
	eirfname  CHAR(17),
	eirfupdtime  CHAR(16),
	fingerprint VARCHAR(256),
	PRIMARY KEY (eirfid),
	FOREIGN KEY (eiid) REFERENCES "ig".IG013(eiid)
		ON DELETE CASCADE
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".COLLECTPARAM
(
	CPTYPEID INTEGER NOT NULL,
	CPSMODE VARCHAR(32),
	CPSCRIPTNAME VARCHAR(32),
	CPFILEPATH VARCHAR(128),
	FINGERPRINT VARCHAR(256),
	PRIMARY KEY (CPTYPEID)
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".compareTemplate
(
	ctpid  INTEGER  NOT NULL,
	ctcategory	VARCHAR(32),
	cttype		VARCHAR(32),
	ctxwidth	VARCHAR(32),
	ctywidth	VARCHAR(32),
	ctvalue		VARCHAR(32),
	fingerprint VARCHAR(256),
	 PRIMARY KEY (ctid)
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".IG259
(
	ptid  INTEGER  NOT NULL,
	ptname  VARCHAR(128),
	pttype  VARCHAR(3),
	ptstartpg   VARCHAR(64),
	ptdetailpg   VARCHAR(64),
	ptcrtdate  Char(10),
	ptpicinfo  VARCHAR(32),
	ptstatus  CHAR,
	ptsavepg VARCHAR(64),
	ptqrtzflag VARCHAR(4) ,
	fingerprint varchar(256) ,
	PRIMARY KEY (ptid)
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".IG380
(
	pdid  CHAR(7)  NOT NULL,
	ptid  INTEGER  NOT NULL,
	pdname  VARCHAR(128),
	pddesc   VARCHAR(128),
	pdcrtdate  Char(10),
	pdstatus  CHAR,
	pdxml  text,
	permission VARCHAR(4),
	fingerprint varchar(256),
	serialgenerator varchar(32) ,
	pdactname varchar(32),
	PRIMARY KEY (pdid),
	FOREIGN KEY (ptid) REFERENCES "ig".IG259(ptid)
		ON DELETE CASCADE
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".IG007
(
	pidid  CHAR(10)  NOT NULL,
	pdid  CHAR(7)  NOT NULL,
	pidname  VARCHAR(128),
	pidlabel  VARCHAR(64),
	piddesc   VARCHAR(2000),
	pidtype  CHAR,
	pidoption  VARCHAR(1024),
	piddefault  VARCHAR(64),
	pidrequired  CHAR,
	fingerprint VARCHAR(256),
	pidsortid VARCHAR(8) ,
	ccid VARCHAR(32),
	pidgid  INTEGER,
	PIDMODE CHARACTER (1),
	PRIVATESCOPE VARCHAR (1),
	ROWWIDTH CHARACTER(1),
	PRIMARY KEY (pidid),
	FOREIGN KEY (pdid) REFERENCES "ig".IG380(pdid)
		ON DELETE CASCADE
) TABLESPACE "IG_SPACE";	

CREATE TABLE "ig".IG333
(
	psdid  CHAR(10)  NOT NULL,
	pdid   CHAR(7)  NOT NULL,
	psdname  VARCHAR(32),
	psddesc  VARCHAR(64),
	psdcode  CHAR,
	fingerPrint VARCHAR(256),
	psdtype VARCHAR(4),
	psdmode VARCHAR(4),
	psdflag CHAR,
	psdassign CHAR,
	psdorg CHAR,
	psdconfirm CHAR,
	assignpsdid VARCHAR(10),
	assignpbdid VARCHAR(2),
	assignflag VARCHAR(1),
	participantchange CHAR(1),
	assignpagetype CHAR(1),
	PRIMARY KEY (psdid),
	FOREIGN KEY (pdid) REFERENCES "ig".IG380(pdid)
		ON DELETE CASCADE
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".IG258
(
	pspcdid CHAR(13) NOT NULL,
	psdid CHAR(10),
	pspcdpsdid CHAR(10),
	fingerPrint VARCHAR(256),
	PRIMARY KEY (pspcdid),
	FOREIGN KEY (psdid) REFERENCES "ig".IG333(psdid)
		ON DELETE CASCADE,
	FOREIGN KEY (pspcdpsdid) REFERENCES "ig".IG333(psdid)
		ON DELETE CASCADE	
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".IG211
(
	psidid  CHAR(13)  NOT NULL,
	psdid   CHAR(10)  NOT NULL,
	pidid   CHAR(10)  NOT NULL,
	pidname  VARCHAR(128),
	pidlabel  VARCHAR(32),
	piddesc   VARCHAR(2000),
	pidtype  CHAR,
	pidvalue  VARCHAR(64),	
	pidattkey VARCHAR (32),
	fingerPrint VARCHAR(256),
	PRIMARY KEY (psidid),
	FOREIGN KEY (psdid) REFERENCES "ig".IG333(psdid)
		ON DELETE CASCADE,
	FOREIGN KEY (pidid) REFERENCES "ig".IG007(pidid)
		ON DELETE CASCADE
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".IG900
(
	pbdid   CHAR(2)  NOT NULL,
	pbdname   VARCHAR(32)  NOT NULL,
	pbdflag  CHAR(1),
	pbdimage  VARCHAR(16),
	fingerPrint VARCHAR(256),
	PRIMARY KEY (pbdid)
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".IG222
(
	ppdid   CHAR(13)  NOT NULL,
	psdid   CHAR(10)  NOT NULL,
	roleid  INTEGER  NOT NULL,
	userid     VARCHAR(16),
	ppdsuper  CHAR,
	fingerPrint VARCHAR(256),
	PRIMARY KEY (ppdid),
	FOREIGN KEY (psdid) REFERENCES "ig".IG333(psdid)
		ON DELETE CASCADE,
	FOREIGN KEY (roleid) REFERENCES "ig".Role(roleid)
		ON DELETE CASCADE
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".IG132
(
	ppbdid   CHAR(16)  NOT NULL,
	ppdid   CHAR(13)  NOT NULL,
	pbdid  CHAR(2) ,
	ppbdname  VARCHAR(32),
	ppbddesc  VARCHAR(64),
	ppbdauth CHAR(1),
	fingerPrint VARCHAR(256),
	PRIMARY KEY (ppbdid),
	FOREIGN KEY (ppdid) REFERENCES "ig".IG222(ppdid)
		ON DELETE CASCADE,
	FOREIGN KEY (pbdid) REFERENCES "ig".IG900(pbdid)
		ON DELETE CASCADE
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".IG881
(
	pipdid  CHAR(16)  NOT NULL,
	pidid   CHAR(10)  NOT NULL,
	psdid   CHAR(10)  NOT NULL,
	ppdid   CHAR(13)  NOT NULL,
	pidaccess CHAR,
	fingerPrint VARCHAR(256),
	PIDREQUIRED CHARACTER (1),
	PRIMARY KEY (pipdid),
	FOREIGN KEY (pidid) REFERENCES "ig".IG007(pidid)
		ON DELETE CASCADE,
	FOREIGN KEY (psdid) REFERENCES "ig".IG333(psdid)
		ON DELETE CASCADE,
	FOREIGN KEY (ppdid) REFERENCES "ig".IG222(ppdid)
		ON DELETE CASCADE
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".IG273
(
	ptdid   CHAR(10)  NOT NULL,
	fpsdid  CHAR(10)  NOT NULL,
	tpsdid  CHAR(10)  NOT NULL,
	ptdname VARCHAR(32),
	ptddesc VARCHAR(64),
	ptdtype CHAR,
	ptdcond VARCHAR(128),
	fingerPrint VARCHAR(256),
	PRIMARY KEY (ptdid),
	FOREIGN KEY (fpsdid) REFERENCES "ig".IG333(psdid)
		ON DELETE CASCADE,
	FOREIGN KEY (tpsdid) REFERENCES "ig".IG333(psdid)
		ON DELETE CASCADE
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".IG933
(
	sfid  INTEGER  NOT NULL,
	sfreportname  VARCHAR(32),
	sfreportphone   VARCHAR(16),
	sfreportorgid  VARCHAR(32),
	sftitle VARCHAR(128),
	sfdesc VARCHAR(2000),
	sfattkey VARCHAR(32),
	sfstatus VARCHAR(4),
	sftype VARCHAR(32),
	sforgid VARCHAR(32),
	sfeiid INTEGER,
	sfregisterid  VARCHAR(16),
	sfinstime CHAR(16),
	fingerprint varchar(256),
	SFCODE VARCHAR(11),
	SFSOURCE VARCHAR(4),
	SFWORKPHONE VARCHAR(16),
	SFEMAIL VARCHAR(40),
	PRIMARY KEY (sfid)
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".IG941
(
	sflid  INTEGER  NOT NULL,
	sfid  INTEGER, 
	sfluserid  VARCHAR(16),
	sfldesc VARCHAR(2000),
	sflinstime CHAR(16),
	fingerprint varchar(256),
	sflattkey varchar(32),
	PRIMARY KEY (sflid),
	FOREIGN KEY (sfid) REFERENCES "ig".IG933(sfid)
		ON DELETE CASCADE
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".SmsSendLog 
(
	SSLID INTEGER NOT NULL , 
	USERNAME VARCHAR(32) , 
	DEPTMENTNAME VARCHAR(100) , 
	SENDDATE VARCHAR(16) , 
	USERMOBILE VARCHAR(16) , 
	SMSTYPE VARCHAR(512) , 
	SENDFLAG CHAR(1) , 
	FINGERPRINT VARCHAR(256),
	PRIMARY KEY (SSLID)
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".IG992
(
	PEDID INTEGER NOT NULL,
	PEDEVENTID VARCHAR(32),
	PEDACTION VARCHAR(32),
	PEDDESC VARCHAR(128),
	FINGERPRINT VARCHAR(256)
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".IG286
(
	plid CHAR(10)  NOT NULL,
	pldpdid CHAR(7) NOT NULL,
	pldactionid VARCHAR(16),
	initiativepidid CHAR(10)  NOT NULL,
	passivitypidid CHAR(10)  NOT NULL,
	pldesc VARCHAR(64),
	plblname VARCHAR(32),
	pljsevent VARCHAR(32),
	pljtype char(1),
	initiativepidname VARCHAR(128),
	passivitypidname VARCHAR(128),
	fingerprint varchar(256),
	PRIMARY KEY (plid),
	FOREIGN KEY (pldpdid) REFERENCES "ig".IG380(pdid)
		ON DELETE CASCADE,
	FOREIGN KEY (initiativepidid) REFERENCES "ig".IG007(pidid)
		ON DELETE CASCADE,
	FOREIGN KEY (passivitypidid) REFERENCES "ig".IG007(pidid)
		ON DELETE CASCADE
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".IG413
(
	pedid  CHAR(13)  NOT NULL,
	pdid   CHAR(7)  NOT NULL,
	psdid   CHAR(10)  NOT NULL,
	pedactionid  VARCHAR(8),
	pedtype  VARCHAR(4),
	pedblid   VARCHAR(32),
	pedorder  INTEGER,
	pedec  VARCHAR(256),
	fingerPrint VARCHAR(256),
	PRIMARY KEY (pedid),
	FOREIGN KEY (pdid) REFERENCES "ig".IG380(pdid)
		ON DELETE CASCADE,
	FOREIGN KEY (psdid) REFERENCES "ig".IG333(psdid)
		ON DELETE CASCADE
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".IG373
(
	piidid  CHAR(13)  NOT NULL,
	pdid   CHAR(7)  NOT NULL,
	psdid   CHAR(10)  NOT NULL,
	piidblid   VARCHAR(32),
	piiddec  VARCHAR(256),
	fingerPrint VARCHAR(256),
	PRIMARY KEY (piidid),
	FOREIGN KEY (pdid) REFERENCES "ig".IG380(pdid)
		ON DELETE CASCADE,
	FOREIGN KEY (psdid) REFERENCES "ig".IG333(psdid)
		ON DELETE CASCADE
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".IG126
(
	pjdid  CHAR(10)  NOT NULL,
	pdid   CHAR(7)  NOT NULL,
	pjdtype  VARCHAR(4),
	pjdblid   VARCHAR(32),
	pjdurl  VARCHAR(32),
	fingerPrint VARCHAR(256),
	PRIMARY KEY (pjdid),
	FOREIGN KEY (pdid) REFERENCES "ig".IG380(pdid)
		ON DELETE CASCADE
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".IG725
(
	pdbdid   CHAR(13)  NOT NULL,
	psdid   CHAR(10)  NOT NULL,
	pbdid  CHAR(2) ,
	pdbdname  VARCHAR(32),
	pdbddesc  VARCHAR(64),
	pdbdauth CHAR(1),
	fingerPrint VARCHAR(256),
	PRIMARY KEY (pdbdid),
	FOREIGN KEY (psdid) REFERENCES "ig".IG333(psdid)
		ON DELETE CASCADE,
	FOREIGN KEY (pbdid) REFERENCES "ig".IG900(pbdid)
		ON DELETE CASCADE
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".IG711
(
	paid INTEGER NOT NULL,
	paiid VARCHAR(16),
	pauid VARCHAR(16),
	pabegintime VARCHAR(16),
	paendtime VARCHAR(16),
	paflag char(1),
	patype char(1),
	paprocessid INTEGER,
	paprocessnum VARCHAR(10),
	palogintime VARCHAR(16),
	fingerprint varchar(256) ,	
	remarks varchar(256),
	PRIMARY KEY (paid) 		
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".IG699
(
	pdvid  CHAR(13)  NOT NULL,
	pidid   CHAR(10)  NOT NULL,
	psdid   CHAR(10)  NOT NULL,
	pidaccess CHAR,
	fingerPrint VARCHAR(256),
	PIDREQUIRED CHARACTER (1),
	PRIMARY KEY (pdvid),
	FOREIGN KEY (pidid) REFERENCES "ig".IG007(pidid)
		ON DELETE CASCADE,
	FOREIGN KEY (psdid) REFERENCES "ig".IG333(psdid)
		ON DELETE CASCADE
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".IG500
(
	prid  INTEGER  NOT NULL,
	prtype  VARCHAR(3),
	prsubtype  VARCHAR(128),
	prstatus  CHAR,
	prsubstatus  CHAR,
	prtitle  VARCHAR(200),
	prdesc  VARCHAR(2000),
	propentime  CHAR(16),
	prclosetime  CHAR(16),
	prplantime  CHAR(16),
	prduration  CHAR(16),
	prurgency  CHAR,
	primpact  CHAR,
	prassetid  INTEGER,
	prassetname  VARCHAR(128),
	prassetcategory VARCHAR(16),
	prbusiness  VARCHAR(128),
	primplplan  VARCHAR(2000),
	prbackplan  VARCHAR(2000),
	prvfyplan  VARCHAR(2000),
	pid INTEGER,
	pcode VARCHAR(32),
	pname VARCHAR(128),
	prinfo VARCHAR(64),
	prcorid INTEGER,
	prcortype CHAR,
	prcortitle VARCHAR(64),
	pruserid VARCHAR(16),
	prusername VARCHAR(32),
	prroleid INTEGER,
	prrolename VARCHAR(64),
	prpdid CHAR(7),
	prpdname VARCHAR(128),
	prorgid	VARCHAR(32),
	prorgname VARCHAR(128),
	prserialnum VARCHAR(11),
	prfacttime INTEGER,
	fingerprint varchar(256) ,
	prptdcond VARCHAR(256),
	prstrategyversion INTEGER,
	prpriority CHAR(1),
	PRIMARY KEY (prid)
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".IG394
(
	PNSSID INTEGER NOT NULL,
	PRID INTEGER NOT NULL,
	PSDID CHAR(10) NOT NULL,
	PSDCONFIRM CHAR(1) NOT NULL,
	ROLEID INTEGER,
	USERID VARCHAR(16),
	NOTIFYSMSTIME VARCHAR(16),
	NOTIFYEMAILTIME VARCHAR(16),
	REPORTSMSTIME VARCHAR(16),
	REPORTEMAILTIME VARCHAR(16),
	FINGERPRINT VARCHAR(256),
	PRIMARY KEY (PNSSID),
	FOREIGN KEY (PRID) REFERENCES "ig".IG500(PRID) ON DELETE CASCADE,
	FOREIGN KEY (PSDID) REFERENCES "ig".IG333(PSDID) 
	ON DELETE CASCADE
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".IG337
(
	ppid  INTEGER  NOT NULL,
	prid  INTEGER  NOT NULL,
	pproleid  INTEGER,
	pprolename  VARCHAR(64),
	ppuserid  VARCHAR(16),
	ppusername  VARCHAR(32),
	pporgid	VARCHAR(32),
	pporgname VARCHAR(128),
	pptype  CHAR  ,
	ppuserinfo  VARCHAR(128),
	ppcomment  VARCHAR(128),
	ppstatus  CHAR  ,
	ppattkey  VARCHAR(32),
	ppinittime CHAR(16),
	ppproctime CHAR(16),
	ppsubstatus CHAR,
	ppfacttime Integer,
	ppbacktime VARCHAR(16),
	fingerprint varchar(256) ,
	ppproxyuserid VARCHAR(16),
	ppsuper CHAR,
	pprolemanager CHAR,
	ppdutyperson CHAR,
	pbdid CHAR(2),
	PRIMARY KEY (ppid),
	FOREIGN KEY (prid) REFERENCES "ig".IG500(prid)
		ON DELETE CASCADE
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".IG599
(
	piid  INTEGER  NOT NULL,
	prid  INTEGER  NOT NULL,
	pivarname  VARCHAR(128),
	pivarlabel VARCHAR(32),
	pivartype  VARCHAR(2),
	pivarvalue  VARCHAR(3000),
	piattkey  VARCHAR(32) ,
	fingerprint varchar(256),
	pidid  CHAR(10),
	PIDMODE CHARACTER (1),
	PRIVATESCOPE VARCHAR (1),
	PRIMARY KEY (piid),
	FOREIGN KEY (prid) REFERENCES "ig".IG500(prid)
		ON DELETE CASCADE
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".Attachment
(
	attid  Integer NOT NULL,
	attkey  VARCHAR(32),
	attname  VARCHAR(512),
	attdesc  VARCHAR(64),
	atturl  VARCHAR(128),
	fingerprint varchar(256),
	 PRIMARY KEY (attid)
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".IG036
(
	rlid  INTEGER  NOT NULL,
	prid  INTEGER  NOT NULL,
	rltime  CHAR(16),
	roleid  INTEGER,
	rlrolename  VARCHAR(64),
	rluserid  VARCHAR(16),
	rlusername  VARCHAR(32),
	rltype	CHAR ,
	rldesc  VARCHAR(512),
	rlcomment  VARCHAR(2000),
	rlattkey  VARCHAR(32),
	rlorgid	VARCHAR(32),
	rlorgname VARCHAR(128),
	fingerprint varchar(256) ,
	psname VARCHAR(32),
	psdcode CHAR(1),
	rolemanger CHAR(1),
	pbdid CHAR(2),
	PRIMARY KEY (rlid),
	FOREIGN KEY (prid) REFERENCES "ig".IG500(prid)
		ON DELETE CASCADE
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".IG715
(
	sprrid  INTEGER  NOT NULL,
	sprrsfid  INTEGER  NOT NULL,
	sprrprid  INTEGER  NOT NULL,
	sprrinstime  CHAR(16),
	fingerprint VARCHAR(256),
	PRIMARY KEY (sprrid),
	FOREIGN KEY (sprrsfid) REFERENCES "ig".IG933(sfid)
		ON DELETE CASCADE,
	FOREIGN KEY (sprrprid) REFERENCES "ig".IG500(prid)
		ON DELETE CASCADE
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".IG113
(
	rlvid INTEGER  NOT NULL,
	rlid  INTEGER  NOT NULL,
	piid  INTEGER  NOT NULL,
	prid  INTEGER  NOT NULL,
	pivarname  VARCHAR(128),
	pivarlabel VARCHAR(32),
	pivartype  VARCHAR(2),
	pivarvalue  VARCHAR(3000),
	piattkey  VARCHAR(32),
	pidid  CHAR(10),
	pishowvarname  VARCHAR(128),
	fingerprint varchar(256),
	PRIMARY KEY (rlvid),
	FOREIGN KEY (rlid) REFERENCES "ig".IG036(rlid)
		ON DELETE CASCADE
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".SdlInfo
(
	siid  INTEGER  NOT NULL,
	sitype  CHAR,
	sibegin  CHAR(16),
	simark  INTEGER,
	sieiid  INTEGER,
	sieiname  VARCHAR(128),
	siprid  INTEGER,
	siprtitle  VARCHAR(32),
	sidesc  VARCHAR(512),
	siend  CHAR(16),
	siattkey VARCHAR(32),
	sifacttime INTEGER,
	sidate CHAR(16),
	fingerprint varchar(256),
	PRIMARY KEY (siid)
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".SdlDefineInfo
(
	sdiid	INTEGER  NOT NULL,
	sdiyear	CHAR(4),
	sdieiid	INTEGER,
	sdieiname VARCHAR(128),
	sdibreakm INTEGER,
	sdibreaky INTEGER,
	sdicontinuousm FLOAT,
	sdicontinuousy FLOAT,
	sdiimpactm INTEGER,
	sdiimpacty INTEGER,
	sdisteadym FLOAT,
	sdisteadyy FLOAT,
	sdisafecasem INTEGER,
	sdisafecasey INTEGER,
	sdisafemarkm INTEGER,
	sdisafemarky INTEGER,
	sdiriskmarkm INTEGER,
	sdiriskmarky INTEGER,
	sdicapacitycasem INTEGER,
	sdicapacitycasey INTEGER,
	sdicapacitymarkm INTEGER,
	sdicapacitymarky INTEGER,
	fingerprint varchar(256),
	PRIMARY KEY (sdiid)
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".Project
(
	pid  INTEGER  NOT NULL,
	ptype  VARCHAR(64),
	pcode  VARCHAR(32),
	pname  VARCHAR(128),
	pdesc  VARCHAR(512),
	pinfo  VARCHAR(512),
	popentime  CHAR(16),
	pclosetime  CHAR(16),
	pstatus  VARCHAR(16),
	porg  VARCHAR(128),
	prole  VARCHAR(128),
	puser  VARCHAR(128),
	ppurpose VARCHAR(512),
	ISUSEBUDGET VARCHAR(16),
	pamount VARCHAR(64),
	puse VARCHAR(64),
	plimit float,
	pbranch VARCHAR(64),
	pbid INTEGER,
	paim VARCHAR(512),
	pplanclosetime char(16),
	pzdevelop FLOAT,
	pzhardware FLOAT,
	pzsoftware FLOAT,
	pzproject FLOAT,
	pzelse FLOAT,
	pcimplement FLOAT,
	pcelse FLOAT,
	plcid INTEGER,
	ppquality VARCHAR(16),
	fingerprint VARCHAR(256),
	PRIMARY KEY (pid)
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".ProjectPlan
(
	pplid  INTEGER  NOT NULL,
	pid  INTEGER  NOT NULL,
	pplinfo  VARCHAR(1024),
	pplversion  INTEGER,
	pplstatus  CHAR,
	ppldesc  VARCHAR(1024),
	ppldate  CHAR(16),
	ppltitle VARCHAR(64),
	pplclosetime VARCHAR(16),
	pplriskatt VARCHAR(32),
	pplopentime VARCHAR(16),
	pplshuttime VARCHAR(16),
	fingerprint varchar(256),
	PRIMARY KEY (pplid),
	FOREIGN KEY (pid) REFERENCES "ig".Project(pid)
		ON DELETE CASCADE
) TABLESPACE "IG_SPACE";





CREATE TABLE "ig".ProjectLog
(
	plid  INTEGER  NOT NULL,
	pid  INTEGER  NOT NULL,
	plroleid  INTEGER,
	plrolename  VARCHAR(64),
	pluserid  VARCHAR(16),
	plusername  VARCHAR(32),
	plinfo  VARCHAR(512),
	pltype  CHAR,
	pltime  CHAR(16),
	plattkey  VARCHAR(32),
	fingerprint varchar(256),
	PRIMARY KEY (plid,pid),
	FOREIGN KEY (pid) REFERENCES "ig".Project(pid)
		ON DELETE CASCADE
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".Budget(
	bid  INTEGER  NOT NULL,
	btype  VARCHAR(64),
	binittime  CHAR(16),
	bopentime  CHAR(16),
	bstatus  CHAR,
	breqid  VARCHAR(16),
	bapvid  VARCHAR(16),
	btitle  VARCHAR(128),
	bclosetime  CHAR(16),
	bdesc  VARCHAR(512),
	binfo  VARCHAR(512),
	byear  CHAR(4),
	borgid  VARCHAR(32),
	borgname  VARCHAR(128),
	breqname  VARCHAR(128),
	bapvname  VARCHAR(128),
	bamount  FLOAT,
	battkey  VARCHAR(32),
	pid INTEGER,
	pcode VARCHAR(32),
	pname VARCHAR(128),
	pquality VARCHAR(16),
	pstorecode VARCHAR(200),
	pneeddispart VARCHAR(16),
	pbuggetform VARCHAR(16),
	puse VARCHAR(16),
	remark VARCHAR(512),
	bzdevelop FLOAT,
	bzhardware FLOAT,
	bzsoftware FLOAT,
	bzproject FLOAT,
	bzelse FLOAT,
	bcimplement FLOAT,
	bcelse FLOAT,
	fingerprint varchar(256),
	PRIMARY KEY (bid)
) TABLESPACE "IG_SPACE";


CREATE TABLE "ig".Expense
(
	exid  INTEGER  NOT NULL,
	bid  INTEGER  NOT NULL,
	exdesc  VARCHAR(512),
	examount  FLOAT,
	exinfo  VARCHAR(256),
	exstatus  CHAR,
	exreqid  VARCHAR(16),
	exreqname  VARCHAR(128),
	exinittime  CHAR(16),
	exopentime  CHAR(16),
	exapvid  VARCHAR(16),
	exapvname  VARCHAR(128),
	exclosetime  CHAR(16),
	exattkey  VARCHAR(32),
	exeiinfo  VARCHAR(128),
	exprinfo  VARCHAR(128),
	expinfo  VARCHAR(128),
	exorginfo  VARCHAR(128),
	btitle  VARCHAR(200),
	fingerprint varchar(256),
	PRIMARY KEY (exid,bid),
	FOREIGN KEY (bid) REFERENCES "ig".Budget(bid)
		ON DELETE CASCADE
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".QuartzJobs ( 
    qjid integer not null,
    qjname varchar(128),
    qjdesc varchar(256),
    qjtriname varchar(32),
    qjtrigrp varchar(32),
    qjtricron varchar(128),
    qjcrtuser varchar(16),
    qjimpluser varchar(16),
    qjcrttime varchar(16),
    qjendtime varchar(16),
    qjtype char,
    qjstatus char,
    qjinfo varchar(256),
    qjcrtusername varchar(32),
    qjimplusername varchar(32),
    qjperiodinfo varchar(64),
    qjorgid VARCHAR(32) ,
    qjorgname varchar(128),
    qjassetid varchar(32),
    qjassettypeid varchar(32),
    fingerprint varchar(256) ,
    PRIMARY KEY (qjid)
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".QuartzProcessRecord
(
	qprid  INTEGER  NOT NULL,
	qprtype  VARCHAR(3),
	qprsubtype  VARCHAR(64),
	qprstatus  CHAR,
	qprsubstatus  CHAR,
	qprtitle  VARCHAR(200),
	qprdesc  VARCHAR(2000),
	qpropentime  CHAR(16),
	qprclosetime  CHAR(16),
	qprplantime  CHAR(16),
	qprduration  CHAR(16),
	qprurgency  CHAR,
	qprimpact  CHAR,
	qprassetid  INTEGER,
	qprassetname  VARCHAR(128),
	qprassetcategory VARCHAR(16),
	qprbusiness  VARCHAR(32),
	qprimplplan  VARCHAR(256),
	qprbackplan  VARCHAR(256),
	qprvfyplan  VARCHAR(256),
	qpid INTEGER,
	qpcode VARCHAR(32),
	qpname VARCHAR(128),
	qprinfo VARCHAR(64),
	qprcorid INTEGER,
	qprcortype CHAR,
	qprcortitle VARCHAR(64),
	qpruserid VARCHAR(16),
	qprusername VARCHAR(32),
	qprroleid INTEGER,
	qprrolename VARCHAR(64),
	qprpdid CHAR(7),
	qprpdname VARCHAR(128),
	qprorgid VARCHAR(32) ,
	qprorgname VARCHAR(128),
	fingerprint varchar(256),
	qprattkey VARCHAR(32),
	PRIMARY KEY (qprid)
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".QuartzProcessParticipant
(
	qppid  INTEGER  NOT NULL,
	qprid  INTEGER  NOT NULL,
	qpproleid  INTEGER,
	qpprolename  VARCHAR(64),
	qppuserid  VARCHAR(16),
	qppusername  VARCHAR(32),
	qpporgid	VARCHAR(32),
	qpporgname VARCHAR(128),
	qpptype  CHAR,
	qppsubstatus VARCHAR(1),
	qppuserinfo  VARCHAR(128),
	qppcomment  VARCHAR(128),
	qppstatus  CHAR,
	qppattkey  VARCHAR(32),
	qppinittime CHAR(16),
	qppproctime CHAR(16),
	fingerprint varchar(256),
	PRIMARY KEY (qppid),
	FOREIGN KEY (qprid) REFERENCES "ig".QuartzProcessRecord(qprid)
		ON DELETE CASCADE
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".QuartzProcessInfo
(
	qpiid  INTEGER  NOT NULL,
	qprid  INTEGER  NOT NULL,
	qpivarname  VARCHAR(128),
	qpivarlabel VARCHAR(32),
	qpivartype  VARCHAR(2),
	qpivarvalue  VARCHAR(3000),
	qpiattkey  VARCHAR(32),
	fingerprint varchar(256),
	qpidid CHAR(10),
	PRIMARY KEY (qpiid),
	FOREIGN KEY (qprid) REFERENCES "ig".QuartzProcessRecord(qprid)
		ON DELETE CASCADE
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".Notification (
	nfid integer not null,
	nfinitime char(16),
	nfsdrtime char(16),
	nfexptime char(16),
	nftitle varchar(64),
	nfcontent varchar(128),
	nfsdrrid integer,
	nfsdrrname varchar(128),
	nfsdruid varchar(16),
	nfsdruname varchar(32),
	nftype char,
	nftarget varchar(64),
	nfstatus char,
	fingerprint varchar(256),
	PRIMARY KEY (nfid)
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".RiskAudit
(
	raid  INTEGER  NOT NULL,
	raversion   VARCHAR(32)  NOT NULL,
	radate CHAR(10),
	rauserid VARCHAR(16),
	rausername VARCHAR(32),
	racode CHAR(4),
	radesc VARCHAR(128),
	rastatus CHAR,
	fingerprint varchar(256),
	PRIMARY KEY (raid)
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".RiskAuditDef
(
	radid  INTEGER  NOT NULL,
	raid INTEGER NOT NULL,
	raversion VARCHAR(32)  NOT NULL,
	radname VARCHAR(32),
	radcode VARCHAR(32),
	radlevel CHAR(1),
	radparcode VARCHAR(32),
	raddesc VARCHAR(256),
	radrisklevel CHAR,
	raduserid VARCHAR(16),
	radusername VARCHAR(32),
	radorg VARCHAR(32),
	radorgcoding VARCHAR(32),
	radstatus CHAR,
	radmode CHAR,
	radtype CHAR,
	radfrequency CHAR,
	fingerprint varchar(256),
	PRIMARY KEY (radid),
	FOREIGN KEY (raid) REFERENCES "ig".RiskAudit(raid)
		ON DELETE CASCADE
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".RiskAuditIns
(
	raiid  INTEGER  NOT NULL,
	raid INTEGER NOT  NULL,
	raversion VARCHAR(32)  NOT NULL,
	raicode VARCHAR(32),
	raistart CHAR(10),
	raiend CHAR(10),
	raidesc VARCHAR(128),
	raistatus CHAR,
	fingerprint varchar(256),
	PRIMARY KEY (raiid),
	FOREIGN KEY (raid) REFERENCES "ig".RiskAudit(raid)
		ON DELETE CASCADE
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".RiskAuditResult
(
	rarid  INTEGER  NOT NULL,
	raiid INTEGER NOT  NULL,
	radid INTEGER NOT  NULL,
	rardate CHAR(10),
	raruserid VARCHAR(16),
	rarusername VARCHAR(32),
	rarplanscore VARCHAR(2),
	rarplandesc VARCHAR(512),
	rarexecscore VARCHAR(2),
	rarexecdesc VARCHAR(512),
	raroverallscore VARCHAR(2),
	raroveralldesc VARCHAR(512),
	rarcomment VARCHAR(512),
	fingerprint varchar(256),
	radcode VARCHAR(32),
	PRIMARY KEY (rarid),
	FOREIGN KEY (raiid) REFERENCES "ig".RiskAuditIns(raiid)
		ON DELETE CASCADE,
	FOREIGN KEY (radid) REFERENCES "ig".RiskAuditDef(radid)
		ON DELETE CASCADE
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".RiskCheck
(
	rcid  INTEGER  NOT NULL,
	rcname VARCHAR(32),
	rcdesc VARCHAR(256),
	rctype CHAR,
	rcstatus CHAR,
	rcstartdate CHAR(10),
	rcenddate CHAR(10),
	rcfrequency VARCHAR(16),
	rccron VARCHAR(128),
	rcuserid VARCHAR(16),
	rcusername VARCHAR(32),
	rcroleid INTEGER,
	rcrolename VARCHAR(64),
	rcasset INTEGER,
	rcassetname VARCHAR(128),
	rcattch VARCHAR(32),
	rcoption VARCHAR(128),
	fingerprint varchar(256),
	PRIMARY KEY (rcid)
) TABLESPACE "IG_SPACE";

  CREATE TABLE "ig".RiskCheckResult
(
	rcrid  INTEGER  NOT NULL,
	rcid INTEGER NOT  NULL,
	rcrplandate CHAR(10),
	rcrrealtime CHAR(16),
	rcruserid VARCHAR(16),
	rcrusername VARCHAR(32),
	rcrresult VARCHAR(32),
	rcrcomment VARCHAR(128),
	rcrattch VARCHAR(32),
	fingerprint varchar(256),
	rctype CHAR,
	PRIMARY KEY (rcrid),
	FOREIGN KEY (rcid) REFERENCES "ig".RiskCheck(rcid)
		ON DELETE CASCADE
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".AuditCheckRelation
(
	acrid  INTEGER  NOT NULL,
	rcid INTEGER NOT NULL,
	radid INTEGER NOT NULL,
	radcode VARCHAR(128),
	fingerprint varchar(256),
	PRIMARY KEY (acrid),
	FOREIGN KEY (rcid) REFERENCES "ig".RiskCheck(rcid)
		ON DELETE CASCADE,
	FOREIGN KEY (radid) REFERENCES "ig".RiskAuditDef(radid)
		ON DELETE CASCADE
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".DUTYAUDITDEF (
    DADID INTEGER NOT NULL,
    DADCATEGORY CHAR(1),
    DADTYPE VARCHAR(4),
    DADNAME VARCHAR(128),
    DADLIMTIME VARCHAR(4),
    DADCONTENT VARCHAR(4),
    DADINFO VARCHAR(4),
    DADSTATUS CHAR(1),
   	DADUSERID VARCHAR(16),
    DADUSERNAME VARCHAR(32),
    DADUPDTIME CHAR(16),
    DADORDERBY INTEGER,
    PERIODTYPE VARCHAR(32),
	PERIODVALUE VARCHAR(128),
    FINGERPRINT VARCHAR(256),
    PRIMARY KEY (DADID)
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".DUTYAUDITTIME (
    DATID INTEGER NOT NULL,
    DADID INTEGER NOT NULL,
    DATTIME VARCHAR(5),
    DATLIMTIME VARCHAR(5),
    FINGERPRINT VARCHAR(256),
    PRIMARY KEY (DATID),
    FOREIGN KEY (DADID) REFERENCES "ig".DUTYAUDITDEF(DADID)
		ON DELETE CASCADE
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".DUTYPLAN (
    DPID INTEGER NOT NULL,
    DADCATEGORY CHAR(1),
    DPTIME CHAR(10),
    DPTYPE CHAR(1),
    DPSTATUS CHAR(1),
    DPQUESTION VARCHAR(256),
    DPINFO VARCHAR(256),
    DPUSERID VARCHAR(16),
    DPUSERNAME VARCHAR(32),
    DPCRETIME CHAR(16),
    DPUPDTIME CHAR(16),
    DPFINTIME CHAR(16),
    DPREMARKS VARCHAR(1024),
    FINGERPRINT VARCHAR(256),
    PRIMARY KEY (DPID)
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".DUTYPERSON (
    DPERID INTEGER NOT NULL,
    DPID INTEGER NOT NULL,
    DPERTIME CHAR(10),
    DPTYPE CHAR(1),
    DPERUSERID VARCHAR(16),
    DPERUSERNAME VARCHAR(32),
    FINGERPRINT VARCHAR(256),
    PRIMARY KEY (DPERID),
    FOREIGN KEY (DPID) REFERENCES "ig".DUTYPLAN(DPID)
		ON DELETE CASCADE
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".DUTYRESULT (
    DRID INTEGER NOT NULL,
    DPID INTEGER NOT NULL,
    DADID INTEGER NOT NULL,
    DADCATEGORY CHAR(1),
    DADTYPE VARCHAR(4),
    DADNAME VARCHAR(128),
    DPTIME CHAR(10),
    DPTYPE CHAR(1),
    DATTIME VARCHAR(5),
    DATLIMTIME VARCHAR(5),
    DADCONTENT VARCHAR(4),
    DRCONTENT VARCHAR(4),
    DRFILLTIME VARCHAR(16),
    DRRESULT VARCHAR(256),
    DRUSERID VARCHAR(16),
    DRUSERNAME VARCHAR(32),
    DRCRETIME VARCHAR(16),
    drlimdtime CHAR(16),
    FINGERPRINT VARCHAR(256),
    PRIMARY KEY (DRID),
    FOREIGN KEY (DPID) REFERENCES "ig".DUTYPLAN(DPID)
		ON DELETE CASCADE,
    FOREIGN KEY (DADID) REFERENCES "ig".DUTYAUDITDEF(DADID)
		ON DELETE CASCADE
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".IG512
(
	prrid  INTEGER  NOT NULL,
	parprid  INTEGER  NOT NULL,
	cldprid  INTEGER  NOT NULL,
	prrinstime  CHAR(16),
	fingerprint VARCHAR(256),
	PRIMARY KEY (prrid),
	FOREIGN KEY (parprid) REFERENCES "ig".IG500(prid)
		ON DELETE CASCADE,
	FOREIGN KEY (cldprid) REFERENCES "ig".IG500(prid)
		ON DELETE CASCADE
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".ReportFileDefinition
(
	rfdid  INTEGER  NOT NULL,
	rfdtitle  VARCHAR(128),
	rfdtype  VARCHAR(32),
	rfddesc  VARCHAR(512),
	rfdfilename VARCHAR(32),
	rfduserid  VARCHAR(16),
	rfdusername  VARCHAR(32),
	rfdinstime  CHAR(16),
	rfdversion INTEGER,
	rfdnewversion INTEGER,
	rfdpictype VARCHAR(1),
	fingerprint VARCHAR(256),
	rfdparameters VARCHAR(64),
	isflag VARCHAR(1),
	PRIMARY KEY (rfdid)
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".ReportFileVersion
(
	rfvid  INTEGER  NOT NULL,
	rfdid  INTEGER  NOT NULL,
	rfvversion  INTEGER,
	rfvinstime  CHAR(16),
	fingerprint VARCHAR(256),
	PRIMARY KEY (rfvid),
	FOREIGN KEY (rfdid) REFERENCES "ig".ReportFileDefinition(rfdid)
		ON DELETE CASCADE
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".IG224
(
	rslid  INTEGER  NOT NULL,
	prid  INTEGER  NOT NULL,
	prpdid  CHAR(7),
	prtype  VARCHAR(3),
	prstatus CHAR,
	rslopentime  TIMESTAMP,
	rslclosetime  TIMESTAMP,
	rslExpect CHAR(1),
	fingerprint VARCHAR(256),
	PRIMARY KEY (rslid),
	FOREIGN KEY (prid) REFERENCES "ig".IG500(prid)
		ON DELETE CASCADE
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".IG899
(
	PPIID INTEGER NOT NULL,
	PIDID CHAR(10),
	PIID INTEGER,
	ROLEID INTEGER,
	USERID VARCHAR(16),
	PPIVALUE VARCHAR(2000),
	PPIATTKEY VARCHAR(32),
	FINGERPRINT VARCHAR(256),
	PRIMARY KEY (PPIID),
	FOREIGN KEY (PIID) REFERENCES "ig".IG599(PIID)
		ON DELETE CASCADE
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".IG463
(
	ppwid INTEGER  NOT NULL,
	ppwprid INTEGER,
	ppwprtype VARCHAR(3),
	ppwprserialnum VARCHAR(11),
	ppwprtitle VARCHAR(64),
    ppwauthorizeuserid VARCHAR(16),
    ppwproxyuserid VARCHAR(16),
    ppwproxyusername VARCHAR(32),
    ppwoptiontime VARCHAR(16),
    ppwcloseflag  CHAR(1),
	fingerPrint VARCHAR(256),
	PRIMARY KEY (ppwid )
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".IG213
( 
	prtdid CHAR(10)  NOT NULL,
	pdid CHAR(7)  NOT NULL,
	roletype VARCHAR(8) ,
	fingerprint varchar(256) ,
	PRIMARY KEY (prtdid),
	FOREIGN KEY (pdid) REFERENCES "ig".IG380(pdid)
		ON DELETE CASCADE
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".IG243
(
	ptdid CHAR(10) NOT NULL,
	pdid CHAR(7) NOT NULL,
	ptitlename VARCHAR(32),
	ptitleaccess CHARACTER(1),
	pdescname VARCHAR(32),
	pdescaccess CHARACTER(1),
	fingerprint VARCHAR(256),
	PRIMARY KEY (ptdid),
	FOREIGN KEY (pdid) REFERENCES "ig".IG380(pdid)
		ON DELETE CASCADE
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".IG298
(
	psrdid CHAR(13) NOT NULL,
	psdid CHAR(10) NOT NULL,
	roleid INTEGER NOT NULL,
	fingerprint VARCHAR(256),
	PRIMARY KEY (psrdid),
	FOREIGN KEY (psdid) REFERENCES "ig".IG333(psdid)
		ON DELETE CASCADE,
	FOREIGN KEY (roleid) REFERENCES "ig".Role(roleid)
		ON DELETE CASCADE
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".IG156 (
		  PSEID CHAR(13) NOT NULL , 
		  PDID  CHAR(7) NOT NULL , 
		  PSDID CHAR(10) NOT NULL ,
		  PSEBUTTONID VARCHAR(32) ,
		  PSEACTIONID VARCHAR(32) , 
		  PSEORDER INTEGER , 
		  PSEDEC VARCHAR(256) , 
		  PSBDNAME VARCHAR(32) ,
		  FINGERPRINT VARCHAR(256),
		  PRIMARY KEY (PSEID),
		  FOREIGN KEY (PSDID) REFERENCES "ig".IG333(PSDID)
		ON DELETE CASCADE
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".IG212
(
	PSDID CHAR(10) NOT NULL,
	PSDCONFIRM CHAR(1) NOT NULL,
	SMS CHAR(1),
	EMAIL CHAR(1),
	NOTIFYD INTEGER,
	NOTIFYH INTEGER,
	NOTIFYM INTEGER,
	REPORTD INTEGER,
	REPORTH INTEGER,
	REPORTM INTEGER,
	ROLEMANAGER CHAR(1),
	FINGERPRINT VARCHAR(256),
	PRIMARY KEY (PSDID, PSDCONFIRM),
	FOREIGN KEY (PSDID) REFERENCES "ig".IG333(PSDID)
	ON DELETE CASCADE
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".IG237
(
	PSDID CHAR(10) NOT NULL,
	PSDCONFIRM CHAR(1) NOT NULL,
	USERID VARCHAR(16) NOT NULL,
	ROLEID INTEGER NOT NULL,
	FINGERPRINT VARCHAR(256),
	PRIMARY KEY (PSDID, PSDCONFIRM, USERID),
	FOREIGN KEY (PSDID) REFERENCES "ig".IG333(PSDID) ON DELETE CASCADE,
	FOREIGN KEY (USERID) REFERENCES "ig".IgUser(USERID) ON DELETE CASCADE,
	FOREIGN KEY (ROLEID) REFERENCES "ig".Role(ROLEID) ON DELETE CASCADE
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".IG202
(
	PIDID INTEGER NOT NULL , 
	PIDNAME VARCHAR(128) , 
	PIDLABEL VARCHAR(64) , 
	PIDDESC VARCHAR(2000) , 
	PIDTYPE CHAR(1) , 
	PIDOPTION VARCHAR(128) , 
	PIDDEFAULT VARCHAR(64) , 
	PIDREQUIRED CHAR(1) , 
	PIDSORTID VARCHAR(8) , 
	CCID VARCHAR(128) , 
	PIDMODE CHARACTER (1),
	PRIVATESCOPE VARCHAR (1),
	ROWWIDTH CHARACTER(1),
	FINGERPRINT VARCHAR(256),
	PRIMARY KEY (pidid)
) TABLESPACE "IG_SPACE";


CREATE TABLE "ig".CUSTOMREPORT 
( 
	CRID INTEGER  NOT NULL, 
	USERID VARCHAR (16), 
	RFDID INTEGER,
	ORDERNUM INTEGER,
	FINGERPRINT VARCHAR (256), 
	PRIMARY KEY (CRID)
) TABLESPACE "IG_SPACE";


CREATE TABLE "ig".ROLEREPORT
(
	RRID INTEGER  NOT NULL, 
	ROLEID INTEGER  NOT NULL, 
	RFDID INTEGER  NOT NULL, 
	RRPERM VARCHAR (2), 
	RRDESC VARCHAR (64), 
	FINGERPRINT VARCHAR (256), 
	PRIMARY KEY (RRID),
	FOREIGN KEY (RFDID) REFERENCES "ig".ReportFileDefinition(RFDID)
) TABLESPACE "IG_SPACE";


CREATE TABLE "ig".SEQUENCE_GENERATOR_TABLE ( 
    SEQUENCE_NAME VARCHAR(64) NOT NULL,
    SEQUENCE_VALUE INTEGER ,
    PRIMARY KEY (SEQUENCE_NAME)
) TABLESPACE "IG_SPACE";


CREATE TABLE "ig".HOTLINK(
	hid INTEGER NOT NULL,
	userid VARCHAR(16),
	hname VARCHAR(32),
	hlink VARCHAR(256),
	horder INTEGER,
	fingerprint VARCHAR(256),
	PRIMARY KEY (hid)
) TABLESPACE "IG_SPACE"; 


CREATE TABLE "ig".IG731
(
	pieid INTEGER NOT NULL,
	prid INTEGER NOT NULL,
	piid INTEGER NOT NULL,
	eiid INTEGER NOT NULL,
	fingerprint VARCHAR(256),
		PRIMARY KEY (pieid),
	FOREIGN KEY (prid) REFERENCES "ig".IG500(prid)
		ON DELETE CASCADE,
	FOREIGN KEY (piid) REFERENCES "ig".IG599(piid)
		ON DELETE CASCADE,
	FOREIGN KEY (eiid) REFERENCES "ig".IG013(eiid)
		ON DELETE CASCADE
)   TABLESPACE "IG_SPACE" ; 


CREATE TABLE "ig".QuartzProcessInfoEntity
(
	qpieid INTEGER NOT NULL,
	qprid INTEGER NOT NULL,
	qpiid INTEGER NOT NULL,
	qeiid INTEGER NOT NULL,
	fingerprint VARCHAR(256),
		PRIMARY KEY (qpieid),
	FOREIGN KEY (qprid) REFERENCES "ig".QuartzProcessRecord(qprid)
		ON DELETE CASCADE,
	FOREIGN KEY (qpiid) REFERENCES "ig".QuartzProcessInfo(qpiid)
		ON DELETE CASCADE,
	FOREIGN KEY (qeiid) REFERENCES "ig".IG013(eiid)
		ON DELETE CASCADE
) TABLESPACE "IG_SPACE" ; 


CREATE TABLE "ig".QuartzJobDetails(
	qjdid integer not null , 
	qjid integer , 
	qjdtriname VARCHAR(32) ,
	qjdtrigrpname VARCHAR(32) ,
	qjdtime VARCHAR(16) ,
	qjdweek VARCHAR(16) , 
	qjdtype VARCHAR(4), 
	FINGERPRINT VARCHAR(256),
	PRIMARY KEY (qjdid),
	FOREIGN KEY (qjid) REFERENCES "ig".QuartzJobs(qjid)
		ON DELETE CASCADE 
) TABLESPACE "IG_SPACE" ; 


CREATE TABLE "ig".IG433	
(	
	paid  INTEGER  NOT NULL,
	paprid  INTEGER NOT NULL,
	pauserid VARCHAR(16),
	paprname  VARCHAR(200),
	paassessmentdes  VARCHAR(512),
	paassessmentdate  CHAR(16),
	paeventtypecode VARCHAR(32),
	PAATTKEY VARCHAR(32),
	PASTATUS CHAR(1),
	fingerprint varchar(256),
	PRIMARY KEY (paid),               
	FOREIGN KEY(paprid) REFERENCES "ig".IG500(prid)
		ON DELETE CASCADE
) TABLESPACE "IG_SPACE";	


CREATE TABLE "ig".IG229	
(	
	padid  INTEGER  NOT NULL,
	padprid  INTEGER NOT NULL,
	padaffectsystem  VARCHAR(8),
	padstart  CHAR(16),
	padend  CHAR(16),
	fingerprint varchar(256),
	PRIMARY KEY (padid),
	FOREIGN KEY(padprid) REFERENCES "ig".IG500(prid)
		ON DELETE CASCADE
) TABLESPACE "IG_SPACE";


CREATE TABLE "ig".IG105
(
	pdid CHAR(7) NOT NULL,
	prstatus CHAR NOT NULL,
	prurgency CHAR NOT NULL,
	psdversion INTEGER NOT NULL,
	expecttime INTEGER,
	createtime CHAR(16),
	fingerprint VARCHAR(256),
	PRIMARY KEY (pdid, prstatus, prurgency, psdversion),
	FOREIGN KEY (pdid) REFERENCES "ig".IG380(pdid)
		ON DELETE CASCADE
) TABLESPACE "IG_SPACE";


CREATE TABLE "ig".PRIORITY(	 
  	uvalue VARCHAR(64)  NOT NULL,
	ivalue VARCHAR(64)  NOT NULL,
 	pprtype VARCHAR(3) NOT NULL,
	pvalue VARCHAR(64),
  	FINGERPRINT	VARCHAR(256),
	PRIMARY KEY (pprtype,uvalue,ivalue)
) TABLESPACE "IG_SPACE";


CREATE TABLE "ig".KNOWLEDGE
(
	KNID INTEGER NOT NULL,
	KNVERSION INTEGER NOT NULL,
	KNSERIAL VARCHAR(32),
	KNDEPARTMENT VARCHAR(128),
	KNAPPROVER VARCHAR(16),
	KNAPPROVERNAME VARCHAR(32),
	KNAPPROVETIME CHAR(16),
	KNCLASS VARCHAR(32),
	KNCLASSNAME VARCHAR(64),
	KNAREA VARCHAR(32),
	KNAREANAME VARCHAR(64),
	KNTELAREA VARCHAR(32),
	KNTELAREANAME VARCHAR(64),
	KNKEY VARCHAR(128),
	KNORIGIN VARCHAR(32),
	KNORIGINNAME VARCHAR(64),
	KNPROFFER VARCHAR(16),
	KNPROFFERNAME VARCHAR(32),
	KNPROFFERTIME CHAR(16),
	KNTITLE VARCHAR(200),
	KNDES VARCHAR(1024),
	KNFAULTCAUSE VARCHAR(1024),
	KNSOLVEWAY VARCHAR(1024),
	KNSTATUS CHAR(1),
	KNREJECT VARCHAR(1024),
	KNATTKEY VARCHAR(32),
	FINGERPRINT VARCHAR(256),
	KNAPPROVEROLE INTEGER,
	PRIMARY KEY (KNID,KNVERSION)
) TABLESPACE "IG_SPACE";


CREATE TABLE "ig".KNOWLEDGEAPPIMPACT
(
	KAIID INTEGER NOT NULL,
	KNID INTEGER,
	KAICODE VARCHAR(8),
	FINGERPRINT VARCHAR(256),
	KNVERSION INTEGER,
	PRIMARY KEY (KAIID)
) TABLESPACE "IG_SPACE";


CREATE TABLE "ig".KNOWLEDGEGRADE
(
	KGID INTEGER NOT NULL,
	KNID INTEGER,
	KGGRADE DECIMAL(8,2),
	KGAPPRAISE VARCHAR(512),
	KGUSERID VARCHAR(16),
	KGTIME CHAR(16),
	FINGERPRINT VARCHAR(256),
	PRIMARY KEY (KGID)
) TABLESPACE "IG_SPACE";


CREATE TABLE "ig".KNOWLEDGEPROCESS
(
	KPID INTEGER NOT NULL,
	KNID INTEGER,
	KNVERSION INTEGER,
	PRID INTEGER,
	SFID INTEGER,
	CONNECTTYPE CHAR(1),
	KPEFFECT CHAR(1),
	FINGERPRINT VARCHAR(256),
	PRIMARY KEY (KPID)
) TABLESPACE "IG_SPACE";


CREATE TABLE "ig".KNOWLOG
(
	KLID INTEGER NOT NULL,
	KLKID INTEGER,
	KLTIME VARCHAR(16),
	KLROLEID VARCHAR(16),
	KLROLENAME VARCHAR(64),
	KLUSERID VARCHAR(16),
	KLUSERNAME VARCHAR(64),
	KLDESC VARCHAR(1024),
	KLCOMMEND VARCHAR(512),
	KLORGID VARCHAR(32),
	KLORGNAME VARCHAR(128),
	FINGERPRINT VARCHAR(256),
	PRIMARY KEY (KLID)
) TABLESPACE "IG_SPACE";


CREATE TABLE "ig".DELAY
(
	ID INTEGER NOT NULL,
	DATETIME VARCHAR(16),
	ORGNAME VARCHAR(64),
	TITLE VARCHAR(10),
	HZNAME VARCHAR(16),
	HZTEL VARCHAR(16),
	JLNAME VARCHAR(16),
	JLTEL VARCHAR(16),
	REMARK VARCHAR(256),
	STARTTIME VARCHAR(20),
	ENDTIME VARCHAR(20),
	OPERATER VARCHAR(20),
	FINGERPRINT VARCHAR(256),
	UNLOCKTIME VARCHAR(16),
	PRIMARY KEY (ID)
) TABLESPACE "IG_SPACE";


CREATE TABLE "ig".ONDUTYPERSONRECORD
(
  ODPRID         INTEGER NOT NULL,
  ODPRGUEST      VARCHAR(256), 
  ODPRGUESTORG   VARCHAR(256),
  ODPRGUESTIDNUM VARCHAR(32),
  ODPRAREA       VARCHAR(32),
  ODPRCTIME      VARCHAR(16),
  ODPRLTIME      VARCHAR(16),
  ODPROPTER      VARCHAR(32),
  ODPRACTER      VARCHAR(32),
  ODPRUSERNAME   VARCHAR(32),
  ODPRTARGET     VARCHAR(256),
  ODPRRECORD     VARCHAR(1024),
  ODPRINSERTTIME VARCHAR(10),
  ODPRMODTIME    VARCHAR(16),
  FINGERPRINT    VARCHAR(256),
  PRIMARY KEY (ODPRID)
)TABLESPACE "IG_SPACE";


CREATE TABLE "ig".EIBELONGRELATION
(
	BRID INTEGER NOT NULL,
	BRPAREIID INTEGER NOT NULL,
	BRPARVERSION INTEGER NOT NULL,
	BRPARSMALLVERSION INTEGER NOT NULL,
	BRCLDEIID INTEGER NOT NULL,
	BRCLDVERSION INTEGER NOT NULL,
	BRCLDSMALLVERSION INTEGER NOT NULL,
	BRTYPE CHAR(1),
	BRDES VARCHAR(256),
	BRCREATETIME CHAR(16),
	BRRALETIONCODE VARCHAR(32),
	BRASSETRELATION VARCHAR(4),
	EIROOTMARK INTEGER,
	DELETEFLAG CHAR(1),
	FINGERPRINT VARCHAR(256),
	PRIMARY KEY (BRID)
) TABLESPACE "IG_SPACE";


CREATE TABLE "ig".IG700
(
	PDID CHAR(7) NOT NULL,
	ROLEID INTEGER NOT NULL,
	FINGERPRINT VARCHAR(256),
	PRIMARY KEY (PDID, ROLEID),
	FOREIGN KEY (PDID) REFERENCES "ig".IG380(PDID) ON DELETE CASCADE,
	FOREIGN KEY (ROLEID) REFERENCES "ig".ROLE (ROLEID) ON DELETE CASCADE
) TABLESPACE "IG_SPACE";


CREATE TABLE "ig".IG701
(
	PDID CHAR(7) NOT NULL,
	ROLEID INTEGER NOT NULL,
	PIDID CHAR(10) NOT NULL,
	FINGERPRINT VARCHAR(256),
	PRIMARY KEY (PDID, ROLEID, PIDID),
	FOREIGN KEY (PDID) REFERENCES "ig".IG380(PDID) ON DELETE CASCADE,
	FOREIGN KEY (ROLEID) REFERENCES "ig".ROLE (ROLEID) ON DELETE CASCADE,
	FOREIGN KEY (PIDID) REFERENCES "ig".IG007 (PIDID) ON DELETE CASCADE
) TABLESPACE "IG_SPACE";


CREATE TABLE "ig".IG911        
(
    psprpid char(13) NOT NULL,
    pdid char(7) not null,
    psdid CHAR(10) not null,
    roleid integer not null,
    relevantPdid char(5),
    FINGERPRINT VARCHAR(256),
    PRIMARY KEY (psprpid),
    FOREIGN KEY (pdid) REFERENCES "ig".ig380 (pdid) ON DELETE CASCADE,
    FOREIGN KEY (psdid) REFERENCES "ig".ig333 (psdid) ON DELETE CASCADE,
    FOREIGN KEY (roleid) REFERENCES "ig".role (roleid) ON DELETE CASCADE
) TABLESPACE "IG_SPACE";


CREATE TABLE "ig".IG931
(
    dpsprpid char(13) NOT NULL,
    pdid char(7) not null,
    psdid CHAR(10) not null,
    relevantPdid char(5),
    FINGERPRINT VARCHAR(256),
    PRIMARY KEY (dpsprpid),
    FOREIGN KEY (pdid) REFERENCES "ig".ig380 (pdid) ON DELETE CASCADE,
    FOREIGN KEY (psdid) REFERENCES "ig".ig333 (psdid) ON DELETE CASCADE
) TABLESPACE "IG_SPACE";


CREATE TABLE "ig".CUSTOMCONFIGURATION
(
	RFDID INTEGER NOT NULL,
	PDID VARCHAR(50),
	PRSTATUSINFO VARCHAR(2000),
	PIDID VARCHAR(12),
	PIDVALUE VARCHAR(2000),
	USERID VARCHAR(32),
	CREATETIME VARCHAR(16),
	UPDATETIME VARCHAR(16),
	FINGERPRINT VARCHAR(128),
	PRIMARY KEY (RFDID)
) TABLESPACE "IG_SPACE";


create sequence "ig".PDID_SEQ
	minvalue 1
	maxvalue 99999
	start with 1000
	increment by 1
	cache 20;

CREATE TABLE "ig".TOPOXML (
  MYID VARCHAR(256) NOT NULL ,
  AIXS VARCHAR(256) NOT NULL ,
  FINGERPRINT VARCHAR(256) NULL ,
  PRIMARY KEY (MYID) 
) TABLESPACE "IG_SPACE";


CREATE TABLE "ig".userCheckingIn (
  UCID INTEGER NOT NULL,
  UCUSERID VARCHAR(16),
  UCUSERNAME VARCHAR(32),
  UCORGID VARCHAR(32),
  UCORGNAME VARCHAR(128),
  UCYEAR VARCHAR(4),
  UCMONTH VARCHAR(2),
  UCDAY VARCHAR(2),
  CHECKINTIME VARCHAR(5),
  CHECKOUTTIME VARCHAR(5),
  UCDESC VARCHAR(512),
  FINGERPRINT VARCHAR(256),
  UCBELATE VARCHAR(4),
  UCLEAVEEARLY VARCHAR(3),
  UCLEAVETYPE VARCHAR(8),
  UCLEAVEDURATION VARCHAR(16),
  UCSTARTTIME VARCHAR(5),
  UCENDTIME VARCHAR(5),
  UCSTATE VARCHAR(4),
  PRIMARY KEY (UCID)
);


CREATE TABLE "ig".OVERTIMERECORD (
  otrid  INTEGER  NOT NULL,
  userid  VARCHAR(32)  ,
  PROJECTID  INTEGER  ,
  CTIME  VARCHAR(16)  ,
  overTime  VARCHAR(32)  ,
  workTime  INTEGER ,
  overdate VARCHAR(16),
  overTimeDesc  varCHAR(256)  ,
  workcontext  VARCHAR(256)  ,
  FINGERPRINT  VARCHAR(256)  ,
  PRIMARY KEY (otrid)
) TABLESPACE "IG_SPACE";


CREATE TABLE "ig".PROJECT_LIST (
  PRJ_ID  INTEGER  NOT NULL,
  PRJ_NAME  VARCHAR(64)  ,
  PRJ_STATUS CHAR(1)  ,
  CTIME  VARCHAR(16)  ,
  FINGERPRINT  VARCHAR(256)  ,
  PRIMARY KEY (PRJ_ID)
) TABLESPACE "IG_SPACE";


CREATE TABLE "ig".CONTROLCONNINFO (
  SYSID        INTEGER NOT NULL,
  SYSNAME      VARCHAR(150),
  SYSDBTYPE    CHAR(1),
  SYSVALUE     VARCHAR(1000),
  SYSPARAM     VARCHAR(1000),
  SYSDBNAME    VARCHAR(150),
  SYSDBPWD     VARCHAR(150),
  FINGERPRINT  VARCHAR(256),
  SYSTABLENAME VARCHAR(150),
  SYSFILETYPE  CHAR(1),
  SYSTIME      VARCHAR(16),
  SYSDBURL     VARCHAR(300),
  SYSFILEPATH  VARCHAR(1000),
  SYSSTATUS    CHAR(1),
  SYSFTPPORT   VARCHAR(5),
  SYSREADLINE  VARCHAR(5),
  PRIMARY KEY (SYSID)
) TABLESPACE "IG_SPACE";


CREATE TABLE "ig".BUSINESSTABLEDETAIL (
  disid       INTEGER not null,
  sysid       INTEGER,
  disname     VARCHAR(150),
  discolum    VARCHAR(150),
  disphyname  VARCHAR(150),
  dispk       CHAR(1),
  disshowflg  CHAR(1),
  dissyn      CHAR(1),
  dissynvalue VARCHAR(128),
  fingerprint VARCHAR(256),
  PRIMARY KEY (DISID),
  FOREIGN KEY (SYSID) REFERENCES "ig".CONTROLCONNINFO(SYSID) ON DELETE CASCADE
) TABLESPACE "IG_SPACE";

create sequence "ig".SYS_AUTO_SEQ 
	minvalue 1
	maxvalue 9999999999
	start with 1
	increment by 1
	cache 20;


CREATE TABLE "ig".ProjectLogContract  (
		plcid INTEGER NOT NULL,
		plcsum decimal,
		plcsumterm VARCHAR(512),
		plcfirst decimal,
		plcfirstterm VARCHAR(512),
		plcsecond decimal,
		plcsecondterm VARCHAR(512),
		plcthird decimal,
		plcthirdterm VARCHAR(512),
		plcfourth decimal,
	 	plcfourthterm VARCHAR(512),
		plcfifth decimal,
		plcfifthterm VARCHAR(512),
		plcpid INTEGER,
		plcplid INTEGER,
		bzdevelop FLOAT,
		bzhardware FLOAT,
		bzsoftware FLOAT,
		bzproject FLOAT,
		bzelse FLOAT,
		bcimplement FLOAT,
		bcelse FLOAT,
		plcnumber VARCHAR(128),
	 	fingerprint VARCHAR(256),
		PRIMARY KEY (plcid)
)TABLESPACE "IG_SPACE";


CREATE TABLE "ig".ProjectLogBusiness  
(
		plbid INTEGER NOT NULL,
		plbplcsum decimal,
		plbfirst decimal,
		plbsecond decimal,
		plbthird decimal,
		plbfourth decimal,
	 	plbfifth decimal,
	 	plbpid INTEGER,
		plbplid INTEGER,
		plbsum decimal,
		plbscale decimal,
		plbnotsum decimal,
		plbnotscale decimal,
	 	fingerprint VARCHAR(256),
		PRIMARY KEY (plbid)
)TABLESPACE "IG_SPACE";

--项目预算关系表
CREATE TABLE "ig".ProjectBudgetRelation
(
       pbid Integer primary key,
       pid Integer ,
       bid Integer,
       bzdevelop FLOAT,
       bzhardware FLOAT,
       bzsoftware FLOAT,
       bzproject FLOAT,
       bzelse FLOAT,
       bcimplement FLOAT,
       bcelse FLOAT,
       pbdatetime char(16),
       fingerprint varchar(256)
)TABLESPACE "IG_SPACE";

--SOC原功能_作息时间设定
CREATE TABLE "ig".ProcessTime
(
	prtid INTEGER NOT NULL,
	prid INTEGER,
	userid VARCHAR(16),
	prtstarttime VARCHAR(20),
	prtstartstatus CHAR(1),
	prtendtime VARCHAR(20),
    prtendstatus CHAR(1),
    facttime INTEGER,
	fingerPrint VARCHAR(256),
	CONSTRAINT processtime_pkey PRIMARY KEY (prtid )
)TABLESPACE "IG_SPACE";
CREATE TABLE "ig".ProcessWorkTime
(
	pwid INTEGER NOT NULL,
	userid VARCHAR(16),
	pwdate VARCHAR(10),
	pwstarttime VARCHAR(6),
	pwendtime VARCHAR(6),
	pwsleep INTEGER,
    pwflg  CHAR(1),
    facttime INTEGER,
	fingerPrint VARCHAR(256),
	CONSTRAINT processworktime_pkey PRIMARY KEY (pwid )
)TABLESPACE "IG_SPACE";
CREATE TABLE "ig".ProcessWorkTimeTemplate
(
	pwtid INTEGER NOT NULL,
	pwtdate VARCHAR(10),
	pwtstarttime VARCHAR(6),
	pwtendtime VARCHAR(6),
    pwtsleeptime INTEGER,
    facttime INTEGER,
	fingerPrint VARCHAR(256),
	CONSTRAINT processworktimetemplate_pkey PRIMARY KEY (pwtid )
)TABLESPACE "IG_SPACE";


--配置定时采集SQL  王省
--DROP TABLE ig.timer01;
CREATE TABLE ig.timer01
(
	uuid character varying(32) NOT NULL,
	name character varying(64),
	typename character varying(64) NOT NULL,
	platformname character varying(64),
	resourceid integer NOT NULL,
	collecttype character(1) NOT NULL,
	startrule character varying(64),
	stoprule character varying(64),
	starttime character varying(16),
	stoptime character varying(16),
	newstarttime character varying(16),
	newstoptime character varying(16),
	executstatus character(1),
	periodtype character(1),
	fingerprint character varying(64),
	CONSTRAINT timer01_pkey PRIMARY KEY (uuid)
)
WITH (
OIDS=FALSE
);
ALTER TABLE ig.timer01
OWNER TO postgres;


CREATE SEQUENCE ig.timer02_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE ig.timer02_seq
  OWNER TO postgres;


--DROP TABLE ig.timer02;
CREATE TABLE "ig"."timer02" (
	"id" int4 DEFAULT nextval('"ig".timer02_seq'::regclass) NOT NULL,
	"uuid" varchar(32) NOT NULL,
	"name" varchar(64) NOT NULL,
	"typename" varchar(64) NOT NULL,
	"collectdate" varchar(16) NOT NULL,
	"executrule" varchar(64) NOT NULL,
	"executstatus" char(1),
	"periodtype" char(1) NOT NULL,
	"fingerprint" varchar(16),
	"executmessage" varchar(1024),
	CONSTRAINT "timer02_pkey" PRIMARY KEY ("id")
)
WITH (OIDS=FALSE);

ALTER TABLE "ig"."timer02" OWNER TO "postgres";


/* Drop Tables */

DROP TABLE IF EXISTS IG.CRM01;
DROP TABLE IF EXISTS IG.CRM02;
DROP TABLE IF EXISTS IG.CRM03;
DROP TABLE IF EXISTS IG.CRM04;
DROP TABLE IF EXISTS IG.CRM05;
DROP TABLE IF EXISTS IG.CRM06;
DROP TABLE IF EXISTS IG.CRM07;
DROP TABLE IF EXISTS IG.CRM08;
DROP TABLE IF EXISTS IG.CRM09;

DROP SEQUENCE  IF EXISTS ig.crm01_seq;
DROP SEQUENCE  IF EXISTS ig.crm02_seq;
DROP SEQUENCE  IF EXISTS ig.crm03_seq;
DROP SEQUENCE  IF EXISTS ig.crm04_seq;
DROP SEQUENCE  IF EXISTS ig.crm05_seq;
DROP SEQUENCE  IF EXISTS ig.crm06_seq;
DROP SEQUENCE  IF EXISTS ig.crm07_seq;
DROP SEQUENCE  IF EXISTS ig.crm08_seq;
DROP SEQUENCE  IF EXISTS ig.crm09_seq;

CREATE TABLE ig.crm02
(
  collecttime character varying(20),
  tablename character varying(32) NOT NULL,
  status character(1),
  fingerprint character varying(256),
  CONSTRAINT crm02_pkey PRIMARY KEY (tablename)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE ig.crm02
  OWNER TO postgres;


-- Table: ig.crm03

-- DROP TABLE ig.crm03;

CREATE TABLE ig.crm03
(
  collecttime character varying(20),
  tablename character varying(32),
  host character varying(32),
  status character(1),
  type character varying(32),
  servername character varying(32),
  servertype integer,
  ip character varying(32),
  fingerprint character varying(256)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE ig.crm03
  OWNER TO postgres;



CREATE SEQUENCE ig.crm04_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1000
  CACHE 1;
ALTER TABLE ig.crm04_seq
  OWNER TO postgres;

-- Table: ig.crm04

-- DROP TABLE ig.crm04;

CREATE TABLE ig.crm04
(
  alarmid integer NOT NULL DEFAULT nextval('ig.crm04_seq'::regclass),
  serverid integer,
  ruletempid integer,
  serverip character varying(32),
  servername character varying(32),
  rulelevel integer,
  alarmtime character varying(20),
  alarmmsg character varying(256),
  collecttime character varying(20),
  alarmstate character(1),
  category character varying(32),
  fingerprint character varying(256),
  objectname character varying(64),
  CONSTRAINT crm04_pkey PRIMARY KEY (alarmid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE ig.crm04
  OWNER TO postgres;


CREATE SEQUENCE ig.crm05_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1000
  CACHE 1;
ALTER TABLE ig.crm05_seq
  OWNER TO postgres;

CREATE TABLE ig.crm05
(
  fileid integer NOT NULL DEFAULT nextval('ig.crm05_seq'::regclass),
  filename character varying(64),
  uploadtime character varying(20),
  filepath character varying(256),
  fingerprint character varying(256),
  CONSTRAINT crm05_pkey PRIMARY KEY (fileid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE ig.crm05
  OWNER TO postgres;


CREATE SEQUENCE ig.crm06_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1000
  CACHE 1;
ALTER TABLE ig.crm06_seq
  OWNER TO postgres;

-- Table: ig.crm06

-- DROP TABLE ig.crm06;

CREATE TABLE ig.crm06
(
  serverid integer NOT NULL DEFAULT nextval('ig.crm06_seq'::regclass),
  fileid integer,
  servername character varying(64),
  servertype character varying(64),
  ip character varying(32),
  ip2 character varying(32),
  status character(1),
  alarmstatus character(1),
  createmessage character varying(128),
  fingerprint character varying(256),
  host character varying(64),
  CONSTRAINT crm06_pkey PRIMARY KEY (serverid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE ig.crm06
  OWNER TO postgres;



CREATE SEQUENCE ig.crm07_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1000
  CACHE 1;
ALTER TABLE ig.crm07_seq
  OWNER TO postgres;

CREATE TABLE ig.crm07
(
  ruleconditionid integer NOT NULL DEFAULT nextval('ig.crm07_seq'::regclass), -- 条件主键
  ruletempid integer, -- 规则模板ID
  alarmmsg character varying(256), -- 对比告警内容
  alarmcondition integer, -- 对比条件...
  createtime character varying(20),
  fingerprint character varying(256),
  CONSTRAINT crm07_pkey PRIMARY KEY (ruleconditionid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE ig.crm07
  OWNER TO postgres;


CREATE SEQUENCE ig.crm08_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1000
  CACHE 1;
ALTER TABLE ig.crm08_seq
  OWNER TO postgres;


-- Table: ig.crm08

-- DROP TABLE ig.crm08;

CREATE TABLE ig.crm08
(
  ruletempid integer NOT NULL DEFAULT nextval('ig.crm08_seq'::regclass),
  ruletempname character varying(32),
  categoryccid character varying(16),
  typecid character varying(16),
  typeccid character varying(16),
  alarmlevel integer,
  rulecondition integer,
  tempstate integer,
  createtime character varying(20),
  detail character varying(128),
  categorycid character varying(16),
  fingerprint character varying(256),
  CONSTRAINT crm08_pkey PRIMARY KEY (ruletempid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE ig.crm08
  OWNER TO postgres;


CREATE SEQUENCE ig.crm09_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1000
  CACHE 1;
ALTER TABLE ig.crm09_seq
  OWNER TO postgres;

-- Table: ig.crm09

-- DROP TABLE ig.crm09;

CREATE TABLE ig.crm09
(
  relationid integer NOT NULL DEFAULT nextval('ig.crm09_seq'::regclass),
  serverid integer, -- 监控对象ID
  ruletempid integer, -- 规则模板ID
  maxalarmnum integer, -- 对比告警次数
  maxalarmtime integer, -- 对比告警最大间隔时间(分钟)
  createtime character varying(20),
  fingerprint character varying(256),
  CONSTRAINT crm09_pkey PRIMARY KEY (relationid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE ig.crm09
  OWNER TO postgres;



-- Table: ig.crm10

-- DROP TABLE ig.crm10;

CREATE TABLE ig.crm10
(
  host character varying(32),
  ip character varying(32),
  servername character varying(128),
  servertype integer,
  collecttime character varying(20),
  command character varying(512),
  cdataorder integer,
  cdata character varying(1024),
  inserttime character varying(20),
  category character varying(512),
  keys character varying(512),
  fingerprint character varying(512),
  objectname character varying(64),
  alarmkey character varying(64),
  unit character varying(16)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE ig.crm10
  OWNER TO postgres;


/* Comments */

COMMENT ON COLUMN IG.CRM07.RULECONDITIONID IS '条件主键';
COMMENT ON COLUMN IG.CRM07.RULETEMPID IS '规则模板ID';
COMMENT ON COLUMN IG.CRM07.ALARMMSG IS '对比告警内容';
COMMENT ON COLUMN IG.CRM07.ALARMCONDITION IS '对比条件
0 没有条件
1 包含
2 等于
3 大于
4 小于
';
COMMENT ON COLUMN IG.CRM08.RULETEMPNAME IS '模板名称';
COMMENT ON COLUMN IG.CRM08.CATEGORYCCID IS '指标CCID';
COMMENT ON COLUMN IG.CRM08.RULECONDITION IS '规则条件
0：与
1：或
';
COMMENT ON COLUMN IG.CRM08.TEMPSTATE IS '0 无效
1 有效
';
COMMENT ON COLUMN IG.CRM09.SERVERID IS '监控对象ID';
COMMENT ON COLUMN IG.CRM09.RULETEMPID IS '规则模板ID';
COMMENT ON COLUMN IG.CRM09.MAXALARMNUM IS '对比告警次数';
COMMENT ON COLUMN IG.CRM09.MAXALARMTIME IS '对比告警最大间隔时间(分钟)';



-- 邮件告警表DDL
-- crm04fk 实时告警表id外键
-- inserttime 插入记录时间
-- senttime 邮件发送时间
-- sentstatus 0 -> 未发送 , 1 -> 已发送
CREATE SEQUENCE ig.AlermSendMailQueue_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1000
  CACHE 1;
ALTER TABLE ig.AlermSendMailQueue_seq OWNER TO postgres;

--Drop TABLE ig.AlermSendMailQueue;
CREATE TABLE ig.AlermSendMailQueue
(
   mid INTEGER NOT NULL DEFAULT nextval('ig.AlermSendMailQueue_seq'::regclass),
   crm04fk integer, 
   inserttime varchar(20),
   senttime varchar(20), 
   sentstatus char(1),
   fingerprint varchar(256), 
   PRIMARY KEY (mid)
)