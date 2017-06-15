/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.plugin.mail.model.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.soc.alarm.model.entity.CRM04TB;
import com.deliverik.plugin.mail.model.AlermSendMailQueueInfo;

/**
  * ����: �ʼ����б�ʵ��
  * ��������: �ʼ����б�ʵ��
  * ������¼: 2013/08/05
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="alermsendmailqueue")
public class AlermSendMailQueueTB extends BaseEntity implements Serializable,
		Cloneable, AlermSendMailQueueInfo {

	/** ���� */
	@Id
	protected Integer mid ;
	
	/** ʵʱ�澯��� */
	protected Integer crm04fk;
	/** �����¼ʱ�� */
	protected String inserttime;
	/** ���͸澯ʱ�� */
	protected String senttime;
	/** ���͸澯״̬ 0 δ����orʧ�� ;1���ͳɹ� */
	protected char sentstatus;
	
	@OneToOne
	@JoinColumn(name="crm04fk", referencedColumnName = "alarmid", updatable = false, insertable = false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected CRM04TB crm04TB;
	
	
	
	public Serializable getPK(){
		return mid;
	}



	/**
	 * midȡ��
	 *
	 * @return mid mid
	 */
	public Integer getMid() {
		return mid;
	}



	/**
	 * crm04fkȡ��
	 *
	 * @return crm04fk crm04fk
	 */
	public Integer getCrm04fk() {
		return crm04fk;
	}



	/**
	 * inserttimeȡ��
	 *
	 * @return inserttime inserttime
	 */
	public String getInserttime() {
		return inserttime;
	}



	/**
	 * senttimeȡ��
	 *
	 * @return senttime senttime
	 */
	public String getSenttime() {
		return senttime;
	}



	/**
	 * sentstatusȡ��
	 *
	 * @return sentstatus sentstatus
	 */
	public char getSentstatus() {
		return sentstatus;
	}



	/**
	 * mid�趨
	 *
	 * @param mid mid
	 */
	public void setMid(Integer mid) {
		this.mid = mid;
	}



	/**
	 * crm05fk�趨
	 *
	 * @param crm04fk crm04fk
	 */
	public void setCrm04fk(Integer crm04fk) {
		this.crm04fk = crm04fk;
	}



	/**
	 * inserttime�趨
	 *
	 * @param inserttime inserttime
	 */
	public void setInserttime(String inserttime) {
		this.inserttime = inserttime;
	}



	/**
	 * senttime�趨
	 *
	 * @param senttime senttime
	 */
	public void setSenttime(String senttime) {
		this.senttime = senttime;
	}



	/**
	 * sentstatus�趨
	 *
	 * @param sentstatus sentstatus
	 */
	public void setSentstatus(char sentstatus) {
		this.sentstatus = sentstatus;
	}



	/**
	 * crm04TBȡ��
	 *
	 * @return crm04TB crm04TB
	 */
	public CRM04TB getCrm04TB() {
		return crm04TB;
	}



	/**
	 * crm04TB�趨
	 *
	 * @param crm04tb crm04TB
	 */
	public void setCrm04TB(CRM04TB crm04tb) {
		crm04TB = crm04tb;
	}
}