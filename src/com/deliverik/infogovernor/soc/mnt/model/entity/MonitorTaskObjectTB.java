/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.mnt.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.soc.mnt.model.MonitorTaskObjectInfo;

/**
  * ����: �����������ʵ��
  * ��������: �����������ʵ��
  * ������¼: 2012/05/10
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="monitorTaskObject")
public class MonitorTaskObjectTB extends BaseEntity implements Serializable,
		Cloneable, MonitorTaskObjectInfo {

	/** ��ˮID */
	@Id
	@TableGenerator(
		name="MONITORTASKOBJECT_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="MONITORTASKOBJECT_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="MONITORTASKOBJECT_TABLE_GENERATOR")
	protected Integer mtoId;

	/** ����ID */
	protected Integer mtId;

	/** �������� */
	protected String mtoName;

	/** ������¼���� */
	protected Integer mtoRow;

	/**
	 * ��ˮIDȡ��
	 *
	 * @return ��ˮID
	 */
	public Integer getMtoId() {
		return mtoId;
	}

	/**
	 * ��ˮID�趨
	 *
	 * @param mtoId ��ˮID
	 */
	public void setMtoId(Integer mtoId) {
		this.mtoId = mtoId;
	}

	/**
	 * ����IDȡ��
	 *
	 * @return ����ID
	 */
	public Integer getMtId() {
		return mtId;
	}

	/**
	 * ����ID�趨
	 *
	 * @param mtId ����ID
	 */
	public void setMtId(Integer mtId) {
		this.mtId = mtId;
	}

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getMtoName() {
		return mtoName;
	}

	/**
	 * ���������趨
	 *
	 * @param mtoName ��������
	 */
	public void setMtoName(String mtoName) {
		this.mtoName = mtoName;
	}

	/**
	 * ������¼����ȡ��
	 *
	 * @return ������¼����
	 */
	public Integer getMtoRow() {
		return mtoRow;
	}

	/**
	 * ������¼�����趨
	 *
	 * @param mtoRow ������¼����
	 */
	public void setMtoRow(Integer mtoRow) {
		this.mtoRow = mtoRow;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return mtoId;
	}

}