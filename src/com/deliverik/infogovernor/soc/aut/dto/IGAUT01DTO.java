/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.soc.aut.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.security.UserPermission;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prd.model.IG259Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prr.model.CurrentMonthWorkVWInfo;
import com.deliverik.framework.workflow.prr.model.IG036Info;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCond;
import com.deliverik.infogovernor.soc.aut.form.IGAUT0101Form;
import com.deliverik.infogovernor.soc.aut.form.IGAUT0102Form;
import com.deliverik.infogovernor.soc.aut.form.IGAUT0103Form;
import com.deliverik.infogovernor.soc.aut.form.IGAUT0104Form;
import com.deliverik.infogovernor.soc.aut.form.IGAUT0110Form;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程管理_变更管理DTO
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGAUT01DTO extends BaseDTO implements Serializable {

	/**变更记录ID*/
	protected Integer prid;
	
	/**变更用户ID*/
	protected String userid;
	
	/**变更用户姓名*/
	protected String username;
	
	/**变更角色ID*/
	protected Integer roleid;
	
	/**变更角色名称*/
	protected String rolename;
	
	/**变更状态或人员状态*/
	protected String status;
	
	/**流程定义id*/
	protected String pdid;
	
	protected String prtype;
	
	/**流程变量*/
	protected List<IG007Info> processInfoDef;
	
	/**参与者*/
	protected List<IG337Info> processParticipantList;

	/**日志*/
	protected Map<String, List<IG036Info>> recordLogAttachmentMap;

	/** 按钮 */
	protected List<String> actionnameList;
	
	/** 角色 */
	protected List<Role> roleList;

	/** 用户角色 */
	protected List<UserRoleInfo> userRoleList;

	/**变更对象*/
	protected IG500Info process;
	
	/**流程变量参数值*/
	protected List<IG599Info> processInfo;
	
	/**变更查询接口*/
	protected IG500SearchCond prSearchCond;
	
	/**变更对象List*/
	protected List<IG500Info> processList;
	
	/**允许查询的最大记录数*/
	protected int maxSearchCount;

	/**分页Bean*/
	protected PagingDTO pagingDto;
	
	protected Map<String,String> nameURLMap;
	
	protected List<IG259Info> processTemplateList;
	
	protected List<IG380Info> processDefinitionList;
	
	protected String isAdmin;
	
	protected User user;
	
	/** 流程跳转JSP */
	protected String forwardJsp;
	
	/** 流程查询form */
	protected IGAUT0101Form igaut0101From;
	protected IGAUT0102Form igaut0102From;
	protected IGAUT0103Form igaut0103From;
	protected IGAUT0104Form igaut0104From;

	/** 表单定义查询条件map */
	protected Map<String, IG007Info> processInfoQueryMap;
		

	
	/** 带有当前处理人的本月工作 */
	protected List<CurrentMonthWorkVWInfo> currentManagerList;
	
	/** 查询类型*/
	protected String type;

	/** 菜单标识 */
	protected String actname;
	
	/** 登录人可见菜单集合 */
	protected UserPermission userPermission;
	
	/** 自定义流程通用查询form */
	protected IGAUT0110Form igaut0110Form;
	
	/** 外部生产事件查询页面显示最大数 */
	protected int maxCnt;
	
	/** 外部生产事件查询页面分页对象*/
	protected PagingDTO pDto;
	
	/** 外部生产事件查询信息集合 */
	protected List<IG500Info> scForOutList;
	
	/** 机构名称(下拉列表) (查询)信息集合 */
	protected List<LabelValueBean> orgList;
	
	
	/**
	 * 菜单标识取得
	 *
	 * @return actname 菜单标识
	 */
	public String getActname() {
		return actname;
	}

	/**
	 * 菜单标识设定
	 *
	 * @param actname 菜单标识
	 */
	public void setActname(String actname) {
		this.actname = actname;
	}

	/**
	 * 登录人可见菜单集合取得
	 *
	 * @return userPermission 登录人可见菜单集合
	 */
	public UserPermission getUserPermission() {
		return userPermission;
	}

	/**
	 * 登录人可见菜单集合设定
	 *
	 * @param userPermission 登录人可见菜单集合
	 */
	public void setUserPermission(UserPermission userPermission) {
		this.userPermission = userPermission;
	}

	private List<IG333Info> iG333InfoList;
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	public List<IG259Info> getProcessTemplateList() {
		return processTemplateList;
	}

	public void setProcessTemplateList(List<IG259Info> processTemplateList) {
		this.processTemplateList = processTemplateList;
	}

	public Map<String, String> getNameURLMap() {
		return nameURLMap;
	}

	public void setNameURLMap(Map<String, String> nameURLMap) {
		this.nameURLMap = nameURLMap;
	}

	public List<IG380Info> getProcessDefinitionList() {
		return processDefinitionList;
	}

	public void setProcessDefinitionList(
			List<IG380Info> processDefinitionList) {
		this.processDefinitionList = processDefinitionList;
	}

	/**
	 * 获取变更记录ID
	 * @return 变更记录ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * 设置变更记录ID
	 * @param prid 变更记录ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * 获取变更用户ID
	 * @return 变更用户ID
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * 设置变更用户ID
	 * @param userid 变更用户ID
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * 获取变更用户姓名
	 * @return 变更用户姓名
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * 设置变更用户姓名
	 * @param username 变更用户姓名
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * 获取变更角色ID
	 * @return 变更角色ID
	 */
	public Integer getRoleid() {
		return roleid;
	}

	/**
	 * 设置变更角色ID
	 * @param roleid 变更角色ID
	 */
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	/**
	 * 获取变更角色名称
	 * @return 变更角色名称
	 */
	public String getRolename() {
		return rolename;
	}

	/**
	 * 设置变更角色名称
	 * @param rolename 变更角色名称
	 */
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	/**
	 * 获取变更状态或人员状态
	 * @return 变更状态或人员状态
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * 设置变更状态或人员状态
	 * @param status 变更状态或人员状态
	 */
	public void setStatus(String status) {
		this.status = status;
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
	public Map<String, List<IG036Info>> getRecordLogAttachmentMap() {
		return recordLogAttachmentMap;
	}

	/**
	 * 设置日志
	 * @param recordLogAttachmentMap 日志
	 */
	public void setRecordLogAttachmentMap(
			Map<String, List<IG036Info>> recordLogAttachmentMap) {
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
	 * 获取变更对象
	 * @return 变更对象
	 */
	public IG500Info getProcess() {
		return process;
	}

	/**
	 * 设置变更对象
	 * @param process 变更对象
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
	 * 获取变更查询接口
	 * @return 变更查询接口
	 */
	public IG500SearchCond getPrSearchCond() {
		return prSearchCond;
	}

	/**
	 * 设置变更查询接口
	 * @param prSearchCond 变更查询接口
	 */
	public void setPrSearchCond(IG500SearchCond prSearchCond) {
		this.prSearchCond = prSearchCond;
	}

	/**
	 * 获取变更对象List
	 * @return 变更对象List
	 */
	public List<IG500Info> getProcessList() {
		return processList;
	}

	/**
	 * 设置变更对象List
	 * @param processList 变更对象List
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

	public String getPrtype() {
		return prtype;
	}

	public void setPrtype(String prtype) {
		this.prtype = prtype;
	}

    /**
     * @return the 流程定义id
     */
    public String getPdid() {
        return pdid;
    }

    /**
     * @param 流程定义id the pdid to set
     */
    public void setPdid(String pdid) {
        this.pdid = pdid;
    }

	/**
	 * 流程跳转JSP取得
	 * @return 流程跳转JSP
	 */
	public String getForwardJsp() {
		return forwardJsp;
	}

	/**
	 * 流程跳转JSP设定
	 * @param forwardJsp流程跳转JSP
	 */
	public void setForwardJsp(String forwardJsp) {
		this.forwardJsp = forwardJsp;
	}

	/**
	 * 流程查询form取得
	 * @return 流程查询form
	 */
	public IGAUT0101Form getIgaut0101From() {
		return igaut0101From;
	}

	/**
	 * 流程查询form设定
	 * @param igaut0101From 流程查询form
	 */
	public void setIgaut0101From(IGAUT0101Form igaut0101From) {
		this.igaut0101From = igaut0101From;
	}

	/**
	 * 表单定义查询条件map取得
	 * @return 表单定义查询条件map
	 */
	public Map<String, IG007Info> getProcessInfoQueryMap() {
		return processInfoQueryMap;
	}

	/**
	 * 表单定义查询条件map设定
	 * @param processInfoQueryMap 表单定义查询条件map
	 */
	public void setProcessInfoQueryMap(Map<String, IG007Info> processInfoQueryMap) {
		this.processInfoQueryMap = processInfoQueryMap;
	}

	/**
	 * 带有当前处理人的本月工作取得
	 * @return 带有当前处理人的本月工作
	 */
	public List<CurrentMonthWorkVWInfo> getCurrentManagerList() {
		return currentManagerList;
	}

	/**
	 * 带有当前处理人的本月工作设定
	 * @param currentManagerList 带有当前处理人的本月工作
	 */
	public void setCurrentManagerList(
			List<CurrentMonthWorkVWInfo> currentManagerList) {
		this.currentManagerList = currentManagerList;
	}
	
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}

	public void setIG333InfoList(List<IG333Info> iG333InfoList) {
		this.iG333InfoList = iG333InfoList;
	}

	/**
	 * iG333InfoList取得
	 * @return iG333InfoList iG333InfoList
	 */
	public List<IG333Info> getiG333InfoList() {
		return iG333InfoList;
	}

	/**
	 * iG333InfoList设定
	 * @param iG333InfoList iG333InfoList
	 */
	public void setiG333InfoList(List<IG333Info> iG333InfoList) {
		this.iG333InfoList = iG333InfoList;
	}
	
	/**
	 * 外部生产事件查询页面显示最大信息数取得
	 * @return 外部生产事件查询页面显示最大信息数
	 */
	public int getMaxCnt() {
		return maxCnt;
	}

	/**
	 * 外部生产事件查询页面显示最大信息数设定
	 * @param maxCnt 外部生产事件查询页面显示最大信息数
	 */
	public void setMaxCnt(int maxCnt) {
		this.maxCnt = maxCnt;
	}
	
	/**
	 * 外部生产事件查询页面分页对象取得
	 * @return 外部生产事件查询页面分页对象
	 */
	public PagingDTO getpDto() {
		return pDto;
	}

	/**
	 * 外部生产事件查询页面分页对象设定
	 * @param pDto 外部生产事件查询页面分页对象
	 */
	public void setpDto(PagingDTO pDto) {
		this.pDto = pDto;
	}
	
	/**
	 * 外部生产事件查询信息集合取得
	 * @return 外部生产事件查询信息集合
	 */
	public List<IG500Info> getScForOutList() {
		return scForOutList;
	}

	/**
	 * 外部生产事件查询信息集合设定
	 * @param scForOutList 外部生产事件查询信息集合
	 */
	public void setScForOutList(List<IG500Info> scForOutList) {
		this.scForOutList = scForOutList;
	}

	public List<LabelValueBean> getOrgList() {
		return orgList;
	}

	public void setOrgList(List<LabelValueBean> orgList) {
		this.orgList = orgList;
	}

	/**
	 * 自定义流程通用查询form取得
	 * @return igaut0110Form 自定义流程通用查询form
	 */
	public IGAUT0110Form getIgaut0110Form() {
		return igaut0110Form;
	}

	/**
	 * 自定义流程通用查询form设定
	 * @param igaut0110Form 自定义流程通用查询form
	 */
	public void setIgaut0110Form(IGAUT0110Form igaut0110Form) {
		this.igaut0110Form = igaut0110Form;
	}

	public IGAUT0102Form getIgaut0102From() {
		return igaut0102From;
	}

	public void setIgaut0102From(IGAUT0102Form igaut0102From) {
		this.igaut0102From = igaut0102From;
	}

	public IGAUT0103Form getIgaut0103From() {
		return igaut0103From;
	}

	public void setIgaut0103From(IGAUT0103Form igaut0103From) {
		this.igaut0103From = igaut0103From;
	}

	public IGAUT0104Form getIgaut0104From() {
		return igaut0104From;
	}

	public void setIgaut0104From(IGAUT0104Form igaut0104From) {
		this.igaut0104From = igaut0104From;
	}
	
}
