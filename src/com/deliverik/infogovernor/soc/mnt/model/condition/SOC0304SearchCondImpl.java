/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.mnt.model.condition;

/**
  * ����: ������������������ʵ��
  * ��������: ������������������ʵ��
  * ������¼: 2012/05/10
  * �޸ļ�¼: 
  */
public class SOC0304SearchCondImpl implements
		SOC0304SearchCond {
	/** ����״̬ */
	protected String mtStatus;
	
	/** �������к� */
	protected String mtSsn;
	/**
	 * ����״̬ȡ��
	 *
	 * @return mtStatus ����״̬
	 */
	public String getMtStatus() {
		return mtStatus;
	}

	/**
	 * ����״̬�趨
	 *
	 * @param mtStatus ����״̬
	 */
	public void setMtStatus(String mtStatus) {
		this.mtStatus = mtStatus;
	}

	/**
	 * �������к�ȡ��
	 *
	 * @return mtSsn �������к�
	 */
	public String getMtSsn() {
		return mtSsn;
	}

	/**
	 * �������к��趨
	 *
	 * @param mtSsn �������к�
	 */
	public void setMtSsn(String mtSsn) {
		this.mtSsn = mtSsn;
	}
	
	
	
}