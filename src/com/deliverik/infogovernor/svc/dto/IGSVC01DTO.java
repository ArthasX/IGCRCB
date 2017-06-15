/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.svc.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.IG677Info;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG677SearchCondImpl;
import com.deliverik.infogovernor.com.model.ProcessInHandVWInfo;
import com.deliverik.infogovernor.svc.form.IGSVC0100Form;


@SuppressWarnings("serial")
public class IGSVC01DTO extends BaseDTO implements Serializable {
    
	/**用户id*/
	private String userid;
	
	protected String userid_q;
	
	/**用户姓名*/
	private String username;
	
	/**流程map*/
	private Map<String, List<IG500Info>> processRecordMap;
	
	/**事件查询接口*/
	protected IG500SearchCond prSearchCond;
	
	/**流程与参与者视图map*/
	private Map<String, List<IG677Info>> processRecordInfoMap;
	
	/**流程模板名称*/
	private String[] templateNames;
	
	/**流程模板查看页URL*/
	private Map<String,String> detailPgMap;
	
	/**流程模板查看页URL*/
	private String[] detailPgs;
	
	/**流程对象List*/
	protected List<IG500Info> processList;
	
	/**允许查询的最大记录数*/
	protected int maxSearchCount;

	/**分页Bean*/
	protected PagingDTO pagingDto;
	
	protected IGSVC0100Form igsvc0100form;

	protected IG677SearchCondImpl processInfoSearchCond;
	
	/** 流程类型集合 */
	protected List<LabelValueBean> prtypeList;
	
	/** 工作信息集合 */
	protected List<ProcessInHandVWInfo> workList;
	
	public IGSVC0100Form getIgsvc0100form() {
		return igsvc0100form;
	}

	public void setIgsvc0100form(IGSVC0100Form igsvc0100form) {
		this.igsvc0100form = igsvc0100form;
	}

	/**
	 * 获取用户id
	 * @return 用户id
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * 设置用户id
	 * @param userid 用户id
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * 获取用户姓名
	 * @return 用户姓名
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * 设置用户姓名
	 * @param username 用户姓名
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * 获取流程map
	 * @return 流程map
	 */
	public Map<String, List<IG500Info>> getProcessRecordMap() {
		return processRecordMap;
	}

	/**
	 * 设置流程map
	 * @param processRecordMap 流程map
	 */
	public void setProcessRecordMap(
			Map<String, List<IG500Info>> processRecordMap) {
		this.processRecordMap = processRecordMap;
	}

	/**
	 * 获取流程模板名称
	 * @return 流程模板名称
	 */
	public String[] getTemplateNames() {
		return templateNames;
	}

	/**
	 * 设置流程模板名称
	 * @param templateNames 流程模板名称
	 */
	public void setTemplateNames(String[] templateNames) {
		this.templateNames = templateNames;
	}

	/**
	 * 获取流程模板查看页URL
	 * @return 流程模板查看页URL
	 */
	public Map<String,String> getDetailPgMap() {
		return detailPgMap;
	}

	/**
	 * 设置流程模板查看页URL
	 * @param detailPgMap 流程模板查看页URL
	 */
	public void setDetailPgMap(Map<String,String> detailPgMap) {
		this.detailPgMap = detailPgMap;
	}
	
	/**
	 * 获取流程模板查看页URL
	 * @return 流程模板查看页URL
	 */
	public String[] getDetailPgs() {
		return detailPgs;
	}

	/**
	 * 设置流程模板查看页URL
	 * @param detailPgs 流程模板查看页URL
	 */
	public void setDetailPgs(String[] detailPgs) {
		this.detailPgs = detailPgs;
	}

	/**
	 * 获取流程与参与者视图map
	 * @return 流程与参与者视图map
	 */
	public Map<String, List<IG677Info>> getProcessRecordInfoMap() {
		return processRecordInfoMap;
	}

	/**
	 * 设置流程与参与者视图map
	 * @param processRecordInfoMap 流程与参与者视图map
	 */
	public void setProcessRecordInfoMap(
			Map<String, List<IG677Info>> processRecordInfoMap) {
		this.processRecordInfoMap = processRecordInfoMap;
	}
	

	/**
	 * 获取事件查询接口
	 * @return 事件查询接口
	 */
	public IG500SearchCond getPrSearchCond() {
		return prSearchCond;
	}

	/**
	 * 设置事件查询接口
	 * @param prSearchCond 事件查询接口
	 */
	public void setPrSearchCond(IG500SearchCond prSearchCond) {
		this.prSearchCond = prSearchCond;
	}

	/**
	 * 获取流程对象List
	 * @return 流程对象List
	 */
	public List<IG500Info> getProcessList() {
		return processList;
	}


	/**
	 * 设置流程对象List
	 * @param processList 流程对象List
	 */
	public void setProcessList(List<IG500Info> processList) {
		this.processList = processList;
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

	public IG677SearchCondImpl getProcessInfoSearchCond() {
		return processInfoSearchCond;
	}

	public void setProcessInfoSearchCond(
			IG677SearchCondImpl processInfoSearchCond) {
		this.processInfoSearchCond = processInfoSearchCond;
	}

	/**
	 * 获取userid_q
	 * @return fuserid_q userid_q
	 */
	public String getUserid_q() {
		return userid_q;
	}

	/**
	 * 设置userid_q
	 * @param userid_q  userid_q
	 */
	public void setUserid_q(String userid_q) {
		this.userid_q = userid_q;
	}

	/**
	 * prtypeList取得
	 * @return prtypeList prtypeList
	 */
	public List<LabelValueBean> getPrtypeList() {
		return prtypeList;
	}

	/**
	 * prtypeList设定
	 * @param prtypeList prtypeList
	 */
	public void setPrtypeList(List<LabelValueBean> prtypeList) {
		this.prtypeList = prtypeList;
	}

	/**
	 * 工作信息集合取得
	 * @return workList 工作信息集合
	 */
	public List<ProcessInHandVWInfo> getWorkList() {
		return workList;
	}

	/**
	 * 工作信息集合设定
	 * @param workList 工作信息集合
	 */
	public void setWorkList(List<ProcessInHandVWInfo> workList) {
		this.workList = workList;
	}
	
	
}