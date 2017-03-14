/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prd.model;


/**
 * ����:�����������ʵ��ӿ�
 * ���������������������ʵ��ӿ�
 *           
 * ������¼���κ���    2010/11/26
 */
public interface IG567Info {

	/**
	 * ���̼�¼IDȡ��
	 * @return���̼�¼ID
	 */
	public Integer getPrid();

	/**
	 * ���̼�¼����ȡ��
	 * @return ���̼�¼����
	 */
	public String getPrtype();

	/**
	 * ���̼�¼������ȡ��
	 * @return ���̼�¼������
	 */
	public String getPrsubtype();

	/**
	 * ���̼�¼״̬ȡ��
	 * @return ���̼�¼״̬
	 */
	public String getPrstatus();

	/**
	 * ���̼�¼״̬��״̬ȡ��
	 * @return ���̼�¼״̬��״̬
	 */
	public String getPrsubstatus();

	/**
	 * ���̼�¼��Ŀȡ��
	 * @return ���̼�¼��Ŀ
	 */
	public String getPrtitle();

	/**
	 * ���̼�¼����ȡ��
	 * @return ���̼�¼����
	 */
	public String getPrdesc();

	/**
	 * ���̼�¼����ʱ��ȡ��
	 * @return ���̼�¼����ʱ��
	 */
	public String getPropentime();

	/**
	 * ���̼�¼�ر�ʱ��ȡ��
	 * @return ���̼�¼�ر�ʱ��
	 */
	public String getPrclosetime();

	/**
	 * ���̼�¼�ƻ�ִ��ʱ��ȡ��
	 * @return ���̼�¼�ƻ�ִ��ʱ��
	 */
	public String getPrplantime();

	/**
	 * ���̼�¼�ƻ�ִ������ȡ��
	 * @return ���̼�¼�ƻ�ִ������
	 */
	public String getPrduration();

	/**
	 * ���̼�¼�����̶�ȡ��
	 * @return ���̼�¼�����̶�
	 */
	public String getPrurgency();

	/**
	 * ���̼�¼Ӱ��̶�ȡ��
	 * @return ���̼�¼Ӱ��̶�
	 */
	public String getPrimpact();

	/**
	 * ���̼�¼����ʲ�IDȡ��
	 * @return ���̼�¼����ʲ�ID
	 */
	public Integer getPrassetid();

	/**
	 * ���̼�¼����ʲ�����ȡ��
	 * @return ���̼�¼����ʲ�����
	 */
	public String getPrassetname();

	/**
	 * ���̼�¼�����ҵ��ȡ��
	 * @return ���̼�¼�����ҵ��
	 */
	public String getPrbusiness();

	/**
	 * ���̼�¼ִ�мƻ�ȡ��
	 * @return ���̼�¼ִ�мƻ�
	 */
	public String getPrimplplan();

	/**
	 * ���̼�¼�ָ��ƻ�ȡ��
	 * @return ���̼�¼�ָ��ƻ�
	 */
	public String getPrbackplan();

	/**
	 * ���̼�¼��֤�ƻ�ȡ��
	 * @return ���̼�¼��֤�ƻ�
	 */
	public String getPrvfyplan();
	
	/**
	 * ���̼�¼�����ĿIDȡ��
	 * @return ���̼�¼�����ĿID
	 */
	public Integer getPid();

	/**
	 * ���̼�¼�����Ŀ���ȡ��
	 * @return ���̼�¼�����Ŀ���
	 */
	public String getPcode();

	/**
	 * ���̼�¼�����Ŀ����ȡ��
	 * @return ���̼�¼�����Ŀ����
	 */
	public String getPname();
	
	/**
	 * ���̼�¼��������ϵ��ʽȡ��
	 * @return ���̼�¼��������ϵ��ʽ
	 */
	public String getPrinfo();

	/**
	 * ���̼�¼�������IDȡ��
	 * @return ���̼�¼�������ID
	 */
	public Integer getPrcorid();
	/**
	 * ���̼�¼�����������ȡ��
	 * @return ���̼�¼�����������
	 */
	public String getPrcortype();

	/**
	 * ���̼�¼�����������ȡ��
	 * @return ���̼�¼�����������
	 */
	public String getPrcortitle();

	/**
	 * ���̼�¼����ʲ�����ȡ��
	 * @return ���̼�¼����ʲ�����
	 */
	public String getPrassetcategory();

	/**
	 * ���̼�¼�������û�����ȡ��
	 * @return ���̼�¼�������û�����
	 */
	public String getPrusername();

	/**
	 * ���̼�¼�����߽�ɫ����ȡ��
	 * @return ���̼�¼�����߽�ɫ����
	 */
	public String getPrrolename();

	/**
	 * ���̼�¼�������û�IDȡ��
	 * @return ���̼�¼�������û�ID
	 */
	public String getPruserid();

	/**
	 * ���̼�¼�����߽�ɫIDȡ��
	 * @return ���̼�¼�����߽�ɫID
	 */
	public Integer getPrroleid();

	/**
	 * ���̼�¼��������IDȡ��
	 * @return ���̼�¼��������ID
	 */
	public Integer getPrpdid();

	/**
	 * ���̼�¼������������ȡ��
	 * @return ���̼�¼������������
	 */
	public String getPrpdname();

	/**
	 * ���̼�¼�������������������ȡ��
	 * @return ���̼�¼�������������������
	 */
	public String getProrgid();

	/**
	 * ���̼�¼������������������ȡ��
	 * @return ���̼�¼������������������
	 */
	public String getProrgname();

	/**
	 * ���̼�¼������ȡ��
	 * @return ���̼�¼������
	 */
	public String getPrserialnum();

	/**
	 * ���̼�¼ʵ�ʽ��ʱ�䣨�ӿ�ʼ��������ȡ��
	 * @return ���̼�¼ʵ�ʽ��ʱ��
	 */
	public Integer getPrfacttime();

	/**
	 * �Զ���������ʱԾǨ����ȡ��
	 * @return �Զ���������ʱԾǨ����
	 */
	public String getPrptdcond();
	
	/**
	 *�������������ȡ��
	 * 
	 * @return �������������
	 */
	public Integer getPaid();
	
	/**
	 * ���ܣ����������ȡ��
	 * @return  ���������
	 */
	public String getAssessmentstatus();
	
	
}