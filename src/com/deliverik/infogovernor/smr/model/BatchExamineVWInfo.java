/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.smr.model;

import java.io.Serializable;

/**
 * 概述:批量审批 
 * 功能描述：批量审批 
 * 创建人：赵梓廷
 * 创建记录： 2013-07-31
 * 修改记录：
 */
public interface BatchExamineVWInfo extends Serializable{

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getPrid();
	
	/**
	 * 报表名 取得
	 *
	 * @return 报表名 
	 */
	public String getPrtitle();
	
	/**
	 * 填报完成时间 取得
	 *
	 * @return 填报完成时间 
	 */
	public String getFillintime();
	
	/**
	 * 报表审批完成时间 取得
	 *
	 * @return 报表审批完成时间 
	 */
	public String getExaminetime();
	
	/**
	 * 填报人 取得
	 *
	 * @return 填报人 
	 */
	public String getFillinusername();
	
	/**
	 * 报表审批人 取得
	 *
	 * @return 报表审批人 
	 */
	public String getExanimeusername();
	
	/**
	 * 状态取得
	 *
	 * @return 状态
	 */
	public String getPrstatus();
	
	/**
	 * 驳回时间取得
	 *
	 * @return 驳回时间
	 */
	public String getRejecttime();
	/**
	 * 流程类型id取得
	 *
	 * @return 流程类型id
	 */
	public String getPrpdid();
	
	
	public String getFlag();
	
}
