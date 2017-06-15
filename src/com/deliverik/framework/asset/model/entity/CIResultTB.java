/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.asset.model.CIResultInfo;
import com.deliverik.framework.base.BaseEntity;

/**
  * 概述: CI变更对比结果信息表实体
  * 功能描述: CI变更对比结果信息表实体
  * 创建记录: 2011/05/18
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="CIResult")
public class CIResultTB extends BaseEntity implements Serializable,
		Cloneable, CIResultInfo {

	/** CI变更对比结果 */
	@Id
	@TableGenerator(
		name="CIRESULT_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="CIRESULT_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="CIRESULT_TABLE_GENERATOR")
	protected Integer cirid;

	/** CI变更任务ID */
	protected Integer citid;

	/** CI变更时间戳 */
	protected String citime;

	/** 对比结果类型 */
	protected String cicmptype;

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
	protected String ciflag;

	/** CI变更结果说明 */
	protected String ciresultdesc;
	
	/** 资产层次码 */
	protected String esyscoding;

	/**
	 * CI变更对比结果取得
	 *
	 * @return CI变更对比结果
	 */
	public Integer getCirid() {
		return cirid;
	}

	/**
	 * CI变更对比结果设定
	 *
	 * @param cirid CI变更对比结果
	 */
	public void setCirid(Integer cirid) {
		this.cirid = cirid;
	}

	/**
	 * CI变更任务ID取得
	 *
	 * @return CI变更任务ID
	 */
	public Integer getCitid() {
		return citid;
	}

	/**
	 * CI变更任务ID设定
	 *
	 * @param citid CI变更任务ID
	 */
	public void setCitid(Integer citid) {
		this.citid = citid;
	}

	/**
	 * CI变更时间戳取得
	 *
	 * @return CI变更时间戳
	 */
	public String getCitime() {
		return citime;
	}

	/**
	 * CI变更时间戳设定
	 *
	 * @param citime CI变更时间戳
	 */
	public void setCitime(String citime) {
		this.citime = citime;
	}

	/**
	 * 对比结果类型取得
	 *
	 * @return 对比结果类型
	 */
	public String getCicmptype() {
		return cicmptype;
	}

	/**
	 * 对比结果类型设定
	 *
	 * @param cicmptype 对比结果类型
	 */
	public void setCicmptype(String cicmptype) {
		this.cicmptype = cicmptype;
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
	 * @param civalue 采集值
	 */
	public void setAuvalue(String auvalue) {
		this.auvalue = auvalue;
	}

	/**
	 * 合理标识取得
	 *
	 * @return 合理标识
	 */
	public String getCiflag() {
		return ciflag;
	}

	/**
	 * 合理标识设定
	 *
	 * @param ciflag 合理标识
	 */
	public void setCiflag(String ciflag) {
		this.ciflag = ciflag;
	}

	/**
	 * CI变更结果说明取得
	 *
	 * @return CI变更结果说明
	 */
	public String getCiresultdesc() {
		return ciresultdesc;
	}

	/**
	 * CI变更结果说明设定
	 *
	 * @param ciresultdesc CI变更结果说明
	 */
	public void setCiresultdesc(String ciresultdesc) {
		this.ciresultdesc = ciresultdesc;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return cirid;
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

}