/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.smr.model.condition;


/**
  * ����: �������ϸ���������ʵ��
  * ��������: �������ϸ���������ʵ��
  * ������¼: 2013/07/18
  * �޸ļ�¼: 
  */
public class RegulatoryReportDetailSearchCondImpl implements
		RegulatoryReportDetailSearchCond {
	
	/** ʵ��ID */
	private	Integer instanceID;
	
	/** ����ID */
	private	Integer prid;

	/**
	 * ʵ��IDȡ��
	 * 
	 * @return ʵ��ID
	 */
	public Integer getInstanceID() {
		return instanceID;
	}

	/**
	 * ʵ��ID�趨
	 * 
	 * @param instanceID ʵ��ID
	 */
	public void setInstanceID(Integer instanceID) {
		this.instanceID = instanceID;
	}
	
	/**
	 * ����IDȡ��
	 * 
	 * @return ����ID
	 */
	public Integer getPrid() {
		return prid;
	}
	
	/**
	 * ����ID�趨
	 * 
	 * @param prid ����ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	
}