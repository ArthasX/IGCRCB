/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.dbm.form;

import com.deliverik.framework.base.BaseForm;

/**
 * �Ƽ������ۺϷ���(һ)DashBaord��ѯ��� form
 * 
 * @author 
 *
 */
public class IGDBM1201Form extends BaseForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9028486377175964658L;

	/*�������������ù���������Ӧ��PRPDID*/
	private String workValue;
	
	private String prtype;
	
	/** ���̶������� */
	protected String prpdid;

	public String getWorkValue() {
		return workValue;
	}

	public void setWorkValue(String workValue) {
		this.workValue = workValue;
	}

	public String getPrtype() {
		return prtype;
	}

	public void setPrtype(String prtype) {
		this.prtype = prtype;
	}
	
	/**
	 * ���̶�������ȡ��
	 * @return prpdid ���̶�������
	 */
	public String getPrpdid() {
		return prpdid;
	}

	/**
	 * ���̶��������趨
	 * @param prpdid ���̶�������
	 */
	public void setPrpdid(String prpdid) {
		this.prpdid = prpdid;
	}

}
