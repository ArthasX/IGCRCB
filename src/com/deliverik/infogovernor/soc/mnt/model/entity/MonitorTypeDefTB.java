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
import com.deliverik.infogovernor.soc.mnt.model.MonitorTypeDefInfo;

/**
  * 概述: 监控类型阀值信息实体
  * 功能描述: 监控类型阀值信息实体
  * 创建记录: 2012/02/07
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="monitorTypeDef", schema="cst")
public class MonitorTypeDefTB extends BaseEntity implements Serializable,
		Cloneable, MonitorTypeDefInfo {

	/** 主键id */
	@Id
	@TableGenerator(
		name="MONITORTYPEDEF_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="MONITORTYPEDEF_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="MONITORTYPEDEF_TABLE_GENERATOR")
	protected Integer mtdId;

	/** 监控类型id */
	protected Integer mtId;

	/** 阀值名称 */
	protected String mtdName;

	/** 阀值 */
	protected String mtdValue;

	/** 创建时间 */
	protected String mtdCreateTime;

	/** 排序号 */
	protected Integer orderNumber;

	/** 状态 */
	protected String deleteFlag;

	/** 描述*/
	protected String mtdDes;
	
	/** 比较符*/
	protected String compare;
	
	/**
	 * 主键id取得
	 *
	 * @return 主键id
	 */
	public Integer getMtdId() {
		return mtdId;
	}

	/**
	 * 主键id设定
	 *
	 * @param mtdId 主键id
	 */
	public void setMtdId(Integer mtdId) {
		this.mtdId = mtdId;
	}

	/**
	 * 监控类型id取得
	 *
	 * @return 监控类型id
	 */
	public Integer getMtId() {
		return mtId;
	}

	/**
	 * 监控类型id设定
	 *
	 * @param mtId 监控类型id
	 */
	public void setMtId(Integer mtId) {
		this.mtId = mtId;
	}

	/**
	 * 阀值名称取得
	 *
	 * @return 阀值名称
	 */
	public String getMtdName() {
		return mtdName;
	}

	/**
	 * 阀值名称设定
	 *
	 * @param mtdName 阀值名称
	 */
	public void setMtdName(String mtdName) {
		this.mtdName = mtdName;
	}

	/**
	 * 阀值取得
	 *
	 * @return 阀值
	 */
	public String getMtdValue() {
		return mtdValue;
	}

	/**
	 * 阀值设定
	 *
	 * @param mtdValue 阀值
	 */
	public void setMtdValue(String mtdValue) {
		this.mtdValue = mtdValue;
	}

	/**
	 * 创建时间取得
	 *
	 * @return 创建时间
	 */
	public String getMtdCreateTime() {
		return mtdCreateTime;
	}

	/**
	 * 创建时间设定
	 *
	 * @param mtdCreateTime 创建时间
	 */
	public void setMtdCreateTime(String mtdCreateTime) {
		this.mtdCreateTime = mtdCreateTime;
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
		return mtdId;
	}

	/**
	 * 描述取得
	 * @return
	 */
	public String getMtdDes() {
		return mtdDes;
	}

	/**
	 * 描述设定
	 * @param mtdDes
	 */
	public void setMtdDes(String mtdDes) {
		this.mtdDes = mtdDes;
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