/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.soc.asset.model.SOC0114Info;

/**
  * 概述: 实体链路图实体
  * 功能描述: 实体链路图实体
  * 创建记录: 2011/05/24
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@IdClass(SOC0114PK.class)
@Table(name="SOC0114")
public class SOC0114TB extends BaseEntity implements Serializable,
		Cloneable, SOC0114Info {

	/** 域ID */
	@Id
	protected Integer domainid;

	/** Domain版本 */
	@Id
	protected Integer domainversion;

	/** 链路ID */
	@Id
	protected Integer linkid;

	/** 链路顺序 */
	@Id
	protected Integer linkorder;

	/** 实体id */
	protected Integer eiid;

	/** 实体名 */
	protected String einame;

	/** 资产层次码 */
	protected String esyscoding;

	/** 大版本 */
	protected Integer eiversion;

	/** 小版本 */
	protected Integer eismallversion;
	
	/** 绘图标记 */
	protected String linkflag;
	
	/** 创建时间 */
	protected String createtime;
	
	/** 链路结束标识 */
	protected String endflag;
	
	/**
	 * 绘图标记取得
	 *
	 * @return 绘图标记
	 */
	public String getLinkflag() {
		return linkflag;
	}
	
	/**
	 * 绘图标记设定
	 *
	 * @param linkflag 绘图标记
	 */
	public void setLinkflag(String linkflag) {
		this.linkflag = linkflag;
	}

	/**
	 * 域ID取得
	 *
	 * @return 域ID
	 */
	public Integer getDomainid() {
		return domainid;
	}

	/**
	 * 域ID设定
	 *
	 * @param domainid 域ID
	 */
	public void setDomainid(Integer domainid) {
		this.domainid = domainid;
	}

	/**
	 * Domain版本取得
	 *
	 * @return Domain版本
	 */
	public Integer getDomainversion() {
		return domainversion;
	}

	/**
	 * Domain版本设定
	 *
	 * @param domainversion Domain版本
	 */
	public void setDomainversion(Integer domainversion) {
		this.domainversion = domainversion;
	}

	/**
	 * 链路ID取得
	 *
	 * @return 链路ID
	 */
	public Integer getLinkid() {
		return linkid;
	}

	/**
	 * 链路ID设定
	 *
	 * @param linkid 链路ID
	 */
	public void setLinkid(Integer linkid) {
		this.linkid = linkid;
	}

	/**
	 * 链路顺序取得
	 *
	 * @return 链路顺序
	 */
	public Integer getLinkorder() {
		return linkorder;
	}

	/**
	 * 链路顺序设定
	 *
	 * @param linkorder 链路顺序
	 */
	public void setLinkorder(Integer linkorder) {
		this.linkorder = linkorder;
	}

	/**
	 * 实体id取得
	 *
	 * @return 实体id
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * 实体id设定
	 *
	 * @param eiid 实体id
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	/**
	 * 实体名取得
	 *
	 * @return 实体名
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * 实体名设定
	 *
	 * @param einame 实体名
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**
	 * 资产层次码取得
	 *
	 * @return 资产层次码
	 */
	public String getEsyscoding() {
		return esyscoding;
	}

	/**
	 * 资产层次码设定
	 *
	 * @param esyscoding 资产层次码
	 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	/**
	 * 大版本取得
	 *
	 * @return 大版本
	 */
	public Integer getEiversion() {
		return eiversion;
	}

	/**
	 * 大版本设定
	 *
	 * @param eiversion 大版本
	 */
	public void setEiversion(Integer eiversion) {
		this.eiversion = eiversion;
	}

	/**
	 * 小版本取得
	 *
	 * @return 小版本
	 */
	public Integer getEismallversion() {
		return eismallversion;
	}

	/**
	 * 小版本设定
	 *
	 * @param eismallversion 小版本
	 */
	public void setEismallversion(Integer eismallversion) {
		this.eismallversion = eismallversion;
	}
	
	/**
	 * 创建时间取得
	 *
	 * @return 创建时间
	 */
	public String getCreatetime() {
		return createtime;
	}

	/**
	 * 创建时间设定
	 *
	 * @param createtime 创建时间
	 */
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	
	/**
	 * 链路结束标识取得
	 *
	 * @return 链路结束标识
	 */
	public String getEndflag() {
		return endflag;
	}

	/**
	 * 链路结束标识设定
	 *
	 * @param endflag 链路结束标识
	 */
	public void setEndflag(String endflag) {
		this.endflag = endflag;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return new SOC0114PK(domainid, domainversion, linkid, linkorder);
	}

}