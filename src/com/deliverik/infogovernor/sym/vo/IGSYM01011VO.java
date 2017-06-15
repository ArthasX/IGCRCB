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
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.framework.user.model.Organization;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 系统管理_机构管理_查询VO
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSYM01011VO extends BaseVO implements Serializable {

	/**
	 * 机构对象List
	 */
	
	protected List<Organization> organizationcondList;
	
	/**机构树*/
	protected Map<String,TreeNode> treeNodeMap=new LinkedHashMap<String,TreeNode>();
	
	/**
	 * 每级机构的完整名称
	 */
	
	protected  Map<Integer,String> completenameMap;

	/**
	 * 构造方法
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
	 * 获取机构对象List
	 * @return List<Organization>
	 */
	
	public List<Organization> getOrganizationcondList() {
		return organizationcondList;
	}
}
