/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.cic.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: �Աȼ�¼�ӿ�
  * ��������: �Աȼ�¼�ӿ�
  * ������¼: 2014/04/22
  * �޸ļ�¼: 
  */
public interface CompareprocessInfo extends BaseModel {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getCpid();

	/**
	 * �ȶ������ȡ��
	 *
	 * @return �ȶ������
	 */
	public Integer getFkCsid();

	/**
	 * ��ʼʱ��ȡ��
	 *
	 * @return ��ʼʱ��
	 */
	public String getCpstarttime();

	/**
	 * ����ʱ��ȡ��
	 *
	 * @return ����ʱ��
	 */
	public String getCpendtime();

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getCpschedule();

	/**
	 * ִ�н��ȡ��
	 *
	 * @return ִ�н��
	 */
	public String getCpresulttype();

	/**
	 * ������ʾȡ��
	 *
	 * @return ������ʾ
	 */
	public String getErrorcaption();




}