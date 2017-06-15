/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.csebank.items.form;

import com.csebank.items.model.condition.ItemsPaySearchCond;
import com.deliverik.framework.base.BaseForm;

public class ITEMS0135Form extends BaseForm implements ItemsPaySearchCond{

	private static final long serialVersionUID = 1L;

	protected String outtime_f;
	protected String outtime_t;
	protected String path;
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getOuttime_f() {
		return outtime_f;
	}
	public void setOuttime_f(String outtime_f) {
		this.outtime_f = outtime_f;
	}
	public String getOuttime_t() {
		return outtime_t;
	}
	public void setOuttime_t(String outtime_t) {
		this.outtime_t = outtime_t;
	}

}