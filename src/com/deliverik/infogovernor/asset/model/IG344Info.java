/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.model;


/**
  * ����: IG344Info�ӿ�
  * ��������: IG344Info�ӿ�
  * ������¼: 2012/07/13
  * �޸ļ�¼: 
  */
public interface IG344Info {

	/**
	 * ����������ȡ��
	 *
	 * @return ����������
	 */
	public String getEiname();

	/**
	 * �����¼���ȡ��
	 *
	 * @return �����¼���
	 */
	public String getEilabel();

	/**
	 * �����¼�Ǽ�ʱ��ȡ��
	 *
	 * @return �����¼�Ǽ�ʱ��
	 */
	public String getEiinsdate();

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getCivalue();

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getCivalue1();

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getCivalue2();

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public Double getCivalue3();

}