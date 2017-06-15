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
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.tree.TreeNode;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ������Ϣ��VO
 * </p>
 * 
 * @author duchong@deliverik.com
 * @version 1.0
 */

public class IGSYM12011VO extends BaseVO implements Serializable {

	private static final long serialVersionUID = -4866952218593809598L;

	/**
	 * ������Ϣ����List
	 */
	
	protected List<CodeDetail> codedetailList;
	
	/**������Ϣ��*/
	protected Map<String,TreeNode> treeNodeMap=new LinkedHashMap<String,TreeNode>();
	
	/**
	 * ÿ��������������
	 */
	
	protected  Map<Integer,String> completenameMap;

	/**
	 * ���췽��
	 */
	
	public IGSYM12011VO(List<CodeDetail> codedetailList) {
		this.codedetailList = codedetailList;
	}
	public IGSYM12011VO() {
		
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
	
	
	
}
