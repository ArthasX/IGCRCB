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
import com.deliverik.infogovernor.rpt.model.SOC0411Info;

/**
  * 概述: 存储容量实时表实体
  * 功能描述: 存储容量实时表实体
  * 创建记录: 2012/07/03
  * 修改记录: 2012/08/09 将StorageCapacityRealTimeTB表名改为SOC0411TB
  */
@SuppressWarnings("serial")
@Entity
@Table(name="SOC0411")
public class SOC0411TB extends BaseEntity implements Serializable,
		Cloneable, SOC0411Info {

	/** 主键 */
	@Id
	@TableGenerator(
		name="STORAGECAPACITYREALTIME_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="STORAGECAPACITYREALTIME_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="STORAGECAPACITYREALTIME_TABLE_GENERATOR")
	protected Integer scid;

	/** 存储序列号 */
	protected String sName;

	/** 日期 */
	protected String createDate;

	/** 裸容量 */
	protected Integer rawCapacity;

	/** 有效容量 */
	protected Integer effectiveCapacity;

	/** 冗余容量 */
	protected Integer redundancyCapacity;

	/** 已分配容量 */
	protected Integer allottedCapacity;

	/** 空闲容量 */
	protected Integer freeCapacity;

	/** 磁盘个数 */
	protected Integer diskCount;

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getScid() {
		return scid;
	}

	/**
	 * 主键设定
	 *
	 * @param scid 主键
	 */
	public void setScid(Integer scid) {
		this.scid = scid;
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
	 * 裸容量取得
	 *
	 * @return 裸容量
	 */
	public Integer getRawCapacity() {
		return rawCapacity;
	}

	/**
	 * 裸容量设定
	 *
	 * @param rawCapacity 裸容量
	 */
	public void setRawCapacity(Integer rawCapacity) {
		this.rawCapacity = rawCapacity;
	}

	/**
	 * 有效容量取得
	 *
	 * @return 有效容量
	 */
	public Integer getEffectiveCapacity() {
		return effectiveCapacity;
	}

	/**
	 * 有效容量设定
	 *
	 * @param effectiveCapacity 有效容量
	 */
	public void setEffectiveCapacity(Integer effectiveCapacity) {
		this.effectiveCapacity = effectiveCapacity;
	}

	/**
	 * 冗余容量取得
	 *
	 * @return 冗余容量
	 */
	public Integer getRedundancyCapacity() {
		return redundancyCapacity;
	}

	/**
	 * 冗余容量设定
	 *
	 * @param redundancyCapacity 冗余容量
	 */
	public void setRedundancyCapacity(Integer redundancyCapacity) {
		this.redundancyCapacity = redundancyCapacity;
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
	 * 磁盘个数取得
	 *
	 * @return 磁盘个数
	 */
	public Integer getDiskCount() {
		return diskCount;
	}

	/**
	 * 磁盘个数设定
	 *
	 * @param diskCount 磁盘个数
	 */
	public void setDiskCount(Integer diskCount) {
		this.diskCount = diskCount;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return scid;
	}

}