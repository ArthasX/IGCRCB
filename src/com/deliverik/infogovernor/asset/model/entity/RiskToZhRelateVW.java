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
import com.deliverik.infogovernor.asset.model.RiskToZhRelateVWInfo;

/**
  * 概述: 风险到指标关系实体
  * 功能描述: 风险到指标关系实体
  * 创建记录: 2014/07/24
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="RiskToZhRelateVW")
public class RiskToZhRelateVW extends BaseEntity implements Serializable,
		Cloneable, RiskToZhRelateVWInfo {

	/** 主键 */
	@Id
	@TableGenerator(
		name="RISKTOZHRELATEVW_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="RISKTOZHRELATEVW_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="RISKTOZHRELATEVW_TABLE_GENERATOR")
	protected Integer eiid;

	/** eid */
	protected String eid;

	/** 编号 */
	protected String eilabel;

	/** 阀值 */
	protected String threshold;

	/** 风险指标名称 */
	protected String einame;

	/** 是否关键指标 */
	protected String keyindex;

	/** 风险指标说明 */
	protected String eidesc;

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * 主键设定
	 *
	 * @param eiid 主键
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	/**
	 * eid取得
	 *
	 * @return eid
	 */
	public String getEid() {
		return eid;
	}

	/**
	 * eid设定
	 *
	 * @param eid eid
	 */
	public void setEid(String eid) {
		this.eid = eid;
	}

	/**
	 * 编号取得
	 *
	 * @return 编号
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * 编号设定
	 *
	 * @param eilabel 编号
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	/**
	 * 阀值取得
	 *
	 * @return 阀值
	 */
	public String getThreshold() {
		return threshold;
	}

	/**
	 * 阀值设定
	 *
	 * @param threshold 阀值
	 */
	public void setThreshold(String threshold) {
		this.threshold = threshold;
	}

	/**
	 * 风险指标名称取得
	 *
	 * @return 风险指标名称
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * 风险指标名称设定
	 *
	 * @param einame 风险指标名称
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**
	 * 是否关键指标取得
	 *
	 * @return 是否关键指标
	 */
	public String getKeyindex() {
		return keyindex;
	}

	/**
	 * 是否关键指标设定
	 *
	 * @param keyindex 是否关键指标
	 */
	public void setKeyindex(String keyindex) {
		this.keyindex = keyindex;
	}

	/**
	 * 风险指标说明取得
	 *
	 * @return 风险指标说明
	 */
	public String getEidesc() {
		return eidesc;
	}

	/**
	 * 风险指标说明设定
	 *
	 * @param eidesc 风险指标说明
	 */
	public void setEidesc(String eidesc) {
		this.eidesc = eidesc;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return eiid;
	}

}