/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.plugin.sms.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.plugin.sms.model.SmsQueueInfo;

/**
  * ����: ���Ŷ��б�ʵ��
  * ��������: ���Ŷ��б�ʵ��
  * ������¼: 2012/10/31
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="SMS_QUEUE")
public class SmsQueueTB extends BaseEntity implements Serializable,
		Cloneable, SmsQueueInfo {

	/** ���� */
	@Id
	protected Integer qid ;

	/** �澯ID */
	protected String alertId;

	/** �ֻ��� */
	protected String tel ;

	/** �û�ID */
	protected String userId ;

	/** �û����� */
	protected String userName ;

	/** �������� */
	protected String smsContext;

	/** �澯ʱ�� */
	protected String alertTime;

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return qid ;
	}

	public Integer getQid() {
		return qid;
	}

	public void setQid(Integer qid) {
		this.qid = qid;
	}

	public String getAlertId() {
		return alertId;
	}

	public void setAlertId(String alertId) {
		this.alertId = alertId;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSmsContext() {
		return smsContext;
	}

	public void setSmsContext(String smsContext) {
		this.smsContext = smsContext;
	}

	public String getAlertTime() {
		return alertTime;
	}

	public void setAlertTime(String alertTime) {
		this.alertTime = alertTime;
	}

}