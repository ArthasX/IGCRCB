/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.crc.model;

/**	
 * ����:��ȹ�����ѯα��ͼ
 * ������¼��lianghongyang    2014-8-7 16:16:51	
 * �޸ļ�¼��null
 */	

public interface IGCRC2001VWInfo {

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
