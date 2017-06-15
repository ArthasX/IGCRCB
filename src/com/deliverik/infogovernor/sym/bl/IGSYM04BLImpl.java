/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sym.bl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;
import org.hyperic.hq.hqapi1.HQApi;
import org.hyperic.hq.hqapi1.RoleApi;
import org.hyperic.hq.hqapi1.UserApi;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.user.bl.task.ActionBL;
import com.deliverik.framework.user.bl.task.OrganizationBL;
import com.deliverik.framework.user.bl.task.RoleActionBL;
import com.deliverik.framework.user.bl.task.RoleBL;
import com.deliverik.framework.user.bl.task.UserBL;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.Action;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.RoleAction;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserInfo;
import com.deliverik.framework.user.model.UserRole;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.user.model.condition.ActionSearchCondImpl;
import com.deliverik.framework.user.model.condition.OrganizationSearchCondImpl;
import com.deliverik.framework.user.model.condition.RoleActionSearchCondImpl;
import com.deliverik.framework.user.model.condition.RoleSearchCond;
import com.deliverik.framework.user.model.condition.RoleSearchCondImpl;
import com.deliverik.framework.user.model.condition.UserInfoSearchCondImpl;
import com.deliverik.framework.user.model.condition.UserRoleSearchCondImpl;
import com.deliverik.framework.user.model.condition.UserSearchCondImpl;
import com.deliverik.framework.user.model.entity.RoleActionTB;
import com.deliverik.framework.user.model.entity.UserRoleTB;
import com.deliverik.framework.utility.CodeListUtils;
import com.deliverik.framework.workflow.WorkFlowConstDefine;
import com.deliverik.framework.workflow.prr.bl.task.IG500BL;
import com.deliverik.framework.workflow.prr.model.IG677Info;
import com.deliverik.framework.workflow.prr.model.condition.IG677SearchCondImpl;
import com.deliverik.infogovernor.sym.bl.task.ReportFileDefinitionBL;
import com.deliverik.infogovernor.sym.bl.task.ReportFileVersionBL;
import com.deliverik.infogovernor.sym.bl.task.RoleReportBL;
import com.deliverik.infogovernor.sym.bl.task.UserNotRoleBL;
import com.deliverik.infogovernor.sym.dto.IGSYM04DTO;
import com.deliverik.infogovernor.sym.form.IGSYM0410Form;
import com.deliverik.infogovernor.sym.form.IGSYM0413Form;
import com.deliverik.infogovernor.sym.form.IGSYM0415Form;
import com.deliverik.infogovernor.sym.model.ReportFileDefinition;
import com.deliverik.infogovernor.sym.model.ReportFileVersion;
import com.deliverik.infogovernor.sym.model.RoleReport;
import com.deliverik.infogovernor.sym.model.UserNotRole;
import com.deliverik.infogovernor.sym.model.condition.RoleReportSearchCondImpl;
import com.deliverik.infogovernor.sym.model.entity.RoleReportTB;
import com.deliverik.infogovernor.util.StringEncrypt;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 系统管理_授权管理_角色授权LIMPL
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 * @update zhaojun 2010-12-13
 */

public class IGSYM04BLImpl extends BaseBLImpl implements IGSYM04BL {

	static Log log = LogFactory.getLog(IGSYM04BLImpl.class);
	
	/**
	 * 注入UserBL
	 */
	protected UserBL userBL;
	
	/**
	 * 注入processRecordBL
	 */
	protected IG500BL ig500BL;
	
	/**
	 * 注入userNotRoleBL
	 */
	protected UserNotRoleBL userNotRoleBL;
	
	public void setIg500BL(IG500BL ig500BL) {
		this.ig500BL = ig500BL;
	}

	/**
	 * 设置UserBL
	 * @param userBL UserBL
	 */
	
	public void setUserBL(UserBL userBL) {
		this.userBL = userBL;
	}
	
/** 报表版本信息BL */
	protected ReportFileVersionBL reportFileVersionBL;
	
	
	
	public void setReportFileVersionBL(ReportFileVersionBL reportFileVersionBL) {
		this.reportFileVersionBL = reportFileVersionBL;
	}

	/** 报表信息BL */
	protected ReportFileDefinitionBL reportFileDefinitionBL;
	
	/** 报表信息BL */
	protected RoleReportBL roleReportBL;
	
	
	/**
	 * 设置ReportFileDefinitionBL
	 * @param reportFileDefinitionBL ReportFileDefinitionBL
	 */
	
	public void setReportFileDefinitionBL(
			ReportFileDefinitionBL reportFileDefinitionBL) {
		this.reportFileDefinitionBL = reportFileDefinitionBL;
	}
	/**
	 * 注入RoleBL
	 */
	protected RoleBL roleBL;
	
	/**
	 * 设置RoleBL
	 * @param roleBL RoleBL
	 */
	
	public void setRoleBL(RoleBL roleBL) {
		this.roleBL = roleBL;
	}
	
	/**
	 * 注入ActionBL
	 */
	protected ActionBL actionBL;
	
	/**
	 * 设置ActionBL
	 * @param actionBL ActionBL
	 */
	
	public void setActionBL(ActionBL actionBL) {
		this.actionBL = actionBL;
	}
	
	/**
	 * 注入RoleActionBL
	 */
	protected RoleActionBL roleActionBL;
	
	/**
	 * 设置RoleActionBL
	 * @param roleActionBL RoleActionBL
	 */
	
	public void setRoleActionBL(RoleActionBL roleActionBL) {
		this.roleActionBL = roleActionBL;
	}
	/**
	 * 注入UserRoleBL
	 */
	protected UserRoleBL userRoleBL;
	
	/**
	 * 设置UserRoleBL
	 * @param userRoleBL UserRoleBL
	 */
	
	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}
	
	/**
	 * 机构BL
	 */
	protected OrganizationBL organizationBL;
	
	/**
	 * 设置机构BL
	 * @param organizationBL OrganizationBL
	 */

	public void setOrganizationBL(OrganizationBL organizationBL) {
		this.organizationBL = organizationBL;
	}

	/**
	 * 设置RoleReportBL
	 * @param RoleReportBL roleReportBL
	 */
	
	public void setRoleReportBL(RoleReportBL roleReportBL) {
		this.roleReportBL = roleReportBL;
	}
	
	/**
	 * 设置userNotRoleBL
	 * 
	 * @param userNotRoleBL UserNotRoleBL
	 */
	public void setUserNotRoleBL(UserNotRoleBL userNotRoleBL) {
		this.userNotRoleBL = userNotRoleBL;
	}

	/**
	 * <p>
	 * Description: 用户查询
	 * </p>
	 * 
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM04DTO searchUserAction(IGSYM04DTO dto)
			throws BLException {
		log.debug("========用户查询处理开始========");
		// 查询记录总数
		int totalCount = userBL.getUserSearchCount(dto
				.getUserSearchCond());
		if (totalCount == 0) {
			log.debug("========查询数据不存在========");
			// 查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========查询数据件数过多========");
			// 查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}
		//获取分页bean
		PagingDTO pDto = dto.getPagingDto();
		//调用DAO接口查询
		List<User> userList = userBL.searchUser(dto
				.getUserSearchCond(), pDto.getFromCount(), pDto
				.getPageDispCount());
		pDto.setTotalCount(totalCount);
		dto.setUserList(userList);
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		log.debug("========用户查询处理终了========");
		return dto;
	}
	
	
	/**
	 * <p>
	 * Description: 角色查询
	 * </p>
	 * 
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM04DTO searchRoleAction(IGSYM04DTO dto)
	throws BLException {
		log.debug("========角色查询处理开始========");
		// 查询记录总数
		int totalCount = roleBL.getRoleSearchCount(dto
				.getRoleSearchCond());
		if (totalCount == 0) {
			log.debug("========查询数据不存在========");
			// 查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========查询数据件数过多========");
			// 查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}
		//获取分页bean
		PagingDTO pDto = dto.getPagingDto();
		//调用DAO接口查询
		List<Role> roleList = roleBL.searchRole(dto
				.getRoleSearchCond(), pDto.getFromCount(), pDto
				.getPageDispCount());
		pDto.setTotalCount(totalCount);
		dto.setRoleList(roleList);
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		log.debug("========角色查询处理终了========");
		return dto;
	}
	
	/**
	 * <p>
	 * Description: 用户角色查询
	 * </p>
	 * 
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM04DTO searchUserRoleAction(IGSYM04DTO dto)
	throws BLException {
		log.debug("========用户角色查询处理开始========");
		//获取用户已授权角色
		List<UserRoleInfo> ownRoleList = userRoleBL.searchUserRoleVW(dto.getUserRoleVWSearchCond(),0,0);
		//获取用户未授权角色（暂时是所有角色）
		List<Role> roleList = roleBL.searchRole(new RoleSearchCondImpl());
		
		String userStatus = null;//用户是否同步
		
		if(dto.getUserid()!=null && !"".equals(dto.getUserid())){
			User user = userBL.searchUserByKey(dto.getUserid());
			dto.setUsername(user.getUsername());
			dto.setOrgname(user.getOrgname());
			userStatus = user.getUserstatus();
		}
		
		if(StringUtils.isEmpty(userStatus)){
			List<Role> roleListParam = new ArrayList<Role>();
			for(Role role:roleList){
				if(!role.getRoletype().equals("IGSY01")){
					roleListParam.add(role);
				}
			}
			dto.setRoleList(roleListParam);
		}else {
			dto.setRoleList(roleList);			
		}
		
		dto.setOwnRoleList(ownRoleList);
		log.debug("========用户角色查询处理终了========");
		return dto;
	}
	
	/**
	 * <p>
	 * Description: 用户角色查询
	 * </p>
	 * 
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM04DTO searchUserRoleForManagerAction(IGSYM04DTO dto)
			throws BLException {
		log.debug("========用户角色查询处理开始========");
		//获取用户已授权角色
		List<UserRoleInfo> ownRoleList = userRoleBL.searchUserRoleVW(dto.getUserRoleVWSearchCond(),0,0);
		
		//获取用户所负责的角色，用于设置值班角色负责人
		Map<UserRoleInfo,List<UserInfo>> managerMap = new LinkedHashMap<UserRoleInfo,List<UserInfo>>();
		
		UserInfoSearchCondImpl cond = new UserInfoSearchCondImpl();
		for(UserRoleInfo uri : ownRoleList) {
			if("1".equals(uri.getRolemanager()) && uri.getRoletype().startsWith(WorkFlowConstDefine.PROCESS_ROLE_MARK)) {
				cond.setRoleida(uri.getRoleid());
				List<UserInfo> list = this.userBL.searchUserInfo(cond, 0, 0);
				for(Iterator<UserInfo> iter = list.iterator(); iter.hasNext();) {
					UserInfo ui = iter.next();
					if(!"1".equals(ui.getRolemanager())) {
						iter.remove();
					}
				}
				if(!list.isEmpty()){
					managerMap.put(uri, list);
				}
			} else {
				managerMap.put(uri, new ArrayList<UserInfo>());
			}
		}
		if(!managerMap.isEmpty()) {
			dto.setManagerMap(managerMap);
			//初始化值班人
			Set<UserRoleInfo> set = managerMap.keySet();
			//roleid - userid
			Map<String,String> roleMap = new HashMap<String,String>();
			Map<String,String> mobileMap = new HashMap<String,String>();
			for(Iterator<UserRoleInfo> iter = set.iterator();iter.hasNext();){
				UserRoleInfo uri = iter.next();
				
				Role role = this.roleBL.searchRoleByKey(uri.getRoleid());
				if(role != null) {
					if(StringUtils.isEmpty(role.getRoleinfo())) {
						roleMap.put(role.getRoleid().toString(), "");
						mobileMap.put(role.getRoleid().toString(), "0");
					} else {
						String[] info = role.getRoleinfo().split("###");
						if(info != null && info.length == 2) {
							if("".equals(info[0])) {
								roleMap.put(role.getRoleid().toString(), info[1]);
								mobileMap.put(role.getRoleid().toString(), "0");
							} else {
								roleMap.put(role.getRoleid().toString(), info[0]);
								mobileMap.put(role.getRoleid().toString(), "1");
							}
						}
					}
				} else {
					throw new BLException("IGCO10000.E004","角色基本");
				}
			}
			dto.setRoleMap(roleMap);
			dto.setMobileMap(mobileMap);
		}
		dto.setOwnRoleList(ownRoleList);
		log.debug("========用户角色查询处理终了========");
		return dto;
	}
	
	
	/**
	 * <p>
	 * Description: 删除用户角色
	 * </p>
	 * 
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM04DTO revokeUserRoleAction(IGSYM04DTO dto) throws BLException {
		log.debug("========删除用户角色处理开始========");
		//循环删除
		for( int i=0;i<dto.getUrid().length;i++ ){
			//获取资源库用户角色关系表实体
			UserRole userrole = userRoleBL.searchUserRoleByKey(Integer.parseInt(dto.getUrid()[i]));
			Role role = roleBL.getRole(userrole.getRoleid());//获取该关系表中的角色实体
			User user = userBL.searchUserByKey(userrole.getUserid());//获取该关系表中的用户实体
			if(role.getRoletype().equals("IGSY01")){
				//同步删除操作
				String res = synSubjectRoleDateDel(user.getUserstatus(),role.getFingerPrint());
				if("-1".equals(res)){
					throw new BLException("IGCO10000.E132","删除");
				}else if("Role-2".equals(res)){
					throw new BLException("IGCO10000.E133","删除","角色");
				}else if("User-2".equals(res)){
					throw new BLException("IGCO10000.E133","删除","用户");
				}else if("0".equals(res)){
					throw new BLException("IGCO10000.E029","用户角色关系");
				}else if(res.equals("SUCCESS")){
					//预留
					log.info("========同步删除用户角色关系信息成功========");
				}else{
					throw new BLException("IGCO10000.E135",res);
				}
			}
			//用户角色删除主键
			userRoleBL.deleteUserRoleByKey(Integer.parseInt(dto.getUrid()[i]));
		}
		dto.addMessage(new ActionMessage("IGSYM0402.I002"));
		log.debug("========删除用户角色处理终了========");
		return dto;
	}
	
	/**
	 * 同步HQ的Subject与Role关系表_删除
	 * @param userID
	 * @param roleName
	 * @return
	 * @throws BLException 
	 */
	private String synSubjectRoleDateDel(String sub_id, String role_id) throws BLException {
		CodeListUtils codeListUtils=(CodeListUtils) WebApplicationSupport.getBean("codeListUtils");
		//提取相应的配置信息
		String HQServerIP = codeListUtils.getCodeValue("160", null, null, "1");
		Integer HQServerPort = new Integer(codeListUtils.getCodeValue("160", null, null, "2"));
		String HQServerUsername = codeListUtils.getCodeValue("160", null, null, "3");
		String HQServerPassword = StringEncrypt.asciiToChar(codeListUtils.getCodeValue("160", null, null, "4"));
		String useFlg = codeListUtils.getCodeValue("160", null, null, "5");
		if("0".equals(useFlg)||StringUtils.isEmpty(useFlg)){
			return "0";
		}
		HQApi api = new HQApi(HQServerIP, HQServerPort, false, HQServerUsername, HQServerPassword);
		RoleApi roleApi = api.getRoleApi();
		UserApi userApi = api.getUserApi();
		
		try {
			org.hyperic.hq.hqapi1.types.Role roleTemp = roleApi.getRole(Integer.parseInt(role_id.trim())).getRole();
			if(roleTemp == null){
				return "Role-2";
			}
			org.hyperic.hq.hqapi1.types.User userTemp = userApi.getUser(Integer.parseInt(sub_id.trim())).getUser();
			if(userTemp == null){
				return "User-2";
			}
			
			for(int i=0;i<roleTemp.getUser().size();i++){
				if(roleTemp.getUser().get(i).getId().equals(userTemp.getId())){
					roleTemp.getUser().remove(i);
				}
			}
			roleApi.updateRole(roleTemp);
			return "SUCCESS";
		} catch (IOException e) {
			return "-1";
		}
	}
	
	/**
	 * <p>
	 * Description: 添加用户角色
	 * </p>
	 * 
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM04DTO grantUserRoleAction(IGSYM04DTO dto)
			throws BLException {
		log.debug("========添加用户角色处理开始========");
		//循环添加
		for( int i=0;i<dto.getRoleids().length;i++ ){
			String roleid = dto.getRoleids()[i];
			Role role = roleBL.searchRoleByKey(Integer.parseInt(roleid));//获取该关系表中的角色实体
			User user = userBL.searchUserByKey(dto.getUserid());//获取该关系表中的用户实体
			//判断是否是业务资源同步的角色
			if(role.getRoletype().equals("IGSY01")){
				String res = synSubjectRoleDateIns(user.getUserstatus(),role.getFingerPrint());
				if("-1".equals(res)){
					throw new BLException("IGCO10000.E132","添加");
				}else if("Role-2".equals(res)){
					throw new BLException("IGCO10000.E133","添加","角色");
				}else if("User-2".equals(res)){
					throw new BLException("IGCO10000.E133","添加","用户");
				}else if("0".equals(res)){
					throw new BLException("IGCO10000.E029","用户角色关系");
				}else if(res.equals("SUCCESS")){
					//预留
					log.info("========同步添加用户角色关系信息成功========");
				}else{
					throw new BLException("IGCO10000.E130",res);
				}
			}
			UserRoleTB userRole= new UserRoleTB();
			userRole.setUserid(dto.getUserid());//用户id
			userRole.setRoleid(Integer.parseInt(roleid));//角色id
			userRole.setOrgid(dto.getOrgid());//机构id
			userRole.setRolemanager("0");
			userRole.setDutyflag("0");
			userRoleBL.registUserRole(userRole);
		}
		dto.addMessage(new ActionMessage("IGSYM0402.I001"));
		log.debug("========添加用户角色处理终了========");
		return dto;
	}
	/**
	 * 同步HQ的Subject与Role关系表_添加
	 * @param userID
	 * @param roleName
	 * @return
	 * @throws BLException 
	 */
	private String synSubjectRoleDateIns(String sub_id, String role_id) throws BLException {
		CodeListUtils codeListUtils=(CodeListUtils) WebApplicationSupport.getBean("codeListUtils");
		//提取相应的配置信息
		String HQServerIP = codeListUtils.getCodeValue("160", null, null, "1");
		Integer HQServerPort = new Integer(codeListUtils.getCodeValue("160", null, null, "2"));
		String HQServerUsername = codeListUtils.getCodeValue("160", null, null, "3");
		String HQServerPassword = StringEncrypt.asciiToChar(codeListUtils.getCodeValue("160", null, null, "4"));
		String useFlg = codeListUtils.getCodeValue("160", null, null, "5");
		if("0".equals(useFlg)||StringUtils.isEmpty(useFlg)){
			return "0";
		}
		HQApi api = new HQApi(HQServerIP, HQServerPort, false, HQServerUsername, HQServerPassword);
		RoleApi roleApi = api.getRoleApi();
		UserApi userApi = api.getUserApi();
		
		try {
			org.hyperic.hq.hqapi1.types.Role roleTemp = roleApi.getRole(Integer.parseInt(role_id.trim())).getRole();
			if(roleTemp == null){
				return "Role-2";
			}
			org.hyperic.hq.hqapi1.types.User userTemp = userApi.getUser(Integer.parseInt(sub_id.trim())).getUser();
			if(userTemp == null){
				return "User-2";
			}
			
			roleTemp.getUser().add(userTemp);
			roleApi.updateRole(roleTemp);
			return "SUCCESS";
		} catch (IOException e) {
			return "-1";
		}
	}

	/**
	 * <p>
	 * Description: 角色菜单查询
	 * </p>
	 * 
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM04DTO searchRoleActionAction(IGSYM04DTO dto)
			throws BLException {
		log.debug("========角色菜单查询处理开始========");
		Role role = roleBL.searchRoleByKey(dto.getRoleid());
		dto.setRolename(role.getRolename());
		//获取角色已授权菜单
		List<RoleAction> roleActionList = roleActionBL.searchRoleAction(
				dto.getRoleActionSearchCond(), 0, 0);
		ActionSearchCondImpl actionCond = new ActionSearchCondImpl();
		if(!"IGAM01".equals(role.getRoletype())) {
			actionCond.setActroletype(role.getRoletype());
		}
		//获取所有菜单
		List<Action> actionList = actionBL.searchAction(actionCond);
		Action firstAction = null;
		Action secondAction = null;
		Action thirdAction = null;
		List<Map<Action,List<Map<Action,List<Map<Action,List<Action>>>>>>> allList 
		= new ArrayList<Map<Action,List<Map<Action,List<Map<Action,List<Action>>>>>>>();
		Map<Action,List<Map<Action,List<Map<Action,List<Action>>>>>> firstMap = null;
		Map<Action,List<Map<Action,List<Action>>>> secondMap = null;
		Map<Action,List<Action>> thirdMap = null;
		for(int i=0;i<actionList.size();i++){
			Action action = actionList.get(i);
			if("M1".equals(action.getActtype())){
				firstAction = action;
				firstMap = new LinkedHashMap<Action,List<Map<Action,List<Map<Action,List<Action>>>>>>();
				firstMap.put(firstAction, new ArrayList<Map<Action,List<Map<Action,List<Action>>>>>());
				allList.add(firstMap);
			}
			if("M2".equals(action.getActtype())){
				secondAction = action;
				secondMap = new LinkedHashMap<Action,List<Map<Action,List<Action>>>>();
				secondMap.put(secondAction, new ArrayList<Map<Action,List<Action>>>());
				if(firstMap == null) {
					throw new BLException("IGCO10000.E004",action.getActlabel() + "相关一级菜单");
				}
				firstMap.get(firstAction).add(secondMap);
			}
			if("M3".equals(action.getActtype())){
				thirdAction = action;
				thirdMap = new LinkedHashMap<Action,List<Action>>();
				thirdMap.put(thirdAction, new ArrayList<Action>());
				if(secondMap == null) {
					throw new BLException("IGCO10000.E004",action.getActlabel() + "相关二级菜单");
				}
				secondMap.get(secondAction).add(thirdMap);
			}
			if("M4".equals(action.getActtype())){
				if(thirdMap == null) {
					throw new BLException("IGCO10000.E004",action.getActlabel() + "相关三级菜单");
				}
				thirdMap.get(thirdAction).add(action);
			}
		}
		
		if(actionList.isEmpty()) {
			dto.addMessage(new ActionMessage("IGSYM0404.E001"));
		}
		dto.setActionList(allList);
		dto.setRoleActionList(roleActionList);
		log.debug("========角色菜单查询处理终了========");
		return dto;
	}
	
	/**
	 * <p>
	 * Description: 添加角色菜单
	 * </p>
	 * 
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM04DTO grantRoleActionAction(IGSYM04DTO dto)
			throws BLException {
		log.debug("========添加角色菜单处理开始========");
		//循环添加
		for( int i=0;i<dto.getActionids().length;i++ ){
			RoleActionTB roleAction= new RoleActionTB();
			roleAction.setActname(dto.getActionids()[i]);//菜单id
			roleAction.setRoleid(dto.getRoleid());//角色id
			roleActionBL.registRoleAction(roleAction);
		}
		dto.addMessage(new ActionMessage("IGSYM0404.I001"));
		log.debug("========添加角色菜单处理终了========");
		return dto;
	}

	/**
	 * <p>
	 * Description: 删除角色菜单
	 * </p>
	 * 
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM04DTO revokeRoleActionAction(IGSYM04DTO dto) throws BLException {
		log.debug("========删除角色菜单处理开始========");
		
		RoleActionSearchCondImpl raCond = new RoleActionSearchCondImpl();
		raCond.setRoleid(dto.getRoleid());
		List<RoleAction> raList = roleActionBL.searchRoleAction(raCond, 0, 0);
		if (raList == null){
			throw new BLException("IGCO10000.E004","删除对象角色菜单基本");
		}
		for(RoleAction ra : raList) {
			roleActionBL.deleteRoleAction(ra);
		}
		log.debug("========删除角色菜单处理终了========");
		return dto;
	}
	
	/**
	 * <p>
	 * Description: 机构查询
	 * </p>
	 * 
	 * @return List<Organization>
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM04DTO searchOrganizationAll(IGSYM04DTO dto) throws BLException{
		List<Organization> ret = organizationBL.searchOrganization(new OrganizationSearchCondImpl());
		dto.setOrganizationList(ret);
		return dto;
	}
	
	/**
	 * <p>
	 * Description: 根据角色查询用户
	 * </p>
	 * 
	 * @return IGSYM04DTO
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM04DTO searchRoleUser(IGSYM04DTO dto) throws BLException{
		log.debug("========根据角色查询用户处理开始========");
		// 查询记录总数
		int totalCount = userBL.getUserInfoSearchCount(dto.getUserInfoSearchCond());
		if (totalCount == 0) {
			log.debug("========查询数据不存在========");
			// 查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========查询数据件数过多========");
			// 查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}
		//获取分页bean
		PagingDTO pDto = dto.getPagingDto();
		//调用DAO接口查询
		List<UserInfo> ret = userBL.searchUserInfo(dto.getUserInfoSearchCond(), pDto.getFromCount(), pDto
				.getPageDispCount());
		pDto.setTotalCount(totalCount);
		dto.setRoleUserList(ret);
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		log.debug("========根据角色查询用户处理终了========");
		return dto;
	}
	
	public IGSYM04DTO searchRoleUserALL(IGSYM04DTO dto) throws BLException{
		log.debug("========根据角色查询用户处理开始========");
		// 查询记录总数
		int totalCount = userBL.getUserInfoSearchCount(dto.getUserInfoSearchCond());
//		if (totalCount == 0) {
//			log.debug("========查询数据不存在========");
//			// 查询数据不存在
//			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
//			return dto;
//		}
		//调用DAO接口查询
		List<UserInfo> ret = userBL.searchUserInfo(dto.getUserInfoSearchCond(), 0, 0);
		dto.setRoleUserList(ret);
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		log.debug("========根据角色查询用户处理终了========");
		return dto;
	}

	
	/**
	 * <p>
	 * Description: 查询流程所有信息
	 * </p>
	 * @return IGSYM04DTO
	 * @author zhaojun@deliverik.com
	 * @update2010-12-13
	 */
	public IGSYM04DTO getProcessInfoAll(IGSYM04DTO dto) throws BLException{
		log.debug("========根据用户参与流程开始========");
			IG677SearchCondImpl cond = new IG677SearchCondImpl();
			cond.setTodo(true);
			List<IG677Info> dataList = ig500BL.searchProcessRecordInfo(cond, 0, 0);
			dto.setProcessRecordInfoList(dataList);
		log.debug("========根据用户参与流程结束========");
		return dto;
	}
	
	/**
	 * <p>
	 * Description: 菜单授权
	 * </p>
	 * 
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM04DTO roleActionAction(IGSYM04DTO dto) throws BLException{
		revokeRoleActionAction(dto);
		grantRoleActionAction(dto);
		return dto;
	}
	
	/**
	 * 获取角色负责人
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 */
	
	public IGSYM04DTO searchRoleManagerAction(IGSYM04DTO dto)
	throws BLException {
		log.debug("========角色负责人查询处理开始========");
		//角色用户关联视图查询
		List<UserRoleInfo> userRoleInfoList = userRoleBL.searchUserRoleVW(dto.getUserRoleVWSearchCond(), 0, 0);
		if(userRoleInfoList != null) {
			Map<Integer, UserInfo> map = new LinkedHashMap<Integer, UserInfo>();
			for(UserRoleInfo urInfo : userRoleInfoList) {
				if(!"admin".equals(urInfo.getUserid())) {
					//用户基本信息查询
					UserInfoSearchCondImpl cond = new UserInfoSearchCondImpl();
					cond.setUserida(urInfo.getUserid());
					cond.setRoleida(urInfo.getRoleid());
					List<UserInfo> userInfoList = userBL.searchUserInfo(cond, 0, 0);
					if(userInfoList.size() != 1) {
						throw new BLException("IGCO10000.E004","用户角色基本信息");
					}
					map.put(urInfo.getUrid(), userInfoList.get(0));
				}
			}
			dto.setUserInfoMap(map);
		}
		log.debug("========角色负责人查询处理终了========");
		return dto;
	}
	
	/**
	 * 设置角色负责人
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 */
	
	public IGSYM04DTO saveRoleManagerAction(IGSYM04DTO dto)
			throws BLException {
		log.debug("========设置角色负责人处理开始========");
		String[] urid = dto.getUrid();
		//角色用户关联表查询
		List<UserRole> allUserRoleList = userRoleBL.searchUserRole(dto.getUserRoleSearchCond(), 0, 0);
		
		//过滤删除过的用户开始
		UserSearchCondImpl userCond = new UserSearchCondImpl();
		userCond.setDeleteflag("1");
		List<User> userList = userBL.searchUser(userCond);
		List<String> deleteUserIdList = new ArrayList<String>();
		for (User user : userList) {
			deleteUserIdList.add(user.getUserid());
		}
		List<UserRole> userRoleList = new ArrayList<UserRole>();
		for (UserRole userRole : allUserRoleList) {
			if(!deleteUserIdList.contains(userRole.getUserid())){
				userRoleList.add(userRole);
			}
		}
		//过滤删除过的用户结束
		
		if(urid == null) {
			for(UserRole ur : userRoleList) {
				if("1".equals(ur.getRolemanager())) {
					UserRoleTB userRoleTB = (UserRoleTB)SerializationUtils.clone(ur);
					userRoleTB.setRolemanager("0");
					userRoleBL.updateUserRole(userRoleTB);//回收负责人
				}
			}
		} else {
			List<String> list = Arrays.asList(urid);
			for(UserRole ur : userRoleList) {
				if(list.contains(ur.getUrid().toString()) && "0".equals(ur.getRolemanager())) {
					UserRoleTB userRoleTB = (UserRoleTB)SerializationUtils.clone(ur);
					userRoleTB.setRolemanager("1");
					userRoleBL.updateUserRole(userRoleTB);//授权负责人
				} else if(!list.contains(ur.getUrid().toString()) && "1".equals(ur.getRolemanager())) {
					UserRoleTB userRoleTB = (UserRoleTB)SerializationUtils.clone(ur);
					userRoleTB.setRolemanager("0");
					userRoleBL.updateUserRole(userRoleTB);//回收负责人
				}
			}
		}
		dto.addMessage(new ActionMessage("IGSYM0407.I001"));
		log.debug("========设置角色负责人处理终了========");
		return dto;
	}
	/**
	 * <p>
	 * Description: 根据角色类型查询用户
	 * </p>
	 * 
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 */
	
	public IGSYM04DTO searchUserByRoleType(IGSYM04DTO dto) throws BLException{
		log.debug("========根据角色类型查询用户处理开始========");
		// 查询记录总数
		int totalCount = userBL.getUserCountByRoleType(dto.getUserInfoSearchCond());
		if (totalCount == 0) {
			log.debug("========查询数据不存在========");
			// 查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========查询数据件数过多========");
			// 查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}
		//获取分页bean
		PagingDTO pDto = dto.getPagingDto();
		//调用DAO接口查询
		List<User> ret = userBL.searchUserByRoleType(dto.getUserInfoSearchCond(), pDto.getFromCount(), pDto
				.getPageDispCount());
		pDto.setTotalCount(totalCount);
		dto.setUserList(ret);
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		log.debug("========根据角色类型查询用户处理终了========");
		return dto;
	}

	/**
	 * 报表信息查询处理
	 *
	 * @param dto IGSYM14DTO
	 * @return IGSYM14DTO
	 */
	public IGSYM04DTO searchReportFileDefinitionAction(IGSYM04DTO dto) throws BLException {
		
		log.debug("========报表信息查询处理开始========");
		
		//报表信息查询件数取得 
		int totalCount = this.reportFileDefinitionBL.getSearchCount(dto.getReportFileDefinitionSearchCond());
		
		if (totalCount == 0) {
			log.debug("========报表信息查询数据不存在========");
			//报表信息查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========报表信息查询数据件数过多========");
			//报表信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		//分页用信息取得
		PagingDTO pDto = dto.getPagingDto();
		
		//当前页报表信息取得
		List<ReportFileDefinition> reportFileDefinitionList = this.reportFileDefinitionBL.searchReportFileDefinition(dto.getReportFileDefinitionSearchCond(), pDto.getFromCount(), pDto.getPageDispCount());
		
		pDto.setTotalCount(totalCount);
		
		dto.setReportFileDefinitionList(reportFileDefinitionList);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========报表信息查询处理终了========");
		return dto;
	}
	/**
	 * 报表信息变更初始化
	 * 
	 * @param dto IGSYM14DTO
	 * @return IGSYM14DTO
	 * @throws BLException
	 */
	
	public IGSYM04DTO initReportFileDefinitionAction(IGSYM04DTO dto) throws BLException {
		
		log.debug("========报表基本信息查询处理开始========");
		IGSYM0413Form form = dto.getIgSYM0413Form();
		
		ReportFileDefinition rfd = this.reportFileDefinitionBL.searchReportFileDefinitionByKey(form.getRfdid());
		
		form.setRfdtitle(rfd.getRfdtitle());//显示名称
		
		form.setRfdtype(rfd.getRfdtype());//分类
		
		form.setRfdid(rfd.getRfdid());//主键
		
		form.setRfdfilename(rfd.getRfdfilename());//文件名
		
		form.setRfdpictype(rfd.getRfdpictype());//报表样式
		
		form.setRfddesc(rfd.getRfddesc());//说明
		
		form.setRfdtypename(rfd.getCodeDetailTB().getCvalue());//分类显示名称
		
		dto.addMessage(new ActionMessage("IGCO10000.I001","报表基本信息"));
		
		log.debug("========报表基本信息查询处理终了========");
		return dto;
	}

	public IGSYM04DTO searchRoleReportAction(IGSYM04DTO dto) throws BLException {
		
		log.debug("========报表授权基本信息查询处理开始========");
		IGSYM0410Form form = dto.getIgSYM0410Form();
		
		RoleReportSearchCondImpl roleCond = new RoleReportSearchCondImpl();
		
		//获取用户未授权角色（暂时是所有角色）
		List<Role> roleList = roleBL.searchRole(new RoleSearchCondImpl());
				
		roleCond.setRfdid(form.getRfdid());
		
		List<RoleReport>  rr = this.roleReportBL.searchRoleReportByRfdid(roleCond);
		
		dto.setRoleReportList(rr);
		dto.setRoleList(roleList);
		
		return dto;
	}
	
	/**
	 * <p>
	 * Description: 添加报表角色
	 * </p>
	 * 
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author 
	 * @update
	 */
	
	public IGSYM04DTO grantRoleReportAction(IGSYM04DTO dto)
			throws BLException {
		log.debug("========添加用户角色处理开始========");
		//循环添加
		for( int i=0;i<dto.getRoleids().length;i++ ){
			String roleid = dto.getRoleids()[i];
			RoleReportTB roleReport = new RoleReportTB();
			roleReport.setRfdid(dto.getRfdid());
			roleReport.setRoleid(Integer.valueOf(roleid));
			roleReportBL.registRoleReport(roleReport);
		}
		dto.addMessage(new ActionMessage("IGSYM0402.I001"));
		log.debug("========添加用户角色处理终了========");
		return dto;
	}
	
	/**
	 * <p>
	 * Description: 删除报表角色
	 * </p>
	 * 
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author 
	 * @update
	 */
	
	public void revokeRoleReportAction(IGSYM04DTO dto)
			throws BLException {
		log.debug("========添加用户角色处理开始========");
		//循环删除
		for( int i=0;i<dto.getRoleids().length;i++ ){
			RoleReportSearchCondImpl roleCond = new RoleReportSearchCondImpl();
			String roleid = dto.getRoleids()[i];
			roleCond.setRfdid(dto.getRfdid());
			roleCond.setRoleid(Integer.valueOf(roleid));
			List<RoleReport> list = new ArrayList<RoleReport>();
			list = roleReportBL.searchRoleReport(roleCond);
			roleReportBL.revokeRoleReport(list);
		}
		dto.addMessage(new ActionMessage("IGSYM0402.I001"));
		log.debug("========添加用户角色处理终了========");

	}
	
	/**
	 * 报表版本信息查询处理
	 *
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 */
	public IGSYM04DTO searchReportFileVersionAction(IGSYM04DTO dto) throws BLException {
		
		log.debug("========报表版本信息查询处理开始========");
		
		//报表信息取得
		dto.setReportFileDefinition(this.reportFileDefinitionBL.searchReportFileDefinitionByKey(dto.getReportFileVersionSearchCond().getRfdid()));

		//报表版本信息取得
		List<ReportFileVersion> reportFileVersionList = this.reportFileVersionBL.searchReportFileVersion(dto.getReportFileVersionSearchCond(), 0, 0);
		
		dto.setReportFileVersionList(reportFileVersionList);
		
		log.debug("========报表版本信息查询处理终了========");
		return dto;
	}
	/**
	 * 报表授权信息初始化
	 * 
	 * @param dto IGSYM14DTO
	 * @return IGSYM14DTO
	 * @throws BLException
	 */
	
	public IGSYM04DTO roleReportFileDefinitionAction(IGSYM04DTO dto) throws BLException {
		
		log.debug("========报表基本信息查询处理开始========");
		IGSYM0410Form form = dto.getIgSYM0410Form();
		
		ReportFileDefinition rfd = this.reportFileDefinitionBL.searchReportFileDefinitionByKey(form.getRfdid());
		
		form.setRfdtitle(rfd.getRfdtitle());//显示名称
		
		form.setRfdtype(rfd.getRfdtype());//分类
		
		form.setRfdid(rfd.getRfdid());//主键
		
		form.setRfdpictype(rfd.getRfdpictype());//报表样式
		
		form.setRfdtypename(rfd.getCodeDetailTB().getCvalue());//分类显示名称

		dto.addMessage(new ActionMessage("IGCO10000.I001","报表基本信息"));
		
		log.debug("========报表基本信息查询处理终了========");
		return dto;
	}

	/**
	 * <p>
	 * Description: 获取已有报表授权信息
	 * </p>
	 * 
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author renxiaodi
	 * @update
	 */
	public IGSYM04DTO searchRoleReportRfdidByRoleid(IGSYM04DTO dto)
			throws BLException {
		log.debug("========已授权报表查询开始========");
		IGSYM0415Form form = dto.getIgSYM0415Form();
		
		RoleReportSearchCondImpl cond = new RoleReportSearchCondImpl();
		cond.setRoleid(form.getRoleid());
		
		//通过roleid查询所拥有的报表id
		List<RoleReport> rfdids = this.roleReportBL.searchRoleReportByRoleid(cond);
		
		List<ReportFileDefinition> ownReportFileDefinition = new ArrayList<ReportFileDefinition>();
		
		//循环获取所拥有报表id查询相应报表信息并放入ownReportFileDefinition
		for(RoleReport r:rfdids){
			ownReportFileDefinition.add(this.reportFileDefinitionBL.searchReportFileDefinitionByKey(r.getRfdid()));
		}
		
		
		dto.setOwnReportFileDefinitionList(ownReportFileDefinition);
		
		log.debug("========已授权报表查询处理终了========");
		return dto;
	}

	/**
	 * <p>
	 * Description: 获取全部报表集合
	 * </p>
	 * 
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author renxiaodi
	 * @update
	 */
	public IGSYM04DTO searchReportFileDefinition(IGSYM04DTO dto) throws BLException {
		log.debug("========报表查询开始========");
		
		List<ReportFileDefinition> allReportFileDefinition = this.reportFileDefinitionBL.searchReportFileDefinitionAll();
		
		dto.setReportFileDefinitionList(allReportFileDefinition);
		log.debug("========报表查询处理终了========");
		return dto;
	}

	/**
	 * <p>
	 * Description: 通过角色id查询角色
	 * </p>
	 * 
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author renxiaodi
	 * @update
	 */
	public IGSYM04DTO searchRoleByRoleId(IGSYM04DTO dto) throws BLException {
		log.debug("========角色查询开始========");
		
		Role role = this.roleBL.searchRoleByKey(dto.getRoleid());
		
		dto.setRole(role);

		log.debug("========角色处理终了========");
		return dto;
	}
	
	/**
	 * <p>
	 * Description: 通过报表id查询报名
	 * </p>
	 * 
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author renxiaodi
	 * @update
	 */
	public IGSYM04DTO searchRolenameByRoleId(IGSYM04DTO dto) throws BLException {
		log.debug("========角色名查询开始========");
		
		Role role = this.roleBL.searchRoleByKey(dto.getRoleid());
		
		dto.setRolename(role.getRolename());

		log.debug("========角色名处理终了========");
		return dto;
	}
	
	/**
	 * <p>
	 * Description: 按角色删除报表授权
	 * </p>
	 * 
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author renxiaodi
	 * @update
	 */
	public void revokeRoleReportActionByRoleid(IGSYM04DTO dto)
			throws BLException {
		log.debug("========按角色删除报表处理开始========");
		//循环删除
		for( int i=0;i<dto.getRfdids().length;i++ ){
			RoleReportSearchCondImpl roleCond = new RoleReportSearchCondImpl();
			String rfdid = dto.getRfdids()[i];
			roleCond.setRfdid(Integer.valueOf(rfdid));
			roleCond.setRoleid(dto.getRoleid());
			List<RoleReport> list = new ArrayList<RoleReport>();
			list = roleReportBL.searchRoleReport(roleCond);
			roleReportBL.revokeRoleReport(list);
		}
		dto.addMessage(new ActionMessage("IGSYM0402.I001"));
		log.debug("========按角色删除报表处理终了========");

	}

	/**
	 * <p>
	 * Description: 按角色添加报表授权
	 * </p>
	 * 
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author renxiaodi
	 * @update
	 */
	public IGSYM04DTO grantRoleReportActionByRoleid(IGSYM04DTO dto)
			throws BLException {
		log.debug("========添加用户角色处理开始========");
		//循环添加
		for( int i=0;i<dto.getRfdids().length;i++ ){
			String rfdid = dto.getRfdids()[i];
			RoleReportTB roleReport = new RoleReportTB();
			roleReport.setRfdid(Integer.valueOf(rfdid));
			roleReport.setRoleid(dto.getRoleid());
			roleReportBL.registRoleReport(roleReport);
		}
		dto.addMessage(new ActionMessage("IGSYM0415.I001"));
		log.debug("========添加用户角色处理终了========");
		return dto;
	}
	/**
	 * 设置角色负责人
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 */
	
	public IGSYM04DTO saveDutyflagAction(IGSYM04DTO dto)
			throws BLException {
		log.debug("========设置值班人处理开始========");
		String[] urid = dto.getUrid();
		//角色用户关联表查询
		List<UserRole> allUserRoleList = userRoleBL.searchUserRole(dto.getUserRoleSearchCond(), 0, 0);
		
		//过滤删除过的用户开始
		UserSearchCondImpl userCond = new UserSearchCondImpl();
		userCond.setDeleteflag("1");
		List<User> userList = userBL.searchUser(userCond);
		List<String> deleteUserIdList = new ArrayList<String>();
		for (User user : userList) {
			deleteUserIdList.add(user.getUserid());
		}
		List<UserRole> userRoleList = new ArrayList<UserRole>();
		for (UserRole userRole : allUserRoleList) {
			if(!deleteUserIdList.contains(userRole.getUserid())){
				userRoleList.add(userRole);
			}
		}
		//过滤删除过的用户结束
		
		if(urid == null) {
			for(UserRole ur : userRoleList) {
				if("1".equals(ur.getDutyflag())||"".equals(ur.getDutyflag())) {
					UserRoleTB userRoleTB = (UserRoleTB)SerializationUtils.clone(ur);
					userRoleTB.setDutyflag("0");
					userRoleBL.updateUserRole(userRoleTB);//回收值班人
				}
			}
		} else {
			List<String> list = Arrays.asList(urid);
			for(UserRole ur : userRoleList) {
				if(list.contains(ur.getUrid().toString()) && "0".equals(ur.getDutyflag())) {
					UserRoleTB userRoleTB = (UserRoleTB)SerializationUtils.clone(ur);
					userRoleTB.setDutyflag("1");
					userRoleBL.updateUserRole(userRoleTB);//授权值班人
				} else if(!list.contains(ur.getUrid().toString()) && "1".equals(ur.getDutyflag())) {
					UserRoleTB userRoleTB = (UserRoleTB)SerializationUtils.clone(ur);
					userRoleTB.setDutyflag("0");
					userRoleBL.updateUserRole(userRoleTB);//回收值班人
				} else if(list.contains(ur.getUrid().toString()) && " ".equals(ur.getDutyflag())) {
					UserRoleTB userRoleTB = (UserRoleTB)SerializationUtils.clone(ur);
					userRoleTB.setDutyflag("1");
					userRoleBL.updateUserRole(userRoleTB);
				}
			}
		}
		dto.addMessage(new ActionMessage("IGSYM0409.I001"));
		log.debug("========设置值班人处理终了========");
		return dto;
	}
	
	/**
	 * <p>
	 * Description: 根据角色查询同一组织的用户
	 * </p>
	 * 
	 * @return IGSYM04DTO
	 * @author   
	 * @update
	 */
	
	public IGSYM04DTO searchRoleUserByOrg(IGSYM04DTO dto) throws BLException{
		log.debug("========根据角色查询用户处理开始========");
		//调用DAO接口查询
		List<UserInfo> ret = userBL.searchUserInfo(dto.getUserInfoSearchCond(), 0, 0);
		List<UserInfo> realList = new ArrayList<UserInfo>();

		//获取分页bean
		PagingDTO pDto = dto.getPagingDto();
		/**按部门过滤*/
		if(StringUtils.isNotEmpty(dto.getOrgid())){
			if(dto.getOrgid().length()<=7){//如果为顶级机构或顶级机构的下一级机构按等于orgid过滤
				for(UserInfo ui : ret){
					if(dto.getOrgid().equals(ui.getOrgida())){
						realList.add(ui);
					}
				}
			}else{//按orgid前七位过滤
				String orgid = dto.getOrgid().substring(0,7);
				for(UserInfo ui : ret){
					if(StringUtils.isNotEmpty(ui.getOrgida())){
						if(ui.getOrgida().length()>=7){//排除顶级机构
							if(orgid.equals(ui.getOrgida().substring(0,7))){
								realList.add(ui);
							}
						}
					}
				}
			}
		}
		pDto.setTotalCount(realList.size());

		/***/
		dto.setRoleUserList(realList);
		//dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));

		log.debug("========根据角色查询用户处理终了========");
		return dto;
	}
	
	/**
	 * <p>
	 * Description: 根据角色类型查询用户不需要分页
	 * </p>
	 * 
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author   
	 */
	
	public IGSYM04DTO searchUserByRoleTypeNoPage(IGSYM04DTO dto) throws BLException{
		
		log.debug("========根据角色类型查询用户处理开始========");
		UserInfoSearchCondImpl userSearchCondImpl = new UserInfoSearchCondImpl();
		
		userSearchCondImpl.setRoleida(dto.getRoleid());

		List<UserInfo> userInfoList = userBL.searchUserInfo(userSearchCondImpl);

		dto.setUserInfoList(userInfoList);
		dto.setRole(roleBL.getRole(dto.getRoleid()));
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",userInfoList.size()));// xd-fixed
		
		log.debug("========根据角色类型查询用户处理终了========");
		
		return dto;
	}
	
	/**
	 * <p>
	 * Description: 删除角色用户
	 * </p>
	 * 
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author   
	 * @update
	 */
	public IGSYM04DTO deleteRoleUser(IGSYM04DTO dto) throws BLException {
		
		log.debug("========删除角色用户处理开始========");
		
		//循环删除
		for(int i = 0 ; i < dto.getUrid().length ; i++){
			
			UserRoleSearchCondImpl userRoleSearchCondImpl =  new UserRoleSearchCondImpl();

			userRoleSearchCondImpl.setUserid(dto.getUrid()[i]);
			userRoleSearchCondImpl.setRoleid(dto.getRoleid());

			List<UserRole> userRoleList = userRoleBL.searchUserRole(userRoleSearchCondImpl);
	
			for(UserRole userRole : userRoleList) {			
				//获取资源库用户角色关系表实体
				Role role = roleBL.getRole(userRole.getRoleid());//获取该关系表中的角色实体
				User user = userBL.searchUserByKey(userRole.getUserid());//获取该关系表中的用户实体
				if(role.getRoletype().equals("IGSY01")){
					//同步删除操作
					String res = synSubjectRoleDateDel(user.getUserstatus(),role.getFingerPrint());
					if("-1".equals(res)){
						throw new BLException("IGCO10000.E132","删除");
					}else if("Role-2".equals(res)){
						throw new BLException("IGCO10000.E133","删除","角色");
					}else if("User-2".equals(res)){
//						throw new BLException("IGCO10000.E133","删除","用户");
						log.info("========用户表无相关用户信息========");
					}else if("0".equals(res)){
						throw new BLException("IGCO10000.E029","用户角色关系");
					}else if(res.equals("SUCCESS")){
						//预留
						log.info("========同步删除用户角色关系信息成功========");
					}else{
						throw new BLException("IGCO10000.E135",res);
					}
				}
				
				//用户角色删除主键
				userRoleBL.deleteUserRoleByKey(userRole.getUrid());
			}
		}
		
		dto.addMessage(new ActionMessage("IGSYM0402.I002"));

		log.debug("========删除角色用户处理终了========");
		
		return dto;
		
	}
	
	/**
	 * <p>
	 * Description: 根据角色类型查询不属于该角色的同步用户
	 * </p>
	 * 
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author   
	 */
	public IGSYM04DTO searchUserNoByRoleTypeSyn(IGSYM04DTO dto) throws BLException{

		log.debug("========根据角色类型查询不属于该角色的用户========");

		// 查询记录总数
		int totalCount = userNotRoleBL.getSearchCountSyn(dto.getUserNotRoleVWSearchCond());

		if (totalCount == 0) {
			log.debug("========查询数据不存在========");
			// 查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========查询数据件数过多========");
			// 查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}
		
		//获取分页bean
		PagingDTO pDto = dto.getPagingDto();

		//调用DAO接口查询
		List<UserNotRole> ret = userNotRoleBL.searchUserNotRoleSyn(dto.getUserNotRoleVWSearchCond() , pDto.getFromCount(), pDto.getPageDispCount());
		
		pDto.setTotalCount(totalCount);

		dto.setUserNotRoleList(ret);
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		
		log.debug("========根据角色类型查询不属于该角色的用户========");
		
		return dto;
	}
	
	/**
	 * <p>
	 * Description: 根据角色类型查询不属于该角色的用户
	 * </p>
	 * 
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author   
	 */
	
	public IGSYM04DTO searchUserNoByRoleType(IGSYM04DTO dto) throws BLException{

		log.debug("========根据角色类型查询不属于该角色的用户========");

		// 查询记录总数
		int totalCount = userNotRoleBL.getSearchCount(dto.getUserNotRoleVWSearchCond());

		if (totalCount == 0) {
			log.debug("========查询数据不存在========");
			// 查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========查询数据件数过多========");
			// 查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}
		
		//获取分页bean
		PagingDTO pDto = dto.getPagingDto();

		//调用DAO接口查询
		List<UserNotRole> ret = userNotRoleBL.searchUserNotRole(dto.getUserNotRoleVWSearchCond() , pDto.getFromCount(), pDto.getPageDispCount());
		
		pDto.setTotalCount(totalCount);

		dto.setUserNotRoleList(ret);
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		
		log.debug("========根据角色类型查询不属于该角色的用户========");
		
		return dto;
	}
	
	/**
	 * <p>
	 * Description: 添加角色用户
	 * </p>
	 * 
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author   
	 * @update
	 */
	public IGSYM04DTO saveRoleUser(IGSYM04DTO dto) throws BLException {
		
		log.debug("========添加角色用户处理开始========");
		
		Integer roleid = dto.getRoleid();
		Role role = roleBL.searchRoleByKey(roleid);//获取该关系表中的角色实体
		
		//循环添加
		for(int i = 0 ; i < dto.getUrid().length ; i++){	
			String urid = dto.getUrid()[i];
			
			User user = userBL.searchUserByKey(urid.split("-")[0]);//循环获取用户实体
			
			//判断是否是业务资源同步的角色
			if(role.getRoletype().equals("IGSY01")){
				String res = synSubjectRoleDateIns(user.getUserstatus(),role.getFingerPrint());
				if("-1".equals(res)){
					throw new BLException("IGCO10000.E132","添加");
				}else if("Role-2".equals(res)){
					throw new BLException("IGCO10000.E133","添加","角色");
				}else if("User-2".equals(res)){
					throw new BLException("IGCO10000.E133","添加","用户");
				}else if("0".equals(res)){
					throw new BLException("IGCO10000.E029","用户角色关系");
				}else if(res.equals("SUCCESS")){
					//预留
					log.info("========同步添加用户角色关系信息成功========");
				}else{
					throw new BLException("IGCO10000.E130",res);
				}
			}
			
			UserRoleTB userRole = new UserRoleTB();
			
			userRole.setUserid(urid.split("-")[0]);//用户id
			userRole.setRoleid(dto.getRoleid());//角色id
			userRole.setOrgid(urid.split("-")[1]);//机构id
			userRole.setRolemanager("0");

			userRoleBL.registUserRole(userRole);
			
		}
		
		dto.addMessage(new ActionMessage("IGSYM0402.I001"));
		
		log.debug("========添加角色用户处理终了========");
		
		return dto;
		
	}
	
	
	/** 资源组授权 */
	/**
	 * 查询同步的角色列表
	 * @return
	 * @throws BLException
	 */
	public IGSYM04DTO searchSYNRoleAction(IGSYM04DTO dto) throws BLException {
		log.debug("========同步角色查询处理开始========");
		/** 无法使用已封装的方法得到需要的信息只能先全查再处理也无法进行分页 */
		RoleSearchCond cond = new RoleSearchCondImpl();
//		int totalCount = roleBL.getRoleSearchCount(cond);
//		if (totalCount == 0) {
//			log.debug("========查询数据不存在========");
//			// 查询数据不存在
//			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
//			return dto;
//		}
//		if (totalCount > dto.getMaxSearchCount()) {
//			log.debug("========查询数据件数过多========");
//			// 查询数据件数过多
//			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
//					.getMaxSearchCount(), totalCount));
//			return dto;
//		}
//		//获取分页bean
//		PagingDTO pDto = dto.getPagingDto();
		//调用DAO接口查询
		List<Role> roleAllList = roleBL.searchRole(cond);
		List<Role> roleList = new ArrayList<Role>();
		for(Role role : roleAllList){
			if(StringUtils.isNotEmpty(role.getFingerPrint())){
				roleList.add(role);
			}
		}
		//List<Role> roleList = roleBL.searchRole(dto.getRoleSearchCond(), pDto.getFromCount(), pDto.getPageDispCount());
//		pDto.setTotalCount(totalCount);
		dto.setRoleList(roleList);
		log.debug("========同步角色查询处理终了========");
		return dto;
	}
}
