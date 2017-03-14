/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.pdf.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.pdf.model.PdfIg599MapVWInfo;

/**
  * 概述: 报表字段与流程公有表单值映射关系视图实体
  * 功能描述: 报表字段与流程公有表单值映射关系视图实体
  * 创建记录: 2013/07/31
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@IdClass(PdfIg599MapVWPK.class)
@Table(name="PdfIg599MapVW")
public class PdfIg599MapVWTB extends BaseEntity implements Serializable,
		Cloneable, PdfIg599MapVWInfo {

	/** 流程ID */
	@Id
	protected Integer prid;

	/** 表单定义ID */
	@Id
	protected String pidid;

	/** 表单值 */
	protected String pivarvalue;

	/** 表单定义名称 */
	protected String pivarname;

	/** 流程定义ID */
	protected String pdid;

	/** 报表字段名称 */
	protected String pdfpidname;

	/** 表单父绑定信息 */
	protected String pdatabinding;

	/** 表单绑定信息 */
	protected String databinding;

	/** 表单类型 */
	protected String formtype;

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

	/**
	 * 表单值取得
	 *
	 * @return 表单值
	 */
	public String getPivarvalue() {
		return pivarvalue;
	}

	/**
	 * 表单值设定
	 *
	 * @param pivarvalue 表单值
	 */
	public void setPivarvalue(String pivarvalue) {
		this.pivarvalue = pivarvalue;
	}

	/**
	 * 表单定义名称取得
	 *
	 * @return 表单定义名称
	 */
	public String getPivarname() {
		return pivarname;
	}

	/**
	 * 表单定义名称设定
	 *
	 * @param pivarname 表单定义名称
	 */
	public void setPivarname(String pivarname) {
		this.pivarname = pivarname;
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
	 * 报表字段名称取得
	 *
	 * @return 报表字段名称
	 */
	public String getPdfpidname() {
		return pdfpidname;
	}

	/**
	 * 报表字段名称设定
	 *
	 * @param pdfpidname 报表字段名称
	 */
	public void setPdfpidname(String pdfpidname) {
		this.pdfpidname = pdfpidname;
	}

	/**
	 * 表单父绑定信息取得
	 *
	 * @return 表单父绑定信息
	 */
	public String getPdatabinding() {
		return pdatabinding;
	}

	/**
	 * 表单父绑定信息设定
	 *
	 * @param pdatabinding 表单父绑定信息
	 */
	public void setPdatabinding(String pdatabinding) {
		this.pdatabinding = pdatabinding;
	}

	/**
	 * 表单绑定信息取得
	 *
	 * @return 表单绑定信息
	 */
	public String getDatabinding() {
		return databinding;
	}

	/**
	 * 表单绑定信息设定
	 *
	 * @param databinding 表单绑定信息
	 */
	public void setDatabinding(String databinding) {
		this.databinding = databinding;
	}

	/**
	 * 表单类型取得
	 *
	 * @return 表单类型
	 */
	public String getFormtype() {
		return formtype;
	}

	/**
	 * 表单类型设定
	 *
	 * @param formtype 表单类型
	 */
	public void setFormtype(String formtype) {
		this.formtype = formtype;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return new PdfIg599MapVWPK(prid, pidid);
	}

}