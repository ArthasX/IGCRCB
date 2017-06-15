/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */


package com.deliverik.infogovernor.rpt.dto;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.rpt.form.IGRPT0102Form;
import com.deliverik.infogovernor.sym.model.ReportFileDefinition;
import com.deliverik.infogovernor.sym.model.condition.ReportFileDefinitionSearchCond;

/**
 * ͳ�Ʒ���ҵ��DTO
 * 
 */
@SuppressWarnings("serial")
public class IGRPT01DTO extends BaseDTO implements Serializable{
	
	/** ��������� */
	protected Map<String,TreeNode> treeNodeMap=new LinkedHashMap<String,TreeNode>();
	
	/** ������Ϣ�������� */
	protected ReportFileDefinitionSearchCond reportFileDefinitionSearchCond;
	
	/** ������Ϣ��������� */
	protected List<ReportFileDefinition> reportFileDefinitionList;
	
	/** �ڵ��������� */
	protected String completeNodeName;
	
	protected IGRPT0102Form igRPT0102Form;
	
	/** �û���Ϣ*/
	protected User user;
	
	List<ReportFileDefinition> selectedReportFileDefinitionList ;
	
	
	public IGRPT0102Form getIgRPT0102Form() {
		return igRPT0102Form;
	}

	public void setIgRPT0102Form(IGRPT0102Form igRPT0102Form) {
		this.igRPT0102Form = igRPT0102Form;
	}

	public List<ReportFileDefinition> getSelectedReportFileDefinitionList() {
		return selectedReportFileDefinitionList;
	}

	public void setSelectedReportFileDefinitionList(
			List<ReportFileDefinition> selectedReportFileDefinitionList) {
		this.selectedReportFileDefinitionList = selectedReportFileDefinitionList;
	}

	/**
	 * ���������ȡ��
	 * @return ���������
	 */
	public Map<String, TreeNode> getTreeNodeMap() {
		return treeNodeMap;
	}

	/**
	 * ����������趨
	 * @param treeNodeMap ���������
	 */
	public void setTreeNodeMap(Map<String, TreeNode> treeNodeMap) {
		this.treeNodeMap = treeNodeMap;
	}
	
	/**
	 * ������Ϣ��������ȡ��
	 * @return ������Ϣ��������
	 */
	public ReportFileDefinitionSearchCond getReportFileDefinitionSearchCond() {
		return reportFileDefinitionSearchCond;
	}

	/**
	 * ������Ϣ���������趨
	 * @param reportFileDefinitionSearchCond ������Ϣ��������
	 */
	public void setReportFileDefinitionSearchCond(
			ReportFileDefinitionSearchCond reportFileDefinitionSearchCond) {
		this.reportFileDefinitionSearchCond = reportFileDefinitionSearchCond;
	}
	
	/**
	 * ������Ϣ���������ȡ��
	 * @return ������Ϣ���������
	 */
	public List<ReportFileDefinition> getReportFileDefinitionList() {
		return reportFileDefinitionList;
	}

	/**
	 * ������Ϣ����������趨
	 * @param reportFileDefinitionList ������Ϣ���������
	 */
	public void setReportFileDefinitionList(
			List<ReportFileDefinition> reportFileDefinitionList) {
		this.reportFileDefinitionList = reportFileDefinitionList;
	}

	/**
	 * �ڵ��������ȡ��
	 * @return �ڵ��������
	 */
	public String getCompleteNodeName() {
		return completeNodeName;
	}

	/**
	 * �ڵ���������趨
	 * @param completeNodeName �ڵ��������
	 */
	public void setCompleteNodeName(String completeNodeName) {
		this.completeNodeName = completeNodeName;
	}

	/**
	 * ��ȡ�û���Ϣ
	 * @param 
	 */
	public User getUser() {
		return user;
	}

	/**
	 * �����û���Ϣ
	 * 
	 */
	public void setUser(User user) {
		this.user = user;
	}
	
	
}


