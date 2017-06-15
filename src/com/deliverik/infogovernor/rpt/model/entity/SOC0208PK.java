/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;

/**
  * 概述: 事件变更服务效率实体主键
  * 功能描述: 事件变更服务效率实体主键
  * 创建记录: 2011/11/23
  * 修改记录: 2012/08/09 将ServeEfficiencyPK表名改为SOC0208PK
  */
@SuppressWarnings("serial")
public class SOC0208PK extends BasePK implements Serializable {

	/** 流程类型 */
	protected String prtype;

	/** 流程来源 */
	protected String pivaralue;

	/** 时间 */
	protected String efficiencyTime;

	/**
	 * 构造函数
	 */
	public SOC0208PK() {

	}

	/**
	 * 构造函数
	 */
	public SOC0208PK(String prtype, String pivaralue, String efficiencyTime) {
		super();
		this.prtype = prtype;
		this.pivaralue = pivaralue;
		this.efficiencyTime = efficiencyTime;
	}

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

}