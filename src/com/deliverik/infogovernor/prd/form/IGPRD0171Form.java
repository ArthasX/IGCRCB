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
public class IGPRD0171Form extends BaseForm{
	
	/** ���̶���ID */
	private String pdid;
	
	/**�����߽�ɫID����*/
	protected String[] roleids;
	
	protected String[] prdids;
	
	/**����ʽ��0-ɾ����1-����*/
	protected String mode;
	
	/** �鿴ģʽ 0���£��ɱ༭��1����ʷ��ֻ�鿴 */
	protected String viewhistory;

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

	public String[] getRoleids() {
		return roleids;
	}

	public void setRoleids(String[] roleids) {
		this.roleids = roleids;
	}

	public String[] getPrdids() {
		return prdids;
	}

	public void setPrdids(String[] prdids) {
		this.prdids = prdids;
	}
	
	/**
	 * �鿴ģʽ
	 *
	 * @return �鿴ģʽ
	 */
	public String getViewhistory() {
		return viewhistory;
	}

	/**
	 * �鿴ģʽ
	 *
	 * @param viewHistory  0�����£�1��ʷ
	 */
	public void setViewhistory(String viewhistory) {
		this.viewhistory = viewhistory;
	}
	
}
