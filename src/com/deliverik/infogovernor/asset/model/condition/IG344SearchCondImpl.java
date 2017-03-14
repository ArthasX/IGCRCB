/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.model.condition;

/**
  * 概述: EntityItemRelationDetailVW检索条件实现
  * 功能描述: EntityItemRelationDetailVW检索条件实现
  * 创建记录: 2012/07/13
  * 修改记录: 
  */
public class IG344SearchCondImpl implements
IG344SearchCond {

	/** 服务商编号 */
	protected String eiid_q;
	
	/** 服务记录开始时间 */
	protected String beginTime_q;
	
	/** 服务记录结束时间 */
	protected String endTime_q;

	/**
	 * 获取eiid_q
	 * @return feiid_q eiid_q
	 */
	public String getEiid_q() {
		return eiid_q;
	}

	/**
	 * 设置eiid_q
	 * @param eiid_q  eiid_q
	 */
	public void setEiid_q(String eiid_q) {
		this.eiid_q = eiid_q;
	}

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