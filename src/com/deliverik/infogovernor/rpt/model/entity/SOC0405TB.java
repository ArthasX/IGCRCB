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
import com.deliverik.infogovernor.rpt.model.SOC0405Info;

/**
  * 概述: 逻辑卷容量实时表实体
  * 功能描述: 逻辑卷容量实时表实体
  * 创建记录: 2012/07/03
  * 修改记录: 2012/08/09 将LVCapacityRealTimeTB表名改为SOC0405TB
  */
@SuppressWarnings("serial")
@Entity
@Table(name="SOC0405")
public class SOC0405TB extends BaseEntity implements Serializable,
		Cloneable, SOC0405Info {

	/** 主键 */
	@Id
	@TableGenerator(
		name="LVCAPACITYREALTIME_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="LVCAPACITYREALTIME_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="LVCAPACITYREALTIME_TABLE_GENERATOR")
	protected Integer lvId;

	/** 主机名 */
	protected String hostName;

	/** 卷组名 */
	protected String vgName;

	/** 逻辑卷类型 */
	protected String lvType;

	/** 逻辑卷名 */
	protected String lvName;

	/** 逻辑卷大小 */
	protected Integer lvSize;

	/** 逻辑卷状态 */
	protected String lvState;

	/** 文件系统名 */
	protected String fsName;

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
	public Integer getLvId() {
		return lvId;
	}

	/**
	 * 主键设定
	 *
	 * @param lvId 主键
	 */
	public void setLvId(Integer lvId) {
		this.lvId = lvId;
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
	 * 逻辑卷类型取得
	 *
	 * @return 逻辑卷类型
	 */
	public String getLvType() {
		return lvType;
	}

	/**
	 * 逻辑卷类型设定
	 *
	 * @param lvType 逻辑卷类型
	 */
	public void setLvType(String lvType) {
		this.lvType = lvType;
	}

	/**
	 * 逻辑卷名取得
	 *
	 * @return 逻辑卷名
	 */
	public String getLvName() {
		return lvName;
	}

	/**
	 * 逻辑卷名设定
	 *
	 * @param lvName 逻辑卷名
	 */
	public void setLvName(String lvName) {
		this.lvName = lvName;
	}

	/**
	 * 逻辑卷大小取得
	 *
	 * @return 逻辑卷大小
	 */
	public Integer getLvSize() {
		return lvSize;
	}

	/**
	 * 逻辑卷大小设定
	 *
	 * @param lvSize 逻辑卷大小
	 */
	public void setLvSize(Integer lvSize) {
		this.lvSize = lvSize;
	}

	/**
	 * 逻辑卷状态取得
	 *
	 * @return 逻辑卷状态
	 */
	public String getLvState() {
		return lvState;
	}

	/**
	 * 逻辑卷状态设定
	 *
	 * @param lvState 逻辑卷状态
	 */
	public void setLvState(String lvState) {
		this.lvState = lvState;
	}

	/**
	 * 文件系统名取得
	 *
	 * @return 文件系统名
	 */
	public String getFsName() {
		return fsName;
	}

	/**
	 * 文件系统名设定
	 *
	 * @param fsName 文件系统名
	 */
	public void setFsName(String fsName) {
		this.fsName = fsName;
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
		return lvId;
	}

}