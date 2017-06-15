/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.rpt.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;

/**
 * 概述: 
 * 功能描述: 
 * 创建记录: 2012-08-09
 * 修改记录: 将BusinessCapacityRealTimeVWPK表名改成SOC0428PK
 */
@SuppressWarnings("serial")
public class SOC0428PK extends BasePK implements Serializable{
	/** 业务系统ID */

	protected Integer bcid;
	/**业务系统名称*/

	protected String bcName;

	/**
	 * 
	 */
	public SOC0428PK(){}
	
	/**
	 * 数据信息主键定义构造函数
	 */
	public SOC0428PK(Integer bcid, String bcName) {
		super();
		this.bcid = bcid;
		this.bcName = bcName;
	}

	/**
	 * 业务系统ID取得
	 *
	 * @return bcid 业务系统ID
	 */
	public Integer getBcid() {
		return bcid;
	}

	/**
	 * 业务系统名称取得
	 *
	 * @return bcName 业务系统名称
	 */
	public String getBcName() {
		return bcName;
	}

	/**
	 * 业务系统ID设定
	 *
	 * @param bcid 业务系统ID
	 */
	public void setBcid(Integer bcid) {
		this.bcid = bcid;
	}

	/**
	 * 业务系统名称设定
	 *
	 * @param bcName 业务系统名称
	 */
	public void setBcName(String bcName) {
		this.bcName = bcName;
	}
}
