/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model;

import com.deliverik.framework.base.BaseModel;
import com.deliverik.framework.user.model.Role;

/**
  * ����: ����״̬�ɷ��ɽ�ɫ������Ϣ�ӿ�
  * ��������: ����״̬�ɷ��ɽ�ɫ������Ϣ�ӿ�
  * ������¼: 2012/04/11
  * �޸ļ�¼: 
  */
public interface IG298Info extends BaseModel {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getPsrdid();

	/**
	 * ״̬IDȡ��
	 *
	 * @return ״̬ID
	 */
	public String getPsdid();

	/**
	 * ��ɫIDȡ��
	 *
	 * @return ��ɫID
	 */
	public Integer getRoleid();
	
	/**
	 * ��ɫ��Ϣȡ��
	 * 
	 * @return ��ɫ��Ϣ
	 */
	public Role getRole();

}