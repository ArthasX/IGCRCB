/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: CI��������ӿ�
  * ��������: CI��������ӿ�
  * ������¼: 2011/05/18
  * �޸ļ�¼: 
  */
public interface CITaskInfo extends BaseModel {

	/**
	 * �߼�����ȡ��
	 *
	 * @return �߼�����
	 */
	public Integer getCitid();

	/**
	 * CI�����������ȡ��
	 *
	 * @return CI�����������
	 */
	public String getCitdesc();

	/**
	 * CI���ʱ���ȡ��
	 *
	 * @return CI���ʱ���
	 */
	public String getCittime();
	
	/**
	 * ״̬ȡ��
	 * @return ״̬
	 */
	public String getCitstatus();
	
	/**
	 * ������ʱ��ȡ��
	 * @return ������ʱ��
	 */
	public String getCitupdtime();

	/**
	 * ���Ա�ʱ��ȡ��
	 * @return ���Ա�ʱ��
	 */
	public String getCitcomptime();

}