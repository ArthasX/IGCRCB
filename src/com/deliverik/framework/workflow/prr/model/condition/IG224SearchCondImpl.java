/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prr.model.condition;

/**
 * ����״̬��־��ѯ����ʵ��
 */
public class IG224SearchCondImpl implements IG224SearchCond {

	/** ����ID */
	protected Integer prid;
	
	/** �Ƿ��ѯ���̵�ǰ״̬��¼��ʶ */
	protected boolean currentPrstatus;
	
	/** ����״̬ */
	private String prstatus;
	
	/** ����״̬NOT */
	protected String prstatus_ne;

	/** ����״̬����ID */
	protected String psdid;
	
	/** �ϼ�����״̬����ID */
	protected String ppsdid;
	
	/** ����ڵ�״̬ */
	protected String virtualstatus;

	/** ��ǰ״̬ */
	protected String nowstatus;
	
	/** ��̬��֧��� */
	protected Integer psdnum;
	
	/** �Ƿ���� */
	protected boolean pend;
	
	/**
	 * ����IDȡ��
	 * 
	 * @return ����ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * ����IDȡ��
	 * 
	 * @param prid ����ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * ����״̬ȡ��
	 * 
	 * @return ����״̬
	 */
	public boolean isCurrentPrstatus() {
		return currentPrstatus;
	}

	/**
	 * �Ƿ��ѯ���̵�ǰ״̬��¼��ʶ�趨
	 * 
	 * @param currentPrstatus �Ƿ��ѯ���̵�ǰ״̬��¼��ʶ
	 */
	public void setCurrentPrstatus(boolean currentPrstatus) {
		this.currentPrstatus = currentPrstatus;
	}

	/**
	 * ����״̬��ʶ�趨
	 * @param prstatus
	 */
	public void setPrstatus(String prstatus) {
		this.prstatus = prstatus;
	}

	/**
	 * ����״̬��ȡ
	 * @return
	 */
	public String getPrstatus() {
		return prstatus;
	}

	/**
	 * ����״̬NOTȡ��
	 * @return ����״̬NOT
	 */
	public String getPrstatus_ne() {
		return prstatus_ne;
	}

	/**
	 * ����״̬NOT�趨
	 * @param prstatus_ne ����״̬NOT
	 */
	public void setPrstatus_ne(String prstatus_ne) {
		this.prstatus_ne = prstatus_ne;
	}

	/**
	 * ����״̬����IDȡ��
	 * @return ����״̬����ID
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * ����״̬����ID�趨
	 * @param psdid ����״̬����ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * �ϼ�����״̬����IDȡ��
	 * @return �ϼ�����״̬����ID
	 */
	public String getPpsdid() {
		return ppsdid;
	}

	/**
	 * �ϼ�����״̬����ID�趨
	 * @param ppsdid �ϼ�����״̬����ID
	 */
	public void setPpsdid(String ppsdid) {
		this.ppsdid = ppsdid;
	}

	/**
	 * ����ڵ�״̬ȡ��
	 * @return ����ڵ�״̬
	 */
	public String getVirtualstatus() {
		return virtualstatus;
	}

	/**
	 * ����ڵ�״̬�趨
	 * @param virtualstatus ����ڵ�״̬
	 */
	public void setVirtualstatus(String virtualstatus) {
		this.virtualstatus = virtualstatus;
	}

	/**
	 * ��̬��֧���ȡ��
	 * @return ��̬��֧���
	 */
	public Integer getPsdnum() {
		return psdnum;
	}

	/**
	 * ��̬��֧����趨
	 * @param psdnum ��̬��֧���
	 */
	public void setPsdnum(Integer psdnum) {
		this.psdnum = psdnum;
	}

	/**
	 * ��ǰ״̬ȡ��
	 * @return ��ǰ״̬
	 */
	public String getNowstatus() {
		return nowstatus;
	}

	/**
	 * ��ǰ״̬�趨
	 * @param nowstatus ��ǰ״̬
	 */
	public void setNowstatus(String nowstatus) {
		this.nowstatus = nowstatus;
	}

	/**
	 * �Ƿ����ȡ��
	 * @return �Ƿ����
	 */
	public boolean isPend() {
		return pend;
	}

	/**
	 * �Ƿ�����趨
	 * @param pend �Ƿ����
	 */
	public void setPend(boolean pend) {
		this.pend = pend;
	}
	
}
