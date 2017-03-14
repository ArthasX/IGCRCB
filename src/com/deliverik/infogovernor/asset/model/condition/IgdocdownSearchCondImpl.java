/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.model.condition;

/**
  * 概述: 下载记录表检索条件实现
  * 功能描述: 下载记录表检索条件实现
  * 创建记录: 2014/07/24
  * 修改记录: 
  */
public class IgdocdownSearchCondImpl implements
		IgdocdownSearchCond {
	
	/**  文档资产ID*/
	protected Integer eiid;
	
	/**  下载人*/
	protected String userid;
	
	/**  下载时间*/
	protected String downtime;
	
	/**  下载位置*/
	protected String downlocation;
	
	/**  保留字段*/
	protected String fingerprint;

	public Integer getEiid() {
		return eiid;
	}

	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getDowntime() {
		return downtime;
	}

	public void setDowntime(String downtime) {
		this.downtime = downtime;
	}

	public String getDownlocation() {
		return downlocation;
	}

	public void setDownlocation(String downlocation) {
		this.downlocation = downlocation;
	}

	public String getFingerprint() {
		return fingerprint;
	}

	public void setFingerprint(String fingerprint) {
		this.fingerprint = fingerprint;
	}
}