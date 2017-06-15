/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 模板映射表接口
  * 功能描述: 模板映射表接口
  * 创建记录: 2012/06/06
  * 修改记录: 2012/08/09 将ReportTemplateMappingInfo表名改为SOC0206Info
  */
public interface SOC0206Info extends BaseModel {

	/**
	 * 流水ID取得
	 *
	 * @return 流水ID
	 */
	public Integer getRtmId();

	/**
	 * 模板位置序号取得
	 *
	 * @return 模板位置序号
	 */
	public Integer getRtNumber();

	/**
	 * 存储序列号取得
	 *
	 * @return 存储序列号
	 */
	public String getRtmSsn();

	/**
	 * KPI取得
	 *
	 * @return KPI
	 */
	public String getRtmKpi();

	/**
	 * Word文档对象图片位置取得
	 *
	 * @return Word文档对象图片位置
	 */
	public Integer getRtmImgNumber();
	/**
	 * 标识取得
	 *
	 * @return rtmFlag 标识
	 */
	public String getRtmFlag();
	/**
	 * 存储类型取得
	 *
	 * @return rtmSsnType 存储类型
	 */
	public String getRtmSsnType();
}