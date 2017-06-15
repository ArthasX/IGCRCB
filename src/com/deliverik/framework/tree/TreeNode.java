/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */

package com.deliverik.framework.tree;

import java.util.LinkedHashMap;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 树节点属性 
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */
public class TreeNode {
	
	/**节点标识*/
	private String id;
	
	/**节点名称*/
	private String name;
	
	/**节点所属*/
	private String belong;
	
	/**节点状态*/
	private String status;
	
	/**节点备注*/
	private String remark;
	
	/**子级节点集合*/
	private LinkedHashMap<String,TreeNode> childTreeNodeMap=new LinkedHashMap<String,TreeNode>();
	
	public LinkedHashMap<String,TreeNode> getChildTreeNodeMap() {
		return childTreeNodeMap;
	}
	/**
	 * 添加子级属性
	 * @param childKey
	 * @param childTreeNode
	 */
	public void addChildTreeNode(String childKey,TreeNode childTreeNode){
		if(childTreeNodeMap==null){
			childTreeNodeMap=new LinkedHashMap<String,TreeNode>();
		}
		childTreeNodeMap.put(childKey,childTreeNode);
	}
	
	/**
	 * 删除指定的子属性信息。
	 * @param childKey
	 */
	public void removeChildTreeNode(String childKey){
		if(childTreeNodeMap!=null&&!childTreeNodeMap.isEmpty()&&childTreeNodeMap.containsKey(childKey)){
			childTreeNodeMap.remove(childKey);
		}
	}
	/**
	 *  删除全部子属性信息。
	 *
	 */
	public void removeAllChildTreeNode(){
		if(childTreeNodeMap!=null&&!childTreeNodeMap.isEmpty()){
			childTreeNodeMap.clear();
		}
	}
	
	/**
	 * 获得子属性信息
	 * @param childKey
	 * @return TreeNode
	 */
	public TreeNode getChildTreeNode(String childKey){
		TreeNode treeNode=null;
		if(childTreeNodeMap!=null&&!childTreeNodeMap.isEmpty()&&childTreeNodeMap.containsKey(childKey)){
			Object obj=childTreeNodeMap.get(childKey);
			if(obj!=null&&obj instanceof TreeNode){
				treeNode=(TreeNode)treeNode;
			}
		}
		return treeNode;
	}
	/**
	 * 获取节点标识
	 * @return 节点标识
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置节点标识
	 * @param id 节点标识
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取节点名称
	 * @return 节点名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置节点名称
	 * @param name 节点名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取节点所属
	 * @return 节点所属
	 */
	public String getBelong() {
		return belong;
	}
	/**
	 * 设置节点所属
	 * @param belong 节点所属
	 */
	public void setBelong(String belong) {
		this.belong = belong;
	}
	/**
	 * 获取节点状态
	 * @return 节点状态
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 设置节点状态
	 * @param status 节点状态
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取节点备注
	 * @return 节点备注
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 设置节点备注
	 * @param remark 节点备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
