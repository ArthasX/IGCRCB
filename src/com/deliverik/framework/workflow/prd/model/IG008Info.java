/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ��Ա����ɫ�޶��ӿ�
  * ��������: ��Ա����ɫ�޶��ӿ�
  * ������¼: 2013/11/27
  * �޸ļ�¼: 
  */
public interface IG008Info extends BaseModel {

	/**
	 * ������IDȡ��
	 *
	 * @return ������ID
	 */
	public String getPidid();

	/**
	 * ��ɫIDȡ��
	 *
	 * @return ��ɫID
	 */
	public Integer getRoleid();

	/**
	 * ��ɫ����ȡ��
	 *
	 * @return ��ɫ����
	 */
	public String getRolename();

}