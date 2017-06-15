/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
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
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 角色管理域（资产相关控制）VO
 * </p>
 * 
 * @author duchong@deliverik.com
 * @version 1.0
 */
public class IGSYM03041VO extends BaseVO implements Serializable {

	private static final long serialVersionUID = 6859410498141832862L;

	/**管理域树*/
	private Map<String,TreeNode> treeNodeMap=new LinkedHashMap<String,TreeNode>();
	
	/**管理域树默认结点id*/
	private String defnode_id;
	
	/**管理域树默认结点name*/
	private String defnode_name;
	
	/** 是否只能选择最后节点*/
	protected String selectedLast;
	
	/**
	 * 构造方法
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
	 * 是否只能选择最后节点取得
	 * @return selectedLast 是否只能选择最后节点
	 */
	public String getSelectedLast() {
		return selectedLast;
	}

	/**
	 * 是否只能选择最后节点设定
	 * @param selectedLast 是否只能选择最后节点
	 */
	public void setSelectedLast(String selectedLast) {
		this.selectedLast = selectedLast;
	}
	
}
