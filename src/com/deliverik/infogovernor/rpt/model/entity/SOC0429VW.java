/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.infogovernor.rpt.model.SOC0429Info;

/**
  * 概述: 主机容量视图实体
  * 功能描述: 主机容量视图实体
  * 创建记录: 2012/07/03
  * 修改记录: 2012/08/09 将HostCapacityRealTimeVW表名改为SOC0429VW
  */
@SuppressWarnings("serial")
@Entity
@Table(name="SOC0429")
public class SOC0429VW implements Serializable,
		Cloneable, SOC0429Info {

	/** 主机名字 */
	@Id
	protected String hostName;

	/**业务系统名称*/
	protected String bcName;
	/** 业务系统id */
	protected Integer bcid;

	/** 存储名字 */
	protected String sName;

	/** 记录时间 */
	protected String createDate;

	/** 已分配容量 */
	protected Integer allottedCapacity;

	/** 空闲容量 */
	protected Integer freeCapacity;

	/**
	 * 主机名字取得
	 *
	 * @return 主机名字
	 */
	public String getHostName() {
		return hostName;
	}

	/**
	 * 主机名字设定
	 *
	 * @param hostName 主机名字
	 */
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	/**
	 * 业务系统id取得
	 *
	 * @return 业务系统id
	 */
	public Integer getBcid() {
		return bcid;
	}

	/**
	 * 业务系统id设定
	 *
	 * @param bcid 业务系统id
	 */
	public void setBcid(Integer bcid) {
		this.bcid = bcid;
	}

	/**
	 * 存储名字取得
	 *
	 * @return 存储名字
	 */
	public String getSName() {
		return sName;
	}

	/**
	 * 存储名字设定
	 *
	 * @param sName 存储名字
	 */
	public void setSName(String sName) {
		this.sName = sName;
	}

	/**
	 * 记录时间取得
	 *
	 * @return 记录时间
	 */
	public String getCreateDate() {
		return createDate;
	}

	/**
	 * 记录时间设定
	 *
	 * @param createDate 记录时间
	 */
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
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
	 * 空闲容量取得
	 *
	 * @return 空闲容量
	 */
	public Integer getFreeCapacity() {
		return freeCapacity;
	}

	/**
	 * 空闲容量设定
	 *
	 * @param freeCapacity 空闲容量
	 */
	public void setFreeCapacity(Integer freeCapacity) {
		this.freeCapacity = freeCapacity;
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

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return null;
	}

}