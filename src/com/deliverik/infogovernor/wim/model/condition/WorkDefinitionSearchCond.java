/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.wim.model.condition;

/**
  * ����: ����������������ӿ�
  * ��������: ����������������ӿ�
  * ������¼: 2017/06/09
  * �޸ļ�¼: 
  */
public interface WorkDefinitionSearchCond {

	/**
	 * ����������ȡ��
	 * @return ����������
	 */
	public String getWdname();

	/**
	 * �����ˣ�userid��ȡ��
	 * @return �����ˣ�userid��
	 */
	public String getInitiatorId();

	/**
	 * ����״̬��0��δ���ã�1�������ã�ȡ��
	 * @return ����״̬��0��δ���ã�1�������ã�
	 */
	public String getWdstatus();

	/**
	 * ��ʼ���ڴ�ȡ��
	 * @return ��ʼ���ڴ�
	 */
	public String getBeginDateStart();

	/**
	 * ��ʼ���ڵ�ȡ��
	 * @return ��ʼ���ڵ�
	 */
	public String getBeginDateOver();
}