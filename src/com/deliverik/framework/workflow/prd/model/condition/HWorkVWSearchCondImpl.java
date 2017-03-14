/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prd.model.condition;

/**
 * 
 * 历史工作统计视图查询接口实现
 *
 */
public class HWorkVWSearchCondImpl implements HWorkVWSearchCond {
	
	/**发布时间*/
	protected String propentime ;
	/**发起人员*/
	protected String pruserid;
	public String getPropentime() {
		return propentime;
	}
	public void setPropentime(String propentime) {
		this.propentime = propentime;
	}
	public String getPruserid() {
		return pruserid;
	}
	public void setPruserid(String pruserid) {
		this.pruserid = pruserid;
	}
	
}
