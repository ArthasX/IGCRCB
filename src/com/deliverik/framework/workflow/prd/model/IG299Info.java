/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model;

import com.deliverik.framework.base.BaseModel;
import com.deliverik.framework.user.model.entity.OrganizationTB;

/**
  * ����: ״̬�ɷ��ɻ��������ӿ�
  * ��������: ״̬�ɷ��ɻ��������ӿ�
  * ������¼: 2013/02/26
  * �޸ļ�¼: 
  */
public interface IG299Info extends BaseModel {

	/**
	 * ״̬���û�����������ȡ��
	 *
	 * @return ״̬���û�����������
	 */
	public String getPsodid();

	/**
	 * ״̬�ڵ�IDȡ��
	 *
	 * @return psdid ״̬�ڵ�ID
	 */
	public String getPsdid();

	/**
	 * ���������ȡ��
	 *
	 * @return orgsyscoding ���������
	 */
	public String getOrgsyscoding();
	
	/**
	 * ��������ȡ��
	 *
	 * @return orgname ��������
	 */
	public String getOrgname();
	
	/**
	 * ����ȡ��
	 * @return ����
	 */
	public OrganizationTB getOrg();

}