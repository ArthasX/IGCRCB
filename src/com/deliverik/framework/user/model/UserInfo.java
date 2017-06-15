package com.deliverik.framework.user.model;

/**
 * <p>
 * �û���Ϣ
 * </p>
 */
public interface UserInfo {

	/**
	 * �û�IDȡ��
	 * @return �û�ID
	 */
	public String getUserida();

	/**
	 * �û�����ȡ��
	 * @return �û�����
	 */
	public String getUsername();

	/**
	 * �û�����ȡ��
	 * @return �û�����
	 */
	public String getPassword();

	/**
	 * �û�˵��ȡ��
	 * @return �û�˵��
	 */
	public String getUserdesc();

	/**
	 * �û���Ϣȡ��
	 * @return �û���Ϣ
	 */
	public String getUserinfo();

	/**
	 * �û�����ȡ��
	 * @return �û�����
	 */
	public String getUsertype();

	/**
	 * �û�״̬ȡ��
	 * @return �û�״̬
	 */
	public String getUserstatus();

	/**
	 * �û��绰ȡ��
	 * @return �û��绰
	 */
	public String getUserphone();

	/**
	 * �û��ֻ�ȡ��
	 * @return �û��ֻ�
	 */
	public String getUsermobile();

	/**
	 * �û�����ȡ��
	 * @return �û�����
	 */
	public String getUseremail();

	/**
	 * �û���ɫIDȡ��
	 * @return �û���ɫID
	 */
	public Integer getRoleida();

	/**
	 * �û���ɫ����ȡ��
	 * @return �û���ɫ����
	 */
	public String getRolename();

	/**
	 * �û���ɫ˵��ȡ��
	 * @return �û���ɫ˵��
	 */
	public String getRoledesc();

	/**
	 * �û���ɫ��Ϣȡ��
	 * @return �û���ɫ��Ϣ
	 */
	public String getRoleinfo();

	/**
	 * �û���ɫ����ȡ��
	 * @return �û���ɫ����
	 */
	public String getRoletype();

	/**
	 * �û����������ȡ��
	 * @return �û����������
	 */
	public String getOrgida();

	/**
	 * �û���������ȡ��
	 * @return �û���������
	 */
	public String getOrgname();

	/**
	 * �û�����˵��ȡ��
	 * @return �û�����˵��
	 */
	public String getOrgdesc();

	/**
	 * �û�������Ϣȡ��
	 * @return �û�������Ϣ
	 */
	public String getOrginfo();

	/**
	 * �û���������ȡ��
	 * @return �û���������
	 */
	public String getOrgtype();

	/**
	 * �û��������ϼ����������ȡ��
	 * @return �û��������ϼ����������
	 */
	public String getOrgpar();

	/**
	 * �û��������ϼ���������ȡ��
	 * @return �û��������ϼ���������
	 */
	public String getOrgparname();

	/**
	 * �û�������ַȡ��
	 * @return �û�������ַ
	 */
	public String getOrgaddr();

	/**
	 * �û������绰ȡ��
	 * @return �û������绰
	 */
	public String getOrgphone();

	/**
	 * �û���������ȡ��
	 * @return �û���������
	 */
	public String getOrgfax();

	/**
	 * �û�������ϵ��ȡ��
	 * @return �û�������ϵ��
	 */
	public String getOrgcontact();

	/**
	 * �û�����״̬ȡ��
	 * @return �û�����״̬
	 */
	public String getOrgstatus();

	/**
	 * �û���ɫ�ʲ�����Χȡ��
	 * @return �û���ɫ�ʲ�����Χ
	 */
	public String getRolemanager();
	
	/**
	 * ֵ���˱�ʶȡ��
	 * @return ֵ���˱�ʶ
	 */
	public String getDutyflag();

	/**
	 * �߼�ɾ����־λȡ��
	 * @return �߼�ɾ����־λ
	 */
	public String getDeleteflag();
}