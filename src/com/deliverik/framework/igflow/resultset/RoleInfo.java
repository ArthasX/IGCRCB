/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.igflow.resultset;

/**
 * ��ɫ��Ϣ
 */
public interface RoleInfo {
	
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
	 * ��ɫ����ȡ��
	 * @return ��ɫ����
	 */
	public String getRoletype();

	/**
	 * ��������Χȡ��
	 * @return ��������Χ
	 */
	public String getRoledomain();

	/**
	 * �ʲ���������ȡ��
	 * @return �ʲ���������
	 */
	public String getAssetdomain();

}
