/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.fxk.dto;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.tree.TreeNode;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 风险评估DTO
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGFXK04DTO extends BaseDTO{

	/**管理域树*/
	protected Map<String,TreeNode> treeNodeMap = null;
	
	/** 资产模型编号 */
	protected String esyscoding;
	
	/** 资产信息集合 */
	protected List<SOC0124Info> entityItemVWInfoList;
	
	/** ajax返回结果 */
	protected String ajaxResult;

	/**
	 * 管理域树取得
	 * @return treeNodeMap 管理域树
	 */
	public Map<String, TreeNode> getTreeNodeMap() {
		return treeNodeMap;
	}

	/**
	 * 管理域树设定
	 * @param treeNodeMap 管理域树
	 */
	public void setTreeNodeMap(Map<String, TreeNode> treeNodeMap) {
		this.treeNodeMap = treeNodeMap;
	}

	/**
	 * 资产模型编号取得
	 * @return esyscoding 资产模型编号
	 */
	public String getEsyscoding() {
		return esyscoding;
	}

	/**
	 * 资产模型编号设定
	 * @param esyscoding 资产模型编号
	 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	/**
	 * 资产信息集合取得
	 * @return entityItemVWInfoList 资产信息集合
	 */
	public List<SOC0124Info> getEntityItemVWInfoList() {
		return entityItemVWInfoList;
	}

	/**
	 * 资产信息集合设定
	 * @param entityItemVWInfoList 资产信息集合
	 */
	public void setEntityItemVWInfoList(List<SOC0124Info> entityItemVWInfoList) {
		this.entityItemVWInfoList = entityItemVWInfoList;
	}

	/**
	 * ajax返回结果取得
	 * @return ajaxResult ajax返回结果
	 */
	public String getAjaxResult() {
		return ajaxResult;
	}

	/**
	 * ajax返回结果设定
	 * @param ajaxResult ajax返回结果
	 */
	public void setAjaxResult(String ajaxResult) {
		this.ajaxResult = ajaxResult;
	}
}
