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
public class IGSYM04101VO extends BaseVO implements Serializable {

	/**
	 * δ��Ȩ��ɫ����List
	 */
	
	protected List<Role> roleList;
	
	/**
	 * ����Ȩ��ɫ����List
	 */
	
	protected List<Role> yroleList;
	
	
	protected Map<String,List<Role>> roleMap;

	/**
	 * ���췽��
	 * @param roleList List<Role>,ownRoleList List<RoleReport>
	 */
	

	
	public IGSYM04101VO(List<Role> roleList,List<Role> yroleList) {
		this.roleList = roleList;
		this.yroleList = yroleList;
	}
	
	/**
	 * ��ȡδ��Ȩ��ɫ����List
	 * @return List<UserRoleInfo>
	 */
	
	public List<Role> getRoleList() {
		return roleList;
	}

	public List<Role> getYroleList() {
		return yroleList;
	}

	public Map<String, List<Role>> getRoleMap() {
		return roleMap;
	}

	public void setRoleMap(Map<String, List<Role>> roleMap) {
		this.roleMap = roleMap;
	}
	


	
}
