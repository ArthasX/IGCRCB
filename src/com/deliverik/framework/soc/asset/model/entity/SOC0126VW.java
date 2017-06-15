/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.soc.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.soc.asset.model.SOC0126Info;

/**
 * 概述: 域明细信息
 * 功能描述: 域明细信息
 * 创建记录: 2011/05/25
 * 修改记录: 
 */
@SuppressWarnings("serial")
@Entity
@org.hibernate.annotations.Entity(mutable=false)
@Table(name = "SOC0126")
@IdClass(SOC0126PK.class)
public class SOC0126VW implements Serializable,Cloneable,SOC0126Info{

	
	/** 资产域ID */
	@Id
	protected Integer eiddid;

	/** 资产域版本 */
	@Id
	protected Integer eiddversion;

	/** 资产名称 */
	@Id
	protected String einame;

	/** 资产导入版本 */
	@Id
	protected Integer eiImportversion;
	
	protected Integer eiid;
	
	/**
	 * 创建时间
	 */
	protected String createtime;

	/** 逻辑删除标识 */
	protected String deleteflag;
	
	protected String fingerPrint;
	
	/** 域信息 */
	@ManyToOne
	@JoinColumns({
		  @JoinColumn(name="eiddid", referencedColumnName="eiddid" ,updatable=false, insertable= false),
		  @JoinColumn(name="eiddversion", referencedColumnName="version",updatable=false, insertable= false)
		      })
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected SOC0111TB eiDomainDefTB;
	
	
	
	
	
	/**
	 * 域信息取得
	 * @return 域信息
	 */
	public SOC0111TB getEiDomainDefTB() {
		return eiDomainDefTB;
	}
	
	/**
	 * 域信息设定
	 * @param eiDomainDefTB域信息
	 */
	public void setEiDomainDefTB(SOC0111TB eiDomainDefTB) {
		this.eiDomainDefTB = eiDomainDefTB;
	}
	
	/**
	 * 逻辑删除标识取得
	 *
	 * @return 逻辑删除标识
	 */
	public String getDeleteflag() {
		return deleteflag;
	}

	/**
	 * 逻辑删除标识设定
	 *
	 * @param brdeleteflag逻辑删除标识
	 */
	public void setDeleteflag(String deleteflag) {
		this.deleteflag = deleteflag;
	}
	/**
	 * 资产域ID取得
	 *
	 * @return 资产域ID
	 */
	public Integer getEiddid() {
		return eiddid;
	}

	/**
	 * 资产域ID设定
	 *
	 * @param eiddid资产域ID
	 */
	public void setEiddid(Integer eiddid) {
		this.eiddid = eiddid;
	}

	/**
	 * 资产域版本取得
	 *
	 * @return 资产域版本
	 */
	public Integer getEiddversion() {
		return eiddversion;
	}

	/**
	 * 资产域版本设定
	 *
	 * @param eiddversion资产域版本
	 */
	public void setEiddversion(Integer eiddversion) {
		this.eiddversion = eiddversion;
	}



	/**
	 * 资产导入版本取得
	 *
	 * @return 资产导入版本
	 */
	public Integer getEiImportversion() {
		return eiImportversion;
	}

	/**
	 * 资产导入版本设定
	 *
	 * @param eiImportversion资产导入版本
	 */
	public void setEiImportversion(Integer eiImportversion) {
		this.eiImportversion = eiImportversion;
	}

	public  String getEiname() {
		return einame;
	}

	public void setEiname(String einame) {
		this.einame = einame;
	}
	public SOC0126VW(){
		
	}
    public SOC0126VW(Integer eiddid,Integer eiddversion,String einame,Integer eiImportversion,String createtime){
    	this.eiddid = eiddid;
    	this.eiddversion = eiddversion;
    	this.einame = einame;
    	this.eiImportversion = eiImportversion;
    	this.createtime = createtime;		
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return new SOC0112PK(eiddid, eiddversion, einame,eiImportversion);
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getFingerPrint() {
		return fingerPrint;
	}

	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}

	public Integer getEiid() {
		return eiid;
	}

	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}
	
	
}
