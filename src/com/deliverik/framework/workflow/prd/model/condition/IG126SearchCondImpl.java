/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.condition;



/**
 * ����ҳ�涨����Ϣ��������ʵ��
 * 
 */
public class IG126SearchCondImpl implements IG126SearchCond {
	
	/** ���̶���ID */
	protected String pdid;

	/** ҳ������ */
	protected String pjdtype;
	
	/** ����ҳ�涨��ID */
	protected String pjdid_like;
	
	/**
	 * ���̶���IDȡ��
	 * 
	 * @return ���̶���ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * ���̶���ID�趨
	 * 
	 * @param pdid���̶���ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * ҳ������ȡ��
	 * 
	 * @return ҳ������
	 */
	public String getPjdtype() {
		return pjdtype;
	}

	/**
	 * ҳ�������趨
	 * 
	 * @param pjdtypeҳ������
	 */
	public void setPjdtype(String pjdtype) {
		this.pjdtype = pjdtype;
	}

	/**
	 * ����ҳ�涨��IDȡ��
	 * 
	 * @return ����ҳ�涨��ID
	 */
	public String getPjdid_like() {
		return pjdid_like;
	}

	/**
	 * ����ҳ�涨��ID�趨
	 * 
	 * @param pjdid_like ����ҳ�涨��ID
	 */
	public void setPjdid_like(String pjdid_like) {
		this.pjdid_like = pjdid_like;
	}
	
}
