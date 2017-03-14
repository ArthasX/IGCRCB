/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.iam.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 内审项目接口
  * 功能描述: 内审项目接口
  * 创建记录: 2012/07/19
  * 修改记录: 
  */
public interface InternalauditprjInfo extends BaseModel {

	/**
	 * 无意义自增主键取得
	 *
	 * @return 无意义自增主键
	 */
	public Integer getIapId();

	/**
	 * 审计年度取得
	 *
	 * @return 审计年度
	 */
	public String getIapYear();

	/**
	 * 审计项目名称取得
	 *
	 * @return 审计项目名称
	 */
	public String getIapName();

	/**
	 * 审计项目状态取得
	 *
	 * @return 审计项目状态
	 */
	public String getIapStatus();

	/**
	 * 审计对象取得
	 *
	 * @return 审计对象
	 */
	public String getIapObject();

	/**
	 * 审计方式取得
	 *
	 * @return 审计方式
	 */
	public String getIapWay();

	/**
	 * 审计人员取得
	 *
	 * @return 审计人员
	 */
	public String getIapUserName();

	/**
	 * 审计开始日期取得
	 *
	 * @return 审计开始日期
	 */
	public String getIapOpenTime();

	/**
	 * 审计结束日期取得
	 *
	 * @return 审计结束日期
	 */
	public String getIapCloseTime();

	/**
	 * 审计目标取得
	 *
	 * @return 审计目标
	 */
	public String getIapObjective();

	/**
	 * 审计范围取得
	 *
	 * @return 审计范围
	 */
	public String getIapScope();

	/**
	 * 审计依据取得
	 *
	 * @return 审计依据
	 */
	public String getIapBasis ();

	/**
	 * 审计内容及要点取得
	 *
	 * @return 审计内容及要点
	 */
	public String getIapDesc();

	/**
	 * 审计配合人员取得
	 *
	 * @return 审计配合人员
	 */
	public String getIapCooperator();

	/**
	 * 审计建议取得
	 *
	 * @return 审计建议
	 */
	public String getIapSuggestion();

	/**
	 * 审计项目发起人ID取得
	 *
	 * @return 审计项目发起人ID
	 */
	public String getIapCreateUserId();

	/**
	 * 审计项目发起时间取得
	 *
	 * @return 审计项目发起时间
	 */
	public String getIapCreateTime();

	/**
	 * 审计项目确认人ID取得
	 *
	 * @return 审计项目确认人ID
	 */
	public String getIapConfirmUserId();

	/**
	 * 审计项目确认时间取得
	 *
	 * @return 审计项目确认时间
	 */
	public String getIapConfirmTime();

	/**
	 * 审计附件Key取得
	 *
	 * @return 审计附件Key
	 */
	public String getIapAttKey();

	/**
	 * 审计类型取得
	 * 
	 * @return 审计类型
	 */
	public String getIapType();
	
	/**
	 * 审计检查来源
	 * 
	 * @return 审计检查来源
	 */
	public String getIapSource();
}