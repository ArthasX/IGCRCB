/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.mnt.model.condition;

/**
  * ����: ��ض���KPI��Ϣ��ͼ��������ʵ��
  * ��������: ��ض���KPI��Ϣ��ͼ��������ʵ��
  * ������¼: 2012/02/13
  * �޸ļ�¼: 
  */
public class MonitorObjectDefVWSearchCondImpl implements
		MonitorObjectDefVWSearchCond {
	
	/** ��ض������� */
	protected String moName;
	
	/** ״̬ */
	protected String deleteFlag;
	
	/**
	 * ��ض�������ȡ��
	 *
	 * @return ��ض�������
	 */
	public String getMoName() {
		return moName;
	}

	/**
	 * ��ض��������趨
	 *
	 * @param moName ��ض�������
	 */
	public void setMoName(String moName) {
		this.moName = moName;
	}
	
	/**
	 * ״̬ȡ��
	 *
	 * @return ״̬
	 */
	public String getDeleteFlag() {
		return deleteFlag;
	}

	/**
	 * ״̬�趨
	 *
	 * @param deleteFlag ״̬
	 */
	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

}