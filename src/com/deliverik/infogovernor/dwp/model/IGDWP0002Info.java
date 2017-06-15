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
 * Description: 日常工作计划流程信息表
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface IGDWP0002Info extends BaseModel{

	/**
	 * 主键取得
	 * @return id 主键
	 */
	public Integer getId();

	/**
	 * 计划主键取得
	 * @return planid 计划主键
	 */
	public Integer getPlanid();

	/**
	 * 流程标题取得
	 * @return prtitle 流程标题
	 */
	public String getPrtitle();

	/**
	 * 流程描述取得
	 * @return prdesc 流程描述
	 */
	public String getPrdesc();

	/**
	 * 联系方式取得
	 * @return prinfo 联系方式
	 */
	public String getPrinfo();

	/**
	 * 发起人角色ID取得
	 * @return prroleid 发起人角色ID
	 */
	public Integer getPrroleid();
}
