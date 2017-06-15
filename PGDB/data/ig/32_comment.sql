--Role
comment on table IG.Role is '角色表';
comment on column IG.Role.roleid is '角色ID';
comment on column IG.Role.rolename is '角色名称';
comment on column IG.Role.roledesc is '角色说明';
comment on column IG.Role.roleinfo is '角色信息';
comment on column IG.Role.roletype is '角色类型';
comment on column IG.Role.roledomain is '角色机构管理范围';
comment on column IG.Role.assetdomain is '角色资产模型管理范围';
comment on column IG.Role.fingerprint is '时间戳';

--Action
comment on table IG.Action is '菜单表';
comment on column IG.Action.actname is '菜单标识';
comment on column IG.Action.actlabel is '菜单显示名称';
comment on column IG.Action.actdesc is '菜单说明';
comment on column IG.Action.acturl is '提交URL';
comment on column IG.Action.acttype is '菜单类型';
comment on column IG.Action.actl1id is '一级菜单ID（保留）';
comment on column IG.Action.actl2id is '二级菜单ID（保留）';
comment on column IG.Action.actl3id is '三级菜单ID（保留）';
comment on column IG.Action.fingerprint is '时间戳';
comment on column IG.Action.actroletype is '菜单可授予角色类型';
comment on column IG.Action.actsortid is '菜单显示顺序';
comment on column IG.Action.acturltype is '提交URL类型';

--RoleAction
comment on table IG.RoleAction is '角色菜单表';
comment on column IG.RoleAction.raid is '角色菜单ID';
comment on column IG.RoleAction.roleid is '角色ID';
comment on column IG.RoleAction.actname is '菜单标识';
comment on column IG.RoleAction.raperm is '角色对应菜单的权限（保留）';
comment on column IG.RoleAction.radesc is '角色对应菜单的权限说明（保留）';
comment on column IG.RoleAction.fingerprint is '时间戳';

--Organization
comment on table IG.Organization is '机构表';
comment on column IG.Organization.orgid is '机构ID';
comment on column IG.Organization.orgname is '机构名称';
comment on column IG.Organization.orgpar is '上级机构层次码';
comment on column IG.Organization.orgparname is '上级机构名称（保留）';
comment on column IG.Organization.orgdesc is '机构说明';
comment on column IG.Organization.orgtype is '机构类型';
comment on column IG.Organization.orgaddr is '机构地址';
comment on column IG.Organization.orgphone is '机构电话';
comment on column IG.Organization.orgfax is '机构传真';
comment on column IG.Organization.orgcontact is '机构联系人';
comment on column IG.Organization.orgstatus is '机构状态';
comment on column IG.Organization.orginfo is '机构信息';
comment on column IG.Organization.orgsyscoding is '机构层次码';
comment on column IG.Organization.orgusercoding is '机构编码';
comment on column IG.Organization.fingerprint is '时间戳';

--IgUser
comment on table IG.IgUser is '用户表';
comment on column IG.IgUser.userid is '用户ID';
comment on column IG.IgUser.orgid is '所属机构层次码';
comment on column IG.IgUser.orgname is '所属机构名称';
comment on column IG.IgUser.username is '用户姓名';
comment on column IG.IgUser.userdesc is '用户说明';
comment on column IG.IgUser.userinfo is '用户信息';
comment on column IG.IgUser.password is '用户密码';
comment on column IG.IgUser.userstatus is '用户状态';
comment on column IG.IgUser.usertype is '用户类型';
comment on column IG.IgUser.userphone is '用户电话';
comment on column IG.IgUser.usermobile is '用户手机';
comment on column IG.IgUser.useremail is '用户邮箱';
comment on column IG.IgUser.fingerprint is '时间戳';
comment on column IG.IgUser.deleteflag is '逻辑删除标识';

--IG622
comment on table IG.IG622 is '首页跳转URL定义表';
comment on column IG.IG622.HPID is '首页ID';
comment on column IG.IG622.HPLABEL is '首页描述';
comment on column IG.IG622.HPTITLE is '首页显示名称';
comment on column IG.IG622.HPURL is '首页URL';
comment on column IG.IG622.FINGERPRINT is '时间戳';

--UserRole
comment on table IG.UserRole is '用户角色表';
comment on column IG.UserRole.urid is '用户角色ID';
comment on column IG.UserRole.userid is '用户ID';
comment on column IG.UserRole.orgid is '角色ID';
comment on column IG.UserRole.roleid is '机构层次码';
comment on column IG.UserRole.fingerprint is '时间戳';
comment on column IG.UserRole.rolemanager is '角色负责人标识';
comment on column IG.UserRole.dutyflag is '值班人标识';

--Notice
comment on table IG.Notice is '通知表';
comment on column IG.Notice.nid is '通知ID';
comment on column IG.Notice.nname is '通知名称';
comment on column IG.Notice.ndesc is '通知描述';
comment on column IG.Notice.ntime is '通知时间';
comment on column IG.Notice.nuserid is '用户ID';
comment on column IG.Notice.nusername is '用户姓名';
comment on column IG.Notice.norgid is '机构层次码';
comment on column IG.Notice.norgname is '机构名称';
comment on column IG.Notice.nattkey is '附件KEY';
comment on column IG.Notice.fingerprint is '时间戳';

--CodeCategory
comment on table IG.CodeCategory is '基础数据分类表';
comment on column IG.CodeCategory.ccid is '数据分类ID';
comment on column IG.CodeCategory.ccname is '数据分类名称';
comment on column IG.CodeCategory.ccinfo is '数据分类说明';
comment on column IG.CodeCategory.cceditable is '编辑标识';
comment on column IG.CodeCategory.pccid is '上级数据分类ID';
comment on column IG.CodeCategory.pcflag is '支持最大级数';
comment on column IG.CodeCategory.fingerprint is '时间戳';

--CodeDetail
comment on table IG.CodeDetail is '基础数据详细信息表';
comment on column IG.CodeDetail.ccid is '数据分类ID';
comment on column IG.CodeDetail.cid is '数据ID';
comment on column IG.CodeDetail.cvalue is '数据内容';
comment on column IG.CodeDetail.pccid is '上级数据分类ID';
comment on column IG.CodeDetail.pcid is '上级数据ID';
comment on column IG.CodeDetail.updtime is '数据更新时间';
comment on column IG.CodeDetail.syscoding is '数据层次码';
comment on column IG.CodeDetail.psyscoding is '上级数据层次码';
comment on column IG.CodeDetail.cdstatus is '数据状态';
comment on column IG.CodeDetail.businesscode is '资产关联关系码';
comment on column IG.CodeDetail.fingerprint is '时间戳';
comment on column IG.CodeDetail.cdinfo is '数据说明';
comment on column IG.CodeDetail.cdorder is '数据显示顺序';

--CODECATEGORYDEF
comment on table IG.CODECATEGORYDEF is '树型数据分类表';
comment on column IG.CODECATEGORYDEF.CCID is '树型数据分类ID';
comment on column IG.CODECATEGORYDEF.CCNAME is '树型数据分类名称';
comment on column IG.CODECATEGORYDEF.CCINFO is '树型数据分类说明';
comment on column IG.CODECATEGORYDEF.CCEDITABLE is '编辑标识';
comment on column IG.CODECATEGORYDEF.PCCID is '上级数据分类ID'; 
comment on column IG.CODECATEGORYDEF.PCFLAG is '支持最大级数';
comment on column IG.CODECATEGORYDEF.FINGERPRINT is '时间戳';

--CODEDETAILDEF
comment on table IG.CODEDETAILDEF is '树型数据详细信息表';
comment on column IG.CODEDETAILDEF.CCID is '树型数据分类ID'; 
comment on column IG.CODEDETAILDEF.CID is '数据ID';
comment on column IG.CODEDETAILDEF.CVALUE is '数据内容';
comment on column IG.CODEDETAILDEF.PCCID is '上级数据分类ID';
comment on column IG.CODEDETAILDEF.PCID is '上级数据ID';
comment on column IG.CODEDETAILDEF.UPDTIME is '数据更新时间';
comment on column IG.CODEDETAILDEF.SYSCODING is '数据层次码';
comment on column IG.CODEDETAILDEF.PSYSCODING is '上级数据层次码';
comment on column IG.CODEDETAILDEF.CDSTATUS is '数据状态';
comment on column IG.CODEDETAILDEF.BUSINESSCODE is '业务标识';
comment on column IG.CODEDETAILDEF.CDINFO is '数据说明';
comment on column IG.CODEDETAILDEF.FINGERPRINT is '时间戳';

--IG117
comment on table IG.IG117 is '资产模型表';
comment on column IG.IG117.eid is '模型ID';
comment on column IG.IG117.ename is '模型名称';
comment on column IG.IG117.elabel is '模型标识';
comment on column IG.IG117.edesc is '模型说明';
comment on column IG.IG117.estatus is '模型状态';
comment on column IG.IG117.ecategory is '模型分类';
comment on column IG.IG117.ekey1 is '保留';
comment on column IG.IG117.ekey2 is '保留';
comment on column IG.IG117.ekey3 is '保留';
comment on column IG.IG117.esyscoding is '模型层次码';
comment on column IG.IG117.eparcoding is '上级模型层次码';
comment on column IG.IG117.fingerprint is '时间戳';
comment on column IG.IG117.emodeltype is '模型类型';

--IG225
comment on table IG.IG225 is '资产配置表';
comment on column IG.IG225.cid is '配置ID';
comment on column IG.IG225.eid is '资产模型ID';
comment on column IG.IG225.cname is '配置名称';
comment on column IG.IG225.clabel is '配置关键字';
comment on column IG.IG225.cdesc is '配置说明';
comment on column IG.IG225.cunit is '配置单位';
comment on column IG.IG225.cstatus is '配置状态';
comment on column IG.IG225.cseq is '配置可见标识';
comment on column IG.IG225.ccategory is '配置类别';
comment on column IG.IG225.coption is '配置取值范围';
comment on column IG.IG225.cattach is '配置数据类型';
comment on column IG.IG225.esyscoding is '资产模型层次码';
comment on column IG.IG225.fingerprint is '时间戳';
comment on column IG.IG225.crequired is '配置必填标识';

--IG545
comment on table IG.IG545 is '资产配置取值范围表';
comment on column IG.IG545.ccdid is '数据ID';
comment on column IG.IG545.ccdcategory is '数据编码';
comment on column IG.IG545.ccdlabel is '数据名称';
comment on column IG.IG545.ccdvalue is '数据值';
comment on column IG.IG545.ccdstatus is '数据状态';
comment on column IG.IG545.ccdtype is '数据类型';
comment on column IG.IG545.ccdinfo is '数据说明';
comment on column IG.IG545.fingerprint is '时间戳';

--IG611
comment on table IG.IG611 is '资产配置项缺省值表';
comment on column IG.IG611.EID is '资产模型ID';
comment on column IG.IG611.CID is '资产配置ID';
comment on column IG.IG611.CVALUE is '缺省值';
comment on column IG.IG611.FINGERPRINT is '时间戳';

--IG013
comment on table IG.IG013 is '资产表';
comment on column IG.IG013.eiid is '资产ID';
comment on column IG.IG013.eid is '资产模型ID';
comment on column IG.IG013.eidesc is '资产说明';
comment on column IG.IG013.einame is '资产名称';
comment on column IG.IG013.eilabel is '资产编号';
comment on column IG.IG013.eiinsdate is '资产登记日期';
comment on column IG.IG013.eiorgsyscoding is '资产所属机构层次码';
comment on column IG.IG013.esyscoding is '资产所属模型层次码';
comment on column IG.IG013.eiupdtime is '资产更新时间';
comment on column IG.IG013.eistatus is '资产状态';
comment on column IG.IG013.eiversion is '资产大版本';
comment on column IG.IG013.fingerprint is '时间戳';
comment on column IG.IG013.eiuserid is '资产管理人ID';
comment on column IG.IG013.eiusername is '资产管理人姓名';
comment on column IG.IG013.eismallversion is '资产小版本';
comment on column IG.IG013.eirootmark is '资产所属根节点实体标识';

--IG800
comment on table IG.IG800 is '资产配置项表';
comment on column IG.IG800.ciid is '资产配置项ID';
comment on column IG.IG800.cid is '资产配置ID';
comment on column IG.IG800.eiid is '资产ID';
comment on column IG.IG800.eid is '资产模型ID';
comment on column IG.IG800.civalue is '配置项值';
comment on column IG.IG800.ciupdtime is '配置项更新时间';
comment on column IG.IG800.esyscoding is '资产模型层次码';
comment on column IG.IG800.ciexpire is '保留';
comment on column IG.IG800.cistatus is '保留';
comment on column IG.IG800.cicurver is '配置项值是否变更';
comment on column IG.IG800.civersion is '配置项大版本';
comment on column IG.IG800.civerinfo is '保留';
comment on column IG.IG800.fingerprint is '时间戳';
comment on column IG.IG800.cismallversion is '配置项小版本';

--IG313
comment on table IG.IG313 is '资产关系表';
comment on column IG.IG313.eirid is '资产关系ID';
comment on column IG.IG313.pareiid is '资产ID（正向）';
comment on column IG.IG313.pareid is '资产模型ID（正向）';
comment on column IG.IG313.cldeiid is '资产ID（反向）';
comment on column IG.IG313.cldeid is '资产模型ID（反向）';
comment on column IG.IG313.eirrelation is '关联关系标识';
comment on column IG.IG313.eirrelationcode is '关系码头';
comment on column IG.IG313.eirupdtime is '更新时间';
comment on column IG.IG313.eirstatus is '可删除标识';
comment on column IG.IG313.eirdesc is '关系说明';
comment on column IG.IG313.fingerprint is '时间戳';
comment on column IG.IG313.eirinfo is '特殊关系标识';
comment on column IG.IG313.parversion is '资产大版本（正向）';
comment on column IG.IG313.parsmallversion is '资产小版本（正向）';
comment on column IG.IG313.cldversion is '资产大版本（反向）';
comment on column IG.IG313.cldsmallversion is '资产小版本（反向）';
comment on column IG.IG313.deleteflag is '逻辑删除标识';

--IG809
comment on table IG.IG809 is '资产关系图信息表（保留）';
comment on column IG.IG809.eirfid is '资产关系图信息ID';
comment on column IG.IG809.eiid is '资产ID';
comment on column IG.IG809.eirftype is '关系图类型';
comment on column IG.IG809.eirfname is '关系图XML文件名';
comment on column IG.IG809.eirfupdtime is '关系图创建时间';
comment on column IG.IG809.fingerprint is '时间戳';

--COLLECTPARAM
comment on table IG.COLLECTPARAM is '软件采集脚本定义表（保留）';
comment on column IG.COLLECTPARAM.CPTYPEID is '自增主键';
comment on column IG.COLLECTPARAM.CPSMODE is '脚本类型';
comment on column IG.COLLECTPARAM.CPSCRIPTNAME is '脚本名称';
comment on column IG.COLLECTPARAM.CPFILEPATH is '脚本路径';
comment on column IG.COLLECTPARAM.FINGERPRINT is '时间戳';

--compareTemplate
comment on table IG.compareTemplate is '机房位置信息表';
comment on column IG.compareTemplate.ctid is '位置信息ID';
comment on column IG.compareTemplate.ctcategory is '类别ID';
comment on column IG.compareTemplate.cttype is '类型';
comment on column IG.compareTemplate.ctxwidth is '横向宽度';
comment on column IG.compareTemplate.ctywidth is '纵向宽度';
comment on column IG.compareTemplate.ctvalue is '值';
comment on column IG.compareTemplate.fingerprint is '时间戳';

--IG259
comment on table IG.IG259 is '流程模版表';
comment on column IG.IG259.ptid is '模版ID';
comment on column IG.IG259.ptname is '模版名称';
comment on column IG.IG259.pttype is '模版类型';
comment on column IG.IG259.ptstartpg is '模版发起页URL';
comment on column IG.IG259.ptdetailpg is '模版创建时间';
comment on column IG.IG259.ptcrtdate is '模版信息';
comment on column IG.IG259.ptpicinfo is '模版状态';
comment on column IG.IG259.ptstatus is '模版查看页URL';
comment on column IG.IG259.ptsavepg is '发起页URL';
comment on column IG.IG259.ptqrtzflag is '定时发起URL';
comment on column IG.IG259.fingerprint is '时间戳';

--IG380
comment on table IG.IG380 is '流程类型表';
comment on column IG.IG380.pdid is '流程类型ID';
comment on column IG.IG380.ptid is '流程模版ID';
comment on column IG.IG380.pdname is '类型名称';
comment on column IG.IG380.pddesc is '类型描述';
comment on column IG.IG380.pdcrtdate is '创建时间';
comment on column IG.IG380.pdstatus is '类型状态';
comment on column IG.IG380.pdxml is '流程图XML';
comment on column IG.IG380.permission is '权限';
comment on column IG.IG380.fingerprint is '时间戳';
comment on column IG.IG380.serialgenerator is '工单号生成器';
comment on column IG.IG380.pdactname is '流程二级菜单ID';

--IG007
comment on table IG.IG007 is '流程表单定义表';
comment on column IG.IG007.pidid is '表单定义ID';
comment on column IG.IG007.pdid is '流程定义ID';
comment on column IG.IG007.pidname is '表单标识';
comment on column IG.IG007.pidlabel is '表单显示名称';
comment on column IG.IG007.piddesc is '表单描述';
comment on column IG.IG007.pidtype is '表单类型';
comment on column IG.IG007.pidoption is '表单取值范围';
comment on column IG.IG007.piddefault is '表单默认值';
comment on column IG.IG007.pidrequired is '是否必填';
comment on column IG.IG007.fingerprint is '时间戳';
comment on column IG.IG007.pidsortid is '排序标识';
comment on column IG.IG007.ccid is '树型数据分类ID';
comment on column IG.IG007.pidgid is '通用表单定义ID';
comment on column IG.IG007.PIDMODE is '表单模式';
comment on column IG.IG007.PRIVATESCOPE is '私有表单权限范围';
comment on column IG.IG007.ROWWIDTH is '表单行显示模式';

--IG333
comment on table IG.IG333 is '自定义流程状态定义表';
comment on column IG.IG333.psdid is '流程状态ID';
comment on column IG.IG333.pdid is '流程定义ID';
comment on column IG.IG333.psdname is '状态名称';
comment on column IG.IG333.psddesc is '状态描述';
comment on column IG.IG333.psdcode is '状态标识';
comment on column IG.IG333.fingerPrint is '时间戳';
comment on column IG.IG333.psdtype is '状态类型';
comment on column IG.IG333.psdmode is '状态模式';
comment on column IG.IG333.psdflag is '动态参与者标识';
comment on column IG.IG333.psdassign is '分派参与者类型';
comment on column IG.IG333.psdorg is '分派参与者类型';
comment on column IG.IG333.psdconfirm is '有无确认操作';
comment on column IG.IG333.assignpsdid is '分派节点ID';
comment on column IG.IG333.assignpbdid is '分派按钮ID';
comment on column IG.IG333.assignflag is '是否必须分派标识';
comment on column IG.IG333.participantchange is '参与者是否可改派标识';
comment on column IG.IG333.assignpagetype is '分派页面类型';

--IG258
comment on table IG.IG258 is '自定义流程可分派状态定义表';
comment on column IG.IG258.pspcdid is '自增主键';
comment on column IG.IG258.psdid is '源状态';
comment on column IG.IG258.pspcdpsdid is '可被分派状态';
comment on column IG.IG258.fingerPrint is '时间戳';

--IG211
comment on table IG.IG211 is '自定义流程表单默认值（保留）';
comment on column IG.IG211.psidid is '默认值ID';
comment on column IG.IG211.psdid is '流程状态ID';
comment on column IG.IG211.pidid is '表单定义ID';
comment on column IG.IG211.pidname is '表单标识';
comment on column IG.IG211.pidlabel is '表单显示名称';
comment on column IG.IG211.piddesc is '表单描述';
comment on column IG.IG211.pidtype is '表单类型';
comment on column IG.IG211.pidvalue is '表单值';
comment on column IG.IG211.pidattkey is '附件KEY';
comment on column IG.IG211.fingerPrint is '时间戳';

--IG900
comment on table IG.IG900 is '自定义流程按钮定义表';
comment on column IG.IG900.pbdid is '按钮ID';
comment on column IG.IG900.pbdname is '按钮默认名称';
comment on column IG.IG900.pbdflag is '是否系统保留按钮';
comment on column IG.IG900.pbdimage is '按钮显示图片名称';
comment on column IG.IG900.fingerPrint is '时间戳';

--IG222
comment on table IG.IG222 is '自定义流程参与者定义表';
comment on column IG.IG222.ppdid is '参与者ID';
comment on column IG.IG222.psdid is '流程状态ID';
comment on column IG.IG222.roleid is '角色ID';
comment on column IG.IG222.userid is '默认参与用户ID';
comment on column IG.IG222.ppdsuper is '是否SUPER角色';
comment on column IG.IG222.fingerPrint is '时间戳';

--IG132
comment on table IG.IG132 is '参与者按钮定义信息表';
comment on column IG.IG132.ppbdid is '自增主键';
comment on column IG.IG132.ppdid is '参与者定义ID';
comment on column IG.IG132.pbdid is '按钮定义ID';
comment on column IG.IG132.ppbdname is '按钮显示名称';
comment on column IG.IG132.ppbddesc is '按钮提示信息';
comment on column IG.IG132.ppbdauth is '按钮提交权限';
comment on column IG.IG132.fingerPrint is '时间戳';

--IG881
comment on table IG.Action is '自定义流程参与者变量权限表';
comment on column IG.IG881.pipdid is '参与者变量权限ID';
comment on column IG.IG881.pidid is '表单定义ID';
comment on column IG.IG881.psdid is '流程状态ID';
comment on column IG.IG881.ppdid is '参与者定义ID';
comment on column IG.IG881.pidaccess is '表单权限';
comment on column IG.IG881.fingerPrint is '时间戳';
comment on column IG.IG881.PIDREQUIRED is '是否必填';

--IG273
comment on table IG.IG273 is '自定义流程状态跃迁规则表';
comment on column IG.IG273.ptdid is '跃迁规则ID';
comment on column IG.IG273.fpsdid is '源流程状态ID';
comment on column IG.IG273.tpsdid is '目的流程状态ID';
comment on column IG.IG273.ptdname is '跃迁规则名称';
comment on column IG.IG273.ptddesc is '跃迁规则描述';
comment on column IG.IG273.ptdtype is '跃迁规则类型';
comment on column IG.IG273.ptdcond is '跃迁条件';
comment on column IG.IG273.fingerPrint is '时间戳';

--IG933
comment on table IG.IG933 is '服务工单表';
comment on column IG.IG933.sfid is '服务工单ID';
comment on column IG.IG933.sfreportname is '报告人姓名';
comment on column IG.IG933.sfreportphone is '报告人联系电话';
comment on column IG.IG933.sfreportorgid is '报告人机构层次码';
comment on column IG.IG933.sftitle is '标题';
comment on column IG.IG933.sfdesc is '描述';
comment on column IG.IG933.sfattkey is '附件KEY';
comment on column IG.IG933.sfstatus is '状态';
comment on column IG.IG933.sftype is '分类';
comment on column IG.IG933.sforgid is '登记人机构层次码';
comment on column IG.IG933.sfeiid is '相关资产ID';
comment on column IG.IG933.sfregisterid is '登记人ID';
comment on column IG.IG933.sfinstime is '登记时间';
comment on column IG.IG933.fingerprint is '时间戳';
comment on column IG.IG933.SFCODE is '服务工单编号';
comment on column IG.IG933.SFSOURCE is '来源';
comment on column IG.IG933.SFWORKPHONE is '办公电话';
comment on column IG.IG933.SFEMAIL is '邮箱';

--IG941
comment on table IG.IG941 is '服务工单日志表';
comment on column IG.IG941.sflid is '日志ID';
comment on column IG.IG941.sfid is '服务工单ID';
comment on column IG.IG941.sfluserid is '处理人ID';
comment on column IG.IG941.sfldesc is '处理记录';
comment on column IG.IG941.sflinstime is '处理时间';
comment on column IG.IG941.fingerprint is '时间戳';
comment on column IG.IG941.sflattkey is '附件KEY';

--SmsSendLog
comment on table IG.SmsSendLog is '短信日志表（保留）';
comment on column IG.SmsSendLog.SSLID is '日志ID';
comment on column IG.SmsSendLog.USERNAME is '用户姓名'; 
comment on column IG.SmsSendLog.DEPTMENTNAME is '用户所属机构名称'; 
comment on column IG.SmsSendLog.SENDDATE is '发送日期'; 
comment on column IG.SmsSendLog.USERMOBILE is '发送手机号'; 
comment on column IG.SmsSendLog.SMSTYPE is '日志类型'; 
comment on column IG.SmsSendLog.SENDFLAG is '成功失败标志'; 
comment on column IG.SmsSendLog.FINGERPRINT is '时间戳';

--IG992
comment on table IG.IG992 is '自定义流程外部事件定义表';
comment on column IG.IG992.PEDID is '自增主键';
comment on column IG.IG992.PEDEVENTID is '事件ID';
comment on column IG.IG992.PEDACTION is '处理BL标识';
comment on column IG.IG992.PEDDESC is '描述';
comment on column IG.IG992.FINGERPRINT is '时间戳';

--IG286
comment on table IG.IG286 is '自定义流程表单联动规则定义表';
comment on column IG.IG286.plid is '自增主键';
comment on column IG.IG286.pldpdid is '流程定义ID';
comment on column IG.IG286.pldactionid is '动作ID';
comment on column IG.IG286.initiativepidid is '主动表单定义ID';
comment on column IG.IG286.passivitypidid is '被动表单定义ID';
comment on column IG.IG286.pldesc is '描述';
comment on column IG.IG286.plblname is '处理BL标识';
comment on column IG.IG286.pljsevent is 'JS脚本事件名称';
comment on column IG.IG286.pljtype is '联动规则类型';
comment on column IG.IG286.initiativepidname is '主动表单名称';
comment on column IG.IG286.passivitypidname is '被动表单名称';
comment on column IG.IG286.fingerprint is '时间戳';

--IG413
comment on table IG.IG413 is '自定义流程前后处理事件定义表';
comment on column IG.IG413.pedid is '自增主键';
comment on column IG.IG413.pdid is '流程定义ID';
comment on column IG.IG413.psdid is '流程状态ID';
comment on column IG.IG413.pedactionid is '动作ID';
comment on column IG.IG413.pedtype is '事件类型';
comment on column IG.IG413.pedblid is '处理BL标识';
comment on column IG.IG413.pedorder is '事件执行顺序';
comment on column IG.IG413.pedec is '描述';
comment on column IG.IG413.fingerPrint is '时间戳';

--IG373
comment on table IG.IG373 is '自定义流程表单初始化事件定义表';
comment on column IG.IG373.piidid is '自增主键';
comment on column IG.IG373.pdid is '流程定义ID';
comment on column IG.IG373.psdid is '流程状态ID';
comment on column IG.IG373.piidblid is '处理BL标识';
comment on column IG.IG373.piiddec is '描述';
comment on column IG.IG373.fingerPrint is '时间戳';

--IG126
comment on table IG.IG126 is '自定义流程显示页面定义表';
comment on column IG.IG126.pjdid is '自增主键';
comment on column IG.IG126.pdid is '流程定义ID';
comment on column IG.IG126.pjdtype is '页面类型';
comment on column IG.IG126.pjdblid is '处理BL标识';
comment on column IG.IG126.pjdurl is 'JSP页面路径';
comment on column IG.IG126.fingerPrint is '时间戳';

--IG725
comment on table IG.IG725 is '自定义流程缺省参与者按钮定义表';
comment on column IG.IG725.pdbdid is '自增主键';
comment on column IG.IG725.psdid is '流程状态ID';
comment on column IG.IG725.pbdid is '按钮ID';
comment on column IG.IG725.pdbdname is '按钮显示名称';
comment on column IG.IG725.pdbddesc is '按钮提示信息';
comment on column IG.IG725.pdbdauth is '按钮提交权限';
comment on column IG.IG725.fingerPrint is '时间戳';

--IG711
comment on table IG.IG711 is '自定义流程代办授权表';
comment on column IG.IG711.paid is '自增主键';
comment on column IG.IG711.paiid is '被授权人ID';
comment on column IG.IG711.pauid is '授权人ID';
comment on column IG.IG711.pabegintime is '授权开始时间';
comment on column IG.IG711.paendtime is '授权结束时间';
comment on column IG.IG711.paflag is '是否授权标识';
comment on column IG.IG711.patype is '授权类型';
comment on column IG.IG711.paprocessid is '流程ID';
comment on column IG.IG711.paprocessnum is '流程工单号';
comment on column IG.IG711.palogintime is '授权时间';
comment on column IG.IG711.fingerprint is '时间戳';	
comment on column IG.IG711.remarks is '备注';

--IG699
comment on table IG.IG699 is '自定义流程缺省参与者表单权限表';
comment on column IG.IG699.pdvid is '自增主键';
comment on column IG.IG699.pidid is '表单定义ID';
comment on column IG.IG699.psdid is '流程状态ID';
comment on column IG.IG699.pidaccess is '表单权限';
comment on column IG.IG699.fingerPrint is '时间戳';
comment on column IG.IG699.PIDREQUIRED is '是否必填';

--IG500
comment on table IG.IG500 is '流程工单表';
comment on column IG.IG500.prid is '流程ID';
comment on column IG.IG500.prtype is '流程类型';
comment on column IG.IG500.prsubtype is '流程子类型';
comment on column IG.IG500.prstatus is '流程状态';
comment on column IG.IG500.prsubstatus is '流程子状态';
comment on column IG.IG500.prtitle is '流程标题';
comment on column IG.IG500.prdesc is '流程描述';
comment on column IG.IG500.propentime is '流程发起时间';
comment on column IG.IG500.prclosetime is '流程关闭时间';
comment on column IG.IG500.prplantime is '计划执行时间';
comment on column IG.IG500.prduration is '计划执行周期';
comment on column IG.IG500.prurgency is '紧急程度';
comment on column IG.IG500.primpact is '影响程度';
comment on column IG.IG500.prassetid is '相关资产ID';
comment on column IG.IG500.prassetname is '相关资产名称';
comment on column IG.IG500.prassetcategory is '相关资产类型';
comment on column IG.IG500.prbusiness is '相关业务';
comment on column IG.IG500.primplplan is '执行计划';
comment on column IG.IG500.prbackplan is '恢复计划';
comment on column IG.IG500.prvfyplan is '验证计划';
comment on column IG.IG500.pid is '相关项目ID';
comment on column IG.IG500.pcode is '相关项目编号';
comment on column IG.IG500.pname is '相关项目名称';
comment on column IG.IG500.prinfo is '发起者联系方式';
comment on column IG.IG500.prcorid is '相关流程ID';
comment on column IG.IG500.prcortype is '相关流程类型';
comment on column IG.IG500.prcortitle is '相关流程标题';
comment on column IG.IG500.pruserid is '发起者ID';
comment on column IG.IG500.prusername is '发起者姓名';
comment on column IG.IG500.prroleid is '发起者角色ID';
comment on column IG.IG500.prrolename is '发起者角色名称';
comment on column IG.IG500.prpdid is '流程类型ID';
comment on column IG.IG500.prpdname is '流程类型名称';
comment on column IG.IG500.prorgid is '发起者机构层次码';
comment on column IG.IG500.prorgname is '发起者机构名称';
comment on column IG.IG500.prserialnum is '流程工单号';
comment on column IG.IG500.prfacttime is '实际解决时间';
comment on column IG.IG500.fingerprint is '时间戳';
comment on column IG.IG500.prptdcond is '流程跃迁条件';
comment on column IG.IG500.prstrategyversion is '流程策略版本';
comment on column IG.IG500.prpriority is '优先级';

--IG394
comment on table IG.IG394 is '自定义流程通知日志表';
comment on column IG.IG394.PNSSID is '日志ID';
comment on column IG.IG394.PRID is '流程ID';
comment on column IG.IG394.PSDID is '流程状态ID';
comment on column IG.IG394.PSDCONFIRM is '接单';
comment on column IG.IG394.ROLEID is '通知角色ID';
comment on column IG.IG394.USERID is '通知用户ID';
comment on column IG.IG394.NOTIFYSMSTIME is '短信提醒发送时间';
comment on column IG.IG394.NOTIFYEMAILTIME is '邮件提醒发送时间';
comment on column IG.IG394.REPORTSMSTIME is '短信上报发送时间';
comment on column IG.IG394.REPORTEMAILTIME is '邮件上报发送时间';
comment on column IG.IG394.FINGERPRINT is '时间戳';

--IG337
comment on table IG.IG337 is '流程参与者信息表';
comment on column IG.IG337.ppid is '自增主键';
comment on column IG.IG337.prid is '流程ID';
comment on column IG.IG337.pproleid is '角色ID';
comment on column IG.IG337.pprolename is '角色名称';
comment on column IG.IG337.ppuserid is '用户ID';
comment on column IG.IG337.ppusername is '用户姓名';
comment on column IG.IG337.pporgid is '用户所属机构层次码';
comment on column IG.IG337.pporgname is '用户所属机构名称';
comment on column IG.IG337.pptype is '参与类型';
comment on column IG.IG337.ppuserinfo is '用户信息';
comment on column IG.IG337.ppcomment is '工作评语';
comment on column IG.IG337.ppstatus is '参与状态';
comment on column IG.IG337.ppattkey is '附件KEY';
comment on column IG.IG337.ppinittime is '指定时间';
comment on column IG.IG337.ppproctime is '处理完成时间';
comment on column IG.IG337.ppsubstatus is '子状态';
comment on column IG.IG337.ppfacttime is '实际解决时间';
comment on column IG.IG337.ppbacktime is '流程回退指定时间';
comment on column IG.IG337.fingerprint is '时间戳';
comment on column IG.IG337.ppproxyuserid is '代理用户ID';
comment on column IG.IG337.ppsuper is '是否SUPER角色';
comment on column IG.IG337.pprolemanager is '是否角色负责人';
comment on column IG.IG337.ppdutyperson is '是否值班人';
comment on column IG.IG337.pbdid is '流程按钮ID';

--IG599
comment on table IG.IG599 is '流程表单信息表';
comment on column IG.IG599.piid is '自增主键';
comment on column IG.IG599.prid is '流程ID';
comment on column IG.IG599.pivarname is '表单标识';
comment on column IG.IG599.pivarlabel is '表单显示名称';
comment on column IG.IG599.pivartype is '表单类型';
comment on column IG.IG599.pivarvalue is '表单值';
comment on column IG.IG599.piattkey is '附件KEY';
comment on column IG.IG599.fingerprint is '时间戳';
comment on column IG.IG599.pidid is '表单定义ID';
comment on column IG.IG599.PIDMODE is '表单模式';
comment on column IG.IG599.PRIVATESCOPE is '私有表单权限范围';

--Attachment
comment on table IG.Attachment is '附件表';
comment on column IG.Attachment.attid is '自增主键';
comment on column IG.Attachment.attkey is '附件KEY';
comment on column IG.Attachment.attname is '附件名称';
comment on column IG.Attachment.attdesc is '说明';
comment on column IG.Attachment.atturl is '分类标识';
comment on column IG.Attachment.fingerprint is '时间戳';

--IG036
comment on table IG.Action is '流程日志表';
comment on column IG.IG036.rlid is '日志ID';
comment on column IG.IG036.prid is '流程ID';
comment on column IG.IG036.rltime is '处理时间';
comment on column IG.IG036.roleid is '处理角色ID';
comment on column IG.IG036.rlrolename is '处理角色名称';
comment on column IG.IG036.rluserid is '处理用户ID';
comment on column IG.IG036.rlusername is '处理用户名称';
comment on column IG.IG036.rltype is '日志类型';
comment on column IG.IG036.rldesc is '日志描述';
comment on column IG.IG036.rlcomment is '处理内容';
comment on column IG.IG036.rlattkey is '附件KEY';
comment on column IG.IG036.rlorgid is '处理用户所属机构层次码';
comment on column IG.IG036.rlorgname is '处理用户所属机构名称';
comment on column IG.IG036.fingerprint is '时间戳';
comment on column IG.IG036.psname is '流程状态名称';
comment on column IG.IG036.psdcode is '流程状态标识';
comment on column IG.IG036.rolemanger is '是否角色负责人';
comment on column IG.IG036.pbdid is '流程按钮ID';

--IG715
comment on table IG.IG715 is '流程与服务工单关联表';
comment on column IG.IG715.sprrid is '自增主键';
comment on column IG.IG715.sprrsfid is '服务工单ID';
comment on column IG.IG715.sprrprid is '流程ID';
comment on column IG.IG715.sprrinstime is '登记时间';
comment on column IG.IG715.fingerprint is '时间戳';

--IG113
comment on table IG.IG113 is '流程表单日志表';
comment on column IG.IG113.rlvid is '自增主键';
comment on column IG.IG113.rlid is '流程日志ID';
comment on column IG.IG113.piid is '流程表单ID';
comment on column IG.IG113.prid is '流程ID';
comment on column IG.IG113.pivarname is '表单标识';
comment on column IG.IG113.pivarlabel is '表单显示名称';
comment on column IG.IG113.pivartype is '表单类型';
comment on column IG.IG113.pivarvalue is '表单值';
comment on column IG.IG113.piattkey is '附件KEY';
comment on column IG.IG113.pidid is '表单定义ID';
comment on column IG.IG113.pishowvarname is '表单显示名称';
comment on column IG.IG113.fingerprint is '时间戳';

--SdlInfo
comment on table IG.SdlInfo is '服务水平信息表';
comment on column IG.SdlInfo.siid is '自增主键';
comment on column IG.SdlInfo.sitype is '类别';
comment on column IG.SdlInfo.sibegin is '开始时间';
comment on column IG.SdlInfo.simark is '评分';
comment on column IG.SdlInfo.sieiid is '相关资产ID';
comment on column IG.SdlInfo.sieiname is '相关资产名称';
comment on column IG.SdlInfo.siprid is '相关事件流程ID';
comment on column IG.SdlInfo.siprtitle is '相关事件流程标题';
comment on column IG.SdlInfo.sidesc is '描述';
comment on column IG.SdlInfo.siend is '结束时间';
comment on column IG.SdlInfo.siattkey is '附件KEY';
comment on column IG.SdlInfo.sifacttime is '实际时间';
comment on column IG.SdlInfo.sidate is '登记时间';
comment on column IG.SdlInfo.fingerprint is '时间戳';

--SdlDefineInfo
comment on table IG.SdlDefineInfo is '服务水平目标信息表';
comment on column IG.SdlDefineInfo.sdiid is '自增主键';
comment on column IG.SdlDefineInfo.sdiyear is '登记年度';
comment on column IG.SdlDefineInfo.sdieiid is '相关资产ID';
comment on column IG.SdlDefineInfo.sdieiname is '相关资产名称';
comment on column IG.SdlDefineInfo.sdibreakm is '月中断时间';
comment on column IG.SdlDefineInfo.sdibreaky is '年中断时间';
comment on column IG.SdlDefineInfo.sdicontinuousm is '月连续时间百分比';
comment on column IG.SdlDefineInfo.sdicontinuousy is '年连续时间百分比';
comment on column IG.SdlDefineInfo.sdiimpactm is '月影响时间';
comment on column IG.SdlDefineInfo.sdiimpacty is '年影响时间';
comment on column IG.SdlDefineInfo.sdisteadym is '月稳定时间百分比';
comment on column IG.SdlDefineInfo.sdisteadyy is '年稳定时间百分比';
comment on column IG.SdlDefineInfo.sdisafecasem is '月安全事件个数';
comment on column IG.SdlDefineInfo.sdisafecasey is '年安全事件个数';
comment on column IG.SdlDefineInfo.sdisafemarkm is '月安全事件评分';
comment on column IG.SdlDefineInfo.sdisafemarky is '年安全事件评分';
comment on column IG.SdlDefineInfo.sdiriskmarkm is '月风险检查评分';
comment on column IG.SdlDefineInfo.sdiriskmarky is '年风险检查评分';
comment on column IG.SdlDefineInfo.sdicapacitycasem is '月容量事件个数';
comment on column IG.SdlDefineInfo.sdicapacitycasey is '年容量事件个数';
comment on column IG.SdlDefineInfo.sdicapacitymarkm is '月容量事件评分';
comment on column IG.SdlDefineInfo.sdicapacitymarky is '年容量事件评分';
comment on column IG.SdlDefineInfo.fingerprint is '时间戳';

--Project
comment on table IG.Project is '项目表';
comment on column IG.Project.pid is '项目ID';
comment on column IG.Project.ptype is '项目类型';
comment on column IG.Project.pcode is '项目编号';
comment on column IG.Project.pname is '项目名称';
comment on column IG.Project.pdesc is '项目说明';
comment on column IG.Project.pinfo is '（保留）';
comment on column IG.Project.popentime is '项目开始时间';
comment on column IG.Project.pclosetime is '项目结束时间';
comment on column IG.Project.pstatus is '项目状态';
comment on column IG.Project.porg is '登记人所属机构层次码（前两级）';
comment on column IG.Project.prole is '项目负责人';
comment on column IG.Project.puser is '项目参与者';
comment on column IG.Project.fingerprint is '时间戳';

--ProjectPlan
comment on table IG.ProjectPlan is '项目计划表';
comment on column IG.ProjectPlan.pplid is '计划ID';
comment on column IG.ProjectPlan.pid is '项目ID';
comment on column IG.ProjectPlan.pplinfo is '信息';
comment on column IG.ProjectPlan.pplversion is '版本';
comment on column IG.ProjectPlan.pplstatus is '状态';
comment on column IG.ProjectPlan.ppldesc is '描述';
comment on column IG.ProjectPlan.ppldate is '登记时间';
comment on column IG.ProjectPlan.fingerprint is '时间戳';

--ProjectLog
comment on table IG.ProjectLog is '项目日志表';
comment on column IG.ProjectLog.plid is '日志ID';
comment on column IG.ProjectLog.pid is '项目ID';
comment on column IG.ProjectLog.plroleid is '（保留字段）';
comment on column IG.ProjectLog.plrolename is '（保留字段）';
comment on column IG.ProjectLog.pluserid is '用户ID';
comment on column IG.ProjectLog.plusername is '用户姓名';
comment on column IG.ProjectLog.plinfo is '内容';
comment on column IG.ProjectLog.pltype is '类型';
comment on column IG.ProjectLog.pltime is '登记时间';
comment on column IG.ProjectLog.plattkey is '附件KEY';
comment on column IG.ProjectLog.fingerprint is '时间戳';

--Budget
comment on table IG.Budget is '预算表';
comment on column IG.Budget.bid is '预算ID';
comment on column IG.Budget.btype is '预算类型';
comment on column IG.Budget.binittime is '（保留）';
comment on column IG.Budget.bopentime is '开始时间';
comment on column IG.Budget.bstatus is '状态';
comment on column IG.Budget.breqid is '（保留）';
comment on column IG.Budget.bapvid is '（保留）';
comment on column IG.Budget.btitle is '预算名称';
comment on column IG.Budget.bclosetime is '关闭时间';
comment on column IG.Budget.bdesc is '预算说明';
comment on column IG.Budget.binfo is '（保留）';
comment on column IG.Budget.byear is '预算年度';
comment on column IG.Budget.borgid is '（保留）';
comment on column IG.Budget.borgname is '（保留）';
comment on column IG.Budget.breqname is '登记人名称';
comment on column IG.Budget.bapvname is '（保留）';
comment on column IG.Budget.bamount is '金额';
comment on column IG.Budget.battkey is '附件KEY';
comment on column IG.Budget.pid is '相关项目';
comment on column IG.Budget.pcode is '相关项目编号';
comment on column IG.Budget.pname is '相关项目名称';
comment on column IG.Budget.fingerprint is '时间戳';

--Expense
comment on table IG.Expense is '费用表';
comment on column IG.Expense.exid is '费用ID';
comment on column IG.Expense.bid is '预算ID';
comment on column IG.Expense.exdesc is '费用说明';
comment on column IG.Expense.examount is '费用金额';
comment on column IG.Expense.exinfo is '（保留）';
comment on column IG.Expense.exstatus is '费用状态';
comment on column IG.Expense.exreqid is '（保留）';
comment on column IG.Expense.exreqname is '（保留）';
comment on column IG.Expense.exinittime is '（保留）';
comment on column IG.Expense.exopentime is '开始时间';
comment on column IG.Expense.exapvid is '（保留）';
comment on column IG.Expense.exapvname is '费用名称';
comment on column IG.Expense.exclosetime is '结束时间';
comment on column IG.Expense.exattkey is '附件KEY';
comment on column IG.Expense.exeiinfo is '（保留）';
comment on column IG.Expense.exprinfo is '（保留）';
comment on column IG.Expense.expinfo is '（保留）';
comment on column IG.Expense.exorginfo is '（保留）';
comment on column IG.Expense.btitle is '预算名称';
comment on column IG.Expense.fingerprint is '时间戳';

--QuartzJobs
comment on table IG.QuartzJobs is '定时任务表';
comment on column IG.QuartzJobs.qjid is '自增主键';
comment on column IG.QuartzJobs.qjname is '任务名称';
comment on column IG.QuartzJobs.qjdesc is '任务描述';
comment on column IG.QuartzJobs.qjtriname is '触发器名称';
comment on column IG.QuartzJobs.qjtrigrp is '触发器所属组名称';
comment on column IG.QuartzJobs.qjtricron is 'QUARTZ表达式';
comment on column IG.QuartzJobs.qjcrtuser is '创建人ID';
comment on column IG.QuartzJobs.qjimpluser is '执行人ID';
comment on column IG.QuartzJobs.qjcrttime is '创建时间';
comment on column IG.QuartzJobs.qjendtime is '结束时间';
comment on column IG.QuartzJobs.qjtype is '类型';
comment on column IG.QuartzJobs.qjstatus is '状态';
comment on column IG.QuartzJobs.qjinfo is '备注';
comment on column IG.QuartzJobs.qjcrtusername is '创建人姓名';
comment on column IG.QuartzJobs.qjimplusername is '执行人姓名';
comment on column IG.QuartzJobs.qjperiodinfo is '周期类型';
comment on column IG.QuartzJobs.qjorgid is '执行人所属机构层次码';
comment on column IG.QuartzJobs.qjorgname is '执行人所属机构名称';
comment on column IG.QuartzJobs.qjassetid is '相关资产ID';
comment on column IG.QuartzJobs.qjassettypeid is '相关资产所属模型层次码';
comment on column IG.QuartzJobs.fingerprint is '时间戳';

--QuartzProcessRecord
comment on table IG.QuartzProcessRecord is '定时流程基本信息表';
comment on column IG.QuartzProcessRecord.qprid is '定时流程ID';
comment on column IG.QuartzProcessRecord.qprtype is '流程模版类型';
comment on column IG.QuartzProcessRecord.qprsubtype is '流程子类型';
comment on column IG.QuartzProcessRecord.qprstatus is '流程状态';
comment on column IG.QuartzProcessRecord.qprsubstatus is '流程子状态';
comment on column IG.QuartzProcessRecord.qprtitle is '流程标题';
comment on column IG.QuartzProcessRecord.qprdesc is '流程描述';
comment on column IG.QuartzProcessRecord.qpropentime is '建立时间';
comment on column IG.QuartzProcessRecord.qprclosetime is '关闭时间';
comment on column IG.QuartzProcessRecord.qprplantime is '计划执行时间';
comment on column IG.QuartzProcessRecord.qprduration is '计划执行周期';
comment on column IG.QuartzProcessRecord.qprurgency is '紧急程度';
comment on column IG.QuartzProcessRecord.qprimpact is '影响程度';
comment on column IG.QuartzProcessRecord.qprassetid is '相关资产ID';
comment on column IG.QuartzProcessRecord.qprassetname is '相关资产名称';
comment on column IG.QuartzProcessRecord.qprassetcategory is '相关资产类型';
comment on column IG.QuartzProcessRecord.qprbusiness is '相关业务';
comment on column IG.QuartzProcessRecord.qprimplplan is '执行计划';
comment on column IG.QuartzProcessRecord.qprbackplan is '恢复计划';
comment on column IG.QuartzProcessRecord.qprvfyplan is '验证计划';
comment on column IG.QuartzProcessRecord.qpid is '相关项目ID';
comment on column IG.QuartzProcessRecord.qpcode is '相关项目编号';
comment on column IG.QuartzProcessRecord.qpname is '相关项目名称';
comment on column IG.QuartzProcessRecord.qprinfo is '发起者联系方式';
comment on column IG.QuartzProcessRecord.qprcorid is '相关流程ID';
comment on column IG.QuartzProcessRecord.qprcortype is '相关流程类型';
comment on column IG.QuartzProcessRecord.qprcortitle is '相关流程标题';
comment on column IG.QuartzProcessRecord.qpruserid is '发起者ID';
comment on column IG.QuartzProcessRecord.qprusername is '发起者姓名';
comment on column IG.QuartzProcessRecord.qprroleid is '发起者角色ID';
comment on column IG.QuartzProcessRecord.qprrolename is '发起者角色名称';
comment on column IG.QuartzProcessRecord.qprpdid is '流程类型ID';
comment on column IG.QuartzProcessRecord.qprpdname is '流程类型名称';
comment on column IG.QuartzProcessRecord.qprorgid is '发起者所属机构层次码';
comment on column IG.QuartzProcessRecord.qprorgname is '发起者所属机构名称';
comment on column IG.QuartzProcessRecord.fingerprint is '时间戳';
comment on column IG.QuartzProcessRecord.qprattkey is '附件KEY';

--QuartzProcessParticipant
comment on table IG.QuartzProcessParticipant is '定时流程参与者信息表';
comment on column IG.QuartzProcessParticipant.qppid is '自增主键';
comment on column IG.QuartzProcessParticipant.qprid is '定时流程ID';
comment on column IG.QuartzProcessParticipant.qpproleid is '角色ID';
comment on column IG.QuartzProcessParticipant.qpprolename is '角色名称';
comment on column IG.QuartzProcessParticipant.qppuserid is '用户ID';
comment on column IG.QuartzProcessParticipant.qppusername is '用户姓名';
comment on column IG.QuartzProcessParticipant.qpporgid is '用户所属机构层次码';
comment on column IG.QuartzProcessParticipant.qpporgname is '用户所属机构名称';
comment on column IG.QuartzProcessParticipant.qpptype is '参与类型';
comment on column IG.QuartzProcessParticipant.qppsubstatus is '子状态';
comment on column IG.QuartzProcessParticipant.qppuserinfo is '用户信息';
comment on column IG.QuartzProcessParticipant.qppcomment is '工作评语';
comment on column IG.QuartzProcessParticipant.qppstatus is '参与状态';
comment on column IG.QuartzProcessParticipant.qppattkey is '附件KEY';
comment on column IG.QuartzProcessParticipant.qppinittime is '指定时间';
comment on column IG.QuartzProcessParticipant.qppproctime is '处理完成时间';
comment on column IG.QuartzProcessParticipant.fingerprint is '时间戳';

--QuartzProcessInfo
comment on table IG.QuartzProcessInfo is '定时流程表单信息表';
comment on column IG.QuartzProcessInfo.qpiid is '自增主键';
comment on column IG.QuartzProcessInfo.qprid is '定时流程ID';
comment on column IG.QuartzProcessInfo.qpivarname is '表单标识';
comment on column IG.QuartzProcessInfo.qpivarlabel is '表单显示名称';
comment on column IG.QuartzProcessInfo.qpivartype is '表单类型';
comment on column IG.QuartzProcessInfo.qpivarvalue is '表单值';
comment on column IG.QuartzProcessInfo.qpiattkey is '附件KEY';
comment on column IG.QuartzProcessInfo.fingerprint is '时间戳';
comment on column IG.QuartzProcessInfo.qpidid is '表单定义ID';

--Notification
comment on table IG.Notification is '系统集成（保留）';

--RiskAudit
comment on table IG.RiskAudit is '风险审计表';
comment on column IG.RiskAudit.raid is '审计ID';
comment on column IG.RiskAudit.raversion is '审计版本';
comment on column IG.RiskAudit.radate is '创建日期';
comment on column IG.RiskAudit.rauserid is '创建人ID';
comment on column IG.RiskAudit.rausername is '创建人姓名';
comment on column IG.RiskAudit.racode is '版本编号';
comment on column IG.RiskAudit.radesc is '描述';
comment on column IG.RiskAudit.rastatus is '状态';
comment on column IG.RiskAudit.fingerprint is '时间戳';

--RiskAuditDef
comment on table IG.RiskAuditDef is '风险审计项信息表';
comment on column IG.RiskAuditDef.radid is '审计项ID';
comment on column IG.RiskAuditDef.raid is '审计ID';
comment on column IG.RiskAuditDef.raversion is '审计版本';
comment on column IG.RiskAuditDef.radname is '审计项名称';
comment on column IG.RiskAuditDef.radcode is '层次码';
comment on column IG.RiskAuditDef.radlevel is '级次';
comment on column IG.RiskAuditDef.radparcode is '上级层次码';
comment on column IG.RiskAuditDef.raddesc is '描述';
comment on column IG.RiskAuditDef.radrisklevel is '风险程度';
comment on column IG.RiskAuditDef.raduserid is '责任人ID';
comment on column IG.RiskAuditDef.radusername is '责任人姓名';
comment on column IG.RiskAuditDef.radorg is '责任部门名称';
comment on column IG.RiskAuditDef.radorgcoding is '责任部门层次码';
comment on column IG.RiskAuditDef.radstatus is '状态';
comment on column IG.RiskAuditDef.radmode is '控制手段';
comment on column IG.RiskAuditDef.radtype is '控制类型';
comment on column IG.RiskAuditDef.radfrequency is '控制频率';
comment on column IG.RiskAuditDef.fingerprint is '时间戳';

--RiskAuditIns
comment on table IG.RiskAuditIns is '风险审计实例表';
comment on column IG.RiskAuditIns.raiid is '实例ID';
comment on column IG.RiskAuditIns.raid is '审计ID';
comment on column IG.RiskAuditIns.raversion is '审计版本';
comment on column IG.RiskAuditIns.raicode is '审计编号';
comment on column IG.RiskAuditIns.raistart is '创建日期';
comment on column IG.RiskAuditIns.raiend is '结束日期';
comment on column IG.RiskAuditIns.raidesc is '描述';
comment on column IG.RiskAuditIns.raistatus is '状态';
comment on column IG.RiskAuditIns.fingerprint is '时间戳';

--RiskAuditResult
comment on table IG.RiskAuditResult is '风险审计评估表';
comment on column IG.RiskAuditResult.rarid is '评估ID';
comment on column IG.RiskAuditResult.raiid is '审计实例ID';
comment on column IG.RiskAuditResult.radid is '审计项ID';
comment on column IG.RiskAuditResult.rardate is '评估日期';
comment on column IG.RiskAuditResult.raruserid is '评估用户ID';
comment on column IG.RiskAuditResult.rarusername is '评估用户姓名';
comment on column IG.RiskAuditResult.rarplanscore is '评估制度建设评分';
comment on column IG.RiskAuditResult.rarplandesc is '评估制度建设评价';
comment on column IG.RiskAuditResult.rarexecscore is '评估制度执行评分';
comment on column IG.RiskAuditResult.rarexecdesc is '评估制度执行评价';
comment on column IG.RiskAuditResult.raroverallscore is '评估总体评分';
comment on column IG.RiskAuditResult.raroveralldesc is '评估总体评价';
comment on column IG.RiskAuditResult.rarcomment is '评估意见';
comment on column IG.RiskAuditResult.fingerprint is '时间戳';
comment on column IG.RiskAuditResult.radcode is '审计项层次码';

--RiskCheck
comment on table IG.RiskCheck is '风险检查表';
comment on column IG.RiskCheck.rcid is '检查ID';
comment on column IG.RiskCheck.rcname is '检查名称';
comment on column IG.RiskCheck.rcdesc is '描述';
comment on column IG.RiskCheck.rctype is '重要程度';
comment on column IG.RiskCheck.rcstatus is '状态';
comment on column IG.RiskCheck.rcstartdate is '开始日期';
comment on column IG.RiskCheck.rcenddate is '结束日期';
comment on column IG.RiskCheck.rcfrequency is '频率';
comment on column IG.RiskCheck.rccron is '策略执行表达式';
comment on column IG.RiskCheck.rcuserid is '责任人ID';
comment on column IG.RiskCheck.rcusername is '责任人姓名';
comment on column IG.RiskCheck.rcroleid is '责任组角色ID';
comment on column IG.RiskCheck.rcrolename is '责任组角色名称';
comment on column IG.RiskCheck.rcasset is '相关资产ID';
comment on column IG.RiskCheck.rcassetname is '相关资产名称';
comment on column IG.RiskCheck.rcattch is '附件KEY';
comment on column IG.RiskCheck.rcoption is '选项';
comment on column IG.RiskCheck.fingerprint is '时间戳';

--RiskCheckResult
comment on table IG.RiskCheckResult is '风险检查结果表';
comment on column IG.RiskCheckResult.rcrid is '结果ID';
comment on column IG.RiskCheckResult.rcid is '检查ID';
comment on column IG.RiskCheckResult.rcrplandate is '计划检查日期';
comment on column IG.RiskCheckResult.rcrrealtime is '实际检查时间';
comment on column IG.RiskCheckResult.rcruserid is '结果提交人ID';
comment on column IG.RiskCheckResult.rcrusername is '结果提交人姓名';
comment on column IG.RiskCheckResult.rcrresult is '检查结果';
comment on column IG.RiskCheckResult.rcrcomment is '说明';
comment on column IG.RiskCheckResult.rcrattch is '附件KEY';
comment on column IG.RiskCheckResult.fingerprint is '时间戳';
comment on column IG.RiskCheckResult.rctype is '重要程度';

--AuditCheckRelation
comment on table IG.AuditCheckRelation is '风险检查与风险审计关系表';
comment on column IG.AuditCheckRelation.acrid is '自增主键';
comment on column IG.AuditCheckRelation.rcid is '检查ID';
comment on column IG.AuditCheckRelation.radid is '审计项ID';
comment on column IG.AuditCheckRelation.radcode is '审计项层次码';
comment on column IG.AuditCheckRelation.fingerprint is '时间戳';

--DUTYAUDITDEF
comment on table IG.DUTYAUDITDEF is '值班检查项定义表';
comment on column IG.DUTYAUDITDEF.DADID is '检查项ID';
comment on column IG.DUTYAUDITDEF.DADCATEGORY is '值班类型';
comment on column IG.DUTYAUDITDEF.DADTYPE is '分类';
comment on column IG.DUTYAUDITDEF.DADNAME is '检查名称';
comment on column IG.DUTYAUDITDEF.DADLIMTIME is '填报时间限制';
comment on column IG.DUTYAUDITDEF.DADCONTENT is '检查内容';
comment on column IG.DUTYAUDITDEF.DADINFO is '说明';
comment on column IG.DUTYAUDITDEF.DADSTATUS is '状态';
comment on column IG.DUTYAUDITDEF.DADUSERID is '更新人ID';
comment on column IG.DUTYAUDITDEF.DADUSERNAME is '更新人姓名';
comment on column IG.DUTYAUDITDEF.DADUPDTIME is '更新时间';
comment on column IG.DUTYAUDITDEF.DADORDERBY is '排序标识';
comment on column IG.DUTYAUDITDEF.PERIODTYPE is '周期类型';
comment on column IG.DUTYAUDITDEF.PERIODVALUE is '周期时间';
comment on column IG.DUTYAUDITDEF.FINGERPRINT is '时间戳';

--DUTYAUDITTIME
comment on table IG.DUTYAUDITTIME is '值班检查项检查时间表';
comment on column IG.DUTYAUDITTIME.DATID is '自增主键';
comment on column IG.DUTYAUDITTIME.DADID is '检查项ID';
comment on column IG.DUTYAUDITTIME.DATTIME is '检查项时间';
comment on column IG.DUTYAUDITTIME.DATLIMTIME is '限制时间';
comment on column IG.DUTYAUDITTIME.FINGERPRINT is '时间戳';

--DUTYPLAN
comment on table IG.DUTYPLAN is '值班计划表';
comment on column IG.DUTYPLAN.DPID is '值班计划ID';
comment on column IG.DUTYPLAN.DADCATEGORY is '值班类型';
comment on column IG.DUTYPLAN.DPTIME is '值班日期';
comment on column IG.DUTYPLAN.DPTYPE is '值班类型';
comment on column IG.DUTYPLAN.DPSTATUS is '状态';
comment on column IG.DUTYPLAN.DPQUESTION is '遗留问题';
comment on column IG.DUTYPLAN.DPINFO is '总结';
comment on column IG.DUTYPLAN.DPUSERID is '交班人ID';
comment on column IG.DUTYPLAN.DPUSERNAME is '交班人姓名';
comment on column IG.DUTYPLAN.DPCRETIME is '登记时间';
comment on column IG.DUTYPLAN.DPUPDTIME is '更新时间';
comment on column IG.DUTYPLAN.DPFINTIME is '交班时间';
comment on column IG.DUTYPLAN.DPREMARKS is '备注';
comment on column IG.DUTYPLAN.FINGERPRINT is '时间戳';

--DUTYPERSON
comment on table IG.DUTYPERSON is '值班人表';
comment on column IG.DUTYPERSON.DPERID is '自增主键';
comment on column IG.DUTYPERSON.DPID is '值班计划ID';
comment on column IG.DUTYPERSON.DPERTIME is '值班日期';
comment on column IG.DUTYPERSON.DPTYPE is '值班类型';
comment on column IG.DUTYPERSON.DPERUSERID is '值班人ID';
comment on column IG.DUTYPERSON.DPERUSERNAME is '值班人姓名';
comment on column IG.DUTYPERSON.FINGERPRINT is '记录时间戳';

--DUTYRESULT
comment on table IG.DUTYRESULT is '值班检查结果表';
comment on column IG.DUTYRESULT.DRID is '结果ID';
comment on column IG.DUTYRESULT.DPID is '值班计划ID';
comment on column IG.DUTYRESULT.DADID is '检查项ID';
comment on column IG.DUTYRESULT.DADCATEGORY is '值班类型';
comment on column IG.DUTYRESULT.DADTYPE is '检查分类';
comment on column IG.DUTYRESULT.DADNAME is '检查名称';
comment on column IG.DUTYRESULT.DPTIME is '值班日期';
comment on column IG.DUTYRESULT.DPTYPE is '值班类型';
comment on column IG.DUTYRESULT.DATTIME is '检查时间';
comment on column IG.DUTYRESULT.DATLIMTIME is '填报时间限制';
comment on column IG.DUTYRESULT.DADCONTENT is '检查内容';
comment on column IG.DUTYRESULT.DRCONTENT is '检查结果';
comment on column IG.DUTYRESULT.DRFILLTIME is '填报时间（小时分）';
comment on column IG.DUTYRESULT.DRRESULT is '结果说明';
comment on column IG.DUTYRESULT.DRUSERID is '填报人ID';
comment on column IG.DUTYRESULT.DRUSERNAME is '填报人姓名';
comment on column IG.DUTYRESULT.DRCRETIME is '填报时间';
comment on column IG.DUTYRESULT.drlimdtime is '填报日/时限制';
comment on column IG.DUTYRESULT.FINGERPRINT is '时间戳';

--IG512
comment on table IG.IG512 is '流程关联关系表';
comment on column IG.IG512.prrid is '自增主键';
comment on column IG.IG512.parprid is '流程ID（主动）';
comment on column IG.IG512.cldprid is '流程ID（被动）';
comment on column IG.IG512.prrinstime is '创建时间';
comment on column IG.IG512.fingerprint is '时间戳';

--ReportFileDefinition
comment on table IG.ReportFileDefinition is '报表定义表';
comment on column IG.ReportFileDefinition.rfdid is '报表ID';
comment on column IG.ReportFileDefinition.rfdtitle is '报表名称';
comment on column IG.ReportFileDefinition.rfdtype is '报表分类';
comment on column IG.ReportFileDefinition.rfddesc is '报表说明';
comment on column IG.ReportFileDefinition.rfdfilename is '报表文件名';
comment on column IG.ReportFileDefinition.rfduserid is '登记人ID';
comment on column IG.ReportFileDefinition.rfdusername is '登记人姓名';
comment on column IG.ReportFileDefinition.rfdinstime is '登记时间';
comment on column IG.ReportFileDefinition.rfdversion is '当前版本';
comment on column IG.ReportFileDefinition.rfdnewversion is '最新版本';
comment on column IG.ReportFileDefinition.rfdpictype is '报表样式';
comment on column IG.ReportFileDefinition.fingerprint is '时间戳';
comment on column IG.ReportFileDefinition.rfdparameters is '报表参数';
comment on column IG.ReportFileDefinition.isflag is '是否为定制报表（0定制，1常规）';

--ReportFileVersion
comment on table IG.ReportFileVersion is '报表版本表';
comment on column IG.ReportFileVersion.rfvid is '自增主键';
comment on column IG.ReportFileVersion.rfdid is '报表ID';
comment on column IG.ReportFileVersion.rfvversion is '版本';
comment on column IG.ReportFileVersion.rfvinstime is '创建时间';
comment on column IG.ReportFileVersion.fingerprint is '时间戳';

--IG224
comment on table IG.IG224 is '流程状态日志表';
comment on column IG.IG224.rslid is '自增主键';
comment on column IG.IG224.prid is '流程ID';
comment on column IG.IG224.prpdid is '流程类型ID';
comment on column IG.IG224.prtype is '流程模版类型';
comment on column IG.IG224.prstatus is '流程状态';
comment on column IG.IG224.rslopentime is '开始时间';
comment on column IG.IG224.rslclosetime is '结束时间';
comment on column IG.IG224.rslExpect is '是否超时';
comment on column IG.IG224.fingerprint is '时间戳';

--IG899
comment on table IG.IG899 is '流程私有表单表';
comment on column IG.IG899.PPIID is '自增主键';
comment on column IG.IG899.PIDID is '表单定义ID';
comment on column IG.IG899.PIID is '流程表单ID';
comment on column IG.IG899.ROLEID is '处理角色ID';
comment on column IG.IG899.USERID is '处理人ID';
comment on column IG.IG899.PPIVALUE is '表单值';
comment on column IG.IG899.PPIATTKEY is '附件KEY';
comment on column IG.IG899.FINGERPRINT is '时间戳';

--IG463
comment on table IG.IG463 is '流程代办授权工作表';
comment on column IG.IG463.ppwid is '自增主键';
comment on column IG.IG463.ppwprid is '流程ID';
comment on column IG.IG463.ppwprtype is '流程模版类型';
comment on column IG.IG463.ppwprserialnum is '流程工单号';
comment on column IG.IG463.ppwprtitle is '流程标题';
comment on column IG.IG463.ppwauthorizeuserid is '授权人ID';
comment on column IG.IG463.ppwproxyuserid is '代理人ID';
comment on column IG.IG463.ppwproxyusername is '代理人姓名';
comment on column IG.IG463.ppwoptiontime is '代理人处理时间';
comment on column IG.IG463.ppwcloseflag is '是否关闭';
comment on column IG.IG463.fingerPrint is '时间戳';

--IG213
comment on table IG.IG213 is '自定义流程角色范围表';
comment on column IG.IG213.prtdid is '自增主键';
comment on column IG.IG213.pdid is '流程类型ID';
comment on column IG.IG213.roletype is '角色类型';
comment on column IG.IG213.fingerprint is '时间戳';

--IG243
comment on table IG.IG243 is '自定义流程标题定义表';
comment on column IG.IG243.ptdid is '自增主键';
comment on column IG.IG243.pdid is '流程类型ID';
comment on column IG.IG243.ptitlename is '标题表单显示名称';
comment on column IG.IG243.ptitleaccess is '标题表单是否可见';
comment on column IG.IG243.pdescname is '描述表单显示名称';
comment on column IG.IG243.pdescaccess is '描述表单是否可见';
comment on column IG.IG243.fingerprint is '时间戳';

--IG298
comment on table IG.IG298 is '自定义流程状态可分派角色定义表';
comment on column IG.IG298.psrdid is '自增主键';
comment on column IG.IG298.psdid is '流程状态ID';
comment on column IG.IG298.roleid is '角色ID';
comment on column IG.IG298.fingerprint is '时间戳';

--IG156
comment on table IG.IG156 is '自定义流程状态按钮事件定义表';
comment on column IG.IG156.PSEID is '自增主键';
comment on column IG.IG156.PDID is '流程类型ID'; 
comment on column IG.IG156.PSDID is '流程状态ID';
comment on column IG.IG156.PSEBUTTONID is '按钮ID';
comment on column IG.IG156.PSEACTIONID is '处理BL标识';
comment on column IG.IG156.PSEORDER is '执行顺序'; 
comment on column IG.IG156.PSEDEC is '描述';
comment on column IG.IG156.FINGERPRINT is '时间戳';
comment on column IG.IG156.PSBDNAME is '按钮授权时的别名';

--IG212
comment on table IG.IG212 is '自定义流程通知策略定义表';
comment on column IG.IG212.PSDID is '流程状态ID';
comment on column IG.IG212.PSDCONFIRM is '是否确认状态';
comment on column IG.IG212.SMS is '是否发送短信';
comment on column IG.IG212.EMAIL is '是否发送邮件';
comment on column IG.IG212.NOTIFYD is '再次提醒时间（天）';
comment on column IG.IG212.NOTIFYH is '再次提醒时间（小时）';
comment on column IG.IG212.NOTIFYM is '再次提醒时间（分）';
comment on column IG.IG212.REPORTD is '上报时间（天）';
comment on column IG.IG212.REPORTH is '上报时间（小时）';
comment on column IG.IG212.REPORTM is '上报时间（分）';
comment on column IG.IG212.ROLEMANAGER is '通知人类型';
comment on column IG.IG212.FINGERPRINT is '时间戳';

--IG237
comment on table IG.IG237 is '自定义流程策略通知人定义表';
comment on column IG.IG237.PSDID is '流程状态ID';
comment on column IG.IG237.PSDCONFIRM is '是否确认状态';
comment on column IG.IG237.USERID is '用户ID';
comment on column IG.IG237.ROLEID is '角色ID';
comment on column IG.IG237.FINGERPRINT is '时间戳';

--IG202
comment on table IG.IG202 is '流程通用表单定义表';
comment on column IG.IG202.PIDID is '表单定义ID'; 
comment on column IG.IG202.PIDNAME is '表单标识';
comment on column IG.IG202.PIDLABEL is '表单显示名称'; 
comment on column IG.IG202.PIDDESC is '表单描述';
comment on column IG.IG202.PIDTYPE is '表单类型'; 
comment on column IG.IG202.PIDOPTION is '表单取值范围';
comment on column IG.IG202.PIDDEFAULT is '表单默认值'; 
comment on column IG.IG202.PIDREQUIRED is '是否必填'; 
comment on column IG.IG202.PIDSORTID is '排序标识'; 
comment on column IG.IG202.CCID is '树型数据分类ID';
comment on column IG.IG202.PIDMODE is '表单模式';
comment on column IG.IG202.PRIVATESCOPE is '私有表单权限范围';
comment on column IG.IG202.ROWWIDTH is '表单行显示模式';
comment on column IG.IG202.FINGERPRINT is '时间戳';

--CUSTOMREPORT
comment on table IG.CUSTOMREPORT is '定制报表信息表';
comment on column IG.CUSTOMREPORT.CRID is '自增主键'; 
comment on column IG.CUSTOMREPORT.USERID is '定制用户ID';
comment on column IG.CUSTOMREPORT.RFDID is '报表ID';
comment on column IG.CUSTOMREPORT.ORDERNUM is '排序标识';
comment on column IG.CUSTOMREPORT.FINGERPRINT is '时间戳'; 

--ROLEREPORT
comment on table IG.ROLEREPORT is '报表授权信息表';
comment on column IG.ROLEREPORT.RRID is '自增主键'; 
comment on column IG.ROLEREPORT.ROLEID is '角色ID';  
comment on column IG.ROLEREPORT.RFDID is '报表ID'; 
comment on column IG.ROLEREPORT.RRPERM is '权限（保留）'; 
comment on column IG.ROLEREPORT.RRDESC is '说明（保留）'; 
comment on column IG.ROLEREPORT.FINGERPRINT is '时间戳';

--SEQUENCE_GENERATOR_TABLE
comment on table IG.SEQUENCE_GENERATOR_TABLE is '主键序列表';
comment on column IG.SEQUENCE_GENERATOR_TABLE.SEQUENCE_NAME is '序列标识';
comment on column IG.SEQUENCE_GENERATOR_TABLE.SEQUENCE_VALUE is '序列值';

--HOTLINK
comment on table IG.HOTLINK is '常用链接';
comment on column IG.HOTLINK.hid is '自增主键';
comment on column IG.HOTLINK.userid is '用户ID';
comment on column IG.HOTLINK.hname is '链接显示名称';
comment on column IG.HOTLINK.hlink is '链接URL';
comment on column IG.HOTLINK.horder is '显示顺序';
comment on column IG.HOTLINK.fingerprint is '时间戳';

--IG731
comment on table IG.IG731 is '流程相关资产关联表';
comment on column IG.IG731.pieid is '自增主键';
comment on column IG.IG731.prid is '流程ID';
comment on column IG.IG731.piid is '流程表单ID';
comment on column IG.IG731.eiid is '资产ID';
comment on column IG.IG731.fingerprint is '时间戳';

--QuartzProcessInfoEntity
comment on table IG.QuartzProcessInfoEntity is '定时流程相关资产关联表';
comment on column IG.QuartzProcessInfoEntity.qpieid is '自增主键';
comment on column IG.QuartzProcessInfoEntity.qprid is '流程ID';
comment on column IG.QuartzProcessInfoEntity.qpiid is '流程表单ID';
comment on column IG.QuartzProcessInfoEntity.qeiid is '资产ID';
comment on column IG.QuartzProcessInfoEntity.fingerprint is '时间戳';

--QuartzJobDetails
comment on table IG.QuartzJobDetails is '日常运维计划信息表';
comment on column IG.QuartzJobDetails.qjdid is '自增主键';
comment on column IG.QuartzJobDetails.qjid is '定时任务ID';
comment on column IG.QuartzJobDetails.qjdtriname is '触发器名称';
comment on column IG.QuartzJobDetails.qjdtrigrpname is '触发器所属组名称';
comment on column IG.QuartzJobDetails.qjdtime is '执行时间';
comment on column IG.QuartzJobDetails.qjdweek is '星期几';
comment on column IG.QuartzJobDetails.qjdtype is '执行状态';
comment on column IG.QuartzJobDetails.FINGERPRINT is '时间戳';

--IG433
comment on table IG.IG433 is '流程评审信息表';
comment on column IG.IG433.paid is '自增主键';
comment on column IG.IG433.paprid is '流程ID';
comment on column IG.IG433.pauserid is '评审人ID';
comment on column IG.IG433.paprname is '流程标题';
comment on column IG.IG433.paassessmentdes is '评审内容';
comment on column IG.IG433.paassessmentdate is '评审时间';
comment on column IG.IG433.paeventtypecode is '事件类别';
comment on column IG.IG433.PAATTKEY is '附件KEY';
comment on column IG.IG433.PASTATUS is '状态';
comment on column IG.IG433.fingerprint is '时间戳';

--IG229
comment on table IG.IG229 is '流程影响业务系统信息表';
comment on column IG.IG229.padid is '自增主键';
comment on column IG.IG229.padprid is '流程ID';
comment on column IG.IG229.padaffectsystem is '影响业务系统';
comment on column IG.IG229.padstart is '影响开始时间';
comment on column IG.IG229.padend is '影响结束时间';
comment on column IG.IG229.fingerprint is '时间戳';

--IG105
comment on table IG.IG105 is '流程策略定义信息';
comment on column IG.IG105.pdid is '流程类型ID';
comment on column IG.IG105.prstatus is '流程状态';
comment on column IG.IG105.prurgency is '紧急程度';
comment on column IG.IG105.psdversion is '策略版本';
comment on column IG.IG105.expecttime is '期望解决时间';
comment on column IG.IG105.createtime is '创建时间';
comment on column IG.IG105.fingerprint is '时间戳';

--PRIORITY
comment on table IG.PRIORITY is '流程优先级定义表';
comment on column IG.PRIORITY.uvalue is '紧急程度';
comment on column IG.PRIORITY.ivalue is '影响程度';
comment on column IG.PRIORITY.pprtype is '流程类型ID';
comment on column IG.PRIORITY.pvalue is '优先级';
comment on column IG.PRIORITY.FINGERPRINT is '时间戳';

--KNOWLEDGE
comment on table IG.KNOWLEDGE is '知识表';
comment on column IG.KNOWLEDGE.KNID is '知识ID';
comment on column IG.KNOWLEDGE.KNVERSION is '知识版本';
comment on column IG.KNOWLEDGE.KNSERIAL is '编号';
comment on column IG.KNOWLEDGE.KNDEPARTMENT is '部门';
comment on column IG.KNOWLEDGE.KNAPPROVER is '归档人ID';
comment on column IG.KNOWLEDGE.KNAPPROVERNAME is '归档人姓名';
comment on column IG.KNOWLEDGE.KNAPPROVETIME is '归档时间';
comment on column IG.KNOWLEDGE.KNCLASS is '分类';
comment on column IG.KNOWLEDGE.KNCLASSNAME is '类别名称';
comment on column IG.KNOWLEDGE.KNAREA is '业务领域标识';
comment on column IG.KNOWLEDGE.KNAREANAME is '业务领域名称';
comment on column IG.KNOWLEDGE.KNTELAREA is '技术领域标识';
comment on column IG.KNOWLEDGE.KNTELAREANAME is '技术领域名称';
comment on column IG.KNOWLEDGE.KNKEY is '关键字';
comment on column IG.KNOWLEDGE.KNORIGIN is '来源标识';
comment on column IG.KNOWLEDGE.KNORIGINNAME is '来源名称';
comment on column IG.KNOWLEDGE.KNPROFFER is '贡献人ID';
comment on column IG.KNOWLEDGE.KNPROFFERNAME is '贡献人名称';
comment on column IG.KNOWLEDGE.KNPROFFERTIME is '贡献时间';
comment on column IG.KNOWLEDGE.KNTITLE is '标题';
comment on column IG.KNOWLEDGE.KNDES is '问题描述';
comment on column IG.KNOWLEDGE.KNFAULTCAUSE is '故障原因总结';
comment on column IG.KNOWLEDGE.KNSOLVEWAY is '解决办法';
comment on column IG.KNOWLEDGE.KNSTATUS is '状态';
comment on column IG.KNOWLEDGE.KNREJECT is '驳回原因';
comment on column IG.KNOWLEDGE.KNATTKEY is '附件KEY';
comment on column IG.KNOWLEDGE.FINGERPRINT is '时间戳';
comment on column IG.KNOWLEDGE.KNAPPROVEROLE is '审批角色ID';

--KNOWLEDGEAPPIMPACT
comment on table IG.KNOWLEDGEAPPIMPACT is '知识与业务系统关联表';
comment on column IG.KNOWLEDGEAPPIMPACT.KAIID is '自增主键';
comment on column IG.KNOWLEDGEAPPIMPACT.KNID is '知识ID';
comment on column IG.KNOWLEDGEAPPIMPACT.KAICODE is '业务系统标识';
comment on column IG.KNOWLEDGEAPPIMPACT.FINGERPRINT is '时间戳';
comment on column IG.KNOWLEDGEAPPIMPACT.KNVERSION is '知识版本';

--KNOWLEDGEGRADE
comment on table IG.KNOWLEDGEGRADE is '知识评分表';
comment on column IG.KNOWLEDGEGRADE.KGID is '自增主键';
comment on column IG.KNOWLEDGEGRADE.KNID is '知识ID';
comment on column IG.KNOWLEDGEGRADE.KGGRADE is '知识评分';
comment on column IG.KNOWLEDGEGRADE.KGAPPRAISE is '知识评价';
comment on column IG.KNOWLEDGEGRADE.KGUSERID is '评分人ID';
comment on column IG.KNOWLEDGEGRADE.KGTIME is '评分时间';
comment on column IG.KNOWLEDGEGRADE.FINGERPRINT is '时间戳';

--KNOWLEDGEPROCESS
comment on table IG.KNOWLEDGEPROCESS is '知识与流程关联表';
comment on column IG.KNOWLEDGEPROCESS.KPID is '自增主键';
comment on column IG.KNOWLEDGEPROCESS.KNID is '知识ID';
comment on column IG.KNOWLEDGEPROCESS.KNVERSION is '知识版本';
comment on column IG.KNOWLEDGEPROCESS.PRID is '流程ID';
comment on column IG.KNOWLEDGEPROCESS.SFID is '服务工单ID';
comment on column IG.KNOWLEDGEPROCESS.CONNECTTYPE is '关联类型';
comment on column IG.KNOWLEDGEPROCESS.KPEFFECT is '是否有效标识';
comment on column IG.KNOWLEDGEPROCESS.FINGERPRINT is '时间戳';

--KNOWLOG
comment on table IG.KNOWLOG is '知识日志表';
comment on column IG.KNOWLOG.KLID is '自增主键';
comment on column IG.KNOWLOG.KLKID is '知识ID';
comment on column IG.KNOWLOG.KLTIME is '记录时间';
comment on column IG.KNOWLOG.KLROLEID is '角色ID';
comment on column IG.KNOWLOG.KLROLENAME is '角色名称';
comment on column IG.KNOWLOG.KLUSERID is '用户ID';
comment on column IG.KNOWLOG.KLUSERNAME is '用户姓名';
comment on column IG.KNOWLOG.KLDESC is '描述';
comment on column IG.KNOWLOG.KLCOMMEND is '备注';
comment on column IG.KNOWLOG.KLORGID is '机构层次码';
comment on column IG.KNOWLOG.KLORGNAME is '机构名称';
comment on column IG.KNOWLOG.FINGERPRINT is '时间戳';

--DELAY
comment on table IG.DELAY is '延时解锁信息表';
comment on column IG.DELAY.ID is '自增主键';
comment on column IG.DELAY.DATETIME is '日期';
comment on column IG.DELAY.ORGNAME is '申请单位';
comment on column IG.DELAY.TITLE is '申请标题';
comment on column IG.DELAY.HZNAME is '行长姓名';
comment on column IG.DELAY.HZTEL is '行长电话';
comment on column IG.DELAY.JLNAME is '经理姓名';
comment on column IG.DELAY.JLTEL is '经理电话';
comment on column IG.DELAY.REMARK is '备注';
comment on column IG.DELAY.STARTTIME is '开始时间';
comment on column IG.DELAY.ENDTIME is '结束时间';
comment on column IG.DELAY.OPERATER is '操作人';
comment on column IG.DELAY.FINGERPRINT is '时间戳';
comment on column IG.DELAY.UNLOCKTIME is '解锁时间';

--ONDUTYPERSONRECORD
comment on table IG.ONDUTYPERSONRECORD is '日常维护登记表';
comment on column IG.ONDUTYPERSONRECORD.ODPRID is '自增主键';
comment on column IG.ONDUTYPERSONRECORD.ODPRGUEST is '来访人员';
comment on column IG.ONDUTYPERSONRECORD.ODPRGUESTORG is '所属单位';
comment on column IG.ONDUTYPERSONRECORD.ODPRGUESTIDNUM is '身份证明';
comment on column IG.ONDUTYPERSONRECORD.ODPRAREA is '进入区域';
comment on column IG.ONDUTYPERSONRECORD.ODPRCTIME is '进入时间';
comment on column IG.ONDUTYPERSONRECORD.ODPRLTIME is '离开时间';
comment on column IG.ONDUTYPERSONRECORD.ODPROPTER is '操作人';
comment on column IG.ONDUTYPERSONRECORD.ODPRACTER is '批准人';
comment on column IG.ONDUTYPERSONRECORD.ODPRUSERNAME is '记录人';
comment on column IG.ONDUTYPERSONRECORD.ODPRTARGET is '操作目标';
comment on column IG.ONDUTYPERSONRECORD.ODPRRECORD is '操作记录';
comment on column IG.ONDUTYPERSONRECORD.ODPRINSERTTIME is '记录时间';
comment on column IG.ONDUTYPERSONRECORD.ODPRMODTIME is '编辑时间';
comment on column IG.ONDUTYPERSONRECORD.FINGERPRINT is '时间戳';

--EIBELONGRELATION
comment on table IG.EIBELONGRELATION is '配置所属关系表';
comment on column IG.EIBELONGRELATION.BRID is '逻辑主键';
comment on column IG.EIBELONGRELATION.BRPAREIID is '源资产ID';
comment on column IG.EIBELONGRELATION.BRPARVERSION is '源资产大版本';
comment on column IG.EIBELONGRELATION.BRPARSMALLVERSION is '源资产小版本';
comment on column IG.EIBELONGRELATION.BRCLDEIID is '目的资产ID';
comment on column IG.EIBELONGRELATION.BRCLDVERSION is '目的资产大版本';
comment on column IG.EIBELONGRELATION.BRCLDSMALLVERSION is '目的资产小版本';
comment on column IG.EIBELONGRELATION.BRTYPE is '关系类型(物理/逻辑)';
comment on column IG.EIBELONGRELATION.BRDES is '关系说明';
comment on column IG.EIBELONGRELATION.BRCREATETIME is '创建时间';
comment on column IG.EIBELONGRELATION.BRRALETIONCODE is '关联关系码';
comment on column IG.EIBELONGRELATION.BRASSETRELATION is '资产关系项';
comment on column IG.EIBELONGRELATION.EIROOTMARK is '资产所属树根节点实体标识';
comment on column IG.EIBELONGRELATION.DELETEFLAG is '逻辑删除标识';
comment on column IG.EIBELONGRELATION.FINGERPRINT is '时间戳';


--SOC0101 
comment on table IG.SOC0101 is '审计资产属性表';
comment on column IG.SOC0101.CIID is '资产属性ID';
comment on column IG.SOC0101.CID is '资产模型属性ID';
comment on column IG.SOC0101.EIID is '资产ID';
comment on column IG.SOC0101.EID is '资产模型ID';
comment on column IG.SOC0101.CIVALUE is '资产属性值';
comment on column IG.SOC0101.CIUPDTIME is '资产属性更新时间';
comment on column IG.SOC0101.ESYSCODING is '资产模型层次码';
comment on column IG.SOC0101.CIEXPIRE is '资产属性失效时间';
comment on column IG.SOC0101.CISTATUS is '资产属性状态';
comment on column IG.SOC0101.CICURVER is '资产属性当前版本号';
comment on column IG.SOC0101.CIVERINFO is '资产属性版本信息';
comment on column IG.SOC0101.CISMALLVERSION is '资产属性小版本';
comment on column IG.SOC0101.CIVERSION is '资产属性大版本';
comment on column IG.SOC0101.FINGERPRINT is '时间戳';

--SOC0102 
comment on table IG.SOC0102 is '审计资产表';
comment on column IG.SOC0102.EIID is '资产ID';
comment on column IG.SOC0102.EID is '资产模型ID';
comment on column IG.SOC0102.EIDESC is '资产说明';
comment on column IG.SOC0102.EINAME is '资产名称';
comment on column IG.SOC0102.EILABEL is '资产编号';
comment on column IG.SOC0102.EIINSDATE is '资产登记日';
comment on column IG.SOC0102.EIORGSYSCODING is '资产所属机构层次码';
comment on column IG.SOC0102.ESYSCODING is '资产模型层次码';
comment on column IG.SOC0102.EIUPDTIME is '资产更新时间';
comment on column IG.SOC0102.EISTATUS is '资产状态';
comment on column IG.SOC0102.EIUSERID is '资产管理人';
comment on column IG.SOC0102.EIUSERNAME is '资产管理人姓名';
comment on column IG.SOC0102.EIROOTMARK is '顶级CI标识';
comment on column IG.SOC0102.EISMALLVERSION is '资产小版本';
comment on column IG.SOC0102.EIVERSION is '资产大版本';
comment on column IG.SOC0102.FINGERPRINT is '时间戳';

--SOC0103 
comment on table IG.SOC0103 is '审计对比结果信息表';
comment on column IG.SOC0103.AURID is '审计对比结果';
comment on column IG.SOC0103.AUTID is '审计任务ID';
comment on column IG.SOC0103.AUTIME is '审计时间戳';
comment on column IG.SOC0103.AUCMPTYPE is '对比结果类型';
comment on column IG.SOC0103.EIID is '资产ID';
comment on column IG.SOC0103.EIVERSION is '大版本';
comment on column IG.SOC0103.EISMALLVERSION is '小版本';
comment on column IG.SOC0103.EINAME is '资产名称';
comment on column IG.SOC0103.ESYSCODING is '资产层次码';
comment on column IG.SOC0103.EIROOTMARK is '顶级CI标识';
comment on column IG.SOC0103.CIID is '属性ID';
comment on column IG.SOC0103.CNAME is '属性名';
comment on column IG.SOC0103.CIVALUE is '当前版本值';
comment on column IG.SOC0103.AUVALUE is '采集值';
comment on column IG.SOC0103.AUFLAG is '合理标识';
comment on column IG.SOC0103.AURESULTDESC is '审计结果说明';
comment on column IG.SOC0103.FINGERPRINT is '时间戳';

--SOC0104 
comment on table IG.SOC0104 is '审计任务表';
comment on column IG.SOC0104.AUTID is '逻辑主键';
comment on column IG.SOC0104.AUTDESC is '审计任务描述';
comment on column IG.SOC0104.AUTTIME is '审计时间戳';
comment on column IG.SOC0104.AUTSTATUS is '审计任务状态';
comment on column IG.SOC0104.AUTUPDTIME is '审计任务更新时间';
comment on column IG.SOC0104.AUTCOMPTIME is 'AUTCOMPTIME';
comment on column IG.SOC0104.FINGERPRINT is '时间戳';

--SOC0105 
comment on table IG.SOC0105 is '审计待处理任务表';
comment on column IG.SOC0105.AUWTID is '逻辑主键';
comment on column IG.SOC0105.AUWTCREATETIME is '任务创建时间';
comment on column IG.SOC0105.AUWTFILENAME is '源文件名';
comment on column IG.SOC0105.AUWTTOPCI is '顶级CI';
comment on column IG.SOC0105.AUWTSTATUS is '状态';
comment on column IG.SOC0105.AUWTPARSESTART is '解析开始时间';
comment on column IG.SOC0105.AUWTPARSEEND is '解析结束时间';
comment on column IG.SOC0105.AUWTCISTART is 'CI实体生成开始时间';
comment on column IG.SOC0105.AUWTCIEND is 'CI实体生成结束时间';
comment on column IG.SOC0105.DELETEFLAG is '删除标识';
comment on column IG.SOC0105.IMPTYPEID is '导入程序类型ID';
comment on column IG.SOC0105.FINGERPRINT is '时间戳';

--SOC0106 
comment on table IG.SOC0106 is '审计待处理任务临时表';
comment on column IG.SOC0106.AWTID is '逻辑主键';
comment on column IG.SOC0106.FILENAME is '文件名';
comment on column IG.SOC0106.BATNAME is 'BAT文件名';
comment on column IG.SOC0106.EINAME is '实体名称';
comment on column IG.SOC0106.AUWTID is '实体ID';
comment on column IG.SOC0106.FINGERPRINT is '时间戳';

--SOC0107 
comment on table IG.SOC0107 is '资产属性信息表';
comment on column IG.SOC0107.CIID is '资产属性ID';
comment on column IG.SOC0107.CID is '资产模型属性ID';
comment on column IG.SOC0107.EIID is '资产ID';
comment on column IG.SOC0107.EID is '资产模型ID';
comment on column IG.SOC0107.CIVALUE is '资产属性值';
comment on column IG.SOC0107.CIUPDTIME is '资产属性更新时间';
comment on column IG.SOC0107.ESYSCODING is '资产模型层次码';
comment on column IG.SOC0107.CIEXPIRE is '资产属性失效时间';
comment on column IG.SOC0107.CISTATUS is '资产属性状态';
comment on column IG.SOC0107.CICURVER is '资产属性当前版本号';
comment on column IG.SOC0107.CIVERSION is '资产属性版本号';
comment on column IG.SOC0107.CIVERINFO is '资产属性版本信息';
comment on column IG.SOC0107.FINGERPRINT is '时间戳';
comment on column IG.SOC0107.CISMALLVERSION is '资产属性小版本';

--SOC0108 
comment on table IG.SOC0108 is '资产属性信息临时表';
comment on column IG.SOC0108.CIID is '资产属性ID';
comment on column IG.SOC0108.CID is '资产模型属性ID';
comment on column IG.SOC0108.EIID is '资产ID';
comment on column IG.SOC0108.EID is '资产模型ID';
comment on column IG.SOC0108.CIVALUE is '资产属性值';
comment on column IG.SOC0108.CIUPDTIME is '资产属性更新时间';
comment on column IG.SOC0108.ESYSCODING is '资产模型层次码';
comment on column IG.SOC0108.CIEXPIRE is '资产属性失效时间';
comment on column IG.SOC0108.CISTATUS is '资产属性状态';
comment on column IG.SOC0108.CICURVER is '资产属性当前版本号';
comment on column IG.SOC0108.CIVERSION is '资产属性版本号';
comment on column IG.SOC0108.CIVERINFO is '资产属性版本信息';
comment on column IG.SOC0108.FINGERPRINT is '时间戳';
comment on column IG.SOC0108.CISMALLVERSION is '资产属性小版本';

--SOC0109 
comment on table IG.SOC0109 is '资产模型属性信息表';
comment on column IG.SOC0109.CID is '资产模型属性ID';
comment on column IG.SOC0109.EID is '资产模型ID';
comment on column IG.SOC0109.CNAME is '资产模型属性名称';
comment on column IG.SOC0109.CLABEL is '资产模型属性编号';
comment on column IG.SOC0109.CDESC is '资产模型属性说明';
comment on column IG.SOC0109.CUNIT is '资产模型属性单位';
comment on column IG.SOC0109.CSTATUS is '资产模型属性状态';
comment on column IG.SOC0109.CSEQ is '资产模型属性是否显示标识';
comment on column IG.SOC0109.CCATEGORY is '资产模型属性所属模型的模型分类';
comment on column IG.SOC0109.COPTION is '资产模型属性取值范围ID';
comment on column IG.SOC0109.CATTACH is '资产模型属性数据类型';
comment on column IG.SOC0109.ESYSCODING is '资产模型属性所属模型层次码';
comment on column IG.SOC0109.FINGERPRINT is '时间戳';
comment on column IG.SOC0109.CREQUIRED is '资产模型属性必填项';

--SOC0110 
comment on table IG.SOC0110 is '配置所属关系表';
comment on column IG.SOC0110.BRID is '逻辑主键';
comment on column IG.SOC0110.BRPAREIID is '源资产ID';
comment on column IG.SOC0110.BRPARVERSION is '源资产大版本';
comment on column IG.SOC0110.BRPARSMALLVERSION is '源资产小版本';
comment on column IG.SOC0110.BRCLDEIID is '目的资产ID';
comment on column IG.SOC0110.BRCLDVERSION is '目的资产大版本';
comment on column IG.SOC0110.BRCLDSMALLVERSION is '目的资产小版本';
comment on column IG.SOC0110.BRTYPE is '关系类型(物理/逻辑)';
comment on column IG.SOC0110.BRDES is '关系说明';
comment on column IG.SOC0110.BRCREATETIME is '创建时间';
comment on column IG.SOC0110.BRRALETIONCODE is '关联关系码';
comment on column IG.SOC0110.BRASSETRELATION is '资产关系项';
comment on column IG.SOC0110.EIROOTMARK is '资产所属树根节点实体标识';
comment on column IG.SOC0110.DELETEFLAG is '逻辑删除标识';
comment on column IG.SOC0110.FINGERPRINT is '时间戳';

--SOC0111 
comment on table IG.SOC0111 is '资产域定义表';
comment on column IG.SOC0111.EIDDID is '逻辑主键';
comment on column IG.SOC0111.VERSION is '版本号';
comment on column IG.SOC0111.NAME is '名称';
comment on column IG.SOC0111.DESCRIPTION is '描述';
comment on column IG.SOC0111.CREATETIME is '创建时间';
comment on column IG.SOC0111.UPDATETIME is '更新时间';
comment on column IG.SOC0111.FINGERPRINT is '时间戳';

--SOC0112 
comment on table IG.SOC0112 is '资产域明细表';
comment on column IG.SOC0112.EIDDID is '资产域ID';
comment on column IG.SOC0112.EIDDVERSION is '资产域版本';
comment on column IG.SOC0112.EINAME is '实体名称';
comment on column IG.SOC0112.EIIMPORTVERSION is '资产导入版本';
comment on column IG.SOC0112.CREATETIME is '创建时间';
comment on column IG.SOC0112.DELETEFLAG is '删除标识';
comment on column IG.SOC0112.MODIFYFLAG is '修改标识';
comment on column IG.SOC0112.FINGERPRINT is '时间戳';

--SOC0113
comment on table IG.SOC0113 is '导入程序管理表';
comment on column IG.SOC0113.IMPTYPEID is '类型ID';
comment on column IG.SOC0113.IMPTYPENAME is '类型名称';
comment on column IG.SOC0113.IMPPROGRAMME is '导入Bat名称';
comment on column IG.SOC0113.IMPPROGRAMMEAUDIT is '审计Bat名称';
comment on column IG.SOC0113.IMPPROGRAMMEUPDATE is '更新Bat名称';
comment on column IG.SOC0113.FINGERPRINT is '时间戳';
comment on column IG.SOC0113.COLLECTTYPE is '采集类型';
comment on column IG.SOC0113.SHELLNAME is '对应采集脚本名称';

--SOC0114 
comment on table IG.SOC0114 is '实体链路图表';
comment on column IG.SOC0114.DOMAINID is '域ID';
comment on column IG.SOC0114.DOMAINVERSION is 'Domain版本';
comment on column IG.SOC0114.LINKID is '链路ID';
comment on column IG.SOC0114.LINKORDER is '链路顺序';
comment on column IG.SOC0114.EIID is '实体ID';
comment on column IG.SOC0114.EINAME is '实体名称';
comment on column IG.SOC0114.ESYSCODING is '资产层次码';
comment on column IG.SOC0114.EIVERSION is '大版本';
comment on column IG.SOC0114.EISMALLVERSION is '小版本';
comment on column IG.SOC0114.CREATETIME is '创建时间';
comment on column IG.SOC0114.LINKFLAG is '绘图标记';
comment on column IG.SOC0114.ENDFLAG is '链路结束标识';
comment on column IG.SOC0114.FINGERPRINT is '时间戳';

--SOC0115 
comment on table IG.SOC0115 is '待处理任务表';
comment on column IG.SOC0115.EITID is '逻辑主键';
comment on column IG.SOC0115.EITCREATETIME is '任务创建时间';
comment on column IG.SOC0115.EITTOPCI is '顶级CI';
comment on column IG.SOC0115.EITFILENAME is '源文件名';
comment on column IG.SOC0115.EITSTATUS is '状态';
comment on column IG.SOC0115.EITPARSESTART is '解析开始时间';
comment on column IG.SOC0115.EITPARSEEND is '解析结束时间';
comment on column IG.SOC0115.EITCISTART is 'CI实体生成开始时间';
comment on column IG.SOC0115.EITCIEND is 'CI实体生成结束时间';
comment on column IG.SOC0115.EITRELATIONSTART is '关系建立开始时间';
comment on column IG.SOC0115.EITRELATIONEND is '关系建立结束时间';
comment on column IG.SOC0115.DELETEFLAG is '删除标识';
comment on column IG.SOC0115.IMPTYPEID is '导入程序类型ID';
comment on column IG.SOC0115.FINGERPRINT is '时间戳';

--SOC0116 
comment on table IG.SOC0116 is '待处理任务临时表';
comment on column IG.SOC0116.EWTID is '逻辑主键';
comment on column IG.SOC0116.FILENAME is '文件名';
comment on column IG.SOC0116.BATNAME is 'Bat文件名';
comment on column IG.SOC0116.EINAME is '实体名称';
comment on column IG.SOC0116.EIID is '实体ID';
comment on column IG.SOC0116.FINGERPRINT is '时间戳';

--SOC0117
comment on table IG.SOC0117 is '资产模型表';
comment on column IG.SOC0117.EID is '资产模型ID';
comment on column IG.SOC0117.ENAME is '资产模型名称';
comment on column IG.SOC0117.ELABEL is '资产模型编号';
comment on column IG.SOC0117.EDESC is '资产模型说明';
comment on column IG.SOC0117.ESTATUS is '资产模型状态';
comment on column IG.SOC0117.ECATEGORY is '资产模型分类';
comment on column IG.SOC0117.EKEY1 is '资产模型一级子类';
comment on column IG.SOC0117.EKEY2 is '资产模型二级子类';
comment on column IG.SOC0117.EKEY3 is '资产模型三级子类';
comment on column IG.SOC0117.ESYSCODING is '资产模型层次码';
comment on column IG.SOC0117.EPARCODING is '资产模型父级层次码';
comment on column IG.SOC0117.FINGERPRINT is '时间戳';
comment on column IG.SOC0117.EMODELTYPE is '资产模型类别';

--SOC0118 
comment on table IG.SOC0118 is '资产信息表';
comment on column IG.SOC0118.EIID is '资产ID';
comment on column IG.SOC0118.EID is '资产模型ID';
comment on column IG.SOC0118.EIDESC is '资产说明';
comment on column IG.SOC0118.EINAME is '资产名称';
comment on column IG.SOC0118.EILABEL is '资产编号';
comment on column IG.SOC0118.EIINSDATE is '资产登记日';
comment on column IG.SOC0118.EIORGSYSCODING is '资产所属机构层次码';
comment on column IG.SOC0118.ESYSCODING is '资产模型层次码';
comment on column IG.SOC0118.EIUPDTIME is '资产更新时间';
comment on column IG.SOC0118.EISTATUS is '资产状态';
comment on column IG.SOC0118.EIVERSION is '资产版本号';
comment on column IG.SOC0118.FINGERPRINT is '时间戳';
comment on column IG.SOC0118.EIUSERID is '资产管理人';
comment on column IG.SOC0118.EIUSERNAME is '资产管理人姓名';
comment on column IG.SOC0118.EISMALLVERSION is '资产小版本';
comment on column IG.SOC0118.EIROOTMARK is '资产所属树根节点实体标识';

--SOC0119
comment on table IG.SOC0119 is '资产关系信息表';
comment on column IG.SOC0119.EIRID is '资产关系信息ID';
comment on column IG.SOC0119.PAREIID is '资产ID(正向)';
comment on column IG.SOC0119.PAREID is '资产模型ID(正向)';
comment on column IG.SOC0119.CLDEIID is '资产ID(反向)';
comment on column IG.SOC0119.CLDEID is '资产模型ID(反向)';
comment on column IG.SOC0119.EIRRELATION is '资产关系ID';
comment on column IG.SOC0119.EIRRELATIONCODE is '资产关系编码';
comment on column IG.SOC0119.EIRUPDTIME is '资产关系信息更新时间';
comment on column IG.SOC0119.EIRSTATUS is '资产关系是否可以删除标识';
comment on column IG.SOC0119.EIRDESC is '资产关系说明';
comment on column IG.SOC0119.FINGERPRINT is '时间戳';
comment on column IG.SOC0119.EIRINFO is '通过资产属性增加自动生成的关系信息';
comment on column IG.SOC0119.PARVERSION is '正向资产大版本';
comment on column IG.SOC0119.PARSMALLVERSION is '正向资产小版本';
comment on column IG.SOC0119.CLDVERSION is '反向资产大版本';
comment on column IG.SOC0119.CLDSMALLVERSION is '反向资产小版本';
comment on column IG.SOC0119.DELETEFLAG is '逻辑删除标识';

--SOC0120 
comment on table IG.SOC0120 is '导入对象管理表';
comment on column IG.SOC0120.IMPVERSION is '导入版本';
comment on column IG.SOC0120.IMPEINAME is '实体名称';
comment on column IG.SOC0120.IMPEIID is '导入实体ID';
comment on column IG.SOC0120.IMPCITYPE is '顶级CI类型';
comment on column IG.SOC0120.IMPFILENAME is '导入文件名称';
comment on column IG.SOC0120.IMPCREATETIME is '导入时间';
comment on column IG.SOC0120.DELETEFLAG is '删除标识';
comment on column IG.SOC0120.ESYSCODING is '资产层次码';
comment on column IG.SOC0120.IMPIP is '导入IP';
comment on column IG.SOC0120.IMPUSERID is '导入用户ID';
comment on column IG.SOC0120.IMPPASSWORD is '导入密码';
comment on column IG.SOC0120.IMPSTATUS is '导入状态';
comment on column IG.SOC0120.FINGERPRINT is '时间戳';

--SOC0121 
comment on table IG.SOC0121 is '快照关系表';
comment on column IG.SOC0121.SRID is '逻辑主键';
comment on column IG.SOC0121.SRDOMAINID is 'DomainID';
comment on column IG.SOC0121.SRARITHMETICTYPE is '扩展算法类型';
comment on column IG.SOC0121.SRDOMAINVERSION is 'Domain版本';
comment on column IG.SOC0121.SRPAREIID is '源资产ID';
comment on column IG.SOC0121.SRPARVERSION is '源资产大版本';
comment on column IG.SOC0121.SRPARSMALLVERSION is '源资产小版本';
comment on column IG.SOC0121.SRCLDEIID is '目的资产ID';
comment on column IG.SOC0121.SRCLDVERSION is '目的资产大版本';
comment on column IG.SOC0121.SRCLDSMALLVERSION is '目的资产小版本';
comment on column IG.SOC0121.SRTYPE is '关系类型(物理/逻辑)';
comment on column IG.SOC0121.SRDES is '关系说明';
comment on column IG.SOC0121.SRCREATETIME is '创建时间';
comment on column IG.SOC0121.DELETEFLAG is '删除标识';
comment on column IG.SOC0121.SRRALETIONCODE is '关联关系码';
comment on column IG.SOC0121.SRASSETRELATION is '资产关系项';
comment on column IG.SOC0121.FINGERPRINT is '时间戳';

--SOC0122 
comment on table IG.SOC0122 is '拓扑BAT信息表';
comment on column IG.SOC0122.MAPID is '主键ID';
comment on column IG.SOC0122.EIDOMAINID is '域ID';
comment on column IG.SOC0122.SNAPSHOTBAT is '拓扑BAT';
comment on column IG.SOC0122.EIDOMAINDESC is '域描述';

--SOC0147 
comment on table IG.SOC0147 is '告警信息唯一表';
comment on column IG.SOC0147.DETECTIONDAY is '告警日期';
comment on column IG.SOC0147.DETECTIONMIN is '告警时间';
comment on column IG.SOC0147.DIR is 'DIR';
comment on column IG.SOC0147.ERRORNUM is '错误码';
comment on column IG.SOC0147.EIROOTMARK is '顶级资产名称';
comment on column IG.SOC0147.FINGERPRINT is '时间戳';

--SOC0201  
comment on table IG.SOC0201 is '自动报表生成表';
comment on column IG.SOC0201.id is 'ID';
comment on column IG.SOC0201.DATAID is '数据ID';
comment on column IG.SOC0201.R_CATEGORY is '统计类型';
comment on column IG.SOC0201.R_PATH is '报表文件名称';
comment on column IG.SOC0201.R_RCID is '报表配置id';
comment on column IG.SOC0201.R_TIME is '报表统计年月';
comment on column IG.SOC0201.fingerprint is '时间戳';

--SOC0202  
comment on table IG.SOC0202 is '附加报表';
comment on column IG.SOC0202.raId is '附加ID';
comment on column IG.SOC0202.raName is '附加报表名字';
comment on column IG.SOC0202.raSsn is '存储序列号';
comment on column IG.SOC0202.raKpi is 'kpi';
comment on column IG.SOC0202.raCreateDate is '创建时间';
comment on column IG.SOC0202.raUserName is '用户名称';
comment on column IG.SOC0202.raRealName is '真实名字';
comment on column IG.SOC0202.fingerprint is '时间戳';

--SOC0203  
comment on table IG.SOC0203 is '自动报表配置列表';
comment on column IG.SOC0203.id is 'ID';
comment on column IG.SOC0203.DATAID is '数据ID';
comment on column IG.SOC0203.R_PATH is '报表文件名称';
comment on column IG.SOC0203.R_TITLE is '报表文件的中文含义';
comment on column IG.SOC0203.PARA is '报表运行时所用的参数';
comment on column IG.SOC0203.fingerprint is '时间戳';

--SOC0204  
comment on table IG.SOC0204 is '报表自定链接';
comment on column IG.SOC0204.rclId is '主键ID';
comment on column IG.SOC0204.rclReportType is '报表类型';
comment on column IG.SOC0204.rclObjName is '对象名称';
comment on column IG.SOC0204.rclTemName is '模板名字';
comment on column IG.SOC0204.rclTemDesc is '模板描述';
comment on column IG.SOC0204.rclObjEiid is '对象Eiid';
comment on column IG.SOC0204.rclObjType is '对象类型';
comment on column IG.SOC0204.rclMode is '容量Mode';
comment on column IG.SOC0204.rclCaType is '容量主机小类型';
comment on column IG.SOC0204.rclMenuDefault is '菜单默认';
comment on column IG.SOC0204.rclUserId is '用户帐号';
comment on column IG.SOC0204.fingerprint is '时间戳';

--SOC0205  
comment on table IG.SOC0205 is '报告管理表';
comment on column IG.SOC0205.rmId is '报告ID';
comment on column IG.SOC0205.rmName is '报告名称';
comment on column IG.SOC0205.rtId is '模板对象';
comment on column IG.SOC0205.rmYear is '年';
comment on column IG.SOC0205.rmQuarter is '季度';
comment on column IG.SOC0205.rmMonth is '月';
comment on column IG.SOC0205.createDate is '创建时间';
comment on column IG.SOC0205.lastAnnexationDate is '最后附加报表时间';
comment on column IG.SOC0205.fingerprint is '时间戳';

--SOC0206  
comment on table IG.SOC0206 is '模板映射表';
comment on column IG.SOC0206.rtmId is '流水ID';
comment on column IG.SOC0206.rtNumber is '模板位置序号';
comment on column IG.SOC0206.rtmSsn is '存储序列号';
comment on column IG.SOC0206.rtmKpi is '时间类型';
--comment on column IG.SOC0206.rtRealName is 'KPI';
comment on column IG.SOC0206.rtmImgNumber is 'Word文档对象图片位置';
comment on column IG.SOC0206.rtId is '模板对象';
comment on column IG.SOC0206.fingerprint is '时间戳';

--SOC0207  
comment on table IG.SOC0207 is '报告模板';
comment on column IG.SOC0207.rtId is 'ID';
comment on column IG.SOC0207.rtName is '模板名称';
comment on column IG.SOC0207.rtSum is '可修改位置数';
comment on column IG.SOC0207.rtDateType is '时间类型';
comment on column IG.SOC0207.rtRealName is '模板真实名字';
comment on column IG.SOC0207.rtUploadTime is '模板上传时间';
comment on column IG.SOC0207.rtType is '模板类型';
comment on column IG.SOC0207.fingerprint is '时间戳';

--SOC0208  
comment on table IG.SOC0208 is '事件变更服务效率';
comment on column IG.SOC0208.prtype is '流程类型';
comment on column IG.SOC0208.pivaralue is '流程来源';
comment on column IG.SOC0208.efficiencyTime is '时间';
comment on column IG.SOC0208.monthEfficiency is '当前月服务效率';
comment on column IG.SOC0208.historyEfficiency is '历史服务效率';

--SOC0301  
comment on table IG.SOC0301 is 'DMX实时监控性能表';
comment on column IG.SOC0301.id is '主键';
comment on column IG.SOC0301.mtId is '监控任务id';
comment on column IG.SOC0301.mtoName is '监控对象名';
comment on column IG.SOC0301.mtKpi is '性能指标';
comment on column IG.SOC0301.kpiValue is '性能指标值';
comment on column IG.SOC0301.timeStamp is '解析时间点';
comment on column IG.SOC0301.fingerprint is '时间戳';

--SOC0302  
comment on table IG.SOC0302 is 'DMX实时监控性能缓存表';
comment on column IG.SOC0302.mtId is '监控任务id';
comment on column IG.SOC0302.timeStamp is '解析时间点';
comment on column IG.SOC0302.IOPS is '系统IOPS';
comment on column IG.SOC0302.IO_Read is '每秒读IO数量';
comment on column IG.SOC0302.IO_Write is '每秒写IO数量';
comment on column IG.SOC0302.RW_Hits is '缓存读写命中率';
comment on column IG.SOC0302.KB_Read is '每秒读吞吐量';
comment on column IG.SOC0302.KB_Write is '每秒写吞吐量';

--SOC0303  
comment on table IG.SOC0303 is 'KPI位置映射表';
comment on column IG.SOC0303.id is '主键';
comment on column IG.SOC0303.mtcName is '组件类别';
comment on column IG.SOC0303.mtKpi is '性能指标';
comment on column IG.SOC0303.kpiIndex is 'KPI数据列索引';

--SOC0304  
comment on table IG.SOC0304 is '监控任务主表';
comment on column IG.SOC0304.mtId is '主键';
comment on column IG.SOC0304.mtSsn is '存储序列号d';
comment on column IG.SOC0304.mtCname is '组件名称';
comment on column IG.SOC0304.mtKpi is 'KPI';
comment on column IG.SOC0304.mtObjNames is '监控对象字符串';
comment on column IG.SOC0304.mtInterval is '采集间隔';
comment on column IG.SOC0304.mtNum is '采集次数';
comment on column IG.SOC0304.mtStartTime is '开始时间';
comment on column IG.SOC0304.mtStopTime is '结束时间';
comment on column IG.SOC0304.mtPStopTime is '预计结束时间';
comment on column IG.SOC0304.mtStatus is '任务状态';
comment on column IG.SOC0304.mtRecordTime is '记录时间';
comment on column IG.SOC0304.mtUserId is '记录用户id';
comment on column IG.SOC0304.mtOrgId is '用户部门ID';
comment on column IG.SOC0304.fingerprint is '时间戳';

--SOC0305  
comment on table IG.SOC0305 is '告警信息表';
comment on column IG.SOC0305.id is '主键';
comment on column IG.SOC0305.detectiontime is '告警时间';
comment on column IG.SOC0305.dir is 'dir';
comment on column IG.SOC0305.src is 'src';
comment on column IG.SOC0305.category is 'category';
comment on column IG.SOC0305.severity is '告警级别';
comment on column IG.SOC0305.errornum is '错误码';
comment on column IG.SOC0305.errordesc is '错误描述';
comment on column IG.SOC0305.eirootmark is '顶级资产名称';
comment on column IG.SOC0305.state is 'state';
comment on column IG.SOC0305.sort is 'sort';
comment on column IG.SOC0305.imptypename is '导入类型名称';
comment on column IG.SOC0305.imptypeid is '导入类型id';
comment on column IG.SOC0305.lparnam is 'lparnam';
comment on column IG.SOC0305.ip is 'ip';
comment on column IG.SOC0305.reportingmtms is 'reportingmtms';
comment on column IG.SOC0305.failingenclosuremtms is 'failingenclosuremtms';
comment on column IG.SOC0305.fru1loc is 'fru1loc';
comment on column IG.SOC0305.fru2loc is 'fru2loc';
comment on column IG.SOC0305.fru3loc is 'fru3loc';
comment on column IG.SOC0305.fingerprint is '时间戳';
comment on column IG.SOC0305.alarmtype is '告警类型';
comment on column IG.SOC0305.status is '告警状态';

--SOC0306  
comment on table IG.SOC0306 is '未导入性能数据资产信息表';
comment on column IG.SOC0306.id is '主键';
comment on column IG.SOC0306.symmid is '资产名称';
comment on column IG.SOC0306.dataitmes is '未导入时间';
comment on column IG.SOC0306.symtype is '资产类型';
comment on column IG.SOC0306.readdate is '确认时间';
comment on column IG.SOC0306.fingerprint is '时间戳';

--SOC0401 
comment on table IG.SOC0401 is '数据库容量实时表';
comment on column IG.SOC0401.DBID is '流水ID';
comment on column IG.SOC0401.DBNAME is '数据库名称';
comment on column IG.SOC0401.HOSTNAME is '主机名称';
comment on column IG.SOC0401.CREATEDATE is '日期';
comment on column IG.SOC0401.ALLOTTEDCAPACITY is '已分配容量';
comment on column IG.SOC0401.FREECAPACITY is '空闲容量';
comment on column IG.SOC0401.USEDCAPACITY is '已使用容量';
comment on column IG.SOC0401.FINGERPRINT is '时间戳';

--SOC0402 
comment on table IG.SOC0402 is '数据库容量月表';
comment on column IG.SOC0402.DBID is '流水ID';
comment on column IG.SOC0402.DBNAME is '数据库名称';
comment on column IG.SOC0402.HOSTNAME is '主机名称';
comment on column IG.SOC0402.CREATEDATE is '日期';
comment on column IG.SOC0402.ALLOTTEDCAPACITY is '已分配容量';
comment on column IG.SOC0402.FREECAPACITY is '空闲容量';
comment on column IG.SOC0402.USEDCAPACITY is '已使用容量';
comment on column IG.SOC0402.FINGERPRINT is '时间戳';

--SOC0403 
comment on table IG.SOC0403 is '数据库容量季表';
comment on column IG.SOC0403.DBID is '流水ID';
comment on column IG.SOC0403.DBNAME is '数据库名称';
comment on column IG.SOC0403.HOSTNAME is '主机名称';
comment on column IG.SOC0403.CREATEDATE is '日期';
comment on column IG.SOC0403.ALLOTTEDCAPACITY is '已分配容量';
comment on column IG.SOC0403.FREECAPACITY is '空闲容量';
comment on column IG.SOC0403.USEDCAPACITY is '已使用容量';
comment on column IG.SOC0403.FINGERPRINT is '时间戳';

--SOC0404  
comment on table IG.SOC0404 is '数据库容量年表';
comment on column IG.SOC0404.DBID is '流水ID';
comment on column IG.SOC0404.DBNAME is '数据库名称';
comment on column IG.SOC0404.HOSTNAME is '主机名称';
comment on column IG.SOC0404.CREATEDATE is '日期';
comment on column IG.SOC0404.ALLOTTEDCAPACITY is '已分配容量';
comment on column IG.SOC0404.FREECAPACITY is '空闲容量';
comment on column IG.SOC0404.USEDCAPACITY is '已使用容量';
comment on column IG.SOC0404.FINGERPRINT is '时间戳';

--SOC0405 
comment on table IG.SOC0405 is '逻辑卷容量实时表';
comment on column IG.SOC0405.LVID is '流水ID';
comment on column IG.SOC0405.HOSTNAME is '主机名称';
comment on column IG.SOC0405.VGNAME is '卷组名称';
comment on column IG.SOC0405.LVTYPE is '逻辑卷类型';
comment on column IG.SOC0405.LVNAME is '逻辑卷名称';
comment on column IG.SOC0405.LVSIZE is '逻辑卷大小';
comment on column IG.SOC0405.LVSTATE is '逻辑卷状态';
comment on column IG.SOC0405.FSNAME is '文件系统名称';
comment on column IG.SOC0405.CREATEDATE is '日期';
comment on column IG.SOC0405.ALLOTTEDCAPACITY is '已分配容量';
comment on column IG.SOC0405.FREECAPACITY is '空闲容量';
comment on column IG.SOC0405.USEDCAPACITY is '已使用容量';
comment on column IG.SOC0405.FINGERPRINT is '时间戳';

--SOC0406 
comment on table IG.SOC0406 is '逻辑卷容量月表';
comment on column IG.SOC0406.LVID is '流水ID';
comment on column IG.SOC0406.HOSTNAME is '主机名称';
comment on column IG.SOC0406.VGNAME is '卷组名称';
comment on column IG.SOC0406.LVTYPE is '逻辑卷类型';
comment on column IG.SOC0406.LVNAME is '逻辑卷名称';
comment on column IG.SOC0406.LVSIZE is '逻辑卷大小';
comment on column IG.SOC0406.LVSTATE is '逻辑卷状态';
comment on column IG.SOC0406.FSNAME is '文件系统名称';
comment on column IG.SOC0406.CREATEDATE is '日期';
comment on column IG.SOC0406.ALLOTTEDCAPACITY is '已分配容量';
comment on column IG.SOC0406.FREECAPACITY is '空闲容量';
comment on column IG.SOC0406.USEDCAPACITY is '已使用容量';
comment on column IG.SOC0406.FINGERPRINT is '时间戳';

--SOC0407 
comment on table IG.SOC0407 is '逻辑卷容量季表';
comment on column IG.SOC0407.LVID is '流水ID';
comment on column IG.SOC0407.HOSTNAME is '主机名称';
comment on column IG.SOC0407.VGNAME is '卷组名称';
comment on column IG.SOC0407.LVTYPE is '逻辑卷类型';
comment on column IG.SOC0407.LVNAME is '逻辑卷名称';
comment on column IG.SOC0407.LVSIZE is '逻辑卷大小';
comment on column IG.SOC0407.LVSTATE is '逻辑卷状态';
comment on column IG.SOC0407.FSNAME is '文件系统名称';
comment on column IG.SOC0407.CREATEDATE is '日期';
comment on column IG.SOC0407.ALLOTTEDCAPACITY is '已分配容量';
comment on column IG.SOC0407.FREECAPACITY is '空闲容量';
comment on column IG.SOC0407.USEDCAPACITY is '已使用容量';
comment on column IG.SOC0407.FINGERPRINT is '时间戳';

--SOC0408
comment on table IG.SOC0408 is '逻辑卷容量年表';
comment on column IG.SOC0408.LVID is '流水ID';
comment on column IG.SOC0408.HOSTNAME is '主机名称';
comment on column IG.SOC0408.VGNAME is '卷组名称';
comment on column IG.SOC0408.LVTYPE is '逻辑卷类型';
comment on column IG.SOC0408.LVNAME is '逻辑卷名称';
comment on column IG.SOC0408.LVSIZE is '逻辑卷大小';
comment on column IG.SOC0408.LVSTATE is '逻辑卷状态';
comment on column IG.SOC0408.FSNAME is '文件系统名称';
comment on column IG.SOC0408.CREATEDATE is '日期';
comment on column IG.SOC0408.ALLOTTEDCAPACITY is '已分配容量';
comment on column IG.SOC0408.FREECAPACITY is '空闲容量';
comment on column IG.SOC0408.USEDCAPACITY is '已使用容量';
comment on column IG.SOC0408.FINGERPRINT is '时间戳';

--SOC0409 
comment on table IG.SOC0409 is '物理卷主机实时表';
comment on column IG.SOC0409.PHID is '流水ID';
comment on column IG.SOC0409.SNAME is '存储序列号';
comment on column IG.SOC0409.HOSTNAME is '主机名称';
comment on column IG.SOC0409.VGNAME is '卷组名称';
comment on column IG.SOC0409.CREATEDATE is '日期';
comment on column IG.SOC0409.LUNID is 'LUNID';
comment on column IG.SOC0409.PVSIZE is '物理卷大小';
comment on column IG.SOC0409.FINGERPRINT is '时间戳';

--SOC0410 
comment on table IG.SOC0410 is '物理卷存储实时表';
comment on column IG.SOC0410.PSID is '流水ID';
comment on column IG.SOC0410.SNAME is '存储序列号';
comment on column IG.SOC0410.LUNID is 'LUNID';
comment on column IG.SOC0410.PVSIZE is '物理卷大小';
comment on column IG.SOC0410.ISUSED is '是否被分配';
comment on column IG.SOC0410.CREATEDATE is '日期';
comment on column IG.SOC0410.FINGERPRINT is '时间戳';

--SOC0411 
comment on table IG.SOC0411 is '存储容量实时表';
comment on column IG.SOC0411.SCID is '流水ID';
comment on column IG.SOC0411.SNAME is '存储序列号';
comment on column IG.SOC0411.CREATEDATE is '日期';
comment on column IG.SOC0411.RAWCAPACITY is '裸容量';
comment on column IG.SOC0411.EFFECTIVECAPACITY is '有效容量';
comment on column IG.SOC0411.REDUNDANCYCAPACITY is '冗余容量';
comment on column IG.SOC0411.ALLOTTEDCAPACITY is '已分配容量';
comment on column IG.SOC0411.FREECAPACITY is '空闲容量';
comment on column IG.SOC0411.DISKCOUNT is '磁盘个数';
comment on column IG.SOC0411.FINGERPRINT is '时间戳';

--SOC0412 
comment on table IG.SOC0412 is '存储容量月表';
comment on column IG.SOC0412.SCID is '流水ID';
comment on column IG.SOC0412.SNAME is '存储序列号';
comment on column IG.SOC0412.CREATEDATE is '日期';
comment on column IG.SOC0412.RAWCAPACITY is '裸容量';
comment on column IG.SOC0412.EFFECTIVECAPACITY is '有效容量';
comment on column IG.SOC0412.REDUNDANCYCAPACITY is '冗余容量';
comment on column IG.SOC0412.ALLOTTEDCAPACITY is '已分配容量';
comment on column IG.SOC0412.FREECAPACITY is '空闲容量';
comment on column IG.SOC0412.DISKCOUNT is '磁盘个数';
comment on column IG.SOC0412.FINGERPRINT is '时间戳';

--SOC0413 
comment on table IG.SOC0413 is '存储容量季表';
comment on column IG.SOC0413.SCID is '流水ID';
comment on column IG.SOC0413.SNAME is '存储序列号';
comment on column IG.SOC0413.CREATEDATE is '日期';
comment on column IG.SOC0413.RAWCAPACITY is '裸容量';
comment on column IG.SOC0413.EFFECTIVECAPACITY is '有效容量';
comment on column IG.SOC0413.REDUNDANCYCAPACITY is '冗余容量';
comment on column IG.SOC0413.ALLOTTEDCAPACITY is '已分配容量';
comment on column IG.SOC0413.FREECAPACITY is '空闲容量';
comment on column IG.SOC0413.DISKCOUNT is '磁盘个数';
comment on column IG.SOC0413.FINGERPRINT is '时间戳';

--SOC0414 
comment on table IG.SOC0414 is '存储容量年表';
comment on column IG.SOC0414.SCID is '流水ID';
comment on column IG.SOC0414.SNAME is '存储序列号';
comment on column IG.SOC0414.CREATEDATE is '日期';
comment on column IG.SOC0414.RAWCAPACITY is '裸容量';
comment on column IG.SOC0414.EFFECTIVECAPACITY is '有效容量';
comment on column IG.SOC0414.REDUNDANCYCAPACITY is '冗余容量';
comment on column IG.SOC0414.ALLOTTEDCAPACITY is '已分配容量';
comment on column IG.SOC0414.FREECAPACITY is '空闲容量';
comment on column IG.SOC0414.DISKCOUNT is '磁盘个数';
comment on column IG.SOC0414.FINGERPRINT is '时间戳';

--SOC0415 
comment on table IG.SOC0415 is '表空间容量实时表';
comment on column IG.SOC0415.TSID is '流水ID';
comment on column IG.SOC0415.TSNAME is '表空间名称';
comment on column IG.SOC0415.HOSTNAME is '主机名称';
comment on column IG.SOC0415.DBNAME is '数据库名称';
comment on column IG.SOC0415.CREATEDATE is '日期';
comment on column IG.SOC0415.ALLOTTEDCAPACITY is '已分配容量';
comment on column IG.SOC0415.FREECAPACITY is '空闲容量';
comment on column IG.SOC0415.USEDCAPACITY is '已使用容量';
comment on column IG.SOC0415.FINGERPRINT is '时间戳';

--SOC0416 
comment on table IG.SOC0416 is '表空间容量月表';
comment on column IG.SOC0416.TSID is '流水ID';
comment on column IG.SOC0416.TSNAME is '表空间名称';
comment on column IG.SOC0416.HOSTNAME is '主机名称';
comment on column IG.SOC0416.DBNAME is '数据库名称';
comment on column IG.SOC0416.CREATEDATE is '日期';
comment on column IG.SOC0416.ALLOTTEDCAPACITY is '已分配容量';
comment on column IG.SOC0416.FREECAPACITY is '空闲容量';
comment on column IG.SOC0416.USEDCAPACITY is '已使用容量';
comment on column IG.SOC0416.FINGERPRINT is '时间戳';

--SOC0417 
comment on table IG.SOC0417 is '表空间容量季表';
comment on column IG.SOC0417.TSID is '流水ID';
comment on column IG.SOC0417.TSNAME is '表空间名称';
comment on column IG.SOC0417.HOSTNAME is '主机名称';
comment on column IG.SOC0417.DBNAME is '数据库名称';
comment on column IG.SOC0417.CREATEDATE is '日期';
comment on column IG.SOC0417.ALLOTTEDCAPACITY is '已分配容量';
comment on column IG.SOC0417.FREECAPACITY is '空闲容量';
comment on column IG.SOC0417.USEDCAPACITY is '已使用容量';
comment on column IG.SOC0417.FINGERPRINT is '时间戳';

--SOC0418 
comment on table IG.SOC0418 is '表空间容量年表';
comment on column IG.SOC0418.TSID is '流水ID';
comment on column IG.SOC0418.TSNAME is '表空间名称';
comment on column IG.SOC0418.HOSTNAME is '主机名称';
comment on column IG.SOC0418.DBNAME is '数据库名称';
comment on column IG.SOC0418.CREATEDATE is '日期';
comment on column IG.SOC0418.ALLOTTEDCAPACITY is '已分配容量';
comment on column IG.SOC0418.FREECAPACITY is '空闲容量';
comment on column IG.SOC0418.USEDCAPACITY is '已使用容量';
comment on column IG.SOC0418.FINGERPRINT is '时间戳';

--SOC0419 
comment on table IG.SOC0419 is '卷组容量实时表';
comment on column IG.SOC0419.VGID is '流水ID';
comment on column IG.SOC0419.VGNAME is '卷组名称';
comment on column IG.SOC0419.HOSTNAME is '主机名称';
comment on column IG.SOC0419.SNAME is '存储序列号';
comment on column IG.SOC0419.CREATEDATE is '日期';
comment on column IG.SOC0419.ALLOTTEDCAPACITY is '已分配容量';
comment on column IG.SOC0419.FREECAPACITY is '空闲容量';
comment on column IG.SOC0419.USEDCAPACITY is '已使用容量';
comment on column IG.SOC0419.FINGERPRINT is '时间戳';

--SOC0420 
comment on table IG.SOC0420 is '卷组容量月表';
comment on column IG.SOC0420.VGID is '流水ID';
comment on column IG.SOC0420.VGNAME is '卷组名称';
comment on column IG.SOC0420.HOSTNAME is '主机名称';
comment on column IG.SOC0420.SNAME is '存储序列号';
comment on column IG.SOC0420.CREATEDATE is '日期';
comment on column IG.SOC0420.ALLOTTEDCAPACITY is '已分配容量';
comment on column IG.SOC0420.FREECAPACITY is '空闲容量';
comment on column IG.SOC0420.USEDCAPACITY is '已使用容量';
comment on column IG.SOC0420.FINGERPRINT is '时间戳';

--SOC0421 
comment on table IG.SOC0421 is '卷组容量季表';
comment on column IG.SOC0421.VGID is '流水ID';
comment on column IG.SOC0421.VGNAME is '卷组名称';
comment on column IG.SOC0421.HOSTNAME is '主机名称';
comment on column IG.SOC0421.SNAME is '存储序列号';
comment on column IG.SOC0421.CREATEDATE is '日期';
comment on column IG.SOC0421.ALLOTTEDCAPACITY is '已分配容量';
comment on column IG.SOC0421.FREECAPACITY is '空闲容量';
comment on column IG.SOC0421.USEDCAPACITY is '已使用容量';
comment on column IG.SOC0421.FINGERPRINT is '时间戳';

--SOC0422 
comment on table IG.SOC0422 is '卷组容量年表';
comment on column IG.SOC0422.VGID is '流水ID';
comment on column IG.SOC0422.VGNAME is '卷组名称';
comment on column IG.SOC0422.HOSTNAME is '主机名称';
comment on column IG.SOC0422.SNAME is '存储序列号';
comment on column IG.SOC0422.CREATEDATE is '日期';
comment on column IG.SOC0422.ALLOTTEDCAPACITY is '已分配容量';
comment on column IG.SOC0422.FREECAPACITY is '空闲容量';
comment on column IG.SOC0422.USEDCAPACITY is '已使用容量';
comment on column IG.SOC0422.FINGERPRINT is '时间戳';

--SOC0423 
comment on table IG.SOC0423 is '容量对象列表';
comment on column IG.SOC0423.ID is '流水ID';
comment on column IG.SOC0423.NAME is '父级容量对象名称';
comment on column IG.SOC0423.OBJECTTYPE is '容量对象类型';
comment on column IG.SOC0423.OBJECTNAME is '容量对象名称';
comment on column IG.SOC0423.FINGERPRINT is '时间戳';
comment on column IG.SOC0423.ERRORNUM is '严重告警阈值';
comment on column IG.SOC0423.WARNINGNUM is '普通告警阈值';
comment on column IG.SOC0423.STATUS is '状态';

--SOC0424 
comment on table IG.SOC0424 is '报表类型表';
comment on column IG.SOC0424.REPORTNAME is '报表名称';
comment on column IG.SOC0424.RTTYPE is '报表类型';
comment on column IG.SOC0424.STORAGETYPE is '存储类型';
comment on column IG.SOC0424.FINGERPRINT is '时间戳';

--SOC0425 
comment on table IG.SOC0425 is '业务系统容量月表';
comment on column IG.SOC0425.ID is '流水ID';
comment on column IG.SOC0425.BCID is '业务系统ID';
comment on column IG.SOC0425.BCNAME is '业务系统名称';
comment on column IG.SOC0425.SNAME is '存储序列号';
comment on column IG.SOC0425.CREATEDATE is '日期';
comment on column IG.SOC0425.ALLOTTEDCAPACITY is '已分配容量';
comment on column IG.SOC0425.USEDCAPACITY is '已使用容量';
comment on column IG.SOC0425.FINGERPRINT is '时间戳';

--SOC0426 
comment on table IG.SOC0426 is '业务系统容量季表';
comment on column IG.SOC0426.ID is '流水ID';
comment on column IG.SOC0426.BCID is '业务系统ID';
comment on column IG.SOC0426.BCNAME is '业务系统名称';
comment on column IG.SOC0426.SNAME is '存储序列号';
comment on column IG.SOC0426.CREATEDATE is '日期';
comment on column IG.SOC0426.ALLOTTEDCAPACITY is '已分配容量';
comment on column IG.SOC0426.USEDCAPACITY is '已使用容量';
comment on column IG.SOC0426.FINGERPRINT is '时间戳';

--SOC0427 
comment on table IG.SOC0427 is '业务系统容量年表';
comment on column IG.SOC0427.ID is '流水ID';
comment on column IG.SOC0427.BCID is '业务系统ID';
comment on column IG.SOC0427.BCNAME is '业务系统名称';
comment on column IG.SOC0427.SNAME is '存储序列号';
comment on column IG.SOC0427.CREATEDATE is '日期';
comment on column IG.SOC0427.ALLOTTEDCAPACITY is '已分配容量';
comment on column IG.SOC0427.USEDCAPACITY is '已使用容量';
comment on column IG.SOC0427.FINGERPRINT is '时间戳';

--SOC0433
comment on table IG.SOC0433 is 'VIO';
comment on column IG.SOC0433.ID is '流水ID';
comment on column IG.SOC0433.VIONAME is 'VIO名称';
comment on column IG.SOC0433.HOSTNAME is '主机名称';
comment on column IG.SOC0433.FINGERPRINT is '时间戳';

--SOC0434
comment on table IG.SOC0434 is 'VIO物理卷表';
comment on column IG.SOC0434.pvvid is '主键';
comment on column IG.SOC0434.sn is '序列号';
comment on column IG.SOC0434.sName is '存储名';
comment on column IG.SOC0434.lunid is 'lunid';
comment on column IG.SOC0434.pvSize is '物理卷容量';
comment on column IG.SOC0434.isUsed is '使用状态';
comment on column IG.SOC0434.createDate is '日期';
comment on column IG.SOC0434.FINGERPRINT is '时间戳';

--SOC0435 
comment on table IG.SOC0435 is '主机pv表';
comment on column IG.SOC0435.PHID is '流水ID';
comment on column IG.SOC0435.SNAME is '存储序列号';
comment on column IG.SOC0435.HOSTNAME is '主机名称';
comment on column IG.SOC0435.VGNAME is '卷组名称';
comment on column IG.SOC0435.CREATEDATE is '日期';
comment on column IG.SOC0435.LUNID is 'LUNID';
comment on column IG.SOC0435.PVSIZE is '物理卷大小';
comment on column IG.SOC0435.FINGERPRINT is '时间戳';

--SOC0436 
comment on table IG.SOC0436 is '物理卷存储实时表';
comment on column IG.SOC0436.PSID is '流水ID';
comment on column IG.SOC0436.SNAME is '存储序列号';
comment on column IG.SOC0436.LUNID is 'LUNID';
comment on column IG.SOC0436.PVSIZE is '物理卷大小';
comment on column IG.SOC0436.ISUSED is '是否被分配';
comment on column IG.SOC0436.CREATEDATE is '日期';
comment on column IG.SOC0436.FINGERPRINT is '时间戳';

--IG911
comment on table IG.IG911 is '自定义流程相关发起信息表';
comment on column IG.IG911.psprpid is '自增主键';
comment on column IG.IG911.pdid is '流程类型ID';
comment on column IG.IG911.psdid is '流程状态ID';
comment on column IG.IG911.roleid is '参与者角色ID';
comment on column IG.IG911.relevantPdid is '相关发起的流程类型ID';
comment on column IG.IG911.fingerPrint is '时间戳';

--IG931
comment on table IG.IG931 is '缺省自定义流程相关发起信息表';
comment on column IG.IG931.dpsprpid is '自增主键';
comment on column IG.IG931.pdid is '流程类型ID';
comment on column IG.IG931.psdid is '流程状态ID';
comment on column IG.IG931.relevantPdid is '相关发起的流程类型ID';
comment on column IG.IG931.fingerPrint is '时间戳';

--CUSTOMCONFIGURATION
comment on table IG.CUSTOMCONFIGURATION is '定制报表的报表参数设定表';
comment on column IG.CUSTOMCONFIGURATION.RFDID is '报表ID';
comment on column IG.CUSTOMCONFIGURATION.PDID is '流程类型ID（多个时用#分隔）';
comment on column IG.CUSTOMCONFIGURATION.PRSTATUSINFO is '流程状态标识（多个时用#分隔）';
comment on column IG.CUSTOMCONFIGURATION.PIDID is '表单定义ID';
comment on column IG.CUSTOMCONFIGURATION.PIDVALUE is '表单值（多个时用#分隔）';
comment on column IG.CUSTOMCONFIGURATION.USERID is '操作用户id';
comment on column IG.CUSTOMCONFIGURATION.CREATETIME is '创建时间';
comment on column IG.CUSTOMCONFIGURATION.UPDATETIME is '更新时间';
comment on column IG.CUSTOMCONFIGURATION.FINGERPRINT is '时间戳';

--IG700
comment on table IG.IG700 is '流程查看角色配置表';
comment on column IG.IG700.pdid is '流程定义ID';
comment on column IG.IG700.roleid is '角色ID';

--IG701
comment on table IG.IG701 is '流程查看角色授权表单表';
comment on column IG.IG701.pdid is '流程定义ID';
comment on column IG.IG701.roleid is '角色ID';
comment on column IG.IG701.pidid is '表单ID';

commit;