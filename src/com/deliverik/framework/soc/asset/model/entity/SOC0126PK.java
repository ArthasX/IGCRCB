/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.soc.asset.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;

/**
 * 概述: 资产域明细表实体主键
 * 功能描述: 资产域明细表实体主键
 * 创建记录: 2011/05/25
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class SOC0126PK extends BasePK implements Serializable {

	/** 资产域ID */
	protected Integer eiddid;

	/** 资产域版本 */
	protected Integer eiddversion;

	/** 资产名称 */
	protected String einame;
	
	/** 资产导入版本 */
	protected Integer eiImportversion;

	/**
	 * 构造函数
	 */
	public SOC0126PK() {

	}

	/**
	 * 构造函数
	 */
	public SOC0126PK(Integer eiddid, Integer eiddversion, String einame,Integer eiImportversion) {
		super();
		this.eiddid = eiddid;
		this.eiddversion = eiddversion;
		this.einame = einame;
		this.eiImportversion=eiImportversion;
	}

	/**
	 * 资产域ID取得
	 *
	 * @return 资产域ID
	 */
	public Integer getEiddid() {
		return eiddid;
	}

	/**
	 * 资产域ID设定
	 *
	 * @param eiddid资产域ID
	 */
	public void setEiddid(Integer eiddid) {
		this.eiddid = eiddid;
	}

	/**
	 * 资产域版本取得
	 *
	 * @return 资产域版本
	 */
	public Integer getEiddversion() {
		return eiddversion;
	}

	/**
	 * 资产域版本设定
	 *
	 * @param eiddversion资产域版本
	 */
	public void setEiddversion(Integer eiddversion) {
		this.eiddversion = eiddversion;
	}

		/**
		 * 资产导入版本取得
		 * @return资产导入版本
		 */
	public Integer getEiImportversion() {
		return eiImportversion;
	}

	/**
	 * 资产导入版本设定
	 * @param eiImportversion资产导入版本
	 */
	public void setEiImportversion(Integer eiImportversion) {
		this.eiImportversion = eiImportversion;
	}

	public String getEiname() {
		return einame;
	}

	public void setEiname(String einame) {
		this.einame = einame;
	}
}
