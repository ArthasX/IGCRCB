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
import com.deliverik.infogovernor.soc.mnt.model.MonitorObjectDefInfo;

/**
  * ����: ��ض���ֵ��Ϣ��ʵ��
  * ��������: ��ض���ֵ��Ϣ��ʵ��
  * ������¼: 2012/02/07
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="monitorObjectDef", schema="cst")
public class MonitorObjectDefTB extends BaseEntity implements Serializable,
		Cloneable, MonitorObjectDefInfo {

	/** ����id */
	@Id
	@TableGenerator(
		name="MONITOROBJECTDEF_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="MONITOROBJECTDEF_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="MONITOROBJECTDEF_TABLE_GENERATOR")
	protected Integer modId;

	/** ��ض���id */
	protected Integer moId;

	/** ����ʱ�� */
	protected String modCreateTime;

	/** ��ض���ֵ���� */
	protected String modName;

	/** ��ض���ֵ */
	protected String modValue;

	/** ����� */
	protected Integer orderNumber;

	/** ״̬ */
	protected String deleteFlag;

	/** ���� */
	protected String modDes;
	
	/** �ȽϷ� */
	protected String compare;
	
	/**
	 * ����idȡ��
	 *
	 * @return ����id
	 */
	public Integer getModId() {
		return modId;
	}

	/**
	 * ����id�趨
	 *
	 * @param modId ����id
	 */
	public void setModId(Integer modId) {
		this.modId = modId;
	}

	/**
	 * ��ض���idȡ��
	 *
	 * @return ��ض���id
	 */
	public Integer getMoId() {
		return moId;
	}

	/**
	 * ��ض���id�趨
	 *
	 * @param moId ��ض���id
	 */
	public void setMoId(Integer moId) {
		this.moId = moId;
	}

	/**
	 * ����ʱ��ȡ��
	 *
	 * @return ����ʱ��
	 */
	public String getModCreateTime() {
		return modCreateTime;
	}

	/**
	 * ����ʱ���趨
	 *
	 * @param modCreateTime ����ʱ��
	 */
	public void setModCreateTime(String modCreateTime) {
		this.modCreateTime = modCreateTime;
	}

	/**
	 * ��ض���ֵ����ȡ��
	 *
	 * @return ��ض���ֵ����
	 */
	public String getModName() {
		return modName;
	}

	/**
	 * ��ض���ֵ�����趨
	 *
	 * @param modName ��ض���ֵ����
	 */
	public void setModName(String modName) {
		this.modName = modName;
	}

	/**
	 * ��ض���ֵȡ��
	 *
	 * @return ��ض���ֵ
	 */
	public String getModValue() {
		return modValue;
	}

	/**
	 * ��ض���ֵ�趨
	 *
	 * @param modValue ��ض���ֵ
	 */
	public void setModValue(String modValue) {
		this.modValue = modValue;
	}

	/**
	 * �����ȡ��
	 *
	 * @return �����
	 */
	public Integer getOrderNumber() {
		return orderNumber;
	}

	/**
	 * ������趨
	 *
	 * @param orderNumber �����
	 */
	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
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
		return modId;
	}

	/**
	 * ����ȡ��
	 * @return
	 */
	public String getModDes() {
		return modDes;
	}

	/**
	 * ������ȡ
	 * @param modDes
	 */
	public void setModDes(String modDes) {
		this.modDes = modDes;
	}

	/**
	 * �ȽϷ�ȡ��
	 * @return
	 */
	public String getCompare() {
		return compare;
	}

	/**
	 * �ȽϷ��趨
	 * @param compare
	 */
	public void setCompare(String compare) {
		this.compare = compare;
	}

}