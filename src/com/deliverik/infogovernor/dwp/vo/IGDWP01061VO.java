/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dwp.vo;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.UserInfo;
import com.deliverik.framework.workflow.prd.model.IG333Info;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 日常工作计划分派VO
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGDWP01061VO extends BaseVO{

	/** 分派信息集合 */
	protected Map<IG333Info,Map<Role, List<UserInfo>>> assignInfoMap;

	/**
	 * 分派信息集合取得
	 * @return assignInfoMap 分派信息集合
	 */
	public Map<IG333Info, Map<Role, List<UserInfo>>> getAssignInfoMap() {
		return assignInfoMap;
	}

	/**
	 * 分派信息集合设定
	 * @param assignInfoMap 分派信息集合
	 */
	public void setAssignInfoMap(
			Map<IG333Info, Map<Role, List<UserInfo>>> assignInfoMap) {
		this.assignInfoMap = assignInfoMap;
	}
}
