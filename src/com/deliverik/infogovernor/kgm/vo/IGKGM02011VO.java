package com.deliverik.infogovernor.kgm.vo;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.framework.user.model.Role;
import com.deliverik.infogovernor.kgm.model.Knowledge;
import com.deliverik.infogovernor.kgm.model.KnowledgeAppImpact;
import com.deliverik.infogovernor.kgm.model.KnowledgeProcess;

/**
 * 概述:知识库登记VO
 * 功能描述：知识库登记VO
 * 创建记录：cdd 2010/12/07
 * 修改记录：
 */
@SuppressWarnings("serial")
public class IGKGM02011VO  extends BaseVO implements Serializable{

	/**
	 * 知识库登记结果List取得
	 * @return 知识库登记结果List
	 */
	protected List<Knowledge> knowledgeList;
	
	/**
	 * 知识库登记关键词结果List取得
	 * @return 知识库登记关键词结果List
	 */
	protected List<String> defaultKeyList;
	
	/**
	 * 知识库登记取得
	 * @return 知识库登记关键词结果
	 */
	protected Knowledge knowledge;
	
	/** 知识流程关联信息集合 */
	protected List<KnowledgeProcess> knowledgeProcessList;
	
	/**知识关键字*/
	protected Map<String,TreeNode> treeNodeMap=new LinkedHashMap<String,TreeNode>();
	
	/**知识审批人角色*/
	protected List<Role> roleList;
	
	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	public IGKGM02011VO() {
	
	}

	/**
	 * 知识库登记关键字获取
	 * @return 知识库登记关键字list
	 */
	public List<String> getDefaultKeyList() {
		return defaultKeyList;
	}

	/**
	 * 知识库登记关键字设置list
	 * @param 知识库登记关键字list
	 */
	public void setDefaultKeyList(List<String> defaultKeyList) {
		this.defaultKeyList = defaultKeyList;
	}

	/**
	 * 知识库登记结果获取list
	 * @return 知识库登记结果list
	 */
	public List<Knowledge> getKnowledgeList() {
		return knowledgeList;
	}

	/**
	 * 知识库登记结果设置list
	 * @param 知识库登记结果list
	 */
	public void setKnowledgeList(List<Knowledge> knowledgeList) {
		this.knowledgeList = knowledgeList;
	}

	/**
	 * 知识库查询结果获取
	 * @return 知识库查询结果
	 */
	public Knowledge getKnowledge() {
		return knowledge;
	}

	/**
	 * 知识库登记结果设置
	 * @param 知识库查询结果
	 */
	public void setKnowledge(Knowledge knowledge) {
		this.knowledge = knowledge;
	}

	/**
	 * 知识流程关联信息集合取得
	 * @return 知识流程关联信息集合
	 */
	public List<KnowledgeProcess> getKnowledgeProcessList() {
		return knowledgeProcessList;
	}
	
	/**
	 * 知识流程关联信息集合设定
	 * @param knowledgeProcess知识流程关联信息集合
	 */
	public void setKnowledgeProcessList(List<KnowledgeProcess> knowledgeProcessList) {
		this.knowledgeProcessList = knowledgeProcessList;
	}

	public Map<String, TreeNode> getTreeNodeMap() {
		return treeNodeMap;
	}

	public void setTreeNodeMap(Map<String, TreeNode> treeNodeMap) {
		this.treeNodeMap = treeNodeMap;
	}
	
	/**流程影响应用系统List*/
	protected List<KnowledgeAppImpact> knowledgeAppImpactList;
	
	
	
	public List<KnowledgeAppImpact> getKnowledgeAppImpactList() {
		return knowledgeAppImpactList;
	}

	public void setKnowledgeAppImpactList(
			List<KnowledgeAppImpact> knowledgeAppImpactList) {
		this.knowledgeAppImpactList = knowledgeAppImpactList;
	}

	/** 流程关联系统Map */
	protected Map<LabelValueBean,String> knowledgeAppImpactMap;

	public Map<LabelValueBean, String> getKnowledgeAppImpactMap() {
		return knowledgeAppImpactMap;
	}

	public void setKnowledgeAppImpactMap(
			Map<LabelValueBean, String> knowledgeAppImpactMap) {
		this.knowledgeAppImpactMap = knowledgeAppImpactMap;
	}
	
	
}
