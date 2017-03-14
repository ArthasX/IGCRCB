/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */

package com.deliverik.framework.tree;

import java.util.LinkedHashMap;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���ڵ����� 
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */
public class TreeNode {
	
	/**�ڵ��ʶ*/
	private String id;
	
	/**�ڵ�����*/
	private String name;
	
	/**�ڵ�����*/
	private String belong;
	
	/**�ڵ�״̬*/
	private String status;
	
	/**�ڵ㱸ע*/
	private String remark;
	
	/**�Ӽ��ڵ㼯��*/
	private LinkedHashMap<String,TreeNode> childTreeNodeMap=new LinkedHashMap<String,TreeNode>();
	
	public LinkedHashMap<String,TreeNode> getChildTreeNodeMap() {
		return childTreeNodeMap;
	}
	/**
	 * ����Ӽ�����
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
	 * ɾ��ָ������������Ϣ��
	 * @param childKey
	 */
	public void removeChildTreeNode(String childKey){
		if(childTreeNodeMap!=null&&!childTreeNodeMap.isEmpty()&&childTreeNodeMap.containsKey(childKey)){
			childTreeNodeMap.remove(childKey);
		}
	}
	/**
	 *  ɾ��ȫ����������Ϣ��
	 *
	 */
	public void removeAllChildTreeNode(){
		if(childTreeNodeMap!=null&&!childTreeNodeMap.isEmpty()){
			childTreeNodeMap.clear();
		}
	}
	
	/**
	 * �����������Ϣ
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
	 * ��ȡ�ڵ��ʶ
	 * @return �ڵ��ʶ
	 */
	public String getId() {
		return id;
	}
	/**
	 * ���ýڵ��ʶ
	 * @param id �ڵ��ʶ
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * ��ȡ�ڵ�����
	 * @return �ڵ�����
	 */
	public String getName() {
		return name;
	}
	/**
	 * ���ýڵ�����
	 * @param name �ڵ�����
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * ��ȡ�ڵ�����
	 * @return �ڵ�����
	 */
	public String getBelong() {
		return belong;
	}
	/**
	 * ���ýڵ�����
	 * @param belong �ڵ�����
	 */
	public void setBelong(String belong) {
		this.belong = belong;
	}
	/**
	 * ��ȡ�ڵ�״̬
	 * @return �ڵ�״̬
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * ���ýڵ�״̬
	 * @param status �ڵ�״̬
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * ��ȡ�ڵ㱸ע
	 * @return �ڵ㱸ע
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * ���ýڵ㱸ע
	 * @param remark �ڵ㱸ע
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
