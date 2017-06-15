/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.sym.model.condition;

/**
 * @Description: 角色授权用户查询接口实现
 * @Author  masai
 * @History 2010-6-22     新建 
 * @Version V2.0
 */
public class UserNotRoleVWSearchCondImpl implements UserNotRoleVWSearchCond {

	public String userid_q;

	public String username_q;
	
	public String orgidstr;
	
	public Integer roleid;

	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public String getUserid_q() {
		
		return userid_q;
	}

	public void setUserid_q(String userid_q) {
		this.userid_q = userid_q;
	}

	public String getUsername_q() {
		return username_q;
	}

	public void setUsername_q(String username_q) {
		this.username_q = username_q;
	}

	public String getOrgidstr() {
		return orgidstr;
	}

	public void setOrgidstr(String orgidstr) {
		this.orgidstr = orgidstr;
	}

}
