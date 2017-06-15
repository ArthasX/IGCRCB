/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
  * 概述: 交换机Zone属性
  * 功能描述: 快照关系表实体
  * 创建记录: 2011/04/20
  * 修改记录: 
  */
@Entity
public class SwitchZoneVW implements Serializable,Cloneable{

	private static final long serialVersionUID = 1L;
	
	@Id
	/**ZoneID*/
    protected Integer eiid;
    
	/** Zone名称 */
	protected String zonename;

	/** Zone成员 */
	protected String zonemember;
	
	/** cfg */
	protected String effectivecfg;
	
	@Transient
	protected String eiids;

	public Integer getEiid() {
		return eiid;
	}

	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	public String getZonename() {
		return zonename;
	}

	public void setZonename(String zonename) {
		this.zonename = zonename;
	}

	public String getZonemember() {
		return zonemember;
	}

	public void setZonemember(String zonemember) {
		this.zonemember = zonemember;
	}

	public String getEffectivecfg() {
		return effectivecfg;
	}

	public void setEffectivecfg(String effectivecfg) {
		this.effectivecfg = effectivecfg;
	}

	public String getEiids() {
		return eiids;
	}

	public void setEiids(String eiids) {
		this.eiids = eiids;
	}
	
}