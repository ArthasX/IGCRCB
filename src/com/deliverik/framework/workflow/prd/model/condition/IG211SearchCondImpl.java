/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.framework.workflow.prd.model.condition;


/**
 * ����״̬����ǰ�����������ʵ��
 *
 */
public class IG211SearchCondImpl implements IG211SearchCond{
	
	/** 
	 * ���� 
	 */
	protected String psidid;
	
	/**
	 * ����״̬ID
	 */
	protected String psdid;
	
	/**
	 * ���̱���ID
	 */
	protected String pidid;

	/**
	 * ���̱�������
	 */
	protected String pidname;
	
	/**
	 * ���̱�������
	 */
	protected String pidtype;	

	/**
	 * ���̱���ֵ
	 */
	protected String pidvalue;
	
	/**
	 * ����״̬ID 
	 */
	protected String psidid_like;

	/**
	 * ����״̬����ǰ����IDȡ��
	 * @return ����״̬����ǰ����ID
	 */
	public String getPsidid() {
		return psidid;
	}

	/**
	 * ����״̬����ǰ����ID�趨
	 * @param psidid ����״̬����ǰ����ID
	 */
	public void setPsidid(String psidid) {
		this.psidid = psidid;
	}

	/**
	 * ����״̬IDȡ��
	 * @return ����״̬ID
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * ����״̬ID�趨
	 * @param psdid ����״̬ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * ���̱���IDȡ��
	 * @return ���̱���ID
	 */
	public String getPidid() {
		return pidid;
	}

	/**
	 * ���̱���ID�趨
	 * @param pidid ���̱���ID
	 */
	public void setPidid(String pidid) {
		this.pidid = pidid;
	}

	/**
	 * ���̱�������ȡ��
	 * @return ���̱�������
	 */
	public String getPidname() {
		return pidname;
	}

	/**
	 * ���̱��������趨
	 * @param pidname ���̱�������
	 */
	public void setPidname(String pidname) {
		this.pidname = pidname;
	}

	/**
	 * ���̱�������ȡ��
	 * @return ���̱�������
	 */
	public String getPidtype() {
		return pidtype;
	}

	/**
	 * ���̱��������趨
	 * @param pidtype ���̱�������
	 */
	public void setPidtype(String pidtype) {
		this.pidtype = pidtype;
	}

	/**
	 * ���̱���ֵȡ��
	 * @return ���̱���ֵ
	 */
	public String getPidvalue() {
		return pidvalue;
	}

	/**
	 * ���̱���ֵ�趨
	 * @param pidvalue ���̱���ֵ
	 */
	public void setPidvalue(String pidvalue) {
		this.pidvalue = pidvalue;
	}

	/**
	 * ����ȡ��
	 * 
	 * @return ���� 
	 */
	public String getPsidid_like() {
		return psidid_like;
	}

	/**
	 * ���� �趨
	 * 
	 * @param psidid_like ���� 
	 */
	public void setPsidid_like(String psidid_like) {
		this.psidid_like = psidid_like;
	}
	
}
