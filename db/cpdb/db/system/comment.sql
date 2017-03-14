--Role
comment on table Role is '角色表';
comment on column Role.roleid is '角色ID';
comment on column Role.rolename is '角色名称';
comment on column Role.roledesc is '角色说明';
comment on column Role.roleinfo is '角色信息';
comment on column Role.roletype is '角色类型';
comment on column Role.roledomain is '角色机构管理范围';
comment on column Role.assetdomain is '角色资产模型管理范围';
comment on column Role.fingerprint is '时间戳';

--Action
comment on table Action is '菜单表';
comment on column Action.actname is '菜单标识';
comment on column Action.actlabel is '菜单显示名称';
comment on column Action.actdesc is '菜单说明';
comment on column Action.acturl is '提交URL';
comment on column Action.acttype is '菜单类型';
comment on column Action.actl1id is '一级菜单ID（保留）';
comment on column Action.actl2id is '二级菜单ID（保留）';
comment on column Action.actl3id is '三级菜单ID（保留）';
comment on column Action.fingerprint is '时间戳';
comment on column Action.actroletype is '菜单可授予角色类型';
comment on column Action.actsortid is '菜单显示顺序';
comment on column Action.acturltype is '提交URL类型';

--RoleAction
comment on table RoleAction is '角色菜单表';
comment on column RoleAction.raid is '角色菜单ID';
comment on column RoleAction.roleid is '角色ID';
comment on column RoleAction.actname is '菜单标识';
comment on column RoleAction.raperm is '角色对应菜单的权限（保留）';
comment on column RoleAction.radesc is '角色对应菜单的权限说明（保留）';
comment on column RoleAction.fingerprint is '时间戳';

--Organization
comment on table Organization is '机构表';
comment on column Organization.orgid is '机构ID';
comment on column Organization.orgname is '机构名称';
comment on column Organization.orgpar is '上级机构层次码';
comment on column Organization.orgparname is '上级机构名称（保留）';
comment on column Organization.orgdesc is '机构说明';
comment on column Organization.orgtype is '机构类型';
comment on column Organization.orgaddr is '机构地址';
comment on column Organization.orgphone is '机构电话';
comment on column Organization.orgfax is '机构传真';
comment on column Organization.orgcontact is '机构联系人';
comment on column Organization.orgstatus is '机构状态';
comment on column Organization.orginfo is '机构信息';
comment on column Organization.orgsyscoding is '机构层次码';
comment on column Organization.orgusercoding is '机构编码';
comment on column Organization.fingerprint is '时间戳';

--IgUser
comment on table IgUser is '用户表';
comment on column IgUser.userid is '用户ID';
comment on column IgUser.orgid is '所属机构层次码';
comment on column IgUser.orgname is '所属机构名称';
comment on column IgUser.username is '用户姓名';
comment on column IgUser.userdesc is '用户说明';
comment on column IgUser.userinfo is '用户信息';
comment on column IgUser.password is '用户密码';
comment on column IgUser.userstatus is '用户状态';
comment on column IgUser.usertype is '用户类型';
comment on column IgUser.userphone is '用户电话';
comment on column IgUser.usermobile is '用户手机';
comment on column IgUser.useremail is '用户邮箱';
comment on column IgUser.fingerprint is '时间戳';
comment on column IgUser.deleteflag is '逻辑删除标识';

--IG622
comment on table IG622 is '首页跳转URL定义表';
comment on column IG622.HPID is '首页ID';
comment on column IG622.HPLABEL is '首页描述';
comment on column IG622.HPTITLE is '首页显示名称';
comment on column IG622.HPURL is '首页URL';
comment on column IG622.FINGERPRINT is '时间戳';

--UserRole
comment on table UserRole is '用户角色表';
comment on column UserRole.urid is '用户角色ID';
comment on column UserRole.userid is '用户ID';
comment on column UserRole.orgid is '角色ID';
comment on column UserRole.roleid is '机构层次码';
comment on column UserRole.fingerprint is '时间戳';
comment on column UserRole.rolemanager is '角色负责人标识';
comment on column UserRole.dutyflag is '值班人标识';

--Notice
comment on table Notice is '通知表';
comment on column Notice.nid is '通知ID';
comment on column Notice.nname is '通知名称';
comment on column Notice.ndesc is '通知描述';
comment on column Notice.ntime is '通知时间';
comment on column Notice.nuserid is '用户ID';
comment on column Notice.nusername is '用户姓名';
comment on column Notice.norgid is '机构层次码';
comment on column Notice.norgname is '机构名称';
comment on column Notice.nattkey is '附件KEY';
comment on column Notice.fingerprint is '时间戳';

--CodeCategory
comment on table CodeCategory is '基础数据分类表';
comment on column CodeCategory.ccid is '数据分类ID';
comment on column CodeCategory.ccname is '数据分类名称';
comment on column CodeCategory.ccinfo is '数据分类说明';
comment on column CodeCategory.cceditable is '编辑标识';
comment on column CodeCategory.pccid is '上级数据分类ID';
comment on column CodeCategory.pcflag is '支持最大级数';
comment on column CodeCategory.fingerprint is '时间戳';

--CodeDetail
comment on table CodeDetail is '基础数据详细信息表';
comment on column CodeDetail.ccid is '数据分类ID';
comment on column CodeDetail.cid is '数据ID';
comment on column CodeDetail.cvalue is '数据内容';
comment on column CodeDetail.pccid is '上级数据分类ID';
comment on column CodeDetail.pcid is '上级数据ID';
comment on column CodeDetail.updtime is '数据更新时间';
comment on column CodeDetail.syscoding is '数据层次码';
comment on column CodeDetail.psyscoding is '上级数据层次码';
comment on column CodeDetail.cdstatus is '数据状态';
comment on column CodeDetail.businesscode is '资产关联关系码';
comment on column CodeDetail.fingerprint is '时间戳';
comment on column CodeDetail.cdinfo is '数据说明';
comment on column CodeDetail.cdorder is '数据显示顺序';

--CODECATEGORYDEF
comment on table CODECATEGORYDEF is '树型数据分类表';
comment on column CODECATEGORYDEF.CCID is '树型数据分类ID';
comment on column CODECATEGORYDEF.CCNAME is '树型数据分类名称';
comment on column CODECATEGORYDEF.CCINFO is '树型数据分类说明';
comment on column CODECATEGORYDEF.CCEDITABLE is '编辑标识';
comment on column CODECATEGORYDEF.PCCID is '上级数据分类ID'; 
comment on column CODECATEGORYDEF.PCFLAG is '支持最大级数';
comment on column CODECATEGORYDEF.FINGERPRINT is '时间戳';

--CODEDETAILDEF
comment on table CODEDETAILDEF is '树型数据详细信息表';
comment on column CODEDETAILDEF.CCID is '树型数据分类ID'; 
comment on column CODEDETAILDEF.CID is '数据ID';
comment on column CODEDETAILDEF.CVALUE is '数据内容';
comment on column CODEDETAILDEF.PCCID is '上级数据分类ID';
comment on column CODEDETAILDEF.PCID is '上级数据ID';
comment on column CODEDETAILDEF.UPDTIME is '数据更新时间';
comment on column CODEDETAILDEF.SYSCODING is '数据层次码';
comment on column CODEDETAILDEF.PSYSCODING is '上级数据层次码';
comment on column CODEDETAILDEF.CDSTATUS is '数据状态';
comment on column CODEDETAILDEF.BUSINESSCODE is '业务标识';
comment on column CODEDETAILDEF.CDINFO is '数据说明';
comment on column CODEDETAILDEF.FINGERPRINT is '时间戳';

--IG117
comment on table IG117 is '资产模型表';
comment on column IG117.eid is '模型ID';
comment on column IG117.ename is '模型名称';
comment on column IG117.elabel is '模型标识';
comment on column IG117.edesc is '模型说明';
comment on column IG117.estatus is '模型状态';
comment on column IG117.ecategory is '模型分类';
comment on column IG117.ekey1 is '保留';
comment on column IG117.ekey2 is '保留';
comment on column IG117.ekey3 is '保留';
comment on column IG117.esyscoding is '模型层次码';
comment on column IG117.eparcoding is '上级模型层次码';
comment on column IG117.fingerprint is '时间戳';
comment on column IG117.emodeltype is '模型类型';

--IG225
comment on table IG225 is '资产配置表';
comment on column IG225.cid is '配置ID';
comment on column IG225.eid is '资产模型ID';
comment on column IG225.cname is '配置名称';
comment on column IG225.clabel is '配置关键字';
comment on column IG225.cdesc is '配置说明';
comment on column IG225.cunit is '配置单位';
comment on column IG225.cstatus is '配置状态';
comment on column IG225.cseq is '配置可见标识';
comment on column IG225.ccategory is '配置类别';
comment on column IG225.coption is '配置取值范围';
comment on column IG225.cattach is '配置数据类型';
comment on column IG225.esyscoding is '资产模型层次码';
comment on column IG225.fingerprint is '时间戳';
comment on column IG225.crequired is '配置必填标识';

--IG545
comment on table IG545 is '资产配置取值范围表';
comment on column IG545.ccdid is '数据ID';
comment on column IG545.ccdcategory is '数据编码';
comment on column IG545.ccdlabel is '数据名称';
comment on column IG545.ccdvalue is '数据值';
comment on column IG545.ccdstatus is '数据状态';
comment on column IG545.ccdtype is '数据类型';
comment on column IG545.ccdinfo is '数据说明';
comment on column IG545.fingerprint is '时间戳';

--IG611
comment on table IG611 is '资产配置项缺省值表';
comment on column IG611.EID is '资产模型ID';
comment on column IG611.CID is '资产配置ID';
comment on column IG611.CVALUE is '缺省值';
comment on column IG611.FINGERPRINT is '时间戳';

--IG013
comment on table IG013 is '资产表';
comment on column IG013.eiid is '资产ID';
comment on column IG013.eid is '资产模型ID';
comment on column IG013.eidesc is '资产说明';
comment on column IG013.einame is '资产名称';
comment on column IG013.eilabel is '资产编号';
comment on column IG013.eiinsdate is '资产登记日期';
comment on column IG013.eiorgsyscoding is '资产所属机构层次码';
comment on column IG013.esyscoding is '资产所属模型层次码';
comment on column IG013.eiupdtime is '资产更新时间';
comment on column IG013.eistatus is '资产状态';
comment on column IG013.eiversion is '资产大版本';
comment on column IG013.fingerprint is '时间戳';
comment on column IG013.eiuserid is '资产管理人ID';
comment on column IG013.eiusername is '资产管理人姓名';
comment on column IG013.eismallversion is '资产小版本';
comment on column IG013.eirootmark is '资产所属根节点实体标识';

--IG800
comment on table IG800 is '资产配置项表';
comment on column IG800.ciid is '资产配置项ID';
comment on column IG800.cid is '资产配置ID';
comment on column IG800.eiid is '资产ID';
comment on column IG800.eid is '资产模型ID';
comment on column IG800.civalue is '配置项值';
comment on column IG800.ciupdtime is '配置项更新时间';
comment on column IG800.esyscoding is '资产模型层次码';
comment on column IG800.ciexpire is '保留';
comment on column IG800.cistatus is '保留';
comment on column IG800.cicurver is '配置项值是否变更';
comment on column IG800.civersion is '配置项大版本';
comment on column IG800.civerinfo is '保留';
comment on column IG800.fingerprint is '时间戳';
comment on column IG800.cismallversion is '配置项小版本';

--IG313
comment on table IG313 is '资产关系表';
comment on column IG313.eirid is '资产关系ID';
comment on column IG313.pareiid is '资产ID（正向）';
comment on column IG313.pareid is '资产模型ID（正向）';
comment on column IG313.cldeiid is '资产ID（反向）';
comment on column IG313.cldeid is '资产模型ID（反向）';
comment on column IG313.eirrelation is '关联关系标识';
comment on column IG313.eirrelationcode is '关系码头';
comment on column IG313.eirupdtime is '更新时间';
comment on column IG313.eirstatus is '可删除标识';
comment on column IG313.eirdesc is '关系说明';
comment on column IG313.fingerprint is '时间戳';
comment on column IG313.eirinfo is '特殊关系标识';
comment on column IG313.parversion is '资产大版本（正向）';
comment on column IG313.parsmallversion is '资产小版本（正向）';
comment on column IG313.cldversion is '资产大版本（反向）';
comment on column IG313.cldsmallversion is '资产小版本（反向）';
comment on column IG313.deleteflag is '逻辑删除标识';

--IG809
comment on table IG809 is '资产关系图信息表（保留）';
comment on column IG809.eirfid is '资产关系图信息ID';
comment on column IG809.eiid is '资产ID';
comment on column IG809.eirftype is '关系图类型';
comment on column IG809.eirfname is '关系图XML文件名';
comment on column IG809.eirfupdtime is '关系图创建时间';
comment on column IG809.fingerprint is '时间戳';

--COLLECTPARAM
comment on table COLLECTPARAM is '软件采集脚本定义表（保留）';
comment on column COLLECTPARAM.CPTYPEID is '自增主键';
comment on column COLLECTPARAM.CPSMODE is '脚本类型';
comment on column COLLECTPARAM.CPSCRIPTNAME is '脚本名称';
comment on column COLLECTPARAM.CPFILEPATH is '脚本路径';
comment on column COLLECTPARAM.FINGERPRINT is '时间戳';

--compareTemplate
comment on table compareTemplate is '机房位置信息表';
comment on column compareTemplate.ctid is '位置信息ID';
comment on column compareTemplate.ctcategory is '类别ID';
comment on column compareTemplate.cttype is '类型';
comment on column compareTemplate.ctxwidth is '横向宽度';
comment on column compareTemplate.ctywidth is '纵向宽度';
comment on column compareTemplate.ctvalue is '值';
comment on column compareTemplate.fingerprint is '时间戳';

--IG259
comment on table IG259 is '流程模版表';
comment on column IG259.ptid is '模版ID';
comment on column IG259.ptname is '模版名称';
comment on column IG259.pttype is '模版类型';
comment on column IG259.ptstartpg is '模版发起页URL';
comment on column IG259.ptdetailpg is '模版创建时间';
comment on column IG259.ptcrtdate is '模版信息';
comment on column IG259.ptpicinfo is '模版状态';
comment on column IG259.ptstatus is '模版查看页URL';
comment on column IG259.ptsavepg is '发起页URL';
comment on column IG259.ptqrtzflag is '定时发起URL';
comment on column IG259.fingerprint is '时间戳';

--IG380
comment on table IG380 is '流程类型表';
comment on column IG380.pdid is '流程类型ID';
comment on column IG380.ptid is '流程模版ID';
comment on column IG380.pdname is '类型名称';
comment on column IG380.pddesc is '类型描述';
comment on column IG380.pdcrtdate is '创建时间';
comment on column IG380.pdstatus is '类型状态';
comment on column IG380.pdxml is '流程图XML';
comment on column IG380.permission is '权限';
comment on column IG380.fingerprint is '时间戳';
comment on column IG380.serialgenerator is '工单号生成器';
comment on column IG380.pdactname is '流程二级菜单ID';

--IG007
comment on table IG007 is '流程表单定义表';
comment on column IG007.pidid is '表单定义ID';
comment on column IG007.pdid is '流程定义ID';
comment on column IG007.pidname is '表单标识';
comment on column IG007.pidlabel is '表单显示名称';
comment on column IG007.piddesc is '表单描述';
comment on column IG007.pidtype is '表单类型';
comment on column IG007.pidoption is '表单取值范围';
comment on column IG007.piddefault is '表单默认值';
comment on column IG007.pidrequired is '是否必填';
comment on column IG007.fingerprint is '时间戳';
comment on column IG007.pidsortid is '排序标识';
comment on column IG007.ccid is '树型数据分类ID';
comment on column IG007.pidgid is '通用表单定义ID';
comment on column IG007.PIDMODE is '表单模式';
comment on column IG007.PRIVATESCOPE is '私有表单权限范围';
comment on column IG007.ROWWIDTH is '表单行显示模式';

--IG333
comment on table IG333 is '自定义流程状态定义表';
comment on column IG333.psdid is '流程状态ID';
comment on column IG333.pdid is '流程定义ID';
comment on column IG333.psdname is '状态名称';
comment on column IG333.psddesc is '状态描述';
comment on column IG333.psdcode is '状态标识';
comment on column IG333.fingerPrint is '时间戳';
comment on column IG333.psdtype is '状态类型';
comment on column IG333.psdmode is '状态模式';
comment on column IG333.psdflag is '动态参与者标识';
comment on column IG333.psdassign is '分派参与者类型';
comment on column IG333.psdorg is '分派参与者类型';
comment on column IG333.psdconfirm is '有无确认操作';
comment on column IG333.assignpsdid is '分派节点ID';
comment on column IG333.assignpbdid is '分派按钮ID';
comment on column IG333.assignflag is '是否必须分派标识';
comment on column IG333.participantchange is '参与者是否可改派标识';
comment on column IG333.assignpagetype is '分派页面类型';

--IG258
comment on table IG258 is '自定义流程可分派状态定义表';
comment on column IG258.pspcdid is '自增主键';
comment on column IG258.psdid is '源状态';
comment on column IG258.pspcdpsdid is '可被分派状态';
comment on column IG258.fingerPrint is '时间戳';

--IG211
comment on table IG211 is '自定义流程表单默认值（保留）';
comment on column IG211.psidid is '默认值ID';
comment on column IG211.psdid is '流程状态ID';
comment on column IG211.pidid is '表单定义ID';
comment on column IG211.pidname is '表单标识';
comment on column IG211.pidlabel is '表单显示名称';
comment on column IG211.piddesc is '表单描述';
comment on column IG211.pidtype is '表单类型';
comment on column IG211.pidvalue is '表单值';
comment on column IG211.pidattkey is '附件KEY';
comment on column IG211.fingerPrint is '时间戳';

--IG900
comment on table IG900 is '自定义流程按钮定义表';
comment on column IG900.pbdid is '按钮ID';
comment on column IG900.pbdname is '按钮默认名称';
comment on column IG900.pbdflag is '是否系统保留按钮';
comment on column IG900.pbdimage is '按钮显示图片名称';
comment on column IG900.fingerPrint is '时间戳';

--IG222
comment on table IG222 is '自定义流程参与者定义表';
comment on column IG222.ppdid is '参与者ID';
comment on column IG222.psdid is '流程状态ID';
comment on column IG222.roleid is '角色ID';
comment on column IG222.userid is '默认参与用户ID';
comment on column IG222.ppdsuper is '是否SUPER角色';
comment on column IG222.fingerPrint is '时间戳';

--IG132
comment on table IG132 is '参与者按钮定义信息表';
comment on column IG132.ppbdid is '自增主键';
comment on column IG132.ppdid is '参与者定义ID';
comment on column IG132.pbdid is '按钮定义ID';
comment on column IG132.ppbdname is '按钮显示名称';
comment on column IG132.ppbddesc is '按钮提示信息';
comment on column IG132.ppbdauth is '按钮提交权限';
comment on column IG132.fingerPrint is '时间戳';

--IG881
comment on table Action is '自定义流程参与者变量权限表';
comment on column IG881.pipdid is '参与者变量权限ID';
comment on column IG881.pidid is '表单定义ID';
comment on column IG881.psdid is '流程状态ID';
comment on column IG881.ppdid is '参与者定义ID';
comment on column IG881.pidaccess is '表单权限';
comment on column IG881.fingerPrint is '时间戳';
comment on column IG881.PIDREQUIRED is '是否必填';

--IG273
comment on table IG273 is '自定义流程状态跃迁规则表';
comment on column IG273.ptdid is '跃迁规则ID';
comment on column IG273.fpsdid is '源流程状态ID';
comment on column IG273.tpsdid is '目的流程状态ID';
comment on column IG273.ptdname is '跃迁规则名称';
comment on column IG273.ptddesc is '跃迁规则描述';
comment on column IG273.ptdtype is '跃迁规则类型';
comment on column IG273.ptdcond is '跃迁条件';
comment on column IG273.fingerPrint is '时间戳';

--IG933
comment on table IG933 is '服务工单表';
comment on column IG933.sfid is '服务工单ID';
comment on column IG933.sfreportname is '报告人姓名';
comment on column IG933.sfreportphone is '报告人联系电话';
comment on column IG933.sfreportorgid is '报告人机构层次码';
comment on column IG933.sftitle is '标题';
comment on column IG933.sfdesc is '描述';
comment on column IG933.sfattkey is '附件KEY';
comment on column IG933.sfstatus is '状态';
comment on column IG933.sftype is '分类';
comment on column IG933.sforgid is '登记人机构层次码';
comment on column IG933.sfeiid is '相关资产ID';
comment on column IG933.sfregisterid is '登记人ID';
comment on column IG933.sfinstime is '登记时间';
comment on column IG933.fingerprint is '时间戳';
comment on column IG933.SFCODE is '服务工单编号';
comment on column IG933.SFSOURCE is '来源';
comment on column IG933.SFWORKPHONE is '办公电话';
comment on column IG933.SFEMAIL is '邮箱';

--IG941
comment on table IG941 is '服务工单日志表';
comment on column IG941.sflid is '日志ID';
comment on column IG941.sfid is '服务工单ID';
comment on column IG941.sfluserid is '处理人ID';
comment on column IG941.sfldesc is '处理记录';
comment on column IG941.sflinstime is '处理时间';
comment on column IG941.fingerprint is '时间戳';
comment on column IG941.sflattkey is '附件KEY';

--SmsSendLog
comment on table SmsSendLog is '短信日志表（保留）';
comment on column SmsSendLog.SSLID is '日志ID';
comment on column SmsSendLog.USERNAME is '用户姓名'; 
comment on column SmsSendLog.DEPTMENTNAME is '用户所属机构名称'; 
comment on column SmsSendLog.SENDDATE is '发送日期'; 
comment on column SmsSendLog.USERMOBILE is '发送手机号'; 
comment on column SmsSendLog.SMSTYPE is '日志类型'; 
comment on column SmsSendLog.SENDFLAG is '成功失败标志'; 
comment on column SmsSendLog.FINGERPRINT is '时间戳';

--IG992
comment on table IG992 is '自定义流程外部事件定义表';
comment on column IG992.PEDID is '自增主键';
comment on column IG992.PEDEVENTID is '事件ID';
comment on column IG992.PEDACTION is '处理BL标识';
comment on column IG992.PEDDESC is '描述';
comment on column IG992.FINGERPRINT is '时间戳';

--IG286
comment on table IG286 is '自定义流程表单联动规则定义表';
comment on column IG286.plid is '自增主键';
comment on column IG286.pldpdid is '流程定义ID';
comment on column IG286.pldactionid is '动作ID';
comment on column IG286.initiativepidid is '主动表单定义ID';
comment on column IG286.passivitypidid is '被动表单定义ID';
comment on column IG286.pldesc is '描述';
comment on column IG286.plblname is '处理BL标识';
comment on column IG286.pljsevent is 'JS脚本事件名称';
comment on column IG286.pljtype is '联动规则类型';
comment on column IG286.initiativepidname is '主动表单名称';
comment on column IG286.passivitypidname is '被动表单名称';
comment on column IG286.fingerprint is '时间戳';

--IG413
comment on table IG413 is '自定义流程前后处理事件定义表';
comment on column IG413.pedid is '自增主键';
comment on column IG413.pdid is '流程定义ID';
comment on column IG413.psdid is '流程状态ID';
comment on column IG413.pedactionid is '动作ID';
comment on column IG413.pedtype is '事件类型';
comment on column IG413.pedblid is '处理BL标识';
comment on column IG413.pedorder is '事件执行顺序';
comment on column IG413.pedec is '描述';
comment on column IG413.fingerPrint is '时间戳';

--IG373
comment on table IG373 is '自定义流程表单初始化事件定义表';
comment on column IG373.piidid is '自增主键';
comment on column IG373.pdid is '流程定义ID';
comment on column IG373.psdid is '流程状态ID';
comment on column IG373.piidblid is '处理BL标识';
comment on column IG373.piiddec is '描述';
comment on column IG373.fingerPrint is '时间戳';

--IG126
comment on table IG126 is '自定义流程显示页面定义表';
comment on column IG126.pjdid is '自增主键';
comment on column IG126.pdid is '流程定义ID';
comment on column IG126.pjdtype is '页面类型';
comment on column IG126.pjdblid is '处理BL标识';
comment on column IG126.pjdurl is 'JSP页面路径';
comment on column IG126.fingerPrint is '时间戳';

--IG725
comment on table IG725 is '自定义流程缺省参与者按钮定义表';
comment on column IG725.pdbdid is '自增主键';
comment on column IG725.psdid is '流程状态ID';
comment on column IG725.pbdid is '按钮ID';
comment on column IG725.pdbdname is '按钮显示名称';
comment on column IG725.pdbddesc is '按钮提示信息';
comment on column IG725.pdbdauth is '按钮提交权限';
comment on column IG725.fingerPrint is '时间戳';

--IG711
comment on table IG711 is '自定义流程代办授权表';
comment on column IG711.paid is '自增主键';
comment on column IG711.paiid is '被授权人ID';
comment on column IG711.pauid is '授权人ID';
comment on column IG711.pabegintime is '授权开始时间';
comment on column IG711.paendtime is '授权结束时间';
comment on column IG711.paflag is '是否授权标识';
comment on column IG711.patype is '授权类型';
comment on column IG711.paprocessid is '流程ID';
comment on column IG711.paprocessnum is '流程工单号';
comment on column IG711.palogintime is '授权时间';
comment on column IG711.fingerprint is '时间戳';	
comment on column IG711.remarks is '备注';

--IG699
comment on table IG699 is '自定义流程缺省参与者表单权限表';
comment on column IG699.pdvid is '自增主键';
comment on column IG699.pidid is '表单定义ID';
comment on column IG699.psdid is '流程状态ID';
comment on column IG699.pidaccess is '表单权限';
comment on column IG699.fingerPrint is '时间戳';
comment on column IG699.PIDREQUIRED is '是否必填';

--IG500
comment on table IG500 is '流程工单表';
comment on column IG500.prid is '流程ID';
comment on column IG500.prtype is '流程类型';
comment on column IG500.prsubtype is '流程子类型';
comment on column IG500.prstatus is '流程状态';
comment on column IG500.prsubstatus is '流程子状态';
comment on column IG500.prtitle is '流程标题';
comment on column IG500.prdesc is '流程描述';
comment on column IG500.propentime is '流程发起时间';
comment on column IG500.prclosetime is '流程关闭时间';
comment on column IG500.prplantime is '计划执行时间';
comment on column IG500.prduration is '计划执行周期';
comment on column IG500.prurgency is '紧急程度';
comment on column IG500.primpact is '影响程度';
comment on column IG500.prassetid is '相关资产ID';
comment on column IG500.prassetname is '相关资产名称';
comment on column IG500.prassetcategory is '相关资产类型';
comment on column IG500.prbusiness is '相关业务';
comment on column IG500.primplplan is '执行计划';
comment on column IG500.prbackplan is '恢复计划';
comment on column IG500.prvfyplan is '验证计划';
comment on column IG500.pid is '相关项目ID';
comment on column IG500.pcode is '相关项目编号';
comment on column IG500.pname is '相关项目名称';
comment on column IG500.prinfo is '发起者联系方式';
comment on column IG500.prcorid is '相关流程ID';
comment on column IG500.prcortype is '相关流程类型';
comment on column IG500.prcortitle is '相关流程标题';
comment on column IG500.pruserid is '发起者ID';
comment on column IG500.prusername is '发起者姓名';
comment on column IG500.prroleid is '发起者角色ID';
comment on column IG500.prrolename is '发起者角色名称';
comment on column IG500.prpdid is '流程类型ID';
comment on column IG500.prpdname is '流程类型名称';
comment on column IG500.prorgid is '发起者机构层次码';
comment on column IG500.prorgname is '发起者机构名称';
comment on column IG500.prserialnum is '流程工单号';
comment on column IG500.prfacttime is '实际解决时间';
comment on column IG500.fingerprint is '时间戳';
comment on column IG500.prptdcond is '流程跃迁条件';
comment on column IG500.prstrategyversion is '流程策略版本';
comment on column IG500.prpriority is '优先级';

--IG394
comment on table IG394 is '自定义流程通知日志表';
comment on column IG394.PNSSID is '日志ID';
comment on column IG394.PRID is '流程ID';
comment on column IG394.PSDID is '流程状态ID';
comment on column IG394.PSDCONFIRM is '接单';
comment on column IG394.ROLEID is '通知角色ID';
comment on column IG394.USERID is '通知用户ID';
comment on column IG394.NOTIFYSMSTIME is '短信提醒发送时间';
comment on column IG394.NOTIFYEMAILTIME is '邮件提醒发送时间';
comment on column IG394.REPORTSMSTIME is '短信上报发送时间';
comment on column IG394.REPORTEMAILTIME is '邮件上报发送时间';
comment on column IG394.FINGERPRINT is '时间戳';

--IG337
comment on table IG337 is '流程参与者信息表';
comment on column IG337.ppid is '自增主键';
comment on column IG337.prid is '流程ID';
comment on column IG337.pproleid is '角色ID';
comment on column IG337.pprolename is '角色名称';
comment on column IG337.ppuserid is '用户ID';
comment on column IG337.ppusername is '用户姓名';
comment on column IG337.pporgid is '用户所属机构层次码';
comment on column IG337.pporgname is '用户所属机构名称';
comment on column IG337.pptype is '参与类型';
comment on column IG337.ppuserinfo is '用户信息';
comment on column IG337.ppcomment is '工作评语';
comment on column IG337.ppstatus is '参与状态';
comment on column IG337.ppattkey is '附件KEY';
comment on column IG337.ppinittime is '指定时间';
comment on column IG337.ppproctime is '处理完成时间';
comment on column IG337.ppsubstatus is '子状态';
comment on column IG337.ppfacttime is '实际解决时间';
comment on column IG337.ppbacktime is '流程回退指定时间';
comment on column IG337.fingerprint is '时间戳';
comment on column IG337.ppproxyuserid is '代理用户ID';
comment on column IG337.ppsuper is '是否SUPER角色';
comment on column IG337.pprolemanager is '是否角色负责人';
comment on column IG337.ppdutyperson is '是否值班人';
comment on column IG337.pbdid is '流程按钮ID';

--IG599
comment on table IG599 is '流程表单信息表';
comment on column IG599.piid is '自增主键';
comment on column IG599.prid is '流程ID';
comment on column IG599.pivarname is '表单标识';
comment on column IG599.pivarlabel is '表单显示名称';
comment on column IG599.pivartype is '表单类型';
comment on column IG599.pivarvalue is '表单值';
comment on column IG599.piattkey is '附件KEY';
comment on column IG599.fingerprint is '时间戳';
comment on column IG599.pidid is '表单定义ID';
comment on column IG599.PIDMODE is '表单模式';
comment on column IG599.PRIVATESCOPE is '私有表单权限范围';

--Attachment
comment on table Attachment is '附件表';
comment on column Attachment.attid is '自增主键';
comment on column Attachment.attkey is '附件KEY';
comment on column Attachment.attname is '附件名称';
comment on column Attachment.attdesc is '说明';
comment on column Attachment.atturl is '分类标识';
comment on column Attachment.fingerprint is '时间戳';

--IG036
comment on table Action is '流程日志表';
comment on column IG036.rlid is '日志ID';
comment on column IG036.prid is '流程ID';
comment on column IG036.rltime is '处理时间';
comment on column IG036.roleid is '处理角色ID';
comment on column IG036.rlrolename is '处理角色名称';
comment on column IG036.rluserid is '处理用户ID';
comment on column IG036.rlusername is '处理用户名称';
comment on column IG036.rltype is '日志类型';
comment on column IG036.rldesc is '日志描述';
comment on column IG036.rlcomment is '处理内容';
comment on column IG036.rlattkey is '附件KEY';
comment on column IG036.rlorgid is '处理用户所属机构层次码';
comment on column IG036.rlorgname is '处理用户所属机构名称';
comment on column IG036.fingerprint is '时间戳';
comment on column IG036.psname is '流程状态名称';
comment on column IG036.psdcode is '流程状态标识';
comment on column IG036.rolemanger is '是否角色负责人';
comment on column IG036.pbdid is '流程按钮ID';

--IG715
comment on table IG715 is '流程与服务工单关联表';
comment on column IG715.sprrid is '自增主键';
comment on column IG715.sprrsfid is '服务工单ID';
comment on column IG715.sprrprid is '流程ID';
comment on column IG715.sprrinstime is '登记时间';
comment on column IG715.fingerprint is '时间戳';

--IG113
comment on table IG113 is '流程表单日志表';
comment on column IG113.rlvid is '自增主键';
comment on column IG113.rlid is '流程日志ID';
comment on column IG113.piid is '流程表单ID';
comment on column IG113.prid is '流程ID';
comment on column IG113.pivarname is '表单标识';
comment on column IG113.pivarlabel is '表单显示名称';
comment on column IG113.pivartype is '表单类型';
comment on column IG113.pivarvalue is '表单值';
comment on column IG113.piattkey is '附件KEY';
comment on column IG113.pidid is '表单定义ID';
comment on column IG113.pishowvarname is '表单显示名称';
comment on column IG113.fingerprint is '时间戳';

--SdlInfo
comment on table SdlInfo is '服务水平信息表';
comment on column SdlInfo.siid is '自增主键';
comment on column SdlInfo.sitype is '类别';
comment on column SdlInfo.sibegin is '开始时间';
comment on column SdlInfo.simark is '评分';
comment on column SdlInfo.sieiid is '相关资产ID';
comment on column SdlInfo.sieiname is '相关资产名称';
comment on column SdlInfo.siprid is '相关事件流程ID';
comment on column SdlInfo.siprtitle is '相关事件流程标题';
comment on column SdlInfo.sidesc is '描述';
comment on column SdlInfo.siend is '结束时间';
comment on column SdlInfo.siattkey is '附件KEY';
comment on column SdlInfo.sifacttime is '实际时间';
comment on column SdlInfo.sidate is '登记时间';
comment on column SdlInfo.fingerprint is '时间戳';

--SdlDefineInfo
comment on table SdlDefineInfo is '服务水平目标信息表';
comment on column SdlDefineInfo.sdiid is '自增主键';
comment on column SdlDefineInfo.sdiyear is '登记年度';
comment on column SdlDefineInfo.sdieiid is '相关资产ID';
comment on column SdlDefineInfo.sdieiname is '相关资产名称';
comment on column SdlDefineInfo.sdibreakm is '月中断时间';
comment on column SdlDefineInfo.sdibreaky is '年中断时间';
comment on column SdlDefineInfo.sdicontinuousm is '月连续时间百分比';
comment on column SdlDefineInfo.sdicontinuousy is '年连续时间百分比';
comment on column SdlDefineInfo.sdiimpactm is '月影响时间';
comment on column SdlDefineInfo.sdiimpacty is '年影响时间';
comment on column SdlDefineInfo.sdisteadym is '月稳定时间百分比';
comment on column SdlDefineInfo.sdisteadyy is '年稳定时间百分比';
comment on column SdlDefineInfo.sdisafecasem is '月安全事件个数';
comment on column SdlDefineInfo.sdisafecasey is '年安全事件个数';
comment on column SdlDefineInfo.sdisafemarkm is '月安全事件评分';
comment on column SdlDefineInfo.sdisafemarky is '年安全事件评分';
comment on column SdlDefineInfo.sdiriskmarkm is '月风险检查评分';
comment on column SdlDefineInfo.sdiriskmarky is '年风险检查评分';
comment on column SdlDefineInfo.sdicapacitycasem is '月容量事件个数';
comment on column SdlDefineInfo.sdicapacitycasey is '年容量事件个数';
comment on column SdlDefineInfo.sdicapacitymarkm is '月容量事件评分';
comment on column SdlDefineInfo.sdicapacitymarky is '年容量事件评分';
comment on column SdlDefineInfo.fingerprint is '时间戳';

--Project
comment on table Project is '项目表';
comment on column Project.pid is '项目ID';
comment on column Project.ptype is '项目类型';
comment on column Project.pcode is '项目编号';
comment on column Project.pname is '项目名称';
comment on column Project.pdesc is '项目说明';
comment on column Project.pinfo is '（保留）';
comment on column Project.popentime is '项目开始时间';
comment on column Project.pclosetime is '项目结束时间';
comment on column Project.pstatus is '项目状态';
comment on column Project.porg is '登记人所属机构层次码（前两级）';
comment on column Project.prole is '项目负责人';
comment on column Project.puser is '项目参与者';
comment on column Project.fingerprint is '时间戳';

--ProjectPlan
comment on table ProjectPlan is '项目计划表';
comment on column ProjectPlan.pplid is '计划ID';
comment on column ProjectPlan.pid is '项目ID';
comment on column ProjectPlan.pplinfo is '信息';
comment on column ProjectPlan.pplversion is '版本';
comment on column ProjectPlan.pplstatus is '状态';
comment on column ProjectPlan.ppldesc is '描述';
comment on column ProjectPlan.ppldate is '登记时间';
comment on column ProjectPlan.fingerprint is '时间戳';

--ProjectLog
comment on table ProjectLog is '项目日志表';
comment on column ProjectLog.plid is '日志ID';
comment on column ProjectLog.pid is '项目ID';
comment on column ProjectLog.plroleid is '（保留字段）';
comment on column ProjectLog.plrolename is '（保留字段）';
comment on column ProjectLog.pluserid is '用户ID';
comment on column ProjectLog.plusername is '用户姓名';
comment on column ProjectLog.plinfo is '内容';
comment on column ProjectLog.pltype is '类型';
comment on column ProjectLog.pltime is '登记时间';
comment on column ProjectLog.plattkey is '附件KEY';
comment on column ProjectLog.fingerprint is '时间戳';

--Budget
comment on table Budget is '预算表';
comment on column Budget.bid is '预算ID';
comment on column Budget.btype is '预算类型';
comment on column Budget.binittime is '（保留）';
comment on column Budget.bopentime is '开始时间';
comment on column Budget.bstatus is '状态';
comment on column Budget.breqid is '（保留）';
comment on column Budget.bapvid is '（保留）';
comment on column Budget.btitle is '预算名称';
comment on column Budget.bclosetime is '关闭时间';
comment on column Budget.bdesc is '预算说明';
comment on column Budget.binfo is '（保留）';
comment on column Budget.byear is '预算年度';
comment on column Budget.borgid is '（保留）';
comment on column Budget.borgname is '（保留）';
comment on column Budget.breqname is '登记人名称';
comment on column Budget.bapvname is '（保留）';
comment on column Budget.bamount is '金额';
comment on column Budget.battkey is '附件KEY';
comment on column Budget.pid is '相关项目';
comment on column Budget.pcode is '相关项目编号';
comment on column Budget.pname is '相关项目名称';
comment on column Budget.fingerprint is '时间戳';

--Expense
comment on table Expense is '费用表';
comment on column Expense.exid is '费用ID';
comment on column Expense.bid is '预算ID';
comment on column Expense.exdesc is '费用说明';
comment on column Expense.examount is '费用金额';
comment on column Expense.exinfo is '（保留）';
comment on column Expense.exstatus is '费用状态';
comment on column Expense.exreqid is '（保留）';
comment on column Expense.exreqname is '（保留）';
comment on column Expense.exinittime is '（保留）';
comment on column Expense.exopentime is '开始时间';
comment on column Expense.exapvid is '（保留）';
comment on column Expense.exapvname is '费用名称';
comment on column Expense.exclosetime is '结束时间';
comment on column Expense.exattkey is '附件KEY';
comment on column Expense.exeiinfo is '（保留）';
comment on column Expense.exprinfo is '（保留）';
comment on column Expense.expinfo is '（保留）';
comment on column Expense.exorginfo is '（保留）';
comment on column Expense.btitle is '预算名称';
comment on column Expense.fingerprint is '时间戳';

--QuartzJobs
comment on table QuartzJobs is '定时任务表';
comment on column QuartzJobs.qjid is '自增主键';
comment on column QuartzJobs.qjname is '任务名称';
comment on column QuartzJobs.qjdesc is '任务描述';
comment on column QuartzJobs.qjtriname is '触发器名称';
comment on column QuartzJobs.qjtrigrp is '触发器所属组名称';
comment on column QuartzJobs.qjtricron is 'QUARTZ表达式';
comment on column QuartzJobs.qjcrtuser is '创建人ID';
comment on column QuartzJobs.qjimpluser is '执行人ID';
comment on column QuartzJobs.qjcrttime is '创建时间';
comment on column QuartzJobs.qjendtime is '结束时间';
comment on column QuartzJobs.qjtype is '类型';
comment on column QuartzJobs.qjstatus is '状态';
comment on column QuartzJobs.qjinfo is '备注';
comment on column QuartzJobs.qjcrtusername is '创建人姓名';
comment on column QuartzJobs.qjimplusername is '执行人姓名';
comment on column QuartzJobs.qjperiodinfo is '周期类型';
comment on column QuartzJobs.qjorgid is '执行人所属机构层次码';
comment on column QuartzJobs.qjorgname is '执行人所属机构名称';
comment on column QuartzJobs.qjassetid is '相关资产ID';
comment on column QuartzJobs.qjassettypeid is '相关资产所属模型层次码';
comment on column QuartzJobs.fingerprint is '时间戳';

--QuartzProcessRecord
comment on table QuartzProcessRecord is '定时流程基本信息表';
comment on column QuartzProcessRecord.qprid is '定时流程ID';
comment on column QuartzProcessRecord.qprtype is '流程模版类型';
comment on column QuartzProcessRecord.qprsubtype is '流程子类型';
comment on column QuartzProcessRecord.qprstatus is '流程状态';
comment on column QuartzProcessRecord.qprsubstatus is '流程子状态';
comment on column QuartzProcessRecord.qprtitle is '流程标题';
comment on column QuartzProcessRecord.qprdesc is '流程描述';
comment on column QuartzProcessRecord.qpropentime is '建立时间';
comment on column QuartzProcessRecord.qprclosetime is '关闭时间';
comment on column QuartzProcessRecord.qprplantime is '计划执行时间';
comment on column QuartzProcessRecord.qprduration is '计划执行周期';
comment on column QuartzProcessRecord.qprurgency is '紧急程度';
comment on column QuartzProcessRecord.qprimpact is '影响程度';
comment on column QuartzProcessRecord.qprassetid is '相关资产ID';
comment on column QuartzProcessRecord.qprassetname is '相关资产名称';
comment on column QuartzProcessRecord.qprassetcategory is '相关资产类型';
comment on column QuartzProcessRecord.qprbusiness is '相关业务';
comment on column QuartzProcessRecord.qprimplplan is '执行计划';
comment on column QuartzProcessRecord.qprbackplan is '恢复计划';
comment on column QuartzProcessRecord.qprvfyplan is '验证计划';
comment on column QuartzProcessRecord.qpid is '相关项目ID';
comment on column QuartzProcessRecord.qpcode is '相关项目编号';
comment on column QuartzProcessRecord.qpname is '相关项目名称';
comment on column QuartzProcessRecord.qprinfo is '发起者联系方式';
comment on column QuartzProcessRecord.qprcorid is '相关流程ID';
comment on column QuartzProcessRecord.qprcortype is '相关流程类型';
comment on column QuartzProcessRecord.qprcortitle is '相关流程标题';
comment on column QuartzProcessRecord.qpruserid is '发起者ID';
comment on column QuartzProcessRecord.qprusername is '发起者姓名';
comment on column QuartzProcessRecord.qprroleid is '发起者角色ID';
comment on column QuartzProcessRecord.qprrolename is '发起者角色名称';
comment on column QuartzProcessRecord.qprpdid is '流程类型ID';
comment on column QuartzProcessRecord.qprpdname is '流程类型名称';
comment on column QuartzProcessRecord.qprorgid is '发起者所属机构层次码';
comment on column QuartzProcessRecord.qprorgname is '发起者所属机构名称';
comment on column QuartzProcessRecord.fingerprint is '时间戳';
comment on column QuartzProcessRecord.qprattkey is '附件KEY';

--QuartzProcessParticipant
comment on table QuartzProcessParticipant is '定时流程参与者信息表';
comment on column QuartzProcessParticipant.qppid is '自增主键';
comment on column QuartzProcessParticipant.qprid is '定时流程ID';
comment on column QuartzProcessParticipant.qpproleid is '角色ID';
comment on column QuartzProcessParticipant.qpprolename is '角色名称';
comment on column QuartzProcessParticipant.qppuserid is '用户ID';
comment on column QuartzProcessParticipant.qppusername is '用户姓名';
comment on column QuartzProcessParticipant.qpporgid is '用户所属机构层次码';
comment on column QuartzProcessParticipant.qpporgname is '用户所属机构名称';
comment on column QuartzProcessParticipant.qpptype is '参与类型';
comment on column QuartzProcessParticipant.qppsubstatus is '子状态';
comment on column QuartzProcessParticipant.qppuserinfo is '用户信息';
comment on column QuartzProcessParticipant.qppcomment is '工作评语';
comment on column QuartzProcessParticipant.qppstatus is '参与状态';
comment on column QuartzProcessParticipant.qppattkey is '附件KEY';
comment on column QuartzProcessParticipant.qppinittime is '指定时间';
comment on column QuartzProcessParticipant.qppproctime is '处理完成时间';
comment on column QuartzProcessParticipant.fingerprint is '时间戳';

--QuartzProcessInfo
comment on table QuartzProcessInfo is '定时流程表单信息表';
comment on column QuartzProcessInfo.qpiid is '自增主键';
comment on column QuartzProcessInfo.qprid is '定时流程ID';
comment on column QuartzProcessInfo.qpivarname is '表单标识';
comment on column QuartzProcessInfo.qpivarlabel is '表单显示名称';
comment on column QuartzProcessInfo.qpivartype is '表单类型';
comment on column QuartzProcessInfo.qpivarvalue is '表单值';
comment on column QuartzProcessInfo.qpiattkey is '附件KEY';
comment on column QuartzProcessInfo.fingerprint is '时间戳';
comment on column QuartzProcessInfo.qpidid is '表单定义ID';

--Notification
comment on table Notification is '系统集成（保留）';

--RiskAudit
comment on table RiskAudit is '风险审计表';
comment on column RiskAudit.raid is '审计ID';
comment on column RiskAudit.raversion is '审计版本';
comment on column RiskAudit.radate is '创建日期';
comment on column RiskAudit.rauserid is '创建人ID';
comment on column RiskAudit.rausername is '创建人姓名';
comment on column RiskAudit.racode is '版本编号';
comment on column RiskAudit.radesc is '描述';
comment on column RiskAudit.rastatus is '状态';
comment on column RiskAudit.fingerprint is '时间戳';

--RiskAuditDef
comment on table RiskAuditDef is '风险审计项信息表';
comment on column RiskAuditDef.radid is '审计项ID';
comment on column RiskAuditDef.raid is '审计ID';
comment on column RiskAuditDef.raversion is '审计版本';
comment on column RiskAuditDef.radname is '审计项名称';
comment on column RiskAuditDef.radcode is '层次码';
comment on column RiskAuditDef.radlevel is '级次';
comment on column RiskAuditDef.radparcode is '上级层次码';
comment on column RiskAuditDef.raddesc is '描述';
comment on column RiskAuditDef.radrisklevel is '风险程度';
comment on column RiskAuditDef.raduserid is '责任人ID';
comment on column RiskAuditDef.radusername is '责任人姓名';
comment on column RiskAuditDef.radorg is '责任部门名称';
comment on column RiskAuditDef.radorgcoding is '责任部门层次码';
comment on column RiskAuditDef.radstatus is '状态';
comment on column RiskAuditDef.radmode is '控制手段';
comment on column RiskAuditDef.radtype is '控制类型';
comment on column RiskAuditDef.radfrequency is '控制频率';
comment on column RiskAuditDef.fingerprint is '时间戳';

--RiskAuditIns
comment on table RiskAuditIns is '风险审计实例表';
comment on column RiskAuditIns.raiid is '实例ID';
comment on column RiskAuditIns.raid is '审计ID';
comment on column RiskAuditIns.raversion is '审计版本';
comment on column RiskAuditIns.raicode is '审计编号';
comment on column RiskAuditIns.raistart is '创建日期';
comment on column RiskAuditIns.raiend is '结束日期';
comment on column RiskAuditIns.raidesc is '描述';
comment on column RiskAuditIns.raistatus is '状态';
comment on column RiskAuditIns.fingerprint is '时间戳';

--RiskAuditResult
comment on table RiskAuditResult is '风险审计评估表';
comment on column RiskAuditResult.rarid is '评估ID';
comment on column RiskAuditResult.raiid is '审计实例ID';
comment on column RiskAuditResult.radid is '审计项ID';
comment on column RiskAuditResult.rardate is '评估日期';
comment on column RiskAuditResult.raruserid is '评估用户ID';
comment on column RiskAuditResult.rarusername is '评估用户姓名';
comment on column RiskAuditResult.rarplanscore is '评估制度建设评分';
comment on column RiskAuditResult.rarplandesc is '评估制度建设评价';
comment on column RiskAuditResult.rarexecscore is '评估制度执行评分';
comment on column RiskAuditResult.rarexecdesc is '评估制度执行评价';
comment on column RiskAuditResult.raroverallscore is '评估总体评分';
comment on column RiskAuditResult.raroveralldesc is '评估总体评价';
comment on column RiskAuditResult.rarcomment is '评估意见';
comment on column RiskAuditResult.fingerprint is '时间戳';
comment on column RiskAuditResult.radcode is '审计项层次码';

--RiskCheck
comment on table RiskCheck is '风险检查表';
comment on column RiskCheck.rcid is '检查ID';
comment on column RiskCheck.rcname is '检查名称';
comment on column RiskCheck.rcdesc is '描述';
comment on column RiskCheck.rctype is '重要程度';
comment on column RiskCheck.rcstatus is '状态';
comment on column RiskCheck.rcstartdate is '开始日期';
comment on column RiskCheck.rcenddate is '结束日期';
comment on column RiskCheck.rcfrequency is '频率';
comment on column RiskCheck.rccron is '策略执行表达式';
comment on column RiskCheck.rcuserid is '责任人ID';
comment on column RiskCheck.rcusername is '责任人姓名';
comment on column RiskCheck.rcroleid is '责任组角色ID';
comment on column RiskCheck.rcrolename is '责任组角色名称';
comment on column RiskCheck.rcasset is '相关资产ID';
comment on column RiskCheck.rcassetname is '相关资产名称';
comment on column RiskCheck.rcattch is '附件KEY';
comment on column RiskCheck.rcoption is '选项';
comment on column RiskCheck.fingerprint is '时间戳';

--RiskCheckResult
comment on table RiskCheckResult is '风险检查结果表';
comment on column RiskCheckResult.rcrid is '结果ID';
comment on column RiskCheckResult.rcid is '检查ID';
comment on column RiskCheckResult.rcrplandate is '计划检查日期';
comment on column RiskCheckResult.rcrrealtime is '实际检查时间';
comment on column RiskCheckResult.rcruserid is '结果提交人ID';
comment on column RiskCheckResult.rcrusername is '结果提交人姓名';
comment on column RiskCheckResult.rcrresult is '检查结果';
comment on column RiskCheckResult.rcrcomment is '说明';
comment on column RiskCheckResult.rcrattch is '附件KEY';
comment on column RiskCheckResult.fingerprint is '时间戳';
comment on column RiskCheckResult.rctype is '重要程度';

--AuditCheckRelation
comment on table AuditCheckRelation is '风险检查与风险审计关系表';
comment on column AuditCheckRelation.acrid is '自增主键';
comment on column AuditCheckRelation.rcid is '检查ID';
comment on column AuditCheckRelation.radid is '审计项ID';
comment on column AuditCheckRelation.radcode is '审计项层次码';
comment on column AuditCheckRelation.fingerprint is '时间戳';

--DUTYAUDITDEF
comment on table DUTYAUDITDEF is '值班检查项定义表';
comment on column DUTYAUDITDEF.DADID is '检查项ID';
comment on column DUTYAUDITDEF.DADCATEGORY is '值班类型';
comment on column DUTYAUDITDEF.DADTYPE is '分类';
comment on column DUTYAUDITDEF.DADNAME is '检查名称';
comment on column DUTYAUDITDEF.DADLIMTIME is '填报时间限制';
comment on column DUTYAUDITDEF.DADCONTENT is '检查内容';
comment on column DUTYAUDITDEF.DADINFO is '说明';
comment on column DUTYAUDITDEF.DADSTATUS is '状态';
comment on column DUTYAUDITDEF.DADUSERID is '更新人ID';
comment on column DUTYAUDITDEF.DADUSERNAME is '更新人姓名';
comment on column DUTYAUDITDEF.DADUPDTIME is '更新时间';
comment on column DUTYAUDITDEF.DADORDERBY is '排序标识';
comment on column DUTYAUDITDEF.PERIODTYPE is '周期类型';
comment on column DUTYAUDITDEF.PERIODVALUE is '周期时间';
comment on column DUTYAUDITDEF.FINGERPRINT is '时间戳';

--DUTYAUDITTIME
comment on table DUTYAUDITTIME is '值班检查项检查时间表';
comment on column DUTYAUDITTIME.DATID is '自增主键';
comment on column DUTYAUDITTIME.DADID is '检查项ID';
comment on column DUTYAUDITTIME.DATTIME is '检查项时间';
comment on column DUTYAUDITTIME.DATLIMTIME is '限制时间';
comment on column DUTYAUDITTIME.FINGERPRINT is '时间戳';

--DUTYPLAN
comment on table DUTYPLAN is '值班计划表';
comment on column DUTYPLAN.DPID is '值班计划ID';
comment on column DUTYPLAN.DADCATEGORY is '值班类型';
comment on column DUTYPLAN.DPTIME is '值班日期';
comment on column DUTYPLAN.DPTYPE is '值班类型';
comment on column DUTYPLAN.DPSTATUS is '状态';
comment on column DUTYPLAN.DPQUESTION is '遗留问题';
comment on column DUTYPLAN.DPINFO is '总结';
comment on column DUTYPLAN.DPUSERID is '交班人ID';
comment on column DUTYPLAN.DPUSERNAME is '交班人姓名';
comment on column DUTYPLAN.DPCRETIME is '登记时间';
comment on column DUTYPLAN.DPUPDTIME is '更新时间';
comment on column DUTYPLAN.DPFINTIME is '交班时间';
comment on column DUTYPLAN.DPREMARKS is '备注';
comment on column DUTYPLAN.FINGERPRINT is '时间戳';

--DUTYPERSON
comment on table DUTYPERSON is '值班人表';
comment on column DUTYPERSON.DPERID is '自增主键';
comment on column DUTYPERSON.DPID is '值班计划ID';
comment on column DUTYPERSON.DPERTIME is '值班日期';
comment on column DUTYPERSON.DPTYPE is '值班类型';
comment on column DUTYPERSON.DPERUSERID is '值班人ID';
comment on column DUTYPERSON.DPERUSERNAME is '值班人姓名';
comment on column DUTYPERSON.FINGERPRINT is '记录时间戳';

--DUTYRESULT
comment on table DUTYRESULT is '值班检查结果表';
comment on column DUTYRESULT.DRID is '结果ID';
comment on column DUTYRESULT.DPID is '值班计划ID';
comment on column DUTYRESULT.DADID is '检查项ID';
comment on column DUTYRESULT.DADCATEGORY is '值班类型';
comment on column DUTYRESULT.DADTYPE is '检查分类';
comment on column DUTYRESULT.DADNAME is '检查名称';
comment on column DUTYRESULT.DPTIME is '值班日期';
comment on column DUTYRESULT.DPTYPE is '值班类型';
comment on column DUTYRESULT.DATTIME is '检查时间';
comment on column DUTYRESULT.DATLIMTIME is '填报时间限制';
comment on column DUTYRESULT.DADCONTENT is '检查内容';
comment on column DUTYRESULT.DRCONTENT is '检查结果';
comment on column DUTYRESULT.DRFILLTIME is '填报时间（小时分）';
comment on column DUTYRESULT.DRRESULT is '结果说明';
comment on column DUTYRESULT.DRUSERID is '填报人ID';
comment on column DUTYRESULT.DRUSERNAME is '填报人姓名';
comment on column DUTYRESULT.DRCRETIME is '填报时间';
comment on column DUTYRESULT.drlimdtime is '填报日/时限制';
comment on column DUTYRESULT.FINGERPRINT is '时间戳';

--IG512
comment on table IG512 is '流程关联关系表';
comment on column IG512.prrid is '自增主键';
comment on column IG512.parprid is '流程ID（主动）';
comment on column IG512.cldprid is '流程ID（被动）';
comment on column IG512.prrinstime is '创建时间';
comment on column IG512.fingerprint is '时间戳';

--ReportFileDefinition
comment on table ReportFileDefinition is '报表定义表';
comment on column ReportFileDefinition.rfdid is '报表ID';
comment on column ReportFileDefinition.rfdtitle is '报表名称';
comment on column ReportFileDefinition.rfdtype is '报表分类';
comment on column ReportFileDefinition.rfddesc is '报表说明';
comment on column ReportFileDefinition.rfdfilename is '报表文件名';
comment on column ReportFileDefinition.rfduserid is '登记人ID';
comment on column ReportFileDefinition.rfdusername is '登记人姓名';
comment on column ReportFileDefinition.rfdinstime is '登记时间';
comment on column ReportFileDefinition.rfdversion is '当前版本';
comment on column ReportFileDefinition.rfdnewversion is '最新版本';
comment on column ReportFileDefinition.rfdpictype is '报表样式';
comment on column ReportFileDefinition.fingerprint is '时间戳';
comment on column ReportFileDefinition.rfdparameters is '报表参数';

--ReportFileVersion
comment on table ReportFileVersion is '报表版本表';
comment on column ReportFileVersion.rfvid is '自增主键';
comment on column ReportFileVersion.rfdid is '报表ID';
comment on column ReportFileVersion.rfvversion is '版本';
comment on column ReportFileVersion.rfvinstime is '创建时间';
comment on column ReportFileVersion.fingerprint is '时间戳';

--IG224
comment on table IG224 is '流程状态日志表';
comment on column IG224.rslid is '自增主键';
comment on column IG224.prid is '流程ID';
comment on column IG224.prpdid is '流程类型ID';
comment on column IG224.prtype is '流程模版类型';
comment on column IG224.prstatus is '流程状态';
comment on column IG224.rslopentime is '开始时间';
comment on column IG224.rslclosetime is '结束时间';
comment on column IG224.rslExpect is '是否超时';
comment on column IG224.fingerprint is '时间戳';

--IG899
comment on table IG899 is '流程私有表单表';
comment on column IG899.PPIID is '自增主键';
comment on column IG899.PIDID is '表单定义ID';
comment on column IG899.PIID is '流程表单ID';
comment on column IG899.ROLEID is '处理角色ID';
comment on column IG899.USERID is '处理人ID';
comment on column IG899.PPIVALUE is '表单值';
comment on column IG899.PPIATTKEY is '附件KEY';
comment on column IG899.FINGERPRINT is '时间戳';

--IG463
comment on table IG463 is '流程代办授权工作表';
comment on column IG463.ppwid is '自增主键';
comment on column IG463.ppwprid is '流程ID';
comment on column IG463.ppwprtype is '流程模版类型';
comment on column IG463.ppwprserialnum is '流程工单号';
comment on column IG463.ppwprtitle is '流程标题';
comment on column IG463.ppwauthorizeuserid is '授权人ID';
comment on column IG463.ppwproxyuserid is '代理人ID';
comment on column IG463.ppwproxyusername is '代理人姓名';
comment on column IG463.ppwoptiontime is '代理人处理时间';
comment on column IG463.ppwcloseflag is '是否关闭';
comment on column IG463.fingerPrint is '时间戳';

--IG213
comment on table IG213 is '自定义流程角色范围表';
comment on column IG213.prtdid is '自增主键';
comment on column IG213.pdid is '流程类型ID';
comment on column IG213.roletype is '角色类型';
comment on column IG213.fingerprint is '时间戳';

--IG243
comment on table IG243 is '自定义流程标题定义表';
comment on column IG243.ptdid is '自增主键';
comment on column IG243.pdid is '流程类型ID';
comment on column IG243.ptitlename is '标题表单显示名称';
comment on column IG243.ptitleaccess is '标题表单是否可见';
comment on column IG243.pdescname is '描述表单显示名称';
comment on column IG243.pdescaccess is '描述表单是否可见';
comment on column IG243.fingerprint is '时间戳';

--IG298
comment on table IG298 is '自定义流程状态可分派角色定义表';
comment on column IG298.psrdid is '自增主键';
comment on column IG298.psdid is '流程状态ID';
comment on column IG298.roleid is '角色ID';
comment on column IG298.fingerprint is '时间戳';

--IG156
comment on table IG156 is '自定义流程状态按钮事件定义表';
comment on column IG156.PSEID is '自增主键';
comment on column IG156.PDID is '流程类型ID'; 
comment on column IG156.PSDID is '流程状态ID';
comment on column IG156.PSEBUTTONID is '按钮ID';
comment on column IG156.PSEACTIONID is '处理BL标识';
comment on column IG156.PSEORDER is '执行顺序'; 
comment on column IG156.PSEDEC is '描述';
comment on column IG156.PSBDNAME is '按钮名称';
comment on column IG156.FINGERPRINT is '时间戳';

--IG212
comment on table IG212 is '自定义流程通知策略定义表';
comment on column IG212.PSDID is '流程状态ID';
comment on column IG212.PSDCONFIRM is '是否确认状态';
comment on column IG212.SMS is '是否发送短信';
comment on column IG212.EMAIL is '是否发送邮件';
comment on column IG212.NOTIFYD is '再次提醒时间（天）';
comment on column IG212.NOTIFYH is '再次提醒时间（小时）';
comment on column IG212.NOTIFYM is '再次提醒时间（分）';
comment on column IG212.REPORTD is '上报时间（天）';
comment on column IG212.REPORTH is '上报时间（小时）';
comment on column IG212.REPORTM is '上报时间（分）';
comment on column IG212.ROLEMANAGER is '通知人类型';
comment on column IG212.FINGERPRINT is '时间戳';

--IG237
comment on table IG237 is '自定义流程策略通知人定义表';
comment on column IG237.PSDID is '流程状态ID';
comment on column IG237.PSDCONFIRM is '是否确认状态';
comment on column IG237.USERID is '用户ID';
comment on column IG237.ROLEID is '角色ID';
comment on column IG237.FINGERPRINT is '时间戳';

--IG202
comment on table IG202 is '流程通用表单定义表';
comment on column IG202.PIDID is '表单定义ID'; 
comment on column IG202.PIDNAME is '表单标识';
comment on column IG202.PIDLABEL is '表单显示名称'; 
comment on column IG202.PIDDESC is '表单描述';
comment on column IG202.PIDTYPE is '表单类型'; 
comment on column IG202.PIDOPTION is '表单取值范围';
comment on column IG202.PIDDEFAULT is '表单默认值'; 
comment on column IG202.PIDREQUIRED is '是否必填'; 
comment on column IG202.PIDSORTID is '排序标识'; 
comment on column IG202.CCID is '树型数据分类ID';
comment on column IG202.PIDMODE is '表单模式';
comment on column IG202.PRIVATESCOPE is '私有表单权限范围';
comment on column IG202.ROWWIDTH is '表单行显示模式';
comment on column IG202.FINGERPRINT is '时间戳';

--CUSTOMREPORT
comment on table CUSTOMREPORT is '定制报表信息表';
comment on column CUSTOMREPORT.CRID is '自增主键'; 
comment on column CUSTOMREPORT.USERID is '定制用户ID';
comment on column CUSTOMREPORT.RFDID is '报表ID';
comment on column CUSTOMREPORT.ORDERNUM is '排序标识';
comment on column CUSTOMREPORT.FINGERPRINT is '时间戳'; 

--ROLEREPORT
comment on table ROLEREPORT is '报表授权信息表';
comment on column ROLEREPORT.RRID is '自增主键'; 
comment on column ROLEREPORT.ROLEID is '角色ID';  
comment on column ROLEREPORT.RFDID is '报表ID'; 
comment on column ROLEREPORT.RRPERM is '权限（保留）'; 
comment on column ROLEREPORT.RRDESC is '说明（保留）'; 
comment on column ROLEREPORT.FINGERPRINT is '时间戳';

--SEQUENCE_GENERATOR_TABLE
comment on table SEQUENCE_GENERATOR_TABLE is '主键序列表';
comment on column SEQUENCE_GENERATOR_TABLE.SEQUENCE_NAME is '序列标识';
comment on column SEQUENCE_GENERATOR_TABLE.SEQUENCE_VALUE is '序列值';

--HOTLINK
comment on table HOTLINK is '常用链接';
comment on column HOTLINK.hid is '自增主键';
comment on column HOTLINK.userid is '用户ID';
comment on column HOTLINK.hname is '链接显示名称';
comment on column HOTLINK.hlink is '链接URL';
comment on column HOTLINK.horder is '显示顺序';
comment on column HOTLINK.fingerprint is '时间戳';

--IG731
comment on table IG731 is '流程相关资产关联表';
comment on column IG731.pieid is '自增主键';
comment on column IG731.prid is '流程ID';
comment on column IG731.piid is '流程表单ID';
comment on column IG731.eiid is '资产ID';
comment on column IG731.fingerprint is '时间戳';

--QuartzProcessInfoEntity
comment on table QuartzProcessInfoEntity is '定时流程相关资产关联表';
comment on column QuartzProcessInfoEntity.qpieid is '自增主键';
comment on column QuartzProcessInfoEntity.qprid is '流程ID';
comment on column QuartzProcessInfoEntity.qpiid is '流程表单ID';
comment on column QuartzProcessInfoEntity.qeiid is '资产ID';
comment on column QuartzProcessInfoEntity.fingerprint is '时间戳';

--QuartzJobDetails
comment on table QuartzJobDetails is '日常运维计划信息表';
comment on column QuartzJobDetails.qjdid is '自增主键';
comment on column QuartzJobDetails.qjid is '定时任务ID';
comment on column QuartzJobDetails.qjdtriname is '触发器名称';
comment on column QuartzJobDetails.qjdtrigrpname is '触发器所属组名称';
comment on column QuartzJobDetails.qjdtime is '执行时间';
comment on column QuartzJobDetails.qjdweek is '星期几';
comment on column QuartzJobDetails.qjdtype is '执行状态';
comment on column QuartzJobDetails.FINGERPRINT is '时间戳';

--IG433
comment on table IG433 is '流程评审信息表';
comment on column IG433.paid is '自增主键';
comment on column IG433.paprid is '流程ID';
comment on column IG433.pauserid is '评审人ID';
comment on column IG433.paprname is '流程标题';
comment on column IG433.paassessmentdes is '评审内容';
comment on column IG433.paassessmentdate is '评审时间';
comment on column IG433.paeventtypecode is '事件类别';
comment on column IG433.PAATTKEY is '附件KEY';
comment on column IG433.PASTATUS is '状态';
comment on column IG433.fingerprint is '时间戳';

--IG229
comment on table IG229 is '流程影响业务系统信息表';
comment on column IG229.padid is '自增主键';
comment on column IG229.padprid is '流程ID';
comment on column IG229.padaffectsystem is '影响业务系统';
comment on column IG229.padstart is '影响开始时间';
comment on column IG229.padend is '影响结束时间';
comment on column IG229.fingerprint is '时间戳';

--IG105
comment on table IG105 is '流程策略定义信息';
comment on column IG105.pdid is '流程类型ID';
comment on column IG105.prstatus is '流程状态';
comment on column IG105.prurgency is '紧急程度';
comment on column IG105.psdversion is '策略版本';
comment on column IG105.expecttime is '期望解决时间';
comment on column IG105.createtime is '创建时间';
comment on column IG105.fingerprint is '时间戳';

--PRIORITY
comment on table PRIORITY is '流程优先级定义表';
comment on column PRIORITY.uvalue is '紧急程度';
comment on column PRIORITY.ivalue is '影响程度';
comment on column PRIORITY.pprtype is '流程类型ID';
comment on column PRIORITY.pvalue is '优先级';
comment on column PRIORITY.FINGERPRINT is '时间戳';

--KNOWLEDGE
comment on table KNOWLEDGE is '知识表';
comment on column KNOWLEDGE.KNID is '知识ID';
comment on column KNOWLEDGE.KNVERSION is '知识版本';
comment on column KNOWLEDGE.KNSERIAL is '编号';
comment on column KNOWLEDGE.KNDEPARTMENT is '部门';
comment on column KNOWLEDGE.KNAPPROVER is '归档人ID';
comment on column KNOWLEDGE.KNAPPROVERNAME is '归档人姓名';
comment on column KNOWLEDGE.KNAPPROVETIME is '归档时间';
comment on column KNOWLEDGE.KNCLASS is '分类';
comment on column KNOWLEDGE.KNCLASSNAME is '类别名称';
comment on column KNOWLEDGE.KNAREA is '业务领域标识';
comment on column KNOWLEDGE.KNAREANAME is '业务领域名称';
comment on column KNOWLEDGE.KNTELAREA is '技术领域标识';
comment on column KNOWLEDGE.KNTELAREANAME is '技术领域名称';
comment on column KNOWLEDGE.KNKEY is '关键字';
comment on column KNOWLEDGE.KNORIGIN is '来源标识';
comment on column KNOWLEDGE.KNORIGINNAME is '来源名称';
comment on column KNOWLEDGE.KNPROFFER is '贡献人ID';
comment on column KNOWLEDGE.KNPROFFERNAME is '贡献人名称';
comment on column KNOWLEDGE.KNPROFFERTIME is '贡献时间';
comment on column KNOWLEDGE.KNTITLE is '标题';
comment on column KNOWLEDGE.KNDES is '问题描述';
comment on column KNOWLEDGE.KNFAULTCAUSE is '故障原因总结';
comment on column KNOWLEDGE.KNSOLVEWAY is '解决办法';
comment on column KNOWLEDGE.KNSTATUS is '状态';
comment on column KNOWLEDGE.KNREJECT is '驳回原因';
comment on column KNOWLEDGE.KNATTKEY is '附件KEY';
comment on column KNOWLEDGE.FINGERPRINT is '时间戳';
comment on column KNOWLEDGE.KNAPPROVEROLE is '审批角色ID';

--KNOWLEDGEAPPIMPACT
comment on table KNOWLEDGEAPPIMPACT is '知识与业务系统关联表';
comment on column KNOWLEDGEAPPIMPACT.KAIID is '自增主键';
comment on column KNOWLEDGEAPPIMPACT.KNID is '知识ID';
comment on column KNOWLEDGEAPPIMPACT.KAICODE is '业务系统标识';
comment on column KNOWLEDGEAPPIMPACT.FINGERPRINT is '时间戳';
comment on column KNOWLEDGEAPPIMPACT.KNVERSION is '知识版本';

--KNOWLEDGEGRADE
comment on table KNOWLEDGEGRADE is '知识评分表';
comment on column KNOWLEDGEGRADE.KGID is '自增主键';
comment on column KNOWLEDGEGRADE.KNID is '知识ID';
comment on column KNOWLEDGEGRADE.KGGRADE is '知识评分';
comment on column KNOWLEDGEGRADE.KGAPPRAISE is '知识评价';
comment on column KNOWLEDGEGRADE.KGUSERID is '评分人ID';
comment on column KNOWLEDGEGRADE.KGTIME is '评分时间';
comment on column KNOWLEDGEGRADE.FINGERPRINT is '时间戳';

--KNOWLEDGEPROCESS
comment on table KNOWLEDGEPROCESS is '知识与流程关联表';
comment on column KNOWLEDGEPROCESS.KPID is '自增主键';
comment on column KNOWLEDGEPROCESS.KNID is '知识ID';
comment on column KNOWLEDGEPROCESS.KNVERSION is '知识版本';
comment on column KNOWLEDGEPROCESS.PRID is '流程ID';
comment on column KNOWLEDGEPROCESS.SFID is '服务工单ID';
comment on column KNOWLEDGEPROCESS.CONNECTTYPE is '关联类型';
comment on column KNOWLEDGEPROCESS.KPEFFECT is '是否有效标识';
comment on column KNOWLEDGEPROCESS.FINGERPRINT is '时间戳';

--KNOWLOG
comment on table KNOWLOG is '知识日志表';
comment on column KNOWLOG.KLID is '自增主键';
comment on column KNOWLOG.KLKID is '知识ID';
comment on column KNOWLOG.KLTIME is '记录时间';
comment on column KNOWLOG.KLROLEID is '角色ID';
comment on column KNOWLOG.KLROLENAME is '角色名称';
comment on column KNOWLOG.KLUSERID is '用户ID';
comment on column KNOWLOG.KLUSERNAME is '用户姓名';
comment on column KNOWLOG.KLDESC is '描述';
comment on column KNOWLOG.KLCOMMEND is '备注';
comment on column KNOWLOG.KLORGID is '机构层次码';
comment on column KNOWLOG.KLORGNAME is '机构名称';
comment on column KNOWLOG.FINGERPRINT is '时间戳';

--DELAY
comment on table DELAY is '延时解锁信息表';
comment on column DELAY.ID is '自增主键';
comment on column DELAY.DATETIME is '日期';
comment on column DELAY.ORGNAME is '申请单位';
comment on column DELAY.TITLE is '申请标题';
comment on column DELAY.HZNAME is '行长姓名';
comment on column DELAY.HZTEL is '行长电话';
comment on column DELAY.JLNAME is '经理姓名';
comment on column DELAY.JLTEL is '经理电话';
comment on column DELAY.REMARK is '备注';
comment on column DELAY.STARTTIME is '开始时间';
comment on column DELAY.ENDTIME is '结束时间';
comment on column DELAY.OPERATER is '操作人';
comment on column DELAY.FINGERPRINT is '时间戳';
comment on column DELAY.UNLOCKTIME is '解锁时间';

--ONDUTYPERSONRECORD
comment on table ONDUTYPERSONRECORD is '日常维护登记表';
comment on column ONDUTYPERSONRECORD.ODPRID is '自增主键';
comment on column ONDUTYPERSONRECORD.ODPRGUEST is '来访人员';
comment on column ONDUTYPERSONRECORD.ODPRGUESTORG is '所属单位';
comment on column ONDUTYPERSONRECORD.ODPRGUESTIDNUM is '身份证明';
comment on column ONDUTYPERSONRECORD.ODPRAREA is '进入区域';
comment on column ONDUTYPERSONRECORD.ODPRCTIME is '进入时间';
comment on column ONDUTYPERSONRECORD.ODPRLTIME is '离开时间';
comment on column ONDUTYPERSONRECORD.ODPROPTER is '操作人';
comment on column ONDUTYPERSONRECORD.ODPRACTER is '批准人';
comment on column ONDUTYPERSONRECORD.ODPRUSERNAME is '记录人';
comment on column ONDUTYPERSONRECORD.ODPRTARGET is '操作目标';
comment on column ONDUTYPERSONRECORD.ODPRRECORD is '操作记录';
comment on column ONDUTYPERSONRECORD.ODPRINSERTTIME is '记录时间';
comment on column ONDUTYPERSONRECORD.ODPRMODTIME is '编辑时间';
comment on column ONDUTYPERSONRECORD.FINGERPRINT is '时间戳';

--EIBELONGRELATION
comment on table EIBELONGRELATION is '配置所属关系表';
comment on column EIBELONGRELATION.BRID is '逻辑主键';
comment on column EIBELONGRELATION.BRPAREIID is '源资产ID';
comment on column EIBELONGRELATION.BRPARVERSION is '源资产大版本';
comment on column EIBELONGRELATION.BRPARSMALLVERSION is '源资产小版本';
comment on column EIBELONGRELATION.BRCLDEIID is '目的资产ID';
comment on column EIBELONGRELATION.BRCLDVERSION is '目的资产大版本';
comment on column EIBELONGRELATION.BRCLDSMALLVERSION is '目的资产小版本';
comment on column EIBELONGRELATION.BRTYPE is '关系类型(物理/逻辑)';
comment on column EIBELONGRELATION.BRDES is '关系说明';
comment on column EIBELONGRELATION.BRCREATETIME is '创建时间';
comment on column EIBELONGRELATION.BRRALETIONCODE is '关联关系码';
comment on column EIBELONGRELATION.BRASSETRELATION is '资产关系项';
comment on column EIBELONGRELATION.EIROOTMARK is '资产所属树根节点实体标识';
comment on column EIBELONGRELATION.DELETEFLAG is '逻辑删除标识';
comment on column EIBELONGRELATION.FINGERPRINT is '时间戳';

--IG911
comment on table IG911 is '自定义流程相关发起信息表';
comment on column IG911.psprpid is '自增主键';
comment on column IG911.pdid is '流程类型ID';
comment on column IG911.psdid is '流程状态ID';
comment on column IG911.roleid is '参与者角色ID';
comment on column IG911.relevantPdid is '相关发起的流程类型ID';
comment on column IG911.fingerPrint is '时间戳';

--IG931
comment on table IG931 is '缺省自定义流程相关发起信息表';
comment on column IG931.dpsprpid is '自增主键';
comment on column IG931.pdid is '流程类型ID';
comment on column IG931.psdid is '流程状态ID';
comment on column IG931.relevantPdid is '相关发起的流程类型ID';
comment on column IG931.fingerPrint is '时间戳';