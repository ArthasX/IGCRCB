/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.condition;

/**
  * ����: ״̬�ɷ��ɻ���������������ʵ��
  * ��������: ״̬�ɷ��ɻ���������������ʵ��
  * ������¼: 2013/02/26
  * �޸ļ�¼: 
  */
public class IG299SearchCondImpl implements
		IG299SearchCond {

	/** ����״̬�ڵ� */
	protected String psdid_eq;
	
	/** ����״̬�ڵ�ָ���ɷ��ɻ���������ģ����ѯ */
	protected String psodid_like;
	
	/** ����״̬�ڵ�ָ���ɷ��ɻ����뾫ȷ��ѯ */
	protected String orgsyscoding_eq;
	
	/** ����״̬�ڵ�like */
	protected String psdid_like;

	/**
	 * ����״̬�ڵ�ȡ��
	 *
	 * @return psdid_eq ����״̬�ڵ�
	 */
	public String getPsdid_eq() {
		return psdid_eq;
	}

	/**
	 * ����״̬�ڵ��趨
	 *
	 * @param psdid_eq ����״̬�ڵ�
	 */
	public void setPsdid_eq(String psdid_eq) {
		this.psdid_eq = psdid_eq;
	}

	/**
	 * ����״̬�ڵ�ָ���ɷ��ɻ�������ģ����ѯȡ��
	 *
	 * @return psodid_like ����״̬�ڵ�ָ���ɷ��ɻ���ģ����ѯ
	 */
	public String getPsodid_like() {
		return psodid_like;
	}

	/**
	 * ����״̬�ڵ�ָ���ɷ��ɻ�������ģ����ѯ�趨
	 *
	 * @param psodid_like ����״̬�ڵ�ָ���ɷ��ɻ���ģ����ѯ
	 */
	public void setPsodid_like(String psodid_like) {
		this.psodid_like = psodid_like;
	}

	/**
	 * ����״̬�ڵ�ָ���ɷ��ɻ����뾫ȷ��ѯȡ��
	 *
	 * @return orgsyscoding_eq ����״̬�ڵ�ָ���ɷ��ɻ����뾫ȷ��ѯ
	 */
	public String getOrgsyscoding_eq() {
		return orgsyscoding_eq;
	}

	/**
	 * ����״̬�ڵ�ָ���ɷ��ɻ����뾫ȷ��ѯ�趨
	 *
	 * @param orgsyscoding_eq ����״̬�ڵ�ָ���ɷ��ɻ����뾫ȷ��ѯ
	 */
	public void setOrgsyscoding_eq(String orgsyscoding_eq) {
		this.orgsyscoding_eq = orgsyscoding_eq;
	}

	/**
	 * ����״̬�ڵ�likeȡ��
	 * @return ����״̬�ڵ�like
	 */
	public String getPsdid_like() {
		return psdid_like;
	}

	/**
	 * ����״̬�ڵ�like�趨
	 * @param psdid_like ����״̬�ڵ�like
	 */
	public void setPsdid_like(String psdid_like) {
		this.psdid_like = psdid_like;
	}

	
}