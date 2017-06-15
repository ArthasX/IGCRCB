/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.model.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.user.model.entity.UserTB;
import com.deliverik.framework.workflow.prr.model.IG711Info;

/**
 * <p>概述:授权管理实体</p>
 * <p>功能描述：</p>
 * <p>创建记录：</p>
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="IG711")
public class IG711TB extends BaseEntity implements Serializable, Cloneable, IG711Info {
	/** 授权管理ID */
	@Id
	@TableGenerator(
		    name="IG711_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="IG711_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="IG711_TABLE_GENERATOR")
	
	/** 授权ID*/
	protected Integer paid;
	
	/** 使用人ID*/
	protected String paiid;
	
	/** 授权人ID*/
	protected String pauid;
	
	/** 授权开始日期*/
	protected String pabegintime;
	
	/** 授权结束日期*/
	protected String paendtime;
	
	/** 授权标识位*/
	protected String paflag;
	
	/** 授权类型*/
	protected String patype;
	
	/** 工作(流程)ID*/
	protected Integer paprocessid ;
	
	/** 工作(流程)编号*/
	protected String paprocessnum ;
	
	/** 授权登记时间*/
	protected String palogintime;
	
	/** 授权说明*/
	protected String remarks;
	
	@OneToOne
	@JoinColumn(name="paiid", referencedColumnName="userid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	/** 授权人TB*/
	protected UserTB userTB_A;
	@OneToOne
	@JoinColumn(name="pauid", referencedColumnName="userid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	
	/** 被授权人TB*/
	protected UserTB userTB_B;
	/**
	 * 功能：主键取得
	 * @return 
	 */
	public Serializable getPK() {
		return paid;
	}
	
	/**
	 * 功能：授权ID取得
	 * 
	 * @return 授权ID
	 */
	
	public Integer getPaid() {
		return paid;
	}

	/**
	 * 功能：授权ID设定
	 *
	 * @param paid 授权ID
	 */
	public void setPaid(Integer paid) {
		this.paid = paid;
	}

	/**
	 * 功能：使用人ID取得
	 * 
	 * @return 使用人ID
	 */
	public String getPaiid() {
		return paiid;
	}

	/**
	 * 功能：使用人ID设定
	 *
	 * @param paiid 使用人ID
	 */
	public void setPaiid(String paiid) {
		this.paiid = paiid;
	}

	/**
	 * 功能：授权人ID取得
	 * 
	 * @return 授权人ID
	 */
	public String getPauid() {
		return pauid;
	}

	/**
	 * 功能：授权人ID设定
	 *
	 * @param pauid 授权人ID
	 */
	public void setPauid(String pauid) {
		this.pauid = pauid;
	}

	/**
	 * 功能：授权开始日期取得
	 * 
	 * @return 授权开始日期
	 */
	public String getPabegintime() {
		return pabegintime;
	}

	/**
	 * 功能：授权开始日期设定
	 *
	 * @param pabegintime 授权开始日期
	 */
	public void setPabegintime(String pabegintime) {
		this.pabegintime = pabegintime;
	}

	/**
	 * 功能：授权结束日期取得
	 * 
	 * @return 授权结束日期
	 */
	public String getPaendtime() {
		return paendtime;
	}

	/**
	 * 功能：授权结束日期设定
	 *
	 * @param paendtime 授权结束日期
	 */
	public void setPaendtime(String paendtime) {
		this.paendtime = paendtime;
	}

	/**
	 * 功能：授权标识位取得
	 * 
	 * @return 授权标识位
	 */
	public String getPaflag() {
		return paflag;
	}

	/**
	 * 功能：授权标识位设定
	 *
	 * @param paflag 授权标识位
	 */
	public void setPaflag(String paflag) {
		this.paflag = paflag;
	}

	/**
	 * 功能：授权类型取得
	 * 
	 * @return 授权类型
	 */
	public String getPatype() {
		return patype;
	}

	/**
	 * 功能：授权类型设定
	 *
	 * @param paflag 授权类型
	 */
	public void setPatype(String patype) {
		this.patype = patype;
	}

	/**
	 * 功能：工作编号取得
	 * 
	 * @return 工作编号
	 */
	public String getPaprocessnum() {
		return paprocessnum;
	}

	/**
	 * 功能：工作编号设定
	 *
	 * @param paflag 工作编号
	 */
	public void setPaprocessnum(String paprocessnum) {
		this.paprocessnum = paprocessnum;
	}
	
	/**
	 * 功能：工作ID取得
	 * 
	 * @return 工作ID
	 */
	public Integer getPaprocessid() {
		return paprocessid;
	}

	/**
	 * 功能：工作ID设定
	 *
	 * @param paflag 工作ID
	 */
	public void setPaprocessid(Integer paprocessid) {
		this.paprocessid = paprocessid;
	}

	/**
	 * 功能：授权登记时间取得
	 * 
	 * @return 授权登记时间
	 */
	public String getPalogintime() {
		return palogintime;
	}

	/**
	 * 功能：授权登记时间设定
	 *
	 * @param paflag 授权登记时间
	 */
	public void setPalogintime(String palogintime) {
		this.palogintime = palogintime;
	}

	/**
	 * 功能：授权人TB取得
	 * @return userTB_A 授权人TB
	 */
	public UserTB getUserTB_A() {
		return userTB_A;
	}
	
	/**
	 * 功能：授权人TB设置
	 * @param userTB_A 授权人TB
	 */
	public void setUserTB_A(UserTB userTB_A) {
		this.userTB_A = userTB_A;
	}

	/**
	 * 功能：被授权人TB取得
	 * @return userTB_B 被授权人TB
	 */
	public UserTB getUserTB_B() {
		return userTB_B;
	}

	/**
	 * 功能：被授权人TB设置
	 * @param userTB_B 被授权人TB
	 */
	public void setUserTB_B(UserTB userTB_B) {
		this.userTB_B = userTB_B;
	}

	/**
	 * 授权说明取得
	 * @return 授权说明
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * 授权说明设定
	 * @param remarks授权说明
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
}
