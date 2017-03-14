/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 下载记录表接口实例化
  * 功能描述: 下载记录表接口
  * 创建记录: 2014/07/24
  * 修改记录: 
  */
public class IgdocdownInfoImpl implements IgdocdownInfo {

	private  Integer ddid;
	public Integer getDdid() {
		return ddid;
	}

	public void setDdid(Integer ddid) {
		this.ddid = ddid;
	}

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

	public String getFingerPrint() {
		// TODO Auto-generated method stub
		return fingerprint;
	}


}