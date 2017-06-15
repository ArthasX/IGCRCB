/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dwp.dto;

import java.util.List;
import java.util.Map;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserInfo;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prd.model.IG243Info;
import com.deliverik.framework.workflow.prd.model.IG259Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.infogovernor.dwp.model.IGDWP0001Info;
import com.deliverik.infogovernor.dwp.model.IGDWP0002Info;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 日常工作计划dto
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGDWP01DTO extends BaseDTO{
	
	/** 主键 */
	protected Integer id;
	
	/** 用户信息 */
	protected User user;

	/**允许查询的最大记录数*/
	protected int maxSearchCount;

	/**分页Bean*/
	protected PagingDTO pagingDto;
	
	/** 日常工作计划信息集合 */
	protected List<IGDWP0001Info> dayWorkPlanList;
	
	/** 流程定义信息 */
	protected Map<IG259Info, List<IG380Info>> processDefinitionMap;
	
	/** 计划信息 */
	protected IGDWP0001Info plan;
	
	/** 流程信息 */
	protected IGDWP0002Info process;
	
	/** 流程定义信息 */
	protected IG380Info processDefinition;
	
	/** 状态定义信息 */
	protected IG333Info processStatusDef;
	
	/** 下拉列表信息 */
	protected List<LabelValueBean> labelValueBeanList;
	
	/** 流程标题定义信息 */
	protected IG243Info ptdInfo;
	
	/** 流程表单定义信息集合 */
	protected List<IG007Info> processInfoList;
	
	/** 分派标识 */
	protected String assignFlag;
	
	/** 分派信息集合 */
	protected Map<IG333Info,Map<Role, List<UserInfo>>> assignInfoMap;

	/**
	 * 主键取得
	 * @return id 主键
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 主键设定
	 * @param id 主键
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 用户信息取得
	 * @return user 用户信息
	 */
	public User getUser() {
		return user;
	}

	/**
	 * 用户信息设定
	 * @param user 用户信息
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * 允许查询的最大记录数取得
	 * @return maxSearchCount 允许查询的最大记录数
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * 允许查询的最大记录数设定
	 * @param maxSearchCount 允许查询的最大记录数
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * 分页Bean取得
	 * @return pagingDto 分页Bean
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * 分页Bean设定
	 * @param pagingDto 分页Bean
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	/**
	 * 日常工作计划信息集合取得
	 * @return dayWorkPlanList 日常工作计划信息集合
	 */
	public List<IGDWP0001Info> getDayWorkPlanList() {
		return dayWorkPlanList;
	}

	/**
	 * 日常工作计划信息集合设定
	 * @param dayWorkPlanList 日常工作计划信息集合
	 */
	public void setDayWorkPlanList(List<IGDWP0001Info> dayWorkPlanList) {
		this.dayWorkPlanList = dayWorkPlanList;
	}

	/**
	 * 流程信息取得
	 * @return process 流程信息
	 */
	public IGDWP0002Info getProcess() {
		return process;
	}

	/**
	 * 流程信息设定
	 * @param process 流程信息
	 */
	public void setProcess(IGDWP0002Info process) {
		this.process = process;
	}

	/**
	 * 流程定义信息取得
	 * @return processDefinitionMap 流程定义信息
	 */
	public Map<IG259Info, List<IG380Info>> getProcessDefinitionMap() {
		return processDefinitionMap;
	}

	/**
	 * 流程定义信息设定
	 * @param processDefinitionMap 流程定义信息
	 */
	public void setProcessDefinitionMap(
			Map<IG259Info, List<IG380Info>> processDefinitionMap) {
		this.processDefinitionMap = processDefinitionMap;
	}

	/**
	 * 计划信息取得
	 * @return plan 计划信息
	 */
	public IGDWP0001Info getPlan() {
		return plan;
	}

	/**
	 * 计划信息设定
	 * @param plan 计划信息
	 */
	public void setPlan(IGDWP0001Info plan) {
		this.plan = plan;
	}

	/**
	 * 流程定义信息取得
	 * @return processDefinition 流程定义信息
	 */
	public IG380Info getProcessDefinition() {
		return processDefinition;
	}

	/**
	 * 流程定义信息设定
	 * @param processDefinition 流程定义信息
	 */
	public void setProcessDefinition(IG380Info processDefinition) {
		this.processDefinition = processDefinition;
	}
	
	/**
	 * 状态定义信息取得
	 * @return processStatusDef 状态定义信息
	 */
	public IG333Info getProcessStatusDef() {
		return processStatusDef;
	}

	/**
	 * 状态定义信息设定
	 * @param processStatusDef 状态定义信息
	 */
	public void setProcessStatusDef(IG333Info processStatusDef) {
		this.processStatusDef = processStatusDef;
	}

	/**
	 * 下拉列表信息取得
	 * @return labelValueBeanList 下拉列表信息
	 */
	public List<LabelValueBean> getLabelValueBeanList() {
		return labelValueBeanList;
	}

	/**
	 * 下拉列表信息设定
	 * @param labelValueBeanList 下拉列表信息
	 */
	public void setLabelValueBeanList(List<LabelValueBean> labelValueBeanList) {
		this.labelValueBeanList = labelValueBeanList;
	}

	/**
	 * 流程标题定义信息取得
	 * @return ptdInfo 流程标题定义信息
	 */
	public IG243Info getPtdInfo() {
		return ptdInfo;
	}

	/**
	 * 流程标题定义信息设定
	 * @param ptdInfo 流程标题定义信息
	 */
	public void setPtdInfo(IG243Info ptdInfo) {
		this.ptdInfo = ptdInfo;
	}

	/**
	 * 流程表单定义信息集合取得
	 * @return processInfoList 流程表单定义信息集合
	 */
	public List<IG007Info> getProcessInfoList() {
		return processInfoList;
	}

	/**
	 * 流程表单定义信息集合设定
	 * @param processInfoList 流程表单定义信息集合
	 */
	public void setProcessInfoList(List<IG007Info> processInfoList) {
		this.processInfoList = processInfoList;
	}

	/**
	 * 分派标识取得
	 * @return assignFlag 分派标识
	 */
	public String getAssignFlag() {
		return assignFlag;
	}

	/**
	 * 分派标识设定
	 * @param assignFlag 分派标识
	 */
	public void setAssignFlag(String assignFlag) {
		this.assignFlag = assignFlag;
	}

	/**
	 * 分派信息集合取得
	 * @return assignInfoMap 分派信息集合
	 */
	public Map<IG333Info, Map<Role, List<UserInfo>>> getAssignInfoMap() {
		return assignInfoMap;
	}

	/**
	 * 分派信息集合设定
	 * @param assignInfoMap 分派信息集合
	 */
	public void setAssignInfoMap(
			Map<IG333Info, Map<Role, List<UserInfo>>> assignInfoMap) {
		this.assignInfoMap = assignInfoMap;
	}
}
