/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.mnt.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.soc.mnt.model.MonitorObjectDefInfo;

/**
  * 概述: 监控对象阀值信息表实体
  * 功能描述: 监控对象阀值信息表实体
  * 创建记录: 2012/02/07
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="monitorObjectDef", schema="cst")
public class MonitorObjectDefTB extends BaseEntity implements Serializable,
		Cloneable, MonitorObjectDefInfo {

	/** 主键id */
	@Id
	@TableGenerator(
		name="MONITOROBJECTDEF_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="MONITOROBJECTDEF_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="MONITOROBJECTDEF_TABLE_GENERATOR")
	protected Integer modId;

	/** 监控对象id */
	protected Integer moId;

	/** 创建时间 */
	protected String modCreateTime;

	/** 监控对象阀值名称 */
	protected String modName;

	/** 监控对象阀值 */
	protected String modValue;

	/** 排序号 */
	protected Integer orderNumber;

	/** 状态 */
	protected String deleteFlag;

	/** 描述 */
	protected String modDes;
	
	/** 比较符 */
	protected String compare;
	
	/**
	 * 主键id取得
	 *
	 * @return 主键id
	 */
	public Integer getModId() {
		return modId;
	}

	/**
	 * 主键id设定
	 *
	 * @param modId 主键id
	 */
	public void setModId(Integer modId) {
		this.modId = modId;
	}

	/**
	 * 监控对象id取得
	 *
	 * @return 监控对象id
	 */
	public Integer getMoId() {
		return moId;
	}

	/**
	 * 监控对象id设定
	 *
	 * @param moId 监控对象id
	 */
	public void setMoId(Integer moId) {
		this.moId = moId;
	}

	/**
	 * 创建时间取得
	 *
	 * @return 创建时间
	 */
	public String getModCreateTime() {
		return modCreateTime;
	}

	/**
	 * 创建时间设定
	 *
	 * @param modCreateTime 创建时间
	 */
	public void setModCreateTime(String modCreateTime) {
		this.modCreateTime = modCreateTime;
	}

	/**
	 * 监控对象阀值名称取得
	 *
	 * @return 监控对象阀值名称
	 */
	public String getModName() {
		return modName;
	}

	/**
	 * 监控对象阀值名称设定
	 *
	 * @param modName 监控对象阀值名称
	 */
	public void setModName(String modName) {
		this.modName = modName;
	}

	/**
	 * 监控对象阀值取得
	 *
	 * @return 监控对象阀值
	 */
	public String getModValue() {
		return modValue;
	}

	/**
	 * 监控对象阀值设定
	 *
	 * @param modValue 监控对象阀值
	 */
	public void setModValue(String modValue) {
		this.modValue = modValue;
	}

	/**
	 * 排序号取得
	 *
	 * @return 排序号
	 */
	public Integer getOrderNumber() {
		return orderNumber;
	}

	/**
	 * 排序号设定
	 *
	 * @param orderNumber 排序号
	 */
	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}

	/**
	 * 状态取得
	 *
	 * @return 状态
	 */
	public String getDeleteFlag() {
		return deleteFlag;
	}

	/**
	 * 状态设定
	 *
	 * @param deleteFlag 状态
	 */
	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return modId;
	}

	/**
	 * 描述取得
	 * @return
	 */
	public String getModDes() {
		return modDes;
	}

	/**
	 * 描述获取
	 * @param modDes
	 */
	public void setModDes(String modDes) {
		this.modDes = modDes;
	}

	/**
	 * 比较符取得
	 * @return
	 */
	public String getCompare() {
		return compare;
	}

	/**
	 * 比较符设定
	 * @param compare
	 */
	public void setCompare(String compare) {
		this.compare = compare;
	}

}