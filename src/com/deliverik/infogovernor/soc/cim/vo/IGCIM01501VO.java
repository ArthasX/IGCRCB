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
 * ����: �������ˣ�Ӧ��ά����ʾVO
 * ��������: Ӧ��ά����ʾVO
 * ������¼: 2013/10/25
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGCIM01501VO extends BaseVO implements Serializable{
	
	/** ��ϵ�� */
	protected Map<String, TreeNode> treeNodeMap = new LinkedHashMap<String, TreeNode>();
	
	/**��ʼ����ϵ���ַ�*/
	protected String initTreeStr;
	
	/**��ʼ����ϵ��Ĭ��ֵID*/
	protected String initNodeID;
	/**
	 * ���캯��
	 * @param treeNodeMap����ϵ��
	 */
	public IGCIM01501VO(Map<String, TreeNode> treeNodeMap) {
		this.treeNodeMap = treeNodeMap;
	}

	/**
	 * ���췽��
	 */
	public IGCIM01501VO() {
		super();
	}

	/**
	 * ��ϵ��ȡ��
	 * @return ��ϵ��
	 */
	public Map<String, TreeNode> getTreeNodeMap() {
		return treeNodeMap;
	}

	/**
	 * ��ʼ����ϵ���ַ�ȡ��
	 *
	 * @return initTreeStr ��ʼ����ϵ���ַ�
	 */
	
	public String getInitTreeStr() {
		return initTreeStr;
	}

	/**
	 * ��ʼ����ϵ���ַ��趨
	 *
	 * @param initTreeStr ��ʼ����ϵ���ַ�
	 */
	
	public void setInitTreeStr(String initTreeStr) {
		this.initTreeStr = initTreeStr;
	}

	/**
	 * ��ʼ����ϵ��Ĭ��ֵIDȡ��
	 *
	 * @return initNodeID ��ʼ����ϵ��Ĭ��ֵID
	 */
	
	public String getInitNodeID() {
		return initNodeID;
	}

	/**
	 * ��ʼ����ϵ��Ĭ��ֵID�趨
	 *
	 * @param initNodeID ��ʼ����ϵ��Ĭ��ֵID
	 */
	
	public void setInitNodeID(String initNodeID) {
		this.initNodeID = initNodeID;
	}

	/**
	 * ��ϵ���趨
	 *
	 * @param treeNodeMap ��ϵ��
	 */
	public void setTreeNodeMap(Map<String, TreeNode> treeNodeMap) {
		this.treeNodeMap = treeNodeMap;
	}
	
	
}


