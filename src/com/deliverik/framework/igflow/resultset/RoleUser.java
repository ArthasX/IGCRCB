/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.igflow.resultset;

import java.util.List;

/**
 * ��ɫ�û���Ϣ
 */
public class RoleUser implements RoleUserInfo {
	
	/** ��ɫID */
	private Integer roleid;
	
	/** ��ɫ�û�ID�б� */
	private List<String> lst_Userid;

	/**
	 * ��ɫIDȡ��
	 * @return ��ɫID
	 */
	public Integer getRoleid() {
		return roleid;
	}

	/**
	 * ��ɫ�û�ID�б�ȡ��
	 * @return ��ɫ�û�ID�б�
	 */
	public List<String> getLst_Userid() {
		return lst_Userid;
	}

	/**
	 * ��ɫID�趨
	 * 
	 * @param roleid ��ɫID
	 */
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}
	
	/**
	 * ��ɫ�û�ID�б��趨
	 * 
	 * @param lst_Userid ��ɫ�û�ID�б�
	 */
	public void setLst_Userid(List<String> lst_Userid) {
		this.lst_Userid = lst_Userid;
	}
	
}
