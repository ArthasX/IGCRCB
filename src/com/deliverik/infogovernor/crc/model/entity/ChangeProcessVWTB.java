/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.crc.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.crc.model.ChangeProcessVWInfo;

/**
  * 概述: 变更流程实体
  * 功能描述: 变更流程实体
  * 创建记录: 2015/01/04
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="ChangeProcessVW")
public class ChangeProcessVWTB extends BaseEntity implements Serializable,
		Cloneable, ChangeProcessVWInfo {

	/** 主键 */
	@Id
	@TableGenerator(
		name="CHANGEPROCESSVW_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="CHANGEPROCESSVW_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="CHANGEPROCESSVW_TABLE_GENERATOR")
	protected Integer prid;

	/** 工单号*/
	protected String prserialnum;
	
	/** 工单说明*/
	protected String prdesc;
	
	/** 流程状态 */
	protected String prstatus;

	/** 流程名称 */
	protected String prtitle;

	/** 流程开始时间 */
	protected String propentime;

	/** 流程关闭时间 */
	protected String prclosetime;
	
	/** 流程发起人*/
	protected String prusername;

	/** 变更分类 */
	protected String changeclassify;

	/** 更新平台 */
	protected String updateplatform;

	/** 变更类型 */
	protected String changetype;

	/** 变更原因 */
	protected String changereason;

	/** 变更类别 */
	protected String changecategory;

	/** 业务影响范围 */
	protected String businessscope;

	/** 是否影响业务 */
	protected String isinfluence;

	/** 变更内容 */
	protected String changecontent;

	/** 流程状态名称 */
	protected String orderstatus;

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * 主键设定
	 *
	 * @param prid 主键
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}
	

	/**
	 * 工单号取得
	 * @return the prserialnum
	 */
	public String getPrserialnum() {
		return prserialnum;
	}

	/**
	 * 工单号设定
	 * @param prserialnum the 工单号
	 */
	public void setPrserialnum(String prserialnum) {
		this.prserialnum = prserialnum;
	}

	/**
	 * 流程状态取得
	 *
	 * @return 流程状态
	 */
	public String getPrstatus() {
		return prstatus;
	}

	/**
	 * 流程状态设定
	 *
	 * @param prstatus 流程状态
	 */
	public void setPrstatus(String prstatus) {
		this.prstatus = prstatus;
	}

	/**
	 * 流程名称取得
	 *
	 * @return 流程名称
	 */
	public String getPrtitle() {
		return prtitle;
	}

	/**
	 * 流程名称设定
	 *
	 * @param prtitle 流程名称
	 */
	public void setPrtitle(String prtitle) {
		this.prtitle = prtitle;
	}

	/**
	 * 流程开始时间取得
	 *
	 * @return 流程开始时间
	 */
	public String getPropentime() {
		return propentime;
	}

	/**
	 * 流程开始时间设定
	 *
	 * @param propentime 流程开始时间
	 */
	public void setPropentime(String propentime) {
		this.propentime = propentime;
	}

	/**
	 * 流程关闭时间取得
	 *
	 * @return 流程关闭时间
	 */
	public String getPrclosetime() {
		return prclosetime;
	}

	/**
	 * 流程关闭时间设定
	 *
	 * @param prclosetime 流程关闭时间
	 */
	public void setPrclosetime(String prclosetime) {
		this.prclosetime = prclosetime;
	}

	/**
	 * 流程发起人取得
	 * @return the prusername
	 */
	public String getPrusername() {
		return prusername;
	}

	/**
	 * 流程发起人设定
	 * @param prusername the 流程发起人
	 */
	public void setPrusername(String prusername) {
		this.prusername = prusername;
	}

	/**
	 * 变更分类取得
	 *
	 * @return 变更分类
	 */
	public String getChangeclassify() {
		return changeclassify;
	}

	/**
	 * 变更分类设定
	 *
	 * @param changeclassify 变更分类
	 */
	public void setChangeclassify(String changeclassify) {
		this.changeclassify = changeclassify;
	}

	/**
	 * 更新平台取得
	 *
	 * @return 更新平台
	 */
	public String getUpdateplatform() {
		return updateplatform;
	}

	/**
	 * 更新平台设定
	 *
	 * @param updateplatform 更新平台
	 */
	public void setUpdateplatform(String updateplatform) {
		this.updateplatform = updateplatform;
	}

	/**
	 * 变更类型取得
	 *
	 * @return 变更类型
	 */
	public String getChangetype() {
		return changetype;
	}

	/**
	 * 变更类型设定
	 *
	 * @param changetype 变更类型
	 */
	public void setChangetype(String changetype) {
		this.changetype = changetype;
	}

	/**
	 * 变更原因取得
	 *
	 * @return 变更原因
	 */
	public String getChangereason() {
		return changereason;
	}

	/**
	 * 变更原因设定
	 *
	 * @param changereason 变更原因
	 */
	public void setChangereason(String changereason) {
		this.changereason = changereason;
	}

	/**
	 * 变更类别取得
	 *
	 * @return 变更类别
	 */
	public String getChangecategory() {
		return changecategory;
	}

	/**
	 * 变更类别设定
	 *
	 * @param changecategory 变更类别
	 */
	public void setChangecategory(String changecategory) {
		this.changecategory = changecategory;
	}

	/**
	 * 业务影响范围取得
	 *
	 * @return 业务影响范围
	 */
	public String getBusinessscope() {
		return businessscope;
	}

	/**
	 * 业务影响范围设定
	 *
	 * @param businessscope 业务影响范围
	 */
	public void setBusinessscope(String businessscope) {
		this.businessscope = businessscope;
	}

	/**
	 * 是否影响业务取得
	 *
	 * @return 是否影响业务
	 */
	public String getIsinfluence() {
		return isinfluence;
	}

	/**
	 * 是否影响业务设定
	 *
	 * @param isinfluence 是否影响业务
	 */
	public void setIsinfluence(String isinfluence) {
		this.isinfluence = isinfluence;
	}

	/**
	 * 变更内容取得
	 *
	 * @return 变更内容
	 */
	public String getChangecontent() {
		return changecontent;
	}

	/**
	 * 变更内容设定
	 *
	 * @param changecontent 变更内容
	 */
	public void setChangecontent(String changecontent) {
		this.changecontent = changecontent;
	}

	/**
	 * 流程状态名称取得
	 *
	 * @return 流程状态名称
	 */
	public String getOrderstatus() {
		return orderstatus;
	}

	/**
	 * 流程状态名称设定
	 *
	 * @param orderstatus 流程状态名称
	 */
	public void setOrderstatus(String orderstatus) {
		this.orderstatus = orderstatus;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return prid;
	}

	/**
	 * 工单说明取得
	 * @return the prdesc
	 */
	public String getPrdesc() {
		return prdesc;
	}

	/**
	 * 工单说明设定
	 * @param prdesc the 工单说明
	 */
	public void setPrdesc(String prdesc) {
		this.prdesc = prdesc;
	}
}