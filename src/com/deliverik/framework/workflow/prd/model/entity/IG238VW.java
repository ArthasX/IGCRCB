/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.workflow.prd.model.IG238Info;

/**
  * 概述: 流程通知策略实体
  * 功能描述: 流程通知策略实体
  * 创建记录: 2012/04/24
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@IdClass(IG212PK.class)
public class IG238VW implements Serializable,
		Cloneable, IG238Info {

	/** 状态ID */
	@Id
	protected String psdid;

	/** 是否确认 */
	@Id
	protected String psdconfirm;
	
	/** 状态名称 */
	protected String psdname;

	/** 是否发送短信 */
	protected String sms;

	/** 是否发送邮件 */
	protected String email;

	/** 通知人 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumns({
		  @JoinColumn(name="psdid", referencedColumnName="psdid" ,updatable=false, insertable= false),
		  @JoinColumn(name="psdconfirm", referencedColumnName="psdconfirm",updatable=false, insertable= false)
		      })
	@NotFound(action = NotFoundAction.IGNORE)
	protected List<IG237TB> lst_ProcessNoticeStrategyUser;
	
	/** 通知人ID */
	@Transient
	protected String notifierids;
	
	/** 通知人名称 */
	@Transient
	protected String notifiernames;

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
	 * 通知人设定
	 * 
	 * @return 通知人
	 */
	public List<IG237TB> getLst_ProcessNoticeStrategyUser() {
		return lst_ProcessNoticeStrategyUser;
	}
	
	/**
	 * 通知人ID取得
	 * 
	 * @return 通知人ID
	 */
	public String getNotifierids() {
		if(this.lst_ProcessNoticeStrategyUser != null) {
			StringBuffer sbf_notifierids = new StringBuffer();
			for(IG237TB bean : lst_ProcessNoticeStrategyUser) {
				sbf_notifierids.append(bean.getRoleid()).append("##").append(bean.getUserid()).append("###");
			}
			if(sbf_notifierids.length() > 0) {
				this.notifierids = sbf_notifierids.substring(0, sbf_notifierids.length() - 3);
			}
		}
		return notifierids;
	}

	/**
	 * 通知人ID设定
	 * 
	 * @param notifierids 通知人ID
	 */
	public void setNotifierids(String notifierids) {
		this.notifierids = notifierids;
	}

	/**
	 * 通知人名称取得
	 * 
	 * @return 通知人名称
	 */
	public String getNotifiernames() {
		if(this.lst_ProcessNoticeStrategyUser != null) {
			StringBuffer sbf_notifiernames = new StringBuffer();
			for(IG237TB bean : lst_ProcessNoticeStrategyUser) {
				sbf_notifiernames.append(bean.getUser().getUsername()).append("，");
			}
			if(sbf_notifiernames.length() > 0) {
				this.notifiernames = sbf_notifiernames.substring(0, sbf_notifiernames.length() - 1);
			}
		}
		return notifiernames;
	}

	/**
	 * 通知人名称设定
	 * 
	 * @param notifiernames 通知人名称
	 */
	public void setNotifiernames(String notifiernames) {
		this.notifiernames = notifiernames;
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