/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dut.model.condition;

/**
 * ֵ���ձ���ѯ�����ӿ�
 */
public interface DutyResultVWSearchCond {
	
	/**
	 * �����IDȡ��
	 * @return �����ID
	 */
	public Integer getDadid();



	/**
	 * ֵ���ձ�IDȡ��
	 * @return ֵ���ձ�ID
	 */
	public Integer getDrid();


	/**
	 * ֵ��ƻ�IDȡ��
	 * @return ֵ��ƻ�ID
	 */
	public Integer getDpid();
	

	/**
	 * ������ȡ��
	 * @return ������
	 */
	public String getDadtype();



	/**
	 * �������ȡ��
	 * @return �������
	 */
	public String getDadname();



	/**
	 * ���ʱ��ȡ��
	 * @return ���ʱ��
	 */
	public String getDattime();



	/**
	 * �ʱ������ȡ��
	 * @return �ʱ������
	 */
	public String getDatlimtime();



	/**
	 * ���������ȡ��
	 * @return ���������
	 */
	public String getDadcontent();



	/**
	 * ���˵��ȡ��
	 * @return ���˵��
	 */
	public String getDadinfo();


	/**
	 * ʹ��״̬ȡ��
	 * @return ʹ��״̬
	 */
	public String getDadstatus();



	/**
	 * �����ȡ��
	 * @return �����
	 */
	public String getDrcontent();



	/**
	 * ʵ���ʱ��ȡ��
	 * @return ʵ���ʱ��
	 */
	public String getDrfilltime();



	/**
	 * ���˵��ȡ��
	 * @return ���˵��
	 */
	public String getDrresult();
	
	/**
	 * ֵ������ȡ��
	 * @return ֵ������
	 */
	public String getDadcategory();
	
	/**
	 * ���ʱ��(��)ȡ��
	 * @return ���ʱ���
	 */
	public String getDattime_form();
	
	/**
	 * ���ʱ��(��)ȡ��
	 * @return ���ʱ��(��)
	 */
	public String getDattime_to();
	
	/**
	 * ���ʱ���ѯ����ȡ��
	 * @return ���ʱ���ѯ����
	 */
	public String getDattime_q();
}
