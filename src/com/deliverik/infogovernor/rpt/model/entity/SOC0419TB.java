/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.rpt.model.SOC0419Info;

/**
  * 概述: 卷组容量实时表实体
  * 功能描述: 卷组容量实时表实体
  * 创建记录: 2012/07/03
  * 修改记录: 2012/08/09 将VGCapacityRealTimeTB表名改为SOC0419TB
  */
@SuppressWarnings("serial")
@Entity
@Table(name="SOC0419")
public class SOC0419TB extends BaseEntity implements Serializable,
		Cloneable, SOC0419Info {

	/** 主键 */
	@Id
	@TableGenerator(
		name="VGCAPACITYREALTIME_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="VGCAPACITYREALTIME_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="VGCAPACITYREALTIME_TABLE_GENERATOR")
	protected Integer vgId;

	/** 卷组名 */
	protected String vgName;

	/** 主机名 */
	protected String hostName;

	/** 存储序列号 */
	protected String sName;

	/** 日期 */
	protected String createDate;

	/** 已分配容量 */
	protected Integer allottedCapacity;

	/** 空闲容量 */
	protected Integer freeCapacity;

	/** 已使用容量 */
	protected Integer usedCapacity;

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getVgId() {
		return vgId;
	}

	/**
	 * 主键设定
	 *
	 * @param vgId 主键
	 */
	public void setVgId(Integer vgId) {
		this.vgId = vgId;
	}

	/**
	 * 卷组名取得
	 *
	 * @return 卷组名
	 */
	public String getVgName() {
		return vgName;
	}

	/**
	 * 卷组名设定
	 *
	 * @param vgName 卷组名
	 */
	public void setVgName(String vgName) {
		this.vgName = vgName;
	}

	/**
	 * 主机名取得
	 *
	 * @return 主机名
	 */
	public String getHostName() {
		return hostName;
	}

	/**
	 * 主机名设定
	 *
	 * @param hostName 主机名
	 */
	public void setHostName(String hostName) {
		this.hostName = hostName;
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
	 * 日期取得
	 *
	 * @return 日期
	 */
	public String getCreateDate() {
		return createDate;
	}

	/**
	 * 日期设定
	 *
	 * @param createDate 日期
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
	 * 已使用容量取得
	 *
	 * @return 已使用容量
	 */
	public Integer getUsedCapacity() {
		return usedCapacity;
	}

	/**
	 * 已使用容量设定
	 *
	 * @param usedCapacity 已使用容量
	 */
	public void setUsedCapacity(Integer usedCapacity) {
		this.usedCapacity = usedCapacity;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return vgId;
	}

}