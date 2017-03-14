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
public class PdfIg898MapVWPK extends BasePK implements Serializable {

	/** 流程id */
	protected Integer prid;

	/** 表单定义ID */
	protected String pidid;

	/** 表格式表单列ID */
	protected String pvcolpidid;

	/** 表格式表单值行号 */
	protected String pvrownumber;

	/**
	 * 构造函数
	 */
	public PdfIg898MapVWPK() {

	}

	/**
	 * 构造函数
	 */
	public PdfIg898MapVWPK(Integer prid, String pidid, String pvcolpidid, String pvrownumber) {
		super();
		this.prid = prid;
		this.pidid = pidid;
		this.pvcolpidid = pvcolpidid;
		this.pvrownumber = pvrownumber;
	}

	/**
	 * 流程id取得
	 *
	 * @return 流程id
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * 流程id设定
	 *
	 * @param prid 流程id
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

	/**
	 * 表格式表单列ID取得
	 *
	 * @return 表格式表单列ID
	 */
	public String getPvcolpidid() {
		return pvcolpidid;
	}

	/**
	 * 表格式表单列ID设定
	 *
	 * @param pvcolpidid 表格式表单列ID
	 */
	public void setPvcolpidid(String pvcolpidid) {
		this.pvcolpidid = pvcolpidid;
	}

	/**
	 * 表格式表单值行号取得
	 *
	 * @return 表格式表单值行号
	 */
	public String getPvrownumber() {
		return pvrownumber;
	}

	/**
	 * 表格式表单值行号设定
	 *
	 * @param pvrownumber 表格式表单值行号
	 */
	public void setPvrownumber(String pvrownumber) {
		this.pvrownumber = pvrownumber;
	}

}