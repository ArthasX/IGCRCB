package com.deliverik.infogovernor.smr.dto;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.smr.form.IGSMR1101Form;
import com.deliverik.infogovernor.smr.form.IGSMR1102Form;
import com.deliverik.infogovernor.smr.form.IGSMR1103Form;
import com.deliverik.infogovernor.smr.model.ApproveSuggestionInfo;
import com.deliverik.infogovernor.smr.model.RegulatoryReportInstanceInfo;
import com.deliverik.infogovernor.smr.model.entity.AnnualReportVW;
import com.deliverik.infogovernor.smr.model.entity.BatchExamineVW;
/**
 * 月报填报业务DTO
 * 
 */
@SuppressWarnings("serial")
public class IGSMR11DTO extends BaseDTO{
	/** 用户信息 */
	protected User user;
	
	/** 季报发起Form */
	protected IGSMR1101Form igSMR1101Form;
	
	/** 季报催办Form */
	protected IGSMR1102Form igSMR1102Form;
		
	/** 季报催办Form */
	protected IGSMR1103Form igSMR1103Form;
	/** 审批意见信息 */
	protected ApproveSuggestionInfo approveSuggestionInfo;
	
	/** 审批意见信息集合 */
	protected List<ApproveSuggestionInfo> lstApproveSuggestionInfo;
	
	/** 季报查询结果*/
	protected Map<String,List<AnnualReportVW>> map_arq;
	
	/** 季报一级审批查询结果*/
	protected Map<String,List<AnnualReportVW>> map_first;
	
	/** 季报二级审批查询结果*/
	protected List<RegulatoryReportInstanceInfo> second_list;
	
	/** 填报查看查询结果*/
	protected Map<String,List<AnnualReportVW>> map_see;
	
	/** 季报列表 */
	protected List<BatchExamineVW> lst_Report;
	
	/** 实例ID */
	private	Integer instanceID;
	
	/**
	 * 审批意见信息集合取得
	 *
	 * @return lstApproveSuggestionInfo 审批意见信息集合
	 */
	public List<ApproveSuggestionInfo> getLstApproveSuggestionInfo() {
		return lstApproveSuggestionInfo;
	}

	/**
	 * 审批意见信息集合设定
	 *
	 * @param lstApproveSuggestionInfo 审批意见信息集合
	 */
	public void setLstApproveSuggestionInfo(
			List<ApproveSuggestionInfo> lstApproveSuggestionInfo) {
		this.lstApproveSuggestionInfo = lstApproveSuggestionInfo;
	}

	/**
	 * 审批意见信息取得
	 *
	 * @return approveSuggestionInfo 审批意见信息
	 */
	public ApproveSuggestionInfo getApproveSuggestionInfo() {
		return approveSuggestionInfo;
	}

	/**
	 * 审批意见信息设定
	 *
	 * @param approveSuggestionInfo 审批意见信息
	 */
	public void setApproveSuggestionInfo(ApproveSuggestionInfo approveSuggestionInfo) {
		this.approveSuggestionInfo = approveSuggestionInfo;
	}

	/**
	 * 用户信息取得
	 * 
	 * @return 用户信息
	 */
	public User getUser() {
		return user;
	}

	/**
	 * 用户信息设定
	 * 
	 * @param user 用户信息
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * 季报发起Form取得
	 * 
	 * @return 年报发起Form
	 */
	public IGSMR1101Form getIgSMR1101Form() {
		return igSMR1101Form;
	}

	/**
	 * 季报发起Form设定
	 * 
	 * @param igSMR0101Form 年报发起Form
	 */
	public void setIgSMR1101Form(IGSMR1101Form igSMR1101Form) {
		this.igSMR1101Form = igSMR1101Form;
	}
	
	/**
	 * 季报查询结果取得
	 * 
	 * @return 季报查询结果
	 */
	public Map<String, List<AnnualReportVW>> getMap_arq() {
		return map_arq;
	}

	
	/**
	 * 季报查询结果设定
	 * 
	 * @param arqMap 季报查询结果
	 */
	public void setMap_arq(Map<String, List<AnnualReportVW>> map_arq) {
		this.map_arq = map_arq;
	}
	
	/**
	 * 季报一级审批查询结果取得
	 * 
	 * @return 季报一级审批查询结果
	 */
	public Map<String, List<AnnualReportVW>> getMap_first() {
		return map_first;
	}

	/**
	 * 季报一级审批查询结果设定
	 * 
	 * @param map_first 季报一级审批查询结果
	 */
	public void setMap_first(Map<String, List<AnnualReportVW>> map_first) {
		this.map_first = map_first;
	}
	/**
	 * 季报二级审批查询结果取得
	 * 
	 * @return 季年报二级审批查询结果
	 */
	public List<RegulatoryReportInstanceInfo> getSecond_list() {
		return second_list;
	}

	/**
	 * 季年报二级审批查询结果设定
	 * 
	 * @param second_list 季报二级审批查询结果
	 */
	public void setSecond_list(List<RegulatoryReportInstanceInfo> second_list) {
		this.second_list = second_list;
	}
	/**
	 * 填报查看查询结果取得
	 * 
	 * @return 填报查看查询结果
	 */
	public Map<String, List<AnnualReportVW>> getMap_see() {
		return map_see;
	}

	/**
	 * 填报查看查询结果设定
	 * 
	 * @param list_rri 填报查看查询结果
	 */
	public void setMap_see(Map<String, List<AnnualReportVW>> map_see) {
		this.map_see = map_see;
	}
	/**
	 * 季报催办Form取得
	 * 
	 * @return 季报催办Form
	 */
	public IGSMR1102Form getIgSMR1102Form() {
		return igSMR1102Form;
	}
	/**
	 * 季报催办Form设定
	 * 
	 * @param igSMR1102Form 季报催办Form
	 */
	public void setIgSMR1102Form(IGSMR1102Form igSMR1102Form) {
		this.igSMR1102Form = igSMR1102Form;
	}
	/**
	 * 季报列表取得
	 * 
	 * @return 季报列表
	 */
	public List<BatchExamineVW> getLst_Report() {
		return lst_Report;
	}

	/**
	 * 季报列表设定
	 * 
	 * @param lst_Report 季报列表
	 */
	public void setLst_Report(List<BatchExamineVW> lst_Report) {
		this.lst_Report = lst_Report;
	}
	/**
	 * 实例ID取得
	 * 
	 * @return 实例ID
	 */
	public Integer getInstanceID() {
		return instanceID;
	}

	/**
	 * 实例ID设定
	 * 
	 * @param instanceID 实例ID
	 */
	public void setInstanceID(Integer instanceID) {
		this.instanceID = instanceID;
	}
	/**
	 * 季报催办Form取得
	 * 
	 * @return 季报催办Form
	 */
	public IGSMR1103Form getIgSMR1103Form() {
		return igSMR1103Form;
	}
	/**
	 * 季报催办Form设定
	 * 
	 * @param igSMR1103Form 季报催办Form
	 */
	public void setIgSMR1103Form(IGSMR1103Form igSMR1103Form) {
		this.igSMR1103Form = igSMR1103Form;
	}
}
