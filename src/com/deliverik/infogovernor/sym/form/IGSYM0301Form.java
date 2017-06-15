/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sym.form;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.user.model.condition.RoleSearchCond;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 系统管理_角色管理_查询删除Form
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSYM0301Form extends BaseForm implements RoleSearchCond{
	
	/**
	 * 角色主键
	 */
	
	protected String roleid;
	
	/**
	 * 角色名称
	 */
	
	protected String rolename;
	
	/**
	 * 角色名称（查询）
	 */
	
	protected String rolename_q;
	
	/**
	 * 角色类型（查询）
	 */
	
	protected String roletype_q;
	
	/**
	 * 角色类型
	 */
	
	protected String roletype;
	
	
	/**
	 * 角色删除主键
	 */
	
	protected String[] deleteRoleid;
	/**
	 * 角色类型是否相同
	 */
	protected int roletypeEqual;
	
	protected String roledomain;//角色管理域
	
	/**
	 * 资产管理内容（esyscoding）
	 */
	protected String assetdomain;
	
	protected String assetdomain_q;
	
	/** 角色类型 */
	protected String roles_Like;
	
	/** 角色类型查询条件（角色类型大于）*/
	protected String roletype_gt;
	
	/** 流程定义ID*/
	protected String pdid;
	
	
	
	

	public String getPdid() {
		return pdid;
	}

	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * 角色类型查询条件取得
	 * @return 角色类型查询条件
	 */
	public String getRoletype_gt() {
		return roletype_gt;
	}

	/**
	 * 角色类型查询条件设定
	 *
	 * @param roletype_gt 角色类型查询条件
	 */
	public void setRoletype_gt(String roletype_gt) {
		this.roletype_gt = roletype_gt;
	}
	
	
	

	public String getRoles_Like() {
		return roles_Like;
	}

	public void setRoles_Like(String roles_Like) {
		this.roles_Like = roles_Like;
	}

	public String getAssetdomain_q() {
		return assetdomain_q;
	}

	public void setAssetdomain_q(String assetdomain_q) {
		this.assetdomain_q = assetdomain_q;
	}

	public String getAssetdomain() {
		return assetdomain;
	}

	public void setAssetdomain(String assetdomain) {
		this.assetdomain = assetdomain;
	}

	public String getRoletype_q() {
		return roletype_q;
	}

	public void setRoletype_q(String roletype_q) {
		this.roletype_q = roletype_q;
	}

	public String getRoledomain() {
		return roledomain;
	}

	public void setRoledomain(String roledomain) {
		this.roledomain = roledomain;
	}

	/**
	 * 获取角色主键
	 * @return String
	 */
	
	public String getRoleid() {
		return roleid;
	}
	
	/**
	 * 设置角色主键
	 * @param roleid String
	 */
	
	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}
	
	/**
	 * 获取角色名称
	 * @return String
	 */
	
	public String getRolename() {
		return rolename;
	}
	
	/**
	 * 设置角色名称
	 * @param rolename String
	 */
	
	public void setRolename(String rolename) {
		this.rolename = rolename;
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
	 * 重置Form
	 * @param mapping ActionMapping
	 * @param request HttpServletRequest
	 */
	
	public void reset(ActionMapping mapping,HttpServletRequest request){
		super.reset(mapping, request);
		this.deleteRoleid = null;
	}
	
	/**
	 * 获取角色类型）
	 * @return String
	 */
	
	public String getRoletype() {
		return roletype;
	}

	/**
	 * 设置角色类型
	 * @param roletype String
	 */
	
	public void setRoletype(String roletype) {
		this.roletype = roletype;
	}
	
	/**
	 * 获取角色名称（查询）
	 * @return String
	 */
	
	public String getRolename_q() {
		return rolename_q;
	}
	
	/**
	 * 设置角色名称（查询）
	 * @param rolename_q String
	 */
	
	public void setRolename_q(String rolename_q) {
		this.rolename_q = rolename_q;
	}

	public int getRoletypeEqual() {
		return roletypeEqual;
	}

	public void setRoletypeEqual(int roletypeEqual) {
		this.roletypeEqual = roletypeEqual;
	}

	public String[] getRoles_BP_EX() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getRoledomain_Like() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Integer> getRoleid_in() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getRoleid_not_in() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
