/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prd.model;

import java.util.List;

import com.deliverik.framework.base.BaseModel;
import com.deliverik.framework.user.model.entity.OrganizationTB;
import com.deliverik.framework.user.model.entity.RoleTB;
import com.deliverik.framework.user.model.entity.UserTB;
import com.deliverik.framework.workflow.prd.model.entity.IG132TB;

/**
 * <p>概述:流程参与者定义接口</p>
 * <p>功能描述：</p>
 * <p>创建记录：</p>
 */
public interface IG222Info  extends BaseModel {
	/**
	 * 功能：流程参与者ID取得
	 * @return 流程参与者ID
	 */
	public String getPpdid();
	
	/**
	 * 功能：流程状态ID取得
	 * @return 流程状态ID
	 */
	public String getPsdid();
	
	/**
	 * 功能：流程参与者角色ID取得
	 * @return 流程参与者角色ID
	 */
	public Integer getRoleid();
	
	/**
	 * 功能：流程参与者ID取得
	 * @return 流程参与者ID
	 */
	public String getUserid();
	
	/**
	 * 流程super参与者标识取得
	 * @return 流程super参与者标识
	 */
	public String getPpdsuper();
	
	/**
	 * 功能：角色取得
	 * @return 角色
	 */
	public RoleTB getRole();
	
	/**
	 * 功能：用户取得
	 * @return 用户
	 */
	public UserTB getUser();
	
	public List<IG132TB> getProcessParticipantButtonDefList();
	
	/**
	 * 机构码取得
	 * @return 机构码
	 */
	public String getOrgid();
	
	/**
	 * 机构取得
	 * @return 机构
	 */
	public OrganizationTB getOrg();
}
