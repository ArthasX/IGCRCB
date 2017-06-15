package com.deliverik.framework.user.model;

import com.deliverik.framework.base.BaseModel;

/**
 * <p>
 * ��ɫ��Ϣ
 * </p>
 */
public interface Role  extends BaseModel {
	
	/**
	 * ��ɫIDȡ��
	 * @return ��ɫID
	 */
	public Integer getRoleid();

	/**
	 * ��ɫ����ȡ��
	 * @return ��ɫ����
	 */
	public String getRolename();

	/**
	 * ��ɫ˵��ȡ��
	 * @return ��ɫ˵��
	 */
	public String getRoledesc();

	/**
	 * ��ɫ��Ϣȡ��
	 * @return ��ɫ��Ϣ
	 */
	public String getRoleinfo();

	/**
	 * ��ɫ����ȡ��
	 * @return ��ɫ����
	 */
	public String getRoletype();

	/**
	 * ��ɫ��������Χȡ��
	 * @return ��ɫ��������Χ
	 */
	public String getRoledomain();

	/**
	 * ��ɫ�ʲ�����Χȡ��
	 * @return ��ɫ�ʲ�����Χ
	 */
	public String getAssetdomain();

}