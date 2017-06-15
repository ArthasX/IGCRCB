/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.framework.workflow.prd.model.condition;


/**
 * 流程状态跃迁规则检索条件实现
 *
 */
public class IG273SearchCondImpl implements IG273SearchCond{
	
	/** 
	 * 流程参与者变量权限ID 
	 */
	protected String ptdid;
	
	/**
	 * 流程状态ID（From）
	 */
	protected String fpsdid;
	
	/**
	 * 流程状态ID（To）
	 */
	protected String tpsdid;

	/**
	 * 流程状态跃迁规则名称
	 */
	protected String ptdname;
	
	/**
	 * 流程状态跃迁规则类型
	 */
	protected String ptdtype;
	
	/**
	 * 流程状态跃迁条件
	 */
	protected String ptdcond;
	
	/**
	 * 流程状态跃迁条件（模糊匹配）
	 */
	protected String ptdcond_like;
	
	/**
	 * 流程状态缺省跃迁条件
	 */
	protected boolean defaultRule;
	
	/**
	 * 流程状态非缺省跃迁条件
	 */
	protected boolean notDefaultRule;
	
	/** 
	 * 流程参与者变量权限ID 
	 */
	protected String ptdid_like;

	/**
	 * 流程状态跃迁规则ID取得
	 * @return 流程状态跃迁规则ID
	 */
	public String getPtdid() {
		return ptdid;
	}

	/**
	 * 流程状态跃迁规则ID设定
	 * @param ptdid 流程状态跃迁规则ID
	 */
	public void setPtdid(String ptdid) {
		this.ptdid = ptdid;
	}

	/**
	 * 流程状态ID（From）取得
	 * @return 流程状态ID（From）
	 */
	public String getFpsdid() {
		return fpsdid;
	}

	/**
	 * 流程状态ID（From）设定
	 * @param fpsdid 流程状态ID（From）
	 */
	public void setFpsdid(String fpsdid) {
		this.fpsdid = fpsdid;
	}

	/**
	 * 流程状态ID（To）取得
	 * @return 流程状态ID（To）
	 */
	public String getTpsdid() {
		return tpsdid;
	}

	/**
	 * 流程状态ID（To）设定
	 * @param tpsdid 流程状态ID（To）
	 */
	public void setTpsdid(String tpsdid) {
		this.tpsdid = tpsdid;
	}

	/**
	 * 流程状态跃迁规则名称取得
	 * @return 流程状态跃迁规则名称
	 */
	public String getPtdname() {
		return ptdname;
	}

	/**
	 * 流程状态跃迁规则名称设定
	 * @param ptdname 流程状态跃迁规则名称
	 */
	public void setPtdname(String ptdname) {
		this.ptdname = ptdname;
	}
	
	/**
	 * 流程状态跃迁规则类型取得
	 * @return 流程状态跃迁规则类型
	 */
	public String getPtdtype() {
		return ptdtype;
	}

	/**
	 * 流程状态跃迁规则类型设定
	 * @param ptdtype 流程状态跃迁规则类型
	 */
	public void setPtdtype(String ptdtype) {
		this.ptdtype = ptdtype;
	}

	/**
	 * 流程状态跃迁条件取得
	 * @return 流程状态跃迁条件
	 */
	public String getPtdcond() {
		return ptdcond;
	}

	/**
	 * 流程状态跃迁条件设定
	 * @param ptdcond 流程状态跃迁条件
	 */
	public void setPtdcond(String ptdcond) {
		this.ptdcond = ptdcond;
	}
	
	/**
	 * 流程状态跃迁条件（模糊匹配）取得
	 * @return 流程状态跃迁条件
	 */
	public String getPtdcond_like() {
		return ptdcond_like;
	}

	/**
	 * 流程状态跃迁条件设定
	 * @param ptdcond_like 流程状态跃迁条件
	 */
	public void setPtdcond_like(String ptdcond_like) {
		this.ptdcond_like = ptdcond_like;
	}

	/**
	 * 流程状态缺省跃迁条件取得
	 * @return 流程状态缺省跃迁条件
	 */
	public boolean isDefaultRule() {
		return defaultRule;
	}

	/**
	 * 流程状态缺省跃迁条件设定
	 * @param defaultRule 流程状态缺省跃迁条件
	 */
	public void setDefaultRule(boolean defaultRule) {
		this.defaultRule = defaultRule;
	}

	/**
	 * 流程状态非缺省跃迁条件取得
	 * @return 流程状态非缺省跃迁条件
	 */
	public boolean isNotDefaultRule() {
		return notDefaultRule;
	}

	/**
	 * 流程状态非缺省跃迁条件设定
	 * @param notDefaultRule 流程状态非缺省跃迁条件
	 */
	public void setNotDefaultRule(boolean notDefaultRule) {
		this.notDefaultRule = notDefaultRule;
	}

	/**
	 * 流程参与者变量权限ID取得
	 * 
	 * @return 流程参与者变量权限ID
	 */
	public String getPtdid_like() {
		return ptdid_like;
	}

	/**
	 * 流程参与者变量权限ID设定
	 * 
	 * @param ptdid_like 流程参与者变量权限ID
	 */
	public void setPtdid_like(String ptdid_like) {
		this.ptdid_like = ptdid_like;
	}
	
}
