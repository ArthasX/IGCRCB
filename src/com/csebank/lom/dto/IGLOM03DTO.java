/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.csebank.lom.form.IGLOM0301Form;
import com.csebank.lom.form.IGLOM0303Form;
import com.csebank.lom.form.IGLOM0304Form;
import com.csebank.lom.form.IGLOM0306Form;
import com.csebank.lom.form.IGLOM0307Form;
import com.csebank.lom.form.IGLOM0309Form;
import com.csebank.lom.form.IGLOM0313Form;
import com.csebank.lom.model.AdvanCescost;
import com.csebank.lom.model.AdvanceDetail;
import com.csebank.lom.model.AdvanceSummary;
import com.csebank.lom.model.LoanPayDetail;
import com.csebank.lom.model.PersonLoanDetail;
import com.csebank.lom.model.PersonLoanSummary;
import com.csebank.lom.model.condition.AdvanCescostSearchCond;
import com.csebank.lom.model.condition.AdvanceDetailSearchCond;
import com.csebank.lom.model.condition.AdvancesummaryCond;
import com.csebank.lom.model.condition.LoanPayDetailSearchCond;
import com.csebank.lom.model.condition.PersonLoanDetailSearchCond;
import com.csebank.lom.model.condition.PersonLoanSummarySearchCond;
import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;

/**
 * 
 * 预支费用管理DTO
 *
 */
@SuppressWarnings("serial")
public class IGLOM03DTO extends BaseDTO implements Serializable {
	

	/** 预支费用管理查询条件 */
	protected AdvanCescostSearchCond advanCescostSearchCond;
	
	/** 借款审批、确定查询条件 */
	protected LoanPayDetailSearchCond loanPayDetailSearchCond;

	/** 分页用DTO */
	protected PagingDTO pagingDto;

	/** 预支费用信息最大检索件数 */
	protected int maxSearchCount;
	
	/** 预支费用信息Form */
	protected IGLOM0301Form iglom0301Form;
	
	/** 借款信息Form */
	protected IGLOM0303Form iglom0303Form;
	
	/** 借款审批、确认Form */
	protected IGLOM0304Form iglom0304Form;
	
	/** 还款Form */
	protected IGLOM0306Form iglom0306Form;
	
	/** 冲抵计财部借款Form */
	protected IGLOM0307Form iglom0307Form;
	
	/** 还款登记Form */
	protected IGLOM0313Form iglom0313Form;
	
	/** 预支费用 */
	protected AdvanCescost advanCescost;
	
	/** 预支费用搜索结果集 */
	protected List<AdvanCescost> advanCescostList;
	
	/** 预支费用删除对象 */
	protected String[] deleteAcid;
	
	/** 借还款 */
	protected LoanPayDetail loanPayDetail;
	
	/** 借还款搜索结果集 */
	protected List<LoanPayDetail> loanPayDetailList;
	
	/** 借款信息 */
	protected LoanPayDetail loanPayDetailData;
	
	/** 借款删除对象 */
	protected String[] deleteLpdid;
	
	/** 还款总额 */
	protected BigDecimal[] db;
	
	/** 用户ID */
	protected String userid;
	
	/** 用户姓名 */
	protected String username;
	
	/** 预支人员统计查询接口 */
	protected PersonLoanSummarySearchCond personLoanSummarySearchCond;
	
	/** 预支人员统计查询结果列表 */
	protected List<PersonLoanSummary> personLoanSummaryList;
	
	/** 人员借款明细查询接口 */
	protected PersonLoanDetailSearchCond personLoanDetailSearchCond;
	
	/** 人员借款明细查询结果列表 */
	protected List<PersonLoanDetail> personLoanDetailList;
	
	/** 预支明细查询接口 */
	protected AdvanceDetailSearchCond advanceDetailSearchCond;
	
	/** 预支明细查询结果列表 */
	protected List<AdvanceDetail> advanceDetailList;
	
	/** 预支月度统计Form */
	protected IGLOM0309Form iglom0309Form;
	
	/** 预支月度统计查询条件 */
	protected AdvancesummaryCond advancesummaryCond;
	
	/** 预支月度统计结果集 */
	protected List<AdvanceSummary> advanceSummarylList;
	
	/** 可用金额 */
	protected BigDecimal availableAmount;
	
	
	public List<AdvanceSummary> getAdvanceSummarylList() {
		return advanceSummarylList;
	}

	public void setAdvanceSummarylList(List<AdvanceSummary> advanceSummarylList) {
		this.advanceSummarylList = advanceSummarylList;
	}

	public AdvancesummaryCond getAdvancesummaryCond() {
		return advancesummaryCond;
	}

	public void setAdvancesummaryCond(AdvancesummaryCond advancesummaryCond) {
		this.advancesummaryCond = advancesummaryCond;
	}

	public IGLOM0309Form getIglom0309Form() {
		return iglom0309Form;
	}

	public void setIglom0309Form(IGLOM0309Form iglom0309Form) {
		this.iglom0309Form = iglom0309Form;
	}

	
	/**
	 * 预支费用管理查询条件取得
	 * @return 预支费用管理查询条件
	 */
	public AdvanCescostSearchCond getAdvanCescostSearchCond() {
		return advanCescostSearchCond;
	}

	/**
	 * 预支费用管理查询条件设定
	 * @param advanCescostSearchCond 预支费用管理查询条件设定
	 */
	public void setAdvanCescostSearchCond(AdvanCescostSearchCond advanCescostSearchCond) {
		this.advanCescostSearchCond = advanCescostSearchCond;
	}

	/**
	 * 分页用DTO取得
	 * @return 分页用DTO
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * 分页用DTO设定
	 * @param pagingDto 分页用DTO
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	/**
	 * 预支费用信息最大检索件数取得
	 * @return 预支费用信息最大检索件数取得
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * 预支费用信息最大检索件数设定
	 * @param maxSearchCount 预支费用信息最大检索件数
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * 预支费用信息Form取得
	 * @return 预支费用信息Form
	 */
	public IGLOM0301Form getIglom0301Form() {
		return iglom0301Form;
	}

	/**
	 * 预支费用信息Form设定
	 * @param igLOM0301Form 预支费用信息Form
	 */
	public void setIglom0301Form(IGLOM0301Form iglom0301Form) {
		this.iglom0301Form = iglom0301Form;
	}

	/**
	 * 预支费用取得
	 * @return 预支费用
	 */
	public AdvanCescost getAdvanCescost() {
		return advanCescost;
	}

	/**
	 * 预支费用设定
	 * @param advanCescost 预支费用
	 */
	public void setAdvanCescost(AdvanCescost advanCescost) {
		this.advanCescost = advanCescost;
	}

	/**
	 * 预支费用搜索结果集取得
	 * @return 预支费用搜索结果集
	 */
	public List<AdvanCescost> getAdvanCescostList() {
		return advanCescostList;
	}

	/**
	 * 预支费用搜索结果集设定
	 * @param advanCescostList 预支费用搜索结果集
	 */
	public void setAdvanCescostList(List<AdvanCescost> advanCescostList) {
		this.advanCescostList = advanCescostList;
	}

	/**
	 * 预支费用删除对象取得
	 * @return 预支费用删除对象
	 */
	public String[] getDeleteAcid() {
		return deleteAcid;
	}

	/**
	 * 预支费用删除对象设定
	 * @param deleteAcid 预支费用删除对象
	 */
	public void setDeleteAcid(String[] deleteAcid) {
		this.deleteAcid = deleteAcid;
	}

	/**
	 * 借款信息Form取得
	 * @return 借款信息Form
	 */
	public IGLOM0303Form getIglom0303Form() {
		return iglom0303Form;
	}

	/**
	 * 借款信息Form设定
	 * @param iglom0303Form 借款信息Form
	 */
	public void setIglom0303Form(IGLOM0303Form iglom0303Form) {
		this.iglom0303Form = iglom0303Form;
	}

	/**
	 * 借款取得
	 * @return 借款
	 */
	public LoanPayDetail getLoanPayDetail() {
		return loanPayDetail;
	}

	/**
	 * 借款设定
	 * @param loanPayDetail 借款
	 */
	public void setLoanPayDetail(LoanPayDetail loanPayDetail) {
		this.loanPayDetail = loanPayDetail;
	}

	/**
	 * 借款审批、确认搜索结果集取得
	 * @return 借款审批、确认搜索结果集
	 */
	public List<LoanPayDetail> getLoanPayDetailList() {
		return loanPayDetailList;
	}

	/**
	 * 借款审批、确认搜索结果集设定
	 * @param loanPayDetailList 借款审批、确认搜索结果集
	 */
	public void setLoanPayDetailList(List<LoanPayDetail> loanPayDetailList) {
		this.loanPayDetailList = loanPayDetailList;
	}

	/**
	 * 借款审批、确定查询条件取得
	 * @return 借款审批、确定查询条件
	 */
	public LoanPayDetailSearchCond getLoanPayDetailSearchCond() {
		return loanPayDetailSearchCond;
	}

	/**
	 * 借款审批、确定查询条件设定
	 * @param loanPayDetailSearchCond 借款审批、确定查询条件
	 */
	public void setLoanPayDetailSearchCond(
			LoanPayDetailSearchCond loanPayDetailSearchCond) {
		this.loanPayDetailSearchCond = loanPayDetailSearchCond;
	}

	/**
	 * 借款审批、确认Form取得
	 * @return 借款审批、确认Form
	 */
	public IGLOM0304Form getIglom0304Form() {
		return iglom0304Form;
	}
	
	/**
	 * 借款审批、确认Form设定
	 * @param iglom0304Form 借款审批、确认Form
	 */
	public void setIglom0304Form(IGLOM0304Form iglom0304Form) {
		this.iglom0304Form = iglom0304Form;
	}
	
	/**
	 * 冲抵计财部借款Form取得
	 * @return 冲抵计财部借款Form
	 */
	public IGLOM0307Form getIglom0307Form() {
		return iglom0307Form;
	}

	/**
	 * 冲抵计财部借款Form设定
	 * @param iglom0307Form 冲抵计财部借款
	 */
	public void setIglom0307Form(IGLOM0307Form iglom0307Form) {
		this.iglom0307Form = iglom0307Form;
	}

	/**
	 * 借款删除对象取得
	 * @return 借款删除对象
	 */
	public String[] getDeleteLpdid() {
		return deleteLpdid;
	}

	/**
	 * 借款删除对象设定
	 * @param deleteLpdid 借款删除对象
	 */
	public void setDeleteLpdid(String[] deleteLpdid) {
		this.deleteLpdid = deleteLpdid;
	}

	/**
	 * 用户ID取得
	 * @return 用户ID
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * 用户ID设定
	 * @param userid 用户ID
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * 用户姓名取得
	 * @return 用户姓名
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * 用户姓名设定
	 * @param username 用户姓名
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * 还款form取得
	 * @return 还款form
	 */
	public IGLOM0306Form getIglom0306Form() {
		return iglom0306Form;
	}

	/**
	 * 还款form设定
	 * @param iglom0305Form 还款form
	 */
	public void setIglom0306Form(IGLOM0306Form iglom0306Form) {
		this.iglom0306Form = iglom0306Form;
	}

	/**
	 * 还款登记Form取得
	 * @return 还款登记Form
	 */
	public IGLOM0313Form getIglom0313Form() {
		return iglom0313Form;
	}

	/**
	 * 还款登记Form设定
	 * @param iglom0313Form 还款登记Form
	 */
	public void setIglom0313Form(IGLOM0313Form iglom0313Form) {
		this.iglom0313Form = iglom0313Form;
	}

	/**
	 * 预支人员统计查询接口取得
	 * @return 预支人员统计查询接口
	 */
	public PersonLoanSummarySearchCond getPersonLoanSummarySearchCond() {
		return personLoanSummarySearchCond;
	}

	/**
	 * 预支人员统计查询接口设定
	 * @param personLoanSummarySearchCond 预支人员统计查询接口
	 */
	public void setPersonLoanSummarySearchCond(
			PersonLoanSummarySearchCond personLoanSummarySearchCond) {
		this.personLoanSummarySearchCond = personLoanSummarySearchCond;
	}

	/**
	 * 预支人员统计查询结果列表取得
	 * @return 预支人员统计查询结果列表
	 */
	public List<PersonLoanSummary> getPersonLoanSummaryList() {
		return personLoanSummaryList;
	}

	/**
	 * 预支人员统计查询结果列表设定
	 * @param personLoanSummarySearchCond 预支人员统计查询结果列表
	 */
	public void setPersonLoanSummaryList(
			List<PersonLoanSummary> personLoanSummaryList) {
		this.personLoanSummaryList = personLoanSummaryList;
	}

	/**
	 * 人员借款明细查询接口取得
	 * @return 人员借款明细查询接口
	 */
	public PersonLoanDetailSearchCond getPersonLoanDetailSearchCond() {
		return personLoanDetailSearchCond;
	}

	/**
	 * 人员借款明细查询接口设定
	 * @param personLoanDetailSearchCond 人员借款明细查询接口
	 */
	public void setPersonLoanDetailSearchCond(
			PersonLoanDetailSearchCond personLoanDetailSearchCond) {
		this.personLoanDetailSearchCond = personLoanDetailSearchCond;
	}

	/**
	 * 人员借款明细查询结果列表取得
	 * @return 人员借款明细查询结果列表
	 */
	public List<PersonLoanDetail> getPersonLoanDetailList() {
		return personLoanDetailList;
	}

	/**
	 * 人员借款明细查询结果列表设定
	 * @param personLoanDetailList 人员借款明细查询结果列表
	 */
	public void setPersonLoanDetailList(List<PersonLoanDetail> personLoanDetailList) {
		this.personLoanDetailList = personLoanDetailList;
	}

	/**
	 * 预支明细查询接口取得
	 * @return 预支明细查询接口
	 */
	public AdvanceDetailSearchCond getAdvanceDetailSearchCond() {
		return advanceDetailSearchCond;
	}

	/**
	 * 预支明细查询接口设定
	 * @param advanceDetailSearchCond 预支明细查询接口
	 */
	public void setAdvanceDetailSearchCond(
			AdvanceDetailSearchCond advanceDetailSearchCond) {
		this.advanceDetailSearchCond = advanceDetailSearchCond;
	}

	/**
	 * 预支明细查询结果列表取得
	 * @return 预支明细查询结果列表
	 */
	public List<AdvanceDetail> getAdvanceDetailList() {
		return advanceDetailList;
	}

	/**
	 * 预支明细查询结果列表设定
	 * @param advanceDetailList 预支明细查询结果列表
	 */
	public void setAdvanceDetailList(List<AdvanceDetail> advanceDetailList) {
		this.advanceDetailList = advanceDetailList;
	}

	/**
	 * 借款信息取得
	 * @return 借款信息
	 */
	public LoanPayDetail getLoanPayDetailData() {
		return loanPayDetailData;
	}

	/**
	 * 借款信息设定
	 * @param loanPayDetailData 借款信息
	 */
	public void setLoanPayDetailData(LoanPayDetail loanPayDetailData) {
		this.loanPayDetailData = loanPayDetailData;
	}

	/**
	 * 还款总额取得
	 * @return 还款总额
	 */
	public BigDecimal[] getDb() {
		return db;
	}

	/**
	 * 还款总额设定
	 * @param db 还款总额
	 */
	public void setDb(BigDecimal[] db) {
		this.db = db;
	}

	/**
	 * 可用金额取得
	 * @return 可用金额
	 */
	public BigDecimal getAvailableAmount() {
		return availableAmount;
	}

	/**
	 * 可用金额设定
	 * @param availableAmount 可用金额
	 */
	public void setAvailableAmount(BigDecimal availableAmount) {
		this.availableAmount = availableAmount;
	}
	
}
