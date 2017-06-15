/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prr.vo;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.UserInfo;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 自定义流程参与者vo
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGPRR01036VO extends BaseVO{
	
	/** 根据角色显示参与者 */
	protected Map<Role, List<UserInfo>> map_ParticipantDefToBeAssignByRole;
	
	/** 根据机构显示参与者 */
	protected Map<Organization, List<UserInfo>> map_ParticipantDefToBeAssignByOrg;

	/**
	 * 根据角色显示参与者取得
	 * @return 根据角色显示参与者
	 */
	public Map<Role, List<UserInfo>> getMap_ParticipantDefToBeAssignByRole() {
		return map_ParticipantDefToBeAssignByRole;
	}

	/**
	 * 根据角色显示参与者设定
	 * @param map_ParticipantDefToBeAssignByRole 根据角色显示参与者
	 */
	public void setMap_ParticipantDefToBeAssignByRole(
			Map<Role, List<UserInfo>> map_ParticipantDefToBeAssignByRole) {
		this.map_ParticipantDefToBeAssignByRole = map_ParticipantDefToBeAssignByRole;
	}

	/**
	 * 根据机构显示参与者取得
	 * @return  根据机构显示参与者
	 */
	public Map<Organization, List<UserInfo>> getMap_ParticipantDefToBeAssignByOrg() {
		return map_ParticipantDefToBeAssignByOrg;
	}

	/**
	 * 根据机构显示参与者设定
	 * @param map_ParticipantDefToBeAssignByOrg 根据机构显示参与者
	 */
	public void setMap_ParticipantDefToBeAssignByOrg(
			Map<Organization, List<UserInfo>> map_ParticipantDefToBeAssignByOrg) {
		this.map_ParticipantDefToBeAssignByOrg = map_ParticipantDefToBeAssignByOrg;
	}
}
