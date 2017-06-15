package com.deliverik.framework.user.bl.task;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.condition.RoleSearchCond;
import com.deliverik.framework.user.model.condition.RoleSearchCondImpl;
import com.deliverik.framework.user.model.dao.RoleTBDAO;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.framework.workflow.WorkFlowConstDefine;

/**
 * <p>
 * 角色信息业务逻辑实现
 * </p>
 */
public class RoleBLImpl extends BaseBLImpl implements RoleBL {
	
	/** 角色信息相关操作DAO */
	
	protected RoleTBDAO roleTBDAO;

	/**
	 * 角色信息相关操作DAO设定
	 * @param roleTBDAO 角色信息相关操作DAO
	 */
	
	public void setRoleTBDAO(RoleTBDAO roleTBDAO) {
		this.roleTBDAO = roleTBDAO;
	}
	
	/**
	 * 根据检索条件取得角色信息结果条数
	 * 
	 * @param cond 角色信息检索条件
	 * @return 角色信息结果条数
	 */
	public int getRoleSearchCount(RoleSearchCond cond){

		return roleTBDAO.getSearchCount(cond);
	}

	
	/**
	 * 根据角色信息主键取得角色信息
	 * 
	 * @param roleid 角色信息主键
	 * @return 角色信息
	 * @throws BLException 
	 */
	public Role searchRoleByKey(Integer roleid) throws BLException{

		return checkExistRole(roleid);
	}
	
	/**
	 * 根据检索条件取得角色信息列表
	 * 
	 * @param cond 角色信息检索条件
	 * @return 角色信息检索结果列表
	 */

	public List<Role> searchRole(RoleSearchCond cond){

		List<Role> ret = roleTBDAO.findByCond(cond,0,0);
		return ret;
	}

	/**
	 * 根据检索条件取得角色信息列表
	 * 
	 * @param cond 角色信息检索条件
	 * @param start 检索记录起始条数
	 * @param count 检索记录件数
	 * @return 角色信息检索结果列表
	 */
	public List<Role> searchRole(RoleSearchCond cond, int start, int count){

		List<Role> ret = roleTBDAO.findByCond(cond,start,count);
		return ret;
	}

	/**
	 * 保存角色信息处理
	 * 
	 * @param role 保存的角色信息数据
	 * @return 角色信息
	 * @throws BLException
	 */
	public Role registRole(Role Role) throws BLException{
		Role ret = roleTBDAO.save(Role);
		return ret;
	}

	/**
	 * 变更角色信息处理
	 * 
	 * @param role 变更的角色信息数据
	 * @return 角色信息
	 * @throws BLException
	 */
	public Role updateRole(Role role) throws BLException{
		checkExistRole(role.getRoleid());
		Role ret = roleTBDAO.save(role);
		return ret;
	}

	/**
	 * 删除角色信息处理
	 * 
	 * @param role 删除的角色信息数据
	 * @return
	 * @throws BLException
	 */
	public void deleteRole(Role role) throws BLException{
		checkExistRole(role.getRoleid());
		roleTBDAO.delete(role);
	}
	
	/**
	 * 根据角色信息主键删除角色信息处理
	 * 
	 * @param roleid 删除角色信息的主键
	 * @return
	 * @throws BLException
	 */

	public void deleteRoleByKey(Integer roleid) throws BLException {
		Role role = checkExistRole(roleid);
		roleTBDAO.delete(role);
		
	}
	
	/**
	 * 角色信息存在检查
	 * 
	 * @param roleid 角色信息ID
	 * @return 角色信息
	 * @throws BLException 
	 */
	protected Role checkExistRole(Integer roleid) throws BLException{
		Role info = roleTBDAO.findByPK(roleid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","角色");
		}
		
		return info;
	}
	
	/**
	 * 流程管理员角色判断
	 * 
	 * @param roleid 角色信息ID
	 * @return true:是,false:否
	 * @throws BLException 
	 *
	 */
	
	public boolean isProcessAdminRole(Integer roleid) throws BLException {
		Role role = checkExistRole(roleid);
		if(WorkFlowConstDefine.PROCESSADMIN_ROLE_TYPE.equals(role.getRoletype())) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 流程分派者角色判断
	 * 
	 * @param roleid 角色信息ID
	 * @return true:是,false:否
	 * @throws BLException 
	 *
	 */
	
	public boolean isProcessDispatchRole(Integer roleid) throws BLException {
		Role role = checkExistRole(roleid);
		if(WorkFlowConstDefine.DISPATCH_ROLE_TYPE.equals(role.getRoletype())) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 指定角色所属管理范围内流程角色取得，根据参数flag判断是否包括流程管理员
	 * true:是,false:否
	 * @param roleid 角色信息ID
	 * @param flag 是否包括流程管理员
	 * @return 角色信息列表
	 *
	 */
	
	public List<Role> getRoleDomain(Integer roleid, boolean flag) throws BLException{
		Role role = checkExistRole(roleid);
		RoleSearchCondImpl cond = new RoleSearchCondImpl();
		cond.setRoledomain_Like(role.getRoledomain());
		cond.setRoles_Like(WorkFlowConstDefine.PROCESS_ROLE_MARK);
		List<Role> roleList = roleTBDAO.findByCond(cond, 0, 0);
		if(!flag) {
			for(Iterator<Role> iter = roleList.iterator(); iter.hasNext();) {
				if(WorkFlowConstDefine.PROCESSADMIN_ROLE_TYPE.equals(iter.next().getRoletype())) {
					iter.remove();
				}
			}
		}
		return roleList;
	}
	
	
	/**
	 * <p>
	 * 获取系统中可以分派的角色集合，既不是系统中的流程管理角色
	 * </p>
	 * 
	 * @return 可以分派的角色集合
	 *
	 */

	public List<Role> getRolesNotInProcess() {
		RoleSearchCondImpl cond = new RoleSearchCondImpl();
		cond.setRoletype(WorkFlowConstDefine.PROCESSADMIN_ROLE_TYPE);
		cond.setRoletypeEqual(2);
		String roles_BP_EX = ResourceUtility.getString("ROLES_BP_EX");
		if(!StringUtils.isEmpty(roles_BP_EX)){
			cond.setRoles_BP_EX(roles_BP_EX.split(","));
		}
		cond.setRoles_Like(WorkFlowConstDefine.PROCESS_ROLE_MARK);
		return searchRole(cond, 0, 0);
	}
	
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
	
	public Role getRole(Integer roleId) throws BLException {
		return searchRoleByKey(roleId);
	}
	
	/**
	 * <p>
	 * 获取指定类型的角色
	 * </p>
	 * 
	 * @param roletype 角色类型
	 * @return 指定的角色对象
	 *
	 */

	public List<Role> getRoleByType(String roletype) {
		RoleSearchCondImpl cond = new RoleSearchCondImpl();
		cond.setRoletype(roletype);
		return searchRole(cond, 0, 0);
	}
	
	/**
	 * <p>
	 * 获取系统中的审批角色
	 * </p>
	 * 
	 * @return 系统中的审批角色集合
	 *
	 */

	public List<Role> getApproveRoles() {
		RoleSearchCondImpl cond = new RoleSearchCondImpl();
		cond.setRoletype(WorkFlowConstDefine.APPROVE_ROLE_TYPE);
		return searchRole(cond, 0, 0);
	}
	
	/**
	 * 根据检索条件取得角色信息结果条数(自定义流程分派时查询该流程支持的角色使用)
	 * 
	 * @param cond 角色信息检索条件
	 * @param start 检索记录起始条数
	 * @param count 检索记录件数
	 * @return 角色信息检索结果列表
	 */
	public int searchRoleCountForSelfDef(RoleSearchCond cond){

		int ret = roleTBDAO.searchRoleCountForSelfDef(cond);
		return ret;
	}
	
	
	/**
	 * 根据检索条件取得角色信息列表(自定义流程分派时查询该流程支持的角色使用)
	 * 
	 * @param cond 角色信息检索条件
	 * @param start 检索记录起始条数
	 * @param count 检索记录件数
	 * @return 角色信息检索结果列表
	 */
	public List<Role> searchRoleForSelfDef(RoleSearchCond cond, int start, int count){

		List<Role> ret = roleTBDAO.searchRoleForSelfDef(cond,start,count);
		return ret;
	}
	
}
