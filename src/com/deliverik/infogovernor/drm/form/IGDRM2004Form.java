package com.deliverik.infogovernor.drm.form;

import com.deliverik.framework.base.BaseForm;

@SuppressWarnings("serial")
public class IGDRM2004Form extends BaseForm {

	// ��ѯ���� - ģ����
	private String ename_q;

	// ����ʾ��ϸ��Ϣ��EID
	private String eid;
	
	// Ĭ�ϲ�ѯ�β������888001��ͷ��
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
