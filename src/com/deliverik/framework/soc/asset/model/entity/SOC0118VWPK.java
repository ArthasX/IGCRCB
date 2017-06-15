/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;

/**
  * 概述: SOC0118VW实体主键
  * 功能描述: SOC0118VW实体主键
  * 创建记录: 2016/06/21
  * 修改记录: 
  */
@SuppressWarnings("serial")
public class SOC0118VWPK extends BasePK implements Serializable {

	/** 主键 */
	protected Integer id;

	/** 资产ID                   */
	protected Integer eiid;

	/**
	 * 构造函数
	 */
	public SOC0118VWPK() {

	}

	/**
	 * 构造函数
	 */
	public SOC0118VWPK(Integer id, Integer eiid) {
		super();
		this.id = id;
		this.eiid = eiid;
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
	 * 资产ID                  取得
	 *
	 * @return 资产ID                  
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * 资产ID                  设定
	 *
	 * @param eiid 资产ID                  
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

}