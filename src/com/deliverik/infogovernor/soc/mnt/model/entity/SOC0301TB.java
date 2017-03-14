/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.mnt.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.soc.mnt.model.SOC0301Info;
/**
  * 概述: DMX实时监控性能表实体dmxrealtime
  * 功能描述: DMX实时监控性能表实体dmxrealtime
  * 创建记录: 2012/05/16
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="SOC0301")
public class SOC0301TB extends BaseEntity implements Serializable,
		Cloneable, SOC0301Info{
	/** 主键 */
	@Id
	@GeneratedValue(generator = "id")
	@GenericGenerator(name = "id", strategy = "identity")
	protected Integer id;

	/** 监控任务id */
	protected Integer mtId;

	/** 监控对象名 */
	protected String mtoName;

	/** 性能指标 */
	protected String mtKpi;

	/** 性能指标值 */
	protected Double kpiValue;

	/** 解析时间点 */
	protected String timeStamp;

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 主键设定
	 *
	 * @param id 主键
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 监控任务id取得
	 *
	 * @return 监控任务id
	 */
	public Integer getMtId() {
		return mtId;
	}

	/**
	 * 监控任务id设定
	 *
	 * @param mtId 监控任务id
	 */
	public void setMtId(Integer mtId) {
		this.mtId = mtId;
	}

	/**
	 * 监控对象名取得
	 *
	 * @return 监控对象名
	 */
	public String getMtoName() {
		return mtoName;
	}

	/**
	 * 监控对象名设定
	 *
	 * @param mtoName 监控对象名
	 */
	public void setMtoName(String mtoName) {
		this.mtoName = mtoName;
	}

	/**
	 * 性能指标取得
	 *
	 * @return 性能指标
	 */
	public String getMtKpi() {
		return mtKpi;
	}

	/**
	 * 性能指标设定
	 *
	 * @param mtKpi 性能指标
	 */
	public void setMtKpi(String mtKpi) {
		this.mtKpi = mtKpi;
	}

	/**
	 * 性能指标值取得
	 *
	 * @return 性能指标值
	 */
	public Double getKpiValue() {
		return kpiValue;
	}

	/**
	 * 性能指标值设定
	 *
	 * @param kpiValue 性能指标值
	 */
	public void setKpiValue(Double kpiValue) {
		this.kpiValue = kpiValue;
	}

	/**
	 * 解析时间点取得
	 *
	 * @return 解析时间点
	 */
	public String getTimeStamp() {
		return timeStamp;
	}

	/**
	 * 解析时间点设定
	 *
	 * @param timeStamp 解析时间点
	 */
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return id;
	}

}