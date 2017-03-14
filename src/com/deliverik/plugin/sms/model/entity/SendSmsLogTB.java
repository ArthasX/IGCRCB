/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
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
  * 概述: 短信队列表实体
  * 功能描述: 短信队列表实体
  * 创建记录: 2012/10/31
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="SEND_SMSLOG")
public class SendSmsLogTB extends BaseEntity implements Serializable,
		Cloneable, SendSmsLogInfo {

	/** 主键 */
	@Id
	@TableGenerator(
		name="SENDLOG_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="SENDLOG_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="SENDLOG_TABLE_GENERATOR")
	protected Integer id ;

	/** 告警内容 */
	protected String smsContext;

	/** 告警时间 */
	protected String alertTime;

	/** 发送时间 */
	protected String sendTime;

	/** 用户名称 */
	protected String sendStatus;

	/** 手机号 */
	protected String tel;

	/** 用户ID */
	protected String userId;

	/**
	 * 主键取得
	 *
	 * @return 主键
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