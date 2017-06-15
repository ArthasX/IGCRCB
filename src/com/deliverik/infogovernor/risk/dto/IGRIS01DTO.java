/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */


package com.deliverik.infogovernor.risk.dto;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.model.Attachment;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.risk.form.IGRIS0102Form;
import com.deliverik.infogovernor.risk.form.IGRIS0104Form;
import com.deliverik.infogovernor.risk.form.IGRIS0105Form;
import com.deliverik.infogovernor.risk.form.IGRIS0110Form;
import com.deliverik.infogovernor.risk.form.IGRIS0112Form;
import com.deliverik.infogovernor.risk.form.IGRIS0113Form;
import com.deliverik.infogovernor.risk.form.IGRIS0114Form;
import com.deliverik.infogovernor.risk.form.IGRIS0115Form;
import com.deliverik.infogovernor.risk.form.IGRIS0117Form;
import com.deliverik.infogovernor.risk.model.RiskAudit;
import com.deliverik.infogovernor.risk.model.RiskAuditDef;
import com.deliverik.infogovernor.risk.model.RiskAuditDefResultVWInfo;
import com.deliverik.infogovernor.risk.model.RiskAuditIns;
import com.deliverik.infogovernor.risk.model.RiskAuditResult;
import com.deliverik.infogovernor.risk.model.RiskCheck;
import com.deliverik.infogovernor.risk.model.RiskCheckResult;
import com.deliverik.infogovernor.risk.model.condition.RiskAuditDefSearchCond;
import com.deliverik.infogovernor.risk.model.condition.RiskAuditInsSearchCond;
import com.deliverik.infogovernor.risk.model.condition.RiskAuditSearchCond;

/**
 * �������ҵ��DTO
 * 
 * @author liupeng@deliverik.com
 */
@SuppressWarnings("serial")
public class IGRIS01DTO extends BaseDTO implements Serializable{
	
	//-----------------------------------------------------------�������----------------------------------------------------------------------

	/** ���������Ϣ�������� */
	protected RiskAuditSearchCond riskAuditSearchCond;
	
	/** ���������ϢForm */
	protected IGRIS0102Form igRIS0102Form;

	/** ���������Ϣ��������� */
	protected List<RiskAudit> riskAuditList;

	/** ��ҳ��DTO */
	protected PagingDTO pagingDto;
	
	/** �û����� */
	protected User user;
	
	/** �����б� */
	protected List<LabelValueBean> labelList;
	
	//-----------------------------------------------------------������Ʒ���----------------------------------------------------------------------

	/** ������Ʒ�����Ϣ�������� */
	protected RiskAuditInsSearchCond riskAuditInsSearchCond;
	
	/** ������Ʒ�����ϢForm */
	protected IGRIS0110Form igRIS0110Form;

	/** ������Ʒ�����Ϣ��������� */
	protected List<RiskAuditIns> riskAuditInsList;
	
	/** ������Ʒ�����Ϣ */
	protected RiskAuditIns riskAuditIns;
	
	//-----------------------------------------------------------�����----------------------------------------------------------------------
	
	/** �������Ϣ�������� */
	protected RiskAuditDefSearchCond riskAuditDefSearchCond;
	
	/** �������Ϣ��ѯForm */
	protected IGRIS0104Form igRIS0104Form;
	
	/** �������ϢForm */
	protected IGRIS0105Form igRIS0105Form;
	//-----------------------------------------------------------���������----------------------------------------------------------------------
	
	/** �����������ϢForm */
	protected IGRIS0112Form igRIS0112Form;
	
	/** �����������Ϣ��������� */
	protected List<RiskAuditDefResultVWInfo> riskAuditDefResultVWInfoList;
	
	/** �������󼶴� */
	protected Integer radMaxLevel;
	
	/** ������list */
	protected List<Integer> radMaxLevelList;
	
	//-----------------------------------------------------------��Ʊ���----------------------------------------------------------------------
	
	/** ������Ʊ�����ϢForm */
	protected IGRIS0117Form igRIS0117Form;
	
	/** �����������ճ̶�list */
	protected List<CodeDetail> radrisklevelList;
	
	/** ������������Ƶ��list */
	protected List<CodeDetail> radfrequencyList;
	
	/** �������������ֶ�list */
	protected List<CodeDetail> radmodeList;
	
	/** ����������������list */
	protected List<CodeDetail> radtypeList;
	
	/** ��������ƶȽ�������list */
	protected List<CodeDetail> rarplanscoreList;
	
	/** ��������ƶ�ִ������list */
	protected List<CodeDetail> rarexecscoreList;
	
	/** ���������������list */
	protected List<CodeDetail> raroverallscoreList;
	
	/** ͳ�Ƹ����������� */
	protected Map<String, Integer> childCountMap;
	
	/** ���������Ϣ���������� */
	protected int maxSearchCount;

	/** �������Ϣ��������� */
	protected List<RiskAuditDef> riskAuditDefList;
	
	/** �������ϸ��Ϣ */
	protected RiskAuditDef riskAuditDef;
	
	/** �������*/
	private Map<String,TreeNode> treeNodeMap=new LinkedHashMap<String,TreeNode>();
	//-----------------------------------------------------------�������----------------------------------------------------------------------
	/** ���������Ϣ��ѯForm */
	protected IGRIS0113Form igRIS0113Form;
	
	/** ���������Ϣ��������� */
	protected List<RiskAuditResult> riskAuditResultList;
	
	/** ���������ϸ��Ϣ */
	protected RiskAuditResult riskAuditResult;
	
	/** ���������Ϣ����Form */
	protected IGRIS0114Form igRIS0114Form;
	
	/** ��������鿴�����Form */
	protected IGRIS0115Form igRIS0115Form;
	
	/** ���ռ����Ϣ��������� */
	protected List<RiskCheck> riskCheckList;
	
	/** ���ռ������Ϣ��������� */
	protected List<RiskCheckResult> riskCheckResultList;
	
	/**���ռ����ϸ��Ϣ*/
	
	protected RiskCheck riskCheck;
	
	/** ���ռ����Ա��ʽ�Ľ�����Ϣ */
	protected String cronInfo;
	
	/** ���ռ����Ϣ�������� */
	protected List<Attachment> attachmentList;
	
	/**���ռ����*/
	protected Map<RiskCheckResult, List<Attachment>> attachmentMap;

	public RiskCheck getRiskCheck() {
		return riskCheck;
	}

	public void setRiskCheck(RiskCheck riskCheck) {
		this.riskCheck = riskCheck;
	}

	public String getCronInfo() {
		return cronInfo;
	}

	public void setCronInfo(String cronInfo) {
		this.cronInfo = cronInfo;
	}

	public List<Attachment> getAttachmentList() {
		return attachmentList;
	}

	public void setAttachmentList(List<Attachment> attachmentList) {
		this.attachmentList = attachmentList;
	}

	public Map<RiskCheckResult, List<Attachment>> getAttachmentMap() {
		return attachmentMap;
	}

	public void setAttachmentMap(
			Map<RiskCheckResult, List<Attachment>> attachmentMap) {
		this.attachmentMap = attachmentMap;
	}

	/**
	 * ���ռ����Ϣ���������ȡ��
	 * @return ���ռ������ϢϢ���������
	 */
	public List<RiskCheckResult> getRiskCheckResultList() {
		return riskCheckResultList;
	}

	/**
	 * ���ռ������Ϣ����������趨
	 * @param riskCheckResultList ���ռ������Ϣ���������
	 */
	public void setRiskCheckResultList(List<RiskCheckResult> riskCheckResultList) {
		this.riskCheckResultList = riskCheckResultList;
	}
	
	/**
	 * ���ռ����Ϣ���������ȡ��
	 * @return ���ռ����ϢϢ���������
	 */
	public List<RiskCheck> getRiskCheckList() {
		return riskCheckList;
	}

	/**
	 * ���ռ����Ϣ����������趨
	 * @param riskCheckList ���ռ����Ϣ���������
	 */
	public void setRiskCheckList(List<RiskCheck> riskCheckList) {
		this.riskCheckList = riskCheckList;
	}

	/**
	 * ��������鿴�����Formȡ��
	 * 
	 * @return ��������鿴�����Form
	 */
	public IGRIS0115Form getIgRIS0115Form() {
		return igRIS0115Form;
	}

	/**
	 * ��������鿴�����Form�趨
	 *
	 * @param igRIS0113Form ��������鿴�����Form
	 */
	public void setIgRIS0115Form(IGRIS0115Form igRIS0115Form) {
		this.igRIS0115Form = igRIS0115Form;
	}
	/**
	 * ���������Ϣ����Formȡ��
	 * 
	 * @return ���������Ϣ����Form
	 */
	public IGRIS0114Form getIgRIS0114Form() {
		return igRIS0114Form;
	}

	/**
	 * ���������Ϣ����Form�趨
	 *
	 * @param igRIS0113Form ���������Ϣ����Form
	 */
	public void setIgRIS0114Form(IGRIS0114Form igRIS0114Form) {
		this.igRIS0114Form = igRIS0114Form;
	}
	
	/**
	 * ���������Ϣ���������ȡ��
	 * @return ���������Ϣ���������
	 */
	public List<RiskAuditResult> getRiskAuditResultList() {
		return riskAuditResultList;
	}

	/**
	 * ���������Ϣ����������趨
	 * @param riskAuditResultList ���������Ϣ���������
	 */
	public void setRiskAuditResultList(List<RiskAuditResult> riskAuditResultList) {
		this.riskAuditResultList = riskAuditResultList;
	}

	/**
	 * ���������ϸ��Ϣȡ��
	 * @return ���������ϸ��Ϣ��
	 */
	public RiskAuditResult getRiskAuditResult() {
		return riskAuditResult;
	}
	/**
	 * ���������ϸ��Ϣ�趨
	 * @param riskAuditResult ���������ϸ��Ϣ
	 */

	public void setRiskAuditResult(RiskAuditResult riskAuditResult) {
		this.riskAuditResult = riskAuditResult;
	}

	/**
	 * ���������Ϣ��ѯForȡ��
	 * 
	 * @return ���������Ϣ��ѯFor
	 */
	public IGRIS0113Form getIgRIS0113Form() {
		return igRIS0113Form;
	}

	/**
	 * ���������Ϣ��ѯFor�趨
	 *
	 * @param igRIS0113Form ���������Ϣ��ѯFor
	 */
	public void setIgRIS0113Form(IGRIS0113Form igRIS0113Form) {
		this.igRIS0113Form = igRIS0113Form;
	}

	
	/**
	 * �������ϸ��Ϣȡ��
	 * @return �������ϸ��Ϣ��
	 */
	public RiskAuditDef getRiskAuditDef() {
		return riskAuditDef;
	}

	/**
	 * �������ϸ��Ϣ�趨
	 * @param riskAudit �������ϸ��Ϣ
	 */
	public void setRiskAuditDef(RiskAuditDef riskAuditDef) {
		this.riskAuditDef = riskAuditDef;
	}

	/**
	 * �����״̬ȡ��
	 * @return �����״̬
	 */
	public RiskAuditDefSearchCond getRiskAuditDefSearchCond() {
		return riskAuditDefSearchCond;
	}

	/**
	 * �������Ϣ���������趨
	 * @param riskAuditDefSearchCond �������Ϣ��������
	 */
	public void setRiskAuditDefSearchCond(
			RiskAuditDefSearchCond riskAuditDefSearchCond) {
		this.riskAuditDefSearchCond = riskAuditDefSearchCond;
	}

	/**
	 * �������Ϣ��ѯFormȡ��
	 * @return �������Ϣ��ѯForm
	 */
	public IGRIS0104Form getIgRIS0104Form() {
		return igRIS0104Form;
	}

	/**
	 * �������Ϣ��ѯForm�趨
	 * @param igRIS0105Form �������Ϣ��ѯForm
	 */
	public void setIgRIS0104Form(IGRIS0104Form igRIS0104Form) {
		this.igRIS0104Form = igRIS0104Form;
	}
	/**
	 * �������ϢFormȡ��
	 * @return �������ϢForm
	 */
	public IGRIS0105Form getIgRIS0105Form() {
		return igRIS0105Form;
	}

	/**
	 * �������ϢForm�趨
	 * @param igRIS0105Form �������ϢForm
	 */
	public void setIgRIS0105Form(IGRIS0105Form igRIS0105Form) {
		this.igRIS0105Form = igRIS0105Form;
	}

	/**
	 * �������Ϣ���������ȡ��
	 * @return �������Ϣ���������
	 */
	public List<RiskAuditDef> getRiskAuditDefList() {
		return riskAuditDefList;
	}

	/**
	 * �������Ϣ����������趨
	 * @param riskAuditList �������Ϣ���������
	 */
	public void setRiskAuditDefList(List<RiskAuditDef> riskAuditDefList) {
		this.riskAuditDefList = riskAuditDefList;
	}

	/**
	 * ���������Ϣ���������ȡ��
	 * @return ���������Ϣ���������
	 */
	public Map<String, TreeNode> getTreeNodeMap() {
		return treeNodeMap;
	}

	/**
	 * ���������Ϣ����������趨
	 * @param treeNodeMap ���������Ϣ���������
	 */
	public void setTreeNodeMap(Map<String, TreeNode> treeNodeMap) {
		this.treeNodeMap = treeNodeMap;
	}

	/**
	 * �������״̬ȡ��
	 * @return �������״̬
	 */
	public RiskAuditSearchCond getRiskAuditSearchCond() {
		return riskAuditSearchCond;
	}

	/**
	 * ���������Ϣ���������趨
	 * @param riskAuditSearchCond ���������Ϣ��������
	 */
	public void setRiskAuditSearchCond(RiskAuditSearchCond riskAuditSearchCond) {
		this.riskAuditSearchCond = riskAuditSearchCond;
	}

	/**
	 * ���������ϢFormȡ��
	 * @return ���������ϢForm
	 */
	public IGRIS0102Form getIgRIS0102Form() {
		return igRIS0102Form;
	}

	/**
	 * ���������ϢForm�趨
	 * @param igRIS0102Form ���������ϢForm
	 */
	public void setIgRIS0102Form(IGRIS0102Form igRIS0102Form) {
		this.igRIS0102Form = igRIS0102Form;
	}

	/**
	 * ���������Ϣ���������ȡ��
	 * @return ���������Ϣ���������
	 */
	public List<RiskAudit> getRiskAuditList() {
		return riskAuditList;
	}

	/**
	 * ���������Ϣ����������趨
	 * @param riskAuditList ���������Ϣ���������
	 */
	public void setRiskAuditList(List<RiskAudit> riskAuditList) {
		this.riskAuditList = riskAuditList;
	}
	
	/**
	 * ���������Ϣ����������ȡ��
	 * 
	 * @return ���������Ϣ����������
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * ���������Ϣ�����������趨
	 *
	 * @param maxSearchCount ���������Ϣ����������
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * ��ҳ��DTOȡ��
	 * 
	 * @return ��ҳ��DTO
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * ��ҳ��DTO�趨
	 *
	 * @param pagingDto ��ҳ��DTO
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	/**
	 * �û�����ȡ��
	 * 
	 * @return �û�����
	 */
	public User getUser() {
		return user;
	}

	/**
	 * �û������趨
	 *
	 * @param user �û�����
	 */
	public void setUser(User user) {
		this.user = user;
	}
	
	/**
	 * ������Ʒ�����Ϣ��������ȡ��
	 * 
	 * @return ������Ʒ�����Ϣ��������
	 */
	public RiskAuditInsSearchCond getRiskAuditInsSearchCond() {
		return riskAuditInsSearchCond;
	}

	/**
	 * ������Ʒ�����Ϣ���������趨
	 *
	 * @param riskAuditInsSearchCond ������Ʒ�����Ϣ��������
	 */
	public void setRiskAuditInsSearchCond(
			RiskAuditInsSearchCond riskAuditInsSearchCond) {
		this.riskAuditInsSearchCond = riskAuditInsSearchCond;
	}

	/**
	 * ������Ʒ�����ϢFormȡ��
	 * 
	 * @return ������Ʒ�����ϢForm
	 */
	public IGRIS0110Form getIgRIS0110Form() {
		return igRIS0110Form;
	}

	/**
	 * ������Ʒ�����ϢForm�趨
	 *
	 * @param igRIS0110Form ������Ʒ�����ϢForm
	 */
	public void setIgRIS0110Form(IGRIS0110Form igRIS0110Form) {
		this.igRIS0110Form = igRIS0110Form;
	}

	/**
	 * ������Ʒ�����Ϣ���������ȡ��
	 * 
	 * @return ������Ʒ�����Ϣ���������
	 */
	public List<RiskAuditIns> getRiskAuditInsList() {
		return riskAuditInsList;
	}

	/**
	 * ������Ʒ�����Ϣ����������趨
	 *
	 * @param riskAuditInsList ������Ʒ�����Ϣ���������
	 */
	public void setRiskAuditInsList(List<RiskAuditIns> riskAuditInsList) {
		this.riskAuditInsList = riskAuditInsList;
	}

	/**
	 * �����б�ȡ��
	 * 
	 * @return �����б�
	 */
	public List<LabelValueBean> getLabelList() {
		return labelList;
	}

	/**
	 * �����б��趨
	 *
	 * @param labelList �����б�
	 */
	public void setLabelList(List<LabelValueBean> labelList) {
		this.labelList = labelList;
	}
	
	
	/**
	 * �����������ϢFormȡ��
	 * 
	 * @return �����������ϢForm
	 */
	public IGRIS0112Form getIgRIS0112Form() {
		return igRIS0112Form;
	}

	/**
	 * �����������ϢForm�趨
	 *
	 * @param igRIS0112Form �����������ϢForm
	 */
	public void setIgRIS0112Form(IGRIS0112Form igRIS0112Form) {
		this.igRIS0112Form = igRIS0112Form;
	}

	/**
	 * �����������Ϣ���������ȡ��
	 * 
	 * @return �����������Ϣ���������
	 */
	public List<RiskAuditDefResultVWInfo> getRiskAuditDefResultVWInfoList() {
		return riskAuditDefResultVWInfoList;
	}

	/**
	 * �����������Ϣ����������趨
	 *
	 * @param riskAuditDefResultVWInfoList �����������Ϣ���������
	 */
	public void setRiskAuditDefResultVWInfoList(
			List<RiskAuditDefResultVWInfo> riskAuditDefResultVWInfoList) {
		this.riskAuditDefResultVWInfoList = riskAuditDefResultVWInfoList;
	}

	/**
	 * �������󼶴�ȡ��
	 * 
	 * @return �������󼶴�
	 */
	public Integer getRadMaxLevel() {
		return radMaxLevel;
	}
	
	/**
	 * �������󼶴��趨
	 *
	 * @param radMaxLevel �������󼶴�
	 */
	public void setRadMaxLevel(Integer radMaxLevel) {
		this.radMaxLevel = radMaxLevel;
	}
	
	/**
	 * ������listȡ��
	 * 
	 * @return ������list
	 */
	public List<Integer> getRadMaxLevelList() {
		return radMaxLevelList;
	}

	/**
	 * ������list�趨
	 *
	 * @param List<Integer> ������list
	 */
	public void setRadMaxLevelList(List<Integer> radMaxLevelList) {
		this.radMaxLevelList = radMaxLevelList;
	}

	/**
	 * ������Ʊ�����ϢFormȡ��
	 * 
	 * @return ������Ʊ�����ϢForm
	 */
	public IGRIS0117Form getIgRIS0117Form() {
		return igRIS0117Form;
	}

	/**
	 * ������Ʊ�����ϢForm�趨
	 *
	 * @param igRIS0117Form ������Ʊ�����ϢForm
	 */
	public void setIgRIS0117Form(IGRIS0117Form igRIS0117Form) {
		this.igRIS0117Form = igRIS0117Form;
	}

	/**
	 * ͳ�Ƹ�����������ȡ��
	 * 
	 * @return ͳ�Ƹ�����������
	 */
	public Map<String, Integer> getChildCountMap() {
		return childCountMap;
	}

	/**
	 * ͳ�Ƹ������������趨
	 *
	 * @param childCountMap ͳ�Ƹ�����������
	 */
	public void setChildCountMap(Map<String, Integer> childCountMap) {
		this.childCountMap = childCountMap;
	}

	/**
	 * �����������ճ̶�listȡ��
	 * 
	 * @return �����������ճ̶�list
	 */
	public List<CodeDetail> getRadrisklevelList() {
		return radrisklevelList;
	}

	/**
	 * �����������ճ̶�list�趨
	 *
	 * @param radrisklevelList �����������ճ̶�list
	 */
	public void setRadrisklevelList(List<CodeDetail> radrisklevelList) {
		this.radrisklevelList = radrisklevelList;
	}

	/**
	 * ������������Ƶ��listȡ��
	 * 
	 * @return ������������Ƶ��list
	 */
	public List<CodeDetail> getRadfrequencyList() {
		return radfrequencyList;
	}

	/**
	 * ������������Ƶ��list�趨
	 *
	 * @param radfrequencyList ������������Ƶ��list
	 */
	public void setRadfrequencyList(List<CodeDetail> radfrequencyList) {
		this.radfrequencyList = radfrequencyList;
	}

	/**
	 * �������������ֶ�listȡ��
	 * 
	 * @return �������������ֶ�list
	 */
	public List<CodeDetail> getRadmodeList() {
		return radmodeList;
	}

	/**
	 * �������������ֶ�list�趨
	 *
	 * @param radmodeList �������������ֶ�list
	 */
	public void setRadmodeList(List<CodeDetail> radmodeList) {
		this.radmodeList = radmodeList;
	}

	/**
	 * ����������������listȡ��
	 * 
	 * @return ����������������list
	 */
	public List<CodeDetail> getRadtypeList() {
		return radtypeList;
	}

	/**
	 * ����������������list�趨
	 *
	 * @param radtypeList ����������������list
	 */
	public void setRadtypeList(List<CodeDetail> radtypeList) {
		this.radtypeList = radtypeList;
	}

	/**
	 * ��������ƶȽ�������listȡ��
	 * 
	 * @return ��������ƶȽ�������list
	 */
	public List<CodeDetail> getRarplanscoreList() {
		return rarplanscoreList;
	}

	/**
	 * ��������ƶȽ�������list�趨
	 *
	 * @param rarplanscoreList ��������ƶȽ�������list
	 */
	public void setRarplanscoreList(List<CodeDetail> rarplanscoreList) {
		this.rarplanscoreList = rarplanscoreList;
	}

	/**
	 * ��������ƶ�ִ������listȡ��
	 * 
	 * @return ��������ƶ�ִ������list
	 */
	public List<CodeDetail> getRarexecscoreList() {
		return rarexecscoreList;
	}

	/**
	 * ��������ƶ�ִ������list�趨
	 *
	 * @param rarexecscoreList ��������ƶ�ִ������list
	 */
	public void setRarexecscoreList(List<CodeDetail> rarexecscoreList) {
		this.rarexecscoreList = rarexecscoreList;
	}

	/**
	 * ���������������listȡ��
	 * 
	 * @return ���������������list
	 */
	public List<CodeDetail> getRaroverallscoreList() {
		return raroverallscoreList;
	}

	/**
	 * ���������������list�趨
	 *
	 * @param raroverallscoreList ���������������list
	 */
	public void setRaroverallscoreList(List<CodeDetail> raroverallscoreList) {
		this.raroverallscoreList = raroverallscoreList;
	}

	/**
	 * ������Ʒ�����Ϣȡ��
	 * 
	 * @return ������Ʒ�����Ϣ
	 */
	public RiskAuditIns getRiskAuditIns() {
		return riskAuditIns;
	}

	/**
	 * ������Ʒ�����Ϣ�趨
	 *
	 * @param riskAuditIns ������Ʒ�����Ϣ
	 */
	public void setRiskAuditIns(RiskAuditIns riskAuditIns) {
		this.riskAuditIns = riskAuditIns;
	}
	
}


