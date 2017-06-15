package com.deliverik.framework.user.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.user.model.Action;


/**
 * <p>
 * 菜单信息实体
 * </p>
 */
@SuppressWarnings("serial")
@Entity
@Table(name="Action")
public class ActionTB extends BaseEntity implements Serializable, Cloneable, Action {
	
	/** 菜单ID */
	@Id
	protected String actname;

	/** 菜单显示名称 */
	protected String actlabel;

	/** 菜单描述 */
	protected String actdesc;

	/** 菜单URL */
	protected String acturl;

	/** 菜单类型 */
	protected String acttype;

	/** 一级菜单ID */
	protected Integer actl1id;

	/** 二级菜单ID */
	protected Integer actl2id;

	/** 三级菜单ID */
	protected Integer actl3id;
	
	/** 菜单可授予角色类型(逗号分割) */
	protected String actroletype;
	
	/** 菜单排序ID*/
	protected String actsortid;
	
	/** 菜单URL类型 */
	protected String acturltype;
	
	/**
	 * 菜单命名取得
	 * @return 菜单命名
	 */
	public String getActname() {
		return actname;
	}

	/**
	 * 菜单命名设定
	 *
	 * @param actname 菜单命名
	 */
	public void setActname(String actname) {
		this.actname = actname;
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
	 * 一级菜单ID取得
	 * @return 一级菜单ID
	 */
	public Integer getActl1id() {
		return actl1id;
	}

	/**
	 * 一级菜单ID设定
	 *
	 * @param actl1id 一级菜单ID
	 */
	public void setActl1id(Integer actl1id) {
		this.actl1id = actl1id;
	}

	/**
	 * 二级菜单ID取得
	 * @return 二级菜单ID
	 */
	public Integer getActl2id() {
		return actl2id;
	}

	/**
	 * 二级菜单ID设定
	 *
	 * @param actl2id 二级菜单ID
	 */
	public void setActl2id(Integer actl2id) {
		this.actl2id = actl2id;
	}

	/**
	 * 三级菜单ID取得
	 * @return 三级菜单ID
	 */
	public Integer getActl3id() {
		return actl3id;
	}

	/**
	 * 三级菜单ID设定
	 *
	 * @param actl3id 三级菜单ID
	 */
	public void setActl3id(Integer actl3id) {
		this.actl3id = actl3id;
	}
	
	/**
	 * 菜单可授予角色类型(逗号分割)取得
	 * @return 菜单可授予角色类型(逗号分割)
	 */
	public String getActroletype() {
		return actroletype;
	}

	/**
	 * 菜单可授予角色类型(逗号分割)设定
	 *
	 * @param actroletype 菜单可授予角色类型(逗号分割)
	 */
	public void setActroletype(String actroletype) {
		this.actroletype = actroletype;
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
		return actname;
	}

	/**
	 * 比较两个对象是否相同
	 * @param obj
	 * @return 比较结果（true相同，false不同）
	 */
	public boolean equals(Object obj) {
		if (!(obj instanceof ActionTB))
			return false;
		Action target = (Action) obj;
		if (!(getActname()==target.getActname()))
			return false;

		return true;
	}
	
	

}
