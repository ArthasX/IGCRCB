/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.risk.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: �������ӿ�
  * ��������: �������ӿ�
  * ������¼: 2014/09/02
  * �޸ļ�¼: 
  */
public interface CheckWorkResultInfo extends BaseModel {

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
	 * ��鷽��
	 * 
	 * @return ��鷽ʽ
	 */
	public String getCwrtestmode();

}