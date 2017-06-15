/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.smr.model.condition;

/**
 * 概述:填报考核 
 * 功能描述：填报考核 
 * 创建人：赵梓廷
 * 创建记录： 2013-08-30
 * 修改记录：
 */
public class FillInQualityAssessSearchCondImpl implements FillInQualityAssessSearchCond{

	/** 考核开始日期 */
	protected String assessstartdate;
	
	/** 考核结束日期 */
	protected String assessoverdate;
	
	/** 用户ID */
	protected String userid;
	
	/** 机构ID */
	protected String orgid;

	public String getAssessstartdate() {
		return assessstartdate;
	}
	public void setAssessstartdate(String assessstartdate) {
		this.assessstartdate = assessstartdate;
	}

	public String getAssessoverdate() {
		return assessoverdate;
	}

	public void setAssessoverdate(String assessoverdate) {
		this.assessoverdate = assessoverdate;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getOrgid() {
		return orgid;
	}
	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}
	
	
	
	
	
}
