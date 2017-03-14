/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.model;

import com.deliverik.framework.base.BaseModel;
import com.deliverik.infogovernor.rpt.model.entity.SOC0207TB;

/**
  * 概述: 报告管理表接口
  * 功能描述: 报告管理表接口
  * 创建记录: 2012/06/06
  * 修改记录: 2012/08/09 将ReportManageInfo表名改为SOC0205Info
  */
public interface SOC0205Info extends BaseModel {

	/**
	 * 报告ID取得
	 *
	 * @return 报告ID
	 */
	public Integer getRmId();

	/**
	 * 报告名称取得
	 *
	 * @return 报告名称
	 */
	public String getRmName();

	/**
	 * 模板对象取得
	 *
	 * @return 模板对象
	 */
	public SOC0207TB getReportTemplateTB();

	/**
	 * 年取得
	 *
	 * @return 年
	 */
	public String getRmYear();

	/**
	 * 季度取得
	 *
	 * @return 季度
	 */
	public String getRmQuarter();

	/**
	 * 月取得
	 *
	 * @return 月
	 */
	public String getRmMonth();

	/**
	 * 创建时间取得
	 *
	 * @return 创建时间
	 */
	public String getCreateDate();
	/**
	 * 最后添加附加报表时间取得
	 *
	 * @return lastAnnexationDate 最后添加附加报表时间
	 */
	public String getLastAnnexationDate();
	/**
	 * 类型取得
	 *
	 * @return rmDateType 类型
	 */
	public String getRmDateType();


	/**
	 * 最后一天取得
	 *
	 * @return rmLastDay 最后一天
	 */
	public String getRmLastDay() ;
	/**
	 * 模板名字取得
	 *
	 * @return rtName 模板名字
	 */
	public String getRtName();
	/**
	 * 存放附加报表ID以逗号为分隔符取得
	 *
	 * @return raStr 存放附加报表ID以逗号为分隔符
	 */
	public String getRaStr();
	/**
	 * 后缀名字取得
	 *
	 * @return rmSuffix 后缀名字
	 */
	public String getRmSuffix();
}