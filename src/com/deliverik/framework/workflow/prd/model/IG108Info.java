/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model;

import com.deliverik.framework.base.BaseModel;
import com.deliverik.framework.workflow.prd.model.entity.IG007TB;

/**
  * ����: �Զ������̱���ѯ���������ӿ�
  * ��������: �Զ������̱���ѯ���������ӿ�
  * ������¼: 2013/03/13
  * �޸ļ�¼: 
  */
public interface IG108Info extends BaseModel {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getPqid();

	/**
	 * ������������ȡ��
	 *
	 * @return ������������
	 */
	public String getPdid();

	/**
	 * ����������ȡ��
	 *
	 * @return ����������
	 */
	public String getPidid();
	
	/**
	 * ��������Ϣȡ��
	 * @return ��������Ϣ
	 */
	public IG007TB getPidTB();

}