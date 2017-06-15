/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.scheduling.dto;

import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.user.model.Role;
import com.deliverik.infogovernor.scheduling.form.IGSCH0401Form;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 服务管理_服务策略_事件监督DTO
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSCH04DTO extends BaseDTO {

	private IGSCH0401Form igsch0401Form;
	
	private List<Role> roleList;

	public IGSCH0401Form getIgsch0401Form() {
		return igsch0401Form;
	}

	public void setIgsch0401Form(IGSCH0401Form igsch0401Form) {
		this.igsch0401Form = igsch0401Form;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}
	
}