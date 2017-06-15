--SOC0101 
comment on table SOC0101 is '审计资产属性表';
comment on column SOC0101.CIID is '资产属性ID';
comment on column SOC0101.CID is '资产模型属性ID';
comment on column SOC0101.EIID is '资产ID';
comment on column SOC0101.EID is '资产模型ID';
comment on column SOC0101.CIVALUE is '资产属性值';
comment on column SOC0101.CIUPDTIME is '资产属性更新时间';
comment on column SOC0101.ESYSCODING is '资产模型层次码';
comment on column SOC0101.CIEXPIRE is '资产属性失效时间';
comment on column SOC0101.CISTATUS is '资产属性状态';
comment on column SOC0101.CICURVER is '资产属性当前版本号';
comment on column SOC0101.CIVERINFO is '资产属性版本信息';
comment on column SOC0101.CISMALLVERSION is '资产属性小版本';
comment on column SOC0101.CIVERSION is '资产属性大版本';
comment on column SOC0101.FINGERPRINT is '时间戳';

--SOC0102 
comment on table SOC0102 is '审计资产表';
comment on column SOC0102.EIID is '资产ID';
comment on column SOC0102.EID is '资产模型ID';
comment on column SOC0102.EIDESC is '资产说明';
comment on column SOC0102.EINAME is '资产名称';
comment on column SOC0102.EILABEL is '资产编号';
comment on column SOC0102.EIINSDATE is '资产登记日';
comment on column SOC0102.EIORGSYSCODING is '资产所属机构层次码';
comment on column SOC0102.ESYSCODING is '资产模型层次码';
comment on column SOC0102.EIUPDTIME is '资产更新时间';
comment on column SOC0102.EISTATUS is '资产状态';
comment on column SOC0102.EIUSERID is '资产管理人';
comment on column SOC0102.EIUSERNAME is '资产管理人姓名';
comment on column SOC0102.EIROOTMARK is '顶级CI标识';
comment on column SOC0102.EISMALLVERSION is '资产小版本';
comment on column SOC0102.EIVERSION is '资产大版本';
comment on column SOC0102.FINGERPRINT is '时间戳';

--SOC0103 
comment on table SOC0103 is '审计对比结果信息表';
comment on column SOC0103.AURID is '审计对比结果';
comment on column SOC0103.AUTID is '审计任务ID';
comment on column SOC0103.AUTIME is '审计时间戳';
comment on column SOC0103.AUCMPTYPE is '对比结果类型';
comment on column SOC0103.EIID is '资产ID';
comment on column SOC0103.EIVERSION is '大版本';
comment on column SOC0103.EISMALLVERSION is '小版本';
comment on column SOC0103.EINAME is '资产名称';
comment on column SOC0103.ESYSCODING is '资产层次码';
comment on column SOC0103.EIROOTMARK is '顶级CI标识';
comment on column SOC0103.CIID is '属性ID';
comment on column SOC0103.CNAME is '属性名';
comment on column SOC0103.CIVALUE is '当前版本值';
comment on column SOC0103.AUVALUE is '采集值';
comment on column SOC0103.AUFLAG is '合理标识';
comment on column SOC0103.AURESULTDESC is '审计结果说明';
comment on column SOC0103.FINGERPRINT is '时间戳';

--SOC0104 
comment on table SOC0104 is '审计任务表';
comment on column SOC0104.AUTID is '逻辑主键';
comment on column SOC0104.AUTDESC is '审计任务描述';
comment on column SOC0104.AUTTIME is '审计时间戳';
comment on column SOC0104.AUTSTATUS is '审计任务状态';
comment on column SOC0104.AUTUPDTIME is '审计任务更新时间';
comment on column SOC0104.AUTCOMPTIME is 'AUTCOMPTIME';
comment on column SOC0104.FINGERPRINT is '时间戳';

--SOC0105 
comment on table SOC0105 is '审计待处理任务表';
comment on column SOC0105.EITID is '逻辑主键';
comment on column SOC0105.EITCREATETIME is '任务创建时间';
comment on column SOC0105.EITFILENAME is '源文件名';
comment on column SOC0105.AUWTTOPCI is '顶级CI';
comment on column SOC0105.EITSTATUS is '状态';
comment on column SOC0105.EITPARSESTART is '解析开始时间';
comment on column SOC0105.EITPARSEEND is '解析结束时间';
comment on column SOC0105.EITCISTART is 'CI实体生成开始时间';
comment on column SOC0105.EITCIEND is 'CI实体生成结束时间';
comment on column SOC0105.DELETEFLAG is '删除标识';
comment on column SOC0105.IMPTYPEID is '导入程序类型ID';
comment on column SOC0105.FINGERPRINT is '时间戳';

--SOC0106 
comment on table SOC0106 is '审计待处理任务临时表';
comment on column SOC0106.AWTID is '逻辑主键';
comment on column SOC0106.FILENAME is '文件名';
comment on column SOC0106.BATNAME is 'BAT文件名';
comment on column SOC0106.EINAME is '实体名称';
comment on column SOC0106.AUWTID is '实体ID';
comment on column SOC0106.FINGERPRINT is '时间戳';

--SOC0107 
comment on table SOC0107 is '资产属性信息表';
comment on column SOC0107.CIID is '资产属性ID';
comment on column SOC0107.CID is '资产模型属性ID';
comment on column SOC0107.EIID is '资产ID';
comment on column SOC0107.EID is '资产模型ID';
comment on column SOC0107.CIVALUE is '资产属性值';
comment on column SOC0107.CIUPDTIME is '资产属性更新时间';
comment on column SOC0107.ESYSCODING is '资产模型层次码';
comment on column SOC0107.CIEXPIRE is '资产属性失效时间';
comment on column SOC0107.CISTATUS is '资产属性状态';
comment on column SOC0107.CICURVER is '资产属性当前版本号';
comment on column SOC0107.CIVERSION is '资产属性版本号';
comment on column SOC0107.CIVERINFO is '资产属性版本信息';
comment on column SOC0107.FINGERPRINT is '时间戳';
comment on column SOC0107.CISMALLVERSION is '资产属性小版本';

--SOC0108 
comment on table SOC0108 is '资产属性信息临时表';
comment on column SOC0108.CIID is '资产属性ID';
comment on column SOC0108.CID is '资产模型属性ID';
comment on column SOC0108.EIID is '资产ID';
comment on column SOC0108.EID is '资产模型ID';
comment on column SOC0108.CIVALUE is '资产属性值';
comment on column SOC0108.CIUPDTIME is '资产属性更新时间';
comment on column SOC0108.ESYSCODING is '资产模型层次码';
comment on column SOC0108.CIEXPIRE is '资产属性失效时间';
comment on column SOC0108.CISTATUS is '资产属性状态';
comment on column SOC0108.CICURVER is '资产属性当前版本号';
comment on column SOC0108.CIVERSION is '资产属性版本号';
comment on column SOC0108.CIVERINFO is '资产属性版本信息';
comment on column SOC0108.FINGERPRINT is '时间戳';
comment on column SOC0108.CISMALLVERSION is '资产属性小版本';

--SOC0109 
comment on table SOC0109 is '资产模型属性信息表';
comment on column SOC0109.CID is '资产模型属性ID';
comment on column SOC0109.EID is '资产模型ID';
comment on column SOC0109.CNAME is '资产模型属性名称';
comment on column SOC0109.CLABEL is '资产模型属性编号';
comment on column SOC0109.CDESC is '资产模型属性说明';
comment on column SOC0109.CUNIT is '资产模型属性单位';
comment on column SOC0109.CSTATUS is '资产模型属性状态';
comment on column SOC0109.CSEQ is '资产模型属性是否显示标识';
comment on column SOC0109.CCATEGORY is '资产模型属性所属模型的模型分类';
comment on column SOC0109.COPTION is '资产模型属性取值范围ID';
comment on column SOC0109.CATTACH is '资产模型属性数据类型';
comment on column SOC0109.ESYSCODING is '资产模型属性所属模型层次码';
comment on column SOC0109.FINGERPRINT is '时间戳';
comment on column SOC0109.CREQUIRED is '资产模型属性必填项';

--SOC0110 
comment on table SOC0110 is '配置所属关系表';
comment on column SOC0110.BRID is '逻辑主键';
comment on column SOC0110.BRPAREIID is '源资产ID';
comment on column SOC0110.BRPARVERSION is '源资产大版本';
comment on column SOC0110.BRPARSMALLVERSION is '源资产小版本';
comment on column SOC0110.BRCLDEIID is '目的资产ID';
comment on column SOC0110.BRCLDVERSION is '目的资产大版本';
comment on column SOC0110.BRCLDSMALLVERSION is '目的资产小版本';
comment on column SOC0110.BRTYPE is '关系类型(物理/逻辑)';
comment on column SOC0110.BRDES is '关系说明';
comment on column SOC0110.BRCREATETIME is '创建时间';
comment on column SOC0110.BRRALETIONCODE is '关联关系码';
comment on column SOC0110.BRASSETRELATION is '资产关系项';
comment on column SOC0110.EIROOTMARK is '资产所属树根节点实体标识';
comment on column SOC0110.DELETEFLAG is '逻辑删除标识';
comment on column SOC0110.FINGERPRINT is '时间戳';

--SOC0111 
comment on table SOC0111 is '资产域定义表';
comment on column SOC0111.EIDDID is '逻辑主键';
comment on column SOC0111.VERSION is '版本号';
comment on column SOC0111.NAME is '名称';
comment on column SOC0111.DESCRIPTION is '描述';
comment on column SOC0111.CREATETIME is '创建时间';
comment on column SOC0111.UPDATETIME is '更新时间';
comment on column SOC0111.FINGERPRINT is '时间戳';

--SOC0112 
comment on table SOC0112 is '资产域明细表';
comment on column SOC0112.EIDDID is '资产域ID';
comment on column SOC0112.EIDDVERSION is '资产域版本';
comment on column SOC0112.EINAME is '实体名称';
comment on column SOC0112.EIIMPORTVERSION is '资产导入版本';
comment on column SOC0112.CREATETIME is '创建时间';
comment on column SOC0112.DELETEFLAG is '删除标识';
comment on column SOC0112.MODIFYFLAG is '修改标识';
comment on column SOC0112.FINGERPRINT is '时间戳';

--SOC0113
comment on table SOC0113 is '导入程序管理表';
comment on column SOC0113.IMPTYPEID is '类型ID';
comment on column SOC0113.IMPTYPENAME is '类型名称';
comment on column SOC0113.IMPPROGRAMME is '导入Bat名称';
comment on column SOC0113.IMPPROGRAMMEAUDIT is '审计Bat名称';
comment on column SOC0113.IMPPROGRAMMEUPDATE is '更新Bat名称';
comment on column SOC0113.FINGERPRINT is '时间戳';
comment on column SOC0113.COLLECTTYPE is '采集类型';
comment on column SOC0113.SHELLNAME is '对应采集脚本名称';

--SOC0114 
comment on table SOC0114 is '实体链路图表';
comment on column SOC0114.DOMAINID is '域ID';
comment on column SOC0114.SRDOMAINVERSION is 'Domain版本';
comment on column SOC0114.LINKID is '链路ID';
comment on column SOC0114.LINKORDER is '链路顺序';
comment on column SOC0114.EIID is '实体ID';
comment on column SOC0114.EINAME is '实体名称';
comment on column SOC0114.ESYSCODING is '资产层次码';
comment on column SOC0114.EIVERSION is '大版本';
comment on column SOC0114.EISMALLVERSION is '小版本';
comment on column SOC0114.CREATETIME is '创建时间';
comment on column SOC0114.LINKFLAG is '绘图标记';
comment on column SOC0114.ENDFLAG is '链路结束标识';
comment on column SOC0114.FINGERPRINT is '时间戳';

--SOC0115 
comment on table SOC0115 is '待处理任务表';
comment on column SOC0115.EITID is '逻辑主键';
comment on column SOC0115.EITCREATETIME is '任务创建时间';
comment on column SOC0115.EITTOPCI is '顶级CI';
comment on column SOC0115.EITFILENAME is '源文件名';
comment on column SOC0115.EITSTATUS is '状态';
comment on column SOC0115.EITPARSESTART is '解析开始时间';
comment on column SOC0115.EITPARSEEND is '解析结束时间';
comment on column SOC0115.EITCISTART is 'CI实体生成开始时间';
comment on column SOC0115.EITCIEND is 'CI实体生成结束时间';
comment on column SOC0115.EITRELATIONSTART is '关系建立开始时间';
comment on column SOC0115.EITRELATIONEND is '关系建立结束时间';
comment on column SOC0115.DELETEFLAG is '删除标识';
comment on column SOC0115.IMPTYPEID is '导入程序类型ID';
comment on column SOC0115.FINGERPRINT is '时间戳';

--SOC0116 
comment on table SOC0116 is '待处理任务临时表';
comment on column SOC0116.EWTID is '逻辑主键';
comment on column SOC0116.FILENAME is '文件名';
comment on column SOC0116.BATNAME is 'Bat文件名';
comment on column SOC0116.EINAME is '实体名称';
comment on column SOC0116.EIID is '实体ID';
comment on column SOC0116.FINGERPRINT is '时间戳';

--SOC0117
comment on table SOC0117 is '资产模型表';
comment on column SOC0117.EID is '资产模型ID';
comment on column SOC0117.ENAME is '资产模型名称';
comment on column SOC0117.ELABEL is '资产模型编号';
comment on column SOC0117.EDESC is '资产模型说明';
comment on column SOC0117.ESTATUS is '资产模型状态';
comment on column SOC0117.ECATEGORY is '资产模型分类';
comment on column SOC0117.EKEY1 is '资产模型一级子类';
comment on column SOC0117.EKEY2 is '资产模型二级子类';
comment on column SOC0117.EKEY3 is '资产模型三级子类';
comment on column SOC0117.ESYSCODING is '资产模型层次码';
comment on column SOC0117.EPARCODING is '资产模型父级层次码';
comment on column SOC0117.FINGERPRINT is '时间戳';
comment on column SOC0117.EMODELTYPE is '资产模型类别';

--SOC0118 
comment on table SOC0118 is '资产信息表';
comment on column SOC0118.EIID is '资产ID';
comment on column SOC0118.EID is '资产模型ID';
comment on column SOC0118.EIDESC is '资产说明';
comment on column SOC0118.EINAME is '资产名称';
comment on column SOC0118.EILABEL is '资产编号';
comment on column SOC0118.EIINSDATE is '资产登记日';
comment on column SOC0118.EIORGSYSCODING is '资产所属机构层次码';
comment on column SOC0118.ESYSCODING is '资产模型层次码';
comment on column SOC0118.EIUPDTIME is '资产更新时间';
comment on column SOC0118.EISTATUS is '资产状态';
comment on column SOC0118.EIVERSION is '资产版本号';
comment on column SOC0118.FINGERPRINT is '时间戳';
comment on column SOC0118.EIUSERID is '资产管理人';
comment on column SOC0118.EIUSERNAME is '资产管理人姓名';
comment on column SOC0118.EISMALLVERSION is '资产小版本';
comment on column SOC0118.EIROOTMARK is '资产所属树根节点实体标识';

--SOC0119
comment on table SOC0119 is '资产关系信息表';
comment on column SOC0119.EIRID is '资产关系信息ID';
comment on column SOC0119.PAREIID is '资产ID(正向)';
comment on column SOC0119.PAREID is '资产模型ID(正向)';
comment on column SOC0119.CLDEIID is '资产ID(反向)';
comment on column SOC0119.CLDEID is '资产模型ID(反向)';
comment on column SOC0119.EIRRELATION is '资产关系ID';
comment on column SOC0119.EIRRELATIONCODE is '资产关系编码';
comment on column SOC0119.EIRUPDTIME is '资产关系信息更新时间';
comment on column SOC0119.EIRSTATUS is '资产关系是否可以删除标识';
comment on column SOC0119.EIRDESC is '资产关系说明';
comment on column SOC0119.FINGERPRINT is '时间戳';
comment on column SOC0119.EIRINFO is '通过资产属性增加自动生成的关系信息';
comment on column SOC0119.PARVERSION is '正向资产大版本';
comment on column SOC0119.PARSMALLVERSION is '正向资产小版本';
comment on column SOC0119.CLDVERSION is '反向资产大版本';
comment on column SOC0119.CLDSMALLVERSION is '反向资产小版本';
comment on column SOC0119.DELETEFLAG is '逻辑删除标识';

--SOC0120 
comment on table SOC0120 is '导入对象管理表';
comment on column SOC0120.IMPVERSION is '导入版本';
comment on column SOC0120.IMPEINAME is '实体名称';
comment on column SOC0120.IMPEIID is '导入实体ID';
comment on column SOC0120.IMPCITYPE is '顶级CI类型';
comment on column SOC0120.IMPFILENAME is '导入文件名称';
comment on column SOC0120.IMPCREATETIME is '导入时间';
comment on column SOC0120.DELETEFLAG is '删除标识';
comment on column SOC0120.ESYSCODING is '资产层次码';
comment on column SOC0120.IMPIP is '导入IP';
comment on column SOC0120.IMPUSERID is '导入用户ID';
comment on column SOC0120.IMPPASSWORD is '导入密码';
comment on column SOC0120.IMPSTATUS is '导入状态';
comment on column SOC0120.FINGERPRINT is '时间戳';

--SOC0121 
comment on table SOC0121 is '快照关系表';
comment on column SOC0121.SRID is '逻辑主键';
comment on column SOC0121.SRDOMAINID is 'DomainID';
comment on column SOC0121.SRARITHMETICTYPE is '扩展算法类型';
comment on column SOC0121.SRDOMAINVERSION is 'Domain版本';
comment on column SOC0121.SRPAREIID is '源资产ID';
comment on column SOC0121.SRPARVERSION is '源资产大版本';
comment on column SOC0121.SRPARSMALLVERSION is '源资产小版本';
comment on column SOC0121.SRCLDEIID is '目的资产ID';
comment on column SOC0121.SRCLDVERSION is '目的资产大版本';
comment on column SOC0121.SRCLDSMALLVERSION is '目的资产小版本';
comment on column SOC0121.SRTYPE is '关系类型(物理/逻辑)';
comment on column SOC0121.SRDES is '关系说明';
comment on column SOC0121.SRCREATETIME is '创建时间';
comment on column SOC0121.DELETEFLAG is '删除标识';
comment on column SOC0121.SRRALETIONCODE is '关联关系码';
comment on column SOC0121.SRASSETRELATION is '资产关系项';
comment on column SOC0121.FINGERPRINT is '时间戳';

--SOC0122 
comment on table SOC0122 is '拓扑BAT信息表';
comment on column SOC0122.MAPID is '主键ID';
comment on column SOC0122.EIDOMAINID is '域ID';
comment on column SOC0122.SNAPSHOTBAT is '拓扑BAT';
comment on column SOC0122.EIDOMAINDESC is '域描述';

--SOC0147 
comment on table SOC0147 is '告警信息唯一表';
comment on column SOC0147.DETECTIONDAY is '告警日期';
comment on column SOC0147.DETECTIONMIN is '告警时间';
comment on column SOC0147.DIR is 'DIR';
comment on column SOC0147.ERRORNUM is '错误码';
comment on column SOC0147.EIROOTMARK is '顶级资产名称';
comment on column SOC0147.FINGERPRINT is '时间戳';

--SOC0201  
comment on table SOC0201 is '自动报表生成表';
comment on column SOC0201.id is 'ID';
comment on column SOC0201.DATAID is '数据ID';
comment on column SOC0201.R_CATEGORY is '统计类型';
comment on column SOC0201.R_PATH is '报表文件名称';
comment on column SOC0201.R_RCID is '报表配置id';
comment on column SOC0201.R_TIME is '报表统计年月';
comment on column SOC0201.fingerprint is '时间戳';

--SOC0202  
comment on table SOC0202 is '附加报表';
comment on column SOC0202.rald is '附加ID';
comment on column SOC0202.raName is '附加报表名字';
comment on column SOC0202.raSsn is '存储序列号';
comment on column SOC0202.raKpi is 'kpi';
comment on column SOC0202.raCreateDate is '创建时间';
comment on column SOC0202.raUserName is '用户名称';
comment on column SOC0202.raRealName is '真实名字';
comment on column SOC0202.fingerprint is '时间戳';

--SOC0203  
comment on table SOC0203 is '自动报表配置列表';
comment on column SOC0203.id is 'ID';
comment on column SOC0203.DATAID is '数据ID';
comment on column SOC0203.R_PATH is '报表文件名称';
comment on column SOC0203.R_TITLEis '报表文件的中文含义';
comment on column SOC0203.R_PARA is '报表运行时所用的参数';
comment on column SOC0203.fingerprint is '时间戳';

--SOC0204  
comment on table SOC0204 is '报表自定链接';
comment on column SOC0204.rmId is '主键ID';
comment on column SOC0204.rclReportType is '报表类型';
comment on column SOC0204.rclObjName is '对象名称';
comment on column SOC0204.rclTemName is '模板名字';
comment on column SOC0204.rclTemDesc is '模板描述';
comment on column SOC0204.rclObjEiid is '对象Eiid';
comment on column SOC0204.rclObjType is '对象类型';
comment on column SOC0204.rclMode is '容量Mode';
comment on column SOC0204.rclCaType is '容量主机小类型';
comment on column SOC0204.rclMenuDefault is '菜单默认';
comment on column SOC0204.rclUserId is '用户帐号';
comment on column SOC0204.fingerprint is '时间戳';

--SOC0205  
comment on table SOC0205 is '报告管理表';
comment on column SOC0205.rmId is '报告ID';
comment on column SOC0205.rmName is '报告名称';
comment on column SOC0205.rtId is '模板对象';
comment on column SOC0205.rmYear is '年';
comment on column SOC0205.rmQuarter is '季度';
comment on column SOC0205.rmMonth is '月';
comment on column SOC0205.createDate is '创建时间';
comment on column SOC0205.lastAnnexationDate is '最后附加报表时间';
comment on column SOC0205.fingerprint is '时间戳';

--SOC0206  
comment on table SOC0206 is '模板映射表';
comment on column SOC0206.rtmId is '流水ID';
comment on column SOC0206.rtNumber is '模板位置序号';
comment on column SOC0206.rtmSsn is '存储序列号';
comment on column SOC0206.rtmKpi is '时间类型';
comment on column SOC0206.rtRealName is 'KPI';
comment on column SOC0206.rtmImgNumbere is 'Word文档对象图片位置';
comment on column SOC0206.rtId is '模板对象';
comment on column SOC0206.fingerprint is '时间戳';

--SOC0207  
comment on table SOC0207 is '报告模板';
comment on column SOC0207.rtId is 'ID';
comment on column SOC0207.rtName is '模板名称';
comment on column SOC0207.rtSum is '可修改位置数';
comment on column SOC0207.rtDateType is '时间类型';
comment on column SOC0207.rtRealName is '模板真实名字';
comment on column SOC0207.rtUploadTime is '模板上传时间';
comment on column SOC0207.rtType is '模板类型';
comment on column SOC0207.fingerprint is '时间戳';

--SOC0208  
comment on table SOC0208 is '事件变更服务效率';
comment on column SOC0208.prtype is '流程类型';
comment on column SOC0208.pivaralue is '流程来源';
comment on column SOC0208.efficiencyTime is '时间';
comment on column SOC0208.monthEfficiency is '当前月服务效率';
comment on column SOC0208.historyEfficiency is '历史服务效率';

--SOC0301  
comment on table SOC0301 is 'DMX实时监控性能表';
comment on column SOC0301.id is '主键';
comment on column SOC0301.mtId is '监控任务id';
comment on column SOC0301.mtoName is '监控对象名';
comment on column SOC0301.mtKpio is '性能指标';
comment on column SOC0301.kpiValue is '性能指标值';
comment on column SOC0301.timeStamp is '解析时间点';
comment on column SOC0301.fingerprint is '时间戳';

--SOC0302  
comment on table SOC0302 is 'DMX实时监控性能缓存表';
comment on column SOC0302.mtId is '监控任务id';
comment on column SOC0302.timeStamp is '解析时间点';
comment on column SOC0302.IOPS is '系统IOPS';
comment on column SOC0302.IO_Read is '每秒读IO数量';
comment on column SOC0302.IO_Write is '每秒写IO数量';
comment on column SOC0302.RW_Hits is '缓存读写命中率';
comment on column SOC0302.KB_Read is '每秒读吞吐量';
comment on column SOC0302.KB_Write is '每秒写吞吐量';

--SOC0303  
comment on table SOC0303 is 'KPI位置映射表';
comment on column SOC0303.id is '主键';
comment on column SOC0303.mtcName is '组件类别';
comment on column SOC0303.mtKpi is '性能指标';
comment on column SOC0303.kpiIndex is 'KPI数据列索引';

--SOC0304  
comment on table SOC0304 is '监控任务主表';
comment on column SOC0304.id is '主键';
comment on column SOC0304.mtSsn is '存储序列号d';
comment on column SOC0304.mtCname is '组件名称';
comment on column SOC0304.mtKpi is 'KPI';
comment on column SOC0304.mtoObjNames is '监控对象字符串';
comment on column SOC0304.mtInterval is '采集间隔';
comment on column SOC0304.mtNum is '采集次数';
comment on column SOC0304.mtStartTime is '开始时间';
comment on column SOC0304.mtStopTime is '结束时间';
comment on column SOC0304.mtPStopTime is '预计结束时间';
comment on column SOC0304.mtStatus is '任务状态';
comment on column SOC0304.mtRecordTime is '记录时间';
comment on column SOC0304.mtUserId is '记录用户id';
comment on column SOC0304.mtOrgId is '用户部门ID';
comment on column SOC0304.fingerprint is '时间戳';

--SOC0305  
comment on table SOC0305 is '告警信息表';
comment on column SOC0305.id is '主键';
comment on column SOC0305.detectiontime is '告警时间';
comment on column SOC0305.dir is 'dir';
comment on column SOC0305.src is 'src';
comment on column SOC0305.category is 'category';
comment on column SOC0305.severity is '告警级别';
comment on column SOC0305.errornum is '错误码';
comment on column SOC0305.errordesc is '错误描述';
comment on column SOC0305.eirootmark is '顶级资产名称';
comment on column SOC0305.state is 'state';
comment on column SOC0305.sort is 'sort';
comment on column SOC0305.imptypename is '导入类型名称';
comment on column SOC0305.imptypeid is '导入类型id';
comment on column SOC0305.lparnam is 'lparnam';
comment on column SOC0305.ip is 'ip';
comment on column SOC0305.reportingmtms is 'reportingmtms';
comment on column SOC0305.failingenclosuremtms is 'failingenclosuremtms';
comment on column SOC0305.fru1loc is 'fru1loc';
comment on column SOC0305.fru2loc is 'fru2loc';
comment on column SOC0305.fru3loc is 'fru3loc';
comment on column SOC0305.fingerprint is '时间戳';
comment on column SOC0305.alarmtype is '告警类型';
comment on column SOC0305.status is '告警状态';

--SOC0306  
comment on table SOC0306 is '未导入性能数据资产信息表';
comment on column SOC0306.id is '主键';
comment on column SOC0306.symmid is '资产名称';
comment on column SOC0306.dataitmes is '未导入时间';
comment on column SOC0306.symtype is '资产类型';
comment on column SOC0306.readdate is '确认时间';
comment on column SOC0306.fingerprint is '时间戳';

--SOC0401 
comment on table SOC0401 is '数据库容量实时表';
comment on column SOC0401.DBID is '流水ID';
comment on column SOC0401.DBNAME is '数据库名称';
comment on column SOC0401.HOSTNAME is '主机名称';
comment on column SOC0401.CREATEDATE is '日期';
comment on column SOC0401.ALLOTTEDCAPACITY is '已分配容量';
comment on column SOC0401.FREECAPACITY is '空闲容量';
comment on column SOC0401.USEDCAPACITY is '已使用容量';
comment on column SOC0401.FINGERPRINT is '时间戳';

--SOC0402 
comment on table SOC0402 is '数据库容量月表';
comment on column SOC0402.DBID is '流水ID';
comment on column SOC0402.DBNAME is '数据库名称';
comment on column SOC0402.HOSTNAME is '主机名称';
comment on column SOC0402.CREATEDATE is '日期';
comment on column SOC0402.ALLOTTEDCAPACITY is '已分配容量';
comment on column SOC0402.FREECAPACITY is '空闲容量';
comment on column SOC0402.USEDCAPACITY is '已使用容量';
comment on column SOC0402.FINGERPRINT is '时间戳';

--SOC0403 
comment on table SOC0403 is '数据库容量季表';
comment on column SOC0403.DBID is '流水ID';
comment on column SOC0403.DBNAME is '数据库名称';
comment on column SOC0403.HOSTNAME is '主机名称';
comment on column SOC0403.CREATEDATE is '日期';
comment on column SOC0403.ALLOTTEDCAPACITY is '已分配容量';
comment on column SOC0403.FREECAPACITY is '空闲容量';
comment on column SOC0403.USEDCAPACITY is '已使用容量';
comment on column SOC0403.FINGERPRINT is '时间戳';

--SOC0404  
comment on table SOC0404 is '数据库容量年表';
comment on column SOC0404.DBID is '流水ID';
comment on column SOC0404.DBNAME is '数据库名称';
comment on column SOC0404.HOSTNAME is '主机名称';
comment on column SOC0404.CREATEDATE is '日期';
comment on column SOC0404.ALLOTTEDCAPACITY is '已分配容量';
comment on column SOC0404.FREECAPACITY is '空闲容量';
comment on column SOC0404.USEDCAPACITY is '已使用容量';
comment on column SOC0404.FINGERPRINT is '时间戳';

--SOC0405 
comment on table SOC0405 is '逻辑卷容量实时表';
comment on column SOC0405.LVID is '流水ID';
comment on column SOC0405.HOSTNAME is '主机名称';
comment on column SOC0405.VGNAME is '卷组名称';
comment on column SOC0405.LVTYPE is '逻辑卷类型';
comment on column SOC0405.LVNAME is '逻辑卷名称';
comment on column SOC0405.LVSIZE is '逻辑卷大小';
comment on column SOC0405.LVSTATE is '逻辑卷状态';
comment on column SOC0405.FSNAME is '文件系统名称';
comment on column SOC0405.CREATEDATE is '日期';
comment on column SOC0405.ALLOTTEDCAPACITY is '已分配容量';
comment on column SOC0405.FREECAPACITY is '空闲容量';
comment on column SOC0405.USEDCAPACITY is '已使用容量';
comment on column SOC0405.FINGERPRINT is '时间戳';

--SOC0406 
comment on table SOC0406 is '逻辑卷容量月表';
comment on column SOC0406.LVID is '流水ID';
comment on column SOC0406.HOSTNAME is '主机名称';
comment on column SOC0406.VGNAME is '卷组名称';
comment on column SOC0406.LVTYPE is '逻辑卷类型';
comment on column SOC0406.LVNAME is '逻辑卷名称';
comment on column SOC0406.LVSIZE is '逻辑卷大小';
comment on column SOC0406.LVSTATE is '逻辑卷状态';
comment on column SOC0406.FSNAME is '文件系统名称';
comment on column SOC0406.CREATEDATE is '日期';
comment on column SOC0406.ALLOTTEDCAPACITY is '已分配容量';
comment on column SOC0406.FREECAPACITY is '空闲容量';
comment on column SOC0406.USEDCAPACITY is '已使用容量';
comment on column SOC0406.FINGERPRINT is '时间戳';

--SOC0407 
comment on table SOC0407 is '逻辑卷容量季表';
comment on column SOC0407.LVID is '流水ID';
comment on column SOC0407.HOSTNAME is '主机名称';
comment on column SOC0407.VGNAME is '卷组名称';
comment on column SOC0407.LVTYPE is '逻辑卷类型';
comment on column SOC0407.LVNAME is '逻辑卷名称';
comment on column SOC0407.LVSIZE is '逻辑卷大小';
comment on column SOC0407.LVSTATE is '逻辑卷状态';
comment on column SOC0407.FSNAME is '文件系统名称';
comment on column SOC0407.CREATEDATE is '日期';
comment on column SOC0407.ALLOTTEDCAPACITY is '已分配容量';
comment on column SOC0407.FREECAPACITY is '空闲容量';
comment on column SOC0407.USEDCAPACITY is '已使用容量';
comment on column SOC0407.FINGERPRINT is '时间戳';

--SOC0408
comment on table SOC0408 is '逻辑卷容量年表';
comment on column SOC0408.LVID is '流水ID';
comment on column SOC0408.HOSTNAME is '主机名称';
comment on column SOC0408.VGNAME is '卷组名称';
comment on column SOC0408.LVTYPE is '逻辑卷类型';
comment on column SOC0408.LVNAME is '逻辑卷名称';
comment on column SOC0408.LVSIZE is '逻辑卷大小';
comment on column SOC0408.LVSTATE is '逻辑卷状态';
comment on column SOC0408.FSNAME is '文件系统名称';
comment on column SOC0408.CREATEDATE is '日期';
comment on column SOC0408.ALLOTTEDCAPACITY is '已分配容量';
comment on column SOC0408.FREECAPACITY is '空闲容量';
comment on column SOC0408.USEDCAPACITY is '已使用容量';
comment on column SOC0408.FINGERPRINT is '时间戳';

--SOC0409 
comment on table SOC0409 is '物理卷主机实时表';
comment on column SOC0409.PHID is '流水ID';
comment on column SOC0409.SNAME is '存储序列号';
comment on column SOC0409.HOSTNAME is '主机名称';
comment on column SOC0409.VGNAME is '卷组名称';
comment on column SOC0409.CREATEDATE is '日期';
comment on column SOC0409.LUNID is 'LUNID';
comment on column SOC0409.PVSIZE is '物理卷大小';
comment on column SOC0409.FINGERPRINT is '时间戳';

--SOC0410 
comment on table SOC0410 is '物理卷存储实时表';
comment on column SOC0410.PSID is '流水ID';
comment on column SOC0410.SNAME is '存储序列号';
comment on column SOC0410.LUNID is 'LUNID';
comment on column SOC0410.PVSIZE is '物理卷大小';
comment on column SOC0410.ISUSED is '是否被分配';
comment on column SOC0410.CREATEDATE is '日期';
comment on column SOC0410.FINGERPRINT is '时间戳';

--SOC0411 
comment on table SOC0411 is '存储容量实时表';
comment on column SOC0411.SCID is '流水ID';
comment on column SOC0411.SNAME is '存储序列号';
comment on column SOC0411.CREATEDATE is '日期';
comment on column SOC0411.RAWCAPACITY is '裸容量';
comment on column SOC0411.EFFECTIVECAPACITY is '有效容量';
comment on column SOC0411.REDUNDANCYCAPACITY is '冗余容量';
comment on column SOC0411.ALLOTTEDCAPACITY is '已分配容量';
comment on column SOC0411.FREECAPACITY is '空闲容量';
comment on column SOC0411.DISKCOUNT is '磁盘个数';
comment on column SOC0411.FINGERPRINT is '时间戳';

--SOC0412 
comment on table SOC0412 is '存储容量月表';
comment on column SOC0412.SCID is '流水ID';
comment on column SOC0412.SNAME is '存储序列号';
comment on column SOC0412.CREATEDATE is '日期';
comment on column SOC0412.RAWCAPACITY is '裸容量';
comment on column SOC0412.EFFECTIVECAPACITY is '有效容量';
comment on column SOC0412.REDUNDANCYCAPACITY is '冗余容量';
comment on column SOC0412.ALLOTTEDCAPACITY is '已分配容量';
comment on column SOC0412.FREECAPACITY is '空闲容量';
comment on column SOC0412.DISKCOUNT is '磁盘个数';
comment on column SOC0412.FINGERPRINT is '时间戳';

--SOC0413 
comment on table SOC0413 is '存储容量季表';
comment on column SOC0413.SCID is '流水ID';
comment on column SOC0413.SNAME is '存储序列号';
comment on column SOC0413.CREATEDATE is '日期';
comment on column SOC0413.RAWCAPACITY is '裸容量';
comment on column SOC0413.EFFECTIVECAPACITY is '有效容量';
comment on column SOC0413.REDUNDANCYCAPACITY is '冗余容量';
comment on column SOC0413.ALLOTTEDCAPACITY is '已分配容量';
comment on column SOC0413.FREECAPACITY is '空闲容量';
comment on column SOC0413.DISKCOUNT is '磁盘个数';
comment on column SOC0413.FINGERPRINT is '时间戳';

--SOC0414 
comment on table SOC0414 is '存储容量年表';
comment on column SOC0414.SCID is '流水ID';
comment on column SOC0414.SNAME is '存储序列号';
comment on column SOC0414.CREATEDATE is '日期';
comment on column SOC0414.RAWCAPACITY is '裸容量';
comment on column SOC0414.EFFECTIVECAPACITY is '有效容量';
comment on column SOC0414.REDUNDANCYCAPACITY is '冗余容量';
comment on column SOC0414.ALLOTTEDCAPACITY is '已分配容量';
comment on column SOC0414.FREECAPACITY is '空闲容量';
comment on column SOC0414.DISKCOUNT is '磁盘个数';
comment on column SOC0414.FINGERPRINT is '时间戳';

--SOC0415 
comment on table SOC0415 is '表空间容量实时表';
comment on column SOC0415.TSID is '流水ID';
comment on column SOC0415.TSNAME is '表空间名称';
comment on column SOC0415.HOSTNAME is '主机名称';
comment on column SOC0415.DBNAME is '数据库名称';
comment on column SOC0415.CREATEDATE is '日期';
comment on column SOC0415.ALLOTTEDCAPACITY is '已分配容量';
comment on column SOC0415.FREECAPACITY is '空闲容量';
comment on column SOC0415.USEDCAPACITY is '已使用容量';
comment on column SOC0415.FINGERPRINT is '时间戳';

--SOC0416 
comment on table SOC0416 is '表空间容量月表';
comment on column SOC0416.TSID is '流水ID';
comment on column SOC0416.TSNAME is '表空间名称';
comment on column SOC0416.HOSTNAME is '主机名称';
comment on column SOC0416.DBNAME is '数据库名称';
comment on column SOC0416.CREATEDATE is '日期';
comment on column SOC0416.ALLOTTEDCAPACITY is '已分配容量';
comment on column SOC0416.FREECAPACITY is '空闲容量';
comment on column SOC0416.USEDCAPACITY is '已使用容量';
comment on column SOC0416.FINGERPRINT is '时间戳';

--SOC0417 
comment on table SOC0417 is '表空间容量季表';
comment on column SOC0417.TSID is '流水ID';
comment on column SOC0417.TSNAME is '表空间名称';
comment on column SOC0417.HOSTNAME is '主机名称';
comment on column SOC0417.DBNAME is '数据库名称';
comment on column SOC0417.CREATEDATE is '日期';
comment on column SOC0417.ALLOTTEDCAPACITY is '已分配容量';
comment on column SOC0417.FREECAPACITY is '空闲容量';
comment on column SOC0417.USEDCAPACITY is '已使用容量';
comment on column SOC0417.FINGERPRINT is '时间戳';

--SOC0418 
comment on table SOC0418 is '表空间容量年表';
comment on column SOC0418.TSID is '流水ID';
comment on column SOC0418.TSNAME is '表空间名称';
comment on column SOC0418.HOSTNAME is '主机名称';
comment on column SOC0418.DBNAME is '数据库名称';
comment on column SOC0418.CREATEDATE is '日期';
comment on column SOC0418.ALLOTTEDCAPACITY is '已分配容量';
comment on column SOC0418.FREECAPACITY is '空闲容量';
comment on column SOC0418.USEDCAPACITY is '已使用容量';
comment on column SOC0418.FINGERPRINT is '时间戳';

--SOC0419 
comment on table SOC0419 is '卷组容量实时表';
comment on column SOC0419.VGID is '流水ID';
comment on column SOC0419.VGNAME is '卷组名称';
comment on column SOC0419.HOSTNAME is '主机名称';
comment on column SOC0419.SNAME is '存储序列号';
comment on column SOC0419.CREATEDATE is '日期';
comment on column SOC0419.ALLOTTEDCAPACITY is '已分配容量';
comment on column SOC0419.FREECAPACITY is '空闲容量';
comment on column SOC0419.USEDCAPACITY is '已使用容量';
comment on column SOC0419.FINGERPRINT is '时间戳';

--SOC0420 
comment on table SOC0420 is '卷组容量月表';
comment on column SOC0420.VGID is '流水ID';
comment on column SOC0420.VGNAME is '卷组名称';
comment on column SOC0420.HOSTNAME is '主机名称';
comment on column SOC0420.SNAME is '存储序列号';
comment on column SOC0420.CREATEDATE is '日期';
comment on column SOC0420.ALLOTTEDCAPACITY is '已分配容量';
comment on column SOC0420.FREECAPACITY is '空闲容量';
comment on column SOC0420.USEDCAPACITY is '已使用容量';
comment on column SOC0420.FINGERPRINT is '时间戳';

--SOC0421 
comment on table SOC0421 is '卷组容量季表';
comment on column SOC0421.VGID is '流水ID';
comment on column SOC0421.VGNAME is '卷组名称';
comment on column SOC0421.HOSTNAME is '主机名称';
comment on column SOC0421.SNAME is '存储序列号';
comment on column SOC0421.CREATEDATE is '日期';
comment on column SOC0421.ALLOTTEDCAPACITY is '已分配容量';
comment on column SOC0421.FREECAPACITY is '空闲容量';
comment on column SOC0421.USEDCAPACITY is '已使用容量';
comment on column SOC0421.FINGERPRINT is '时间戳';

--SOC0422 
comment on table SOC0422 is '卷组容量年表';
comment on column SOC0422.VGID is '流水ID';
comment on column SOC0422.VGNAME is '卷组名称';
comment on column SOC0422.HOSTNAME is '主机名称';
comment on column SOC0422.SNAME is '存储序列号';
comment on column SOC0422.CREATEDATE is '日期';
comment on column SOC0422.ALLOTTEDCAPACITY is '已分配容量';
comment on column SOC0422.FREECAPACITY is '空闲容量';
comment on column SOC0422.USEDCAPACITY is '已使用容量';
comment on column SOC0422.FINGERPRINT is '时间戳';

--SOC0423 
comment on table SOC0423 is '容量对象列表';
comment on column SOC0423.ID is '流水ID';
comment on column SOC0423.NAME is '父级容量对象名称';
comment on column SOC0423.OBJECTTYPE is '容量对象类型';
comment on column SOC0423.OBJECTNAME is '容量对象名称';
comment on column SOC0423.FINGERPRINT is '时间戳';
comment on column SOC0423.ERRORNUM is '严重告警阈值';
comment on column SOC0423.WARNINGNUM is '普通告警阈值';
comment on column SOC0423.STATUS is '状态';

--SOC0424 
comment on table SOC0424 is '报表类型表';
comment on column SOC0424.REPORTNAME is '报表名称';
comment on column SOC0424.RTTYPE is '报表类型';
comment on column SOC0424.STORAGETYPE is '存储类型';
comment on column SOC0424.FINGERPRINT is '时间戳';

--SOC0425 
comment on table SOC0425 is '业务系统容量月表';
comment on column SOC0425.ID is '流水ID';
comment on column SOC0425.BCID is '业务系统ID';
comment on column SOC0425.BCNAME is '业务系统名称';
comment on column SOC0425.SNAME is '存储序列号';
comment on column SOC0425.CREATEDATE is '日期';
comment on column SOC0425.ALLOTTEDCAPACITY is '已分配容量';
comment on column SOC0425.USEDCAPACITY is '已使用容量';
comment on column SOC0425.FINGERPRINT is '时间戳';

--SOC0426 
comment on table SOC0426 is '业务系统容量季表';
comment on column SOC0426.ID is '流水ID';
comment on column SOC0426.BCID is '业务系统ID';
comment on column SOC0426.BCNAME is '业务系统名称';
comment on column SOC0426.SNAME is '存储序列号';
comment on column SOC0426.CREATEDATE is '日期';
comment on column SOC0426.ALLOTTEDCAPACITY is '已分配容量';
comment on column SOC0426.USEDCAPACITY is '已使用容量';
comment on column SOC0426.FINGERPRINT is '时间戳';

--SOC0427 
comment on table SOC0427 is '业务系统容量年表';
comment on column SOC0427.ID is '流水ID';
comment on column SOC0427.BCID is '业务系统ID';
comment on column SOC0427.BCNAME is '业务系统名称';
comment on column SOC0427.SNAME is '存储序列号';
comment on column SOC0427.CREATEDATE is '日期';
comment on column SOC0427.ALLOTTEDCAPACITY is '已分配容量';
comment on column SOC0427.USEDCAPACITY is '已使用容量';
comment on column SOC0427.FINGERPRINT is '时间戳';

--SOC0433
comment on table SOC0433 is 'VIO';
comment on column SOC0433.ID is '流水ID';
comment on column SOC0433.VIONAME is 'VIO名称';
comment on column SOC0433.HOSTNAME is '主机名称';
comment on column SOC0433.FINGERPRINT is '时间戳';

--SOC0434
comment on table SOC0434 is 'VIO物理卷表';
comment on column SOC0434.pvvid is '主键';
comment on column SOC0434.sn is '序列号';
comment on column SOC0434.sName is '存储名';
comment on column SOC0434.lunid is 'lunid';
comment on column SOC0434.pvSize is '物理卷容量';
comment on column SOC0434.isUsed is '使用状态';
comment on column SOC0434.createDate is '日期';
comment on column SOC0434.FINGERPRINT is '时间戳';

--SOC0435 
comment on table SOC0435 is '主机pv表';
comment on column SOC0435.PHID is '流水ID';
comment on column SOC0435.SNAME is '存储序列号';
comment on column SOC0435.HOSTNAME is '主机名称';
comment on column SOC0435.VGNAME is '卷组名称';
comment on column SOC0435.CREATEDATE is '日期';
comment on column SOC0435.LUNID is 'LUNID';
comment on column SOC0435.PVSIZE is '物理卷大小';
comment on column SOC0435.FINGERPRINT is '时间戳';

--SOC0436 
comment on table SOC0436 is '物理卷存储实时表';
comment on column SOC0436.PSID is '流水ID';
comment on column SOC0436.SNAME is '存储序列号';
comment on column SOC0436.LUNID is 'LUNID';
comment on column SOC0436.PVSIZE is '物理卷大小';
comment on column SOC0436.ISUSED is '是否被分配';
comment on column SOC0436.CREATEDATE is '日期';
comment on column SOC0436.FINGERPRINT is '时间戳';