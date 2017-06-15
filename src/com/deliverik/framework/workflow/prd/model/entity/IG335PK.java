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
public class IG335PK extends BasePK implements Serializable {

	/** 状态定义ID */
	protected String psdid;

	/** 表单定义ID */
	protected String pidid;

	/** 表单值 */
	protected String pivalue;
	
	/** 确认节点是否发送邮件 */
	protected String psdconfirm;

	/**流程定义ID*/
	protected String pdid;

	/**
	 * 构造函数
	 */
	public IG335PK() {

	}

	/**
	 * 构造函数
	 */
	public IG335PK(String psdid, String pdid, String pidid, String pivalue, String psdconfirm) {
		super();
		this.psdid = psdid;
		this.pdid = pdid;
		this.pidid = pidid;
		this.pivalue = pivalue;
		this.psdconfirm = psdconfirm;
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

	/**
	 * 确认节点是否发送邮件取得
	 * @return psdconfirm 确认节点是否发送邮件
	 */
	public String getPsdconfirm() {
		return psdconfirm;
	}

	/**
	 * 确认节点是否发送邮件设定
	 * @param psdconfirm 确认节点是否发送邮件
	 */
	public void setPsdconfirm(String psdconfirm) {
		this.psdconfirm = psdconfirm;
	}
 
	/**
	 * 流程定义ID取得
	 * @return pdid
	 */
	public String getPdid() {
		return pdid;
	}
	/**
	 * 流程定义ID设定
	 * @param pdid
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

}