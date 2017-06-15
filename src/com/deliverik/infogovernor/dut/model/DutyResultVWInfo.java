/*
 * ��������������������޹�˾��Ȩ����,��������Ȩ��.
 */

package com.deliverik.infogovernor.dut.model;


/**
 * ֵ���ձ���ͼ�ӿ�
 * 
 */
public interface DutyResultVWInfo {

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
	
	/** ��ա�ʱ����ȡ��
	 * @return ��ա�ʱ����
	 */
	public String getDrlimdtime();
	
	/**
	 * ����ʱ��ȡ��
	 * @return ����ʱ��
	 */
	public String getDadlimtime();
	
	/**
	 * �����ʶȡ��
	 *
	 * @return dadorderby �����ʶ
	 */
	public String getDadorderby();
	
	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public String getPeriodType();


	/**
	 * ����ʱ��ȡ��
	 * @return ����ʱ��
	 */
	public String getPeriodValue();
	

}