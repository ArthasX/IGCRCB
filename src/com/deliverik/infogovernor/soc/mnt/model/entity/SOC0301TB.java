/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.mnt.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.soc.mnt.model.SOC0301Info;
/**
  * ����: DMXʵʱ������ܱ�ʵ��dmxrealtime
  * ��������: DMXʵʱ������ܱ�ʵ��dmxrealtime
  * ������¼: 2012/05/16
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="SOC0301")
public class SOC0301TB extends BaseEntity implements Serializable,
		Cloneable, SOC0301Info{
	/** ���� */
	@Id
	@GeneratedValue(generator = "id")
	@GenericGenerator(name = "id", strategy = "identity")
	protected Integer id;

	/** �������id */
	protected Integer mtId;

	/** ��ض����� */
	protected String mtoName;

	/** ����ָ�� */
	protected String mtKpi;

	/** ����ָ��ֵ */
	protected Double kpiValue;

	/** ����ʱ��� */
	protected String timeStamp;

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * �����趨
	 *
	 * @param id ����
	 */
	public void setId(Integer id) {
		this.id = id;
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
	 * ��ض�����ȡ��
	 *
	 * @return ��ض�����
	 */
	public String getMtoName() {
		return mtoName;
	}

	/**
	 * ��ض������趨
	 *
	 * @param mtoName ��ض�����
	 */
	public void setMtoName(String mtoName) {
		this.mtoName = mtoName;
	}

	/**
	 * ����ָ��ȡ��
	 *
	 * @return ����ָ��
	 */
	public String getMtKpi() {
		return mtKpi;
	}

	/**
	 * ����ָ���趨
	 *
	 * @param mtKpi ����ָ��
	 */
	public void setMtKpi(String mtKpi) {
		this.mtKpi = mtKpi;
	}

	/**
	 * ����ָ��ֵȡ��
	 *
	 * @return ����ָ��ֵ
	 */
	public Double getKpiValue() {
		return kpiValue;
	}

	/**
	 * ����ָ��ֵ�趨
	 *
	 * @param kpiValue ����ָ��ֵ
	 */
	public void setKpiValue(Double kpiValue) {
		this.kpiValue = kpiValue;
	}

	/**
	 * ����ʱ���ȡ��
	 *
	 * @return ����ʱ���
	 */
	public String getTimeStamp() {
		return timeStamp;
	}

	/**
	 * ����ʱ����趨
	 *
	 * @param timeStamp ����ʱ���
	 */
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return id;
	}

}