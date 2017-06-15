/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.prd.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.user.model.UserRoleInfo;

/**
 * @Description: 流程策略通知人VO
 * @Author  
 * @History 2009-8-23     新建 
 * @Version V2.0
 */
@SuppressWarnings("serial")
public class IGPRD01592VO extends BaseVO implements Serializable {
	
	/** 角色ID */
	private Integer roleid;
	
	/** 角色名称 */
	private String rolename;
	
	/** 用户列表 */
	private List<UserRoleInfo> lst_userRoleInfo = new ArrayList<UserRoleInfo>();
	
	/**
	 * 构造函数
	 * 
	 * @param roleid 角色ID
	 * @param rolename 角色名称
	 * @param lst_UserRole 用户列表
	 */
	public IGPRD01592VO(Integer roleid, String rolename, UserRoleInfo userRoleInfo) {
		this.roleid = roleid;
		this.rolename = rolename;
		if(userRoleInfo != null) {
			this.lst_userRoleInfo.add(userRoleInfo);
		}
	}

	/**
	 * 角色ID取得
	 * 
	 * @return 角色ID
	 */
	public Integer getRoleid() {
		return roleid;
	}
	
	/**
	 * 角色名称取得
	 * 
	 * @return 角色名称
	 */
	public String getRolename() {
		return rolename;
	}

	/**
	 * 用户列表取得
	 * 
	 * @return 用户列表
	 */
	public List<UserRoleInfo> getLst_userRoleInfo() {
		return lst_userRoleInfo;
	}

}
