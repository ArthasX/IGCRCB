/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.model.condition;

/**
  * 概述: EmergencyResource检索条件实现
  * 功能描述: EmergencyResource检索条件实现
  * 创建记录: 2016/06/14
  * 修改记录: 
  */
public class EmergencyResourceSearchCondImpl implements
		EmergencyResourceSearchCond {

	protected Integer erid;
	/** 资源名称 */
	protected String ername;

	/** 资源描述 */
	protected String erdesc;

	/** 资源状态 */
	protected String erstatus;

	/** 资源编号 */
	protected String erlabel;

	/** 资源编码 */
	protected String ercode;

	/** 父级编码 */
	protected String erparcode;
	
	/** 父级编码like */
	protected String erparcode_like;

	/** 录入时间 */
	protected String ercreatetime;

	/** 录入人id */
	protected String eruserid;

	/** 录入人姓名 */
	protected String erusername;
	
	/** 排序by */
	protected String orderby;
	
	/** 排序字段 */
	protected String order;
	
	/** 对应资产码  */
	protected String esyscoding;
	/**
	 * @return the esyscoding
	 */
	public String getEsyscoding() {
		return esyscoding;
	}

	/**
	 * @param 对应资产码  the esyscoding to set
	 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}
	/**
	 * @return the erparcode_like
	 */
	public String getErparcode_like() {
		return erparcode_like;
	}

	/**
	 * @param erparcode_like the erparcode_like to set
	 */
	public void setErparcode_like(String erparcode_like) {
		this.erparcode_like = erparcode_like;
	}

	/**
	 * @return the orderby
	 */
	public String getOrderby() {
		return orderby;
	}

	/**
	 * @param orderby the orderby to set
	 */
	public void setOrderby(String orderby) {
		this.orderby = orderby;
	}

	/**
	 * @return the order
	 */
	public String getOrder() {
		return order;
	}

	/**
	 * @param order the order to set
	 */
	public void setOrder(String order) {
		this.order = order;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getErid() {
		return erid;
	}

	/**
	 * 主键设定
	 *
	 * @param erid 主键
	 */
	public void setErid(Integer erid) {
		this.erid = erid;
	}

	/**
	 * 资源名称取得
	 *
	 * @return 资源名称
	 */
	public String getErname() {
		return ername;
	}

	/**
	 * 资源名称设定
	 *
	 * @param ername 资源名称
	 */
	public void setErname(String ername) {
		this.ername = ername;
	}

	/**
	 * 资源描述取得
	 *
	 * @return 资源描述
	 */
	public String getErdesc() {
		return erdesc;
	}

	/**
	 * 资源描述设定
	 *
	 * @param erdesc 资源描述
	 */
	public void setErdesc(String erdesc) {
		this.erdesc = erdesc;
	}

	/**
	 * 资源状态取得
	 *
	 * @return 资源状态
	 */
	public String getErstatus() {
		return erstatus;
	}

	/**
	 * 资源状态设定
	 *
	 * @param erstatus 资源状态
	 */
	public void setErstatus(String erstatus) {
		this.erstatus = erstatus;
	}

	/**
	 * 资源编号取得
	 *
	 * @return 资源编号
	 */
	public String getErlabel() {
		return erlabel;
	}

	/**
	 * 资源编号设定
	 *
	 * @param erlabel 资源编号
	 */
	public void setErlabel(String erlabel) {
		this.erlabel = erlabel;
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
	 * 录入时间取得
	 *
	 * @return 录入时间
	 */
	public String getErcreatetime() {
		return ercreatetime;
	}

	/**
	 * 录入时间设定
	 *
	 * @param ercreatetime 录入时间
	 */
	public void setErcreatetime(String ercreatetime) {
		this.ercreatetime = ercreatetime;
	}

	/**
	 * 录入人id取得
	 *
	 * @return 录入人id
	 */
	public String getEruserid() {
		return eruserid;
	}

	/**
	 * 录入人id设定
	 *
	 * @param eruserid 录入人id
	 */
	public void setEruserid(String eruserid) {
		this.eruserid = eruserid;
	}

	/**
	 * 录入人姓名取得
	 *
	 * @return 录入人姓名
	 */
	public String getErusername() {
		return erusername;
	}

	/**
	 * 录入人姓名设定
	 *
	 * @param erusername 录入人姓名
	 */
	public void setErusername(String erusername) {
		this.erusername = erusername;
	}

}