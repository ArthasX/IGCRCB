/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.sym.model.entity;

import java.io.Serializable;

import javax.persistence.Id;

import com.deliverik.infogovernor.sym.model.DateWorkVWInfo;

/**
 * 
 * 接待统计实体
 *
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
public class DateWorkVW implements Serializable, Cloneable, DateWorkVWInfo {

	@Id
	/** 日期 */
	protected String date;
	
	/** 用户ID */
	
	protected String userid;
	
	/** 角色ID */
	protected String roleid;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getRoleid() {
		return roleid;
	}

	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}
	
}
