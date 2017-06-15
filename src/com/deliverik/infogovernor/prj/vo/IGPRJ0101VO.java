/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
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
	
	/** ��ť */
	protected List<String> actionnameList;
	
	protected List<CodeDetail> codeDetailList;
	
	/**��־���Ϊ��ͬǩ��ʱ������Ϣ����*/
	protected List<ProjectLogContractInfo> plcList;

	/**��־���Ϊ����ʱ������Ϣ����*/
	protected List<ProjectLogBusinessInfo> plbList;
	
	/**Ԥ�㼰���̷�����Ϣ��ͼ���ݼ���*/
	protected List<Pbsummary> pbsummaryList;
	
	//��Ŀ��־�����
	/**��ͬ�ܶ�*/
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

	/**һ�ڸ�����*/
	protected String projectLogBusinessFirst;
	/**���ڸ�����*/
	protected String projectLogBusinessSecond;
	/**���ڸ�����*/
	protected String projectLogBusinessThird;
	/**���ڸ�����*/
	protected String projectLogBusinessFourth;
	/**���ڸ�����*/
	protected String projectLogBusinessFifth;
	/**�Ѹ����ܶ�*/
	protected String projectLogBusinessSum;
	/**�Ѹ������*/
	protected String projectLogBusinessScale;
	/**δ�����ܶ�*/
	protected String projectLogBusinessNotsum;
	/**δ�������*/
	protected String projectLogBusinessNotscale;
	/**һ�ڽ��*/
	protected String projectLogContractFirst;
	/**���ڽ��*/
	protected String projectLogContractSecond;
	/**���ڽ��*/
	protected String projectLogContractThird;
	/**���ڽ��*/
	protected String projectLogContractFourth;
	/**���ڽ��*/
	protected String projectLogContractFifth;
	/**��ͬ�ܶ������*/
	protected String projectLogContractSumTerm;
	/**һ�ڸ�������*/
	protected String projectLogContractFirstTerm;
	/**���ڸ�������*/
	protected String projectLogContractSecondTerm;
	/**���ڸ�������*/
	protected String projectLogContractThirdTerm;
	/**���ڸ�������*/
	protected String projectLogContractFourthTerm;
	/**���ڸ�������*/
	protected String projectLogContractFifthTerm;
	/** ��ͬ���*/
	protected String plcnumber;
	/**��Ŀ��־*/
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
	 * ��ȡform
	 * @return fform form
	 */
	public IGPRJ0102Form getForm() {
		return form;
	}

	/**
	 * ����form
	 * @param form  form
	 */
	public void setForm(IGPRJ0102Form form) {
		this.form = form;
	}

	/**
	 * һ�ڽ��ȡ��
	 * @return projectLogContractFirst һ�ڽ��
	 */
	public String getProjectLogContractFirst() {
		return projectLogContractFirst;
	}

	/**
	 * һ�ڽ���趨
	 * @param projectLogContractFirst һ�ڽ��
	 */
	public void setProjectLogContractFirst(String projectLogContractFirst) {
		this.projectLogContractFirst = projectLogContractFirst;
	}

	/**
	 * ���ڽ��ȡ��
	 * @return projectLogContractSecond ���ڽ��
	 */
	public String getProjectLogContractSecond() {
		return projectLogContractSecond;
	}

	/**
	 * ���ڽ���趨
	 * @param projectLogContractSecond ���ڽ��
	 */
	public void setProjectLogContractSecond(String projectLogContractSecond) {
		this.projectLogContractSecond = projectLogContractSecond;
	}

	/**
	 * ���ڽ��ȡ��
	 * @return projectLogContractThird ���ڽ��
	 */
	public String getProjectLogContractThird() {
		return projectLogContractThird;
	}

	/**
	 * ���ڽ���趨
	 * @param projectLogContractThird ���ڽ��
	 */
	public void setProjectLogContractThird(String projectLogContractThird) {
		this.projectLogContractThird = projectLogContractThird;
	}

	/**
	 * ���ڽ��ȡ��
	 * @return projectLogContractFourth ���ڽ��
	 */
	public String getProjectLogContractFourth() {
		return projectLogContractFourth;
	}

	/**
	 * ���ڽ���趨
	 * @param projectLogContractFourth ���ڽ��
	 */
	public void setProjectLogContractFourth(String projectLogContractFourth) {
		this.projectLogContractFourth = projectLogContractFourth;
	}

	/**
	 * ���ڽ��ȡ��
	 * @return projectLogContractFifth ���ڽ��
	 */
	public String getProjectLogContractFifth() {
		return projectLogContractFifth;
	}

	/**
	 * ���ڽ���趨
	 * @param projectLogContractFifth ���ڽ��
	 */
	public void setProjectLogContractFifth(String projectLogContractFifth) {
		this.projectLogContractFifth = projectLogContractFifth;
	}

	/**
	 * ��ͬ�ܶ������ȡ��
	 * @return projectLogContractSumTerm ��ͬ�ܶ������
	 */
	public String getProjectLogContractSumTerm() {
		return projectLogContractSumTerm;
	}

	/**
	 * ��ͬ�ܶ�������趨
	 * @param projectLogContractSumTerm ��ͬ�ܶ������
	 */
	public void setProjectLogContractSumTerm(String projectLogContractSumTerm) {
		this.projectLogContractSumTerm = projectLogContractSumTerm;
	}

	/**
	 * һ�ڸ�������ȡ��
	 * @return projectLogContractFirstTerm һ�ڸ�������
	 */
	public String getProjectLogContractFirstTerm() {
		return projectLogContractFirstTerm;
	}

	/**
	 * һ�ڸ��������趨
	 * @param projectLogContractFirstTerm һ�ڸ�������
	 */
	public void setProjectLogContractFirstTerm(String projectLogContractFirstTerm) {
		this.projectLogContractFirstTerm = projectLogContractFirstTerm;
	}

	/**
	 * ���ڸ�������ȡ��
	 * @return projectLogContractSecondTerm ���ڸ�������
	 */
	public String getProjectLogContractSecondTerm() {
		return projectLogContractSecondTerm;
	}

	/**
	 * ���ڸ��������趨
	 * @param projectLogContractSecondTerm ���ڸ�������
	 */
	public void setProjectLogContractSecondTerm(String projectLogContractSecondTerm) {
		this.projectLogContractSecondTerm = projectLogContractSecondTerm;
	}

	/**
	 * ���ڸ�������ȡ��
	 * @return projectLogContractThirdTerm ���ڸ�������
	 */
	public String getProjectLogContractThirdTerm() {
		return projectLogContractThirdTerm;
	}

	/**
	 * ���ڸ��������趨
	 * @param projectLogContractThirdTerm ���ڸ�������
	 */
	public void setProjectLogContractThirdTerm(String projectLogContractThirdTerm) {
		this.projectLogContractThirdTerm = projectLogContractThirdTerm;
	}

	/**
	 * ���ڸ�������ȡ��
	 * @return projectLogContractFourthTerm ���ڸ�������
	 */
	public String getProjectLogContractFourthTerm() {
		return projectLogContractFourthTerm;
	}

	/**
	 * ���ڸ��������趨
	 * @param projectLogContractFourthTerm ���ڸ�������
	 */
	public void setProjectLogContractFourthTerm(String projectLogContractFourthTerm) {
		this.projectLogContractFourthTerm = projectLogContractFourthTerm;
	}

	/**
	 * ���ڸ�������ȡ��
	 * @return projectLogContractFifthTerm ���ڸ�������
	 */
	public String getProjectLogContractFifthTerm() {
		return projectLogContractFifthTerm;
	}

	/**
	 * ���ڸ��������趨
	 * @param projectLogContractFifthTerm ���ڸ�������
	 */
	public void setProjectLogContractFifthTerm(String projectLogContractFifthTerm) {
		this.projectLogContractFifthTerm = projectLogContractFifthTerm;
	}

	/**
	 * ��Ŀ��־ȡ��
	 * @return ��Ŀ��־
	 */
	public String getProjectLogInfo() {
		return projectLogInfo;
	}

	/**
	 * ��Ŀ��־�趨
	 * @param projectLogInfo ��Ŀ��־
	 */
	public void setProjectLogInfo(String projectLogInfo) {
		this.projectLogInfo = projectLogInfo;
	}

	/**
	 * ��־���Ϊ��ͬǩ��ʱ������Ϣ����ȡ��
	 * @return ��־���Ϊ��ͬǩ��ʱ������Ϣ����
	 */
	public List<ProjectLogContractInfo> getPlcList() {
		return plcList;
	}

	/**
	 * ��־���Ϊ��ͬǩ��ʱ������Ϣ�����趨
	 * @param plcList ��־���Ϊ��ͬǩ��ʱ������Ϣ����
	 */
	public void setPlcList(List<ProjectLogContractInfo> plcList) {
		this.plcList = plcList;
	}

	/**
	 * ��־���Ϊ����ʱ������Ϣ����ȡ��
	 * @return ��־���Ϊ����ʱ������Ϣ����
	 */
	public List<ProjectLogBusinessInfo> getPlbList() {
		return plbList;
	}

	/**
	 * ��־���Ϊ����ʱ������Ϣ�����趨
	 * @param plbList ��־���Ϊ����ʱ������Ϣ����
	 */
	public void setPlbList(List<ProjectLogBusinessInfo> plbList) {
		this.plbList = plbList;
	}
	
	/**
	 * Ԥ�㼰���̷�����Ϣ��ͼ���ݼ���ȡ��
	 * @return Ԥ�㼰���̷�����Ϣ��ͼ���ݼ���
	 */
	public List<Pbsummary> getPbsummaryList() {
		return pbsummaryList;
	}

	/**
	 * Ԥ�㼰���̷�����Ϣ��ͼ���ݼ����趨
	 * @param pbsummaryList Ԥ�㼰���̷�����Ϣ��ͼ���ݼ���
	 */
	public void setPbsummaryList(List<Pbsummary> pbsummaryList) {
		this.pbsummaryList = pbsummaryList;
	}

	/**
	 * voListȡ��
	 * @return voList voList
	 */
	public List<IGPRJ01011VO> getVoList() {
		return voList;
	}

	/**
	 * voList�趨
	 * @param voList voList
	 */
	public void setVoList(List<IGPRJ01011VO> voList) {
		this.voList = voList;
	}	

	/**
	 * ��ͬ���ȡ��
	 * @return ��ͬ���
	 */
	public String getPlcnumber() {
		return plcnumber;
	}

	/**
	 * ��ͬ����趨
	 * @param plcnumber ��ͬ���
	 */
	public void setPlcnumber(String plcnumber) {
		this.plcnumber = plcnumber;
	}
}
