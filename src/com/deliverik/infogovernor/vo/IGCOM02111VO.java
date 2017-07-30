/*
 * ���������������������޹�˾��Ȩ���У���������Ȩ����
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
 * ͳ�Ʒ�������������ʾVO
 * 
 */
@SuppressWarnings("serial")
public class IGCOM02111VO extends BaseVO implements Serializable {

	/** ����������Ϣ�� */
	protected Map<String, TreeNode> treeNodeMap = new LinkedHashMap<String, TreeNode>();
	
	/**
	 * ���캯��
	 * @param treeNodeMap������������Ϣ��
	 */
	public IGCOM02111VO(Map<String, TreeNode> treeNodeMap) {
		this.treeNodeMap = treeNodeMap;
	}

	/**
	 * ����������Ϣ��ȡ��
	 * @return ����������Ϣ��
	 */
	public Map<String, TreeNode> getTreeNodeMap() {
		return treeNodeMap;
	}

}