/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.pdf.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;

/**
  * 概述: PDF报表XML中表格式表单节点定义表实体主键
  * 功能描述: PDF报表XML中表格式表单节点定义表实体主键
  * 创建记录: 2013/08/02
  * 修改记录: 
  */
@SuppressWarnings("serial")
public class PdfTableNodePK extends BasePK implements Serializable {

	/** 流程定义ID */
	protected String pdid;

	/** 绑定名称 */
	protected String databinding;

	/**
	 * 构造函数
	 */
	public PdfTableNodePK() {

	}

	/**
	 * 构造函数
	 */
	public PdfTableNodePK(String pdid, String databinding) {
		super();
		this.pdid = pdid;
		this.databinding = databinding;
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
	 * 绑定名称取得
	 *
	 * @return 绑定名称
	 */
	public String getDatabinding() {
		return databinding;
	}

	/**
	 * 绑定名称设定
	 *
	 * @param databinding 绑定名称
	 */
	public void setDatabinding(String databinding) {
		this.databinding = databinding;
	}

}