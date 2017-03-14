/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.drm.model.condition;

/**
 * ������Ӧ����־��Ϣ����������ӿ�
 * ����������Ӧ����־��Ϣ����������ӿ�
 * ������¼��2014/05/19
 * (1)�����뽵������������EmergencyLogTB�е��ֶ���Ϊ��������ֻ�Ǽ�����û�漰���ӹ�ϵ
 * �޸ļ�¼��
 */
public interface EmergencyLogSearchCond {
	/**
	 * Ӧ���������IDȡ��
	 * @return Ӧ���������ID(��ȫƥ��)
	 */
	public String getElprid_eq();
	/**
	 * ��־��Ϣ����ȡ��
	 * @return ��־��Ϣ����(��ȫƥ��)
	 */
	public String getEllitype_eq();
	
	/**
	 * ������������ȡ��
	 * @return �������������ֶ�����
	 */
	public String[] getAscs();
	/**
	 * ������������ȡ��
	 * @return �������������ֶ�����
	 */
	public String[] getDesc();
	
	public String[] getPsdid_in();
	
	public Integer[] getPrid_in();
}