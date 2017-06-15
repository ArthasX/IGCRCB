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
import com.deliverik.infogovernor.risk.model.AuditCheckRelation;

/**
 * 风险检查与风险审计项关系实体
 *
 * @author lipeng@deliverik.com
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="AuditCheckRelation")
public class AuditCheckRelationTB extends BaseEntity implements Serializable, Cloneable, AuditCheckRelation {

	/** 风险检查与风险审计项关系ID */
	@Id
	@TableGenerator(
		    name="AUDITCHECKRELATION_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="AUDITCHECKRELATION_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="AUDITCHECKRELATION_TABLE_GENERATOR")
	protected Integer acrid;
	
	/** 风险检查ID */
	protected Integer rcid;
	
	/** 风险审计项ID */
	protected Integer radid;

	/** 风险审计项层次码 */
	protected String radcode;
	
	/**
	 * 主键取得
	 * @return 
	 */
	public Serializable getPK() {
		return acrid;
	}

	/**
	 * 风险检查与风险审计关系ID取得
	 * @return 风险检查与风险审计关系ID
	 */
	public Integer getAcrid() {
		return acrid;
	}

	/**
	 * 风险检查与风险审计关系ID设定
	 * @param acrid 风险检查与风险审计关系ID
	 */
	public void setAcrid(Integer acrid) {
		this.acrid = acrid;
	}

	/**
	 * 风险检查ID取得
	 * @return 风险检查ID
	 */
	public Integer getRcid() {
		return rcid;
	}

	/**
	 * 风险检查ID设定
	 * @param rcid 风险检查ID
	 */
	public void setRcid(Integer rcid) {
		this.rcid = rcid;
	}

	/**
	 * 风险审计项ID取得
	 * @return 风险审计项ID
	 */
	public Integer getRadid() {
		return radid;
	}

	/**
	 * 风险审计项ID设定
	 * @param radid 风险审计项ID
	 */
	public void setRadid(Integer radid) {
		this.radid = radid;
	}


	/**
	 * 风险审计项层次码取得
	 * @return 风险审计项层次码
	 */
	public String getRadcode() {
		return radcode;
	}

	/**
	 * 风险审计项层次码设定
	 * @param radcode 风险审计项层次码
	 */
	public void setRadcode(String radcode) {
		this.radcode = radcode;
	}
	
}
