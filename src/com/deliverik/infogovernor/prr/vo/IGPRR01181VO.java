/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.prr.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserRoleInfo;

/**
 * @Description: 流程定义_参与者Vo
 * @Author  
 * @History 2013-01-06     新建 
 * @Version V2.0
 */
@SuppressWarnings("serial")
public class IGPRR01181VO extends BaseVO implements Serializable {/**参与者信息集合*/
	
	/**用户角色信息*/
	List<UserRoleInfo> userRoleInfo;
	
	
	/**
	 *<p>用户角色信息 userRoleInfo取得</p>
	 *<p>2013-1-9下午2:09:24</p>
	 */
	public List<UserRoleInfo> getUserRoleInfo() {
		return userRoleInfo;
	}

	/**
	 *<p>用户角色信息 userRoleInfo设置</p>
	 *<p>2013-1-9下午2:09:24</p>
	 */
	public void setUserRoleInfo(List<UserRoleInfo> userRoleInfo) {
		this.userRoleInfo = userRoleInfo;
	}
	
}
