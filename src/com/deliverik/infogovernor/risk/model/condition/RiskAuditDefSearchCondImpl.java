/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.risk.model.condition;

/**
 *  �����������Ϣ��ѯ����ʵ��
 *  @author lipeng@deliverik.com
 */
public class RiskAuditDefSearchCondImpl implements RiskAuditDefSearchCond {
	
	/** ������ư汾id */
	protected Integer raid;
	

	/** �������״̬ */
	protected String radstatus;
	
	/** ������������� */
	protected String radcode;
	
	/** ������������� */
	protected String radcode_q;
	
	/** ����������ϼ������ */
	protected String radparcode;
	
	/** ����������ϼ�������ѯ */
	protected String radparcode_q;
	
	/** ���������汾 */
	protected String raversion;
	
	/** ���ղ�ν������� */
	protected String byLevelDesc;
	
	
	
	/**
	 * ���ղ�ν�������ȡ��
	 * @return ���ղ�ν�������
	 */
	public String getByLevelDesc() {
		return byLevelDesc;
	}

	/**
	 * ���ղ�ν��������趨
	 * @param byLevelDesc ���ղ�ν�������
	 */
	public void setByLevelDesc(String byLevelDesc) {
		this.byLevelDesc = byLevelDesc;
	}

	/**
	 * ���������汾ȡ��
	 * @return ���������汾
	 */
	public String getRaversion() {
		return raversion;
	}

	/**
	 * ���������汾�趨
	 * @param raversion ���������汾
	 */
	public void setRaversion(String raversion) {
		this.raversion = raversion;
	}
	
	public String getRadcode_q() {
		return radcode_q;
	}

	public void setRadcode_q(String radcode_q) {
		this.radcode_q = radcode_q;
	}

	public String getRadparcode_q() {
		return radparcode_q;
	}

	public void setRadparcode_q(String radparcode_q) {
		this.radparcode_q = radparcode_q;
	}

	/**
	 * ����������ϼ������ȡ��
	 * @return ����������ϼ������
	 */
	public String getRadparcode() {
		return radparcode;
	}

	/**
	 * ����������ϼ�������趨
	 * @param radparcode ����������ϼ������
	 */
	public void setRadparcode(String radparcode) {
		this.radparcode = radparcode;
	}
	
	/**
	 * ������ư汾idȡ��
	 * @return ������ư汾id
	 */
	public Integer getRaid() {
		return raid;
	}

	/**
	 * ������ư汾id�趨
	 * @param raversion �������id�汾
	 */
	public void setRaid(Integer raid) {
		this.raid = raid;
	}
	
	/**
	 * ���������״̬ȡ��
	 * @return ���������״̬
	 */
	public String getRadstatus() {
		return radstatus;
	}

	/**
	 * ���������״̬�趨
	 * @param radfrequency ���������״̬
	 */
	public void setRadstatus(String radstatus) {
		this.radstatus = radstatus;
	}

	/**
	 * �������������ȡ��
	 * @return �������������
	 */
	public String getRadcode() {
		return radcode;
	}

	/**
	 * ��������������趨
	 * @param radcode �������������
	 */
	public void setRadcode(String radcode) {
		this.radcode = radcode;
	}
}
