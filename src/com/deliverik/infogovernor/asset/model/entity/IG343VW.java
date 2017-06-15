/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Id;

import com.deliverik.infogovernor.asset.model.IG343Info;

/**
  * 概述: IG343VW实体
  * 功能描述: IG343VW实体
  * 创建记录: 2012/07/12
  * 修改记录: 
  */
@SuppressWarnings("serial")
@javax.persistence.Entity
public class IG343VW implements Serializable, Cloneable, IG343Info {

	@Id
	protected Integer eiid;

	/** 服务商名称 */
	protected String einame;

	/** 设备资产 */
	protected Integer civalue;

	/** 设备资产评分 */
	protected Double civalue1;

	/** 应用资产 */
	protected Integer civalue2;

	/** 应用资产评分 */
	protected Double civalue3;

	/** 培训记录 */
	protected Integer einame3;

	/** 培训记录评分 */
	protected Double civalue4;
	
	/** 合计次数 */
	protected Integer sumcount;
	
	/** 合计平均分 */
	protected Double sumstore;

	/**
	 * 服务商id取得
	 *
	 * @return 服务商id
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * 服务商id设定
	 *
	 * @param eiid 服务商id
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	/**
	 * 服务商名称取得
	 *
	 * @return 服务商名称
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * 服务商名称设定
	 *
	 * @param einame 服务商名称
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**
	 * 设备资产取得
	 *
	 * @return 设备资产
	 */
	public Integer getCivalue() {
		return civalue;
	}

	/**
	 * 设备资产设定
	 *
	 * @param civalue 设备资产
	 */
	public void setCivalue(Integer civalue) {
		this.civalue = civalue;
	}

	/**
	 * 设备资产评分取得
	 *
	 * @return 设备资产评分
	 */
	public Double getCivalue1() {
		return civalue1;
	}

	/**
	 * 设备资产评分设定
	 *
	 * @param civalue1 设备资产评分
	 */
	public void setCivalue1(Double civalue1) {
		this.civalue1 = civalue1;
	}

	/**
	 * 应用资产取得
	 *
	 * @return 应用资产
	 */
	public Integer getCivalue2() {
		return civalue2;
	}

	/**
	 * 应用资产设定
	 *
	 * @param civalue2 应用资产
	 */
	public void setCivalue2(Integer civalue2) {
		this.civalue2 = civalue2;
	}

	/**
	 * 应用资产评分取得
	 *
	 * @return 应用资产评分
	 */
	public Double getCivalue3() {
		return civalue3;
	}

	/**
	 * 应用资产评分设定
	 *
	 * @param civalue3 应用资产评分
	 */
	public void setCivalue3(Double civalue3) {
		this.civalue3 = civalue3;
	}

	/**
	 * 培训记录取得
	 *
	 * @return 培训记录
	 */
	public Integer getEiname3() {
		return einame3;
	}

	/**
	 * 培训记录设定
	 *
	 * @param einame3 培训记录
	 */
	public void setEiname3(Integer einame3) {
		this.einame3 = einame3;
	}

	/**
	 * 培训记录评分取得
	 *
	 * @return 培训记录评分
	 */
	public Double getCivalue4() {
		return civalue4;
	}

	/**
	 * 培训记录评分设定
	 *
	 * @param civalue4 培训记录评分
	 */
	public void setCivalue4(Double civalue4) {
		this.civalue4 = civalue4;
	}

	/**
	 * 获取合计次数
	 * @return sumcount
	 */
	public Integer getSumcount() {
		return sumcount;
	}

	/**
	 * 设置合计次数
	 * @param sumcount
	 */
	public void setSumcount(Integer sumcount) {
		this.sumcount = sumcount;
	}

	/**
	 * 获取合计平均分
	 * @return sumstore
	 */
	public Double getSumstore() {
		return sumstore;
	}

	/**
	 * 设置合计平均分
	 * @param sumstore
	 */
	public void setSumstore(Double sumstore) {
		this.sumstore = sumstore;
	}


}