/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.framework.workflow.prd.model.condition;


/**
 * ����ȱʡ�����߱���Ȩ�޲�ѯ����ʵ��
 *
 */
public class IG699SearchCondImpl implements IG699SearchCond{
	
	/**
	 * ����״̬ID
	 */
	protected String psdid;
	
	/**
	 * ����
	 */
	protected String pdvid_like;
	
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
	 * ����ȡ��
	 * 
	 * @return ����
	 */
	public String getPdvid_like() {
		return pdvid_like;
	}

	/**
	 * �����趨
	 * 
	 * @param pdvid_like ����
	 */
	public void setPdvid_like(String pdvid_like) {
		this.pdvid_like = pdvid_like;
	}
	
}
