/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.sym.model;

/**
 * @Description: ��ɫ��Ȩ�û�����
 * @Author  masai
 * @History 2010-6-22     �½� 
 * @Version V2.0
 */
public interface UserNotRole {
	
	public abstract String getUserid();

	public abstract String getUsername();

	public abstract String getUserphone();
	
	public abstract String getUsermobile();
	
	public abstract String getUseremail();
	
	public abstract String getOrgid();
	
	public abstract String getOrgname();
	
	public abstract Integer getRoleid();
	
	public String getUserstatus();

}
