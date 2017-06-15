/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.cim.vo;

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
public class IGCIM01461VO extends BaseVO implements Serializable{
	
	/** 配置包含关系树 */
	protected Map<String, TreeNode> treeNodeMap = new LinkedHashMap<String, TreeNode>();
	
	/**初始化包含树字符*/
	protected String initTreeStr;
	
	/**初始化包含树默认值ID*/
	protected String initNodeID;
	/**
	 * 构造函数
	 * @param treeNodeMap　配置包含关系树
	 */
	public IGCIM01461VO(Map<String, TreeNode> treeNodeMap) {
		this.treeNodeMap = treeNodeMap;
	}

	/**
	 * 构造方法
	 */
	public IGCIM01461VO() {
		super();
	}

	/**
	 * 配置包含关系树取得
	 * @return 配置包含关系树
	 */
	public Map<String, TreeNode> getTreeNodeMap() {
		return treeNodeMap;
	}

	/**
	 * 初始化包含树字符取得
	 *
	 * @return initTreeStr 初始化包含树字符
	 */
	
	public String getInitTreeStr() {
		return initTreeStr;
	}

	/**
	 * 初始化包含树字符设定
	 *
	 * @param initTreeStr 初始化包含树字符
	 */
	
	public void setInitTreeStr(String initTreeStr) {
		this.initTreeStr = initTreeStr;
	}

	/**
	 * 初始化包含树默认值ID取得
	 *
	 * @return initNodeID 初始化包含树默认值ID
	 */
	
	public String getInitNodeID() {
		return initNodeID;
	}

	/**
	 * 初始化包含树默认值ID设定
	 *
	 * @param initNodeID 初始化包含树默认值ID
	 */
	
	public void setInitNodeID(String initNodeID) {
		this.initNodeID = initNodeID;
	}

	/**
	 * 配置包含关系树设定
	 *
	 * @param treeNodeMap 配置包含关系树
	 */
	
	public void setTreeNodeMap(Map<String, TreeNode> treeNodeMap) {
		this.treeNodeMap = treeNodeMap;
	}
	
	
}


