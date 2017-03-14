/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;

/**
  * 概述: SOC0107VW实体主键
  * 功能描述: SOC0107VW实体主键
  * 创建记录: 2016/06/21
  * 修改记录: 
  */
@SuppressWarnings("serial")
public class SOC0107VWPK extends BasePK implements Serializable {

	/** 主键 */
	protected Integer id;

	/** 无意义主键 */
	protected Integer ciid;

	/**
	 * 构造函数
	 */
	public SOC0107VWPK() {

	}

	/**
	 * 构造函数
	 */
	public SOC0107VWPK(Integer id, Integer ciid) {
		super();
		this.id = id;
		this.ciid = ciid;
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
	 * 无意义主键取得
	 *
	 * @return 无意义主键
	 */
	public Integer getCiid() {
		return ciid;
	}

	/**
	 * 无意义主键设定
	 *
	 * @param ciid 无意义主键
	 */
	public void setCiid(Integer ciid) {
		this.ciid = ciid;
	}

}