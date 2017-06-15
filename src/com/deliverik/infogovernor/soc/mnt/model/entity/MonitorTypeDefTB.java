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
import com.deliverik.infogovernor.soc.mnt.model.MonitorTypeDefInfo;

/**
  * ����: ������ͷ�ֵ��Ϣʵ��
  * ��������: ������ͷ�ֵ��Ϣʵ��
  * ������¼: 2012/02/07
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="monitorTypeDef", schema="cst")
public class MonitorTypeDefTB extends BaseEntity implements Serializable,
		Cloneable, MonitorTypeDefInfo {

	/** ����id */
	@Id
	@TableGenerator(
		name="MONITORTYPEDEF_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="MONITORTYPEDEF_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="MONITORTYPEDEF_TABLE_GENERATOR")
	protected Integer mtdId;

	/** �������id */
	protected Integer mtId;

	/** ��ֵ���� */
	protected String mtdName;

	/** ��ֵ */
	protected String mtdValue;

	/** ����ʱ�� */
	protected String mtdCreateTime;

	/** ����� */
	protected Integer orderNumber;

	/** ״̬ */
	protected String deleteFlag;

	/** ����*/
	protected String mtdDes;
	
	/** �ȽϷ�*/
	protected String compare;
	
	/**
	 * ����idȡ��
	 *
	 * @return ����id
	 */
	public Integer getMtdId() {
		return mtdId;
	}

	/**
	 * ����id�趨
	 *
	 * @param mtdId ����id
	 */
	public void setMtdId(Integer mtdId) {
		this.mtdId = mtdId;
	}

	/**
	 * �������idȡ��
	 *
	 * @return �������id
	 */
	public Integer getMtId() {
		return mtId;
	}

	/**
	 * �������id�趨
	 *
	 * @param mtId �������id
	 */
	public void setMtId(Integer mtId) {
		this.mtId = mtId;
	}

	/**
	 * ��ֵ����ȡ��
	 *
	 * @return ��ֵ����
	 */
	public String getMtdName() {
		return mtdName;
	}

	/**
	 * ��ֵ�����趨
	 *
	 * @param mtdName ��ֵ����
	 */
	public void setMtdName(String mtdName) {
		this.mtdName = mtdName;
	}

	/**
	 * ��ֵȡ��
	 *
	 * @return ��ֵ
	 */
	public String getMtdValue() {
		return mtdValue;
	}

	/**
	 * ��ֵ�趨
	 *
	 * @param mtdValue ��ֵ
	 */
	public void setMtdValue(String mtdValue) {
		this.mtdValue = mtdValue;
	}

	/**
	 * ����ʱ��ȡ��
	 *
	 * @return ����ʱ��
	 */
	public String getMtdCreateTime() {
		return mtdCreateTime;
	}

	/**
	 * ����ʱ���趨
	 *
	 * @param mtdCreateTime ����ʱ��
	 */
	public void setMtdCreateTime(String mtdCreateTime) {
		this.mtdCreateTime = mtdCreateTime;
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
		return mtdId;
	}

	/**
	 * ����ȡ��
	 * @return
	 */
	public String getMtdDes() {
		return mtdDes;
	}

	/**
	 * �����趨
	 * @param mtdDes
	 */
	public void setMtdDes(String mtdDes) {
		this.mtdDes = mtdDes;
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