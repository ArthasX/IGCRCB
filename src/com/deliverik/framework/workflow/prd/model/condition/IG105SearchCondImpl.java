/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.condition;



/**
 * ����: ���̲����趨��Ϣ��������ʵ��
 * �������������̲����趨��Ϣ��������ʵ��
 * ������¼������    2010/11/26
 * �޸ļ�¼��
 */
public class IG105SearchCondImpl implements IG105SearchCond {
	
	/** ���̶���ID */
	protected String pdid;
	
	/** ���԰汾 */
	protected Integer psdversion;
	
	/** ����״̬ */
	protected String prstatus;

	/** �����̶� */
	protected String prurgency;
	
	/**
	 * ��������IDȡ��
	 * @return ��������ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * ��������ID�趨
	 * @param pdid ��������ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}
	
	/**
	 * ���԰汾ȡ��
	 * 
	 * @return ���԰汾
	 */
	public Integer getPsdversion() {
		return psdversion;
	}

	/**
	 * ���԰汾�趨
	 * 
	 * @param psdversion���԰汾
	 */
	public void setPsdversion(Integer psdversion) {
		this.psdversion = psdversion;
	}
	
	/**
	 * ����״̬ȡ��
	 * 
	 * @return ����״̬
	 */
	public String getPrstatus() {
		return prstatus;
	}

	/**
	 * ����״̬�趨
	 * 
	 * @param prstatus����״̬
	 */
	public void setPrstatus(String prstatus) {
		this.prstatus = prstatus;
	}

	/**
	 * �����̶�ȡ��
	 * 
	 * @return �����̶�
	 */
	public String getPrurgency() {
		return prurgency;
	}

	/**
	 * �����̶��趨
	 * 
	 * @param prurgency�����̶�
	 */
	public void setPrurgency(String prurgency) {
		this.prurgency = prurgency;
	}
	
}
