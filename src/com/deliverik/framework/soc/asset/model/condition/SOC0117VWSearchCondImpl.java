/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model.condition;

import java.util.List;

/**
  * 概述: SOC0117VW检索条件实现
  * 功能描述: SOC0117VW检索条件实现
  * 创建记录: 2016/06/21
  * 修改记录: 
  */
public class SOC0117VWSearchCondImpl implements
		SOC0117VWSearchCond {
	/**
	 * 数据库id
	 */
	private Integer id;
	/** 
	 * 资产模型ID 
	 */
	protected String eidStr;

	/** 
	 * 资产模型ID like
	 */
	protected String eidStr_like;

	/** 
	 * 资产模型编号 
	 */
	protected String elabel;
	
	/** 
	 * 资产模型名称
	 */
	protected String ename;
	
	/** 
	 * 资产模型分类 
	 */
	protected String ecategory_q;
	
	/** 
	 * 资产模型分类（平台保留） 
	 */
	protected String ecategory;

	/** 
	 * 资产模型一级子类（平台保留） 
	 */
	protected String ekey1;
	
	/** 
	 * 资产模型二级子类（平台保留）
	 */
	protected String ekey2;
	
	/** 
	 * 资产模型三级子类（平台保留）
	 */
	protected String ekey3;
	
	/** 
	 * 资产模型层次码前方一致模糊匹配检索条件 
	 */
	protected String syscoding_q;
	
	/** 
	 * 资产模型层次码 
	 */
	protected String esyscoding;
	
	/** 
	 * 资产模型父级层次码（平台保留）
	 */
	protected String eparcoding;
	
	/** 
	 * 资产模型层次码前方一致模糊匹配检索条件（like）
	 */
	protected String esyscoding_q;
	
	/** 
	 * 资产模型层次码前方一致模糊匹配检索条件（not like）
	 */
	protected String esyscoding_nq;
	
	/** 
	 * 资产模型父级层次码检索条件 
	 */
	protected String eparcoding_q;
	
	/** 
	 * 资产模型的状态 
	 */
	protected String estatus;
	
	/** 
	 * 资产模型层次码区间检索条件<br>
	 * （去掉资产模型层次码与该集合内的元素模糊匹配的资产模型信息） 
	 */
	protected List<String> delList_q;
	
	/** 
	 * 资产模型父级层次码检索条件（平台保留）
	 */
	protected String eparcoding_status;
	
	/** 
	 * 资产模型层次码检索条件（平台保留） 
	 */
	protected String eparcoding_status_start;
	
	/** 
	 * 资产模型层次码辅助检索条件（平台保留）<br>
	 *     （当该属性不为空，eparcoding属性为空时完全匹配资产模型层次码。
	 *        当该属性为空，eparcoding属性不为空时完全匹配资产模型的上级模型层次码。）
	 */
	protected String esyscoding_tree;//资产模型syscoding,igsym1201action使用
	
	/** 
	 * 资产模型层次码区间检索条件（平台保留）<br>
	 *    （检索资产模型层次码与该集合内的元素完全匹配的资产模型信息） 
	 */
	protected List<String> esyscodingList;
	
	/** 
	 * 资产模型层次码区间检索条件（平台保留）<br>
	 *    （检索资产模型层次码与该集合内的元素完全匹配的资产模型信息） 
	 */
	protected List<String> selectList;//entity树显示时需要检索的1级结点（供取值范围使用）
	
	/** 
	 * 资产模型层次码区间检索条件（平台保留）<br>
	 * （检索资产模型层次码与该集合内的元素不完全匹配的资产模型信息） 
	 */
	protected List<String> delList;//entity树显示时需要去掉的1级结点（供取值范围使用）
	
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 资产模型层次码区间检索条件取得
	 * @return 去掉资产模型层次码与该集合内的元素模糊匹配的资产模型信息
	 */
	public List<String> getDelList_q() {
		return delList_q;
	}

	/**
	 * 资产模型层次码区间检索条件设定
	 *
	 * @param delList_q 去掉资产模型层次码与该集合内的元素模糊匹配的资产模型信息
	 */
	public void setDelList_q(List<String> delList_q) {
		this.delList_q = delList_q;
	}

	/**
	 * 资产模型层次码前方一致模糊匹配检索条件（not like）取得
	 * @return 资产模型层次码前方一致模糊匹配检索条件（not like）
	 */
	public String getEsyscoding_nq() {
		return esyscoding_nq;
	}

	/**
	 * 资产模型层次码前方一致模糊匹配检索条件（not like）设定
	 *
	 * @param esyscoding_nq 资产模型层次码前方一致模糊匹配检索条件（not like）
	 */
	public void setEsyscoding_nq(String esyscoding_nq) {
		this.esyscoding_nq = esyscoding_nq;
	}

	
	/**
	 * 资产模型分类取得
	 * @return 资产模型分类
	 */
	public String getEcategory_q() {
		return ecategory_q;
	}

	/**
	 * 资产模型分类设定
	 *
	 * @param ecategory_q 资产模型分类
	 */
	public void setEcategory_q(String ecategory_q) {
		this.ecategory_q = ecategory_q;
	}

	/**
	 * 资产模型层次码区间检索条件取得
	 * @return 资产模型层次码区间检索条件
	 */
	public List<String> getDelList() {
		return delList;
	}

	/**
	 * 资产模型层次码区间检索条件设定
	 * 
	 * @param delList 资产模型层次码区间检索条件
	 * （检索资产模型层次码与该集合内的元素不完全匹配的资产模型信息） 
	 */
	public void setDelList(List<String> delList) {
		this.delList = delList;
	}

	/**
	 * 资产模型层次码区间检索条件取得
	 * @return 资产模型层次码区间检索条件
	 */
	public List<String> getSelectList() {
		return selectList;
	}

	/**
	 * 资产模型层次码区间检索条件设定
	 *
	 * @param selectList 资产模型层次码区间检索条件
	 * （检索资产模型层次码与该集合内的元素完全匹配的资产模型信息） 
	 */
	public void setSelectList(List<String> selectList) {
		this.selectList = selectList;
	}
	
	/**
	 * 资产模型层次码辅助检索条件取得
	 * @return 资产模型层次码辅助检索条件
	 */
	public String getEsyscoding_tree() {
		return esyscoding_tree;
	}

	/**
	 * 资产模型层次码辅助检索条件设定
	 *
	 * @param esyscoding_tree 资产模型层次码辅助检索条件
	 * （当该属性不为空，eparcoding属性为空时完全匹配资产模型层次码。
	 *   当该属性为空，eparcoding属性不为空时完全匹配资产模型的上级模型层次码）
	 */
	public void setEsyscoding_tree(String esyscoding_tree) {
		this.esyscoding_tree = esyscoding_tree;
	}

	/**
	 * 资产模型层次码检索条件取得
	 * @return 资产模型层次码检索条件
	 */
	public String getEparcoding_status_start() {
		return eparcoding_status_start;
	}

	/**
	 * 资产模型层次码检索条件设定
	 *
	 * @param eparcoding_status_start 资产模型层次码检索条件
	 */
	public void setEparcoding_status_start(String eparcoding_status_start) {
		this.eparcoding_status_start = eparcoding_status_start;
	}

	/**
	 * 资产模型父级层次码检索条件取得
	 * @return 资产模型父级层次码检索条件
	 */
	public String getEparcoding_status() {
		return eparcoding_status;
	}

	/**
	 * 资产模型父级层次码检索条件设定
	 *
	 * @param eparcoding_status 资产模型父级层次码检索条件
	 */
	public void setEparcoding_status(String eparcoding_status) {
		this.eparcoding_status = eparcoding_status;
	}

	/**
	 * 资产模型的状态取得
	 * @return 资产模型的状态
	 */
	public String getEstatus() {
		return estatus;
	}

	/**
	 * 资产模型的状态设定
	 *
	 * @param estatus 资产模型的状态
	 */
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	/**
	 * 资产模型父级层次码检索条件取得
	 * @return 资产模型父级层次码检索条件
	 */
	public String getEparcoding_q() {
		return eparcoding_q;
	}

	/**
	 * 资产模型父级层次码检索条件设定
	 *
	 * @param eparcoding_q 资产模型父级层次码检索条件
	 */
	public void setEparcoding_q(String eparcoding_q) {
		this.eparcoding_q = eparcoding_q;
	}

	/**
	 * 资产模型父级层次码前方一致模糊匹配检索条件取得
	 * @return 资产模型父级层次码前方一致模糊匹配检索条件
	 */
	public String getEsyscoding_q() {
		return esyscoding_q;
	}

	/**
	 * 资产模型父级层次码前方一致模糊匹配检索条件设定
	 *
	 * @param esyscoding_q 资产模型父级层次码前方一致模糊匹配检索条件
	 */
	public void setEsyscoding_q(String esyscoding_q) {
		this.esyscoding_q = esyscoding_q;
	}

	/**
	 * 资产模型层次码前方一致模糊匹配检索条件取得
	 * @return 资产模型层次码前方一致模糊匹配检索条件
	 */
	public String getSyscoding_q() {
		return syscoding_q;
	}

	/**
	 * 资产模型层次码前方一致模糊匹配检索条件设定
	 *
	 * @param syscoding_q 资产模型层次码前方一致模糊匹配检索条件
	 */
	public void setSyscoding_q(String syscoding_q) {
		this.syscoding_q = syscoding_q;
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
	 * @param eparcoding 资产模型层次码
	 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}
	
	/**
	 * 资产模型父级层次码取得
	 * @return 资产模型父级层次码
	 */
	public String getEparcoding() {
		return eparcoding;
	}
	/**
	 * 资产模型父级层次码设定
	 *
	 * @param eparcoding 资产模型父级层次码
	 */
	public void setEparcoding(String eparcoding) {
		this.eparcoding = eparcoding;
	}

	/**
	 * 资产模型ID取得
	 * @return 资产模型ID
	 */
	public String getEidStr() {
		return eidStr;
	}

	/**
	 * 资产模型ID设定
	 *
	 * @param eidStr 资产模型ID
	 */
	public void setEidStr(String eidStr) {
		this.eidStr = eidStr;
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
	 * 资产模型三级子类取得
	 * @return 资产模型三级子类
	 */
	public String getEkey3() {
		return ekey3;
	}

	/**
	 * 资产模型三级子类设定
	 *
	 * @param ekey3 资产模型三级子类
	 */
	public void setEkey3(String ekey3) {
		this.ekey3 = ekey3;
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
	 * @param esyscodingList 资产模型层次码区间
	 * （检索资产模型层次码与该集合内的元素完全匹配的资产模型信息）
	 */
	public void setEsyscodingList(List<String> esyscodingList) {
		this.esyscodingList = esyscodingList;
	}

	/**
	 * 资产模型ID like取得
	 * @return 资产模型ID like
	 */
	public String getEidStr_like() {
		return eidStr_like;
	}

	/**
	 * 资产模型ID like设定
	 * @param eidStr_like 资产模型ID like
	 */
	public void setEidStr_like(String eidStr_like) {
		this.eidStr_like = eidStr_like;
	}
}