/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.sym.model;

/**
 * @Description: 角色授权用户管理
 * @Author  masai
 * @History 2010-6-22     新建 
 * @Version V2.0
 */
public interface UserNotRole {
	
	public abstract String getUserid();

	public abstract String getUsername();

	public abstract String getUserphone();
	
	public abstract String getUsermobile();
	
	public abstract String getUseremail();
	
	public abstract String getOrgid();
	
	public abstract String getOrgname();
	
	public abstract Integer getRoleid();
	
	public String getUserstatus();

}
