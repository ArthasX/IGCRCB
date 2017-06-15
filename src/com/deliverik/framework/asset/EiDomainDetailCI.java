/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.asset;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.asset.model.entity.IG013TB;



/**
 * 概述: 域明细信息（影响CI）
 * 功能描述: 域明细信息（影响CI）
 * 创建记录: 2011/05/25
 * 修改记录: 
 */
@SuppressWarnings("serial")
@Entity
@IdClass(EiDomainDetailCIPK.class)
public class EiDomainDetailCI implements Serializable,Cloneable,EiDomainDetailCIInfo{
	 
	@Id
	protected Integer domainid;
	
	@Id
	protected Integer domainversion;
	
	protected String name;
	
	protected String einame;
	
	@Id
	protected Integer eiversion;
	
	protected String eiupdtime;
	
	@Id
	protected Integer eiid;
	
	@ManyToOne
	@JoinColumn(name="eiid", referencedColumnName="eiid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected IG013TB entityItemTB;

	public IG013TB getEntityItemTB()
	{
		return entityItemTB;
	}

	public void setEntityItemTB(IG013TB entityItemTB)
	{
		this.entityItemTB = entityItemTB;
	}

	public Integer getDomainid() {
		return domainid;
	}

	public void setDomainid(Integer domainid) {
		this.domainid = domainid;
	}

	public Integer getDomainversion() {
		return domainversion;
	}

	public void setDomainversion(Integer domainversion) {
		this.domainversion = domainversion;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEiname() {
		return einame;
	}

	public void setEiname(String einame) {
		this.einame = einame;
	}

	public Integer getEiversion() {
		return eiversion;
	}

	public void setEiversion(Integer eiversion) {
		this.eiversion = eiversion;
	}

	public String getEiupdtime() {
		return eiupdtime;
	}

	public void setEiupdtime(String eiupdtime) {
		this.eiupdtime = eiupdtime;
	}

	public String getFingerPrint() {
		return null;
	}

	public Integer getEiid() {
		return eiid;
	}

	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}
	
	
	

}
