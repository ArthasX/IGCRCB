/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: �Զ������̷��ɶ����ӿ�
  * ��������: �Զ������̷��ɶ����ӿ�
  * ������¼: 2013/03/12
  * �޸ļ�¼: 
  */
public interface IG233Info extends BaseModel {

	/**
	 * �����ɽڵ�����ȡ��
	 *
	 * @return �����ɽڵ�����
	 */
	public String getPsdid();

	/**
	 * ���ɽڵ�����ȡ��
	 *
	 * @return ���ɽڵ�����
	 */
	public String getAssignpsdid();

	/**
	 * ���ɰ�ť����ȡ��
	 *
	 * @return ���ɰ�ť����
	 */
	public String getAssignpbdid();

	/**
	 * �Ƿ������ɱ�ʶȡ��
	 *
	 * @return �Ƿ������ɱ�ʶ
	 */
	public String getAssignflag();

}