/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dwp.model;

import com.deliverik.framework.base.BaseModel;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 日常工作计划参与人信息表实体接口
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface IGDWP0004Info extends BaseModel{
	
	/**
	 * 主键取得
	 * @return id 主键
	 */
	public Integer getId();
	
	/**
	 * 计划ID取得
	 * @return planid 计划ID
	 */
	public Integer getPlanid();

	/**
	 * 流程信息ID取得
	 * @return prid 流程信息ID
	 */
	public Integer getPrid();

	/**
	 * 状态ID取得
	 * @return psdid 状态ID
	 */
	public String getPsdid();

	/**
	 * 用户ID取得
	 * @return usersid 用户ID
	 */
	public String getUserid();

	/**
	 * 处理角色ID取得
	 * @return roleid 处理角色ID
	 */
	public Integer getRoleid();
}
