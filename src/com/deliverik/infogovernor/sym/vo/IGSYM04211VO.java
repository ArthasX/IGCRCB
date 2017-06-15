/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sym.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.user.model.Role;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 系统管理_授权管理_资源组授权VO
 * </p>
 * 
 * @author lujiayun 2012/11/15
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSYM04211VO extends BaseVO implements Serializable {

	/**
	 * 角色对象List
	 */
	protected List<Role> roleList;

	/**
	 * 角色对象List取得
	 *
	 * @return roleList 角色对象List
	 */
	public List<Role> getRoleList() {
		return roleList;
	}

	/**
	 * 角色对象List设定
	 *
	 * @param roleList 角色对象List
	 */
	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}
}