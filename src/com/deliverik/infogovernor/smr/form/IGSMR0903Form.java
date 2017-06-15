/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.smr.form;

import com.deliverik.framework.base.BaseForm;


@SuppressWarnings("serial")
public class IGSMR0903Form extends BaseForm {
	
	protected String year;
	
	protected String quarter;
	
	protected String projectAttr;//项目属性
	
	
	public String getProjectAttr() {
		return projectAttr;
	}

	public void setProjectAttr(String projectAttr) {
		this.projectAttr = projectAttr;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getQuarter() {
		return quarter;
	}

	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}

}
