/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.condition;


/**
  * ����: ����״̬�ɷ��ɽ�ɫ������Ϣ��������ʵ��
  * ��������: ����״̬�ɷ��ɽ�ɫ������Ϣ��������ʵ��
  * ������¼: 2012/04/11
  * �޸ļ�¼: 
  */
public class IG298SearchCondImpl implements
		IG298SearchCond {
	
	/** ����״̬ID */
	protected String psdid;
	
	/** ��ɫID */
	protected Integer roleid;
	
	/** ���� */
	protected String psrdid_like;
	
	/**
	 * ����״̬IDȡ��
	 * 
	 * @return ����״̬ID
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * ����״̬ID�趨
	 * 
	 * @param psdid ����״̬ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}
	
	/**
	 * ��ɫIDȡ��
	 * 
	 * @return ��ɫID
	 */
	public Integer getRoleid() {
		return roleid;
	}

	/**
	 * ��ɫID�趨
	 * 
	 * @param roleid ��ɫID
	 */
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	/**
	 * ����ȡ��
	 * 
	 * @return ����
	 */
	public String getPsrdid_like() {
		return psrdid_like;
	}

	/**
	 * �����趨
	 * 
	 * @param psrdid_like ����
	 */
	public void setPsrdid_like(String psrdid_like) {
		this.psrdid_like = psrdid_like;
	}
	
}