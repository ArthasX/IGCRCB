/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.condition;


/**
  * 概述: 流程状态按钮定义表检索条件实现
  * 功能描述: 流程状态按钮定义表检索条件实现
  * 创建记录: 2012/04/13
  * 修改记录: 
  */
public class IG156SearchCondImpl implements
		IG156SearchCond {

	/** 主键 */
	protected String pseid;

	/** 流程定义ID */
	protected String pdid;

	/** 流程状态 */
	protected String psdid;

	/** 动作ID */
	protected String pseactionid;

	/** 排序ID */
	protected Integer pseorder;

	/** 描述 */
	protected String psedec;
	
	protected String psebuttonid;

	/** 主键 */
	protected String pseid_like;

	public String getPsebuttonid() {
		return psebuttonid;
	}

	public void setPsebuttonid(String psebuttonid) {
		this.psebuttonid = psebuttonid;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public String getPseid() {
		return pseid;
	}

	/**
	 * 主键设定
	 *
	 * @param pseid 主键
	 */
	public void setPseid(String pseid) {
		this.pseid = pseid;
	}

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
	 * @param pdid 流程定义ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * 流程状态取得
	 *
	 * @return 流程状态
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * 流程状态设定
	 *
	 * @param psdid 流程状态
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * 动作ID取得
	 *
	 * @return 动作ID
	 */
	public String getPseactionid() {
		return pseactionid;
	}

	/**
	 * 动作ID设定
	 *
	 * @param pseactionid 动作ID
	 */
	public void setPseactionid(String pseactionid) {
		this.pseactionid = pseactionid;
	}

	/**
	 * 排序ID取得
	 *
	 * @return 排序ID
	 */
	public Integer getPseorder() {
		return pseorder;
	}

	/**
	 * 排序ID设定
	 *
	 * @param pseorder 排序ID
	 */
	public void setPseorder(Integer pseorder) {
		this.pseorder = pseorder;
	}

	/**
	 * 描述取得
	 *
	 * @return 描述
	 */
	public String getPsedec() {
		return psedec;
	}

	/**
	 * 描述设定
	 *
	 * @param psedec 描述
	 */
	public void setPsedec(String psedec) {
		this.psedec = psedec;
	}

	/**
	 * 主键取得
	 * 
	 * @return 主键
	 */
	public String getPseid_like() {
		return pseid_like;
	}

	/**
	 * 主键设定
	 * 
	 * @param pseid_like 主键
	 */
	public void setPseid_like(String pseid_like) {
		this.pseid_like = pseid_like;
	}
	
	

}