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
import com.deliverik.infogovernor.soc.mnt.model.MonitorTaskObjectInfo;

/**
  * 概述: 监控任务对象表实体
  * 功能描述: 监控任务对象表实体
  * 创建记录: 2012/05/10
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="monitorTaskObject")
public class MonitorTaskObjectTB extends BaseEntity implements Serializable,
		Cloneable, MonitorTaskObjectInfo {

	/** 流水ID */
	@Id
	@TableGenerator(
		name="MONITORTASKOBJECT_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="MONITORTASKOBJECT_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="MONITORTASKOBJECT_TABLE_GENERATOR")
	protected Integer mtoId;

	/** 任务ID */
	protected Integer mtId;

	/** 对象名称 */
	protected String mtoName;

	/** 解析记录行数 */
	protected Integer mtoRow;

	/**
	 * 流水ID取得
	 *
	 * @return 流水ID
	 */
	public Integer getMtoId() {
		return mtoId;
	}

	/**
	 * 流水ID设定
	 *
	 * @param mtoId 流水ID
	 */
	public void setMtoId(Integer mtoId) {
		this.mtoId = mtoId;
	}

	/**
	 * 任务ID取得
	 *
	 * @return 任务ID
	 */
	public Integer getMtId() {
		return mtId;
	}

	/**
	 * 任务ID设定
	 *
	 * @param mtId 任务ID
	 */
	public void setMtId(Integer mtId) {
		this.mtId = mtId;
	}

	/**
	 * 对象名称取得
	 *
	 * @return 对象名称
	 */
	public String getMtoName() {
		return mtoName;
	}

	/**
	 * 对象名称设定
	 *
	 * @param mtoName 对象名称
	 */
	public void setMtoName(String mtoName) {
		this.mtoName = mtoName;
	}

	/**
	 * 解析记录行数取得
	 *
	 * @return 解析记录行数
	 */
	public Integer getMtoRow() {
		return mtoRow;
	}

	/**
	 * 解析记录行数设定
	 *
	 * @param mtoRow 解析记录行数
	 */
	public void setMtoRow(Integer mtoRow) {
		this.mtoRow = mtoRow;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return mtoId;
	}

}