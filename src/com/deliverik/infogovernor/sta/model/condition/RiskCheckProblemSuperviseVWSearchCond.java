/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.sta.model.condition;

/**
  * 概述: 问题整改监督检索条件接口
  * 功能描述: 问题整改监督检索条件接口
  * 创建记录: 2013/02/27
  * 修改记录: 
  */
public interface RiskCheckProblemSuperviseVWSearchCond {
	/**
	 * 问题标题取得
	 * @return prtitle 问题标题
	 */
	public String getPrtitle() ;

	/**
	 * 问题描述取得
	 * @return prdesc 问题描述
	 */
	public String getPrdesc() ;

	/**
	 * 问题发起时间从取得
	 * @return propentime_from 问题发起时间从
	 */
	public String getPropentime_from() ;

	/**
	 * 问题发起时间到取得
	 * @return propentime_to 问题发起时间到
	 */
	public String getPropentime_to() ;

	/**
	 * 问题状态取得
	 * @return prstatus 问题状态
	 */
	public String getPrstatus() ;
	
	/**
	 * 问题查询状态取得
	 * @return questionstatus 问题查询状态
	 */
	public String getQuestionstatus();
	
	/**
     * 问题分类取得
     *
     * @return category 问题分类
     */
    public String getCategory();
    
	public String getRcclass();
	
	public String getRcsourse();
}