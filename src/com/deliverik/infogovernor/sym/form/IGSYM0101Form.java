/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sym.form;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.user.model.condition.OrganizationSearchCond;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 系统管理_机构管理_查询删除Form
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public class IGSYM0101Form extends BaseForm implements OrganizationSearchCond{
	
	private static final long serialVersionUID = -7806752326705441563L;

	/**
	 * 机构主键
	 */
	
	protected String orgid;
	
	/**
	 * 上级机构主键
	 */
	
	protected String orgpar;
	
	/**
	 * 上级机构主键
	 */
	
	protected String orgparstr;
	
	/**
	 * 上级机构名称
	 */
	
	protected String orgparname;
	
	/**
	 * 机构名称
	 */
	
	protected String orgname;
	
	/**
	 * 机构名称(查询)
	 */
	
	protected String orgname_q;
	
	/**
	 * 机构删除主键
	 */
	
	protected String[] deleteOrgid;
	
	
	/**
	 * 机构状态(0停用 1启用)
	 */
	
	protected String is_in_use;
	
	/**
	 * 上级机构主键
	 */
	
	protected String orgparid;
	
	protected String orgstatus;
	
	protected Integer orgsuper;//代表adminorg机构
	
	
	protected String orgsyscoding;
	
	protected ArrayList<String> syscoding_area;
	
	/**
	 * 角色管理域树查询用(资产权限控制)
	 */
	protected String roledomain_q;
	
	/**
	 * 角色管理域树查询结点全名用(资产权限控制)
	 */
	protected String complete_name;
	
	/**
	 * 查询页--上级机构--保存syscode
	 */
	
	protected String orgparstr_q;
	

	/**
	 * 是否显示停用按钮(只能从最下级机构开始停用)
	 */
	protected String orgsyscoding_q;
	
	/** 排序方式 */
	protected String sortType;
	
	/**
	 * 下拨分类
	 *        0512: 下拨全部
	 *        0512001: 下拨总行
	 *        0512002: 下拨支行
	 */
	protected String selectorg;
	

	/**
	 * @return the sortType
	 */
	public String getSortType() {
		return sortType;
	}

	/**
	 * @param sortType the sortType to set
	 */
	public void setSortType(String sortType) {
		this.sortType = sortType;
	}

	public ArrayList<String> getSyscoding_area() {
		return syscoding_area;
	}

	public void setSyscoding_area(ArrayList<String> syscoding_area) {
		this.syscoding_area = syscoding_area;
	}

	public String getOrgsyscoding_q() {
		return orgsyscoding_q;
	}

	public void setOrgsyscoding_q(String orgsyscoding_q) {
		this.orgsyscoding_q = orgsyscoding_q;
	}

	public String getOrgpar() {
		return orgpar;
	}

	public void setOrgpar(String orgpar) {
		this.orgpar = orgpar;
	}



	public String getOrgparstr_q() {
		return orgparstr_q;
	}

	public void setOrgparstr_q(String orgparstr_q) {
		this.orgparstr_q = orgparstr_q;
	}

	public String getComplete_name() {
		return complete_name;
	}

	public void setComplete_name(String complete_name) {
		this.complete_name = complete_name;
	}

	public String getRoledomain_q() {
		return roledomain_q;
	}

	public void setRoledomain_q(String roledomain_q) {
		this.roledomain_q = roledomain_q;
	}

	public String getOrgsyscoding() {
		return orgsyscoding;
	}

	public void setOrgsyscoding(String orgsyscoding) {
		this.orgsyscoding = orgsyscoding;
	}

	public Integer getOrgsuper() {
		return orgsuper;
	}

	public void setOrgsuper(Integer orgsuper) {
		this.orgsuper = orgsuper;
	}

	public String getOrgstatus() {
		return orgstatus;
	}

	public void setOrgstatus(String orgstatus) {
		this.orgstatus = orgstatus;
	}
	
	public String getOrgparname() {
		return orgparname;
	}

	public void setOrgparname(String orgparname) {
		this.orgparname = orgparname;
	}

	public String getOrgparid() {
		return orgparid;
	}

	public void setOrgparid(String orgparid) {
		this.orgparid = orgparid;
	}

	public String getIs_in_use() {
		return is_in_use;
	}

	public void setIs_in_use(String is_in_use) {
		this.is_in_use = is_in_use;
	}

	/**
	 * 获取机构主键
	 * @return String
	 */
	
	public String getOrgid() {
		return orgid;
	}
	
	/**
	 * 设置机构主键
	 * @param orgid String
	 */
	
	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}
	
	/**
	 * 获取机构名称
	 * @return String
	 */
	
	public String getOrgname() {
		return orgname;
	}
	
	/**
	 * 设置机构名称
	 * @param orgname String
	 */
	
	public void setOrgname(String orgname) {
		this.orgname = orgname;
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
	 * 重置Form
	 * @param mapping ActionMapping
	 * @param request HttpServletRequest
	 */
	
	public void reset(ActionMapping mapping,HttpServletRequest request){
		super.reset(mapping, request);
		this.deleteOrgid = null;
	}

	
	/**
	 * 获取上级机构主键
	 * @return String
	 */
	
	public String getOrgparstr() {
		return orgparstr;
	}

	/**
	 * 设置上级机构主键
	 * @param orgpar String
	 */
	
	public void setOrgparstr(String orgparstr) {
		this.orgparstr = orgparstr;
	}
	
	/**
	 * 获取机构名称(查询)
	 * @return String
	 */
	
	public String getOrgname_q(){
		return orgname_q;
	}
	
	/**
	 * 设置机构名称(查询)
	 * @param orgname_q String
	 */
	
	public void setOrgname_q(String orgname_q) {
		this.orgname_q = orgname_q;
	}

	public ArrayList<String> getNot_in_syscoding_area() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.framework.user.model.condition.OrganizationSearchCond#getXbtype()
	 */
	public String getXbtype() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getSelectorg() {
		return selectorg;
	}

	public void setSelectorg(String selectorg) {
		this.selectorg = selectorg;
	}

	public String getOrgname_like() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
