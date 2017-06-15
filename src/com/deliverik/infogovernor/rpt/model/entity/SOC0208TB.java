/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.rpt.model.SOC0208Info;

/**
  * 概述: 事件变更服务效率实体
  * 功能描述: 事件变更服务效率实体
  * 创建记录: 2011/11/23
  * 修改记录: 2012/08/09 将ServeEfficiencyTB表名改为SOC0208TB
  */
@SuppressWarnings("serial")
@Entity
@IdClass(SOC0208PK.class)
@Table(name="SOC0208")
public class SOC0208TB extends BaseEntity implements Serializable,
		Cloneable, SOC0208Info {

	/** 流程类型 */
	@Id
	protected String prtype;

	/** 流程来源 */
	@Id
	protected String pivaralue;

	/** 时间 */
	@Id
	protected String efficiencyTime;

	/** 当前月服务效率 */
	protected String monthEfficiency;

	/** 历史服务效率 */
	protected String historyEfficiency;

	/**
	 * 流程类型取得
	 *
	 * @return 流程类型
	 */
	public String getPrtype() {
		return prtype;
	}

	/**
	 * 流程类型设定
	 *
	 * @param prtype 流程类型
	 */
	public void setPrtype(String prtype) {
		this.prtype = prtype;
	}

	/**
	 * 流程来源取得
	 *
	 * @return 流程来源
	 */
	public String getPivaralue() {
		return pivaralue;
	}

	/**
	 * 流程来源设定
	 *
	 * @param pivaralue 流程来源
	 */
	public void setPivaralue(String pivaralue) {
		this.pivaralue = pivaralue;
	}

	/**
	 * 时间取得
	 *
	 * @return 时间
	 */
	public String getEfficiencyTime() {
		return efficiencyTime;
	}

	/**
	 * 时间设定
	 *
	 * @param efficiencyTime 时间
	 */
	public void setEfficiencyTime(String efficiencyTime) {
		this.efficiencyTime = efficiencyTime;
	}

	/**
	 * 当前月服务效率取得
	 *
	 * @return 当前月服务效率
	 */
	public String getMonthEfficiency() {
		return monthEfficiency;
	}

	/**
	 * 当前月服务效率设定
	 *
	 * @param monthEfficiency 当前月服务效率
	 */
	public void setMonthEfficiency(String monthEfficiency) {
		this.monthEfficiency = monthEfficiency;
	}

	/**
	 * 历史服务效率取得
	 *
	 * @return 历史服务效率
	 */
	public String getHistoryEfficiency() {
		return historyEfficiency;
	}

	/**
	 * 历史服务效率设定
	 *
	 * @param historyEfficiency 历史服务效率
	 */
	public void setHistoryEfficiency(String historyEfficiency) {
		this.historyEfficiency = historyEfficiency;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return new SOC0208PK(prtype, pivaralue, efficiencyTime);
	}

}