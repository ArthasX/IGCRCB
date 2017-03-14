/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.prm.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.workflow.prr.model.IG337Info;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程类型_缺省审批人_列表VO
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGPRM03041VO extends BaseVO implements Serializable {

	/**
	 * 未添加审批人对象List
	 */
	
	protected List<Role> roleList_one;
	/**
	 * 未添加审批人对象List
	 */
	
	protected List<Role> roleList_two;
	/**
	 * 未添加审批人对象List
	 */
	
	protected List<Role> roleList_three;
	
	/**
	 * 已添加审批人对象List
	 */
	
	protected List<IG337Info> approvorsList_one;
	/**
	 * 已添加审批人对象List
	 */
	
	protected List<IG337Info> approvorsList_two;
	/**
	 * 已添加审批人对象List
	 */
	
	protected List<IG337Info> approvorsList_three;
	public List<Role> getRoleList_one() {
		return roleList_one;
	}
	public void setRoleList_one(List<Role> roleList_one) {
		this.roleList_one = roleList_one;
	}
	public List<Role> getRoleList_two() {
		return roleList_two;
	}
	public void setRoleList_two(List<Role> roleList_two) {
		this.roleList_two = roleList_two;
	}
	public List<Role> getRoleList_three() {
		return roleList_three;
	}
	public void setRoleList_three(List<Role> roleList_three) {
		this.roleList_three = roleList_three;
	}
	public List<IG337Info> getApprovorsList_one() {
		return approvorsList_one;
	}
	public void setApprovorsList_one(List<IG337Info> approvorsList_one) {
		this.approvorsList_one = approvorsList_one;
	}
	public List<IG337Info> getApprovorsList_two() {
		return approvorsList_two;
	}
	public void setApprovorsList_two(List<IG337Info> approvorsList_two) {
		this.approvorsList_two = approvorsList_two;
	}
	public List<IG337Info> getApprovorsList_three() {
		return approvorsList_three;
	}
	public void setApprovorsList_three(List<IG337Info> approvorsList_three) {
		this.approvorsList_three = approvorsList_three;
	}

}
