/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.risk.model.condition;

import java.util.Set;

/**
  * ����: ���������������ӿ�
  * ��������: ���������������ӿ�
  * ������¼: 2014/09/02
  * �޸ļ�¼: 
  */
public interface CheckWorkResultSearchCond {

	
	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getCwrid();

	/**
	 * ������idȡ��
	 *
	 * @return ������id
	 */
	public Integer getCsid();

	/**
	 * �����������ȡ��
	 *
	 * @return �����������
	 */
	public String getCwrname();

	/**
	 * ����ʼʱ��ȡ��
	 *
	 * @return ����ʼʱ��
	 */
	public String getCwrplandate();

	/**
	 * �������ʱ��ȡ��
	 *
	 * @return �������ʱ��
	 */
	public String getCwrrealtime();

	/**
	 * ������idȡ��
	 *
	 * @return ������id
	 */
	public String getCwruserid();

	/**
	 * ����������ȡ��
	 *
	 * @return ����������
	 */
	public String getCwrusername();

	/**
	 * ����������idȡ��
	 *
	 * @return ����������id
	 */
	public String getCwrassetid();

	/**
	 * ��������������ȡ��
	 *
	 * @return ��������������
	 */
	public String getCwrassetname();

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getCwrrate();
	
	/**
	 * ��鷽ʽ
	 * 
	 * @return ��鷽ʽ
	 */
	public String getCwrtestmode();
	
	public String getCwrid_in();
	
	public String getCwrrealtime_to();
	
	public String getCwrrealtime_from();
	
	public String getCwrplandate_to();
	
	public String getCwrplandate_from();
	
	public Set<Integer> getCwrid_inSet();
}