/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.tree.TreeNode;

/**
 * ����: ���ð�����ϵ��ʾVO
 * ��������: ���ð�����ϵ��ʾVO
 * ������¼: 2011/04/29
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGASM03461VO extends BaseVO implements Serializable{
	
	/** ���ð�����ϵ�� */
	protected Map<String, TreeNode> treeNodeMap = new LinkedHashMap<String, TreeNode>();
	
	/**
	 * ���캯��
	 * @param treeNodeMap�����ð�����ϵ��
	 */
	public IGASM03461VO(Map<String, TreeNode> treeNodeMap) {
		this.treeNodeMap = treeNodeMap;
	}

	/**
	 * ���ð�����ϵ��ȡ��
	 * @return ���ð�����ϵ��
	 */
	public Map<String, TreeNode> getTreeNodeMap() {
		return treeNodeMap;
	}
}


