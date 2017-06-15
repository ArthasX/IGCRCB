/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sym.dto;

import java.io.Serializable;
import java.util.List;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.condition.UserSearchCond;
import com.deliverik.infogovernor.sym.form.IGSYM0202Form;
import com.deliverik.infogovernor.sym.form.IGSYM0204Form;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 系统管理_用户管理_DTO
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

/**
 * @author Administrator
 *
 */
/**
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class IGSYM02DTO extends BaseDTO implements Serializable {
	
	/**
	 * 用户对象
	 */
	
	protected User user;
	/**
	 * 用户查询Bean
	 */
	
	protected UserSearchCond userSearchCond;
	
	/**
	 * 用户对象List
	 */
	
	protected List<User> userList;

	/**
	 * 允许查询的最大记录数
	 */
	
	protected int maxSearchCount;

	/**
	 * 分页Bean
	 */
	
	protected PagingDTO pagingDto;
	
	/**
	 * 用户删除主键
	 */
	
	protected String userid;
	
	/**
	 * 变更用用户基本信息
	 */
	
	protected IGSYM0202Form igsym0202Form;

	/** 人员查询信息  */
	protected IGSYM0204Form igsym0204Form;
	
	
	/**
	 * 机构列表
	 */
	
	protected List<Organization> organizationList;
	
	/**
	 * 角色id
	 */
	
	protected Integer roleid;
	
	/** 用户首页列表 */
	protected List<LabelValueBean> lst_LabelValueBean;

	/**
	 * 获取用户对象
	 * @return User
	 */
	
	public User getUser() {
		return user;
	}

	/**
	 * 设置用户对象
	 * @param user User
	 */
	
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * 获取用户查询Bean
	 * @return UserSearchCond
	 */
	
	public UserSearchCond getUserSearchCond() {
		return userSearchCond;
	}

	/**
	 * 设置用户查询Bean
	 * @param userSearchCond UserSearchCond
	 */
	
	public void setUserSearchCond(
			UserSearchCond userSearchCond) {
		this.userSearchCond = userSearchCond;
	}

	/**
	 * 获取用户对象List
	 * @return List<User>
	 */
	
	public List<User> getUserList() {
		return userList;
	}

	/**
	 * 设置用户对象List
	 * @param userList List<User>
	 */
	
	public void setUserList(List<User> userList) {
		this.userList = userList;
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
	 * 获取用户删除主键
	 * @return String
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * 设置用户删除主键
	 * @param userid String
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * 获取变更用用户基本信息
	 * @return IGSYM0202Form
	 */
	
	public IGSYM0202Form getIgsym0202Form() {
		return igsym0202Form;
	}

	/**
	 * 设置变更用用户基本信息
	 * @param igsym0202Form IGSYM0202Form
	 */
	
	public void setIgsym0202Form(IGSYM0202Form igsym0202Form) {
		this.igsym0202Form = igsym0202Form;
	}

	/**
	 * 获取机构列表
	 * @return List<Organization>
	 */
	
	public List<Organization> getOrganizationList() {
		return organizationList;
	}

	/**
	 * 设置机构列表
	 * @param organizationList List<Organization>
	 */
	
	public void setOrganizationList(List<Organization> organizationList) {
		this.organizationList = organizationList;
	}

	/**
	 * 获取角色id
	 * @return Integer
	 */
	
	public Integer getRoleid() {
		return roleid;
	}

	/**
	 * 设置角色id
	 * @param roleid Integer
	 */
	
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	/**
	 * 用户首页列表取得
	 * 
	 * @return 用户首页列表
	 */
	public List<LabelValueBean> getLst_LabelValueBean() {
		return lst_LabelValueBean;
	}

	/**
	 * 用户首页列表设定
	 * 
	 * @param lst_LabelValueBean 用户首页列表
	 */
	public void setLst_LabelValueBean(List<LabelValueBean> lst_LabelValueBean) {
		this.lst_LabelValueBean = lst_LabelValueBean;
	}

	/**
	 * 人员查询信息取得
	 * @return igsym0204Form  人员查询信息
	 */
	public IGSYM0204Form getIgsym0204Form() {
		return igsym0204Form;
	}

	/**
	 * 人员查询信息设定
	 * @param igsym0204Form  人员查询信息
	 */
	public void setIgsym0204Form(IGSYM0204Form igsym0204Form) {
		this.igsym0204Form = igsym0204Form;
	}
	
}
