/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.model.condition;

/**
  * 概述: 报表自定链接检索条件接口
  * 功能描述: 报表自定链接检索条件接口
  * 创建记录: 2012/07/20
  * 修改记录: 2012/08/10 将ReportCustomLinkSearchCond表名修改为SOC0204SearchCond
  */
public interface SOC0204SearchCond {
	/**
	 * 报表类型取得
	 *
	 * @return rclReportType_eq 报表类型
	 */
	public String getRclReportType_eq();

	/**
	 * 对象名称取得
	 *
	 * @return rclObjName_eq 对象名称
	 */
	public String getRclObjName_eq();

	/**
	 * 模板名字取得
	 *
	 * @return rclTemName_eq 模板名字
	 */
	public String getRclTemName_eq();

	/**
	 * 模板描述取得
	 *
	 * @return rclTemDesc_eq 模板描述
	 */
	public String getRclTemDesc_eq();

	/**
	 * 模板标题取得
	 *
	 * @return rclRfdTitle_eq 模板标题
	 */
	public String getRclRfdTitle_eq();

	/**
	 * 对象Eiid取得
	 *
	 * @return rclObjEiid_eq 对象Eiid
	 */
	public Integer getRclObjEiid_eq();

	/**
	 * 对象类型取得
	 *
	 * @return rclObjType_eq 对象类型
	 */
	public String getRclObjType_eq();

	/**
	 * 容量Mode取得
	 *
	 * @return rclMode_eq 容量Mode
	 */
	public String getRclMode_eq();

	/**
	 * 容量主机小类型取得
	 *
	 * @return rclCaType_eq 容量主机小类型
	 */
	public String getRclCaType_eq();

	/**
	 * 菜单默认取得
	 *
	 * @return rclMenuDefault_eq 菜单默认
	 */
	public String getRclMenuDefault_eq();

	/**
	 * 用户帐号取得
	 *
	 * @return rclUserId_eq 用户帐号
	 */
	public String getRclUserId_eq();
}