/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.dbs.model.condition;

/**
 * 
 * @Description:存储实时信息视图Cond类
 * @Author
 * @History
 * @Version V1.0
 */
public class Collect_Symmetrix_Monitor_RtVWSearchCondImpl implements
		Collect_Symmetrix_Monitor_RtVWSearchCond {
	/**
	 *序列号
	 */
	protected String symmid;
	
	/**
	 * 查询时间开始
	 */
	protected String date_from;
	
	/**
	 * 查询时间结束
	 */
	protected String date_to;
	
	/**
	 * 存储类型
	 */
	protected String serverType;

	public String getSymmid() {
		return symmid;
	}

	public void setSymmid(String symmid) {
		this.symmid = symmid;
	}
	public String getDate_from() {
		return date_from;
	}

	public void setDate_from(String date_from) {
		this.date_from = date_from;
	}

	public String getDate_to() {
		return date_to;
	}

	public void setDate_to(String date_to) {
		this.date_to = date_to;
	}

	public String getServerType() {
		return serverType;
	}

	public void setServerType(String serverType) {
		this.serverType = serverType;
	}

}
