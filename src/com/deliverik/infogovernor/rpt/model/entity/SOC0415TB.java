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
import com.deliverik.infogovernor.rpt.model.SOC0415Info;

/**
  * 概述: 表空间容量实时表实体
  * 功能描述: 表空间容量实时表实体
  * 创建记录: 2012/07/03
  * 修改记录: 2012/08/09 将TSCapacityRealTimeTB表名改为SOC0415TB
  */
@SuppressWarnings("serial")
@Entity
@Table(name="SOC0415")
public class SOC0415TB extends BaseEntity implements Serializable,
		Cloneable, SOC0415Info {

	/** 主键 */
	@Id
	@TableGenerator(
		name="TSCAPACITYREALTIME_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="TSCAPACITYREALTIME_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="TSCAPACITYREALTIME_TABLE_GENERATOR")
	protected Integer tsId;

	/** 表空间名 */
	protected String tsName;

	/** 主机名 */
	protected String hostName;

	/** 数据库名 */
	protected String dbName;

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
	public Integer getTsId() {
		return tsId;
	}

	/**
	 * 主键设定
	 *
	 * @param tsId 主键
	 */
	public void setTsId(Integer tsId) {
		this.tsId = tsId;
	}

	/**
	 * 表空间名取得
	 *
	 * @return 表空间名
	 */
	public String getTsName() {
		return tsName;
	}

	/**
	 * 表空间名设定
	 *
	 * @param tsName 表空间名
	 */
	public void setTsName(String tsName) {
		this.tsName = tsName;
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
		return tsId;
	}

}