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
import com.deliverik.infogovernor.risk.model.RiskAuditIns;

/**
 * ������Ʒ���ʵ��
 * @author lipeng@deliverik.com
 *
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="RiskAuditIns")
public class RiskAuditInsTB extends BaseEntity implements Serializable, Cloneable, RiskAuditIns {

	/** ������Ʒ���ID */
	@Id
	@TableGenerator(
		    name="RISKAUDITINS_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="RISKAUDITINS_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="RISKAUDITINS_TABLE_GENERATOR")
	protected Integer raiid;
	
	/** �������ID */
	protected Integer raid;

	/** ������ư汾 */
	protected String raversion;
	
	/** ������Ʒ����� */
	protected String raicode;
	
	/** ������Ʒ��𴴽����� */
	protected String raistart;
	
	/** ������Ʒ���������� */
	protected String raiend;
	
	/** ������Ʒ������� */
	protected String raidesc;
	
	/** ������Ʒ���״̬ */
	protected String raistatus;
	
	/**
	 * ����ȡ��
	 * @return 
	 */
	public Serializable getPK() {
		return raiid;
	}

	/**
	 * ������Ʒ���IDȡ��
	 * @return ������Ʒ���ID
	 */
	public Integer getRaiid() {
		return raiid;
	}

	/**
	 * ������Ʒ���ID�趨
	 * @param raiid ������Ʒ���ID
	 */
	public void setRaiid(Integer raiid) {
		this.raiid = raiid;
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
	 * ������Ʒ��𴴽�����ȡ��
	 * @return ������Ʒ��𴴽�����
	 */
	public String getRaistart() {
		return raistart;
	}

	/**
	 * ������Ʒ��𴴽������趨
	 * @param raistart ������Ʒ��𴴽�����
	 */
	public void setRaistart(String raistart) {
		this.raistart = raistart;
	}

	/**
	 * ������Ʒ����������ȡ��
	 * @return ������Ʒ����������
	 */
	public String getRaiend() {
		return raiend;
	}

	/**
	 * ������Ʒ�����������趨
	 * @param raiend ������Ʒ����������
	 */
	public void setRaiend(String raiend) {
		this.raiend = raiend;
	}

	/**
	 * ������Ʒ�������ȡ��
	 * @return ������Ʒ�������
	 */
	public String getRaidesc() {
		return raidesc;
	}

	/**
	 * ������Ʒ��������趨
	 * @param raidesc ������Ʒ�������
	 */
	public void setRaidesc(String raidesc) {
		this.raidesc = raidesc;
	}

	/**
	 * ������Ʒ���״̬ȡ��
	 * @return ������Ʒ���״̬
	 */
	public String getRaistatus() {
		return raistatus;
	}

	/**
	 * ������Ʒ���״̬�趨
	 * @param raistatus ������Ʒ���״̬
	 */
	public void setRaistatus(String raistatus) {
		this.raistatus = raistatus;
	}

	/**
	 * ������Ʒ�����ȡ��
	 * @return ������Ʒ�����
	 */
	public String getRaicode() {
		return raicode;
	}

	/**
	 * ������Ʒ������趨
	 * @param raicode ������Ʒ�����
	 */
	public void setRaicode(String raicode) {
		this.raicode = raicode;
	}
	
}
