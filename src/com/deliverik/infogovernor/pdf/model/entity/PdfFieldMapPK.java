/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.pdf.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;

/**
  * 概述: PDF报表与流程表单映射表实体主键
  * 功能描述: PDF报表与流程表单映射表实体主键
  * 创建记录: 2013/07/31
  * 修改记录: 
  */
@SuppressWarnings("serial")
public class PdfFieldMapPK extends BasePK implements Serializable {

	/** 流程定义ID */
	protected String pdid;

	/** 流程表单定义ID */
	protected String pidid;

	/**
	 * 构造函数
	 */
	public PdfFieldMapPK() {

	}

	/**
	 * 构造函数
	 */
	public PdfFieldMapPK(String pdid, String pidid) {
		super();
		this.pdid = pdid;
		this.pidid = pidid;
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
	 * 流程表单定义ID取得
	 *
	 * @return 流程表单定义ID
	 */
	public String getPidid() {
		return pidid;
	}

	/**
	 * 流程表单定义ID设定
	 *
	 * @param pidid 流程表单定义ID
	 */
	public void setPidid(String pidid) {
		this.pidid = pidid;
	}

}