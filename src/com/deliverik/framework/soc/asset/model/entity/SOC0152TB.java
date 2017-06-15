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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.soc.asset.model.SOC0152Info;

/**
  * 概述: 资产关系表实体
  * 功能描述: 资产关系表实体
  * 创建记录: 杨龙全 2013/05/27
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="SOC0152")
@IdClass(SOC0152PK.class)
public class SOC0152TB extends BaseEntity implements Serializable,
		Cloneable, SOC0152Info {

	/** 关系码 */
	protected String rlnCode;

	/** 开始模型名字 */
	protected String fromModelName;

	/** 开始模型ID */
	@Id
	protected String fromModelEid;

	/** 到模型名字 */
	protected String toModelName;

	/** 到模型ID */
	@Id
	protected String toModelEid;

	/** 关系描述 */
	protected String rlnDesc;

	/** 预留字段1 */
	protected String rlnKey1;

	/** 预留字段2 */
	protected String rlnKey2;
	
	/**关系类别*/
	protected String rlnType;
	
	/** 导入对象类型信息 */
	@ManyToOne
	@JoinColumn(name="frommodeleid", referencedColumnName="eid",  updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected SOC0117TB from0117TB;
	
	/** 导入对象类型信息 */
	@ManyToOne
	@JoinColumn(name="tomodeleid", referencedColumnName="eid",  updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected SOC0117TB to0117TB;
	

	public SOC0117TB getFrom0117TB() {
		return from0117TB;
	}

	public void setFrom0117TB(SOC0117TB from0117TB) {
		this.from0117TB = from0117TB;
	}

	public SOC0117TB getTo0117TB() {
		return to0117TB;
	}

	public void setTo0117TB(SOC0117TB to0117TB) {
		this.to0117TB = to0117TB;
	}

	/**
	 * 关系码取得
	 *
	 * @return 关系码
	 */
	public String getRlnCode() {
		return rlnCode;
	}

	/**
	 * 关系码设定
	 *
	 * @param rlnCode 关系码
	 */
	public void setRlnCode(String rlnCode) {
		this.rlnCode = rlnCode;
	}

	/**
	 * 开始模型名字取得
	 *
	 * @return 开始模型名字
	 */
	public String getFromModelName() {
		return fromModelName;
	}

	/**
	 * 开始模型名字设定
	 *
	 * @param fromModelName 开始模型名字
	 */
	public void setFromModelName(String fromModelName) {
		this.fromModelName = fromModelName;
	}

	/**
	 * 开始模型ID取得
	 *
	 * @return 开始模型ID
	 */
	public String getFromModelEid() {
		return fromModelEid;
	}

	/**
	 * 开始模型ID设定
	 *
	 * @param fromModelEid 开始模型ID
	 */
	public void setFromModelEid(String fromModelEid) {
		this.fromModelEid = fromModelEid;
	}

	/**
	 * 到模型名字取得
	 *
	 * @return 到模型名字
	 */
	public String getToModelName() {
		return toModelName;
	}

	/**
	 * 到模型名字设定
	 *
	 * @param toModelName 到模型名字
	 */
	public void setToModelName(String toModelName) {
		this.toModelName = toModelName;
	}

	/**
	 * 到模型ID取得
	 *
	 * @return 到模型ID
	 */
	public String getToModelEid() {
		return toModelEid;
	}

	/**
	 * 到模型ID设定
	 *
	 * @param toModelEid 到模型ID
	 */
	public void setToModelEid(String toModelEid) {
		this.toModelEid = toModelEid;
	}

	/**
	 * 关系描述取得
	 *
	 * @return 关系描述
	 */
	public String getRlnDesc() {
		return rlnDesc;
	}

	/**
	 * 关系描述设定
	 *
	 * @param rlnDesc 关系描述
	 */
	public void setRlnDesc(String rlnDesc) {
		this.rlnDesc = rlnDesc;
	}

	/**
	 * 预留字段1取得
	 *
	 * @return 预留字段1
	 */
	public String getRlnKey1() {
		return rlnKey1;
	}

	/**
	 * 预留字段1设定
	 *
	 * @param rlnKey1 预留字段1
	 */
	public void setRlnKey1(String rlnKey1) {
		this.rlnKey1 = rlnKey1;
	}

	/**
	 * 预留字段2取得
	 *
	 * @return 预留字段2
	 */
	public String getRlnKey2() {
		return rlnKey2;
	}

	/**
	 * 预留字段2设定
	 *
	 * @param rlnKey2 预留字段2
	 */
	public void setRlnKey2(String rlnKey2) {
		this.rlnKey2 = rlnKey2;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return rlnCode;
	}

	/**
	 * 关系类别取得
	 *
	 * @return rlnType 关系类别
	 */
	
	public String getRlnType() {
		return rlnType;
	}

	/**
	 * 关系类别设定
	 *
	 * @param rlnType 关系类别
	 */
	
	public void setRlnType(String rlnType) {
		this.rlnType = rlnType;
	}
	
	
}