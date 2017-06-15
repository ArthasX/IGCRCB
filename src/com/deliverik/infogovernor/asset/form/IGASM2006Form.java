/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.form;


import com.deliverik.framework.asset.model.ImportVersionInfo;
import com.deliverik.framework.asset.model.entity.EiImportProgrammeTB;
import com.deliverik.framework.asset.model.entity.IG013TB;
import com.deliverik.framework.base.BaseForm;

/**
 * 概述: 导入对象Form 
 * 功能描述: 导入对象Form
 * 创建记录: 2011/05/03 
 * 修改记录:
 */
public class IGASM2006Form extends BaseForm implements ImportVersionInfo {
	private static final long serialVersionUID = 1L;

	/** 导入对象实体名 */
	protected String impeiname;

	/** 顶级CI类型 */
	protected Integer impcitype;
	
	/** 导入实体ID */
	protected Integer impeiid;

	/** 导入版本 */
	protected Integer impversion;

	/** 导入文件名 */
	protected String impfilename;

	/** 导入时间 */
	protected String impcreatetime;

	/** 资产模型层次码 */
	protected String esyscoding;

	/** 编辑模式（登记/变更） */
	protected String mode = "0";
	
	/** 顶级CI类型 */
	protected EiImportProgrammeTB eiImportProgrammeTB;
	
	/**
	 * 时间戳
	 */
	protected String fingerPrint;
	
	
	/** 逻辑删除标识 */
	protected String deleteflag;
	
	/** ip */
	protected String impip;
	
	/** 用户名 */
	protected String impuserid;
	
	/** 密码 */
	protected String imppassword;
	
	/** 状态 */
	protected String impstatus;

	/**
	 * 编辑模式（登记/变更）
	 * @return 编辑模式（登记/变更）
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * 编辑模式（登记/变更）
	 * @param mode编辑模式（登记/变更）
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}

	/**
	 * 导入对象实体名
	 */
	public String getImpeiname() {
		return impeiname;
	}

	/**
	 * 导入对象实体名
	 * @param impeiname导入对象实体名
	 */
	public void setImpeiname(String impeiname) {
		this.impeiname = impeiname;
	}

	/**
	 * 顶级CI类型
	 * @return 顶级CI类型
	 */
	public Integer getImpcitype() {
		return impcitype;
	}

	/**
	 * 顶级CI类型
	 * @param impcitype顶级CI类型
	 */
	public void setImpcitype(Integer impcitype) {
		this.impcitype = impcitype;
	}

	/**
	 * 导入实体ID
	 */
	public Integer getImpeiid() {
		return impeiid;
	}

	/**
	 * 导入实体ID
	 * @param impeiid导入实体ID
	 */
	public void setImpeiid(Integer impeiid) {
		this.impeiid = impeiid;
	}

	/**
	 * 导入版本
	 */
	public Integer getImpversion() {
		return impversion;
	}

	/**
	 * 导入版本
	 * @param impversion导入版本
	 */
	public void setImpversion(Integer impversion) {
		this.impversion = impversion;
	}

	/**
	 * 导入文件名
	 */
	public String getImpfilename() {
		return impfilename;
	}

	/**
	 * 导入文件名
	 * @param impfilename导入文件名
	 */
	public void setImpfilename(String impfilename) {
		this.impfilename = impfilename;
	}

	/**
	 * 导入时间
	 */
	public String getImpcreatetime() {
		return impcreatetime;
	}

	/**
	 * 导入时间
	 * @param impcreatetime导入时间
	 */
	public void setImpcreatetime(String impcreatetime) {
		this.impcreatetime = impcreatetime;
	}

	/**
	 * 资产模型层次码
	 */
	public String getEsyscoding() {
		return esyscoding;
	}

	/**
	 * 资产模型层次码
	 * @param esyscoding资产模型层次码
	 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	/**
	 * 时间戳取得
	 */
	public String getFingerPrint() {
		return fingerPrint;
	}

	/**
	 * 时间戳设定
	 * @param fingerPrint时间戳
	 */
	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}

	/**
	 * 逻辑删除标识
	 */
	public String getDeleteflag() {
		return deleteflag;
	}

	/**
	 * 逻辑删除标识
	 * @param deleteflag逻辑删除标识
	 */
	public void setDeleteflag(String deleteflag) {
		this.deleteflag = deleteflag;
	}



	/**
	 * 顶级CI类型取得
	 * @return 顶级CI类型
	 */
	public EiImportProgrammeTB getEiImportProgrammeTB() {
		return eiImportProgrammeTB;
	}

	/**
	 * 顶级CI类型设定
	 * @param eiImportProgrammeTB顶级CI类型
	 */
	public void setEiImportProgrammeTB(EiImportProgrammeTB eiImportProgrammeTB) {
		this.eiImportProgrammeTB = eiImportProgrammeTB;
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

	public IG013TB getEntityItemTB() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getEircount() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getBelongcount() {
		// TODO Auto-generated method stub
		return null;
	}

}
