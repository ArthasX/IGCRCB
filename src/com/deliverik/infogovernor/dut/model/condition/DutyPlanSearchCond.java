/*
 * ��������������������޹�˾��Ȩ����,��������Ȩ��.
 */
package com.deliverik.infogovernor.dut.model.condition;
/**
 * 
 * ֵ��ƻ���ѯ�ӿ�
 *
 */
public interface DutyPlanSearchCond {
	
	/**
	 * ֵ��ƻ�״̬ȡ��
	 * @return ֵ��ƻ�״̬
	 */
	public String getDpstatus();
	
	/**
	 * ֵ������ȡ��
	 * @return ֵ������
	 */
	public String getDadcategory();
	
	/**
	 * ֵ������ȡ��
	 * @return ֵ������
	 */
	public String getDptime();
	
	/**
	 * ֵ�����ڣ����ڵ���ƥ�䣩ȡ��
	 * @return ֵ�����ڣ����ڵ���ƥ�䣩
	 */
	public String getDptime_ge();
	
	/**
	 * ֵ�����ڣ�С�ڵ���ƥ�䣩ȡ��
	 * @return ֵ�����ڣ�С�ڵ���ƥ�䣩
	 */
	public String getDptime_le();

	/**
	 * ֵ������ȡ��
	 * @return ֵ������
	 */
	public String getDptype();
	
	/**
	 * ֵ��ƻ�������ȡ��
	 *
	 * @return dpid ֵ��ƻ�������
	 */
	public Integer getDpid();
}
