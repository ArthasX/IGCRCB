/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.mnt.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.infogovernor.soc.mnt.model.MonitorObjectDefVWInfo;

/**
  * 概述: 监控对象KPI信息视图实体
  * 功能描述: 监控对象KPI信息视图实体
  * 创建记录: 2012/02/13
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(schema="cst")
public class MonitorObjectDefVW implements Serializable,
		Cloneable, MonitorObjectDefVWInfo {

	/** 主键id */
	@Id
	protected Integer modid;

	/** 监控对象名称 */
	protected String moName;

	/** 监控类型名称 */
	protected String mtName;

	/** 监控类型层次码 */
	protected String mtSyscoding;

	/** 创建时间 */
	protected String modCreateTime;

	/** 监控对象阀值名称 */
	protected String modName;

	/** 监控对象阀值 */
	protected String modValue;
	
	/** 比较符号 */
	protected String compare;

	/** 排序号 */
	protected Integer orderNumber;
	
	/** 描述 */
	protected String modDes;

	/** 状态 */
	protected String deleteFlag;

	/**
	 * 主键id取得
	 *
	 * @return 主键id
	 */
	public Integer getModid() {
		return modid;
	}

	/**
	 * 主键id设定
	 *
	 * @param modid 主键id
	 */
	public void setModid(Integer modid) {
		this.modid = modid;
	}

	/**
	 * 监控对象名称取得
	 *
	 * @return 监控对象名称
	 */
	public String getMoName() {
		return moName;
	}

	/**
	 * 监控对象名称设定
	 *
	 * @param moName 监控对象名称
	 */
	public void setMoName(String moName) {
		this.moName = moName;
	}

	/**
	 * 监控类型名称取得
	 *
	 * @return 监控类型名称
	 */
	public String getMtName() {
		return mtName;
	}

	/**
	 * 监控类型名称设定
	 *
	 * @param mtName 监控类型名称
	 */
	public void setMtName(String mtName) {
		this.mtName = mtName;
	}

	/**
	 * 监控类型层次码取得
	 *
	 * @return 监控类型层次码
	 */
	public String getMtSyscoding() {
		return mtSyscoding;
	}

	/**
	 * 监控类型层次码设定
	 *
	 * @param mtSyscoding 监控类型层次码
	 */
	public void setMtSyscoding(String mtSyscoding) {
		this.mtSyscoding = mtSyscoding;
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
	 * 比较符号取得
	 * @return 比较符号
	 */
	public String getCompare() {
		return compare;
	}

	/**
	 * 比较符号设定
	 * @param compare比较符号
	 */
	public void setCompare(String compare) {
		this.compare = compare;
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

}