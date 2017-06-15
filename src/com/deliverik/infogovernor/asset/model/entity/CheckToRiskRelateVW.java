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
import com.deliverik.infogovernor.asset.model.CheckToRiskRelateVWInfo;

/**
  * 概述: 检查项到风险点关系模型实体
  * 功能描述: 检查项到风险点关系模型实体
  * 创建记录: 2014/07/23
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="CheckToRiskRelateVW")
public class CheckToRiskRelateVW extends BaseEntity implements Serializable,
		Cloneable, CheckToRiskRelateVWInfo {

	/** 主键 */
	@Id
	@TableGenerator(
		name="CHECKTORISKRELATEVW_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="CHECKTORISKRELATEVW_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="CHECKTORISKRELATEVW_TABLE_GENERATOR")
	protected Integer eiid;

	/** eid */
	protected String eid;

	/** 编号 */
	protected String eilabel;

	/** 风险级别 */
	protected String levels;

	/** 风险严重等级 */
	protected String grad;

	/** 检查项名称 */
	protected String einame;

	/** 风险点标志 */
	protected String risksign;

	/** 风险发生可能 */
	protected String poss;

	/** 检查项说明 */
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
	 * 风险级别取得
	 *
	 * @return 风险级别
	 */
	public String getLevels() {
		return levels;
	}

	/**
	 * 风险级别设定
	 *
	 * @param levels 风险级别
	 */
	public void setLevels(String levels) {
		this.levels = levels;
	}

	/**
	 * 风险严重等级取得
	 *
	 * @return 风险严重等级
	 */
	public String getGrad() {
		return grad;
	}

	/**
	 * 风险严重等级设定
	 *
	 * @param grad 风险严重等级
	 */
	public void setGrad(String grad) {
		this.grad = grad;
	}

	/**
	 * 检查项名称取得
	 *
	 * @return 检查项名称
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * 检查项名称设定
	 *
	 * @param einame 检查项名称
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**
	 * 风险点标志取得
	 *
	 * @return 风险点标志
	 */
	public String getRisksign() {
		return risksign;
	}

	/**
	 * 风险点标志设定
	 *
	 * @param risksign 风险点标志
	 */
	public void setRisksign(String risksign) {
		this.risksign = risksign;
	}

	/**
	 * 风险发生可能取得
	 *
	 * @return 风险发生可能
	 */
	public String getPoss() {
		return poss;
	}

	/**
	 * 风险发生可能设定
	 *
	 * @param poss 风险发生可能
	 */
	public void setPoss(String poss) {
		this.poss = poss;
	}

	/**
	 * 检查项说明取得
	 *
	 * @return 检查项说明
	 */
	public String getEidesc() {
		return eidesc;
	}

	/**
	 * 检查项说明设定
	 *
	 * @param eidesc 检查项说明
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