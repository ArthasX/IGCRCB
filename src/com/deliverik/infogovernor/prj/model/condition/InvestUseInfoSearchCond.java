/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prj.model.condition;

/**
 * 概述:投资使用明细查询条件接口 
 * 功能描述：投资使用明细查询条件接口
 * 创建人：王廷志
 * 创建记录： 2012-5-22
 * 修改记录：
 */
public interface InvestUseInfoSearchCond {
	/**
	 * 项目发起时间开始取得
	 * @return popentime_start 项目发起时间开始
	 */
	public String getPopentime_start();
	/**
	 * 项目发起时间结束取得
	 * @return popentime_end 项目发起时间结束
	 */
	public String getPopentime_end();
}
