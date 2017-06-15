/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prd.vo;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prd.model.IG108Info;
import com.deliverik.framework.workflow.prd.model.IG110Info;
import com.deliverik.framework.workflow.prd.model.IG111Info;
/**
 * 概述: 自定义流程表单查询条件定义vo
 * 功能描述: 自定义流程表单查询条件定义vo
 * 创建记录: 2013/03/13
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGPRD01451VO extends BaseVO{

	/** 已选查询条件 */
	protected List<IG108Info> pqList;
	/** 可选查询条件 */
	protected List<IG007Info> pdList;
	/** 已设定流程查询显示列集合 */
    protected List<IG110Info> queryShowColumnList;
    
    /** 未设定流程查询显示列集合 */
    protected Map<String, String> queryShowColumnMap;
    
    /** 已设定查询条件集合 */
    protected List<IG111Info> queryList;
    
    /** 未设定查询条件集合 */
    protected Map<String, String> queryMap;

	/**
	 * 已设定流程查询显示列集合取得
	 * @return queryShowColumnList 已设定流程查询显示列集合
	 */
	public List<IG110Info> getQueryShowColumnList() {
		return queryShowColumnList;
	}

	/**
	 * 已设定流程查询显示列集合设定
	 * @param queryShowColumnList 已设定流程查询显示列集合
	 */
	public void setQueryShowColumnList(List<IG110Info> queryShowColumnList) {
		this.queryShowColumnList = queryShowColumnList;
	}

	/**
	 * 未设定流程查询显示列集合取得
	 * @return queryShowColumnMap 未设定流程查询显示列集合
	 */
	public Map<String, String> getQueryShowColumnMap() {
		return queryShowColumnMap;
	}

	/**
	 * 未设定流程查询显示列集合设定
	 * @param queryShowColumnMap 未设定流程查询显示列集合
	 */
	public void setQueryShowColumnMap(Map<String, String> queryShowColumnMap) {
		this.queryShowColumnMap = queryShowColumnMap;
	}

	/**
	 * 已设定查询条件集合取得
	 * @return queryList 已设定查询条件集合
	 */
	public List<IG111Info> getQueryList() {
		return queryList;
	}

	/**
	 * 已设定查询条件集合设定
	 * @param queryList 已设定查询条件集合
	 */
	public void setQueryList(List<IG111Info> queryList) {
		this.queryList = queryList;
	}

	/**
	 * 未设定查询条件集合取得
	 * @return queryMap 未设定查询条件集合
	 */
	public Map<String, String> getQueryMap() {
		return queryMap;
	}

	/**
	 * 未设定查询条件集合设定
	 * @param queryMap 未设定查询条件集合
	 */
	public void setQueryMap(Map<String, String> queryMap) {
		this.queryMap = queryMap;
	}
	
	/**
	 * 已选查询条件取得
	 * @return 已选查询条件
	 */
	public List<IG108Info> getPqList() {
		return pqList;
	}
	
	/**
	 * 可选查询条件取得
	 * @return 可选查询条件
	 */
	public List<IG007Info> getPdList() {
		return pdList;
	}
	
	/**
	 * 已选查询条件设定
	 * @param pqList 已选查询条件
	 */
	public void setPqList(List<IG108Info> pqList) {
		this.pqList = pqList;
	}
	
	/**
	 * 可选查询条件设定
	 * @param pdList 可选查询条件
	 */
	public void setPdList(List<IG007Info> pdList) {
		this.pdList = pdList;
	}
	
}
