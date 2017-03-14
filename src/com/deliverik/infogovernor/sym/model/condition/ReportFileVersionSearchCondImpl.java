/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sym.model.condition;

/**
 * 报表版本信息查询条件实现
 * 
 */
public class ReportFileVersionSearchCondImpl implements ReportFileVersionSearchCond {
	
	/** 报表主键 */
	protected Integer rfdid;
	
	/**
	 * 主键取得
	 * @return 主键
	 */
	public Integer getRfdid() {
		return rfdid;
	}
	
	/**
	 * 主键设定
	 * @param rfdid 主键
	 */
	public void setRfdid(Integer rfdid) {
		this.rfdid = rfdid;
	}
}
