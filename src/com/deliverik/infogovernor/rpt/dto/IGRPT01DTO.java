/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */


package com.deliverik.infogovernor.rpt.dto;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.rpt.form.IGRPT0102Form;
import com.deliverik.infogovernor.sym.model.ReportFileDefinition;
import com.deliverik.infogovernor.sym.model.condition.ReportFileDefinitionSearchCond;

/**
 * 统计分析业务DTO
 * 
 */
@SuppressWarnings("serial")
public class IGRPT01DTO extends BaseDTO implements Serializable{
	
	/** 报表分类树 */
	protected Map<String,TreeNode> treeNodeMap=new LinkedHashMap<String,TreeNode>();
	
	/** 报表信息检索条件 */
	protected ReportFileDefinitionSearchCond reportFileDefinitionSearchCond;
	
	/** 报表信息检索结果集 */
	protected List<ReportFileDefinition> reportFileDefinitionList;
	
	/** 节点完整名称 */
	protected String completeNodeName;
	
	protected IGRPT0102Form igRPT0102Form;
	
	/** 用户信息*/
	protected User user;
	
	List<ReportFileDefinition> selectedReportFileDefinitionList ;
	
	
	public IGRPT0102Form getIgRPT0102Form() {
		return igRPT0102Form;
	}

	public void setIgRPT0102Form(IGRPT0102Form igRPT0102Form) {
		this.igRPT0102Form = igRPT0102Form;
	}

	public List<ReportFileDefinition> getSelectedReportFileDefinitionList() {
		return selectedReportFileDefinitionList;
	}

	public void setSelectedReportFileDefinitionList(
			List<ReportFileDefinition> selectedReportFileDefinitionList) {
		this.selectedReportFileDefinitionList = selectedReportFileDefinitionList;
	}

	/**
	 * 报表分类树取得
	 * @return 报表分类树
	 */
	public Map<String, TreeNode> getTreeNodeMap() {
		return treeNodeMap;
	}

	/**
	 * 报表分类树设定
	 * @param treeNodeMap 报表分类树
	 */
	public void setTreeNodeMap(Map<String, TreeNode> treeNodeMap) {
		this.treeNodeMap = treeNodeMap;
	}
	
	/**
	 * 报表信息检索条件取得
	 * @return 报表信息检索条件
	 */
	public ReportFileDefinitionSearchCond getReportFileDefinitionSearchCond() {
		return reportFileDefinitionSearchCond;
	}

	/**
	 * 报表信息检索条件设定
	 * @param reportFileDefinitionSearchCond 报表信息检索条件
	 */
	public void setReportFileDefinitionSearchCond(
			ReportFileDefinitionSearchCond reportFileDefinitionSearchCond) {
		this.reportFileDefinitionSearchCond = reportFileDefinitionSearchCond;
	}
	
	/**
	 * 报表信息检索结果集取得
	 * @return 报表信息检索结果集
	 */
	public List<ReportFileDefinition> getReportFileDefinitionList() {
		return reportFileDefinitionList;
	}

	/**
	 * 报表信息检索结果集设定
	 * @param reportFileDefinitionList 报表信息检索结果集
	 */
	public void setReportFileDefinitionList(
			List<ReportFileDefinition> reportFileDefinitionList) {
		this.reportFileDefinitionList = reportFileDefinitionList;
	}

	/**
	 * 节点完成名称取得
	 * @return 节点完成名称
	 */
	public String getCompleteNodeName() {
		return completeNodeName;
	}

	/**
	 * 节点完成名称设定
	 * @param completeNodeName 节点完成名称
	 */
	public void setCompleteNodeName(String completeNodeName) {
		this.completeNodeName = completeNodeName;
	}

	/**
	 * 获取用户信息
	 * @param 
	 */
	public User getUser() {
		return user;
	}

	/**
	 * 设置用户信息
	 * 
	 */
	public void setUser(User user) {
		this.user = user;
	}
	
	
}


