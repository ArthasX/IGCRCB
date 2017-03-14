/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.sym.model.condition;

/**
 * @Description: 角色授权用户查询接口
 * @Author  masai
 * @History 2010-6-22     新建 
 * @Version V2.0
 */
public interface UserNotRoleVWSearchCond {

	public abstract String getUserid_q();
	
	public abstract String getUsername_q();
	
	public abstract String getOrgidstr();
	
	public abstract Integer getRoleid();

}
