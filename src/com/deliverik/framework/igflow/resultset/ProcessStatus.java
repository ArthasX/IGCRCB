/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.igflow.resultset;

/**
 * ����״̬������Ϣ
 */
public class ProcessStatus implements ProcessStatusInfo {
	
	/** ����״̬ID */
	protected String psdid;
	
	/** ���̶���ID */
	protected String pdid;

	/** ����״̬���� */
	protected String psdname;
	
	/** ����״̬��ʶ */
	protected String psdcode;
	
	/** ���� */
	protected String bysequence;

	/** �ϼ�״̬ID */
	protected String ppsdid;

	/** ״̬��ʼʱ�� */
	protected String opentime;
	
	/** ״̬����ʱ�� */
	protected String closetime;

	/** ״̬��֧��� */
	protected String statusnum;
	
	/** ʱ��� */
	protected String fingerPrint;
	
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
	 * ���̶���IDȡ��
	 * @return ���̶���ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * ���̶���ID�趨
	 * @param pdid ���̶���ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * ����״̬����ȡ��
	 * @return ����״̬����
	 */
	public String getPsdname() {
		return psdname;
	}

	/**
	 * ����״̬�����趨
	 * @param psdname ����״̬����
	 */
	public void setPsdname(String psdname) {
		this.psdname = psdname;
	}
	
	/**
	 * ����״̬��ʶȡ��
	 * @return ����״̬��ʶ
	 */
	public String getPsdcode() {
		return psdcode;
	}

	/**
	 * ����״̬��ʶ�趨
	 * @param psdcode ����״̬��ʶ
	 */
	public void setPsdcode(String psdcode) {
		this.psdcode = psdcode;
	}

	/**
	 * ����ȡ��
	 * 
	 * @return ����
	 */
	public String getBysequence() {
		return bysequence;
	}

	/**
	 * �����趨
	 * 
	 * @param bysequence ����
	 */
	public void setBysequence(String bysequence) {
		this.bysequence = bysequence;
	}

	/**
	 * �ϼ�״̬IDȡ��
	 * @return �ϼ�״̬ID
	 */
	public String getPpsdid() {
		return ppsdid;
	}

	/**
	 * �ϼ�״̬ID�趨
	 * @param ppsdid �ϼ�״̬ID
	 */
	public void setPpsdid(String ppsdid) {
		this.ppsdid = ppsdid;
	}

	/**
	 * ״̬��ʼʱ��ȡ��
	 * @return ״̬��ʼʱ��
	 */
	public String getOpentime() {
		return opentime;
	}

	/**
	 * ״̬��ʼʱ���趨
	 * @param opentime ״̬��ʼʱ��
	 */
	public void setOpentime(String opentime) {
		this.opentime = opentime;
	}

	/**
	 * ״̬��֧���ȡ��
	 * @return ״̬��֧���
	 */
	public String getStatusnum() {
		return statusnum;
	}

	/**
	 * ״̬��֧����趨
	 * @param statusnum ״̬��֧���
	 */
	public void setStatusnum(String statusnum) {
		this.statusnum = statusnum;
	}

	/**
	 * ״̬����ʱ��ȡ��
	 * @return ״̬����ʱ��
	 */
	public String getClosetime() {
		return closetime;
	}

	/**
	 * ״̬����ʱ���趨
	 * @param closetime ״̬����ʱ��
	 */
	public void setClosetime(String closetime) {
		this.closetime = closetime;
	}

	/**
	 * ʱ���ȡ��
	 * @return fingerPrint ʱ���
	 */
	public String getFingerPrint() {
		return fingerPrint;
	}

	/**
	 * ʱ����趨
	 * @param fingerPrint ʱ���
	 */
	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}
	
}
