/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
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
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 数据信息树VO
 * </p>
 * 
 * @author duchong@deliverik.com
 * @version 1.0
 */

public class IGSYM12011VO extends BaseVO implements Serializable {

	private static final long serialVersionUID = -4866952218593809598L;

	/**
	 * 数据信息对象List
	 */
	
	protected List<CodeDetail> codedetailList;
	
	/**数据信息树*/
	protected Map<String,TreeNode> treeNodeMap=new LinkedHashMap<String,TreeNode>();
	
	/**
	 * 每级结点的完整名称
	 */
	
	protected  Map<Integer,String> completenameMap;

	/**
	 * 构造方法
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
