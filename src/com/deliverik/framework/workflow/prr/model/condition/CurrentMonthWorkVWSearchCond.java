/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prr.model.condition;

/**
 * ����:��ѯ���д����˵ı��¹��� 
 * ������������ѯ���д����˵ı��¹���
 * �����ˣ�����͢
 * ������¼�� 2013-04-22
 * �޸ļ�¼��
 */
public interface CurrentMonthWorkVWSearchCond {

	/**
	 * ��ǰ��ȡ��
	 *
	 * @return ��ǰ��
	 */
	public String getMonth();
	
	/**
	 * ��ǰ��¼�˽�ɫȡ��
	 *
	 * @return ��ǰ��¼�˽�ɫ
	 */
	public String[] getRoleid();
	
	public String getOrder();
	
	public String getSing();
}
