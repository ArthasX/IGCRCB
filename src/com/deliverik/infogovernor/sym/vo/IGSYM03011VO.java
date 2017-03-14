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
 * Description: 系统管理_角色管理_查询VO
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSYM03011VO extends BaseVO implements Serializable {

	/**
	 * 角色对象List
	 */
	
	protected List<Role> roleList;

	/**
	 * 构造方法
	 * @param roleList List<Role>
	 */
	
	public IGSYM03011VO(List<Role> roleList) {
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
