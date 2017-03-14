package com.deliverik.infogovernor.ven.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.model.Attachment;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserInfo;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.infogovernor.risk.model.CheckWorkResultInfo;
import com.deliverik.infogovernor.risk.model.RiskAuditDef;
import com.deliverik.infogovernor.risk.model.RiskCheck;
import com.deliverik.infogovernor.risk.model.RiskCheckResult;
import com.deliverik.infogovernor.ven.form.IGVEN0101Form;
import com.deliverik.infogovernor.ven.form.IGVEN0102Form;
import com.deliverik.infogovernor.ven.form.IGVEN0103Form;
import com.deliverik.infogovernor.ven.model.RiskStrategyInfo;
import com.deliverik.infogovernor.ven.vo.IGVEN01022VO;

/**
 * ���ռ��DTO
 * 
 */
@SuppressWarnings("serial")
public class IGVEN01DTO extends BaseDTO implements Serializable{

	/** ���ռ����Ϣ������� */
	protected List<RiskCheck> riskCheckDataList;
	/** ������Ϣ���� */
	protected List<IG500Info> processList;
	/** ���ռ������Ϣ������� */
	protected List<RiskCheckResult> riskCheckResultDataList;
	
	protected List<RiskCheck> riskCheckList;
	
	protected List<CheckWorkResultInfo> checkWorkResultInfos;
	
	protected List<RiskStrategyInfo> riskStrategyList;
	
	/** ����������� */
	protected IGVEN0101Form igven0101Form;
	
	/** ������Ϣ */
	protected Map<IG333Info, Map<Role, List<UserInfo>>> assignInfo;
	
	/** �������󼶴� */
	protected Integer radMaxLevel;
	
	/** ������list */
	protected List<Integer> radMaxLevelList;
	
	/** �����������Ϣ��������� */
	protected List<RiskAuditDef> riskAuditDefList;
	
	protected IGVEN0102Form igVEN0102Form;

	protected RiskStrategyInfo RiskStrategyInfo;
	
	protected Integer raid;
	
	protected Integer rcid;
	
	protected List<String> eiids ;
	
	protected List<String> eiversions;
	
	protected Integer csid;
	
	protected Integer cwrid; 
	
	protected Integer rcrid;
	
	protected Map<String, List<RiskCheck>> riskCheckmap;
	
	protected Map<Integer,String> mapType;
	
	/** �ʲ�id����*/
	protected List<Integer> eiidList;
	
	
	/** �ʲ��汾����*/
	protected List<Integer> eiVersionList;
	
	/** ���ռ����Ա��ʽ�Ľ�����Ϣ */
	protected String cronInfo;
	
	/** ���ռ����Ϣ�������� */
	protected List<Attachment> attachmentList;
	
	protected User user;
	
	/** ת�ش���ҳ */
	protected String goToError;
	
	/**
	 * �����ѯ������¼��
	 */
	
	protected int maxSearchCount;

	/**
	 * ��ҳBean
	 */
	
	protected PagingDTO pagingDto;
	
	/**Ƶ�������ڼ���*/
	protected List<IGVEN01022VO> weekList;
	
	/**Ƶ������������*/
	protected List<IGVEN01022VO> monthList;
	
	 /**�´�ִ��ʱ��*/
    protected String nextFireTime;
    
    /** ���ռ��FORM*/
    protected IGVEN0103Form igVEN0103Form;

    /**
	 * @return the raid
	 */
	public Integer getRaid() {
		return raid;
	}

	/**
	 * @param raid the raid to set
	 */
	public void setRaid(Integer raid) {
		this.raid = raid;
	}

	/**
	 * ���ռ��FORMȡ��
	 * @return the igVEN0103Form
	 */
	public IGVEN0103Form getIgVEN0103Form() {
		return igVEN0103Form;
	}

	/**
	 * ���ռ��FORM�趨
	 * @param igVEN0103Form the ���ռ��FORM
	 */
	public void setIgVEN0103Form(IGVEN0103Form igVEN0103Form) {
		this.igVEN0103Form = igVEN0103Form;
	}

	/**
	 * @return the cwrid
	 */
	public Integer getCwrid() {
		return cwrid;
	}

	/**
	 * @param cwrid the cwrid to set
	 */
	public void setCwrid(Integer cwrid) {
		this.cwrid = cwrid;
	}

	/**
	 * @return the checkWorkResultInfos
	 */
	public List<CheckWorkResultInfo> getCheckWorkResultInfos() {
		return checkWorkResultInfos;
	}

	/**
	 * @param checkWorkResultInfos the checkWorkResultInfos to set
	 */
	public void setCheckWorkResultInfos(
			List<CheckWorkResultInfo> checkWorkResultInfos) {
		this.checkWorkResultInfos = checkWorkResultInfos;
	}

	/**
	 * @return the riskCheckList
	 */
	public List<RiskCheck> getRiskCheckList() {
		return riskCheckList;
	}

	/**
	 * @param riskCheckList the riskCheckList to set
	 */
	public void setRiskCheckList(List<RiskCheck> riskCheckList) {
		this.riskCheckList = riskCheckList;
	}

	/**
	 * @return the riskAuditDefList
	 */
	public List<RiskAuditDef> getRiskAuditDefList() {
		return riskAuditDefList;
	}

	/**
	 * @param riskAuditDefList the riskAuditDefList to set
	 */
	public void setRiskAuditDefList(List<RiskAuditDef> riskAuditDefList) {
		this.riskAuditDefList = riskAuditDefList;
	}

	/**
	 * @return the radMaxLevel
	 */
	public Integer getRadMaxLevel() {
		return radMaxLevel;
	}

	/**
	 * @return the radMaxLevelList
	 */
	public List<Integer> getRadMaxLevelList() {
		return radMaxLevelList;
	}

	/**
	 * @param radMaxLevel the radMaxLevel to set
	 */
	public void setRadMaxLevel(Integer radMaxLevel) {
		this.radMaxLevel = radMaxLevel;
	}

	/**
	 * @param radMaxLevelList the radMaxLevelList to set
	 */
	public void setRadMaxLevelList(List<Integer> radMaxLevelList) {
		this.radMaxLevelList = radMaxLevelList;
	}

	

	public IGVEN0101Form getIgven0101Form() {
		return igven0101Form;
	}

	public void setIgven0101Form(IGVEN0101Form igven0101Form) {
		this.igven0101Form = igven0101Form;
	}

	/**
	 * @return the goToError
	 */
	public String getGoToError() {
		return goToError;
	}

	/**
	 * @param goToError the goToError to set
	 */
	public void setGoToError(String goToError) {
		this.goToError = goToError;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the rcrid
	 */
	public Integer getRcrid() {
		return rcrid;
	}

	/**
	 * @param rcrid the rcrid to set
	 */
	public void setRcrid(Integer rcrid) {
		this.rcrid = rcrid;
	}

	/**
	 * @return the riskCheckResultDataList
	 */
	public List<RiskCheckResult> getRiskCheckResultDataList() {
		return riskCheckResultDataList;
	}

	/**
	 * @param riskCheckResultDataList the riskCheckResultDataList to set
	 */
	public void setRiskCheckResultDataList(
			List<RiskCheckResult> riskCheckResultDataList) {
		this.riskCheckResultDataList = riskCheckResultDataList;
	}



	/**
	 * @return the cronInfo
	 */
	public String getCronInfo() {
		return cronInfo;
	}

	/**
	 * @param cronInfo the cronInfo to set
	 */
	public void setCronInfo(String cronInfo) {
		this.cronInfo = cronInfo;
	}

	/**
	 * @return the attachmentList
	 */
	public List<Attachment> getAttachmentList() {
		return attachmentList;
	}

	/**
	 * @param attachmentList the attachmentList to set
	 */
	public void setAttachmentList(List<Attachment> attachmentList) {
		this.attachmentList = attachmentList;
	}

	/**
	 * @return the riskCheckDataList
	 */
	public List<RiskCheck> getRiskCheckDataList() {
		return riskCheckDataList;
	}

	/**
	 * @param riskCheckDataList the riskCheckDataList to set
	 */
	public void setRiskCheckDataList(List<RiskCheck> riskCheckDataList) {
		this.riskCheckDataList = riskCheckDataList;
	}

	/**
	 * @return the maxSearchCount
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * @return the pagingDto
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * @param maxSearchCount the maxSearchCount to set
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * @param pagingDto the pagingDto to set
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	/**
	 * @return the rcid
	 */
	public Integer getRcid() {
		return rcid;
	}

	/**
	 * @param rcid the rcid to set
	 */
	public void setRcid(Integer rcid) {
		this.rcid = rcid;
	}



	public List<IGVEN01022VO> getWeekList() {
		return weekList;
	}

	
	/**
	 * @return the eiids
	 */
	public List<String> getEiids() {
		return eiids;
	}

	/**
	 * @param eiids the eiids to set
	 */
	public void setEiids(List<String> eiids) {
		this.eiids = eiids;
	}

	/**
	 * @return the eiversions
	 */
	public List<String> getEiversions() {
		return eiversions;
	}

	/**
	 * @param eiversions the eiversions to set
	 */
	public void setEiversions(List<String> eiversions) {
		this.eiversions = eiversions;
	}

	public void setWeekList(List<IGVEN01022VO> weekList) {
		this.weekList = weekList;
	}

	public List<IGVEN01022VO> getMonthList() {
		return monthList;
	}

	public void setMonthList(List<IGVEN01022VO> monthList) {
		this.monthList = monthList;
	}

	/**
	 * �´�ִ��ʱ��ȡ��
	 * @return �´�ִ��ʱ��
	 */
	public String getNextFireTime() {
		return nextFireTime;
	}

	/**
	 * �´�ִ��ʱ���趨
	 * @param nextFireTime �´�ִ��ʱ��
	 */
	public void setNextFireTime(String nextFireTime) {
		this.nextFireTime = nextFireTime;
	}


	public RiskStrategyInfo getRiskStrategyInfo() {
		return RiskStrategyInfo;
	}

	public void setRiskStrategyInfo(RiskStrategyInfo riskStrategyInfo) {
		RiskStrategyInfo = riskStrategyInfo;
	}

	/**
	 * @return the csid
	 */
	public Integer getCsid() {
		return csid;
	}

	/**
	 * @param csid the csid to set
	 */
	public void setCsid(Integer csid) {
		this.csid = csid;
	}

	/**
	 * @return the eiidList
	 */
	public List<Integer> getEiidList() {
		return eiidList;
	}


	/**
	 * @param eiidList the eiidList to set
	 */
	public void setEiidList(List<Integer> eiidList) {
		this.eiidList = eiidList;
	}

	/**
	 * @return the eiVersionList
	 */
	public List<Integer> getEiVersionList() {
		return eiVersionList;
	}

	/**
	 * @param eiVersionList the eiVersionList to set
	 */
	public void setEiVersionList(List<Integer> eiVersionList) {
		this.eiVersionList = eiVersionList;
	}

	/**
	 * @return the riskCheckmap
	 */
	public Map<String, List<RiskCheck>> getRiskCheckmap() {
		return riskCheckmap;
	}

	/**
	 * @param riskCheckmap the riskCheckmap to set
	 */
	public void setRiskCheckmap(Map<String, List<RiskCheck>> riskCheckmap) {
		this.riskCheckmap = riskCheckmap;
	}

	/**
	 * @return the mapType
	 */
	public Map<Integer, String> getMapType() {
		return mapType;
	}

	/**
	 * @param mapType the mapType to set
	 */
	public void setMapType(Map<Integer, String> mapType) {
		this.mapType = mapType;
	}

	/**
	 * @return the processList
	 */
	public List<IG500Info> getProcessList() {
		return processList;
	}

	/**
	 * @param processList the processList to set
	 */
	public void setProcessList(List<IG500Info> processList) {
		this.processList = processList;
	}

	/**
	 * @return the assignInfo
	 */
	public Map<IG333Info, Map<Role, List<UserInfo>>> getAssignInfo() {
		return assignInfo;
	}

	/**
	 * @param assignInfo the assignInfo to set
	 */
	public void setAssignInfo(Map<IG333Info, Map<Role, List<UserInfo>>> assignInfo) {
		this.assignInfo = assignInfo;
	}

	public IGVEN0102Form getIgVEN0102Form() {
		return igVEN0102Form;
	}

	public void setIgVEN0102Form(IGVEN0102Form igVEN0102Form) {
		this.igVEN0102Form = igVEN0102Form;
	}

	public List<RiskStrategyInfo> getRiskStrategyList() {
		return riskStrategyList;
	}

	public void setRiskStrategyList(List<RiskStrategyInfo> riskStrategyList) {
		this.riskStrategyList = riskStrategyList;
	}

	
	
}


