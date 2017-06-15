/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.sym.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.sym.model.QueueInfo;

/**
  * ����: ���Ŷ��б�ʵ��
  * ��������: ���Ŷ��б�ʵ��
  * ������¼: 2012/11/13
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="Sms_queue")
@SequenceGenerator(
	    name="SEQ_STORE",
	    sequenceName="SMS_QUEUE_SEQ",
	    allocationSize=1
	)
public class QueueTB extends BaseEntity implements Serializable,
		Cloneable, QueueInfo {

	/** ���� */
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_STORE")
	protected Integer qid;

	/** �澯ID */
	protected String alertid;

	/** �澯���� */
	protected String smscontext;

	/** �澯ʱ�� */
	protected String alerttime;

	/** �ֻ��� */
	protected String tel;

	/** �û����� */
	protected String userName;

	/** �û�ID */
	protected String userid;

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getQid() {
		return qid;
	}

	/**
	 * �����趨
	 *
	 * @param qid ����
	 */
	public void setQid(Integer qid) {
		this.qid = qid;
	}

	/**
	 * �澯IDȡ��
	 *
	 * @return �澯ID
	 */
	public String getAlertid() {
		return alertid;
	}

	/**
	 * �澯ID�趨
	 *
	 * @param alertid �澯ID
	 */
	public void setAlertid(String alertid) {
		this.alertid = alertid;
	}

	/**
	 * �澯����ȡ��
	 *
	 * @return �澯����
	 */
	public String getSmscontext() {
		return smscontext;
	}

	/**
	 * �澯�����趨
	 *
	 * @param smscontext �澯����
	 */
	public void setSmscontext(String smscontext) {
		this.smscontext = smscontext;
	}

	/**
	 * �澯ʱ��ȡ��
	 *
	 * @return �澯ʱ��
	 */
	public String getAlerttime() {
		return alerttime;
	}

	/**
	 * �澯ʱ���趨
	 *
	 * @param alerttime �澯ʱ��
	 */
	public void setAlerttime(String alerttime) {
		this.alerttime = alerttime;
	}

	/**
	 * �ֻ���ȡ��
	 *
	 * @return �ֻ���
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * �ֻ����趨
	 *
	 * @param tel �ֻ���
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 * �û�����ȡ��
	 *
	 * @return �û�����
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * �û������趨
	 *
	 * @param userName �û�����
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * �û�IDȡ��
	 *
	 * @return �û�ID
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * �û�ID�趨
	 *
	 * @param userid �û�ID
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return qid;
	}

}