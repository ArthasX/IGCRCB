/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.model;

import com.deliverik.framework.base.BaseModel;
import com.deliverik.framework.user.model.entity.OrganizationTB;
import com.deliverik.framework.user.model.entity.RoleTB;
import com.deliverik.framework.user.model.entity.UserTB;

/**
  * ����: ����˽�б�����ӿ�
  * ��������: ����˽�б�����ӿ�
  * ������¼: 2012/03/27
  * �޸ļ�¼: 
  */
public interface IG899Info extends BaseModel {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getPpiid();

	/**
	 * ���̱�������IDȡ��
	 *
	 * @return ���̱�������ID
	 */
	public String getPidid();

	/**
	 * ���̱���ֵIDȡ��
	 *
	 * @return ���̱���ֵID
	 */
	public Integer getPiid();

	/**
	 * ���̲����ߵĽ�ɫIDȡ��
	 *
	 * @return ���̲����ߵĽ�ɫID
	 */
	public Integer getRoleid();
	
	/**
	 * ���̲�����IDȡ��
	 * 
	 * @return ���̲�����ID
	 */
	public String getUserid();

	/**
	 * ֵȡ��
	 *
	 * @return ֵ
	 */
	public String getPpivalue();

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getPpiattkey();
	
	public UserTB getUserTB();
	
	public RoleTB getRoleTB();
	
	/**
	 * ������Ϣȡ��
	 * @return ������Ϣ
	 */
	public OrganizationTB getOrg();
	
	/**
	 * ��עȡ��
	 * @return ppicommect ��ע
	 */
	public String getPpicommect();

}