package com.deliverik.infogovernor.asset.dto;

/**
 * 
 * 功能：文件下载DTO
 * @author 史凯龙   2014-7-24
 */
public class IGASM42DTO {

	
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
