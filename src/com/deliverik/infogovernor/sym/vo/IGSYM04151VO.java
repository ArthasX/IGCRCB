/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sym.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.sym.model.ReportFileDefinition;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 系统管理_授权管理_角色授权VO
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSYM04151VO extends BaseVO implements Serializable {

	/**
	 * 未授权角色对象List
	 */
	
	protected List<ReportFileDefinition> yroleList;
	
	/**
	 * 已授权角色对象List
	 */
	
	protected List<ReportFileDefinition> ownList;
	
	
	protected Map<String,List<ReportFileDefinition>> roleMap;

	/**
	 * 构造方法
	 * @param roleList List<Role>,ownRoleList List<RoleReport>
	 */
	

	
	public IGSYM04151VO(List<ReportFileDefinition> yroleList,List<ReportFileDefinition> ownList) {
		this.ownList = ownList;
		this.yroleList = yroleList;
	}
	
	/**
	 * 获取未授权角色对象List
	 * @return List<UserRoleInfo>
	 */
	




	public List<ReportFileDefinition> getYroleList() {
		return yroleList;
	}

	public void setYroleList(List<ReportFileDefinition> yroleList) {
		this.yroleList = yroleList;
	}

	public List<ReportFileDefinition> getOwnList() {
		return ownList;
	}

	public void setOwnList(List<ReportFileDefinition> ownList) {
		this.ownList = ownList;
	}

	public Map<String, List<ReportFileDefinition>> getRoleMap() {
		return roleMap;
	}

	public void setRoleMap(Map<String, List<ReportFileDefinition>> roleMap) {
		this.roleMap = roleMap;
	}


	


	
}
