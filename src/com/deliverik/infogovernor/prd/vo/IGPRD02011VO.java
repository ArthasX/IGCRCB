/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prd.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.user.model.UserRoleInfo;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description:用户查询vo 
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGPRD02011VO extends BaseVO{

	/** 用户角色信息集合 */
	protected List<UserRoleInfo> userroleList;;
	
	/**
	 * 用户角色信息集合取得
	 * @return 用户角色信息集合
	 */
	public List<UserRoleInfo> getUserroleList() {
		return userroleList;
	}

	/**
	 * 用户角色信息集合设定
	 * @param userroleList 用户角色信息集合
	 */
	public void setUserroleList(List<UserRoleInfo> userroleList) {
		this.userroleList = userroleList;
	}
}
