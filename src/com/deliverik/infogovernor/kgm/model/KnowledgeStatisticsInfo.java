/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.kgm.model;

/**
 * ����: ֪ʶ��ͳ�ƽӿ�
 * ����������֪ʶ��ͳ�ƽӿ�
 * ������¼��wanglei  2014/3/13
 * �޸ļ�¼��
 */
public interface KnowledgeStatisticsInfo{
	
	/**
	 *֪ʶ����������ȡ��
	 * 
	 * @return ֪ʶ����������
	 */
	public String getKnproffername();
	
	/**
	 *����ȡ��
	 * 
	 * @return ����
	 */
	public Integer getKlsid();
	
	/**
	 *ͳ������ȡ��
	 * 
	 * @return ͳ������
	 */
	public Integer getKlscount();
	
	/**
	 *����ȡ��
	 * 
	 * @return ����
	 */
	public String getKnclass();
	
	/**
	 *֪ʶ������ȡ��
	 * 
	 * @return ֪ʶ������
	 */
	public String getKnproffer();
	
	/**
	 *�������ȡ��
	 * 
	 * @return �������
	 */
	public String getKnclassname();
	
}
