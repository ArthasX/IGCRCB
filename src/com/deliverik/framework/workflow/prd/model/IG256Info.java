/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ���̲������ѽӿ�
  * ��������: ���̲������ѽӿ�
  * ������¼: 2013/09/03
  * �޸ļ�¼: 
  */
public interface IG256Info extends BaseModel {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getFnid();

	/**
	 * ���̱�����ȡ��
	 *
	 * @return ���̱�����
	 */
	public Integer getPrid();

	/**
	 * �������ͱ�����ȡ��
	 *
	 * @return �������ͱ�����
	 */
	public String getPdid();

	/**
	 * ���̼�¼״̬ȡ��
	 *
	 * @return ���̼�¼״̬
	 */
	public String getPrstatus();

	/**
	 * ��ǰ���̲�����idȡ��
	 *
	 * @return ��ǰ���̲�����id
	 */
	public String getPpuserid();
	
	/**
	 * ��ǰ���̲���������ȡ��
	 *
	 * @return ��ǰ���̲���������
	 */
	public String getPpusername();

	/**
	 * ��ʶȡ��
	 *
	 * @return ��ʶ
	 */
	public String getFlag();

}