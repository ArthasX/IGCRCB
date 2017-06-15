/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */
package com.deliverik.infogovernor.prj.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.infogovernor.prj.form.IGPRJ0102Form;
import com.deliverik.infogovernor.prj.model.Pbsummary;
import com.deliverik.infogovernor.prj.model.Project;
import com.deliverik.infogovernor.prj.model.ProjectLogBusinessInfo;
import com.deliverik.infogovernor.prj.model.ProjectLogContractInfo;

public class IGPRJ0101VO extends BaseVO{
	
	private static final long serialVersionUID = -3333005832071788684L;

	private Project project;
	
	private IGPRJ0102Form form;
	
	private List<Project> projectList;
	
	/** 按钮 */
	protected List<String> actionnameList;
	
	protected List<CodeDetail> codeDetailList;
	
	/**日志类别为合同签订时当条信息集合*/
	protected List<ProjectLogContractInfo> plcList;

	/**日志类别为付款时当条信息集合*/
	protected List<ProjectLogBusinessInfo> plbList;
	
	/**预算及工程分类信息视图数据集合*/
	protected List<Pbsummary> pbsummaryList;
	
	//项目日志付款表
	/**合同总额*/
	protected String projectLogContractSum;
	
	protected List<IGPRJ01011VO> voList;
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
	/** 合同编号*/
	protected String plcnumber;
	/**项目日志*/
	protected String projectLogInfo;
	
	public String getProjectLogContractSum() {
		return projectLogContractSum;
	}

	public void setProjectLogContractSum(String projectLogContractSum) {
		this.projectLogContractSum = projectLogContractSum;
	}

	public List<String> getActionnameList() {
		return actionnameList;
	}

	public void setActionnameList(List<String> actionnameList) {
		this.actionnameList = actionnameList;
	}

	public List<Project> getProjectList() {
		return projectList;
	}

	public void setProjectList(List<Project> projectList) {
		this.projectList = projectList;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
	
	public List<CodeDetail> getCodeDetailList() {
		return codeDetailList;
	}

	public void setCodeDetailList(List<CodeDetail> codeDetailList) {
		this.codeDetailList = codeDetailList;
	}

	/**
	 * 获取form
	 * @return fform form
	 */
	public IGPRJ0102Form getForm() {
		return form;
	}

	/**
	 * 设置form
	 * @param form  form
	 */
	public void setForm(IGPRJ0102Form form) {
		this.form = form;
	}

	/**
	 * 一期金额取得
	 * @return projectLogContractFirst 一期金额
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
	 * @return projectLogContractSecond 二期金额
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
	 * @return projectLogContractThird 三期金额
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
	 * @return projectLogContractFourth 四期金额
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
	 * @return projectLogContractFifth 五期金额
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
	 * @return projectLogContractSumTerm 合同总额付款条件
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
	 * @return projectLogContractFirstTerm 一期付款条件
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
	 * @return projectLogContractSecondTerm 二期付款条件
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
	 * @return projectLogContractThirdTerm 三期付款条件
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
	 * @return projectLogContractFourthTerm 四期付款条件
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
	 * @return projectLogContractFifthTerm 五期付款条件
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
}
