/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.sym.model.condition;

/**
 * @Description: ��ɫ��Ȩ�û���ѯ�ӿ�
 * @Author  masai
 * @History 2010-6-22     �½� 
 * @Version V2.0
 */
public interface UserNotRoleVWSearchCond {

	public abstract String getUserid_q();
	
	public abstract String getUsername_q();
	
	public abstract String getOrgidstr();
	
	public abstract Integer getRoleid();

}
