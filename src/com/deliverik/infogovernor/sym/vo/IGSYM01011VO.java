/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sym.vo;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.framework.user.model.Organization;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ϵͳ����_��������_��ѯVO
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSYM01011VO extends BaseVO implements Serializable {

	/**
	 * ��������List
	 */
	
	protected List<Organization> organizationcondList;
	
	/**������*/
	protected Map<String,TreeNode> treeNodeMap=new LinkedHashMap<String,TreeNode>();
	
	/**
	 * ÿ����������������
	 */
	
	protected  Map<Integer,String> completenameMap;

	/**
	 * ���췽��
	 * @param organizationcondList List<Organization>
	 */
	
	public IGSYM01011VO(List<Organization> organizationcondList) {
		this.organizationcondList = organizationcondList;
	}
	public IGSYM01011VO() {
		
	}
	
	
	
	public Map<Integer, String> getCompletenameMap() {
		return completenameMap;
	}
	public void setCompletenameMap(Map<Integer, String> completenameMap) {
		this.completenameMap = completenameMap;
	}
	public Map<String, TreeNode> getTreeNodeMap() {
		return treeNodeMap;
	}



	public void setTreeNodeMap(Map<String, TreeNode> treeNodeMap) {
		this.treeNodeMap = treeNodeMap;
	}



	/**
	 * ��ȡ��������List
	 * @return List<Organization>
	 */
	
	public List<Organization> getOrganizationcondList() {
		return organizationcondList;
	}
}
