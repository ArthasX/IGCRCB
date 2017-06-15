/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.vo;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.tree.TreeNode;

/**
 * 
 * 统计分析报表分类显示VO
 * 
 */
@SuppressWarnings("serial")
public class IGCOM02111VO extends BaseVO implements Serializable {

	/** 报表分类信息树 */
	protected Map<String, TreeNode> treeNodeMap = new LinkedHashMap<String, TreeNode>();
	
	/**
	 * 构造函数
	 * @param treeNodeMap　报表分类信息树
	 */
	public IGCOM02111VO(Map<String, TreeNode> treeNodeMap) {
		this.treeNodeMap = treeNodeMap;
	}

	/**
	 * 报表分类信息树取得
	 * @return 报表分类信息树
	 */
	public Map<String, TreeNode> getTreeNodeMap() {
		return treeNodeMap;
	}

}
