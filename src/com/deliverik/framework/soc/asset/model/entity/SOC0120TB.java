/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.dao.hibernate.LogicalDelete;
import com.deliverik.framework.soc.asset.model.SOC0120Info;

/**
  * 概述: 导入数据版本管理表实体
  * 功能描述: 导入数据版本管理表实体
  * 创建记录: 2011/04/20
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@IdClass(SOC0120PK.class)
@Table(name="SOC0120")
public class SOC0120TB extends BaseEntity implements Serializable,
		Cloneable, SOC0120Info, LogicalDelete {

	/** 导入实体ID */
	protected Integer impeiid;

	/** 导入版本 */
	@Id
	protected Integer impversion;

	/** 实体名 */
	@Id
	protected String impeiname;
	
	/** 顶级CI类型 */
	protected Integer impcitype;
	
	/** 导入文件名 */
	protected String impfilename;

	/** 导入时间 */
	protected String impcreatetime;
	
	/** 资产模型层次码*/
	protected String esyscoding;
	
	/** 逻辑删除标识 */
	protected String deleteflag;
	
	/** IP */
	protected String impip;
	

	/** 用户名 */
	protected String impuserid;
	
	/** 密码 */
	protected String imppassword;
	
	/** 状态 */
	protected String impstatus;
	
	/** 导入对象类型信息 */
	@ManyToOne
	@JoinColumn(name="impcitype", referencedColumnName="impTypeid",  updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected SOC0113TB soc0113TB;
	
	/** 导入对象类型信息 */
	@ManyToOne
	@JoinColumn(name="esyscoding", referencedColumnName="esyscoding",  updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected SOC0117TB soc0117TB;
	
	public SOC0117TB getSoc0117TB() {
		return soc0117TB;
	}

	public void setSoc0117TB(SOC0117TB soc0117TB) {
		this.soc0117TB = soc0117TB;
	}

	/** 导入对象类型信息 */
	@OneToOne
	@JoinColumn(name="impeiid", referencedColumnName="eiid",  updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected SOC0118TB soc0118TB;
	
	public SOC0118TB getSoc0118TB() {
		return soc0118TB;
	}

	public void setSoc0118TB(SOC0118TB soc0118TB) {
		this.soc0118TB = soc0118TB;
	}
	
	/**
	 * 导入对象类型信息取得
	 *
	 * @return soc0113TB 导入对象类型信息
	 */
	public SOC0113TB getSoc0113TB() {
		return soc0113TB;
	}

	/**
	 * 导入对象类型信息设定
	 *
	 * @param soc0113TB 导入对象类型信息
	 */
	public void setSoc0113TB(SOC0113TB soc0113TB) {
		this.soc0113TB = soc0113TB;
	}

	/**
	 * 导入实体ID取得
	 *
	 * @return 导入实体ID
	 */
	public Integer getImpeiid() {
		return impeiid;
	}

	/**
	 * 导入实体ID设定
	 *
	 * @param impeiid导入实体ID
	 */
	public void setImpeiid(Integer impeiid) {
		this.impeiid = impeiid;
	}

	/**
	 * 导入版本取得
	 *
	 * @return 导入版本
	 */
	public Integer getImpversion() {
		return impversion;
	}

	/**
	 * 导入版本设定
	 *
	 * @param impversion导入版本
	 */
	public void setImpversion(Integer impversion) {
		this.impversion = impversion;
	}

	/**
	 * 实体名取得
	 *
	 * @return 实体名
	 */
	public String getImpeiname() {
		return impeiname;
	}

	/**
	 * 实体名设定
	 *
	 * @param impeiname实体名
	 */
	public void setImpeiname(String impeiname) {
		this.impeiname = impeiname;
	}

	/**
	 * 导入文件名取得
	 *
	 * @return 导入文件名
	 */
	public String getImpfilename() {
		return impfilename;
	}

	/**
	 * 导入文件名设定
	 *
	 * @param impfilename导入文件名
	 */
	public void setImpfilename(String impfilename) {
		this.impfilename = impfilename;
	}

	/**
	 * 导入时间取得
	 *
	 * @return 导入时间
	 */
	public String getImpcreatetime() {
		return impcreatetime;
	}

	/**
	 * 导入时间设定
	 *
	 * @param impcreatetime导入时间
	 */
	public void setImpcreatetime(String impcreatetime) {
		this.impcreatetime = impcreatetime;
	}
	
	/**
	 * 逻辑删除标识取得
	 *
	 * @return 逻辑删除标识
	 */
	public String getDeleteflag() {
		return deleteflag;
	}

	/**
	 * 逻辑删除标识设定
	 *
	 * @param brdeleteflag逻辑删除标识
	 */
	public void setDeleteflag(String deleteflag) {
		this.deleteflag = deleteflag;
	}
	
	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return new SOC0120PK(impversion, impeiname);
	}
	
	/** 资产模型层次码获取*/
	public String getEsyscoding() {
		return esyscoding;
	}
	
	/** 资产模型层次码设定*/
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}
	/**
	 * 导入类型
	 * @return 导入类型
	 */
	public Integer getImpcitype() {
		return impcitype;
	}
	/**
	 * 导入类型
	 * @param impcitype导入类型
	 */
	public void setImpcitype(Integer impcitype) {
		this.impcitype = impcitype;
	}

	/**
	 * IP取得
	 * 
	 * @return IP
	 */
	public String getImpip() {
		return impip;
	}

	/**
	 * IP设定
	 * 
	 * @param impip IP
	 */
	public void setImpip(String impip) {
		this.impip = impip;
	}

	/**
	 * 用户名取得
	 * 
	 * @return 用户名
	 */
	public String getImpuserid() {
		return impuserid;
	}

	/**
	 * 用户名设定
	 * 
	 * @param impuserid 用户名
	 */
	public void setImpuserid(String impuserid) {
		this.impuserid = impuserid;
	}

	/**
	 * 密码取得
	 * 
	 * @return 密码
	 */
	public String getImppassword() {
		return imppassword;
	}

	/**
	 * 密码设定
	 * 
	 * @param imppassword 密码
	 */
	public void setImppassword(String imppassword) {
		this.imppassword = imppassword;
	}

	/**
	 * 状态取得
	 * 
	 * @return 状态
	 */
	public String getImpstatus() {
		return impstatus;
	}

	/**
	 * 状态设定
	 * 
	 * @param impstatus 状态
	 */
	public void setImpstatus(String impstatus) {
		this.impstatus = impstatus;
	}
	
}