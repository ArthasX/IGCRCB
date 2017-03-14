/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
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
  * 概述: 短信队列表实体
  * 功能描述: 短信队列表实体
  * 创建记录: 2012/11/13
  * 修改记录: 
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

	/** 主键 */
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_STORE")
	protected Integer qid;

	/** 告警ID */
	protected String alertid;

	/** 告警内容 */
	protected String smscontext;

	/** 告警时间 */
	protected String alerttime;

	/** 手机号 */
	protected String tel;

	/** 用户姓名 */
	protected String userName;

	/** 用户ID */
	protected String userid;

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getQid() {
		return qid;
	}

	/**
	 * 主键设定
	 *
	 * @param qid 主键
	 */
	public void setQid(Integer qid) {
		this.qid = qid;
	}

	/**
	 * 告警ID取得
	 *
	 * @return 告警ID
	 */
	public String getAlertid() {
		return alertid;
	}

	/**
	 * 告警ID设定
	 *
	 * @param alertid 告警ID
	 */
	public void setAlertid(String alertid) {
		this.alertid = alertid;
	}

	/**
	 * 告警内容取得
	 *
	 * @return 告警内容
	 */
	public String getSmscontext() {
		return smscontext;
	}

	/**
	 * 告警内容设定
	 *
	 * @param smscontext 告警内容
	 */
	public void setSmscontext(String smscontext) {
		this.smscontext = smscontext;
	}

	/**
	 * 告警时间取得
	 *
	 * @return 告警时间
	 */
	public String getAlerttime() {
		return alerttime;
	}

	/**
	 * 告警时间设定
	 *
	 * @param alerttime 告警时间
	 */
	public void setAlerttime(String alerttime) {
		this.alerttime = alerttime;
	}

	/**
	 * 手机号取得
	 *
	 * @return 手机号
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * 手机号设定
	 *
	 * @param tel 手机号
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 * 用户姓名取得
	 *
	 * @return 用户姓名
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 用户姓名设定
	 *
	 * @param userName 用户姓名
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * 用户ID取得
	 *
	 * @return 用户ID
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * 用户ID设定
	 *
	 * @param userid 用户ID
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return qid;
	}

}