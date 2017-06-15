/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;

/**
  * 概述: SOC0117VW实体主键
  * 功能描述: SOC0117VW实体主键
  * 创建记录: 2016/06/21
  * 修改记录: 
  */
@SuppressWarnings("serial")
public class SOC0117VWPK extends BasePK implements Serializable {

	/** 主键 */
	protected Integer id;

	/** 资产类型id */
	protected String eid;

	/**
	 * 构造函数
	 */
	public SOC0117VWPK() {

	}

	/**
	 * 构造函数
	 */
	public SOC0117VWPK(Integer id, String eid) {
		super();
		this.id = id;
		this.eid = eid;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 主键设定
	 *
	 * @param id 主键
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 资产类型id取得
	 *
	 * @return 资产类型id
	 */
	public String getEid() {
		return eid;
	}

	/**
	 * 资产类型id设定
	 *
	 * @param eid 资产类型id
	 */
	public void setEid(String eid) {
		this.eid = eid;
	}

}