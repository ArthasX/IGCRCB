/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model;

import com.deliverik.framework.base.BaseModel;
import com.deliverik.framework.user.model.User;

/**
  * ����: ���̲���֪ͨ�˽ӿ�
  * ��������: ���̲���֪ͨ�˽ӿ�
  * ������¼: 2012/04/25
  * �޸ļ�¼: 
  */
public interface IG237Info extends BaseModel {

	/**
	 * ״̬IDȡ��
	 *
	 * @return ״̬ID
	 */
	public String getPsdid();

	/**
	 * �Ƿ�ȷ��ȡ��
	 *
	 * @return �Ƿ�ȷ��
	 */
	public String getPsdconfirm();
	
	/**
	 * �û�IDȡ��
	 *
	 * @return �û�ID
	 */
	public String getUserid();
	
	/**
	 * ��ֵȡ��
	 * @return pivalue ��ֵ
	 */
	public String getPivalue();
	
	/**
	 * ��ɫIDȡ��
	 *
	 * @return ��ɫID
	 */
	public Integer getRoleid();
	
	/**
	 * �û���Ϣȡ��
	 * 
	 * @return �û���Ϣ
	 */
	public User getUser();

}