/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.fxk.vo;

import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.tree.TreeNode;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ģ������ʾVO
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGFXK04011VO extends BaseVO{

	/**��������*/
	private Map<String,TreeNode> treeNodeMap = null;
	
	 /** �ʲ������������� */
    protected String treejson;

	/**
	 * ��������ȡ��
	 * @return treeNodeMap ��������
	 */
	public Map<String, TreeNode> getTreeNodeMap() {
		return treeNodeMap;
	}

	/**
	 * ���������趨
	 * @param treeNodeMap ��������
	 */
	public void setTreeNodeMap(Map<String, TreeNode> treeNodeMap) {
		this.treeNodeMap = treeNodeMap;
	}
	
	/**
     * treejsonȡ��
     *
     * @return treejson treejson
     */
    public String getTreejson() {
        return treejson;
    }
    /**
     * treejson�趨
     *
     * @param treejson treejson
     */
    public void setTreejson(String treejson) {
        this.treejson = treejson;
    }
}
