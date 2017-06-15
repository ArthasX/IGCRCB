/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.smr.vo;

import com.deliverik.framework.base.BaseVO;

/**
 * 概述:填报考核 
 * 功能描述：填报考核
 * 创建人：赵梓廷
 * 创建记录： 2013-09-02
 * 修改记录：
 */
@SuppressWarnings("serial")
public class IGSMR08001VO extends BaseVO {

	/**人员id*/
	protected String userid;
	
	/**人员名称*/
	protected String username;
	
	/**部门机构码*/
	protected String orgid;
	
	/**部门名*/
	protected String orgname;
	
	/**年报填报次数*/
	protected String yearnum;
	
	/**年报填报及时率*/
	protected String yeartime;
	
	/**年报填报正确率*/
	protected String yeartrue;
	
	/**季报填报次数*/
	protected String quarternum;
	
	/**季报填报及时率*/
	protected String quartertime;
	
	/**季报填报正确率*/
	protected String quartertrue;
	
	/**不定期报填报次数*/
	protected String notimenum;
	
	/**不定期报填报及时率*/
	protected String notime;
	
	/**不定期报填报正确率*/
	protected String notimetrue;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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



	public String getYearnum() {
		return yearnum;
	}

	public void setYearnum(String yearnum) {
		this.yearnum = yearnum;
	}

	public String getQuarternum() {
		return quarternum;
	}

	public void setQuarternum(String quarternum) {
		this.quarternum = quarternum;
	}

	public String getNotimenum() {
		return notimenum;
	}

	public void setNotimenum(String notimenum) {
		this.notimenum = notimenum;
	}

	public String getYeartime() {
		return yeartime;
	}

	public void setYeartime(String yeartime) {
		this.yeartime = yeartime;
	}

	public String getYeartrue() {
		return yeartrue;
	}

	public void setYeartrue(String yeartrue) {
		this.yeartrue = yeartrue;
	}

	public String getQuartertime() {
		return quartertime;
	}

	public void setQuartertime(String quartertime) {
		this.quartertime = quartertime;
	}

	public String getQuartertrue() {
		return quartertrue;
	}

	public void setQuartertrue(String quartertrue) {
		this.quartertrue = quartertrue;
	}

	public String getNotime() {
		return notime;
	}

	public void setNotime(String notime) {
		this.notime = notime;
	}

	public String getNotimetrue() {
		return notimetrue;
	}

	public void setNotimetrue(String notimetrue) {
		this.notimetrue = notimetrue;
	}




	
	
	
}
