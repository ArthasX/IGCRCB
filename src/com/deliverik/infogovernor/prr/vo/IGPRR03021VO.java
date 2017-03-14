/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prr.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.user.model.Role;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 角色查询vo
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGPRR03021VO extends BaseVO{
	
	/** 角色信息集合 */
	protected List<Role> roleList;

	/**
	 * 角色信息集合取得
	 * @return 角色信息集合
	 */
	public final List<Role> getRoleList() {
		return roleList;
	}

	/**
	 * 角色信息集合设定
	 * @param roleList 角色信息集合
	 */
	public final void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}
}
