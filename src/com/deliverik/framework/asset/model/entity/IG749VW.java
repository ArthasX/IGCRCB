/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.asset.model.IG749Info;

/**
  * 概述: 资产模型视图实体
  * 功能描述: 资产模型视图实体
  * 创建记录: 2011/04/21
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="IG749")
public class IG749VW implements Serializable,
		Cloneable, IG749Info {

	/** 资产ID */
	@Id
	protected Integer eiid;

	/** 资产模型ID */
	protected Integer eid;

	/** 资产名称 */
	protected String einame;

	/** 资产编号 */
	protected String eilabel;

	/** 资产说明 */
	protected String eidesc;

	/** 资产更新时间 */
	protected String eiupdtime;

	/** 资产状态 */
	protected String eistatus;

	/** 资产版本 */
	protected Integer eiversion;

	/** 资产登记时间 */
	protected String eiinsdate;

	/** 资产所属机构层次码 */
	protected String eiorgsyscoding;

	/** 资产所属模型层次码 */
	protected String esyscoding;

	/** 资产管理人ID */
	protected String eiuserid;

	/** 资产管理人姓名 */
	protected String eiusername;

	/** 资产模型名称 */
	protected String ename;

	/** 模型标识 */
	protected String elabel;

	/** 模型分类 */
	protected String ecategory;
	
	/** 资产小版本*/
	protected Integer eismallversion;

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
	 * @param eiid资产ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	/**
	 * 资产模型ID取得
	 *
	 * @return 资产模型ID
	 */
	public Integer getEid() {
		return eid;
	}

	/**
	 * 资产模型ID设定
	 *
	 * @param eid资产模型ID
	 */
	public void setEid(Integer eid) {
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
	 * @param einame资产名称
	 */
	public void setEiname(String einame) {
		this.einame = einame;
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
	 * @param eilabel资产编号
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
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
	 * @param eidesc资产说明
	 */
	public void setEidesc(String eidesc) {
		this.eidesc = eidesc;
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
	 * @param eiupdtime资产更新时间
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
	 * @param eistatus资产状态
	 */
	public void setEistatus(String eistatus) {
		this.eistatus = eistatus;
	}

	/**
	 * 资产版本取得
	 *
	 * @return 资产版本
	 */
	public Integer getEiversion() {
		return eiversion;
	}

	/**
	 * 资产版本设定
	 *
	 * @param eiversion资产版本
	 */
	public void setEiversion(Integer eiversion) {
		this.eiversion = eiversion;
	}

	/**
	 * 资产登记时间取得
	 *
	 * @return 资产登记时间
	 */
	public String getEiinsdate() {
		return eiinsdate;
	}

	/**
	 * 资产登记时间设定
	 *
	 * @param eiinsdate资产登记时间
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
	 * @param eiorgsyscoding资产所属机构层次码
	 */
	public void setEiorgsyscoding(String eiorgsyscoding) {
		this.eiorgsyscoding = eiorgsyscoding;
	}

	/**
	 * 资产所属模型层次码取得
	 *
	 * @return 资产所属模型层次码
	 */
	public String getEsyscoding() {
		return esyscoding;
	}

	/**
	 * 资产所属模型层次码设定
	 *
	 * @param esyscoding资产所属模型层次码
	 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	/**
	 * 资产管理人ID取得
	 *
	 * @return 资产管理人ID
	 */
	public String getEiuserid() {
		return eiuserid;
	}

	/**
	 * 资产管理人ID设定
	 *
	 * @param eiuserid资产管理人ID
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
	 * @param eiusername资产管理人姓名
	 */
	public void setEiusername(String eiusername) {
		this.eiusername = eiusername;
	}

	/**
	 * 资产模型名称取得
	 *
	 * @return 资产模型名称
	 */
	public String getEname() {
		return ename;
	}

	/**
	 * 资产模型名称设定
	 *
	 * @param ename资产模型名称
	 */
	public void setEname(String ename) {
		this.ename = ename;
	}

	/**
	 * 模型标识取得
	 *
	 * @return 模型标识
	 */
	public String getElabel() {
		return elabel;
	}

	/**
	 * 模型标识设定
	 *
	 * @param elabel模型标识
	 */
	public void setElabel(String elabel) {
		this.elabel = elabel;
	}

	/**
	 * 模型分类取得
	 *
	 * @return 模型分类
	 */
	public String getEcategory() {
		return ecategory;
	}

	/**
	 * 模型分类设定
	 *
	 * @param ecategory模型分类
	 */
	public void setEcategory(String ecategory) {
		this.ecategory = ecategory;
	}
	
	/**
	 * 资产小版本取得
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

}