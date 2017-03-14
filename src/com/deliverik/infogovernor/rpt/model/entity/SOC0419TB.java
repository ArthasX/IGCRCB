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
import com.deliverik.infogovernor.rpt.model.SOC0419Info;

/**
  * ����: ��������ʵʱ��ʵ��
  * ��������: ��������ʵʱ��ʵ��
  * ������¼: 2012/07/03
  * �޸ļ�¼: 2012/08/09 ��VGCapacityRealTimeTB������ΪSOC0419TB
  */
@SuppressWarnings("serial")
@Entity
@Table(name="SOC0419")
public class SOC0419TB extends BaseEntity implements Serializable,
		Cloneable, SOC0419Info {

	/** ���� */
	@Id
	@TableGenerator(
		name="VGCAPACITYREALTIME_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="VGCAPACITYREALTIME_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="VGCAPACITYREALTIME_TABLE_GENERATOR")
	protected Integer vgId;

	/** ������ */
	protected String vgName;

	/** ������ */
	protected String hostName;

	/** �洢���к� */
	protected String sName;

	/** ���� */
	protected String createDate;

	/** �ѷ������� */
	protected Integer allottedCapacity;

	/** �������� */
	protected Integer freeCapacity;

	/** ��ʹ������ */
	protected Integer usedCapacity;

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getVgId() {
		return vgId;
	}

	/**
	 * �����趨
	 *
	 * @param vgId ����
	 */
	public void setVgId(Integer vgId) {
		this.vgId = vgId;
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
	 * ��ʹ������ȡ��
	 *
	 * @return ��ʹ������
	 */
	public Integer getUsedCapacity() {
		return usedCapacity;
	}

	/**
	 * ��ʹ�������趨
	 *
	 * @param usedCapacity ��ʹ������
	 */
	public void setUsedCapacity(Integer usedCapacity) {
		this.usedCapacity = usedCapacity;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return vgId;
	}

}