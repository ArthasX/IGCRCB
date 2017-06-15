/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 附加报表接口
  * 功能描述: 附加报表接口
  * 创建记录: 2012/06/06
  * 修改记录: 2012/08/09 将ReportAnnexationInfo表名改为SOC0202Info
  */
public interface SOC0202Info extends BaseModel {

	/**
	 * 附加ID取得
	 *
	 * @return 附加ID
	 */
	public Integer getRaId();

	/**
	 * 附加报表名字取得
	 *
	 * @return 附加报表名字
	 */
	public String getRaName();

	/**
	 * 存储序列号取得
	 *
	 * @return 存储序列号
	 */
	public String getRaSsn();

	/**
	 * kpi取得
	 *
	 * @return kpi
	 */
	public String getRaKpi();

	/**
	 * 开始时间取得
	 *
	 * @return 开始时间
	 */
	public String getRaCreateDate();

	
	/**
	 * Word文档名称取得
	 *
	 * @return raRealName Word文档名称
	 */
	public String getRaRealName();
	/**
	 * 用户名字取得
	 *
	 * @return raUserName 用户名字
	 */
	public String getRaUserName();
	/**
	 * 是否被使用取得
	 *
	 * @return isUsed 是否被使用
	 */
	public String getIsUsed();
}