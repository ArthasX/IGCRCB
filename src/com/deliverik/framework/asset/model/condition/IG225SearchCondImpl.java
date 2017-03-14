package com.deliverik.framework.asset.model.condition;

import java.util.List;

/**
 * 资产模型属性信息检索条件实现
 * 
 */
public class IG225SearchCondImpl implements IG225SearchCond {

	/** 资产模型ID */
	protected String eid;
	
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

	/** clabel字段过滤，不显示隔断属性 */
	protected String[] filterlabel; 
	
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
	
	/**
	 * clabel字段过滤信息取得
	 * @return clabel字段过滤信息标识
	 */
	public String[] getFilterlabel() {
		return filterlabel;
	}
	
	/**
	 * clabel字段过滤信息设定
	 *
	 * @param cseq clabel字段过滤信息设定
	 */
	public void setFilterlabel(String[] filterlabel) {
		this.filterlabel = filterlabel;
	}
}
