/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: �����������ϵʵ����ӿ�
  * ��������: �����������ϵʵ����ӿ�
  * ������¼: 2015/02/03
  * �޸ļ�¼: 
  */
public interface IG485Info extends BaseModel {

	/**
	 * �����������ϵ����ȡ��
	 *
	 * @return �����������ϵ����
	 */
	public String getPgreid();

	/**
	 *  ������ʵ��idȡ��
	 *
	 * @return  ������ʵ��id
	 */
	public Integer getPgrid();

	/**
	 * �ο�����ʵ��IDȡ��
	 *
	 * @return �ο�����ʵ��ID
	 */
	public Integer getPrid();

	/**
	 * ״̬ȡ��
	 *
	 * @return ״̬
	 */
	public String getPgrrstatus();

	/**
	 * ���ʱ��ȡ��
	 *
	 * @return ���ʱ��
	 */
	public String getPgrtime();

}