/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */
package com.deliverik.infogovernor.soc.mnt.vo;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.tree.TreeNode;

/**
 * ����:�����������ʾVO
 * ����������
 * ������¼�����    2012/02/09
 */
@SuppressWarnings("serial")
public class IGMNT01011VO extends BaseVO implements Serializable {
	
	/** ��ط�����Ϣ�� */
	protected Map<String, TreeNode> treeNodeMap = new LinkedHashMap<String, TreeNode>();
	
	/**
	 * ���캯��
	 * @param treeNodeMap
	 */
	public IGMNT01011VO(Map<String, TreeNode> treeNodeMap) {
		this.treeNodeMap = treeNodeMap;
	}
	
	/**
	 * ��ط�����Ϣ��ȡ��
	 * @return
	 */
	public Map<String, TreeNode> getTreeNodeMap() {
		return treeNodeMap;
	}

}
