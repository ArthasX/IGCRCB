/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sym.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.Action;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.RoleAction;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserInfo;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.user.model.condition.RoleActionSearchCond;
import com.deliverik.framework.user.model.condition.RoleSearchCond;
import com.deliverik.framework.user.model.condition.UserInfoSearchCond;
import com.deliverik.framework.user.model.condition.UserRoleSearchCond;
import com.deliverik.framework.user.model.condition.UserRoleVWSearchCond;
import com.deliverik.framework.user.model.condition.UserSearchCond;
import com.deliverik.framework.workflow.prr.model.IG677Info;
import com.deliverik.infogovernor.sym.form.IGSYM0410Form;
import com.deliverik.infogovernor.sym.form.IGSYM0413Form;
import com.deliverik.infogovernor.sym.form.IGSYM0415Form;
import com.deliverik.infogovernor.sym.model.ReportFileDefinition;
import com.deliverik.infogovernor.sym.model.ReportFileVersion;
import com.deliverik.infogovernor.sym.model.RoleReport;
import com.deliverik.infogovernor.sym.model.UserNotRole;
import com.deliverik.infogovernor.sym.model.condition.ReportFileDefinitionSearchCond;
import com.deliverik.infogovernor.sym.model.condition.ReportFileVersionSearchCond;
import com.deliverik.infogovernor.sym.model.condition.RoleReportSearchCond;
import com.deliverik.infogovernor.sym.model.condition.UserNotRoleVWSearchCond;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 系统管理_授权管理_角色授权DTO
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
public class IGSYM04DTO extends BaseDTO implements Serializable {
	
	/**
	 * 角色负责人集合
	 */
	protected Map<UserRoleInfo,List<UserInfo>> managerMap;
	
	/**
	 * 角色集合
	 */
	protected Map<String,String> roleMap;
	
	/**
	 * 手机类型集合,0值班,1负责人
	 */
	protected Map<String,String> mobileMap;
	
	/**
	 * 用户对象
	 */
	
	protected User user;
	/**
	 * 用户查询Bean
	 */
	
	protected UserSearchCond userSearchCond;
	
	/**
	 * 用户对象List
	 */
	
	protected List<User> userList;

	/**
	 * 允许查询的最大记录数
	 */
	
	protected int maxSearchCount;

	/**
	 * 分页Bean
	 */
	
	protected PagingDTO pagingDto;
	
	/**
	 * 未授权角色对象List
	 */
	
	protected List<Role> roleList;
	
	/**
	 * 已授权角色对象List
	 */
	
	protected List<UserRoleInfo> ownRoleList;
	
	/**
	 * 角色查询Bean
	 */
	
	protected UserRoleSearchCond userRoleSearchCond;
	
	/**
	 * 角色查询Bean
	 */
	
	protected UserRoleVWSearchCond userRoleVWSearchCond;
	
	/**
	 * 已授权角色主键
	 */
	
	protected String[] urid;
	
	/**
	 * 未授权角色主键
	 */
	
	protected String[] roleids;
	
	/**
	 * 未授权报表主键
	 */
	
	protected String[] rfdids;
	
	/**
	 * 用户id
	 */
	
	protected String userid;
	
	/**
	 * 机构id
	 */
	
	protected String orgid;
	
	/**
	 * 角色对象
	 */
	
	protected Role role;
	
	protected UserInfoSearchCond userInfoSearchCond;
	
	/**
	 * 角色查询Bean
	 */
	
	protected RoleSearchCond roleSearchCond;
	
	
	/**
	 * 角色id
	 */
	
	protected Integer roleid;
	
	/**
	 * 菜单对象
	 */
	
	protected Action action;
	
	/**
	 * 菜单查询Bean
	 */
	
	protected RoleActionSearchCond roleActionSearchCond;
	
	/**
	 * 角色菜单对象List
	 */
	
	protected List<RoleAction> roleActionList;
	
	/**
	 * 菜单对象List
	 */
	
	protected List<Map<Action,List<Map<Action,List<Map<Action,List<Action>>>>>>> actionList;
	
	/**
	 * 授权菜单id
	 */
	
	protected String[] actionids;
	
	/**
	 * 角色菜单主键
	 */
	
	protected Integer raid;
	
	/**
	 * 菜单id
	 */
	
	protected Integer actid;
	
	/**
	 * Role对于Action的权限
	 */
	
	protected String raperm;
	
	/**
	 * Role对于Action的权限说明
	 */
	
	protected String radesc;
	
	/**
	 * 机构列表
	 */
	
	protected List<Organization> organizationList;
	
	/**
	 * 角色用户List
	 */
	
	protected List<UserInfo> roleUserList;
	
	
	protected String username;
	
	protected String orgname;
	
	protected String rolename;
	
	/** 报表版本信息检索条件 */
	protected ReportFileVersionSearchCond reportFileVersionSearchCond;
	
	/** 报表信息 */
	protected ReportFileDefinition reportFileDefinition;
	
	/** 报表版本信息检索结果集 */
	protected List<ReportFileVersion> reportFileVersionList;
	
	/** 用户信息集合 */
	protected List<UserInfo> userInfoList;
	
	/** 用户角色查询接口 */
	protected UserNotRoleVWSearchCond userNotRoleVWSearchCond;
	
	/** 用户信息集合 */
	protected List<UserNotRole> userNotRoleList;
	
	/**
	 * 报表版本信息检索条件取得
	 * @return 报表版本信息检索条件
	 */
	public ReportFileVersionSearchCond getReportFileVersionSearchCond() {
		return reportFileVersionSearchCond;
	}

	/**
	 * 报表版本信息检索条件设定
	 * @param reportFileVersionSearchCond 报表版本信息检索条件
	 */
	public void setReportFileVersionSearchCond(
			ReportFileVersionSearchCond reportFileVersionSearchCond) {
		this.reportFileVersionSearchCond = reportFileVersionSearchCond;
	}
	
	/**
	 * 报表ID
	 */
	protected Integer rfdid;
	
	/**
	 * 角色负责人map
	 */
	protected Map<Integer, UserInfo> userInfoMap;
	
	/** 报表信息检索条件 */
	protected ReportFileDefinitionSearchCond reportFileDefinitionSearchCond;
	
	/** 报表授权信息检索条件 */
	protected RoleReportSearchCond roleReportSearchCond;
	
	/** 报表信息检索结果集 */
	protected List<ReportFileDefinition> reportFileDefinitionList;
	
	/** 报表信息检索结果集 */
	protected List<ReportFileDefinition> ownReportFileDefinitionList;
	
	/** 报表信息Form */
	protected IGSYM0413Form igSYM0413Form;
	
	/** 报表信息Form */
	protected IGSYM0410Form igSYM0410Form;
	
	/** 报表信息Form */
	protected IGSYM0415Form igSYM0415Form;
	/**
	 * 获取报表授权信息
	 */
	protected List<RoleReport> roleReportList;
	
	protected List<IG677Info> processRecordInfoList;
	
	
	/**
	 * 报表授权信息检索结果集取得
	 * @return 报表授权信息检索结果集
	 */
	public List<RoleReport> getRoleReportList() {
		return roleReportList;
	}

	/**
	 * 报表授权信息检索结果集设定
	 * @param reportFileDefinitionList 报表授权信息检索结果集
	 */
	public void setRoleReportList(List<RoleReport> roleReportList) {
		this.roleReportList = roleReportList;
	}

	/**
	 * 报表信息检索结果集取得
	 * @return 报表信息检索结果集
	 */
	public List<ReportFileDefinition> getReportFileDefinitionList() {
		return reportFileDefinitionList;
	}

	/**
	 * 报表信息检索结果集设定
	 * @param reportFileDefinitionList 报表信息检索结果集
	 */
	public void setReportFileDefinitionList(
			List<ReportFileDefinition> reportFileDefinitionList) {
		this.reportFileDefinitionList = reportFileDefinitionList;
	}
	
	/**
	 * 报表信息检索条件取得
	 * @return 报表信息检索条件
	 */
	public ReportFileDefinitionSearchCond getReportFileDefinitionSearchCond() {
		return reportFileDefinitionSearchCond;
	}

	/**
	 * 报表信息检索条件设定
	 * @param reportFileDefinitionSearchCond 报表信息检索条件
	 */
	public void setReportFileDefinitionSearchCond(
			ReportFileDefinitionSearchCond reportFileDefinitionSearchCond) {
		this.reportFileDefinitionSearchCond = reportFileDefinitionSearchCond;
	}
	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getUsername() {
		return username;
	}

	public String getOrgname() {
		return orgname;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	/**
	 * 获取用户对象
	 * @return User
	 */
	
	public User getUser() {
		return user;
	}

	/**
	 * 设置用户对象
	 * @param user User
	 */
	
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * 获取用户查询Bean
	 * @return UserSearchCond
	 */
	
	public UserSearchCond getUserSearchCond() {
		return userSearchCond;
	}

	/**
	 * 设置用户查询Bean
	 * @param userSearchCond UserSearchCond
	 */
	
	public void setUserSearchCond(
			UserSearchCond userSearchCond) {
		this.userSearchCond = userSearchCond;
	}

	/**
	 * 获取用户对象List
	 * @return List<User>
	 */
	
	public List<User> getUserList() {
		return userList;
	}

	/**
	 * 设置用户对象List
	 * @param userList List<User>
	 */
	
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	
	/**
	 * 获取允许查询的最大记录数
	 * @return int
	 */
	
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * 设置允许查询的最大记录数
	 * @param maxSearchCount int
	 */
	
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * 获取分页Bean
	 * @return PagingDTO
	 */
	
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * 设置分页Bean
	 * @param pagingDto PagingDTO
	 */
	
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}
	
	/**
	 * 设置未授权角色对象List
	 * @param roleList List<Role>
	 */
	
	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}
	
	/**
	 * 获取未授权角色对象List
	 * @return List<Role>
	 */
	
	public List<Role> getRoleList() {
		return roleList;
	}
	
	/**
	 * 设置已授权角色对象List
	 * @param ownRoleList List<UserRoleInfo>
	 */
	
	public void setOwnRoleList(List<UserRoleInfo> ownRoleList) {
		this.ownRoleList = ownRoleList;
	}

	/**
	 * 获取已授权角色对象List
	 * @return List<UserRoleInfo>
	 */
	
	public List<UserRoleInfo> getOwnRoleList() {
		return ownRoleList;
	}
	
	/**
	 * 获取角色查询Bean
	 * @return UserRoleSearchCond
	 */
	
	public UserRoleSearchCond getUserRoleSearchCond() {
		return userRoleSearchCond;
	}

	/**
	 * 设置角色查询Bean
	 * @param userRoleSearchCond UserRoleSearchCond
	 */
	
	public void setUserRoleSearchCond(
			UserRoleSearchCond userRoleSearchCond) {
		this.userRoleSearchCond = userRoleSearchCond;
	}
	
	/**
	 * 获取角色查询Bean
	 * @return UserRoleVWSearchCond
	 */
	
	public UserRoleVWSearchCond getUserRoleVWSearchCond() {
		return userRoleVWSearchCond;
	}

	/**
	 * 设置角色查询Bean
	 * @param userRoleVWSearchCond UserRoleVWSearchCond
	 */
	
	public void setUserRoleVWSearchCond(
			UserRoleVWSearchCond userRoleVWSearchCond) {
		this.userRoleVWSearchCond = userRoleVWSearchCond;
	}
	
	/**
	 * 设置已授权角色主键
	 * @param urid String[]
	 */
	
	public void setUrid(String[] urid) {
		this.urid = urid;
	}
	
	/**
	 * 获取已授权角色主键
	 * @return String[]
	 */
	
	public String[] getUrid() {
		return urid;
	}
	

	/**
	 * 设置未授权角色主键
	 * @param roleids String[]
	 */
	
	public void setRoleids(String[] roleids) {
		this.roleids = roleids;
	}

	/**
	 * 获取已授权角色主键
	 * @return String[]
	 */
	
	public String[] getRoleids() {
		return roleids;
	}

	/**
	 * 获取用户id
	 * @return String
	 */
	
	public String getUserid() {
		return userid;
	}

	/**
	 * 获取用户id
	 * @return userid String
	 */
	
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * 获取机构id
	 * @return Integer
	 */
	
	public String getOrgid() {
		return orgid;
	}

	/**
	 * 获取机构id
	 * @return orgid Integer
	 */
	
	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}
	
	/**
	 * 获取角色对象
	 * @return Role
	 */
	
	public Role getRole() {
		return role;
	}

	/**
	 * 设置角色对象
	 * @param role Role
	 */
	
	public void setRole(Role role) {
		this.role = role;
	}

	/**
	 * 获取角色查询Bean
	 * @return RoleSearchCond
	 */
	
	public RoleSearchCond getRoleSearchCond() {
		return roleSearchCond;
	}

	/**
	 * 设置角色查询Bean
	 * @param roleSearchCond RoleSearchCond
	 */
	
	public void setRoleSearchCond(
			RoleSearchCond roleSearchCond) {
		this.roleSearchCond = roleSearchCond;
	}
	
	/**
	 * 获取角色id
	 * @return Integer
	 */
	
	public Integer getRoleid() {
		return roleid;
	}

	/**
	 * 设置角色id
	 * @param roleid Integer
	 */
	
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	/**
	 * 获取菜单对象
	 * @return Action
	 */
	
	public Action getAction() {
		return action;
	}

	/**
	 * 设置菜单对象
	 * @param action Action
	 */
	
	public void setAction(Action action) {
		this.action = action;
	}

	/**
	 * 获取菜单查询Bean
	 * @return RoleActionSearchCond
	 */
	
	public RoleActionSearchCond getRoleActionSearchCond() {
		return roleActionSearchCond;
	}

	/**
	 * 设置菜单查询Bean
	 * @param roleActionSearchCond RoleActionSearchCond
	 */
	
	public void setRoleActionSearchCond(
			RoleActionSearchCond roleActionSearchCond) {
		this.roleActionSearchCond = roleActionSearchCond;
	}

	/**
	 * 获取菜单对象List
	 * @return List<Map<Action,List<Map<Action,List<Map<Action,List<Action>>>>>>>
	 */
	
	public List<Map<Action,List<Map<Action,List<Map<Action,List<Action>>>>>>> getActionList() {
		return actionList;
	}

	/**
	 * 设置菜单对象List
	 * @param actionList List<Map<Action,List<Map<Action,List<Map<Action,List<Action>>>>>>>
	 */
	
	public void setActionList(List<Map<Action,List<Map<Action,List<Map<Action,List<Action>>>>>>> actionList) {
		this.actionList = actionList;
	}

	/**
	 * 获取授权菜单id
	 * @return String[]
	 */
	
	public String[] getActionids() {
		return actionids;
	}

	/**
	 * 设置授权菜单id
	 * @param actionids String[]
	 */
	
	
	public void setActionids(String[] actionids) {
		this.actionids = actionids;
	}

	/**
	 * 获取角色菜单对象List
	 * @return List<RoleAction>
	 */
	
	public List<RoleAction> getRoleActionList() {
		return roleActionList;
	}

	/**
	 * 设置角色菜单对象List
	 * @param roleAction List<RoleAction>
	 */
	
	public void setRoleActionList(List<RoleAction> roleActionList) {
		this.roleActionList = roleActionList;
	}

	/**
	 * 获取角色菜单主键
	 * @return Integer
	 */
	
	public Integer getRaid() {
		return raid;
	}

	/**
	 * 设置角色菜单主键
	 * @param raid Integer
	 */
	
	public void setRaid(Integer raid) {
		this.raid = raid;
	}

	/**
	 * 获取菜单id
	 * @return Integer
	 */
	
	public Integer getActid() {
		return actid;
	}
	
	/**
	 * 设置菜单id
	 * @param actid Integer
	 */
	
	public void setActid(Integer actid) {
		this.actid = actid;
	}

	/**
	 * 获取Role对于Action的权限
	 * @return String
	 */
	
	public String getRaperm() {
		return raperm;
	}

	/**
	 * 设置Role对于Action的权限
	 * @param radesc String
	 */
	
	public void setRaperm(String raperm) {
		this.raperm = raperm;
	}

	/**
	 * 获取Role对于Action的权限说明
	 * @return String
	 */
	
	public String getRadesc() {
		return radesc;
	}

	/**
	 * 设置Role对于Action的权限说明
	 * @param radesc String
	 */
	
	public void setRadesc(String radesc) {
		this.radesc = radesc;
	}

	/**
	 * 获取机构列表
	 * @return List<Organization>
	 */
	
	public List<Organization> getOrganizationList() {
		return organizationList;
	}

	/**
	 * 设置机构列表
	 * @param organizationList List<Organization>
	 */
	
	public void setOrganizationList(List<Organization> organizationList) {
		this.organizationList = organizationList;
	}

	public UserInfoSearchCond getUserInfoSearchCond() {
		return userInfoSearchCond;
	}

	public void setUserInfoSearchCond(UserInfoSearchCond userInfoSearchCond) {
		this.userInfoSearchCond = userInfoSearchCond;
	}
	
	
	public void setRoleUserList(List<UserInfo> roleUserList) {
		this.roleUserList = roleUserList;
	}

	/**
	 * 获取角色用户
	 * @return List<UserInfo>
	 */
	
	public List<UserInfo> getRoleUserList() {
		return roleUserList;
	}

	/**
	 * 获取角色负责人map
	 * @return Map<Integer, UserInfo>
	 */
	public Map<Integer, UserInfo> getUserInfoMap() {
		return userInfoMap;
	}

	/**
	 * 设置角色负责人map
	 * @param userInfoMap Map<Integer, UserInfo>
	 */
	public void setUserInfoMap(Map<Integer, UserInfo> userInfoMap) {
		this.userInfoMap = userInfoMap;
	}

	/**
	 * 获取角色负责人集合
	 * @return Map<UserRoleInfo, List<UserInfo>>
	 */
	public Map<UserRoleInfo, List<UserInfo>> getManagerMap() {
		return managerMap;
	}

	/**
	 * 设置角色负责人集合
	 * @param managerMap Map<UserRoleInfo, List<UserInfo>>
	 */
	public void setManagerMap(Map<UserRoleInfo, List<UserInfo>> managerMap) {
		this.managerMap = managerMap;
	}

	/**
	 * 获取角色集合
	 * @return Map<String,String>
	 */
	public Map<String,String> getRoleMap() {
		return roleMap;
	}

	/**
	 * 设置角色集合
	 * @param roleMap Map<String,String>
	 */
	public void setRoleMap(Map<String,String> roleMap) {
		this.roleMap = roleMap;
	}

	/**
	 * 获取手机类型集合
	 * @return Map<String,String>
	 */
	public Map<String,String> getMobileMap() {
		return mobileMap;
	}

	/**
	 * 设置手机类型集合
	 * @param mobileMap Map<String,String>
	 */
	public void setMobileMap(Map<String,String> mobileMap) {
		this.mobileMap = mobileMap;
	}

	public IGSYM0413Form getIgSYM0413Form() {
		return igSYM0413Form;
	}

	public void setIgSYM0413Form(IGSYM0413Form igSYM0413Form) {
		this.igSYM0413Form = igSYM0413Form;
	}

	public RoleReportSearchCond getRoleReportSearchCond() {
		return roleReportSearchCond;
	}

	public void setRoleReportSearchCond(RoleReportSearchCond roleReportSearchCond) {
		this.roleReportSearchCond = roleReportSearchCond;
	}

	public IGSYM0410Form getIgSYM0410Form() {
		return igSYM0410Form;
	}

	public void setIgSYM0410Form(IGSYM0410Form igSYM0410Form) {
		this.igSYM0410Form = igSYM0410Form;
	}

	public Integer getRfdid() {
		return rfdid;
	}

	public void setRfdid(Integer rfdid) {
		this.rfdid = rfdid;
	}

	/**
	 * 报表信息取得
	 * @return 报表信息
	 */
	public ReportFileDefinition getReportFileDefinition() {
		return reportFileDefinition;
	}

	/**
	 * 报表信息设定
	 * @param reportFileDefinition 报表信息
	 */
	public void setReportFileDefinition(ReportFileDefinition reportFileDefinition) {
		this.reportFileDefinition = reportFileDefinition;
	}
	
	/**
	 * 报表版本信息检索结果集取得
	 * @return 报表版本信息检索结果集
	 */
	public List<ReportFileVersion> getReportFileVersionList() {
		return reportFileVersionList;
	}

	/**
	 * 报表版本信息检索结果集设定
	 * @param reportFileVersionList 报表版本信息检索结果集
	 */
	public void setReportFileVersionList(
			List<ReportFileVersion> reportFileVersionList) {
		this.reportFileVersionList = reportFileVersionList;
	}

	public IGSYM0415Form getIgSYM0415Form() {
		return igSYM0415Form;
	}

	public void setIgSYM0415Form(IGSYM0415Form igSYM0415Form) {
		this.igSYM0415Form = igSYM0415Form;
	}

	public List<ReportFileDefinition> getOwnReportFileDefinitionList() {
		return ownReportFileDefinitionList;
	}

	public void setOwnReportFileDefinitionList(
			List<ReportFileDefinition> ownReportFileDefinitionList) {
		this.ownReportFileDefinitionList = ownReportFileDefinitionList;
	}

	public String[] getRfdids() {
		return rfdids;
	}

	public void setRfdids(String[] rfdids) {
		this.rfdids = rfdids;
	}

	public List<IG677Info> getProcessRecordInfoList() {
		return processRecordInfoList;
	}

	public void setProcessRecordInfoList(
			List<IG677Info> processRecordInfoList) {
		this.processRecordInfoList = processRecordInfoList;
	}

	/**
	 * 用户信息集合取得
	 * 
	 * @return 用户信息集合
	 */
	public List<UserInfo> getUserInfoList() {
		return userInfoList;
	}

	/**
	 * 用户信息集合设定
	 * 
	 * @param userInfoList 用户信息集合
	 */
	public void setUserInfoList(List<UserInfo> userInfoList) {
		this.userInfoList = userInfoList;
	}

	/**
	 * 用户角色查询接口取得
	 * 
	 * @return 用户角色查询接口
	 */
	public UserNotRoleVWSearchCond getUserNotRoleVWSearchCond() {
		return userNotRoleVWSearchCond;
	}

	/**
	 * 用户角色查询接口设定
	 * 
	 * @param userNotRoleVWSearchCond 用户角色查询接口
	 */
	public void setUserNotRoleVWSearchCond(
			UserNotRoleVWSearchCond userNotRoleVWSearchCond) {
		this.userNotRoleVWSearchCond = userNotRoleVWSearchCond;
	}

	/**
	 * 用户信息集合取得
	 * 
	 * @return 用户信息集合
	 */
	public List<UserNotRole> getUserNotRoleList() {
		return userNotRoleList;
	}

	/**
	 * 用户信息集合设定
	 * 
	 * @param userNotRoleList 用户信息集合
	 */
	public void setUserNotRoleList(List<UserNotRole> userNotRoleList) {
		this.userNotRoleList = userNotRoleList;
	}
	
}
