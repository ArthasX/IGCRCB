/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.prd.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 流程并行节点规则定义查询画面Form
 * 
 */
@SuppressWarnings("serial")
public class IGPRD0115Form extends BaseForm {

	/** 
	 * 流程参与者变量权限ID 
	 */
	protected String ptdid;
	
	/** 流程ID */
	protected String pdid;
	
	/**
	 * 流程状态ID（From）
	 */
	protected String fpsdid;
	
	/**
	 * 流程状态ID（To）
	 */
	protected String tpsdid;

	/** 上级状态ID */
	protected String ppsdid;

	public String getPdid() {
		return pdid;
	}

	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

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
	 * 上级状态ID取得
	 * @return 上级状态ID
	 */
	public String getPpsdid() {
		return ppsdid;
	}

	/**
	 * 上级状态ID设定
	 * @param ppsdid 上级状态ID
	 */
	public void setPpsdid(String ppsdid) {
		this.ppsdid = ppsdid;
	}

}
