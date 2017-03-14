/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.soc.asset.model.IndicatorLightsSystemInfo;

/**
  * 概述: 告警系统显示信息表实体
  * 功能描述: 告警系统显示信息表实体
  * 创建记录: 2014/03/05
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="IndicatorLightsSystem")
public class IndicatorLightsSystemTB extends BaseEntity implements Serializable,
		Cloneable, IndicatorLightsSystemInfo {

	/** 无意思主键 */
	@Id
	@TableGenerator(
		name="INDICATORLIGHTSSYSTEM_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="INDICATORLIGHTSSYSTEM_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="INDICATORLIGHTSSYSTEM_TABLE_GENERATOR")
	protected Integer ilsid;

	/** 系统名称 */
	protected String ilsname;

	/** 位置X */
	protected Integer ilsplacex;

	/** 位置Y */
	protected Integer ilsplacey;

	/** 状态 */
	protected String ilsstatus;

	/**
	 * 无意思主键取得
	 *
	 * @return 无意思主键
	 */
	public Integer getIlsid() {
		return ilsid;
	}

	/**
	 * 无意思主键设定
	 *
	 * @param ilsid 无意思主键
	 */
	public void setIlsid(Integer ilsid) {
		this.ilsid = ilsid;
	}

	/**
	 * 系统名称取得
	 *
	 * @return 系统名称
	 */
	public String getIlsname() {
		return ilsname;
	}

	/**
	 * 系统名称设定
	 *
	 * @param ilsname 系统名称
	 */
	public void setIlsname(String ilsname) {
		this.ilsname = ilsname;
	}

	/**
	 * 位置X取得
	 *
	 * @return 位置X
	 */
	public Integer getIlsplacex() {
		return ilsplacex;
	}

	/**
	 * 位置X设定
	 *
	 * @param ilsplacex 位置X
	 */
	public void setIlsplacex(Integer ilsplacex) {
		this.ilsplacex = ilsplacex;
	}

	/**
	 * 位置Y取得
	 *
	 * @return 位置Y
	 */
	public Integer getIlsplacey() {
		return ilsplacey;
	}

	/**
	 * 位置Y设定
	 *
	 * @param ilsplacey 位置Y
	 */
	public void setIlsplacey(Integer ilsplacey) {
		this.ilsplacey = ilsplacey;
	}

	/**
	 * 状态取得
	 *
	 * @return 状态
	 */
	public String getIlsstatus() {
		return ilsstatus;
	}

	/**
	 * 状态设定
	 *
	 * @param ilsstatus 状态
	 */
	public void setIlsstatus(String ilsstatus) {
		this.ilsstatus = ilsstatus;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return ilsid;
	}

}