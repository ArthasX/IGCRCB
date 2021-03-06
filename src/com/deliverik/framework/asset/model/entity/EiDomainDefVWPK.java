package com.deliverik.framework.asset.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;
/**
 * 概述: 资产域定义表实体主键
 * 功能描述: 资产域定义表实体主键
 * 创建记录: 2011/05/25
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class EiDomainDefVWPK extends BasePK implements Serializable {

	/** 主键 */
	protected Integer eiddid;

	/** 版本号 */
	protected Integer version;
	
	/**
	 * 构造函数
	 */
	public EiDomainDefVWPK() {

	}
	
	/**
	 * 构造函数
	 */
	public EiDomainDefVWPK(Integer eiddid, Integer version) {
		super();
		this.eiddid = eiddid;
		this.version = version;
	}

	/**
	 * 主键取得
	 * @return 主键
	 */
	public Integer getEiddid() {
		return eiddid;
	}

	/**
	 * 主键设定
	 * @param eiddid主键
	 */
	public void setEiddid(Integer eiddid) {
		this.eiddid = eiddid;
	}

	/**
	 * 版本号取得
	 * @return 版本号
	 */
	public Integer getVersion() {
		return version;
	}

	/**
	 * 版本号设定
	 * @param version版本号
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}
}
