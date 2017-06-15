/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.prr.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.UserRoleInfo;

/**
 * @Description: ���̶���_������Vo
 * @Author  
 * @History 2009-8-23     �½� 
 * @Version V2.0
 */
@SuppressWarnings("serial")
public class IGPRR01032VO extends BaseVO implements Serializable {
	
	/** ��ɫ */
	private Role role;
	
	/** �û��б� */
	private List<UserRoleInfo> lst_UserRoleInfo;
	
	/**
	 * ���캯��
	 * 
	 * @param role ��ɫ
	 * @param lst_UserRoleInfo �û��б�
	 */
	public IGPRR01032VO(Role role, List<UserRoleInfo> lst_UserRoleInfo) {
		this.role = role;
		this.lst_UserRoleInfo = lst_UserRoleInfo;
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
	public List<UserRoleInfo> getLst_UserRoleInfo() {
		return lst_UserRoleInfo;
	}

}
