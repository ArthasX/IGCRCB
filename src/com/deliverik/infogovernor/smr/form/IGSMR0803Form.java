/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.smr.form;


import com.deliverik.framework.base.BaseForm;

/**
 * ����:��ر�����ϸҳ form
 * ������������ر�����ϸҳform
 * �����ˣ�
 * ������¼�� 2013/09/04
 * �޸ļ�¼��
 */
@SuppressWarnings("serial")
public class IGSMR0803Form extends BaseForm{

	/** ��ԱID*/
	protected String userid;
	
	/** ����ID */
	protected String orgid;
	
	
	
	/**
	 * ��ԱIDȡ��
	 *
	 * @return ��ԱID
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * ��ԱID�趨
	 *
	 * @param userid ��ԱID
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * ����IDȡ��
	 *
	 * @return ����ID
	 */
	public String getOrgid() {
		return orgid;
	}

	/**
	 * ����ID�趨
	 *
	 * @param orgid ����ID
	 */
	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

}
