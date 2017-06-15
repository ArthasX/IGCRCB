/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dbm.dto;

import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.infogovernor.asset.model.CheckItemVWInfo;
import com.deliverik.infogovernor.asset.model.RiskPointVMInfo;
import com.deliverik.infogovernor.asset.model.RiskcaseVWInfo;
import com.deliverik.infogovernor.risk.model.RiskCheckResult;

@SuppressWarnings("serial")
public class IGDBM12DTO extends BaseDTO{
	
	/*服务工单值*/
	protected String swoValue;
	
	/*故障申报值*/
	protected String ftdValue;
	
	/*服务请求*/
	protected String serValue;
	
	/*事件*/
	protected String teValue;
	
	/*问题*/
	protected String tpValue;
	
	/*变更*/
	protected String chaValue;
	
	/*请求*/
	protected String reqValue;
	
	/*指派*/
	protected String assValue;

	/*返回一切需要xml流的字符串*/
	protected String resultXML;
	
	/*点击工单数，获得工单数所对应的PRPDID*/
	private String workValue;
	
	/** ajax结果 */
	protected String ajaxResult;
	
	/*科技运行一服务工单、故障申报、业务服务请求*/
	protected String processCountYW;
	
	/*科技运行一事件、问题、变更、科技服务请求、指派*/
	protected String processCountKJ;
	
	/*科技风险 -风险点、检查项、风险计划、评估任务、风险清单、问题整改*/
	protected String riskCounter;
	/**检查项集合*/
	protected  List<CheckItemVWInfo> checkItemList;
	/**风险点集合*/
	protected List<RiskPointVMInfo> riskPointList;
	/**风险事件集合*/
	protected List<RiskcaseVWInfo> riskcaseList;

	public String getRiskCounter() {
		return riskCounter;
	}

	public void setRiskCounter(String riskCounter) {
		this.riskCounter = riskCounter;
	}
	/** 资产信息集合 */
	protected List<SOC0118Info> assetList;
	
	public List<SOC0118Info> getAssetList() {
		return assetList;
	}

	public void setAssetList(List<SOC0118Info> assetList) {
		this.assetList = assetList;
	}
	/*科技*/
	protected String sciValue;
	/*业务*/
	protected String busiValue;
	
	/**允许查询的最大记录数*/
	protected int maxSearchCount;

	/**分页Bean*/
	protected PagingDTO pagingDto;
	
	/** 流程信息集合 */
	protected List<IG500Info> prList;
	
	/** 检查工作集合 */
	protected List<RiskCheckResult> rcrList;
	
	/**资产列表*/
	protected List<SOC0124Info> soc0124List;
	
	public String getSwoValue() {
		return swoValue;
	}

	public void setSwoValue(String swoValue) {
		this.swoValue = swoValue;
	}

	public String getFtdValue() {
		return ftdValue;
	}

	public void setFtdValue(String ftdValue) {
		this.ftdValue = ftdValue;
	}

	public String getSerValue() {
		return serValue;
	}

	public void setSerValue(String serValue) {
		this.serValue = serValue;
	}

	public String getTeValue() {
		return teValue;
	}

	public void setTeValue(String teValue) {
		this.teValue = teValue;
	}

	public String getTpValue() {
		return tpValue;
	}

	public void setTpValue(String tpValue) {
		this.tpValue = tpValue;
	}

	public String getChaValue() {
		return chaValue;
	}

	public void setChaValue(String chaValue) {
		this.chaValue = chaValue;
	}

	public String getReqValue() {
		return reqValue;
	}

	public void setReqValue(String reqValue) {
		this.reqValue = reqValue;
	}

	public String getAssValue() {
		return assValue;
	}

	public void setAssValue(String assValue) {
		this.assValue = assValue;
	}

	public String getResultXML() {
		return resultXML;
	}

	public void setResultXML(String resultXML) {
		this.resultXML = resultXML;
	}

	public String getWorkValue() {
		return workValue;
	}

	public void setWorkValue(String workValue) {
		this.workValue = workValue;
	}

	/**
	 * ajax结果取得
	 * @return ajaxResult ajax结果
	 */
	public String getAjaxResult() {
		return ajaxResult;
	}

	/**
	 * ajax结果设定
	 * @param ajaxResult ajax结果
	 */
	public void setAjaxResult(String ajaxResult) {
		this.ajaxResult = ajaxResult;
	}


	/**
	 * 科技运行一服务工单、故障申报、业务服务请求取得
	 * @return processCountYW 科技运行一服务工单、故障申报、业务服务请求
	 */
	public String getProcessCountYW() {
		return processCountYW;
	}

	/**
	 * 科技运行一服务工单、故障申报、业务服务请求设定
	 * @param processCountYW 科技运行一服务工单、故障申报、业务服务请求
	 */
	public void setProcessCountYW(String processCountYW) {
		this.processCountYW = processCountYW;
	}


	/**
	 * 科技运行一事件、问题、变更、科技服务请求、指派取得
	 * @return processCountKJ 科技运行一事件、问题、变更、科技服务请求、指派
	 */
	public String getProcessCountKJ() {
		return processCountKJ;
	}

	/**
	 * 科技运行一事件、问题、变更、科技服务请求、指派设定
	 * @param processCountKJ 科技运行一事件、问题、变更、科技服务请求、指派
	 */
	public void setProcessCountKJ(String processCountKJ) {
		this.processCountKJ = processCountKJ;
	}
	
	/**
	 * 获取允许查询的最大记录数
	 * @return 允许查询的最大记录数
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * 设置允许查询的最大记录数
	 * @param maxSearchCount 允许查询的最大记录数
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}
	

	/**
	 * 获取分页Bean
	 * @return 分页Bean
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * 设置分页Bean
	 * @param pagingDto 分页Bean
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	public String getSciValue() {
		return sciValue;
	}

	public void setSciValue(String sciValue) {
		this.sciValue = sciValue;
	}

	public String getBusiValue() {
		return busiValue;
	}

	/**
	 * @param busiValue
	 */
	public void setBusiValue(String busiValue) {
		this.busiValue = busiValue;
	}

	/**
	 * 流程信息集合取得
	 * @return prList 流程信息集合
	 */
	public List<IG500Info> getPrList() {
		return prList;
	}

	/**
	 * 流程信息集合设定
	 * @param prList 流程信息集合
	 */
	public void setPrList(List<IG500Info> prList) {
		this.prList = prList;
	}

	/**
	 * 检查工作集合取得
	 * @return rcrList 检查工作集合
	 */
	public List<RiskCheckResult> getRcrList() {
		return rcrList;
	}

	/**
	 * 检查工作集合设定
	 * @param rcrList 检查工作集合
	 */
	public void setRcrList(List<RiskCheckResult> rcrList) {
		this.rcrList = rcrList;
	}

	/**
	 * 资产列表   取得
	 * @return soc0124List 资产列表
	 */
	public List<SOC0124Info> getSoc0124List() {
		return soc0124List;
	}

	/**
	 * 资产列表   设定
	 * @param soc0124List 资产列表
	 */
	public void setSoc0124List(List<SOC0124Info> soc0124List) {
		this.soc0124List = soc0124List;
	}

	/**
	 * 检查项集合   取得
	 * @return checkItemList 检查项集合
	 */
	public List<CheckItemVWInfo> getCheckItemList() {
		return checkItemList;
	}

	/**
	 * 检查项集合   设定
	 * @param checkItemList 检查项集合
	 */
	public void setCheckItemList(List<CheckItemVWInfo> checkItemList) {
		this.checkItemList = checkItemList;
	}

	/**
	 * 风险点集合   取得
	 * @return riskPointList 风险点集合
	 */
	public List<RiskPointVMInfo> getRiskPointList() {
		return riskPointList;
	}

	/**
	 * 风险点集合   设定
	 * @param riskPointList 风险点集合
	 */
	public void setRiskPointList(List<RiskPointVMInfo> riskPointList) {
		this.riskPointList = riskPointList;
	}

	
	public List<RiskcaseVWInfo> getRiskcaseList() {
		return riskcaseList;
	}

	public void setRiskcaseList(List<RiskcaseVWInfo> riskcaseList) {
		this.riskcaseList = riskcaseList;
	}
	
	
}
