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
import com.deliverik.infogovernor.soc.mnt.model.MonitorTypeInfo;

/**
  * 概述: 监控类型表实体
  * 功能描述: 监控类型表实体
  * 创建记录: 2012/02/08
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="monitorType", schema="cst")
public class MonitorTypeTB extends BaseEntity implements Serializable,
		Cloneable, MonitorTypeInfo {

	/** 主键id */
	@Id
	@TableGenerator(
		name="MONITORTYPE_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="MONITORTYPE_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="MONITORTYPE_TABLE_GENERATOR")
	protected Integer mtId;

	/** 监控类型名称 */
	protected String mtName;

	/** 创建时间 */
	protected String mtCreateTime;

	/** 树形层次码 */
	protected String mtSyscoding;

	/** 状态 */
	protected String deleteFlag;

	/**
	 * 主键id取得
	 *
	 * @return 主键id
	 */
	public Integer getMtId() {
		return mtId;
	}

	/**
	 * 主键id设定
	 *
	 * @param mtId 主键id
	 */
	public void setMtId(Integer mtId) {
		this.mtId = mtId;
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
	 * 创建时间取得
	 *
	 * @return 创建时间
	 */
	public String getMtCreateTime() {
		return mtCreateTime;
	}

	/**
	 * 创建时间设定
	 *
	 * @param mtCreateTime 创建时间
	 */
	public void setMtCreateTime(String mtCreateTime) {
		this.mtCreateTime = mtCreateTime;
	}

	/**
	 * 树形层次码取得
	 *
	 * @return 树形层次码
	 */
	public String getMtSyscoding() {
		return mtSyscoding;
	}

	/**
	 * 树形层次码设定
	 *
	 * @param mtSyscoding 树形层次码
	 */
	public void setMtSyscoding(String mtSyscoding) {
		this.mtSyscoding = mtSyscoding;
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
		return mtId;
	}

}