/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.wim.model.condition;

import java.util.List;

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
	 * ����״̬��0��δ���ã�1�������ã�ȡ��
	 * @return ����״̬��0��δ���ã�1�������ã�
	 */
	public String getWdstatus();
	
	/**
	 * �����ˣ�userid��ȡ��
	 * @return �����ˣ�userid��
	 */
	public String getLeaderId();
	
	/**
	 * ִ��������ȡ��
	 * @return ִ��������
	 */
	public String getExcutorName();
	
	/**
	 * �����ˣ�userid��ȡ��
	 * @return �����ˣ�userid��
	 */
	public String getInitiatorId();
	
	/**
	 * ����������ȡ��
	 * @return ����������
	 */
	public String getLeaderName();
	
	/**
	 * �����ˣ�useridƥ������ȡ��
	 * @return �����ˣ�useridƥ������
	 */
	public List<String> getInitiatorId_in();
	
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