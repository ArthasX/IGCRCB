/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;

/**
  * 概述: SOC0151VW实体主键
  * 功能描述: SOC0151VW实体主键
  * 创建记录: 2016/06/23
  * 修改记录: 
  */
@SuppressWarnings("serial")
public class SOC0151VWPK extends BasePK implements Serializable {

	/** 主键 */
	protected Integer id;

	/** 无意义主键 */
	protected Integer ccdid;

	/**
	 * 构造函数
	 */
	public SOC0151VWPK() {

	}

	/**
	 * 构造函数
	 */
	public SOC0151VWPK(Integer id, Integer ccdid) {
		super();
		this.id = id;
		this.ccdid = ccdid;
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
	public Integer getCcdid() {
		return ccdid;
	}

	/**
	 * 无意义主键设定
	 *
	 * @param ccdid 无意义主键
	 */
	public void setCcdid(Integer ccdid) {
		this.ccdid = ccdid;
	}

}