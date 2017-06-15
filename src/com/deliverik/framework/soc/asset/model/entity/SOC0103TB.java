/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.soc.asset.model.entity.SOC0117TB;
import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.soc.asset.model.SOC0103Info;

/**
  * 概述: 审计对比结果信息表实体
  * 功能描述: 审计对比结果信息表实体
  * 创建记录: 2011/05/18
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="SOC0103")
public class SOC0103TB extends BaseEntity implements Serializable,
		Cloneable, SOC0103Info {

	/** 审计对比结果 */
	@Id
	@TableGenerator(
		name="SOC0103_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="SOC0103_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="SOC0103_TABLE_GENERATOR")
	protected Integer aurid;

	/** 审计任务ID */
	protected Integer autid;

	/** 审计时间戳 */
	protected String autime;

	/** 对比结果类型 */
	protected String aucmptype;

	/** 资产ID */
	protected Integer eiid;

	/** 大版本 */
	protected Integer eiversion;

	/** 小版本 */
	protected Integer eismallversion;

	/** 资产名称 */
	protected String einame;

	/** 顶级CI标识 */
	protected Integer eirootmark;

	/** 属性ID */
	protected Integer ciid;

	/** 属性名 */
	protected String cname;

	/** 当前版本值 */
	protected String civalue;

	/** 采集值 */
	protected String auvalue;

	/** 合理标识 */
	protected String auflag;

	/** 审计结果说明 */
	protected String auresultdesc;
	
	/** 资产层次码 */
	protected String esyscoding;
	
	
	/** 模型实体 */
	@ManyToOne
	@JoinColumn(name="esyscoding", referencedColumnName="esyscoding", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected SOC0117TB entityTB;

	/**
	 * 审计对比结果取得
	 *
	 * @return 审计对比结果
	 */
	public Integer getAurid() {
		return aurid;
	}

	/**
	 * 审计对比结果设定
	 *
	 * @param aurid 审计对比结果
	 */
	public void setAurid(Integer aurid) {
		this.aurid = aurid;
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
	 * 顶级CI标识取得
	 *
	 * @return 顶级CI标识
	 */
	public Integer getEirootmark() {
		return eirootmark;
	}

	/**
	 * 顶级CI标识设定
	 *
	 * @param eirootmark 顶级CI标识
	 */
	public void setEirootmark(Integer eirootmark) {
		this.eirootmark = eirootmark;
	}

	/**
	 * 属性ID取得
	 *
	 * @return 属性ID
	 */
	public Integer getCiid() {
		return ciid;
	}

	/**
	 * 属性ID设定
	 *
	 * @param ciid 属性ID
	 */
	public void setCiid(Integer ciid) {
		this.ciid = ciid;
	}

	/**
	 * 属性名取得
	 *
	 * @return 属性名
	 */
	public String getCname() {
		return cname;
	}

	/**
	 * 属性名设定
	 *
	 * @param cname 属性名
	 */
	public void setCname(String cname) {
		this.cname = cname;
	}

	/**
	 * 当前版本值取得
	 *
	 * @return 当前版本值
	 */
	public String getCivalue() {
		return civalue;
	}

	/**
	 * 当前版本值设定
	 *
	 * @param civalue 当前版本值
	 */
	public void setCivalue(String civalue) {
		this.civalue = civalue;
	}

	/**
	 * 采集值取得
	 *
	 * @return 采集值
	 */
	public String getAuvalue() {
		return auvalue;
	}

	/**
	 * 采集值设定
	 *
	 * @param auvalue 采集值
	 */
	public void setAuvalue(String auvalue) {
		this.auvalue = auvalue;
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
	 * 审计结果说明取得
	 *
	 * @return 审计结果说明
	 */
	public String getAuresultdesc() {
		return auresultdesc;
	}

	/**
	 * 审计结果说明设定
	 *
	 * @param auresultdesc 审计结果说明
	 */
	public void setAuresultdesc(String auresultdesc) {
		this.auresultdesc = auresultdesc;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return aurid;
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