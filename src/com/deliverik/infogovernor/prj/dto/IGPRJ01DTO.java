/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
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
	 * ��Ŀ����
	 */
	protected String projectId;
	
	protected String userId;
	
	/**��Ŀ��־ID*/
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

	/** ��ť */
	protected List<String> actionnameList;
	
	/**Ԥ�㼰���̷�����Ϣ��ͼ���ݼ���*/
	protected List<Pbsummary> pbsummaryList;
	/**
	 * ��ҳBean
	 */
	protected PagingDTO pagingDto;
	
	protected int maxSearchCount;
	
	protected Map<String,List<Role>> roleMap;
	
	protected IGPRJ01HistoryVO[] historyVOs;
	
	protected List<CodeDetail> codeDetailList;

	//��Ŀ��־�����
	/**��ͬ�ܶ�*/
	protected String projectLogContractSum;
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
	/** ��ͬ���*/
	protected String plcnumber;
	/**��Ŀ��־*/
	protected String projectLogInfo;
	
	/**��־���Ϊ��ͬǩ��ʱ������Ϣ����*/
	protected List<ProjectLogContractInfo> plcList;

	/**��־���Ϊ����ʱ������Ϣ����*/
	protected List<ProjectLogBusinessInfo> plbList;
	
	protected List<IGPRJ01011VO> voList;
	
	/** Ͷ����ϸ��� */
	protected List<InvestUseInfoVW> investUseInfoList;
	
	/** ��Ŀ���� */
	protected List<CodeDetail> ppqCodeList;
	/** ��Ŀ���� */
	protected List<CodeDetail> ptypeCodeList;
	
	/** Ͷ��ʹ�����ͬ��ϸ���� */
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
	 * һ�ڽ��ȡ��
	 * @return  һ�ڽ��
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
	 * @return  ���ڽ��
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
	 * @return  ���ڽ��
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
	 * @return  ���ڽ��
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
	 * @return  ���ڽ��
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
	 * @return  ��ͬ�ܶ������
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
	 * @return  һ�ڸ�������
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
	 * @return  ���ڸ�������
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
	 * @return  ���ڸ�������
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
	 * @return  ���ڸ�������
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
	 * @return  ���ڸ�������
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
	 * ��Ŀ��־IDȡ��
	 * @return  ��Ŀ��־ID
	 */
	public Integer getPlid() {
		return plid;
	}

	/**
	 * ��Ŀ��־ID�趨
	 * @param plid ��Ŀ��־ID
	 */
	public void setPlid(Integer plid) {
		this.plid = plid;
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
	 * ��ȡigPrj0109Form
	 * @return figPrj0109Form igPrj0109Form
	 */
	public IGPRJ0109Form getIgPrj0109Form() {
		return igPrj0109Form;
	}

	/**
	 * ����igPrj0109Form
	 * @param igPrj0109Form  igPrj0109Form
	 */
	public void setIgPrj0109Form(IGPRJ0109Form igPrj0109Form) {
		this.igPrj0109Form = igPrj0109Form;
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

	/**
	 * Ͷ����ϸ���ȡ��
	 * @return investUseInfoList Ͷ����ϸ���
	 */
	public List<InvestUseInfoVW> getInvestUseInfoList() {
		return investUseInfoList;
	}

	/**
	 * Ͷ����ϸ����趨
	 * @param investUseInfoList Ͷ����ϸ���
	 */
	public void setInvestUseInfoList(List<InvestUseInfoVW> investUseInfoList) {
		this.investUseInfoList = investUseInfoList;
	}

	/**
	 * ��Ŀ����ȡ��
	 * @return ppqCodeList ��Ŀ����
	 */
	public List<CodeDetail> getPpqCodeList() {
		return ppqCodeList;
	}

	/**
	 * ��Ŀ�����趨
	 * @param ppqCodeList ��Ŀ����
	 */
	public void setPpqCodeList(List<CodeDetail> ppqCodeList) {
		this.ppqCodeList = ppqCodeList;
	}

	/**
	 * ��Ŀ����ȡ��
	 * @return ptypeCodeList ��Ŀ����
	 */
	public List<CodeDetail> getPtypeCodeList() {
		return ptypeCodeList;
	}

	/**
	 * ��Ŀ�����趨
	 * @param ptypeCodeList ��Ŀ����
	 */
	public void setPtypeCodeList(List<CodeDetail> ptypeCodeList) {
		this.ptypeCodeList = ptypeCodeList;
	}

	/**
	 * Ͷ��ʹ�����ͬ��ϸ����ȡ��
	 * @return investContractInfoList Ͷ��ʹ�����ͬ��ϸ����
	 */
	public List<InvestContractInfoVW> getInvestContractInfoList() {
		return investContractInfoList;
	}

	/**
	 * Ͷ��ʹ�����ͬ��ϸ�����趨
	 * @param investContractInfoList Ͷ��ʹ�����ͬ��ϸ����
	 */
	public void setInvestContractInfoList(
			List<InvestContractInfoVW> investContractInfoList) {
		this.investContractInfoList = investContractInfoList;
	}
}
