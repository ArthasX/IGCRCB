/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ���̲鿴��ɫ���ñ�ӿ�
  * ��������: ���̲鿴��ɫ���ñ�ӿ�
  * ������¼: 2012/10/15
  * �޸ļ�¼: 
  */
public interface IG700Info extends BaseModel {

	/**
	 * ���̶���IDȡ��
	 *
	 * @return ���̶���ID
	 */
	public String getPdid();

	/**
	 * ��ɫIDȡ��
	 *
	 * @return ��ɫID
	 */
	public Integer getRoleid();

}