/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.asset.model.MaintenanceInfo;

/**
  * 概述: 风险指标维护实体
  * 功能描述: 风险指标维护实体
  * 创建记录: 2014/07/25
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="maintenance")
public class MaintenanceTB extends BaseEntity implements Serializable,
		Cloneable, MaintenanceInfo {

	/** 风险指标维护ID */
	@Id
	@TableGenerator(
		name="MAINTENANCE_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="MAINTENANCE_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="MAINTENANCE_TABLE_GENERATOR")
	protected Integer RIMID;

	/** 风险指标ID */
	protected Integer RIID;

	/** 风险指标分类 */
	protected String RIMTYPE;

	/** 风险指标说明 */
	protected String RIMDESC;

	/** 指标维护语句 */
	protected String RIMSQL;

	/**
	 * 风险指标维护ID取得
	 *
	 * @return 风险指标维护ID
	 */
	public Integer getRIMID() {
		return RIMID;
	}

	/**
	 * 风险指标维护ID设定
	 *
	 * @param RIMID 风险指标维护ID
	 */
	public void setRIMID(Integer RIMID) {
		this.RIMID = RIMID;
	}

	/**
	 * 风险指标ID取得
	 *
	 * @return 风险指标ID
	 */
	public Integer getRIID() {
		return RIID;
	}

	/**
	 * 风险指标ID设定
	 *
	 * @param RIID 风险指标ID
	 */
	public void setRIID(Integer RIID) {
		this.RIID = RIID;
	}

	/**
	 * 风险指标分类取得
	 *
	 * @return 风险指标分类
	 */
	public String getRIMTYPE() {
		return RIMTYPE;
	}

	/**
	 * 风险指标分类设定
	 *
	 * @param RIMTYPE 风险指标分类
	 */
	public void setRIMTYPE(String RIMTYPE) {
		this.RIMTYPE = RIMTYPE;
	}

	/**
	 * 风险指标说明取得
	 *
	 * @return 风险指标说明
	 */
	public String getRIMDESC() {
		return RIMDESC;
	}

	/**
	 * 风险指标说明设定
	 *
	 * @param RIMDESC 风险指标说明
	 */
	public void setRIMDESC(String RIMDESC) {
		this.RIMDESC = RIMDESC;
	}

	/**
	 * 指标维护语句取得
	 *
	 * @return 指标维护语句
	 */
	public String getRIMSQL() {
		return RIMSQL;
	}

	/**
	 * 指标维护语句设定
	 *
	 * @param RIMSQL 指标维护语句
	 */
	public void setRIMSQL(String RIMSQL) {
		this.RIMSQL = RIMSQL;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return RIMID;
	}

}