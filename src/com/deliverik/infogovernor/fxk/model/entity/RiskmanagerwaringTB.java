/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.fxk.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;

import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.fxk.model.RiskmanagerwaringInfo;

/**
  * 概述: 风险管理提示数据表实体
  * 功能描述: 风险管理提示数据表实体
  * 创建记录: 2014/06/17
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="riskmanagerwaring")
public class RiskmanagerwaringTB extends BaseEntity implements Serializable,
		Cloneable, RiskmanagerwaringInfo {

	/** 主键 */
	@Id
	@TableGenerator(
		name="RISKMANAGERWARING_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="RISKMANAGERWARING_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="RISKMANAGERWARING_TABLE_GENERATOR")
	protected Integer rwid;

	/** 风险提示名称 */
	protected String rwname;

	/** 下发起者id */
	protected String nuserid;

	/** 下发起者名字 */
	protected String nusername;

	/** 下发者机构名 */
	protected String norgname;

	/** 下发者机构码 */
	protected String norgid;

	/** 下发时间 */
	protected String ntime;

	/** 下发者联系方式 */
	protected String ntel;

	/** 风险提示描述 */
	protected String rwcontext;

	/** 提示附件 */
	protected String rwkey;
	
	/** 显示日期 */
	@Transient
	protected String showTime;

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getRwid() {
		return rwid;
	}

	/**
	 * 主键设定
	 *
	 * @param rwid 主键
	 */
	public void setRwid(Integer rwid) {
		this.rwid = rwid;
	}

	/**
	 * 风险提示名称取得
	 *
	 * @return 风险提示名称
	 */
	public String getRwname() {
		return rwname;
	}

	/**
	 * 风险提示名称设定
	 *
	 * @param rwname 风险提示名称
	 */
	public void setRwname(String rwname) {
		this.rwname = rwname;
	}

	/**
	 * 下发起者id取得
	 *
	 * @return 下发起者id
	 */
	public String getNuserid() {
		return nuserid;
	}

	/**
	 * 下发起者id设定
	 *
	 * @param nuserid 下发起者id
	 */
	public void setNuserid(String nuserid) {
		this.nuserid = nuserid;
	}

	/**
	 * 下发起者名字取得
	 *
	 * @return 下发起者名字
	 */
	public String getNusername() {
		return nusername;
	}

	/**
	 * 下发起者名字设定
	 *
	 * @param nusername 下发起者名字
	 */
	public void setNusername(String nusername) {
		this.nusername = nusername;
	}

	/**
	 * 下发者机构名取得
	 *
	 * @return 下发者机构名
	 */
	public String getNorgname() {
		return norgname;
	}

	/**
	 * 下发者机构名设定
	 *
	 * @param norgname 下发者机构名
	 */
	public void setNorgname(String norgname) {
		this.norgname = norgname;
	}

	/**
	 * 下发者机构码取得
	 *
	 * @return 下发者机构码
	 */
	public String getNorgid() {
		return norgid;
	}

	/**
	 * 下发者机构码设定
	 *
	 * @param norgid 下发者机构码
	 */
	public void setNorgid(String norgid) {
		this.norgid = norgid;
	}

	/**
	 * 下发时间取得
	 *
	 * @return 下发时间
	 */
	public String getNtime() {
		return ntime;
	}

	/**
	 * 下发时间设定
	 *
	 * @param ntime 下发时间
	 */
	public void setNtime(String ntime) {
		this.ntime = ntime;
	}

	/**
	 * 下发者联系方式取得
	 *
	 * @return 下发者联系方式
	 */
	public String getNtel() {
		return ntel;
	}

	/**
	 * 下发者联系方式设定
	 *
	 * @param ntel 下发者联系方式
	 */
	public void setNtel(String ntel) {
		this.ntel = ntel;
	}

	/**
	 * 风险提示描述取得
	 *
	 * @return 风险提示描述
	 */
	public String getRwcontext() {
		return rwcontext;
	}

	/**
	 * 风险提示描述设定
	 *
	 * @param rwcontext 风险提示描述
	 */
	public void setRwcontext(String rwcontext) {
		this.rwcontext = rwcontext;
	}

	/**
	 * 提示附件取得
	 *
	 * @return 提示附件
	 */
	public String getRwkey() {
		return rwkey;
	}

	/**
	 * 提示附件设定
	 *
	 * @param rwkey 提示附件
	 */
	public void setRwkey(String rwkey) {
		this.rwkey = rwkey;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return rwid;
	}

	/**
	 * 显示日期取得
	 * @return showTime 显示日期
	 */
	public String getShowTime() {
		if(StringUtils.isNotEmpty(this.ntime)){
			if(this.ntime.length() > 10){
				this.showTime = this.ntime.substring(0,10);
			}else{
				this.showTime = this.ntime;
			}
		}
		return showTime;
	}

	/**
	 * 显示日期设定
	 * @param showTime 显示日期
	 */
	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}

	
}