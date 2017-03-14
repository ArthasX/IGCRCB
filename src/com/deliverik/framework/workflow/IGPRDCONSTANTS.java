/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.framework.workflow;

/**
 * 流程定义和驱动常量类
 *
 */
public final class IGPRDCONSTANTS {
	
	/*--------------- 配置类型 --------------*/
	/** 负责人角色 */
	public static final String OA_ROLE_A = "A";
	/** 值班人角色 */
	public static final String OA_ROLE_B = "B";
	/** 执行人角色 */
	public static final String OA_ROLE_C = "C";
	//-----------流程信息类型定义-----------
	
	/** 流程信息来自于IG */
	public static final String IG_PROCESSRECORD = "IG";
	
	/** 流程日志有权限 */
	public static final String RECORDLOG_PERMISSION_YES = "1";
	
	/** 流程日志无权限 */
	public static final String RECORDLOG_PERMISSION_NO = "0";
	
	
	//-----------常量定义-----------
	
	/** 有权限 */
	public static final String HAVE_PERMISSION = "checked";
	
	/** 选定 */
	public static final String SELECTED = "1";
	
	/** 未选定 */
	public static final String CANCEL = "0";
	
	/** 变量缺省 */
	public static final String PUBLIC_ACCESS_DEFAULT = "0";
	
	/** 变量不可见 */
	public static final String PUBLIC_ACCESS_HIDE = "1";
	
	/** 变量只读 */
	public static final String PUBLIC_ACCESS_READABLE = "2";
	
	/** 变量可写 */
	public static final String PUBLIC_ACCESS_WRITEABLE = "3";
	
	/** 私有变量全部可见 */
	public static final String PRIVATE_ACCESS_READABLE_ALL = "4";
	
	/** 表单模式：公有 */
	public static final String PIDMODE_PUBLIC = "0";
	
	/** 表单模式：私有 */
	public static final String PIDMODE_PRIVATE = "1";
	
	/** 表单模式：状态 */
    public static final String PIDMODE_STATUS = "2";
	
	/** 表单显示模式：整行 */
	public static final String PIDROWWIDTH_FULL = "0";
	
	/** 表单显示模式：半行 */
	public static final String PIDROWWIDTH_HALF = "1";
	
	/** 流程主题显示模式：可见 */
	public static final String PROCESSTITLE_DEFAULT = "0";
	
	/** 流程主题显示模式：不可见 */
	public static final String PROCESSTITLE_HIDE = "1";
	
	/** 私有变量权限范围：角色 */
	public static final String PRIVATESCOPE_ROLE = "0";
	
	/** 私有变量权限范围：用户 */
	public static final String PRIVATESCOPE_USER = "1";

	/** 私有变量权限范围：机构 */
	public static final String PRIVATESCOPE_ORG = "2";
	
	/** 可被分派参与者类型：角色 */
	public static final String PSDASSIGN_ROLE = "1";
	
	/** 可被分派参与者类型：用户 */
	public static final String PSDASSIGN_USER = "0";

	//====>130225Begin
	/** 可被分派参与者类型：机构 */
	public static final String PSDASSIGN_ORG = "2";
	//====>130225End	
	
	/** 可被分派参与者机构过滤：是 */
	public static final String PSDORG_YES = "0";
	
	/** 可被分派参与者机构过滤：否 */
	public static final String PSDORG_NO = "1";
	
	/** 流程图action线id属性的默认起始字母 */
	public static final String IMG_ACTION_ID_BEGIN_WITH = "a";
	
	/** 表单是否必填：否 */
	public static final String PID_REQUIRED_NO = "0";
	/** 表单是否必填：是 */
	public static final String PID_REQUIRED_YES = "1";
	
	/** 可被分派：否 */
	public static final String ASSIGN_NO = "0";
	//-----------按钮-----------
	
	
	public static final String BUTTON_UPDATE = "01";//更新
	
	public static final String BUTTON_CONFIRM = "02";//确认
	
	public static final String BUTTON_TERMINATE = "03";//中止
	
	public static final String BUTTON_EXECUTOR = "04";//调整处理人
	
    public static final String BUTTON_PROCESS = "05";//相关发起
    
    public static final String BUTTON_KNGSEARCH = "06";//知识查询
    
    public static final String BUTTON_COPYREADING = "07";//知识查询
    
    public static final String BUTTON_NSBUTTON1 = "08";//非跃迁按钮1
    
	public static final String BUUTON_NSBUTTON2 = "09";//非跃迁按钮2
    
	public static final String BUTTON_SUBMIT = "10";//提交
	
	public static final String BUTTON_APPROVE = "11";//审核
	
	public static final String BUTTON_DENY = "12";//驳回
	
	public static final String BUTTON_BUTTON1 = "13";//扩充按钮1
	
	public static final String BUTTON_BUTTON2 = "14";//扩充按钮2
	
	public static final String BUTTON_BUTTON3 = "15";//扩充按钮3
	
	public static final String BUTTON_BUTTON4 = "16";//扩充按钮4
	
	public static final String BUTTON_BUTTON5 = "17";//扩充按钮5
	
	public static final String BUTTON_PBDFLAG_1 = "1";//不可跃迁按钮
	
	public static final String BUTTON_PBDFLAG_0 = "0";//可跃迁按钮
	
	//-----------逻辑符号-----------
	public static final String LOGICSIGN1  = "1";//等号
	public static final String LOGICSIGN2  = "2";//不等号
	public static final String LOGICSIGN3  = "3";//大于号
	public static final String LOGICSIGN4  = "4";//小于号
	public static final String LOGICSIGN5  = "5";//大于等于号
	public static final String LOGICSIGN6  = "6";//小于等于号
	
	//-----------Ig259-----------
	/** 流程定义事件模板ID */
	public static final Integer PROCESS_DEFINITION_TEMPLATE_I = 1;
	
	/** 流程定义问题模板ID */
	public static final Integer PROCESS_DEFINITION_TEMPLATE_P = 2;
	
	/** 流程定义变更模板ID */
	public static final Integer PROCESS_DEFINITION_TEMPLATE_C = 3;
	
	/** 流程定义发布模板ID */
	public static final Integer PROCESS_DEFINITION_TEMPLATE_D = 4;
	
	/** 流程定义服务请求模板ID */
	public static final Integer PROCESS_DEFINITION_TEMPLATE_S = 5;
	
	/** 流程定义指派模板ID */
	public static final Integer PROCESS_DEFINITION_TEMPLATE_WA = 7;
	
	/** 流程定义个人模板ID */
	public static final Integer PROCESS_DEFINITION_TEMPLATE_WB = 6;
	
	/** 流程定义通用模板ID */
	public static final Integer PROCESS_DEFINITION_COMMON_TEMPLATE_ID = 8;
	
	/** 自定义事件模板ID */
	public static final Integer PROCESS_DEFINITION_ID = 9;
	
	/** 自定义问题模板ID */
	public static final Integer PROCESS_DEFINITION_PD = 10;
	
	/** 自定义应急管理模板ID */
	public static final Integer PROCESS_DEFINITION_DRM = 20;
	
	/** 自定义预案流程管理模板ID */
	public static final Integer PROCESS_DEFINITION_WDP = 22;
	
	/** 自定义指挥流程管理模板ID */
	public static final Integer PROCESS_DEFINITION_WDC = 21;
	
	
	/** 自定义变更模板ID */
	public static final Integer PROCESS_DEFINITION_CD = 11;
	
	/** 自定义发布模板ID */
	public static final Integer PROCESS_DEFINITION_DD = 12;
	
	/** 自定义服务请求模板ID */
	public static final Integer PROCESS_DEFINITION_SD = 13;
	
	/** 流程定义通用模板标识 */
	public static final String PROCESS_DEFINITION_TYPE_WD = "WD";
	
	/** 自定义通用模板状态标识（生成通用自定义流程时PDID的第一位） */
	public static final String PRTYPE_DEFINITION_TYPE_WD_STATUS_ID = "0";
	
	/** 自定义事件模板标识 */
	public static final String PROCESS_DEFINITION_TYPE_ID = "ID"; 
	
	/** 自定义问题模板标识 */
	public static final String PROCESS_DEFINITION_TYPE_PD = "PD";
	
	/** 自定义变更模板标识 */
	public static final String PROCESS_DEFINITION_TYPE_CD = "CD";
	
	/** 自定义发布模板标识 */
	public static final String PROCESS_DEFINITION_TYPE_DD = "DD";
	
	/** 自定义服务请求模板标识 */
	public static final String PROCESS_DEFINITION_TYPE_SD = "SD";

	/**自定义应急管理模版表示*/
	public static final String PROCESS_DEFINITION_TYPE_DRM = "DRM";
	
	/**自定义预案流程管理模版表示*/
	public static final String PROCESS_DEFINITION_TYPE_WDP = "WDP";
	
	/**自定义指挥流程管理模版表示*/
	public static final String PROCESS_DEFINITION_TYPE_WDC = "WDC";

	/** 自定义年报模板标识 */
	public static final String PRTYPE_YEAR = "WD1";
	
	/** 自定义年报模板ID */
	public static final Integer PRTYPE_YEAR_ID = 14;
	
	/** 自定义年报模板状态标识（生成年报流程时PDID的第一位） */
	public static final String PRTYPE_YEAR_STATUS_ID = "1";
	
	/** 自定义季报模板标识 */
	public static final String PRTYPE_SEASON = "WD2";
	
	/** 自定义季报模板ID */
	public static final Integer PRTYPE_SEASON_ID = 15;

	/** 自定义季报模板状态标识（生成季报流程时PDID的第一位） */
	public static final String PRTYPE_SEASON_STATUS_ID = "2";
	
	/** 自定义不定期模板标识 */
	public static final String PRTYPE_IRREGULAR = "WD3";
	
	/** 自定义不定期模板ID */
	public static final Integer PRTYPE_IRREGULAR_ID = 16;
	
	/** 自定义不定期模板状态标识（生成不定期流程时PDID的第一位） */
	public static final String PRTYPE_IRREGULAR_STATUS_ID = "3";
	
	/** 自定义月报模板状态标识（生成月报流程时PDID的第一位） */
	public static final String PRTYPE_MONTH_STATUS_ID = "4";
	
	/** 自定义月报模板标识 */
	public static final String PRTYPE_MONTH = "WD4";
	
	/** 自定义月报模板ID */
	public static final Integer PRTYPE_MONTH_ID = 13;
	
	/** 事件模板标识 */
	public static final String PROCESS_TYPE_I = "I"; 

	/** 问题标识 */
	public static final String PROCESS_TYPE_P = "P"; 
	
	/** 变更模板标识 */
	public static final String PROCESS_TYPE_C = "C"; 
	
	/** 发布模板标识 */
	public static final String PROCESS_TYPE_D = "D"; 
	
	/** 服务请求模板标识 */
	public static final String PROCESS_TYPE_S = "S"; 
	
	/** 应急指挥流程模板标识 */
	public static final String PROCESS_TYPE_WDC = "WDC";
	/** 应急指挥流程模板标识ID */
	public static final Integer PROCESS_TYPE_WDC_ID = 18;
	
	/** 预案流程模板标识 */
	public static final String PROCESS_TYPE_WDP = "WDP";
	/** 预案流程模板标识ID */
	public static final Integer PROCESS_TYPE_WDP_ID = 19;
	
	/** 存在未关闭的流程在使用模板 */
	public static final String PROCESSDEFINITION_IS_IN_USE = "1";
	
	/** 不存在未关闭的流程在使用模板 */
	public static final String PROCESSDEFINITION_IS_NOT_IN_USE = "0";
	
	//-----------ProcessDefinition-----------
	
	/** 流程定义状态 启用*/
	public static final String PD_STATUS_ENABLE = "a";
	
	/** 流程定义状态 停用*/
	public static final String PD_STATUS_DISABLE = "i";
	
	/** 流程定义状态 测试*/
	public static final String PD_STATUS_TESTABLE = "t";
	
	/** 流程组定义状态 启用*/
	public static final String PGD_STATUS_ENABLE = "2";
	
	/** 流程组定义状态 停用*/
	public static final String PGD_STATUS_DISABLE = "0";
	
	/** 流程组定义状态 测试*/
	public static final String PGD_STATUS_TESTABLE = "1";
	
	/** 流程定义测试数据标示*/
	public static final String PD_TEST_ID = "1";
	
	//-----------IG333-----------
	
	/** 流程默认开始状态*/
	public static final String PROCESS_START_STATUS = "Z";
	
	/** 流程默认开始状态说明*/
	public static final String PROCESS_START_STATUS_DESC = "流程默认开始状态";
	
	/** 流程默认开始状态显示名称*/
	public static final String PROCESS_START_STATUS_LABEL = "待发起";
	
	/** 流程默认结束状态*/
	public static final String PROCESS_END_STATUS = "C";

	/** 子流程默认结束状态*/
	public static final String PROCESS_END_SUBSTATUS = "B";
	
	/** 流程终止状态 */
	public static final String PROCESS_TERMINATE = "#";
	
	/** 流程默认结束状态说明*/
	public static final String PROCESS_END_STATUS_DESC = "流程默认结束状态";
	
	/** 流程默认结束状态显示名称*/
	public static final String PROCESS_END_STATUS_LABEL = "关闭";
	
	/** 流程节点类型-普通节点*/
	public static final String PROCESS_NODE_TYPE_NORMAL = "0";
	
	/** 流程节点类型-可分派节点*/
	public static final String PROCESS_NODE_TYPE_ASSIGN = "1";
	
	/** 流程节点类型-并行节点*/
	public static final String PROCESS_NODE_TYPE_CONCURRENCY = "2";

	/** 流程节点类型-静态分支节点*/
	public static final String PROCESS_NODE_TYPE_STATICBRANCH = "3";

	/** 流程节点类型-动态分支节点*/
	public static final String PROCESS_NODE_TYPE_DYNAMICBRANCH = "4";

	/** 流程节点类型-合并节点*/
	public static final String PROCESS_NODE_TYPE_MERGE = "5";

	/** 流程节点类型-子流程节点*/
	public static final String PROCESS_NODE_TYPE_CHILDPROCESS = "6";
	
	/** 流程节点类型-子流程节点 0 代表无子流程 郑健楠 2014.7.15*/
	public static final String PROCESS_SUB_TYPE0_CHILDPROCESS = "0";
	/** 流程节点类型-子流程节点 1 代表有子流程 郑健楠 2014.7.15*/
	public static final String PROCESS_SUB_TYPE1_CHILDPROCESS = "1";
	
	/** 动态分支条件-角色 */
	public static final String PROCESS_BRANCHCOND_ROLE = "0";
	
	/** 动态分支条件-人员 */
	public static final String PROCESS_BRANCHCOND_USER = "1";
	
	//-----------Ig273-----------
	/** 原规则与变更分隔符*/
	public static final String PROCESSPVARIABLE_COND_SPLIT = "|";
	
	/** 参与者与规则分隔符*/
	public static final String PROCESSPARTICIPANT_COND_SPLIT = "!";
	
	/** 规则分隔符 */
	public static final String COND_COND_SPLIT = "#";
	
	/** 规则类型-与 */
	public static final String COND_TYPE_AND = "0";
	
	/** 规则类型-或 */
	public static final String COND_TYPE_OR = "1";
	
	/** 规则类型-ANY */
	public static final String COND_TYPE_ANY = "2";
	
	/** 规则类型-缺省 */
	public static final String COND_TYPE_DEFAULT = "3";
	
	/** 规则类型-缺省角色标识 */
	public static final String COND_TYPE_DEFAULT_ROLE = "AAA";
	
	
	
	//-----------ig222-----------
	public static final String PPD_ADD_ROLETYPE_MESSAGE = "添加角色类型";
	
	public static final String PPD_ADD_PROCESSPARTICIPANT_MESSAGE = "添加参与者";
	
	public static final String PPD_REMOVE_PROCESSPARTICIPANT_MESSAGE = "删除参与者";
	
	
	//-----------Comment Message-----------
	
	public static final String PROCESS_INITIAL_MESSAGE = "发起流程";
	public static final String COMMENT_OPENER_MESSAGE = "发起人";
	public static final String COMMENT_TERMINATE_MESSAGE = "中止流程";
	public static final String COMMENT_ASSIGNPERSON_MESSAGE = "设定执行人";
	public static final String COMMENT_DELETEPERSON_MESSAGE = "删除执行人";
	public static final String COMMENT_TRANSITION_MESSAGE = "流程状态转至";

	
	/**
	 * 规则逻辑符号定义转换成描述：
	 * 
	 * @param cond String
	 */
	public static String convertLogicSineInfo(int cond) {
		int index=cond;
		String sign = null;
		switch (index) {
		case 1:
			sign = "等于";
			break;
		case 2:
			sign = "不等于";
			break;
		case 3:
			sign = "大于";
			break;
		case 4:
			sign = "小于";
			break;
		case 5:
			sign = "大于等于";
			break;
		case 6:
			sign = "小于等于";
			break;
		default:
			sign = null;
			break;
		}
		return sign;
	}
	
	
	//-----------日志类型-----------
	
	/**
	 * 日志类型:系统日志
	 */
	public static final String RECORDLOG_TYPE_XTRZ = "0";
	
	/**
	 * 日志类型:审核记录
	 */
	public static final String RECORDLOG_TYPE_SH = "1";
	
	/**
	 * 日志类型:处理记录
	 */
	public static final String RECORDLOG_TYPE_CL = "2";
	
	/**
	 * 日志类型:提交记录
	 */
	public static final String RECORDLOG_TYPE_TJ = "3";
	
	/**
	 * 日志类型:中止记录
	 */
	public static final String RECORDLOG_TYPE_ZZ = "4";
	
	/**
	 * 日志类型:更新记录
	 */
	public static final String RECORDLOG_TYPE_GX = "5";
	
	/**
	 * 树形流程变量类型
	 */
	public static final String PROCESSVAR_TREE_TYPE = "T";
	
	//=====================流程日志分类====================================
	/**
	 * 处理类日志
	 */
	public static final String RECORDLOG_TYPE_CL_NAME = "处理类日志";
	
	/**
	 * 更新类日志
	 */
	public static final String RECORDLOG_TYPE_GX_NAME = "更新类日志";
	
	/**
	 * 审核类日志
	 */
	public static final String RECORDLOG_TYPE_SH_NAME = "审核类日志";
	
	/**
	 * 提交类日志
	 */
	public static final String RECORDLOG_TYPE_TJ_NAME = "提交类日志";
	
	/**
	 * 系统类日志
	 */
	public static final String RECORDLOG_TYPE_XTRZ_NAME = "系统类日志";
	
	/**
	 * 中止类日志
	 */
	public static final String RECORDLOG_TYPE_ZZ_NAME = "中止类日志";
	
	//=====================角色类型常量值====================================
	/** 服务台 */
	public static final String ROLETYPE_SERVICE_DESK = "IGBP17";
	/** 工程师 */
	public static final String ROLETYPE_ENGINEER = "IGBP15";
	
	//============================================================
	/** 自定义工作 */
	public static final String SELF_DEFINING_WORK_PRTYPE = "WD";
	
	/** 数据变更描述 */
	public static final String RLDESC_DATA = "用户填写数据变更";
	
	/** 流程管理员修改数据描述 */
	public static final String RLADMIN_DATA = "流程管理员修改数据";
	
	/** 历史记录最大字节数 */
	public static final int RLDESC_MAX_BYTE = 512;
	
	/** 前处理 */
	public static final String RLDESC_SYS = "前处理数据变更";
	
	//=====================流程事件定义类型====================================
	
	/** 前处理 */
	public static final String PRETREATMENT = "1";
	
	/** 后处理 */
	public static final String AFTERTREATMENT = "2";
	
	/** 多线程 */
	public static final String THREADTREATMENT = "3";
	
	//=====================流程JSP定义类型====================================
	
	/** 发起 */
	public static final String CREATEJSP = "1";
	
	/** 处理 */
	public static final String DEALJSP = "2";
	
	/** 查看 */
	public static final String DETAILJSP = "3";
	
	/** 相关流程Include页*/
	public static final String RELEVANTPROCESSJSP = "4";
	
	/** 查询页*/
	public static final String SEARCHJSP = "5";
	
	//=====================流程状态super角色标识====================================
	
	/** 非可分派角色 */
	public static final String UN_SUPER_ROLE = "0";
	
	/** 可分派角色 */
	public static final String SUPER_ROLE = "1";
	
	//=====================流程节点模式====================================
	
	/** 普通模式 */
	public static final String MODE_NORMAL = "1";
	
	/** OA模式 */
	public static final String MODE_OA = "2";
	
	//=====================流程并行节点规则标识====================================
	
	/** ANY */
	public static final String TRANSITION_RULE_ANY = "ANY";
	
	//=====================是否进入分派参与者标识====================================
	
	/** 不需要 */
	public static final String NOT_NEED_ASSIGN = "0";
	
	/** 需要 */
	public static final String NEED_ASSIGN = "1";
	
	//=====================是否值班人标识====================================
	
	/** 非值班人 */
	public static final String NOT_DUTYPERSON = "0";
	
	/** 值班人 */
	public static final String DUTYPERSON = "1";
	
	//=====================是否角色负责人标识====================================
	
	/** 非角色负责人 */
	public static final String NOT_ROLEMANAGER = "0";
	
	/** 角色负责人 */
	public static final String ROLEMANAGER = "1";
	
	/** 临时角色负责人，只可以提交，不能干别的 */
	public static final String TEMP_ROLEMANAGER = "2";
	
	//=====================值班人被授权提交子状态标识,PPSUBSTATUS====================================
	
	/** 无权提交 */
	public static final String DUTYPERSON_NOACCESS = "0";
	
	/** 有权提交 */
	public static final String DUTYPERSON_ACCESS = "1";
	
	//=====================流程自定义表单模式====================================
	
	/** 流程表单模式：共有 */
	public static final String PROCESSINFODEF_MODE_PUBLIC = "0";
	
	/** 流程表单模式：私有 */
	public static final String PROCESSINFODEF_MODE_PRIVATE = "1";
	
	
	//=====================自定义流程相关定义表主键====================================
	
	/** ID前缀长度 */
	public static final int ID_PREFIX_LENGTH = 5;
	
	/** ID版本长度 */
	public static final int ID_VERSION_LENGTH = 2;
	
	/** ID后缀程度 */
	public static final int ID_SUFFIX_LENGTH = 3;
	
	//=====================角色提交权限====================================
	
	/** 同角色所有人提交跃迁 */
	public static final String UserCommitInRole_ALL = "1";
	
	/** 同角色有一人提交跃迁 */
	public static final String UserCommitInRole_ANY = "0";
	
	//=====================有确认操作====================================
	
	/** 无 */
	public static final String SUBSTATUS_CONFIRM_NO = "0";
	
	/** 有 */
	public static final String SUBSTATUS_CONFIRM_YES = "1";
	
	//=====================确认子状态操作====================================
	
	/** 已确认 */
	public static final String PARTICIPANT_SUBSTATUS_CONFIRM = "1";
	
	//=====================流程策略通知人类型====================================
	
	/** 角色负责人 */
	public static final String STRATEGY_NOTIFIER_TYPE_ROLEMANAGER = "0";
	
	/** 指定人 */
	public static final String STRATEGY_NOTIFIER_TYPE_USER = "1";
	
	//=====================流程策略通知方式====================================
	
	/** 短信 */
	public static final String STRATEGY_NOTICE_MODE_SMS = "1";
	
	/** 邮件 */
	public static final String STRATEGY_NOTICE_MODE_EMAIL = "1";
	
	//=====================流程策略通知状态0:状态超时通知 1:状态超时2:报告上级3:流程整体超时====================================
	/** 状态超时通知 */
	public static final String PROCESS_STATUS_SEND = "0";
	/** 状态超时 */
	public static final String PROCESS_STATUS_OVERTIME = "1";
	/** 报告上级 */
	public static final String PROCESS_STATUS_SEND_MANAGER = "2";
	/** 流程整体超时 */
	public static final String PROCESS_OVERTIME = "3";
	/** 流程状态超时记录标识 */ 
	public static final String PROCESS_STATUS_FLAG = "4";
	
	//=====================流程登记自动生成菜单====================================
	/** 流程管理菜单名称 */
    public static final String ACTION_LABEL_MANAGE = "管理";
    
    /** 流程发起菜单名称 */
    public static final String ACTION_LABEL_INIT = "发起";
    
    /** 流程查询菜单名称 */
    public static final String ACTION_LABEL_SEARCH = "查询";
    
    /** 流程发起菜单序号 */
    public static final String ACTION_LABEL_INIT_NUM = "02";
    
    /** 流程查询菜单序号 */
    public static final String ACTION_LABEL_SEARCH_NUM = "01";
    
    /** 自动生成的二级菜单类型 */
    public static final String ACTION_TYPE_2 = "M2";
    
    /** 自动生成的三级菜单类型 */
    public static final String ACTION_TYPE_3 = "M3";
    
    /** 自动生成菜单的角色授权 */
    public static final String ACTION_ROLE_TYPE = "IGBP01";
    
    /** 自动生成菜单的URL类型 */
    public static final String ACTION_URL_TYPE = "0";
    
    /** 自定义流程自动生成菜单的停用标识 */
    public static final int ACTION_STATUS_STOP = 1;
    
    /** 自定义流程按钮校验表单必填标识 */
    public static final String BUTTON_CHECKREQUIRED_YES = "1";
    
    /** 自定义流程按钮校验处理记录非必填标识 */
    public static final String BUTTON_CHECKRECORD_NO = "0";
    
    /** 自定义流程按钮校验处理记录必填标识 */
    public static final String BUTTON_CHECKRECORD_YES = "1";
    
	/** 查询所有工单信息 */
	public static final String SEARCH_ALL_PROCESS ="1";
	
	/** 查询我自己的工单*/
	public static final String SEARCH_MY_PROCESS ="2";
	
	/** 查询和登录者同机构的工单*/
	public static final String SEARCH_ORG_PROCESS ="3";
	
	/** 查询和登录者同角色的工单*/
	public static final String SEARCH_ROLE_PROCESS ="4";
	
	/** 查询我自己处理过的工单*/
	public static final String SEARCH_MY_PROCESSED ="5";
	
	/** 查询我自己未处理过的工单*/
	public static final String SEARCH_MY_UN_PROCESSED ="6";

	/** IG335主流程标识 */
	public static final String MAIN_PROCESS_FLAG = "0100000000";

	/**表单无关联通知策略时pidid后3位默认值*/
	public static final String PROCESS_UNRELFORM_IDEND = "000";
	/**表单无关联通知策略时pivalue默认值*/
	public static final String PROCESS_UNRELFORM_VALUE = "N/A";

	/**目前的设置先以以完成的方法为主*/
	/**通知策略-状态默认处理方法*/
	public static final String PROCESS_TACTICS_STATUS = "igReportTacticsBL";
	/**通知策略-整体默认处理方法*/
	public static final String PROCESS_TACTICS_WHOLE = "igWholeTacticsBL";
	/**业务连续性管理员roleid*/
	public static final Integer PLAN_ADMINISTRATOR_ROLEID = 2074;
	/**业务连续性管理员roleid所在角色类型-应急执行层*/
	public static final String PLAN_ADMINISTRATOR_ROLETYPE = "IGBP04";
	
	/**流程设计器 动作类型 _新增*/
	public static final String PD_ACTTYPE_INSERT = "insert";
	/**流程设计器 动作类型 _删除*/
	public static final String PD_ACTTYPE_DELETE = "delete";
	/**流程设计器 动作类型 _修改*/
	public static final String PD_ACTTYPE_MODIFY = "modify";
}
