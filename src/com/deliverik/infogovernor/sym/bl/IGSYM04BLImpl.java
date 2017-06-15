/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ϵͳ����_��Ȩ����_��ɫ��ȨLIMPL
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 * @update zhaojun 2010-12-13
 */

public class IGSYM04BLImpl extends BaseBLImpl implements IGSYM04BL {

	static Log log = LogFactory.getLog(IGSYM04BLImpl.class);
	
	/**
	 * ע��UserBL
	 */
	protected UserBL userBL;
	
	/**
	 * ע��processRecordBL
	 */
	protected IG500BL ig500BL;
	
	/**
	 * ע��userNotRoleBL
	 */
	protected UserNotRoleBL userNotRoleBL;
	
	public void setIg500BL(IG500BL ig500BL) {
		this.ig500BL = ig500BL;
	}

	/**
	 * ����UserBL
	 * @param userBL UserBL
	 */
	
	public void setUserBL(UserBL userBL) {
		this.userBL = userBL;
	}
	
/** ����汾��ϢBL */
	protected ReportFileVersionBL reportFileVersionBL;
	
	
	
	public void setReportFileVersionBL(ReportFileVersionBL reportFileVersionBL) {
		this.reportFileVersionBL = reportFileVersionBL;
	}

	/** ������ϢBL */
	protected ReportFileDefinitionBL reportFileDefinitionBL;
	
	/** ������ϢBL */
	protected RoleReportBL roleReportBL;
	
	
	/**
	 * ����ReportFileDefinitionBL
	 * @param reportFileDefinitionBL ReportFileDefinitionBL
	 */
	
	public void setReportFileDefinitionBL(
			ReportFileDefinitionBL reportFileDefinitionBL) {
		this.reportFileDefinitionBL = reportFileDefinitionBL;
	}
	/**
	 * ע��RoleBL
	 */
	protected RoleBL roleBL;
	
	/**
	 * ����RoleBL
	 * @param roleBL RoleBL
	 */
	
	public void setRoleBL(RoleBL roleBL) {
		this.roleBL = roleBL;
	}
	
	/**
	 * ע��ActionBL
	 */
	protected ActionBL actionBL;
	
	/**
	 * ����ActionBL
	 * @param actionBL ActionBL
	 */
	
	public void setActionBL(ActionBL actionBL) {
		this.actionBL = actionBL;
	}
	
	/**
	 * ע��RoleActionBL
	 */
	protected RoleActionBL roleActionBL;
	
	/**
	 * ����RoleActionBL
	 * @param roleActionBL RoleActionBL
	 */
	
	public void setRoleActionBL(RoleActionBL roleActionBL) {
		this.roleActionBL = roleActionBL;
	}
	/**
	 * ע��UserRoleBL
	 */
	protected UserRoleBL userRoleBL;
	
	/**
	 * ����UserRoleBL
	 * @param userRoleBL UserRoleBL
	 */
	
	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}
	
	/**
	 * ����BL
	 */
	protected OrganizationBL organizationBL;
	
	/**
	 * ���û���BL
	 * @param organizationBL OrganizationBL
	 */

	public void setOrganizationBL(OrganizationBL organizationBL) {
		this.organizationBL = organizationBL;
	}

	/**
	 * ����RoleReportBL
	 * @param RoleReportBL roleReportBL
	 */
	
	public void setRoleReportBL(RoleReportBL roleReportBL) {
		this.roleReportBL = roleReportBL;
	}
	
	/**
	 * ����userNotRoleBL
	 * 
	 * @param userNotRoleBL UserNotRoleBL
	 */
	public void setUserNotRoleBL(UserNotRoleBL userNotRoleBL) {
		this.userNotRoleBL = userNotRoleBL;
	}

	/**
	 * <p>
	 * Description: �û���ѯ
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
		log.debug("========�û���ѯ����ʼ========");
		// ��ѯ��¼����
		int totalCount = userBL.getUserSearchCount(dto
				.getUserSearchCond());
		if (totalCount == 0) {
			log.debug("========��ѯ���ݲ�����========");
			// ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========��ѯ���ݼ�������========");
			// ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}
		//��ȡ��ҳbean
		PagingDTO pDto = dto.getPagingDto();
		//����DAO�ӿڲ�ѯ
		List<User> userList = userBL.searchUser(dto
				.getUserSearchCond(), pDto.getFromCount(), pDto
				.getPageDispCount());
		pDto.setTotalCount(totalCount);
		dto.setUserList(userList);
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		log.debug("========�û���ѯ��������========");
		return dto;
	}
	
	
	/**
	 * <p>
	 * Description: ��ɫ��ѯ
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
		log.debug("========��ɫ��ѯ����ʼ========");
		// ��ѯ��¼����
		int totalCount = roleBL.getRoleSearchCount(dto
				.getRoleSearchCond());
		if (totalCount == 0) {
			log.debug("========��ѯ���ݲ�����========");
			// ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========��ѯ���ݼ�������========");
			// ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}
		//��ȡ��ҳbean
		PagingDTO pDto = dto.getPagingDto();
		//����DAO�ӿڲ�ѯ
		List<Role> roleList = roleBL.searchRole(dto
				.getRoleSearchCond(), pDto.getFromCount(), pDto
				.getPageDispCount());
		pDto.setTotalCount(totalCount);
		dto.setRoleList(roleList);
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		log.debug("========��ɫ��ѯ��������========");
		return dto;
	}
	
	/**
	 * <p>
	 * Description: �û���ɫ��ѯ
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
		log.debug("========�û���ɫ��ѯ����ʼ========");
		//��ȡ�û�����Ȩ��ɫ
		List<UserRoleInfo> ownRoleList = userRoleBL.searchUserRoleVW(dto.getUserRoleVWSearchCond(),0,0);
		//��ȡ�û�δ��Ȩ��ɫ����ʱ�����н�ɫ��
		List<Role> roleList = roleBL.searchRole(new RoleSearchCondImpl());
		
		String userStatus = null;//�û��Ƿ�ͬ��
		
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
		log.debug("========�û���ɫ��ѯ��������========");
		return dto;
	}
	
	/**
	 * <p>
	 * Description: �û���ɫ��ѯ
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
		log.debug("========�û���ɫ��ѯ����ʼ========");
		//��ȡ�û�����Ȩ��ɫ
		List<UserRoleInfo> ownRoleList = userRoleBL.searchUserRoleVW(dto.getUserRoleVWSearchCond(),0,0);
		
		//��ȡ�û�������Ľ�ɫ����������ֵ���ɫ������
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
			//��ʼ��ֵ����
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
					throw new BLException("IGCO10000.E004","��ɫ����");
				}
			}
			dto.setRoleMap(roleMap);
			dto.setMobileMap(mobileMap);
		}
		dto.setOwnRoleList(ownRoleList);
		log.debug("========�û���ɫ��ѯ��������========");
		return dto;
	}
	
	
	/**
	 * <p>
	 * Description: ɾ���û���ɫ
	 * </p>
	 * 
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM04DTO revokeUserRoleAction(IGSYM04DTO dto) throws BLException {
		log.debug("========ɾ���û���ɫ����ʼ========");
		//ѭ��ɾ��
		for( int i=0;i<dto.getUrid().length;i++ ){
			//��ȡ��Դ���û���ɫ��ϵ��ʵ��
			UserRole userrole = userRoleBL.searchUserRoleByKey(Integer.parseInt(dto.getUrid()[i]));
			Role role = roleBL.getRole(userrole.getRoleid());//��ȡ�ù�ϵ���еĽ�ɫʵ��
			User user = userBL.searchUserByKey(userrole.getUserid());//��ȡ�ù�ϵ���е��û�ʵ��
			if(role.getRoletype().equals("IGSY01")){
				//ͬ��ɾ������
				String res = synSubjectRoleDateDel(user.getUserstatus(),role.getFingerPrint());
				if("-1".equals(res)){
					throw new BLException("IGCO10000.E132","ɾ��");
				}else if("Role-2".equals(res)){
					throw new BLException("IGCO10000.E133","ɾ��","��ɫ");
				}else if("User-2".equals(res)){
					throw new BLException("IGCO10000.E133","ɾ��","�û�");
				}else if("0".equals(res)){
					throw new BLException("IGCO10000.E029","�û���ɫ��ϵ");
				}else if(res.equals("SUCCESS")){
					//Ԥ��
					log.info("========ͬ��ɾ���û���ɫ��ϵ��Ϣ�ɹ�========");
				}else{
					throw new BLException("IGCO10000.E135",res);
				}
			}
			//�û���ɫɾ������
			userRoleBL.deleteUserRoleByKey(Integer.parseInt(dto.getUrid()[i]));
		}
		dto.addMessage(new ActionMessage("IGSYM0402.I002"));
		log.debug("========ɾ���û���ɫ��������========");
		return dto;
	}
	
	/**
	 * ͬ��HQ��Subject��Role��ϵ��_ɾ��
	 * @param userID
	 * @param roleName
	 * @return
	 * @throws BLException 
	 */
	private String synSubjectRoleDateDel(String sub_id, String role_id) throws BLException {
		CodeListUtils codeListUtils=(CodeListUtils) WebApplicationSupport.getBean("codeListUtils");
		//��ȡ��Ӧ��������Ϣ
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
	 * Description: ����û���ɫ
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
		log.debug("========����û���ɫ����ʼ========");
		//ѭ�����
		for( int i=0;i<dto.getRoleids().length;i++ ){
			String roleid = dto.getRoleids()[i];
			Role role = roleBL.searchRoleByKey(Integer.parseInt(roleid));//��ȡ�ù�ϵ���еĽ�ɫʵ��
			User user = userBL.searchUserByKey(dto.getUserid());//��ȡ�ù�ϵ���е��û�ʵ��
			//�ж��Ƿ���ҵ����Դͬ���Ľ�ɫ
			if(role.getRoletype().equals("IGSY01")){
				String res = synSubjectRoleDateIns(user.getUserstatus(),role.getFingerPrint());
				if("-1".equals(res)){
					throw new BLException("IGCO10000.E132","���");
				}else if("Role-2".equals(res)){
					throw new BLException("IGCO10000.E133","���","��ɫ");
				}else if("User-2".equals(res)){
					throw new BLException("IGCO10000.E133","���","�û�");
				}else if("0".equals(res)){
					throw new BLException("IGCO10000.E029","�û���ɫ��ϵ");
				}else if(res.equals("SUCCESS")){
					//Ԥ��
					log.info("========ͬ������û���ɫ��ϵ��Ϣ�ɹ�========");
				}else{
					throw new BLException("IGCO10000.E130",res);
				}
			}
			UserRoleTB userRole= new UserRoleTB();
			userRole.setUserid(dto.getUserid());//�û�id
			userRole.setRoleid(Integer.parseInt(roleid));//��ɫid
			userRole.setOrgid(dto.getOrgid());//����id
			userRole.setRolemanager("0");
			userRole.setDutyflag("0");
			userRoleBL.registUserRole(userRole);
		}
		dto.addMessage(new ActionMessage("IGSYM0402.I001"));
		log.debug("========����û���ɫ��������========");
		return dto;
	}
	/**
	 * ͬ��HQ��Subject��Role��ϵ��_���
	 * @param userID
	 * @param roleName
	 * @return
	 * @throws BLException 
	 */
	private String synSubjectRoleDateIns(String sub_id, String role_id) throws BLException {
		CodeListUtils codeListUtils=(CodeListUtils) WebApplicationSupport.getBean("codeListUtils");
		//��ȡ��Ӧ��������Ϣ
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
	 * Description: ��ɫ�˵���ѯ
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
		log.debug("========��ɫ�˵���ѯ����ʼ========");
		Role role = roleBL.searchRoleByKey(dto.getRoleid());
		dto.setRolename(role.getRolename());
		//��ȡ��ɫ����Ȩ�˵�
		List<RoleAction> roleActionList = roleActionBL.searchRoleAction(
				dto.getRoleActionSearchCond(), 0, 0);
		ActionSearchCondImpl actionCond = new ActionSearchCondImpl();
		if(!"IGAM01".equals(role.getRoletype())) {
			actionCond.setActroletype(role.getRoletype());
		}
		//��ȡ���в˵�
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
					throw new BLException("IGCO10000.E004",action.getActlabel() + "���һ���˵�");
				}
				firstMap.get(firstAction).add(secondMap);
			}
			if("M3".equals(action.getActtype())){
				thirdAction = action;
				thirdMap = new LinkedHashMap<Action,List<Action>>();
				thirdMap.put(thirdAction, new ArrayList<Action>());
				if(secondMap == null) {
					throw new BLException("IGCO10000.E004",action.getActlabel() + "��ض����˵�");
				}
				secondMap.get(secondAction).add(thirdMap);
			}
			if("M4".equals(action.getActtype())){
				if(thirdMap == null) {
					throw new BLException("IGCO10000.E004",action.getActlabel() + "��������˵�");
				}
				thirdMap.get(thirdAction).add(action);
			}
		}
		
		if(actionList.isEmpty()) {
			dto.addMessage(new ActionMessage("IGSYM0404.E001"));
		}
		dto.setActionList(allList);
		dto.setRoleActionList(roleActionList);
		log.debug("========��ɫ�˵���ѯ��������========");
		return dto;
	}
	
	/**
	 * <p>
	 * Description: ��ӽ�ɫ�˵�
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
		log.debug("========��ӽ�ɫ�˵�����ʼ========");
		//ѭ�����
		for( int i=0;i<dto.getActionids().length;i++ ){
			RoleActionTB roleAction= new RoleActionTB();
			roleAction.setActname(dto.getActionids()[i]);//�˵�id
			roleAction.setRoleid(dto.getRoleid());//��ɫid
			roleActionBL.registRoleAction(roleAction);
		}
		dto.addMessage(new ActionMessage("IGSYM0404.I001"));
		log.debug("========��ӽ�ɫ�˵���������========");
		return dto;
	}

	/**
	 * <p>
	 * Description: ɾ����ɫ�˵�
	 * </p>
	 * 
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM04DTO revokeRoleActionAction(IGSYM04DTO dto) throws BLException {
		log.debug("========ɾ����ɫ�˵�����ʼ========");
		
		RoleActionSearchCondImpl raCond = new RoleActionSearchCondImpl();
		raCond.setRoleid(dto.getRoleid());
		List<RoleAction> raList = roleActionBL.searchRoleAction(raCond, 0, 0);
		if (raList == null){
			throw new BLException("IGCO10000.E004","ɾ�������ɫ�˵�����");
		}
		for(RoleAction ra : raList) {
			roleActionBL.deleteRoleAction(ra);
		}
		log.debug("========ɾ����ɫ�˵���������========");
		return dto;
	}
	
	/**
	 * <p>
	 * Description: ������ѯ
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
	 * Description: ���ݽ�ɫ��ѯ�û�
	 * </p>
	 * 
	 * @return IGSYM04DTO
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM04DTO searchRoleUser(IGSYM04DTO dto) throws BLException{
		log.debug("========���ݽ�ɫ��ѯ�û�����ʼ========");
		// ��ѯ��¼����
		int totalCount = userBL.getUserInfoSearchCount(dto.getUserInfoSearchCond());
		if (totalCount == 0) {
			log.debug("========��ѯ���ݲ�����========");
			// ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========��ѯ���ݼ�������========");
			// ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}
		//��ȡ��ҳbean
		PagingDTO pDto = dto.getPagingDto();
		//����DAO�ӿڲ�ѯ
		List<UserInfo> ret = userBL.searchUserInfo(dto.getUserInfoSearchCond(), pDto.getFromCount(), pDto
				.getPageDispCount());
		pDto.setTotalCount(totalCount);
		dto.setRoleUserList(ret);
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		log.debug("========���ݽ�ɫ��ѯ�û���������========");
		return dto;
	}
	
	public IGSYM04DTO searchRoleUserALL(IGSYM04DTO dto) throws BLException{
		log.debug("========���ݽ�ɫ��ѯ�û�����ʼ========");
		// ��ѯ��¼����
		int totalCount = userBL.getUserInfoSearchCount(dto.getUserInfoSearchCond());
//		if (totalCount == 0) {
//			log.debug("========��ѯ���ݲ�����========");
//			// ��ѯ���ݲ�����
//			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
//			return dto;
//		}
		//����DAO�ӿڲ�ѯ
		List<UserInfo> ret = userBL.searchUserInfo(dto.getUserInfoSearchCond(), 0, 0);
		dto.setRoleUserList(ret);
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		log.debug("========���ݽ�ɫ��ѯ�û���������========");
		return dto;
	}

	
	/**
	 * <p>
	 * Description: ��ѯ����������Ϣ
	 * </p>
	 * @return IGSYM04DTO
	 * @author zhaojun@deliverik.com
	 * @update2010-12-13
	 */
	public IGSYM04DTO getProcessInfoAll(IGSYM04DTO dto) throws BLException{
		log.debug("========�����û��������̿�ʼ========");
			IG677SearchCondImpl cond = new IG677SearchCondImpl();
			cond.setTodo(true);
			List<IG677Info> dataList = ig500BL.searchProcessRecordInfo(cond, 0, 0);
			dto.setProcessRecordInfoList(dataList);
		log.debug("========�����û��������̽���========");
		return dto;
	}
	
	/**
	 * <p>
	 * Description: �˵���Ȩ
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
	 * ��ȡ��ɫ������
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 */
	
	public IGSYM04DTO searchRoleManagerAction(IGSYM04DTO dto)
	throws BLException {
		log.debug("========��ɫ�����˲�ѯ����ʼ========");
		//��ɫ�û�������ͼ��ѯ
		List<UserRoleInfo> userRoleInfoList = userRoleBL.searchUserRoleVW(dto.getUserRoleVWSearchCond(), 0, 0);
		if(userRoleInfoList != null) {
			Map<Integer, UserInfo> map = new LinkedHashMap<Integer, UserInfo>();
			for(UserRoleInfo urInfo : userRoleInfoList) {
				if(!"admin".equals(urInfo.getUserid())) {
					//�û�������Ϣ��ѯ
					UserInfoSearchCondImpl cond = new UserInfoSearchCondImpl();
					cond.setUserida(urInfo.getUserid());
					cond.setRoleida(urInfo.getRoleid());
					List<UserInfo> userInfoList = userBL.searchUserInfo(cond, 0, 0);
					if(userInfoList.size() != 1) {
						throw new BLException("IGCO10000.E004","�û���ɫ������Ϣ");
					}
					map.put(urInfo.getUrid(), userInfoList.get(0));
				}
			}
			dto.setUserInfoMap(map);
		}
		log.debug("========��ɫ�����˲�ѯ��������========");
		return dto;
	}
	
	/**
	 * ���ý�ɫ������
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 */
	
	public IGSYM04DTO saveRoleManagerAction(IGSYM04DTO dto)
			throws BLException {
		log.debug("========���ý�ɫ�����˴���ʼ========");
		String[] urid = dto.getUrid();
		//��ɫ�û��������ѯ
		List<UserRole> allUserRoleList = userRoleBL.searchUserRole(dto.getUserRoleSearchCond(), 0, 0);
		
		//����ɾ�������û���ʼ
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
		//����ɾ�������û�����
		
		if(urid == null) {
			for(UserRole ur : userRoleList) {
				if("1".equals(ur.getRolemanager())) {
					UserRoleTB userRoleTB = (UserRoleTB)SerializationUtils.clone(ur);
					userRoleTB.setRolemanager("0");
					userRoleBL.updateUserRole(userRoleTB);//���ո�����
				}
			}
		} else {
			List<String> list = Arrays.asList(urid);
			for(UserRole ur : userRoleList) {
				if(list.contains(ur.getUrid().toString()) && "0".equals(ur.getRolemanager())) {
					UserRoleTB userRoleTB = (UserRoleTB)SerializationUtils.clone(ur);
					userRoleTB.setRolemanager("1");
					userRoleBL.updateUserRole(userRoleTB);//��Ȩ������
				} else if(!list.contains(ur.getUrid().toString()) && "1".equals(ur.getRolemanager())) {
					UserRoleTB userRoleTB = (UserRoleTB)SerializationUtils.clone(ur);
					userRoleTB.setRolemanager("0");
					userRoleBL.updateUserRole(userRoleTB);//���ո�����
				}
			}
		}
		dto.addMessage(new ActionMessage("IGSYM0407.I001"));
		log.debug("========���ý�ɫ�����˴�������========");
		return dto;
	}
	/**
	 * <p>
	 * Description: ���ݽ�ɫ���Ͳ�ѯ�û�
	 * </p>
	 * 
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 */
	
	public IGSYM04DTO searchUserByRoleType(IGSYM04DTO dto) throws BLException{
		log.debug("========���ݽ�ɫ���Ͳ�ѯ�û�����ʼ========");
		// ��ѯ��¼����
		int totalCount = userBL.getUserCountByRoleType(dto.getUserInfoSearchCond());
		if (totalCount == 0) {
			log.debug("========��ѯ���ݲ�����========");
			// ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========��ѯ���ݼ�������========");
			// ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}
		//��ȡ��ҳbean
		PagingDTO pDto = dto.getPagingDto();
		//����DAO�ӿڲ�ѯ
		List<User> ret = userBL.searchUserByRoleType(dto.getUserInfoSearchCond(), pDto.getFromCount(), pDto
				.getPageDispCount());
		pDto.setTotalCount(totalCount);
		dto.setUserList(ret);
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		log.debug("========���ݽ�ɫ���Ͳ�ѯ�û���������========");
		return dto;
	}

	/**
	 * ������Ϣ��ѯ����
	 *
	 * @param dto IGSYM14DTO
	 * @return IGSYM14DTO
	 */
	public IGSYM04DTO searchReportFileDefinitionAction(IGSYM04DTO dto) throws BLException {
		
		log.debug("========������Ϣ��ѯ����ʼ========");
		
		//������Ϣ��ѯ����ȡ�� 
		int totalCount = this.reportFileDefinitionBL.getSearchCount(dto.getReportFileDefinitionSearchCond());
		
		if (totalCount == 0) {
			log.debug("========������Ϣ��ѯ���ݲ�����========");
			//������Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========������Ϣ��ѯ���ݼ�������========");
			//������Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		//��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();
		
		//��ǰҳ������Ϣȡ��
		List<ReportFileDefinition> reportFileDefinitionList = this.reportFileDefinitionBL.searchReportFileDefinition(dto.getReportFileDefinitionSearchCond(), pDto.getFromCount(), pDto.getPageDispCount());
		
		pDto.setTotalCount(totalCount);
		
		dto.setReportFileDefinitionList(reportFileDefinitionList);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========������Ϣ��ѯ��������========");
		return dto;
	}
	/**
	 * ������Ϣ�����ʼ��
	 * 
	 * @param dto IGSYM14DTO
	 * @return IGSYM14DTO
	 * @throws BLException
	 */
	
	public IGSYM04DTO initReportFileDefinitionAction(IGSYM04DTO dto) throws BLException {
		
		log.debug("========���������Ϣ��ѯ����ʼ========");
		IGSYM0413Form form = dto.getIgSYM0413Form();
		
		ReportFileDefinition rfd = this.reportFileDefinitionBL.searchReportFileDefinitionByKey(form.getRfdid());
		
		form.setRfdtitle(rfd.getRfdtitle());//��ʾ����
		
		form.setRfdtype(rfd.getRfdtype());//����
		
		form.setRfdid(rfd.getRfdid());//����
		
		form.setRfdfilename(rfd.getRfdfilename());//�ļ���
		
		form.setRfdpictype(rfd.getRfdpictype());//������ʽ
		
		form.setRfddesc(rfd.getRfddesc());//˵��
		
		form.setRfdtypename(rfd.getCodeDetailTB().getCvalue());//������ʾ����
		
		dto.addMessage(new ActionMessage("IGCO10000.I001","���������Ϣ"));
		
		log.debug("========���������Ϣ��ѯ��������========");
		return dto;
	}

	public IGSYM04DTO searchRoleReportAction(IGSYM04DTO dto) throws BLException {
		
		log.debug("========������Ȩ������Ϣ��ѯ����ʼ========");
		IGSYM0410Form form = dto.getIgSYM0410Form();
		
		RoleReportSearchCondImpl roleCond = new RoleReportSearchCondImpl();
		
		//��ȡ�û�δ��Ȩ��ɫ����ʱ�����н�ɫ��
		List<Role> roleList = roleBL.searchRole(new RoleSearchCondImpl());
				
		roleCond.setRfdid(form.getRfdid());
		
		List<RoleReport>  rr = this.roleReportBL.searchRoleReportByRfdid(roleCond);
		
		dto.setRoleReportList(rr);
		dto.setRoleList(roleList);
		
		return dto;
	}
	
	/**
	 * <p>
	 * Description: ��ӱ����ɫ
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
		log.debug("========����û���ɫ����ʼ========");
		//ѭ�����
		for( int i=0;i<dto.getRoleids().length;i++ ){
			String roleid = dto.getRoleids()[i];
			RoleReportTB roleReport = new RoleReportTB();
			roleReport.setRfdid(dto.getRfdid());
			roleReport.setRoleid(Integer.valueOf(roleid));
			roleReportBL.registRoleReport(roleReport);
		}
		dto.addMessage(new ActionMessage("IGSYM0402.I001"));
		log.debug("========����û���ɫ��������========");
		return dto;
	}
	
	/**
	 * <p>
	 * Description: ɾ�������ɫ
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
		log.debug("========����û���ɫ����ʼ========");
		//ѭ��ɾ��
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
		log.debug("========����û���ɫ��������========");

	}
	
	/**
	 * ����汾��Ϣ��ѯ����
	 *
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 */
	public IGSYM04DTO searchReportFileVersionAction(IGSYM04DTO dto) throws BLException {
		
		log.debug("========����汾��Ϣ��ѯ����ʼ========");
		
		//������Ϣȡ��
		dto.setReportFileDefinition(this.reportFileDefinitionBL.searchReportFileDefinitionByKey(dto.getReportFileVersionSearchCond().getRfdid()));

		//����汾��Ϣȡ��
		List<ReportFileVersion> reportFileVersionList = this.reportFileVersionBL.searchReportFileVersion(dto.getReportFileVersionSearchCond(), 0, 0);
		
		dto.setReportFileVersionList(reportFileVersionList);
		
		log.debug("========����汾��Ϣ��ѯ��������========");
		return dto;
	}
	/**
	 * ������Ȩ��Ϣ��ʼ��
	 * 
	 * @param dto IGSYM14DTO
	 * @return IGSYM14DTO
	 * @throws BLException
	 */
	
	public IGSYM04DTO roleReportFileDefinitionAction(IGSYM04DTO dto) throws BLException {
		
		log.debug("========���������Ϣ��ѯ����ʼ========");
		IGSYM0410Form form = dto.getIgSYM0410Form();
		
		ReportFileDefinition rfd = this.reportFileDefinitionBL.searchReportFileDefinitionByKey(form.getRfdid());
		
		form.setRfdtitle(rfd.getRfdtitle());//��ʾ����
		
		form.setRfdtype(rfd.getRfdtype());//����
		
		form.setRfdid(rfd.getRfdid());//����
		
		form.setRfdpictype(rfd.getRfdpictype());//������ʽ
		
		form.setRfdtypename(rfd.getCodeDetailTB().getCvalue());//������ʾ����

		dto.addMessage(new ActionMessage("IGCO10000.I001","���������Ϣ"));
		
		log.debug("========���������Ϣ��ѯ��������========");
		return dto;
	}

	/**
	 * <p>
	 * Description: ��ȡ���б�����Ȩ��Ϣ
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
		log.debug("========����Ȩ�����ѯ��ʼ========");
		IGSYM0415Form form = dto.getIgSYM0415Form();
		
		RoleReportSearchCondImpl cond = new RoleReportSearchCondImpl();
		cond.setRoleid(form.getRoleid());
		
		//ͨ��roleid��ѯ��ӵ�еı���id
		List<RoleReport> rfdids = this.roleReportBL.searchRoleReportByRoleid(cond);
		
		List<ReportFileDefinition> ownReportFileDefinition = new ArrayList<ReportFileDefinition>();
		
		//ѭ����ȡ��ӵ�б���id��ѯ��Ӧ������Ϣ������ownReportFileDefinition
		for(RoleReport r:rfdids){
			ownReportFileDefinition.add(this.reportFileDefinitionBL.searchReportFileDefinitionByKey(r.getRfdid()));
		}
		
		
		dto.setOwnReportFileDefinitionList(ownReportFileDefinition);
		
		log.debug("========����Ȩ�����ѯ��������========");
		return dto;
	}

	/**
	 * <p>
	 * Description: ��ȡȫ��������
	 * </p>
	 * 
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author renxiaodi
	 * @update
	 */
	public IGSYM04DTO searchReportFileDefinition(IGSYM04DTO dto) throws BLException {
		log.debug("========�����ѯ��ʼ========");
		
		List<ReportFileDefinition> allReportFileDefinition = this.reportFileDefinitionBL.searchReportFileDefinitionAll();
		
		dto.setReportFileDefinitionList(allReportFileDefinition);
		log.debug("========�����ѯ��������========");
		return dto;
	}

	/**
	 * <p>
	 * Description: ͨ����ɫid��ѯ��ɫ
	 * </p>
	 * 
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author renxiaodi
	 * @update
	 */
	public IGSYM04DTO searchRoleByRoleId(IGSYM04DTO dto) throws BLException {
		log.debug("========��ɫ��ѯ��ʼ========");
		
		Role role = this.roleBL.searchRoleByKey(dto.getRoleid());
		
		dto.setRole(role);

		log.debug("========��ɫ��������========");
		return dto;
	}
	
	/**
	 * <p>
	 * Description: ͨ������id��ѯ����
	 * </p>
	 * 
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author renxiaodi
	 * @update
	 */
	public IGSYM04DTO searchRolenameByRoleId(IGSYM04DTO dto) throws BLException {
		log.debug("========��ɫ����ѯ��ʼ========");
		
		Role role = this.roleBL.searchRoleByKey(dto.getRoleid());
		
		dto.setRolename(role.getRolename());

		log.debug("========��ɫ����������========");
		return dto;
	}
	
	/**
	 * <p>
	 * Description: ����ɫɾ��������Ȩ
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
		log.debug("========����ɫɾ��������ʼ========");
		//ѭ��ɾ��
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
		log.debug("========����ɫɾ������������========");

	}

	/**
	 * <p>
	 * Description: ����ɫ��ӱ�����Ȩ
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
		log.debug("========����û���ɫ����ʼ========");
		//ѭ�����
		for( int i=0;i<dto.getRfdids().length;i++ ){
			String rfdid = dto.getRfdids()[i];
			RoleReportTB roleReport = new RoleReportTB();
			roleReport.setRfdid(Integer.valueOf(rfdid));
			roleReport.setRoleid(dto.getRoleid());
			roleReportBL.registRoleReport(roleReport);
		}
		dto.addMessage(new ActionMessage("IGSYM0415.I001"));
		log.debug("========����û���ɫ��������========");
		return dto;
	}
	/**
	 * ���ý�ɫ������
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 */
	
	public IGSYM04DTO saveDutyflagAction(IGSYM04DTO dto)
			throws BLException {
		log.debug("========����ֵ���˴���ʼ========");
		String[] urid = dto.getUrid();
		//��ɫ�û��������ѯ
		List<UserRole> allUserRoleList = userRoleBL.searchUserRole(dto.getUserRoleSearchCond(), 0, 0);
		
		//����ɾ�������û���ʼ
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
		//����ɾ�������û�����
		
		if(urid == null) {
			for(UserRole ur : userRoleList) {
				if("1".equals(ur.getDutyflag())||"".equals(ur.getDutyflag())) {
					UserRoleTB userRoleTB = (UserRoleTB)SerializationUtils.clone(ur);
					userRoleTB.setDutyflag("0");
					userRoleBL.updateUserRole(userRoleTB);//����ֵ����
				}
			}
		} else {
			List<String> list = Arrays.asList(urid);
			for(UserRole ur : userRoleList) {
				if(list.contains(ur.getUrid().toString()) && "0".equals(ur.getDutyflag())) {
					UserRoleTB userRoleTB = (UserRoleTB)SerializationUtils.clone(ur);
					userRoleTB.setDutyflag("1");
					userRoleBL.updateUserRole(userRoleTB);//��Ȩֵ����
				} else if(!list.contains(ur.getUrid().toString()) && "1".equals(ur.getDutyflag())) {
					UserRoleTB userRoleTB = (UserRoleTB)SerializationUtils.clone(ur);
					userRoleTB.setDutyflag("0");
					userRoleBL.updateUserRole(userRoleTB);//����ֵ����
				} else if(list.contains(ur.getUrid().toString()) && " ".equals(ur.getDutyflag())) {
					UserRoleTB userRoleTB = (UserRoleTB)SerializationUtils.clone(ur);
					userRoleTB.setDutyflag("1");
					userRoleBL.updateUserRole(userRoleTB);
				}
			}
		}
		dto.addMessage(new ActionMessage("IGSYM0409.I001"));
		log.debug("========����ֵ���˴�������========");
		return dto;
	}
	
	/**
	 * <p>
	 * Description: ���ݽ�ɫ��ѯͬһ��֯���û�
	 * </p>
	 * 
	 * @return IGSYM04DTO
	 * @author   
	 * @update
	 */
	
	public IGSYM04DTO searchRoleUserByOrg(IGSYM04DTO dto) throws BLException{
		log.debug("========���ݽ�ɫ��ѯ�û�����ʼ========");
		//����DAO�ӿڲ�ѯ
		List<UserInfo> ret = userBL.searchUserInfo(dto.getUserInfoSearchCond(), 0, 0);
		List<UserInfo> realList = new ArrayList<UserInfo>();

		//��ȡ��ҳbean
		PagingDTO pDto = dto.getPagingDto();
		/**�����Ź���*/
		if(StringUtils.isNotEmpty(dto.getOrgid())){
			if(dto.getOrgid().length()<=7){//���Ϊ���������򶥼���������һ������������orgid����
				for(UserInfo ui : ret){
					if(dto.getOrgid().equals(ui.getOrgida())){
						realList.add(ui);
					}
				}
			}else{//��orgidǰ��λ����
				String orgid = dto.getOrgid().substring(0,7);
				for(UserInfo ui : ret){
					if(StringUtils.isNotEmpty(ui.getOrgida())){
						if(ui.getOrgida().length()>=7){//�ų���������
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

		log.debug("========���ݽ�ɫ��ѯ�û���������========");
		return dto;
	}
	
	/**
	 * <p>
	 * Description: ���ݽ�ɫ���Ͳ�ѯ�û�����Ҫ��ҳ
	 * </p>
	 * 
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author   
	 */
	
	public IGSYM04DTO searchUserByRoleTypeNoPage(IGSYM04DTO dto) throws BLException{
		
		log.debug("========���ݽ�ɫ���Ͳ�ѯ�û�����ʼ========");
		UserInfoSearchCondImpl userSearchCondImpl = new UserInfoSearchCondImpl();
		
		userSearchCondImpl.setRoleida(dto.getRoleid());

		List<UserInfo> userInfoList = userBL.searchUserInfo(userSearchCondImpl);

		dto.setUserInfoList(userInfoList);
		dto.setRole(roleBL.getRole(dto.getRoleid()));
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",userInfoList.size()));// xd-fixed
		
		log.debug("========���ݽ�ɫ���Ͳ�ѯ�û���������========");
		
		return dto;
	}
	
	/**
	 * <p>
	 * Description: ɾ����ɫ�û�
	 * </p>
	 * 
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author   
	 * @update
	 */
	public IGSYM04DTO deleteRoleUser(IGSYM04DTO dto) throws BLException {
		
		log.debug("========ɾ����ɫ�û�����ʼ========");
		
		//ѭ��ɾ��
		for(int i = 0 ; i < dto.getUrid().length ; i++){
			
			UserRoleSearchCondImpl userRoleSearchCondImpl =  new UserRoleSearchCondImpl();

			userRoleSearchCondImpl.setUserid(dto.getUrid()[i]);
			userRoleSearchCondImpl.setRoleid(dto.getRoleid());

			List<UserRole> userRoleList = userRoleBL.searchUserRole(userRoleSearchCondImpl);
	
			for(UserRole userRole : userRoleList) {			
				//��ȡ��Դ���û���ɫ��ϵ��ʵ��
				Role role = roleBL.getRole(userRole.getRoleid());//��ȡ�ù�ϵ���еĽ�ɫʵ��
				User user = userBL.searchUserByKey(userRole.getUserid());//��ȡ�ù�ϵ���е��û�ʵ��
				if(role.getRoletype().equals("IGSY01")){
					//ͬ��ɾ������
					String res = synSubjectRoleDateDel(user.getUserstatus(),role.getFingerPrint());
					if("-1".equals(res)){
						throw new BLException("IGCO10000.E132","ɾ��");
					}else if("Role-2".equals(res)){
						throw new BLException("IGCO10000.E133","ɾ��","��ɫ");
					}else if("User-2".equals(res)){
//						throw new BLException("IGCO10000.E133","ɾ��","�û�");
						log.info("========�û���������û���Ϣ========");
					}else if("0".equals(res)){
						throw new BLException("IGCO10000.E029","�û���ɫ��ϵ");
					}else if(res.equals("SUCCESS")){
						//Ԥ��
						log.info("========ͬ��ɾ���û���ɫ��ϵ��Ϣ�ɹ�========");
					}else{
						throw new BLException("IGCO10000.E135",res);
					}
				}
				
				//�û���ɫɾ������
				userRoleBL.deleteUserRoleByKey(userRole.getUrid());
			}
		}
		
		dto.addMessage(new ActionMessage("IGSYM0402.I002"));

		log.debug("========ɾ����ɫ�û���������========");
		
		return dto;
		
	}
	
	/**
	 * <p>
	 * Description: ���ݽ�ɫ���Ͳ�ѯ�����ڸý�ɫ��ͬ���û�
	 * </p>
	 * 
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author   
	 */
	public IGSYM04DTO searchUserNoByRoleTypeSyn(IGSYM04DTO dto) throws BLException{

		log.debug("========���ݽ�ɫ���Ͳ�ѯ�����ڸý�ɫ���û�========");

		// ��ѯ��¼����
		int totalCount = userNotRoleBL.getSearchCountSyn(dto.getUserNotRoleVWSearchCond());

		if (totalCount == 0) {
			log.debug("========��ѯ���ݲ�����========");
			// ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========��ѯ���ݼ�������========");
			// ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}
		
		//��ȡ��ҳbean
		PagingDTO pDto = dto.getPagingDto();

		//����DAO�ӿڲ�ѯ
		List<UserNotRole> ret = userNotRoleBL.searchUserNotRoleSyn(dto.getUserNotRoleVWSearchCond() , pDto.getFromCount(), pDto.getPageDispCount());
		
		pDto.setTotalCount(totalCount);

		dto.setUserNotRoleList(ret);
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		
		log.debug("========���ݽ�ɫ���Ͳ�ѯ�����ڸý�ɫ���û�========");
		
		return dto;
	}
	
	/**
	 * <p>
	 * Description: ���ݽ�ɫ���Ͳ�ѯ�����ڸý�ɫ���û�
	 * </p>
	 * 
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author   
	 */
	
	public IGSYM04DTO searchUserNoByRoleType(IGSYM04DTO dto) throws BLException{

		log.debug("========���ݽ�ɫ���Ͳ�ѯ�����ڸý�ɫ���û�========");

		// ��ѯ��¼����
		int totalCount = userNotRoleBL.getSearchCount(dto.getUserNotRoleVWSearchCond());

		if (totalCount == 0) {
			log.debug("========��ѯ���ݲ�����========");
			// ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========��ѯ���ݼ�������========");
			// ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}
		
		//��ȡ��ҳbean
		PagingDTO pDto = dto.getPagingDto();

		//����DAO�ӿڲ�ѯ
		List<UserNotRole> ret = userNotRoleBL.searchUserNotRole(dto.getUserNotRoleVWSearchCond() , pDto.getFromCount(), pDto.getPageDispCount());
		
		pDto.setTotalCount(totalCount);

		dto.setUserNotRoleList(ret);
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		
		log.debug("========���ݽ�ɫ���Ͳ�ѯ�����ڸý�ɫ���û�========");
		
		return dto;
	}
	
	/**
	 * <p>
	 * Description: ��ӽ�ɫ�û�
	 * </p>
	 * 
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author   
	 * @update
	 */
	public IGSYM04DTO saveRoleUser(IGSYM04DTO dto) throws BLException {
		
		log.debug("========��ӽ�ɫ�û�����ʼ========");
		
		Integer roleid = dto.getRoleid();
		Role role = roleBL.searchRoleByKey(roleid);//��ȡ�ù�ϵ���еĽ�ɫʵ��
		
		//ѭ�����
		for(int i = 0 ; i < dto.getUrid().length ; i++){	
			String urid = dto.getUrid()[i];
			
			User user = userBL.searchUserByKey(urid.split("-")[0]);//ѭ����ȡ�û�ʵ��
			
			//�ж��Ƿ���ҵ����Դͬ���Ľ�ɫ
			if(role.getRoletype().equals("IGSY01")){
				String res = synSubjectRoleDateIns(user.getUserstatus(),role.getFingerPrint());
				if("-1".equals(res)){
					throw new BLException("IGCO10000.E132","���");
				}else if("Role-2".equals(res)){
					throw new BLException("IGCO10000.E133","���","��ɫ");
				}else if("User-2".equals(res)){
					throw new BLException("IGCO10000.E133","���","�û�");
				}else if("0".equals(res)){
					throw new BLException("IGCO10000.E029","�û���ɫ��ϵ");
				}else if(res.equals("SUCCESS")){
					//Ԥ��
					log.info("========ͬ������û���ɫ��ϵ��Ϣ�ɹ�========");
				}else{
					throw new BLException("IGCO10000.E130",res);
				}
			}
			
			UserRoleTB userRole = new UserRoleTB();
			
			userRole.setUserid(urid.split("-")[0]);//�û�id
			userRole.setRoleid(dto.getRoleid());//��ɫid
			userRole.setOrgid(urid.split("-")[1]);//����id
			userRole.setRolemanager("0");

			userRoleBL.registUserRole(userRole);
			
		}
		
		dto.addMessage(new ActionMessage("IGSYM0402.I001"));
		
		log.debug("========��ӽ�ɫ�û���������========");
		
		return dto;
		
	}
	
	
	/** ��Դ����Ȩ */
	/**
	 * ��ѯͬ���Ľ�ɫ�б�
	 * @return
	 * @throws BLException
	 */
	public IGSYM04DTO searchSYNRoleAction(IGSYM04DTO dto) throws BLException {
		log.debug("========ͬ����ɫ��ѯ����ʼ========");
		/** �޷�ʹ���ѷ�װ�ķ����õ���Ҫ����Ϣֻ����ȫ���ٴ���Ҳ�޷����з�ҳ */
		RoleSearchCond cond = new RoleSearchCondImpl();
//		int totalCount = roleBL.getRoleSearchCount(cond);
//		if (totalCount == 0) {
//			log.debug("========��ѯ���ݲ�����========");
//			// ��ѯ���ݲ�����
//			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
//			return dto;
//		}
//		if (totalCount > dto.getMaxSearchCount()) {
//			log.debug("========��ѯ���ݼ�������========");
//			// ��ѯ���ݼ�������
//			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
//					.getMaxSearchCount(), totalCount));
//			return dto;
//		}
//		//��ȡ��ҳbean
//		PagingDTO pDto = dto.getPagingDto();
		//����DAO�ӿڲ�ѯ
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
		log.debug("========ͬ����ɫ��ѯ��������========");
		return dto;
	}
}
