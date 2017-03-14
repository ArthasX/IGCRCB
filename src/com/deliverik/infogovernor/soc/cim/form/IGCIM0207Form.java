/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.cim.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.soc.asset.model.condition.SOC0120SearchCond;

/**
 * 概述: 导入对象信息查询画面FORM
 * 功能描述: 导入对象信息查询画面FORM
 * 创建记录: 2011/05/04
 * 修改记录: 
 */
public class IGCIM0207Form extends BaseForm implements SOC0120SearchCond{
	private static final long serialVersionUID = 1L;
	
	/** 逻辑删除标识 */
	protected String deleteflag_eq;
	
	/** 实体名 */
	protected String impeiname;
	
	/** 实体名(调整用) */
	protected String impeiname_eq;
	
	/** 实体名(模糊查询) */
	protected String impeiname_like;
	
	/** 预删除对象信息 */
	protected String[] deleteImpeiid;
	
	/** 版本号 */
	protected Integer impversion;
	
	/** 逻辑删除标识 */
	protected String deleteflag;
	
	/**
	 * 逻辑删除标识取得
	 *
	 * @return 逻辑删除标识
	 */
	public String getDeleteflag_eq() {
		return deleteflag_eq;
	}

	/**
	 * 逻辑删除标识设定
	 * @param deleteflag_eq逻辑删除标识
	 */
	public void setDeleteflag_eq(String deleteflag_eq) {
		this.deleteflag_eq = deleteflag_eq;
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
	 * @param impeiname实体名
	 */
	public void setImpeiname(String impeiname) {
		this.impeiname = impeiname;
	}

	/**
	 * 实体名(模糊查询)取得
	 *
	 * @return 实体名(模糊查询)
	 */
	public String getImpeiname_like() {
		return impeiname_like;
	}

	/**
	 * 实体名(模糊查询)设定
	 * @param impeiname实体名(模糊查询)
	 */
	public void setImpeiname_like(String impeiname_like) {
		this.impeiname_like = impeiname_like;
	}

	/**
	 * 预删除对象信息
	 * @return 预删除对象信息
	 */
	public String[] getDeleteImpeiid() {
		return deleteImpeiid;
	}

	/**
	 * 预删除对象信息
	 * @param deleteImpeiid预删除对象信息
	 */
	public void setDeleteImpeiid(String[] deleteImpeiid) {
		this.deleteImpeiid = deleteImpeiid;
	}

	/**
	 * 版本号取得
	 * @return 版本号
	 */
	public Integer getImpversion() {
		return impversion;
	}

	/**
	 * 版本号设定
	 * @param impversion版本号
	 */
	public void setImpversion(Integer impversion) {
		this.impversion = impversion;
	}

	/**
	 * 逻辑删除标识
	 * @return 逻辑删除标识
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
	 * 实体名(调整用)取得
	 */
	public String getImpeiname_eq() {
		return impeiname_eq;
	}

	/**
	 * 实体名(调整用)设定
	 * @param impeiname_eq实体名(调整用)
	 */
	public void setImpeiname_eq(String impeiname_eq) {
		this.impeiname_eq = impeiname_eq;
	}

	public String getEsyscoding() {
		return null;
	}

	public String getImpcreatetime_e() {
		return null;
	}

	public String getImpcreatetime_s() {
		return null;
	}

}
