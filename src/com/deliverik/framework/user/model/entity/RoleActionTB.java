package com.deliverik.framework.user.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.user.model.RoleAction;

/**
 * <p>
 * 角色菜单授权信息实体
 * </p>
 */
@SuppressWarnings("serial")
@Entity
@Table(name="RoleAction")
public class RoleActionTB extends BaseEntity implements Serializable, Cloneable, RoleAction {

	/** 角色菜单授权ID */
	@Id
	@TableGenerator(
		    name="ROLEACTION_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="ROLEACTION_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="ROLEACTION_TABLE_GENERATOR")
	protected Integer raid;
	
	/** 角色ID */
	protected Integer roleid;
	
	/** 菜单ID */
	protected String actname;

	/** 角色对于菜单的权限 */
	protected String raperm;

	/** 角色对于菜单的权限的说明 */
	protected String radesc;

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
		this.actname= actname;
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
	 * 角色对于菜单的权限的说明取得
	 * @return 角色对于菜单的权限的说明
	 */
	public String getRadesc() {
		return radesc;
	}

	/**
	 * 角色对于菜单的权限的说明设定
	 *
	 * @param radesc 角色对于菜单的权限的说明
	 */
	public void setRadesc(String radesc) {
		this.radesc = radesc;
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
		if (!(obj instanceof RoleActionTB))
			return false;
		RoleAction target = (RoleAction) obj;
		if (!(getRaid()==target.getRaid()))
			return false;

		return true;
	}

}
