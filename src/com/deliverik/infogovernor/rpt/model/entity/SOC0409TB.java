/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.rpt.model.SOC0409Info;

/**
  * ����: ����pvʵʱ��ʵ��
  * ��������: ����pvʵʱ��ʵ��
  * ������¼: 2012/07/03
  * �޸ļ�¼: 2012/08/09 ��PVHostRealTimeTB������ΪSOC0409TB
  */
@SuppressWarnings("serial")
@Entity
@Table(name="SOC0409")
public class SOC0409TB extends BaseEntity implements Serializable,
		Cloneable, SOC0409Info {

	/** ���� */
	@Id
	@TableGenerator(
		name="PVHOSTREALTIME_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="PVHOSTREALTIME_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="PVHOSTREALTIME_TABLE_GENERATOR")
	protected Integer phId;

	/** �洢���к� */
	protected String sName;

	/** ������ */
	protected String hostName;

	/** ������ */
	protected String vgName;

	/** ���� */
	protected String createDate;

	/** lunid */
	protected String lunid;

	/** pv��С */
	protected Integer pvSize;

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getPhId() {
		return phId;
	}

	/**
	 * �����趨
	 *
	 * @param phId ����
	 */
	public void setPhId(Integer phId) {
		this.phId = phId;
	}

	/**
	 * �洢���к�ȡ��
	 *
	 * @return �洢���к�
	 */
	public String getSName() {
		return sName;
	}

	/**
	 * �洢���к��趨
	 *
	 * @param sName �洢���к�
	 */
	public void setSName(String sName) {
		this.sName = sName;
	}

	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getHostName() {
		return hostName;
	}

	/**
	 * �������趨
	 *
	 * @param hostName ������
	 */
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getVgName() {
		return vgName;
	}

	/**
	 * �������趨
	 *
	 * @param vgName ������
	 */
	public void setVgName(String vgName) {
		this.vgName = vgName;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getCreateDate() {
		return createDate;
	}

	/**
	 * �����趨
	 *
	 * @param createDate ����
	 */
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	/**
	 * lunidȡ��
	 *
	 * @return lunid
	 */
	public String getLunid() {
		return lunid;
	}

	/**
	 * lunid�趨
	 *
	 * @param lunid lunid
	 */
	public void setLunid(String lunid) {
		this.lunid = lunid;
	}

	/**
	 * pv��Сȡ��
	 *
	 * @return pv��С
	 */
	public Integer getPvSize() {
		return pvSize;
	}

	/**
	 * pv��С�趨
	 *
	 * @param pvSize pv��С
	 */
	public void setPvSize(Integer pvSize) {
		this.pvSize = pvSize;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return phId;
	}

}