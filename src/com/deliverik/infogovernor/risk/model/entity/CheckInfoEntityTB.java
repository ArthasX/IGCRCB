/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.risk.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.risk.model.CheckInfoEntityInfo;

/**
  * 概述: 检查策略关联资产表实体
  * 功能描述: 检查策略关联资产表实体
  * 创建记录: 2014/09/02
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="CheckInfoEntity")
public class CheckInfoEntityTB extends BaseEntity implements Serializable,
		Cloneable, CheckInfoEntityInfo {

	/** 主键 */
	@Id
	@TableGenerator(
		name="CHECKINFOENTITY_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="CHECKINFOENTITY_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="CHECKINFOENTITY_TABLE_GENERATOR")
	protected Integer cieid;

	/** 检查策略id */
	protected Integer csid;

	/** 资产id */
	protected Integer eiid;

	/** 资产版本 */
	protected Integer eiversion;

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getCieid() {
		return cieid;
	}

	/**
	 * 主键设定
	 *
	 * @param cieid 主键
	 */
	public void setCieid(Integer cieid) {
		this.cieid = cieid;
	}

	/**
	 * 检查策略id取得
	 *
	 * @return 检查策略id
	 */
	public Integer getCsid() {
		return csid;
	}

	/**
	 * 检查策略id设定
	 *
	 * @param csid 检查策略id
	 */
	public void setCsid(Integer csid) {
		this.csid = csid;
	}

	/**
	 * 资产id取得
	 *
	 * @return 资产id
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * 资产id设定
	 *
	 * @param eiid 资产id
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	/**
	 * 资产版本取得
	 *
	 * @return 资产版本
	 */
	public Integer getEiversion() {
		return eiversion;
	}

	/**
	 * 资产版本设定
	 *
	 * @param eiversion 资产版本
	 */
	public void setEiversion(Integer eiversion) {
		this.eiversion = eiversion;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return cieid;
	}

}