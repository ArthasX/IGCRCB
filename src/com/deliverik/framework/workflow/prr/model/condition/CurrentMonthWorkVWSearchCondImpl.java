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
public class CurrentMonthWorkVWSearchCondImpl implements
		CurrentMonthWorkVWSearchCond {

	/** ��ǰ��*/
	protected String month;
	
	/** ��ǰ��¼�˽�ɫ*/
	protected String[] roleid;
	
	/**�����ʶ*/
	protected String order;
	
	protected String sing;

	/**
	 * ��ǰ��ȡ��
	 *
	 * @return ��ǰ��
	 */
	public String getMonth() {
		return month;
	}

	/**
	 * ��ǰ���趨
	 *
	 * @param month ��ǰ��
	 */
	public void setMonth(String month) {
		this.month = month;
	}

	public String[] getRoleid() {
		return roleid;
	}

	public void setRoleid(String[] roleid) {
		this.roleid = roleid;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getSing() {
		return sing;
	}

	public void setSing(String sing) {
		this.sing = sing;
	}





	
	
	
}
