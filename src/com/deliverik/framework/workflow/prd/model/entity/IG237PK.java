/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;

/**
  * 概述: 流程策略通知人实体主键
  * 功能描述: 流程策略通知人实体主键
  * 创建记录: 2012/04/25
  * 修改记录: 
  */
@SuppressWarnings("serial")
public class IG237PK extends BasePK implements Serializable {

	/** 状态ID */
	protected String psdid;

	/** 是否确认 */
	protected String psdconfirm;

	/** 用户ID */
	protected String userid;
	
	/** 表单值 */
	protected String pivalue;

	/**
	 * 构造函数
	 */
	public IG237PK() {

	}

	/**
	 * 构造函数
	 */
	public IG237PK(String psdid, String psdconfirm, String userid, String pivalue) {
		super();
		this.psdid = psdid;
		this.psdconfirm = psdconfirm;
		this.userid = userid;
		this.pivalue = pivalue;
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
	 * 用户ID取得
	 *
	 * @return 用户ID
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * 用户ID设定
	 *
	 * @param userid 用户ID
	 */
	public void setUserid(String userid) {
		this.userid = userid;
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