/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.model.condition;

/**
  * 概述: ErRelation检索条件实现
  * 功能描述: ErRelation检索条件实现
  * 创建记录: 2016/06/14
  * 修改记录: 
  */
public class ErRelationSearchCondImpl implements
		ErRelationSearchCond {
	

	protected Integer errid;
	
	/** 应急资源主键 */
	protected Integer erid;

	/** 资源编码 */
	protected String ercode;

	/** 父级编码 */
	protected String erparcode;

	/** 资产id */
	protected String eiid;

	/** 资产名称 */
	protected String einame;

	/** 录入人姓名 */
	protected String errstatus;

	/** 删除标志 */
	protected String deleteflag;
	
	/**
	 * 资源类型(1:应急,0:演练)
	 */
	protected String resourceType;

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}
	/**
	 * 资源类型(1:应急,0:演练)
	 */
	public String getResourceType() {
		return resourceType;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getErrid() {
		return errid;
	}

	/**
	 * 主键设定
	 *
	 * @param errid 主键
	 */
	public void setErrid(Integer errid) {
		this.errid = errid;
	}

	/**
	 * 应急资源主键取得
	 *
	 * @return 应急资源主键
	 */
	public Integer getErid() {
		return erid;
	}

	/**
	 * 应急资源主键设定
	 *
	 * @param erid 应急资源主键
	 */
	public void setErid(Integer erid) {
		this.erid = erid;
	}

	/**
	 * 资源编码取得
	 *
	 * @return 资源编码
	 */
	public String getErcode() {
		return ercode;
	}

	/**
	 * 资源编码设定
	 *
	 * @param ercode 资源编码
	 */
	public void setErcode(String ercode) {
		this.ercode = ercode;
	}

	/**
	 * 父级编码取得
	 *
	 * @return 父级编码
	 */
	public String getErparcode() {
		return erparcode;
	}

	/**
	 * 父级编码设定
	 *
	 * @param erparcode 父级编码
	 */
	public void setErparcode(String erparcode) {
		this.erparcode = erparcode;
	}

	/**
	 * 资产id取得
	 *
	 * @return 资产id
	 */
	public String getEiid() {
		return eiid;
	}

	/**
	 * 资产id设定
	 *
	 * @param eiid 资产id
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
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
	 * 录入人姓名取得
	 *
	 * @return 录入人姓名
	 */
	public String getErrstatus() {
		return errstatus;
	}

	/**
	 * 录入人姓名设定
	 *
	 * @param errstatus 录入人姓名
	 */
	public void setErrstatus(String errstatus) {
		this.errstatus = errstatus;
	}

	/**
	 * 删除标志取得
	 *
	 * @return 删除标志
	 */
	public String getDeleteflag() {
		return deleteflag;
	}

	/**
	 * 删除标志设定
	 *
	 * @param deleteflag 删除标志
	 */
	public void setDeleteflag(String deleteflag) {
		this.deleteflag = deleteflag;
	}
}