/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rdp.model.condition;

/**
  * 概述: 日志信息检索条件实现
  * 功能描述: 日志信息检索条件实现
  * 创建记录: 2014/05/06
  * 修改记录: 
  */
public class RealtimedetailSearchCondImpl implements
		RealtimedetailSearchCond {
	
	private Integer taskid;
	private String hostip;
	private Integer rtdid_gt;
	
	
	
	public Integer getRtdid_gt() {
		return rtdid_gt;
	}
	public void setRtdid_gt(Integer rtdid_gt) {
		this.rtdid_gt = rtdid_gt;
	}
	public Integer getTaskid() {
		return taskid;
	}
	public void setTaskid(Integer taskid) {
		this.taskid = taskid;
	}
	public String getHostip() {
		return hostip;
	}
	public void setHostip(String hostip) {
		this.hostip = hostip;
	}
	
	

}