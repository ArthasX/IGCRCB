/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.model.condition;

/**
  * 概述: EntityItemAndConfigItemVW检索条件实现
  * 功能描述: EntityItemAndConfigItemVW检索条件实现
  * 创建记录: 2012/08/03
  * 修改记录: 
  */
public class IG342SearchCondImpl implements
		IG342SearchCond {

	/** 服务商登记开始时间 */
	protected String beginTime_q;
	
	/** 服务商登记结束时间 */
	protected String endTime_q;

	/**
	 * 获取beginTime_q
	 * @return fbeginTime_q beginTime_q
	 */
	public String getBeginTime_q() {
		return beginTime_q;
	}

	/**
	 * 设置beginTime_q
	 * @param beginTime_q  beginTime_q
	 */
	public void setBeginTime_q(String beginTime_q) {
		this.beginTime_q = beginTime_q;
	}

	/**
	 * 获取endTime_q
	 * @return fendTime_q endTime_q
	 */
	public String getEndTime_q() {
		return endTime_q;
	}

	/**
	 * 设置endTime_q
	 * @param endTime_q  endTime_q
	 */
	public void setEndTime_q(String endTime_q) {
		this.endTime_q = endTime_q;
	}
	
	
}