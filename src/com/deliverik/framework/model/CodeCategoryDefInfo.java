package com.deliverik.framework.model;

/**
 * ���ݷ�����Ϣ�ӿ�
 * @author
 *
 */
public interface CodeCategoryDefInfo {

	/**
	 * ���ݷ���CDȡ��
	 * @return ���ݷ���CD
	 */
	public String getCcid ();

	/**
	 * ���ݷ�����ȡ��
	 * @return ���ݷ�����
	 */
	public String getCcname ();

	/**
	 * ���ݷ���˵��ȡ��
	 * @return ���ݷ���˵��
	 */
	public String getCcinfo ();

	/**
	 * ���ݷ���༭��ʶȡ��
	 * @return ���ݷ���༭��ʶ
	 */
	public String getCceditable ();

	/**
	 * ���ݷ���CD(��)ȡ��
	 * @return ���ݷ���CD(��)
	 */
	public String getPccid ();

	/**
	 * �����������ݷ����ʶȡ��
	 * @return �����������ݷ����ʶ
	 */
	public String getPcflag ();
}