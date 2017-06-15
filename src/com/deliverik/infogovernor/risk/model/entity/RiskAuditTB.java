/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.risk.model.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.risk.model.RiskAudit;

/**
 * 
 * 风险审计实体
 * @author lipeng@deliverik.com
 * 
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="RiskAudit")
public class RiskAuditTB extends BaseEntity implements Serializable, Cloneable, RiskAudit {
	/** 风险审计ID */
	@Id
	@TableGenerator(
		    name="RISKAUDIT_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="RISKAUDIT_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="RISKAUDIT_TABLE_GENERATOR")
	protected Integer raid;

	/** 风险审计版本 */
	protected String raversion;
	
	/** 风险审计创建日期 */
	protected String radate;
	
	/** 风险审计创建人ID */
	protected String rauserid;
	
	/** 风险审计创建人姓名 */
	protected String rausername;

	/** 风险审计描述 */
	protected String radesc;
	
	/** 风险审计状态 */
	protected String rastatus;
	
	/** 风险审计根标识 */
	protected String racode;
	
	/**
	 * 主键取得
	 * @return 
	 */
	public Serializable getPK() {
		return raid;
	}

	/**
	 * 风险审计ID取得
	 * @return 风险审计ID
	 */
	public Integer getRaid() {
		return raid;
	}

	/**
	 * 风险审计ID设定
	 * @param raid 风险审计ID
	 */
	public void setRaid(Integer raid) {
		this.raid = raid;
	}

	/**
	 * 风险审计版本取得
	 * @return 风险审计版本
	 */
	public String getRaversion() {
		return raversion;
	}

	/**
	 * 风险审计版本设定
	 * @param raversion 风险审计版本
	 */
	public void setRaversion(String raversion) {
		this.raversion = raversion;
	}

	/**
	 * 风险审计创建日期取得
	 * @return 风险审计创建日期
	 */
	public String getRadate() {
		return radate;
	}

	/**
	 * 风险审计创建日期设定
	 * @param radate 风险审计创建日期
	 */
	public void setRadate(String radate) {
		this.radate = radate;
	}

	/**
	 * 风险审计描述取得
	 * @return 风险审计描述
	 */
	public String getRadesc() {
		return radesc;
	}

	/**
	 * 风险审计描述设定
	 * @param radesc 风险审计描述
	 */
	public void setRadesc(String radesc) {
		this.radesc = radesc;
	}

	/**
	 * 风险审计状态取得
	 * @return 风险审计状态
	 */
	public String getRastatus() {
		return rastatus;
	}

	/**
	 * 风险审计状态设定
	 * @param rastatus 风险审计状态
	 */
	public void setRastatus(String rastatus) {
		this.rastatus = rastatus;
	}

	/**
	 * 风险审计创建人ID取得
	 * @return 风险审计创建人ID
	 */
	public String getRauserid() {
		return rauserid;
	}

	/**
	 * 风险审计创建人ID设定
	 * @param rauserid 风险审计创建人ID
	 */
	public void setRauserid(String rauserid) {
		this.rauserid = rauserid;
	}

	/**
	 * 风险审计创建人姓名取得
	 * @return 风险审计创建人姓名
	 */
	public String getRausername() {
		return rausername;
	}

	/**
	 * 风险审计创建人姓名设定
	 * @param rausername 风险审计创建人姓名
	 */
	public void setRausername(String rausername) {
		this.rausername = rausername;
	}

	/**
	 * 风险审计根标识取得
	 * @return 风险审计根标识
	 */
	public String getRacode() {
		return racode;
	}

	/**
	 * 风险审计根标识设定
	 * @param racode 风险审计根标识
	 */
	public void setRacode(String racode) {
		this.racode = racode;
	}

}
