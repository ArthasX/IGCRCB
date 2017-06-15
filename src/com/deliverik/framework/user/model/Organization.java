package com.deliverik.framework.user.model;

import com.deliverik.framework.base.BaseModel;

/**
 * <p>
 * ������Ϣ
 * </p>
 */
public interface Organization  extends BaseModel {

	/**
	 * ����IDȡ��
	 * @return ����ID
	 */
	public Integer getOrgid();

	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public String getOrgname();

	/**
	 * ����˵��ȡ��
	 * @return ����˵��
	 */
	public String getOrgdesc();

	/**
	 * ������Ϣȡ��
	 * @return ������Ϣ
	 */
	public String getOrginfo();

	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public String getOrgtype();

	/**
	 * �ϼ����������ȡ��
	 * @return �ϼ����������
	 */
	public String getOrgpar();

	/**
	 * �ϼ���������ȡ��
	 * @return �ϼ���������
	 */
	public String getOrgparname();

	/**
	 * ������ַȡ��
	 * @return ������ַ
	 */
	public String getOrgaddr();

	/**
	 * �����绰ȡ��
	 * @return �����绰
	 */
	public String getOrgphone();

	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public String getOrgfax();

	/**
	 * ������ϵ��ȡ��
	 * @return ������ϵ��
	 */
	public String getOrgcontact();

	/**
	 * ����״̬ȡ��
	 * @return ����״̬
	 */
	public String getOrgstatus();

	/**
	 * ���������ȡ��
	 * @return ���������
	 */
	public String getOrgsyscoding();

	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public String getOrgusercoding();

}