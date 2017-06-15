/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model.condition;

/**
 * 
 * 预支费用查询接口
 *
 */
public interface AdvanCescostSearchCond {
	
	/**
	 * 预支费用计财记帐日期查询时间开始
	 */
	public String getAcdate_from();
	
	/**
	 * 预支费用计财记帐日期查询时间结束
	 */
	public String getAcdate_to();
	
	/**
	 * 预支费用状态取得
	 * @return 预支费用状态
	 */
	public String getAcstatus_q();
	
}
