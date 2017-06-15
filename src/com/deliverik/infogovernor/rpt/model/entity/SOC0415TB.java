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
import com.deliverik.infogovernor.rpt.model.SOC0415Info;

/**
  * ����: ��ռ�����ʵʱ��ʵ��
  * ��������: ��ռ�����ʵʱ��ʵ��
  * ������¼: 2012/07/03
  * �޸ļ�¼: 2012/08/09 ��TSCapacityRealTimeTB������ΪSOC0415TB
  */
@SuppressWarnings("serial")
@Entity
@Table(name="SOC0415")
public class SOC0415TB extends BaseEntity implements Serializable,
		Cloneable, SOC0415Info {

	/** ���� */
	@Id
	@TableGenerator(
		name="TSCAPACITYREALTIME_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="TSCAPACITYREALTIME_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="TSCAPACITYREALTIME_TABLE_GENERATOR")
	protected Integer tsId;

	/** ��ռ��� */
	protected String tsName;

	/** ������ */
	protected String hostName;

	/** ���ݿ��� */
	protected String dbName;

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
	public Integer getTsId() {
		return tsId;
	}

	/**
	 * �����趨
	 *
	 * @param tsId ����
	 */
	public void setTsId(Integer tsId) {
		this.tsId = tsId;
	}

	/**
	 * ��ռ���ȡ��
	 *
	 * @return ��ռ���
	 */
	public String getTsName() {
		return tsName;
	}

	/**
	 * ��ռ����趨
	 *
	 * @param tsName ��ռ���
	 */
	public void setTsName(String tsName) {
		this.tsName = tsName;
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
		return tsId;
	}

}