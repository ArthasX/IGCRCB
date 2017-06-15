/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.form;

import com.csebank.lom.model.condition.DealSearchCond;
import com.deliverik.framework.base.BaseForm;

/**
 * 模块：后勤管理-接待管理
 * 外出就餐工作统计明细管理Form
 * 作者：唐晓娜
 *
 */
public class IGLOM0118Form extends BaseForm implements DealSearchCond {
	
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 接待工作ID
	 */
	protected Integer rid;
	protected String dealTime;
	
	/** 删除接待工作对象 */
	protected String[] deleteRid;
	
	/** 主要申请部门层次码 */
	protected String rapporgid;
	
	/** 主要申请部门名称 */
	protected String deptName;
	
	/** 状态（1进行中，2结束） */
	protected String rstatus;
	
	
	
	/** 查询日期段开始 */
	protected String rtime_from;
	
	/** 查询日期段结束 */
	protected String rtime_to;
	
	/** 月份 */
	protected String month;
	
	/** 年份 */
	protected String year;
	

	/**
	 * 接待工作ID
	 * @return 接待工作ID
	 */
	public Integer getRid() {
		return rid;
	}

	/**
	 * 接待工作ID
	 * @param rid 接待工作ID
	 */
	public void setRid(Integer rid) {
		this.rid = rid;
	}

	/**
	 * 删除接待工作对象
	 * @return 删除接待工作对象
	 */
	public String[] getDeleteRid() {
		return deleteRid;
	}

	/**
	 * 删除接待工作对象
	 * @param deleteRid 删除接待工作对象
	 */
	public void setDeleteRid(String[] deleteRid) {
		this.deleteRid = deleteRid;
	}



	




	/**
	 * 查询日期段开始取得
	 * @return 查询日期段开始
	 */
	public String getRtime_from() {
		return rtime_from;
	}

	/**
	 * 查询日期段开始设定
	 * @param rtime_from 查询日期段开始
	 */
	public void setRtime_from(String rtime_from) {
		this.rtime_from = rtime_from;
	}

	/**
	 * 查询日期段结束取得
	 * @return 查询日期结束
	 */
	public String getRtime_to() {
		return rtime_to;
	}

	/**
	 * 查询日期段结束设定
	 * @param rtime_to 查询日期段开始
	 */
	public void setRtime_to(String rtime_to) {
		this.rtime_to = rtime_to;
	}

	/**
	 * 状态取得
	 * @return 状态
	 */
	public String getRstatus() {
		return rstatus;
	}

	/**
	 * 状态设定
	 * @param rstatus 状态
	 */
	public void setRstatus(String rstatus) {
		this.rstatus = rstatus;
	}

	/**
	 * 月份取得
	 * @return 月份
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

	/**
	 * 年份取得
	 * @return 年份
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

	public String getMonth_from_org() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getMonth_to_org() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getRapporgid_org() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getYear_org() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getRapporgid() {
		return rapporgid;
	}

	public void setRapporgid(String rapporgid) {
		this.rapporgid = rapporgid;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDealTime() {
		return dealTime;
	}

	public void setDealTime(String dealTime) {
		this.dealTime = dealTime;
	}

}
