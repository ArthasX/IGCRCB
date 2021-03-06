/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.risk.model.condition;

import java.util.Set;

/**
  * 概述: 检查任务检索条件接口
  * 功能描述: 检查任务检索条件接口
  * 创建记录: 2014/09/02
  * 修改记录: 
  */
public interface CheckWorkResultSearchCond {

	
	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getCwrid();

	/**
	 * 检查策略id取得
	 *
	 * @return 检查策略id
	 */
	public Integer getCsid();

	/**
	 * 检查任务名称取得
	 *
	 * @return 检查任务名称
	 */
	public String getCwrname();

	/**
	 * 任务开始时间取得
	 *
	 * @return 任务开始时间
	 */
	public String getCwrplandate();

	/**
	 * 任务完成时间取得
	 *
	 * @return 任务完成时间
	 */
	public String getCwrrealtime();

	/**
	 * 责任人id取得
	 *
	 * @return 责任人id
	 */
	public String getCwruserid();

	/**
	 * 责任人姓名取得
	 *
	 * @return 责任人姓名
	 */
	public String getCwrusername();

	/**
	 * 合作责任人id取得
	 *
	 * @return 合作责任人id
	 */
	public String getCwrassetid();

	/**
	 * 合作责任人姓名取得
	 *
	 * @return 合作责任人姓名
	 */
	public String getCwrassetname();

	/**
	 * 进度取得
	 *
	 * @return 进度
	 */
	public String getCwrrate();
	
	/**
	 * 检查方式
	 * 
	 * @return 检查方式
	 */
	public String getCwrtestmode();
	
	public String getCwrid_in();
	
	public String getCwrrealtime_to();
	
	public String getCwrrealtime_from();
	
	public String getCwrplandate_to();
	
	public String getCwrplandate_from();
	
	public Set<Integer> getCwrid_inSet();
}