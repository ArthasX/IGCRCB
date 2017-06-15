/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;

/**
  * 概述: SOC0109VW实体主键
  * 功能描述: SOC0109VW实体主键
  * 创建记录: 2016/06/21
  * 修改记录: 
  */
@SuppressWarnings("serial")
public class SOC0109VWPK extends BasePK implements Serializable {

	/** 主键 */
	protected Integer id;

	/** 资产模型属性ID                            */
	protected String cid;

	/**
	 * 构造函数
	 */
	public SOC0109VWPK() {

	}

	/**
	 * 构造函数
	 */
	public SOC0109VWPK(Integer id, String cid) {
		super();
		this.id = id;
		this.cid = cid;
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
	 * 资产模型属性ID                           取得
	 *
	 * @return 资产模型属性ID                           
	 */
	public String getCid() {
		return cid;
	}

	/**
	 * 资产模型属性ID                           设定
	 *
	 * @param cid 资产模型属性ID                           
	 */
	public void setCid(String cid) {
		this.cid = cid;
	}

}