/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: �������Աʵ���ӿ�
  * ��������: �������Աʵ���ӿ�
  * ������¼: 2015/02/03
  * �޸ļ�¼: 
  */
public interface IG484Info extends BaseModel {

	/**
	 * ����ʵ��IDȡ��
	 *
	 * @return ����ʵ��ID
	 */
	public Integer getPrid();

	/**
	 * ������ʵ��IDȡ��
	 *
	 * @return ������ʵ��ID
	 */
	public Integer getPgrid();
	
	/**
	 * ���̶���IDȡ��
	 * @return ���̶���ID
	 */
	public String getPdid();

}