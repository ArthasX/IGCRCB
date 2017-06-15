/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sym.vo;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.tree.TreeNode;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��ɫ�������ʲ���ؿ��ƣ�VO
 * </p>
 * 
 * @author duchong@deliverik.com
 * @version 1.0
 */
public class IGSYM03041VO extends BaseVO implements Serializable {

	private static final long serialVersionUID = 6859410498141832862L;

	/**��������*/
	private Map<String,TreeNode> treeNodeMap=new LinkedHashMap<String,TreeNode>();
	
	/**��������Ĭ�Ͻ��id*/
	private String defnode_id;
	
	/**��������Ĭ�Ͻ��name*/
	private String defnode_name;
	
	/** �Ƿ�ֻ��ѡ�����ڵ�*/
	protected String selectedLast;
	
	/**
	 * ���췽��
	 * @param roleList List<Role>
	 */
	
	public IGSYM03041VO(Map<String,TreeNode> treeNodeMap) {
		this.treeNodeMap = treeNodeMap;
	}
	
	public Map<String, TreeNode> getTreeNodeMap() {
		return treeNodeMap;
	}

	public String getDefnode_id() {
		return defnode_id;
	}

	public void setDefnode_id(String defnode_id) {
		this.defnode_id = defnode_id;
	}

	public String getDefnode_name() {
		return defnode_name;
	}

	public void setDefnode_name(String defnode_name) {
		this.defnode_name = defnode_name;
	}

	/**
	 * �Ƿ�ֻ��ѡ�����ڵ�ȡ��
	 * @return selectedLast �Ƿ�ֻ��ѡ�����ڵ�
	 */
	public String getSelectedLast() {
		return selectedLast;
	}

	/**
	 * �Ƿ�ֻ��ѡ�����ڵ��趨
	 * @param selectedLast �Ƿ�ֻ��ѡ�����ڵ�
	 */
	public void setSelectedLast(String selectedLast) {
		this.selectedLast = selectedLast;
	}
	
}
