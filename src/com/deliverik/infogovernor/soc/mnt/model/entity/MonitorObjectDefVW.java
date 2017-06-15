/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.mnt.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.infogovernor.soc.mnt.model.MonitorObjectDefVWInfo;

/**
  * ����: ��ض���KPI��Ϣ��ͼʵ��
  * ��������: ��ض���KPI��Ϣ��ͼʵ��
  * ������¼: 2012/02/13
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(schema="cst")
public class MonitorObjectDefVW implements Serializable,
		Cloneable, MonitorObjectDefVWInfo {

	/** ����id */
	@Id
	protected Integer modid;

	/** ��ض������� */
	protected String moName;

	/** ����������� */
	protected String mtName;

	/** ������Ͳ���� */
	protected String mtSyscoding;

	/** ����ʱ�� */
	protected String modCreateTime;

	/** ��ض���ֵ���� */
	protected String modName;

	/** ��ض���ֵ */
	protected String modValue;
	
	/** �ȽϷ��� */
	protected String compare;

	/** ����� */
	protected Integer orderNumber;
	
	/** ���� */
	protected String modDes;

	/** ״̬ */
	protected String deleteFlag;

	/**
	 * ����idȡ��
	 *
	 * @return ����id
	 */
	public Integer getModid() {
		return modid;
	}

	/**
	 * ����id�趨
	 *
	 * @param modid ����id
	 */
	public void setModid(Integer modid) {
		this.modid = modid;
	}

	/**
	 * ��ض�������ȡ��
	 *
	 * @return ��ض�������
	 */
	public String getMoName() {
		return moName;
	}

	/**
	 * ��ض��������趨
	 *
	 * @param moName ��ض�������
	 */
	public void setMoName(String moName) {
		this.moName = moName;
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
	 * ������Ͳ����ȡ��
	 *
	 * @return ������Ͳ����
	 */
	public String getMtSyscoding() {
		return mtSyscoding;
	}

	/**
	 * ������Ͳ�����趨
	 *
	 * @param mtSyscoding ������Ͳ����
	 */
	public void setMtSyscoding(String mtSyscoding) {
		this.mtSyscoding = mtSyscoding;
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
	 * �ȽϷ���ȡ��
	 * @return �ȽϷ���
	 */
	public String getCompare() {
		return compare;
	}

	/**
	 * �ȽϷ����趨
	 * @param compare�ȽϷ���
	 */
	public void setCompare(String compare) {
		this.compare = compare;
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

}