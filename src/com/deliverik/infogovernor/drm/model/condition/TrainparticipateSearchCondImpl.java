/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.model.condition;

/**
  * 概述: 培训参与人检索条件实现
  * 功能描述: 培训参与人检索条件实现
  * 创建记录: 2015/04/13
  * 修改记录: 
  */
public class TrainparticipateSearchCondImpl implements TrainparticipateSearchCond {

	/** 培训记录ID */
	protected Integer trid;

	/**  
	 * 获取培训记录ID  
	 * @return trid 培训记录ID  
	 */
	
	public Integer getTrid() {
		return trid;
	}

	/**  
	 * 设置培训记录ID  
	 * @param trid 培训记录ID  
	 */
	
	public void setTrid(Integer trid) {
		this.trid = trid;
	}
}