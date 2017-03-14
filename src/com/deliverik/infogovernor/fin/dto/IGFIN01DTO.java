/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */
package com.deliverik.infogovernor.fin.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.fin.form.IGFIN0101Form;
import com.deliverik.infogovernor.fin.form.IGFIN0102Form;
import com.deliverik.infogovernor.fin.model.Budget;
import com.deliverik.infogovernor.fin.model.Expense;
import com.deliverik.infogovernor.fin.model.condition.BudgetSearchCond;
import com.deliverik.infogovernor.prj.model.Pbsummary;

/**
 *预算用DTO
 * 
 */
public class IGFIN01DTO extends BaseDTO implements Serializable {

	private static final long serialVersionUID = 5387096557928865851L;

	protected int maxSearchCount;

	protected String pcode;

	private Map<Integer, List> budgetIdExpenseListMap;
	private Map<Integer, String> budgetIdNameMap;

	/** 用于项目登记页面预算集合的显示*/
	private List<IGFIN0102Form> budgetLeaveAmountList;
	
	/** 项目主键*/
	private String pid;
	
	/** 预算显示列表此列表可以直接判断预算下是否有项目*/
	private List<IGFIN0102Form> budgetFormList;
	
	/** 预算视图结果集 */
	private List<Pbsummary> pbsummaryList;
	
	public String getPcode() {
		return pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	protected List<LabelValueBean> byearList;//预算年份集合
	
	public List<LabelValueBean> getByearList() {
		return byearList;
	}

	public void setByearList(List<LabelValueBean> byearList) {
		this.byearList = byearList;
	}

	protected List<Expense> expenseList;

	public List<Expense> getExpenseList() {
		return expenseList;
	}

	public void setExpenseList(List<Expense> expenseList) {
		this.expenseList = expenseList;
	}

	protected PagingDTO pagingDto;

	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	protected Integer bid;

	protected String btype;

	protected String binittime;

	protected String bopentime;

	protected String bstatus;

	protected String breqid;

	protected String bapvid;

	protected String btitle;

	protected String bclosetime;

	protected String bdesc;

	protected String binfo;

	protected String byear;

	protected String borgid;

	protected String borgname;

	protected String breqname;

	protected String bapvname;

	protected Double bamount;

	protected String battkey;

	protected Budget budget;

	protected BudgetSearchCond budgetSearchCond;

	protected List budgetList;

	protected IGFIN0101Form igfin0101Form;
	
	protected IGFIN0102Form igfin0102Form;

	
	
	public IGFIN0102Form getIgfin0102Form() {
		return igfin0102Form;
	}

	public void setIgfin0102Form(IGFIN0102Form igfin0102Form) {
		this.igfin0102Form = igfin0102Form;
	}

	protected Integer deleteBudget;

	public Integer getBid() {
		return bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public String getBtype() {
		return btype;
	}

	public void setBtype(String btype) {
		this.btype = btype;
	}

	public String getBinittime() {
		return binittime;
	}

	public void setBinittime(String binittime) {
		this.binittime = binittime;
	}

	public String getBopentime() {
		return bopentime;
	}

	public void setBopentime(String bopentime) {
		this.bopentime = bopentime;
	}

	public String getBstatus() {
		return bstatus;
	}

	public void setBstatus(String bstatus) {
		this.bstatus = bstatus;
	}

	public String getBreqid() {
		return breqid;
	}

	public void setBreqid(String breqid) {
		this.breqid = breqid;
	}

	public String getBapvid() {
		return bapvid;
	}

	public void setBapvid(String bapvid) {
		this.bapvid = bapvid;
	}

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public String getBclosetime() {
		return bclosetime;
	}

	public void setBclosetime(String bclosetime) {
		this.bclosetime = bclosetime;
	}

	public String getBdesc() {
		return bdesc;
	}

	public void setBdesc(String bdesc) {
		this.bdesc = bdesc;
	}

	public String getBinfo() {
		return binfo;
	}

	public void setBinfo(String binfo) {
		this.binfo = binfo;
	}

	public String getByear() {
		return byear;
	}

	public void setByear(String byear) {
		this.byear = byear;
	}

	public String getBorgid() {
		return borgid;
	}

	public void setBorgid(String borgid) {
		this.borgid = borgid;
	}

	public String getBorgname() {
		return borgname;
	}

	public void setBorgname(String borgname) {
		this.borgname = borgname;
	}

	public String getBreqname() {
		return breqname;
	}

	public void setBreqname(String breqname) {
		this.breqname = breqname;
	}

	public String getBapvname() {
		return bapvname;
	}

	public void setBapvname(String bapvname) {
		this.bapvname = bapvname;
	}

	public Double getBamount() {
		return bamount;
	}

	public void setBamount(Double bamount) {
		this.bamount = bamount;
	}

	public String getBattkey() {
		return battkey;
	}

	public void setBattkey(String battkey) {
		this.battkey = battkey;
	}

	public Budget getBudget() {
		return budget;
	}

	public void setBudget(Budget budget) {
		this.budget = budget;
	}

	public BudgetSearchCond getBudgetSearchCond() {
		return budgetSearchCond;
	}

	public void setBudgetSearchCond(BudgetSearchCond budgetSearchCond) {
		this.budgetSearchCond = budgetSearchCond;
	}

	public List getBudgetList() {
		return budgetList;
	}

	public void setBudgetList(List budgetList) {
		this.budgetList = budgetList;
	}

	public IGFIN0101Form getIgfin0101Form() {
		return igfin0101Form;
	}

	public void setIgfin0101Form(IGFIN0101Form igfin0101Form) {
		this.igfin0101Form = igfin0101Form;
	}

	public void setDeleteBudget(Integer deleteBudget) {
		this.deleteBudget = deleteBudget;
	}

	public Integer getDeleteBudget() {
		return deleteBudget;
	}

	public Map<Integer, List> getBudgetIdExpenseListMap() {
		return budgetIdExpenseListMap;
	}

	public void setBudgetIdExpenseListMap(
			Map<Integer, List> budgetIdExpenseListMap) {
		this.budgetIdExpenseListMap = budgetIdExpenseListMap;
	}

	public Map<Integer, String> getBudgetIdNameMap() {
		return budgetIdNameMap;
	}

	public void setBudgetIdNameMap(Map<Integer, String> budgetIdNameMap) {
		this.budgetIdNameMap = budgetIdNameMap;
	}
	public List<IGFIN0102Form> getBudgetLeaveAmountList() {
		return budgetLeaveAmountList;
	}

	public void setBudgetLeaveAmountList(List<IGFIN0102Form> budgetLeaveAmountList) {
		this.budgetLeaveAmountList = budgetLeaveAmountList;
	}

	/**
	 * 获取budgetFormList
	 * @return fbudgetFormList budgetFormList
	 */
	public List<IGFIN0102Form> getBudgetFormList() {
		return budgetFormList;
	}

	/**
	 * 设置budgetFormList
	 * @param budgetFormList  budgetFormList
	 */
	public void setBudgetFormList(List<IGFIN0102Form> budgetFormList) {
		this.budgetFormList = budgetFormList;
	}

	/**
	 * 获取项目主键
	 * @return fpid 项目主键
	 */
	public String getPid() {
		return pid;
	}

	/**
	 * 设置项目主键
	 * @param pid  项目主键
	 */
	public void setPid(String pid) {
		this.pid = pid;
	}

	/**
	 * 预算视图结果集取得
	 * @return pbsummaryList 预算视图结果集
	 */
	public List<Pbsummary> getPbsummaryList() {
		return pbsummaryList;
	}

	/**
	 * 预算视图结果集设定
	 * @param pbsummaryList 预算视图结果集
	 */
	public void setPbsummaryList(List<Pbsummary> pbsummaryList) {
		this.pbsummaryList = pbsummaryList;
	}
	
	
}
