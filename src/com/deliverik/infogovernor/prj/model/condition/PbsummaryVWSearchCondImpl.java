/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.prj.model.condition;


/**
 * <p>概述:预算及工程分类信息视图查询条件实现</p>
 * <p>功能描述：</p>
 * <p>创建记录：</p>
 */

public class PbsummaryVWSearchCondImpl implements PbsummaryVWSearchCond{	
	/** 项目ID*/
	protected Integer pid;
	
	/** 预算项目关系表ID*/
	protected Integer pbid;
	
	/** 预算表ID*/
	protected Integer bid;
	
	/** 开始预算年份*/
	protected String byear_begin;
	
	/** 结束预算年份*/
	protected String byear_end;
	
	/**
	 * 获取项目ID
	 * @return 项目ID
	 */
	public Integer getPid() {
		return pid;
	}

	/**
	 * 设置项目ID
	 * @param pid  项目ID
	 */
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	
	/**
	 * 获取预算项目关系表ID
	 * @return 预算项目关系表ID
	 */
	public Integer getPbid() {
		return pbid;
	}

	/**
	 * 设置预算项目关系表ID
	 * @param pbid  预算项目关系表ID
	 */
	public void setPbid(Integer pbid) {
		this.pbid = pbid;
	}
	
	/**
	 * 获取预算表ID
	 * @return 预算表ID
	 */
	public Integer getBid() {
		return bid;
	}

	/**
	 * 设置预算表ID
	 * @param bid  预算表ID
	 */
	public void setBid(Integer bid) {
		this.bid = bid;
	}
	
	/**
	 * 获取开始预算年份
	 * @return 开始预算年份
	 */
	public String getByear_begin() {
		return byear_begin;
	}

	/**
	 * 设置开始预算年份
	 * @param setByear_begin 开始预算年份
	 */
	public void setByear_begin(String byear_begin) {
		this.byear_begin = byear_begin;
	}

	/**
	 * 获取结束预算年份
	 * @return 结束预算年份
	 */
	public String getByear_end() {
		return byear_end;
	}

	/**
	 * 设置结束预算年份
	 * @param setByear_end 结束预算年份
	 */
	public void setByear_end(String byear_end) {
		this.byear_end = byear_end;
	}
}
