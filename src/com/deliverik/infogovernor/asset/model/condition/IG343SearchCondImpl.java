/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.model.condition;

/**
  * 概述: EntityItemRelationVW检索条件实现
  * 功能描述: EntityItemRelationVW检索条件实现
  * 创建记录: 2012/07/12
  * 修改记录: 
  */
public class IG343SearchCondImpl implements
IG343SearchCond {

	/** 服务商名称 */
	protected String einame_like;
	
	/** 服务记录开始时间 */
	protected String beginTime_q;
	
	/** 服务记录结束时间 */
	protected String endTime_q;


	/**
	 * 获取服务商名称
	 * @return einame_like
	 */
	public String getEiname_like() {
		return einame_like;
	}

	/**
	 * 设置服务商名称
	 * @param einame_like
	 */
	public void setEiname_like(String einame_like) {
		this.einame_like = einame_like;
	}

	/**
	 * 获取服务记录开始时间
	 * @return beginTime_q
	 */
	public String getBeginTime_q() {
		return beginTime_q;
	}

	/**
	 * 设置服务记录开始时间
	 * @param beginTime_q
	 */
	public void setBeginTime_q(String beginTime_q) {
		this.beginTime_q = beginTime_q;
	}

	/**
	 * 获取服务记录结束时间
	 * @return endTime_q
	 */
	public String getEndTime_q() {
		return endTime_q;
	}

	/**
	 * 设置服务记录结束时间
	 * @param endTime_q
	 */
	public void setEndTime_q(String endTime_q) {
		this.endTime_q = endTime_q;
	}
	
}