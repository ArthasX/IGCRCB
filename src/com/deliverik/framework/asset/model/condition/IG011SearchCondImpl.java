package com.deliverik.framework.asset.model.condition;

/**
 * �ʲ�ͳ����Ϣ��������ʵ��
 * 
 */
public class IG011SearchCondImpl implements IG011SearchCond {

	/** �ʲ��Ǽǿ�ʼʱ��*/
	protected String ciupdtime_from;

	/** �ʲ��Ǽǽ�ֹʱ��*/
	protected String ciupdtime_to;
	
	/** �ʲ��������������*/
	protected String eiorgsyscoding_q;
	
	/** �ʲ�ģ���ϼ������*/
	protected String eparcoding;
	
	/** ������ѯ���ͣ�ƽ̨������0�������� 1ʹ�û�����*/
	protected String orgType;
	
	

	/**
	 * �ʲ�ģ���ϼ������ȡ��
	 * @return �ʲ�ģ���ϼ������
	 */
	public String getEparcoding() {
		return eparcoding;
	}

	/**
	 * �ʲ�ģ���ϼ�������趨
	 *
	 * @param eparcoding �ʲ�ģ���ϼ������
	 */
	public void setEparcoding(String eparcoding) {
		this.eparcoding = eparcoding;
	}

	/**
	 * �ʲ��������������ȡ��
	 * @return �ʲ��������������
	 */
	public String getEiorgsyscoding_q() {
		return eiorgsyscoding_q;
	}

	/**
	 * �ʲ���������������趨
	 *
	 * @param eiorgsyscoding_q �ʲ��������������
	 */
	public void setEiorgsyscoding_q(String eiorgsyscoding_q) {
		this.eiorgsyscoding_q = eiorgsyscoding_q;
	}

	/**
	 * �ʲ��Ǽǿ�ʼʱ��ȡ��
	 * @return �ʲ��Ǽǿ�ʼʱ��
	 */
	public String getCiupdtime_from() {
		return ciupdtime_from;
	}

	/**
	 * �ʲ��Ǽǿ�ʼʱ���趨
	 *
	 * @param ciupdtime_from �ʲ��Ǽǿ�ʼʱ��
	 */
	public void setCiupdtime_from(String ciupdtime_from) {
		this.ciupdtime_from = ciupdtime_from;
	}

	/**
	 * �ʲ��Ǽǽ�ֹʱ��ȡ��
	 * @return �ʲ��Ǽǽ�ֹʱ��
	 */
	public String getCiupdtime_to() {
		return ciupdtime_to;
	}

	/**
	 * �ʲ��Ǽǽ�ֹʱ���趨
	 *
	 * @param ciupdtime_to �ʲ��Ǽǽ�ֹʱ��
	 */
	public void setCiupdtime_to(String ciupdtime_to) {
		this.ciupdtime_to = ciupdtime_to;
	}

	/**
	 * ������ѯ���ͣ�ƽ̨������ȡ��
	 * @return ������ѯ���ͣ�ƽ̨������
	 */
	public String getOrgType() {
		return orgType;
	}

	/**
	 * ������ѯ���ͣ�ƽ̨�������趨
	 *
	 * @param orgType ������ѯ���ͣ�ƽ̨������
	 */
	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}

}
