/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.svc.vo;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prr.model.IG003Info;
import com.deliverik.framework.workflow.prr.model.IG160Info;
import com.deliverik.framework.workflow.prr.model.IG359Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.IG512Info;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.framework.workflow.prr.model.IG677Info;
import com.deliverik.framework.workflow.prr.model.IG933Info;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程管理_统计分析_汇总列表VO
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSVC05131VO extends BaseVO {

	/**
	 * 流程汇总信息列表
	 */
	private List<IG359Info> processCountList;
	
	/**
	 * 流程记录信息列表
	 */
	private List<IG500Info> processRecordList;
	
	/**
	 * 按用户查询得到的流程汇总信息列表
	 */
	private List<IG160Info> userProcessCountList;
	
	/**相关人员信息*/
	private Map<String,String> perMap;
	
	/**
	 * 流程记录信息
	 */
	private IG500Info process;
	
	/**
	 * 流程统计信息列表
	 */
	private List<IG003Info> processSummaryList;
	
	private List<IG599Info> processInfo;
	
	private List<IG677Info> processRecordInfo;
	
	private String initStatusTime;
	
	private String expectStatusTime;
	
	private String expectProcessTime;
	
	/**
	 * 工单处理列表
	 */
	private List<IG933Info> processGdRecordInfoList;

	public String getExpectProcessTime() {
		return expectProcessTime;
	}

	public void setExpectProcessTime(String expectProcessTime) {
		this.expectProcessTime = expectProcessTime;
	}

	public String getInitStatusTime() {
		return initStatusTime;
	}

	public void setInitStatusTime(String initStatusTime) {
		this.initStatusTime = initStatusTime;
	}

	public String getExpectStatusTime() {
		return expectStatusTime;
	}

	public void setExpectStatusTime(String expectStatusTime) {
		this.expectStatusTime = expectStatusTime;
	}

	/**流程关系信息检索列表*/
	protected List<IG512Info> processRecordRelationList;

	public List<IG677Info> getProcessRecordInfo() {
		return processRecordInfo;
	}

	public void setProcessRecordInfo(List<IG677Info> processRecordInfo) {
		this.processRecordInfo = processRecordInfo;
	}

	public List<IG599Info> getProcessInfo() {
		return processInfo;
	}

	public void setProcessInfo(List<IG599Info> processInfo) {
		this.processInfo = processInfo;
	}

	/**
	 * 获取流程统计信息列表
	 * @return List<ProcessSummary>
	 */
	public List<IG003Info> getProcessSummaryList() {
		return processSummaryList;
	}

	/**
	 * 设置流程统计信息列表
	 * @param processSummaryList List<ProcessSummary>
	 */
	
	public void setProcessSummaryList(List<IG003Info> processSummaryList) {
		this.processSummaryList = processSummaryList;
	}

	/**
	 * 获取按用户查询得到的流程汇总信息列表
	 * @return  List<UserProcessCount>
	 */
	public List<IG160Info> getUserProcessCountList() {
		return userProcessCountList;
	}

	/**
	 * 设置按用户查询得到的流程汇总信息列表
	 * @param userProcessCountList List<UserProcessCount>
	 */
	public void setUserProcessCountList(List<IG160Info> userProcessCountList) {
		this.userProcessCountList = userProcessCountList;
	}

	public List<IG500Info> getProcessRecordList() {
		return processRecordList;
	}

	public void setProcessRecordList(List<IG500Info> processRecordList) {
		this.processRecordList = processRecordList;
	}

	public IG500Info getProcess() {
		return process;
	}

	public void setProcess(IG500Info process) {
		this.process = process;
	}

	/**
	 * 获取流程汇总信息列表
	 * @return List<ProcessCount>
	 */
	public List<IG359Info> getProcessCountList() {
		return processCountList;
	}

	/**
	 * 设置流程汇总信息列表
	 * @param processCountList List<ProcessCount>
	 */
	public void setProcessCountList(List<IG359Info> processCountList) {
		this.processCountList = processCountList;
	}
	
	/**
	 * 获取相关人员信息
	 * @return 相关人员信息
	 */
	public Map<String, String> getPerMap() {
		return perMap;
	}

	/**
	 * 设置相关人员信息
	 * @param perMap 相关人员信息
	 */
	public void setPerMap(Map<String, String> perMap) {
		this.perMap = perMap;
	}
	
	/**
	 * 设置流程关系信息检索列表
	 * @param processRecordRelationList 流程关系信息检索列表
	 */
	public void setProcessRecordRelationList(
			List<IG512Info> processRecordRelationList) {
		this.processRecordRelationList = processRecordRelationList;
	}

	public List<IG933Info> getProcessGdRecordInfoList() {
		return processGdRecordInfoList;
	}

	public void setProcessGdRecordInfoList(List<IG933Info> processGdRecordInfoList) {
		this.processGdRecordInfoList = processGdRecordInfoList;
	}
	
}
