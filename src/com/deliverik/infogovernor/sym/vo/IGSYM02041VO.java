/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sym.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.user.model.UserInfo;
import com.deliverik.framework.user.model.UserRoleInfo;

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
public class IGSYM02041VO extends BaseVO implements Serializable {

	/**
	 * 角色负责人集合
	 */
	protected Map<UserRoleInfo,List<UserInfo>> managerMap;
	
	/**
	 * 角色集合
	 */
	protected Map<String,String> roleMap;
	
	/**
	 * 手机类型集合,0值班,1负责人
	 */
	protected Map<String,String> mobileMap;

	/**
	 * 获取角色负责人集合
	 * @return Map<UserRoleInfo, List<UserInfo>>
	 */
	public Map<UserRoleInfo, List<UserInfo>> getManagerMap() {
		return managerMap;
	}

	/**
	 * 设置角色负责人集合
	 * @param managerMap Map<UserRoleInfo, List<UserInfo>>
	 */
	public void setManagerMap(Map<UserRoleInfo, List<UserInfo>> managerMap) {
		this.managerMap = managerMap;
	}
	
	/**
	 * 获取角色集合
	 * @return Map<String,String>
	 */
	public Map<String,String> getRoleMap() {
		return roleMap;
	}

	/**
	 * 设置角色集合
	 * @param roleMap Map<String,String>
	 */
	public void setRoleMap(Map<String,String> roleMap) {
		this.roleMap = roleMap;
	}
	
	/**
	 * 获取手机类型集合
	 * @return Map<String,String>
	 */
	public Map<String,String> getMobileMap() {
		return mobileMap;
	}

	/**
	 * 设置手机类型集合
	 * @param mobileMap Map<String,String>
	 */
	public void setMobileMap(Map<String,String> mobileMap) {
		this.mobileMap = mobileMap;
	}
	
}
