/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model;


/**
  * ����: �ʲ�ģ������ȱʡֵ��ͼ�ӿ�
  * ��������: �ʲ�ģ������ȱʡֵ��ͼ�ӿ�
  * ������¼: 2012/07/20
  * �޸ļ�¼: 
  */
public interface IG612Info {

	/**
	 * �ʲ�ģ������IDȡ��
	 * @return �ʲ�ģ������ID
	 */
	public String getCid();

	/**
	 * �ʲ�ģ��IDȡ��
	 * @return �ʲ�ģ��ID
	 */
	public String getEid();

	/**
	 * �ʲ�ģ����������ȡ��
	 * @return �ʲ�ģ����������
	 */
	public String getCname();

	/**
	 * �ʲ�ģ�����Ա��ȡ��
	 * @return �ʲ�ģ�����Ա��
	 */
	public String getClabel();

	/**
	 * �ʲ�ģ������˵��ȡ��
	 * @return �ʲ�ģ������˵��
	 */
	public String getCdesc();

	/**
	 * �ʲ�ģ�����Ե�λȡ��
	 * @return �ʲ�ģ�����Ե�λ
	 */
	public String getCunit();

	/**
	 * �ʲ�ģ������״̬ȡ��
	 * @return �ʲ�ģ������״̬
	 */
	public String getCstatus();

	/**
	 * �ʲ�ģ�������Ƿ���ʾ��ʶȡ��
	 * @return �ʲ�ģ�������Ƿ���ʾ��ʶ
	 */
	public String getCseq();

	/**
	 * �ʲ�ģ����������ȡ��
	 * @return �ʲ�ģ���������� 
	 */
	public String getCcategory();

	/**
	 * �ʲ�ģ������ȡֵ��Χȡ��
	 * @return �ʲ�ģ������ȡֵ��Χ
	 */
	public String getCoption();

	/**
	 * �ʲ�ģ�����Ը�����ʶȡ��
	 * @return �ʲ�ģ�����Ը�����ʶ
	 */
	public String getCattach();

	/**
	 * �ʲ�ģ�Ͳ����ȡ��
	 * @return �ʲ�ģ�Ͳ����
	 */
	public String getEsyscoding();

	/**
	 * ��¼ʱ���ȡ��
	 * @return ��¼ʱ���
	 */
	public String getFingerPrint();
	
	/**
	 * �ʲ�ģ�����Ա�����ȡ��
	 * @return �ʲ�ģ�����Ա�����
	 */
	public String getCrequired();
	
	/**
	 * ����Ĭ��ֵȡ��
	 * @return ����Ĭ��ֵ
	 */
	public String getCvalue();

}