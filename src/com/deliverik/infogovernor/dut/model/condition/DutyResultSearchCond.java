/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dut.model.condition;

/**
 * ֵ�������ݲ�ѯ�����ӿ�
 */
public interface DutyResultSearchCond {
	
	/**
	 * ֵ��ƻ�IDȡ��
	 * @return ֵ��ƻ�ID
	 */
	public Integer getDpid();
	
	/**
	 * ֵ������IDȡ��
	 * @return ֵ������ID
	 */
	public Integer getDadid();
	
	/**
	 * �������ֵ������ȡ��
	 * @return �������ֵ������
	 */
	public String getDptime();
	
	/**
	 * �������ȡ��
	 * @return �������
	 */
	public String getDadname();
	
	/**
	 * ��ʼʱ��ȡ��
	 * @return ��ʼʱ��
	 */
	public String getDopentime();
	
	/**
	 * ����ʱ��ȡ��
	 * @return ����ʱ��
	 */
	public String getDclosetime();
	
	/**
	 * ���������ƥ�䣩ȡ��
	 * @return ���������ƥ�䣩
	 */
	public String getIsNullDrcontent();

	public String getDptime_ge();
	public String getDptime_le();
	public String getDadcategory();
	public String getDattime();
}
