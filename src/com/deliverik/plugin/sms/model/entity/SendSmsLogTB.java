/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.plugin.sms.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.plugin.sms.model.SendSmsLogInfo;

/**
  * ����: ���Ŷ��б�ʵ��
  * ��������: ���Ŷ��б�ʵ��
  * ������¼: 2012/10/31
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="SEND_SMSLOG")
public class SendSmsLogTB extends BaseEntity implements Serializable,
		Cloneable, SendSmsLogInfo {

	/** ���� */
	@Id
	@TableGenerator(
		name="SENDLOG_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="SENDLOG_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="SENDLOG_TABLE_GENERATOR")
	protected Integer id ;

	/** �澯���� */
	protected String smsContext;

	/** �澯ʱ�� */
	protected String alertTime;

	/** ����ʱ�� */
	protected String sendTime;

	/** �û����� */
	protected String sendStatus;

	/** �ֻ��� */
	protected String tel;

	/** �û�ID */
	protected String userId;

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return id ;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
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



	public String getSendTime() {
		return sendTime;
	}



	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}



	public String getSendStatus() {
		return sendStatus;
	}



	public void setSendStatus(String sendStatus) {
		this.sendStatus = sendStatus;
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

}