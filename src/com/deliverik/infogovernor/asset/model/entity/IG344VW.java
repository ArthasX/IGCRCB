/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Id;

import com.deliverik.infogovernor.asset.model.IG344Info;

/**
  * 概述: IG344VW实体
  * 功能描述: IG344VW实体
  * 创建记录: 2012/07/13
  * 修改记录: 
  */
@SuppressWarnings("serial")
@javax.persistence.Entity
public class IG344VW implements Serializable, Cloneable, IG344Info {

	/** 服务商名称 */
	protected String einame;
	@Id
	/** 服务记录编号 */
	protected String eilabel;

	/** 服务记录登记时间 */
	protected String eiinsdate;

	/** 服务类型 */
	protected String civalue;

	/** 服务性质 */
	protected String civalue1;

	/** 服务评价 */
	protected String civalue2;

	/** 服务评分 */
	protected Double civalue3;

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
	 * 服务记录编号取得
	 *
	 * @return 服务记录编号
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * 服务记录编号设定
	 *
	 * @param eilabel 服务记录编号
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	/**
	 * 服务记录登记时间取得
	 *
	 * @return 服务记录登记时间
	 */
	public String getEiinsdate() {
		return eiinsdate;
	}

	/**
	 * 服务记录登记时间设定
	 *
	 * @param eiupdtime 服务记录登记时间
	 */
	public void setEiinsdate(String eiinsdate) {
		this.eiinsdate = eiinsdate;
	}

	/**
	 * 服务类型取得
	 *
	 * @return 服务类型
	 */
	public String getCivalue() {
		return civalue;
	}

	/**
	 * 服务类型设定
	 *
	 * @param civalue 服务类型
	 */
	public void setCivalue(String civalue) {
		this.civalue = civalue;
	}

	/**
	 * 服务性质取得
	 *
	 * @return 服务性质
	 */
	public String getCivalue1() {
		return civalue1;
	}

	/**
	 * 服务性质设定
	 *
	 * @param civalue1 服务性质
	 */
	public void setCivalue1(String civalue1) {
		this.civalue1 = civalue1;
	}

	/**
	 * 服务评价取得
	 *
	 * @return 服务评价
	 */
	public String getCivalue2() {
		return civalue2;
	}

	/**
	 * 服务评价设定
	 *
	 * @param civalue2 服务评价
	 */
	public void setCivalue2(String civalue2) {
		this.civalue2 = civalue2;
	}

	/**
	 * 服务评分取得
	 *
	 * @return 服务评分
	 */
	public Double getCivalue3() {
		return civalue3;
	}

	/**
	 * 服务评分设定
	 *
	 * @param civalue3 服务评分
	 */
	public void setCivalue3(Double civalue3) {
		this.civalue3 = civalue3;
	}

}