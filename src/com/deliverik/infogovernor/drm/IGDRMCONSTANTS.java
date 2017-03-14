/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.drm;

import java.util.LinkedList;

/**
 * drm常量类1
 *
 */
public final class IGDRMCONSTANTS {
	
	/**日常管理组织架构和应急组织架构对应CCID*/
	public final static LinkedList<String> ORGSTRU_CCID = new LinkedList<String>();
	static {
		ORGSTRU_CCID.add("240");// 日常管理组织架构CCID
		ORGSTRU_CCID.add("230");// 应急组织架构CCID
	}
	
    /**应急角色类型*/
    public static final String DRMROLETYPE="IGBP50";

    /**应急演练流程中 <演练内容>表单名称*/
    public static final String DRILL_FORM_DRCONTENT = "演练内容";
    
    /**应急指挥流程中 <事件名称>表单名称*/
    public static final String EC_FORM_ECNAME = "事件名称";
    /**应急指挥流程中 <事件描述>表单名称*/
    public static final String EC_FORM_ECDESC = "事件描述";
    
   
    
	/** 专项预案和场景 */
	public final static String ENTIY_CATEGORY_DOCUMENT = "050";
	
    /**应急指挥流程中场景资产表单名称*/
    public static final String SCENE_ITEM_NAME = "应急场景";
    
    /**应急指挥流程中员资产表单名称*/
    public  static final String PLAN_NAME = "专项预案";
    
    /**应急指挥流程中 业务系统表单名称 */
	public static final String ITEM_SYSTEM_FORM_NAME = "业务系统";
	
    
    /**应急场景中关联流程定义id属性名称*/
    public static final String PROCESS_DEF_ID = "场景应急处置步骤";
    
    /**应急指挥流程中 -应急演练流程prid 表单名*/
    public static final String PRACTISE_PRID_LABEL = "应急演练prid";
    
    
    /**应急演练流程中演练场景表单名称*/
    public static final String EMERGENCY_SCENE_NAME = "演练场景";
     
    /**应急演练流程中专项预案表单名称*/
    public static final String SPECIAL_PLAN_NAME = "专项预案";
    
    /**应急演练流程中 业务系统表单名称 */
	public static final String DRILL_SYSTEM_FORM_NAME = "业务系统";
	
    /**场景资产属性定义场景流程ID*/
    public static final String DEFINE_SCENE_PDID = "场景应急处置步骤";
    
    /** 业务连续性角色类型 */
    public final static String SP_ROLE_TYPE = "IGBP50";
    
    /** 应急指挥PDID */
	public final static String EMER_PROCESS_PDID = "0138601";
    
    
    
    /** 计划任务ID表单名称*/
    public final static String PLAN_JOB_NAME = "计划任务id";
    /** 演练计划名称表单*/
    public final static String PLAN_JOB_FORM_NAME = "演练计划名称";
    /**演练流程定义ID*/
    public final static String DRILL_PROCESS_DEF_ID = "01385";
    
    /**应急指挥流程定义ID*/
    public final static String DIRECT_PROCESS_DEF_ID = "01386";
    
    /**演练流程中指挥流程的prid 表单名*/
    public final static String DRILL_FROM_NAME_DIRECT_PRID = "指挥流程prid";
    /**演练流程中场景prid 表单名*/
    public final static String DRILL_FROM_NAME_SCENE_PRID = "场景相关流程prid";
   
    /**演练流程中 参与人调整表单名称 */
    public static final String DRILL_PARTICIPANT_ADJUST_FORM_NAME = "场景参与人";
	
    /**指挥流程中场景流程的prid 表单名*/
    public final static String DIRECT_FROM_NAME_SCENE_PRID = "场景prid";
    
    /**指挥流程   参与人调整表单名称 */
    public static final String DIRECT_PARTICIPANT_ADJUST_FORM_NAME = "场景参与人";
    
    /**演练流程表单“演练指挥是否完成”*/
    public final static String DRILL_PROCESS_FORM_NAME_DIRECTSTATUS = "演练指挥是否完成";
    
    /**场景资产属性“是否已演练”*/
    public final static String DRILL_FINISED_FORM_NAME = "是否已演练";
    
    /**场景资产属性“是否已演练”CID*/
    public final static String DRILL_FINISED_FORM_NAME_CID = "CI600000001006";
    
	/**重新推送系统当前时间*/
	public final static String DB_TYPE_REPUSH_SYSMTIME = "6";
	/**重新推送已用时*/
	public final static String DB_TYPE_REPUSH_USEDTIME = "7";
	/**推送通知日志信息类型*/
	public final static String DB_TYPE_NOTICE = "1";
	/**流程信息类型*/
	public final static String DB_TYPE_PROCESS = "2";
	/**人员就位类型*/
	public final static String DB_TYPE_INPLACE = "3";
	/**应急流程事件信息类型*/
	public final static String DB_TYPE_EMCINFO = "4";
	/**应急流程相关预案信息类型*/
	public final static String DB_TYPE_RELPLAN = "5";
	/**信息发布*/
	public final static String DB_TYPE_MESSAGE = "6";
	/**获取进度百分比*/
	public final static String DB_TYPE_PERCENT = "7";
	/**流程开始时间*/
	public final static String DB_TYPE_PROCESS_START = "8";
	/**流程已用时*/
	public final static String DB_TYPE_USED_TIME = "9";
	/**流程节点状态*/
	public final static String DB_TYPE_PROCESS_STATUS = "10";
	/**实施跟踪节点按钮*/
	public final static String DB_TYPE_PROCESS_BUTTON = "11";
	
	/**组流程开始时间*/
	public final static String DB_TYPE_GROUP_PROCESS_START = "14";
	/**组流程节点状态*/
	public final static String DB_TYPE_GROUP_PROCESS_STATUS = "15";
	/**组流程已用时*/
	public final static String DB_TYPE_GROUP_USED_TIME = "16";
	/**组流程信息发布*/
	public final static String DB_TYPE_GROUP_MESSAGE = "17";
	/**组流程实时追踪*/
	public final static String DB_TYPE_GROUP_NOTICE = "18";
	/**组流程-实施跟踪节点按钮*/
	public final static String DB_TYPE_GROUP_PROCESS_BUTTON = "19";
	/**流程组--各个流程 实例信息*/
	public final static String DB_TYPE_GROUP_PROCESS_RECORD = "20";
	/**关闭流程和节点信息*/
	public final static String DB_TYPE_GROUP_TERMINATE_MSG = "21";
	/**应急资源*/
	public final static String DB_TYPE_SOC_MSG = "22";
	
	/**应急处理 dashboard 获取实时跟踪日志信息*/
	public final static String EME_SENCE_NOTICE ="S1";
	
	/**指挥流程图DashBoard"待发起"节点名称显示调整*/
	public final static String EMC_PROCESS_START_STATUS_LABEL = "事件上报";
	/**指挥流程默认当前节点bysequence为"01"即"待发起"节点序号*/
	public final static String EMC_PROCESS_START_STATUS_SEQ = "01";
	/**"事件上报时间"对应的表单值*/
	public final static String EMCPRO_OTIME = "事件上报时间";
	/**"事件发生地点"对应的表单值*/
	public final static String EMCPRO_PLACE = "发生地点";
	/**"事件上报人员"对应的表单值*/
	public final static String EMCPRO_REUSER = "事件上报人";
	/**上报人联系电话*/
	public final static String EMCPRO_REUSERPHONE = "联系电话";
	/**"影响范围"对应的表单值*/
	public final static String EMCPRO_REACH = "影响范围";
	/**"事件现象概述"对应的表单值*/
	public final static String EMCPRO_DESC = "事件描述";
	/**"相关预案"资产表单名称*/
	public final static String EMCPRO_RELPLAN = "专项预案";
	/**相应决策层对应的组织机构常量*/
	public final static String ORGSTRU_LAYS = "520";
	/**应急人员就位标识_未就位*/
	public final static Integer EMP_NO_INPLACE = 0;
	/**应急人员就位标识_已就位*/
	public final static Integer EMP_IS_INPLACE = 1;
	/** 流程默认开始状态显示名称*/
	public static final String PROCESS_START_STATUS_LABEL = "待发起";
	/**指挥流程节点-应急处置*/
	public static final String PROCESS_DRICT_DISPOSE = "应急处置";
	/**指挥流程节点-预案调用*/
	public static final String PROCESS_DRICT_PLANTRANSFER = "预案调用";
	/**指挥流程节点-资源协调*/
	public static final String PROCESS_RESOURCE_COORDINATION = "资源协调";
	/**指挥流程节点-应急处置psdid*/
	public static final String PROCESS_DRICT_DISPOSE_PSDID = "0138601007";
	/**指挥流程节点-事件升级*/
	public static final String PROCESS_CASE_UPGRADE = "事件升级";
	/**指挥流程节点-事件升级psdid*/
	public static final String PROCESS_CASE_UPGRADE_PSDID = "0138601009";
	/** 流程默认开始状态*/
	public static final String PROCESS_START_STATUS = "Z";
	/** 流程默认结束状态*/
	public static final String PROCESS_END_STATUS = "C";
	/** 流程节点类型-合并节点*/
	public static final String PROCESS_NODE_TYPE_MERGE = "5";
	/**预案查询类型  --查询所有*/
	public static final String PLAN_SEARCH_TYPE_ALL = "A";
	/**预案查询类型  --查询升版的*/
	public static final String PLAN_SEARCH_TYPE_UPGRADE = "U";
	/**预案查询类型  --查询已演练*/
	public static final String PLAN_SEARCH_TYPE_DIRLL = "D";
	/**场景资产属性_场景类型 */
	public static final String SCENE_ENTITY_ITEM_SCENETYPE = "场景类型";
	/** 场景资产cid-场景流程pdid */
	public static final String SCENE_MODEL_CID = "CI600000001004";
	/** 场景esyscoding */
	public static final String SCENE_ESYSCODING = "999060";
	/** 场景修订流程定义id前五位 */
	public static final String SCENE_DEFINE_FIVE = "01441";
	
	/**演练 发现相关流程表单名称*/
	public static final String DRILL_RELATE_PROCESS_FORM_NAME = "演练流程设定";
	/**演练 发现相关流程 应急指挥流程*/
	public static final String DRILL_RELATE_PROCESS_FORM_DIRECT = "演练指挥流程";
	/**演练 发现相关流程 场景定义*/
	public static final String DRILL_RELATE_PROCESS_FORM_SCENE = "演练处置流程";
	
	/**应急制度层次码*/
	public static final String EMERGENCY_INSTITUTION_ESYSCODING = "999070";
	
	
	/** 关系类型 0：演练-场景 */
	public static final String DRILL_RELATE_SCENE ="0";
	/** 关系类型 1 应急指挥-场景 */
	public static final String DIRECT_RELATE_SCENE ="1";
	/** 关系类型 2 演练-应急指挥 */
	public static final String DRILL_RELATE_DIRECT ="2";
	
	/** 场景定义流程的参与人信息 */
	public static final String DIRECT_ADJUST_PARTIC = "参与人的角色用户信息";
	/** 场景定义流程的 流程节点名称 */
	public static final String DIRECT_PROCESS_PSDNAME = "流程节点名称";
	/** 场景定义流程的 流程节点名称 */
	public static final String DIRECT_PROCESS_PSDID = "流程节点id";
	
	/**应急处置 结束时间*/
	public static final String DB_TYPE_STOP_TIME = "stopTime";
	
	/**应急处置 基本信息*/
	public static final String DB_TYPE_BASE_MSG = "baseMsg";
	
	/**应急处置 流程图*/
	public static final String DB_TYPE_FLOW_MSG = "flowMsg";
	
	/** 专项预案目录类型 - 富文本 */
	public static final String PLAN_DIR_TYPE_TEXT = "0";

	/** 专项预案目录类型 - 场景 */
	public static final String PLAN_DIR_TYPE_SCENE = "1";

	/** 专项预案目录类型 - 组织架构 */
	public static final String PLAN_DIR_TYPE_ORG = "2";

	/** 专项预案目录类型 - 应急资源 */
	public static final String PLAN_DIR_TYPE_RESOURCE = "4";

	/** 应急指挥流程类型 */
	public static final String EME_DIRECT_PRTYPE = "WDC";
	/** 应急恢复流程类型 */
	public static final String EME_RECOVER_PRTYPE = "WDP";
	/** 应急处置类型-演练 */
	public static final String DWP_TYPE_DRILL = "DRILL";
	/** 应急处置类型-应急 */
	public static final String DWP_TYPE_DIRECT = "DTRECT";

	/** 存储设备层次码 */
	public static final String CUNCU_ESYSCODING = "999001005";
	/** 网络设备层次码 */
	public static final String WANGLUO_ESYSCODING = "999001002";

}
