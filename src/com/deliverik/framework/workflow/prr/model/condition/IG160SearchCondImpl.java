/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prr.model.condition;

/**
 * <p>����:���������Ա����ͳ�Ʋ�ѯ����ʵ��</p>
 * <p>����������</p>
 * <p>������¼��</p>
 */
public class IG160SearchCondImpl implements IG160SearchCond {

	/** ����ID*/
	protected String orgid;

	/** ��ѯ��ʼʱ��*/
	protected String propentime_from;

	/** ��ѯ����ʱ��*/
	protected String propentime_to;

	/**
	 * ���ܣ�����IDȡ��
	 * @return orgid ����ID
	 */
	public String getOrgid() {
		return orgid;
	}

	/**
	 * ���ܣ�����ID����
	 * @param orgid ����ID
	 */
	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	/**
	 * ���ܣ���ѯ��ʼʱ��ȡ��
	 * @return propentime_from ��ѯ��ʼʱ��
	 */
	public String getPropentime_from() {
		return propentime_from;
	}

	/**
	 * ���ܣ���ѯ��ʼʱ������
	 * @param propentime_from ��ѯ��ʼʱ��
	 */
	public void setPropentime_from(String propentime_from) {
		this.propentime_from = propentime_from;
	}

	/**
	 * ���ܣ���ѯ����ʱ��ȡ��
	 * @return propentime_to ��ѯ����ʱ��
	 */
	public String getPropentime_to() {
		return propentime_to;
	}

	/**
	 * ���ܣ���ѯ����ʱ������
	 * @param propentime_to ��ѯ����ʱ��
	 */
	public void setPropentime_to(String propentime_to) {
		this.propentime_to = propentime_to;
	}
	
}
