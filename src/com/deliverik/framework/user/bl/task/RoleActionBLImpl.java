package com.deliverik.framework.user.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.user.model.RoleAction;
import com.deliverik.framework.user.model.condition.RoleActionSearchCond;
import com.deliverik.framework.user.model.dao.RoleActionTBDAO;

/**
 * <p>
 * 角色菜单授权信息业务逻辑实现
 * </p>
 */
public class RoleActionBLImpl extends BaseBLImpl implements RoleActionBL {
	
	/** 角色菜单授权信息相关操作DAO */
	
	protected RoleActionTBDAO roleActionTBDAO;

	/**
	 * 角色菜单授权信息相关操作DAO设定
	 * @param roleActionTBDAO 角色菜单授权信息相关操作DAO
	 */
	
	public void setRoleActionTBDAO(RoleActionTBDAO roleActionTBDAO) {
		this.roleActionTBDAO = roleActionTBDAO;
	}
	
	/**
	 * 根据检索条件取得角色菜单授权信息结果条数
	 * 
	 * @param cond 角色菜单授权信息检索条件
	 * @return 角色菜单授权信息结果条数
	 */
	public int getRoleActionSearchCount(RoleActionSearchCond cond){

		return roleActionTBDAO.getSearchCount(cond);
	}

	
	/**
	 * 根据角色菜单授权信息主键取得角色菜单授权信息
	 * 
	 * @param raid 角色菜单授权信息主键
	 * @return 角色菜单授权信息
	 * @throws BLException 
	 */
	public RoleAction searchRoleActionByKey(Integer raid) throws BLException{

		return checkExistRoleAction(raid);
	}
	
	/**
	 * 根据检索条件取得角色菜单授权信息列表
	 * 
	 * @param cond 角色菜单授权信息检索条件
	 * @return 角色菜单授权信息检索结果列表
	 */

	public List<RoleAction> searchRoleAction(RoleActionSearchCond cond){

		List<RoleAction> ret = roleActionTBDAO.findByCond(cond,0,0);
		return ret;
	}

	/**
	 * 根据检索条件取得角色菜单授权信息列表
	 * 
	 * @param cond 角色菜单授权信息检索条件
	 * @param start 检索记录起始条数
	 * @param count 检索记录件数
	 * @return 角色菜单授权信息检索结果列表
	 */
	public List<RoleAction> searchRoleAction(RoleActionSearchCond cond, int start, int count){

		List<RoleAction> ret = roleActionTBDAO.findByCond(cond,start,count);
		return ret;
	}

	/**
	 * 保存角色菜单授权信息处理
	 * 
	 * @param roleAction 保存的角色菜单授权信息数据
	 * @return 角色菜单授权信息
	 * @throws BLException
	 */
	public RoleAction registRoleAction(RoleAction RoleAction) throws BLException{
		RoleAction ret = roleActionTBDAO.save(RoleAction);
		return ret;
	}

	/**
	 * 变更角色菜单授权信息处理
	 * 
	 * @param roleAction 变更的角色菜单授权信息数据
	 * @return 角色菜单授权信息
	 * @throws BLException
	 */
	public RoleAction updateRoleAction(RoleAction roleAction) throws BLException{
		checkExistRoleAction(roleAction.getRaid());
		RoleAction ret = roleActionTBDAO.save(roleAction);
		return ret;
	}

	/**
	 * 删除角色菜单授权信息处理
	 * 
	 * @param roleAction 删除的角色菜单授权信息数据
	 * @return
	 * @throws BLException
	 */
	public void deleteRoleAction(RoleAction roleAction) throws BLException{
		checkExistRoleAction(roleAction.getRaid());
		roleActionTBDAO.delete(roleAction);
	}
	
	/**
	 * 根据角色菜单授权信息主键删除角色菜单授权信息处理
	 * 
	 * @param raid 删除角色菜单授权信息的主键
	 * @return
	 * @throws BLException
	 */

	public void deleteRoleActionByKey(Integer raid) throws BLException {
		RoleAction roleAction = checkExistRoleAction(raid);
		roleActionTBDAO.delete(roleAction);
	}
	
	/**
	 * 角色菜单授权信息存在检查
	 * 
	 * @param raid 角色菜单授权信息ID
	 * @return 角色菜单授权信息
	 * @throws BLException 
	 */
	protected RoleAction checkExistRoleAction(Integer raid) throws BLException{
		RoleAction info = roleActionTBDAO.findByPK(raid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","角色菜单授权");
		}
		
		return info;
	}
	
}
