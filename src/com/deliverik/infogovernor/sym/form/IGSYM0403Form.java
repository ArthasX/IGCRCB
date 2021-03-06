/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sym.form;

import java.util.List;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.user.model.condition.RoleSearchCond;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 系统管理_授权管理_菜单授权查询Form
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSYM0403Form extends BaseForm implements RoleSearchCond{
	
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
	 * 角色类型
	 */
	
	protected String roletype;
	/**
	 * 角色类型是否相同
	 */
	protected int roletypeEqual;
	
	protected String roledomain;//角色管理域
	
	/**
	 * 资产管理内容（esyscoding）
	 */
	protected String assetdomain;
	
	/** 角色类型查询条件（角色类型大于）*/
	protected String roletype_gt;
	
	
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
	
	public String getAssetdomain() {
		return assetdomain;
	}

	public void setAssetdomain(String assetdomain) {
		this.assetdomain = assetdomain;
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

	public String getRoles_Like() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getRoledomain_Like() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getAssetdomain_q() {
		// TODO Auto-generated method stub
		return null;
	}

	public String pdid;
	public String getPdid() {
		return pdid;
	}

	public void setPdid(String pdid) {
		this.pdid = pdid;
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
