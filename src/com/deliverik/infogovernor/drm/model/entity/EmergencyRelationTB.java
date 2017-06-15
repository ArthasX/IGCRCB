/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.drm.model.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.drm.model.EmergencyRelationInfo;

/**
 * 流程关系实体接口
 *
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="EMERGENCYRELATION")
public class EmergencyRelationTB extends BaseEntity implements Serializable, Cloneable, EmergencyRelationInfo {

	/** 流程关系ID */
	@Id
	@TableGenerator(
		    name="EMERGENCYRELATION_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="EMERGENCYRELATION_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="EMERGENCYRELATION_TABLE_GENERATOR")
	protected Integer erid;
	
	/** 主动流程ID */
	protected Integer parprid;

	/** 被动流程ID */
	protected Integer cldprid;
	
	/** 关系建立时间 */
	protected String prrinstime;
	/**应急处置流程类型(1:单一场景else组合场景)*/
	protected String cldType;
	
	/** 关系类型  0：演练-场景   1 应急指挥-场景  2 演练-应急指挥 */
	protected String relatetype;
	
	public String getRelatetype() {
		return relatetype;
	}


	public void setRelatetype(String relatetype) {
		this.relatetype = relatetype;
	}


	public String getCldType() {
		return cldType;
	}


	public void setCldType(String cldType) {
		this.cldType = cldType;
	}


	/**
	 * 主键取得
	 * @return 
	 */
	public Serializable getPK() {
		return erid;
	}


	/**
	 * 主动流程ID取得
	 * 
	 * @return 主动流程ID
	 */
	public Integer getParprid() {
		return parprid;
	}

	/**
	 * 主动流程ID取得
	 * 
	 * @param parprid 主动流程ID
	 */
	public void setParprid(Integer parprid) {
		this.parprid = parprid;
	}

	/**
	 * 被动流程ID取得
	 * 
	 * @return 被动流程ID
	 */
	public Integer getCldprid() {
		return cldprid;
	}

	/**
	 * 被动流程ID取得
	 * 
	 * @param cldprid 被动流程ID
	 */
	public void setCldprid(Integer cldprid) {
		this.cldprid = cldprid;
	}

	/**
	 * 关系建立时间取得
	 * 
	 * @return 关系建立时间
	 */
	public String getPrrinstime() {
		return prrinstime;
	}

	/**
	 * 关系建立时间取得
	 * 
	 * @param prrinstime 关系建立时间
	 */
	public void setPrrinstime(String prrinstime) {
		this.prrinstime = prrinstime;
	}


	public Integer getErid() {
		return erid;
	}


	public void setErid(Integer erid) {
		this.erid = erid;
	}



	
	
}
