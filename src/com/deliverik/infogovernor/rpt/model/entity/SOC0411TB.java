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
import com.deliverik.infogovernor.rpt.model.SOC0411Info;

/**
  * ����: �洢����ʵʱ��ʵ��
  * ��������: �洢����ʵʱ��ʵ��
  * ������¼: 2012/07/03
  * �޸ļ�¼: 2012/08/09 ��StorageCapacityRealTimeTB������ΪSOC0411TB
  */
@SuppressWarnings("serial")
@Entity
@Table(name="SOC0411")
public class SOC0411TB extends BaseEntity implements Serializable,
		Cloneable, SOC0411Info {

	/** ���� */
	@Id
	@TableGenerator(
		name="STORAGECAPACITYREALTIME_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="STORAGECAPACITYREALTIME_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="STORAGECAPACITYREALTIME_TABLE_GENERATOR")
	protected Integer scid;

	/** �洢���к� */
	protected String sName;

	/** ���� */
	protected String createDate;

	/** ������ */
	protected Integer rawCapacity;

	/** ��Ч���� */
	protected Integer effectiveCapacity;

	/** �������� */
	protected Integer redundancyCapacity;

	/** �ѷ������� */
	protected Integer allottedCapacity;

	/** �������� */
	protected Integer freeCapacity;

	/** ���̸��� */
	protected Integer diskCount;

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getScid() {
		return scid;
	}

	/**
	 * �����趨
	 *
	 * @param scid ����
	 */
	public void setScid(Integer scid) {
		this.scid = scid;
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
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public Integer getRawCapacity() {
		return rawCapacity;
	}

	/**
	 * �������趨
	 *
	 * @param rawCapacity ������
	 */
	public void setRawCapacity(Integer rawCapacity) {
		this.rawCapacity = rawCapacity;
	}

	/**
	 * ��Ч����ȡ��
	 *
	 * @return ��Ч����
	 */
	public Integer getEffectiveCapacity() {
		return effectiveCapacity;
	}

	/**
	 * ��Ч�����趨
	 *
	 * @param effectiveCapacity ��Ч����
	 */
	public void setEffectiveCapacity(Integer effectiveCapacity) {
		this.effectiveCapacity = effectiveCapacity;
	}

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public Integer getRedundancyCapacity() {
		return redundancyCapacity;
	}

	/**
	 * ���������趨
	 *
	 * @param redundancyCapacity ��������
	 */
	public void setRedundancyCapacity(Integer redundancyCapacity) {
		this.redundancyCapacity = redundancyCapacity;
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
	 * ���̸���ȡ��
	 *
	 * @return ���̸���
	 */
	public Integer getDiskCount() {
		return diskCount;
	}

	/**
	 * ���̸����趨
	 *
	 * @param diskCount ���̸���
	 */
	public void setDiskCount(Integer diskCount) {
		this.diskCount = diskCount;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return scid;
	}

}