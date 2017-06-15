/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.ven.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.ven.model.StrategyIndexRelationInfo;

/**
  * 概述: 风险策略指标关系表实体
  * 功能描述: 风险策略指标关系表实体
  * 创建记录: 2014/12/01
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="StrategyIndexRelation")
public class StrategyIndexRelationTB extends BaseEntity implements Serializable,
		Cloneable, StrategyIndexRelationInfo {

	/** 主键 */
	@Id
	@TableGenerator(
		name="STRATEGYINDEXRELATION_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="STRATEGYINDEXRELATION_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="STRATEGYINDEXRELATION_TABLE_GENERATOR")
	protected Integer sirid;

	/** 风险策略id */
	protected Integer rsid;

	/** 风险指标id */
	protected Integer riid;

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getSirid() {
		return sirid;
	}

	/**
	 * 主键设定
	 *
	 * @param sirid 主键
	 */
	public void setSirid(Integer sirid) {
		this.sirid = sirid;
	}

	/**
	 * 风险策略id取得
	 *
	 * @return 风险策略id
	 */
	public Integer getRsid() {
		return rsid;
	}

	/**
	 * 风险策略id设定
	 *
	 * @param rsid 风险策略id
	 */
	public void setRsid(Integer rsid) {
		this.rsid = rsid;
	}

	/**
	 * 风险指标id取得
	 *
	 * @return 风险指标id
	 */
	public Integer getRiid() {
		return riid;
	}

	/**
	 * 风险指标id设定
	 *
	 * @param riid 风险指标id
	 */
	public void setRiid(Integer riid) {
		this.riid = riid;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return sirid;
	}

}