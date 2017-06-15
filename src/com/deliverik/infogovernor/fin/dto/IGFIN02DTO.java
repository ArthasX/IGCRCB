/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */
package com.deliverik.infogovernor.fin.dto;

import java.io.Serializable;
import java.util.List;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.model.condition.AttachmentSearchCond;
import com.deliverik.infogovernor.fin.form.IGFIN0102Form;
import com.deliverik.infogovernor.fin.form.IGFIN0201Form;
import com.deliverik.infogovernor.fin.form.IGFIN0206Form;
import com.deliverik.infogovernor.fin.model.Budget;
import com.deliverik.infogovernor.fin.model.Expense;
import com.deliverik.infogovernor.fin.model.condition.BudgetSearchCond;
import com.deliverik.infogovernor.fin.model.condition.ExpenseSearchCond;
import com.deliverik.infogovernor.fin.vo.IGFIN0303VO;


/**
 *预算用DTO
 * 
 */
public class IGFIN02DTO extends BaseDTO implements Serializable{
	
	private static final long serialVersionUID = -1476835278016099214L;

	protected int maxSearchCount;
	
	protected String btype;
	
	protected IGFIN0303VO[] vos;
	
	public String getBtype() {
		return btype;
	}

	public void setBtype(String btype) {
		this.btype = btype;
	}

	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	protected PagingDTO pagingDto;

	protected Integer exid;

	protected Integer bid;

	protected String exdesc;

	protected Float examount;

	protected String exinfo;

	protected String exstatus;

	protected String exreqid;

	protected String exreqname;

	protected String exinittime;

	protected String exopentime;

	protected String exapvid;

	protected String exapvname;

	protected String exclosetime;

	protected String exattkey;

	protected String exeiinfo;

	protected String exprinfo;

	protected String expinfo;

	protected String exorginfo;
	
	protected Integer attid;

	protected String attkey;

	protected String attname;

	protected String attdesc;

	protected String atturl;
	
	protected String btitle;
	
	protected Expense expense;
	
	protected Budget budget;
	
	protected BudgetSearchCond budgetSearchCond;
	
	protected List budgetList;
	
	protected ExpenseSearchCond expenseSearchCond;
	
	protected IGFIN0201Form attachFile;
	
	protected IGFIN0102Form igfin0102Form;
	
	protected List expenseList;
	
	protected IGFIN0206Form igfin0206Form;
	
	protected AttachmentSearchCond attachmentSearchCond;
	
	protected List attachmentList;
	
	protected Integer deleteExpense;

	protected List<LabelValueBean> byearList;//预算年份集合
	
	
	
	public IGFIN0102Form getIgfin0102Form() {
		return igfin0102Form;
	}

	public void setIgfin0102Form(IGFIN0102Form igfin0102Form) {
		this.igfin0102Form = igfin0102Form;
	}

	public List<LabelValueBean> getByearList() {
		return byearList;
	}

	public void setByearList(List<LabelValueBean> byearList) {
		this.byearList = byearList;
	}
	public Integer getExid() {
		return exid;
	}

	public void setExid(Integer exid) {
		this.exid = exid;
	}

	public Integer getBid() {
		return bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public String getExdesc() {
		return exdesc;
	}

	public void setExdesc(String exdesc) {
		this.exdesc = exdesc;
	}

	public Float getExamount() {
		return examount;
	}

	public void setExamount(Float examount) {
		this.examount = examount;
	}

	public String getExinfo() {
		return exinfo;
	}

	public void setExinfo(String exinfo) {
		this.exinfo = exinfo;
	}

	public String getExstatus() {
		return exstatus;
	}

	public void setExstatus(String exstatus) {
		this.exstatus = exstatus;
	}

	public String getExreqid() {
		return exreqid;
	}

	public void setExreqid(String exreqid) {
		this.exreqid = exreqid;
	}

	public String getExreqname() {
		return exreqname;
	}

	public void setExreqname(String exreqname) {
		this.exreqname = exreqname;
	}

	public String getExinittime() {
		return exinittime;
	}

	public void setExinittime(String exinittime) {
		this.exinittime = exinittime;
	}

	public String getExopentime() {
		return exopentime;
	}

	public void setExopentime(String exopentime) {
		this.exopentime = exopentime;
	}

	public String getExapvid() {
		return exapvid;
	}

	public void setExapvid(String exapvid) {
		this.exapvid = exapvid;
	}

	public String getExapvname() {
		return exapvname;
	}

	public void setExapvname(String exapvname) {
		this.exapvname = exapvname;
	}

	public String getExclosetime() {
		return exclosetime;
	}

	public void setExclosetime(String exclosetime) {
		this.exclosetime = exclosetime;
	}

	public String getExattkey() {
		return exattkey;
	}

	public void setExattkey(String exattkey) {
		this.exattkey = exattkey;
	}

	public String getExeiinfo() {
		return exeiinfo;
	}

	public void setExeiinfo(String exeiinfo) {
		this.exeiinfo = exeiinfo;
	}

	public String getExprinfo() {
		return exprinfo;
	}

	public void setExprinfo(String exprinfo) {
		this.exprinfo = exprinfo;
	}

	public String getExpinfo() {
		return expinfo;
	}

	public void setExpinfo(String expinfo) {
		this.expinfo = expinfo;
	}

	public String getExorginfo() {
		return exorginfo;
	}

	public void setExorginfo(String exorginfo) {
		this.exorginfo = exorginfo;
	}

	public Integer getAttid() {
		return attid;
	}

	public void setAttid(Integer attid) {
		this.attid = attid;
	}

	public String getAttkey() {
		return attkey;
	}

	public void setAttkey(String attkey) {
		this.attkey = attkey;
	}

	public String getAttname() {
		return attname;
	}

	public void setAttname(String attname) {
		this.attname = attname;
	}

	public String getAttdesc() {
		return attdesc;
	}

	public void setAttdesc(String attdesc) {
		this.attdesc = attdesc;
	}

	public String getAtturl() {
		return atturl;
	}

	public void setAtturl(String atturl) {
		this.atturl = atturl;
	}

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public Expense getExpense() {
		return expense;
	}

	public void setExpense(Expense expense) {
		this.expense = expense;
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

	public IGFIN0201Form getAttachFile() {
		return attachFile;
	}

	public void setAttachFile(IGFIN0201Form attachFile) {
		this.attachFile = attachFile;
	}

	public ExpenseSearchCond getExpenseSearchCond() {
		return expenseSearchCond;
	}

	public void setExpenseSearchCond(ExpenseSearchCond expenseSearchCond) {
		this.expenseSearchCond = expenseSearchCond;
	}

	public List getExpenseList() {
		return expenseList;
	}

	public void setExpenseList(List expenseList) {
		this.expenseList = expenseList;
	}

	public IGFIN0206Form getIgfin0206Form() {
		return igfin0206Form;
	}

	public void setIgfin0206Form(IGFIN0206Form igfin0206Form) {
		this.igfin0206Form = igfin0206Form;
	}

	public AttachmentSearchCond getAttachmentSearchCond() {
		return attachmentSearchCond;
	}

	public void setAttachmentSearchCond(AttachmentSearchCond attachmentSearchCond) {
		this.attachmentSearchCond = attachmentSearchCond;
	}

	public List getAttachmentList() {
		return attachmentList;
	}

	public void setAttachmentList(List attachmentList) {
		this.attachmentList = attachmentList;
	}

	public Integer getDeleteExpense() {
		return deleteExpense;
	}

	public void setDeleteExpense(Integer deleteExpense) {
		this.deleteExpense = deleteExpense;
	}

	public IGFIN0303VO[] getVos() {
		return vos;
	}

	public void setVos(IGFIN0303VO[] vos) {
		this.vos = vos;
	}

}


