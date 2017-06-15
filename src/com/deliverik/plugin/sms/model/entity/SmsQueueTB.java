/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.plugin.sms.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.plugin.sms.model.SmsQueueInfo;

/**
  * 概述: 短信队列表实体
  * 功能描述: 短信队列表实体
  * 创建记录: 2012/10/31
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="SMS_QUEUE")
public class SmsQueueTB extends BaseEntity implements Serializable,
		Cloneable, SmsQueueInfo {

	/** 主键 */
	@Id
	protected Integer qid ;

	/** 告警ID */
	protected String alertId;

	/** 手机号 */
	protected String tel ;

	/** 用户ID */
	protected String userId ;

	/** 用户名称 */
	protected String userName ;

	/** 短信内容 */
	protected String smsContext;

	/** 告警时间 */
	protected String alertTime;

	/**
	 * 主键取得
	 *
	 * @return 主键
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