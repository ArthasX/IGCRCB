/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.condition;


/**
 * ���̲����߱���Ȩ�޲�ѯ����ʵ��
 *
 */
public class IG881SearchCondImpl implements IG881SearchCond{
	
	/** 
	 * ���̲����߱���Ȩ��ID 
	 */
	protected String pipdid;
	
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
	 * ���̱�Ȩ��
	 */
	protected String pidaccess;
	
	/**
	 * ����״̬ID
	 */
	protected String psdid;
	
	/**
	 * ���̲�����ID
	 */
	protected String ppdid;
	
	/**
	 * ����ID
	 */
	protected String pdid;
	
	/** 
	 * ���̲����߱���Ȩ��ID
	 */
	protected String pipdid_like;
	
	/**
	 * ����IDȡ��
	 * @return ����ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * ����ID�趨
	 * @param pdid ����ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
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
	 * ���̲�����IDȡ��
	 * @return ���̲�����ID
	 */
	public String getPpdid() {
		return ppdid;
	}

	/**
	 * ���̲�����ID�趨
	 * @param ppdid ���̲�����ID
	 */
	public void setPpdid(String ppdid) {
		this.ppdid = ppdid;
	}

	/**
	 * ���̲����߱���Ȩ��IDȡ��
	 * @return ���̲����߱���Ȩ��ID
	 */
	public String getPipdid() {
		return pipdid;
	}

	/**
	 * ���̲����߱���Ȩ��ID�趨
	 * @param pipdid ���̲����߱���Ȩ��ID
	 */
	public void setPipdid(String pipdid) {
		this.pipdid = pipdid;
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
	 * ���̲����߱���Ȩ��ȡ��
	 * @return ���̲����߱���Ȩ��
	 */
	public String getPidaccess() {
		return pidaccess;
	}

	/**
	 * ���̲����߱���Ȩ���趨
	 * @param pidaccess ���̲����߱���Ȩ��
	 */
	public void setPidaccess(String pidaccess) {
		this.pidaccess = pidaccess;
	}

	/**
	 * ���̲����߱���Ȩ��IDȡ��
	 * 
	 * @return ���̲����߱���Ȩ��ID
	 */
	public String getPipdid_like() {
		return pipdid_like;
	}

	/**
	 * ���̲����߱���Ȩ��ID�趨
	 * 
	 * @param pipdid_like ���̲����߱���Ȩ��ID
	 */
	public void setPipdid_like(String pipdid_like) {
		this.pipdid_like = pipdid_like;
	}
	
}
