/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.form;

import com.csebank.lom.model.condition.GoutDetailSearchCond;
import com.deliverik.framework.base.BaseForm;

/**
 * 模块：食堂管理-食堂出库明细
 * 说明：出库明细Form
 * 作者：唐晓娜
 */
public class IGLOM0513Form extends BaseForm implements GoutDetailSearchCond {
	

	private static final long serialVersionUID = 1L;
    protected String month_from;
    protected String month_to;
    protected String year;
    protected String useType;
    protected String guser;

	public String getUseType() {
		return useType;
	}
	public void setUseType(String useType) {
		this.useType = useType;
	}
	public String getGuser() {
		return guser;
	}
	public void setGuser(String guser) {
		this.guser = guser;
	}
	public String getMonth_from() {
		return month_from;
	}
	public void setMonth_from(String month_from) {
		this.month_from = month_from;
	}
	public String getMonth_to() {
		return month_to;
	}
	public void setMonth_to(String month_to) {
		this.month_to = month_to;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	

}
