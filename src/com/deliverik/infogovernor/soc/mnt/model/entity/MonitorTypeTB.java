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
import com.deliverik.infogovernor.soc.mnt.model.MonitorTypeInfo;

/**
  * ����: ������ͱ�ʵ��
  * ��������: ������ͱ�ʵ��
  * ������¼: 2012/02/08
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="monitorType", schema="cst")
public class MonitorTypeTB extends BaseEntity implements Serializable,
		Cloneable, MonitorTypeInfo {

	/** ����id */
	@Id
	@TableGenerator(
		name="MONITORTYPE_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="MONITORTYPE_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="MONITORTYPE_TABLE_GENERATOR")
	protected Integer mtId;

	/** ����������� */
	protected String mtName;

	/** ����ʱ�� */
	protected String mtCreateTime;

	/** ���β���� */
	protected String mtSyscoding;

	/** ״̬ */
	protected String deleteFlag;

	/**
	 * ����idȡ��
	 *
	 * @return ����id
	 */
	public Integer getMtId() {
		return mtId;
	}

	/**
	 * ����id�趨
	 *
	 * @param mtId ����id
	 */
	public void setMtId(Integer mtId) {
		this.mtId = mtId;
	}

	/**
	 * �����������ȡ��
	 *
	 * @return �����������
	 */
	public String getMtName() {
		return mtName;
	}

	/**
	 * ������������趨
	 *
	 * @param mtName �����������
	 */
	public void setMtName(String mtName) {
		this.mtName = mtName;
	}

	/**
	 * ����ʱ��ȡ��
	 *
	 * @return ����ʱ��
	 */
	public String getMtCreateTime() {
		return mtCreateTime;
	}

	/**
	 * ����ʱ���趨
	 *
	 * @param mtCreateTime ����ʱ��
	 */
	public void setMtCreateTime(String mtCreateTime) {
		this.mtCreateTime = mtCreateTime;
	}

	/**
	 * ���β����ȡ��
	 *
	 * @return ���β����
	 */
	public String getMtSyscoding() {
		return mtSyscoding;
	}

	/**
	 * ���β�����趨
	 *
	 * @param mtSyscoding ���β����
	 */
	public void setMtSyscoding(String mtSyscoding) {
		this.mtSyscoding = mtSyscoding;
	}

	/**
	 * ״̬ȡ��
	 *
	 * @return ״̬
	 */
	public String getDeleteFlag() {
		return deleteFlag;
	}

	/**
	 * ״̬�趨
	 *
	 * @param deleteFlag ״̬
	 */
	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return mtId;
	}

}