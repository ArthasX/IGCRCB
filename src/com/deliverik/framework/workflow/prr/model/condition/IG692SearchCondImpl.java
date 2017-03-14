/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prr.model.condition;

/**
 * 
 * 预支明细查询接口实现
 *
 */
public class IG692SearchCondImpl implements IG692SearchCond {
	
	/**
	 * 查询时间开始
	 */
	protected String date_from;
	
	/**
	 * 查询时间结束
	 */
	protected String date_to;

	/**
	 * 查询工单cid
	 */
	protected String sfcid;
	
	/**
	 * 查询工单名称
	 */
	protected String sftypename;
	
	/**
	 * 查询时间开始设定
	 * @return 查询时间开始
	 */
	public String getDate_from() {
		return date_from;
	}

	/**
	 * 查询时间开始设定
	 * @param date_from 查询时间开始
	 */
	public void setDate_from(String date_from) {
		this.date_from = date_from;
	}

	/**
	 * 查询时间结束设定
	 * @return 查询时间结束
	 */
	public String getDate_to() {
		return date_to;
	}

	/**
	 * 查询时间结束设定
	 * @param date_to 查询时间结束
	 */
	public void setDate_to(String date_to) {
		this.date_to = date_to;
	}
	public String getSfcid() {
		return sfcid;
	}

	public void setSfcid(String sfcid) {
		this.sfcid = sfcid;
	}

	public String getSftypename() {
		return sftypename;
	}

	public void setSftypename(String sftypename) {
		this.sftypename = sftypename;
	}
	
}