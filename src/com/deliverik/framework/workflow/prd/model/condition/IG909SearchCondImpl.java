package com.deliverik.framework.workflow.prd.model.condition;


/**
 * ����ȱʡ����Ȩ����ͼ��������ʵ��
 * 
 */
public class IG909SearchCondImpl implements IG909SearchCond {
	
	/** ����״̬ID */
	protected String psdid;

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
