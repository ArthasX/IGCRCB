/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Id;

import com.deliverik.framework.base.BasePK;

/**
 * 概述: 配置所属关系视图主键定义
 * 功能描述: 配置所属关系视图主键定义
 * 创建记录: 2011/04/20
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class EiBelongRelationVWPK extends BasePK implements Serializable{

	/** 源资产ID */
	@Id
	protected Integer brpareiid;

	/** 目的资产ID */
	@Id
	protected Integer brcldeiid;
	
	/**
	 * 构造函数
	 * 
	 */
	public EiBelongRelationVWPK(){}
	
	/**
	 * 构造函数
	 * 
	 */
	public EiBelongRelationVWPK(Integer brpareiid, Integer brcldeiid) {
		super();
		this.brpareiid = brpareiid;
		this.brcldeiid = brcldeiid;
	}

	/**
	 * 源资产ID取得
	 *
	 * @return 源资产ID
	 */
	public Integer getBrpareiid() {
		return brpareiid;
	}

	/**
	 * 源资产ID设定
	 *
	 * @param brpareiid源资产ID
	 */
	public void setBrpareiid(Integer brpareiid) {
		this.brpareiid = brpareiid;
	}

	/**
	 * 目的资产ID取得
	 *
	 * @return 目的资产ID
	 */
	public Integer getBrcldeiid() {
		return brcldeiid;
	}

	/**
	 * 目的资产ID设定
	 *
	 * @param brcldeiid目的资产ID
	 */
	public void setBrcldeiid(Integer brcldeiid) {
		this.brcldeiid = brcldeiid;
	}

}
