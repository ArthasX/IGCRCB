/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ���̴���ҳ����������Ϣ�ӿ�
  * ��������: ���̴���ҳ����������Ϣ�ӿ�
  * ������¼: 2013/08/29
  * �޸ļ�¼: 
  */
public interface IG555Info extends BaseModel {

	/**
	 * ��ʶȡ��
	 *
	 * @return ��ʶ
	 */
	public String getJump();

	/**
	 * ����·��ȡ��
	 *
	 * @return ����·��
	 */
	public String getUrl();

	/**
	 * ˵��ȡ��
	 * @return ˵��
	 */
	public String getDescription();

}