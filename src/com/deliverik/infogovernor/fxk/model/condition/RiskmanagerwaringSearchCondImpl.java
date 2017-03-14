/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.fxk.model.condition;

/**
  * 概述: 风险管理提示数据表检索条件实现
  * 功能描述: 风险管理提示数据表检索条件实现
  * 创建记录: 2014/06/17
  * 修改记录: 
  */
public class RiskmanagerwaringSearchCondImpl implements RiskmanagerwaringSearchCond {
	
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
	
	/** 被下发用户用户ID */
	protected String userid;
	protected String username_s;
	

	public String getUsername_s() {
		return username_s;
	}

	public void setUsername_s(String username_s) {
		this.username_s = username_s;
	}

	/**
	 * 风险提示名称取得
	 * @return rwname 风险提示名称
	 */
	
	public String getRwname() {
		return rwname;
	}

	/**
	 * 风险提示名称设定
	 * @param rwname 风险提示名称
	 */
	public void setRwname(String rwname) {
		this.rwname = rwname;
	}

	/**
	 * 下发起者id取得
	 * @return nuserid 下发起者id
	 */
	
	public String getNuserid() {
		return nuserid;
	}

	/**
	 * 下发起者id设定
	 * @param nuserid 下发起者id
	 */
	public void setNuserid(String nuserid) {
		this.nuserid = nuserid;
	}

	/**
	 * 下发起者名字取得
	 * @return nusername 下发起者名字
	 */
	
	public String getNusername() {
		return nusername;
	}

	/**
	 * 下发起者名字设定
	 * @param nusername 下发起者名字
	 */
	public void setNusername(String nusername) {
		this.nusername = nusername;
	}

	/**
	 * 下发者机构名取得
	 * @return norgname 下发者机构名
	 */
	
	public String getNorgname() {
		return norgname;
	}

	/**
	 * 下发者机构名设定
	 * @param norgname 下发者机构名
	 */
	public void setNorgname(String norgname) {
		this.norgname = norgname;
	}

	/**
	 * 下发者机构码取得
	 * @return norgid 下发者机构码
	 */
	
	public String getNorgid() {
		return norgid;
	}

	/**
	 * 下发者机构码设定
	 * @param norgid 下发者机构码
	 */
	public void setNorgid(String norgid) {
		this.norgid = norgid;
	}

	/**
	 * 下发时间取得
	 * @return ntime 下发时间
	 */
	
	public String getNtime() {
		return ntime;
	}

	/**
	 * 下发时间设定
	 * @param ntime 下发时间
	 */
	public void setNtime(String ntime) {
		this.ntime = ntime;
	}

	/**
	 * 被下发用户用户ID取得
	 * @return userid 被下发用户用户ID
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * 被下发用户用户ID设定
	 * @param userid 被下发用户用户ID
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

}