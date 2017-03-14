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
 * Description: 系统管理_授权管理_菜单授权查询VO
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSYM04031VO extends BaseVO implements Serializable {

	/**
	 * 角色对象List
	 */
	
	protected List<Role> roleList;

	/**
	 * 构造方法
	 * @param roleList List<Role>
	 */
	
	public IGSYM04031VO(List<Role> roleList) {
		this.roleList = roleList;
	}
	
	/**
	 * 获取角色对象List
	 * @return List<Role>
	 */
	
	public List<Role> getRoleList() {
		return roleList;
	}
}
