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
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.condition.OrganizationSearchCond;
import com.deliverik.infogovernor.sym.form.IGSYM0101Form;
import com.deliverik.infogovernor.sym.form.IGSYM0102Form;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 系统管理_机构管理_DTO
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
public class IGSYM01DTO extends BaseDTO implements Serializable {
	
	/**
	 * 机构对象
	 */
	
	protected Organization organization;
	/**
	 * 机构查询Bean
	 */
	
	protected OrganizationSearchCond organizationSearchCond;
	
	/**
	 * 机构对象List
	 */
	
	protected List<Organization> organizationCondList;
	
	/**
	 * 机构对象List（下拉列表用）
	 */
	
	protected List<Organization> organizationList;

	/**
	 * 允许查询的最大记录数
	 */
	
	protected int maxSearchCount;

	/**
	 * 分页Bean
	 */
	
	protected PagingDTO pagingDto;
	
	/**
	 * 机构删除主键
	 */
	
	protected String[] deleteOrgid;
	/**
	 * 机构状态变化主键
	 */
	
	protected  Integer changeOrgid;
	
	/**
	 * 每级机构的完整名称
	 */
	
	protected  Map<Integer,String> completenameMap;
	
	/**
	 * 每级机构是否显示停用按钮
	 */
	
	protected  Map<Integer,String> buttonMap;
	
	/**
	 * 每级机构是否显示启用按钮
	 */
	
	protected  Map<Integer,String> startbuttonMap;
	
	

	public Map<Integer, String> getStartbuttonMap() {
		return startbuttonMap;
	}

	public void setStartbuttonMap(Map<Integer, String> startbuttonMap) {
		this.startbuttonMap = startbuttonMap;
	}

	public Map<Integer, String> getButtonMap() {
		return buttonMap;
	}

	public void setButtonMap(Map<Integer, String> buttonMap) {
		this.buttonMap = buttonMap;
	}

	public Map<Integer, String> getCompletenameMap() {
		return completenameMap;
	}

	public void setCompletenameMap(Map<Integer, String> completenameMap) {
		this.completenameMap = completenameMap;
	}

	public Integer getChangeOrgid() {
		return changeOrgid;
	}

	public void setChangeOrgid(Integer changeOrgid) {
		this.changeOrgid = changeOrgid;
	}

	/**
	 * 变更用机构基本信息
	 */
	protected IGSYM0102Form igsym0102Form;
	
	/**
	 * 变更用机构基本信息
	 */
	protected IGSYM0101Form igsym0101Form;
	
	
	/**机构树*/
	private Map<String,TreeNode> treeNodeMap=new LinkedHashMap<String,TreeNode>();
	
	
	

	public IGSYM0101Form getIgsym0101Form() {
		return igsym0101Form;
	}

	public void setIgsym0101Form(IGSYM0101Form igsym0101Form) {
		this.igsym0101Form = igsym0101Form;
	}

	public Map<String, TreeNode> getTreeNodeMap() {
		return treeNodeMap;
	}

	public void setTreeNodeMap(Map<String, TreeNode> treeNodeMap) {
		this.treeNodeMap = treeNodeMap;
	}

	/**
	 * 获取机构对象
	 * @return Organization
	 */
	
	public Organization getOrganization() {
		return organization;
	}

	/**
	 * 设置机构对象
	 * @param organization Organization
	 */
	
	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	/**
	 * 获取机构查询Bean
	 * @return OrganizationSearchCond
	 */
	
	public OrganizationSearchCond getOrganizationSearchCond() {
		return organizationSearchCond;
	}

	/**
	 * 设置机构查询Bean
	 * @param organizationSearchCond OrganizationSearchCond
	 */
	
	public void setOrganizationSearchCond(
			OrganizationSearchCond organizationSearchCond) {
		this.organizationSearchCond = organizationSearchCond;
	}

	/**
	 * 获取机构对象List
	 * @return List<Organization>
	 */
	
	public List<Organization> getOrganizationCondList() {
		return organizationCondList;
	}
	
	/**
	 * 获取机构对象List（下拉列表用）
	 * @return List<Organization>
	 */
	
	public List<Organization> getOrganizationList() {
		return organizationList;
	}

	/**
	 * 设置机构对象List
	 * @param organizationCondList List<Organization>
	 */
	
	public void setOrganizationCondList(List<Organization> organizationCondList) {
		this.organizationCondList = organizationCondList;
	}
	
	/**
	 * 设置机构对象List（下拉列表用）
	 * @param organizationList List<Organization>
	 */
	
	public void setOrganizationList(List<Organization> organizationList) {
		this.organizationList = organizationList;
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
	 * 获取机构删除主键
	 * @return String[]
	 */
	
	public String[] getDeleteOrgid() {
		return deleteOrgid;
	}

	/**
	 * 设置机构删除主键
	 * @param deleteOrgid String[]
	 */
	
	public void setDeleteOrgid(String[] deleteOrgid) {
		this.deleteOrgid = deleteOrgid;
	}

	/**
	 * 获取变更用机构基本信息
	 * @return IGSYM0102Form
	 */
	
	public IGSYM0102Form getIgsym0102Form() {
		return igsym0102Form;
	}

	/**
	 * 设置变更用机构基本信息
	 * @return igsym0102Form IGSYM0102Form
	 */
	
	public void setIgsym0102Form(IGSYM0102Form igsym0102Form) {
		this.igsym0102Form = igsym0102Form;
	}

}
