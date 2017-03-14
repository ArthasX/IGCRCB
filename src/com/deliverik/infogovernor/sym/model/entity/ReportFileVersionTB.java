/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sym.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.sym.model.ReportFileVersion;

/**
 * ����汾ʵ��
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name="ReportFileVersion")
public class ReportFileVersionTB extends BaseEntity implements Serializable, Cloneable, ReportFileVersion {

	/** ���� */
	@Id
	@TableGenerator(
		    name="REPORTFILEVERSION_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="REPORTFILEVERSION_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="REPORTFILEVERSION_TABLE_GENERATOR")
	protected Integer rfvid;

	/** �������� */
	protected Integer rfdid;
	
	/** �汾�� */
	protected Integer rfvversion;
	
	/** ����ʱ�� */
	protected String rfvinstime;
	
	/**
	 * ��ȡ����
	 * @return 
	 */
	public Serializable getPK() {
		return rfvid;
	}

	/**
	 * �Ƚ�
	 * @return 
	 */
	public boolean equals(Object obj) {
		if (!(obj instanceof ReportFileVersionTB))
			return false;
		ReportFileVersion target = (ReportFileVersion) obj;
		if (!(getRfvid()==target.getRfvid()))
			return false;

		return true;
	}

	/**
	 * ����ȡ��
	 * @return ����
	 */
	public Integer getRfvid() {
		return rfvid;
	}
	
	/**
	 * �����趨
	 * @param rfvid ����
	 */
	public void setRfvid(Integer rfvid) {
		this.rfvid = rfvid;
	}
	
	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public Integer getRfdid() {
		return rfdid;
	}

	/**
	 * ���������趨
	 * @param rfdid ��������
	 */
	public void setRfdid(Integer rfdid) {
		this.rfdid = rfdid;
	}

	/**
	 * �汾��ȡ��
	 * @return �汾��
	 */
	public Integer getRfvversion() {
		return rfvversion;
	}

	/**
	 * �汾���趨
	 * @param rfdid �汾��
	 */
	public void setRfvversion(Integer rfvversion) {
		this.rfvversion = rfvversion;
	}

	/**
	 * ����ʱ��ȡ��
	 * @return ����ʱ��
	 */
	public String getRfvinstime() {
		return rfvinstime;
	}

	/**
	 * ����ʱ���趨
	 * @param rfvinstime ����ʱ��
	 */
	public void setRfvinstime(String rfvinstime) {
		this.rfvinstime = rfvinstime;
	}
	
}
