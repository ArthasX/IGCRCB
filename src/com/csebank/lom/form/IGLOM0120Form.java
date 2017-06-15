/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.form;

import com.csebank.lom.model.condition.DealOrgVWSearchCond;
import com.deliverik.framework.base.BaseForm;

/**
 * 模块：后勤管理-接待管理
 * 说明：外出就餐部门工作统计Form
 * 作者：唐晓娜
 */
public class IGLOM0120Form extends BaseForm implements DealOrgVWSearchCond {
	

	private static final long serialVersionUID = 1L;

	/** 查询年度 */
	protected String year;
	
	/** 查询开始月 */
	protected String month_from;
	
	/** 查询结束月 */
	protected String month_to;
	
	/** 部门层次码 */
	protected String rapporgid_org;
	
	/** 部门层次码 */
	protected String rapporgid;
	
	/** 部门名称 */
	protected String deptName;

	
	/**
	 * 查询年度取得
	 * @return 查询年度
	 */
	public String getYear() {
		return year;
	}

	/**
	 * 查询年度设定
	 * @param year 查询年度
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * 查询开始月取得
	 * @return 查询开始月
	 */
	public String getMonth_from() {
		return month_from;
	}

	/**
	 * 查询开始月设定
	 * @param month_from 查询开始月
	 */
	public void setMonth_from(String month_from) {
		this.month_from = month_from;
	}

	/**
	 * 查询结束月取得
	 * @return 查询结束月
	 */
	public String getMonth_to() {
		return month_to;
	}

	/**
	 * 查询结束月设定
	 * @param month_to 查询结束月
	 */
	public void setMonth_to(String month_to) {
		this.month_to = month_to;
	}

	/**
	 * 部门层次码取得
	 * @return 部门层次码
	 */
	public String getRapporgid() {
		return rapporgid;
	}

	/**
	 * 部门层次码设定
	 * @param rapporgid 部门层次码
	 */
	public void setRapporgid(String rapporgid) {
		this.rapporgid = rapporgid;
	}

	
	/**
	 * 部门层次码取得
	 * @return 部门层次码
	 */
	public String getRapporgid_org() {
		return rapporgid_org;
	}

	/**
	 * 部门层次码设定
	 * @param rapporgid 部门层次码
	 */
	public void setRapporgid_org(String rapporgid_org) {
		this.rapporgid_org = rapporgid_org;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

}
