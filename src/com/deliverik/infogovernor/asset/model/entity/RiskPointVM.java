/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.asset.model.RiskPointVMInfo;

/**
  * 概述: 风险点查询实体
  * 功能描述: 风险点查询实体
  * 创建记录: 2014/06/30
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="RiskPointVM")
public class RiskPointVM extends BaseEntity implements Serializable,
		Cloneable, RiskPointVMInfo {

	/** 主键 */
	@Id
	@TableGenerator(
		name="RISKPOINTVM_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="RISKPOINTVM_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="RISKPOINTVM_TABLE_GENERATOR")
	protected Integer eiid;

	/** 资产模型ID */
	protected String eid;

	/** 资产名称 */
	protected String einame;

	/** 资产说明 */
	protected String eidesc;

	/** 资产编号 */
	protected String eilabel;

	/** 资产更新时间 */
	protected String eiupdtime;

	/** 资产状态 */
	protected String eistatus;

	/** 资产版本号 */
	protected Integer eiversion;

	/** 资产登记日 */
	protected String eiinsdate;

	/** 资产所属机构层次码 */
	protected String eiorgsyscoding;

	/** 资产模型层次码 */
	protected String esyscoding;

	/** 资产管理人 */
	protected String eiuserid;

	/** 资产管理人姓名 */
	protected String eiusername;

	/** 资产小版本 */
	protected Integer eismallversion;

	/** 资产所属树根节点实体标识 */
	protected Integer eirootmark;

	/** 资产管理人 */
	protected String managername;

	/** 级别 */
	protected String levels;

	/** 等级 */
	protected String grad;

	/** 风险领域名称 */
	protected String riskly;

	/** 风险子域名称 */
	protected String riskarea;

	/** 风险项称 */
	protected String riskitem;
	
	/**说明*/
	protected String bh;
	/**可能性*/
	protected String poss;
	
	/**管理人名字*/
	protected String mguserid;
	
	/**风险点标志*/
	protected String risksign;
	

	/**
	 * 风险点标志取得
	 * @return risksign 风险点标志
	 */
	public String getRisksign() {
		return risksign;
	}

	/**
	 * 风险点标志设定
	 * @param risksign 风险点标志
	 */
	public void setRisksign(String risksign) {
		this.risksign = risksign;
	}

	/**
	 * 管理人名字取得
	 * @return mguserid 管理人名字
	 */
	public String getMguserid() {
		return mguserid;
	}

	/**
	 * 管理人名字设定
	 * @param mguserid 管理人名字
	 */
	public void setMguserid(String mguserid) {
		this.mguserid = mguserid;
	}

	/**
	 * 可能性取得
	 * @return poss 可能性
	 */
	public String getPoss() {
		return poss;
	}

	/**
	 * 可能性设定
	 * @param poss 可能性
	 */
	public void setPoss(String poss) {
		this.poss = poss;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * 主键设定
	 *
	 * @param eiid 主键
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	/**
	 * 资产模型ID取得
	 *
	 * @return 资产模型ID
	 */
	public String getEid() {
		return eid;
	}

	/**
	 * 资产模型ID设定
	 *
	 * @param eid 资产模型ID
	 */
	public void setEid(String eid) {
		this.eid = eid;
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
	 * 资产说明取得
	 *
	 * @return 资产说明
	 */
	public String getEidesc() {
		return eidesc;
	}

	/**
	 * 资产说明设定
	 *
	 * @param eidesc 资产说明
	 */
	public void setEidesc(String eidesc) {
		this.eidesc = eidesc;
	}

	/**
	 * 资产编号取得
	 *
	 * @return 资产编号
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * 资产编号设定
	 *
	 * @param eilabel 资产编号
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	/**
	 * 资产更新时间取得
	 *
	 * @return 资产更新时间
	 */
	public String getEiupdtime() {
		return eiupdtime;
	}

	/**
	 * 资产更新时间设定
	 *
	 * @param eiupdtime 资产更新时间
	 */
	public void setEiupdtime(String eiupdtime) {
		this.eiupdtime = eiupdtime;
	}

	/**
	 * 资产状态取得
	 *
	 * @return 资产状态
	 */
	public String getEistatus() {
		return eistatus;
	}

	/**
	 * 资产状态设定
	 *
	 * @param eistatus 资产状态
	 */
	public void setEistatus(String eistatus) {
		this.eistatus = eistatus;
	}

	/**
	 * 资产版本号取得
	 *
	 * @return 资产版本号
	 */
	public Integer getEiversion() {
		return eiversion;
	}

	/**
	 * 资产版本号设定
	 *
	 * @param eiversion 资产版本号
	 */
	public void setEiversion(Integer eiversion) {
		this.eiversion = eiversion;
	}

	/**
	 * 资产登记日取得
	 *
	 * @return 资产登记日
	 */
	public String getEiinsdate() {
		return eiinsdate;
	}

	/**
	 * 资产登记日设定
	 *
	 * @param eiinsdate 资产登记日
	 */
	public void setEiinsdate(String eiinsdate) {
		this.eiinsdate = eiinsdate;
	}

	/**
	 * 资产所属机构层次码取得
	 *
	 * @return 资产所属机构层次码
	 */
	public String getEiorgsyscoding() {
		return eiorgsyscoding;
	}

	/**
	 * 资产所属机构层次码设定
	 *
	 * @param eiorgsyscoding 资产所属机构层次码
	 */
	public void setEiorgsyscoding(String eiorgsyscoding) {
		this.eiorgsyscoding = eiorgsyscoding;
	}

	/**
	 * 资产模型层次码取得
	 *
	 * @return 资产模型层次码
	 */
	public String getEsyscoding() {
		return esyscoding;
	}

	/**
	 * 资产模型层次码设定
	 *
	 * @param esyscoding 资产模型层次码
	 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	/**
	 * 资产管理人取得
	 *
	 * @return 资产管理人
	 */
	public String getEiuserid() {
		return eiuserid;
	}

	/**
	 * 资产管理人设定
	 *
	 * @param eiuserid 资产管理人
	 */
	public void setEiuserid(String eiuserid) {
		this.eiuserid = eiuserid;
	}

	/**
	 * 资产管理人姓名取得
	 *
	 * @return 资产管理人姓名
	 */
	public String getEiusername() {
		return eiusername;
	}

	/**
	 * 资产管理人姓名设定
	 *
	 * @param eiusername 资产管理人姓名
	 */
	public void setEiusername(String eiusername) {
		this.eiusername = eiusername;
	}

	/**
	 * 资产小版本取得
	 *
	 * @return 资产小版本
	 */
	public Integer getEismallversion() {
		return eismallversion;
	}

	/**
	 * 资产小版本设定
	 *
	 * @param eismallversion 资产小版本
	 */
	public void setEismallversion(Integer eismallversion) {
		this.eismallversion = eismallversion;
	}

	/**
	 * 资产所属树根节点实体标识取得
	 *
	 * @return 资产所属树根节点实体标识
	 */
	public Integer getEirootmark() {
		return eirootmark;
	}

	/**
	 * 资产所属树根节点实体标识设定
	 *
	 * @param eirootmark 资产所属树根节点实体标识
	 */
	public void setEirootmark(Integer eirootmark) {
		this.eirootmark = eirootmark;
	}

	/**
	 * 资产管理人取得
	 *
	 * @return 资产管理人
	 */
	public String getManagername() {
		return managername;
	}

	/**
	 * 资产管理人设定
	 *
	 * @param managername 资产管理人
	 */
	public void setManagername(String managername) {
		this.managername = managername;
	}

	/**
	 * 级别取得
	 *
	 * @return 级别
	 */
	public String getLevels() {
		return levels;
	}

	/**
	 * 级别设定
	 *
	 * @param levels 级别
	 */
	public void setLevels(String levels) {
		this.levels = levels;
	}

	/**
	 * 等级取得
	 *
	 * @return 等级
	 */
	public String getGrad() {
		return grad;
	}

	/**
	 * 等级设定
	 *
	 * @param grad 等级
	 */
	public void setGrad(String grad) {
		this.grad = grad;
	}

	/**
	 * 风险领域名称取得
	 *
	 * @return 风险领域名称
	 */
	public String getRiskly() {
		return riskly;
	}

	/**
	 * 风险领域名称设定
	 *
	 * @param riskly 风险领域名称
	 */
	public void setRiskly(String riskly) {
		this.riskly = riskly;
	}

	/**
	 * 风险子域名称取得
	 *
	 * @return 风险子域名称
	 */
	public String getRiskarea() {
		return riskarea;
	}

	/**
	 * 风险子域名称设定
	 *
	 * @param riskarea 风险子域名称
	 */
	public void setRiskarea(String riskarea) {
		this.riskarea = riskarea;
	}

	/**
	 * 风险项称取得
	 *
	 * @return 风险项称
	 */
	public String getRiskitem() {
		return riskitem;
	}

	/**
	 * 风险项称设定
	 *
	 * @param riskitem 风险项称
	 */
	public void setRiskitem(String riskitem) {
		this.riskitem = riskitem;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return eiid;
	}

	/**
	 * 编号取得
	 * @return bh 编号
	 */
	public String getBh() {
		return bh;
	}

	/**
	 * 编号设定
	 * @param bh 编号
	 */
	public void setBh(String bh) {
		this.bh = bh;
	}

}