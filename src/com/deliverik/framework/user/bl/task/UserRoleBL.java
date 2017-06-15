package com.deliverik.framework.user.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.user.model.UserRole;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.user.model.condition.UserRoleSearchCond;
import com.deliverik.framework.user.model.condition.UserRoleVWSearchCond;

/**
 * <p>
 * 用户角色授权信息业务逻辑
 * </p>
 */
public interface UserRoleBL extends BaseBL {
	
	/**
	 * 根据检索条件取得用户角色授权信息条数
	 * 
	 * @param cond 用户角色授权信息检索条件
	 * @return 用户角色授权信息条数
	 */
	
	public int getUserRoleSearchCount(UserRoleSearchCond cond);

	/**
	 * 根据用户角色授权信息主键取得用户角色授权信息
	 * 
	 * @param urid 用户角色授权信息主键
	 * @return 用户角色授权信息
	 * @throws BLException 
	 */
	public UserRole searchUserRoleByKey(Integer urid) throws BLException;
	
	/**
	 * 根据检索条件取得用户角色授权信息列表
	 * 
	 * @param cond 用户角色授权信息检索条件
	 * @return 用户角色授权信息列表
	 */
	
	public List<UserRole> searchUserRole(UserRoleSearchCond cond);
	
	/**
	 * 根据检索条件取得用户角色授权信息列表(分页查询用)
	 * 
	 * @param cond 用户角色授权信息检索条件
	 * @param start 检索记录起始条数
	 * @param count 检索记录件数
	 * @return 用户角色授权信息列表
	 */
	
	public List<UserRole> searchUserRole(UserRoleSearchCond cond, int start, int count);
	
	/**
	 * 保存用户角色授权信息处理
	 * 
	 * @param userRole 保存的用户角色授权信息
	 * @return 保存后用户角色授权信息
	 * @throws BLException
	 */
	public UserRole registUserRole(UserRole userRole) throws BLException;
	
	/**
	 * 删除用户角色授权信息处理
	 * 
	 * @param userRole 删除的用户角色授权信息
	 * @return
	 * @throws BLException
	 */
	public void deleteUserRole(UserRole userRole) throws BLException;
	
	/**
	 * 根据用户角色授权信息主键删除用户角色授权信息处理
	 * 
	 * @param urid 删除用户角色授权信息的主键
	 * @return
	 * @throws BLException
	 */
	public void deleteUserRoleByKey(Integer urid) throws BLException;


	/**
	 * 变更用户角色授权信息处理
	 * 
	 * @param userRole 变更的用户角色授权信息
	 * @return 变更后用户角色授权信息
	 * @throws BLException
	 */
	public UserRole updateUserRole(UserRole userRole) throws BLException;
	
	/**
	 * 根据检索条件取得用户角色授权信息条数
	 * 
	 * @param cond 用户角色授权信息检索条件
	 * @return 用户角色授权条数
	 */
	
	public int getUserRoleVWSearchCount(UserRoleVWSearchCond cond);

	/**
	 * 根据检索条件取得用户角色授权信息列表
	 * 
	 * @param cond 用户角色授权信息检索条件
	 * @return 用户角色授权信息列表
	 */
	public List<UserRoleInfo> searchUserRoleVW(UserRoleVWSearchCond cond);
	
	/**
	 * 根据检索条件取得用户角色授权信息列表(分页查询用)
	 * 
	 * @param cond 用户角色授权信息检索条件
	 * @param start 检索记录起始条数
	 * @param count 检索记录件数
	 * @return 用户角色授权信息列表
	 */
	public List<UserRoleInfo> searchUserRoleVW(UserRoleVWSearchCond cond, int start, int count);

	/**
	 * <p>
	 * 获取指定用户被授予的所有流程角色列表
	 * </p>
	 * 
	 * @param userId 用户ID
	 * @return 指定用户被授予的所有流程角色列表
	 *
	 */
	public List<UserRoleInfo> getUserRoles(String userId);
	
	
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
	public boolean isRoleInUserRole(String userId, Integer roleId);
	
	/**
	 * <p>
	 * 获取指定用户被授予的流程管理角色以外的所有角色信息
	 * </p>
	 * 
	 * @param userId 用户ID
	 * @return 流程管理角色以外的所有角色信息
	 *
	 */
	public List<UserRoleInfo> getUserRolesNotInProcess(String userId);
	
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
	public boolean checkRoleManagerByType(String userId, String roletype);
	
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
	public boolean checkRoleManagerByID(String userId, Integer roleId);
	
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
	public boolean checkRoleDutyflagByID(String userId, Integer roleId);
	
	/**
	 * 查询流程定义中所需要的人员和角色信息
	 * @param pdid
	 * @return
	 */
	public List<UserRoleInfo> findByPdid(String pdid);
}
