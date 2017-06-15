package com.deliverik.infogovernor.fin.model.condition;

/**
 * 
 */
public interface BudgetSearchCond {
	/**
	 * 
	 * @return
	 */
	public String getBtype();

	public String getBstatus();

	public String getBinittime();

	public String getBopentime();

	public String getBclosetime();

	public String getBtitle();
	
	public String getBtitle_q();

	public String getBtype_q();
	
	public String getByear_q();
	
	public String getPcode();

	public String getSelectMode();// ͼ����ʾ��

	public String getBstatus_q();

	public String getPquality();//��Ŀ����
	
	public String getPstorecode();// ������Ŀ���

	public String getPneeddispart();// ������

	public String getPbuggetform();// Ԥ�����

	public String getRemark();// ��ע

	public String getByear_before();//ǰ������
	
	public String getByear_now();//��������
	
}
