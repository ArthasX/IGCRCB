package com.deliverik.framework.user.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.user.model.UserRole;

/**
 * <p>
 * 用户角色授权信息实体
 * </p>
 */
@SuppressWarnings("serial")
@Entity
@Table(name="USERROLE")
public class UserRoleTB extends BaseEntity implements Serializable, Cloneable, UserRole {

	/** 用户角色授权ID */
	@Id
	@TableGenerator(
		    name="USERROLE_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="USERROLE_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="USERROLE_TABLE_GENERATOR")
	protected Integer urid;
	
	/** 用户ID */
	protected String userid;

	/** 用户角色ID */
	protected Integer roleid;

	/** 用户机构层次码 */
	protected String orgid;
	
	/** 用户是否角色负责人标识 */
	protected String rolemanager;
	
	/** 用户是否值班人标识 */
	protected String dutyflag;

	/**
	 * 用户角色授权ID取得
	 * @return 用户角色授权ID
	 */
	public Integer getUrid() {
		return urid;
	}

	/**
	 * 用户角色授权ID设定
	 *
	 * @param urid 用户角色授权ID
	 */
	public void setUrid(Integer urid) {
		this.urid = urid;
	}

	/**
	 * 用户ID取得
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
	 * 用户角色ID取得
	 * @return 用户角色ID
	 */
	public Integer getRoleid() {
		return roleid;
	}

	/**
	 * 用户角色ID设定
	 *
	 * @param roleid 用户角色ID
	 */
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	/**
	 * 用户机构层次码取得
	 * @return 用户机构层次码
	 */
	public String getOrgid() {
		return orgid;
	}

	/**
	 * 用户机构层次码设定
	 *
	 * @param orgid 用户机构层次码
	 */
	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	/**
	 * 用户是否角色负责人标识取得
	 * @return 用户是否角色负责人标识
	 */
	public String getRolemanager() {
		return rolemanager;
	}

	/**
	 * 用户是否角色负责人标识设定
	 *
	 * @param rolemanager 用户是否角色负责人标识
	 */
	public void setRolemanager(String rolemanager) {
		this.rolemanager = rolemanager;
	}

	/**
	 * 获取主键
	 * @return 主键
	 */
	public Serializable getPK() {
		return urid;
	}

	/**
	 * 用户是否值班人标识取得
	 * @return 用户是否值班人标识
	 */
	public String getDutyflag() {
		return dutyflag;
	}

	/**
	 * 用户是否值班人标识设定
	 *
	 * @param rolemanager 用户是否值班人标识
	 */
	public void setDutyflag(String dutyflag) {
		this.dutyflag = dutyflag;
	}
	
	

}
