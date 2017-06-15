/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * ���̹�ϵʵ��ӿ�
 *
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="EMERGENCYRELATION")
public class EmergencyRelationTB extends BaseEntity implements Serializable, Cloneable, EmergencyRelationInfo {

	/** ���̹�ϵID */
	@Id
	@TableGenerator(
		    name="EMERGENCYRELATION_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="EMERGENCYRELATION_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="EMERGENCYRELATION_TABLE_GENERATOR")
	protected Integer erid;
	
	/** ��������ID */
	protected Integer parprid;

	/** ��������ID */
	protected Integer cldprid;
	
	/** ��ϵ����ʱ�� */
	protected String prrinstime;
	/**Ӧ��������������(1:��һ����else��ϳ���)*/
	protected String cldType;
	
	/** ��ϵ����  0������-����   1 Ӧ��ָ��-����  2 ����-Ӧ��ָ�� */
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
	 * ����ȡ��
	 * @return 
	 */
	public Serializable getPK() {
		return erid;
	}


	/**
	 * ��������IDȡ��
	 * 
	 * @return ��������ID
	 */
	public Integer getParprid() {
		return parprid;
	}

	/**
	 * ��������IDȡ��
	 * 
	 * @param parprid ��������ID
	 */
	public void setParprid(Integer parprid) {
		this.parprid = parprid;
	}

	/**
	 * ��������IDȡ��
	 * 
	 * @return ��������ID
	 */
	public Integer getCldprid() {
		return cldprid;
	}

	/**
	 * ��������IDȡ��
	 * 
	 * @param cldprid ��������ID
	 */
	public void setCldprid(Integer cldprid) {
		this.cldprid = cldprid;
	}

	/**
	 * ��ϵ����ʱ��ȡ��
	 * 
	 * @return ��ϵ����ʱ��
	 */
	public String getPrrinstime() {
		return prrinstime;
	}

	/**
	 * ��ϵ����ʱ��ȡ��
	 * 
	 * @param prrinstime ��ϵ����ʱ��
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
