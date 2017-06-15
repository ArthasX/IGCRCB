/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.framework.soc.asset.model.PlatformManagerInfo;

/**
 * 概述: 业务系统管理员缺失视图
 * 功能描述: 业务系统管理员缺失视图
 * 创建记录: 2013/12/11
 * 修改记录: 
 */
@Entity
public class PlatformManagerVW implements Serializable,Cloneable,PlatformManagerInfo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	/**业务系统eiid*/
	private Integer eiid;
	/**业务系统名称*/
	private String	eiName;
	/**业务系统登记人员*/
	private String eiUserName;
	/**业务系统登记日期*/
	private String eiInsDate;
	/**管理员A*/
	private String magea;
	/**管理员B*/
	private String mageb;

	public Integer getEiid() {
		return eiid;
	}

	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	public String getEiName() {
		return eiName;
	}

	public void setEiName(String eiName) {
		this.eiName = eiName;
	}

	public String getEiUserName() {
		return eiUserName;
	}

	public void setEiUserName(String eiUserName) {
		this.eiUserName = eiUserName;
	}

	public String getEiInsDate() {
		return eiInsDate;
	}

	public void setEiInsDate(String eiInsDate) {
		this.eiInsDate = eiInsDate;
	}

	public String getMagea() {
		return magea;
	}

	public void setMagea(String magea) {
		this.magea = magea;
	}

	public String getMageb() {
		return mageb;
	}

	public void setMageb(String mageb) {
		this.mageb = mageb;
	}
	
	
	
	
}