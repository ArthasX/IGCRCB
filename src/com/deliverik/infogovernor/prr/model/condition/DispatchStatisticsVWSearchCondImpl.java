/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.prr.model.condition;

/**
  * ����: ��������ͳ�Ƽ�������ʵ��
  * ��������: ��������ͳ�Ƽ�������ʵ��
  * ������¼: 2013/02/27
  * �޸ļ�¼: 
  */
public class DispatchStatisticsVWSearchCondImpl implements
		DispatchStatisticsVWSearchCond {
	
	/** �û��� */
	protected String dsusername;
	
	/** ��ѯ������ʼʱ�� */
	protected String propentime_from;
	
	/** ��ѯ��������ʱ�� */
	protected String propentime_to;
	
	/**
	 * �û���ȡ��
	 *
	 * @return �û���
	 */
	public String getDsusername() {
		return dsusername;
	}

	/**
	 * �û����趨
	 *
	 * @param dsusername �û���
	 */
	public void setDsusername(String dsusername) {
		this.dsusername = dsusername;
	}

	/**
	 * ��ѯ������ʼʱ��ȡ��
	 *
	 * @return ��ѯ������ʼʱ��
	 */
	public String getPropentime_from() {
		return propentime_from;
	}

	/**
	 * ��ѯ������ʼʱ���趨
	 *
	 * @param propentime_from ��ѯ������ʼʱ��
	 */
	public void setPropentime_from(String propentime_from) {
		this.propentime_from = propentime_from;
	}

	/**
	 * ��ѯ��������ʱ��ȡ��
	 *
	 * @return ��ѯ��������ʱ��
	 */
	public String getPropentime_to() {
		return propentime_to;
	}

	/**
	 * ��ѯ��������ʱ���趨
	 *
	 * @param propentime_to ��ѯ��������ʱ��
	 */
	public void setPropentime_to(String propentime_to) {
		this.propentime_to = propentime_to;
	}
	
	

}