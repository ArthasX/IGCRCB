package com.deliverik.infogovernor.util;


/**
 * 基础数据分类常量定义<br>
 *
 * 
 *
 * @author 
 * @updateDate 2014/04/10 LuJiayuan
 * (1)迁移审计管理添加"853"/"854"/"855"枚举类型
 */
public enum CodeDefine {
	
	/** 资产模型分类 */
	ENTITY_CATEGORY_CODE("001"),
	/** 资产模型分类编号 */
	ENTITY_TYPE_CODE("890"),
	/** 保留 */
	ENTITY_EKEY1_CODE("002"),
	/** 保留 */
	ENTITY_EKEY2_CODE("003"),
	/** 保留 */
	ENTITY_EKEY3_CODE("004"),
	/** 资产模型状态 */
	ENTITY_STATUS_CODE("005"),

	/** 资产模型属性单位 */
	CONFIGURATION_UNIT_CODE("006"),
	/** 资产模型属性状态 */
	CONFIGURATION_STATUS_CODE("007"),
	/** 资产模型属性分类 */
	CONFIGURATION_CATEGORY_CODE("008"),

	/** 资产状态 */
	ENTITY_ITEM_STATUS_CODE("009"),

	/** 资产属性状态 */
	CONFIG_ITEM_STATUS_CODE("010"),

	/** 资产关系类型 */
	ENTITY_ITEM_RELATION_CODE("011"),

	/** 资产模型属性数据类型 */
	CONFIGURATION_ATTACH_CODE("012"),
	/** 预案章节类型 */
	CONFIGURATION_PLAN_CODE("013"),
	
	/** 保留 */
	PROJECT_TYPE_CATEGORY_CODE("021"),

	/** 预算类型 */
	BUDGET_TYPE_CATEGORY_CODE("031"),

	/** 基础数据编辑标识 */
	EDIT_STATUS_CODE("999"),

	/** 角色类型 */
	ROLE_CATEGORY_CODE("100"),

	/** 影响程度 */
	IMPACT_GRADE_CODE("101"),
	
	/** 事件优先级 */
	PROCESS_PRIORITY_I("142"),

	/** 自定义流程类型 */
	PROCESS_TYPE_CODE("230"),
	
	/**  */
	I("103"),
	P("104"),
	C("105"),
	D("106"),
	
	
	
	/**  */
	WA("107"),
	WB("108"),
	WS("221"),
	
    /** 检查频率类别 */
    RISK_FREQUENCY_TYPE("272"),
	
	/**  */
	INCIDENT_CATEGORY_CODE("109"),
	
	/** 调度方式  */
	STRATEGY_WORK_CODE("110"),
	
	/** 服务类别  */
	SERVER_CATEGORY_CODE("111"),
	
	/** 项目状态  */
	PROJECT_STATUS_CODE("112"),
	
	/** 基础数据使用状态  */
	ENABLED_STATUS_CODE("113"),
	
	/** 保留  */
	EQUIPMENT_STATUS_CODE("114"),
	
	/** 保留  */
	PERSON_CATEGORY_CODE("115"),
	
	/** 保留  */
	SERVICE_CATEGORY_CODE("116"),
	
	/** 流程变更子状态  */
	CSUB("117"),
	
	/** 流程发布子状态  */
	DSUB("118"),
	
	/** 流程事件子状态  */
	ISUB("242"),
	
	/** 流程问题子状态  */
	PSUB("243"),
	
	/** 流程服务请求子状态  */
	SSUB("244"),
	
	/** 个人工作子状态  */
	WBSUB("245"),
	
	/** 指派工作子状态  */
	WASUB("246"),
	
	/** 技术支持工单子状态  */
	WSSUB("247"),
	
	/** 报表类型  */
	RFDPICTYPE("260"),

	/** 服务水平级别 */
	SERVICE_LEVEL_GRADE("120"),
	/** 事件紧急程度 */
	IURGENCY_GRADE_CODE("119"),
	/** 问题紧急程度 */
	PURGENCY_GRADE_CODE("102"),
	/** 变更紧急程度 */
	CURGENCY_GRADE_CODE("121"),
	/** 发布紧急程度 */
	DURGENCY_GRADE_CODE("122"),
	/** 指派工作紧急程度 */
	WAURGENCY_GRADE_CODE("123"),
	/** 个人工作紧急程度 */
	WBURGENCY_GRADE_CODE("124"),

	/**  */
	S("125"),
	/** 服务请求紧急程度 */
	SURGENCY_GRADE_CODE("126"),
	/** 工作管理紧急程度 */
	WDURGENCY_GRADE_CODE("127"),
	
	/** 流程变量类型 */
	PROCESSINFODEF_TYPE_CODE("128"),
	/** 风险程度 */
	RADRISKLEVEL_CODE("129"),
	/** 控制频率 */
	RADFREQUENCY_CODE("130"),
	/** 控制手段 */
	RADMODE_CODE("131"),
	/** 控制类型 */
	RADTYPE_CODE("132"),
	/** 制度建设评分 */
	RARPLANSCORE_CODE("133"),
	/** 制度执行评分 */
	RAREXECSCORE_CODE("134"),
	/** 总体评分 */
	RAROVERALLSCORE_CODE("135"),
	/** 风险检查结果 */
	RISKCHECKRESULT_CODE("136"),
	/** 风险检查类型 */
	RISKCHECK_CLASS_CODE("143"),
	
	/** 检查方式*/
	RISKCHECK_CLASS_TYPE("144"),
	
	/** 风险检查类型   检查重要程度 */
	RISKCHECK_TYPE_CODE("137"),
	/**  */
	INCIDENT_IMPACT_CODE("138"),
	/**  */
	INCIDENT_SUPERVISION_NOTIFYTIME("139"),
	/**  */
	INCIDENT_SUPERVISION_REPORTTIME("140"),
	/**  */
	INCIDENT_SUPERVISION_RESOLVETIME("141"),
	/** 年度 */
	YEAR_CODE("150"),
	/** 月份 */
	MONTH_CODE("151"),
	/** 邮件 */
	EMAIL_CODE("152"),
	/** 短信 */
	SMS_CODE("153"),
	/** LDAP */
	LDAP_CODE("154"),
	/** 报表 */
	BIRT_CODE("155"),
	/**检查分类*/
	DUTY_TYPE("203"),
	/**填报时间限制*/
	DUTY_LIMIT_TIME("204"),
	/**检查结果*/
	DUTY_CONTENT("205"),
	/**结果说明*/
	DUTY_INFO("206"),
	/** 值班计划类型 */
	DUTY_PLANTYPE("207"),
	DAYSHIFT_DUTY_PERIOD("201"),
	NIGHTSHIFT_DUTY_PERIOD("202"),
	LOM_GOODS_TYPE("216"),
	
	/** 报表管理-报表分类 */
	REOPRT_TYPE_CODE("217"),
	
	/** 自定义流程节点类型 */
	PROCESS_NODE_TYPE_CODE("218"),
	
	/** 服务工单管理-状态 */
	SERVICEFORM_STATUS("219"),

	/** 服务工单管理-工单类别 */
	SERVICEFORM_TYPE("220"),
	/** 工作管理紧急程度 */
	WSURGENCY_GRADE_CODE("222"),
	
	/** 自定义流程节点模式 */
	PROCESS_NODE_MODE_CODE("231"),
	
	/** 自定义流程节点是否可动态分派 */
	PROCESS_NODE_DYNAMIC_CODE("223"),
	
	PROCESS_LINK_CODE("232"),
	/** 自定义流程页面类型*/
	PROCESS_JSP_CODE("292"),
	
	/** 知识审核状态 */
	RECOR_STATUS_CODE("233"),
	
	/** 可定义策略的流程类型 */
	PROCESS_STRATEGY_DEF_PRTYPE("234"),
	
	/** 审批状态 */
	PROCESS_ASSESSMENT_STATUS("240"),
	
	/** 事件可设定策略状态 */
	I_STRATEGY_STATUS("249"),
	
	/** 问题可设定策略状态 */
	P_STRATEGY_STATUS("250"),
	
	/** 变更可设定策略状态 */
	C_STRATEGY_STATUS("251"),
	
	/** 系统类型 */
	BUSINESS_SYSTEM_CODE("241"),
	/** 知识类型 */
	KNOWLEDGE_TYPE_CODE("252"),
	
	/** 知识状态 */
	KNOWLEDGE_STATUS("253"),
	
	/** 知识来源 */
	KNOWLEDGE_FROM("254"),
	
	/** 关键字 */
	KNOWLEDGE_KEYS("258"),
	
	/** CI导入待处理任务状态 */
	EIWAITTASK_STATUS("262"),
	
	/** CI2导入待处理任务状态 */
	CIWAITTASK_TWO_STATUS("273"),
	
	
	/** 审计CI导入待处理任务状态 */
	AUDITWAITTASK_STATUS("263"),
	
	/** 审计对比结果类型 */
	AUDITRESULT_AUCMPTYPE("264"),
	
	/** 审计对比结果合理标识 */
	AUDITRESULT_AUFLAG("265"),
	
	/** CI更新导入待处理任务状态 */
	CIWAITTASK_STATUS("266"),
	
	/** CI更新对比结果类型 */
	CIRESULT_CICMPTYPE("267"),
	
	/** CI更新对比结果合理标识 */
	CIRESULT_CIFLAG("268"),
	
	/** 审计任务状态 */
	AUTSTATUS("269"),
	
	/** CI更新任务状态 */
	CISTATUS("270"),
	
	/** 采集任务状态 */
	CI_COLLECT_STATUS("271"),
	
	/** 机柜标识 */
	SELF_CODE("156"),
	
	/** 流程表单模式 */
	PROCESSINFODEF_MODE_CODE("276"),
	
	/** 流程表单显示宽度 */
	PROCESSINFODEF_ROWWIDTH_CODE("277"),
	
	/** 流程表单私有权限范围 */
	PROCESSINFODEF_PRIVATEACCESS_SCOPE("278"),
	
	/** 可被分派参与者类型 */
	PROCESSSTATUSDEF_PSDASSIGN("279"),
	
	/** 是否机构过滤 */
	PROCESSSTATUSDEF_PSDORG("280"),
	
	/** 有无确认操作 */
	PROCESSSTATUSDEF_PSDCONFIRM("281"),
	
	/** 天 */
	DAYS_CODE("282"),
	
	/** 小时 */
	HOURS_CODE("283"),
	
	/** 分 */
	MINUTES_CODE("285"),
	
	/** 流程策略通知人类型 */
	PRSTRATEGY_NOTIFIER_TYPE_CODE("286"),
	/** 自定义流程表单内容 */
	PROCESSINFODEF_TYPE_CODE_WD("287"),
	
	/** 审计项目状态 */
	IAPSTATUS("853"),
    /** 外审检查来源*/
    IAPSOURCE("854"),    
    /** 审计报告类型*/
    AUDITREPORTTYPE("855"),
    
	/** 工单来源 */
	SERVICEFORM_SFSOURCE("288"),
	/** 变更内容 */
	CHANG_CONTENT("289"),
	/** 组件类型标识 */
    COMPONENT_TYPE_CODE("800"),
    /** SYSTEM_KPI标识 */
    SYSTEM_KPI_CODE("801"),
    /** SYSTEM采集间隔标识 */
    SYSTEM_VAL_CODE("802"),
	/** 业务运行资产 */
	BUSINESSRUN_ENTITYITEM("823"),
	
	/** 统计分析新增2012/08/14 */
	/** 时间类型 */
	REPORT_DATETYPE_CODE("824"),
	/** 时间类型:季度 */
	REPORT_DATETYPEQ_CODE("825"),
	/** 告警等级标识 原SOC ccid=270*/
    ALARM_SEVERITY_CODE("820"),
    /** 告警类型标识 原SOC ccid=271*/
    ALARM_TYPE_CODE("821"),
    /** 容量监控管理类型 原SOC ccid=272 */
    CAPCITY_OBJECT_LIST_TYPE("822"),
    /** 资产关系 */
    ENTITYITEM_RELATION_CODE("832"),
    /** 监控管理新增2012/09/29 */
    /** 告警优先级 */
    ALARM_PRIORITY("850"),
    /** 告警是否修复 */
    ALARM_FIXED("851"),
    /** 摩卡告警优先级 */
    MOCHAALARM_PRIORITY("852"),
    /** 考勤时间 */
    CHECK_TIME("292"),
    /** 数据库连接类型 */
    CONNECT_TYPE("295"),
	/** 执行SQL来源 */
    CONNECT_DB_FROM("296"),
    /** 系统监控用户登录时间标识 */
    LOGIN_TIME_FLAG("297"),
	/** 事由类别 */
	LEAVE_TYPE("294"),
	/** 分派页面类型 */
    ASSIGN_PAGE_TYPE("291"),
    /** 报表模版 */
    RFDFILEMODEL("333"),
    
    /**密码类型*/
	PWD_TYPE("162"),
	/**日志预警类型*/
	LOG_WARN_TYPE("163"),
	/**修改状态*/
	LOG_UPSTATUS("323"),
	/**日志成功状态*/
	LOG_STATUS("322"),
    
    /************项目开始********************/
	/** 项目是否使用预算*/
	Project_ISUSEBUDGET("310"),
	/** 项目性质 */
	BUDGET_QUALITY_CODE("311"),
	/** 需求部门 */
	BUDGET_NEED_DISPART_CODE("312"),
	/** 预算组成 */
	BUDGET_BUGGET_FORM_CODE("313"),
	/** 预算用途 */
	BUDGET_USE_CODE("314"),
	/** 项目日志类别 */
	Project_LOGTYPE("315"),
	/** 项目预算用途 */
	Project_CATEGORY("316"),
	/** 项目需求部门 */
	Project_NEEDBRANCH("317"),
	/** 项目性质 */
	Project_QUALITY("318"),
	
	/** SOC作息时间设定假期类型 */
	DATETYPE("900"),
	/** 主机配置分析下拉 */
	HOST_CMDB("841"),
	/** 交换机配置分析下拉 */
	SWITCH_CMDB("842"),
	/** 存储配置分析下拉 */
	STORAGE_CMDB("843"),
	/** 季度 */
	QUARTER_CODE("320"),
	/** 关系*/
	BELONG_RELATION_TYPE("011"),
	
	/** CMDB性能监控对象类型 */
	PERF_MONITOR_TYPE("340"),
	
	/** CMDB性能监控指标 */
	PERF_MONITOR_CATEGORY("341"),
	
	/** 表单包含附件标识 */
	HASATTACH("350"),
	
    /** 设备日志告警优先级 */
    SYSLOGALARM_PRIORITY("951"),
	
	/** 表格式表单显示模式标识 */
	TABLEFORM_DISPLAY("351"),	
	/** 表格式表单使用模式标识 */
	TABLEFORM_USE("352"),
	/** 表格式表单子表单内容 */
	TABLEFORM_PROCESSINFODEF_TYPE_CODE_WD("353"),	
	/** 表格式表单是否隐藏列名 */
	TABLEFORM_HIDE_COLUMN_NAME("354"),
	/** 流程状态超时策略处理BL */
	PROCESSTACTICSBL_STATUS("700"),
	/** 流程整体超时策略处理BL */
	PROCESSTACTICSBL_ALL("701"),
	/** 流程表单转图片显示 */
	PROCESSINFOTOIMG("702"),
	
	TOPO_DEVICE_TYPE("171"),
	/**对比类型*/
	COMPARE_TYPE("360"),
	
	NMS_EXECUTABLE_FILE_PATH("172"),
	/**所有资产用户esyscoding 基础数据CCID*/
	USERS_CCID("166"),
	NET_CCID("173"),
    EIRRELATION("165"),
    RELATIONCODE("167"),
    /**自定义流程模版*/
	PRPDID("335"),
	SYSLOG_DEVICETYPE("301"),
	VMBILLINGCI_CCID("960"),
	
	/** 风险事件状态 */
	RISK_STATUS("994"),
	
	/** 风险事件评审结果 */
	RISK_REVIEW_RESULT("995"),
	
	/** 风险应对策略 */
	RISK_POLICY("996"),
	
	/** 风险事件来源 */
	RISK_CASE_ORIGIN("997"),
	
	/** 风险事件所属领域 */
	RISK_CASE_CATEGORY("998"),
	/** 专项预案场景关联关系 */
	PLAN_CONDITIONS_RELATION("050"),
	
	/** 动态分支条件 */
	PROCESS_DYNAMICBRANCH_COND("224")
	;
	
	
	/** */
	protected String ccid;

	/**
	 * 
	 *
	 * @param ccid
	 */
	private CodeDefine(String ccid) {
		this.ccid = ccid;
	}

	/**
	 * 
	 *
	 * @param id
	 */
	public static CodeDefine getCodeDefine(String id) {
		for (CodeDefine c : CodeDefine.values()) {
			if (c.name().equalsIgnoreCase(id)) {
				return c;
			}
		}
		return null;
	}

	public String getCcid() {
		return ccid;
	}
}