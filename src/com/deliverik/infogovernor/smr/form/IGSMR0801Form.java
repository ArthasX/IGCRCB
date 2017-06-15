/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.smr.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 概述:填报考核
 * 功能描述：填报考核
 * 创建人：赵梓廷
 * 创建记录： 2013-09-02
 * 修改记录：
 */
@SuppressWarnings("serial")
public class IGSMR0801Form extends BaseForm {

	/** 考核开始日期 */
	protected String assessstartdate;
	
	/** 考核结束日期 */
	protected String assessoverdate;
	
	/** 考核类别 1、部门考核 2、人员考核 */
	protected String assesstype;

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
	public String getAssesstype() {
		return assesstype;
	}
	public void setAssesstype(String assesstype) {
		this.assesstype = assesstype;
	}
	
	
}
