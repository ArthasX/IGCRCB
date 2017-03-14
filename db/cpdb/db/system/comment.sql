--Role
comment on table Role is '��ɫ��';
comment on column Role.roleid is '��ɫID';
comment on column Role.rolename is '��ɫ����';
comment on column Role.roledesc is '��ɫ˵��';
comment on column Role.roleinfo is '��ɫ��Ϣ';
comment on column Role.roletype is '��ɫ����';
comment on column Role.roledomain is '��ɫ����������Χ';
comment on column Role.assetdomain is '��ɫ�ʲ�ģ�͹�����Χ';
comment on column Role.fingerprint is 'ʱ���';

--Action
comment on table Action is '�˵���';
comment on column Action.actname is '�˵���ʶ';
comment on column Action.actlabel is '�˵���ʾ����';
comment on column Action.actdesc is '�˵�˵��';
comment on column Action.acturl is '�ύURL';
comment on column Action.acttype is '�˵�����';
comment on column Action.actl1id is 'һ���˵�ID��������';
comment on column Action.actl2id is '�����˵�ID��������';
comment on column Action.actl3id is '�����˵�ID��������';
comment on column Action.fingerprint is 'ʱ���';
comment on column Action.actroletype is '�˵��������ɫ����';
comment on column Action.actsortid is '�˵���ʾ˳��';
comment on column Action.acturltype is '�ύURL����';

--RoleAction
comment on table RoleAction is '��ɫ�˵���';
comment on column RoleAction.raid is '��ɫ�˵�ID';
comment on column RoleAction.roleid is '��ɫID';
comment on column RoleAction.actname is '�˵���ʶ';
comment on column RoleAction.raperm is '��ɫ��Ӧ�˵���Ȩ�ޣ�������';
comment on column RoleAction.radesc is '��ɫ��Ӧ�˵���Ȩ��˵����������';
comment on column RoleAction.fingerprint is 'ʱ���';

--Organization
comment on table Organization is '������';
comment on column Organization.orgid is '����ID';
comment on column Organization.orgname is '��������';
comment on column Organization.orgpar is '�ϼ����������';
comment on column Organization.orgparname is '�ϼ��������ƣ�������';
comment on column Organization.orgdesc is '����˵��';
comment on column Organization.orgtype is '��������';
comment on column Organization.orgaddr is '������ַ';
comment on column Organization.orgphone is '�����绰';
comment on column Organization.orgfax is '��������';
comment on column Organization.orgcontact is '������ϵ��';
comment on column Organization.orgstatus is '����״̬';
comment on column Organization.orginfo is '������Ϣ';
comment on column Organization.orgsyscoding is '���������';
comment on column Organization.orgusercoding is '��������';
comment on column Organization.fingerprint is 'ʱ���';

--IgUser
comment on table IgUser is '�û���';
comment on column IgUser.userid is '�û�ID';
comment on column IgUser.orgid is '�������������';
comment on column IgUser.orgname is '������������';
comment on column IgUser.username is '�û�����';
comment on column IgUser.userdesc is '�û�˵��';
comment on column IgUser.userinfo is '�û���Ϣ';
comment on column IgUser.password is '�û�����';
comment on column IgUser.userstatus is '�û�״̬';
comment on column IgUser.usertype is '�û�����';
comment on column IgUser.userphone is '�û��绰';
comment on column IgUser.usermobile is '�û��ֻ�';
comment on column IgUser.useremail is '�û�����';
comment on column IgUser.fingerprint is 'ʱ���';
comment on column IgUser.deleteflag is '�߼�ɾ����ʶ';

--IG622
comment on table IG622 is '��ҳ��תURL�����';
comment on column IG622.HPID is '��ҳID';
comment on column IG622.HPLABEL is '��ҳ����';
comment on column IG622.HPTITLE is '��ҳ��ʾ����';
comment on column IG622.HPURL is '��ҳURL';
comment on column IG622.FINGERPRINT is 'ʱ���';

--UserRole
comment on table UserRole is '�û���ɫ��';
comment on column UserRole.urid is '�û���ɫID';
comment on column UserRole.userid is '�û�ID';
comment on column UserRole.orgid is '��ɫID';
comment on column UserRole.roleid is '���������';
comment on column UserRole.fingerprint is 'ʱ���';
comment on column UserRole.rolemanager is '��ɫ�����˱�ʶ';
comment on column UserRole.dutyflag is 'ֵ���˱�ʶ';

--Notice
comment on table Notice is '֪ͨ��';
comment on column Notice.nid is '֪ͨID';
comment on column Notice.nname is '֪ͨ����';
comment on column Notice.ndesc is '֪ͨ����';
comment on column Notice.ntime is '֪ͨʱ��';
comment on column Notice.nuserid is '�û�ID';
comment on column Notice.nusername is '�û�����';
comment on column Notice.norgid is '���������';
comment on column Notice.norgname is '��������';
comment on column Notice.nattkey is '����KEY';
comment on column Notice.fingerprint is 'ʱ���';

--CodeCategory
comment on table CodeCategory is '�������ݷ����';
comment on column CodeCategory.ccid is '���ݷ���ID';
comment on column CodeCategory.ccname is '���ݷ�������';
comment on column CodeCategory.ccinfo is '���ݷ���˵��';
comment on column CodeCategory.cceditable is '�༭��ʶ';
comment on column CodeCategory.pccid is '�ϼ����ݷ���ID';
comment on column CodeCategory.pcflag is '֧�������';
comment on column CodeCategory.fingerprint is 'ʱ���';

--CodeDetail
comment on table CodeDetail is '����������ϸ��Ϣ��';
comment on column CodeDetail.ccid is '���ݷ���ID';
comment on column CodeDetail.cid is '����ID';
comment on column CodeDetail.cvalue is '��������';
comment on column CodeDetail.pccid is '�ϼ����ݷ���ID';
comment on column CodeDetail.pcid is '�ϼ�����ID';
comment on column CodeDetail.updtime is '���ݸ���ʱ��';
comment on column CodeDetail.syscoding is '���ݲ����';
comment on column CodeDetail.psyscoding is '�ϼ����ݲ����';
comment on column CodeDetail.cdstatus is '����״̬';
comment on column CodeDetail.businesscode is '�ʲ�������ϵ��';
comment on column CodeDetail.fingerprint is 'ʱ���';
comment on column CodeDetail.cdinfo is '����˵��';
comment on column CodeDetail.cdorder is '������ʾ˳��';

--CODECATEGORYDEF
comment on table CODECATEGORYDEF is '�������ݷ����';
comment on column CODECATEGORYDEF.CCID is '�������ݷ���ID';
comment on column CODECATEGORYDEF.CCNAME is '�������ݷ�������';
comment on column CODECATEGORYDEF.CCINFO is '�������ݷ���˵��';
comment on column CODECATEGORYDEF.CCEDITABLE is '�༭��ʶ';
comment on column CODECATEGORYDEF.PCCID is '�ϼ����ݷ���ID'; 
comment on column CODECATEGORYDEF.PCFLAG is '֧�������';
comment on column CODECATEGORYDEF.FINGERPRINT is 'ʱ���';

--CODEDETAILDEF
comment on table CODEDETAILDEF is '����������ϸ��Ϣ��';
comment on column CODEDETAILDEF.CCID is '�������ݷ���ID'; 
comment on column CODEDETAILDEF.CID is '����ID';
comment on column CODEDETAILDEF.CVALUE is '��������';
comment on column CODEDETAILDEF.PCCID is '�ϼ����ݷ���ID';
comment on column CODEDETAILDEF.PCID is '�ϼ�����ID';
comment on column CODEDETAILDEF.UPDTIME is '���ݸ���ʱ��';
comment on column CODEDETAILDEF.SYSCODING is '���ݲ����';
comment on column CODEDETAILDEF.PSYSCODING is '�ϼ����ݲ����';
comment on column CODEDETAILDEF.CDSTATUS is '����״̬';
comment on column CODEDETAILDEF.BUSINESSCODE is 'ҵ���ʶ';
comment on column CODEDETAILDEF.CDINFO is '����˵��';
comment on column CODEDETAILDEF.FINGERPRINT is 'ʱ���';

--IG117
comment on table IG117 is '�ʲ�ģ�ͱ�';
comment on column IG117.eid is 'ģ��ID';
comment on column IG117.ename is 'ģ������';
comment on column IG117.elabel is 'ģ�ͱ�ʶ';
comment on column IG117.edesc is 'ģ��˵��';
comment on column IG117.estatus is 'ģ��״̬';
comment on column IG117.ecategory is 'ģ�ͷ���';
comment on column IG117.ekey1 is '����';
comment on column IG117.ekey2 is '����';
comment on column IG117.ekey3 is '����';
comment on column IG117.esyscoding is 'ģ�Ͳ����';
comment on column IG117.eparcoding is '�ϼ�ģ�Ͳ����';
comment on column IG117.fingerprint is 'ʱ���';
comment on column IG117.emodeltype is 'ģ������';

--IG225
comment on table IG225 is '�ʲ����ñ�';
comment on column IG225.cid is '����ID';
comment on column IG225.eid is '�ʲ�ģ��ID';
comment on column IG225.cname is '��������';
comment on column IG225.clabel is '���ùؼ���';
comment on column IG225.cdesc is '����˵��';
comment on column IG225.cunit is '���õ�λ';
comment on column IG225.cstatus is '����״̬';
comment on column IG225.cseq is '���ÿɼ���ʶ';
comment on column IG225.ccategory is '�������';
comment on column IG225.coption is '����ȡֵ��Χ';
comment on column IG225.cattach is '������������';
comment on column IG225.esyscoding is '�ʲ�ģ�Ͳ����';
comment on column IG225.fingerprint is 'ʱ���';
comment on column IG225.crequired is '���ñ����ʶ';

--IG545
comment on table IG545 is '�ʲ�����ȡֵ��Χ��';
comment on column IG545.ccdid is '����ID';
comment on column IG545.ccdcategory is '���ݱ���';
comment on column IG545.ccdlabel is '��������';
comment on column IG545.ccdvalue is '����ֵ';
comment on column IG545.ccdstatus is '����״̬';
comment on column IG545.ccdtype is '��������';
comment on column IG545.ccdinfo is '����˵��';
comment on column IG545.fingerprint is 'ʱ���';

--IG611
comment on table IG611 is '�ʲ�������ȱʡֵ��';
comment on column IG611.EID is '�ʲ�ģ��ID';
comment on column IG611.CID is '�ʲ�����ID';
comment on column IG611.CVALUE is 'ȱʡֵ';
comment on column IG611.FINGERPRINT is 'ʱ���';

--IG013
comment on table IG013 is '�ʲ���';
comment on column IG013.eiid is '�ʲ�ID';
comment on column IG013.eid is '�ʲ�ģ��ID';
comment on column IG013.eidesc is '�ʲ�˵��';
comment on column IG013.einame is '�ʲ�����';
comment on column IG013.eilabel is '�ʲ����';
comment on column IG013.eiinsdate is '�ʲ��Ǽ�����';
comment on column IG013.eiorgsyscoding is '�ʲ��������������';
comment on column IG013.esyscoding is '�ʲ�����ģ�Ͳ����';
comment on column IG013.eiupdtime is '�ʲ�����ʱ��';
comment on column IG013.eistatus is '�ʲ�״̬';
comment on column IG013.eiversion is '�ʲ���汾';
comment on column IG013.fingerprint is 'ʱ���';
comment on column IG013.eiuserid is '�ʲ�������ID';
comment on column IG013.eiusername is '�ʲ�����������';
comment on column IG013.eismallversion is '�ʲ�С�汾';
comment on column IG013.eirootmark is '�ʲ��������ڵ�ʵ���ʶ';

--IG800
comment on table IG800 is '�ʲ��������';
comment on column IG800.ciid is '�ʲ�������ID';
comment on column IG800.cid is '�ʲ�����ID';
comment on column IG800.eiid is '�ʲ�ID';
comment on column IG800.eid is '�ʲ�ģ��ID';
comment on column IG800.civalue is '������ֵ';
comment on column IG800.ciupdtime is '���������ʱ��';
comment on column IG800.esyscoding is '�ʲ�ģ�Ͳ����';
comment on column IG800.ciexpire is '����';
comment on column IG800.cistatus is '����';
comment on column IG800.cicurver is '������ֵ�Ƿ���';
comment on column IG800.civersion is '�������汾';
comment on column IG800.civerinfo is '����';
comment on column IG800.fingerprint is 'ʱ���';
comment on column IG800.cismallversion is '������С�汾';

--IG313
comment on table IG313 is '�ʲ���ϵ��';
comment on column IG313.eirid is '�ʲ���ϵID';
comment on column IG313.pareiid is '�ʲ�ID������';
comment on column IG313.pareid is '�ʲ�ģ��ID������';
comment on column IG313.cldeiid is '�ʲ�ID������';
comment on column IG313.cldeid is '�ʲ�ģ��ID������';
comment on column IG313.eirrelation is '������ϵ��ʶ';
comment on column IG313.eirrelationcode is '��ϵ��ͷ';
comment on column IG313.eirupdtime is '����ʱ��';
comment on column IG313.eirstatus is '��ɾ����ʶ';
comment on column IG313.eirdesc is '��ϵ˵��';
comment on column IG313.fingerprint is 'ʱ���';
comment on column IG313.eirinfo is '�����ϵ��ʶ';
comment on column IG313.parversion is '�ʲ���汾������';
comment on column IG313.parsmallversion is '�ʲ�С�汾������';
comment on column IG313.cldversion is '�ʲ���汾������';
comment on column IG313.cldsmallversion is '�ʲ�С�汾������';
comment on column IG313.deleteflag is '�߼�ɾ����ʶ';

--IG809
comment on table IG809 is '�ʲ���ϵͼ��Ϣ����������';
comment on column IG809.eirfid is '�ʲ���ϵͼ��ϢID';
comment on column IG809.eiid is '�ʲ�ID';
comment on column IG809.eirftype is '��ϵͼ����';
comment on column IG809.eirfname is '��ϵͼXML�ļ���';
comment on column IG809.eirfupdtime is '��ϵͼ����ʱ��';
comment on column IG809.fingerprint is 'ʱ���';

--COLLECTPARAM
comment on table COLLECTPARAM is '�����ɼ��ű��������������';
comment on column COLLECTPARAM.CPTYPEID is '��������';
comment on column COLLECTPARAM.CPSMODE is '�ű�����';
comment on column COLLECTPARAM.CPSCRIPTNAME is '�ű�����';
comment on column COLLECTPARAM.CPFILEPATH is '�ű�·��';
comment on column COLLECTPARAM.FINGERPRINT is 'ʱ���';

--compareTemplate
comment on table compareTemplate is '����λ����Ϣ��';
comment on column compareTemplate.ctid is 'λ����ϢID';
comment on column compareTemplate.ctcategory is '���ID';
comment on column compareTemplate.cttype is '����';
comment on column compareTemplate.ctxwidth is '�������';
comment on column compareTemplate.ctywidth is '�������';
comment on column compareTemplate.ctvalue is 'ֵ';
comment on column compareTemplate.fingerprint is 'ʱ���';

--IG259
comment on table IG259 is '����ģ���';
comment on column IG259.ptid is 'ģ��ID';
comment on column IG259.ptname is 'ģ������';
comment on column IG259.pttype is 'ģ������';
comment on column IG259.ptstartpg is 'ģ�淢��ҳURL';
comment on column IG259.ptdetailpg is 'ģ�洴��ʱ��';
comment on column IG259.ptcrtdate is 'ģ����Ϣ';
comment on column IG259.ptpicinfo is 'ģ��״̬';
comment on column IG259.ptstatus is 'ģ��鿴ҳURL';
comment on column IG259.ptsavepg is '����ҳURL';
comment on column IG259.ptqrtzflag is '��ʱ����URL';
comment on column IG259.fingerprint is 'ʱ���';

--IG380
comment on table IG380 is '�������ͱ�';
comment on column IG380.pdid is '��������ID';
comment on column IG380.ptid is '����ģ��ID';
comment on column IG380.pdname is '��������';
comment on column IG380.pddesc is '��������';
comment on column IG380.pdcrtdate is '����ʱ��';
comment on column IG380.pdstatus is '����״̬';
comment on column IG380.pdxml is '����ͼXML';
comment on column IG380.permission is 'Ȩ��';
comment on column IG380.fingerprint is 'ʱ���';
comment on column IG380.serialgenerator is '������������';
comment on column IG380.pdactname is '���̶����˵�ID';

--IG007
comment on table IG007 is '���̱��������';
comment on column IG007.pidid is '��������ID';
comment on column IG007.pdid is '���̶���ID';
comment on column IG007.pidname is '������ʶ';
comment on column IG007.pidlabel is '������ʾ����';
comment on column IG007.piddesc is '��������';
comment on column IG007.pidtype is '��������';
comment on column IG007.pidoption is '����ȡֵ��Χ';
comment on column IG007.piddefault is '����Ĭ��ֵ';
comment on column IG007.pidrequired is '�Ƿ����';
comment on column IG007.fingerprint is 'ʱ���';
comment on column IG007.pidsortid is '�����ʶ';
comment on column IG007.ccid is '�������ݷ���ID';
comment on column IG007.pidgid is 'ͨ�ñ�������ID';
comment on column IG007.PIDMODE is '����ģʽ';
comment on column IG007.PRIVATESCOPE is '˽�б���Ȩ�޷�Χ';
comment on column IG007.ROWWIDTH is '��������ʾģʽ';

--IG333
comment on table IG333 is '�Զ�������״̬�����';
comment on column IG333.psdid is '����״̬ID';
comment on column IG333.pdid is '���̶���ID';
comment on column IG333.psdname is '״̬����';
comment on column IG333.psddesc is '״̬����';
comment on column IG333.psdcode is '״̬��ʶ';
comment on column IG333.fingerPrint is 'ʱ���';
comment on column IG333.psdtype is '״̬����';
comment on column IG333.psdmode is '״̬ģʽ';
comment on column IG333.psdflag is '��̬�����߱�ʶ';
comment on column IG333.psdassign is '���ɲ���������';
comment on column IG333.psdorg is '���ɲ���������';
comment on column IG333.psdconfirm is '����ȷ�ϲ���';
comment on column IG333.assignpsdid is '���ɽڵ�ID';
comment on column IG333.assignpbdid is '���ɰ�ťID';
comment on column IG333.assignflag is '�Ƿ������ɱ�ʶ';
comment on column IG333.participantchange is '�������Ƿ�ɸ��ɱ�ʶ';
comment on column IG333.assignpagetype is '����ҳ������';

--IG258
comment on table IG258 is '�Զ������̿ɷ���״̬�����';
comment on column IG258.pspcdid is '��������';
comment on column IG258.psdid is 'Դ״̬';
comment on column IG258.pspcdpsdid is '�ɱ�����״̬';
comment on column IG258.fingerPrint is 'ʱ���';

--IG211
comment on table IG211 is '�Զ������̱���Ĭ��ֵ��������';
comment on column IG211.psidid is 'Ĭ��ֵID';
comment on column IG211.psdid is '����״̬ID';
comment on column IG211.pidid is '��������ID';
comment on column IG211.pidname is '������ʶ';
comment on column IG211.pidlabel is '������ʾ����';
comment on column IG211.piddesc is '��������';
comment on column IG211.pidtype is '��������';
comment on column IG211.pidvalue is '����ֵ';
comment on column IG211.pidattkey is '����KEY';
comment on column IG211.fingerPrint is 'ʱ���';

--IG900
comment on table IG900 is '�Զ������̰�ť�����';
comment on column IG900.pbdid is '��ťID';
comment on column IG900.pbdname is '��ťĬ������';
comment on column IG900.pbdflag is '�Ƿ�ϵͳ������ť';
comment on column IG900.pbdimage is '��ť��ʾͼƬ����';
comment on column IG900.fingerPrint is 'ʱ���';

--IG222
comment on table IG222 is '�Զ������̲����߶����';
comment on column IG222.ppdid is '������ID';
comment on column IG222.psdid is '����״̬ID';
comment on column IG222.roleid is '��ɫID';
comment on column IG222.userid is 'Ĭ�ϲ����û�ID';
comment on column IG222.ppdsuper is '�Ƿ�SUPER��ɫ';
comment on column IG222.fingerPrint is 'ʱ���';

--IG132
comment on table IG132 is '�����߰�ť������Ϣ��';
comment on column IG132.ppbdid is '��������';
comment on column IG132.ppdid is '�����߶���ID';
comment on column IG132.pbdid is '��ť����ID';
comment on column IG132.ppbdname is '��ť��ʾ����';
comment on column IG132.ppbddesc is '��ť��ʾ��Ϣ';
comment on column IG132.ppbdauth is '��ť�ύȨ��';
comment on column IG132.fingerPrint is 'ʱ���';

--IG881
comment on table Action is '�Զ������̲����߱���Ȩ�ޱ�';
comment on column IG881.pipdid is '�����߱���Ȩ��ID';
comment on column IG881.pidid is '��������ID';
comment on column IG881.psdid is '����״̬ID';
comment on column IG881.ppdid is '�����߶���ID';
comment on column IG881.pidaccess is '����Ȩ��';
comment on column IG881.fingerPrint is 'ʱ���';
comment on column IG881.PIDREQUIRED is '�Ƿ����';

--IG273
comment on table IG273 is '�Զ�������״̬ԾǨ�����';
comment on column IG273.ptdid is 'ԾǨ����ID';
comment on column IG273.fpsdid is 'Դ����״̬ID';
comment on column IG273.tpsdid is 'Ŀ������״̬ID';
comment on column IG273.ptdname is 'ԾǨ��������';
comment on column IG273.ptddesc is 'ԾǨ��������';
comment on column IG273.ptdtype is 'ԾǨ��������';
comment on column IG273.ptdcond is 'ԾǨ����';
comment on column IG273.fingerPrint is 'ʱ���';

--IG933
comment on table IG933 is '���񹤵���';
comment on column IG933.sfid is '���񹤵�ID';
comment on column IG933.sfreportname is '����������';
comment on column IG933.sfreportphone is '��������ϵ�绰';
comment on column IG933.sfreportorgid is '�����˻��������';
comment on column IG933.sftitle is '����';
comment on column IG933.sfdesc is '����';
comment on column IG933.sfattkey is '����KEY';
comment on column IG933.sfstatus is '״̬';
comment on column IG933.sftype is '����';
comment on column IG933.sforgid is '�Ǽ��˻��������';
comment on column IG933.sfeiid is '����ʲ�ID';
comment on column IG933.sfregisterid is '�Ǽ���ID';
comment on column IG933.sfinstime is '�Ǽ�ʱ��';
comment on column IG933.fingerprint is 'ʱ���';
comment on column IG933.SFCODE is '���񹤵����';
comment on column IG933.SFSOURCE is '��Դ';
comment on column IG933.SFWORKPHONE is '�칫�绰';
comment on column IG933.SFEMAIL is '����';

--IG941
comment on table IG941 is '���񹤵���־��';
comment on column IG941.sflid is '��־ID';
comment on column IG941.sfid is '���񹤵�ID';
comment on column IG941.sfluserid is '������ID';
comment on column IG941.sfldesc is '������¼';
comment on column IG941.sflinstime is '����ʱ��';
comment on column IG941.fingerprint is 'ʱ���';
comment on column IG941.sflattkey is '����KEY';

--SmsSendLog
comment on table SmsSendLog is '������־����������';
comment on column SmsSendLog.SSLID is '��־ID';
comment on column SmsSendLog.USERNAME is '�û�����'; 
comment on column SmsSendLog.DEPTMENTNAME is '�û�������������'; 
comment on column SmsSendLog.SENDDATE is '��������'; 
comment on column SmsSendLog.USERMOBILE is '�����ֻ���'; 
comment on column SmsSendLog.SMSTYPE is '��־����'; 
comment on column SmsSendLog.SENDFLAG is '�ɹ�ʧ�ܱ�־'; 
comment on column SmsSendLog.FINGERPRINT is 'ʱ���';

--IG992
comment on table IG992 is '�Զ��������ⲿ�¼������';
comment on column IG992.PEDID is '��������';
comment on column IG992.PEDEVENTID is '�¼�ID';
comment on column IG992.PEDACTION is '����BL��ʶ';
comment on column IG992.PEDDESC is '����';
comment on column IG992.FINGERPRINT is 'ʱ���';

--IG286
comment on table IG286 is '�Զ������̱��������������';
comment on column IG286.plid is '��������';
comment on column IG286.pldpdid is '���̶���ID';
comment on column IG286.pldactionid is '����ID';
comment on column IG286.initiativepidid is '������������ID';
comment on column IG286.passivitypidid is '������������ID';
comment on column IG286.pldesc is '����';
comment on column IG286.plblname is '����BL��ʶ';
comment on column IG286.pljsevent is 'JS�ű��¼�����';
comment on column IG286.pljtype is '������������';
comment on column IG286.initiativepidname is '������������';
comment on column IG286.passivitypidname is '������������';
comment on column IG286.fingerprint is 'ʱ���';

--IG413
comment on table IG413 is '�Զ�������ǰ�����¼������';
comment on column IG413.pedid is '��������';
comment on column IG413.pdid is '���̶���ID';
comment on column IG413.psdid is '����״̬ID';
comment on column IG413.pedactionid is '����ID';
comment on column IG413.pedtype is '�¼�����';
comment on column IG413.pedblid is '����BL��ʶ';
comment on column IG413.pedorder is '�¼�ִ��˳��';
comment on column IG413.pedec is '����';
comment on column IG413.fingerPrint is 'ʱ���';

--IG373
comment on table IG373 is '�Զ������̱�����ʼ���¼������';
comment on column IG373.piidid is '��������';
comment on column IG373.pdid is '���̶���ID';
comment on column IG373.psdid is '����״̬ID';
comment on column IG373.piidblid is '����BL��ʶ';
comment on column IG373.piiddec is '����';
comment on column IG373.fingerPrint is 'ʱ���';

--IG126
comment on table IG126 is '�Զ���������ʾҳ�涨���';
comment on column IG126.pjdid is '��������';
comment on column IG126.pdid is '���̶���ID';
comment on column IG126.pjdtype is 'ҳ������';
comment on column IG126.pjdblid is '����BL��ʶ';
comment on column IG126.pjdurl is 'JSPҳ��·��';
comment on column IG126.fingerPrint is 'ʱ���';

--IG725
comment on table IG725 is '�Զ�������ȱʡ�����߰�ť�����';
comment on column IG725.pdbdid is '��������';
comment on column IG725.psdid is '����״̬ID';
comment on column IG725.pbdid is '��ťID';
comment on column IG725.pdbdname is '��ť��ʾ����';
comment on column IG725.pdbddesc is '��ť��ʾ��Ϣ';
comment on column IG725.pdbdauth is '��ť�ύȨ��';
comment on column IG725.fingerPrint is 'ʱ���';

--IG711
comment on table IG711 is '�Զ������̴�����Ȩ��';
comment on column IG711.paid is '��������';
comment on column IG711.paiid is '����Ȩ��ID';
comment on column IG711.pauid is '��Ȩ��ID';
comment on column IG711.pabegintime is '��Ȩ��ʼʱ��';
comment on column IG711.paendtime is '��Ȩ����ʱ��';
comment on column IG711.paflag is '�Ƿ���Ȩ��ʶ';
comment on column IG711.patype is '��Ȩ����';
comment on column IG711.paprocessid is '����ID';
comment on column IG711.paprocessnum is '���̹�����';
comment on column IG711.palogintime is '��Ȩʱ��';
comment on column IG711.fingerprint is 'ʱ���';	
comment on column IG711.remarks is '��ע';

--IG699
comment on table IG699 is '�Զ�������ȱʡ�����߱���Ȩ�ޱ�';
comment on column IG699.pdvid is '��������';
comment on column IG699.pidid is '��������ID';
comment on column IG699.psdid is '����״̬ID';
comment on column IG699.pidaccess is '����Ȩ��';
comment on column IG699.fingerPrint is 'ʱ���';
comment on column IG699.PIDREQUIRED is '�Ƿ����';

--IG500
comment on table IG500 is '���̹�����';
comment on column IG500.prid is '����ID';
comment on column IG500.prtype is '��������';
comment on column IG500.prsubtype is '����������';
comment on column IG500.prstatus is '����״̬';
comment on column IG500.prsubstatus is '������״̬';
comment on column IG500.prtitle is '���̱���';
comment on column IG500.prdesc is '��������';
comment on column IG500.propentime is '���̷���ʱ��';
comment on column IG500.prclosetime is '���̹ر�ʱ��';
comment on column IG500.prplantime is '�ƻ�ִ��ʱ��';
comment on column IG500.prduration is '�ƻ�ִ������';
comment on column IG500.prurgency is '�����̶�';
comment on column IG500.primpact is 'Ӱ��̶�';
comment on column IG500.prassetid is '����ʲ�ID';
comment on column IG500.prassetname is '����ʲ�����';
comment on column IG500.prassetcategory is '����ʲ�����';
comment on column IG500.prbusiness is '���ҵ��';
comment on column IG500.primplplan is 'ִ�мƻ�';
comment on column IG500.prbackplan is '�ָ��ƻ�';
comment on column IG500.prvfyplan is '��֤�ƻ�';
comment on column IG500.pid is '�����ĿID';
comment on column IG500.pcode is '�����Ŀ���';
comment on column IG500.pname is '�����Ŀ����';
comment on column IG500.prinfo is '��������ϵ��ʽ';
comment on column IG500.prcorid is '�������ID';
comment on column IG500.prcortype is '�����������';
comment on column IG500.prcortitle is '������̱���';
comment on column IG500.pruserid is '������ID';
comment on column IG500.prusername is '����������';
comment on column IG500.prroleid is '�����߽�ɫID';
comment on column IG500.prrolename is '�����߽�ɫ����';
comment on column IG500.prpdid is '��������ID';
comment on column IG500.prpdname is '������������';
comment on column IG500.prorgid is '�����߻��������';
comment on column IG500.prorgname is '�����߻�������';
comment on column IG500.prserialnum is '���̹�����';
comment on column IG500.prfacttime is 'ʵ�ʽ��ʱ��';
comment on column IG500.fingerprint is 'ʱ���';
comment on column IG500.prptdcond is '����ԾǨ����';
comment on column IG500.prstrategyversion is '���̲��԰汾';
comment on column IG500.prpriority is '���ȼ�';

--IG394
comment on table IG394 is '�Զ�������֪ͨ��־��';
comment on column IG394.PNSSID is '��־ID';
comment on column IG394.PRID is '����ID';
comment on column IG394.PSDID is '����״̬ID';
comment on column IG394.PSDCONFIRM is '�ӵ�';
comment on column IG394.ROLEID is '֪ͨ��ɫID';
comment on column IG394.USERID is '֪ͨ�û�ID';
comment on column IG394.NOTIFYSMSTIME is '�������ѷ���ʱ��';
comment on column IG394.NOTIFYEMAILTIME is '�ʼ����ѷ���ʱ��';
comment on column IG394.REPORTSMSTIME is '�����ϱ�����ʱ��';
comment on column IG394.REPORTEMAILTIME is '�ʼ��ϱ�����ʱ��';
comment on column IG394.FINGERPRINT is 'ʱ���';

--IG337
comment on table IG337 is '���̲�������Ϣ��';
comment on column IG337.ppid is '��������';
comment on column IG337.prid is '����ID';
comment on column IG337.pproleid is '��ɫID';
comment on column IG337.pprolename is '��ɫ����';
comment on column IG337.ppuserid is '�û�ID';
comment on column IG337.ppusername is '�û�����';
comment on column IG337.pporgid is '�û��������������';
comment on column IG337.pporgname is '�û�������������';
comment on column IG337.pptype is '��������';
comment on column IG337.ppuserinfo is '�û���Ϣ';
comment on column IG337.ppcomment is '��������';
comment on column IG337.ppstatus is '����״̬';
comment on column IG337.ppattkey is '����KEY';
comment on column IG337.ppinittime is 'ָ��ʱ��';
comment on column IG337.ppproctime is '�������ʱ��';
comment on column IG337.ppsubstatus is '��״̬';
comment on column IG337.ppfacttime is 'ʵ�ʽ��ʱ��';
comment on column IG337.ppbacktime is '���̻���ָ��ʱ��';
comment on column IG337.fingerprint is 'ʱ���';
comment on column IG337.ppproxyuserid is '�����û�ID';
comment on column IG337.ppsuper is '�Ƿ�SUPER��ɫ';
comment on column IG337.pprolemanager is '�Ƿ��ɫ������';
comment on column IG337.ppdutyperson is '�Ƿ�ֵ����';
comment on column IG337.pbdid is '���̰�ťID';

--IG599
comment on table IG599 is '���̱�����Ϣ��';
comment on column IG599.piid is '��������';
comment on column IG599.prid is '����ID';
comment on column IG599.pivarname is '������ʶ';
comment on column IG599.pivarlabel is '������ʾ����';
comment on column IG599.pivartype is '��������';
comment on column IG599.pivarvalue is '����ֵ';
comment on column IG599.piattkey is '����KEY';
comment on column IG599.fingerprint is 'ʱ���';
comment on column IG599.pidid is '��������ID';
comment on column IG599.PIDMODE is '����ģʽ';
comment on column IG599.PRIVATESCOPE is '˽�б���Ȩ�޷�Χ';

--Attachment
comment on table Attachment is '������';
comment on column Attachment.attid is '��������';
comment on column Attachment.attkey is '����KEY';
comment on column Attachment.attname is '��������';
comment on column Attachment.attdesc is '˵��';
comment on column Attachment.atturl is '�����ʶ';
comment on column Attachment.fingerprint is 'ʱ���';

--IG036
comment on table Action is '������־��';
comment on column IG036.rlid is '��־ID';
comment on column IG036.prid is '����ID';
comment on column IG036.rltime is '����ʱ��';
comment on column IG036.roleid is '������ɫID';
comment on column IG036.rlrolename is '������ɫ����';
comment on column IG036.rluserid is '�����û�ID';
comment on column IG036.rlusername is '�����û�����';
comment on column IG036.rltype is '��־����';
comment on column IG036.rldesc is '��־����';
comment on column IG036.rlcomment is '��������';
comment on column IG036.rlattkey is '����KEY';
comment on column IG036.rlorgid is '�����û��������������';
comment on column IG036.rlorgname is '�����û�������������';
comment on column IG036.fingerprint is 'ʱ���';
comment on column IG036.psname is '����״̬����';
comment on column IG036.psdcode is '����״̬��ʶ';
comment on column IG036.rolemanger is '�Ƿ��ɫ������';
comment on column IG036.pbdid is '���̰�ťID';

--IG715
comment on table IG715 is '��������񹤵�������';
comment on column IG715.sprrid is '��������';
comment on column IG715.sprrsfid is '���񹤵�ID';
comment on column IG715.sprrprid is '����ID';
comment on column IG715.sprrinstime is '�Ǽ�ʱ��';
comment on column IG715.fingerprint is 'ʱ���';

--IG113
comment on table IG113 is '���̱�����־��';
comment on column IG113.rlvid is '��������';
comment on column IG113.rlid is '������־ID';
comment on column IG113.piid is '���̱���ID';
comment on column IG113.prid is '����ID';
comment on column IG113.pivarname is '������ʶ';
comment on column IG113.pivarlabel is '������ʾ����';
comment on column IG113.pivartype is '��������';
comment on column IG113.pivarvalue is '����ֵ';
comment on column IG113.piattkey is '����KEY';
comment on column IG113.pidid is '��������ID';
comment on column IG113.pishowvarname is '������ʾ����';
comment on column IG113.fingerprint is 'ʱ���';

--SdlInfo
comment on table SdlInfo is '����ˮƽ��Ϣ��';
comment on column SdlInfo.siid is '��������';
comment on column SdlInfo.sitype is '���';
comment on column SdlInfo.sibegin is '��ʼʱ��';
comment on column SdlInfo.simark is '����';
comment on column SdlInfo.sieiid is '����ʲ�ID';
comment on column SdlInfo.sieiname is '����ʲ�����';
comment on column SdlInfo.siprid is '����¼�����ID';
comment on column SdlInfo.siprtitle is '����¼����̱���';
comment on column SdlInfo.sidesc is '����';
comment on column SdlInfo.siend is '����ʱ��';
comment on column SdlInfo.siattkey is '����KEY';
comment on column SdlInfo.sifacttime is 'ʵ��ʱ��';
comment on column SdlInfo.sidate is '�Ǽ�ʱ��';
comment on column SdlInfo.fingerprint is 'ʱ���';

--SdlDefineInfo
comment on table SdlDefineInfo is '����ˮƽĿ����Ϣ��';
comment on column SdlDefineInfo.sdiid is '��������';
comment on column SdlDefineInfo.sdiyear is '�Ǽ����';
comment on column SdlDefineInfo.sdieiid is '����ʲ�ID';
comment on column SdlDefineInfo.sdieiname is '����ʲ�����';
comment on column SdlDefineInfo.sdibreakm is '���ж�ʱ��';
comment on column SdlDefineInfo.sdibreaky is '���ж�ʱ��';
comment on column SdlDefineInfo.sdicontinuousm is '������ʱ��ٷֱ�';
comment on column SdlDefineInfo.sdicontinuousy is '������ʱ��ٷֱ�';
comment on column SdlDefineInfo.sdiimpactm is '��Ӱ��ʱ��';
comment on column SdlDefineInfo.sdiimpacty is '��Ӱ��ʱ��';
comment on column SdlDefineInfo.sdisteadym is '���ȶ�ʱ��ٷֱ�';
comment on column SdlDefineInfo.sdisteadyy is '���ȶ�ʱ��ٷֱ�';
comment on column SdlDefineInfo.sdisafecasem is '�°�ȫ�¼�����';
comment on column SdlDefineInfo.sdisafecasey is '�갲ȫ�¼�����';
comment on column SdlDefineInfo.sdisafemarkm is '�°�ȫ�¼�����';
comment on column SdlDefineInfo.sdisafemarky is '�갲ȫ�¼�����';
comment on column SdlDefineInfo.sdiriskmarkm is '�·��ռ������';
comment on column SdlDefineInfo.sdiriskmarky is '����ռ������';
comment on column SdlDefineInfo.sdicapacitycasem is '�������¼�����';
comment on column SdlDefineInfo.sdicapacitycasey is '�������¼�����';
comment on column SdlDefineInfo.sdicapacitymarkm is '�������¼�����';
comment on column SdlDefineInfo.sdicapacitymarky is '�������¼�����';
comment on column SdlDefineInfo.fingerprint is 'ʱ���';

--Project
comment on table Project is '��Ŀ��';
comment on column Project.pid is '��ĿID';
comment on column Project.ptype is '��Ŀ����';
comment on column Project.pcode is '��Ŀ���';
comment on column Project.pname is '��Ŀ����';
comment on column Project.pdesc is '��Ŀ˵��';
comment on column Project.pinfo is '��������';
comment on column Project.popentime is '��Ŀ��ʼʱ��';
comment on column Project.pclosetime is '��Ŀ����ʱ��';
comment on column Project.pstatus is '��Ŀ״̬';
comment on column Project.porg is '�Ǽ���������������루ǰ������';
comment on column Project.prole is '��Ŀ������';
comment on column Project.puser is '��Ŀ������';
comment on column Project.fingerprint is 'ʱ���';

--ProjectPlan
comment on table ProjectPlan is '��Ŀ�ƻ���';
comment on column ProjectPlan.pplid is '�ƻ�ID';
comment on column ProjectPlan.pid is '��ĿID';
comment on column ProjectPlan.pplinfo is '��Ϣ';
comment on column ProjectPlan.pplversion is '�汾';
comment on column ProjectPlan.pplstatus is '״̬';
comment on column ProjectPlan.ppldesc is '����';
comment on column ProjectPlan.ppldate is '�Ǽ�ʱ��';
comment on column ProjectPlan.fingerprint is 'ʱ���';

--ProjectLog
comment on table ProjectLog is '��Ŀ��־��';
comment on column ProjectLog.plid is '��־ID';
comment on column ProjectLog.pid is '��ĿID';
comment on column ProjectLog.plroleid is '�������ֶΣ�';
comment on column ProjectLog.plrolename is '�������ֶΣ�';
comment on column ProjectLog.pluserid is '�û�ID';
comment on column ProjectLog.plusername is '�û�����';
comment on column ProjectLog.plinfo is '����';
comment on column ProjectLog.pltype is '����';
comment on column ProjectLog.pltime is '�Ǽ�ʱ��';
comment on column ProjectLog.plattkey is '����KEY';
comment on column ProjectLog.fingerprint is 'ʱ���';

--Budget
comment on table Budget is 'Ԥ���';
comment on column Budget.bid is 'Ԥ��ID';
comment on column Budget.btype is 'Ԥ������';
comment on column Budget.binittime is '��������';
comment on column Budget.bopentime is '��ʼʱ��';
comment on column Budget.bstatus is '״̬';
comment on column Budget.breqid is '��������';
comment on column Budget.bapvid is '��������';
comment on column Budget.btitle is 'Ԥ������';
comment on column Budget.bclosetime is '�ر�ʱ��';
comment on column Budget.bdesc is 'Ԥ��˵��';
comment on column Budget.binfo is '��������';
comment on column Budget.byear is 'Ԥ�����';
comment on column Budget.borgid is '��������';
comment on column Budget.borgname is '��������';
comment on column Budget.breqname is '�Ǽ�������';
comment on column Budget.bapvname is '��������';
comment on column Budget.bamount is '���';
comment on column Budget.battkey is '����KEY';
comment on column Budget.pid is '�����Ŀ';
comment on column Budget.pcode is '�����Ŀ���';
comment on column Budget.pname is '�����Ŀ����';
comment on column Budget.fingerprint is 'ʱ���';

--Expense
comment on table Expense is '���ñ�';
comment on column Expense.exid is '����ID';
comment on column Expense.bid is 'Ԥ��ID';
comment on column Expense.exdesc is '����˵��';
comment on column Expense.examount is '���ý��';
comment on column Expense.exinfo is '��������';
comment on column Expense.exstatus is '����״̬';
comment on column Expense.exreqid is '��������';
comment on column Expense.exreqname is '��������';
comment on column Expense.exinittime is '��������';
comment on column Expense.exopentime is '��ʼʱ��';
comment on column Expense.exapvid is '��������';
comment on column Expense.exapvname is '��������';
comment on column Expense.exclosetime is '����ʱ��';
comment on column Expense.exattkey is '����KEY';
comment on column Expense.exeiinfo is '��������';
comment on column Expense.exprinfo is '��������';
comment on column Expense.expinfo is '��������';
comment on column Expense.exorginfo is '��������';
comment on column Expense.btitle is 'Ԥ������';
comment on column Expense.fingerprint is 'ʱ���';

--QuartzJobs
comment on table QuartzJobs is '��ʱ�����';
comment on column QuartzJobs.qjid is '��������';
comment on column QuartzJobs.qjname is '��������';
comment on column QuartzJobs.qjdesc is '��������';
comment on column QuartzJobs.qjtriname is '����������';
comment on column QuartzJobs.qjtrigrp is '����������������';
comment on column QuartzJobs.qjtricron is 'QUARTZ����ʽ';
comment on column QuartzJobs.qjcrtuser is '������ID';
comment on column QuartzJobs.qjimpluser is 'ִ����ID';
comment on column QuartzJobs.qjcrttime is '����ʱ��';
comment on column QuartzJobs.qjendtime is '����ʱ��';
comment on column QuartzJobs.qjtype is '����';
comment on column QuartzJobs.qjstatus is '״̬';
comment on column QuartzJobs.qjinfo is '��ע';
comment on column QuartzJobs.qjcrtusername is '����������';
comment on column QuartzJobs.qjimplusername is 'ִ��������';
comment on column QuartzJobs.qjperiodinfo is '��������';
comment on column QuartzJobs.qjorgid is 'ִ�����������������';
comment on column QuartzJobs.qjorgname is 'ִ����������������';
comment on column QuartzJobs.qjassetid is '����ʲ�ID';
comment on column QuartzJobs.qjassettypeid is '����ʲ�����ģ�Ͳ����';
comment on column QuartzJobs.fingerprint is 'ʱ���';

--QuartzProcessRecord
comment on table QuartzProcessRecord is '��ʱ���̻�����Ϣ��';
comment on column QuartzProcessRecord.qprid is '��ʱ����ID';
comment on column QuartzProcessRecord.qprtype is '����ģ������';
comment on column QuartzProcessRecord.qprsubtype is '����������';
comment on column QuartzProcessRecord.qprstatus is '����״̬';
comment on column QuartzProcessRecord.qprsubstatus is '������״̬';
comment on column QuartzProcessRecord.qprtitle is '���̱���';
comment on column QuartzProcessRecord.qprdesc is '��������';
comment on column QuartzProcessRecord.qpropentime is '����ʱ��';
comment on column QuartzProcessRecord.qprclosetime is '�ر�ʱ��';
comment on column QuartzProcessRecord.qprplantime is '�ƻ�ִ��ʱ��';
comment on column QuartzProcessRecord.qprduration is '�ƻ�ִ������';
comment on column QuartzProcessRecord.qprurgency is '�����̶�';
comment on column QuartzProcessRecord.qprimpact is 'Ӱ��̶�';
comment on column QuartzProcessRecord.qprassetid is '����ʲ�ID';
comment on column QuartzProcessRecord.qprassetname is '����ʲ�����';
comment on column QuartzProcessRecord.qprassetcategory is '����ʲ�����';
comment on column QuartzProcessRecord.qprbusiness is '���ҵ��';
comment on column QuartzProcessRecord.qprimplplan is 'ִ�мƻ�';
comment on column QuartzProcessRecord.qprbackplan is '�ָ��ƻ�';
comment on column QuartzProcessRecord.qprvfyplan is '��֤�ƻ�';
comment on column QuartzProcessRecord.qpid is '�����ĿID';
comment on column QuartzProcessRecord.qpcode is '�����Ŀ���';
comment on column QuartzProcessRecord.qpname is '�����Ŀ����';
comment on column QuartzProcessRecord.qprinfo is '��������ϵ��ʽ';
comment on column QuartzProcessRecord.qprcorid is '�������ID';
comment on column QuartzProcessRecord.qprcortype is '�����������';
comment on column QuartzProcessRecord.qprcortitle is '������̱���';
comment on column QuartzProcessRecord.qpruserid is '������ID';
comment on column QuartzProcessRecord.qprusername is '����������';
comment on column QuartzProcessRecord.qprroleid is '�����߽�ɫID';
comment on column QuartzProcessRecord.qprrolename is '�����߽�ɫ����';
comment on column QuartzProcessRecord.qprpdid is '��������ID';
comment on column QuartzProcessRecord.qprpdname is '������������';
comment on column QuartzProcessRecord.qprorgid is '�������������������';
comment on column QuartzProcessRecord.qprorgname is '������������������';
comment on column QuartzProcessRecord.fingerprint is 'ʱ���';
comment on column QuartzProcessRecord.qprattkey is '����KEY';

--QuartzProcessParticipant
comment on table QuartzProcessParticipant is '��ʱ���̲�������Ϣ��';
comment on column QuartzProcessParticipant.qppid is '��������';
comment on column QuartzProcessParticipant.qprid is '��ʱ����ID';
comment on column QuartzProcessParticipant.qpproleid is '��ɫID';
comment on column QuartzProcessParticipant.qpprolename is '��ɫ����';
comment on column QuartzProcessParticipant.qppuserid is '�û�ID';
comment on column QuartzProcessParticipant.qppusername is '�û�����';
comment on column QuartzProcessParticipant.qpporgid is '�û��������������';
comment on column QuartzProcessParticipant.qpporgname is '�û�������������';
comment on column QuartzProcessParticipant.qpptype is '��������';
comment on column QuartzProcessParticipant.qppsubstatus is '��״̬';
comment on column QuartzProcessParticipant.qppuserinfo is '�û���Ϣ';
comment on column QuartzProcessParticipant.qppcomment is '��������';
comment on column QuartzProcessParticipant.qppstatus is '����״̬';
comment on column QuartzProcessParticipant.qppattkey is '����KEY';
comment on column QuartzProcessParticipant.qppinittime is 'ָ��ʱ��';
comment on column QuartzProcessParticipant.qppproctime is '�������ʱ��';
comment on column QuartzProcessParticipant.fingerprint is 'ʱ���';

--QuartzProcessInfo
comment on table QuartzProcessInfo is '��ʱ���̱�����Ϣ��';
comment on column QuartzProcessInfo.qpiid is '��������';
comment on column QuartzProcessInfo.qprid is '��ʱ����ID';
comment on column QuartzProcessInfo.qpivarname is '������ʶ';
comment on column QuartzProcessInfo.qpivarlabel is '������ʾ����';
comment on column QuartzProcessInfo.qpivartype is '��������';
comment on column QuartzProcessInfo.qpivarvalue is '����ֵ';
comment on column QuartzProcessInfo.qpiattkey is '����KEY';
comment on column QuartzProcessInfo.fingerprint is 'ʱ���';
comment on column QuartzProcessInfo.qpidid is '��������ID';

--Notification
comment on table Notification is 'ϵͳ���ɣ�������';

--RiskAudit
comment on table RiskAudit is '������Ʊ�';
comment on column RiskAudit.raid is '���ID';
comment on column RiskAudit.raversion is '��ư汾';
comment on column RiskAudit.radate is '��������';
comment on column RiskAudit.rauserid is '������ID';
comment on column RiskAudit.rausername is '����������';
comment on column RiskAudit.racode is '�汾���';
comment on column RiskAudit.radesc is '����';
comment on column RiskAudit.rastatus is '״̬';
comment on column RiskAudit.fingerprint is 'ʱ���';

--RiskAuditDef
comment on table RiskAuditDef is '�����������Ϣ��';
comment on column RiskAuditDef.radid is '�����ID';
comment on column RiskAuditDef.raid is '���ID';
comment on column RiskAuditDef.raversion is '��ư汾';
comment on column RiskAuditDef.radname is '���������';
comment on column RiskAuditDef.radcode is '�����';
comment on column RiskAuditDef.radlevel is '����';
comment on column RiskAuditDef.radparcode is '�ϼ������';
comment on column RiskAuditDef.raddesc is '����';
comment on column RiskAuditDef.radrisklevel is '���ճ̶�';
comment on column RiskAuditDef.raduserid is '������ID';
comment on column RiskAuditDef.radusername is '����������';
comment on column RiskAuditDef.radorg is '���β�������';
comment on column RiskAuditDef.radorgcoding is '���β��Ų����';
comment on column RiskAuditDef.radstatus is '״̬';
comment on column RiskAuditDef.radmode is '�����ֶ�';
comment on column RiskAuditDef.radtype is '��������';
comment on column RiskAuditDef.radfrequency is '����Ƶ��';
comment on column RiskAuditDef.fingerprint is 'ʱ���';

--RiskAuditIns
comment on table RiskAuditIns is '�������ʵ����';
comment on column RiskAuditIns.raiid is 'ʵ��ID';
comment on column RiskAuditIns.raid is '���ID';
comment on column RiskAuditIns.raversion is '��ư汾';
comment on column RiskAuditIns.raicode is '��Ʊ��';
comment on column RiskAuditIns.raistart is '��������';
comment on column RiskAuditIns.raiend is '��������';
comment on column RiskAuditIns.raidesc is '����';
comment on column RiskAuditIns.raistatus is '״̬';
comment on column RiskAuditIns.fingerprint is 'ʱ���';

--RiskAuditResult
comment on table RiskAuditResult is '�������������';
comment on column RiskAuditResult.rarid is '����ID';
comment on column RiskAuditResult.raiid is '���ʵ��ID';
comment on column RiskAuditResult.radid is '�����ID';
comment on column RiskAuditResult.rardate is '��������';
comment on column RiskAuditResult.raruserid is '�����û�ID';
comment on column RiskAuditResult.rarusername is '�����û�����';
comment on column RiskAuditResult.rarplanscore is '�����ƶȽ�������';
comment on column RiskAuditResult.rarplandesc is '�����ƶȽ�������';
comment on column RiskAuditResult.rarexecscore is '�����ƶ�ִ������';
comment on column RiskAuditResult.rarexecdesc is '�����ƶ�ִ������';
comment on column RiskAuditResult.raroverallscore is '������������';
comment on column RiskAuditResult.raroveralldesc is '������������';
comment on column RiskAuditResult.rarcomment is '�������';
comment on column RiskAuditResult.fingerprint is 'ʱ���';
comment on column RiskAuditResult.radcode is '���������';

--RiskCheck
comment on table RiskCheck is '���ռ���';
comment on column RiskCheck.rcid is '���ID';
comment on column RiskCheck.rcname is '�������';
comment on column RiskCheck.rcdesc is '����';
comment on column RiskCheck.rctype is '��Ҫ�̶�';
comment on column RiskCheck.rcstatus is '״̬';
comment on column RiskCheck.rcstartdate is '��ʼ����';
comment on column RiskCheck.rcenddate is '��������';
comment on column RiskCheck.rcfrequency is 'Ƶ��';
comment on column RiskCheck.rccron is '����ִ�б���ʽ';
comment on column RiskCheck.rcuserid is '������ID';
comment on column RiskCheck.rcusername is '����������';
comment on column RiskCheck.rcroleid is '�������ɫID';
comment on column RiskCheck.rcrolename is '�������ɫ����';
comment on column RiskCheck.rcasset is '����ʲ�ID';
comment on column RiskCheck.rcassetname is '����ʲ�����';
comment on column RiskCheck.rcattch is '����KEY';
comment on column RiskCheck.rcoption is 'ѡ��';
comment on column RiskCheck.fingerprint is 'ʱ���';

--RiskCheckResult
comment on table RiskCheckResult is '���ռ������';
comment on column RiskCheckResult.rcrid is '���ID';
comment on column RiskCheckResult.rcid is '���ID';
comment on column RiskCheckResult.rcrplandate is '�ƻ��������';
comment on column RiskCheckResult.rcrrealtime is 'ʵ�ʼ��ʱ��';
comment on column RiskCheckResult.rcruserid is '����ύ��ID';
comment on column RiskCheckResult.rcrusername is '����ύ������';
comment on column RiskCheckResult.rcrresult is '�����';
comment on column RiskCheckResult.rcrcomment is '˵��';
comment on column RiskCheckResult.rcrattch is '����KEY';
comment on column RiskCheckResult.fingerprint is 'ʱ���';
comment on column RiskCheckResult.rctype is '��Ҫ�̶�';

--AuditCheckRelation
comment on table AuditCheckRelation is '���ռ���������ƹ�ϵ��';
comment on column AuditCheckRelation.acrid is '��������';
comment on column AuditCheckRelation.rcid is '���ID';
comment on column AuditCheckRelation.radid is '�����ID';
comment on column AuditCheckRelation.radcode is '���������';
comment on column AuditCheckRelation.fingerprint is 'ʱ���';

--DUTYAUDITDEF
comment on table DUTYAUDITDEF is 'ֵ��������';
comment on column DUTYAUDITDEF.DADID is '�����ID';
comment on column DUTYAUDITDEF.DADCATEGORY is 'ֵ������';
comment on column DUTYAUDITDEF.DADTYPE is '����';
comment on column DUTYAUDITDEF.DADNAME is '�������';
comment on column DUTYAUDITDEF.DADLIMTIME is '�ʱ������';
comment on column DUTYAUDITDEF.DADCONTENT is '�������';
comment on column DUTYAUDITDEF.DADINFO is '˵��';
comment on column DUTYAUDITDEF.DADSTATUS is '״̬';
comment on column DUTYAUDITDEF.DADUSERID is '������ID';
comment on column DUTYAUDITDEF.DADUSERNAME is '����������';
comment on column DUTYAUDITDEF.DADUPDTIME is '����ʱ��';
comment on column DUTYAUDITDEF.DADORDERBY is '�����ʶ';
comment on column DUTYAUDITDEF.PERIODTYPE is '��������';
comment on column DUTYAUDITDEF.PERIODVALUE is '����ʱ��';
comment on column DUTYAUDITDEF.FINGERPRINT is 'ʱ���';

--DUTYAUDITTIME
comment on table DUTYAUDITTIME is 'ֵ��������ʱ���';
comment on column DUTYAUDITTIME.DATID is '��������';
comment on column DUTYAUDITTIME.DADID is '�����ID';
comment on column DUTYAUDITTIME.DATTIME is '�����ʱ��';
comment on column DUTYAUDITTIME.DATLIMTIME is '����ʱ��';
comment on column DUTYAUDITTIME.FINGERPRINT is 'ʱ���';

--DUTYPLAN
comment on table DUTYPLAN is 'ֵ��ƻ���';
comment on column DUTYPLAN.DPID is 'ֵ��ƻ�ID';
comment on column DUTYPLAN.DADCATEGORY is 'ֵ������';
comment on column DUTYPLAN.DPTIME is 'ֵ������';
comment on column DUTYPLAN.DPTYPE is 'ֵ������';
comment on column DUTYPLAN.DPSTATUS is '״̬';
comment on column DUTYPLAN.DPQUESTION is '��������';
comment on column DUTYPLAN.DPINFO is '�ܽ�';
comment on column DUTYPLAN.DPUSERID is '������ID';
comment on column DUTYPLAN.DPUSERNAME is '����������';
comment on column DUTYPLAN.DPCRETIME is '�Ǽ�ʱ��';
comment on column DUTYPLAN.DPUPDTIME is '����ʱ��';
comment on column DUTYPLAN.DPFINTIME is '����ʱ��';
comment on column DUTYPLAN.DPREMARKS is '��ע';
comment on column DUTYPLAN.FINGERPRINT is 'ʱ���';

--DUTYPERSON
comment on table DUTYPERSON is 'ֵ���˱�';
comment on column DUTYPERSON.DPERID is '��������';
comment on column DUTYPERSON.DPID is 'ֵ��ƻ�ID';
comment on column DUTYPERSON.DPERTIME is 'ֵ������';
comment on column DUTYPERSON.DPTYPE is 'ֵ������';
comment on column DUTYPERSON.DPERUSERID is 'ֵ����ID';
comment on column DUTYPERSON.DPERUSERNAME is 'ֵ��������';
comment on column DUTYPERSON.FINGERPRINT is '��¼ʱ���';

--DUTYRESULT
comment on table DUTYRESULT is 'ֵ��������';
comment on column DUTYRESULT.DRID is '���ID';
comment on column DUTYRESULT.DPID is 'ֵ��ƻ�ID';
comment on column DUTYRESULT.DADID is '�����ID';
comment on column DUTYRESULT.DADCATEGORY is 'ֵ������';
comment on column DUTYRESULT.DADTYPE is '������';
comment on column DUTYRESULT.DADNAME is '�������';
comment on column DUTYRESULT.DPTIME is 'ֵ������';
comment on column DUTYRESULT.DPTYPE is 'ֵ������';
comment on column DUTYRESULT.DATTIME is '���ʱ��';
comment on column DUTYRESULT.DATLIMTIME is '�ʱ������';
comment on column DUTYRESULT.DADCONTENT is '�������';
comment on column DUTYRESULT.DRCONTENT is '�����';
comment on column DUTYRESULT.DRFILLTIME is '�ʱ�䣨Сʱ�֣�';
comment on column DUTYRESULT.DRRESULT is '���˵��';
comment on column DUTYRESULT.DRUSERID is '���ID';
comment on column DUTYRESULT.DRUSERNAME is '�������';
comment on column DUTYRESULT.DRCRETIME is '�ʱ��';
comment on column DUTYRESULT.drlimdtime is '���/ʱ����';
comment on column DUTYRESULT.FINGERPRINT is 'ʱ���';

--IG512
comment on table IG512 is '���̹�����ϵ��';
comment on column IG512.prrid is '��������';
comment on column IG512.parprid is '����ID��������';
comment on column IG512.cldprid is '����ID��������';
comment on column IG512.prrinstime is '����ʱ��';
comment on column IG512.fingerprint is 'ʱ���';

--ReportFileDefinition
comment on table ReportFileDefinition is '���������';
comment on column ReportFileDefinition.rfdid is '����ID';
comment on column ReportFileDefinition.rfdtitle is '��������';
comment on column ReportFileDefinition.rfdtype is '��������';
comment on column ReportFileDefinition.rfddesc is '����˵��';
comment on column ReportFileDefinition.rfdfilename is '�����ļ���';
comment on column ReportFileDefinition.rfduserid is '�Ǽ���ID';
comment on column ReportFileDefinition.rfdusername is '�Ǽ�������';
comment on column ReportFileDefinition.rfdinstime is '�Ǽ�ʱ��';
comment on column ReportFileDefinition.rfdversion is '��ǰ�汾';
comment on column ReportFileDefinition.rfdnewversion is '���°汾';
comment on column ReportFileDefinition.rfdpictype is '������ʽ';
comment on column ReportFileDefinition.fingerprint is 'ʱ���';
comment on column ReportFileDefinition.rfdparameters is '��������';

--ReportFileVersion
comment on table ReportFileVersion is '�����汾��';
comment on column ReportFileVersion.rfvid is '��������';
comment on column ReportFileVersion.rfdid is '����ID';
comment on column ReportFileVersion.rfvversion is '�汾';
comment on column ReportFileVersion.rfvinstime is '����ʱ��';
comment on column ReportFileVersion.fingerprint is 'ʱ���';

--IG224
comment on table IG224 is '����״̬��־��';
comment on column IG224.rslid is '��������';
comment on column IG224.prid is '����ID';
comment on column IG224.prpdid is '��������ID';
comment on column IG224.prtype is '����ģ������';
comment on column IG224.prstatus is '����״̬';
comment on column IG224.rslopentime is '��ʼʱ��';
comment on column IG224.rslclosetime is '����ʱ��';
comment on column IG224.rslExpect is '�Ƿ�ʱ';
comment on column IG224.fingerprint is 'ʱ���';

--IG899
comment on table IG899 is '����˽�б�����';
comment on column IG899.PPIID is '��������';
comment on column IG899.PIDID is '��������ID';
comment on column IG899.PIID is '���̱���ID';
comment on column IG899.ROLEID is '������ɫID';
comment on column IG899.USERID is '������ID';
comment on column IG899.PPIVALUE is '����ֵ';
comment on column IG899.PPIATTKEY is '����KEY';
comment on column IG899.FINGERPRINT is 'ʱ���';

--IG463
comment on table IG463 is '���̴�����Ȩ������';
comment on column IG463.ppwid is '��������';
comment on column IG463.ppwprid is '����ID';
comment on column IG463.ppwprtype is '����ģ������';
comment on column IG463.ppwprserialnum is '���̹�����';
comment on column IG463.ppwprtitle is '���̱���';
comment on column IG463.ppwauthorizeuserid is '��Ȩ��ID';
comment on column IG463.ppwproxyuserid is '������ID';
comment on column IG463.ppwproxyusername is '����������';
comment on column IG463.ppwoptiontime is '�����˴���ʱ��';
comment on column IG463.ppwcloseflag is '�Ƿ�ر�';
comment on column IG463.fingerPrint is 'ʱ���';

--IG213
comment on table IG213 is '�Զ������̽�ɫ��Χ��';
comment on column IG213.prtdid is '��������';
comment on column IG213.pdid is '��������ID';
comment on column IG213.roletype is '��ɫ����';
comment on column IG213.fingerprint is 'ʱ���';

--IG243
comment on table IG243 is '�Զ������̱��ⶨ���';
comment on column IG243.ptdid is '��������';
comment on column IG243.pdid is '��������ID';
comment on column IG243.ptitlename is '���������ʾ����';
comment on column IG243.ptitleaccess is '��������Ƿ�ɼ�';
comment on column IG243.pdescname is '����������ʾ����';
comment on column IG243.pdescaccess is '���������Ƿ�ɼ�';
comment on column IG243.fingerprint is 'ʱ���';

--IG298
comment on table IG298 is '�Զ�������״̬�ɷ��ɽ�ɫ�����';
comment on column IG298.psrdid is '��������';
comment on column IG298.psdid is '����״̬ID';
comment on column IG298.roleid is '��ɫID';
comment on column IG298.fingerprint is 'ʱ���';

--IG156
comment on table IG156 is '�Զ�������״̬��ť�¼������';
comment on column IG156.PSEID is '��������';
comment on column IG156.PDID is '��������ID'; 
comment on column IG156.PSDID is '����״̬ID';
comment on column IG156.PSEBUTTONID is '��ťID';
comment on column IG156.PSEACTIONID is '����BL��ʶ';
comment on column IG156.PSEORDER is 'ִ��˳��'; 
comment on column IG156.PSEDEC is '����';
comment on column IG156.PSBDNAME is '��ť����';
comment on column IG156.FINGERPRINT is 'ʱ���';

--IG212
comment on table IG212 is '�Զ�������֪ͨ���Զ����';
comment on column IG212.PSDID is '����״̬ID';
comment on column IG212.PSDCONFIRM is '�Ƿ�ȷ��״̬';
comment on column IG212.SMS is '�Ƿ��Ͷ���';
comment on column IG212.EMAIL is '�Ƿ����ʼ�';
comment on column IG212.NOTIFYD is '�ٴ�����ʱ�䣨�죩';
comment on column IG212.NOTIFYH is '�ٴ�����ʱ�䣨Сʱ��';
comment on column IG212.NOTIFYM is '�ٴ�����ʱ�䣨�֣�';
comment on column IG212.REPORTD is '�ϱ�ʱ�䣨�죩';
comment on column IG212.REPORTH is '�ϱ�ʱ�䣨Сʱ��';
comment on column IG212.REPORTM is '�ϱ�ʱ�䣨�֣�';
comment on column IG212.ROLEMANAGER is '֪ͨ������';
comment on column IG212.FINGERPRINT is 'ʱ���';

--IG237
comment on table IG237 is '�Զ������̲���֪ͨ�˶����';
comment on column IG237.PSDID is '����״̬ID';
comment on column IG237.PSDCONFIRM is '�Ƿ�ȷ��״̬';
comment on column IG237.USERID is '�û�ID';
comment on column IG237.ROLEID is '��ɫID';
comment on column IG237.FINGERPRINT is 'ʱ���';

--IG202
comment on table IG202 is '����ͨ�ñ��������';
comment on column IG202.PIDID is '��������ID'; 
comment on column IG202.PIDNAME is '������ʶ';
comment on column IG202.PIDLABEL is '������ʾ����'; 
comment on column IG202.PIDDESC is '��������';
comment on column IG202.PIDTYPE is '��������'; 
comment on column IG202.PIDOPTION is '����ȡֵ��Χ';
comment on column IG202.PIDDEFAULT is '����Ĭ��ֵ'; 
comment on column IG202.PIDREQUIRED is '�Ƿ����'; 
comment on column IG202.PIDSORTID is '�����ʶ'; 
comment on column IG202.CCID is '�������ݷ���ID';
comment on column IG202.PIDMODE is '����ģʽ';
comment on column IG202.PRIVATESCOPE is '˽�б���Ȩ�޷�Χ';
comment on column IG202.ROWWIDTH is '��������ʾģʽ';
comment on column IG202.FINGERPRINT is 'ʱ���';

--CUSTOMREPORT
comment on table CUSTOMREPORT is '���Ʊ�����Ϣ��';
comment on column CUSTOMREPORT.CRID is '��������'; 
comment on column CUSTOMREPORT.USERID is '�����û�ID';
comment on column CUSTOMREPORT.RFDID is '����ID';
comment on column CUSTOMREPORT.ORDERNUM is '�����ʶ';
comment on column CUSTOMREPORT.FINGERPRINT is 'ʱ���'; 

--ROLEREPORT
comment on table ROLEREPORT is '������Ȩ��Ϣ��';
comment on column ROLEREPORT.RRID is '��������'; 
comment on column ROLEREPORT.ROLEID is '��ɫID';  
comment on column ROLEREPORT.RFDID is '����ID'; 
comment on column ROLEREPORT.RRPERM is 'Ȩ�ޣ�������'; 
comment on column ROLEREPORT.RRDESC is '˵����������'; 
comment on column ROLEREPORT.FINGERPRINT is 'ʱ���';

--SEQUENCE_GENERATOR_TABLE
comment on table SEQUENCE_GENERATOR_TABLE is '�������б�';
comment on column SEQUENCE_GENERATOR_TABLE.SEQUENCE_NAME is '���б�ʶ';
comment on column SEQUENCE_GENERATOR_TABLE.SEQUENCE_VALUE is '����ֵ';

--HOTLINK
comment on table HOTLINK is '��������';
comment on column HOTLINK.hid is '��������';
comment on column HOTLINK.userid is '�û�ID';
comment on column HOTLINK.hname is '������ʾ����';
comment on column HOTLINK.hlink is '����URL';
comment on column HOTLINK.horder is '��ʾ˳��';
comment on column HOTLINK.fingerprint is 'ʱ���';

--IG731
comment on table IG731 is '��������ʲ�������';
comment on column IG731.pieid is '��������';
comment on column IG731.prid is '����ID';
comment on column IG731.piid is '���̱���ID';
comment on column IG731.eiid is '�ʲ�ID';
comment on column IG731.fingerprint is 'ʱ���';

--QuartzProcessInfoEntity
comment on table QuartzProcessInfoEntity is '��ʱ��������ʲ�������';
comment on column QuartzProcessInfoEntity.qpieid is '��������';
comment on column QuartzProcessInfoEntity.qprid is '����ID';
comment on column QuartzProcessInfoEntity.qpiid is '���̱���ID';
comment on column QuartzProcessInfoEntity.qeiid is '�ʲ�ID';
comment on column QuartzProcessInfoEntity.fingerprint is 'ʱ���';

--QuartzJobDetails
comment on table QuartzJobDetails is '�ճ���ά�ƻ���Ϣ��';
comment on column QuartzJobDetails.qjdid is '��������';
comment on column QuartzJobDetails.qjid is '��ʱ����ID';
comment on column QuartzJobDetails.qjdtriname is '����������';
comment on column QuartzJobDetails.qjdtrigrpname is '����������������';
comment on column QuartzJobDetails.qjdtime is 'ִ��ʱ��';
comment on column QuartzJobDetails.qjdweek is '���ڼ�';
comment on column QuartzJobDetails.qjdtype is 'ִ��״̬';
comment on column QuartzJobDetails.FINGERPRINT is 'ʱ���';

--IG433
comment on table IG433 is '����������Ϣ��';
comment on column IG433.paid is '��������';
comment on column IG433.paprid is '����ID';
comment on column IG433.pauserid is '������ID';
comment on column IG433.paprname is '���̱���';
comment on column IG433.paassessmentdes is '��������';
comment on column IG433.paassessmentdate is '����ʱ��';
comment on column IG433.paeventtypecode is '�¼����';
comment on column IG433.PAATTKEY is '����KEY';
comment on column IG433.PASTATUS is '״̬';
comment on column IG433.fingerprint is 'ʱ���';

--IG229
comment on table IG229 is '����Ӱ��ҵ��ϵͳ��Ϣ��';
comment on column IG229.padid is '��������';
comment on column IG229.padprid is '����ID';
comment on column IG229.padaffectsystem is 'Ӱ��ҵ��ϵͳ';
comment on column IG229.padstart is 'Ӱ�쿪ʼʱ��';
comment on column IG229.padend is 'Ӱ�����ʱ��';
comment on column IG229.fingerprint is 'ʱ���';

--IG105
comment on table IG105 is '���̲��Զ�����Ϣ';
comment on column IG105.pdid is '��������ID';
comment on column IG105.prstatus is '����״̬';
comment on column IG105.prurgency is '�����̶�';
comment on column IG105.psdversion is '���԰汾';
comment on column IG105.expecttime is '�������ʱ��';
comment on column IG105.createtime is '����ʱ��';
comment on column IG105.fingerprint is 'ʱ���';

--PRIORITY
comment on table PRIORITY is '�������ȼ������';
comment on column PRIORITY.uvalue is '�����̶�';
comment on column PRIORITY.ivalue is 'Ӱ��̶�';
comment on column PRIORITY.pprtype is '��������ID';
comment on column PRIORITY.pvalue is '���ȼ�';
comment on column PRIORITY.FINGERPRINT is 'ʱ���';

--KNOWLEDGE
comment on table KNOWLEDGE is '֪ʶ��';
comment on column KNOWLEDGE.KNID is '֪ʶID';
comment on column KNOWLEDGE.KNVERSION is '֪ʶ�汾';
comment on column KNOWLEDGE.KNSERIAL is '���';
comment on column KNOWLEDGE.KNDEPARTMENT is '����';
comment on column KNOWLEDGE.KNAPPROVER is '�鵵��ID';
comment on column KNOWLEDGE.KNAPPROVERNAME is '�鵵������';
comment on column KNOWLEDGE.KNAPPROVETIME is '�鵵ʱ��';
comment on column KNOWLEDGE.KNCLASS is '����';
comment on column KNOWLEDGE.KNCLASSNAME is '�������';
comment on column KNOWLEDGE.KNAREA is 'ҵ�������ʶ';
comment on column KNOWLEDGE.KNAREANAME is 'ҵ����������';
comment on column KNOWLEDGE.KNTELAREA is '���������ʶ';
comment on column KNOWLEDGE.KNTELAREANAME is '������������';
comment on column KNOWLEDGE.KNKEY is '�ؼ���';
comment on column KNOWLEDGE.KNORIGIN is '��Դ��ʶ';
comment on column KNOWLEDGE.KNORIGINNAME is '��Դ����';
comment on column KNOWLEDGE.KNPROFFER is '������ID';
comment on column KNOWLEDGE.KNPROFFERNAME is '����������';
comment on column KNOWLEDGE.KNPROFFERTIME is '����ʱ��';
comment on column KNOWLEDGE.KNTITLE is '����';
comment on column KNOWLEDGE.KNDES is '��������';
comment on column KNOWLEDGE.KNFAULTCAUSE is '����ԭ���ܽ�';
comment on column KNOWLEDGE.KNSOLVEWAY is '����취';
comment on column KNOWLEDGE.KNSTATUS is '״̬';
comment on column KNOWLEDGE.KNREJECT is '����ԭ��';
comment on column KNOWLEDGE.KNATTKEY is '����KEY';
comment on column KNOWLEDGE.FINGERPRINT is 'ʱ���';
comment on column KNOWLEDGE.KNAPPROVEROLE is '������ɫID';

--KNOWLEDGEAPPIMPACT
comment on table KNOWLEDGEAPPIMPACT is '֪ʶ��ҵ��ϵͳ������';
comment on column KNOWLEDGEAPPIMPACT.KAIID is '��������';
comment on column KNOWLEDGEAPPIMPACT.KNID is '֪ʶID';
comment on column KNOWLEDGEAPPIMPACT.KAICODE is 'ҵ��ϵͳ��ʶ';
comment on column KNOWLEDGEAPPIMPACT.FINGERPRINT is 'ʱ���';
comment on column KNOWLEDGEAPPIMPACT.KNVERSION is '֪ʶ�汾';

--KNOWLEDGEGRADE
comment on table KNOWLEDGEGRADE is '֪ʶ���ֱ�';
comment on column KNOWLEDGEGRADE.KGID is '��������';
comment on column KNOWLEDGEGRADE.KNID is '֪ʶID';
comment on column KNOWLEDGEGRADE.KGGRADE is '֪ʶ����';
comment on column KNOWLEDGEGRADE.KGAPPRAISE is '֪ʶ����';
comment on column KNOWLEDGEGRADE.KGUSERID is '������ID';
comment on column KNOWLEDGEGRADE.KGTIME is '����ʱ��';
comment on column KNOWLEDGEGRADE.FINGERPRINT is 'ʱ���';

--KNOWLEDGEPROCESS
comment on table KNOWLEDGEPROCESS is '֪ʶ�����̹�����';
comment on column KNOWLEDGEPROCESS.KPID is '��������';
comment on column KNOWLEDGEPROCESS.KNID is '֪ʶID';
comment on column KNOWLEDGEPROCESS.KNVERSION is '֪ʶ�汾';
comment on column KNOWLEDGEPROCESS.PRID is '����ID';
comment on column KNOWLEDGEPROCESS.SFID is '���񹤵�ID';
comment on column KNOWLEDGEPROCESS.CONNECTTYPE is '��������';
comment on column KNOWLEDGEPROCESS.KPEFFECT is '�Ƿ���Ч��ʶ';
comment on column KNOWLEDGEPROCESS.FINGERPRINT is 'ʱ���';

--KNOWLOG
comment on table KNOWLOG is '֪ʶ��־��';
comment on column KNOWLOG.KLID is '��������';
comment on column KNOWLOG.KLKID is '֪ʶID';
comment on column KNOWLOG.KLTIME is '��¼ʱ��';
comment on column KNOWLOG.KLROLEID is '��ɫID';
comment on column KNOWLOG.KLROLENAME is '��ɫ����';
comment on column KNOWLOG.KLUSERID is '�û�ID';
comment on column KNOWLOG.KLUSERNAME is '�û�����';
comment on column KNOWLOG.KLDESC is '����';
comment on column KNOWLOG.KLCOMMEND is '��ע';
comment on column KNOWLOG.KLORGID is '���������';
comment on column KNOWLOG.KLORGNAME is '��������';
comment on column KNOWLOG.FINGERPRINT is 'ʱ���';

--DELAY
comment on table DELAY is '��ʱ������Ϣ��';
comment on column DELAY.ID is '��������';
comment on column DELAY.DATETIME is '����';
comment on column DELAY.ORGNAME is '���뵥λ';
comment on column DELAY.TITLE is '�������';
comment on column DELAY.HZNAME is '�г�����';
comment on column DELAY.HZTEL is '�г��绰';
comment on column DELAY.JLNAME is '��������';
comment on column DELAY.JLTEL is '�����绰';
comment on column DELAY.REMARK is '��ע';
comment on column DELAY.STARTTIME is '��ʼʱ��';
comment on column DELAY.ENDTIME is '����ʱ��';
comment on column DELAY.OPERATER is '������';
comment on column DELAY.FINGERPRINT is 'ʱ���';
comment on column DELAY.UNLOCKTIME is '����ʱ��';

--ONDUTYPERSONRECORD
comment on table ONDUTYPERSONRECORD is '�ճ�ά���ǼǱ�';
comment on column ONDUTYPERSONRECORD.ODPRID is '��������';
comment on column ONDUTYPERSONRECORD.ODPRGUEST is '������Ա';
comment on column ONDUTYPERSONRECORD.ODPRGUESTORG is '������λ';
comment on column ONDUTYPERSONRECORD.ODPRGUESTIDNUM is '����֤��';
comment on column ONDUTYPERSONRECORD.ODPRAREA is '��������';
comment on column ONDUTYPERSONRECORD.ODPRCTIME is '����ʱ��';
comment on column ONDUTYPERSONRECORD.ODPRLTIME is '�뿪ʱ��';
comment on column ONDUTYPERSONRECORD.ODPROPTER is '������';
comment on column ONDUTYPERSONRECORD.ODPRACTER is '��׼��';
comment on column ONDUTYPERSONRECORD.ODPRUSERNAME is '��¼��';
comment on column ONDUTYPERSONRECORD.ODPRTARGET is '����Ŀ��';
comment on column ONDUTYPERSONRECORD.ODPRRECORD is '������¼';
comment on column ONDUTYPERSONRECORD.ODPRINSERTTIME is '��¼ʱ��';
comment on column ONDUTYPERSONRECORD.ODPRMODTIME is '�༭ʱ��';
comment on column ONDUTYPERSONRECORD.FINGERPRINT is 'ʱ���';

--EIBELONGRELATION
comment on table EIBELONGRELATION is '����������ϵ��';
comment on column EIBELONGRELATION.BRID is '�߼�����';
comment on column EIBELONGRELATION.BRPAREIID is 'Դ�ʲ�ID';
comment on column EIBELONGRELATION.BRPARVERSION is 'Դ�ʲ���汾';
comment on column EIBELONGRELATION.BRPARSMALLVERSION is 'Դ�ʲ�С�汾';
comment on column EIBELONGRELATION.BRCLDEIID is 'Ŀ���ʲ�ID';
comment on column EIBELONGRELATION.BRCLDVERSION is 'Ŀ���ʲ���汾';
comment on column EIBELONGRELATION.BRCLDSMALLVERSION is 'Ŀ���ʲ�С�汾';
comment on column EIBELONGRELATION.BRTYPE is '��ϵ����(����/�߼�)';
comment on column EIBELONGRELATION.BRDES is '��ϵ˵��';
comment on column EIBELONGRELATION.BRCREATETIME is '����ʱ��';
comment on column EIBELONGRELATION.BRRALETIONCODE is '������ϵ��';
comment on column EIBELONGRELATION.BRASSETRELATION is '�ʲ���ϵ��';
comment on column EIBELONGRELATION.EIROOTMARK is '�ʲ����������ڵ�ʵ���ʶ';
comment on column EIBELONGRELATION.DELETEFLAG is '�߼�ɾ����ʶ';
comment on column EIBELONGRELATION.FINGERPRINT is 'ʱ���';

--IG911
comment on table IG911 is '�Զ���������ط�����Ϣ��';
comment on column IG911.psprpid is '��������';
comment on column IG911.pdid is '��������ID';
comment on column IG911.psdid is '����״̬ID';
comment on column IG911.roleid is '�����߽�ɫID';
comment on column IG911.relevantPdid is '��ط������������ID';
comment on column IG911.fingerPrint is 'ʱ���';

--IG931
comment on table IG931 is 'ȱʡ�Զ���������ط�����Ϣ��';
comment on column IG931.dpsprpid is '��������';
comment on column IG931.pdid is '��������ID';
comment on column IG931.psdid is '����״̬ID';
comment on column IG931.relevantPdid is '��ط������������ID';
comment on column IG931.fingerPrint is 'ʱ���';