/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.tree.TreeNode;

/**
 * 概述: 配置包含关系显示VO
 * 功能描述: 配置包含关系显示VO
 * 创建记录: 2011/04/29
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGASM03461VO extends BaseVO implements Serializable{
	
	/** 配置包含关系树 */
	protected Map<String, TreeNode> treeNodeMap = new LinkedHashMap<String, TreeNode>();
	
	/**
	 * 构造函数
	 * @param treeNodeMap　配置包含关系树
	 */
	public IGASM03461VO(Map<String, TreeNode> treeNodeMap) {
		this.treeNodeMap = treeNodeMap;
	}

	/**
	 * 配置包含关系树取得
	 * @return 配置包含关系树
	 */
	public Map<String, TreeNode> getTreeNodeMap() {
		return treeNodeMap;
	}
}


