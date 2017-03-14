/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.condition;


/**
  * 概述: 流程策略通知人检索条件实现
  * 功能描述: 流程策略通知人检索条件实现
  * 创建记录: 2012/04/25
  * 修改记录: 
  */
public class IG237SearchCondImpl implements
		IG237SearchCond {

	/** 状态ID */
	protected String psdid;

	/** 是否确认 */
	protected String psdconfirm;

	/** 状态ID */
	protected String psdid_like;
	
	/** 表单值 */
	protected String pivalue;
	
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
	 * @param psdid 状态ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * 是否确认取得
	 *
	 * @return 是否确认
	 */
	public String getPsdconfirm() {
		return psdconfirm;
	}

	/**
	 * 是否确认设定
	 *
	 * @param psdconfirm 是否确认
	 */
	public void setPsdconfirm(String psdconfirm) {
		this.psdconfirm = psdconfirm;
	}

	/**
	 * 状态ID取得
	 * 
	 * @return 状态ID
	 */
	public String getPsdid_like() {
		return psdid_like;
	}

	/**
	 * 状态ID设定
	 * @param psdid_like 状态ID
	 */
	public void setPsdid_like(String psdid_like) {
		this.psdid_like = psdid_like;
	}

	/**
	 * 表单值取得
	 * @return pivalue 表单值
	 */
	public String getPivalue() {
		return pivalue;
	}

	/**
	 * 表单值设定
	 * @param pivalue 表单值
	 */
	public void setPivalue(String pivalue) {
		this.pivalue = pivalue;
	}
	
}