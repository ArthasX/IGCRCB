/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.pdf.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;

/**
  * 概述: 报表字段与流程公有表单值映射关系视图实体主键
  * 功能描述: 报表字段与流程公有表单值映射关系视图实体主键
  * 创建记录: 2013/07/31
  * 修改记录: 
  */
@SuppressWarnings("serial")
public class PdfIg599MapVWPK extends BasePK implements Serializable {

	/** 流程ID */
	protected Integer prid;

	/** 表单定义ID */
	protected String pidid;

	/**
	 * 构造函数
	 */
	public PdfIg599MapVWPK() {

	}

	/**
	 * 构造函数
	 */
	public PdfIg599MapVWPK(Integer prid, String pidid) {
		super();
		this.prid = prid;
		this.pidid = pidid;
	}

	/**
	 * 流程ID取得
	 *
	 * @return 流程ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * 流程ID设定
	 *
	 * @param prid 流程ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
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

}