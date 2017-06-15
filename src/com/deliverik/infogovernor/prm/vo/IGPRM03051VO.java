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
public class IGPRM03051VO extends BaseVO implements Serializable {

	/**
	 * 未添加审批人对象List
	 */
	
	protected List<Role> roleList;
	
	/**
	 * 已添加审批人对象List
	 */
	
	protected List<IG337Info> approveDispatcherList;

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	public List<IG337Info> getApproveDispatcherList() {
		return approveDispatcherList;
	}

	public void setApproveDispatcherList(
			List<IG337Info> approveDispatcherList) {
		this.approveDispatcherList = approveDispatcherList;
	}
	
}
