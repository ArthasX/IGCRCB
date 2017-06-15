package com.deliverik.infogovernor.ven.dto;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.ven.form.IGVEN0201Form;
import com.deliverik.infogovernor.ven.form.IGVEN0202Form;
import com.deliverik.infogovernor.ven.form.IGVEN0203Form;
import com.deliverik.infogovernor.ven.model.MonitoringWorkInfo;
import com.deliverik.infogovernor.ven.model.RiskMonitoringInfo;

/**
 * ���ռ��DTO
 * 
 */
@SuppressWarnings("serial")
public class IGVEN02DTO extends BaseDTO implements Serializable{

	/** ���ռ�� ����  */	
	protected List<RiskMonitoringInfo> riskMonitoringInfos;
	
	/** ���ռ�⹤�� ����  */	
	protected List<MonitoringWorkInfo> monitoringWorkInfos;

	protected User user;
	
	/**
	 * �����ѯ������¼��
	 */
	protected int maxSearchCount;

	/**
	 * ��ҳBean
	 */
	protected PagingDTO pagingDto;
	
	/** ת�ش���ҳ */
	protected String goToError;
	
	/** ���ռ�����FORM  */	
	protected IGVEN0201Form igVEN0201Form;
	
	/** ���ռ������  */	
	protected IGVEN0202Form igVEN0202Form;
	
	/** ���ռ������  */	
	protected IGVEN0203Form igVEN0203Form;
	
	//-------------------------------------------------------------
	
//	/** ���ռ����Ϣ������� */
//	protected List<RiskCheck> riskCheckDataList;
//	/** ������Ϣ���� */
//	protected List<IG500Info> processList;
//	/** ���ռ������Ϣ������� */
//	protected List<RiskCheckResult> riskCheckResultDataList;
//	
//	protected List<RiskCheck> riskCheckList;
//	
//	
//	protected List<CheckStrategyInfo> checkStrategyList;
//	
//	protected CheckStrategyInfo checkInfo;
//	/** ����������� */
//	protected IGRIS0104Form igRIS0104Form;
//	
//	/** ������Ϣ */
//	protected Map<IG333Info, Map<Role, List<UserInfo>>> assignInfo;
//	
//	/** �������󼶴� */
//	protected Integer radMaxLevel;
//	
//	/** ������list */
//	protected List<Integer> radMaxLevelList;
//	
//	/** �����������Ϣ��������� */
//	protected List<RiskAuditDef> riskAuditDefList;
//	
//	protected IGRIS0201Form igRIS0201Form;
//	
//	protected IGRIS0202Form igRIS0202Form;
//	
//	protected IGRIS0203Form igRIS0203Form;
//	
//	protected IGRIS0204Form igRIS0204Form;
//	

//	
//	protected IGRIS0206Form igRIS0206Form;
//
//	protected RiskCheck riskCheck;
//	
//	protected RiskCheckResult riskCheckResult;
//	
//	protected CheckStrategyInfo checkStrategyInfo;
//	
//	protected Integer raid;
//	
//	protected Integer rcid;
//	
//	protected List<String> eiids ;
//	
//	protected List<String> eiversions;
//	
//	protected Integer csid;
//	
//	protected Integer cwrid; 
//	
//	protected Integer rcrid;
//	
//	protected Map<String, List<RiskCheck>> riskCheckmap;
//	
//	protected Map<Integer,String> mapType;
//	
//	/** �ʲ�id����*/
//	protected List<Integer> eiidList;
//	
//	
//	/** �ʲ��汾����*/
//	protected List<Integer> eiVersionList;
//	
//	/** ���ռ����Ա��ʽ�Ľ�����Ϣ */
//	protected String cronInfo;
//	
//	/** ���ռ����Ϣ�������� */
//	protected List<Attachment> attachmentList;
//	
//	protected User user;
//	
//	/** ת�ش���ҳ */
//	protected String goToError;

//	
//	/**Ƶ�������ڼ���*/
//	protected List<IGRIS02022VO> weekList;
//	
//	/**Ƶ������������*/
//	protected List<IGRIS02022VO> monthList;
//	
//	 /**�´�ִ��ʱ��*/
//    protected String nextFireTime;
//    
//    //�������б�
//    protected List<CheckorgInfo> lst_checkorg;
//	
//	
//	public List<CheckorgInfo> getLst_checkorg() {
//        return lst_checkorg;
//    }
//
//    public void setLst_checkorg(List<CheckorgInfo> lst_checkorg) {
//        this.lst_checkorg = lst_checkorg;
//    }
//
//    /**
//	 * @return the raid
//	 */
//	public Integer getRaid() {
//		return raid;
//	}
//
//	/**
//	 * @param raid the raid to set
//	 */
//	public void setRaid(Integer raid) {
//		this.raid = raid;
//	}
//
//	
//
//	/**
//	 * @return the cwrid
//	 */
//	public Integer getCwrid() {
//		return cwrid;
//	}
//
//	/**
//	 * @param cwrid the cwrid to set
//	 */
//	public void setCwrid(Integer cwrid) {
//		this.cwrid = cwrid;
//	}
//
//
//	/**
//	 * @return the riskCheckList
//	 */
//	public List<RiskCheck> getRiskCheckList() {
//		return riskCheckList;
//	}
//
//	
//	/**
//	 * @return the checkStrategyList
//	 */
//	public List<CheckStrategyInfo> getCheckStrategyList() {
//		return checkStrategyList;
//	}
//
//	/**
//	 * @param checkStrategyList the checkStrategyList to set
//	 */
//	public void setCheckStrategyList(List<CheckStrategyInfo> checkStrategyList) {
//		this.checkStrategyList = checkStrategyList;
//	}
//
//	/**
//	 * @param riskCheckList the riskCheckList to set
//	 */
//	public void setRiskCheckList(List<RiskCheck> riskCheckList) {
//		this.riskCheckList = riskCheckList;
//	}
//
//	/**
//	 * @return the riskAuditDefList
//	 */
//	public List<RiskAuditDef> getRiskAuditDefList() {
//		return riskAuditDefList;
//	}
//
//	/**
//	 * @param riskAuditDefList the riskAuditDefList to set
//	 */
//	public void setRiskAuditDefList(List<RiskAuditDef> riskAuditDefList) {
//		this.riskAuditDefList = riskAuditDefList;
//	}
//
//	/**
//	 * @return the radMaxLevel
//	 */
//	public Integer getRadMaxLevel() {
//		return radMaxLevel;
//	}
//
//	/**
//	 * @return the radMaxLevelList
//	 */
//	public List<Integer> getRadMaxLevelList() {
//		return radMaxLevelList;
//	}
//
//	/**
//	 * @param radMaxLevel the radMaxLevel to set
//	 */
//	public void setRadMaxLevel(Integer radMaxLevel) {
//		this.radMaxLevel = radMaxLevel;
//	}
//
//	/**
//	 * @param radMaxLevelList the radMaxLevelList to set
//	 */
//	public void setRadMaxLevelList(List<Integer> radMaxLevelList) {
//		this.radMaxLevelList = radMaxLevelList;
//	}
//
//	
//
//	/**
//	 * @return the igRIS0104Form
//	 */
//	public IGRIS0104Form getIgRIS0104Form() {
//		return igRIS0104Form;
//	}
//	
//
//	/**
//	 * @return the checkInfo
//	 */
//	public CheckStrategyInfo getCheckInfo() {
//		return checkInfo;
//	}
//
//	/**
//	 * @param checkInfo the checkInfo to set
//	 */
//	public void setCheckInfo(CheckStrategyInfo checkInfo) {
//		this.checkInfo = checkInfo;
//	}
//
//	/**
//	 * @param igRIS0104Form the igRIS0104Form to set
//	 */
//	public void setIgRIS0104Form(IGRIS0104Form igRIS0104Form) {
//		this.igRIS0104Form = igRIS0104Form;
//	}
//
//	/**
//	 * @return the igRIS0206Form
//	 */
//	public IGRIS0206Form getIgRIS0206Form() {
//		return igRIS0206Form;
//	}
//
//	/**
//	 * @param igRIS0206Form the igRIS0206Form to set
//	 */
//	public void setIgRIS0206Form(IGRIS0206Form igRIS0206Form) {
//		this.igRIS0206Form = igRIS0206Form;
//	}
//
//	/**
//	 * @return the igRIS0204Form
//	 */
//	public IGRIS0204Form getIgRIS0204Form() {
//		return igRIS0204Form;
//	}
//
//	/**
//	 * @param igRIS0204Form the igRIS0204Form to set
//	 */
//	public void setIgRIS0204Form(IGRIS0204Form igRIS0204Form) {
//		this.igRIS0204Form = igRIS0204Form;
//	}
//
//	/**
//	 * @return the goToError
//	 */
//	public String getGoToError() {
//		return goToError;
//	}
//
//	/**
//	 * @param goToError the goToError to set
//	 */
//	public void setGoToError(String goToError) {
//		this.goToError = goToError;
//	}
//
//	/**
//	 * @return the user
//	 */
//	public User getUser() {
//		return user;
//	}
//
//	/**
//	 * @param user the user to set
//	 */
//	public void setUser(User user) {
//		this.user = user;
//	}
//
//	/**
//	 * @return the rcrid
//	 */
//	public Integer getRcrid() {
//		return rcrid;
//	}
//
//	/**
//	 * @param rcrid the rcrid to set
//	 */
//	public void setRcrid(Integer rcrid) {
//		this.rcrid = rcrid;
//	}
//
//	/**
//	 * @return the riskCheckResultDataList
//	 */
//	public List<RiskCheckResult> getRiskCheckResultDataList() {
//		return riskCheckResultDataList;
//	}
//
//	/**
//	 * @param riskCheckResultDataList the riskCheckResultDataList to set
//	 */
//	public void setRiskCheckResultDataList(
//			List<RiskCheckResult> riskCheckResultDataList) {
//		this.riskCheckResultDataList = riskCheckResultDataList;
//	}
//
//	/**
//	 * @return the riskCheckResult
//	 */
//	public RiskCheckResult getRiskCheckResult() {
//		return riskCheckResult;
//	}
//
//	/**
//	 * @param riskCheckResult the riskCheckResult to set
//	 */
//	public void setRiskCheckResult(RiskCheckResult riskCheckResult) {
//		this.riskCheckResult = riskCheckResult;
//	}
//
//	/**
//	 * @return the igRIS0203Form
//	 */
//	public IGRIS0203Form getIgRIS0203Form() {
//		return igRIS0203Form;
//	}
//
//	/**
//	 * @param igRIS0203Form the igRIS0203Form to set
//	 */
//	public void setIgRIS0203Form(IGRIS0203Form igRIS0203Form) {
//		this.igRIS0203Form = igRIS0203Form;
//	}
//
//	/**
//	 * @return the cronInfo
//	 */
//	public String getCronInfo() {
//		return cronInfo;
//	}
//
//	/**
//	 * @param cronInfo the cronInfo to set
//	 */
//	public void setCronInfo(String cronInfo) {
//		this.cronInfo = cronInfo;
//	}
//
//	/**
//	 * @return the attachmentList
//	 */
//	public List<Attachment> getAttachmentList() {
//		return attachmentList;
//	}
//
//	/**
//	 * @param attachmentList the attachmentList to set
//	 */
//	public void setAttachmentList(List<Attachment> attachmentList) {
//		this.attachmentList = attachmentList;
//	}
//
//	/**
//	 * @return the riskCheckDataList
//	 */
//	public List<RiskCheck> getRiskCheckDataList() {
//		return riskCheckDataList;
//	}
//
//	/**
//	 * @param riskCheckDataList the riskCheckDataList to set
//	 */
//	public void setRiskCheckDataList(List<RiskCheck> riskCheckDataList) {
//		this.riskCheckDataList = riskCheckDataList;
//	}
//
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

//	/**
//	 * @return the rcid
//	 */
//	public Integer getRcid() {
//		return rcid;
//	}
//
//	/**
//	 * @param rcid the rcid to set
//	 */
//	public void setRcid(Integer rcid) {
//		this.rcid = rcid;
//	}
//
//	/**
//	 * @return the riskCheck
//	 */
//	public RiskCheck getRiskCheck() {
//		return riskCheck;
//	}
//
//	/**
//	 * @param riskCheck the riskCheck to set
//	 */
//	public void setRiskCheck(RiskCheck riskCheck) {
//		this.riskCheck = riskCheck;
//	}
//
//	/**
//	 * @return the igRIS0202Form
//	 */
//	public IGRIS0202Form getIgRIS0202Form() {
//		return igRIS0202Form;
//	}
//
//	/**
//	 * @param igRIS0202Form the igRIS0202Form to set
//	 */
//	public void setIgRIS0202Form(IGRIS0202Form igRIS0202Form) {
//		this.igRIS0202Form = igRIS0202Form;
//	}
//
//	/**
//	 * @return the igRIS0201Form
//	 */
//	public IGRIS0201Form getIgRIS0201Form() {
//		return igRIS0201Form;
//	}
//
//	/**
//	 * @param igRIS0201Form the igRIS0201Form to set
//	 */
//	public void setIgRIS0201Form(IGRIS0201Form igRIS0201Form) {
//		this.igRIS0201Form = igRIS0201Form;
//	}
//
//	public List<IGRIS02022VO> getWeekList() {
//		return weekList;
//	}
//
//	
//	/**
//	 * @return the eiids
//	 */
//	public List<String> getEiids() {
//		return eiids;
//	}
//
//	/**
//	 * @param eiids the eiids to set
//	 */
//	public void setEiids(List<String> eiids) {
//		this.eiids = eiids;
//	}
//
//	/**
//	 * @return the eiversions
//	 */
//	public List<String> getEiversions() {
//		return eiversions;
//	}
//
//	/**
//	 * @param eiversions the eiversions to set
//	 */
//	public void setEiversions(List<String> eiversions) {
//		this.eiversions = eiversions;
//	}
//
//	public void setWeekList(List<IGRIS02022VO> weekList) {
//		this.weekList = weekList;
//	}
//
//	public List<IGRIS02022VO> getMonthList() {
//		return monthList;
//	}
//
//	public void setMonthList(List<IGRIS02022VO> monthList) {
//		this.monthList = monthList;
//	}
//
//	/**
//	 * �´�ִ��ʱ��ȡ��
//	 * @return �´�ִ��ʱ��
//	 */
//	public String getNextFireTime() {
//		return nextFireTime;
//	}
//
//	/**
//	 * �´�ִ��ʱ���趨
//	 * @param nextFireTime �´�ִ��ʱ��
//	 */
//	public void setNextFireTime(String nextFireTime) {
//		this.nextFireTime = nextFireTime;
//	}
//
//	/**
//	 * @return the checkStrategyInfo
//	 */
//	public CheckStrategyInfo getCheckStrategyInfo() {
//		return checkStrategyInfo;
//	}
//
//	/**
//	 * @param checkStrategyInfo the checkStrategyInfo to set
//	 */
//	public void setCheckStrategyInfo(CheckStrategyInfo checkStrategyInfo) {
//		this.checkStrategyInfo = checkStrategyInfo;
//	}
//
//	/**
//	 * @return the csid
//	 */
//	public Integer getCsid() {
//		return csid;
//	}
//
//	/**
//	 * @param csid the csid to set
//	 */
//	public void setCsid(Integer csid) {
//		this.csid = csid;
//	}
//
//	/**
//	 * @return the eiidList
//	 */
//	public List<Integer> getEiidList() {
//		return eiidList;
//	}
//
//
//	/**
//	 * @param eiidList the eiidList to set
//	 */
//	public void setEiidList(List<Integer> eiidList) {
//		this.eiidList = eiidList;
//	}
//
//	/**
//	 * @return the eiVersionList
//	 */
//	public List<Integer> getEiVersionList() {
//		return eiVersionList;
//	}
//
//	/**
//	 * @param eiVersionList the eiVersionList to set
//	 */
//	public void setEiVersionList(List<Integer> eiVersionList) {
//		this.eiVersionList = eiVersionList;
//	}
//
//	/**
//	 * @return the riskCheckmap
//	 */
//	public Map<String, List<RiskCheck>> getRiskCheckmap() {
//		return riskCheckmap;
//	}
//
//	/**
//	 * @param riskCheckmap the riskCheckmap to set
//	 */
//	public void setRiskCheckmap(Map<String, List<RiskCheck>> riskCheckmap) {
//		this.riskCheckmap = riskCheckmap;
//	}
//
//	/**
//	 * @return the mapType
//	 */
//	public Map<Integer, String> getMapType() {
//		return mapType;
//	}
//
//	/**
//	 * @param mapType the mapType to set
//	 */
//	public void setMapType(Map<Integer, String> mapType) {
//		this.mapType = mapType;
//	}
//
//	/**
//	 * @return the processList
//	 */
//	public List<IG500Info> getProcessList() {
//		return processList;
//	}
//
//	/**
//	 * @param processList the processList to set
//	 */
//	public void setProcessList(List<IG500Info> processList) {
//		this.processList = processList;
//	}
//
//	/**
//	 * @return the assignInfo
//	 */
//	public Map<IG333Info, Map<Role, List<UserInfo>>> getAssignInfo() {
//		return assignInfo;
//	}
//
//	/**
//	 * @param assignInfo the assignInfo to set
//	 */
//	public void setAssignInfo(Map<IG333Info, Map<Role, List<UserInfo>>> assignInfo) {
//		this.assignInfo = assignInfo;
//	}
//
	/**
	 * igVEN0201Formȡ��
	 * @return igVEN0201Form  igVEN0201Form
	 */
	public IGVEN0201Form getIgVEN0201Form() {
		return igVEN0201Form;
	}

	/**
	 * igVEN0201Form�趨
	 * @param igVEN0201Form  igVEN0201Form
	 */
	public void setIgVEN0201Form(IGVEN0201Form igVEN0201Form) {
		this.igVEN0201Form = igVEN0201Form;
	}

	/**
	 * ���ռ������ȡ��
	 * @return riskMonitoringInfos  ���ռ������
	 */
	public List<RiskMonitoringInfo> getRiskMonitoringInfos() {
		return riskMonitoringInfos;
	}

	/**
	 * ���ռ�������趨
	 * @param riskMonitoringInfos  ���ռ������
	 */
	public void setRiskMonitoringInfos(List<RiskMonitoringInfo> riskMonitoringInfos) {
		this.riskMonitoringInfos = riskMonitoringInfos;
	}

	/**
	 * userȡ��
	 * @return user  user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * user�趨
	 * @param user  user
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * ���ռ������ȡ��
	 * @return igVEN0202Form  ���ռ������
	 */
	public IGVEN0202Form getIgVEN0202Form() {
		return igVEN0202Form;
	}

	/**
	 * ���ռ�������趨
	 * @param igVEN0202Form  ���ռ������
	 */
	public void setIgVEN0202Form(IGVEN0202Form igVEN0202Form) {
		this.igVEN0202Form = igVEN0202Form;
	}

	/**
	 * ���ռ�⹤������ȡ��
	 * @return monitoringWorkInfos  ���ռ�⹤������
	 */
	public List<MonitoringWorkInfo> getMonitoringWorkInfos() {
		return monitoringWorkInfos;
	}

	/**
	 * ���ռ�⹤�������趨
	 * @param monitoringWorkInfos  ���ռ�⹤������
	 */
	public void setMonitoringWorkInfos(List<MonitoringWorkInfo> monitoringWorkInfos) {
		this.monitoringWorkInfos = monitoringWorkInfos;
	}

	/**
	 * ���ռ������ȡ��
	 * @return igVEN0203Form  ���ռ������
	 */
	public IGVEN0203Form getIgVEN0203Form() {
		return igVEN0203Form;
	}

	/**
	 * ���ռ�������趨
	 * @param igVEN0203Form  ���ռ������
	 */
	public void setIgVEN0203Form(IGVEN0203Form igVEN0203Form) {
		this.igVEN0203Form = igVEN0203Form;
	}

	/**
	 * ת�ش���ҳȡ��
	 * @return goToError  ת�ش���ҳ
	 */
	public String getGoToError() {
		return goToError;
	}

	/**
	 * ת�ش���ҳ�趨
	 * @param goToError  ת�ش���ҳ
	 */
	public void setGoToError(String goToError) {
		this.goToError = goToError;
	}

	
	
}


