/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prd.model.condition;


/**
 * 概述:流程评审Cond接口
 * 功能描述：
 *           
 * 创建记录：宋海洋    2010/11/26
 */
public interface IG433SearchCond {
	/**
	 * 功能：否评审完毕取得
	 * @return  否评审完毕
	 */
	public String getAssessmentstatus();


	/**
	 * 功能：流程记录题目取得
	 * @return  流程记录题目
	 */
	public String getPrtitle() ;

	
	/**
	 * 功能：流程记录发起者用户姓名取得
	 * @return 流程记录发起者用户姓名
	 */
	public String getPrusername();
	

	/**
	 * 功能：流程记录紧急程度取得
	 * @return 流程记录紧急程度
	 */
	public String getPrurgency();


	/**
	 * 功能：流程记录建立时间（大等于）取得
	 * @return 流程记录建立时间（大等于）
	 */
	public String getPropentime();


	/**
	 * 功能：流程记录流程类型ID取得
	 * @return 流程记录流程类型ID
	 */
	public String getPrpdid();


	/**
	 * 功能：流程记录计划执行周期取得
	 * @return 流程记录计划执行周期
	 */
	public String getPrclosetime() ;


	/**
	 * 功能：流程记录工单号取得
	 * @return 流程记录工单号
	 */
	public String getPrserialnum();
	
	/**
	 * 功能：排序标识取得
	 * @return  排序标识
	 */
	public String getOrder();
	
	/**
	 * 功能：排序标识取得
	 * @return  排序标识
	 */
	public String getSing();

	/**
	 *流程评审表主键取得
	 * 
	 * @return 流程评审表主键
	 */
	public Integer getPaid();
	
	/**
	 * 功能：事件类别code
	 * @return 事件类别code
	 */
	public String getPaeventtypecode();
	
	/**
	 * 获取流程类型
	 * @return 流程类型
	 */
	public String getPrtype() ;
	
	/**
	 * 获取流程ID
	 * @return 获取流程ID
	 */
	public Integer getPaprid();
}
