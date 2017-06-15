/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.ven.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.ven.model.RiskStrategyInfo;

/**
  * ����: ���ղ��Ա�ʵ��
  * ��������: ���ղ��Ա�ʵ��
  * ������¼: 2014/12/01
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="RiskStrategy")
public class RiskStrategyTB extends BaseEntity implements Serializable,
		Cloneable, RiskStrategyInfo {

	/** ���� */
	@Id
	@TableGenerator(
		name="RISKSTRATEGY_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="RISKSTRATEGY_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="RISKSTRATEGY_TABLE_GENERATOR")
	protected Integer rsid;

	/** ���ղ������� */
	protected String rsname;

	/** ���ղ������� */
	protected String rsdesc;

	/** ���Կ�ʼʱ�� */
	protected String rsstartdate;

	/** ���Խ���ʱ�� */
	protected String rsenddate;

	/** ״̬(1.����2.ͣ��) */
	protected String rsstatus;

	/** ���ռ��Ƶ�� */
	protected String rsfrequency;

	/** ���ռ��Ƶ������ */
	protected String rsfrequencydesc;

	/** ���ղ���ָ���ϵ��id */
	protected Integer sirid;

	/** ���� */
	protected String rsattachkey;

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getRsid() {
		return rsid;
	}

	/**
	 * �����趨
	 *
	 * @param rsid ����
	 */
	public void setRsid(Integer rsid) {
		this.rsid = rsid;
	}

	/**
	 * ���ղ�������ȡ��
	 *
	 * @return ���ղ�������
	 */
	public String getRsname() {
		return rsname;
	}

	/**
	 * ���ղ��������趨
	 *
	 * @param rsname ���ղ�������
	 */
	public void setRsname(String rsname) {
		this.rsname = rsname;
	}

	/**
	 * ���ղ�������ȡ��
	 *
	 * @return ���ղ�������
	 */
	public String getRsdesc() {
		return rsdesc;
	}

	/**
	 * ���ղ��������趨
	 *
	 * @param rsdesc ���ղ�������
	 */
	public void setRsdesc(String rsdesc) {
		this.rsdesc = rsdesc;
	}

	/**
	 * ���Կ�ʼʱ��ȡ��
	 *
	 * @return ���Կ�ʼʱ��
	 */
	public String getRsstartdate() {
		return rsstartdate;
	}

	/**
	 * ���Կ�ʼʱ���趨
	 *
	 * @param rsstartdate ���Կ�ʼʱ��
	 */
	public void setRsstartdate(String rsstartdate) {
		this.rsstartdate = rsstartdate;
	}

	/**
	 * ���Խ���ʱ��ȡ��
	 *
	 * @return ���Խ���ʱ��
	 */
	public String getRsenddate() {
		return rsenddate;
	}

	/**
	 * ���Խ���ʱ���趨
	 *
	 * @param rsenddate ���Խ���ʱ��
	 */
	public void setRsenddate(String rsenddate) {
		this.rsenddate = rsenddate;
	}

	/**
	 * ״̬(1.����2.ͣ��)ȡ��
	 *
	 * @return ״̬(1.����2.ͣ��)
	 */
	public String getRsstatus() {
		return rsstatus;
	}

	/**
	 * ״̬(1.����2.ͣ��)�趨
	 *
	 * @param rsstatus ״̬(1.����2.ͣ��)
	 */
	public void setRsstatus(String rsstatus) {
		this.rsstatus = rsstatus;
	}

	/**
	 * ���ռ��Ƶ��ȡ��
	 *
	 * @return ���ռ��Ƶ��
	 */
	public String getRsfrequency() {
		return rsfrequency;
	}

	/**
	 * ���ռ��Ƶ���趨
	 *
	 * @param rsfrequency ���ռ��Ƶ��
	 */
	public void setRsfrequency(String rsfrequency) {
		this.rsfrequency = rsfrequency;
	}

	/**
	 * ���ռ��Ƶ������ȡ��
	 *
	 * @return ���ռ��Ƶ������
	 */
	public String getRsfrequencydesc() {
		return rsfrequencydesc;
	}

	/**
	 * ���ռ��Ƶ�������趨
	 *
	 * @param rsfrequencydesc ���ռ��Ƶ������
	 */
	public void setRsfrequencydesc(String rsfrequencydesc) {
		this.rsfrequencydesc = rsfrequencydesc;
	}

	/**
	 * ���ղ���ָ���ϵ��idȡ��
	 *
	 * @return ���ղ���ָ���ϵ��id
	 */
	public Integer getSirid() {
		return sirid;
	}

	/**
	 * ���ղ���ָ���ϵ��id�趨
	 *
	 * @param sirid ���ղ���ָ���ϵ��id
	 */
	public void setSirid(Integer sirid) {
		this.sirid = sirid;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getRsattachkey() {
		return rsattachkey;
	}

	/**
	 * �����趨
	 *
	 * @param rsattachkey ����
	 */
	public void setRsattachkey(String rsattachkey) {
		this.rsattachkey = rsattachkey;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return rsid;
	}

}