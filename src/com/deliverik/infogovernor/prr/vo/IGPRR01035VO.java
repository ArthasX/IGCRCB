/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.prr.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.UserInfo;

/**
 * @Description: ���̶���_������Vo
 * @Author  
 * @History 2009-8-23     �½� 
 * @Version V2.0
 */
@SuppressWarnings("serial")
public class IGPRR01035VO extends BaseVO implements Serializable {
	
	/** ��ɫ */
	private Role role;
	
	/** ���� */
	private Organization org;
	
	/** �û��б� */
	private List<UserInfo> lst_UserInfo;
	
	/**
	 * ����ȡ��
	 *
	 * @return org ����
	 */
	public Organization getOrg() {
		return org;
	}

	/**
	 * �����趨
	 *
	 * @param org ����
	 */
	public void setOrg(Organization org) {
		this.org = org;
	}

//	/**
//	 * ���캯��
//	 * 
//	 * @param role ��ɫ
//	 * @param lst_UserInfo �û��б�
//	 */
//	public IGPRR01035VO(Role role, List<UserInfo> lst_UserInfo) {
//		this.role = role;
//		this.lst_UserInfo = lst_UserInfo;
//	}

	/**
	 * ��ɫ�趨
	 *
	 * @param role ��ɫ
	 */
	public void setRole(Role role) {
		this.role = role;
	}

	/**
	 * �û��б��趨
	 *
	 * @param lst_UserInfo �û��б�
	 */
	public void setLst_UserInfo(List<UserInfo> lst_UserInfo) {
		this.lst_UserInfo = lst_UserInfo;
	}

	/**
	 * ��ɫȡ��
	 * 
	 * @return ��ɫ
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * �û��б�ȡ��
	 * 
	 * @return �û��б�
	 */
	public List<UserInfo> getLst_UserInfo() {
		return lst_UserInfo;
	}

}
