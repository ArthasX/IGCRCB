package com.deliverik.infogovernor.aim.form;

import com.deliverik.framework.base.BaseForm;

/**
 * �ʲ�ģ�Ͳ�ѯ����FORM
 * 
 */
public class IGAIM0150Form extends BaseForm {

	private static final long serialVersionUID = 1L;

	/**ip*/
	protected String ipText;
	/**ʵ����*/
	protected String appText;
	/**�Ƿ����oracle*/
	protected String oracleFlag;
	
	/**
	 * ipȡ��
	 * @return ipText ip
	 */
	public String getIpText() {
		return ipText;
	}
	/**
	 * ip�趨
	 * @param ipText ip
	 */
	public void setIpText(String ipText) {
		this.ipText = ipText;
	}
	/**
	 * ʵ����ȡ��
	 * @return appText ʵ����
	 */
	public String getAppText() {
		return appText;
	}
	/**
	 * ʵ�����趨
	 * @param appText ʵ����
	 */
	public void setAppText(String appText) {
		this.appText = appText;
	}
	/**
	 * �Ƿ����oracleȡ��
	 * @return oracleFlag �Ƿ����oracle
	 */
	public String getOracleFlag() {
		return oracleFlag;
	}
	/**
	 * �Ƿ����oracle�趨
	 * @param oracleFlag �Ƿ����oracle
	 */
	public void setOracleFlag(String oracleFlag) {
		this.oracleFlag = oracleFlag;
	}
}
