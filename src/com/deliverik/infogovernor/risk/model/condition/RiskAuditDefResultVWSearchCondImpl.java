/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.risk.model.condition;

/**
 * ��������������������ͼ��ѯ����ʵ��
 * @author lipeng@deliverik.com
 */
public class RiskAuditDefResultVWSearchCondImpl implements RiskAuditDefResultVWSearchCond {
	
	/** ������Ʒ���ID */
	protected Integer raiid;
	
	/** ���������״̬ */
	protected String radstatus;


	/**
	 * ���������״̬ȡ��
	 * @return ���������״̬
	 */
	public String getRadstatus() {
		return radstatus;
	}

	/**
	 * ���������״̬�趨
	 * @param radstatus ���������״̬
	 */
	public void setRadstatus(String radstatus) {
		this.radstatus = radstatus;
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
}
