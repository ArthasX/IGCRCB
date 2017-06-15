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
import com.deliverik.infogovernor.ven.model.RiskMonitoringInfo;

/**
  * ����: ���ռ�⹤����ʵ��
  * ��������: ���ռ�⹤����ʵ��
  * ������¼: 2014/12/01
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="RiskMonitoring")
public class RiskMonitoringTB extends BaseEntity implements Serializable,
		Cloneable, RiskMonitoringInfo {

	/** ���� */
	@Id
	@TableGenerator(
		name="RISKMONITORING_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="RISKMONITORING_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="RISKMONITORING_TABLE_GENERATOR")
	protected Integer rmid;

	/** ���ղ�������id */
	protected Integer rsid;

	/** ����������� */
	protected String rmname;

	/** �ƻ���ʼʱ�� */
	protected String rmstartdate;

	/** ʵ�����ʱ�� */
	protected String rmenddate;

	/** ���� */
	protected String rmrate;
	
	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getRmid() {
		return rmid;
	}

	/**
	 * �����趨
	 *
	 * @param rmid ����
	 */
	public void setRmid(Integer rmid) {
		this.rmid = rmid;
	}

	/**
	 * ���ղ�������idȡ��
	 *
	 * @return ���ղ�������id
	 */
	public Integer getRsid() {
		return rsid;
	}

	/**
	 * ���ղ�������id�趨
	 *
	 * @param rsid ���ղ�������id
	 */
	public void setRsid(Integer rsid) {
		this.rsid = rsid;
	}

	/**
	 * �����������ȡ��
	 *
	 * @return �����������
	 */
	public String getRmname() {
		return rmname;
	}

	/**
	 * ������������趨
	 *
	 * @param rmname �����������
	 */
	public void setRmname(String rmname) {
		this.rmname = rmname;
	}

	/**
	 * �ƻ���ʼʱ��ȡ��
	 *
	 * @return �ƻ���ʼʱ��
	 */
	public String getRmstartdate() {
		return rmstartdate;
	}

	/**
	 * �ƻ���ʼʱ���趨
	 *
	 * @param rmstartdate �ƻ���ʼʱ��
	 */
	public void setRmstartdate(String rmstartdate) {
		this.rmstartdate = rmstartdate;
	}

	/**
	 * ʵ�����ʱ��ȡ��
	 *
	 * @return ʵ�����ʱ��
	 */
	public String getRmenddate() {
		return rmenddate;
	}

	/**
	 * ʵ�����ʱ���趨
	 *
	 * @param rmenddate ʵ�����ʱ��
	 */
	public void setRmenddate(String rmenddate) {
		this.rmenddate = rmenddate;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return rmid;
	}

	/**
	 * ����ȡ��
	 * @return rmrate  ����
	 */
	public String getRmrate() {
		return rmrate;
	}

	/**
	 * �����趨
	 * @param rmrate  ����
	 */
	public void setRmrate(String rmrate) {
		this.rmrate = rmrate;
	}

}