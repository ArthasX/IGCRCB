package com.deliverik.framework.user.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.user.model.RoleAction;
import com.deliverik.framework.user.model.condition.RoleActionSearchCond;

/**
 * <p>
 * 角色菜单授权信息业务逻辑
 * </p>
 */
public interface RoleActionBL extends BaseBL {
	

	/**
	 * 根据检索条件取得角色菜单授权信息条数
	 * 
	 * @param cond 角色菜单授权信息检索条件
	 * @return 角色菜单授权信息条数
	 */
	
	public int getRoleActionSearchCount(RoleActionSearchCond cond);

	/**
	 * 根据角色菜单授权信息主键取得角色菜单授权信息
	 * 
	 * @param raid 角色菜单授权信息主键
	 * @return 角色菜单授权信息
	 * @throws BLException 
	 */
	public RoleAction searchRoleActionByKey(Integer raid) throws BLException;
	
	/**
	 * 根据检索条件取得角色菜单授权信息列表
	 * 
	 * @param cond 角色菜单授权信息检索条件
	 * @return 角色菜单授权信息列表
	 */
	
	public List<RoleAction> searchRoleAction(RoleActionSearchCond cond);
	
	/**
	 * 根据检索条件取得角色菜单授权信息列表(分页查询用)
	 * 
	 * @param cond 角色菜单授权信息检索条件
	 * @param start 检索记录起始条数
	 * @param count 检索记录件数
	 * @return 角色菜单授权信息列表
	 */
	
	public List<RoleAction> searchRoleAction(RoleActionSearchCond cond, int start, int count);
	
	/**
	 * 保存角色菜单授权信息处理
	 * 
	 * @param action 保存的角色菜单授权信息
	 * @return 保存后角色菜单授权信息
	 * @throws BLException
	 */
	public RoleAction registRoleAction(RoleAction action) throws BLException;
	
	/**
	 * 删除角色菜单授权信息处理
	 * 
	 * @param action 删除的角色菜单授权信息
	 * @return
	 * @throws BLException
	 */
	public void deleteRoleAction(RoleAction action) throws BLException;
	
	/**
	 * 根据角色菜单授权信息主键删除角色菜单授权信息处理
	 * 
	 * @param raid 删除角色菜单授权信息的主键
	 * @return
	 * @throws BLException
	 */
	public void deleteRoleActionByKey(Integer raid) throws BLException;

	/**
	 * 变更角色菜单授权信息处理
	 * 
	 * @param action 变更的角色菜单授权信息
	 * @return 变更后角色菜单授权信息
	 * @throws BLException
	 */
	public RoleAction updateRoleAction(RoleAction action) throws BLException;
	
}
