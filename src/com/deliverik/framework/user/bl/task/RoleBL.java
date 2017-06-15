package com.deliverik.framework.user.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.condition.RoleSearchCond;

/**
 * <p>
 * 角色信息业务逻辑
 * </p>
 */
public interface RoleBL extends BaseBL {
	
	/**
	 * 根据检索条件取得角色信息条数
	 * 
	 * @param cond 角色信息检索条件
	 * @return 角色信息条数
	 */
	
	public int getRoleSearchCount(RoleSearchCond cond);

	/**
	 * 根据角色信息主键取得角色信息
	 * 
	 * @param roleid 角色信息主键
	 * @return 角色信息
	 * @throws BLException 
	 */
	public Role searchRoleByKey(Integer roleid) throws BLException;
	
	/**
	 * 根据检索条件取得角色信息列表
	 * 
	 * @param cond 角色信息检索条件
	 * @return 角色信息列表
	 */
	
	public List<Role> searchRole(RoleSearchCond cond);
	
	/**
	 * 根据检索条件取得角色信息列表(分页查询用)
	 * 
	 * @param cond 角色信息检索条件
	 * @param start 检索记录起始条数
	 * @param count 检索记录件数
	 * @return 角色信息列表
	 */
	
	public List<Role> searchRole(RoleSearchCond cond, int start, int count);
	
	/**
	 * 保存角色信息处理
	 * 
	 * @param role 保存的角色信息数据
	 * @return 角色信息
	 * @throws BLException
	 */
	public Role registRole(Role role) throws BLException;
	
	/**
	 * 删除角色信息处理
	 * 
	 * @param role 删除的角色信息数据
	 * @return
	 * @throws BLException
	 */
	public void deleteRole(Role role) throws BLException;
	
	/**
	 * 根据角色信息主键删除角色信息处理
	 * 
	 * @param roleid 删除角色信息的主键
	 * @return
	 * @throws BLException
	 */
	public void deleteRoleByKey(Integer roleid) throws BLException;


	/**
	 * 变更角色信息处理
	 * 
	 * @param role 变更的角色信息数据
	 * @return 角色信息
	 * @throws BLException
	 */
	public Role updateRole(Role role) throws BLException;
	
	/**
	 * 流程管理员角色判断
	 * 
	 * @param roleid 角色信息ID
	 * @return true:是,false:否
	 * @throws BLException 
	 *
	 */
	
	public boolean isProcessAdminRole(Integer roleid) throws BLException;
	
	/**
	 * 流程分派者角色判断
	 * 
	 * @param roleid 角色信息ID
	 * @return true:是,false:否
	 * @throws BLException 
	 *
	 */
	
	public boolean isProcessDispatchRole(Integer roleid) throws BLException;
	
	/**
	 * 指定角色所属管理范围内流程角色取得，根据参数flag判断是否包括流程管理员
	 * true:是,false:否
	 * @param roleid 角色信息ID
	 * @param flag 是否包括流程管理员
	 * @return 角色信息列表
	 *
	 */
	
	public List<Role> getRoleDomain(Integer roleid, boolean flag) throws BLException;
	
	/**
	 * <p>
	 * 获取系统中可以分派的角色集合，既不是系统中的流程管理角色
	 * </p>
	 * 
	 * @return 可以分派的角色集合
	 *
	 */

	public List<Role> getRolesNotInProcess();
	
	/**
	 * <p>
	 * 获取指定的角色
	 * </p>
	 * 
	 * @param roleId 角色ID
	 * @return 指定的角色对象
	 * @throws BLException
	 *
	 */
	
	public Role getRole(Integer roleId) throws BLException;
	
	/**
	 * <p>
	 * 获取指定类型的角色
	 * </p>
	 * 
	 * @param roletype 角色类型
	 * @return 指定的角色对象
	 *
	 */

	public List<Role> getRoleByType(String roletype);
	
	/**
	 * <p>
	 * 获取系统中的审批角色
	 * </p>
	 * 
	 * @return 系统中的审批角色集合
	 *
	 */

	public List<Role> getApproveRoles();
	
	/**
	 * 根据检索条件取得角色信息结果条数(自定义流程分派时查询该流程支持的角色使用)
	 * 
	 * @param cond 角色信息检索条件
	 * @param start 检索记录起始条数
	 * @param count 检索记录件数
	 * @return 角色信息检索结果列表
	 */
	public int searchRoleCountForSelfDef(RoleSearchCond cond);
	
	
	/**
	 * 根据检索条件取得角色信息列表(自定义流程分派时查询该流程支持的角色使用)
	 * 
	 * @param cond 角色信息检索条件
	 * @param start 检索记录起始条数
	 * @param count 检索记录件数
	 * @return 角色信息检索结果列表
	 */
	public List<Role> searchRoleForSelfDef(RoleSearchCond cond, int start, int count);
}
