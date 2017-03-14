/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sym.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.user.model.Organization;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 系统管理_机构管理_新增修改FormBean
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSYM0102Form extends BaseForm implements Organization{
	
	/**
	 * 机构主键
	 */
	
	protected Integer orgid;
	
	/**
	 * 机构主键
	 */
	
	protected String orgidstr;
	
	/**
	 * 机构名称
	 */
	
	protected String orgname;
	
	/**
	 * 机构名称
	 */
	
	protected String orgnamebak;
	
	/**
	 * 上级机构的ID
	 */
	
	protected String orgpar;
	
	/**
	 * 上级机构的名称
	 */
	
	protected String orgparname;
	
	/**
	 * 机构说明
	 */
	
	protected String orgdesc;

	/**
	 * 机构类型（保留字段）
	 */
	
	protected String orgtype;

	/**
	 * 机构地址
	 */
	
	protected String orgaddr;

	/**
	 * 机构电话
	 */
	
	protected String orgphone;

	/**
	 * 机构传真
	 */
	
	protected String orgfax;

	/**
	 * 机构联系人
	 */
	
	protected String orgcontact;

	/**
	 * 机构状态（是否停用 0停用 1启用）
	 */
	
	protected String orgstatus;

	/**
	 * 机构信息（保留字段）
	 */
	
	protected String orginfo;
	
	/**
	 * 页面标题显示标志0-新增,1-变更
	 */
	
	protected String mode = "0";
	
	/**
	 * 系统编码
	 */
	protected String orgsyscoding;
	
	/**
	 * 用户编码
	 */
	protected String orgusercoding;
	
	

	
	public String getOrgsyscoding() {
		return orgsyscoding;
	}

	public void setOrgsyscoding(String orgsyscoding) {
		this.orgsyscoding = orgsyscoding;
	}

	public String getOrgusercoding() {
		return orgusercoding;
	}

	public void setOrgusercoding(String orgusercoding) {
		this.orgusercoding = orgusercoding;
	}

	/**
	 * 获取机构主键
	 * @return String
	 */
	
	public Integer getOrgid() {
		if( (this.orgidstr == null) || ("".equals(this.orgidstr))){
			return null;
		} else {
			return Integer.valueOf(this.orgidstr);
		}
	}
	
	/**
	 * 设置机构主键
	 * @param orgid String
	 */
	
	public void setOrgid(Integer orgid) {
		this.orgid = orgid;
	}
	
	/**
	 * 获取机构主键
	 * @return String
	 */
	
	public String getOrgidstr() {
		return orgidstr;
	}

	/**
	 * 设置机构主键
	 * @param orgid String
	 */
	
	public void setOrgidstr(String orgidstr) {
		this.orgidstr = orgidstr;
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
	

	
	public String getOrgpar() {
		return orgpar;
	}

	public void setOrgpar(String orgpar) {
		this.orgpar = orgpar;
	}

	/**
	 * 获取上级机构的名称
	 * @return String
	 */
	
	
	public String getOrgparname() {
		return orgparname;
	}
	
	/**
	 * 设置上级机构的名称
	 * @param orgparname String
	 */
	
	public void setOrgparname(String orgparname) {
		this.orgparname = orgparname;
	}

	/**
	 * 获取机构说明
	 * @return String
	 */
	
	public String getOrgdesc() {
		return orgdesc;
	}

	/**
	 * 设置机构说明
	 * @param orgdesc String
	 */
	
	public void setOrgdesc(String orgdesc) {
		this.orgdesc = orgdesc;
	}

	/**
	 * 获取机构类型（保留字段）
	 * @return String
	 */
	
	public String getOrgtype() {
		return orgtype;
	}

	/**
	 * 设置机构类型（保留字段）
	 * @param orgtype String
	 */
	
	public void setOrgtype(String orgtype) {
		this.orgtype = orgtype;
	}

	/**
	 * 获取机构地址
	 * @return String
	 */
	
	public String getOrgaddr() {
		return orgaddr;
	}

	/**
	 * 设置机构地址
	 * @param orgaddr String
	 */
	
	public void setOrgaddr(String orgaddr) {
		this.orgaddr = orgaddr;
	}

	/**
	 * 获取机构电话
	 * @return String
	 */
		
	public String getOrgphone() {
		return orgphone;
	}

	/**
	 * 设置机构电话
	 * @param orgphone String
	 */
	
	public void setOrgphone(String orgphone) {
		this.orgphone = orgphone;
	}

	/**
	 * 获取机构传真
	 * @return String
	 */
	
	public String getOrgfax() {
		return orgfax;
	}

	/**
	 * 设置机构传真
	 * @param orgfax String
	 */
	
	public void setOrgfax(String orgfax) {
		this.orgfax = orgfax;
	}

	/**
	 * 获取机构联系人
	 * @return String
	 */
	
	public String getOrgcontact() {
		return orgcontact;
	}

	/**
	 * 设置机构联系人
	 * @param orgcontact String
	 */
	
	public void setOrgcontact(String orgcontact) {
		this.orgcontact = orgcontact;
	}

	/**
	 * 获取机构状态（保留字段）
	 * @return String
	 */
	
	public String getOrgstatus() {
		return orgstatus;
	}

	/**
	 * 设置机构状态（保留字段）
	 * @param orgstatus String
	 */
	
	public void setOrgstatus(String orgstatus) {
		this.orgstatus = orgstatus;
	}

	/**
	 * 获取机构信息（保留字段）
	 * @return String
	 */
	
	public String getOrginfo() {
		return orginfo;
	}

	/**
	 * 设置机构信息（保留字段）
	 * @param orginfo String
	 */
	
	public void setOrginfo(String orginfo) {
		this.orginfo = orginfo;
	}

	/**
	 * 获取页面标题显示标志
	 * @return String
	 */
	
	public String getMode() {
		return mode;
	}

	/**
	 * 设置页面标题显示标志
	 * @param mode String
	 */
	
	public void setMode(String mode) {
		this.mode = mode;
	}
	/**
	 * 重置Form
	 * @param mapping ActionMapping
	 * @param request HttpServletRequest
	 */
	
	public void reset(ActionMapping mapping,HttpServletRequest request){
		super.reset(mapping, request);
	}

	/**
	 * 获取机构名称
	 * @return String
	 */
	
	public String getOrgnamebak() {
		return orgnamebak;
	}

	/**
	 * 设置机构名称
	 * @param orgnamebak String
	 */
	
	public void setOrgnamebak(String orgnamebak) {
		this.orgnamebak = orgnamebak;
	}
	
	protected String fingerPrint;

	public String getFingerPrint() {
		return fingerPrint;
	}

	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}
}
