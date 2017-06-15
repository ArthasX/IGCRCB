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
import com.deliverik.infogovernor.rpt.model.SOC0401Info;

/**
  * ����: ���ݿ�����ʵʱ��ʵ��
  * ��������: ���ݿ�����ʵʱ��ʵ��
  * ������¼: 2012/08/09
  * �޸ļ�¼: ��DBCapacityRealTimeTB������ΪSOC0401TB
  */
@SuppressWarnings("serial")
@Entity
@Table(name="SOC0401")
public class SOC0401TB extends BaseEntity implements Serializable,
		Cloneable, SOC0401Info {

	/** ���� */
	@Id
	@TableGenerator(
		name="DBCAPACITYREALTIME_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="DBCAPACITYREALTIME_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="DBCAPACITYREALTIME_TABLE_GENERATOR")
	protected Integer dbId;

	/** ���ݿ��� */
	protected String dbName;

	/** ������ */
	protected String hostName;

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
	public Integer getDbId() {
		return dbId;
	}

	/**
	 * �����趨
	 *
	 * @param dbId ����
	 */
	public void setDbId(Integer dbId) {
		this.dbId = dbId;
	}

	/**
	 * ���ݿ���ȡ��
	 *
	 * @return ���ݿ���
	 */
	public String getDbName() {
		return dbName;
	}

	/**
	 * ���ݿ����趨
	 *
	 * @param dbName ���ݿ���
	 */
	public void setDbName(String dbName) {
		this.dbName = dbName;
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
		return dbId;
	}

}