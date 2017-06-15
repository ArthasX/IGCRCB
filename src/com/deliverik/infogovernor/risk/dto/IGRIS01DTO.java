/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
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
 * 风险审计业务DTO
 * 
 * @author liupeng@deliverik.com
 */
@SuppressWarnings("serial")
public class IGRIS01DTO extends BaseDTO implements Serializable{
	
	//-----------------------------------------------------------风险审计----------------------------------------------------------------------

	/** 风险审计信息检索条件 */
	protected RiskAuditSearchCond riskAuditSearchCond;
	
	/** 风险审计信息Form */
	protected IGRIS0102Form igRIS0102Form;

	/** 风险审计信息检索结果集 */
	protected List<RiskAudit> riskAuditList;

	/** 分页用DTO */
	protected PagingDTO pagingDto;
	
	/** 用户对象 */
	protected User user;
	
	/** 下拉列表 */
	protected List<LabelValueBean> labelList;
	
	//-----------------------------------------------------------风险审计发起----------------------------------------------------------------------

	/** 风险审计发起信息检索条件 */
	protected RiskAuditInsSearchCond riskAuditInsSearchCond;
	
	/** 风险审计发起信息Form */
	protected IGRIS0110Form igRIS0110Form;

	/** 风险审计发起信息检索结果集 */
	protected List<RiskAuditIns> riskAuditInsList;
	
	/** 风险审计发起信息 */
	protected RiskAuditIns riskAuditIns;
	
	//-----------------------------------------------------------审计项----------------------------------------------------------------------
	
	/** 审计项信息检索条件 */
	protected RiskAuditDefSearchCond riskAuditDefSearchCond;
	
	/** 审计项信息查询Form */
	protected IGRIS0104Form igRIS0104Form;
	
	/** 审计项信息Form */
	protected IGRIS0105Form igRIS0105Form;
	//-----------------------------------------------------------风险审计人----------------------------------------------------------------------
	
	/** 风险审计人信息Form */
	protected IGRIS0112Form igRIS0112Form;
	
	/** 风险审计人信息检索结果集 */
	protected List<RiskAuditDefResultVWInfo> riskAuditDefResultVWInfoList;
	
	/** 审计项最大级次 */
	protected Integer radMaxLevel;
	
	/** 审计项级次list */
	protected List<Integer> radMaxLevelList;
	
	//-----------------------------------------------------------审计报告----------------------------------------------------------------------
	
	/** 风险审计报告信息Form */
	protected IGRIS0117Form igRIS0117Form;
	
	/** 风险审计项风险程度list */
	protected List<CodeDetail> radrisklevelList;
	
	/** 风险审计项控制频率list */
	protected List<CodeDetail> radfrequencyList;
	
	/** 风险审计项控制手段list */
	protected List<CodeDetail> radmodeList;
	
	/** 风险审计项控制类型list */
	protected List<CodeDetail> radtypeList;
	
	/** 风险审计制度建设评分list */
	protected List<CodeDetail> rarplanscoreList;
	
	/** 风险审计制度执行评分list */
	protected List<CodeDetail> rarexecscoreList;
	
	/** 风险审计总体评分list */
	protected List<CodeDetail> raroverallscoreList;
	
	/** 统计各级审计项孩子数 */
	protected Map<String, Integer> childCountMap;
	
	/** 风险审计信息最大检索件数 */
	protected int maxSearchCount;

	/** 审计项信息检索结果集 */
	protected List<RiskAuditDef> riskAuditDefList;
	
	/** 审计项详细信息 */
	protected RiskAuditDef riskAuditDef;
	
	/** 审计项树*/
	private Map<String,TreeNode> treeNodeMap=new LinkedHashMap<String,TreeNode>();
	//-----------------------------------------------------------审计评估----------------------------------------------------------------------
	/** 审计评估信息查询Form */
	protected IGRIS0113Form igRIS0113Form;
	
	/** 审计评估信息检索结果集 */
	protected List<RiskAuditResult> riskAuditResultList;
	
	/** 审计评估详细信息 */
	protected RiskAuditResult riskAuditResult;
	
	/** 审计评估信息增加Form */
	protected IGRIS0114Form igRIS0114Form;
	
	/** 审计评估查看检查项Form */
	protected IGRIS0115Form igRIS0115Form;
	
	/** 风险检查信息检索结果集 */
	protected List<RiskCheck> riskCheckList;
	
	/** 风险检查结果信息检索结果集 */
	protected List<RiskCheckResult> riskCheckResultList;
	
	/**风险检查详细信息*/
	
	protected RiskCheck riskCheck;
	
	/** 风险检查策略表达式的解释信息 */
	protected String cronInfo;
	
	/** 风险检查信息附件集合 */
	protected List<Attachment> attachmentList;
	
	/**风险检查结果*/
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
	 * 风险检查结果息检索结果集取得
	 * @return 风险检查结果信息息检索结果集
	 */
	public List<RiskCheckResult> getRiskCheckResultList() {
		return riskCheckResultList;
	}

	/**
	 * 风险检查结果信息检索结果集设定
	 * @param riskCheckResultList 风险检查结果信息检索结果集
	 */
	public void setRiskCheckResultList(List<RiskCheckResult> riskCheckResultList) {
		this.riskCheckResultList = riskCheckResultList;
	}
	
	/**
	 * 风险检查信息检索结果集取得
	 * @return 风险检查信息息检索结果集
	 */
	public List<RiskCheck> getRiskCheckList() {
		return riskCheckList;
	}

	/**
	 * 风险检查信息检索结果集设定
	 * @param riskCheckList 风险检查信息检索结果集
	 */
	public void setRiskCheckList(List<RiskCheck> riskCheckList) {
		this.riskCheckList = riskCheckList;
	}

	/**
	 * 审计评估查看检查项Form取得
	 * 
	 * @return 审计评估查看检查项Form
	 */
	public IGRIS0115Form getIgRIS0115Form() {
		return igRIS0115Form;
	}

	/**
	 * 审计评估查看检查项Form设定
	 *
	 * @param igRIS0113Form 审计评估查看检查项Form
	 */
	public void setIgRIS0115Form(IGRIS0115Form igRIS0115Form) {
		this.igRIS0115Form = igRIS0115Form;
	}
	/**
	 * 审计评估信息增加Form取得
	 * 
	 * @return 审计评估信息增加Form
	 */
	public IGRIS0114Form getIgRIS0114Form() {
		return igRIS0114Form;
	}

	/**
	 * 审计评估信息增加Form设定
	 *
	 * @param igRIS0113Form 审计评估信息增加Form
	 */
	public void setIgRIS0114Form(IGRIS0114Form igRIS0114Form) {
		this.igRIS0114Form = igRIS0114Form;
	}
	
	/**
	 * 审计评估信息检索结果集取得
	 * @return 审计评估信息检索结果集
	 */
	public List<RiskAuditResult> getRiskAuditResultList() {
		return riskAuditResultList;
	}

	/**
	 * 审计评估信息检索结果集设定
	 * @param riskAuditResultList 审计评估信息检索结果集
	 */
	public void setRiskAuditResultList(List<RiskAuditResult> riskAuditResultList) {
		this.riskAuditResultList = riskAuditResultList;
	}

	/**
	 * 审计评估详细信息取得
	 * @return 审计评估详细信息集
	 */
	public RiskAuditResult getRiskAuditResult() {
		return riskAuditResult;
	}
	/**
	 * 审计评估详细信息设定
	 * @param riskAuditResult 审计评估详细信息
	 */

	public void setRiskAuditResult(RiskAuditResult riskAuditResult) {
		this.riskAuditResult = riskAuditResult;
	}

	/**
	 * 审计评估信息查询For取得
	 * 
	 * @return 审计评估信息查询For
	 */
	public IGRIS0113Form getIgRIS0113Form() {
		return igRIS0113Form;
	}

	/**
	 * 审计评估信息查询For设定
	 *
	 * @param igRIS0113Form 审计评估信息查询For
	 */
	public void setIgRIS0113Form(IGRIS0113Form igRIS0113Form) {
		this.igRIS0113Form = igRIS0113Form;
	}

	
	/**
	 * 审计项详细信息取得
	 * @return 审计项详细信息集
	 */
	public RiskAuditDef getRiskAuditDef() {
		return riskAuditDef;
	}

	/**
	 * 审计项详细信息设定
	 * @param riskAudit 审计项详细信息
	 */
	public void setRiskAuditDef(RiskAuditDef riskAuditDef) {
		this.riskAuditDef = riskAuditDef;
	}

	/**
	 * 审计项状态取得
	 * @return 审计项状态
	 */
	public RiskAuditDefSearchCond getRiskAuditDefSearchCond() {
		return riskAuditDefSearchCond;
	}

	/**
	 * 审计项信息检索条件设定
	 * @param riskAuditDefSearchCond 审计项信息检索条件
	 */
	public void setRiskAuditDefSearchCond(
			RiskAuditDefSearchCond riskAuditDefSearchCond) {
		this.riskAuditDefSearchCond = riskAuditDefSearchCond;
	}

	/**
	 * 审计项信息查询Form取得
	 * @return 审计项信息查询Form
	 */
	public IGRIS0104Form getIgRIS0104Form() {
		return igRIS0104Form;
	}

	/**
	 * 审计项信息查询Form设定
	 * @param igRIS0105Form 审计项信息查询Form
	 */
	public void setIgRIS0104Form(IGRIS0104Form igRIS0104Form) {
		this.igRIS0104Form = igRIS0104Form;
	}
	/**
	 * 审计项信息Form取得
	 * @return 审计项信息Form
	 */
	public IGRIS0105Form getIgRIS0105Form() {
		return igRIS0105Form;
	}

	/**
	 * 审计项信息Form设定
	 * @param igRIS0105Form 审计项信息Form
	 */
	public void setIgRIS0105Form(IGRIS0105Form igRIS0105Form) {
		this.igRIS0105Form = igRIS0105Form;
	}

	/**
	 * 审计项信息检索结果集取得
	 * @return 审计项信息检索结果集
	 */
	public List<RiskAuditDef> getRiskAuditDefList() {
		return riskAuditDefList;
	}

	/**
	 * 审计项信息检索结果集设定
	 * @param riskAuditList 审计项信息检索结果集
	 */
	public void setRiskAuditDefList(List<RiskAuditDef> riskAuditDefList) {
		this.riskAuditDefList = riskAuditDefList;
	}

	/**
	 * 审计项树信息检索结果集取得
	 * @return 审计项树信息检索结果集
	 */
	public Map<String, TreeNode> getTreeNodeMap() {
		return treeNodeMap;
	}

	/**
	 * 审计项树信息检索结果集设定
	 * @param treeNodeMap 审计项树信息检索结果集
	 */
	public void setTreeNodeMap(Map<String, TreeNode> treeNodeMap) {
		this.treeNodeMap = treeNodeMap;
	}

	/**
	 * 风险审计状态取得
	 * @return 风险审计状态
	 */
	public RiskAuditSearchCond getRiskAuditSearchCond() {
		return riskAuditSearchCond;
	}

	/**
	 * 风险审计信息检索条件设定
	 * @param riskAuditSearchCond 风险审计信息检索条件
	 */
	public void setRiskAuditSearchCond(RiskAuditSearchCond riskAuditSearchCond) {
		this.riskAuditSearchCond = riskAuditSearchCond;
	}

	/**
	 * 风险审计信息Form取得
	 * @return 风险审计信息Form
	 */
	public IGRIS0102Form getIgRIS0102Form() {
		return igRIS0102Form;
	}

	/**
	 * 风险审计信息Form设定
	 * @param igRIS0102Form 风险审计信息Form
	 */
	public void setIgRIS0102Form(IGRIS0102Form igRIS0102Form) {
		this.igRIS0102Form = igRIS0102Form;
	}

	/**
	 * 风险审计信息检索结果集取得
	 * @return 风险审计信息检索结果集
	 */
	public List<RiskAudit> getRiskAuditList() {
		return riskAuditList;
	}

	/**
	 * 风险审计信息检索结果集设定
	 * @param riskAuditList 风险审计信息检索结果集
	 */
	public void setRiskAuditList(List<RiskAudit> riskAuditList) {
		this.riskAuditList = riskAuditList;
	}
	
	/**
	 * 风险审计信息最大检索件数取得
	 * 
	 * @return 风险审计信息最大检索件数
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * 风险审计信息最大检索件数设定
	 *
	 * @param maxSearchCount 风险审计信息最大检索件数
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * 分页用DTO取得
	 * 
	 * @return 分页用DTO
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * 分页用DTO设定
	 *
	 * @param pagingDto 分页用DTO
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	/**
	 * 用户对象取得
	 * 
	 * @return 用户对象
	 */
	public User getUser() {
		return user;
	}

	/**
	 * 用户对象设定
	 *
	 * @param user 用户对象
	 */
	public void setUser(User user) {
		this.user = user;
	}
	
	/**
	 * 风险审计发起信息检索条件取得
	 * 
	 * @return 风险审计发起信息检索条件
	 */
	public RiskAuditInsSearchCond getRiskAuditInsSearchCond() {
		return riskAuditInsSearchCond;
	}

	/**
	 * 风险审计发起信息检索条件设定
	 *
	 * @param riskAuditInsSearchCond 风险审计发起信息检索条件
	 */
	public void setRiskAuditInsSearchCond(
			RiskAuditInsSearchCond riskAuditInsSearchCond) {
		this.riskAuditInsSearchCond = riskAuditInsSearchCond;
	}

	/**
	 * 风险审计发起信息Form取得
	 * 
	 * @return 风险审计发起信息Form
	 */
	public IGRIS0110Form getIgRIS0110Form() {
		return igRIS0110Form;
	}

	/**
	 * 风险审计发起信息Form设定
	 *
	 * @param igRIS0110Form 风险审计发起信息Form
	 */
	public void setIgRIS0110Form(IGRIS0110Form igRIS0110Form) {
		this.igRIS0110Form = igRIS0110Form;
	}

	/**
	 * 风险审计发起信息检索结果集取得
	 * 
	 * @return 风险审计发起信息检索结果集
	 */
	public List<RiskAuditIns> getRiskAuditInsList() {
		return riskAuditInsList;
	}

	/**
	 * 风险审计发起信息检索结果集设定
	 *
	 * @param riskAuditInsList 风险审计发起信息检索结果集
	 */
	public void setRiskAuditInsList(List<RiskAuditIns> riskAuditInsList) {
		this.riskAuditInsList = riskAuditInsList;
	}

	/**
	 * 下拉列表取得
	 * 
	 * @return 下拉列表
	 */
	public List<LabelValueBean> getLabelList() {
		return labelList;
	}

	/**
	 * 下拉列表设定
	 *
	 * @param labelList 下拉列表
	 */
	public void setLabelList(List<LabelValueBean> labelList) {
		this.labelList = labelList;
	}
	
	
	/**
	 * 风险审计人信息Form取得
	 * 
	 * @return 风险审计人信息Form
	 */
	public IGRIS0112Form getIgRIS0112Form() {
		return igRIS0112Form;
	}

	/**
	 * 风险审计人信息Form设定
	 *
	 * @param igRIS0112Form 风险审计人信息Form
	 */
	public void setIgRIS0112Form(IGRIS0112Form igRIS0112Form) {
		this.igRIS0112Form = igRIS0112Form;
	}

	/**
	 * 风险审计人信息检索结果集取得
	 * 
	 * @return 风险审计人信息检索结果集
	 */
	public List<RiskAuditDefResultVWInfo> getRiskAuditDefResultVWInfoList() {
		return riskAuditDefResultVWInfoList;
	}

	/**
	 * 风险审计人信息检索结果集设定
	 *
	 * @param riskAuditDefResultVWInfoList 风险审计人信息检索结果集
	 */
	public void setRiskAuditDefResultVWInfoList(
			List<RiskAuditDefResultVWInfo> riskAuditDefResultVWInfoList) {
		this.riskAuditDefResultVWInfoList = riskAuditDefResultVWInfoList;
	}

	/**
	 * 审计项最大级次取得
	 * 
	 * @return 审计项最大级次
	 */
	public Integer getRadMaxLevel() {
		return radMaxLevel;
	}
	
	/**
	 * 审计项最大级次设定
	 *
	 * @param radMaxLevel 审计项最大级次
	 */
	public void setRadMaxLevel(Integer radMaxLevel) {
		this.radMaxLevel = radMaxLevel;
	}
	
	/**
	 * 审计项级次list取得
	 * 
	 * @return 审计项级次list
	 */
	public List<Integer> getRadMaxLevelList() {
		return radMaxLevelList;
	}

	/**
	 * 审计项级次list设定
	 *
	 * @param List<Integer> 审计项级次list
	 */
	public void setRadMaxLevelList(List<Integer> radMaxLevelList) {
		this.radMaxLevelList = radMaxLevelList;
	}

	/**
	 * 风险审计报告信息Form取得
	 * 
	 * @return 风险审计报告信息Form
	 */
	public IGRIS0117Form getIgRIS0117Form() {
		return igRIS0117Form;
	}

	/**
	 * 风险审计报告信息Form设定
	 *
	 * @param igRIS0117Form 风险审计报告信息Form
	 */
	public void setIgRIS0117Form(IGRIS0117Form igRIS0117Form) {
		this.igRIS0117Form = igRIS0117Form;
	}

	/**
	 * 统计各级审计项孩子数取得
	 * 
	 * @return 统计各级审计项孩子数
	 */
	public Map<String, Integer> getChildCountMap() {
		return childCountMap;
	}

	/**
	 * 统计各级审计项孩子数设定
	 *
	 * @param childCountMap 统计各级审计项孩子数
	 */
	public void setChildCountMap(Map<String, Integer> childCountMap) {
		this.childCountMap = childCountMap;
	}

	/**
	 * 风险审计项风险程度list取得
	 * 
	 * @return 风险审计项风险程度list
	 */
	public List<CodeDetail> getRadrisklevelList() {
		return radrisklevelList;
	}

	/**
	 * 风险审计项风险程度list设定
	 *
	 * @param radrisklevelList 风险审计项风险程度list
	 */
	public void setRadrisklevelList(List<CodeDetail> radrisklevelList) {
		this.radrisklevelList = radrisklevelList;
	}

	/**
	 * 风险审计项控制频率list取得
	 * 
	 * @return 风险审计项控制频率list
	 */
	public List<CodeDetail> getRadfrequencyList() {
		return radfrequencyList;
	}

	/**
	 * 风险审计项控制频率list设定
	 *
	 * @param radfrequencyList 风险审计项控制频率list
	 */
	public void setRadfrequencyList(List<CodeDetail> radfrequencyList) {
		this.radfrequencyList = radfrequencyList;
	}

	/**
	 * 风险审计项控制手段list取得
	 * 
	 * @return 风险审计项控制手段list
	 */
	public List<CodeDetail> getRadmodeList() {
		return radmodeList;
	}

	/**
	 * 风险审计项控制手段list设定
	 *
	 * @param radmodeList 风险审计项控制手段list
	 */
	public void setRadmodeList(List<CodeDetail> radmodeList) {
		this.radmodeList = radmodeList;
	}

	/**
	 * 风险审计项控制类型list取得
	 * 
	 * @return 风险审计项控制类型list
	 */
	public List<CodeDetail> getRadtypeList() {
		return radtypeList;
	}

	/**
	 * 风险审计项控制类型list设定
	 *
	 * @param radtypeList 风险审计项控制类型list
	 */
	public void setRadtypeList(List<CodeDetail> radtypeList) {
		this.radtypeList = radtypeList;
	}

	/**
	 * 风险审计制度建设评分list取得
	 * 
	 * @return 风险审计制度建设评分list
	 */
	public List<CodeDetail> getRarplanscoreList() {
		return rarplanscoreList;
	}

	/**
	 * 风险审计制度建设评分list设定
	 *
	 * @param rarplanscoreList 风险审计制度建设评分list
	 */
	public void setRarplanscoreList(List<CodeDetail> rarplanscoreList) {
		this.rarplanscoreList = rarplanscoreList;
	}

	/**
	 * 风险审计制度执行评分list取得
	 * 
	 * @return 风险审计制度执行评分list
	 */
	public List<CodeDetail> getRarexecscoreList() {
		return rarexecscoreList;
	}

	/**
	 * 风险审计制度执行评分list设定
	 *
	 * @param rarexecscoreList 风险审计制度执行评分list
	 */
	public void setRarexecscoreList(List<CodeDetail> rarexecscoreList) {
		this.rarexecscoreList = rarexecscoreList;
	}

	/**
	 * 风险审计总体评分list取得
	 * 
	 * @return 风险审计总体评分list
	 */
	public List<CodeDetail> getRaroverallscoreList() {
		return raroverallscoreList;
	}

	/**
	 * 风险审计总体评分list设定
	 *
	 * @param raroverallscoreList 风险审计总体评分list
	 */
	public void setRaroverallscoreList(List<CodeDetail> raroverallscoreList) {
		this.raroverallscoreList = raroverallscoreList;
	}

	/**
	 * 风险审计发起信息取得
	 * 
	 * @return 风险审计发起信息
	 */
	public RiskAuditIns getRiskAuditIns() {
		return riskAuditIns;
	}

	/**
	 * 风险审计发起信息设定
	 *
	 * @param riskAuditIns 风险审计发起信息
	 */
	public void setRiskAuditIns(RiskAuditIns riskAuditIns) {
		this.riskAuditIns = riskAuditIns;
	}
	
}


