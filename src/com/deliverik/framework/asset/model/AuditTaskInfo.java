/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ��������ӿ�
  * ��������: ��������ӿ�
  * ������¼: 2011/05/18
  * �޸ļ�¼: 
  */
public interface AuditTaskInfo extends BaseModel {

	/**
	 * �߼�����ȡ��
	 *
	 * @return �߼�����
	 */
	public Integer getAutid();

	/**
	 * �����������ȡ��
	 *
	 * @return �����������
	 */
	public String getAutdesc();

	/**
	 * ���ʱ���ȡ��
	 *
	 * @return ���ʱ���
	 */
	public String getAuttime();
	
	/**
	 * ״̬ȡ��
	 * 
	 * @return ״̬
	 */
	public String getAutstatus();

	/**
	 * ������ʱ��ȡ��
	 * @return ������ʱ��
	 */
	public String getAutupdtime();

	/**
	 * ���Ա�ʱ��ȡ��
	 * @return ���Ա�ʱ��
	 */
	public String getAutcomptime();

}