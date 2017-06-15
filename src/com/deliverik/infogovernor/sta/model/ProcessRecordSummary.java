/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */

package com.deliverik.infogovernor.sta.model;

/**
 * 
 * 检查问题统计实体接口
 * 
 */
public interface ProcessRecordSummary{
	
	/**
	 * 主键取得
	 * @return 主键
	 */	
	public Integer getPrsid();
	/**
	 * 问题种类名称取得
	 * @return 问题种类名称
	 */	
	public String getPname();
	/**
	 * 问题种类取得
	 * @return 问题种类
	 */	
	public String getPcode();
	
	/**
	 * 问题来源取得
	 * @return 问题来源
	 */
	public String getPrassetname();
	
	/**
     * 等待制定计划数量取得
     *
     * @return initials 等待制定计划数量
     */
    public Integer getInitials();
	
	/**
	 * 等待审批计划数量取得
	 * @return 等待审批计划数量
	 */	
	public Integer getAppoval();
	
	/**
	 * 等待整改执行数量取得
	 * @return 等待整改执行数量
	 */	
	public Integer getImplement();
	
	/**
	 * 等待验证数量取得
	 * @return 等待验证数量
	 */	
	public Integer getVerify();
	
	/**
	 * 关闭数量取得
	 * @return 关闭数量
	 */	
	public Integer getClose();	

	/**
	 * 等待制定计划数量取得
	 * @return 等待制定计划数量
	 */
	public Integer getDispatch();
}
