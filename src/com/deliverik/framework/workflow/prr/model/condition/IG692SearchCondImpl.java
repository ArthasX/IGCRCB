/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prr.model.condition;

/**
 * 
 * Ԥ֧��ϸ��ѯ�ӿ�ʵ��
 *
 */
public class IG692SearchCondImpl implements IG692SearchCond {
	
	/**
	 * ��ѯʱ�俪ʼ
	 */
	protected String date_from;
	
	/**
	 * ��ѯʱ�����
	 */
	protected String date_to;

	/**
	 * ��ѯ����cid
	 */
	protected String sfcid;
	
	/**
	 * ��ѯ��������
	 */
	protected String sftypename;
	
	/**
	 * ��ѯʱ�俪ʼ�趨
	 * @return ��ѯʱ�俪ʼ
	 */
	public String getDate_from() {
		return date_from;
	}

	/**
	 * ��ѯʱ�俪ʼ�趨
	 * @param date_from ��ѯʱ�俪ʼ
	 */
	public void setDate_from(String date_from) {
		this.date_from = date_from;
	}

	/**
	 * ��ѯʱ������趨
	 * @return ��ѯʱ�����
	 */
	public String getDate_to() {
		return date_to;
	}

	/**
	 * ��ѯʱ������趨
	 * @param date_to ��ѯʱ�����
	 */
	public void setDate_to(String date_to) {
		this.date_to = date_to;
	}
	public String getSfcid() {
		return sfcid;
	}

	public void setSfcid(String sfcid) {
		this.sfcid = sfcid;
	}

	public String getSftypename() {
		return sftypename;
	}

	public void setSftypename(String sftypename) {
		this.sftypename = sftypename;
	}
	
}