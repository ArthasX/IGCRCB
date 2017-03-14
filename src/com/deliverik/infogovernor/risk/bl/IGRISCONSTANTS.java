/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.risk.bl;

/**
 * 风险审计常量类
 * 
 * @author liupeng@deliverik.com
 */
public final class IGRISCONSTANTS {
	
	//-----------------------------------------------------------审计版本----------------------------------------------------------------------
	
	/** 风险审计状态 启用*/
	public static final String RISKAUDIT_STATUS_ENABLE = "a";
	
	/** 风险审计状态 停用*/
	public static final String RISKAUDIT_STATUS_DISABLE = "i";
	
	
	
	
	
	/** 风险审计根标识位数*/
	public static final int RISKAUDIT_ROOT_LENGTH = 4;
	
	/** 风险审计根标识最小值*/
	public static final String RISKAUDIT_ROOT_MIN_ID = "0001";
	
	/** 风险审计根标识最大值*/
	public static final String RISKAUDIT_ROOT_MAX_ID = "9999";
	
	/** 风险审计根标识填充符*/
	public static final String RISKAUDIT_ROOT_LEFT_PAD = "0";
	
	//-----------------------------------------------------------审计项设定----------------------------------------------------------------------
	
	/** 审计项上级标识最大值*/
	public static final String RISKAUDITDEF_ROOT_MAX_ID = "999";
	
	/** 审计项状态 启用*/
	public static final String RISKAUDITDEF_STATUS_ENABLE = "1";
	
	/** 审计项状态 关闭*/
	public static final String RISKAUDITDEF_STATUS_DISABLE = "0";
	//-----------------------------------------------------------审计发起----------------------------------------------------------------------
	
	/** 风险审计发起状态 启用*/
	public static final String RISKAUDITINS_STATUS_ENABLE = "a";
	
	/** 风险审计发起状态 关闭*/
	public static final String RISKAUDITINS_STATUS_DISABLE = "i";
	
	
	//-----------------------------------------------------------风险检查----------------------------------------------------------------------
	
	/** 风险检查状态 启用*/
	public static final String RISKCHECK_STATUS_ENABLE = "1";
	
	/** 风险检查状态 停用*/
	public static final String RISKCHECK_STATUS_DISABLE = "0";
	
	/** 风险检查错误页*/
	public static final String RISKCHECKRESULT_SUBMIT_ERROR = "yes";
	
	//-----------------------------------------------------------风险检查----------------------------------------------------------------------
	
	/** 风险策略状态 启用*/
	public static final String RISKS_STRATEGY_ENABLE = "1";
	
	/** 风险策略状态 停用*/
	public static final String RISKS_STRATEGY_DISABLE = "2";
	
	//-----------------------------------------------------------审计报告相关基础数据----------------------------------------------------------------------
	
	/** 风险审计项风险程度*/
	public static final String RADRISKLEVEL_CODE = "129";
	
	/** 风险审计项控制频率*/
	public static final String RADFREQUENCY_CODE = "130";
	
	/** 风险审计项控制手段*/
	public static final String RADMODE_CODE = "131";
	
	/** 风险审计项控制类型*/
	public static final String RADTYPE_CODE = "132";
	
	/** 风险审计制度建设评分*/
	public static final String RARPLANSCORE_CODE = "133";
	
	/** 风险审计制度执行评分*/
	public static final String RAREXECSCORE_CODE = "134";
	
	/** 风险审计总体评分*/
	public static final String RAROVERALLSCORE_CODE = "135";
	
	/** 信息安全审批角色id*/
	public static final String INFORMATION_SAFETY_APPROVAL = "1127";

}
