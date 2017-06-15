package com.deliverik.framework.soc.asset.model.condition;

import java.util.List;

/**
 * 资产信息检索条件实现
 * 
 */
public class SOC0163SearchCondImpl implements SOC0163SearchCond {

	/** 资产模型编号 */
	protected String elabel;
	
	/** 资产模型名称（平台保留） */
	protected String ename;
	
	/** 资产编号 */
	protected String eilabel;
	
	/** 资产名称 */
	protected String einame;
	
	/** 资产模型分类 */
	protected String ecategory;
	
	/** 资产模型一级子类（平台保留） */
	protected String ekey1;
	
	/** 资产模型二级子类（平台保留） */
	protected String ekey2;
	
	/** 资产更新开始时间 */
	protected String eiupdtime_from;
	
	/** 资产更新截止时间 */
	protected String eiupdtime_to;
	
	/** 资产更新2开始时间 */
	protected String eiupdtime_from2;
	
	/** 资产更新2截止时间 */
	protected String eiupdtime_to2;
	
	/** 资产属性名检索条件数组（平台保留） */
	protected String[] cname;
	
	/** 资产属性值检索条件数组（平台保留） */
	protected String[] civalue;
	
	/** 资产共通属性编号检索条件数组（平台保留） */
	protected String[] cclabel;
	
	/** 资产共通属性值检索条件数组（平台保留） */
	protected String[] ccivalue;
	
	/** 资产所属机构层次码*/
	public String eiorgcode;
	
	/** 资产所属机构层次码（平台保留）*/
	public String eiorgsyscoding;
	
	/** 资产所属机构层次码（平台保留）*/
	public String eiorgsyscoding_q;

	/** 资产状态（平台保留） */
	protected String eistatus;

	/** 资产模型层次码 */
	protected String esyscoding;
	protected String esyscoding_like;
	
	/** 资产状态（平台保留）*/
	protected String eistatus_q;
	
	/** 资产ID集合（平台保留）*/
	protected List<String> eiidList;
	
	/** 资产使用机构code */
	protected String usesyscoding;
	
	/** 维保开始日期 */
	protected String wbdate_from;
	
	/** 维保结束日期 */
	protected String wbdate_to;
	/**资产父节点*/
	protected Integer eirootmark_eq;
	
	private String ip;
	
	/** 查询顶级实体标识*/
	protected boolean topCiFlag;
	
	/** 顶级实体名*/
	protected String topCI;
	
	public String getTopCI() {
		return topCI;
	}

	public void setTopCI(String topCI) {
		this.topCI = topCI;
	}
	
	public boolean isTopCiFlag() {
		return topCiFlag;
	}

	public void setTopCiFlag(boolean topCiFlag) {
		this.topCiFlag = topCiFlag;
	}
	
	/**
	 * 资产所属机构层次码取得
	 * @return 资产所属机构层次码
	 */
	public String getEiorgcode() {
		return eiorgcode;
	}

	/**
	 * 资产所属机构层次码设定
	 *
	 * @param eiorgcode 资产所属机构层次码
	 */
	public void setEiorgcode(String eiorgcode) {
		this.eiorgcode = eiorgcode;
	}
	
	
	/**
	 * 资产状态取得
	 * @return 资产状态
	 */
	public String getEistatus_q() {
		return eistatus_q;
	}

	/**
	 * 资产状态设定
	 *
	 * @param eistatus_q 资产状态
	 */
	public void setEistatus_q(String eistatus_q) {
		this.eistatus_q = eistatus_q;
	}

	/**
	 * 资产所属机构层次码取得
	 * @return 资产所属机构层次码
	 */
	public String getEiorgsyscoding_q() {
		return eiorgsyscoding_q;
	}

	/**
	 * 资产所属机构层次码设定
	 *
	 * @param eiorgsyscoding_q 资产所属机构层次码
	 */
	public void setEiorgsyscoding_q(String eiorgsyscoding_q) {
		this.eiorgsyscoding_q = eiorgsyscoding_q;
	}

	/**
	 * 资产模型层次码取得
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
	 * 资产状态取得
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
	 * 资产所属机构层次码取得
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
	 * 资产模型编号取得
	 * @return 资产模型编号
	 */
	public String getElabel() {
		return elabel;
	}

	/**
	 * 资产模型编号设定
	 *
	 * @param elabel 资产模型编号
	 */
	public void setElabel(String elabel) {
		this.elabel = elabel;
	}

	/**
	 * 资产模型名称取得
	 * @return 资产模型名称
	 */
	public String getEname() {
		return ename;
	}

	/**
	 * 资产模型名称设定
	 *
	 * @param ename 资产模型名称
	 */
	public void setEname(String ename) {
		this.ename = ename;
	}

	/**
	 * 资产编号取得
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
	 * 资产名称取得
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
	 * 资产模型分类取得
	 * @return 资产模型分类
	 */
	public String getEcategory() {
		return ecategory;
	}

	/**
	 * 资产模型分类设定
	 *
	 * @param ecategory 资产模型分类
	 */
	public void setEcategory(String ecategory) {
		this.ecategory = ecategory;
	}

	/**
	 * 资产模型一级子类取得
	 * @return 资产模型一级子类
	 */
	public String getEkey1() {
		return ekey1;
	}

	/**
	 * 资产模型一级子类设定
	 *
	 * @param ekey1 资产模型一级子类
	 */
	public void setEkey1(String ekey1) {
		this.ekey1 = ekey1;
	}

	/**
	 * 资产模型二级子类取得
	 * @return 资产模型二级子类
	 */
	public String getEkey2() {
		return ekey2;
	}

	/**
	 * 资产模型二级子类设定
	 *
	 * @param ekey2 资产模型二级子类
	 */
	public void setEkey2(String ekey2) {
		this.ekey2 = ekey2;
	}

	/**
	 * 资产更新开始时间取得
	 * @return 资产更新开始时间
	 */
	public String getEiupdtime_from() {
		return eiupdtime_from;
	}

	/**
	 * 资产更新开始时间设定
	 *
	 * @param eiupdtime_from 资产更新开始时间
	 */
	public void setEiupdtime_from(String eiupdtime_from) {
		this.eiupdtime_from = eiupdtime_from;
	}

	/**
	 * 资产更新截止时间取得
	 * @return 资产更新截止时间
	 */
	public String getEiupdtime_to() {
		return eiupdtime_to;
	}

	/**
	 * 资产更新截止时间设定
	 *
	 * @param eiupdtime_to 资产更新截止时间
	 */
	public void setEiupdtime_to(String eiupdtime_to) {
		this.eiupdtime_to = eiupdtime_to;
	}

	/**
	 * 资产属性名检索条件数组取得
	 * @return 资产属性名检索条件数组
	 */
	public String[] getCname() {
		return cname;
	}

	/**
	 * 资产属性名称检索条件数组设定
	 *
	 * @param cname 资产属性名称检索条件数组
	 */
	public void setCname(String[] cname) {
		this.cname = cname;
	}

	/**
	 * 资产属性值检索条件数组取得
	 * @return 资产属性值检索条件数组
	 */
	public String[] getCivalue() {
		return civalue;
	}

	/**
	 * 资产属性值检索条件数组设定
	 *
	 * @param civalue 资产属性值检索条件数组
	 */
	public void setCivalue(String[] civalue) {
		this.civalue = civalue;
	}

	/**
	 * 资产共通属性编号检索条件数组取得
	 * @return 资产共通属性编号检索条件数组
	 */
	public String[] getCclabel() {
		return cclabel;
	}

	/**
	 * 资产共通属性编号检索条件数组设定
	 *
	 * @param cclabel 资产共通属性编号检索条件数组
	 */
	public void setCclabel(String[] cclabel) {
		this.cclabel = cclabel;
	}

	/**
	 * 资产共通属性值检索条件数组取得
	 * @return 资产共通属性值检索条件数组
	 */
	public String[] getCcivalue() {
		return ccivalue;
	}

	/**
	 * 资产共通属性值检索条件数组设定
	 *
	 * @param ccivalue 资产共通属性值检索条件数组
	 */
	public void setCcivalue(String[] ccivalue) {
		this.ccivalue = ccivalue;
	}

	/**
	 * 资产ID集合取得
	 * @return 资产ID集合
	 */
	public List<String> getEiidList() {
		return eiidList;
	}

	/**
	 * 资产ID集合设定
	 *
	 * @param eiidList 资产ID集合
	 */
	public void setEiidList(List<String> eiidList) {
		this.eiidList = eiidList;
	}

	/**
	 * 资产使用机构code取得
	 * @return 资产使用机构code
	 */
	public String getUsesyscoding() {
		return usesyscoding;
	}

	/**
	 * 资产使用机构code设定
	 *
	 * @param usesyscoding 资产使用机构code
	 */
	public void setUsesyscoding(String usesyscoding) {
		this.usesyscoding = usesyscoding;
	}

	/**
	 * 维保开始日期取得
	 * @return 维保开始日期
	 */
	public String getWbdate_from() {
		return wbdate_from;
	}

	/**
	 * 维保开始日期设定
	 *
	 * @param wbdate_from 维保开始日期
	 */
	public void setWbdate_from(String wbdate_from) {
		this.wbdate_from = wbdate_from;
	}

	/**
	 * 维保结束日期取得
	 * @return 维保结束日期
	 */
	public String getWbdate_to() {
		return wbdate_to;
	}

	/**
	 * 维保结束日期设定
	 *
	 * @param wbdate_to 维保结束日期
	 */
	public void setWbdate_to(String wbdate_to) {
		this.wbdate_to = wbdate_to;
	}

	/**
	 * 资产父节点取得
	 *
	 * @return eirootmark_eq 资产父节点
	 */
	public Integer getEirootmark_eq() {
		return eirootmark_eq;
	}

	/**
	 * 资产父节点设定
	 *
	 * @param eirootmark_eq 资产父节点
	 */
	public void setEirootmark_eq(Integer eirootmark_eq) {
		this.eirootmark_eq = eirootmark_eq;
	}

	/**
	 * @return the 资产更新2开始时间
	 */
	public String getEiupdtime_from2() {
		return eiupdtime_from2;
	}

	/**
	 * @param 资产更新2开始时间 the eiupdtime_from2 to set
	 */
	public void setEiupdtime_from2(String eiupdtime_from2) {
		this.eiupdtime_from2 = eiupdtime_from2;
	}

	/**
	 * @return the 资产更新2截止时间
	 */
	public String getEiupdtime_to2() {
		return eiupdtime_to2;
	}

	/**
	 * @param 资产更新2截止时间 the eiupdtime_to2 to set
	 */
	public void setEiupdtime_to2(String eiupdtime_to2) {
		this.eiupdtime_to2 = eiupdtime_to2;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getEsyscoding_like() {
		return esyscoding_like;
	}

	public void setEsyscoding_like(String esyscoding_like) {
		this.esyscoding_like = esyscoding_like;
	}
	
}
