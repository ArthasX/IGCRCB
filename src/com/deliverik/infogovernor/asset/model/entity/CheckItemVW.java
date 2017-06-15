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
import com.deliverik.infogovernor.asset.model.CheckItemVWInfo;

/**
  * 概述: 检查项查询实体
  * 功能描述: 检查项查询实体
  * 创建记录: 2014/07/01
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="CheckItemVW")
public class CheckItemVW extends BaseEntity implements Serializable,
		Cloneable, CheckItemVWInfo {

	/** 主键 */
	@Id
	@TableGenerator(
		name="CHECKITEMVW_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="CHECKITEMVW_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="CHECKITEMVW_TABLE_GENERATOR")
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

	/** 资料调阅 */
	protected String datady;

	/** 编号 */
	protected String bh;

	/** 访谈对象 */
	protected String viewobj;

	/** 风险领域名称 */
	protected String riskly;

	/** 风险子域名称 */
	protected String riskarea;

	/** 风险向名称 */
	protected String riskitem;
	
	/**建议检查频度*/
	protected String checkfrequency;
	/**使用范围*/
	protected String mgrange;
	/**管理人id*/
	protected String  mguserid;
	

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
	 * 建议检查频度取得
	 * @return checkfrequency 建议检查频度
	 */
	public String getCheckfrequency() {
		return checkfrequency;
	}

	/**
	 * 建议检查频度设定
	 * @param checkfrequency 建议检查频度
	 */
	public void setCheckfrequency(String checkfrequency) {
		this.checkfrequency = checkfrequency;
	}

	/**
	 * 使用范围取得
	 * @return mgrange 使用范围
	 */
	public String getMgrange() {
		return mgrange;
	}

	/**
	 * 使用范围设定
	 * @param mgrange 使用范围
	 */
	public void setMgrange(String mgrange) {
		this.mgrange = mgrange;
	}

	/**
	 * 管理人id取得
	 * @return mguserid 管理人id
	 */
	public String getMguserid() {
		return mguserid;
	}

	/**
	 * 管理人id设定
	 * @param mguserid 管理人id
	 */
	public void setMguserid(String mguserid) {
		this.mguserid = mguserid;
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
	 * 资料调阅取得
	 *
	 * @return 资料调阅
	 */
	public String getDatady() {
		return datady;
	}

	/**
	 * 资料调阅设定
	 *
	 * @param datady 资料调阅
	 */
	public void setDatady(String datady) {
		this.datady = datady;
	}

	/**
	 * 编号取得
	 *
	 * @return 编号
	 */
	public String getBh() {
		return bh;
	}

	/**
	 * 编号设定
	 *
	 * @param bh 编号
	 */
	public void setBh(String bh) {
		this.bh = bh;
	}

	/**
	 * 访谈对象取得
	 *
	 * @return 访谈对象
	 */
	public String getViewobj() {
		return viewobj;
	}

	/**
	 * 访谈对象设定
	 *
	 * @param viewobj 访谈对象
	 */
	public void setViewobj(String viewobj) {
		this.viewobj = viewobj;
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
	 * 风险向名称取得
	 *
	 * @return 风险向名称
	 */
	public String getRiskitem() {
		return riskitem;
	}

	/**
	 * 风险向名称设定
	 *
	 * @param riskitem 风险向名称
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

}