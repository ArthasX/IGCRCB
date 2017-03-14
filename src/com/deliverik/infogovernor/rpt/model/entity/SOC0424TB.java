/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.rpt.model.SOC0424Info;

/**
  * ����: �������ͱ�ʵ��
  * ��������: �������ͱ�ʵ��
  * ������¼: 2012/07/18
  * �޸ļ�¼: 2012/08/09 ��ReportTypeTB������ΪSOC0424TB
  */
@SuppressWarnings("serial")
@Entity
@Table(name="SOC0424")
public class SOC0424TB extends BaseEntity implements Serializable,
		Cloneable, SOC0424Info {

	/** ������ */
	@Id
	protected String reportName;

	/** ���� */
	protected String rtType;

	/** �洢���� */
	protected String storageType;

	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getReportName() {
		return reportName;
	}

	/**
	 * �������趨
	 *
	 * @param reportName ������
	 */
	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getRtType() {
		return rtType;
	}

	/**
	 * �����趨
	 *
	 * @param rtType ����
	 */
	public void setRtType(String rtType) {
		this.rtType = rtType;
	}

	/**
	 * �洢����ȡ��
	 *
	 * @return �洢����
	 */
	public String getStorageType() {
		return storageType;
	}

	/**
	 * �洢�����趨
	 *
	 * @param storageType �洢����
	 */
	public void setStorageType(String storageType) {
		this.storageType = storageType;
	}
	@Override
	public Serializable getPK() {
		return null;
	}


}