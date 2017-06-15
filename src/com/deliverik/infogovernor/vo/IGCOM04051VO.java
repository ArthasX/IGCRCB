/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.IG677Info;
import com.deliverik.framework.workflow.prr.model.IG933Info;
import com.deliverik.infogovernor.com.model.ProcessInHandVWInfo;

/**
 * 业务人员首页用VO
 *
 */
@SuppressWarnings("serial")
public class IGCOM04051VO extends BaseVO implements Serializable{

	/** 我的工作列表 */
	private List<IG677Info> processRecordInfoForMeList;
	
	/** 我发起的工作列表 */
	private List<IG677Info> processRecordInitForMeList;
	
	/** 历史工作列表 */
	private List<IG500Info> processRecordInitForHistoryList;
	
	/**相关工作列表*/
	private Map<String,List<IG677Info>> retForRelateMap;
	
	/**相关工作集合*/
	private List<IG677Info> retForRelateList;
	
	/** 流程查看页链接 */
	private Map<String,String> urlMap;
	
	/** 我的工作集合 */
	private Map<String,List<IG677Info>> processRecordMap;
	
	/** 我发起的工作集合 */
	private Map<String,List<IG677Info>> processRecordInitForMeMap;
	
	/** 历史工作集合 */
	private Map<String,List<IG500Info>> processRecordInitForHistoryMap;
	
	/** 我发起的服务台工单记录 */
	private List<IG933Info> serviceFormList;
	
	/** 咨询建议链接是否可用标识 */
	private boolean service_process_6;
	
	/** 投书建议链接是否可用标识 */
	private boolean service_process_7;
	
	/** 我的工作集合 */
	protected List<ProcessInHandVWInfo> myWorkList;
	
	/** 相关工作集合 */
	protected List<ProcessInHandVWInfo> relevanceWorkList;
	
	/**
	 * 我的工作列表取得
	 * 
	 * @return 我的工作列表
	 */
	public List<IG677Info> getProcessRecordInfoForMeList() {
		return processRecordInfoForMeList;
	}

	/**
	 * 我的工作列表设定
	 * 
	 * @param processRecordInfoForMeList 我的工作列表
	 */
	public void setProcessRecordInfoForMeList(
			List<IG677Info> processRecordInfoForMeList) {
		this.processRecordInfoForMeList = processRecordInfoForMeList;
	}

	/**
	 * 我发起的工作列表取得
	 * 
	 * @return 我发起的工作列表
	 */
	public List<IG677Info> getProcessRecordInitForMeList() {
		return processRecordInitForMeList;
	}

	/**
	 * 我发起的工作列表设定
	 * 
	 * @param processRecordInitForMeList 我发起的工作列表
	 */
	public void setProcessRecordInitForMeList(
			List<IG677Info> processRecordInitForMeList) {
		this.processRecordInitForMeList = processRecordInitForMeList;
	}

	/**
	 * 流程查看页链接取得
	 * 
	 * @return 流程查看页链接
	 */
	public Map<String, String> getUrlMap() {
		return urlMap;
	}

	/**
	 * 流程查看页链接设定
	 * 
	 * @param urlMap 流程查看页链接
	 */
	public void setUrlMap(Map<String, String> urlMap) {
		this.urlMap = urlMap;
	}

	/**
	 * 我的工作集合取得
	 * 
	 * @return 我的工作集合取得
	 */
	public Map<String, List<IG677Info>> getProcessRecordMap() {
		return processRecordMap;
	}

	/**
	 * 我的工作集合设定
	 * 
	 * @param processRecordMap 我的工作集合
	 */
	public void setProcessRecordMap(
			Map<String, List<IG677Info>> processRecordMap) {
		this.processRecordMap = processRecordMap;
	}
	
	/**
	 * 我发起的工作集合取得
	 * 
	 * @return 我发起的工作集合
	 */
	public Map<String, List<IG677Info>> getProcessRecordInitForMeMap() {
		return processRecordInitForMeMap;
	}
	
	/**
	 * 我发起的工作集合设定
	 * 
	 * @param processRecordInitForMeMap 我发起的工作集合
	 */
	public void setProcessRecordInitForMeMap(
			Map<String, List<IG677Info>> processRecordInitForMeMap) {
		this.processRecordInitForMeMap = processRecordInitForMeMap;
	}

	/**
	 * 咨询建议链接是否可用标识取得
	 * 
	 * @return 咨询建议链接是否可用标识
	 */
	public boolean isService_process_6() {
		return service_process_6;
	}

	/**
	 * 咨询建议链接是否可用标识设定
	 * 
	 * @param service_process_6 咨询建议链接是否可用标识
	 */
	public void setService_process_6(boolean service_process_6) {
		this.service_process_6 = service_process_6;
	}

	/**
	 * 投诉建议链接是否可用标识取得
	 * 
	 * @return 投诉建议链接是否可用标识
	 */
	public boolean isService_process_7() {
		return service_process_7;
	}

	/**
	 * 投诉建议链接是否可用标识设定
	 * 
	 * @param service_process_7 投诉建议链接是否可用标识
	 */
	public void setService_process_7(boolean service_process_7) {
		this.service_process_7 = service_process_7;
	}

	/**
	 * 我发起的服务台工单记录取得
	 * 
	 * @return 我发起的服务台工单记录
	 */
	public List<IG933Info> getServiceFormList() {
		return serviceFormList;
	}

	/**
	 * 我发起的服务台工单记录设定
	 * 
	 * @param serviceFormList 我发起的服务台工单记录
	 */
	public void setServiceFormList(List<IG933Info> serviceFormList) {
		this.serviceFormList = serviceFormList;
	}
	
	/**
	 *获取历史工作列表
	 * @return the processRecordInitForHistoryList历史工作列表
	 */
	public List<IG500Info> getProcessRecordInitForHistoryList() {
		return processRecordInitForHistoryList;
	}

	/**
	 *设置历史工作列表
	 * @param processRecordInitForHistoryList 历史工作列表
	 */
	public void setProcessRecordInitForHistoryList(
			List<IG500Info> processRecordInitForHistoryList) {
		this.processRecordInitForHistoryList = processRecordInitForHistoryList;
	}
	
	/**
	 *获取历史工作集合
	 * @return the processRecordInitForHistoryMap历史工作集合
	 */
	public Map<String, List<IG500Info>> getProcessRecordInitForHistoryMap() {
		return processRecordInitForHistoryMap;
	}

	/**
	 *设置历史工作集合
	 * @param processRecordInitForHistoryMap 历史工作集合
	 */
	public void setProcessRecordInitForHistoryMap(
			Map<String, List<IG500Info>> processRecordInitForHistoryMap) {
		this.processRecordInitForHistoryMap = processRecordInitForHistoryMap;
	}


	/**
	 * 相关工作集合取得
	 * @return retForRelateList 相关工作集合
	 */
	public List<IG677Info> getRetForRelateList() {
		return retForRelateList;
	}

	/**
	 * 相关工作集合设定
	 * @param retForRelateList 相关工作集合
	 */
	public void setRetForRelateList(List<IG677Info> retForRelateList) {
		this.retForRelateList = retForRelateList;
	}

	/**
	 * 相关工作列表取得
	 * @return retForRelateMap 相关工作列表
	 */
	public Map<String, List<IG677Info>> getRetForRelateMap() {
		return retForRelateMap;
	}

	/**
	 * 相关工作列表设定
	 * @param retForRelateMap 相关工作列表
	 */
	public void setRetForRelateMap(Map<String, List<IG677Info>> retForRelateMap) {
		this.retForRelateMap = retForRelateMap;
	}

	/**
	 * 我的工作集合取得
	 * @return myWorkList 我的工作集合
	 */
	public List<ProcessInHandVWInfo> getMyWorkList() {
		return myWorkList;
	}

	/**
	 * 我的工作集合设定
	 * @param myWorkList 我的工作集合
	 */
	public void setMyWorkList(List<ProcessInHandVWInfo> myWorkList) {
		this.myWorkList = myWorkList;
	}

	/**
	 * 相关工作集合取得
	 * @return relevanceWorkList 相关工作集合
	 */
	public List<ProcessInHandVWInfo> getRelevanceWorkList() {
		return relevanceWorkList;
	}

	/**
	 * 相关工作集合设定
	 * @param relevanceWorkList 相关工作集合
	 */
	public void setRelevanceWorkList(List<ProcessInHandVWInfo> relevanceWorkList) {
		this.relevanceWorkList = relevanceWorkList;
	}
	
}
