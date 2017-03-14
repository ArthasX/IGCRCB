/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.dbs.model.condition;

/**
 * 
 * @Description:存储基本信息Cond类
 * @Author
 * @History
 * @Version V1.0
 */
public class Collect_BusySearchCondImpl implements Collect_BusySearchCond {
	
	/**
	 * 查询时间开始
	 */
	protected String date_from;
	
	/**
	 * 查询时间结束
	 */
	protected String date_to;
	
	/**
	 * 查询dataid
	 */
	private String dataid;
	
	/**
	 * 查询flag Max 为最大、AVG为平均
	 */
	private String flag;
	
	private String symm_model;

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getDataid() {
		return dataid;
	}

	public void setDataid(String dataid) {
		this.dataid = dataid;
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

	public String getSymm_model() {
		return symm_model;
	}

	public void setSymm_model(String symm_model) {
		this.symm_model = symm_model;
	}
}
