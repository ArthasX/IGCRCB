package com.deliverik.framework.workflow.prd.model.condition;


/**
 * 流程参与者变量权限视图检索条件实现
 * 
 */
public class IG100SearchCondImpl implements IG100SearchCond {
	
	/** 流程状态ID */
	protected String psdid;

	/** 流程参与者ID */
	protected String ppdid;
	
	/** 流程类型ID */
	protected String pdid;

	/**
	 * 流程状态ID取得
	 * @return 流程状态ID
	 */
	public String getPsdid() {
		return psdid;
	}
	
	/**
	 * 流程状态ID设定
	 * @param psdid流程状态ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * 流程参与者ID取得
	 * @return 流程参与者ID
	 */
	public String getPpdid() {
		return ppdid;
	}
	/**
	 * 流程参与者ID设定
	 * @param ppdid 流程参与者ID
	 */
	public void setPpdid(String ppdid) {
		this.ppdid = ppdid;
	}

	/**
	 * 流程类型ID取得
	 * 
	 * @return 流程类型ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * 流程类型ID设定
	 * 
	 * @param pdid 流程类型ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}
	
}
