/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.fxk.vo;

import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.tree.TreeNode;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 模型树显示VO
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGFXK04011VO extends BaseVO{

	/**管理域树*/
	private Map<String,TreeNode> treeNodeMap = null;
	
	 /** 资产管理域树数据 */
    protected String treejson;

	/**
	 * 管理域树取得
	 * @return treeNodeMap 管理域树
	 */
	public Map<String, TreeNode> getTreeNodeMap() {
		return treeNodeMap;
	}

	/**
	 * 管理域树设定
	 * @param treeNodeMap 管理域树
	 */
	public void setTreeNodeMap(Map<String, TreeNode> treeNodeMap) {
		this.treeNodeMap = treeNodeMap;
	}
	
	/**
     * treejson取得
     *
     * @return treejson treejson
     */
    public String getTreejson() {
        return treejson;
    }
    /**
     * treejson设定
     *
     * @param treejson treejson
     */
    public void setTreejson(String treejson) {
        this.treejson = treejson;
    }
}
