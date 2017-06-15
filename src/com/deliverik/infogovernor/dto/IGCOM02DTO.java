/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */


package com.deliverik.infogovernor.dto;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.soc.asset.model.SOC0305Info;
import com.deliverik.framework.soc.asset.model.SOC0307Info;
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.kgm.model.Knowledge;
import com.deliverik.infogovernor.sym.model.ReportFileDefinition;
import com.deliverik.infogovernor.sym.model.condition.ReportFileDefinitionSearchCond;

/**
 * 统计分析业务DTO
 * 
 */
@SuppressWarnings("serial")
public class IGCOM02DTO extends BaseDTO implements Serializable{
	
//	/** 报表历史信息检索条件 */
//	protected ReportFileGHSearchCond reportFileGHSearchCond;
//	
//	/** 报表历史信息检索结果集 */
//	protected List<ReportFileGHVWInfo> reportFileGHList;
	
	/**存储序列号*/
	private String dataid;
	
	
	/** 知识信息 */
	protected List<Knowledge> knowledgeList;
	
	
	/** 报表分类树 */
	protected Map<String,TreeNode> treeNodeMap=new LinkedHashMap<String,TreeNode>();
	
	/** 报表信息检索条件 */
	protected ReportFileDefinitionSearchCond reportFileDefinitionSearchCond;
	
	/** 报表信息检索结果集 */
	protected List<ReportFileDefinition> reportFileDefinitionList;
	
	/** 节点完整名称 */
	protected String completeNodeName;
	
	/** 用户信息*/
	protected User user;
	
	/** 告警信息 */
	protected List<SOC0305Info> soc0305List;
	
	/** 告警视图信息 */
	protected List<SOC0307Info> soc0307List;

	/**
	 * 报表历史取得
	 *
	 * @return dataid 报表历史
	 */
	public String getDataid() {
		return dataid;
	}

	/**
	 * 报表历史设定
	 *
	 * @param dataid 报表历史
	 */
	public void setDataid(String dataid) {
		this.dataid = dataid;
	}

	/**
	 * 知识信息取得
	 *
	 * @return knowledgeList 知识信息
	 */
	public List<Knowledge> getKnowledgeList() {
		return knowledgeList;
	}

	/**
	 * 知识信息设定
	 *
	 * @param knowledgeList 知识信息
	 */
	public void setKnowledgeList(List<Knowledge> knowledgeList) {
		this.knowledgeList = knowledgeList;
	}

	/**
	 * 报表分类树取得
	 *
	 * @return treeNodeMap 报表分类树
	 */
	public Map<String, TreeNode> getTreeNodeMap() {
		return treeNodeMap;
	}

	/**
	 * 报表分类树设定
	 *
	 * @param treeNodeMap 报表分类树
	 */
	public void setTreeNodeMap(Map<String, TreeNode> treeNodeMap) {
		this.treeNodeMap = treeNodeMap;
	}

	/**
	 * 报表信息检索条件取得
	 *
	 * @return reportFileDefinitionSearchCond 报表信息检索条件
	 */
	public ReportFileDefinitionSearchCond getReportFileDefinitionSearchCond() {
		return reportFileDefinitionSearchCond;
	}

	/**
	 * 报表信息检索条件设定
	 *
	 * @param reportFileDefinitionSearchCond 报表信息检索条件
	 */
	public void setReportFileDefinitionSearchCond(
			ReportFileDefinitionSearchCond reportFileDefinitionSearchCond) {
		this.reportFileDefinitionSearchCond = reportFileDefinitionSearchCond;
	}

	/**
	 * 报表信息检索结果集取得
	 *
	 * @return reportFileDefinitionList 报表信息检索结果集
	 */
	public List<ReportFileDefinition> getReportFileDefinitionList() {
		return reportFileDefinitionList;
	}

	/**
	 * 报表信息检索结果集设定
	 *
	 * @param reportFileDefinitionList 报表信息检索结果集
	 */
	public void setReportFileDefinitionList(
			List<ReportFileDefinition> reportFileDefinitionList) {
		this.reportFileDefinitionList = reportFileDefinitionList;
	}

	/**
	 * 节点完整名称取得
	 *
	 * @return completeNodeName 节点完整名称
	 */
	public String getCompleteNodeName() {
		return completeNodeName;
	}

	/**
	 * 节点完整名称设定
	 *
	 * @param completeNodeName 节点完整名称
	 */
	public void setCompleteNodeName(String completeNodeName) {
		this.completeNodeName = completeNodeName;
	}

	/**
	 * 用户信息取得
	 *
	 * @return user 用户信息
	 */
	public User getUser() {
		return user;
	}

	/**
	 * 用户信息设定
	 *
	 * @param user 用户信息
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * 告警信息取得
	 *
	 * @return soc0305List 告警信息
	 */
	public List<SOC0305Info> getSoc0305List() {
		return soc0305List;
	}

	/**
	 * 告警信息设定
	 *
	 * @param soc0305List 告警信息
	 */
	public void setSoc0305List(List<SOC0305Info> soc0305List) {
		this.soc0305List = soc0305List;
	}

	/**
	 * 告警视图信息取得
	 *
	 * @return soc0307List 告警视图信息
	 */
	public List<SOC0307Info> getSoc0307List() {
		return soc0307List;
	}

	/**
	 * 告警视图信息设定
	 *
	 * @param soc0307List 告警视图信息
	 */
	public void setSoc0307List(List<SOC0307Info> soc0307List) {
		this.soc0307List = soc0307List;
	}

	
	
	
	
}


