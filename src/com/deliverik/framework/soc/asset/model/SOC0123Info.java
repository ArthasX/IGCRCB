/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model;


/**
  * ����: �ʲ�ģ����ͼ�ӿ�
  * ��������: �ʲ�ģ����ͼ�ӿ�
  * ������¼: 2011/04/21
  * �޸ļ�¼: 
  */
public interface SOC0123Info {

	/**
	 * �ʲ�IDȡ��
	 *
	 * @return �ʲ�ID
	 */
	public Integer getEiid();

	/**
	 * �ʲ�ģ��IDȡ��
	 *
	 * @return �ʲ�ģ��ID
	 */
	public String getEid();

	/**
	 * �ʲ�����ȡ��
	 *
	 * @return �ʲ�����
	 */
	public String getEiname();

	/**
	 * �ʲ����ȡ��
	 *
	 * @return �ʲ����
	 */
	public String getEilabel();

	/**
	 * �ʲ�˵��ȡ��
	 *
	 * @return �ʲ�˵��
	 */
	public String getEidesc();

	/**
	 * �ʲ�����ʱ��ȡ��
	 *
	 * @return �ʲ�����ʱ��
	 */
	public String getEiupdtime();

	/**
	 * �ʲ�״̬ȡ��
	 *
	 * @return �ʲ�״̬
	 */
	public String getEistatus();

	/**
	 * �ʲ��汾ȡ��
	 *
	 * @return �ʲ��汾
	 */
	public Integer getEiversion();

	/**
	 * �ʲ��Ǽ�ʱ��ȡ��
	 *
	 * @return �ʲ��Ǽ�ʱ��
	 */
	public String getEiinsdate();

	/**
	 * �ʲ��������������ȡ��
	 *
	 * @return �ʲ��������������
	 */
	public String getEiorgsyscoding();

	/**
	 * �ʲ�����ģ�Ͳ����ȡ��
	 *
	 * @return �ʲ�����ģ�Ͳ����
	 */
	public String getEsyscoding();

	/**
	 * �ʲ�������IDȡ��
	 *
	 * @return �ʲ�������ID
	 */
	public String getEiuserid();

	/**
	 * �ʲ�����������ȡ��
	 *
	 * @return �ʲ�����������
	 */
	public String getEiusername();

	/**
	 * �ʲ�ģ������ȡ��
	 *
	 * @return �ʲ�ģ������
	 */
	public String getEname();

	/**
	 * ģ�ͱ�ʶȡ��
	 *
	 * @return ģ�ͱ�ʶ
	 */
	public String getElabel();

	/**
	 * ģ�ͷ���ȡ��
	 *
	 * @return ģ�ͷ���
	 */
	public String getEcategory();
	
	/**
	 * �ʲ�С�汾ȡ��
	 * @return �ʲ�С�汾
	 */
	public Integer getEismallversion();
	
	public Integer getEirootmark();

}