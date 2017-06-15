/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.asset.model.MaintenanceInfo;

/**
  * ����: ����ָ��ά��ʵ��
  * ��������: ����ָ��ά��ʵ��
  * ������¼: 2014/07/25
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="maintenance")
public class MaintenanceTB extends BaseEntity implements Serializable,
		Cloneable, MaintenanceInfo {

	/** ����ָ��ά��ID */
	@Id
	@TableGenerator(
		name="MAINTENANCE_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="MAINTENANCE_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="MAINTENANCE_TABLE_GENERATOR")
	protected Integer RIMID;

	/** ����ָ��ID */
	protected Integer RIID;

	/** ����ָ����� */
	protected String RIMTYPE;

	/** ����ָ��˵�� */
	protected String RIMDESC;

	/** ָ��ά����� */
	protected String RIMSQL;

	/**
	 * ����ָ��ά��IDȡ��
	 *
	 * @return ����ָ��ά��ID
	 */
	public Integer getRIMID() {
		return RIMID;
	}

	/**
	 * ����ָ��ά��ID�趨
	 *
	 * @param RIMID ����ָ��ά��ID
	 */
	public void setRIMID(Integer RIMID) {
		this.RIMID = RIMID;
	}

	/**
	 * ����ָ��IDȡ��
	 *
	 * @return ����ָ��ID
	 */
	public Integer getRIID() {
		return RIID;
	}

	/**
	 * ����ָ��ID�趨
	 *
	 * @param RIID ����ָ��ID
	 */
	public void setRIID(Integer RIID) {
		this.RIID = RIID;
	}

	/**
	 * ����ָ�����ȡ��
	 *
	 * @return ����ָ�����
	 */
	public String getRIMTYPE() {
		return RIMTYPE;
	}

	/**
	 * ����ָ������趨
	 *
	 * @param RIMTYPE ����ָ�����
	 */
	public void setRIMTYPE(String RIMTYPE) {
		this.RIMTYPE = RIMTYPE;
	}

	/**
	 * ����ָ��˵��ȡ��
	 *
	 * @return ����ָ��˵��
	 */
	public String getRIMDESC() {
		return RIMDESC;
	}

	/**
	 * ����ָ��˵���趨
	 *
	 * @param RIMDESC ����ָ��˵��
	 */
	public void setRIMDESC(String RIMDESC) {
		this.RIMDESC = RIMDESC;
	}

	/**
	 * ָ��ά�����ȡ��
	 *
	 * @return ָ��ά�����
	 */
	public String getRIMSQL() {
		return RIMSQL;
	}

	/**
	 * ָ��ά������趨
	 *
	 * @param RIMSQL ָ��ά�����
	 */
	public void setRIMSQL(String RIMSQL) {
		this.RIMSQL = RIMSQL;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return RIMID;
	}

}