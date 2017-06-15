/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 报告模板接口
  * 功能描述: 报告模板接口
  * 创建记录: 2012/06/06
  * 修改记录: 2012/08/09 将ReportTemplateInfo表名改为SOC0207Info
  */
public interface SOC0207Info extends BaseModel {

	/**
	 * ID取得
	 *
	 * @return ID
	 */
	public Integer getRtId();

	/**
	 * 模板名称取得
	 *
	 * @return 模板名称
	 */
	public String getRtName();

	/**
	 * 可修改位置数取得
	 *
	 * @return 可修改位置数
	 */
	public Integer getRtSum();

	/**
	 * 时间类型取得
	 *
	 * @return 时间类型
	 */
	public String getRtDateType();

	/**
	 * 模板真实名字取得
	 *
	 * @return 模板真实名字
	 */
	public String getRtRealName();

	/**
	 * 模板上传时间取得
	 *
	 * @return 模板上传时间
	 */
	public String getRtUploadTime();

	/**
	 * 模板类型取得
	 *
	 * @return 模板类型
	 */
	public String getRtType();

}