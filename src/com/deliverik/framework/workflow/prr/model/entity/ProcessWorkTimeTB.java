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
import com.deliverik.framework.workflow.prr.model.ProcessWorkTimeInfo;

/**
  * ����: �û���Ϣʱ�䶨���ʵ��
  * ��������: �û���Ϣʱ�䶨���ʵ��
  * ������¼: 2011/10/08
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="ProcessWorkTime")
public class ProcessWorkTimeTB extends BaseEntity implements Serializable,
		Cloneable, ProcessWorkTimeInfo {

	/** ���� */
	@Id
	@TableGenerator(
		name="PROCESSWORKTIME_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="PROCESSWORKTIME_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="PROCESSWORKTIME_TABLE_GENERATOR")
	protected Integer pwId;

	/** �û�ID */
	protected String userId;

	/** �������� */
	protected String pwDate;

	/** ������ʼʱ�� */
	protected String pwStartTime;

	/** ��������ʱ�� */
	protected String pwEndTime;

	/** ��Ϣʱ�� */
	protected Integer pwSleep;

	/** �û��޸ı�־λ */
	protected String pwFlg;

	/** ��Чʱ�� */
	protected Integer factTime;

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getPwId() {
		return pwId;
	}

	/**
	 * �����趨
	 *
	 * @param pwId����
	 */
	public void setPwId(Integer pwId) {
		this.pwId = pwId;
	}

	/**
	 * �û�IDȡ��
	 *
	 * @return �û�ID
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * �û�ID�趨
	 *
	 * @param userId�û�ID
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getPwDate() {
		return pwDate;
	}

	/**
	 * ���������趨
	 *
	 * @param pwDate��������
	 */
	public void setPwDate(String pwDate) {
		this.pwDate = pwDate;
	}

	/**
	 * ������ʼʱ��ȡ��
	 *
	 * @return ������ʼʱ��
	 */
	public String getPwStartTime() {
		return pwStartTime;
	}

	/**
	 * ������ʼʱ���趨
	 *
	 * @param pwStartTime������ʼʱ��
	 */
	public void setPwStartTime(String pwStartTime) {
		this.pwStartTime = pwStartTime;
	}

	/**
	 * ��������ʱ��ȡ��
	 *
	 * @return ��������ʱ��
	 */
	public String getPwEndTime() {
		return pwEndTime;
	}

	/**
	 * ��������ʱ���趨
	 *
	 * @param pwEndTime��������ʱ��
	 */
	public void setPwEndTime(String pwEndTime) {
		this.pwEndTime = pwEndTime;
	}

	/**
	 * ��Ϣʱ��ȡ��
	 *
	 * @return ��Ϣʱ��
	 */
	public Integer getPwSleep() {
		return pwSleep;
	}

	/**
	 * ��Ϣʱ���趨
	 *
	 * @param pwSleep��Ϣʱ��
	 */
	public void setPwSleep(Integer pwSleep) {
		this.pwSleep = pwSleep;
	}

	/**
	 * �û��޸ı�־λȡ��
	 *
	 * @return �û��޸ı�־λ
	 */
	public String getPwFlg() {
		return pwFlg;
	}

	/**
	 * �û��޸ı�־λ�趨
	 *
	 * @param pwFlg�û��޸ı�־λ
	 */
	public void setPwFlg(String pwFlg) {
		this.pwFlg = pwFlg;
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
		return pwId;
	}

}