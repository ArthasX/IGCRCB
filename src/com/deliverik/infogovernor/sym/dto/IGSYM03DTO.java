/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sym.dto;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.condition.RoleSearchCond;
import com.deliverik.infogovernor.sym.form.IGSYM0302Form;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 系统管理_角色管理_DTO
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSYM03DTO extends BaseDTO implements Serializable {
	
	/**
	 * 角色对象
	 */
	
	protected Role role;
	/**
	 * 角色查询Bean
	 */
	
	protected RoleSearchCond roleSearchCond;
	
	/**
	 * 角色对象List
	 */
	
	protected List<Role> roleList;

	/**
	 * 允许查询的最大记录数
	 */
	
	protected int maxSearchCount;

	/**
	 * 分页Bean
	 */
	
	protected PagingDTO pagingDto;
	
	/**
	 * 角色删除主键
	 */
	
	protected String[] deleteRoleid;
	
	/**
	 * 变更用角色基本信息
	 */
	protected IGSYM0302Form igsym0302Form;
	
	/**管理域树*/
	private Map<String,TreeNode> treeNodeMap=new LinkedHashMap<String,TreeNode>();
	
	/**
	 * 每级机构的完整名称
	 */
	
	protected  Map<Integer,String> completenameMap;
	
	/**
	 * 每级资产管理内容的完整名称
	 */
	
	protected  Map<Integer,String> completeassetnameMap;
	
	protected String roletype;//资产管理内容树igsym03blimpl后台传递参数用
	
	protected String subtype;//资产管理内容树igsym03blimpl后台传递参数用
	
	protected String isItDrivers;
	
	/** 是否作为跟节点 1：是    0：否 */
	protected String isRoot;
	
	public String getIsRoot() {
		return isRoot;
	}

	public void setIsRoot(String isRoot) {
		this.isRoot = isRoot;
	}

	public String getSubtype() {
		return subtype;
	}

	public void setSubtype(String subtype) {
		this.subtype = subtype;
	}

	public String getRoletype() {
		return roletype;
	}

	public void setRoletype(String roletype) {
		this.roletype = roletype;
	}

	public Map<Integer, String> getCompleteassetnameMap() {
		return completeassetnameMap;
	}

	public void setCompleteassetnameMap(Map<Integer, String> completeassetnameMap) {
		this.completeassetnameMap = completeassetnameMap;
	}

	public Map<Integer, String> getCompletenameMap() {
		return completenameMap;
	}

	public void setCompletenameMap(Map<Integer, String> completenameMap) {
		this.completenameMap = completenameMap;
	}

	public Map<String, TreeNode> getTreeNodeMap() {
		return treeNodeMap;
	}

	public void setTreeNodeMap(Map<String, TreeNode> treeNodeMap) {
		this.treeNodeMap = treeNodeMap;
	}

	/**
	 * 获取角色对象
	 * @return Role
	 */
	
	public Role getRole() {
		return role;
	}

	/**
	 * 设置角色对象
	 * @param role Role
	 */
	
	public void setRole(Role role) {
		this.role = role;
	}

	/**
	 * 获取角色查询Bean
	 * @return RoleSearchCond
	 */
	
	public RoleSearchCond getRoleSearchCond() {
		return roleSearchCond;
	}

	/**
	 * 设置角色查询Bean
	 * @param roleSearchCond RoleSearchCond
	 */
	
	public void setRoleSearchCond(
			RoleSearchCond roleSearchCond) {
		this.roleSearchCond = roleSearchCond;
	}

	/**
	 * 获取角色对象List
	 * @return List<Role>
	 */
	
	public List<Role> getRoleList() {
		return roleList;
	}

	/**
	 * 设置角色对象List
	 * @param roleList List<Role>
	 */
	
	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}
	
	/**
	 * 获取允许查询的最大记录数
	 * @return int
	 */
	
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * 设置允许查询的最大记录数
	 * @param maxSearchCount int
	 */
	
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * 获取分页Bean
	 * @return PagingDTO
	 */
	
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * 设置分页Bean
	 * @param pagingDto PagingDTO
	 */
	
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	/**
	 * 获取角色删除主键
	 * @return String[]
	 */
	
	public String[] getDeleteRoleid() {
		return deleteRoleid;
	}

	/**
	 * 设置角色删除主键
	 * @param deleteRoleid String[]
	 */
	
	public void setDeleteRoleid(String[] deleteRoleid) {
		this.deleteRoleid = deleteRoleid;
	}

	/**
	 * 获取变更用角色基本信息
	 * @return IGSYM0302Form
	 */
	
	public IGSYM0302Form getIgsym0302Form() {
		return igsym0302Form;
	}

	/**
	 * 设置变更用角色基本信息
	 * @return igsym0302Form IGSYM0302Form
	 */
	
	public void setIgsym0302Form(IGSYM0302Form igsym0302Form) {
		this.igsym0302Form = igsym0302Form;
	}

	public String getIsItDrivers() {
		return isItDrivers;
	}

	public void setIsItDrivers(String isItDrivers) {
		this.isItDrivers = isItDrivers;
	}

}
