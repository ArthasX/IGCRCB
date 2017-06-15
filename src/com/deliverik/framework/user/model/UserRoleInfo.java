package com.deliverik.framework.user.model;

/**
 * <p>
 * �û���ɫ��Ȩ��Ϣ
 * </p>
 */
public interface UserRoleInfo {
	
	/**
	 * �û���ɫ��ȨIDȡ��
	 * @return �û���ɫ��ȨID
	 */
	public Integer getUrid();

	/**
	 * �û�IDȡ��
	 * @return �û�ID
	 */
	public String getUserid();

	/**
	 * �û�����ȡ��
	 *
	 * @return username �û�����
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
	 * �û���ɫ˵��ȡ��
	 * @return �û���ɫ˵��
	 */
	public String getRoledesc();

	/**
	 * �û���ɫ����ȡ��
	 * @return �û���ɫ����
	 */
	public String getRoletype();

	/**
	 * �û���ɫ��������Χȡ��
	 * @return �û���ɫ��������Χ
	 */
	public String getRoledomain();

	/**
	 * �û���ɫ�ʲ�����Χȡ��
	 * @return �û���ɫ�ʲ�����Χ
	 */
	public String getAssetdomain();

	/**
	 * �û��Ƿ��ɫ�����˱�ʶȡ��
	 * @return �û��Ƿ��ɫ�����˱�ʶ
	 */
	public String getRolemanager();
	
	/**
	 * ����syscodingȡ��
	 *
	 * @return orgid ����syscoding
	 */
	public String getOrgid();
	
	/**
	 * ��������ȡ��
	 *
	 * @return orgname ��������
	 */
	public String getOrgname();
	
	/**
	 * �û��Ƿ�ֵ���˱�ʶȡ��
	 * @return �û��Ƿ�ֵ���˱�ʶ
	 */
	public String getDutyflag();


	/**
	 * �û�����ȡ��
	 * @return userinfo �û�����
	 */
	public String getUserinfo();

	/**
	 * �û��ֻ�ȡ��
	 * @return usermobile �û��ֻ�
	 */
	public String getUsermobile();

	/**
	 * �û�����ȡ��
	 * @return useremail �û�����
	 */
	public String getUseremail();
}