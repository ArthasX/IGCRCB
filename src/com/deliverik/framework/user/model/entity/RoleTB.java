package com.deliverik.framework.user.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.user.model.Role;


/**
 * <p>
 * 角色信息实体
 * </p>
 */
@SuppressWarnings("serial")
@Entity
@Table(name="ROLE")
public class RoleTB extends BaseEntity implements Serializable, Cloneable, Role {

	/** 角色ID */
	@Id
	@TableGenerator(
		    name="ROLE_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="ROLE_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="ROLE_TABLE_GENERATOR")
	protected Integer roleid;
	
	/** 角色名称 */
	protected String rolename;

	/** 角色说明 */
	protected String roledesc;

	/** 角色信息 */
	protected String roleinfo;

	/** 角色类型 */
	protected String roletype;

	/** 角色机构管理范围 */
	protected String roledomain;

	/** 角色资产管理范围 */
	protected String assetdomain;

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
	 * 角色名称取得
	 * @return 角色名称
	 */
	public String getRolename() {
		return rolename;
	}

	/**
	 * 角色名称设定
	 *
	 * @param rolename 角色名称
	 */
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	/**
	 * 角色说明取得
	 * @return 角色说明
	 */
	public String getRoledesc() {
		return roledesc;
	}

	/**
	 * 角色说明设定
	 *
	 * @param roledesc 角色说明
	 */
	public void setRoledesc(String roledesc) {
		this.roledesc = roledesc;
	}

	/**
	 * 角色信息取得
	 * @return 角色信息
	 */
	public String getRoleinfo() {
		return roleinfo;
	}

	/**
	 * 角色信息设定
	 *
	 * @param roleinfo 角色信息
	 */
	public void setRoleinfo(String roleinfo) {
		this.roleinfo = roleinfo;
	}
	
	/**
	 * 角色类型取得
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
	 * 角色机构管理范围取得
	 * @return 角色机构管理范围
	 */
	public String getRoledomain() {
		return roledomain;
	}
	
	/**
	 * 角色机构管理范围设定
	 *
	 * @param roledomain 角色机构管理范围
	 */
	public void setRoledomain(String roledomain) {
		this.roledomain = roledomain;
	}
	
	/**
	 * 角色资产管理范围取得
	 * @return 角色资产管理范围
	 */
	public String getAssetdomain() {
		return assetdomain;
	}

	/**
	 * 角色资产管理范围设定
	 *
	 * @param assetdomain 角色资产管理范围
	 */
	public void setAssetdomain(String assetdomain) {
		this.assetdomain = assetdomain;
	}

	/**
	 * 获取主键
	 * @return 主键
	 */
	public Serializable getPK() {
		return roleid;
	}

	/**
	 * 比较两个对象是否相同
	 * @param obj
	 * @return 比较结果（true相同，false不同）
	 */
	public boolean equals(Object obj) {
		if (!(obj instanceof RoleTB))
			return false;
		RoleTB target = (RoleTB) obj;
		if (!(getRoleid()==target.getRoleid()))
			return false;

		return true;
	}

}
