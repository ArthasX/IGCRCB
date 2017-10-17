package com.dev.hac.vo;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.tree.TreeNode;

public class IGHAC01011VO extends BaseVO implements Serializable {
	private static final long serialVersionUID = -4866952218593809598L;

	protected String jsonstr;
	/**���νṹ����**/
	protected String treeSize;
	/**
	 * ���νṹ����ȡ��
	 * @return treeSize ���νṹ����
	 */
	public String getTreeSize() {
		return treeSize;
	}
	/**
	 * ���νṹ�����趨
	 * @param treeSize ���νṹ����
	 */
	public void setTreeSize(String treeSize) {
		this.treeSize = treeSize;
	}
	/**
	 * ������Ϣ����List
	 */
	
	protected List<CodeDetail> codedetailList;
	
	/**������Ϣ��*/
	protected Map<String,TreeNode> treeNodeMap=new LinkedHashMap<String,TreeNode>();
	
	/**������Ϣ��*/
	protected Map<String,TreeNode> treeNodeNewMap=new LinkedHashMap<String,TreeNode>();
	
	/**
	 * ÿ��������������
	 */
	
	protected  Map<Integer,String> completenameMap;
	
	/** �Ƿ�ֻ��ѡ�����ڵ�*/
	protected String selectedLast;

	/**
	 * ���췽��
	 */
	
	public IGHAC01011VO(List<CodeDetail> codedetailList) {
		this.codedetailList = codedetailList;
	}
	public IGHAC01011VO() {
		
	}
	
	
	
	public List<CodeDetail> getCodedetailList() {
		return codedetailList;
	}
	public void setCodedetailList(List<CodeDetail> codedetailList) {
		this.codedetailList = codedetailList;
	}
	public Map<String, TreeNode> getTreeNodeMap() {
		return treeNodeMap;
	}
	public void setTreeNodeMap(Map<String, TreeNode> treeNodeMap) {
		this.treeNodeMap = treeNodeMap;
	}
	public Map<Integer, String> getCompletenameMap() {
		return completenameMap;
	}
	public void setCompletenameMap(Map<Integer, String> completenameMap) {
		this.completenameMap = completenameMap;
	}
	public Map<String, TreeNode> getTreeNodeNewMap() {
		return treeNodeNewMap;
	}
	public void setTreeNodeNewMap(Map<String, TreeNode> treeNodeNewMap) {
		this.treeNodeNewMap = treeNodeNewMap;
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
	public String getJsonstr() {
		return jsonstr;
	}
	public void setJsonstr(String jsonstr) {
		this.jsonstr = jsonstr;
	}
	
	
	
}
