package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;

import com.deliverik.framework.base.BaseVO;

/**
 * 待上缴设备信息ＶＯ
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGASM03131VO extends BaseVO implements Serializable{
	
	/** 设备所属机构id */
	protected String orgid;
	
	/** 设备所属机构name */
	protected String orgname;
	
	/** 设备下发时间 */
	protected String issuetime;
	
	/** 设备领用人 */
	protected String recivename;

	/**
	 * 构造函数
	 */
	public IGASM03131VO() {
	}

	

	public String getRecivename() {
		return recivename;
	}



	public void setRecivename(String recivename) {
		this.recivename = recivename;
	}



	public String getOrgid() {
		return orgid;
	}



	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}



	public String getOrgname() {
		return orgname;
	}



	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}



	public String getIssuetime() {
		return issuetime;
	}



	public void setIssuetime(String issuetime) {
		this.issuetime = issuetime;
	}


	
	
}


