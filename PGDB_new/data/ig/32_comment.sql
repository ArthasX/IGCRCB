--Role
comment on table IG.Role is '��ɫ��';
comment on column IG.Role.roleid is '��ɫID';
comment on column IG.Role.rolename is '��ɫ����';
comment on column IG.Role.roledesc is '��ɫ˵��';
comment on column IG.Role.roleinfo is '��ɫ��Ϣ';
comment on column IG.Role.roletype is '��ɫ����';
comment on column IG.Role.roledomain is '��ɫ��������Χ';
comment on column IG.Role.assetdomain is '��ɫ�ʲ�ģ�͹���Χ';
comment on column IG.Role.fingerprint is 'ʱ���';

--Action
comment on table IG.Action is '�˵���';
comment on column IG.Action.actname is '�˵���ʶ';
comment on column IG.Action.actlabel is '�˵���ʾ����';
comment on column IG.Action.actdesc is '�˵�˵��';
comment on column IG.Action.acturl is '�ύURL';
comment on column IG.Action.acttype is '�˵�����';
comment on column IG.Action.actl1id is 'һ���˵�ID��������';
comment on column IG.Action.actl2id is '�����˵�ID��������';
comment on column IG.Action.actl3id is '�����˵�ID��������';
comment on column IG.Action.fingerprint is 'ʱ���';
comment on column IG.Action.actroletype is '�˵��������ɫ����';
comment on column IG.Action.actsortid is '�˵���ʾ˳��';
comment on column IG.Action.acturltype is '�ύURL����';

--RoleAction
comment on table IG.RoleAction is '��ɫ�˵���';
comment on column IG.RoleAction.raid is '��ɫ�˵�ID';
comment on column IG.RoleAction.roleid is '��ɫID';
comment on column IG.RoleAction.actname is '�˵���ʶ';
comment on column IG.RoleAction.raperm is '��ɫ��Ӧ�˵���Ȩ�ޣ�������';
comment on column IG.RoleAction.radesc is '��ɫ��Ӧ�˵���Ȩ��˵����������';
comment on column IG.RoleAction.fingerprint is 'ʱ���';

--Organization
comment on table IG.Organization is '������';
comment on column IG.Organization.orgid is '����ID';
comment on column IG.Organization.orgname is '��������';
comment on column IG.Organization.orgpar is '�ϼ����������';
comment on column IG.Organization.orgparname is '�ϼ��������ƣ�������';
comment on column IG.Organization.orgdesc is '����˵��';
comment on column IG.Organization.orgtype is '��������';
comment on column IG.Organization.orgaddr is '������ַ';
comment on column IG.Organization.orgphone is '�����绰';
comment on column IG.Organization.orgfax is '��������';
comment on column IG.Organization.orgcontact is '������ϵ��';
comment on column IG.Organization.orgstatus is '����״̬';
comment on column IG.Organization.orginfo is '������Ϣ';
comment on column IG.Organization.orgsyscoding is '���������';
comment on column IG.Organization.orgusercoding is '��������';
comment on column IG.Organization.fingerprint is 'ʱ���';

--IgUser
comment on table IG.IgUser is '�û���';
comment on column IG.IgUser.userid is '�û�ID';
comment on column IG.IgUser.orgid is '�������������';
comment on column IG.IgUser.orgname is '������������';
comment on column IG.IgUser.username is '�û�����';
comment on column IG.IgUser.userdesc is '�û�˵��';
comment on column IG.IgUser.userinfo is '�û���Ϣ';
comment on column IG.IgUser.password is '�û�����';
comment on column IG.IgUser.userstatus is '�û�״̬';
comment on column IG.IgUser.usertype is '�û�����';
comment on column IG.IgUser.userphone is '�û��绰';
comment on column IG.IgUser.usermobile is '�û��ֻ�';
comment on column IG.IgUser.useremail is '�û�����';
comment on column IG.IgUser.fingerprint is 'ʱ���';
comment on column IG.IgUser.deleteflag is '�߼�ɾ����ʶ';

--IG622
comment on table IG.IG622 is '��ҳ��תURL�����';
comment on column IG.IG622.HPID is '��ҳID';
comment on column IG.IG622.HPLABEL is '��ҳ����';
comment on column IG.IG622.HPTITLE is '��ҳ��ʾ����';
comment on column IG.IG622.HPURL is '��ҳURL';
comment on column IG.IG622.FINGERPRINT is 'ʱ���';

--UserRole
comment on table IG.UserRole is '�û���ɫ��';
comment on column IG.UserRole.urid is '�û���ɫID';
comment on column IG.UserRole.userid is '�û�ID';
comment on column IG.UserRole.orgid is '��ɫID';
comment on column IG.UserRole.roleid is '���������';
comment on column IG.UserRole.fingerprint is 'ʱ���';
comment on column IG.UserRole.rolemanager is '��ɫ�����˱�ʶ';
comment on column IG.UserRole.dutyflag is 'ֵ���˱�ʶ';

--Notice
comment on table IG.Notice is '֪ͨ��';
comment on column IG.Notice.nid is '֪ͨID';
comment on column IG.Notice.nname is '֪ͨ����';
comment on column IG.Notice.ndesc is '֪ͨ����';
comment on column IG.Notice.ntime is '֪ͨʱ��';
comment on column IG.Notice.nuserid is '�û�ID';
comment on column IG.Notice.nusername is '�û�����';
comment on column IG.Notice.norgid is '���������';
comment on column IG.Notice.norgname is '��������';
comment on column IG.Notice.nattkey is '����KEY';
comment on column IG.Notice.fingerprint is 'ʱ���';

--CodeCategory
comment on table IG.CodeCategory is '�������ݷ����';
comment on column IG.CodeCategory.ccid is '���ݷ���ID';
comment on column IG.CodeCategory.ccname is '���ݷ�������';
comment on column IG.CodeCategory.ccinfo is '���ݷ���˵��';
comment on column IG.CodeCategory.cceditable is '�༭��ʶ';
comment on column IG.CodeCategory.pccid is '�ϼ����ݷ���ID';
comment on column IG.CodeCategory.pcflag is '֧�������';
comment on column IG.CodeCategory.fingerprint is 'ʱ���';

--CodeDetail
comment on table IG.CodeDetail is '����������ϸ��Ϣ��';
comment on column IG.CodeDetail.ccid is '���ݷ���ID';
comment on column IG.CodeDetail.cid is '����ID';
comment on column IG.CodeDetail.cvalue is '��������';
comment on column IG.CodeDetail.pccid is '�ϼ����ݷ���ID';
comment on column IG.CodeDetail.pcid is '�ϼ�����ID';
comment on column IG.CodeDetail.updtime is '���ݸ���ʱ��';
comment on column IG.CodeDetail.syscoding is '���ݲ����';
comment on column IG.CodeDetail.psyscoding is '�ϼ����ݲ����';
comment on column IG.CodeDetail.cdstatus is '����״̬';
comment on column IG.CodeDetail.businesscode is '�ʲ�������ϵ��';
comment on column IG.CodeDetail.fingerprint is 'ʱ���';
comment on column IG.CodeDetail.cdinfo is '����˵��';
comment on column IG.CodeDetail.cdorder is '������ʾ˳��';

--CODECATEGORYDEF
comment on table IG.CODECATEGORYDEF is '�������ݷ����';
comment on column IG.CODECATEGORYDEF.CCID is '�������ݷ���ID';
comment on column IG.CODECATEGORYDEF.CCNAME is '�������ݷ�������';
comment on column IG.CODECATEGORYDEF.CCINFO is '�������ݷ���˵��';
comment on column IG.CODECATEGORYDEF.CCEDITABLE is '�༭��ʶ';
comment on column IG.CODECATEGORYDEF.PCCID is '�ϼ����ݷ���ID'; 
comment on column IG.CODECATEGORYDEF.PCFLAG is '֧�������';
comment on column IG.CODECATEGORYDEF.FINGERPRINT is 'ʱ���';

--CODEDETAILDEF
comment on table IG.CODEDETAILDEF is '����������ϸ��Ϣ��';
comment on column IG.CODEDETAILDEF.CCID is '�������ݷ���ID'; 
comment on column IG.CODEDETAILDEF.CID is '����ID';
comment on column IG.CODEDETAILDEF.CVALUE is '��������';
comment on column IG.CODEDETAILDEF.PCCID is '�ϼ����ݷ���ID';
comment on column IG.CODEDETAILDEF.PCID is '�ϼ�����ID';
comment on column IG.CODEDETAILDEF.UPDTIME is '���ݸ���ʱ��';
comment on column IG.CODEDETAILDEF.SYSCODING is '���ݲ����';
comment on column IG.CODEDETAILDEF.PSYSCODING is '�ϼ����ݲ����';
comment on column IG.CODEDETAILDEF.CDSTATUS is '����״̬';
comment on column IG.CODEDETAILDEF.BUSINESSCODE is 'ҵ���ʶ';
comment on column IG.CODEDETAILDEF.CDINFO is '����˵��';
comment on column IG.CODEDETAILDEF.FINGERPRINT is 'ʱ���';

--IG117
comment on table IG.IG117 is '�ʲ�ģ�ͱ�';
comment on column IG.IG117.eid is 'ģ��ID';
comment on column IG.IG117.ename is 'ģ������';
comment on column IG.IG117.elabel is 'ģ�ͱ�ʶ';
comment on column IG.IG117.edesc is 'ģ��˵��';
comment on column IG.IG117.estatus is 'ģ��״̬';
comment on column IG.IG117.ecategory is 'ģ�ͷ���';
comment on column IG.IG117.ekey1 is '����';
comment on column IG.IG117.ekey2 is '����';
comment on column IG.IG117.ekey3 is '����';
comment on column IG.IG117.esyscoding is 'ģ�Ͳ����';
comment on column IG.IG117.eparcoding is '�ϼ�ģ�Ͳ����';
comment on column IG.IG117.fingerprint is 'ʱ���';
comment on column IG.IG117.emodeltype is 'ģ������';

--IG225
comment on table IG.IG225 is '�ʲ����ñ�';
comment on column IG.IG225.cid is '����ID';
comment on column IG.IG225.eid is '�ʲ�ģ��ID';
comment on column IG.IG225.cname is '��������';
comment on column IG.IG225.clabel is '���ùؼ���';
comment on column IG.IG225.cdesc is '����˵��';
comment on column IG.IG225.cunit is '���õ�λ';
comment on column IG.IG225.cstatus is '����״̬';
comment on column IG.IG225.cseq is '���ÿɼ���ʶ';
comment on column IG.IG225.ccategory is '�������';
comment on column IG.IG225.coption is '����ȡֵ��Χ';
comment on column IG.IG225.cattach is '������������';
comment on column IG.IG225.esyscoding is '�ʲ�ģ�Ͳ����';
comment on column IG.IG225.fingerprint is 'ʱ���';
comment on column IG.IG225.crequired is '���ñ����ʶ';

--IG545
comment on table IG.IG545 is '�ʲ�����ȡֵ��Χ��';
comment on column IG.IG545.ccdid is '����ID';
comment on column IG.IG545.ccdcategory is '���ݱ���';
comment on column IG.IG545.ccdlabel is '��������';
comment on column IG.IG545.ccdvalue is '����ֵ';
comment on column IG.IG545.ccdstatus is '����״̬';
comment on column IG.IG545.ccdtype is '��������';
comment on column IG.IG545.ccdinfo is '����˵��';
comment on column IG.IG545.fingerprint is 'ʱ���';

--IG611
comment on table IG.IG611 is '�ʲ�������ȱʡֵ��';
comment on column IG.IG611.EID is '�ʲ�ģ��ID';
comment on column IG.IG611.CID is '�ʲ�����ID';
comment on column IG.IG611.CVALUE is 'ȱʡֵ';
comment on column IG.IG611.FINGERPRINT is 'ʱ���';

--IG013
comment on table IG.IG013 is '�ʲ���';
comment on column IG.IG013.eiid is '�ʲ�ID';
comment on column IG.IG013.eid is '�ʲ�ģ��ID';
comment on column IG.IG013.eidesc is '�ʲ�˵��';
comment on column IG.IG013.einame is '�ʲ�����';
comment on column IG.IG013.eilabel is '�ʲ����';
comment on column IG.IG013.eiinsdate is '�ʲ��Ǽ�����';
comment on column IG.IG013.eiorgsyscoding is '�ʲ��������������';
comment on column IG.IG013.esyscoding is '�ʲ�����ģ�Ͳ����';
comment on column IG.IG013.eiupdtime is '�ʲ�����ʱ��';
comment on column IG.IG013.eistatus is '�ʲ�״̬';
comment on column IG.IG013.eiversion is '�ʲ���汾';
comment on column IG.IG013.fingerprint is 'ʱ���';
comment on column IG.IG013.eiuserid is '�ʲ�������ID';
comment on column IG.IG013.eiusername is '�ʲ�����������';
comment on column IG.IG013.eismallversion is '�ʲ�С�汾';
comment on column IG.IG013.eirootmark is '�ʲ��������ڵ�ʵ���ʶ';

--IG800
comment on table IG.IG800 is '�ʲ��������';
comment on column IG.IG800.ciid is '�ʲ�������ID';
comment on column IG.IG800.cid is '�ʲ�����ID';
comment on column IG.IG800.eiid is '�ʲ�ID';
comment on column IG.IG800.eid is '�ʲ�ģ��ID';
comment on column IG.IG800.civalue is '������ֵ';
comment on column IG.IG800.ciupdtime is '���������ʱ��';
comment on column IG.IG800.esyscoding is '�ʲ�ģ�Ͳ����';
comment on column IG.IG800.ciexpire is '����';
comment on column IG.IG800.cistatus is '����';
comment on column IG.IG800.cicurver is '������ֵ�Ƿ���';
comment on column IG.IG800.civersion is '�������汾';
comment on column IG.IG800.civerinfo is '����';
comment on column IG.IG800.fingerprint is 'ʱ���';
comment on column IG.IG800.cismallversion is '������С�汾';

--IG313
comment on table IG.IG313 is '�ʲ���ϵ��';
comment on column IG.IG313.eirid is '�ʲ���ϵID';
comment on column IG.IG313.pareiid is '�ʲ�ID������';
comment on column IG.IG313.pareid is '�ʲ�ģ��ID������';
comment on column IG.IG313.cldeiid is '�ʲ�ID������';
comment on column IG.IG313.cldeid is '�ʲ�ģ��ID������';
comment on column IG.IG313.eirrelation is '������ϵ��ʶ';
comment on column IG.IG313.eirrelationcode is '��ϵ��ͷ';
comment on column IG.IG313.eirupdtime is '����ʱ��';
comment on column IG.IG313.eirstatus is '��ɾ����ʶ';
comment on column IG.IG313.eirdesc is '��ϵ˵��';
comment on column IG.IG313.fingerprint is 'ʱ���';
comment on column IG.IG313.eirinfo is '�����ϵ��ʶ';
comment on column IG.IG313.parversion is '�ʲ���汾������';
comment on column IG.IG313.parsmallversion is '�ʲ�С�汾������';
comment on column IG.IG313.cldversion is '�ʲ���汾������';
comment on column IG.IG313.cldsmallversion is '�ʲ�С�汾������';
comment on column IG.IG313.deleteflag is '�߼�ɾ����ʶ';

--IG809
comment on table IG.IG809 is '�ʲ���ϵͼ��Ϣ��������';
comment on column IG.IG809.eirfid is '�ʲ���ϵͼ��ϢID';
comment on column IG.IG809.eiid is '�ʲ�ID';
comment on column IG.IG809.eirftype is '��ϵͼ����';
comment on column IG.IG809.eirfname is '��ϵͼXML�ļ���';
comment on column IG.IG809.eirfupdtime is '��ϵͼ����ʱ��';
comment on column IG.IG809.fingerprint is 'ʱ���';

--COLLECTPARAM
comment on table IG.COLLECTPARAM is '����ɼ��ű������������';
comment on column IG.COLLECTPARAM.CPTYPEID is '��������';
comment on column IG.COLLECTPARAM.CPSMODE is '�ű�����';
comment on column IG.COLLECTPARAM.CPSCRIPTNAME is '�ű�����';
comment on column IG.COLLECTPARAM.CPFILEPATH is '�ű�·��';
comment on column IG.COLLECTPARAM.FINGERPRINT is 'ʱ���';

--compareTemplate
comment on table IG.compareTemplate is '����λ����Ϣ��';
comment on column IG.compareTemplate.ctid is 'λ����ϢID';
comment on column IG.compareTemplate.ctcategory is '���ID';
comment on column IG.compareTemplate.cttype is '����';
comment on column IG.compareTemplate.ctxwidth is '������';
comment on column IG.compareTemplate.ctywidth is '������';
comment on column IG.compareTemplate.ctvalue is 'ֵ';
comment on column IG.compareTemplate.fingerprint is 'ʱ���';

--IG259
comment on table IG.IG259 is '����ģ���';
comment on column IG.IG259.ptid is 'ģ��ID';
comment on column IG.IG259.ptname is 'ģ������';
comment on column IG.IG259.pttype is 'ģ������';
comment on column IG.IG259.ptstartpg is 'ģ�淢��ҳURL';
comment on column IG.IG259.ptdetailpg is 'ģ�洴��ʱ��';
comment on column IG.IG259.ptcrtdate is 'ģ����Ϣ';
comment on column IG.IG259.ptpicinfo is 'ģ��״̬';
comment on column IG.IG259.ptstatus is 'ģ��鿴ҳURL';
comment on column IG.IG259.ptsavepg is '����ҳURL';
comment on column IG.IG259.ptqrtzflag is '��ʱ����URL';
comment on column IG.IG259.fingerprint is 'ʱ���';

--IG380
comment on table IG.IG380 is '�������ͱ�';
comment on column IG.IG380.pdid is '��������ID';
comment on column IG.IG380.ptid is '����ģ��ID';
comment on column IG.IG380.pdname is '��������';
comment on column IG.IG380.pddesc is '��������';
comment on column IG.IG380.pdcrtdate is '����ʱ��';
comment on column IG.IG380.pdstatus is '����״̬';
comment on column IG.IG380.pdxml is '����ͼXML';
comment on column IG.IG380.permission is 'Ȩ��';
comment on column IG.IG380.fingerprint is 'ʱ���';
comment on column IG.IG380.serialgenerator is '������������';
comment on column IG.IG380.pdactname is '���̶����˵�ID';

--IG007
comment on table IG.IG007 is '���̱������';
comment on column IG.IG007.pidid is '������ID';
comment on column IG.IG007.pdid is '���̶���ID';
comment on column IG.IG007.pidname is '����ʶ';
comment on column IG.IG007.pidlabel is '����ʾ����';
comment on column IG.IG007.piddesc is '������';
comment on column IG.IG007.pidtype is '������';
comment on column IG.IG007.pidoption is '��ȡֵ��Χ';
comment on column IG.IG007.piddefault is '��Ĭ��ֵ';
comment on column IG.IG007.pidrequired is '�Ƿ����';
comment on column IG.IG007.fingerprint is 'ʱ���';
comment on column IG.IG007.pidsortid is '�����ʶ';
comment on column IG.IG007.ccid is '�������ݷ���ID';
comment on column IG.IG007.pidgid is 'ͨ�ñ�����ID';
comment on column IG.IG007.PIDMODE is '��ģʽ';
comment on column IG.IG007.PRIVATESCOPE is '˽�б�Ȩ�޷�Χ';
comment on column IG.IG007.ROWWIDTH is '������ʾģʽ';

--IG333
comment on table IG.IG333 is '�Զ�������״̬�����';
comment on column IG.IG333.psdid is '����״̬ID';
comment on column IG.IG333.pdid is '���̶���ID';
comment on column IG.IG333.psdname is '״̬����';
comment on column IG.IG333.psddesc is '״̬����';
comment on column IG.IG333.psdcode is '״̬��ʶ';
comment on column IG.IG333.fingerPrint is 'ʱ���';
comment on column IG.IG333.psdtype is '״̬����';
comment on column IG.IG333.psdmode is '״̬ģʽ';
comment on column IG.IG333.psdflag is '��̬�����߱�ʶ';
comment on column IG.IG333.psdassign is '���ɲ���������';
comment on column IG.IG333.psdorg is '���ɲ���������';
comment on column IG.IG333.psdconfirm is '����ȷ�ϲ���';
comment on column IG.IG333.assignpsdid is '���ɽڵ�ID';
comment on column IG.IG333.assignpbdid is '���ɰ�ťID';
comment on column IG.IG333.assignflag is '�Ƿ������ɱ�ʶ';
comment on column IG.IG333.participantchange is '�������Ƿ�ɸ��ɱ�ʶ';
comment on column IG.IG333.assignpagetype is '����ҳ������';

--IG258
comment on table IG.IG258 is '�Զ������̿ɷ���״̬�����';
comment on column IG.IG258.pspcdid is '��������';
comment on column IG.IG258.psdid is 'Դ״̬';
comment on column IG.IG258.pspcdpsdid is '�ɱ�����״̬';
comment on column IG.IG258.fingerPrint is 'ʱ���';

--IG211
comment on table IG.IG211 is '�Զ������̱�Ĭ��ֵ��������';
comment on column IG.IG211.psidid is 'Ĭ��ֵID';
comment on column IG.IG211.psdid is '����״̬ID';
comment on column IG.IG211.pidid is '������ID';
comment on column IG.IG211.pidname is '����ʶ';
comment on column IG.IG211.pidlabel is '����ʾ����';
comment on column IG.IG211.piddesc is '������';
comment on column IG.IG211.pidtype is '������';
comment on column IG.IG211.pidvalue is '��ֵ';
comment on column IG.IG211.pidattkey is '����KEY';
comment on column IG.IG211.fingerPrint is 'ʱ���';

--IG900
comment on table IG.IG900 is '�Զ������̰�ť�����';
comment on column IG.IG900.pbdid is '��ťID';
comment on column IG.IG900.pbdname is '��ťĬ������';
comment on column IG.IG900.pbdflag is '�Ƿ�ϵͳ������ť';
comment on column IG.IG900.pbdimage is '��ť��ʾͼƬ����';
comment on column IG.IG900.fingerPrint is 'ʱ���';

--IG222
comment on table IG.IG222 is '�Զ������̲����߶����';
comment on column IG.IG222.ppdid is '������ID';
comment on column IG.IG222.psdid is '����״̬ID';
comment on column IG.IG222.roleid is '��ɫID';
comment on column IG.IG222.userid is 'Ĭ�ϲ����û�ID';
comment on column IG.IG222.ppdsuper is '�Ƿ�SUPER��ɫ';
comment on column IG.IG222.fingerPrint is 'ʱ���';

--IG132
comment on table IG.IG132 is '�����߰�ť������Ϣ��';
comment on column IG.IG132.ppbdid is '��������';
comment on column IG.IG132.ppdid is '�����߶���ID';
comment on column IG.IG132.pbdid is '��ť����ID';
comment on column IG.IG132.ppbdname is '��ť��ʾ����';
comment on column IG.IG132.ppbddesc is '��ť��ʾ��Ϣ';
comment on column IG.IG132.ppbdauth is '��ť�ύȨ��';
comment on column IG.IG132.fingerPrint is 'ʱ���';

--IG881
comment on table IG.Action is '�Զ������̲����߱���Ȩ�ޱ�';
comment on column IG.IG881.pipdid is '�����߱���Ȩ��ID';
comment on column IG.IG881.pidid is '������ID';
comment on column IG.IG881.psdid is '����״̬ID';
comment on column IG.IG881.ppdid is '�����߶���ID';
comment on column IG.IG881.pidaccess is '��Ȩ��';
comment on column IG.IG881.fingerPrint is 'ʱ���';
comment on column IG.IG881.PIDREQUIRED is '�Ƿ����';

--IG273
comment on table IG.IG273 is '�Զ�������״̬ԾǨ�����';
comment on column IG.IG273.ptdid is 'ԾǨ����ID';
comment on column IG.IG273.fpsdid is 'Դ����״̬ID';
comment on column IG.IG273.tpsdid is 'Ŀ������״̬ID';
comment on column IG.IG273.ptdname is 'ԾǨ��������';
comment on column IG.IG273.ptddesc is 'ԾǨ��������';
comment on column IG.IG273.ptdtype is 'ԾǨ��������';
comment on column IG.IG273.ptdcond is 'ԾǨ����';
comment on column IG.IG273.fingerPrint is 'ʱ���';

--IG933
comment on table IG.IG933 is '���񹤵���';
comment on column IG.IG933.sfid is '���񹤵�ID';
comment on column IG.IG933.sfreportname is '����������';
comment on column IG.IG933.sfreportphone is '��������ϵ�绰';
comment on column IG.IG933.sfreportorgid is '�����˻��������';
comment on column IG.IG933.sftitle is '����';
comment on column IG.IG933.sfdesc is '����';
comment on column IG.IG933.sfattkey is '����KEY';
comment on column IG.IG933.sfstatus is '״̬';
comment on column IG.IG933.sftype is '����';
comment on column IG.IG933.sforgid is '�Ǽ��˻��������';
comment on column IG.IG933.sfeiid is '����ʲ�ID';
comment on column IG.IG933.sfregisterid is '�Ǽ���ID';
comment on column IG.IG933.sfinstime is '�Ǽ�ʱ��';
comment on column IG.IG933.fingerprint is 'ʱ���';
comment on column IG.IG933.SFCODE is '���񹤵����';
comment on column IG.IG933.SFSOURCE is '��Դ';
comment on column IG.IG933.SFWORKPHONE is '�칫�绰';
comment on column IG.IG933.SFEMAIL is '����';

--IG941
comment on table IG.IG941 is '���񹤵���־��';
comment on column IG.IG941.sflid is '��־ID';
comment on column IG.IG941.sfid is '���񹤵�ID';
comment on column IG.IG941.sfluserid is '������ID';
comment on column IG.IG941.sfldesc is '�����¼';
comment on column IG.IG941.sflinstime is '����ʱ��';
comment on column IG.IG941.fingerprint is 'ʱ���';
comment on column IG.IG941.sflattkey is '����KEY';

--SmsSendLog
comment on table IG.SmsSendLog is '������־��������';
comment on column IG.SmsSendLog.SSLID is '��־ID';
comment on column IG.SmsSendLog.USERNAME is '�û�����'; 
comment on column IG.SmsSendLog.DEPTMENTNAME is '�û�������������'; 
comment on column IG.SmsSendLog.SENDDATE is '��������'; 
comment on column IG.SmsSendLog.USERMOBILE is '�����ֻ���'; 
comment on column IG.SmsSendLog.SMSTYPE is '��־����'; 
comment on column IG.SmsSendLog.SENDFLAG is '�ɹ�ʧ�ܱ�־'; 
comment on column IG.SmsSendLog.FINGERPRINT is 'ʱ���';

--IG992
comment on table IG.IG992 is '�Զ��������ⲿ�¼������';
comment on column IG.IG992.PEDID is '��������';
comment on column IG.IG992.PEDEVENTID is '�¼�ID';
comment on column IG.IG992.PEDACTION is '����BL��ʶ';
comment on column IG.IG992.PEDDESC is '����';
comment on column IG.IG992.FINGERPRINT is 'ʱ���';

--IG286
comment on table IG.IG286 is '�Զ������̱������������';
comment on column IG.IG286.plid is '��������';
comment on column IG.IG286.pldpdid is '���̶���ID';
comment on column IG.IG286.pldactionid is '����ID';
comment on column IG.IG286.initiativepidid is '����������ID';
comment on column IG.IG286.passivitypidid is '����������ID';
comment on column IG.IG286.pldesc is '����';
comment on column IG.IG286.plblname is '����BL��ʶ';
comment on column IG.IG286.pljsevent is 'JS�ű��¼�����';
comment on column IG.IG286.pljtype is '������������';
comment on column IG.IG286.initiativepidname is '����������';
comment on column IG.IG286.passivitypidname is '����������';
comment on column IG.IG286.fingerprint is 'ʱ���';

--IG413
comment on table IG.IG413 is '�Զ�������ǰ�����¼������';
comment on column IG.IG413.pedid is '��������';
comment on column IG.IG413.pdid is '���̶���ID';
comment on column IG.IG413.psdid is '����״̬ID';
comment on column IG.IG413.pedactionid is '����ID';
comment on column IG.IG413.pedtype is '�¼�����';
comment on column IG.IG413.pedblid is '����BL��ʶ';
comment on column IG.IG413.pedorder is '�¼�ִ��˳��';
comment on column IG.IG413.pedec is '����';
comment on column IG.IG413.fingerPrint is 'ʱ���';

--IG373
comment on table IG.IG373 is '�Զ������̱���ʼ���¼������';
comment on column IG.IG373.piidid is '��������';
comment on column IG.IG373.pdid is '���̶���ID';
comment on column IG.IG373.psdid is '����״̬ID';
comment on column IG.IG373.piidblid is '����BL��ʶ';
comment on column IG.IG373.piiddec is '����';
comment on column IG.IG373.fingerPrint is 'ʱ���';

--IG126
comment on table IG.IG126 is '�Զ���������ʾҳ�涨���';
comment on column IG.IG126.pjdid is '��������';
comment on column IG.IG126.pdid is '���̶���ID';
comment on column IG.IG126.pjdtype is 'ҳ������';
comment on column IG.IG126.pjdblid is '����BL��ʶ';
comment on column IG.IG126.pjdurl is 'JSPҳ��·��';
comment on column IG.IG126.fingerPrint is 'ʱ���';

--IG725
comment on table IG.IG725 is '�Զ�������ȱʡ�����߰�ť�����';
comment on column IG.IG725.pdbdid is '��������';
comment on column IG.IG725.psdid is '����״̬ID';
comment on column IG.IG725.pbdid is '��ťID';
comment on column IG.IG725.pdbdname is '��ť��ʾ����';
comment on column IG.IG725.pdbddesc is '��ť��ʾ��Ϣ';
comment on column IG.IG725.pdbdauth is '��ť�ύȨ��';
comment on column IG.IG725.fingerPrint is 'ʱ���';

--IG711
comment on table IG.IG711 is '�Զ������̴�����Ȩ��';
comment on column IG.IG711.paid is '��������';
comment on column IG.IG711.paiid is '����Ȩ��ID';
comment on column IG.IG711.pauid is '��Ȩ��ID';
comment on column IG.IG711.pabegintime is '��Ȩ��ʼʱ��';
comment on column IG.IG711.paendtime is '��Ȩ����ʱ��';
comment on column IG.IG711.paflag is '�Ƿ���Ȩ��ʶ';
comment on column IG.IG711.patype is '��Ȩ����';
comment on column IG.IG711.paprocessid is '����ID';
comment on column IG.IG711.paprocessnum is '���̹�����';
comment on column IG.IG711.palogintime is '��Ȩʱ��';
comment on column IG.IG711.fingerprint is 'ʱ���';	
comment on column IG.IG711.remarks is '��ע';

--IG699
comment on table IG.IG699 is '�Զ�������ȱʡ�����߱�Ȩ�ޱ�';
comment on column IG.IG699.pdvid is '��������';
comment on column IG.IG699.pidid is '������ID';
comment on column IG.IG699.psdid is '����״̬ID';
comment on column IG.IG699.pidaccess is '��Ȩ��';
comment on column IG.IG699.fingerPrint is 'ʱ���';
comment on column IG.IG699.PIDREQUIRED is '�Ƿ����';

--IG500
comment on table IG.IG500 is '���̹�����';
comment on column IG.IG500.prid is '����ID';
comment on column IG.IG500.prtype is '��������';
comment on column IG.IG500.prsubtype is '����������';
comment on column IG.IG500.prstatus is '����״̬';
comment on column IG.IG500.prsubstatus is '������״̬';
comment on column IG.IG500.prtitle is '���̱���';
comment on column IG.IG500.prdesc is '��������';
comment on column IG.IG500.propentime is '���̷���ʱ��';
comment on column IG.IG500.prclosetime is '���̹ر�ʱ��';
comment on column IG.IG500.prplantime is '�ƻ�ִ��ʱ��';
comment on column IG.IG500.prduration is '�ƻ�ִ������';
comment on column IG.IG500.prurgency is '�����̶�';
comment on column IG.IG500.primpact is 'Ӱ��̶�';
comment on column IG.IG500.prassetid is '����ʲ�ID';
comment on column IG.IG500.prassetname is '����ʲ�����';
comment on column IG.IG500.prassetcategory is '����ʲ�����';
comment on column IG.IG500.prbusiness is '���ҵ��';
comment on column IG.IG500.primplplan is 'ִ�мƻ�';
comment on column IG.IG500.prbackplan is '�ָ��ƻ�';
comment on column IG.IG500.prvfyplan is '��֤�ƻ�';
comment on column IG.IG500.pid is '�����ĿID';
comment on column IG.IG500.pcode is '�����Ŀ���';
comment on column IG.IG500.pname is '�����Ŀ����';
comment on column IG.IG500.prinfo is '��������ϵ��ʽ';
comment on column IG.IG500.prcorid is '�������ID';
comment on column IG.IG500.prcortype is '�����������';
comment on column IG.IG500.prcortitle is '������̱���';
comment on column IG.IG500.pruserid is '������ID';
comment on column IG.IG500.prusername is '����������';
comment on column IG.IG500.prroleid is '�����߽�ɫID';
comment on column IG.IG500.prrolename is '�����߽�ɫ����';
comment on column IG.IG500.prpdid is '��������ID';
comment on column IG.IG500.prpdname is '������������';
comment on column IG.IG500.prorgid is '�����߻��������';
comment on column IG.IG500.prorgname is '�����߻�������';
comment on column IG.IG500.prserialnum is '���̹�����';
comment on column IG.IG500.prfacttime is 'ʵ�ʽ��ʱ��';
comment on column IG.IG500.fingerprint is 'ʱ���';
comment on column IG.IG500.prptdcond is '����ԾǨ����';
comment on column IG.IG500.prstrategyversion is '���̲��԰汾';
comment on column IG.IG500.prpriority is '���ȼ�';

--IG394
comment on table IG.IG394 is '�Զ�������֪ͨ��־��';
comment on column IG.IG394.PNSSID is '��־ID';
comment on column IG.IG394.PRID is '����ID';
comment on column IG.IG394.PSDID is '����״̬ID';
comment on column IG.IG394.PSDCONFIRM is '�ӵ�';
comment on column IG.IG394.ROLEID is '֪ͨ��ɫID';
comment on column IG.IG394.USERID is '֪ͨ�û�ID';
comment on column IG.IG394.NOTIFYSMSTIME is '�������ѷ���ʱ��';
comment on column IG.IG394.NOTIFYEMAILTIME is '�ʼ����ѷ���ʱ��';
comment on column IG.IG394.REPORTSMSTIME is '�����ϱ�����ʱ��';
comment on column IG.IG394.REPORTEMAILTIME is '�ʼ��ϱ�����ʱ��';
comment on column IG.IG394.FINGERPRINT is 'ʱ���';

--IG337
comment on table IG.IG337 is '���̲�������Ϣ��';
comment on column IG.IG337.ppid is '��������';
comment on column IG.IG337.prid is '����ID';
comment on column IG.IG337.pproleid is '��ɫID';
comment on column IG.IG337.pprolename is '��ɫ����';
comment on column IG.IG337.ppuserid is '�û�ID';
comment on column IG.IG337.ppusername is '�û�����';
comment on column IG.IG337.pporgid is '�û��������������';
comment on column IG.IG337.pporgname is '�û�������������';
comment on column IG.IG337.pptype is '��������';
comment on column IG.IG337.ppuserinfo is '�û���Ϣ';
comment on column IG.IG337.ppcomment is '��������';
comment on column IG.IG337.ppstatus is '����״̬';
comment on column IG.IG337.ppattkey is '����KEY';
comment on column IG.IG337.ppinittime is 'ָ��ʱ��';
comment on column IG.IG337.ppproctime is '�������ʱ��';
comment on column IG.IG337.ppsubstatus is '��״̬';
comment on column IG.IG337.ppfacttime is 'ʵ�ʽ��ʱ��';
comment on column IG.IG337.ppbacktime is '���̻���ָ��ʱ��';
comment on column IG.IG337.fingerprint is 'ʱ���';
comment on column IG.IG337.ppproxyuserid is '�����û�ID';
comment on column IG.IG337.ppsuper is '�Ƿ�SUPER��ɫ';
comment on column IG.IG337.pprolemanager is '�Ƿ��ɫ������';
comment on column IG.IG337.ppdutyperson is '�Ƿ�ֵ����';
comment on column IG.IG337.pbdid is '���̰�ťID';

--IG599
comment on table IG.IG599 is '���̱���Ϣ��';
comment on column IG.IG599.piid is '��������';
comment on column IG.IG599.prid is '����ID';
comment on column IG.IG599.pivarname is '����ʶ';
comment on column IG.IG599.pivarlabel is '����ʾ����';
comment on column IG.IG599.pivartype is '������';
comment on column IG.IG599.pivarvalue is '��ֵ';
comment on column IG.IG599.piattkey is '����KEY';
comment on column IG.IG599.fingerprint is 'ʱ���';
comment on column IG.IG599.pidid is '������ID';
comment on column IG.IG599.PIDMODE is '��ģʽ';
comment on column IG.IG599.PRIVATESCOPE is '˽�б�Ȩ�޷�Χ';

--Attachment
comment on table IG.Attachment is '������';
comment on column IG.Attachment.attid is '��������';
comment on column IG.Attachment.attkey is '����KEY';
comment on column IG.Attachment.attname is '��������';
comment on column IG.Attachment.attdesc is '˵��';
comment on column IG.Attachment.atturl is '�����ʶ';
comment on column IG.Attachment.fingerprint is 'ʱ���';

--IG036
comment on table IG.Action is '������־��';
comment on column IG.IG036.rlid is '��־ID';
comment on column IG.IG036.prid is '����ID';
comment on column IG.IG036.rltime is '����ʱ��';
comment on column IG.IG036.roleid is '�����ɫID';
comment on column IG.IG036.rlrolename is '�����ɫ����';
comment on column IG.IG036.rluserid is '�����û�ID';
comment on column IG.IG036.rlusername is '�����û�����';
comment on column IG.IG036.rltype is '��־����';
comment on column IG.IG036.rldesc is '��־����';
comment on column IG.IG036.rlcomment is '��������';
comment on column IG.IG036.rlattkey is '����KEY';
comment on column IG.IG036.rlorgid is '�����û��������������';
comment on column IG.IG036.rlorgname is '�����û�������������';
comment on column IG.IG036.fingerprint is 'ʱ���';
comment on column IG.IG036.psname is '����״̬����';
comment on column IG.IG036.psdcode is '����״̬��ʶ';
comment on column IG.IG036.rolemanger is '�Ƿ��ɫ������';
comment on column IG.IG036.pbdid is '���̰�ťID';

--IG715
comment on table IG.IG715 is '��������񹤵�������';
comment on column IG.IG715.sprrid is '��������';
comment on column IG.IG715.sprrsfid is '���񹤵�ID';
comment on column IG.IG715.sprrprid is '����ID';
comment on column IG.IG715.sprrinstime is '�Ǽ�ʱ��';
comment on column IG.IG715.fingerprint is 'ʱ���';

--IG113
comment on table IG.IG113 is '���̱���־��';
comment on column IG.IG113.rlvid is '��������';
comment on column IG.IG113.rlid is '������־ID';
comment on column IG.IG113.piid is '���̱�ID';
comment on column IG.IG113.prid is '����ID';
comment on column IG.IG113.pivarname is '����ʶ';
comment on column IG.IG113.pivarlabel is '����ʾ����';
comment on column IG.IG113.pivartype is '������';
comment on column IG.IG113.pivarvalue is '��ֵ';
comment on column IG.IG113.piattkey is '����KEY';
comment on column IG.IG113.pidid is '������ID';
comment on column IG.IG113.pishowvarname is '����ʾ����';
comment on column IG.IG113.fingerprint is 'ʱ���';

--SdlInfo
comment on table IG.SdlInfo is '����ˮƽ��Ϣ��';
comment on column IG.SdlInfo.siid is '��������';
comment on column IG.SdlInfo.sitype is '���';
comment on column IG.SdlInfo.sibegin is '��ʼʱ��';
comment on column IG.SdlInfo.simark is '����';
comment on column IG.SdlInfo.sieiid is '����ʲ�ID';
comment on column IG.SdlInfo.sieiname is '����ʲ�����';
comment on column IG.SdlInfo.siprid is '����¼�����ID';
comment on column IG.SdlInfo.siprtitle is '����¼����̱���';
comment on column IG.SdlInfo.sidesc is '����';
comment on column IG.SdlInfo.siend is '����ʱ��';
comment on column IG.SdlInfo.siattkey is '����KEY';
comment on column IG.SdlInfo.sifacttime is 'ʵ��ʱ��';
comment on column IG.SdlInfo.sidate is '�Ǽ�ʱ��';
comment on column IG.SdlInfo.fingerprint is 'ʱ���';

--SdlDefineInfo
comment on table IG.SdlDefineInfo is '����ˮƽĿ����Ϣ��';
comment on column IG.SdlDefineInfo.sdiid is '��������';
comment on column IG.SdlDefineInfo.sdiyear is '�Ǽ����';
comment on column IG.SdlDefineInfo.sdieiid is '����ʲ�ID';
comment on column IG.SdlDefineInfo.sdieiname is '����ʲ�����';
comment on column IG.SdlDefineInfo.sdibreakm is '���ж�ʱ��';
comment on column IG.SdlDefineInfo.sdibreaky is '���ж�ʱ��';
comment on column IG.SdlDefineInfo.sdicontinuousm is '������ʱ��ٷֱ�';
comment on column IG.SdlDefineInfo.sdicontinuousy is '������ʱ��ٷֱ�';
comment on column IG.SdlDefineInfo.sdiimpactm is '��Ӱ��ʱ��';
comment on column IG.SdlDefineInfo.sdiimpacty is '��Ӱ��ʱ��';
comment on column IG.SdlDefineInfo.sdisteadym is '���ȶ�ʱ��ٷֱ�';
comment on column IG.SdlDefineInfo.sdisteadyy is '���ȶ�ʱ��ٷֱ�';
comment on column IG.SdlDefineInfo.sdisafecasem is '�°�ȫ�¼�����';
comment on column IG.SdlDefineInfo.sdisafecasey is '�갲ȫ�¼�����';
comment on column IG.SdlDefineInfo.sdisafemarkm is '�°�ȫ�¼�����';
comment on column IG.SdlDefineInfo.sdisafemarky is '�갲ȫ�¼�����';
comment on column IG.SdlDefineInfo.sdiriskmarkm is '�·��ռ������';
comment on column IG.SdlDefineInfo.sdiriskmarky is '����ռ������';
comment on column IG.SdlDefineInfo.sdicapacitycasem is '�������¼�����';
comment on column IG.SdlDefineInfo.sdicapacitycasey is '�������¼�����';
comment on column IG.SdlDefineInfo.sdicapacitymarkm is '�������¼�����';
comment on column IG.SdlDefineInfo.sdicapacitymarky is '�������¼�����';
comment on column IG.SdlDefineInfo.fingerprint is 'ʱ���';

--Project
comment on table IG.Project is '��Ŀ��';
comment on column IG.Project.pid is '��ĿID';
comment on column IG.Project.ptype is '��Ŀ����';
comment on column IG.Project.pcode is '��Ŀ���';
comment on column IG.Project.pname is '��Ŀ����';
comment on column IG.Project.pdesc is '��Ŀ˵��';
comment on column IG.Project.pinfo is '��������';
comment on column IG.Project.popentime is '��Ŀ��ʼʱ��';
comment on column IG.Project.pclosetime is '��Ŀ����ʱ��';
comment on column IG.Project.pstatus is '��Ŀ״̬';
comment on column IG.Project.porg is '�Ǽ���������������루ǰ������';
comment on column IG.Project.prole is '��Ŀ������';
comment on column IG.Project.puser is '��Ŀ������';
comment on column IG.Project.fingerprint is 'ʱ���';

--ProjectPlan
comment on table IG.ProjectPlan is '��Ŀ�ƻ���';
comment on column IG.ProjectPlan.pplid is '�ƻ�ID';
comment on column IG.ProjectPlan.pid is '��ĿID';
comment on column IG.ProjectPlan.pplinfo is '��Ϣ';
comment on column IG.ProjectPlan.pplversion is '�汾';
comment on column IG.ProjectPlan.pplstatus is '״̬';
comment on column IG.ProjectPlan.ppldesc is '����';
comment on column IG.ProjectPlan.ppldate is '�Ǽ�ʱ��';
comment on column IG.ProjectPlan.fingerprint is 'ʱ���';

--ProjectLog
comment on table IG.ProjectLog is '��Ŀ��־��';
comment on column IG.ProjectLog.plid is '��־ID';
comment on column IG.ProjectLog.pid is '��ĿID';
comment on column IG.ProjectLog.plroleid is '�������ֶΣ�';
comment on column IG.ProjectLog.plrolename is '�������ֶΣ�';
comment on column IG.ProjectLog.pluserid is '�û�ID';
comment on column IG.ProjectLog.plusername is '�û�����';
comment on column IG.ProjectLog.plinfo is '����';
comment on column IG.ProjectLog.pltype is '����';
comment on column IG.ProjectLog.pltime is '�Ǽ�ʱ��';
comment on column IG.ProjectLog.plattkey is '����KEY';
comment on column IG.ProjectLog.fingerprint is 'ʱ���';

--Budget
comment on table IG.Budget is 'Ԥ���';
comment on column IG.Budget.bid is 'Ԥ��ID';
comment on column IG.Budget.btype is 'Ԥ������';
comment on column IG.Budget.binittime is '��������';
comment on column IG.Budget.bopentime is '��ʼʱ��';
comment on column IG.Budget.bstatus is '״̬';
comment on column IG.Budget.breqid is '��������';
comment on column IG.Budget.bapvid is '��������';
comment on column IG.Budget.btitle is 'Ԥ������';
comment on column IG.Budget.bclosetime is '�ر�ʱ��';
comment on column IG.Budget.bdesc is 'Ԥ��˵��';
comment on column IG.Budget.binfo is '��������';
comment on column IG.Budget.byear is 'Ԥ�����';
comment on column IG.Budget.borgid is '��������';
comment on column IG.Budget.borgname is '��������';
comment on column IG.Budget.breqname is '�Ǽ�������';
comment on column IG.Budget.bapvname is '��������';
comment on column IG.Budget.bamount is '���';
comment on column IG.Budget.battkey is '����KEY';
comment on column IG.Budget.pid is '�����Ŀ';
comment on column IG.Budget.pcode is '�����Ŀ���';
comment on column IG.Budget.pname is '�����Ŀ����';
comment on column IG.Budget.fingerprint is 'ʱ���';

--Expense
comment on table IG.Expense is '���ñ�';
comment on column IG.Expense.exid is '����ID';
comment on column IG.Expense.bid is 'Ԥ��ID';
comment on column IG.Expense.exdesc is '����˵��';
comment on column IG.Expense.examount is '���ý��';
comment on column IG.Expense.exinfo is '��������';
comment on column IG.Expense.exstatus is '����״̬';
comment on column IG.Expense.exreqid is '��������';
comment on column IG.Expense.exreqname is '��������';
comment on column IG.Expense.exinittime is '��������';
comment on column IG.Expense.exopentime is '��ʼʱ��';
comment on column IG.Expense.exapvid is '��������';
comment on column IG.Expense.exapvname is '��������';
comment on column IG.Expense.exclosetime is '����ʱ��';
comment on column IG.Expense.exattkey is '����KEY';
comment on column IG.Expense.exeiinfo is '��������';
comment on column IG.Expense.exprinfo is '��������';
comment on column IG.Expense.expinfo is '��������';
comment on column IG.Expense.exorginfo is '��������';
comment on column IG.Expense.btitle is 'Ԥ������';
comment on column IG.Expense.fingerprint is 'ʱ���';

--QuartzJobs
comment on table IG.QuartzJobs is '��ʱ�����';
comment on column IG.QuartzJobs.qjid is '��������';
comment on column IG.QuartzJobs.qjname is '��������';
comment on column IG.QuartzJobs.qjdesc is '��������';
comment on column IG.QuartzJobs.qjtriname is '����������';
comment on column IG.QuartzJobs.qjtrigrp is '����������������';
comment on column IG.QuartzJobs.qjtricron is 'QUARTZ���ʽ';
comment on column IG.QuartzJobs.qjcrtuser is '������ID';
comment on column IG.QuartzJobs.qjimpluser is 'ִ����ID';
comment on column IG.QuartzJobs.qjcrttime is '����ʱ��';
comment on column IG.QuartzJobs.qjendtime is '����ʱ��';
comment on column IG.QuartzJobs.qjtype is '����';
comment on column IG.QuartzJobs.qjstatus is '״̬';
comment on column IG.QuartzJobs.qjinfo is '��ע';
comment on column IG.QuartzJobs.qjcrtusername is '����������';
comment on column IG.QuartzJobs.qjimplusername is 'ִ��������';
comment on column IG.QuartzJobs.qjperiodinfo is '��������';
comment on column IG.QuartzJobs.qjorgid is 'ִ�����������������';
comment on column IG.QuartzJobs.qjorgname is 'ִ����������������';
comment on column IG.QuartzJobs.qjassetid is '����ʲ�ID';
comment on column IG.QuartzJobs.qjassettypeid is '����ʲ�����ģ�Ͳ����';
comment on column IG.QuartzJobs.fingerprint is 'ʱ���';

--QuartzProcessRecord
comment on table IG.QuartzProcessRecord is '��ʱ���̻�����Ϣ��';
comment on column IG.QuartzProcessRecord.qprid is '��ʱ����ID';
comment on column IG.QuartzProcessRecord.qprtype is '����ģ������';
comment on column IG.QuartzProcessRecord.qprsubtype is '����������';
comment on column IG.QuartzProcessRecord.qprstatus is '����״̬';
comment on column IG.QuartzProcessRecord.qprsubstatus is '������״̬';
comment on column IG.QuartzProcessRecord.qprtitle is '���̱���';
comment on column IG.QuartzProcessRecord.qprdesc is '��������';
comment on column IG.QuartzProcessRecord.qpropentime is '����ʱ��';
comment on column IG.QuartzProcessRecord.qprclosetime is '�ر�ʱ��';
comment on column IG.QuartzProcessRecord.qprplantime is '�ƻ�ִ��ʱ��';
comment on column IG.QuartzProcessRecord.qprduration is '�ƻ�ִ������';
comment on column IG.QuartzProcessRecord.qprurgency is '�����̶�';
comment on column IG.QuartzProcessRecord.qprimpact is 'Ӱ��̶�';
comment on column IG.QuartzProcessRecord.qprassetid is '����ʲ�ID';
comment on column IG.QuartzProcessRecord.qprassetname is '����ʲ�����';
comment on column IG.QuartzProcessRecord.qprassetcategory is '����ʲ�����';
comment on column IG.QuartzProcessRecord.qprbusiness is '���ҵ��';
comment on column IG.QuartzProcessRecord.qprimplplan is 'ִ�мƻ�';
comment on column IG.QuartzProcessRecord.qprbackplan is '�ָ��ƻ�';
comment on column IG.QuartzProcessRecord.qprvfyplan is '��֤�ƻ�';
comment on column IG.QuartzProcessRecord.qpid is '�����ĿID';
comment on column IG.QuartzProcessRecord.qpcode is '�����Ŀ���';
comment on column IG.QuartzProcessRecord.qpname is '�����Ŀ����';
comment on column IG.QuartzProcessRecord.qprinfo is '��������ϵ��ʽ';
comment on column IG.QuartzProcessRecord.qprcorid is '�������ID';
comment on column IG.QuartzProcessRecord.qprcortype is '�����������';
comment on column IG.QuartzProcessRecord.qprcortitle is '������̱���';
comment on column IG.QuartzProcessRecord.qpruserid is '������ID';
comment on column IG.QuartzProcessRecord.qprusername is '����������';
comment on column IG.QuartzProcessRecord.qprroleid is '�����߽�ɫID';
comment on column IG.QuartzProcessRecord.qprrolename is '�����߽�ɫ����';
comment on column IG.QuartzProcessRecord.qprpdid is '��������ID';
comment on column IG.QuartzProcessRecord.qprpdname is '������������';
comment on column IG.QuartzProcessRecord.qprorgid is '�������������������';
comment on column IG.QuartzProcessRecord.qprorgname is '������������������';
comment on column IG.QuartzProcessRecord.fingerprint is 'ʱ���';
comment on column IG.QuartzProcessRecord.qprattkey is '����KEY';

--QuartzProcessParticipant
comment on table IG.QuartzProcessParticipant is '��ʱ���̲�������Ϣ��';
comment on column IG.QuartzProcessParticipant.qppid is '��������';
comment on column IG.QuartzProcessParticipant.qprid is '��ʱ����ID';
comment on column IG.QuartzProcessParticipant.qpproleid is '��ɫID';
comment on column IG.QuartzProcessParticipant.qpprolename is '��ɫ����';
comment on column IG.QuartzProcessParticipant.qppuserid is '�û�ID';
comment on column IG.QuartzProcessParticipant.qppusername is '�û�����';
comment on column IG.QuartzProcessParticipant.qpporgid is '�û��������������';
comment on column IG.QuartzProcessParticipant.qpporgname is '�û�������������';
comment on column IG.QuartzProcessParticipant.qpptype is '��������';
comment on column IG.QuartzProcessParticipant.qppsubstatus is '��״̬';
comment on column IG.QuartzProcessParticipant.qppuserinfo is '�û���Ϣ';
comment on column IG.QuartzProcessParticipant.qppcomment is '��������';
comment on column IG.QuartzProcessParticipant.qppstatus is '����״̬';
comment on column IG.QuartzProcessParticipant.qppattkey is '����KEY';
comment on column IG.QuartzProcessParticipant.qppinittime is 'ָ��ʱ��';
comment on column IG.QuartzProcessParticipant.qppproctime is '�������ʱ��';
comment on column IG.QuartzProcessParticipant.fingerprint is 'ʱ���';

--QuartzProcessInfo
comment on table IG.QuartzProcessInfo is '��ʱ���̱���Ϣ��';
comment on column IG.QuartzProcessInfo.qpiid is '��������';
comment on column IG.QuartzProcessInfo.qprid is '��ʱ����ID';
comment on column IG.QuartzProcessInfo.qpivarname is '����ʶ';
comment on column IG.QuartzProcessInfo.qpivarlabel is '����ʾ����';
comment on column IG.QuartzProcessInfo.qpivartype is '������';
comment on column IG.QuartzProcessInfo.qpivarvalue is '��ֵ';
comment on column IG.QuartzProcessInfo.qpiattkey is '����KEY';
comment on column IG.QuartzProcessInfo.fingerprint is 'ʱ���';
comment on column IG.QuartzProcessInfo.qpidid is '������ID';

--Notification
comment on table IG.Notification is 'ϵͳ���ɣ�������';

--RiskAudit
comment on table IG.RiskAudit is '������Ʊ�';
comment on column IG.RiskAudit.raid is '���ID';
comment on column IG.RiskAudit.raversion is '��ư汾';
comment on column IG.RiskAudit.radate is '��������';
comment on column IG.RiskAudit.rauserid is '������ID';
comment on column IG.RiskAudit.rausername is '����������';
comment on column IG.RiskAudit.racode is '�汾���';
comment on column IG.RiskAudit.radesc is '����';
comment on column IG.RiskAudit.rastatus is '״̬';
comment on column IG.RiskAudit.fingerprint is 'ʱ���';

--RiskAuditDef
comment on table IG.RiskAuditDef is '�����������Ϣ��';
comment on column IG.RiskAuditDef.radid is '�����ID';
comment on column IG.RiskAuditDef.raid is '���ID';
comment on column IG.RiskAuditDef.raversion is '��ư汾';
comment on column IG.RiskAuditDef.radname is '���������';
comment on column IG.RiskAuditDef.radcode is '�����';
comment on column IG.RiskAuditDef.radlevel is '����';
comment on column IG.RiskAuditDef.radparcode is '�ϼ������';
comment on column IG.RiskAuditDef.raddesc is '����';
comment on column IG.RiskAuditDef.radrisklevel is '���ճ̶�';
comment on column IG.RiskAuditDef.raduserid is '������ID';
comment on column IG.RiskAuditDef.radusername is '����������';
comment on column IG.RiskAuditDef.radorg is '���β�������';
comment on column IG.RiskAuditDef.radorgcoding is '���β��Ų����';
comment on column IG.RiskAuditDef.radstatus is '״̬';
comment on column IG.RiskAuditDef.radmode is '�����ֶ�';
comment on column IG.RiskAuditDef.radtype is '��������';
comment on column IG.RiskAuditDef.radfrequency is '����Ƶ��';
comment on column IG.RiskAuditDef.fingerprint is 'ʱ���';

--RiskAuditIns
comment on table IG.RiskAuditIns is '�������ʵ����';
comment on column IG.RiskAuditIns.raiid is 'ʵ��ID';
comment on column IG.RiskAuditIns.raid is '���ID';
comment on column IG.RiskAuditIns.raversion is '��ư汾';
comment on column IG.RiskAuditIns.raicode is '��Ʊ��';
comment on column IG.RiskAuditIns.raistart is '��������';
comment on column IG.RiskAuditIns.raiend is '��������';
comment on column IG.RiskAuditIns.raidesc is '����';
comment on column IG.RiskAuditIns.raistatus is '״̬';
comment on column IG.RiskAuditIns.fingerprint is 'ʱ���';

--RiskAuditResult
comment on table IG.RiskAuditResult is '�������������';
comment on column IG.RiskAuditResult.rarid is '����ID';
comment on column IG.RiskAuditResult.raiid is '���ʵ��ID';
comment on column IG.RiskAuditResult.radid is '�����ID';
comment on column IG.RiskAuditResult.rardate is '��������';
comment on column IG.RiskAuditResult.raruserid is '�����û�ID';
comment on column IG.RiskAuditResult.rarusername is '�����û�����';
comment on column IG.RiskAuditResult.rarplanscore is '�����ƶȽ�������';
comment on column IG.RiskAuditResult.rarplandesc is '�����ƶȽ�������';
comment on column IG.RiskAuditResult.rarexecscore is '�����ƶ�ִ������';
comment on column IG.RiskAuditResult.rarexecdesc is '�����ƶ�ִ������';
comment on column IG.RiskAuditResult.raroverallscore is '������������';
comment on column IG.RiskAuditResult.raroveralldesc is '������������';
comment on column IG.RiskAuditResult.rarcomment is '�������';
comment on column IG.RiskAuditResult.fingerprint is 'ʱ���';
comment on column IG.RiskAuditResult.radcode is '���������';

--RiskCheck
comment on table IG.RiskCheck is '���ռ���';
comment on column IG.RiskCheck.rcid is '���ID';
comment on column IG.RiskCheck.rcname is '�������';
comment on column IG.RiskCheck.rcdesc is '����';
comment on column IG.RiskCheck.rctype is '��Ҫ�̶�';
comment on column IG.RiskCheck.rcstatus is '״̬';
comment on column IG.RiskCheck.rcstartdate is '��ʼ����';
comment on column IG.RiskCheck.rcenddate is '��������';
comment on column IG.RiskCheck.rcfrequency is 'Ƶ��';
comment on column IG.RiskCheck.rccron is '����ִ�б��ʽ';
comment on column IG.RiskCheck.rcuserid is '������ID';
comment on column IG.RiskCheck.rcusername is '����������';
comment on column IG.RiskCheck.rcroleid is '�������ɫID';
comment on column IG.RiskCheck.rcrolename is '�������ɫ����';
comment on column IG.RiskCheck.rcasset is '����ʲ�ID';
comment on column IG.RiskCheck.rcassetname is '����ʲ�����';
comment on column IG.RiskCheck.rcattch is '����KEY';
comment on column IG.RiskCheck.rcoption is 'ѡ��';
comment on column IG.RiskCheck.fingerprint is 'ʱ���';

--RiskCheckResult
comment on table IG.RiskCheckResult is '���ռ������';
comment on column IG.RiskCheckResult.rcrid is '���ID';
comment on column IG.RiskCheckResult.rcid is '���ID';
comment on column IG.RiskCheckResult.rcrplandate is '�ƻ��������';
comment on column IG.RiskCheckResult.rcrrealtime is 'ʵ�ʼ��ʱ��';
comment on column IG.RiskCheckResult.rcruserid is '����ύ��ID';
comment on column IG.RiskCheckResult.rcrusername is '����ύ������';
comment on column IG.RiskCheckResult.rcrresult is '�����';
comment on column IG.RiskCheckResult.rcrcomment is '˵��';
comment on column IG.RiskCheckResult.rcrattch is '����KEY';
comment on column IG.RiskCheckResult.fingerprint is 'ʱ���';
comment on column IG.RiskCheckResult.rctype is '��Ҫ�̶�';

--AuditCheckRelation
comment on table IG.AuditCheckRelation is '���ռ���������ƹ�ϵ��';
comment on column IG.AuditCheckRelation.acrid is '��������';
comment on column IG.AuditCheckRelation.rcid is '���ID';
comment on column IG.AuditCheckRelation.radid is '�����ID';
comment on column IG.AuditCheckRelation.radcode is '���������';
comment on column IG.AuditCheckRelation.fingerprint is 'ʱ���';

--DUTYAUDITDEF
comment on table IG.DUTYAUDITDEF is 'ֵ��������';
comment on column IG.DUTYAUDITDEF.DADID is '�����ID';
comment on column IG.DUTYAUDITDEF.DADCATEGORY is 'ֵ������';
comment on column IG.DUTYAUDITDEF.DADTYPE is '����';
comment on column IG.DUTYAUDITDEF.DADNAME is '�������';
comment on column IG.DUTYAUDITDEF.DADLIMTIME is '�ʱ������';
comment on column IG.DUTYAUDITDEF.DADCONTENT is '�������';
comment on column IG.DUTYAUDITDEF.DADINFO is '˵��';
comment on column IG.DUTYAUDITDEF.DADSTATUS is '״̬';
comment on column IG.DUTYAUDITDEF.DADUSERID is '������ID';
comment on column IG.DUTYAUDITDEF.DADUSERNAME is '����������';
comment on column IG.DUTYAUDITDEF.DADUPDTIME is '����ʱ��';
comment on column IG.DUTYAUDITDEF.DADORDERBY is '�����ʶ';
comment on column IG.DUTYAUDITDEF.PERIODTYPE is '��������';
comment on column IG.DUTYAUDITDEF.PERIODVALUE is '����ʱ��';
comment on column IG.DUTYAUDITDEF.FINGERPRINT is 'ʱ���';

--DUTYAUDITTIME
comment on table IG.DUTYAUDITTIME is 'ֵ��������ʱ���';
comment on column IG.DUTYAUDITTIME.DATID is '��������';
comment on column IG.DUTYAUDITTIME.DADID is '�����ID';
comment on column IG.DUTYAUDITTIME.DATTIME is '�����ʱ��';
comment on column IG.DUTYAUDITTIME.DATLIMTIME is '����ʱ��';
comment on column IG.DUTYAUDITTIME.FINGERPRINT is 'ʱ���';

--DUTYPLAN
comment on table IG.DUTYPLAN is 'ֵ��ƻ���';
comment on column IG.DUTYPLAN.DPID is 'ֵ��ƻ�ID';
comment on column IG.DUTYPLAN.DADCATEGORY is 'ֵ������';
comment on column IG.DUTYPLAN.DPTIME is 'ֵ������';
comment on column IG.DUTYPLAN.DPTYPE is 'ֵ������';
comment on column IG.DUTYPLAN.DPSTATUS is '״̬';
comment on column IG.DUTYPLAN.DPQUESTION is '��������';
comment on column IG.DUTYPLAN.DPINFO is '�ܽ�';
comment on column IG.DUTYPLAN.DPUSERID is '������ID';
comment on column IG.DUTYPLAN.DPUSERNAME is '����������';
comment on column IG.DUTYPLAN.DPCRETIME is '�Ǽ�ʱ��';
comment on column IG.DUTYPLAN.DPUPDTIME is '����ʱ��';
comment on column IG.DUTYPLAN.DPFINTIME is '����ʱ��';
comment on column IG.DUTYPLAN.DPREMARKS is '��ע';
comment on column IG.DUTYPLAN.FINGERPRINT is 'ʱ���';

--DUTYPERSON
comment on table IG.DUTYPERSON is 'ֵ���˱�';
comment on column IG.DUTYPERSON.DPERID is '��������';
comment on column IG.DUTYPERSON.DPID is 'ֵ��ƻ�ID';
comment on column IG.DUTYPERSON.DPERTIME is 'ֵ������';
comment on column IG.DUTYPERSON.DPTYPE is 'ֵ������';
comment on column IG.DUTYPERSON.DPERUSERID is 'ֵ����ID';
comment on column IG.DUTYPERSON.DPERUSERNAME is 'ֵ��������';
comment on column IG.DUTYPERSON.FINGERPRINT is '��¼ʱ���';

--DUTYRESULT
comment on table IG.DUTYRESULT is 'ֵ��������';
comment on column IG.DUTYRESULT.DRID is '���ID';
comment on column IG.DUTYRESULT.DPID is 'ֵ��ƻ�ID';
comment on column IG.DUTYRESULT.DADID is '�����ID';
comment on column IG.DUTYRESULT.DADCATEGORY is 'ֵ������';
comment on column IG.DUTYRESULT.DADTYPE is '������';
comment on column IG.DUTYRESULT.DADNAME is '�������';
comment on column IG.DUTYRESULT.DPTIME is 'ֵ������';
comment on column IG.DUTYRESULT.DPTYPE is 'ֵ������';
comment on column IG.DUTYRESULT.DATTIME is '���ʱ��';
comment on column IG.DUTYRESULT.DATLIMTIME is '�ʱ������';
comment on column IG.DUTYRESULT.DADCONTENT is '�������';
comment on column IG.DUTYRESULT.DRCONTENT is '�����';
comment on column IG.DUTYRESULT.DRFILLTIME is '�ʱ�䣨Сʱ�֣�';
comment on column IG.DUTYRESULT.DRRESULT is '���˵��';
comment on column IG.DUTYRESULT.DRUSERID is '���ID';
comment on column IG.DUTYRESULT.DRUSERNAME is '�������';
comment on column IG.DUTYRESULT.DRCRETIME is '�ʱ��';
comment on column IG.DUTYRESULT.drlimdtime is '���/ʱ����';
comment on column IG.DUTYRESULT.FINGERPRINT is 'ʱ���';

--IG512
comment on table IG.IG512 is '���̹�����ϵ��';
comment on column IG.IG512.prrid is '��������';
comment on column IG.IG512.parprid is '����ID��������';
comment on column IG.IG512.cldprid is '����ID��������';
comment on column IG.IG512.prrinstime is '����ʱ��';
comment on column IG.IG512.fingerprint is 'ʱ���';

--ReportFileDefinition
comment on table IG.ReportFileDefinition is '�������';
comment on column IG.ReportFileDefinition.rfdid is '����ID';
comment on column IG.ReportFileDefinition.rfdtitle is '��������';
comment on column IG.ReportFileDefinition.rfdtype is '�������';
comment on column IG.ReportFileDefinition.rfddesc is '����˵��';
comment on column IG.ReportFileDefinition.rfdfilename is '�����ļ���';
comment on column IG.ReportFileDefinition.rfduserid is '�Ǽ���ID';
comment on column IG.ReportFileDefinition.rfdusername is '�Ǽ�������';
comment on column IG.ReportFileDefinition.rfdinstime is '�Ǽ�ʱ��';
comment on column IG.ReportFileDefinition.rfdversion is '��ǰ�汾';
comment on column IG.ReportFileDefinition.rfdnewversion is '���°汾';
comment on column IG.ReportFileDefinition.rfdpictype is '������ʽ';
comment on column IG.ReportFileDefinition.fingerprint is 'ʱ���';
comment on column IG.ReportFileDefinition.rfdparameters is '�������';
comment on column IG.ReportFileDefinition.isflag is '�Ƿ�Ϊ���Ʊ���0���ƣ�1���棩';

--ReportFileVersion
comment on table IG.ReportFileVersion is '����汾��';
comment on column IG.ReportFileVersion.rfvid is '��������';
comment on column IG.ReportFileVersion.rfdid is '����ID';
comment on column IG.ReportFileVersion.rfvversion is '�汾';
comment on column IG.ReportFileVersion.rfvinstime is '����ʱ��';
comment on column IG.ReportFileVersion.fingerprint is 'ʱ���';

--IG224
comment on table IG.IG224 is '����״̬��־��';
comment on column IG.IG224.rslid is '��������';
comment on column IG.IG224.prid is '����ID';
comment on column IG.IG224.prpdid is '��������ID';
comment on column IG.IG224.prtype is '����ģ������';
comment on column IG.IG224.prstatus is '����״̬';
comment on column IG.IG224.rslopentime is '��ʼʱ��';
comment on column IG.IG224.rslclosetime is '����ʱ��';
comment on column IG.IG224.rslExpect is '�Ƿ�ʱ';
comment on column IG.IG224.fingerprint is 'ʱ���';

--IG899
comment on table IG.IG899 is '����˽�б���';
comment on column IG.IG899.PPIID is '��������';
comment on column IG.IG899.PIDID is '������ID';
comment on column IG.IG899.PIID is '���̱�ID';
comment on column IG.IG899.ROLEID is '�����ɫID';
comment on column IG.IG899.USERID is '������ID';
comment on column IG.IG899.PPIVALUE is '��ֵ';
comment on column IG.IG899.PPIATTKEY is '����KEY';
comment on column IG.IG899.FINGERPRINT is 'ʱ���';

--IG463
comment on table IG.IG463 is '���̴�����Ȩ������';
comment on column IG.IG463.ppwid is '��������';
comment on column IG.IG463.ppwprid is '����ID';
comment on column IG.IG463.ppwprtype is '����ģ������';
comment on column IG.IG463.ppwprserialnum is '���̹�����';
comment on column IG.IG463.ppwprtitle is '���̱���';
comment on column IG.IG463.ppwauthorizeuserid is '��Ȩ��ID';
comment on column IG.IG463.ppwproxyuserid is '������ID';
comment on column IG.IG463.ppwproxyusername is '����������';
comment on column IG.IG463.ppwoptiontime is '�����˴���ʱ��';
comment on column IG.IG463.ppwcloseflag is '�Ƿ�ر�';
comment on column IG.IG463.fingerPrint is 'ʱ���';

--IG213
comment on table IG.IG213 is '�Զ������̽�ɫ��Χ��';
comment on column IG.IG213.prtdid is '��������';
comment on column IG.IG213.pdid is '��������ID';
comment on column IG.IG213.roletype is '��ɫ����';
comment on column IG.IG213.fingerprint is 'ʱ���';

--IG243
comment on table IG.IG243 is '�Զ������̱��ⶨ���';
comment on column IG.IG243.ptdid is '��������';
comment on column IG.IG243.pdid is '��������ID';
comment on column IG.IG243.ptitlename is '�������ʾ����';
comment on column IG.IG243.ptitleaccess is '������Ƿ�ɼ�';
comment on column IG.IG243.pdescname is '��������ʾ����';
comment on column IG.IG243.pdescaccess is '�������Ƿ�ɼ�';
comment on column IG.IG243.fingerprint is 'ʱ���';

--IG298
comment on table IG.IG298 is '�Զ�������״̬�ɷ��ɽ�ɫ�����';
comment on column IG.IG298.psrdid is '��������';
comment on column IG.IG298.psdid is '����״̬ID';
comment on column IG.IG298.roleid is '��ɫID';
comment on column IG.IG298.fingerprint is 'ʱ���';

--IG156
comment on table IG.IG156 is '�Զ�������״̬��ť�¼������';
comment on column IG.IG156.PSEID is '��������';
comment on column IG.IG156.PDID is '��������ID'; 
comment on column IG.IG156.PSDID is '����״̬ID';
comment on column IG.IG156.PSEBUTTONID is '��ťID';
comment on column IG.IG156.PSEACTIONID is '����BL��ʶ';
comment on column IG.IG156.PSEORDER is 'ִ��˳��'; 
comment on column IG.IG156.PSEDEC is '����';
comment on column IG.IG156.FINGERPRINT is 'ʱ���';
comment on column IG.IG156.PSBDNAME is '��ť��Ȩʱ�ı���';

--IG212
comment on table IG.IG212 is '�Զ�������֪ͨ���Զ����';
comment on column IG.IG212.PSDID is '����״̬ID';
comment on column IG.IG212.PSDCONFIRM is '�Ƿ�ȷ��״̬';
comment on column IG.IG212.SMS is '�Ƿ��Ͷ���';
comment on column IG.IG212.EMAIL is '�Ƿ����ʼ�';
comment on column IG.IG212.NOTIFYD is '�ٴ�����ʱ�䣨�죩';
comment on column IG.IG212.NOTIFYH is '�ٴ�����ʱ�䣨Сʱ��';
comment on column IG.IG212.NOTIFYM is '�ٴ�����ʱ�䣨�֣�';
comment on column IG.IG212.REPORTD is '�ϱ�ʱ�䣨�죩';
comment on column IG.IG212.REPORTH is '�ϱ�ʱ�䣨Сʱ��';
comment on column IG.IG212.REPORTM is '�ϱ�ʱ�䣨�֣�';
comment on column IG.IG212.ROLEMANAGER is '֪ͨ������';
comment on column IG.IG212.FINGERPRINT is 'ʱ���';

--IG237
comment on table IG.IG237 is '�Զ������̲���֪ͨ�˶����';
comment on column IG.IG237.PSDID is '����״̬ID';
comment on column IG.IG237.PSDCONFIRM is '�Ƿ�ȷ��״̬';
comment on column IG.IG237.USERID is '�û�ID';
comment on column IG.IG237.ROLEID is '��ɫID';
comment on column IG.IG237.FINGERPRINT is 'ʱ���';

--IG202
comment on table IG.IG202 is '����ͨ�ñ������';
comment on column IG.IG202.PIDID is '������ID'; 
comment on column IG.IG202.PIDNAME is '����ʶ';
comment on column IG.IG202.PIDLABEL is '����ʾ����'; 
comment on column IG.IG202.PIDDESC is '������';
comment on column IG.IG202.PIDTYPE is '������'; 
comment on column IG.IG202.PIDOPTION is '��ȡֵ��Χ';
comment on column IG.IG202.PIDDEFAULT is '��Ĭ��ֵ'; 
comment on column IG.IG202.PIDREQUIRED is '�Ƿ����'; 
comment on column IG.IG202.PIDSORTID is '�����ʶ'; 
comment on column IG.IG202.CCID is '�������ݷ���ID';
comment on column IG.IG202.PIDMODE is '��ģʽ';
comment on column IG.IG202.PRIVATESCOPE is '˽�б�Ȩ�޷�Χ';
comment on column IG.IG202.ROWWIDTH is '������ʾģʽ';
comment on column IG.IG202.FINGERPRINT is 'ʱ���';

--CUSTOMREPORT
comment on table IG.CUSTOMREPORT is '���Ʊ�����Ϣ��';
comment on column IG.CUSTOMREPORT.CRID is '��������'; 
comment on column IG.CUSTOMREPORT.USERID is '�����û�ID';
comment on column IG.CUSTOMREPORT.RFDID is '����ID';
comment on column IG.CUSTOMREPORT.ORDERNUM is '�����ʶ';
comment on column IG.CUSTOMREPORT.FINGERPRINT is 'ʱ���'; 

--ROLEREPORT
comment on table IG.ROLEREPORT is '������Ȩ��Ϣ��';
comment on column IG.ROLEREPORT.RRID is '��������'; 
comment on column IG.ROLEREPORT.ROLEID is '��ɫID';  
comment on column IG.ROLEREPORT.RFDID is '����ID'; 
comment on column IG.ROLEREPORT.RRPERM is 'Ȩ�ޣ�������'; 
comment on column IG.ROLEREPORT.RRDESC is '˵����������'; 
comment on column IG.ROLEREPORT.FINGERPRINT is 'ʱ���';

--SEQUENCE_GENERATOR_TABLE
comment on table IG.SEQUENCE_GENERATOR_TABLE is '�������б�';
comment on column IG.SEQUENCE_GENERATOR_TABLE.SEQUENCE_NAME is '���б�ʶ';
comment on column IG.SEQUENCE_GENERATOR_TABLE.SEQUENCE_VALUE is '����ֵ';

--HOTLINK
comment on table IG.HOTLINK is '��������';
comment on column IG.HOTLINK.hid is '��������';
comment on column IG.HOTLINK.userid is '�û�ID';
comment on column IG.HOTLINK.hname is '������ʾ����';
comment on column IG.HOTLINK.hlink is '����URL';
comment on column IG.HOTLINK.horder is '��ʾ˳��';
comment on column IG.HOTLINK.fingerprint is 'ʱ���';

--IG731
comment on table IG.IG731 is '��������ʲ�������';
comment on column IG.IG731.pieid is '��������';
comment on column IG.IG731.prid is '����ID';
comment on column IG.IG731.piid is '���̱�ID';
comment on column IG.IG731.eiid is '�ʲ�ID';
comment on column IG.IG731.fingerprint is 'ʱ���';

--QuartzProcessInfoEntity
comment on table IG.QuartzProcessInfoEntity is '��ʱ��������ʲ�������';
comment on column IG.QuartzProcessInfoEntity.qpieid is '��������';
comment on column IG.QuartzProcessInfoEntity.qprid is '����ID';
comment on column IG.QuartzProcessInfoEntity.qpiid is '���̱�ID';
comment on column IG.QuartzProcessInfoEntity.qeiid is '�ʲ�ID';
comment on column IG.QuartzProcessInfoEntity.fingerprint is 'ʱ���';

--QuartzJobDetails
comment on table IG.QuartzJobDetails is '�ճ���ά�ƻ���Ϣ��';
comment on column IG.QuartzJobDetails.qjdid is '��������';
comment on column IG.QuartzJobDetails.qjid is '��ʱ����ID';
comment on column IG.QuartzJobDetails.qjdtriname is '����������';
comment on column IG.QuartzJobDetails.qjdtrigrpname is '����������������';
comment on column IG.QuartzJobDetails.qjdtime is 'ִ��ʱ��';
comment on column IG.QuartzJobDetails.qjdweek is '���ڼ�';
comment on column IG.QuartzJobDetails.qjdtype is 'ִ��״̬';
comment on column IG.QuartzJobDetails.FINGERPRINT is 'ʱ���';

--IG433
comment on table IG.IG433 is '����������Ϣ��';
comment on column IG.IG433.paid is '��������';
comment on column IG.IG433.paprid is '����ID';
comment on column IG.IG433.pauserid is '������ID';
comment on column IG.IG433.paprname is '���̱���';
comment on column IG.IG433.paassessmentdes is '��������';
comment on column IG.IG433.paassessmentdate is '����ʱ��';
comment on column IG.IG433.paeventtypecode is '�¼����';
comment on column IG.IG433.PAATTKEY is '����KEY';
comment on column IG.IG433.PASTATUS is '״̬';
comment on column IG.IG433.fingerprint is 'ʱ���';

--IG229
comment on table IG.IG229 is '����Ӱ��ҵ��ϵͳ��Ϣ��';
comment on column IG.IG229.padid is '��������';
comment on column IG.IG229.padprid is '����ID';
comment on column IG.IG229.padaffectsystem is 'Ӱ��ҵ��ϵͳ';
comment on column IG.IG229.padstart is 'Ӱ�쿪ʼʱ��';
comment on column IG.IG229.padend is 'Ӱ�����ʱ��';
comment on column IG.IG229.fingerprint is 'ʱ���';

--IG105
comment on table IG.IG105 is '���̲��Զ�����Ϣ';
comment on column IG.IG105.pdid is '��������ID';
comment on column IG.IG105.prstatus is '����״̬';
comment on column IG.IG105.prurgency is '�����̶�';
comment on column IG.IG105.psdversion is '���԰汾';
comment on column IG.IG105.expecttime is '�������ʱ��';
comment on column IG.IG105.createtime is '����ʱ��';
comment on column IG.IG105.fingerprint is 'ʱ���';

--PRIORITY
comment on table IG.PRIORITY is '�������ȼ������';
comment on column IG.PRIORITY.uvalue is '�����̶�';
comment on column IG.PRIORITY.ivalue is 'Ӱ��̶�';
comment on column IG.PRIORITY.pprtype is '��������ID';
comment on column IG.PRIORITY.pvalue is '���ȼ�';
comment on column IG.PRIORITY.FINGERPRINT is 'ʱ���';

--KNOWLEDGE
comment on table IG.KNOWLEDGE is '֪ʶ��';
comment on column IG.KNOWLEDGE.KNID is '֪ʶID';
comment on column IG.KNOWLEDGE.KNVERSION is '֪ʶ�汾';
comment on column IG.KNOWLEDGE.KNSERIAL is '���';
comment on column IG.KNOWLEDGE.KNDEPARTMENT is '����';
comment on column IG.KNOWLEDGE.KNAPPROVER is '�鵵��ID';
comment on column IG.KNOWLEDGE.KNAPPROVERNAME is '�鵵������';
comment on column IG.KNOWLEDGE.KNAPPROVETIME is '�鵵ʱ��';
comment on column IG.KNOWLEDGE.KNCLASS is '����';
comment on column IG.KNOWLEDGE.KNCLASSNAME is '�������';
comment on column IG.KNOWLEDGE.KNAREA is 'ҵ�������ʶ';
comment on column IG.KNOWLEDGE.KNAREANAME is 'ҵ����������';
comment on column IG.KNOWLEDGE.KNTELAREA is '���������ʶ';
comment on column IG.KNOWLEDGE.KNTELAREANAME is '������������';
comment on column IG.KNOWLEDGE.KNKEY is '�ؼ���';
comment on column IG.KNOWLEDGE.KNORIGIN is '��Դ��ʶ';
comment on column IG.KNOWLEDGE.KNORIGINNAME is '��Դ����';
comment on column IG.KNOWLEDGE.KNPROFFER is '������ID';
comment on column IG.KNOWLEDGE.KNPROFFERNAME is '����������';
comment on column IG.KNOWLEDGE.KNPROFFERTIME is '����ʱ��';
comment on column IG.KNOWLEDGE.KNTITLE is '����';
comment on column IG.KNOWLEDGE.KNDES is '��������';
comment on column IG.KNOWLEDGE.KNFAULTCAUSE is '����ԭ���ܽ�';
comment on column IG.KNOWLEDGE.KNSOLVEWAY is '����취';
comment on column IG.KNOWLEDGE.KNSTATUS is '״̬';
comment on column IG.KNOWLEDGE.KNREJECT is '����ԭ��';
comment on column IG.KNOWLEDGE.KNATTKEY is '����KEY';
comment on column IG.KNOWLEDGE.FINGERPRINT is 'ʱ���';
comment on column IG.KNOWLEDGE.KNAPPROVEROLE is '������ɫID';

--KNOWLEDGEAPPIMPACT
comment on table IG.KNOWLEDGEAPPIMPACT is '֪ʶ��ҵ��ϵͳ������';
comment on column IG.KNOWLEDGEAPPIMPACT.KAIID is '��������';
comment on column IG.KNOWLEDGEAPPIMPACT.KNID is '֪ʶID';
comment on column IG.KNOWLEDGEAPPIMPACT.KAICODE is 'ҵ��ϵͳ��ʶ';
comment on column IG.KNOWLEDGEAPPIMPACT.FINGERPRINT is 'ʱ���';
comment on column IG.KNOWLEDGEAPPIMPACT.KNVERSION is '֪ʶ�汾';

--KNOWLEDGEGRADE
comment on table IG.KNOWLEDGEGRADE is '֪ʶ���ֱ�';
comment on column IG.KNOWLEDGEGRADE.KGID is '��������';
comment on column IG.KNOWLEDGEGRADE.KNID is '֪ʶID';
comment on column IG.KNOWLEDGEGRADE.KGGRADE is '֪ʶ����';
comment on column IG.KNOWLEDGEGRADE.KGAPPRAISE is '֪ʶ����';
comment on column IG.KNOWLEDGEGRADE.KGUSERID is '������ID';
comment on column IG.KNOWLEDGEGRADE.KGTIME is '����ʱ��';
comment on column IG.KNOWLEDGEGRADE.FINGERPRINT is 'ʱ���';

--KNOWLEDGEPROCESS
comment on table IG.KNOWLEDGEPROCESS is '֪ʶ�����̹�����';
comment on column IG.KNOWLEDGEPROCESS.KPID is '��������';
comment on column IG.KNOWLEDGEPROCESS.KNID is '֪ʶID';
comment on column IG.KNOWLEDGEPROCESS.KNVERSION is '֪ʶ�汾';
comment on column IG.KNOWLEDGEPROCESS.PRID is '����ID';
comment on column IG.KNOWLEDGEPROCESS.SFID is '���񹤵�ID';
comment on column IG.KNOWLEDGEPROCESS.CONNECTTYPE is '��������';
comment on column IG.KNOWLEDGEPROCESS.KPEFFECT is '�Ƿ���Ч��ʶ';
comment on column IG.KNOWLEDGEPROCESS.FINGERPRINT is 'ʱ���';

--KNOWLOG
comment on table IG.KNOWLOG is '֪ʶ��־��';
comment on column IG.KNOWLOG.KLID is '��������';
comment on column IG.KNOWLOG.KLKID is '֪ʶID';
comment on column IG.KNOWLOG.KLTIME is '��¼ʱ��';
comment on column IG.KNOWLOG.KLROLEID is '��ɫID';
comment on column IG.KNOWLOG.KLROLENAME is '��ɫ����';
comment on column IG.KNOWLOG.KLUSERID is '�û�ID';
comment on column IG.KNOWLOG.KLUSERNAME is '�û�����';
comment on column IG.KNOWLOG.KLDESC is '����';
comment on column IG.KNOWLOG.KLCOMMEND is '��ע';
comment on column IG.KNOWLOG.KLORGID is '���������';
comment on column IG.KNOWLOG.KLORGNAME is '��������';
comment on column IG.KNOWLOG.FINGERPRINT is 'ʱ���';

--DELAY
comment on table IG.DELAY is '��ʱ������Ϣ��';
comment on column IG.DELAY.ID is '��������';
comment on column IG.DELAY.DATETIME is '����';
comment on column IG.DELAY.ORGNAME is '���뵥λ';
comment on column IG.DELAY.TITLE is '�������';
comment on column IG.DELAY.HZNAME is '�г�����';
comment on column IG.DELAY.HZTEL is '�г��绰';
comment on column IG.DELAY.JLNAME is '��������';
comment on column IG.DELAY.JLTEL is '����绰';
comment on column IG.DELAY.REMARK is '��ע';
comment on column IG.DELAY.STARTTIME is '��ʼʱ��';
comment on column IG.DELAY.ENDTIME is '����ʱ��';
comment on column IG.DELAY.OPERATER is '������';
comment on column IG.DELAY.FINGERPRINT is 'ʱ���';
comment on column IG.DELAY.UNLOCKTIME is '����ʱ��';

--ONDUTYPERSONRECORD
comment on table IG.ONDUTYPERSONRECORD is '�ճ�ά���ǼǱ�';
comment on column IG.ONDUTYPERSONRECORD.ODPRID is '��������';
comment on column IG.ONDUTYPERSONRECORD.ODPRGUEST is '������Ա';
comment on column IG.ONDUTYPERSONRECORD.ODPRGUESTORG is '������λ';
comment on column IG.ONDUTYPERSONRECORD.ODPRGUESTIDNUM is '���֤��';
comment on column IG.ONDUTYPERSONRECORD.ODPRAREA is '��������';
comment on column IG.ONDUTYPERSONRECORD.ODPRCTIME is '����ʱ��';
comment on column IG.ONDUTYPERSONRECORD.ODPRLTIME is '�뿪ʱ��';
comment on column IG.ONDUTYPERSONRECORD.ODPROPTER is '������';
comment on column IG.ONDUTYPERSONRECORD.ODPRACTER is '��׼��';
comment on column IG.ONDUTYPERSONRECORD.ODPRUSERNAME is '��¼��';
comment on column IG.ONDUTYPERSONRECORD.ODPRTARGET is '����Ŀ��';
comment on column IG.ONDUTYPERSONRECORD.ODPRRECORD is '������¼';
comment on column IG.ONDUTYPERSONRECORD.ODPRINSERTTIME is '��¼ʱ��';
comment on column IG.ONDUTYPERSONRECORD.ODPRMODTIME is '�༭ʱ��';
comment on column IG.ONDUTYPERSONRECORD.FINGERPRINT is 'ʱ���';

--EIBELONGRELATION
comment on table IG.EIBELONGRELATION is '����������ϵ��';
comment on column IG.EIBELONGRELATION.BRID is '�߼�����';
comment on column IG.EIBELONGRELATION.BRPAREIID is 'Դ�ʲ�ID';
comment on column IG.EIBELONGRELATION.BRPARVERSION is 'Դ�ʲ���汾';
comment on column IG.EIBELONGRELATION.BRPARSMALLVERSION is 'Դ�ʲ�С�汾';
comment on column IG.EIBELONGRELATION.BRCLDEIID is 'Ŀ���ʲ�ID';
comment on column IG.EIBELONGRELATION.BRCLDVERSION is 'Ŀ���ʲ���汾';
comment on column IG.EIBELONGRELATION.BRCLDSMALLVERSION is 'Ŀ���ʲ�С�汾';
comment on column IG.EIBELONGRELATION.BRTYPE is '��ϵ����(����/�߼�)';
comment on column IG.EIBELONGRELATION.BRDES is '��ϵ˵��';
comment on column IG.EIBELONGRELATION.BRCREATETIME is '����ʱ��';
comment on column IG.EIBELONGRELATION.BRRALETIONCODE is '������ϵ��';
comment on column IG.EIBELONGRELATION.BRASSETRELATION is '�ʲ���ϵ��';
comment on column IG.EIBELONGRELATION.EIROOTMARK is '�ʲ����������ڵ�ʵ���ʶ';
comment on column IG.EIBELONGRELATION.DELETEFLAG is '�߼�ɾ����ʶ';
comment on column IG.EIBELONGRELATION.FINGERPRINT is 'ʱ���';


--SOC0101 
comment on table IG.SOC0101 is '����ʲ����Ա�';
comment on column IG.SOC0101.CIID is '�ʲ�����ID';
comment on column IG.SOC0101.CID is '�ʲ�ģ������ID';
comment on column IG.SOC0101.EIID is '�ʲ�ID';
comment on column IG.SOC0101.EID is '�ʲ�ģ��ID';
comment on column IG.SOC0101.CIVALUE is '�ʲ�����ֵ';
comment on column IG.SOC0101.CIUPDTIME is '�ʲ����Ը���ʱ��';
comment on column IG.SOC0101.ESYSCODING is '�ʲ�ģ�Ͳ����';
comment on column IG.SOC0101.CIEXPIRE is '�ʲ�����ʧЧʱ��';
comment on column IG.SOC0101.CISTATUS is '�ʲ�����״̬';
comment on column IG.SOC0101.CICURVER is '�ʲ����Ե�ǰ�汾��';
comment on column IG.SOC0101.CIVERINFO is '�ʲ����԰汾��Ϣ';
comment on column IG.SOC0101.CISMALLVERSION is '�ʲ�����С�汾';
comment on column IG.SOC0101.CIVERSION is '�ʲ����Դ�汾';
comment on column IG.SOC0101.FINGERPRINT is 'ʱ���';

--SOC0102 
comment on table IG.SOC0102 is '����ʲ���';
comment on column IG.SOC0102.EIID is '�ʲ�ID';
comment on column IG.SOC0102.EID is '�ʲ�ģ��ID';
comment on column IG.SOC0102.EIDESC is '�ʲ�˵��';
comment on column IG.SOC0102.EINAME is '�ʲ�����';
comment on column IG.SOC0102.EILABEL is '�ʲ����';
comment on column IG.SOC0102.EIINSDATE is '�ʲ��Ǽ���';
comment on column IG.SOC0102.EIORGSYSCODING is '�ʲ��������������';
comment on column IG.SOC0102.ESYSCODING is '�ʲ�ģ�Ͳ����';
comment on column IG.SOC0102.EIUPDTIME is '�ʲ�����ʱ��';
comment on column IG.SOC0102.EISTATUS is '�ʲ�״̬';
comment on column IG.SOC0102.EIUSERID is '�ʲ�������';
comment on column IG.SOC0102.EIUSERNAME is '�ʲ�����������';
comment on column IG.SOC0102.EIROOTMARK is '����CI��ʶ';
comment on column IG.SOC0102.EISMALLVERSION is '�ʲ�С�汾';
comment on column IG.SOC0102.EIVERSION is '�ʲ���汾';
comment on column IG.SOC0102.FINGERPRINT is 'ʱ���';

--SOC0103 
comment on table IG.SOC0103 is '��ƶԱȽ����Ϣ��';
comment on column IG.SOC0103.AURID is '��ƶԱȽ��';
comment on column IG.SOC0103.AUTID is '�������ID';
comment on column IG.SOC0103.AUTIME is '���ʱ���';
comment on column IG.SOC0103.AUCMPTYPE is '�ԱȽ������';
comment on column IG.SOC0103.EIID is '�ʲ�ID';
comment on column IG.SOC0103.EIVERSION is '��汾';
comment on column IG.SOC0103.EISMALLVERSION is 'С�汾';
comment on column IG.SOC0103.EINAME is '�ʲ�����';
comment on column IG.SOC0103.ESYSCODING is '�ʲ������';
comment on column IG.SOC0103.EIROOTMARK is '����CI��ʶ';
comment on column IG.SOC0103.CIID is '����ID';
comment on column IG.SOC0103.CNAME is '������';
comment on column IG.SOC0103.CIVALUE is '��ǰ�汾ֵ';
comment on column IG.SOC0103.AUVALUE is '�ɼ�ֵ';
comment on column IG.SOC0103.AUFLAG is '�����ʶ';
comment on column IG.SOC0103.AURESULTDESC is '��ƽ��˵��';
comment on column IG.SOC0103.FINGERPRINT is 'ʱ���';

--SOC0104 
comment on table IG.SOC0104 is '��������';
comment on column IG.SOC0104.AUTID is '�߼�����';
comment on column IG.SOC0104.AUTDESC is '�����������';
comment on column IG.SOC0104.AUTTIME is '���ʱ���';
comment on column IG.SOC0104.AUTSTATUS is '�������״̬';
comment on column IG.SOC0104.AUTUPDTIME is '����������ʱ��';
comment on column IG.SOC0104.AUTCOMPTIME is 'AUTCOMPTIME';
comment on column IG.SOC0104.FINGERPRINT is 'ʱ���';

--SOC0105 
comment on table IG.SOC0105 is '��ƴ����������';
comment on column IG.SOC0105.AUWTID is '�߼�����';
comment on column IG.SOC0105.AUWTCREATETIME is '���񴴽�ʱ��';
comment on column IG.SOC0105.AUWTFILENAME is 'Դ�ļ���';
comment on column IG.SOC0105.AUWTTOPCI is '����CI';
comment on column IG.SOC0105.AUWTSTATUS is '״̬';
comment on column IG.SOC0105.AUWTPARSESTART is '������ʼʱ��';
comment on column IG.SOC0105.AUWTPARSEEND is '��������ʱ��';
comment on column IG.SOC0105.AUWTCISTART is 'CIʵ�����ɿ�ʼʱ��';
comment on column IG.SOC0105.AUWTCIEND is 'CIʵ�����ɽ���ʱ��';
comment on column IG.SOC0105.DELETEFLAG is 'ɾ����ʶ';
comment on column IG.SOC0105.IMPTYPEID is '�����������ID';
comment on column IG.SOC0105.FINGERPRINT is 'ʱ���';

--SOC0106 
comment on table IG.SOC0106 is '��ƴ�����������ʱ��';
comment on column IG.SOC0106.AWTID is '�߼�����';
comment on column IG.SOC0106.FILENAME is '�ļ���';
comment on column IG.SOC0106.BATNAME is 'BAT�ļ���';
comment on column IG.SOC0106.EINAME is 'ʵ������';
comment on column IG.SOC0106.AUWTID is 'ʵ��ID';
comment on column IG.SOC0106.FINGERPRINT is 'ʱ���';

--SOC0107 
comment on table IG.SOC0107 is '�ʲ�������Ϣ��';
comment on column IG.SOC0107.CIID is '�ʲ�����ID';
comment on column IG.SOC0107.CID is '�ʲ�ģ������ID';
comment on column IG.SOC0107.EIID is '�ʲ�ID';
comment on column IG.SOC0107.EID is '�ʲ�ģ��ID';
comment on column IG.SOC0107.CIVALUE is '�ʲ�����ֵ';
comment on column IG.SOC0107.CIUPDTIME is '�ʲ����Ը���ʱ��';
comment on column IG.SOC0107.ESYSCODING is '�ʲ�ģ�Ͳ����';
comment on column IG.SOC0107.CIEXPIRE is '�ʲ�����ʧЧʱ��';
comment on column IG.SOC0107.CISTATUS is '�ʲ�����״̬';
comment on column IG.SOC0107.CICURVER is '�ʲ����Ե�ǰ�汾��';
comment on column IG.SOC0107.CIVERSION is '�ʲ����԰汾��';
comment on column IG.SOC0107.CIVERINFO is '�ʲ����԰汾��Ϣ';
comment on column IG.SOC0107.FINGERPRINT is 'ʱ���';
comment on column IG.SOC0107.CISMALLVERSION is '�ʲ�����С�汾';

--SOC0108 
comment on table IG.SOC0108 is '�ʲ�������Ϣ��ʱ��';
comment on column IG.SOC0108.CIID is '�ʲ�����ID';
comment on column IG.SOC0108.CID is '�ʲ�ģ������ID';
comment on column IG.SOC0108.EIID is '�ʲ�ID';
comment on column IG.SOC0108.EID is '�ʲ�ģ��ID';
comment on column IG.SOC0108.CIVALUE is '�ʲ�����ֵ';
comment on column IG.SOC0108.CIUPDTIME is '�ʲ����Ը���ʱ��';
comment on column IG.SOC0108.ESYSCODING is '�ʲ�ģ�Ͳ����';
comment on column IG.SOC0108.CIEXPIRE is '�ʲ�����ʧЧʱ��';
comment on column IG.SOC0108.CISTATUS is '�ʲ�����״̬';
comment on column IG.SOC0108.CICURVER is '�ʲ����Ե�ǰ�汾��';
comment on column IG.SOC0108.CIVERSION is '�ʲ����԰汾��';
comment on column IG.SOC0108.CIVERINFO is '�ʲ����԰汾��Ϣ';
comment on column IG.SOC0108.FINGERPRINT is 'ʱ���';
comment on column IG.SOC0108.CISMALLVERSION is '�ʲ�����С�汾';

--SOC0109 
comment on table IG.SOC0109 is '�ʲ�ģ��������Ϣ��';
comment on column IG.SOC0109.CID is '�ʲ�ģ������ID';
comment on column IG.SOC0109.EID is '�ʲ�ģ��ID';
comment on column IG.SOC0109.CNAME is '�ʲ�ģ����������';
comment on column IG.SOC0109.CLABEL is '�ʲ�ģ�����Ա��';
comment on column IG.SOC0109.CDESC is '�ʲ�ģ������˵��';
comment on column IG.SOC0109.CUNIT is '�ʲ�ģ�����Ե�λ';
comment on column IG.SOC0109.CSTATUS is '�ʲ�ģ������״̬';
comment on column IG.SOC0109.CSEQ is '�ʲ�ģ�������Ƿ���ʾ��ʶ';
comment on column IG.SOC0109.CCATEGORY is '�ʲ�ģ����������ģ�͵�ģ�ͷ���';
comment on column IG.SOC0109.COPTION is '�ʲ�ģ������ȡֵ��ΧID';
comment on column IG.SOC0109.CATTACH is '�ʲ�ģ��������������';
comment on column IG.SOC0109.ESYSCODING is '�ʲ�ģ����������ģ�Ͳ����';
comment on column IG.SOC0109.FINGERPRINT is 'ʱ���';
comment on column IG.SOC0109.CREQUIRED is '�ʲ�ģ�����Ա�����';

--SOC0110 
comment on table IG.SOC0110 is '����������ϵ��';
comment on column IG.SOC0110.BRID is '�߼�����';
comment on column IG.SOC0110.BRPAREIID is 'Դ�ʲ�ID';
comment on column IG.SOC0110.BRPARVERSION is 'Դ�ʲ���汾';
comment on column IG.SOC0110.BRPARSMALLVERSION is 'Դ�ʲ�С�汾';
comment on column IG.SOC0110.BRCLDEIID is 'Ŀ���ʲ�ID';
comment on column IG.SOC0110.BRCLDVERSION is 'Ŀ���ʲ���汾';
comment on column IG.SOC0110.BRCLDSMALLVERSION is 'Ŀ���ʲ�С�汾';
comment on column IG.SOC0110.BRTYPE is '��ϵ����(����/�߼�)';
comment on column IG.SOC0110.BRDES is '��ϵ˵��';
comment on column IG.SOC0110.BRCREATETIME is '����ʱ��';
comment on column IG.SOC0110.BRRALETIONCODE is '������ϵ��';
comment on column IG.SOC0110.BRASSETRELATION is '�ʲ���ϵ��';
comment on column IG.SOC0110.EIROOTMARK is '�ʲ����������ڵ�ʵ���ʶ';
comment on column IG.SOC0110.DELETEFLAG is '�߼�ɾ����ʶ';
comment on column IG.SOC0110.FINGERPRINT is 'ʱ���';

--SOC0111 
comment on table IG.SOC0111 is '�ʲ������';
comment on column IG.SOC0111.EIDDID is '�߼�����';
comment on column IG.SOC0111.VERSION is '�汾��';
comment on column IG.SOC0111.NAME is '����';
comment on column IG.SOC0111.DESCRIPTION is '����';
comment on column IG.SOC0111.CREATETIME is '����ʱ��';
comment on column IG.SOC0111.UPDATETIME is '����ʱ��';
comment on column IG.SOC0111.FINGERPRINT is 'ʱ���';

--SOC0112 
comment on table IG.SOC0112 is '�ʲ�����ϸ��';
comment on column IG.SOC0112.EIDDID is '�ʲ���ID';
comment on column IG.SOC0112.EIDDVERSION is '�ʲ���汾';
comment on column IG.SOC0112.EINAME is 'ʵ������';
comment on column IG.SOC0112.EIIMPORTVERSION is '�ʲ�����汾';
comment on column IG.SOC0112.CREATETIME is '����ʱ��';
comment on column IG.SOC0112.DELETEFLAG is 'ɾ����ʶ';
comment on column IG.SOC0112.MODIFYFLAG is '�޸ı�ʶ';
comment on column IG.SOC0112.FINGERPRINT is 'ʱ���';

--SOC0113
comment on table IG.SOC0113 is '�����������';
comment on column IG.SOC0113.IMPTYPEID is '����ID';
comment on column IG.SOC0113.IMPTYPENAME is '��������';
comment on column IG.SOC0113.IMPPROGRAMME is '����Bat����';
comment on column IG.SOC0113.IMPPROGRAMMEAUDIT is '���Bat����';
comment on column IG.SOC0113.IMPPROGRAMMEUPDATE is '����Bat����';
comment on column IG.SOC0113.FINGERPRINT is 'ʱ���';
comment on column IG.SOC0113.COLLECTTYPE is '�ɼ�����';
comment on column IG.SOC0113.SHELLNAME is '��Ӧ�ɼ��ű�����';

--SOC0114 
comment on table IG.SOC0114 is 'ʵ����·ͼ��';
comment on column IG.SOC0114.DOMAINID is '��ID';
comment on column IG.SOC0114.DOMAINVERSION is 'Domain�汾';
comment on column IG.SOC0114.LINKID is '��·ID';
comment on column IG.SOC0114.LINKORDER is '��·˳��';
comment on column IG.SOC0114.EIID is 'ʵ��ID';
comment on column IG.SOC0114.EINAME is 'ʵ������';
comment on column IG.SOC0114.ESYSCODING is '�ʲ������';
comment on column IG.SOC0114.EIVERSION is '��汾';
comment on column IG.SOC0114.EISMALLVERSION is 'С�汾';
comment on column IG.SOC0114.CREATETIME is '����ʱ��';
comment on column IG.SOC0114.LINKFLAG is '��ͼ���';
comment on column IG.SOC0114.ENDFLAG is '��·������ʶ';
comment on column IG.SOC0114.FINGERPRINT is 'ʱ���';

--SOC0115 
comment on table IG.SOC0115 is '�����������';
comment on column IG.SOC0115.EITID is '�߼�����';
comment on column IG.SOC0115.EITCREATETIME is '���񴴽�ʱ��';
comment on column IG.SOC0115.EITTOPCI is '����CI';
comment on column IG.SOC0115.EITFILENAME is 'Դ�ļ���';
comment on column IG.SOC0115.EITSTATUS is '״̬';
comment on column IG.SOC0115.EITPARSESTART is '������ʼʱ��';
comment on column IG.SOC0115.EITPARSEEND is '��������ʱ��';
comment on column IG.SOC0115.EITCISTART is 'CIʵ�����ɿ�ʼʱ��';
comment on column IG.SOC0115.EITCIEND is 'CIʵ�����ɽ���ʱ��';
comment on column IG.SOC0115.EITRELATIONSTART is '��ϵ������ʼʱ��';
comment on column IG.SOC0115.EITRELATIONEND is '��ϵ��������ʱ��';
comment on column IG.SOC0115.DELETEFLAG is 'ɾ����ʶ';
comment on column IG.SOC0115.IMPTYPEID is '�����������ID';
comment on column IG.SOC0115.FINGERPRINT is 'ʱ���';

--SOC0116 
comment on table IG.SOC0116 is '������������ʱ��';
comment on column IG.SOC0116.EWTID is '�߼�����';
comment on column IG.SOC0116.FILENAME is '�ļ���';
comment on column IG.SOC0116.USERID is '�û�ID';
comment on column IG.SOC0116.EINAME is 'ʵ������';
comment on column IG.SOC0116.EITID is 'ʵ��ID';
comment on column IG.SOC0116.FINGERPRINT is 'ʱ���';

--SOC0117
comment on table IG.SOC0117 is '�ʲ�ģ�ͱ�';
comment on column IG.SOC0117.EID is '�ʲ�ģ��ID';
comment on column IG.SOC0117.ENAME is '�ʲ�ģ������';
comment on column IG.SOC0117.ELABEL is '�ʲ�ģ�ͱ��';
comment on column IG.SOC0117.EDESC is '�ʲ�ģ��˵��';
comment on column IG.SOC0117.ESTATUS is '�ʲ�ģ��״̬';
comment on column IG.SOC0117.ECATEGORY is '�ʲ�ģ�ͷ���';
comment on column IG.SOC0117.EKEY1 is '�ʲ�ģ��һ������';
comment on column IG.SOC0117.EKEY2 is '�ʲ�ģ�Ͷ�������';
comment on column IG.SOC0117.EKEY3 is '�ʲ�ģ����������';
comment on column IG.SOC0117.ESYSCODING is '�ʲ�ģ�Ͳ����';
comment on column IG.SOC0117.EPARCODING is '�ʲ�ģ�͸��������';
comment on column IG.SOC0117.FINGERPRINT is 'ʱ���';
comment on column IG.SOC0117.EMODELTYPE is '�ʲ�ģ�����';

--SOC0118 
comment on table IG.SOC0118 is '�ʲ���Ϣ��';
comment on column IG.SOC0118.EIID is '�ʲ�ID';
comment on column IG.SOC0118.EID is '�ʲ�ģ��ID';
comment on column IG.SOC0118.EIDESC is '�ʲ�˵��';
comment on column IG.SOC0118.EINAME is '�ʲ�����';
comment on column IG.SOC0118.EILABEL is '�ʲ����';
comment on column IG.SOC0118.EIINSDATE is '�ʲ��Ǽ���';
comment on column IG.SOC0118.EIORGSYSCODING is '�ʲ��������������';
comment on column IG.SOC0118.ESYSCODING is '�ʲ�ģ�Ͳ����';
comment on column IG.SOC0118.EIUPDTIME is '�ʲ�����ʱ��';
comment on column IG.SOC0118.EISTATUS is '�ʲ�״̬';
comment on column IG.SOC0118.EIVERSION is '�ʲ��汾��';
comment on column IG.SOC0118.FINGERPRINT is 'ʱ���';
comment on column IG.SOC0118.EIUSERID is '�ʲ�������';
comment on column IG.SOC0118.EIUSERNAME is '�ʲ�����������';
comment on column IG.SOC0118.EISMALLVERSION is '�ʲ�С�汾';
comment on column IG.SOC0118.EIROOTMARK is '�ʲ����������ڵ�ʵ���ʶ';

--SOC0119
comment on table IG.SOC0119 is '�ʲ���ϵ��Ϣ��';
comment on column IG.SOC0119.EIRID is '�ʲ���ϵ��ϢID';
comment on column IG.SOC0119.PAREIID is '�ʲ�ID(����)';
comment on column IG.SOC0119.PAREID is '�ʲ�ģ��ID(����)';
comment on column IG.SOC0119.CLDEIID is '�ʲ�ID(����)';
comment on column IG.SOC0119.CLDEID is '�ʲ�ģ��ID(����)';
comment on column IG.SOC0119.EIRRELATION is '�ʲ���ϵID';
comment on column IG.SOC0119.EIRRELATIONCODE is '�ʲ���ϵ����';
comment on column IG.SOC0119.EIRUPDTIME is '�ʲ���ϵ��Ϣ����ʱ��';
comment on column IG.SOC0119.EIRSTATUS is '�ʲ���ϵ�Ƿ����ɾ����ʶ';
comment on column IG.SOC0119.EIRDESC is '�ʲ���ϵ˵��';
comment on column IG.SOC0119.FINGERPRINT is 'ʱ���';
comment on column IG.SOC0119.EIRINFO is 'ͨ���ʲ����������Զ����ɵĹ�ϵ��Ϣ';
comment on column IG.SOC0119.PARVERSION is '�����ʲ���汾';
comment on column IG.SOC0119.PARSMALLVERSION is '�����ʲ�С�汾';
comment on column IG.SOC0119.CLDVERSION is '�����ʲ���汾';
comment on column IG.SOC0119.CLDSMALLVERSION is '�����ʲ�С�汾';
comment on column IG.SOC0119.DELETEFLAG is '�߼�ɾ����ʶ';

--SOC0120 
comment on table IG.SOC0120 is '�����������';
comment on column IG.SOC0120.IMPVERSION is '����汾';
comment on column IG.SOC0120.IMPEINAME is 'ʵ������';
comment on column IG.SOC0120.IMPEIID is '����ʵ��ID';
comment on column IG.SOC0120.IMPCITYPE is '����CI����';
comment on column IG.SOC0120.IMPFILENAME is '�����ļ�����';
comment on column IG.SOC0120.IMPCREATETIME is '����ʱ��';
comment on column IG.SOC0120.DELETEFLAG is 'ɾ����ʶ';
comment on column IG.SOC0120.ESYSCODING is '�ʲ������';
comment on column IG.SOC0120.IMPIP is '����IP';
comment on column IG.SOC0120.IMPUSERID is '�����û�ID';
comment on column IG.SOC0120.IMPPASSWORD is '��������';
comment on column IG.SOC0120.IMPSTATUS is '����״̬';
comment on column IG.SOC0120.FINGERPRINT is 'ʱ���';

--SOC0121 
comment on table IG.SOC0121 is '���չ�ϵ��';
comment on column IG.SOC0121.SRID is '�߼�����';
comment on column IG.SOC0121.SRDOMAINID is 'DomainID';
comment on column IG.SOC0121.SRARITHMETICTYPE is '��չ�㷨����';
comment on column IG.SOC0121.SRDOMAINVERSION is 'Domain�汾';
comment on column IG.SOC0121.SRPAREIID is 'Դ�ʲ�ID';
comment on column IG.SOC0121.SRPARVERSION is 'Դ�ʲ���汾';
comment on column IG.SOC0121.SRPARSMALLVERSION is 'Դ�ʲ�С�汾';
comment on column IG.SOC0121.SRCLDEIID is 'Ŀ���ʲ�ID';
comment on column IG.SOC0121.SRCLDVERSION is 'Ŀ���ʲ���汾';
comment on column IG.SOC0121.SRCLDSMALLVERSION is 'Ŀ���ʲ�С�汾';
comment on column IG.SOC0121.SRTYPE is '��ϵ����(����/�߼�)';
comment on column IG.SOC0121.SRDES is '��ϵ˵��';
comment on column IG.SOC0121.SRCREATETIME is '����ʱ��';
comment on column IG.SOC0121.DELETEFLAG is 'ɾ����ʶ';
comment on column IG.SOC0121.SRRALETIONCODE is '������ϵ��';
comment on column IG.SOC0121.SRASSETRELATION is '�ʲ���ϵ��';
comment on column IG.SOC0121.FINGERPRINT is 'ʱ���';

--SOC0122 
comment on table IG.SOC0122 is '����BAT��Ϣ��';
comment on column IG.SOC0122.MAPID is '����ID';
comment on column IG.SOC0122.EIDOMAINID is '��ID';
comment on column IG.SOC0122.SNAPSHOTBAT is '����BAT';
comment on column IG.SOC0122.EIDOMAINDESC is '������';

--SOC0147 
comment on table IG.SOC0147 is '�澯��ϢΨһ��';
comment on column IG.SOC0147.DETECTIONDAY is '�澯����';
comment on column IG.SOC0147.DETECTIONMIN is '�澯ʱ��';
comment on column IG.SOC0147.DIR is 'DIR';
comment on column IG.SOC0147.ERRORNUM is '������';
comment on column IG.SOC0147.EIROOTMARK is '�����ʲ�����';
comment on column IG.SOC0147.FINGERPRINT is 'ʱ���';

--SOC0201  
comment on table IG.SOC0201 is '�Զ��������ɱ�';
comment on column IG.SOC0201.id is 'ID';
comment on column IG.SOC0201.DATAID is '����ID';
comment on column IG.SOC0201.R_CATEGORY is 'ͳ������';
comment on column IG.SOC0201.R_PATH is '�����ļ�����';
comment on column IG.SOC0201.R_RCID is '��������id';
comment on column IG.SOC0201.R_TIME is '����ͳ������';
comment on column IG.SOC0201.fingerprint is 'ʱ���';

--SOC0202  
comment on table IG.SOC0202 is '���ӱ���';
comment on column IG.SOC0202.raId is '����ID';
comment on column IG.SOC0202.raName is '���ӱ�������';
comment on column IG.SOC0202.raSsn is '�洢���к�';
comment on column IG.SOC0202.raKpi is 'kpi';
comment on column IG.SOC0202.raCreateDate is '����ʱ��';
comment on column IG.SOC0202.raUserName is '�û�����';
comment on column IG.SOC0202.raRealName is '��ʵ����';
comment on column IG.SOC0202.fingerprint is 'ʱ���';

--SOC0203  
comment on table IG.SOC0203 is '�Զ����������б�';
comment on column IG.SOC0203.id is 'ID';
comment on column IG.SOC0203.DATAID is '����ID';
comment on column IG.SOC0203.R_PATH is '�����ļ�����';
comment on column IG.SOC0203.R_TITLE is '�����ļ������ĺ���';
comment on column IG.SOC0203.PARA is '��������ʱ���õĲ���';
comment on column IG.SOC0203.fingerprint is 'ʱ���';

--SOC0204  
comment on table IG.SOC0204 is '�����Զ�����';
comment on column IG.SOC0204.rclId is '����ID';
comment on column IG.SOC0204.rclReportType is '��������';
comment on column IG.SOC0204.rclObjName is '��������';
comment on column IG.SOC0204.rclTemName is 'ģ������';
comment on column IG.SOC0204.rclTemDesc is 'ģ������';
comment on column IG.SOC0204.rclObjEiid is '����Eiid';
comment on column IG.SOC0204.rclObjType is '��������';
comment on column IG.SOC0204.rclMode is '����Mode';
comment on column IG.SOC0204.rclCaType is '��������С����';
comment on column IG.SOC0204.rclMenuDefault is '�˵�Ĭ��';
comment on column IG.SOC0204.rclUserId is '�û��ʺ�';
comment on column IG.SOC0204.fingerprint is 'ʱ���';

--SOC0205  
comment on table IG.SOC0205 is '��������';
comment on column IG.SOC0205.rmId is '����ID';
comment on column IG.SOC0205.rmName is '��������';
comment on column IG.SOC0205.rtId is 'ģ�����';
comment on column IG.SOC0205.rmYear is '��';
comment on column IG.SOC0205.rmQuarter is '����';
comment on column IG.SOC0205.rmMonth is '��';
comment on column IG.SOC0205.createDate is '����ʱ��';
comment on column IG.SOC0205.lastAnnexationDate is '��󸽼ӱ���ʱ��';
comment on column IG.SOC0205.fingerprint is 'ʱ���';

--SOC0206  
comment on table IG.SOC0206 is 'ģ��ӳ���';
comment on column IG.SOC0206.rtmId is '��ˮID';
comment on column IG.SOC0206.rtNumber is 'ģ��λ�����';
comment on column IG.SOC0206.rtmSsn is '�洢���к�';
comment on column IG.SOC0206.rtmKpi is 'ʱ������';
--comment on column IG.SOC0206.rtRealName is 'KPI';
comment on column IG.SOC0206.rtmImgNumber is 'Word�ĵ�����ͼƬλ��';
comment on column IG.SOC0206.rtId is 'ģ�����';
comment on column IG.SOC0206.fingerprint is 'ʱ���';

--SOC0207  
comment on table IG.SOC0207 is '����ģ��';
comment on column IG.SOC0207.rtId is 'ID';
comment on column IG.SOC0207.rtName is 'ģ������';
comment on column IG.SOC0207.rtSum is '���޸�λ����';
comment on column IG.SOC0207.rtDateType is 'ʱ������';
comment on column IG.SOC0207.rtRealName is 'ģ����ʵ����';
comment on column IG.SOC0207.rtUploadTime is 'ģ���ϴ�ʱ��';
comment on column IG.SOC0207.rtType is 'ģ������';
comment on column IG.SOC0207.fingerprint is 'ʱ���';

--SOC0208  
comment on table IG.SOC0208 is '�¼��������Ч��';
comment on column IG.SOC0208.prtype is '��������';
comment on column IG.SOC0208.pivaralue is '������Դ';
comment on column IG.SOC0208.efficiencyTime is 'ʱ��';
comment on column IG.SOC0208.monthEfficiency is '��ǰ�·���Ч��';
comment on column IG.SOC0208.historyEfficiency is '��ʷ����Ч��';

--SOC0301  
comment on table IG.SOC0301 is 'DMXʵʱ������ܱ�';
comment on column IG.SOC0301.id is '����';
comment on column IG.SOC0301.mtId is '�������id';
comment on column IG.SOC0301.mtoName is '��ض�����';
comment on column IG.SOC0301.mtKpi is '����ָ��';
comment on column IG.SOC0301.kpiValue is '����ָ��ֵ';
comment on column IG.SOC0301.timeStamp is '����ʱ���';
comment on column IG.SOC0301.fingerprint is 'ʱ���';

--SOC0302  
comment on table IG.SOC0302 is 'DMXʵʱ������ܻ����';
comment on column IG.SOC0302.mtId is '�������id';
comment on column IG.SOC0302.timeStamp is '����ʱ���';
comment on column IG.SOC0302.IOPS is 'ϵͳIOPS';
comment on column IG.SOC0302.IO_Read is 'ÿ���IO����';
comment on column IG.SOC0302.IO_Write is 'ÿ��дIO����';
comment on column IG.SOC0302.RW_Hits is '�����д������';
comment on column IG.SOC0302.KB_Read is 'ÿ���������';
comment on column IG.SOC0302.KB_Write is 'ÿ��д������';

--SOC0303  
comment on table IG.SOC0303 is 'KPIλ��ӳ���';
comment on column IG.SOC0303.id is '����';
comment on column IG.SOC0303.mtcName is '������';
comment on column IG.SOC0303.mtKpi is '����ָ��';
comment on column IG.SOC0303.kpiIndex is 'KPI����������';

--SOC0304  
comment on table IG.SOC0304 is '�����������';
comment on column IG.SOC0304.mtId is '����';
comment on column IG.SOC0304.mtSsn is '�洢���к�d';
comment on column IG.SOC0304.mtCname is '�������';
comment on column IG.SOC0304.mtKpi is 'KPI';
comment on column IG.SOC0304.mtObjNames is '��ض����ַ���';
comment on column IG.SOC0304.mtInterval is '�ɼ����';
comment on column IG.SOC0304.mtNum is '�ɼ�����';
comment on column IG.SOC0304.mtStartTime is '��ʼʱ��';
comment on column IG.SOC0304.mtStopTime is '����ʱ��';
comment on column IG.SOC0304.mtPStopTime is 'Ԥ�ƽ���ʱ��';
comment on column IG.SOC0304.mtStatus is '����״̬';
comment on column IG.SOC0304.mtRecordTime is '��¼ʱ��';
comment on column IG.SOC0304.mtUserId is '��¼�û�id';
comment on column IG.SOC0304.mtOrgId is '�û�����ID';
comment on column IG.SOC0304.fingerprint is 'ʱ���';

--SOC0305  
comment on table IG.SOC0305 is '�澯��Ϣ��';
comment on column IG.SOC0305.id is '����';
comment on column IG.SOC0305.detectiontime is '�澯ʱ��';
comment on column IG.SOC0305.dir is 'dir';
comment on column IG.SOC0305.src is 'src';
comment on column IG.SOC0305.category is 'category';
comment on column IG.SOC0305.severity is '�澯����';
comment on column IG.SOC0305.errornum is '������';
comment on column IG.SOC0305.errordesc is '��������';
comment on column IG.SOC0305.eirootmark is '�����ʲ�����';
comment on column IG.SOC0305.state is 'state';
comment on column IG.SOC0305.sort is 'sort';
comment on column IG.SOC0305.imptypename is '������������';
comment on column IG.SOC0305.imptypeid is '��������id';
comment on column IG.SOC0305.lparnam is 'lparnam';
comment on column IG.SOC0305.ip is 'ip';
comment on column IG.SOC0305.reportingmtms is 'reportingmtms';
comment on column IG.SOC0305.failingenclosuremtms is 'failingenclosuremtms';
comment on column IG.SOC0305.fru1loc is 'fru1loc';
comment on column IG.SOC0305.fru2loc is 'fru2loc';
comment on column IG.SOC0305.fru3loc is 'fru3loc';
comment on column IG.SOC0305.fingerprint is 'ʱ���';
comment on column IG.SOC0305.alarmtype is '�澯����';
comment on column IG.SOC0305.status is '�澯״̬';

--SOC0306  
comment on table IG.SOC0306 is 'δ�������������ʲ���Ϣ��';
comment on column IG.SOC0306.id is '����';
comment on column IG.SOC0306.symmid is '�ʲ�����';
comment on column IG.SOC0306.dataitmes is 'δ����ʱ��';
comment on column IG.SOC0306.symtype is '�ʲ�����';
comment on column IG.SOC0306.readdate is 'ȷ��ʱ��';
comment on column IG.SOC0306.fingerprint is 'ʱ���';

--SOC0401 
comment on table IG.SOC0401 is '���ݿ�����ʵʱ��';
comment on column IG.SOC0401.DBID is '��ˮID';
comment on column IG.SOC0401.DBNAME is '���ݿ�����';
comment on column IG.SOC0401.HOSTNAME is '��������';
comment on column IG.SOC0401.CREATEDATE is '����';
comment on column IG.SOC0401.ALLOTTEDCAPACITY is '�ѷ�������';
comment on column IG.SOC0401.FREECAPACITY is '��������';
comment on column IG.SOC0401.USEDCAPACITY is '��ʹ������';
comment on column IG.SOC0401.FINGERPRINT is 'ʱ���';

--SOC0402 
comment on table IG.SOC0402 is '���ݿ������±�';
comment on column IG.SOC0402.DBID is '��ˮID';
comment on column IG.SOC0402.DBNAME is '���ݿ�����';
comment on column IG.SOC0402.HOSTNAME is '��������';
comment on column IG.SOC0402.CREATEDATE is '����';
comment on column IG.SOC0402.ALLOTTEDCAPACITY is '�ѷ�������';
comment on column IG.SOC0402.FREECAPACITY is '��������';
comment on column IG.SOC0402.USEDCAPACITY is '��ʹ������';
comment on column IG.SOC0402.FINGERPRINT is 'ʱ���';

--SOC0403 
comment on table IG.SOC0403 is '���ݿ���������';
comment on column IG.SOC0403.DBID is '��ˮID';
comment on column IG.SOC0403.DBNAME is '���ݿ�����';
comment on column IG.SOC0403.HOSTNAME is '��������';
comment on column IG.SOC0403.CREATEDATE is '����';
comment on column IG.SOC0403.ALLOTTEDCAPACITY is '�ѷ�������';
comment on column IG.SOC0403.FREECAPACITY is '��������';
comment on column IG.SOC0403.USEDCAPACITY is '��ʹ������';
comment on column IG.SOC0403.FINGERPRINT is 'ʱ���';

--SOC0404  
comment on table IG.SOC0404 is '���ݿ��������';
comment on column IG.SOC0404.DBID is '��ˮID';
comment on column IG.SOC0404.DBNAME is '���ݿ�����';
comment on column IG.SOC0404.HOSTNAME is '��������';
comment on column IG.SOC0404.CREATEDATE is '����';
comment on column IG.SOC0404.ALLOTTEDCAPACITY is '�ѷ�������';
comment on column IG.SOC0404.FREECAPACITY is '��������';
comment on column IG.SOC0404.USEDCAPACITY is '��ʹ������';
comment on column IG.SOC0404.FINGERPRINT is 'ʱ���';

--SOC0405 
comment on table IG.SOC0405 is '�߼�������ʵʱ��';
comment on column IG.SOC0405.LVID is '��ˮID';
comment on column IG.SOC0405.HOSTNAME is '��������';
comment on column IG.SOC0405.VGNAME is '��������';
comment on column IG.SOC0405.LVTYPE is '�߼�������';
comment on column IG.SOC0405.LVNAME is '�߼�������';
comment on column IG.SOC0405.LVSIZE is '�߼����С';
comment on column IG.SOC0405.LVSTATE is '�߼���״̬';
comment on column IG.SOC0405.FSNAME is '�ļ�ϵͳ����';
comment on column IG.SOC0405.CREATEDATE is '����';
comment on column IG.SOC0405.ALLOTTEDCAPACITY is '�ѷ�������';
comment on column IG.SOC0405.FREECAPACITY is '��������';
comment on column IG.SOC0405.USEDCAPACITY is '��ʹ������';
comment on column IG.SOC0405.FINGERPRINT is 'ʱ���';

--SOC0406 
comment on table IG.SOC0406 is '�߼��������±�';
comment on column IG.SOC0406.LVID is '��ˮID';
comment on column IG.SOC0406.HOSTNAME is '��������';
comment on column IG.SOC0406.VGNAME is '��������';
comment on column IG.SOC0406.LVTYPE is '�߼�������';
comment on column IG.SOC0406.LVNAME is '�߼�������';
comment on column IG.SOC0406.LVSIZE is '�߼����С';
comment on column IG.SOC0406.LVSTATE is '�߼���״̬';
comment on column IG.SOC0406.FSNAME is '�ļ�ϵͳ����';
comment on column IG.SOC0406.CREATEDATE is '����';
comment on column IG.SOC0406.ALLOTTEDCAPACITY is '�ѷ�������';
comment on column IG.SOC0406.FREECAPACITY is '��������';
comment on column IG.SOC0406.USEDCAPACITY is '��ʹ������';
comment on column IG.SOC0406.FINGERPRINT is 'ʱ���';

--SOC0407 
comment on table IG.SOC0407 is '�߼�����������';
comment on column IG.SOC0407.LVID is '��ˮID';
comment on column IG.SOC0407.HOSTNAME is '��������';
comment on column IG.SOC0407.VGNAME is '��������';
comment on column IG.SOC0407.LVTYPE is '�߼�������';
comment on column IG.SOC0407.LVNAME is '�߼�������';
comment on column IG.SOC0407.LVSIZE is '�߼����С';
comment on column IG.SOC0407.LVSTATE is '�߼���״̬';
comment on column IG.SOC0407.FSNAME is '�ļ�ϵͳ����';
comment on column IG.SOC0407.CREATEDATE is '����';
comment on column IG.SOC0407.ALLOTTEDCAPACITY is '�ѷ�������';
comment on column IG.SOC0407.FREECAPACITY is '��������';
comment on column IG.SOC0407.USEDCAPACITY is '��ʹ������';
comment on column IG.SOC0407.FINGERPRINT is 'ʱ���';

--SOC0408
comment on table IG.SOC0408 is '�߼����������';
comment on column IG.SOC0408.LVID is '��ˮID';
comment on column IG.SOC0408.HOSTNAME is '��������';
comment on column IG.SOC0408.VGNAME is '��������';
comment on column IG.SOC0408.LVTYPE is '�߼�������';
comment on column IG.SOC0408.LVNAME is '�߼�������';
comment on column IG.SOC0408.LVSIZE is '�߼����С';
comment on column IG.SOC0408.LVSTATE is '�߼���״̬';
comment on column IG.SOC0408.FSNAME is '�ļ�ϵͳ����';
comment on column IG.SOC0408.CREATEDATE is '����';
comment on column IG.SOC0408.ALLOTTEDCAPACITY is '�ѷ�������';
comment on column IG.SOC0408.FREECAPACITY is '��������';
comment on column IG.SOC0408.USEDCAPACITY is '��ʹ������';
comment on column IG.SOC0408.FINGERPRINT is 'ʱ���';

--SOC0409 
comment on table IG.SOC0409 is '���������ʵʱ��';
comment on column IG.SOC0409.PHID is '��ˮID';
comment on column IG.SOC0409.SNAME is '�洢���к�';
comment on column IG.SOC0409.HOSTNAME is '��������';
comment on column IG.SOC0409.VGNAME is '��������';
comment on column IG.SOC0409.CREATEDATE is '����';
comment on column IG.SOC0409.LUNID is 'LUNID';
comment on column IG.SOC0409.PVSIZE is '������С';
comment on column IG.SOC0409.FINGERPRINT is 'ʱ���';

--SOC0410 
comment on table IG.SOC0410 is '�����洢ʵʱ��';
comment on column IG.SOC0410.PSID is '��ˮID';
comment on column IG.SOC0410.SNAME is '�洢���к�';
comment on column IG.SOC0410.LUNID is 'LUNID';
comment on column IG.SOC0410.PVSIZE is '������С';
comment on column IG.SOC0410.ISUSED is '�Ƿ񱻷���';
comment on column IG.SOC0410.CREATEDATE is '����';
comment on column IG.SOC0410.FINGERPRINT is 'ʱ���';

--SOC0411 
comment on table IG.SOC0411 is '�洢����ʵʱ��';
comment on column IG.SOC0411.SCID is '��ˮID';
comment on column IG.SOC0411.SNAME is '�洢���к�';
comment on column IG.SOC0411.CREATEDATE is '����';
comment on column IG.SOC0411.RAWCAPACITY is '������';
comment on column IG.SOC0411.EFFECTIVECAPACITY is '��Ч����';
comment on column IG.SOC0411.REDUNDANCYCAPACITY is '��������';
comment on column IG.SOC0411.ALLOTTEDCAPACITY is '�ѷ�������';
comment on column IG.SOC0411.FREECAPACITY is '��������';
comment on column IG.SOC0411.DISKCOUNT is '���̸���';
comment on column IG.SOC0411.FINGERPRINT is 'ʱ���';

--SOC0412 
comment on table IG.SOC0412 is '�洢�����±�';
comment on column IG.SOC0412.SCID is '��ˮID';
comment on column IG.SOC0412.SNAME is '�洢���к�';
comment on column IG.SOC0412.CREATEDATE is '����';
comment on column IG.SOC0412.RAWCAPACITY is '������';
comment on column IG.SOC0412.EFFECTIVECAPACITY is '��Ч����';
comment on column IG.SOC0412.REDUNDANCYCAPACITY is '��������';
comment on column IG.SOC0412.ALLOTTEDCAPACITY is '�ѷ�������';
comment on column IG.SOC0412.FREECAPACITY is '��������';
comment on column IG.SOC0412.DISKCOUNT is '���̸���';
comment on column IG.SOC0412.FINGERPRINT is 'ʱ���';

--SOC0413 
comment on table IG.SOC0413 is '�洢��������';
comment on column IG.SOC0413.SCID is '��ˮID';
comment on column IG.SOC0413.SNAME is '�洢���к�';
comment on column IG.SOC0413.CREATEDATE is '����';
comment on column IG.SOC0413.RAWCAPACITY is '������';
comment on column IG.SOC0413.EFFECTIVECAPACITY is '��Ч����';
comment on column IG.SOC0413.REDUNDANCYCAPACITY is '��������';
comment on column IG.SOC0413.ALLOTTEDCAPACITY is '�ѷ�������';
comment on column IG.SOC0413.FREECAPACITY is '��������';
comment on column IG.SOC0413.DISKCOUNT is '���̸���';
comment on column IG.SOC0413.FINGERPRINT is 'ʱ���';

--SOC0414 
comment on table IG.SOC0414 is '�洢�������';
comment on column IG.SOC0414.SCID is '��ˮID';
comment on column IG.SOC0414.SNAME is '�洢���к�';
comment on column IG.SOC0414.CREATEDATE is '����';
comment on column IG.SOC0414.RAWCAPACITY is '������';
comment on column IG.SOC0414.EFFECTIVECAPACITY is '��Ч����';
comment on column IG.SOC0414.REDUNDANCYCAPACITY is '��������';
comment on column IG.SOC0414.ALLOTTEDCAPACITY is '�ѷ�������';
comment on column IG.SOC0414.FREECAPACITY is '��������';
comment on column IG.SOC0414.DISKCOUNT is '���̸���';
comment on column IG.SOC0414.FINGERPRINT is 'ʱ���';

--SOC0415 
comment on table IG.SOC0415 is '��ռ�����ʵʱ��';
comment on column IG.SOC0415.TSID is '��ˮID';
comment on column IG.SOC0415.TSNAME is '��ռ�����';
comment on column IG.SOC0415.HOSTNAME is '��������';
comment on column IG.SOC0415.DBNAME is '���ݿ�����';
comment on column IG.SOC0415.CREATEDATE is '����';
comment on column IG.SOC0415.ALLOTTEDCAPACITY is '�ѷ�������';
comment on column IG.SOC0415.FREECAPACITY is '��������';
comment on column IG.SOC0415.USEDCAPACITY is '��ʹ������';
comment on column IG.SOC0415.FINGERPRINT is 'ʱ���';

--SOC0416 
comment on table IG.SOC0416 is '��ռ������±�';
comment on column IG.SOC0416.TSID is '��ˮID';
comment on column IG.SOC0416.TSNAME is '��ռ�����';
comment on column IG.SOC0416.HOSTNAME is '��������';
comment on column IG.SOC0416.DBNAME is '���ݿ�����';
comment on column IG.SOC0416.CREATEDATE is '����';
comment on column IG.SOC0416.ALLOTTEDCAPACITY is '�ѷ�������';
comment on column IG.SOC0416.FREECAPACITY is '��������';
comment on column IG.SOC0416.USEDCAPACITY is '��ʹ������';
comment on column IG.SOC0416.FINGERPRINT is 'ʱ���';

--SOC0417 
comment on table IG.SOC0417 is '��ռ���������';
comment on column IG.SOC0417.TSID is '��ˮID';
comment on column IG.SOC0417.TSNAME is '��ռ�����';
comment on column IG.SOC0417.HOSTNAME is '��������';
comment on column IG.SOC0417.DBNAME is '���ݿ�����';
comment on column IG.SOC0417.CREATEDATE is '����';
comment on column IG.SOC0417.ALLOTTEDCAPACITY is '�ѷ�������';
comment on column IG.SOC0417.FREECAPACITY is '��������';
comment on column IG.SOC0417.USEDCAPACITY is '��ʹ������';
comment on column IG.SOC0417.FINGERPRINT is 'ʱ���';

--SOC0418 
comment on table IG.SOC0418 is '��ռ��������';
comment on column IG.SOC0418.TSID is '��ˮID';
comment on column IG.SOC0418.TSNAME is '��ռ�����';
comment on column IG.SOC0418.HOSTNAME is '��������';
comment on column IG.SOC0418.DBNAME is '���ݿ�����';
comment on column IG.SOC0418.CREATEDATE is '����';
comment on column IG.SOC0418.ALLOTTEDCAPACITY is '�ѷ�������';
comment on column IG.SOC0418.FREECAPACITY is '��������';
comment on column IG.SOC0418.USEDCAPACITY is '��ʹ������';
comment on column IG.SOC0418.FINGERPRINT is 'ʱ���';

--SOC0419 
comment on table IG.SOC0419 is '��������ʵʱ��';
comment on column IG.SOC0419.VGID is '��ˮID';
comment on column IG.SOC0419.VGNAME is '��������';
comment on column IG.SOC0419.HOSTNAME is '��������';
comment on column IG.SOC0419.SNAME is '�洢���к�';
comment on column IG.SOC0419.CREATEDATE is '����';
comment on column IG.SOC0419.ALLOTTEDCAPACITY is '�ѷ�������';
comment on column IG.SOC0419.FREECAPACITY is '��������';
comment on column IG.SOC0419.USEDCAPACITY is '��ʹ������';
comment on column IG.SOC0419.FINGERPRINT is 'ʱ���';

--SOC0420 
comment on table IG.SOC0420 is '���������±�';
comment on column IG.SOC0420.VGID is '��ˮID';
comment on column IG.SOC0420.VGNAME is '��������';
comment on column IG.SOC0420.HOSTNAME is '��������';
comment on column IG.SOC0420.SNAME is '�洢���к�';
comment on column IG.SOC0420.CREATEDATE is '����';
comment on column IG.SOC0420.ALLOTTEDCAPACITY is '�ѷ�������';
comment on column IG.SOC0420.FREECAPACITY is '��������';
comment on column IG.SOC0420.USEDCAPACITY is '��ʹ������';
comment on column IG.SOC0420.FINGERPRINT is 'ʱ���';

--SOC0421 
comment on table IG.SOC0421 is '������������';
comment on column IG.SOC0421.VGID is '��ˮID';
comment on column IG.SOC0421.VGNAME is '��������';
comment on column IG.SOC0421.HOSTNAME is '��������';
comment on column IG.SOC0421.SNAME is '�洢���к�';
comment on column IG.SOC0421.CREATEDATE is '����';
comment on column IG.SOC0421.ALLOTTEDCAPACITY is '�ѷ�������';
comment on column IG.SOC0421.FREECAPACITY is '��������';
comment on column IG.SOC0421.USEDCAPACITY is '��ʹ������';
comment on column IG.SOC0421.FINGERPRINT is 'ʱ���';

--SOC0422 
comment on table IG.SOC0422 is '�����������';
comment on column IG.SOC0422.VGID is '��ˮID';
comment on column IG.SOC0422.VGNAME is '��������';
comment on column IG.SOC0422.HOSTNAME is '��������';
comment on column IG.SOC0422.SNAME is '�洢���к�';
comment on column IG.SOC0422.CREATEDATE is '����';
comment on column IG.SOC0422.ALLOTTEDCAPACITY is '�ѷ�������';
comment on column IG.SOC0422.FREECAPACITY is '��������';
comment on column IG.SOC0422.USEDCAPACITY is '��ʹ������';
comment on column IG.SOC0422.FINGERPRINT is 'ʱ���';

--SOC0423 
comment on table IG.SOC0423 is '���������б�';
comment on column IG.SOC0423.ID is '��ˮID';
comment on column IG.SOC0423.NAME is '����������������';
comment on column IG.SOC0423.OBJECTTYPE is '������������';
comment on column IG.SOC0423.OBJECTNAME is '������������';
comment on column IG.SOC0423.FINGERPRINT is 'ʱ���';
comment on column IG.SOC0423.ERRORNUM is '���ظ澯��ֵ';
comment on column IG.SOC0423.WARNINGNUM is '��ͨ�澯��ֵ';
comment on column IG.SOC0423.STATUS is '״̬';

--SOC0424 
comment on table IG.SOC0424 is '�������ͱ�';
comment on column IG.SOC0424.REPORTNAME is '��������';
comment on column IG.SOC0424.RTTYPE is '��������';
comment on column IG.SOC0424.STORAGETYPE is '�洢����';
comment on column IG.SOC0424.FINGERPRINT is 'ʱ���';

--SOC0425 
comment on table IG.SOC0425 is 'ҵ��ϵͳ�����±�';
comment on column IG.SOC0425.ID is '��ˮID';
comment on column IG.SOC0425.BCID is 'ҵ��ϵͳID';
comment on column IG.SOC0425.BCNAME is 'ҵ��ϵͳ����';
comment on column IG.SOC0425.SNAME is '�洢���к�';
comment on column IG.SOC0425.CREATEDATE is '����';
comment on column IG.SOC0425.ALLOTTEDCAPACITY is '�ѷ�������';
comment on column IG.SOC0425.USEDCAPACITY is '��ʹ������';
comment on column IG.SOC0425.FINGERPRINT is 'ʱ���';

--SOC0426 
comment on table IG.SOC0426 is 'ҵ��ϵͳ��������';
comment on column IG.SOC0426.ID is '��ˮID';
comment on column IG.SOC0426.BCID is 'ҵ��ϵͳID';
comment on column IG.SOC0426.BCNAME is 'ҵ��ϵͳ����';
comment on column IG.SOC0426.SNAME is '�洢���к�';
comment on column IG.SOC0426.CREATEDATE is '����';
comment on column IG.SOC0426.ALLOTTEDCAPACITY is '�ѷ�������';
comment on column IG.SOC0426.USEDCAPACITY is '��ʹ������';
comment on column IG.SOC0426.FINGERPRINT is 'ʱ���';

--SOC0427 
comment on table IG.SOC0427 is 'ҵ��ϵͳ�������';
comment on column IG.SOC0427.ID is '��ˮID';
comment on column IG.SOC0427.BCID is 'ҵ��ϵͳID';
comment on column IG.SOC0427.BCNAME is 'ҵ��ϵͳ����';
comment on column IG.SOC0427.SNAME is '�洢���к�';
comment on column IG.SOC0427.CREATEDATE is '����';
comment on column IG.SOC0427.ALLOTTEDCAPACITY is '�ѷ�������';
comment on column IG.SOC0427.USEDCAPACITY is '��ʹ������';
comment on column IG.SOC0427.FINGERPRINT is 'ʱ���';

--SOC0433
comment on table IG.SOC0433 is 'VIO';
comment on column IG.SOC0433.ID is '��ˮID';
comment on column IG.SOC0433.VIONAME is 'VIO����';
comment on column IG.SOC0433.HOSTNAME is '��������';
comment on column IG.SOC0433.FINGERPRINT is 'ʱ���';

--SOC0434
comment on table IG.SOC0434 is 'VIO������';
comment on column IG.SOC0434.pvvid is '����';
comment on column IG.SOC0434.sn is '���к�';
comment on column IG.SOC0434.sName is '�洢��';
comment on column IG.SOC0434.lunid is 'lunid';
comment on column IG.SOC0434.pvSize is '���������';
comment on column IG.SOC0434.isUsed is 'ʹ��״̬';
comment on column IG.SOC0434.createDate is '����';
comment on column IG.SOC0434.FINGERPRINT is 'ʱ���';

--SOC0435 
comment on table IG.SOC0435 is '����pv��';
comment on column IG.SOC0435.PHID is '��ˮID';
comment on column IG.SOC0435.SNAME is '�洢���к�';
comment on column IG.SOC0435.HOSTNAME is '��������';
comment on column IG.SOC0435.VGNAME is '��������';
comment on column IG.SOC0435.CREATEDATE is '����';
comment on column IG.SOC0435.LUNID is 'LUNID';
comment on column IG.SOC0435.PVSIZE is '������С';
comment on column IG.SOC0435.FINGERPRINT is 'ʱ���';

--SOC0436 
comment on table IG.SOC0436 is '�����洢ʵʱ��';
comment on column IG.SOC0436.PSID is '��ˮID';
comment on column IG.SOC0436.SNAME is '�洢���к�';
comment on column IG.SOC0436.LUNID is 'LUNID';
comment on column IG.SOC0436.PVSIZE is '������С';
comment on column IG.SOC0436.ISUSED is '�Ƿ񱻷���';
comment on column IG.SOC0436.CREATEDATE is '����';
comment on column IG.SOC0436.FINGERPRINT is 'ʱ���';

--IG911
comment on table IG.IG911 is '�Զ���������ط�����Ϣ��';
comment on column IG.IG911.psprpid is '��������';
comment on column IG.IG911.pdid is '��������ID';
comment on column IG.IG911.psdid is '����״̬ID';
comment on column IG.IG911.roleid is '�����߽�ɫID';
comment on column IG.IG911.relevantPdid is '��ط������������ID';
comment on column IG.IG911.fingerPrint is 'ʱ���';

--IG931
comment on table IG.IG931 is 'ȱʡ�Զ���������ط�����Ϣ��';
comment on column IG.IG931.dpsprpid is '��������';
comment on column IG.IG931.pdid is '��������ID';
comment on column IG.IG931.psdid is '����״̬ID';
comment on column IG.IG931.relevantPdid is '��ط������������ID';
comment on column IG.IG931.fingerPrint is 'ʱ���';

--CUSTOMCONFIGURATION
comment on table IG.CUSTOMCONFIGURATION is '���Ʊ���ı�������趨��';
comment on column IG.CUSTOMCONFIGURATION.RFDID is '����ID';
comment on column IG.CUSTOMCONFIGURATION.PDID is '��������ID�����ʱ��#�ָ���';
comment on column IG.CUSTOMCONFIGURATION.PRSTATUSINFO is '����״̬��ʶ�����ʱ��#�ָ���';
comment on column IG.CUSTOMCONFIGURATION.PIDID is '������ID';
comment on column IG.CUSTOMCONFIGURATION.PIDVALUE is '��ֵ�����ʱ��#�ָ���';
comment on column IG.CUSTOMCONFIGURATION.USERID is '�����û�id';
comment on column IG.CUSTOMCONFIGURATION.CREATETIME is '����ʱ��';
comment on column IG.CUSTOMCONFIGURATION.UPDATETIME is '����ʱ��';
comment on column IG.CUSTOMCONFIGURATION.FINGERPRINT is 'ʱ���';

--IG700
comment on table IG.IG700 is '���̲鿴��ɫ���ñ�';
comment on column IG.IG700.pdid is '���̶���ID';
comment on column IG.IG700.roleid is '��ɫID';

--IG701
comment on table IG.IG701 is '���̲鿴��ɫ��Ȩ����';
comment on column IG.IG701.pdid is '���̶���ID';
comment on column IG.IG701.roleid is '��ɫID';
comment on column IG.IG701.pidid is '��ID';

commit;