/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
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
  * 概述: 邮件队列表实体
  * 功能描述: 邮件队列表实体
  * 创建记录: 2013/08/05
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="alermsendmailqueue")
public class AlermSendMailQueueTB extends BaseEntity implements Serializable,
		Cloneable, AlermSendMailQueueInfo {

	/** 主键 */
	@Id
	protected Integer mid ;
	
	/** 实时告警外键 */
	protected Integer crm04fk;
	/** 插入记录时间 */
	protected String inserttime;
	/** 发送告警时间 */
	protected String senttime;
	/** 发送告警状态 0 未发送or失败 ;1发送成功 */
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
	 * mid取得
	 *
	 * @return mid mid
	 */
	public Integer getMid() {
		return mid;
	}



	/**
	 * crm04fk取得
	 *
	 * @return crm04fk crm04fk
	 */
	public Integer getCrm04fk() {
		return crm04fk;
	}



	/**
	 * inserttime取得
	 *
	 * @return inserttime inserttime
	 */
	public String getInserttime() {
		return inserttime;
	}



	/**
	 * senttime取得
	 *
	 * @return senttime senttime
	 */
	public String getSenttime() {
		return senttime;
	}



	/**
	 * sentstatus取得
	 *
	 * @return sentstatus sentstatus
	 */
	public char getSentstatus() {
		return sentstatus;
	}



	/**
	 * mid设定
	 *
	 * @param mid mid
	 */
	public void setMid(Integer mid) {
		this.mid = mid;
	}



	/**
	 * crm05fk设定
	 *
	 * @param crm04fk crm04fk
	 */
	public void setCrm04fk(Integer crm04fk) {
		this.crm04fk = crm04fk;
	}



	/**
	 * inserttime设定
	 *
	 * @param inserttime inserttime
	 */
	public void setInserttime(String inserttime) {
		this.inserttime = inserttime;
	}



	/**
	 * senttime设定
	 *
	 * @param senttime senttime
	 */
	public void setSenttime(String senttime) {
		this.senttime = senttime;
	}



	/**
	 * sentstatus设定
	 *
	 * @param sentstatus sentstatus
	 */
	public void setSentstatus(char sentstatus) {
		this.sentstatus = sentstatus;
	}



	/**
	 * crm04TB取得
	 *
	 * @return crm04TB crm04TB
	 */
	public CRM04TB getCrm04TB() {
		return crm04TB;
	}



	/**
	 * crm04TB设定
	 *
	 * @param crm04tb crm04TB
	 */
	public void setCrm04TB(CRM04TB crm04tb) {
		crm04TB = crm04tb;
	}
}