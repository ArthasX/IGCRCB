/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.model.condition;

/**
  * ����: ��Ϣʱ��ģ�嶨����������ʵ��
  * ��������: ��Ϣʱ��ģ�嶨����������ʵ��
  * ������¼: 2011/10/08
  * �޸ļ�¼: 
  */
public class ProcessWorkTimeTemplateSearchCondImpl implements
		ProcessWorkTimeTemplateSearchCond {
	//��ѯ����
	protected String date_like;

	/**
	 * ��ѯ���ڻ�ȡ
	 */
	public String getDate_like() {
		return date_like;
	}

	/**
	 * ��ѯ�����趨
	 * @param date_like
	 */
	public void setDate_like(String date_like) {
		this.date_like = date_like;
	}

}