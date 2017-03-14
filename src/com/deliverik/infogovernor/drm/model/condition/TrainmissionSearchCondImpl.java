/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.model.condition;

/**
  * 概述: 培训任务表检索条件实现
  * 功能描述: 培训任务表检索条件实现
  * 创建记录: 2015/04/10
  * 修改记录: 
  */
public class TrainmissionSearchCondImpl implements
		TrainmissionSearchCond {
	
	/** 主键 */
	protected Integer tpid;

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getTpid() {
		return tpid;
	}

	/**
	 * 主键设定
	 *
	 * @return tpid 主键
	 */
	public void setTpid(Integer tpid) {
		this.tpid = tpid;
	}
	
	

}