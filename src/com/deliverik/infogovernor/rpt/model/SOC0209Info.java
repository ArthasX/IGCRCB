/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.model;

/**
  * ����: ������Դ��ͼ�ӿ�
  * ��������: ������Դ��ͼ�ӿ�
  * ������¼: 2011/11/24
  * �޸ļ�¼: 2012/08/09 ��ProcessRecordInfoVWInfo������ΪSOC0209Info
  */
public interface SOC0209Info {

	/**
	 * ����IDȡ��
	 *
	 * @return ����ID
	 */
	public Integer getPrid();

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getPrtype();

	/**
	 * ������Դȡ��
	 *
	 * @return ������Դ
	 */
	public String getPivarvalue();

	/**
	 * ���̷���ʱ��ȡ��
	 *
	 * @return ���̷���ʱ��
	 */
	public String getPropentime();

	/**
	 * ���̴�����ʱȡ��
	 *
	 * @return ���̴�����ʱ
	 */
	public Integer getPrfacttime();

}