/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prd.form;

import com.deliverik.framework.base.BaseForm;

/**
 * �����̽��н�ɫ��ȨFORM
 */
@SuppressWarnings("serial")
public class IGPRD0190Form extends BaseForm{
	
	/**��ʼ����XML*/
	protected String initXML;
	/**������XML*/
	protected String updXML;
	
	protected String pdXML;
	
	protected String pdid;
	
	protected String userRoleXML;
	
	protected String resultXMl;
	
	/**�ɱ༭״̬*/
	protected String editable;
	

	public String getEditable() {
		return editable;
	}

	public void setEditable(String editable) {
		this.editable = editable;
	}

	public String getResultXMl() {
		return resultXMl;
	}

	public void setResultXMl(String resultXMl) {
		this.resultXMl = resultXMl;
	}

	public String getUserRoleXML() {
		return userRoleXML;
	}

	public void setUserRoleXML(String userRoleXML) {
		this.userRoleXML = userRoleXML;
	}

	public String getPdXML() {
		return pdXML;
	}

	public void setPdXML(String pdXML) {
		this.pdXML = pdXML;
	}

	public String getPdid() {
		return pdid;
	}

	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	public String getInitXML() {
		return initXML;
	}

	public void setInitXML(String initXML) {
		this.initXML = initXML;
	}

	public String getUpdXML() {
		return updXML;
	}

	public void setUpdXML(String updXML) {
		this.updXML = updXML;
	}
	
	
}
