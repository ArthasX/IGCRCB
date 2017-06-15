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
import com.deliverik.infogovernor.rpt.model.SOC0401Info;

/**
  * 概述: 数据库容量实时表实体
  * 功能描述: 数据库容量实时表实体
  * 创建记录: 2012/08/09
  * 修改记录: 将DBCapacityRealTimeTB表名改为SOC0401TB
  */
@SuppressWarnings("serial")
@Entity
@Table(name="SOC0401")
public class SOC0401TB extends BaseEntity implements Serializable,
		Cloneable, SOC0401Info {

	/** 主键 */
	@Id
	@TableGenerator(
		name="DBCAPACITYREALTIME_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="DBCAPACITYREALTIME_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="DBCAPACITYREALTIME_TABLE_GENERATOR")
	protected Integer dbId;

	/** 数据库名 */
	protected String dbName;

	/** 主机名 */
	protected String hostName;

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
	public Integer getDbId() {
		return dbId;
	}

	/**
	 * 主键设定
	 *
	 * @param dbId 主键
	 */
	public void setDbId(Integer dbId) {
		this.dbId = dbId;
	}

	/**
	 * 数据库名取得
	 *
	 * @return 数据库名
	 */
	public String getDbName() {
		return dbName;
	}

	/**
	 * 数据库名设定
	 *
	 * @param dbName 数据库名
	 */
	public void setDbName(String dbName) {
		this.dbName = dbName;
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
		return dbId;
	}

}