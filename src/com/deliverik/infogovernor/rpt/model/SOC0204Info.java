/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 报表自定链接接口
  * 功能描述: 报表自定链接接口
  * 创建记录: 2012/07/20
  * 修改记录: 2012/08/09 将ReportCustomLinkInfo表名改为SOC0204Info
  */
public interface SOC0204Info extends BaseModel {

	/**
	 * 主键ID取得
	 *
	 * @return 主键ID
	 */
	public Integer getRclId();

	/**
	 * 报表类型取得
	 *
	 * @return 报表类型
	 */
	public String getRclReportType();

	/**
	 * 对象名称取得
	 *
	 * @return 对象名称
	 */
	public String getRclObjName();

	/**
	 * 模板名字取得
	 *
	 * @return 模板名字
	 */
	public String getRclTemName();

	/**
	 * 模板描述取得
	 *
	 * @return 模板描述
	 */
	public String getRclTemDesc();

	/**
	 * 对象Eiid取得
	 *
	 * @return 对象Eiid
	 */
	public Integer getRclObjEiid();

	/**
	 * 对象类型取得
	 *
	 * @return 对象类型
	 */
	public String getRclObjType();

	/**
	 * 容量Mode取得
	 *
	 * @return 容量Mode
	 */
	public String getRclMode();

	/**
	 * 容量主机小类型取得
	 *
	 * @return 容量主机小类型
	 */
	public String getRclCaType();

	/**
	 * 菜单默认取得
	 *
	 * @return 菜单默认
	 */
	public String getRclMenuDefault();

	/**
	 * 用户帐号取得
	 *
	 * @return 用户帐号
	 */
	public String getRclUserId();
	/**
	 * 模板标题取得
	 *
	 * @return rclRfdTitle 模板标题
	 */
	public String getRclRfdTitle();

}