/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.prm.vo;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.IG259Info;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 选择流程类型VO
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGPRM00001VO extends BaseVO implements Serializable {
	
	/**工作定义集合*/
	private Map<IG259Info,List<IG380Info>> templateDefinitionMap;
	
	/**流程定义树*/
	private Map<String,TreeNode> treeNodeMap=new LinkedHashMap<String,TreeNode>();
	
	/**标准流程模板**/
	private IG259Info gpt;
	
	/**自定义流程模板**/
	private IG259Info spt;
	/**
	 * 获取工作定义集合
	 * @return 工作定义集合
	 */
	public Map<IG259Info, List<IG380Info>> getTemplateDefinitionMap() {
		return templateDefinitionMap;
	}
	

	/**
	 * 设置工作定义集合
	 * @param map 工作定义集合
	 */
	public void setTemplateDefinitionMap(Map<IG259Info, List<IG380Info>> templateDefinitionMap) {
		this.templateDefinitionMap = templateDefinitionMap;
	}

	/**
	 * 获取流程定义树
	 * @return 流程定义树
	 */
	public Map<String, TreeNode> getTreeNodeMap() {
		return treeNodeMap;
	}

	/**
	 * 设置流程定义树
	 * @param treeNodeMap 流程定义树
	 */
	public void setTreeNodeMap(Map<String, TreeNode> treeNodeMap) {
		this.treeNodeMap = treeNodeMap;
	}


	public IG259Info getGpt() {
		return gpt;
	}


	public void setGpt(IG259Info gpt) {
		this.gpt = gpt;
	}


	public IG259Info getSpt() {
		return spt;
	}


	public void setSpt(IG259Info spt) {
		this.spt = spt;
	}

	
}
