/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.asset.model.condition.ImportVersionSearchCond;
import com.deliverik.framework.base.BaseForm;

/**
 * 概述: 采集控制台信息查询画面FORM
 * 功能描述: 采集控制台信息查询画面FORM
 * 创建记录: 2011/05/04
 * 修改记录: 
 */
public class IGASM2301Form extends BaseForm implements ImportVersionSearchCond{
	private static final long serialVersionUID = 1L;
	
	/** 逻辑删除标识 */
	protected String deleteflag_eq;
	
	/** 实体名 */
	protected String impeiname;
	
	/** 实体名(调整用) */
	protected String impeiname_eq;
	
	/** 实体名(模糊查询) */
	protected String impeiname_like;
	
	/** 对象ID集合 */
	protected String[] collectIds;
	
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
	 * 对象ID集合
	 * @return 对象ID集合
	 */
	public String[] getCollectIds() {
		return collectIds;
	}

	/**
	 * 对象ID集合
	 * @param collectIds 对象ID集合
	 */
	public void setCollectIds(String[] collectIds) {
		this.collectIds = collectIds;
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


	public String getEilabel() {
		return null;
	}

	public String getEiddid() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getTypeId() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
