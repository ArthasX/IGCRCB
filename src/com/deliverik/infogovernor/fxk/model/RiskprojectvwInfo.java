/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.fxk.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 风险计划查询
  * 功能描述: 风险计划查询
  * 创建记录: 2014/07/24
  * 修改记录: 
  */
public interface RiskprojectvwInfo extends BaseModel {

	/**
	 * 流程记录ID取得
	 *
	 * @return 流程记录ID
	 */
	public Integer getPrid ();

	/**
	 * 流程记录状态取得
	 *
	 * @return 流程记录状态
	 */
	public String getPrstatus();

	/**
	 * 流程记录题目取得
	 *
	 * @return 流程记录题目
	 */
	public String getPrtitle ();

	/**
	 * 流程记录建立时间取得
	 *
	 * @return 流程记录建立时间
	 */
	public String getPropentime();

	/**
	 * 流程记录计划执行时间取得
	 *
	 * @return 流程记录计划执行时间
	 */
	public String getPrplantime();

	/**
	 * 流程记录发起者角色名称取得
	 *
	 * @return 流程记录发起者角色名称
	 */
	public String getPrrolename();

	/**
	 * 流程记录工单号取得
	 *
	 * @return 流程记录工单号
	 */
	public String getPrserialnum();

	/**
	 * 风险计划类型取得
	 *
	 * @return 风险计划类型
	 */
	public String getRisktype();

	/**
	 * 流程记录发起者所属机构名称取得
	 *
	 * @return 流程记录发起者所属机构名称
	 */
	public String getProrgname();

	/**
	 * 计划完成情况取得
	 *
	 * @return 计划完成情况
	 */
	public String getRiskcompletion();

//	/**
//	 * 风险计划状态取得
//	 *
//	 * @return 风险计划状态
//	 */
//	public String getRiskstatus();

	/**
	 * 流程记录发起者所属机构层次码取得
	 *
	 * @return 流程记录发起者所属机构层次码
	 */
	public String getProrgid();

	/**
	 * 流程记录描述取得
	 *
	 * @return 流程记录描述
	 */
	public String getPrdesc();

	/**
	 * 风险编号取得
	 *
	 * @return 风险编号
	 */
	public String getRisknum();

	/**
	 * 流程记录流程类型名称取得
	 *
	 * @return 流程记录流程类型名称
	 */
	public String getPrpdname();

	/**
	 * 流程记录流程类型ID取得
	 *
	 * @return 流程记录流程类型ID
	 */
	public String getPrpdid();

	/**
	 * 流程记录发起者角色ID取得
	 *
	 * @return 流程记录发起者角色ID
	 */
	public String getPrroleid();

	/**
	 * 流程记录发起者用户姓名取得
	 *
	 * @return 流程记录发起者用户姓名
	 */
	public String getPrusername();

	/**
	 * 流程记录发起者用户ID取得
	 *
	 * @return 流程记录发起者用户ID
	 */
	public String getPruserid();

	/**
	 * 流程记录关闭时间取得
	 *
	 * @return 流程记录关闭时间
	 */
	public String getPrclosetime();
	
	public String getRiskstart();
	public String getRiskend();

}