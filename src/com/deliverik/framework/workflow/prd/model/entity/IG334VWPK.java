/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;

/**
  * 概述: 表单策略表实体主键
  * 功能描述: 表单策略表实体主键
  * 创建记录: 2013/09/03
  * 修改记录: 
  */
@SuppressWarnings("serial")
public class IG334VWPK extends BasePK implements Serializable {

	/** 状态定义ID */
	protected String psdid;

	/** 表单定义ID */
	protected String pidid;

	/** 表单值 */
	protected String pivalue;

	/**
	 * 构造函数
	 */
	public IG334VWPK() {

	}

	/**
	 * 构造函数
	 */
	public IG334VWPK(String psdid, String pidid, String pivalue) {
		super();
		this.psdid = psdid;
		this.pidid = pidid;
		this.pivalue = pivalue;
	}

	/**
	 * 状态定义ID取得
	 *
	 * @return 状态定义ID
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * 状态定义ID设定
	 *
	 * @param psdid 状态定义ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * 表单定义ID取得
	 *
	 * @return 表单定义ID
	 */
	public String getPidid() {
		return pidid;
	}

	/**
	 * 表单定义ID设定
	 *
	 * @param pidid 表单定义ID
	 */
	public void setPidid(String pidid) {
		this.pidid = pidid;
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