/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.risk.model.condition;

/**
 * ���������Ϣ��ѯ����ʵ��
 * @author lipeng@deliverik.com
 */
public class RiskAuditSearchCondImpl implements RiskAuditSearchCond {
	
	/** ������ư汾id */
	protected Integer raid;
	
	/** ������ư汾 */
	protected String raversion;
	
	/** �������״̬ */
	protected String rastatus;
	
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
	 * ������ư汾ȡ��
	 * @return ������ư汾
	 */
	public String getRaversion() {
		return raversion;
	}

	/**
	 * ������ư汾�趨
	 * @param raversion ������ư汾
	 */
	public void setRaversion(String raversion) {
		this.raversion = raversion;
	}
	
	/**
	 * �������״̬ȡ��
	 * @return �������״̬
	 */
	public String getRastatus() {
		return rastatus;
	}

	/**
	 * �������״̬�趨
	 * @param rastatus �������״̬
	 */
	public void setRastatus(String rastatus) {
		this.rastatus = rastatus;
	}
}
