/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */
package com.deliverik.infogovernor.prj.dto;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.prj.form.IGPRJ0101DetailForm;
import com.deliverik.infogovernor.prj.form.IGPRJ0101Form;
import com.deliverik.infogovernor.prj.form.IGPRJ0102Form;
import com.deliverik.infogovernor.prj.form.IGPRJ0104Form;
import com.deliverik.infogovernor.prj.form.IGPRJ0107Form;
import com.deliverik.infogovernor.prj.form.IGPRJ0109Form;
import com.deliverik.infogovernor.prj.model.InvestContractInfoVW;
import com.deliverik.infogovernor.prj.model.InvestUseInfoVW;
import com.deliverik.infogovernor.prj.model.Pbsummary;
import com.deliverik.infogovernor.prj.model.Project;
import com.deliverik.infogovernor.prj.model.ProjectLog;
import com.deliverik.infogovernor.prj.model.ProjectLogBusinessInfo;
import com.deliverik.infogovernor.prj.model.ProjectLogContractInfo;
import com.deliverik.infogovernor.prj.model.condition.ProjectLogSearchCond;
import com.deliverik.infogovernor.prj.model.condition.ProjectSearchCond;
import com.deliverik.infogovernor.prj.vo.IGPRJ01011VO;
import com.deliverik.infogovernor.prj.vo.IGPRJ01HistoryVO;

@SuppressWarnings("serial")
public class IGPRJ01DTO extends BaseDTO {
	
	/**
	 * 项目主键
	 */
	protected String projectId;
	
	protected String userId;
	
	/**项目日志ID*/
	protected Integer plid;
	
	protected String projectType;

	protected IGPRJ0101Form igprj0101Form;
	
	protected IGPRJ0102Form igPrj0102Form;
	
	protected IGPRJ0109Form igPrj0109Form;
	
	protected IGPRJ0104Form igprj0104Form;
	
	protected IGPRJ0107Form igprj0107Form;
	
	protected IGPRJ0101DetailForm IGPRJ0101DetailForm;
	
	protected Project project;
	
	protected ProjectLog projectLog;
	
	protected ProjectSearchCond projectSearchCond;
	
	protected ProjectLogSearchCond ProjectLogSearchCond;
	
	protected List<Role> roleList;
	
	protected List<String> principalList;
	
	protected User user;
	protected List<String> participantList;
	
	private List<Project> projectList;
	
	private String ptype_name;
	
	private String ptype;

	/** 按钮 */
	protected List<String> actionnameList;
	
	/**预算及工程分类信息视图数据集合*/
	protected List<Pbsummary> pbsummaryList;
	/**
	 * 分页Bean
	 */
	protected PagingDTO pagingDto;
	
	protected int maxSearchCount;
	
	protected Map<String,List<Role>> roleMap;
	
	protected IGPRJ01HistoryVO[] historyVOs;
	
	protected List<CodeDetail> codeDetailList;

	//项目日志付款表
	/**合同总额*/
	protected String projectLogContractSum;
	/**一期金额*/
	protected String projectLogContractFirst;
	/**二期金额*/
	protected String projectLogContractSecond;
	/**三期金额*/
	protected String projectLogContractThird;
	/**四期金额*/
	protected String projectLogContractFourth;
	/**五期金额*/
	protected String projectLogContractFifth;
	/**合同总额付款条件*/
	protected String projectLogContractSumTerm;
	/**一期付款条件*/
	protected String projectLogContractFirstTerm;
	/**二期付款条件*/
	protected String projectLogContractSecondTerm;
	/**三期付款条件*/
	protected String projectLogContractThirdTerm;
	/**四期付款条件*/
	protected String projectLogContractFourthTerm;
	/**五期付款条件*/
	protected String projectLogContractFifthTerm;
	/**一期付款金额*/
	protected String projectLogBusinessFirst;
	/**二期付款金额*/
	protected String projectLogBusinessSecond;
	/**三期付款金额*/
	protected String projectLogBusinessThird;
	/**四期付款金额*/
	protected String projectLogBusinessFourth;
	/**五期付款金额*/
	protected String projectLogBusinessFifth;
	/**已付款总额*/
	protected String projectLogBusinessSum;
	/**已付款比例*/
	protected String projectLogBusinessScale;
	/**未付款总额*/
	protected String projectLogBusinessNotsum;
	/**未付款比例*/
	protected String projectLogBusinessNotscale;
	/** 合同编号*/
	protected String plcnumber;
	/**项目日志*/
	protected String projectLogInfo;
	
	/**日志类别为合同签订时当条信息集合*/
	protected List<ProjectLogContractInfo> plcList;

	/**日志类别为付款时当条信息集合*/
	protected List<ProjectLogBusinessInfo> plbList;
	
	protected List<IGPRJ01011VO> voList;
	
	/** 投资明细结合 */
	protected List<InvestUseInfoVW> investUseInfoList;
	
	/** 项目性质 */
	protected List<CodeDetail> ppqCodeList;
	/** 项目类型 */
	protected List<CodeDetail> ptypeCodeList;
	
	/** 投资使用类合同明细集合 */
	protected List<InvestContractInfoVW> investContractInfoList;
	
	public String getProjectLogBusinessFirst() {
		return projectLogBusinessFirst;
	}

	public void setProjectLogBusinessFirst(String projectLogBusinessFirst) {
		this.projectLogBusinessFirst = projectLogBusinessFirst;
	}

	public String getProjectLogBusinessSecond() {
		return projectLogBusinessSecond;
	}

	public void setProjectLogBusinessSecond(String projectLogBusinessSecond) {
		this.projectLogBusinessSecond = projectLogBusinessSecond;
	}

	public String getProjectLogBusinessThird() {
		return projectLogBusinessThird;
	}

	public void setProjectLogBusinessThird(String projectLogBusinessThird) {
		this.projectLogBusinessThird = projectLogBusinessThird;
	}

	public String getProjectLogBusinessFourth() {
		return projectLogBusinessFourth;
	}

	public void setProjectLogBusinessFourth(String projectLogBusinessFourth) {
		this.projectLogBusinessFourth = projectLogBusinessFourth;
	}

	public String getProjectLogBusinessFifth() {
		return projectLogBusinessFifth;
	}

	public void setProjectLogBusinessFifth(String projectLogBusinessFifth) {
		this.projectLogBusinessFifth = projectLogBusinessFifth;
	}

	public String getProjectLogBusinessSum() {
		return projectLogBusinessSum;
	}

	public void setProjectLogBusinessSum(String projectLogBusinessSum) {
		this.projectLogBusinessSum = projectLogBusinessSum;
	}

	public String getProjectLogBusinessScale() {
		return projectLogBusinessScale;
	}

	public void setProjectLogBusinessScale(String projectLogBusinessScale) {
		this.projectLogBusinessScale = projectLogBusinessScale;
	}

	public String getProjectLogBusinessNotsum() {
		return projectLogBusinessNotsum;
	}

	public void setProjectLogBusinessNotsum(String projectLogBusinessNotsum) {
		this.projectLogBusinessNotsum = projectLogBusinessNotsum;
	}

	public String getProjectLogBusinessNotscale() {
		return projectLogBusinessNotscale;
	}

	public void setProjectLogBusinessNotscale(String projectLogBusinessNotscale) {
		this.projectLogBusinessNotscale = projectLogBusinessNotscale;
	}

	/**
	 * 一期金额取得
	 * @return  一期金额
	 */
	public String getProjectLogContractFirst() {
		return projectLogContractFirst;
	}

	/**
	 * 一期金额设定
	 * @param projectLogContractFirst 一期金额
	 */
	public void setProjectLogContractFirst(String projectLogContractFirst) {
		this.projectLogContractFirst = projectLogContractFirst;
	}

	/**
	 * 二期金额取得
	 * @return  二期金额
	 */
	public String getProjectLogContractSecond() {
		return projectLogContractSecond;
	}

	/**
	 * 二期金额设定
	 * @param projectLogContractSecond 二期金额
	 */
	public void setProjectLogContractSecond(String projectLogContractSecond) {
		this.projectLogContractSecond = projectLogContractSecond;
	}

	/**
	 * 三期金额取得
	 * @return  三期金额
	 */
	public String getProjectLogContractThird() {
		return projectLogContractThird;
	}

	/**
	 * 三期金额设定
	 * @param projectLogContractThird 三期金额
	 */
	public void setProjectLogContractThird(String projectLogContractThird) {
		this.projectLogContractThird = projectLogContractThird;
	}

	/**
	 * 四期金额取得
	 * @return  四期金额
	 */
	public String getProjectLogContractFourth() {
		return projectLogContractFourth;
	}

	/**
	 * 四期金额设定
	 * @param projectLogContractFourth 四期金额
	 */
	public void setProjectLogContractFourth(String projectLogContractFourth) {
		this.projectLogContractFourth = projectLogContractFourth;
	}

	/**
	 * 五期金额取得
	 * @return  五期金额
	 */
	public String getProjectLogContractFifth() {
		return projectLogContractFifth;
	}

	/**
	 * 五期金额设定
	 * @param projectLogContractFifth 五期金额
	 */
	public void setProjectLogContractFifth(String projectLogContractFifth) {
		this.projectLogContractFifth = projectLogContractFifth;
	}

	/**
	 * 合同总额付款条件取得
	 * @return  合同总额付款条件
	 */
	public String getProjectLogContractSumTerm() {
		return projectLogContractSumTerm;
	}

	/**
	 * 合同总额付款条件设定
	 * @param projectLogContractSumTerm 合同总额付款条件
	 */
	public void setProjectLogContractSumTerm(String projectLogContractSumTerm) {
		this.projectLogContractSumTerm = projectLogContractSumTerm;
	}

	/**
	 * 一期付款条件取得
	 * @return  一期付款条件
	 */
	public String getProjectLogContractFirstTerm() {
		return projectLogContractFirstTerm;
	}

	/**
	 * 一期付款条件设定
	 * @param projectLogContractFirstTerm 一期付款条件
	 */
	public void setProjectLogContractFirstTerm(String projectLogContractFirstTerm) {
		this.projectLogContractFirstTerm = projectLogContractFirstTerm;
	}

	/**
	 * 二期付款条件取得
	 * @return  二期付款条件
	 */
	public String getProjectLogContractSecondTerm() {
		return projectLogContractSecondTerm;
	}

	/**
	 * 二期付款条件设定
	 * @param projectLogContractSecondTerm 二期付款条件
	 */
	public void setProjectLogContractSecondTerm(String projectLogContractSecondTerm) {
		this.projectLogContractSecondTerm = projectLogContractSecondTerm;
	}

	/**
	 * 三期付款条件取得
	 * @return  三期付款条件
	 */
	public String getProjectLogContractThirdTerm() {
		return projectLogContractThirdTerm;
	}

	/**
	 * 三期付款条件设定
	 * @param projectLogContractThirdTerm 三期付款条件
	 */
	public void setProjectLogContractThirdTerm(String projectLogContractThirdTerm) {
		this.projectLogContractThirdTerm = projectLogContractThirdTerm;
	}

	/**
	 * 四期付款条件取得
	 * @return  四期付款条件
	 */
	public String getProjectLogContractFourthTerm() {
		return projectLogContractFourthTerm;
	}

	/**
	 * 四期付款条件设定
	 * @param projectLogContractFourthTerm 四期付款条件
	 */
	public void setProjectLogContractFourthTerm(String projectLogContractFourthTerm) {
		this.projectLogContractFourthTerm = projectLogContractFourthTerm;
	}

	/**
	 * 五期付款条件取得
	 * @return  五期付款条件
	 */
	public String getProjectLogContractFifthTerm() {
		return projectLogContractFifthTerm;
	}

	/**
	 * 五期付款条件设定
	 * @param projectLogContractFifthTerm 五期付款条件
	 */
	public void setProjectLogContractFifthTerm(String projectLogContractFifthTerm) {
		this.projectLogContractFifthTerm = projectLogContractFifthTerm;
	}

	public Map<String, List<Role>> getRoleMap() {
		return roleMap;
	}

	public void setRoleMap(Map<String, List<Role>> roleMap) {
		this.roleMap = roleMap;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public IGPRJ0107Form getIgprj0107Form() {
		return igprj0107Form;
	}

	public void setIgprj0107Form(IGPRJ0107Form igprj0107Form) {
		this.igprj0107Form = igprj0107Form;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	public List<String> getParticipantList() {
		return participantList;
	}

	public void setParticipantList(List<String> participantList) {
		this.participantList = participantList;
	}

	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	public ProjectLogSearchCond getProjectLogSearchCond() {
		return ProjectLogSearchCond;
	}

	public void setProjectLogSearchCond(ProjectLogSearchCond projectLogSearchCond) {
		ProjectLogSearchCond = projectLogSearchCond;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public IGPRJ0102Form getIgPrj0102Form() {
		return igPrj0102Form;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setIgPrj0102Form(IGPRJ0102Form igPrj0102Form) {
		this.igPrj0102Form = igPrj0102Form;
	}
	
	public ProjectLog getProjectLog() {
		return projectLog;
	}

	public void setProjectLog(ProjectLog projectLog) {
		this.projectLog = projectLog;
	}

	public ProjectSearchCond getProjectSearchCond() {
		return projectSearchCond;
	}

	public void setProjectSearchCond(ProjectSearchCond projectSearchCond) {
		this.projectSearchCond = projectSearchCond;
	}
	
	public IGPRJ0101Form getIgprj0101Form() {
		return igprj0101Form;
	}

	public void setIgprj0101Form(IGPRJ0101Form igprj0101Form) {
		this.igprj0101Form = igprj0101Form;
	}
	
	public IGPRJ0101DetailForm getIGPRJ0101DetailForm() {
		return IGPRJ0101DetailForm;
	}

	public void setIGPRJ0101DetailForm(IGPRJ0101DetailForm detailForm) {
		IGPRJ0101DetailForm = detailForm;
	}

	public IGPRJ0104Form getIgprj0104Form() {
		return igprj0104Form;
	}

	public void setIgprj0104Form(IGPRJ0104Form igprj0104Form) {
		this.igprj0104Form = igprj0104Form;
	}

	public List<String> getPrincipalList() {
		return principalList;
	}

	public void setPrincipalList(List<String> principalList) {
		this.principalList = principalList;
	}

	public List<Project> getProjectList() {
		return projectList;
	}

	public void setProjectList(List<Project> projectList) {
		this.projectList = projectList;
	}

	public String getPtype_name() {
		return ptype_name;
	}

	public void setPtype_name(String ptype_name) {
		this.ptype_name = ptype_name;
	}

	public String getPtype() {
		return ptype;
	}

	public void setPtype(String ptype) {
		this.ptype = ptype;
	}

	public List<String> getActionnameList() {
		return actionnameList;
	}

	public void setActionnameList(List<String> actionnameList) {
		this.actionnameList = actionnameList;
	}

	public IGPRJ01HistoryVO[] getHistoryVOs() {
		return historyVOs;
	}

	public void setHistoryVOs(IGPRJ01HistoryVO[] historyVOs) {
		this.historyVOs = historyVOs;
	}
	
	public List<CodeDetail> getCodeDetailList() {
		return codeDetailList;
	}

	public void setCodeDetailList(List<CodeDetail> codeDetailList) {
		this.codeDetailList = codeDetailList;
	}

	public String getProjectType() {
		return projectType;
	}

	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}

	public String getProjectLogContractSum() {
		return projectLogContractSum;
	}

	public void setProjectLogContractSum(String projectLogContractSum) {
		this.projectLogContractSum = projectLogContractSum;
	}

	/**
	 * 项目日志取得
	 * @return 项目日志
	 */
	public String getProjectLogInfo() {
		return projectLogInfo;
	}

	/**
	 * 项目日志设定
	 * @param projectLogInfo 项目日志
	 */
	public void setProjectLogInfo(String projectLogInfo) {
		this.projectLogInfo = projectLogInfo;
	}

	/**
	 * 项目日志ID取得
	 * @return  项目日志ID
	 */
	public Integer getPlid() {
		return plid;
	}

	/**
	 * 项目日志ID设定
	 * @param plid 项目日志ID
	 */
	public void setPlid(Integer plid) {
		this.plid = plid;
	}

	/**
	 * 日志类别为合同签订时当条信息集合取得
	 * @return 日志类别为合同签订时当条信息集合
	 */
	public List<ProjectLogContractInfo> getPlcList() {
		return plcList;
	}

	/**
	 * 日志类别为合同签订时当条信息集合设定
	 * @param plcList 日志类别为合同签订时当条信息集合
	 */
	public void setPlcList(List<ProjectLogContractInfo> plcList) {
		this.plcList = plcList;
	}

	/**
	 * 日志类别为付款时当条信息集合取得
	 * @return 日志类别为付款时当条信息集合
	 */
	public List<ProjectLogBusinessInfo> getPlbList() {
		return plbList;
	}

	/**
	 * 日志类别为付款时当条信息集合设定
	 * @param plbList 日志类别为付款时当条信息集合
	 */
	public void setPlbList(List<ProjectLogBusinessInfo> plbList) {
		this.plbList = plbList;
	}

	/**
	 * 获取igPrj0109Form
	 * @return figPrj0109Form igPrj0109Form
	 */
	public IGPRJ0109Form getIgPrj0109Form() {
		return igPrj0109Form;
	}

	/**
	 * 设置igPrj0109Form
	 * @param igPrj0109Form  igPrj0109Form
	 */
	public void setIgPrj0109Form(IGPRJ0109Form igPrj0109Form) {
		this.igPrj0109Form = igPrj0109Form;
	}

	/**
	 * 预算及工程分类信息视图数据集合取得
	 * @return 预算及工程分类信息视图数据集合
	 */
	public List<Pbsummary> getPbsummaryList() {
		return pbsummaryList;
	}

	/**
	 * 预算及工程分类信息视图数据集合设定
	 * @param pbsummaryList 预算及工程分类信息视图数据集合
	 */
	public void setPbsummaryList(List<Pbsummary> pbsummaryList) {
		this.pbsummaryList = pbsummaryList;
	}

	/**
	 * voList取得
	 * @return voList voList
	 */
	public List<IGPRJ01011VO> getVoList() {
		return voList;
	}

	/**
	 * voList设定
	 * @param voList voList
	 */
	public void setVoList(List<IGPRJ01011VO> voList) {
		this.voList = voList;
	}
	/**
	 * 合同编号取得
	 * @return 合同编号
	 */
	public String getPlcnumber() {
		return plcnumber;
	}

	/**
	 * 合同编号设定
	 * @param plcnumber 合同编号
	 */
	public void setPlcnumber(String plcnumber) {
		this.plcnumber = plcnumber;
	}

	/**
	 * 投资明细结合取得
	 * @return investUseInfoList 投资明细结合
	 */
	public List<InvestUseInfoVW> getInvestUseInfoList() {
		return investUseInfoList;
	}

	/**
	 * 投资明细结合设定
	 * @param investUseInfoList 投资明细结合
	 */
	public void setInvestUseInfoList(List<InvestUseInfoVW> investUseInfoList) {
		this.investUseInfoList = investUseInfoList;
	}

	/**
	 * 项目性质取得
	 * @return ppqCodeList 项目性质
	 */
	public List<CodeDetail> getPpqCodeList() {
		return ppqCodeList;
	}

	/**
	 * 项目性质设定
	 * @param ppqCodeList 项目性质
	 */
	public void setPpqCodeList(List<CodeDetail> ppqCodeList) {
		this.ppqCodeList = ppqCodeList;
	}

	/**
	 * 项目类型取得
	 * @return ptypeCodeList 项目类型
	 */
	public List<CodeDetail> getPtypeCodeList() {
		return ptypeCodeList;
	}

	/**
	 * 项目类型设定
	 * @param ptypeCodeList 项目类型
	 */
	public void setPtypeCodeList(List<CodeDetail> ptypeCodeList) {
		this.ptypeCodeList = ptypeCodeList;
	}

	/**
	 * 投资使用类合同明细集合取得
	 * @return investContractInfoList 投资使用类合同明细集合
	 */
	public List<InvestContractInfoVW> getInvestContractInfoList() {
		return investContractInfoList;
	}

	/**
	 * 投资使用类合同明细集合设定
	 * @param investContractInfoList 投资使用类合同明细集合
	 */
	public void setInvestContractInfoList(
			List<InvestContractInfoVW> investContractInfoList) {
		this.investContractInfoList = investContractInfoList;
	}
}
