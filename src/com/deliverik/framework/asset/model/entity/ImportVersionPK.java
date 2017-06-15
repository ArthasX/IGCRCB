/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;

/**
  * 概述: 导入数据版本管理表实体主键
  * 功能描述: 导入数据版本管理表实体主键
  * 创建记录: 2011/04/20
  * 修改记录: 
  */
@SuppressWarnings("serial")
public class ImportVersionPK extends BasePK implements Serializable {

	/** 导入版本 */
	protected Integer impversion;

	/** 实体名 */
	protected String impeiname;

	/**
	 * 构造函数
	 */
	public ImportVersionPK() {

	}

	/**
	 * 构造函数
	 */
	public ImportVersionPK(Integer impversion, String impeiname) {
		super();
		this.impversion = impversion;
		this.impeiname = impeiname;
		
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

}