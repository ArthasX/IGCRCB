/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.igflow.resultset;

import java.util.List;

/**
 * ��ɫ�û���Ϣ
 */
public interface RoleUserInfo {
	
	/**
	 * ��ɫIDȡ��
	 * @return ��ɫID
	 */
	public Integer getRoleid();
	
	/**
	 * ��ɫ�û�ID�б�ȡ��
	 * @return ��ɫ�û�ID�б�
	 */
	public List<String> getLst_Userid();

}
