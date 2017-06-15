/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */


package com.deliverik.infogovernor.dto;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.soc.asset.model.SOC0305Info;
import com.deliverik.framework.soc.asset.model.SOC0307Info;
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.kgm.model.Knowledge;
import com.deliverik.infogovernor.sym.model.ReportFileDefinition;
import com.deliverik.infogovernor.sym.model.condition.ReportFileDefinitionSearchCond;

/**
 * ͳ�Ʒ���ҵ��DTO
 * 
 */
@SuppressWarnings("serial")
public class IGCOM02DTO extends BaseDTO implements Serializable{
	
//	/** ������ʷ��Ϣ�������� */
//	protected ReportFileGHSearchCond reportFileGHSearchCond;
//	
//	/** ������ʷ��Ϣ��������� */
//	protected List<ReportFileGHVWInfo> reportFileGHList;
	
	/**�洢���к�*/
	private String dataid;
	
	
	/** ֪ʶ��Ϣ */
	protected List<Knowledge> knowledgeList;
	
	
	/** ��������� */
	protected Map<String,TreeNode> treeNodeMap=new LinkedHashMap<String,TreeNode>();
	
	/** ������Ϣ�������� */
	protected ReportFileDefinitionSearchCond reportFileDefinitionSearchCond;
	
	/** ������Ϣ��������� */
	protected List<ReportFileDefinition> reportFileDefinitionList;
	
	/** �ڵ��������� */
	protected String completeNodeName;
	
	/** �û���Ϣ*/
	protected User user;
	
	/** �澯��Ϣ */
	protected List<SOC0305Info> soc0305List;
	
	/** �澯��ͼ��Ϣ */
	protected List<SOC0307Info> soc0307List;

	/**
	 * ������ʷȡ��
	 *
	 * @return dataid ������ʷ
	 */
	public String getDataid() {
		return dataid;
	}

	/**
	 * ������ʷ�趨
	 *
	 * @param dataid ������ʷ
	 */
	public void setDataid(String dataid) {
		this.dataid = dataid;
	}

	/**
	 * ֪ʶ��Ϣȡ��
	 *
	 * @return knowledgeList ֪ʶ��Ϣ
	 */
	public List<Knowledge> getKnowledgeList() {
		return knowledgeList;
	}

	/**
	 * ֪ʶ��Ϣ�趨
	 *
	 * @param knowledgeList ֪ʶ��Ϣ
	 */
	public void setKnowledgeList(List<Knowledge> knowledgeList) {
		this.knowledgeList = knowledgeList;
	}

	/**
	 * ���������ȡ��
	 *
	 * @return treeNodeMap ���������
	 */
	public Map<String, TreeNode> getTreeNodeMap() {
		return treeNodeMap;
	}

	/**
	 * ����������趨
	 *
	 * @param treeNodeMap ���������
	 */
	public void setTreeNodeMap(Map<String, TreeNode> treeNodeMap) {
		this.treeNodeMap = treeNodeMap;
	}

	/**
	 * ������Ϣ��������ȡ��
	 *
	 * @return reportFileDefinitionSearchCond ������Ϣ��������
	 */
	public ReportFileDefinitionSearchCond getReportFileDefinitionSearchCond() {
		return reportFileDefinitionSearchCond;
	}

	/**
	 * ������Ϣ���������趨
	 *
	 * @param reportFileDefinitionSearchCond ������Ϣ��������
	 */
	public void setReportFileDefinitionSearchCond(
			ReportFileDefinitionSearchCond reportFileDefinitionSearchCond) {
		this.reportFileDefinitionSearchCond = reportFileDefinitionSearchCond;
	}

	/**
	 * ������Ϣ���������ȡ��
	 *
	 * @return reportFileDefinitionList ������Ϣ���������
	 */
	public List<ReportFileDefinition> getReportFileDefinitionList() {
		return reportFileDefinitionList;
	}

	/**
	 * ������Ϣ����������趨
	 *
	 * @param reportFileDefinitionList ������Ϣ���������
	 */
	public void setReportFileDefinitionList(
			List<ReportFileDefinition> reportFileDefinitionList) {
		this.reportFileDefinitionList = reportFileDefinitionList;
	}

	/**
	 * �ڵ���������ȡ��
	 *
	 * @return completeNodeName �ڵ���������
	 */
	public String getCompleteNodeName() {
		return completeNodeName;
	}

	/**
	 * �ڵ����������趨
	 *
	 * @param completeNodeName �ڵ���������
	 */
	public void setCompleteNodeName(String completeNodeName) {
		this.completeNodeName = completeNodeName;
	}

	/**
	 * �û���Ϣȡ��
	 *
	 * @return user �û���Ϣ
	 */
	public User getUser() {
		return user;
	}

	/**
	 * �û���Ϣ�趨
	 *
	 * @param user �û���Ϣ
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * �澯��Ϣȡ��
	 *
	 * @return soc0305List �澯��Ϣ
	 */
	public List<SOC0305Info> getSoc0305List() {
		return soc0305List;
	}

	/**
	 * �澯��Ϣ�趨
	 *
	 * @param soc0305List �澯��Ϣ
	 */
	public void setSoc0305List(List<SOC0305Info> soc0305List) {
		this.soc0305List = soc0305List;
	}

	/**
	 * �澯��ͼ��Ϣȡ��
	 *
	 * @return soc0307List �澯��ͼ��Ϣ
	 */
	public List<SOC0307Info> getSoc0307List() {
		return soc0307List;
	}

	/**
	 * �澯��ͼ��Ϣ�趨
	 *
	 * @param soc0307List �澯��ͼ��Ϣ
	 */
	public void setSoc0307List(List<SOC0307Info> soc0307List) {
		this.soc0307List = soc0307List;
	}

	
	
	
	
}


