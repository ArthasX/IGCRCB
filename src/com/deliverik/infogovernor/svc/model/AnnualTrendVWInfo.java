/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.svc.model;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��ȹ�������ͳ�ƽӿ�
 * </p>
 * 
 * @author wanglei@deliverik.com
 * @version 1.0
 */
public interface AnnualTrendVWInfo {

	/**
	 * �¼�ͳ������ȡ��
	 * @return incidentnum �¼�ͳ������
	 */
	public Integer getIncidentnum();
	
	/**
	 * ����ͳ������ȡ��
	 * @return problemnum ����ͳ������
	 */
	public Integer getProblemnum();
	
	/**
	 * ���ͳ������ȡ��
	 * @return changenum ���ͳ������
	 */
	public Integer getChangenum();
	
	/**
	 * ��������ͳ������ȡ��
	 * @return servicenum ��������ͳ������
	 */
	public Integer getServicenum();
	
	/**
	 * ���񹤵�ͳ������ȡ��
	 * @return sfnum ���񹤵�ͳ������
	 */
	public Integer getSfnum();
	
	/**
	 * ����ȡ��
	 * @return propentime ����
	 */
	public String getPropentime();
}
