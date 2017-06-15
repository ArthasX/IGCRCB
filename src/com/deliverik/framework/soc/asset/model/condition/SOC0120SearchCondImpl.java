/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model.condition;

/**
  * 概述: 导入数据版本管理表检索条件实现
  * 功能描述: 导入数据版本管理表检索条件实现
  * 创建记录: 2011/04/20
  * 修改记录: 
  */
public class SOC0120SearchCondImpl implements
		SOC0120SearchCond {
	
	/** 逻辑删除标识 */
	protected String deleteflag_eq;
	
	/** 实体名(调整用)*/
	protected String impeiname_eq;
	
	/** 实体名 */
	protected String impeiname;
	
	/** 实体名(模糊查询) */
	protected String impeiname_like;
	
	/** 版本号 */
	protected Integer impversion;
	
	/** 导入时间 */
	protected String impcreatetime_e;
	
	/** 导入时间 */
	protected String impcreatetime_s;

	/** code码 */
	protected String esyscoding;

	/**
	 * 实体名取得
	 *
	 * @return 实体名
	 */
	public String getImpeiname_eq() {
		return impeiname_eq;
	}
	
	
	/**
	 * 实体名设定
	 *
	 * @param impeiname_eq实体名
	 */
	public void setImpeiname_eq(String impeiname_eq) {
		this.impeiname_eq = impeiname_eq;
	}
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
	 *
	 * @param deleteflag_eq 逻辑删除标识
	 */
	public void setDeleteflag_eq(String deleteflag_eq) {
		this.deleteflag_eq = deleteflag_eq;
	}

	/**
	 * 实体名(模糊查询)取得
	 * @return 实体名(模糊查询)
	 */
	public String getImpeiname_like() {
		return impeiname_like;
	}

	/**
	 * 实体名(模糊查询)设定
	 * @param impeiname_like实体名(模糊查询)
	 */
	public void setImpeiname_like(String impeiname_like) {
		this.impeiname_like = impeiname_like;
	}

	/**
	 * 实体名取得
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
	
	public String getEsyscoding() {
		return esyscoding;
	}


	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}
	
	public String getImpcreatetime_e() {
		return impcreatetime_e;
	}


	public void setImpcreatetime_e(String impcreatetime_e) {
		this.impcreatetime_e = impcreatetime_e;
	}


	public String getImpcreatetime_s() {
		return impcreatetime_s;
	}


	public void setImpcreatetime_s(String impcreatetime_s) {
		this.impcreatetime_s = impcreatetime_s;
	}
}