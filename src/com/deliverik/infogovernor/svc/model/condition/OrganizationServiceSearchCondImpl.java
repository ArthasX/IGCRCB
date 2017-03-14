/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.svc.model.condition;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 部门服务统计查询条件实现
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class OrganizationServiceSearchCondImpl implements OrganizationServiceSearchCond{

	/** 事件流程定义ID */
	protected String ipdid;
	
	/** 服务请求流程定义ID */
	protected String spdid;
	
	/** 年份 */
	protected String year;
	
	/** 月份 */
	protected String month;

	/**
	 * 事件流程定义ID取得
	 * @return ipdid 事件流程定义ID
	 */
	public String getIpdid() {
		return ipdid;
	}

	/**
	 * 事件流程定义ID设定
	 * @param ipdid 事件流程定义ID
	 */
	public void setIpdid(String ipdid) {
		this.ipdid = ipdid;
	}

	/**
	 * 服务请求流程定义ID取得
	 * @return spdid 服务请求流程定义ID
	 */
	public String getSpdid() {
		return spdid;
	}

	/**
	 * 服务请求流程定义ID设定
	 * @param spdid 服务请求流程定义ID
	 */
	public void setSpdid(String spdid) {
		this.spdid = spdid;
	}

	/**
	 * 年份取得
	 * @return year 年份
	 */
	public String getYear() {
		return year;
	}

	/**
	 * 年份设定
	 * @param year 年份
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * 月份取得
	 * @return month 月份
	 */
	public String getMonth() {
		return month;
	}

	/**
	 * 月份设定
	 * @param month 月份
	 */
	public void setMonth(String month) {
		this.month = month;
	}
}
