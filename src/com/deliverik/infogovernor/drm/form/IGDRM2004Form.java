package com.deliverik.infogovernor.drm.form;

import com.deliverik.framework.base.BaseForm;

@SuppressWarnings("serial")
public class IGDRM2004Form extends BaseForm {

	// 查询条件 - 模板名
	private String ename_q;

	// 欲显示详细信息的EID
	private String eid;
	
	// 默认查询次层次码以888001开头的
	private String esyscoding_q = "888001";
	

	public String getEname_q() {
		return ename_q;
	}

	public void setEname_q(String ename_q) {
		this.ename_q = ename_q;
	}

	public String getEid() {
		return eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}

	public String getEsyscoding_q() {
		return esyscoding_q;
	}

	public void setEsyscoding_q(String esyscoding_q) {
		this.esyscoding_q = esyscoding_q;
	}

}
