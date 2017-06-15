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
import com.deliverik.infogovernor.risk.model.RiskAudit;

/**
 * 
 * �������ʵ��
 * @author lipeng@deliverik.com
 * 
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="RiskAudit")
public class RiskAuditTB extends BaseEntity implements Serializable, Cloneable, RiskAudit {
	/** �������ID */
	@Id
	@TableGenerator(
		    name="RISKAUDIT_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="RISKAUDIT_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="RISKAUDIT_TABLE_GENERATOR")
	protected Integer raid;

	/** ������ư汾 */
	protected String raversion;
	
	/** ������ƴ������� */
	protected String radate;
	
	/** ������ƴ�����ID */
	protected String rauserid;
	
	/** ������ƴ��������� */
	protected String rausername;

	/** ����������� */
	protected String radesc;
	
	/** �������״̬ */
	protected String rastatus;
	
	/** ������Ƹ���ʶ */
	protected String racode;
	
	/**
	 * ����ȡ��
	 * @return 
	 */
	public Serializable getPK() {
		return raid;
	}

	/**
	 * �������IDȡ��
	 * @return �������ID
	 */
	public Integer getRaid() {
		return raid;
	}

	/**
	 * �������ID�趨
	 * @param raid �������ID
	 */
	public void setRaid(Integer raid) {
		this.raid = raid;
	}

	/**
	 * ������ư汾ȡ��
	 * @return ������ư汾
	 */
	public String getRaversion() {
		return raversion;
	}

	/**
	 * ������ư汾�趨
	 * @param raversion ������ư汾
	 */
	public void setRaversion(String raversion) {
		this.raversion = raversion;
	}

	/**
	 * ������ƴ�������ȡ��
	 * @return ������ƴ�������
	 */
	public String getRadate() {
		return radate;
	}

	/**
	 * ������ƴ��������趨
	 * @param radate ������ƴ�������
	 */
	public void setRadate(String radate) {
		this.radate = radate;
	}

	/**
	 * �����������ȡ��
	 * @return �����������
	 */
	public String getRadesc() {
		return radesc;
	}

	/**
	 * ������������趨
	 * @param radesc �����������
	 */
	public void setRadesc(String radesc) {
		this.radesc = radesc;
	}

	/**
	 * �������״̬ȡ��
	 * @return �������״̬
	 */
	public String getRastatus() {
		return rastatus;
	}

	/**
	 * �������״̬�趨
	 * @param rastatus �������״̬
	 */
	public void setRastatus(String rastatus) {
		this.rastatus = rastatus;
	}

	/**
	 * ������ƴ�����IDȡ��
	 * @return ������ƴ�����ID
	 */
	public String getRauserid() {
		return rauserid;
	}

	/**
	 * ������ƴ�����ID�趨
	 * @param rauserid ������ƴ�����ID
	 */
	public void setRauserid(String rauserid) {
		this.rauserid = rauserid;
	}

	/**
	 * ������ƴ���������ȡ��
	 * @return ������ƴ���������
	 */
	public String getRausername() {
		return rausername;
	}

	/**
	 * ������ƴ����������趨
	 * @param rausername ������ƴ���������
	 */
	public void setRausername(String rausername) {
		this.rausername = rausername;
	}

	/**
	 * ������Ƹ���ʶȡ��
	 * @return ������Ƹ���ʶ
	 */
	public String getRacode() {
		return racode;
	}

	/**
	 * ������Ƹ���ʶ�趨
	 * @param racode ������Ƹ���ʶ
	 */
	public void setRacode(String racode) {
		this.racode = racode;
	}

}
