/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prr.model;

/**
 * 概述:带有处理人的本月工作查询 
 * 功能描述：带有处理人的本月工作查询 
 * 创建人：赵梓廷
 * 创建记录： 2013-04-19
 * 修改记录：
 */
public interface CurrentMonthWorkVWInfo {

	/**
	 * 流程记录ID取得
	 * @return流程记录ID
	 */
	public Integer getPrid();
	
	
	/**
	 * 流程记录类型取得
	 * @return 流程记录类型
	 */
	public String getPrtype();
	
	
	/**
	 * 流程记录状态取得
	 * @return 流程记录状态
	 */
	public String getPrstatus();
	
	/**
	 * 流程记录状态子状态取得
	 * @return 流程记录状态子状态
	 */
	public String getPrsubstatus();
	
	/**
	 * 流程记录题目取得
	 * @return 流程记录题目
	 */
	public String getPrtitle();
	
	
	/**
	 * 流程记录建立时间取得
	 * @return 流程记录建立时间
	 */
	public String getPropentime();
	
	/**
	 * 流程记录关闭时间取得
	 * @return 流程记录关闭时间
	 */
	public String getPrclosetime();
	
	/**
	 * 流程记录紧急程度取得
	 * @return 流程记录紧急程度
	 */
	public String getPrurgency();
	
	/**
	 * 流程记录影响程度取得
	 * @return 流程记录影响程度
	 */
	public String getPrimpact();
	
	/**
	 * 流程记录发起者用户姓名取得
	 * @return 流程记录发起者用户姓名
	 */
	public String getPrusername();
	

	
	/**
	 * 流程记录流程类型ID取得
	 * @return 流程记录流程类型ID
	 */
	public String getPrpdid();
	
	/**
	 * 流程记录流程类型名称取得
	 * @return 流程记录流程类型名称
	 */
	public String getPrpdname() ;
	
	/**
	 * 流程记录工单号取得
	 * @return 流程记录工单号
	 */
	public String getPrserialnum();
	
	
	public String getPpusername();
	/**
	 * 参与人合并后的角色名取得
	 * @return 参与人合并后的角色名
	 */
	public String getPprolename();
	
	/**
	 * 流程记录发起者用户ID取得
	 * @return 流程记录发起者用户ID
	 */
	public String getPruserid();
	
	/**
	 * 流程记录发起者角色ID取得
	 * @return 流程记录发起者角色ID
	 */
	public Integer getPrroleid();
	

	
	/**
	 * 参与人合并后的用户id取得
	 * @return 参与人合并后的用户id
	 */
	public String getPpuserid();
	
	/**
	 * 参与者角色id取得
	 * @return 参与者角色id
	 */
	public String getPproleid();
	/**
	 * 流程记录发起者角色名称取得
	 * @return 流程记录发起者角色名称
	 */
	public String getPrrolename();
}
