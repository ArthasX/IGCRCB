/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sym.vo;

import java.io.Serializable;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.user.model.UserInfo;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 系统管理_角色管理_角色负责人VO
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSYM04071VO extends BaseVO implements Serializable {

	/**
	 * 角色负责人map
	 */
	protected Map<Integer, UserInfo> userInfoMap;
	
	/**
	 * 构造方法
	 * @param userInfoMap Map<Integer, UserInfo>
	 */
	
	public IGSYM04071VO(Map<Integer, UserInfo> userInfoMap) {
		this.userInfoMap = userInfoMap;
	}
	/**
	 * 获取角色负责人map
	 * @return Map<Integer, UserInfo>
	 */
	public Map<Integer, UserInfo> getUserInfoMap() {
		return userInfoMap;
	}

}
