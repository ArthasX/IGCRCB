package com.deliverik.framework.workflow.prr.model;

/**
 * <p>
 * �����ϱ�ͳ����Ϣ��ƽ̨������
 * </p>
 */

public interface IG019Info {
	
	/**
	 * ���������ȡ�ã��¼�����ȡ�ϱ��˻�����������������ȡ�����˻�����
	 * @return ���������
	 */
	public String getOrgsyscoding();
	
	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public String getOrgname();
	
	/**
	 * �¼����̸���ȡ��
	 * @return �¼����̸���
	 */
	public Integer getIncident();
	
	/**
	 * �����������ȡ��
	 * @return �����������
	 */
	public Integer getServiceRequest();
	
	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public Integer getCount();
	
}
