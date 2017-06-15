/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prr.model.ProcessWorkTimeTemplateInfo;


/**
  * ����: ��Ϣʱ��ģ�嶨���ʵ��
  * ��������: ��Ϣʱ��ģ�嶨���ʵ��
  * ������¼: 2011/10/08
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="ProcessWorkTimeTemplate")
public class ProcessWorkTimeTemplateTB extends BaseEntity implements Serializable,
		Cloneable, ProcessWorkTimeTemplateInfo {

	/** ���� */
	@Id
	@TableGenerator(
		name="PROCESSWORKTIMETEMPLATE_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="PROCESSWORKTIMETEMPLATE_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="PROCESSWORKTIMETEMPLATE_TABLE_GENERATOR")
	protected Integer pwtId;

	/** �������� */
	protected String pwtDate;

	/** ������ʼʱ�� */
	protected String pwtStartTime;

	/** ��������ʱ�� */
	protected String pwtEndTime;

	/** ��Ϣʱ�� */
	protected Integer pwtSleepTime;

	/** ��Чʱ�� */
	protected Integer factTime;


	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getPwtId() {
		return pwtId;
	}

	/**
	 * �����趨
	 *
	 * @param pwtId����
	 */
	public void setPwtId(Integer pwtId) {
		this.pwtId = pwtId;
	}

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getPwtDate() {
		return pwtDate;
	}

	/**
	 * ���������趨
	 *
	 * @param pwtDate��������
	 */
	public void setPwtDate(String pwtDate) {
		this.pwtDate = pwtDate;
	}

	/**
	 * ������ʼʱ��ȡ��
	 *
	 * @return ������ʼʱ��
	 */
	public String getPwtStartTime() {
		return pwtStartTime;
	}

	/**
	 * ������ʼʱ���趨
	 *
	 * @param pwtStartTime������ʼʱ��
	 */
	public void setPwtStartTime(String pwtStartTime) {
		this.pwtStartTime = pwtStartTime;
	}

	/**
	 * ��������ʱ��ȡ��
	 *
	 * @return ��������ʱ��
	 */
	public String getPwtEndTime() {
		return pwtEndTime;
	}

	/**
	 * ��������ʱ���趨
	 *
	 * @param pwtEndTime��������ʱ��
	 */
	public void setPwtEndTime(String pwtEndTime) {
		this.pwtEndTime = pwtEndTime;
	}

	/**
	 * ��Ϣʱ��ȡ��
	 *
	 * @return ��Ϣʱ��
	 */
	public Integer getPwtSleepTime() {
		return pwtSleepTime;
	}

	/**
	 * ��Ϣʱ���趨
	 *
	 * @param pwtSleepTime��Ϣʱ��
	 */
	public void setPwtSleepTime(Integer pwtSleepTime) {
		this.pwtSleepTime = pwtSleepTime;
	}

	/**
	 * ��Чʱ��ȡ��
	 *
	 * @return ��Чʱ��
	 */
	public Integer getFactTime() {
		return factTime;
	}

	/**
	 * ��Чʱ���趨
	 *
	 * @param factTime��Чʱ��
	 */
	public void setFactTime(Integer factTime) {
		this.factTime = factTime;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return pwtId;
	}

}