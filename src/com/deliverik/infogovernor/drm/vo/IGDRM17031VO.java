/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.drm.vo;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.user.model.UserRoleInfo;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 用户查询vo
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGDRM17031VO extends BaseVO{

	/** 用户角色Map */
	protected Map<Integer, Map<String,List<UserRoleInfo>>> userRoleInfoMap;

	/**
	 * 用户角色Map取得
	 * @return userRoleInfoMap 用户角色Map
	 */
	public Map<Integer, Map<String, List<UserRoleInfo>>> getUserRoleInfoMap() {
		return userRoleInfoMap;
	}

	/**
	 * 用户角色Map设定
	 * @param userRoleInfoMap 用户角色Map
	 */
	public void setUserRoleInfoMap(
			Map<Integer, Map<String, List<UserRoleInfo>>> userRoleInfoMap) {
		this.userRoleInfoMap = userRoleInfoMap;
	}
	
}
