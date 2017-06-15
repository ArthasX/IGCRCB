/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prd.model.IG212Info;

/**
  * 概述: 流程通知策略实体
  * 功能描述: 流程通知策略实体
  * 创建记录: 2012/04/24
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@IdClass(IG212PK.class)
@Table(name="IG212")
public class IG212TB extends BaseEntity implements Serializable,
		Cloneable, IG212Info {

	/** 状态ID */
	@Id
	protected String psdid;

	/** 是否确认 */
	@Id
	protected String psdconfirm;
	
	/** 状态名称 */
	@Transient
	protected String psdname;

	/** 是否发送短信 */
	protected String sms;

	/** 是否发送邮件 */
	protected String email;


	/** 流程定义Id */
	protected String pdid;
	
	/**
	 * 状态ID取得
	 *
	 * @return 状态ID
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * 状态ID设定
	 *
	 * @param psdid 状态ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * 是否确认取得
	 *
	 * @return 是否确认
	 */
	public String getPsdconfirm() {
		return psdconfirm;
	}

	/**
	 * 是否确认设定
	 *
	 * @param psdconfirm 是否确认
	 */
	public void setPsdconfirm(String psdconfirm) {
		this.psdconfirm = psdconfirm;
	}
	

	/**
	 * 状态名称取得
	 * 
	 * @return 状态名称
	 */
	public String getPsdname() {
		return psdname;
	}

	/**
	 * 状态名称设定
	 * 
	 * @param psdname 状态名称
	 */
	public void setPsdname(String psdname) {
		this.psdname = psdname;
	}

	/**
	 * 是否发送短信取得
	 *
	 * @return 是否发送短信
	 */
	public String getSms() {
		return sms;
	}

	/**
	 * 是否发送短信设定
	 *
	 * @param sms 是否发送短信
	 */
	public void setSms(String sms) {
		this.sms = sms;
	}

	/**
	 * 是否发送邮件取得
	 *
	 * @return 是否发送邮件
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 是否发送邮件设定
	 *
	 * @param email 是否发送邮件
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 流程定义Id取得
	 * @return pdid 流程定义Id
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * 流程定义Id设定
	 * @param pdid 流程定义Id
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return new IG212PK(psdid, psdconfirm);
	}

}