/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.deliverik.infogovernor.rpt.model.SOC0428Info;

/**
  * 概述: 业务系统视图实体
  * 功能描述: 业务系统视图实体
  * 创建记录: 2012/08/09
  * 修改记录: 将BusinessCapacityRealTimeVW表名改为SOC0428VW
  */
@SuppressWarnings("serial")
@Entity
@IdClass(SOC0428PK.class)
@Table(name="SOC0428")
public class SOC0428VW implements Serializable,
		Cloneable, SOC0428Info {

	/** 业务系统ID */
	@Id
	protected Integer bcid;

	/** 存储序列号 */
	protected String sName;
	/**业务系统名称*/
	@Id
	protected String bcName;

	/** 已分配容量 */
	protected Integer allottedCapacity;
	
	/**
	 * 主键取得
	 * @return 主键
	 */
	public Serializable getPK() {
		return new SOC0428PK(bcid,bcName);
	}
	

	/**
	 * 业务系统ID取得
	 *
	 * @return 业务系统ID
	 */
	public Integer getBcid() {
		return bcid;
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
	 * 存储序列号取得
	 *
	 * @return 存储序列号
	 */
	public String getSName() {
		return sName;
	}

	/**
	 * 存储序列号设定
	 *
	 * @param sName 存储序列号
	 */
	public void setSName(String sName) {
		this.sName = sName;
	}

	/**
	 * 已分配容量取得
	 *
	 * @return 已分配容量
	 */
	public Integer getAllottedCapacity() {
		return allottedCapacity;
	}

	/**
	 * 已分配容量设定
	 *
	 * @param allottedCapacity 已分配容量
	 */
	public void setAllottedCapacity(Integer allottedCapacity) {
		this.allottedCapacity = allottedCapacity;
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
	 * 业务系统名称设定
	 *
	 * @param bcName 业务系统名称
	 */
	public void setBcName(String bcName) {
		this.bcName = bcName;
	}
}