/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.condition;


/**
  * ����: ����״̬��ť������������ʵ��
  * ��������: ����״̬��ť������������ʵ��
  * ������¼: 2012/04/13
  * �޸ļ�¼: 
  */
public class IG156SearchCondImpl implements
		IG156SearchCond {

	/** ���� */
	protected String pseid;

	/** ���̶���ID */
	protected String pdid;

	/** ����״̬ */
	protected String psdid;

	/** ����ID */
	protected String pseactionid;

	/** ����ID */
	protected Integer pseorder;

	/** ���� */
	protected String psedec;
	
	protected String psebuttonid;

	/** ���� */
	protected String pseid_like;

	public String getPsebuttonid() {
		return psebuttonid;
	}

	public void setPsebuttonid(String psebuttonid) {
		this.psebuttonid = psebuttonid;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getPseid() {
		return pseid;
	}

	/**
	 * �����趨
	 *
	 * @param pseid ����
	 */
	public void setPseid(String pseid) {
		this.pseid = pseid;
	}

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
	 * @param pdid ���̶���ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * ����״̬ȡ��
	 *
	 * @return ����״̬
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * ����״̬�趨
	 *
	 * @param psdid ����״̬
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * ����IDȡ��
	 *
	 * @return ����ID
	 */
	public String getPseactionid() {
		return pseactionid;
	}

	/**
	 * ����ID�趨
	 *
	 * @param pseactionid ����ID
	 */
	public void setPseactionid(String pseactionid) {
		this.pseactionid = pseactionid;
	}

	/**
	 * ����IDȡ��
	 *
	 * @return ����ID
	 */
	public Integer getPseorder() {
		return pseorder;
	}

	/**
	 * ����ID�趨
	 *
	 * @param pseorder ����ID
	 */
	public void setPseorder(Integer pseorder) {
		this.pseorder = pseorder;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getPsedec() {
		return psedec;
	}

	/**
	 * �����趨
	 *
	 * @param psedec ����
	 */
	public void setPsedec(String psedec) {
		this.psedec = psedec;
	}

	/**
	 * ����ȡ��
	 * 
	 * @return ����
	 */
	public String getPseid_like() {
		return pseid_like;
	}

	/**
	 * �����趨
	 * 
	 * @param pseid_like ����
	 */
	public void setPseid_like(String pseid_like) {
		this.pseid_like = pseid_like;
	}
	
	

}