/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.fxk.model.condition;

/**
  * ����: ���չ�����ʾ���������ݱ���������ӿ�
  * ��������: ���չ�����ʾ���������ݱ���������ӿ�
  * ������¼: 2014/06/17
  * �޸ļ�¼: 
  */
public interface AcceptuserSearchCond {

	/**
	 * ������Ա���š�����ȡ��
	 * @return apuserid ������Ա���š�����
	 */
	
	public String getApuserid();

	/**
	 * ����������ȡ��
	 * @return apusername ����������
	 */
	
	public String getApusername();

	/**
	 * ���ջ�����ȡ��
	 * @return aporgid ���ջ�����
	 */
	
	public String getAporgid();

	/**
	 * ���ջ�������ȡ��
	 * @return aporgname ���ջ�������
	 */
	
	public String getAporgname();

	/**
	 * ������ʾ����ȡ��
	 * @return rwid ������ʾ����
	 */
	
	public Integer getRwid();

}