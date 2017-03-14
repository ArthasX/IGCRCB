/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dut.model.condition;

/**
 * 概述: 日常维护查询条件接口
 * 功能描述: 日常维护查询条件接口
 * 创建记录: 2012/04/01
 * 修改记录: 
 */
public interface OnDutyPersonRecordSearchCond{
	
	/**
	 * 关键字取得
	 * @return the keywords_like
	 */
	public String getKeywords_like();
	
	
    /**
     * 按主键查询取得
     *
     * @return odprid_eq 按主键查询
     */
    public Integer getOdprid_eq();
    
    /**
     * 时间条件：从 取得
     * @return 时间条件：从
     */
	public String getOdprctime_ge();

	/**
	 * 时间条件：到取得
	 * @return 时间条件：到
	 */
	public String getOdprctime_le();

}
