/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * ���ռ�������������ϵʵ��
 *
 * @author lipeng@deliverik.com
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="AuditCheckRelation")
public class AuditCheckRelationTB extends BaseEntity implements Serializable, Cloneable, AuditCheckRelation {

	/** ���ռ�������������ϵID */
	@Id
	@TableGenerator(
		    name="AUDITCHECKRELATION_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="AUDITCHECKRELATION_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="AUDITCHECKRELATION_TABLE_GENERATOR")
	protected Integer acrid;
	
	/** ���ռ��ID */
	protected Integer rcid;
	
	/** ���������ID */
	protected Integer radid;

	/** ������������� */
	protected String radcode;
	
	/**
	 * ����ȡ��
	 * @return 
	 */
	public Serializable getPK() {
		return acrid;
	}

	/**
	 * ���ռ���������ƹ�ϵIDȡ��
	 * @return ���ռ���������ƹ�ϵID
	 */
	public Integer getAcrid() {
		return acrid;
	}

	/**
	 * ���ռ���������ƹ�ϵID�趨
	 * @param acrid ���ռ���������ƹ�ϵID
	 */
	public void setAcrid(Integer acrid) {
		this.acrid = acrid;
	}

	/**
	 * ���ռ��IDȡ��
	 * @return ���ռ��ID
	 */
	public Integer getRcid() {
		return rcid;
	}

	/**
	 * ���ռ��ID�趨
	 * @param rcid ���ռ��ID
	 */
	public void setRcid(Integer rcid) {
		this.rcid = rcid;
	}

	/**
	 * ���������IDȡ��
	 * @return ���������ID
	 */
	public Integer getRadid() {
		return radid;
	}

	/**
	 * ���������ID�趨
	 * @param radid ���������ID
	 */
	public void setRadid(Integer radid) {
		this.radid = radid;
	}


	/**
	 * �������������ȡ��
	 * @return �������������
	 */
	public String getRadcode() {
		return radcode;
	}

	/**
	 * ��������������趨
	 * @param radcode �������������
	 */
	public void setRadcode(String radcode) {
		this.radcode = radcode;
	}
	
}
