/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.deliverik.infogovernor.rpt.model.SOC0428Info;

/**
  * ����: ҵ��ϵͳ��ͼʵ��
  * ��������: ҵ��ϵͳ��ͼʵ��
  * ������¼: 2012/08/09
  * �޸ļ�¼: ��BusinessCapacityRealTimeVW������ΪSOC0428VW
  */
@SuppressWarnings("serial")
@Entity
@IdClass(SOC0428PK.class)
@Table(name="SOC0428")
public class SOC0428VW implements Serializable,
		Cloneable, SOC0428Info {

	/** ҵ��ϵͳID */
	@Id
	protected Integer bcid;

	/** �洢���к� */
	protected String sName;
	/**ҵ��ϵͳ����*/
	@Id
	protected String bcName;

	/** �ѷ������� */
	protected Integer allottedCapacity;
	
	/**
	 * ����ȡ��
	 * @return ����
	 */
	public Serializable getPK() {
		return new SOC0428PK(bcid,bcName);
	}
	

	/**
	 * ҵ��ϵͳIDȡ��
	 *
	 * @return ҵ��ϵͳID
	 */
	public Integer getBcid() {
		return bcid;
	}

	/**
	 * ҵ��ϵͳID�趨
	 *
	 * @param bcid ҵ��ϵͳID
	 */
	public void setBcid(Integer bcid) {
		this.bcid = bcid;
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
}