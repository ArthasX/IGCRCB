/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;

/**
  * 概述: 资产模型属性缺省值实体主键
  * 功能描述: 资产模型属性缺省值实体主键
  * 创建记录: 2012/07/20
  * 修改记录: 
  */
@SuppressWarnings("serial")
public class IG611PK extends BasePK implements Serializable {

	/** 模型ID */
	protected Integer eid;

	/** 属性ID */
	protected Integer cid;

	/**
	 * 构造函数
	 */
	public IG611PK() {

	}

	/**
	 * 构造函数
	 */
	public IG611PK(Integer eid, Integer cid) {
		super();
		this.eid = eid;
		this.cid = cid;
	}

	/**
	 * 模型ID取得
	 *
	 * @return 模型ID
	 */
	public Integer getEid() {
		return eid;
	}

	/**
	 * 模型ID设定
	 *
	 * @param eid 模型ID
	 */
	public void setEid(Integer eid) {
		this.eid = eid;
	}

	/**
	 * 属性ID取得
	 *
	 * @return 属性ID
	 */
	public Integer getCid() {
		return cid;
	}

	/**
	 * 属性ID设定
	 *
	 * @param cid 属性ID
	 */
	public void setCid(Integer cid) {
		this.cid = cid;
	}

}