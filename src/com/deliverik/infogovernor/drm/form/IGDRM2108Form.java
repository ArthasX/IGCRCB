package com.deliverik.infogovernor.drm.form;

import com.deliverik.framework.base.BaseForm;

@SuppressWarnings("serial")
public class IGDRM2108Form extends BaseForm {
	
	
	/** 专项预案id */
	private Integer planEiid;
	
	/** 目录类型 */
	private String ctype;
	
	/** 目录ID */
	private String cid;

	public Integer getPlanEiid() {
		return planEiid;
	}

	public void setPlanEiid(Integer planEiid) {
		this.planEiid = planEiid;
	}

	public String getCtype() {
		return ctype;
	}

	public void setCtype(String ctype) {
		this.ctype = ctype;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

}
