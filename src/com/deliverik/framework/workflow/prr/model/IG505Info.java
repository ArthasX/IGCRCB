/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ���̱�ֵ��ӿ�
  * ��������: ���̱�ֵ��ӿ�
  * ������¼: 2013/08/28
  * �޸ļ�¼: 
  */
public interface IG505Info extends BaseModel {


	/**
	 * ����ȡ��
	 * @return piprrid ����
	 */
	public Integer getPiprrid();

	/**
	 * ��������ȡ��
	 * @return prid ��������
	 */
	public Integer getPrid();

	/**
	 * pipridȡ��
	 * @return piprid piprid
	 */
	public Integer getPiprid();

	/**
	 * ��������ȡ��
	 * @return piprtype ��������
	 */
	public String getPiprtype();

	/**
	 * ��������ȡ��
	 * @return piprtitle ��������
	 */
	public String getPiprtitle();

}