/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.infogovernor.rpt.model.SOC0429Info;

/**
  * ����: ����������ͼʵ��
  * ��������: ����������ͼʵ��
  * ������¼: 2012/07/03
  * �޸ļ�¼: 2012/08/09 ��HostCapacityRealTimeVW������ΪSOC0429VW
  */
@SuppressWarnings("serial")
@Entity
@Table(name="SOC0429")
public class SOC0429VW implements Serializable,
		Cloneable, SOC0429Info {

	/** �������� */
	@Id
	protected String hostName;

	/**ҵ��ϵͳ����*/
	protected String bcName;
	/** ҵ��ϵͳid */
	protected Integer bcid;

	/** �洢���� */
	protected String sName;

	/** ��¼ʱ�� */
	protected String createDate;

	/** �ѷ������� */
	protected Integer allottedCapacity;

	/** �������� */
	protected Integer freeCapacity;

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getHostName() {
		return hostName;
	}

	/**
	 * ���������趨
	 *
	 * @param hostName ��������
	 */
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	/**
	 * ҵ��ϵͳidȡ��
	 *
	 * @return ҵ��ϵͳid
	 */
	public Integer getBcid() {
		return bcid;
	}

	/**
	 * ҵ��ϵͳid�趨
	 *
	 * @param bcid ҵ��ϵͳid
	 */
	public void setBcid(Integer bcid) {
		this.bcid = bcid;
	}

	/**
	 * �洢����ȡ��
	 *
	 * @return �洢����
	 */
	public String getSName() {
		return sName;
	}

	/**
	 * �洢�����趨
	 *
	 * @param sName �洢����
	 */
	public void setSName(String sName) {
		this.sName = sName;
	}

	/**
	 * ��¼ʱ��ȡ��
	 *
	 * @return ��¼ʱ��
	 */
	public String getCreateDate() {
		return createDate;
	}

	/**
	 * ��¼ʱ���趨
	 *
	 * @param createDate ��¼ʱ��
	 */
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	/**
	 * �ѷ�������ȡ��
	 *
	 * @return �ѷ�������
	 */
	public Integer getAllottedCapacity() {
		return allottedCapacity;
	}

	/**
	 * �ѷ��������趨
	 *
	 * @param allottedCapacity �ѷ�������
	 */
	public void setAllottedCapacity(Integer allottedCapacity) {
		this.allottedCapacity = allottedCapacity;
	}

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public Integer getFreeCapacity() {
		return freeCapacity;
	}

	/**
	 * ���������趨
	 *
	 * @param freeCapacity ��������
	 */
	public void setFreeCapacity(Integer freeCapacity) {
		this.freeCapacity = freeCapacity;
	}

	

	/**
	 * ҵ��ϵͳ����ȡ��
	 *
	 * @return bcName ҵ��ϵͳ����
	 */
	public String getBcName() {
		return bcName;
	}

	/**
	 * ҵ��ϵͳ�����趨
	 *
	 * @param bcName ҵ��ϵͳ����
	 */
	public void setBcName(String bcName) {
		this.bcName = bcName;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return null;
	}

}