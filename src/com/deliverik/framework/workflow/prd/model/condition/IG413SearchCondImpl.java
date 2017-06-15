package com.deliverik.framework.workflow.prd.model.condition;


/**
 * 流程事件定义信息检索条件实现
 * 
 */
public class IG413SearchCondImpl implements IG413SearchCond {
	
	/** 流程定义ID */
	protected String pdid;

	/** 状态ID */
	protected String psdid;

	/** 事件类型 */
	protected String pedtype;
	
	/** 主键 */
	protected String pedid_like;
	
	/**
	 * 流程定义ID取得
	 * 
	 * @return 流程定义ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * 流程定义ID设定
	 * 
	 * @param pdid流程定义ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * 状态ID取得
	 * 
	 * @return 状态ID
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * 状态ID设定
	 * 
	 * @param psdid状态ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * 事件类型取得
	 * 
	 * @return 事件类型
	 */
	public String getPedtype() {
		return pedtype;
	}

	/**
	 * 事件类型设定
	 * 
	 * @param pedtype事件类型
	 */
	public void setPedtype(String pedtype) {
		this.pedtype = pedtype;
	}

	/**
	 * 主键取得
	 * 
	 * @return 主键
	 */
	public String getPedid_like() {
		return pedid_like;
	}

	/**
	 * 主键设定
	 * 
	 * @param pedid_like 主键
	 */
	public void setPedid_like(String pedid_like) {
		this.pedid_like = pedid_like;
	}
	
}
