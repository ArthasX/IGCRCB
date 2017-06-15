/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.dbm.model.condition;

/**
  * 概述: 工作管理检索条件接口
  * 功能描述: 工作管理检索条件接口
  * 创建记录: 2016/04/19
  * 修改记录: 
  */
public interface WorkmanagerSearchCond {

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getWmid();

	/**
	 * 工作名称取得
	 *
	 * @return 工作名称
	 */
	public String getWmname();

	/**
	 * 描述取得
	 *
	 * @return 描述
	 */
	public String getWmdesc();
	
	/**
	 * 完成状态(0-未完成1-已完成)取得
	 *
	 * @return 完成状态(0-未完成1-已完成)
	 */
	public String getWmstatus();

	/**
	 * @return the 发起日期
	 */
	public String getWmstartdate_from();
	
	/**
	 * @return the wmstartdate_to
	 */
	public String getWmstartdate_to();
	
	/**
	 * @return the 频率
	 */
	public String getWmfrequency();
	
	/**
	 * @return the wmusername
	 */
	public String getWmusername();
	
	/**
	 * @return the 数据源wmid
	 */
	public String getRewmid();
	
	/**
	 * @return the 发起日期
	 */
	public String getWmstartdate();
	
	/**
	 * @return the 是否提醒0-提醒1-不再提醒
	 */
	public String getWmremind();
}