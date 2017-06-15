/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset;

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

import com.deliverik.framework.soc.asset.model.entity.SOC0117TB;

/**
 * 概述: 审计对比结果信息表实体
 * 功能描述: 审计对比结果信息表实体
 * 创建记录: 2012/03/05
 * 修改记录: 
 */
@SuppressWarnings("serial")
@Entity
@IdClass(SOC0137PK.class)
public class SOC0137TB implements Serializable,Cloneable,SOC0137Info{
	
	/** 审计任务ID */
	@Id
	protected Integer autid;
	
	/** 资产ID */
	@Id
	protected Integer eiid;

	/** 大版本 */
	@Id
	protected Integer eiversion;

	/** 小版本 */
	@Id
	protected Integer eismallversion;
	
	/** 审计时间戳 */
	protected String autime;

	/** 资产名称 */
	protected String einame;
	
	/** 对比结果类型 */
	protected String aucmptype;
	
	/** 合理标识 */
	protected String auflag;
	
	/** 资产层次码 */
	protected String esyscoding;
	
	/** 模型实体 */
	@ManyToOne
	@JoinColumn(name="esyscoding", referencedColumnName="esyscoding", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected SOC0117TB entityTB;
	

	/**
	 * 审计时间戳取得
	 *
	 * @return 审计时间戳
	 */
	public String getAutime() {
		return autime;
	}

	/**
	 * 审计时间戳设定
	 *
	 * @param autime 审计时间戳
	 */
	public void setAutime(String autime) {
		this.autime = autime;
	}
	
	/**
	 * 审计任务ID取得
	 *
	 * @return 审计任务ID
	 */
	public Integer getAutid() {
		return autid;
	}

	/**
	 * 审计任务ID设定
	 *
	 * @param autid 审计任务ID
	 */
	public void setAutid(Integer autid) {
		this.autid = autid;
	}


	/**
	 * 对比结果类型取得
	 *
	 * @return 对比结果类型
	 */
	public String getAucmptype() {
		return aucmptype;
	}

	/**
	 * 对比结果类型设定
	 *
	 * @param aucmptype 对比结果类型
	 */
	public void setAucmptype(String aucmptype) {
		this.aucmptype = aucmptype;
	}

	/**
	 * 资产ID取得
	 *
	 * @return 资产ID
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * 资产ID设定
	 *
	 * @param eiid 资产ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
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
	 * 资产名称取得
	 *
	 * @return 资产名称
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * 资产名称设定
	 *
	 * @param einame 资产名称
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**
	 * 合理标识取得
	 *
	 * @return 合理标识
	 */
	public String getAuflag() {
		return auflag;
	}

	/**
	 * 合理标识设定
	 *
	 * @param auflag 合理标识
	 */
	public void setAuflag(String auflag) {
		this.auflag = auflag;
	}

	/**
	 * 资产层次码取得
	 * @return 资产层次码
	 */
	public String getEsyscoding() {
		return esyscoding;
	}

	/**
	 * 资产层次码设定
	 * @param esyscoding 资产层次码
	 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	/**
	 * 模型实体取得
	 * @return 模型实体
	 */
	public SOC0117TB getEntityTB() {
		return entityTB;
	}

}
