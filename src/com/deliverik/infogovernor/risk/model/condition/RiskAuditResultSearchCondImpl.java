/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.risk.model.condition;


/**
 * ����������������Ϣ��ѯ����ʵ��
 * @author lipeng@deliverik.com
 */
public class RiskAuditResultSearchCondImpl implements RiskAuditResultSearchCond {
	
	/** ��������������ID */
	protected Integer rarid;

	/** ������Ʒ���ID */
	protected Integer raiid;
	
	/** ���������ID */
	protected Integer radid;
	
	/** �������������ID */
	protected String raruserid;
	
	/** ������������� */
	protected String radcode;
	
	
	/**
	 * ��������������IDȡ��
	 * @return ��������������ID
	 */
	public Integer getRarid() {
		return rarid;
	}

	/**
	 * ��������������ID�趨
	 * @param rarid ��������������ID
	 */
	public void setRarid(Integer rarid) {
		this.rarid = rarid;
	}

	/**
	 * ������Ʒ���IDȡ��
	 * @return ������Ʒ���ID
	 */
	public Integer getRaiid() {
		return raiid;
	}

	/**
	 * ������Ʒ���ID�趨
	 * @param raiid ������Ʒ���ID
	 */
	public void setRaiid(Integer raiid) {
		this.raiid = raiid;
	}
	/**
	 * ���������IDȡ��
	 * @return ���������ID
	 */
	public Integer getRadid() {
		return radid;
	}

	/**
	 * ���������ID�趨
	 * @param radid ���������ID
	 */
	public void setRadid(Integer radid) {
		this.radid = radid;
	}

	/**
	 * �������������IDȡ��
	 * @return �������������ID
	 */
	public String getRaruserid() {
		return raruserid;
	}

	/**
	 * �������������ID�趨
	 * @param raruserid �������������ID
	 */
	public void setRaruserid(String raruserid) {
		this.raruserid = raruserid;
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
