/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prr.form;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 人员查询form
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGPRR0303Form extends BaseForm{

	/** 机构码 */
	protected String orgsyscoding;
	
	/** 角色类型 */
	protected String roletype;
	
	/** 角色ID */
	protected Integer roleid;
	
	/** 机构名称 */
	protected String orgname;
	
	/** 角色名称 */
	protected String rolename;
	
	/** 表单定义主键 */
	protected String pidid;
	
	/** 过滤角色信息 */
	protected String roleid_in;

	/**单选标识*/
	protected String single;
	
	/**
	 * @return the single
	 */
	public String getSingle() {
		return single;
	}

	/**
	 * @param single the single to set
	 */
	public void setSingle(String single) {
		this.single = single;
	}

	/**
	 * 机构码取得
	 * @return orgsyscoding 机构码
	 */
	public String getOrgsyscoding() {
		return orgsyscoding;
	}

	/**
	 * 机构码设定
	 * @param orgsyscoding 机构码
	 */
	public void setOrgsyscoding(String orgsyscoding) {
		this.orgsyscoding = orgsyscoding;
	}

	/**
	 * 角色类型取得
	 * @return roletype 角色类型
	 */
	public String getRoletype() {
		return roletype;
	}

	/**
	 * 角色类型设定
	 * @param roletype 角色类型
	 */
	public void setRoletype(String roletype) {
		this.roletype = roletype;
	}

	/**
	 * 角色ID取得
	 * @return roleid 角色ID
	 */
	public Integer getRoleid() {
		return roleid;
	}

	/**
	 * 角色ID设定
	 * @param roleid 角色ID
	 */
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	/**
	 * 机构名称取得
	 * @return orgname 机构名称
	 */
	public String getOrgname() {
		return orgname;
	}

	/**
	 * 机构名称设定
	 * @param orgname 机构名称
	 */
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	/**
	 * 角色名称取得
	 * @return rolename 角色名称
	 */
	public String getRolename() {
		return rolename;
	}

	/**
	 * 角色名称设定
	 * @param rolename 角色名称
	 */
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	
	/**
	 * 表单定义主键取得
	 * @return pidid 表单定义主键
	 */
	public String getPidid() {
		return pidid;
	}

	/**
	 * 表单定义主键设定
	 * @param pidid 表单定义主键
	 */
	public void setPidid(String pidid) {
		this.pidid = pidid;
	}

	/**
	 * 过滤角色信息取得
	 * @return roleid_in 过滤角色信息
	 */
	public String getRoleid_in() {
		return roleid_in;
	}

	/**
	 * 过滤角色信息设定
	 * @param roleid_in 过滤角色信息
	 */
	public void setRoleid_in(String roleid_in) {
		this.roleid_in = roleid_in;
	}

	/**
	 * 重写reset方法
	 */
	public void reset() {
		this.orgsyscoding = null;
		this.roletype = null;
		this.roleid = null;
		this.orgname = null;
		this.rolename = null;
		this.pidid = null;
		this.roleid_in = null;
	}
	
}
