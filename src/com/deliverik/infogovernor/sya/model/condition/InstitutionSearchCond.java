/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.sya.model.condition;

/**
  * ����: �ƶȼ��������ӿ�
  * ��������: �ƶȼ��������ӿ�
  * ������¼: 2015-2-5 10:59:50
  * �޸ļ�¼: 
  */
public interface InstitutionSearchCond {

	/**
	 * �ƶ�����ȡ��
	 * @return inname  �ƶ�����
	 */
	public String getInname();

	/**
	 * ʱ��ȡ��
	 * @return createtime_from  ʱ��
	 */
	public String getCreatetime_from();

	/**
	 * createtime_toȡ��
	 * @return createtime_to  createtime_to
	 */
	public String getCreatetime_to();

	/**
	 * niuseridȡ��
	 * @return niuserid  niuserid
	 */
	public String getNiuserid();

	/**
	 * �Ǽ��˻�������ȡ��
	 * @return niorgname  �Ǽ��˻�������
	 */
	public String getNiorgname();
	
	/**
	 * �ƶȷ���ȡ��
	 * @return intype  �ƶȷ���
	 */
	public String getIntype();
	
}