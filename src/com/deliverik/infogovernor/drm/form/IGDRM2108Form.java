package com.deliverik.infogovernor.drm.form;

import com.deliverik.framework.base.BaseForm;

@SuppressWarnings("serial")
public class IGDRM2108Form extends BaseForm {
	
	
	/** ר��Ԥ��id */
	private Integer planEiid;
	
	/** Ŀ¼���� */
	private String ctype;
	
	/** Ŀ¼ID */
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
