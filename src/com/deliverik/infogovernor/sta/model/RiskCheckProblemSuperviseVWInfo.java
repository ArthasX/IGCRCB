/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.sta.model;


/**
  * 概述: 发文流程统计接口
  * 功能描述: 发文流程统计接口
  * 创建记录: 2013/02/27
  * 修改记录: 
  */
public interface RiskCheckProblemSuperviseVWInfo {
	/**
	 * 主键流程ID取得
	 * @return prid 主键流程ID
	 */
	public String getPrid() ;

	/**
	 * 流程定义Id取得
	 * @return prpdid 流程定义Id
	 */
	public String getPrpdid();
	
	/**
	 * 问题名称取得
	 * @return prtitle 问题名称
	 */
	public String getPrtitle() ;

	/**
	 * 问题描述取得
	 * @return prdesc 问题描述
	 */
	public String getPrdesc() ;

	/**
	 * 流程发起者id取得
	 * @return pruserid 流程发起者id
	 */
	public String getPruserid() ;

	/**
	 * 流程发起者名字取得
	 * @return prusername 流程发起者名字
	 */
	public String getPrusername() ;

	/**
	 * 问题发起时间取得
	 * @return propentime 问题发起时间
	 */
	public String getPropentime() ;
	/**
	 * 问题结束时间取得
	 * @return prclosetime 问题结束时间
	 */
	public String getPrclosetime() ;
	/**
	 * 问题状态取得
	 * @return prstatus 问题状态
	 */
	public String getPrstatus();
	/**
	 * 检查项类别取得
	 * @return riskprype 检查项类别
	 */
	public String getRiskprype() ;

	/**
	 * 问题来源取得
	 * @return problemsource 问题来源
	 */
	public String getProblemsource() ;

	

}