/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sym.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.UserRoleInfo;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ϵͳ����_��Ȩ����_��ɫ��ȨVO
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSYM04021VO extends BaseVO implements Serializable {

	/**
	 * δ��Ȩ��ɫ����List
	 */
	
	protected List<Role> roleList;
	
	/**
	 * ����Ȩ��ɫ����List
	 */
	
	protected List<UserRoleInfo> ownRoleList;

	/**
	 * ���췽��
	 * @param roleList List<Role>,ownRoleList List<UserRoleInfo>
	 */
	
	protected Map<String,List<Role>> roleMap;
	
	public Map<String, List<Role>> getRoleMap() {
		return roleMap;
	}

	public void setRoleMap(Map<String, List<Role>> roleMap) {
		this.roleMap = roleMap;
	}
	
	public IGSYM04021VO(List<Role> roleList,List<UserRoleInfo> ownRoleList) {
		this.roleList = roleList;
		this.ownRoleList = ownRoleList;
	}
	
	/**
	 * ��ȡδ��Ȩ��ɫ����List
	 * @return List<UserRoleInfo>
	 */
	
	public List<Role> getRoleList() {
		return roleList;
	}
	
	/**
	 * ��ȡ����Ȩ��ɫ����List
	 * @return List<UserRoleInfo>
	 */
	
	public List<UserRoleInfo> getOwnRoleList() {
		return ownRoleList;
	}
	
}
