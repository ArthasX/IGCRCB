/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sym.bl;

import java.util.List;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.bl.task.IG622BL;
import com.deliverik.framework.user.bl.task.OrganizationBL;
import com.deliverik.framework.user.bl.task.RoleBL;
import com.deliverik.framework.user.bl.task.UserBL;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.condition.OrganizationSearchCondImpl;
import com.deliverik.framework.user.model.condition.UserSearchCondImpl;
import com.deliverik.framework.user.model.entity.RoleTB;
import com.deliverik.framework.user.model.entity.UserTB;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.condition.IG677SearchCondImpl;
import com.deliverik.infogovernor.sym.dto.IGSYM02DTO;
import com.deliverik.infogovernor.sym.form.IGSYM0202Form;
import com.deliverik.infogovernor.sym.form.IGSYM0204Form;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 系统管理_用户管理_BLIMPL
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public class IGSYM02BLImpl extends BaseBLImpl implements IGSYM02BL {

	static Log log = LogFactory.getLog(IGSYM02BLImpl.class);
	
	/**
	 * 用户BL
	 */
	protected UserBL userBL;
	
	/**
	 * 用户角色BL
	 */
	protected UserRoleBL userRoleBL;
	
	/**
	 * 角色BL
	 */
	protected RoleBL roleBL;
	
	/**
	 * 机构BL
	 */
	protected OrganizationBL organizationBL;

	/** 流程处理BL */
	protected WorkFlowOperationBL workFlowOperationBL;
	
	/** 首页跳转URL定义BL */
	protected IG622BL ig622BL;
	
	/**
	 * 设置用户DAO
	 * @param userBL UserBL
	 */
	
	public void setUserBL(UserBL userBL) {
		this.userBL = userBL;
	}
	
	/**
	 * 设置用户角色BL
	 * @param userRoleBL UserRoleBL
	 */
	
	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}

	/**
	 * 设置机构BL
	 * @param organizationBL OrganizationBL
	 */

	public void setOrganizationBL(OrganizationBL organizationBL) {
		this.organizationBL = organizationBL;
	}
	
	/**
	 * 设置角色BL
	 * @param roleBL RoleBL
	 */
	
	public void setRoleBL(RoleBL roleBL) {
		this.roleBL = roleBL;
	}
	/**
	 * @param workFlowOperationBL the workFlowOperationBL to set
	 */
	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}
	
	/**
	 * 首页跳转URL定义BL设定
	 * 
	 * @param ig622BL 首页跳转URL定义BL
	 */
	public void setIg622BL(IG622BL ig622BL) {
		this.ig622BL = ig622BL;
	}
	
	/**
	 * <p>
	 * Description: 用户查询
	 * </p>
	 * 
	 * @param dto IGSYM02DTO
	 * @return IGSYM02DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM02DTO searchUserActionForIGASM0101() throws BLException {
		log.debug("========用户查询处理开始========");
		IGSYM02DTO dto = new IGSYM02DTO();
		UserSearchCondImpl cond = new UserSearchCondImpl();
		cond.setDeleteflag("0");//查询状态为可用的用户
		List<User> userList = userBL.searchUser(cond,0,0);
		dto.setUserList(userList);
		log.debug("========用户查询处理终了========");
		return dto;
	}
	
	
	/**
	 * <p>
	 * Description: 用户查询
	 * </p>
	 * 
	 * @param dto IGSYM02DTO
	 * @return IGSYM02DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM02DTO searchUserAction(IGSYM02DTO dto)
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
	 * Description: 用户删除（未完需要check）
	 * </p>
	 * 
	 * @param dto IGSYM02DTO
	 * @return IGSYM02DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM02DTO changeUserFlagAction(IGSYM02DTO dto) throws BLException {
		log.debug("========用户删除处理开始========");
		String userid = dto.getUserid();
		//调用DAO查询该主键标识的实体对象
		User user = userBL.searchUserByKey(userid);
		if("1".equals(user.getDeleteflag())){
			UserTB userTB = (UserTB)SerializationUtils.clone(user);
			userTB.setDeleteflag("0");
			userBL.registUser(userTB);
			dto.addMessage(new ActionMessage("IGCO10000.I009", "用户基本信息"));
		} else {
			IG677SearchCondImpl cond = new IG677SearchCondImpl();
			cond.setPpuserid(userid);
			List<IG500Info> processRecordList = workFlowOperationBL.queryCorrelationProcessByUserid(cond,0,0,1,1);
			if(processRecordList.size() == 0){
				userBL.deleteUser(user);
				dto.addMessage(new ActionMessage("IGCO10000.I008", "用户基本信息"));
			} else {
				String prserialnum = "";
				for (int i = 0; i < processRecordList.size(); i++) {
					prserialnum += processRecordList.get(i).getPrserialnum();
					if(i < processRecordList.size() - 1){
						prserialnum += ",";
					}
				}
				dto.addMessage(new ActionMessage("IGSYM0201.E001", prserialnum));
			}
		}
		log.debug("========用户删除处理终了========");
		return dto;
	}
	
	/**
	 * <p>
	 * Description: 用户新增
	 * </p>
	 * 
	 * @param dto IGSYM02DTO
	 * @return IGSYM02DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM02DTO insertUserAction(IGSYM02DTO dto) throws BLException {
		log.debug("========用户新增处理开始========");
		IGSYM0202Form form = dto.getIgsym0202Form();
		checkUser(form);
		User user = userBL.registUser(form);
		dto.setUser(user);
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "用户基本信息") );
		log.debug("========用户新增处理终了========");
		return dto;
	}
	
	/**
	 * <p>
	 * Description: 用户变更初始化
	 * </p>
	 * 
	 * @param dto IGSYM02DTO
	 * @return IGSYM02DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM02DTO initIGSYM0202Action(IGSYM02DTO dto) throws BLException {
		log.debug("========变更用用户基本信息查询处理开始========");
		IGSYM0202Form form = dto.getIgsym0202Form();
		User user = userBL.searchUserByKey(form.getUserid());
		form.setUserid(user.getUserid());
		form.setOrgid(user.getOrgid());
		form.setOrgidstr(user.getOrgid().toString());
		form.setUsername(user.getUsername());
		form.setUserdesc(user.getUserdesc());
		form.setPassword(user.getPassword());
		form.setRepassword(user.getPassword());
		form.setUserstatus(user.getUserstatus());
		form.setUserphone(user.getUserphone());
		form.setUsermobile(user.getUsermobile());
		form.setUseremail(user.getUseremail());
		form.setOrgname(user.getOrgname());
		form.setUsertype(user.getUsertype());
		form.setDeleteflag(user.getDeleteflag());
		form.setUserinfo(user.getUserinfo());
		form.setFingerPrint(user.getFingerPrint());
		//变更初始化模式
		form.setMode("1");
		dto.addMessage(new ActionMessage("IGCO10000.I001","用户基本信息"));
		log.debug("========变更用用户基本信息查询处理终了========");
		return dto;
	}
	
	/**
	 * <p>
	 * Description: 用户变更
	 * </p>
	 * 
	 * @param dto IGSYM02DTO
	 * @return IGSYM02DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	public IGSYM02DTO updateUserAction(IGSYM02DTO dto) throws BLException{
	    checkExistEntity(dto.getUser().getUserid());
		IGSYM0202Form form = dto.getIgsym0202Form();
		userBL.updateUser(form);
		dto.addMessage(new ActionMessage( "IGCO10000.I005", "用户基本信息") );
		return dto;
	}
	
	/**
	 * <p>
	 * Description: 用户变更
	 * </p>
	 * 
	 * @param dto IGSYM02DTO
	 * @return IGSYM02DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	public IGSYM02DTO updateUserManagerAction(IGSYM02DTO dto) throws BLException{
	    checkExistEntity(dto.getUser().getUserid());
		
		IGSYM0202Form form = dto.getIgsym0202Form();
		userBL.updateUser(dto.getUser());
		
		String[] rolemanager = form.getRolemanager();
		String[] mobile = form.getMobile();
		String[] rolemobile = form.getRolemobile();
		String[] roleid = form.getRoleid();
		if(roleid != null) {
			for(int i = 0; i < roleid.length; i++) {
				//0值班手机，1值班人
				if("0".equals(mobile[i]) || "1".equals(mobile[i])) {
					Role role = this.roleBL.searchRoleByKey(new Integer(roleid[i]));
					RoleTB roleTB = (RoleTB)SerializationUtils.clone(role);
					if(role != null) {
						if("0".equals(mobile[i])) {
							if(StringUtils.isEmpty(rolemobile[i])) {
								roleTB.setRoleinfo(null);
							} else {
								roleTB.setRoleinfo("###" + rolemobile[i]);
							}
						} else if("1".equals(mobile[i])) {
							User manger = this.userBL.searchUserByKey(rolemanager[i]);
							if(manger != null) {
								roleTB.setRoleinfo(manger.getUserid() + "###" + manger.getUsermobile());
							} else {
								throw new BLException("IGCO10000.E004","用户基本");
							}
						}
					} else {
						throw new BLException("IGCO10000.E004","角色基本");
					}
					this.roleBL.updateRole(roleTB);
					
				}
			}
		}
		dto.addMessage(new ActionMessage( "IGCO10000.I005", "用户基本信息") );
		return dto;
	}
	
	/**
	 * 调用DAO查询该主键标识的实体对象是否存在
	 * @param userid Integer
	 * @return User
	 * @throws BLException
	 */
	
	protected User checkExistEntity(String userid) throws BLException{
		User user = userBL.searchUserByKey(userid);
		if( user == null) {
			throw new BLException("IGCO10000.E004","用户基本");
		}
		return user;
	}
	
	
	/**
	 * 调用DAO查询该主键标识的实体对象
	 * @param userid Integer
	 * @return User
	 */
	
	public User registEntity(User user) throws BLException{
		checkNotExistEntity(user.getUserid());
		User ret = userBL.registUser(user);
		return ret;
	}
	
	public void checkUser(User user) throws BLException{
		checkNotExistEntity(user.getUserid());
	}
	
	
	
	/**
	 * 查询用户名是否存在
	 * @param userid String
	 * @throws BLException
	 */
	
	protected void checkNotExistEntity(String userid) throws BLException{
		UserSearchCondImpl cond = new UserSearchCondImpl();
		cond.setUserid(userid);
		List<User> infoList = userBL.searchUser(cond, 0, 0);
		if( infoList != null && infoList.size()>0 ) {
			throw new BLException("IGSYM0000.E001","ID","用户基本");
		}
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
	
	public IGSYM02DTO searchOrganizationAll(IGSYM02DTO dto) throws BLException{
		List<Organization> ret = organizationBL.searchOrganization(new OrganizationSearchCondImpl());
		dto.setOrganizationList(ret);
		return dto;
	}
	
	/**
	 * <p>
	 * Description: 用户数量查询
	 * </p>
	 * 
	 * @param dto IGSYM02DTO
	 * @return IGSYM02DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public int searchUserCount(IGSYM02DTO dto)
			throws BLException {
		log.debug("========用户数量查询处理开始========");
		UserSearchCondImpl searchCond = new UserSearchCondImpl();
		dto.setUserSearchCond(searchCond);
		// 查询记录总数
		int totalCount = userBL.getUserSearchCount(dto
				.getUserSearchCond());
		
		log.debug("========用户数量查询处理终了========");
		return totalCount;
	}
	
	/**
	 * <p>
	 * Description: 用户首页列表取得
	 * </p>
	 * 
	 * @param dto IGSYM02DTO
	 * @return IGSYM02DTO
	 * @throws BLException
	 * @update
	 */
	public IGSYM02DTO searchComboBoxAction(IGSYM02DTO dto) throws BLException {
		dto.setLst_LabelValueBean(ig622BL.getComboBox());
		return dto;
	}
	
	/**
	 * <p>
	 * Description: 用户查询
	 * 无分页
	 * </p>
	 * 
	 * @param dto IGSYM02DTO
	 * @return IGSYM02DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	public IGSYM02DTO searchUserActionNoPage(IGSYM02DTO dto) throws BLException {
		log.debug("========用户查询(无分页)处理开始========");
		//查询条件
		IGSYM0204Form form = dto.getIgsym0204Form();
		UserSearchCondImpl usercond = new UserSearchCondImpl();
		usercond.setOrgid_like(form.getOrgidstr());
		// 查询记录总数
		int totalCount = userBL.getUserSearchCount(usercond);
		if (totalCount == 0) {
			log.debug("========查询数据不存在========");
			// 查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========查询数据件数过多========");
			// 查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto.getMaxSearchCount(), totalCount));
			return dto;
		}
		//调用DAO接口查询
		List<User> userList = userBL.searchUser(usercond);
		dto.setUserList(userList);
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		log.debug("========用户查询(无分页)处理终了========");
		return dto;
	}
}
