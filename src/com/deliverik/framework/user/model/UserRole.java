package com.deliverik.framework.user.model;

import com.deliverik.framework.base.BaseModel;

/**
 * <p>
 * �û���ɫ��Ȩ��Ϣ
 * </p>
 */
public interface UserRole  extends BaseModel {

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
	 * �û���ɫIDȡ��
	 * @return �û���ɫID
	 */
	public Integer getRoleid();

	/**
	 * �û����������ȡ��
	 * @return �û����������
	 */
	public String getOrgid();

	/**
	 * �û��Ƿ��ɫ�����˱�ʶȡ��
	 * @return �û��Ƿ��ɫ�����˱�ʶ
	 */
	public String getRolemanager();
	
	/**
	 * �û��Ƿ�ֵ���˱�ʶȡ��
	 * @return �û��Ƿ�Ϊֵ���˱�ʶ
	 */
	public String getDutyflag();

}