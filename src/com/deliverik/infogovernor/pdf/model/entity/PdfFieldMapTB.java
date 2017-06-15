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
import com.deliverik.infogovernor.pdf.model.PdfFieldMapInfo;

/**
  * 概述: PDF报表与流程表单映射表实体
  * 功能描述: PDF报表与流程表单映射表实体
  * 创建记录: 2013/07/31
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@IdClass(PdfFieldMapPK.class)
@Table(name="PdfFieldMap")
public class PdfFieldMapTB extends BaseEntity implements Serializable,
		Cloneable, PdfFieldMapInfo {

	/** 流程定义ID */
	@Id
	protected String pdid;

	/** 流程表单定义ID */
	@Id
	protected String pidid;

	/** 流程表单名称 */
	protected String pidname;

	/** 父绑定名称 */
	protected String pdatabinding;

	/** 绑定名称 */
	protected String databinding;

	/** 表单类型 */
	protected String formtype;

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

	/**
	 * 流程表单名称取得
	 *
	 * @return 流程表单名称
	 */
	public String getPidname() {
		return pidname;
	}

	/**
	 * 流程表单名称设定
	 *
	 * @param pidname 流程表单名称
	 */
	public void setPidname(String pidname) {
		this.pidname = pidname;
	}

	/**
	 * 父绑定名称取得
	 *
	 * @return 父绑定名称
	 */
	public String getPdatabinding() {
		return pdatabinding;
	}

	/**
	 * 父绑定名称设定
	 *
	 * @param pdatabinding 父绑定名称
	 */
	public void setPdatabinding(String pdatabinding) {
		this.pdatabinding = pdatabinding;
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
		return new PdfFieldMapPK(pdid, pidid);
	}

}