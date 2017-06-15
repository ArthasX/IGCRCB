/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model.condition;

import java.util.List;

/**
  * 概述: SOC0109VW检索条件实现
  * 功能描述: SOC0109VW检索条件实现
  * 创建记录: 2016/06/21
  * 修改记录: 
  */
public class SOC0109VWSearchCondImpl implements
		SOC0109VWSearchCond {
	
	protected Integer id;
	/** 资产模型ID */
	protected String eid;
	
	/** 资产属性ID */
	protected String cid;
	
	/** 资产码 */
	protected String esyscoding_like;

	/** 资产属性ID like */
	protected String cid_like;
	
	/** 资产模型属性编号（平台保留） */
	protected String clabel;
	
	/** 资产模型属性名称 */
	protected String cname;
	
	/** 资产模型属性类型 */
	protected String ccategory;
	
	/** 资产模型属性状态（1启用，2停用） */
	protected String cstatus;
	
	/** 资产模型属性是否显示标识（平台保留。1显示，0显示） */
	protected Integer cseq;
	
	/** 资产模型层次码区间检索条件（平台保留） */
	protected List<String> esyscodingList;
	
	/** 资产模型配置项区间检索条件（平台保留） */
	protected List<String> cattachList;

	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 资产模型配置项区间检索条件取得
	 * @return 资产模型配置项区间检索条件
	 */
	public List<String> getCattachList() {
		return cattachList;
	}

	/**
	 * 资产模型配置项区间检索条件设定
	 *
	 * @param cattachList 资产模型配置项区间检索条件
	 */
	public void setCattachList(List<String> cattachList) {
		this.cattachList = cattachList;
	}

	/**
	 * 资产模型层次码区间检索条件取得
	 * @return 资产模型层次码区间检索条件
	 */
	public List<String> getEsyscodingList() {
		return esyscodingList;
	}

	/**
	 * 资产模型层次码区间检索条件设定
	 *
	 * @param esyscodingList 资产模型层次码区间检索条件
	 */
	public void setEsyscodingList(List<String> esyscodingList) {
		this.esyscodingList = esyscodingList;
	}

	/**
	 * 资产模型属性编号取得
	 * @return 资产模型属性编号
	 */
	public String getClabel() {
		return clabel;
	}

	/**
	 * 资产模型属性编号设定
	 *
	 * @param clabel 资产模型属性编号
	 */
	public void setClabel(String clabel) {
		this.clabel = clabel;
	}

	/**
	 * 资产模型属性名称取得
	 * @return 资产模型属性名称
	 */
	public String getCname() {
		return cname;
	}

	/**
	 * 资产模型属性名称设定
	 *
	 * @param cname 资产模型属性名称
	 */
	public void setCname(String cname) {
		this.cname = cname;
	}

	/**
	 * 资产模型属性类型取得
	 * @return 资产模型属性类型
	 */
	public String getCcategory() {
		return ccategory;
	}

	/**
	 * 资产模型属性类型设定
	 *
	 * @param ccategory 资产模型属性类型
	 */
	public void setCcategory(String ccategory) {
		this.ccategory = ccategory;
	}

	/**
	 * 资产模型ID取得
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
	 * 资产模型属性状态取得
	 * @return 资产模型属性状态
	 */
	public String getCstatus() {
		return cstatus;
	}

	/**
	 * 资产模型属性状态设定
	 *
	 * @param cstatus 资产模型属性状态
	 */
	public void setCstatus(String cstatus) {
		this.cstatus = cstatus;
	}

	/**
	 * 资产模型属性是否显示标识取得
	 * @return 资产模型属性是否显示标识
	 */
	public Integer getCseq() {
		return cseq;
	}

	/**
	 * 资产模型属性是否显示标识设定
	 *
	 * @param cseq 资产模型属性是否显示标识
	 */
	public void setCseq(Integer cseq) {
		this.cseq = cseq;
	}
	
	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getCid_like() {
		return cid_like;
	}

	public void setCid_like(String cid_like) {
		this.cid_like = cid_like;
	}

	public String getEsyscoding_like() {
		return esyscoding_like;
	}

	public void setEsyscoding_like(String esyscoding_like) {
		this.esyscoding_like = esyscoding_like;
	}
}