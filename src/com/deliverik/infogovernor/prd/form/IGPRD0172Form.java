/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.prd.form;

import com.deliverik.framework.base.BaseForm;

/**
 * ��Ȩ��FORM
 * @author byf 2012-10-16
 *
 */
@SuppressWarnings("serial")
public class IGPRD0172Form extends BaseForm{
	
	/** ���̶���ID */
	private String pdid;
	
	/** ��ɫID */
	private String roleid;
	
	/** ���б����� */
	protected String[] pidida;
	
	/** ��ѡ������ */
	protected String[] pididb;
	
	/**����ʽ��0-ɾ����1-����*/
	protected String mode;

	public String getPdid() {
		return pdid;
	}

	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getRoleid() {
		return roleid;
	}

	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}

	public String[] getPidida() {
		return pidida;
	}

	public void setPidida(String[] pidida) {
		this.pidida = pidida;
	}

	public String[] getPididb() {
		return pididb;
	}

	public void setPididb(String[] pididb) {
		this.pididb = pididb;
	}

	
}
