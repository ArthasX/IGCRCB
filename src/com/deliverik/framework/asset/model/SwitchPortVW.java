/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
  * 概述: 交换机端口属性
  * 功能描述: 快照关系表实体
  * 创建记录: 2011/04/20
  * 修改记录: 
  */
@Entity
public class SwitchPortVW implements Serializable,Cloneable{

	private static final long serialVersionUID = 1L;
	
	@Id
	/**portID*/
    protected Integer eiid;
    
	/** 端口号 */
	protected String port;

	/** WWN */
	protected String wwn;
	@Transient
	protected String eiids;

	public Integer getEiid() {
		return eiid;
	}

	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getWwn() {
		return wwn;
	}

	public void setWwn(String wwn) {
		this.wwn = wwn;
	}

	public String getEiids() {
		return eiids;
	}

	public void setEiids(String eiids) {
		this.eiids = eiids;
	}

	
}