/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.fxk.model.condition;

/**
  * 概述: 风险管理提示接收者数据表检索条件实现
  * 功能描述: 风险管理提示接收者数据表检索条件实现
  * 创建记录: 2014/06/17
  * 修改记录: 
  */
public class AcceptuserSearchCondImpl implements
		AcceptuserSearchCond {
	
	/** 接收者id */
	protected String apuserid;
	/** 接收者名字 */
	protected String apusername;

	/** 接收机构码 */
	protected String aporgid;

	/** 接收机构名称 */
	protected String aporgname;

	/** 风险提示主键 */
	protected Integer rwid;

	/**
	 * 接收者名字取得
	 * @return apusername 接收者名字
	 */
	
	public String getApusername() {
		return apusername;
	}

	/**
	 * 接收者名字设定
	 * @param apusername 接收者名字
	 */
	public void setApusername(String apusername) {
		this.apusername = apusername;
	}

	/**
	 * 接收机构码取得
	 * @return aporgid 接收机构码
	 */
	
	public String getAporgid() {
		return aporgid;
	}

	/**
	 * 接收机构码设定
	 * @param aporgid 接收机构码
	 */
	public void setAporgid(String aporgid) {
		this.aporgid = aporgid;
	}

	/**
	 * 接收机构名称取得
	 * @return aporgname 接收机构名称
	 */
	
	public String getAporgname() {
		return aporgname;
	}

	/**
	 * 接收机构名称设定
	 * @param aporgname 接收机构名称
	 */
	public void setAporgname(String aporgname) {
		this.aporgname = aporgname;
	}

	/**
	 * 风险提示主键取得
	 * @return rwid 风险提示主键
	 */
	
	public Integer getRwid() {
		return rwid;
	}

	/**
	 * 风险提示主键设定
	 * @param rwid 风险提示主键
	 */
	public void setRwid(Integer rwid) {
		this.rwid = rwid;
	}

	public String getApuserid() {
		return null;
	}

	/**
	 * 接收者id设定
	 * @param apuserid 接收者id
	 */
	public void setApuserid(String apuserid) {
		this.apuserid = apuserid;
	}
}