/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.wim.model.condition;

import java.util.List;

/**
  * 概述: 工作定义检索条件接口
  * 功能描述: 工作定义检索条件接口
  * 创建记录: 2017/06/09
  * 修改记录: 
  */
public interface WorkDefinitionSearchCond {

	/**
	 * 工作项名称取得
	 * @return 工作项名称
	 */
	public String getWdname();

	/**
	 * 启用状态（0，未启用；1，已启用）取得
	 * @return 启用状态（0，未启用；1，已启用）
	 */
	public String getWdstatus();
	
	/**
	 * 负责人（userid）取得
	 * @return 负责人（userid）
	 */
	public String getLeaderId();
	
	/**
	 * 执行人名称取得
	 * @return 执行人名称
	 */
	public String getExcutorName();
	
	/**
	 * 发起人（userid）取得
	 * @return 发起人（userid）
	 */
	public String getInitiatorId();
	
	/**
	 * 发起人名称取得
	 * @return 发起人名称
	 */
	public String getLeaderName();
	
	/**
	 * 发起人（userid匹配多个）取得
	 * @return 发起人（userid匹配多个）
	 */
	public List<String> getInitiatorId_in();
	
	/**
	 * 开始日期从取得
	 * @return 开始日期从
	 */
	public String getBeginDateStart();

	/**
	 * 开始日期到取得
	 * @return 开始日期到
	 */
	public String getBeginDateOver();
}