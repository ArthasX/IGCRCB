/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
  * 概述: 交换机属性
  * 功能描述: 快照关系表实体
  * 创建记录: 2011/04/20
  * 修改记录: 
  */
@Entity
public class SwitchConfigItemVW implements Serializable,Cloneable{

	private static final long serialVersionUID = 1L;
	
	@Id
	/**交换机ID*/
    protected Integer switchid;
    
	/** 交换机名称 */
	protected String switchname;

	/** IP地址 */
	protected String switchip;

	/** 交换机域 */
	protected String switchdomain;
	
	/** 交换机域 */
	protected String effectivecfg;

	public String getSwitchname() {
		return switchname;
	}

	public void setSwitchname(String switchname) {
		this.switchname = switchname;
	}

	public String getSwitchip() {
		return switchip;
	}

	public void setSwitchip(String switchip) {
		this.switchip = switchip;
	}

	public String getSwitchdomain() {
		return switchdomain;
	}

	public void setSwitchdomain(String switchdomain) {
		this.switchdomain = switchdomain;
	}

	public String getEffectivecfg() {
		return effectivecfg;
	}

	public void setEffectivecfg(String effectivecfg) {
		this.effectivecfg = effectivecfg;
	}

	public Integer getSwitchid() {
		return switchid;
	}

	public void setSwitchid(Integer switchid) {
		this.switchid = switchid;
	}
}