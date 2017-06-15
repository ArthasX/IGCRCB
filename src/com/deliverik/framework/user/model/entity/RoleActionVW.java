package com.deliverik.framework.user.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.user.model.RoleActionInfo;

/**
 * <p>
 * 角色菜单授权信息实体
 * </p>
 */
@SuppressWarnings("serial")
@Entity
@Table(name="RoleActionVW")
public class RoleActionVW implements Serializable, Cloneable, RoleActionInfo {
	
	/** 角色菜单授权ID */
	@Id
	protected Integer raid;
	
	/** 角色ID */
	protected Integer roleid;

	/** 菜单ID */
	protected String actname;
	
	/** 角色对于菜单的权限 */
	protected String raperm;

	/** 角色对于菜单的权限的说明 */
	protected String radesc;

	/** 菜单显示名称 */
	protected String actlabel;

	/** 菜单描述 */
	protected String actdesc;

	/** 菜单URL */
	protected String acturl;

	/** 菜单类型 */
	protected String acttype;
	
	/** 菜单排序ID*/
	protected String actsortid;
	
	/** 菜单URL类型 */
	protected String acturltype;

	/**
	 * 角色菜单授权ID取得
	 * @return 角色菜单授权ID
	 */
	public Integer getRaid() {
		return raid;
	}

	/**
	 * 角色菜单授权ID设定
	 *
	 * @param raid 角色菜单授权ID
	 */
	public void setRaid(Integer raid) {
		this.raid = raid;
	}

	/**
	 * 角色ID取得
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
	 * 菜单ID取得
	 * @return 菜单ID
	 */
	public String getActname() {
		return actname;
	}

	/**
	 * 菜单ID设定
	 *
	 * @param actname 菜单ID
	 */
	public void setActname(String actname) {
		this.actname = actname;
	}

	/**
	 * 角色对于菜单的权限取得
	 * @return 角色对于菜单的权限
	 */
	public String getRaperm() {
		return raperm;
	}

	/**
	 * 角色对于菜单的权限设定
	 *
	 * @param raperm 角色对于菜单的权限
	 */
	public void setRaperm(String raperm) {
		this.raperm = raperm;
	}

	/**
	 * 角色对于菜单的权限说明取得
	 * @return 角色对于菜单的权限说明
	 */
	public String getRadesc() {
		return radesc;
	}

	/**
	 * 角色对于菜单的权限说明设定
	 *
	 * @param radesc 角色对于菜单的权限说明
	 */
	public void setRadesc(String radesc) {
		this.radesc = radesc;
	}

	/**
	 * 菜单显示名称取得
	 * @return 菜单显示名称
	 */
	public String getActlabel() {
		return actlabel;
	}

	/**
	 * 菜单显示名称设定
	 *
	 * @param actlabel 菜单显示名称
	 */
	public void setActlabel(String actlabel) {
		this.actlabel = actlabel;
	}

	/**
	 * 菜单描述取得
	 * @return 菜单描述
	 */
	public String getActdesc() {
		return actdesc;
	}

	/**
	 * 菜单描述设定
	 *
	 * @param actdesc 菜单描述
	 */
	public void setActdesc(String actdesc) {
		this.actdesc = actdesc;
	}

	/**
	 * 菜单URL取得
	 * @return 菜单URL
	 */
	public String getActurl() {
		return acturl;
	}

	/**
	 * 菜单URL设定
	 *
	 * @param acturl 菜单URL
	 */
	public void setActurl(String acturl) {
		this.acturl = acturl;
	}

	/**
	 * 菜单类型取得
	 * @return 菜单类型
	 */
	public String getActtype() {
		return acttype;
	}

	/**
	 * 菜单类型设定
	 *
	 * @param acttype 菜单类型
	 */
	public void setActtype(String acttype) {
		this.acttype = acttype;
	}
	
	/**
	 * 菜单排序ID取得
	 * @return 菜单排序ID
	 */
	public String getActsortid() {
		return actsortid;
	}

	/**
	 * 菜单排序ID设定
	 * @param actsortid 菜单排序ID
	 */
	public void setActsortid(String actsortid) {
		this.actsortid = actsortid;
	}
	
	/**
	 * 菜单URL类型取得
	 * @return 菜单URL类型
	 */
	public String getActurltype() {
		return acturltype;
	}

	/**
	 * 菜单URL类型设定
	 *
	 * @param acturltype 菜单URL类型
	 */
	public void setActurltype(String acturltype) {
		this.acturltype = acturltype;
	}

	/**
	 * 获取主键
	 * @return 主键
	 */
	public Serializable getPK() {
		return raid;
	}

	/**
	 * 比较两个对象是否相同
	 * @param obj
	 * @return 比较结果（true相同，false不同）
	 */
	public boolean equals(Object obj) {
		if (!(obj instanceof RoleActionVW))
			return false;
		RoleActionInfo target = (RoleActionInfo) obj;
		if (!(getRaid()==target.getRaid()))
			return false;

		return true;
	}

}
