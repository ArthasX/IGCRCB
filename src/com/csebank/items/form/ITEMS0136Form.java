/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.csebank.items.form;

import com.deliverik.framework.base.BaseForm;

public class ITEMS0136Form extends BaseForm {

	private static final long serialVersionUID = 1L;

	protected String reqorg;
	protected String path;
	protected String mode;
	protected String outtime_f;
	protected String outtime_t;
	
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

	public String getReqorg() {
		return reqorg;
	}

	public void setReqorg(String reqorg) {
		this.reqorg = reqorg;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}