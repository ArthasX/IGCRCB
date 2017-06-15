/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.prm.vo;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.IG259Info;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ѡ����������VO
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGPRM00001VO extends BaseVO implements Serializable {
	
	/**�������弯��*/
	private Map<IG259Info,List<IG380Info>> templateDefinitionMap;
	
	/**���̶�����*/
	private Map<String,TreeNode> treeNodeMap=new LinkedHashMap<String,TreeNode>();
	
	/**��׼����ģ��**/
	private IG259Info gpt;
	
	/**�Զ�������ģ��**/
	private IG259Info spt;
	/**
	 * ��ȡ�������弯��
	 * @return �������弯��
	 */
	public Map<IG259Info, List<IG380Info>> getTemplateDefinitionMap() {
		return templateDefinitionMap;
	}
	

	/**
	 * ���ù������弯��
	 * @param map �������弯��
	 */
	public void setTemplateDefinitionMap(Map<IG259Info, List<IG380Info>> templateDefinitionMap) {
		this.templateDefinitionMap = templateDefinitionMap;
	}

	/**
	 * ��ȡ���̶�����
	 * @return ���̶�����
	 */
	public Map<String, TreeNode> getTreeNodeMap() {
		return treeNodeMap;
	}

	/**
	 * �������̶�����
	 * @param treeNodeMap ���̶�����
	 */
	public void setTreeNodeMap(Map<String, TreeNode> treeNodeMap) {
		this.treeNodeMap = treeNodeMap;
	}


	public IG259Info getGpt() {
		return gpt;
	}


	public void setGpt(IG259Info gpt) {
		this.gpt = gpt;
	}


	public IG259Info getSpt() {
		return spt;
	}


	public void setSpt(IG259Info spt) {
		this.spt = spt;
	}

	
}
