package com.deliverik.framework.workflow.prd.model.condition;


/**
 * ���̲����߱���Ȩ����ͼ��������ʵ��
 * 
 */
public class IG100SearchCondImpl implements IG100SearchCond {
	
	/** ����״̬ID */
	protected String psdid;

	/** ���̲�����ID */
	protected String ppdid;
	
	/** ��������ID */
	protected String pdid;

	/**
	 * ����״̬IDȡ��
	 * @return ����״̬ID
	 */
	public String getPsdid() {
		return psdid;
	}
	
	/**
	 * ����״̬ID�趨
	 * @param psdid����״̬ID
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
	 * ��������IDȡ��
	 * 
	 * @return ��������ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * ��������ID�趨
	 * 
	 * @param pdid ��������ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}
	
}
