package com.deliverik.infogovernor.drm.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.user.model.UserInfo;

/**
 * IGCOM03021VO
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGDRM07022VO extends BaseVO implements Serializable{
	
	/** 角色人员信息 */
	protected Map<String,List<UserInfo>> userRoleMap;
	
	public Map<String, List<UserInfo>> getUserRoleMap() {
		return userRoleMap;
	}

	public void setUserRoleMap(Map<String, List<UserInfo>> userRoleMap) {
		this.userRoleMap = userRoleMap;
	}

}


