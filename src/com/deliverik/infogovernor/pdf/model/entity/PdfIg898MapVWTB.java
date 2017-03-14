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
import com.deliverik.infogovernor.pdf.model.PdfIg898MapVWInfo;

/**
  * 概述: 报表字段与流程公有表单值映射关系视图实体
  * 功能描述: 报表字段与流程公有表单值映射关系视图实体
  * 创建记录: 2013/07/31
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@IdClass(PdfIg898MapVWPK.class)
@Table(name="PdfIg898MapVW")
public class PdfIg898MapVWTB extends BaseEntity implements Serializable,
		Cloneable, PdfIg898MapVWInfo {

	/** 流程id */
	@Id
	protected Integer prid;

	/** 表单定义ID */
	@Id
	protected String pidid;

	/** 表格式表单列ID */
	@Id
	protected String pvcolpidid;

	/** 表格式表单值行号 */
	@Id
	protected String pvrownumber;

	/** 表格式表单值 */
	protected String pvalue;

	/** 表格式表单列名称 */
	protected String pvcolname;

	/** 附件 */
	protected String attkey;

	/** 表格式表单定义名称 */
	protected String pidname;

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

	/**
	 * 表格式表单值取得
	 *
	 * @return 表格式表单值
	 */
	public String getPvalue() {
		return pvalue;
	}

	/**
	 * 表格式表单值设定
	 *
	 * @param pvalue 表格式表单值
	 */
	public void setPvalue(String pvalue) {
		this.pvalue = pvalue;
	}

	/**
	 * 表格式表单列名称取得
	 *
	 * @return 表格式表单列名称
	 */
	public String getPvcolname() {
		return pvcolname;
	}

	/**
	 * 表格式表单列名称设定
	 *
	 * @param pvcolname 表格式表单列名称
	 */
	public void setPvcolname(String pvcolname) {
		this.pvcolname = pvcolname;
	}

	/**
	 * 附件取得
	 *
	 * @return 附件
	 */
	public String getAttkey() {
		return attkey;
	}

	/**
	 * 附件设定
	 *
	 * @param attkey 附件
	 */
	public void setAttkey(String attkey) {
		this.attkey = attkey;
	}

	/**
	 * 表格式表单定义名称取得
	 *
	 * @return 表格式表单定义名称
	 */
	public String getPidname() {
		return pidname;
	}

	/**
	 * 表格式表单定义名称设定
	 *
	 * @param pidname 表格式表单定义名称
	 */
	public void setPidname(String pidname) {
		this.pidname = pidname;
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
		return new PdfIg898MapVWPK(prid, pidid, pvcolpidid, pvrownumber);
	}

}