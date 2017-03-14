package com.deliverik.framework.user.bl.task;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.user.model.UserRole;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.user.model.condition.UserRoleSearchCond;
import com.deliverik.framework.user.model.condition.UserRoleVWSearchCond;
import com.deliverik.framework.user.model.condition.UserRoleVWSearchCondImpl;
import com.deliverik.framework.user.model.dao.UserRoleTBDAO;
import com.deliverik.framework.user.model.dao.UserRoleVWDAO;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.framework.workflow.WorkFlowConstDefine;

/**
 * <p>
 * 用户角色授权信息业务逻辑实现
 * </p>
 */
public class UserRoleBLImpl extends BaseBLImpl implements UserRoleBL {
	
	/** 用户角色授权信息相关操作DAO */
	protected UserRoleTBDAO userRoleTBDAO;
	
	/** 用户角色授权信息相关操作DAO */
	protected UserRoleVWDAO userRoleVWDAO;

	/**
	 * 用户角色授权信息相关操作DAO设定
	 * @param userRoleTBDAO 用户角色授权信息相关操作DAO
	 */
	
	public void setUserRoleTBDAO(UserRoleTBDAO userRoleTBDAO) {
		this.userRoleTBDAO = userRoleTBDAO;
	}
	
	/**
	 * 用户角色授权信息相关操作DAO设定
	 * @param userRoleVWDAO 用户角色授权信息相关操作DAO
	 */
	
	public void setUserRoleVWDAO(UserRoleVWDAO userRoleVWDAO) {
		this.userRoleVWDAO = userRoleVWDAO;
	}
	
	/**
	 * 根据检索条件取得用户角色授权信息结果条数
	 * 
	 * @param cond 用户角色授权信息检索条件
	 * @return 用户角色授权信息结果条数
	 */
	public int getUserRoleSearchCount(UserRoleSearchCond cond){

		return userRoleTBDAO.getSearchCount(cond);
	}

	
	/**
	 * 根据用户角色授权信息主键取得用户角色授权信息
	 * 
	 * @param urid 用户角色授权信息主键
	 * @return 用户角色授权信息
	 * @throws BLException 
	 */
	public UserRole searchUserRoleByKey(Integer urid) throws BLException{

		return checkExistUserRole(urid);
	}
	
	/**
	 * 根据检索条件取得用户角色授权信息列表
	 * 
	 * @param cond 用户角色授权信息检索条件
	 * @return 用户角色授权信息检索结果列表
	 */

	public List<UserRole> searchUserRole(UserRoleSearchCond cond){

		List<UserRole> ret = userRoleTBDAO.findByCond(cond,0,0);
		return ret;
	}

	/**
	 * 根据检索条件取得用户角色授权信息列表
	 * 
	 * @param cond 用户角色授权信息检索条件
	 * @param start 检索记录起始条数
	 * @param count 检索记录件数
	 * @return 用户角色授权信息检索结果列表
	 */
	public List<UserRole> searchUserRole(UserRoleSearchCond cond, int start, int count){

		List<UserRole> ret = userRoleTBDAO.findByCond(cond,start,count);
		return ret;
	}

	/**
	 * 保存用户角色授权信息处理
	 * 
	 * @param userRole 保存的用户角色授权信息数据
	 * @return 用户角色授权信息
	 * @throws BLException
	 */
	public UserRole registUserRole(UserRole UserRole) throws BLException{
		UserRole ret = userRoleTBDAO.save(UserRole);
		return ret;
	}

	/**
	 * 变更用户角色授权信息处理
	 * 
	 * @param userRole 变更的用户角色授权信息数据
	 * @return 用户角色授权信息
	 * @throws BLException
	 */
	public UserRole updateUserRole(UserRole userRole) throws BLException{
		checkExistUserRole(userRole.getUrid());
		UserRole ret = userRoleTBDAO.save(userRole);
		return ret;
	}

	/**
	 * 删除用户角色授权信息处理
	 * 
	 * @param userRole 删除的用户角色授权信息数据
	 * @return
	 * @throws BLException
	 */
	public void deleteUserRole(UserRole userRole) throws BLException{
		checkExistUserRole(userRole.getUrid());
		userRoleTBDAO.delete(userRole);
	}
	
	/**
	 * 根据用户角色授权信息主键删除用户角色授权信息处理
	 * 
	 * @param urid 删除用户角色授权信息的主键
	 * @return
	 * @throws BLException
	 */

	public void deleteUserRoleByKey(Integer urid) throws BLException {
		UserRole userRole = checkExistUserRole(urid);
		userRoleTBDAO.delete(userRole);
	}
	
	/**
	 * 用户角色授权信息存在检查
	 * 
	 * @param urid 用户角色授权信息ID
	 * @return 用户角色授权信息
	 * @throws BLException 
	 */
	protected UserRole checkExistUserRole(Integer urid) throws BLException{
		UserRole info = userRoleTBDAO.findByPK(urid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","用户角色授权");
		}
		
		return info;
	}
	
	/**
	 * 根据检索条件取得用户角色授权条数
	 * 
	 * @param cond 用户角色授权信息检索条件
	 * @return 用户角色授权信息条数
	 */
	public int getUserRoleVWSearchCount(UserRoleVWSearchCond cond){

		return userRoleVWDAO.getSearchCount(cond);
	}

	/**
	 * 根据检索条件取得用户角色授权信息列表
	 * 
	 * @param cond 用户角色授权信息检索条件
	 * @return 用户角色授权信息列表
	 */
	public List<UserRoleInfo> searchUserRoleVW(UserRoleVWSearchCond cond){

		List<UserRoleInfo> ret = userRoleVWDAO.findByCond(cond,0,0);
		return ret;
	}

	/**
	 * 根据检索条件取得用户角色授权信息列表(分页查询用)
	 * 
	 * @param cond 用户角色授权信息检索条件
	 * @param start 检索记录起始条数
	 * @param count 检索记录件数
	 * @return 用户角色授权信息列表
	 */
	public List<UserRoleInfo> searchUserRoleVW(UserRoleVWSearchCond cond, int start, int count){

		List<UserRoleInfo> ret = userRoleVWDAO.findByCond(cond,start,count);
		return ret;
	}

	
	/**
	 * <p>
	 * 获取指定用户被授予的所有流程角色列表
	 * </p>
	 * 
	 * @param userId 用户ID
	 * @return 指定用户被授予的所有流程角色列表
	 *
	 */
	public List<UserRoleInfo> getUserRoles(String userId) {
		UserRoleVWSearchCondImpl cond = new UserRoleVWSearchCondImpl();
		cond.setUserid(userId);
		String roles_BP_EX = ResourceUtility.getString("ROLES_BP_EX");
		if(!StringUtils.isEmpty(roles_BP_EX)){
			cond.setRoles_BP_EX(roles_BP_EX.split(","));
		}
		cond.setRoles_Like(WorkFlowConstDefine.PROCESS_ROLE_MARK);
		List<UserRoleInfo> roleList = searchUserRoleVW(cond, 0, 0);
		return roleList;
	}
	
	/**
	 * <p>
	 * 判断指定用户是否被授予指定角色
	 * </p>
	 * 
	 * @param userId 用户ID
	 * @param roleId 角色ID
	 * @return false:未授予
	 *         true:授予
	 *
	 */
	public boolean isRoleInUserRole(String userId, Integer roleId) {
		UserRoleVWSearchCondImpl cond = new UserRoleVWSearchCondImpl();
		cond.setUserid(userId);
		cond.setRoleid(roleId);
		List<UserRoleInfo> roleList = searchUserRoleVW(cond, 0, 0);
		return roleList.isEmpty() ? false : true;
	}
	
	/**
	 * <p>
	 * 获取指定用户被授予的流程管理角色以外的所有角色信息
	 * </p>
	 * 
	 * @param userId 用户ID
	 * @return 流程管理角色以外的所有角色信息
	 *
	 */
	public List<UserRoleInfo> getUserRolesNotInProcess(String userId) {
		List<UserRoleInfo> roleList = getUserRoles(userId);
		for (int i = 0; i < roleList.size(); i++) {
			if (WorkFlowConstDefine.PROCESSADMIN_ROLE_TYPE.equals(roleList.get(i)
					.getRoletype())) {
				roleList.remove(i);
				i--;
			}
		}
		return roleList;
	}
	
	/**
	 * <p>
	 * 判断用户是否是指定角色类型的负责人
	 * </p>
	 * 
	 * @param userId 用户ID
	 * @param roletype 角色类型
	 * @return false:不是
	 *         true:是
	 *
	 */
	public boolean checkRoleManagerByType(String userId, String roletype) {
		UserRoleVWSearchCondImpl cond = new UserRoleVWSearchCondImpl();
		cond.setUserid(userId);
		cond.setRoletype(roletype);
		cond.setRolemanager(true);
		List<UserRoleInfo> roleList = searchUserRoleVW(cond, 0, 0);
		return roleList.isEmpty() ? false : true;
	}
	
	/**
	 * <p>
	 * 判断用户是否是指定角色的负责人
	 * </p>
	 * 
	 * @param userId 用户ID
	 * @param roleId 角色ID
	 * @return false:不是
	 *         true:是
	 *
	 */
	public boolean checkRoleManagerByID(String userId, Integer roleId) {
		UserRoleVWSearchCondImpl cond = new UserRoleVWSearchCondImpl();
		cond.setUserid(userId);
		cond.setRoleid(roleId);
		cond.setRolemanager(true);
		List<UserRoleInfo> roleList = searchUserRoleVW(cond, 0, 0);
		return roleList.isEmpty() ? false : true;
	}
	
	/**
	 * <p>
	 * 判断用户是否是指定角色的值班人
	 * </p>
	 * 
	 * @param userId 用户ID
	 * @param roleId 角色ID
	 * @return false:不是
	 *         true:是
	 *
	 */
	public boolean checkRoleDutyflagByID(String userId, Integer roleId) {
		UserRoleVWSearchCondImpl cond = new UserRoleVWSearchCondImpl();
		cond.setUserid(userId);
		cond.setRoleid(roleId);
		cond.setDutyflag(true);
		List<UserRoleInfo> roleList = searchUserRoleVW(cond, 0, 0);
		return roleList.isEmpty() ? false : true;
	}

	public List<UserRoleInfo> findByPdid(String pdid) {
		// TODO Auto-generated method stub
		return userRoleVWDAO.findByPdid(pdid);
	}
}
