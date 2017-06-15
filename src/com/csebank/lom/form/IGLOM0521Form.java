/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.form;
import com.csebank.lom.model.condition.EESearchCond;
import com.deliverik.framework.base.BaseForm;

/**
 * 模块：后勤管理-食堂管理
 * 说明：食堂招待部门汇总明细管理Form
 * 作者：唐晓娜
 */
public class IGLOM0521Form extends BaseForm implements EESearchCond {
	
	
	private static final long serialVersionUID = 1L;

	
	/** 主要申请部门 */
	protected String rapporgid_org;
	
	/** 开始月份 */
	protected String month_from_org;
	
	/** 结束月份 */
	protected String month_to_org;
	
	/** 年份 */
	protected String year_org;
	
	protected String rapporgname;
	

	/**
	 * 部门接待统计申请部门层次码取得
	 * @return 部门接待统计申请部门层次码
	 */
	public String getRapporgid_org() {
		return rapporgid_org;
	}

	/**
	 * 部门接待统计申请部门层次码设定
	 * @param rapporgid_org 部门接待统计申请部门层次码
	 */
	public void setRapporgid_org(String rapporgid_org) {
		this.rapporgid_org = rapporgid_org;
	}

	/**
	 * 部门接待统计年份取得
	 * @return 部门接待统计年份
	 */
	public String getYear_org() {
		return year_org;
	}

	/**
	 * 部门接待统计年份设定
	 * @param year_org 部门接待统计年份
	 */
	public void setYear_org(String year_org) {
		this.year_org = year_org;
	}

	/**
	 * 部门接待统计开始月份取得
	 * @return 部门接待统计开始月份
	 */
	public String getMonth_from_org() {
		return month_from_org;
	}

	/**
	 * 部门接待统计开始月份设定
	 * @param month_from_org 部门接待统计开始月份
	 */
	public void setMonth_from_org(String month_from_org) {
		this.month_from_org = month_from_org;
	}

	/**
	 * 部门接待统计结束月份取得
	 * @return 部门接待统计结束月份
	 */
	public String getMonth_to_org() {
		return month_to_org;
	}

	/**
	 * 部门接待统计结束月份设定
	 * @param month_to_org 部门接待统计结束月份
	 */
	public void setMonth_to_org(String month_to_org) {
		this.month_to_org = month_to_org;
	}

	public String getMonth() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getRapporgid_q() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getRid() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getRstatus_q() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getRtime_from() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getRtime_to() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getYear() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getRapporgname() {
		return rapporgname;
	}

	public void setRapporgname(String rapporgname) {
		this.rapporgname = rapporgname;
	}

	



	

}
