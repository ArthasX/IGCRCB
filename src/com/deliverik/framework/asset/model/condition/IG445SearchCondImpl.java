package com.deliverik.framework.asset.model.condition;

/**
 * �豸ͳ�Ʒ�����Ϣ��ѯ����ʵ�֣�ƽ̨������
 * 
 */
public class IG445SearchCondImpl implements IG445SearchCond {
	
	/** �ʲ��Ǽǿ�ʼʱ��*/
	protected String ciupdtime_from;

	/** �ʲ��Ǽǽ�ֹʱ��*/
	protected String ciupdtime_to;
	
	/** �ʲ�ģ��ID*/
	protected String eid;
	
	/** �ʲ��������������*/
	protected String eiorgsyscoding_q;
	
	/**
	 * ȡ�ÿ�ʼʱ��ȡ��
	 * @return ȡ�ÿ�ʼʱ��
	 */
	public String getCiupdtime_from() {
		return ciupdtime_from;
	}

	/**
	 * ȡ�ÿ�ʼʱ���趨
	 *
	 * @param ciupdtime_from ȡ�ÿ�ʼʱ��
	 */
	public void setCiupdtime_from(String ciupdtime_from) {
		this.ciupdtime_from = ciupdtime_from;
	}

	/**
	 * ȡ�ý�ֹʱ��ȡ��
	 * @return ȡ�ý�ֹʱ��
	 */
	public String getCiupdtime_to() {
		return ciupdtime_to;
	}

	/**
	 * ȡ�ý�ֹʱ���趨
	 *
	 * @param ciupdtime_to ȡ�ý�ֹʱ��
	 */
	public void setCiupdtime_to(String ciupdtime_to) {
		this.ciupdtime_to = ciupdtime_to;
	}

	/**
	 * �ʲ�ģ��IDȡ��
	 * @return �ʲ�ģ��ID
	 */
	public String getEid() {
		return eid;
	}

	/**
	 * �ʲ�ģ��ID�趨
	 *
	 * @param eid �ʲ�ģ��ID
	 */
	public void setEid(String eid) {
		this.eid = eid;
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
	
	
}
