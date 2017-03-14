/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */

package com.deliverik.infogovernor.soc.srv.dto;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.model.Attachment;
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prr.model.IG036Info;
import com.deliverik.framework.workflow.prr.model.IG224Info;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.IG512Info;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.framework.workflow.prr.model.IG715Info;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCond;
import com.deliverik.infogovernor.soc.srv.form.IGSRV0217Form;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程管理_事件管理_DTO
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

/**
 * @author Administrator
 *
 */
/**
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class IGSRV02DTO extends BaseDTO implements Serializable {
	
	/**事件记录ID*/
	protected Integer prid;
	
	/**事件用户ID*/
	protected String userid;
	
	/**事件用户姓名*/
	protected String username;
	
	/**事件角色ID*/
	protected Integer roleid;
	
	/**事件角色名称*/
	protected String rolename;
	
	/**事件状态或人员状态*/
	protected String status;
	
	/**流程定义id*/
	protected Integer pdid;
	
	/**流程变量*/
	protected List<IG007Info> processInfoDef;
	
	/**参与者*/
	protected List<IG337Info> processParticipantList;

	/**日志*/
	protected Map<IG036Info, List<Attachment>> recordLogAttachmentMap;

	/** 按钮 */
	protected List<String> actionnameList;
	
	/** 角色 */
	protected List<Role> roleList;

	/** 用户角色 */
	protected List<UserRoleInfo> userRoleList;

	/**事件对象*/
	protected IG500Info process;
	
	/**流程变量参数值*/
	protected List<IG599Info> processInfo;
	
	/**事件查询接口*/
	protected IG500SearchCond prSearchCond;
	
	/**事件快捷发起页*/
	protected IGSRV0217Form igsrv0217Form;
	
	/**事件对象List*/
	protected List<IG500Info> processList;
	
	/**事件确认标志*/
	protected String confirmflag;
	
	/**事件分类树*/
	private Map<String,TreeNode> treeNodeMap=new LinkedHashMap<String,TreeNode>();
	
	/**允许查询的最大记录数*/
	protected int maxSearchCount;

	/**分页Bean*/
	protected PagingDTO pagingDto;

	/**事件紧急度*/
	protected String urgency;
	
	/**事件预计解决时间*/
	protected String resolveTime;
	
	/**相关人员信息*/
	protected Map<String,String> perMap;
	
	/**下拉列表信息*/
	protected Map<Integer,String[]> optionMap;
	
	/**用户信息*/
	protected User user;
	
	/**事件查看页图形显示标识*/
	protected String confirmImgFlag;
	
	/**事件查看页申请复核按钮显示标识*/
	protected String canDoFlag;
	
	/**流程关系信息检索列表*/
	protected List<IG512Info> processRecordRelationList;
	
	/**服务工单关系信息检索列表*/
	protected List<IG715Info> serviceProcessRecordRelationList;
	
	/** 事件查询流程类型 */
	protected List<IG380Info> processDefinitionList;
	
	/** 流程状态日志集合 */
	protected List<IG224Info> recordStatusLogList;
	
	protected String isAdmin;
	
	/** 归类排序字段 */
	protected String pSort;
	/** 排序字段 */
	protected String pOrder;
	/** 组合排序标题字段 */
	protected String prtitle;

	public String getPsort_order() {
		return psort_order;
	}

	public void setPsort_order(String psort_order) {
		this.psort_order = psort_order;
	}

	protected String psort_order;
	
	public String getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	/**
	 * @return the canDoFlag
	 */
	public String getCanDoFlag() {
		return canDoFlag;
	}

	/**
	 * @param canDoFlag the canDoFlag to set
	 */
	public void setCanDoFlag(String canDoFlag) {
		this.canDoFlag = canDoFlag;
	}

	/**
	 * @return the confirmImgFlag
	 */
	public String getConfirmImgFlag() {
		return confirmImgFlag;
	}

	/**
	 * @param confirmImgFlag the confirmImgFlag to set
	 */
	public void setConfirmImgFlag(String confirmImgFlag) {
		this.confirmImgFlag = confirmImgFlag;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	public String getUrgency() {
		return urgency;
	}

	public void setUrgency(String urgency) {
		this.urgency = urgency;
	}

	public String getResolveTime() {
		return resolveTime;
	}

	public void setResolveTime(String resolveTime) {
		this.resolveTime = resolveTime;
	}

	/**
	 * 获取事件记录ID
	 * @return 事件记录ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * 设置事件记录ID
	 * @param prid 事件记录ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * 获取事件用户ID
	 * @return 事件用户ID
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * 设置事件用户ID
	 * @param userid 事件用户ID
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * 获取事件用户姓名
	 * @return 事件用户姓名
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * 设置事件用户姓名
	 * @param username 事件用户姓名
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * 获取事件角色ID
	 * @return 事件角色ID
	 */
	public Integer getRoleid() {
		return roleid;
	}

	/**
	 * 设置事件角色ID
	 * @param roleid 事件角色ID
	 */
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	/**
	 * 获取事件角色名称
	 * @return 事件角色名称
	 */
	public String getRolename() {
		return rolename;
	}

	/**
	 * 设置事件角色名称
	 * @param rolename 事件角色名称
	 */
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	/**
	 * 获取事件状态或人员状态
	 * @return 事件状态或人员状态
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * 设置事件状态或人员状态
	 * @param status 事件状态或人员状态
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * 获取流程定义id
	 * @return 流程定义id
	 */
	public Integer getPdid() {
		return pdid;
	}

	/**
	 * 设置流程定义id
	 * @param pdid 流程定义id
	 */
	public void setPdid(Integer pdid) {
		this.pdid = pdid;
	}

	/**
	 * 获取流程变量
	 * @return 流程变量
	 */
	public List<IG007Info> getProcessInfoDef() {
		return processInfoDef;
	}

	/**
	 * 设置流程变量
	 * @param processInfoDef 流程变量
	 */
	public void setProcessInfoDef(List<IG007Info> processInfoDef) {
		this.processInfoDef = processInfoDef;
	}

	/**
	 * 获取参与者
	 * @return 参与者
	 */
	public List<IG337Info> getProcessParticipantList() {
		return processParticipantList;
	}

	/**
	 * 设置参与者
	 * @param processParticipantList 参与者
	 */
	public void setProcessParticipantList(
			List<IG337Info> processParticipantList) {
		this.processParticipantList = processParticipantList;
	}

	/**
	 * 获取日志
	 * @return 日志
	 */
	public Map<IG036Info, List<Attachment>> getRecordLogAttachmentMap() {
		return recordLogAttachmentMap;
	}

	/**
	 * 设置日志
	 * @param recordLogAttachmentMap 日志
	 */
	public void setRecordLogAttachmentMap(
			Map<IG036Info, List<Attachment>> recordLogAttachmentMap) {
		this.recordLogAttachmentMap = recordLogAttachmentMap;
	}

	/**
	 * 获取按钮
	 * @return 按钮
	 */
	public List<String> getActionnameList() {
		return actionnameList;
	}

	/**
	 * 设置按钮
	 * @param actionnameList 按钮
	 */
	public void setActionnameList(List<String> actionnameList) {
		this.actionnameList = actionnameList;
	}

	/**
	 * 获取角色
	 * @return 角色
	 */
	public List<Role> getRoleList() {
		return roleList;
	}

	public Map<Integer, String[]> getOptionMap() {
		return optionMap;
	}

	public void setOptionMap(Map<Integer, String[]> optionMap) {
		this.optionMap = optionMap;
	}

	/**
	 * 设置角色
	 * @param roleList 角色
	 */
	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	/**
	 * 获取用户角色 
	 * @return 用户角色 
	 */
	public List<UserRoleInfo> getUserRoleList() {
		return userRoleList;
	}

	/**
	 * 设置用户角色 
	 * @param userRoleList 用户角色 
	 */
	public void setUserRoleList(List<UserRoleInfo> userRoleList) {
		this.userRoleList = userRoleList;
	}

	/**
	 * 获取事件对象
	 * @return 事件对象
	 */
	public IG500Info getProcess() {
		return process;
	}

	/**
	 * 设置事件对象
	 * @param process 事件对象
	 */
	public void setProcess(IG500Info process) {
		this.process = process;
	}

	/**
	 * 获取流程变量参数值
	 * @return 流程变量参数值
	 */
	public List<IG599Info> getProcessInfo() {
		return processInfo;
	}

	/**
	 * 设置流程变量参数值
	 * @param processInfo 流程变量参数值
	 */
	public void setProcessInfo(List<IG599Info> processInfo) {
		this.processInfo = processInfo;
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
	 * 获取事件快捷发起页
	 * @return 事件快捷发起页
	 */
	public IGSRV0217Form getIgsrv0217Form() {
		return igsrv0217Form;
	}

	/**
	 * 设置事件快捷发起页
	 * @param igsvc0217Form 事件快捷发起页
	 */
	public void setIgsrv0217Form(IGSRV0217Form igsrv0217Form) {
		this.igsrv0217Form = igsrv0217Form;
	}

	/**
	 * 获取事件对象List
	 * @return 事件对象List
	 */
	public List<IG500Info> getProcessList() {
		return processList;
	}

	/**
	 * 设置事件对象List
	 * @param processList 事件对象List
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
	
	/**
	 * 获取事件分类树
	 * @return 事件分类树
	 */
	public Map<String, TreeNode> getTreeNodeMap() {
		return treeNodeMap;
	}

	/**
	 * 设置事件分类树
	 * @param treeNodeMap 事件分类树
	 */
	public void setTreeNodeMap(Map<String, TreeNode> treeNodeMap) {
		this.treeNodeMap = treeNodeMap;
	}

	/**
	 * 获取事件确认标志
	 * @return 事件确认标志
	 */
	public String getConfirmflag() {
		return confirmflag;
	}

	/**
	 * 设置事件确认标志
	 * @param confirmflag 事件确认标志
	 */
	public void setConfirmflag(String confirmflag) {
		this.confirmflag = confirmflag;
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
	 * 获取流程关系信息检索列表
	 * @return 流程关系信息检索列表
	 */
	public List<IG512Info> getProcessRecordRelationList() {
		return processRecordRelationList;
	}

	/**
	 * 设置流程关系信息检索列表
	 * @param processRecordRelationList 流程关系信息检索列表
	 */
	public void setProcessRecordRelationList(
			List<IG512Info> processRecordRelationList) {
		this.processRecordRelationList = processRecordRelationList;
	}

	/**
	 * 获取服务工单关系信息检索列表
	 * @return 服务工单关系信息检索列表
	 */
	public List<IG715Info> getServiceProcessRecordRelationList() {
		return serviceProcessRecordRelationList;
	}

	/**
	 * 设置服务工单关系信息检索列表
	 * @param serviceProcessRecordRelationList 服务工单关系信息检索列表
	 */
	public void setServiceProcessRecordRelationList(
			List<IG715Info> serviceProcessRecordRelationList) {
		this.serviceProcessRecordRelationList = serviceProcessRecordRelationList;
	}

	public List<IG380Info> getProcessDefinitionList() {
		return processDefinitionList;
	}

	public void setProcessDefinitionList(
			List<IG380Info> processDefinitionList) {
		this.processDefinitionList = processDefinitionList;
	}
	
	/**
	 * 流程状态日志集合取得
	 * @return 流程状态日志集合
	 */
	public List<IG224Info> getRecordStatusLogList() {
		return recordStatusLogList;
	}

	/**
	 * 流程状态日志集合设定
	 * @param recordStatusLogList 流程状态日志集合
	 */
	public void setRecordStatusLogList(List<IG224Info> recordStatusLogList) {
		this.recordStatusLogList = recordStatusLogList;
	}

	public String getPSort() {
		return pSort;
	}

	public void setPSort(String sort) {
		pSort = sort;
	}

	public String getPOrder() {
		return pOrder;
	}

	public void setPOrder(String order) {
		pOrder = order;
	}

	public String getPrtitle() {
		return prtitle;
	}

	public void setPrtitle(String prtitle) {
		this.prtitle = prtitle;
	}
	
	
}
