/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sym.form;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.user.model.condition.UserRoleSearchCond;
import com.deliverik.framework.user.model.condition.UserRoleVWSearchCond;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 系统管理_角色管理_角色负责人Form
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSYM0407Form extends BaseForm implements UserRoleVWSearchCond,UserRoleSearchCond {
	
	/** 用户ID */
	protected String userid;
	
	/** 角色ID */
	protected Integer roleid;
	
	/** 角色类型 */
	protected String roletype;
	
	/** 角色类型like查询条件 */
	protected String roles_Like;
	
	/** 流程角色扩展类型 */
	protected String[] roles_BP_EX;
	
	/** 角色用户关联ID */
	protected String[] urids;
	
	/** 初始化时是否含有负责人 */
	protected String hasManager;

	/** 初始化时是否含有值班人 */
	protected String hasWatchManager;
	
	/**
	 * 用户ID取得
	 * 
	 * @return 用户ID
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * 用户ID设定
	 *
	 * @param userid 用户ID
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * 角色ID取得
	 * 
	 * @return 角色ID
	 */
	public Integer getRoleid() {
		return roleid;
	}

	/**
	 * 角色ID设定
	 *
	 * @param roleid 角色ID
	 */
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	/**
	 * 角色类型取得
	 * 
	 * @return 角色类型
	 */
	public String getRoletype() {
		return roletype;
	}

	/**
	 * 角色类型设定
	 *
	 * @param roletype 角色类型
	 */
	public void setRoletype(String roletype) {
		this.roletype = roletype;
	}

	/**
	 * 角色类型like查询条件取得
	 * 
	 * @return 角色类型like查询条件
	 */
	public String getRoles_Like() {
		return roles_Like;
	}

	/**
	 * 角色类型like查询条件设定
	 *
	 * @param roles_Like 角色类型like查询条件
	 */
	public void setRoles_Like(String roles_Like) {
		this.roles_Like = roles_Like;
	}

	/**
	 * 流程角色扩展类型取得
	 * 
	 * @return 流程角色扩展类型
	 */
	public String[] getRoles_BP_EX() {
		return roles_BP_EX;
	}

	/**
	 * 流程角色扩展类型设定
	 *
	 * @param roles_BP_EX 流程角色扩展类型
	 */
	public void setRoles_BP_EX(String[] roles_BP_EX) {
		this.roles_BP_EX = roles_BP_EX;
	}

	/**
	 * 角色用户关联ID取得
	 * 
	 * @return 角色用户关联ID
	 */
	public String[] getUrids() {
		return urids;
	}

	/**
	 * 角色用户关联ID设定
	 *
	 * @param urids 角色用户关联ID
	 */
	public void setUrids(String[] urids) {
		this.urids = urids;
	}

	/**
	 * 初始化时是否含有负责人取得
	 * 
	 * @return 初始化时是否含有负责人
	 */
	public String getHasManager() {
		return hasManager;
	}

	/**
	 * 初始化时是否含有负责人设定
	 *
	 * @param hasManager 初始化时是否含有负责人
	 */
	public void setHasManager(String hasManager) {
		this.hasManager = hasManager;
	}
	
	
	public String getHasWatchManager() {
		return hasWatchManager;
	}

	public void setHasWatchManager(String hasWatchManager) {
		this.hasWatchManager = hasWatchManager;
	}

	public void reset(ActionMapping mapping, HttpServletRequest request) {
		super.reset(mapping, request);
		this.roles_BP_EX = null;
		this.urids = null;
	}

	public boolean isRolemanager() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isDutyflag() {
		// TODO Auto-generated method stub
		return false;
	}

	public String getAssetdomain() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getOrgid_like() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getRoledomain_like() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getRoledomain() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getRolename_like() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setUrid_eq(Integer urid_eq) {
		// TODO Auto-generated method stub
		
	}

	public String getUsername_like() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Integer> getRoleid_in() {
		// TODO Auto-generated method stub
		return null;
	}

}
