/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ϵͳ����_��Ȩ����_��ɫ��ȨDTO
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
	 * ��ɫ�����˼���
	 */
	protected Map<UserRoleInfo,List<UserInfo>> managerMap;
	
	/**
	 * ��ɫ����
	 */
	protected Map<String,String> roleMap;
	
	/**
	 * �ֻ����ͼ���,0ֵ��,1������
	 */
	protected Map<String,String> mobileMap;
	
	/**
	 * �û�����
	 */
	
	protected User user;
	/**
	 * �û���ѯBean
	 */
	
	protected UserSearchCond userSearchCond;
	
	/**
	 * �û�����List
	 */
	
	protected List<User> userList;

	/**
	 * �����ѯ������¼��
	 */
	
	protected int maxSearchCount;

	/**
	 * ��ҳBean
	 */
	
	protected PagingDTO pagingDto;
	
	/**
	 * δ��Ȩ��ɫ����List
	 */
	
	protected List<Role> roleList;
	
	/**
	 * ����Ȩ��ɫ����List
	 */
	
	protected List<UserRoleInfo> ownRoleList;
	
	/**
	 * ��ɫ��ѯBean
	 */
	
	protected UserRoleSearchCond userRoleSearchCond;
	
	/**
	 * ��ɫ��ѯBean
	 */
	
	protected UserRoleVWSearchCond userRoleVWSearchCond;
	
	/**
	 * ����Ȩ��ɫ����
	 */
	
	protected String[] urid;
	
	/**
	 * δ��Ȩ��ɫ����
	 */
	
	protected String[] roleids;
	
	/**
	 * δ��Ȩ��������
	 */
	
	protected String[] rfdids;
	
	/**
	 * �û�id
	 */
	
	protected String userid;
	
	/**
	 * ����id
	 */
	
	protected String orgid;
	
	/**
	 * ��ɫ����
	 */
	
	protected Role role;
	
	protected UserInfoSearchCond userInfoSearchCond;
	
	/**
	 * ��ɫ��ѯBean
	 */
	
	protected RoleSearchCond roleSearchCond;
	
	
	/**
	 * ��ɫid
	 */
	
	protected Integer roleid;
	
	/**
	 * �˵�����
	 */
	
	protected Action action;
	
	/**
	 * �˵���ѯBean
	 */
	
	protected RoleActionSearchCond roleActionSearchCond;
	
	/**
	 * ��ɫ�˵�����List
	 */
	
	protected List<RoleAction> roleActionList;
	
	/**
	 * �˵�����List
	 */
	
	protected List<Map<Action,List<Map<Action,List<Map<Action,List<Action>>>>>>> actionList;
	
	/**
	 * ��Ȩ�˵�id
	 */
	
	protected String[] actionids;
	
	/**
	 * ��ɫ�˵�����
	 */
	
	protected Integer raid;
	
	/**
	 * �˵�id
	 */
	
	protected Integer actid;
	
	/**
	 * Role����Action��Ȩ��
	 */
	
	protected String raperm;
	
	/**
	 * Role����Action��Ȩ��˵��
	 */
	
	protected String radesc;
	
	/**
	 * �����б�
	 */
	
	protected List<Organization> organizationList;
	
	/**
	 * ��ɫ�û�List
	 */
	
	protected List<UserInfo> roleUserList;
	
	
	protected String username;
	
	protected String orgname;
	
	protected String rolename;
	
	/** ����汾��Ϣ�������� */
	protected ReportFileVersionSearchCond reportFileVersionSearchCond;
	
	/** ������Ϣ */
	protected ReportFileDefinition reportFileDefinition;
	
	/** ����汾��Ϣ��������� */
	protected List<ReportFileVersion> reportFileVersionList;
	
	/** �û���Ϣ���� */
	protected List<UserInfo> userInfoList;
	
	/** �û���ɫ��ѯ�ӿ� */
	protected UserNotRoleVWSearchCond userNotRoleVWSearchCond;
	
	/** �û���Ϣ���� */
	protected List<UserNotRole> userNotRoleList;
	
	/**
	 * ����汾��Ϣ��������ȡ��
	 * @return ����汾��Ϣ��������
	 */
	public ReportFileVersionSearchCond getReportFileVersionSearchCond() {
		return reportFileVersionSearchCond;
	}

	/**
	 * ����汾��Ϣ���������趨
	 * @param reportFileVersionSearchCond ����汾��Ϣ��������
	 */
	public void setReportFileVersionSearchCond(
			ReportFileVersionSearchCond reportFileVersionSearchCond) {
		this.reportFileVersionSearchCond = reportFileVersionSearchCond;
	}
	
	/**
	 * ����ID
	 */
	protected Integer rfdid;
	
	/**
	 * ��ɫ������map
	 */
	protected Map<Integer, UserInfo> userInfoMap;
	
	/** ������Ϣ�������� */
	protected ReportFileDefinitionSearchCond reportFileDefinitionSearchCond;
	
	/** ������Ȩ��Ϣ�������� */
	protected RoleReportSearchCond roleReportSearchCond;
	
	/** ������Ϣ��������� */
	protected List<ReportFileDefinition> reportFileDefinitionList;
	
	/** ������Ϣ��������� */
	protected List<ReportFileDefinition> ownReportFileDefinitionList;
	
	/** ������ϢForm */
	protected IGSYM0413Form igSYM0413Form;
	
	/** ������ϢForm */
	protected IGSYM0410Form igSYM0410Form;
	
	/** ������ϢForm */
	protected IGSYM0415Form igSYM0415Form;
	/**
	 * ��ȡ������Ȩ��Ϣ
	 */
	protected List<RoleReport> roleReportList;
	
	protected List<IG677Info> processRecordInfoList;
	
	
	/**
	 * ������Ȩ��Ϣ���������ȡ��
	 * @return ������Ȩ��Ϣ���������
	 */
	public List<RoleReport> getRoleReportList() {
		return roleReportList;
	}

	/**
	 * ������Ȩ��Ϣ����������趨
	 * @param reportFileDefinitionList ������Ȩ��Ϣ���������
	 */
	public void setRoleReportList(List<RoleReport> roleReportList) {
		this.roleReportList = roleReportList;
	}

	/**
	 * ������Ϣ���������ȡ��
	 * @return ������Ϣ���������
	 */
	public List<ReportFileDefinition> getReportFileDefinitionList() {
		return reportFileDefinitionList;
	}

	/**
	 * ������Ϣ����������趨
	 * @param reportFileDefinitionList ������Ϣ���������
	 */
	public void setReportFileDefinitionList(
			List<ReportFileDefinition> reportFileDefinitionList) {
		this.reportFileDefinitionList = reportFileDefinitionList;
	}
	
	/**
	 * ������Ϣ��������ȡ��
	 * @return ������Ϣ��������
	 */
	public ReportFileDefinitionSearchCond getReportFileDefinitionSearchCond() {
		return reportFileDefinitionSearchCond;
	}

	/**
	 * ������Ϣ���������趨
	 * @param reportFileDefinitionSearchCond ������Ϣ��������
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
	 * ��ȡ�û�����
	 * @return User
	 */
	
	public User getUser() {
		return user;
	}

	/**
	 * �����û�����
	 * @param user User
	 */
	
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * ��ȡ�û���ѯBean
	 * @return UserSearchCond
	 */
	
	public UserSearchCond getUserSearchCond() {
		return userSearchCond;
	}

	/**
	 * �����û���ѯBean
	 * @param userSearchCond UserSearchCond
	 */
	
	public void setUserSearchCond(
			UserSearchCond userSearchCond) {
		this.userSearchCond = userSearchCond;
	}

	/**
	 * ��ȡ�û�����List
	 * @return List<User>
	 */
	
	public List<User> getUserList() {
		return userList;
	}

	/**
	 * �����û�����List
	 * @param userList List<User>
	 */
	
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	
	/**
	 * ��ȡ�����ѯ������¼��
	 * @return int
	 */
	
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * ���������ѯ������¼��
	 * @param maxSearchCount int
	 */
	
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * ��ȡ��ҳBean
	 * @return PagingDTO
	 */
	
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * ���÷�ҳBean
	 * @param pagingDto PagingDTO
	 */
	
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}
	
	/**
	 * ����δ��Ȩ��ɫ����List
	 * @param roleList List<Role>
	 */
	
	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}
	
	/**
	 * ��ȡδ��Ȩ��ɫ����List
	 * @return List<Role>
	 */
	
	public List<Role> getRoleList() {
		return roleList;
	}
	
	/**
	 * ��������Ȩ��ɫ����List
	 * @param ownRoleList List<UserRoleInfo>
	 */
	
	public void setOwnRoleList(List<UserRoleInfo> ownRoleList) {
		this.ownRoleList = ownRoleList;
	}

	/**
	 * ��ȡ����Ȩ��ɫ����List
	 * @return List<UserRoleInfo>
	 */
	
	public List<UserRoleInfo> getOwnRoleList() {
		return ownRoleList;
	}
	
	/**
	 * ��ȡ��ɫ��ѯBean
	 * @return UserRoleSearchCond
	 */
	
	public UserRoleSearchCond getUserRoleSearchCond() {
		return userRoleSearchCond;
	}

	/**
	 * ���ý�ɫ��ѯBean
	 * @param userRoleSearchCond UserRoleSearchCond
	 */
	
	public void setUserRoleSearchCond(
			UserRoleSearchCond userRoleSearchCond) {
		this.userRoleSearchCond = userRoleSearchCond;
	}
	
	/**
	 * ��ȡ��ɫ��ѯBean
	 * @return UserRoleVWSearchCond
	 */
	
	public UserRoleVWSearchCond getUserRoleVWSearchCond() {
		return userRoleVWSearchCond;
	}

	/**
	 * ���ý�ɫ��ѯBean
	 * @param userRoleVWSearchCond UserRoleVWSearchCond
	 */
	
	public void setUserRoleVWSearchCond(
			UserRoleVWSearchCond userRoleVWSearchCond) {
		this.userRoleVWSearchCond = userRoleVWSearchCond;
	}
	
	/**
	 * ��������Ȩ��ɫ����
	 * @param urid String[]
	 */
	
	public void setUrid(String[] urid) {
		this.urid = urid;
	}
	
	/**
	 * ��ȡ����Ȩ��ɫ����
	 * @return String[]
	 */
	
	public String[] getUrid() {
		return urid;
	}
	

	/**
	 * ����δ��Ȩ��ɫ����
	 * @param roleids String[]
	 */
	
	public void setRoleids(String[] roleids) {
		this.roleids = roleids;
	}

	/**
	 * ��ȡ����Ȩ��ɫ����
	 * @return String[]
	 */
	
	public String[] getRoleids() {
		return roleids;
	}

	/**
	 * ��ȡ�û�id
	 * @return String
	 */
	
	public String getUserid() {
		return userid;
	}

	/**
	 * ��ȡ�û�id
	 * @return userid String
	 */
	
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * ��ȡ����id
	 * @return Integer
	 */
	
	public String getOrgid() {
		return orgid;
	}

	/**
	 * ��ȡ����id
	 * @return orgid Integer
	 */
	
	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}
	
	/**
	 * ��ȡ��ɫ����
	 * @return Role
	 */
	
	public Role getRole() {
		return role;
	}

	/**
	 * ���ý�ɫ����
	 * @param role Role
	 */
	
	public void setRole(Role role) {
		this.role = role;
	}

	/**
	 * ��ȡ��ɫ��ѯBean
	 * @return RoleSearchCond
	 */
	
	public RoleSearchCond getRoleSearchCond() {
		return roleSearchCond;
	}

	/**
	 * ���ý�ɫ��ѯBean
	 * @param roleSearchCond RoleSearchCond
	 */
	
	public void setRoleSearchCond(
			RoleSearchCond roleSearchCond) {
		this.roleSearchCond = roleSearchCond;
	}
	
	/**
	 * ��ȡ��ɫid
	 * @return Integer
	 */
	
	public Integer getRoleid() {
		return roleid;
	}

	/**
	 * ���ý�ɫid
	 * @param roleid Integer
	 */
	
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	/**
	 * ��ȡ�˵�����
	 * @return Action
	 */
	
	public Action getAction() {
		return action;
	}

	/**
	 * ���ò˵�����
	 * @param action Action
	 */
	
	public void setAction(Action action) {
		this.action = action;
	}

	/**
	 * ��ȡ�˵���ѯBean
	 * @return RoleActionSearchCond
	 */
	
	public RoleActionSearchCond getRoleActionSearchCond() {
		return roleActionSearchCond;
	}

	/**
	 * ���ò˵���ѯBean
	 * @param roleActionSearchCond RoleActionSearchCond
	 */
	
	public void setRoleActionSearchCond(
			RoleActionSearchCond roleActionSearchCond) {
		this.roleActionSearchCond = roleActionSearchCond;
	}

	/**
	 * ��ȡ�˵�����List
	 * @return List<Map<Action,List<Map<Action,List<Map<Action,List<Action>>>>>>>
	 */
	
	public List<Map<Action,List<Map<Action,List<Map<Action,List<Action>>>>>>> getActionList() {
		return actionList;
	}

	/**
	 * ���ò˵�����List
	 * @param actionList List<Map<Action,List<Map<Action,List<Map<Action,List<Action>>>>>>>
	 */
	
	public void setActionList(List<Map<Action,List<Map<Action,List<Map<Action,List<Action>>>>>>> actionList) {
		this.actionList = actionList;
	}

	/**
	 * ��ȡ��Ȩ�˵�id
	 * @return String[]
	 */
	
	public String[] getActionids() {
		return actionids;
	}

	/**
	 * ������Ȩ�˵�id
	 * @param actionids String[]
	 */
	
	
	public void setActionids(String[] actionids) {
		this.actionids = actionids;
	}

	/**
	 * ��ȡ��ɫ�˵�����List
	 * @return List<RoleAction>
	 */
	
	public List<RoleAction> getRoleActionList() {
		return roleActionList;
	}

	/**
	 * ���ý�ɫ�˵�����List
	 * @param roleAction List<RoleAction>
	 */
	
	public void setRoleActionList(List<RoleAction> roleActionList) {
		this.roleActionList = roleActionList;
	}

	/**
	 * ��ȡ��ɫ�˵�����
	 * @return Integer
	 */
	
	public Integer getRaid() {
		return raid;
	}

	/**
	 * ���ý�ɫ�˵�����
	 * @param raid Integer
	 */
	
	public void setRaid(Integer raid) {
		this.raid = raid;
	}

	/**
	 * ��ȡ�˵�id
	 * @return Integer
	 */
	
	public Integer getActid() {
		return actid;
	}
	
	/**
	 * ���ò˵�id
	 * @param actid Integer
	 */
	
	public void setActid(Integer actid) {
		this.actid = actid;
	}

	/**
	 * ��ȡRole����Action��Ȩ��
	 * @return String
	 */
	
	public String getRaperm() {
		return raperm;
	}

	/**
	 * ����Role����Action��Ȩ��
	 * @param radesc String
	 */
	
	public void setRaperm(String raperm) {
		this.raperm = raperm;
	}

	/**
	 * ��ȡRole����Action��Ȩ��˵��
	 * @return String
	 */
	
	public String getRadesc() {
		return radesc;
	}

	/**
	 * ����Role����Action��Ȩ��˵��
	 * @param radesc String
	 */
	
	public void setRadesc(String radesc) {
		this.radesc = radesc;
	}

	/**
	 * ��ȡ�����б�
	 * @return List<Organization>
	 */
	
	public List<Organization> getOrganizationList() {
		return organizationList;
	}

	/**
	 * ���û����б�
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
	 * ��ȡ��ɫ�û�
	 * @return List<UserInfo>
	 */
	
	public List<UserInfo> getRoleUserList() {
		return roleUserList;
	}

	/**
	 * ��ȡ��ɫ������map
	 * @return Map<Integer, UserInfo>
	 */
	public Map<Integer, UserInfo> getUserInfoMap() {
		return userInfoMap;
	}

	/**
	 * ���ý�ɫ������map
	 * @param userInfoMap Map<Integer, UserInfo>
	 */
	public void setUserInfoMap(Map<Integer, UserInfo> userInfoMap) {
		this.userInfoMap = userInfoMap;
	}

	/**
	 * ��ȡ��ɫ�����˼���
	 * @return Map<UserRoleInfo, List<UserInfo>>
	 */
	public Map<UserRoleInfo, List<UserInfo>> getManagerMap() {
		return managerMap;
	}

	/**
	 * ���ý�ɫ�����˼���
	 * @param managerMap Map<UserRoleInfo, List<UserInfo>>
	 */
	public void setManagerMap(Map<UserRoleInfo, List<UserInfo>> managerMap) {
		this.managerMap = managerMap;
	}

	/**
	 * ��ȡ��ɫ����
	 * @return Map<String,String>
	 */
	public Map<String,String> getRoleMap() {
		return roleMap;
	}

	/**
	 * ���ý�ɫ����
	 * @param roleMap Map<String,String>
	 */
	public void setRoleMap(Map<String,String> roleMap) {
		this.roleMap = roleMap;
	}

	/**
	 * ��ȡ�ֻ����ͼ���
	 * @return Map<String,String>
	 */
	public Map<String,String> getMobileMap() {
		return mobileMap;
	}

	/**
	 * �����ֻ����ͼ���
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
	 * ������Ϣȡ��
	 * @return ������Ϣ
	 */
	public ReportFileDefinition getReportFileDefinition() {
		return reportFileDefinition;
	}

	/**
	 * ������Ϣ�趨
	 * @param reportFileDefinition ������Ϣ
	 */
	public void setReportFileDefinition(ReportFileDefinition reportFileDefinition) {
		this.reportFileDefinition = reportFileDefinition;
	}
	
	/**
	 * ����汾��Ϣ���������ȡ��
	 * @return ����汾��Ϣ���������
	 */
	public List<ReportFileVersion> getReportFileVersionList() {
		return reportFileVersionList;
	}

	/**
	 * ����汾��Ϣ����������趨
	 * @param reportFileVersionList ����汾��Ϣ���������
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
	 * �û���Ϣ����ȡ��
	 * 
	 * @return �û���Ϣ����
	 */
	public List<UserInfo> getUserInfoList() {
		return userInfoList;
	}

	/**
	 * �û���Ϣ�����趨
	 * 
	 * @param userInfoList �û���Ϣ����
	 */
	public void setUserInfoList(List<UserInfo> userInfoList) {
		this.userInfoList = userInfoList;
	}

	/**
	 * �û���ɫ��ѯ�ӿ�ȡ��
	 * 
	 * @return �û���ɫ��ѯ�ӿ�
	 */
	public UserNotRoleVWSearchCond getUserNotRoleVWSearchCond() {
		return userNotRoleVWSearchCond;
	}

	/**
	 * �û���ɫ��ѯ�ӿ��趨
	 * 
	 * @param userNotRoleVWSearchCond �û���ɫ��ѯ�ӿ�
	 */
	public void setUserNotRoleVWSearchCond(
			UserNotRoleVWSearchCond userNotRoleVWSearchCond) {
		this.userNotRoleVWSearchCond = userNotRoleVWSearchCond;
	}

	/**
	 * �û���Ϣ����ȡ��
	 * 
	 * @return �û���Ϣ����
	 */
	public List<UserNotRole> getUserNotRoleList() {
		return userNotRoleList;
	}

	/**
	 * �û���Ϣ�����趨
	 * 
	 * @param userNotRoleList �û���Ϣ����
	 */
	public void setUserNotRoleList(List<UserNotRole> userNotRoleList) {
		this.userNotRoleList = userNotRoleList;
	}
	
}
