package com.deliverik.infogovernor.asset.dto;

/**
 * 
 * ���ܣ��ļ�����DTO
 * @author ʷ����   2014-7-24
 */
public class IGASM42DTO {

	
	/**  �ĵ��ʲ�ID*/
	protected Integer eiid;
	
	/**  ������*/
	protected String userid;
	
	/**  ����ʱ��*/
	protected String downtime;
	
	/**  ����λ��*/
	protected String downlocation;
	
	/**  �����ֶ�*/
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
