/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.emo.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: oracle���ܲɼ��ӿ�
  * ��������: oracle���ܲɼ��ӿ�
  * ������¼: 2014/03/05
  * �޸ļ�¼: 
  */
public interface EmInfo extends BaseModel {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getEm_id();

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getEm_type();

	/**
	 * ����sql��IDȡ��
	 *
	 * @return ����sql��ID
	 */
	public String getEm_sqlid();

	/**
	 * �����Ự��IDȡ��
	 *
	 * @return �����Ự��ID
	 */
	public String getEm_sessionid();

	/**
	 * SQL����ȡ��
	 *
	 * @return SQL����
	 */
	public String getEm_sqltype();

	/**
	 * SQL����ȡ��
	 *
	 * @return SQL����
	 */
	public String getEm_sqlcontent();

	/**
	 * �û���ȡ��
	 *
	 * @return �û���
	 */
	public String getEm_username();

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getEm_program();

	/**
	 * ָ������ȡ��
	 *
	 * @return ָ������
	 */
	public String getEm_other();

	/**
	 * ָ������ȡ��
	 *
	 * @return ָ������
	 */
	public String getEm_network();

	/**
	 * ָ������ȡ��
	 *
	 * @return ָ������
	 */
	public String getEm_Queueing();

	/**
	 * ָ������ȡ��
	 *
	 * @return ָ������
	 */
	public String getEm_Idle();

	/**
	 * ָ������ȡ��
	 *
	 * @return ָ������
	 */
	public String getEm_Cluster();

	/**
	 * ָ������ȡ��
	 *
	 * @return ָ������
	 */
	public String getEm_administrative();

	/**
	 * ָ������ȡ��
	 *
	 * @return ָ������
	 */
	public String getEm_configuraction();

	/**
	 * ָ������ȡ��
	 *
	 * @return ָ������
	 */
	public String getEm_commit();

	/**
	 * ָ������ȡ��
	 *
	 * @return ָ������
	 */
	public String getEm_application();

	/**
	 * ָ������ȡ��
	 *
	 * @return ָ������
	 */
	public String getEm_concurrency();

	/**
	 * ָ������ȡ��
	 *
	 * @return ָ������
	 */
	public String getEm_systemIO();

	/**
	 * ָ������ȡ��
	 *
	 * @return ָ������
	 */
	public String getEm_userIO();

	/**
	 * ָ������ȡ��
	 *
	 * @return ָ������
	 */
	public String getEm_scheduler();

	/**
	 * ָ������ȡ��
	 *
	 * @return ָ������
	 */
	public String getEm_cpu();

	/**
	 * ָ���ܺ�ȡ��
	 *
	 * @return ָ���ܺ�
	 */
	public String getEm_Totail();

	/**
	 * �ɼ�ʱ��ȡ��
	 *
	 * @return �ɼ�ʱ��
	 */
	public String getEm_Collecttime();

}