/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model;

import com.deliverik.framework.base.BaseModel;
import com.deliverik.framework.workflow.prd.model.entity.IG007TB;

/**
  * ����: ���̲鿴��ɫ��Ȩ����ӿ�
  * ��������: ���̲鿴��ɫ��Ȩ����ӿ�
  * ������¼: 2012/10/15
  * �޸ļ�¼: 
  */
public interface IG701Info extends BaseModel {

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

	/**
	 * ��IDȡ��
	 *
	 * @return ��ID
	 */
	public String getPidid();
	
	/**
	 * ����Ϣȡ��
	 * @return ����Ϣ
	 */
	public IG007TB getProcessInfoDef();

}