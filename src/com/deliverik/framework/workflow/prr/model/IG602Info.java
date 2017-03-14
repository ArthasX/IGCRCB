package com.deliverik.framework.workflow.prr.model;

/**
 * ����: ����ִ������Ϣ�ӿ�
 * ��������: ����ִ������Ϣ�ӿ�
 * ������¼: 2012/04/11
 * �޸ļ�¼: 
 */
public interface IG602Info {
	
	/**
	 * �û�IDȡ��
	 * @return �û�ID
	 */
	public String getUserid();
	
	/**
	 * �û�����ȡ��
	 * @return �û�����
	 */
	public String getUsername();

	/**
	 * �û���ɫIDȡ��
	 * @return �û���ɫID
	 */
	public Integer getRoleid();

	/**
	 * �û���ɫ����ȡ��
	 * @return �û���ɫ����
	 */
	public String getRolename();
	
	/**
	 * �û����������ȡ��
	 * @return �û����������
	 */
	public String getOrgsyscoding();

	/**
	 * �û���������ȡ��
	 * @return �û���������
	 */
	public String getOrgname();

	/**
	 * ������ɱ�ʶȡ��
	 * 
	 * @return ������ɱ�ʶ
	 */
	public String getDoneFlag();

	/**
	 * �û��ֻ���ȡ��
	 * 
	 * @return �û��ֻ���
	 */
	public String getUsermobile();

	/**
	 * �û�����ȡ��
	 * 
	 * @return �û�����
	 */
	public String getUserinfo();
	
}
