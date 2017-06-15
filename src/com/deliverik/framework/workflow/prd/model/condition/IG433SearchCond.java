/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prd.model.condition;


/**
 * ����:��������Cond�ӿ�
 * ����������
 *           
 * ������¼���κ���    2010/11/26
 */
public interface IG433SearchCond {
	/**
	 * ���ܣ����������ȡ��
	 * @return  ���������
	 */
	public String getAssessmentstatus();


	/**
	 * ���ܣ����̼�¼��Ŀȡ��
	 * @return  ���̼�¼��Ŀ
	 */
	public String getPrtitle() ;

	
	/**
	 * ���ܣ����̼�¼�������û�����ȡ��
	 * @return ���̼�¼�������û�����
	 */
	public String getPrusername();
	

	/**
	 * ���ܣ����̼�¼�����̶�ȡ��
	 * @return ���̼�¼�����̶�
	 */
	public String getPrurgency();


	/**
	 * ���ܣ����̼�¼����ʱ�䣨����ڣ�ȡ��
	 * @return ���̼�¼����ʱ�䣨����ڣ�
	 */
	public String getPropentime();


	/**
	 * ���ܣ����̼�¼��������IDȡ��
	 * @return ���̼�¼��������ID
	 */
	public String getPrpdid();


	/**
	 * ���ܣ����̼�¼�ƻ�ִ������ȡ��
	 * @return ���̼�¼�ƻ�ִ������
	 */
	public String getPrclosetime() ;


	/**
	 * ���ܣ����̼�¼������ȡ��
	 * @return ���̼�¼������
	 */
	public String getPrserialnum();
	
	/**
	 * ���ܣ������ʶȡ��
	 * @return  �����ʶ
	 */
	public String getOrder();
	
	/**
	 * ���ܣ������ʶȡ��
	 * @return  �����ʶ
	 */
	public String getSing();

	/**
	 *�������������ȡ��
	 * 
	 * @return �������������
	 */
	public Integer getPaid();
	
	/**
	 * ���ܣ��¼����code
	 * @return �¼����code
	 */
	public String getPaeventtypecode();
	
	/**
	 * ��ȡ��������
	 * @return ��������
	 */
	public String getPrtype() ;
	
	/**
	 * ��ȡ����ID
	 * @return ��ȡ����ID
	 */
	public Integer getPaprid();
}
