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
import com.deliverik.infogovernor.asset.model.RiskCheckVWInfo;

/**
  * 概述: 检查工作统计报表实体
  * 功能描述: 检查工作统计报表实体
  * 创建记录: 2014/07/22
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="RiskCheckVW")
public class RiskCheckVW extends BaseEntity implements Serializable,
		Cloneable, RiskCheckVWInfo {

	/** 主键 */
	@Id
	@TableGenerator(
		name="RISKCHECKVW_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="RISKCHECKVW_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="RISKCHECKVW_TABLE_GENERATOR")
	protected Integer eiid;

	/** eid */
	protected String eid;

	/** 编号 */
	protected String eilabel;

	/** 登记人id */
	protected String eiuserid;

	/** 登记人名字 */
	protected String eiusername;

	/** 检查项名称 */
	protected String einame;

	/** 检查频度 */
	protected String checkpd;

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
	 * 登记人id取得
	 *
	 * @return 登记人id
	 */
	public String getEiuserid() {
		return eiuserid;
	}

	/**
	 * 登记人id设定
	 *
	 * @param eiuserid 登记人id
	 */
	public void setEiuserid(String eiuserid) {
		this.eiuserid = eiuserid;
	}

	/**
	 * 登记人名字取得
	 *
	 * @return 登记人名字
	 */
	public String getEiusername() {
		return eiusername;
	}

	/**
	 * 登记人名字设定
	 *
	 * @param eiusername 登记人名字
	 */
	public void setEiusername(String eiusername) {
		this.eiusername = eiusername;
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
	 * 检查频度取得
	 *
	 * @return 检查频度
	 */
	public String getCheckpd() {
		return checkpd;
	}

	/**
	 * 检查频度设定
	 *
	 * @param checkpd 检查频度
	 */
	public void setCheckpd(String checkpd) {
		this.checkpd = checkpd;
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