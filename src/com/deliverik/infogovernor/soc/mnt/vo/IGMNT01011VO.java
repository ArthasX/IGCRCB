/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */
package com.deliverik.infogovernor.soc.mnt.vo;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.tree.TreeNode;

/**
 * 概述:监控类型树显示VO
 * 功能描述：
 * 创建记录：张楠    2012/02/09
 */
@SuppressWarnings("serial")
public class IGMNT01011VO extends BaseVO implements Serializable {
	
	/** 监控分类信息树 */
	protected Map<String, TreeNode> treeNodeMap = new LinkedHashMap<String, TreeNode>();
	
	/**
	 * 构造函数
	 * @param treeNodeMap
	 */
	public IGMNT01011VO(Map<String, TreeNode> treeNodeMap) {
		this.treeNodeMap = treeNodeMap;
	}
	
	/**
	 * 监控分类信息树取得
	 * @return
	 */
	public Map<String, TreeNode> getTreeNodeMap() {
		return treeNodeMap;
	}

}
