/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.condition;

/**
  * ����: ���̱��ⶨ�����������ӿ�
  * ��������: ���̱��ⶨ�����������ӿ�
  * ������¼: 2012/03/30
  * �޸ļ�¼: 
  */
public interface IG243SearchCond {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getPtdid();


	/**
	 * ���̶���IDȡ��
	 *
	 * @return ���̶���ID
	 */
	public String getPdid();

	/**
	 * �������ƶ���ȡ��
	 *
	 * @return �������ƶ���
	 */
	public String getPtitlename();


	/**
	 * ��������Ȩ�� 0�ɼ���1���ɼ�ȡ��
	 *
	 * @return ��������Ȩ�� 0�ɼ���1���ɼ�
	 */
	public String getPtitleaccess();


	/**
	 * �����ֶ�����ȡ��
	 *
	 * @return �����ֶ�����
	 */
	public String getPdescname();

	/**
	 * �����ֶ�Ȩ�� 0���ɼ���1���ɼ�ȡ��
	 *
	 * @return �����ֶ�Ȩ�� 0���ɼ���1���ɼ�
	 */
	public String getPdescaccess();

	/**
	 * ����ȡ��
	 * 
	 * @return ����
	 */
	public String getPtdid_like();
}