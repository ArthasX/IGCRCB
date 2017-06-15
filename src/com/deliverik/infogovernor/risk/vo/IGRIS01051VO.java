/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.risk.vo;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.infogovernor.risk.model.RiskAuditDef;

/**
 * �������Ϣ��������֣�
 * 
 * @author maozhipeng@deliverik.com
 *
 */
@SuppressWarnings("serial")
public class IGRIS01051VO extends BaseVO implements Serializable{
	
	/** ��ư汾��Ϣ������� */
	protected List<RiskAuditDef> riskAuditDefList;
	
	/** ��ư汾��ϸ��Ϣ */
	protected RiskAuditDef riskAuditDef;
	
	/**�������*/
	protected Map<String,TreeNode> treeNodeMap=new LinkedHashMap<String,TreeNode>();

	public IGRIS01051VO() {
		
	}
	/**
	 * ���캯��
	 * @param riskAuditDef���������Ϣ�������
	 */
	public IGRIS01051VO(List<RiskAuditDef> riskAuditDefList) {
		this.riskAuditDefList = riskAuditDefList;
	}
	
	
	/**
	 * �������Ϣ�������ȡ��
	 * @return �������Ϣ�������
	 */

	public List<RiskAuditDef> getRiskAuditDefList() {
		return riskAuditDefList;
	}
	
	/**
	 * �������ϸ��Ϣȡ��
	 * @return �������ϸ��Ϣ���
	 */
	public RiskAuditDef getRiskAuditDef() {
		return riskAuditDef;
	}
	/**
	 * �������ϸ��Ϣ�趨
	 * @param �������ϸ��Ϣ���
	 */
	public void setRiskAuditDef(RiskAuditDef riskAuditDef) {
		this.riskAuditDef = riskAuditDef;
	}
	/**
	 * ���������Ϣ�������ȡ��
	 * @return ���������Ϣ�������
	 */
	public Map<String, TreeNode> getTreeNodeMap() {
		return treeNodeMap;
	}

	/**
	 * �������Ϣ��������趨
	 * @param treeNodeMap
	 */
	public void setTreeNodeMap(Map<String, TreeNode> treeNodeMap) {
		this.treeNodeMap = treeNodeMap;
	}

}


