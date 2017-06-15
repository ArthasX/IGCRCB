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
import com.deliverik.infogovernor.risk.model.CheckInfoRiskInfo;

/**
  * 概述: 检查策略关联检查项表实体
  * 功能描述: 检查策略关联检查项表实体
  * 创建记录: 2014/09/03
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="CheckInfoRisk")
public class CheckInfoRiskTB extends BaseEntity implements Serializable,
		Cloneable, CheckInfoRiskInfo {

	/** 主键 */
	@Id
	@TableGenerator(
		name="CHECKINFORISK_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="CHECKINFORISK_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="CHECKINFORISK_TABLE_GENERATOR")
	protected Integer cieid;

	/** 检查策略id */
	protected Integer csid;

	/** 检查项id */
	protected Integer rcid;

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
	 * 检查项id取得
	 *
	 * @return 检查项id
	 */
	public Integer getRcid() {
		return rcid;
	}

	/**
	 * 检查项id设定
	 *
	 * @param rcid 检查项id
	 */
	public void setRcid(Integer rcid) {
		this.rcid = rcid;
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