/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.kgm.model;

/**
 * ����: ֪ʶ���ѯ��Ϣ�ӿ�
 * ����������֪ʶ���ѯ��Ϣ�ӿ�
 * ������¼��wangxiaoqiang    2010/12/07
 * �޸ļ�¼��
 */
public interface KnowLedgeInfo {
	/**
	 * ����ȡ��
	 * 
	 * @return ����
	 */
	public Integer getKnid();

	/**
	 * ֪ʶ�����ȡ��
	 * 
	 * @return ֪ʶ�����
	 */
	public String getKnclass();
	
	/**
	 * ֪ʶ���������ȡ��
	 * 
	 * @return ֪ʶ���������
	 */
	public String getKnclassname();

	/**
	 * ������ȡ��
	 * 
	 * @return ������
	 */
	public String getKnproffername();

	/**
	 * ֪ʶ����ȡ��
	 * 
	 * @return ֪ʶ����
	 */
	public String getKntitle();

	/**
	 * �¼�ȡ��
	 * 
	 * @return �¼�
	 */
	public String getKnapprovetime();

	/**
	 * ������ȡ��
	 * 
	 * @return ������
	 */
	public String getGrade();

	
	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public Integer getProcessnum();
	
	/**
	 * ֪ʶ�汾ȡ��
	 * @return ֪ʶ�汾
	 */
	public Integer getKnversion();
	
	/**
	 *���ȡ��
	 * 
	 * @return ���
	 */
	public String getKnserial();
}
