package com.deliverik.framework.user.model;

import com.deliverik.framework.base.BaseModel;

/**
 * <p>
 * �û���Ϣ
 * </p>
 */
public interface User  extends BaseModel {
	
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
	 * �û�����ȡ��
	 * @return �û�����
	 */
	public String getPassword();

	/**
	 * �û���Ϣȡ��
	 * @return �û���Ϣ
	 */
	public String getUserinfo();

	/**
	 * �û�˵��ȡ��
	 * @return �û�˵��
	 */
	public String getUserdesc();

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
	 * �û����������ȡ��
	 * @return �û����������
	 */
	public String getOrgid();

	/**
	 * �û���������ȡ��
	 * @return �û���������
	 */
	public String getOrgname();

	/**
	 * �߼�ɾ����־λȡ��
	 * @return �߼�ɾ����־λ
	 */
	public String getDeleteflag();
	//ҵ�������� drm
	/**
	 * �û���������ȡ��
	 * @return �û���������
	 */
	public Organization getOrganizationTB();
	

}