/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
  * 概述: 快照关系表实体
  * 功能描述: 快照关系表实体
  * 创建记录: 2011/04/20
  * 修改记录: 
  */
@Entity
public class SOC0140VW implements Serializable,Cloneable{

	private static final long serialVersionUID = 1L;

	@Id
	protected Integer eiid;

	/** DomainID */
	protected Integer version;

	/** Domain版本 */
	protected Integer smallversion;

	/** 源资产ID */
	protected String civalue;

	public Integer getEiid() {
		return eiid;
	}

	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Integer getSmallversion() {
		return smallversion;
	}

	public void setSmallversion(Integer smallversion) {
		this.smallversion = smallversion;
	}

	public String getCivalue() {
		return civalue;
	}

	public void setCivalue(String civalue) {
		this.civalue = civalue;
	}		
	
}