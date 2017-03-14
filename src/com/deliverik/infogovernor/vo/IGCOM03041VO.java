package com.deliverik.infogovernor.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prr.model.IG677Info;
import com.deliverik.framework.workflow.prr.model.IG933Info;
import com.deliverik.infogovernor.risk.model.RiskCheckResult;
import com.deliverik.infogovernor.sdl.model.IncidentKpi;

public class IGCOM03041VO extends BaseVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<IG677Info> processRecordInfoForMeList;
	private List<IG677Info> processRecordInfoForGroupList;
	private List<IG677Info> processRecordInfoForMeListAsc;
	private List<IG677Info> processRecordInfoForGroupListAsc;
	private List<IG677Info> processRecordInfoForWAList;
	
	private List<IG933Info> serviceFormInfoForMeListAsc;
	private List<IG933Info> serviceFormInfoForGroupListAsc;
	private List<IG933Info> serviceFormInfoForMeList;
	private List<IG933Info> serviceFormInfoForGroupList;
	
	private Map<String,String> svcTypeMap;
	private Map<String,String> urlMap;
	private Map<String,List<IG677Info>> processRecordMap;
	private int serviceTotalCount;
	private int incidentTotalCount;
//	private int incidentDispatchCount;
//	private int incidentImplementCount;
//	private int incidentVerifyCount0;
	private int problemTotalCount;
//	private int problemDispatchCount;
//	private int problemImplementCount;
//	private int problemVerifyCount;
	private int changeTotalCount;
//	private int changeInitialCount;
//	private int changeApprovalCount;
//	private int changeImplementCount;
//	private int changeVerifyCount;
	private int deploymentTotalCount;
//	private int deploymentInitialCount;
//	private int deploymentApprovalCount;
//	private int deploymentImplementCount;
//	private int deploymentVerifyCount;
	private int workTotalCount;
//	private int workDispatchCount;
//	private int workImplementCount;
//	private int workVerifyCount;
	private int projectCount;
	private boolean is_have_notice;
	private String incxml;//�¼�(�Ǳ�xml)
	private String wkmxml;//����(�Ǳ�xml)
	private String prjxml;//��Ŀ(�Ǳ�xml)
	private String colxml;//����ͼxml
	private String piexml;//����ͼxml
	private String serxml;//��������(�Ǳ�xml)
	/** ����֪ʶ������� */
	private List<IGCOM04032VO> knvoList;
	
	public List<IGCOM04032VO> getKnvoList() {
		return knvoList;
	}

	public void setKnvoList(List<IGCOM04032VO> knvoList) {
		this.knvoList = knvoList;
	}

	/** ���ռ������Ϣ������� */
	protected List<RiskCheckResult> riskCheckResultDataList;
	/**��ʷ����ͳ������*/
	protected String hlist[][]=new String[7][13];

	
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

	public String getSerxml() {
		return serxml;
	}

	public void setSerxml(String serxml) {
		this.serxml = serxml;
	}

	public int getServiceTotalCount() {
		return serviceTotalCount;
	}

	public void setServiceTotalCount(int serviceTotalCount) {
		this.serviceTotalCount = serviceTotalCount;
	}

	public String getColxml() {
		return colxml;
	}

	public void setColxml(String colxml) {
		this.colxml = colxml;
	}

	public String getPiexml() {
		return piexml;
	}

	public void setPiexml(String piexml) {
		this.piexml = piexml;
	}

	public String getIncxml() {
		return incxml;
	}

	public void setIncxml(String incxml) {
		this.incxml = incxml;
	}

	public String getWkmxml() {
		return wkmxml;
	}

	public void setWkmxml(String wkmxml) {
		this.wkmxml = wkmxml;
	}

	public String getPrjxml() {
		return prjxml;
	}

	public void setPrjxml(String prjxml) {
		this.prjxml = prjxml;
	}

	public boolean isIs_have_notice() {
		return is_have_notice;
	}

	public void setIs_have_notice(boolean is_have_notice) {
		this.is_have_notice = is_have_notice;
	}

	public Map<String, String> getUrlMap() {
		return urlMap;
	}

	public void setUrlMap(Map<String, String> urlMap) {
		this.urlMap = urlMap;
	}

	public Map<String, String> getSvcTypeMap() {
		return svcTypeMap;
	}

	public void setSvcTypeMap(Map<String, String> svcTypeMap) {
		this.svcTypeMap = svcTypeMap;
	}
	
	public int getProjectCount() {
		return projectCount;
	}

	public void setProjectCount(int projectCount) {
		this.projectCount = projectCount;
	}

	public List<IG677Info> getProcessRecordInfoForGroupList() {
		return processRecordInfoForGroupList;
	}

	public void setProcessRecordInfoForGroupList(
			List<IG677Info> processRecordInfoForGroupList) {
		this.processRecordInfoForGroupList = processRecordInfoForGroupList;
	}
	
	public int getIncidentTotalCount() {
		return incidentTotalCount;
	}

	public void setIncidentTotalCount(int incidentTotalCount) {
		this.incidentTotalCount = incidentTotalCount;
	}

//	public int getIncidentDispatchCount() {
//		return incidentDispatchCount;
//	}
//
//	public void setIncidentDispatchCount(int incidentDispatchCount) {
//		this.incidentDispatchCount = incidentDispatchCount;
//	}
//
//	public int getIncidentImplementCount() {
//		return incidentImplementCount;
//	}
//
//	public void setIncidentImplementCount(int incidentImplementCount) {
//		this.incidentImplementCount = incidentImplementCount;
//	}
//
//	public int getIncidentVerifyCount0() {
//		return incidentVerifyCount0;
//	}
//
//	public void setIncidentVerifyCount0(int incidentVerifyCount0) {
//		this.incidentVerifyCount0 = incidentVerifyCount0;
//	}

	public int getProblemTotalCount() {
		return problemTotalCount;
	}

	public void setProblemTotalCount(int problemTotalCount) {
		this.problemTotalCount = problemTotalCount;
	}

//	public int getProblemDispatchCount() {
//		return problemDispatchCount;
//	}
//
//	public void setProblemDispatchCount(int problemDispatchCount) {
//		this.problemDispatchCount = problemDispatchCount;
//	}
//
//	public int getProblemImplementCount() {
//		return problemImplementCount;
//	}
//
//	public void setProblemImplementCount(int problemImplementCount) {
//		this.problemImplementCount = problemImplementCount;
//	}
//
//	public int getProblemVerifyCount() {
//		return problemVerifyCount;
//	}
//
//	public void setProblemVerifyCount(int problemVerifyCount) {
//		this.problemVerifyCount = problemVerifyCount;
//	}

	public int getChangeTotalCount() {
		return changeTotalCount;
	}

	public void setChangeTotalCount(int changeTotalCount) {
		this.changeTotalCount = changeTotalCount;
	}

//	public int getChangeInitialCount() {
//		return changeInitialCount;
//	}
//
//	public void setChangeInitialCount(int changeInitialCount) {
//		this.changeInitialCount = changeInitialCount;
//	}
//
//	public int getChangeApprovalCount() {
//		return changeApprovalCount;
//	}
//
//	public void setChangeApprovalCount(int changeApprovalCount) {
//		this.changeApprovalCount = changeApprovalCount;
//	}
//
//	public int getChangeImplementCount() {
//		return changeImplementCount;
//	}
//
//	public void setChangeImplementCount(int changeImplementCount) {
//		this.changeImplementCount = changeImplementCount;
//	}
//
//	public int getChangeVerifyCount() {
//		return changeVerifyCount;
//	}
//
//	public void setChangeVerifyCount(int changeVerifyCount) {
//		this.changeVerifyCount = changeVerifyCount;
//	}

	public int getDeploymentTotalCount() {
		return deploymentTotalCount;
	}

	public void setDeploymentTotalCount(int deploymentTotalCount) {
		this.deploymentTotalCount = deploymentTotalCount;
	}

//	public int getDeploymentInitialCount() {
//		return deploymentInitialCount;
//	}
//
//	public void setDeploymentInitialCount(int deploymentInitialCount) {
//		this.deploymentInitialCount = deploymentInitialCount;
//	}
//
//	public int getDeploymentApprovalCount() {
//		return deploymentApprovalCount;
//	}
//
//	public void setDeploymentApprovalCount(int deploymentApprovalCount) {
//		this.deploymentApprovalCount = deploymentApprovalCount;
//	}
//
//	public int getDeploymentImplementCount() {
//		return deploymentImplementCount;
//	}
//
//	public void setDeploymentImplementCount(int deploymentImplementCount) {
//		this.deploymentImplementCount = deploymentImplementCount;
//	}
//
//	public int getDeploymentVerifyCount() {
//		return deploymentVerifyCount;
//	}
//
//	public void setDeploymentVerifyCount(int deploymentVerifyCount) {
//		this.deploymentVerifyCount = deploymentVerifyCount;
//	}

	public int getWorkTotalCount() {
		return workTotalCount;
	}

	public void setWorkTotalCount(int workTotalCount) {
		this.workTotalCount = workTotalCount;
	}

	private ArrayList noticeList;//���֪ͨ����
	
	private String dataXml;//���ͼ����ʾ����xml
	
	private boolean showflag;//�Ƿ����δ��ʾ��֪ͨ
	
	private boolean showKnflag;//�Ƿ����δ��ʾ��֪ʶ

	
	public boolean isShowKnflag() {
		return showKnflag;
	}

	public void setShowKnflag(boolean showKnflag) {
		this.showKnflag = showKnflag;
	}

	public boolean isShowflag() {
		return showflag;
	}

	public void setShowflag(boolean showflag) {
		this.showflag = showflag;
	}

	public ArrayList getNoticeList() {
		return noticeList;
	}

	public void setNoticeList(ArrayList noticeList) {
		this.noticeList = noticeList;
	}

	public String getDataXml() {
		return dataXml;
	}

	public void setDataXml(String dataXml) {
		this.dataXml = dataXml;
	}

	public List<IG677Info> getProcessRecordInfoForMeList() {
		return processRecordInfoForMeList;
	}

	public void setProcessRecordInfoForMeList(
			List<IG677Info> processRecordInfoForMeList) {
		this.processRecordInfoForMeList = processRecordInfoForMeList;
	}

	public Map<String, List<IG677Info>> getProcessRecordMap() {
		return processRecordMap;
	}

	public void setProcessRecordMap(
			Map<String, List<IG677Info>> processRecordMap) {
		this.processRecordMap = processRecordMap;
	}

	public List<IG677Info> getProcessRecordInfoForMeListAsc() {
		return processRecordInfoForMeListAsc;
	}

	public void setProcessRecordInfoForMeListAsc(
			List<IG677Info> processRecordInfoForMeListAsc) {
		this.processRecordInfoForMeListAsc = processRecordInfoForMeListAsc;
	}

	public List<IG677Info> getProcessRecordInfoForGroupListAsc() {
		return processRecordInfoForGroupListAsc;
	}

	public void setProcessRecordInfoForGroupListAsc(
			List<IG677Info> processRecordInfoForGroupListAsc) {
		this.processRecordInfoForGroupListAsc = processRecordInfoForGroupListAsc;
	}

	public List<IG677Info> getProcessRecordInfoForWAList() {
		return processRecordInfoForWAList;
	}

	public void setProcessRecordInfoForWAList(
			List<IG677Info> processRecordInfoForWAList) {
		this.processRecordInfoForWAList = processRecordInfoForWAList;
	}

	public List<IG933Info> getServiceFormInfoForMeListAsc() {
		return serviceFormInfoForMeListAsc;
	}

	public void setServiceFormInfoForMeListAsc(
			List<IG933Info> serviceFormInfoForMeListAsc) {
		this.serviceFormInfoForMeListAsc = serviceFormInfoForMeListAsc;
	}

	public List<IG933Info> getServiceFormInfoForGroupListAsc() {
		return serviceFormInfoForGroupListAsc;
	}

	public void setServiceFormInfoForGroupListAsc(
			List<IG933Info> serviceFormInfoForGroupListAsc) {
		this.serviceFormInfoForGroupListAsc = serviceFormInfoForGroupListAsc;
	}

	public List<IG933Info> getServiceFormInfoForMeList() {
		return serviceFormInfoForMeList;
	}

	public void setServiceFormInfoForMeList(
			List<IG933Info> serviceFormInfoForMeList) {
		this.serviceFormInfoForMeList = serviceFormInfoForMeList;
	}

	public List<IG933Info> getServiceFormInfoForGroupList() {
		return serviceFormInfoForGroupList;
	}

	public void setServiceFormInfoForGroupList(
			List<IG933Info> serviceFormInfoForGroupList) {
		this.serviceFormInfoForGroupList = serviceFormInfoForGroupList;
	}

	public String[][] getHlist() {
		return hlist;
	}

	public void setHlist(String[][] hlist) {
		this.hlist = hlist;
	}
	
	/** SOC���� **/
	private String socxml;//��Ա������ͳ�ƣ�ͳ�Ƹ����ֳ�����ʦ���еĹ�������δ�ر����̣���������ͼ��ʾ��
	/**
	 * ��Ա������ͳ��ȡ��
	 *
	 * @return socxml ��Ա������ͳ��
	 */
	public String getSocxml() {
		return socxml;
	}
	/**
	 * ��Ա������ͳ���趨
	 *
	 * @param socxml ��Ա������ͳ��
	 */
	
	public void setSocxml(String socxml) {
		this.socxml = socxml;
	}

	private List<IncidentKpi> incidentKpiList;
	/**
	 * incidentKpiListȡ��
	 *
	 * @return incidentKpiList incidentKpiList
	 */
	public List<IncidentKpi> getIncidentKpiList() {
		return incidentKpiList;
	}
	/**
	 * incidentKpiList�趨
	 *
	 * @param incidentKpiList incidentKpiList
	 */
	public void setIncidentKpiList(List<IncidentKpi> incidentKpiList) {
		this.incidentKpiList = incidentKpiList;
	}

	private Map<String,String> varList;
	/**
	 * varListȡ��
	 *
	 * @return varList varList
	 */
	public Map<String, String> getVarList() {
		return varList;
	}
	/**
	 * varList�趨
	 *
	 * @param varList varList
	 */
	public void setVarList(Map<String, String> varList) {
		this.varList = varList;
	}

	private Map<String,String> varAllList;
	/**
	 * varAllListȡ��
	 *
	 * @return varAllList varAllList
	 */
	public Map<String, String> getVarAllList() {
		return varAllList;
	}
	/**
	 * varAllList�趨
	 *
	 * @param varAllList varAllList
	 */
	public void setVarAllList(Map<String, String> varAllList) {
		this.varAllList = varAllList;
	}

	private Map<String,String> allurlMap;
	/**
	 * allurlMapȡ��
	 *
	 * @return allurlMap allurlMap
	 */
	public Map<String, String> getAllurlMap() {
		return allurlMap;
	}
	/**
	 * allurlMap�趨
	 *
	 * @param allurlMap allurlMap
	 */	
	public void setAllurlMap(Map<String, String> allurlMap) {
		this.allurlMap = allurlMap;
	}
}