package com.deliverik.framework.asset.model;

/**
 * ���������豸ͳ�Ʒ�����Ϣ
 * 
 *
 */
public interface IG790Info {
	/**
	 * ����IDȡ��
	 * @return ����ID
	 */
	public String getRoom_id();
	
	/**
	 * ��������ȡ��
	 * @return ��������
	 */

	public String getRoom_name();

	/**
	 * ����IDȡ��
	 * @return ����ID
	 */

	public String getContainer_id();

	/**
	 * ��������ȡ��
	 * @return ��������
	 */

	public String getContainer_name();

	/**
	 * �ʲ�ģ��IDȡ��
	 * @return �ʲ�ģ��ID
	 */
	public String getEid();

	/**
	 * �ʲ�ģ������ȡ��
	 * @return �ʲ�ģ������
	 */
	public String getEname();

	/**
	 * �ʲ����ȡ��
	 * @return �ʲ����
	 */

	public String getEilabel();
	
	/**
	 * �ʲ��ڻ�����λ��ȡ��
	 * @return �ʲ��ڻ�����λ��
	 */
	public String getPosition();
	
	/**
	 * �ʲ��ͺ�ȡ��
	 * @return �ʲ��ͺ�
	 */
	
	public String getModel();	
	
}