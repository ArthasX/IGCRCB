/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.cim.vo;

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
public class IGCIM01461VO extends BaseVO implements Serializable{
	
	/** ���ð�����ϵ�� */
	protected Map<String, TreeNode> treeNodeMap = new LinkedHashMap<String, TreeNode>();
	
	/**��ʼ���������ַ�*/
	protected String initTreeStr;
	
	/**��ʼ��������Ĭ��ֵID*/
	protected String initNodeID;
	/**
	 * ���캯��
	 * @param treeNodeMap�����ð�����ϵ��
	 */
	public IGCIM01461VO(Map<String, TreeNode> treeNodeMap) {
		this.treeNodeMap = treeNodeMap;
	}

	/**
	 * ���췽��
	 */
	public IGCIM01461VO() {
		super();
	}

	/**
	 * ���ð�����ϵ��ȡ��
	 * @return ���ð�����ϵ��
	 */
	public Map<String, TreeNode> getTreeNodeMap() {
		return treeNodeMap;
	}

	/**
	 * ��ʼ���������ַ�ȡ��
	 *
	 * @return initTreeStr ��ʼ���������ַ�
	 */
	
	public String getInitTreeStr() {
		return initTreeStr;
	}

	/**
	 * ��ʼ���������ַ��趨
	 *
	 * @param initTreeStr ��ʼ���������ַ�
	 */
	
	public void setInitTreeStr(String initTreeStr) {
		this.initTreeStr = initTreeStr;
	}

	/**
	 * ��ʼ��������Ĭ��ֵIDȡ��
	 *
	 * @return initNodeID ��ʼ��������Ĭ��ֵID
	 */
	
	public String getInitNodeID() {
		return initNodeID;
	}

	/**
	 * ��ʼ��������Ĭ��ֵID�趨
	 *
	 * @param initNodeID ��ʼ��������Ĭ��ֵID
	 */
	
	public void setInitNodeID(String initNodeID) {
		this.initNodeID = initNodeID;
	}

	/**
	 * ���ð�����ϵ���趨
	 *
	 * @param treeNodeMap ���ð�����ϵ��
	 */
	
	public void setTreeNodeMap(Map<String, TreeNode> treeNodeMap) {
		this.treeNodeMap = treeNodeMap;
	}
	
	
}


