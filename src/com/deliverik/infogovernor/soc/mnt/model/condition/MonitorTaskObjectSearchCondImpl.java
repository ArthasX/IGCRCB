/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.mnt.model.condition;

/**
  * 概述: 监控任务对象表检索条件实现
  * 功能描述: 监控任务对象表检索条件实现
  * 创建记录: 2012/05/10
  * 修改记录: 
  */
public class MonitorTaskObjectSearchCondImpl implements
		MonitorTaskObjectSearchCond {
	/**任务ID*/
	protected Integer mtid;

	/**
	 * 任务ID取得
	 *
	 * @return mtid 任务ID
	 */
	public Integer getMtid() {
		return mtid;
	}

	/**
	 * 任务ID设定
	 *
	 * @param mtid 任务ID
	 */
	public void setMtid(Integer mtid) {
		this.mtid = mtid;
	}
	
}