/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.sym.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.sym.model.SmsMessageLogInfo;

/**
  * 概述: 短信日志信息表实体
  * 功能描述: 短信日志信息表实体
  * 创建记录: 2012/02/20
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="SmsMessageLog")
public class SmsMessageLogTB extends BaseEntity implements Serializable,
		Cloneable, SmsMessageLogInfo {

	/** 无意义主键 */
	@Id
	@TableGenerator(
		name="SMSMESSAGELOG_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="SMSMESSAGELOG_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="SMSMESSAGELOG_TABLE_GENERATOR")
	protected Integer mid;

	/** 手机号码 */
	protected String telephone;

	/** 短信内容 */
	protected String message;

	/** 业务系统名称 */
	protected String platformInfo;

	/** 发送时间 */
	protected String sendtime;

	/** 发送短信IP地址 */
	protected String sendIP;

	/**
	 * 无意义主键取得
	 *
	 * @return 无意义主键
	 */
	public Integer getMid() {
		return mid;
	}

	/**
	 * 无意义主键设定
	 *
	 * @param mid 无意义主键
	 */
	public void setMid(Integer mid) {
		this.mid = mid;
	}

	/**
	 * 手机号码取得
	 *
	 * @return 手机号码
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * 手机号码设定
	 *
	 * @param telephone 手机号码
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * 短信内容取得
	 *
	 * @return 短信内容
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * 短信内容设定
	 *
	 * @param message 短信内容
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * 业务系统名称取得
	 *
	 * @return 业务系统名称
	 */
	public String getPlatformInfo() {
		return platformInfo;
	}

	/**
	 * 业务系统名称设定
	 *
	 * @param platformInfo 业务系统名称
	 */
	public void setPlatformInfo(String platformInfo) {
		this.platformInfo = platformInfo;
	}

	/**
	 * 发送时间取得
	 *
	 * @return 发送时间
	 */
	public String getSendtime() {
		return sendtime;
	}

	/**
	 * 发送时间设定
	 *
	 * @param sendtime 发送时间
	 */
	public void setSendtime(String sendtime) {
		this.sendtime = sendtime;
	}

	/**
	 * 发送短信IP地址取得
	 *
	 * @return 发送短信IP地址
	 */
	public String getSendIP() {
		return sendIP;
	}

	/**
	 * 发送短信IP地址设定
	 *
	 * @param sendIP 发送短信IP地址
	 */
	public void setSendIP(String sendIP) {
		this.sendIP = sendIP;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return mid;
	}

}