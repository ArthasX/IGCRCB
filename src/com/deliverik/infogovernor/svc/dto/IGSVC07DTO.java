package com.deliverik.infogovernor.svc.dto;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prr.model.IG003Info;
import com.deliverik.framework.workflow.prr.model.IG036Info;
import com.deliverik.framework.workflow.prr.model.IG160Info;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.IG512Info;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.framework.workflow.prr.model.IG677Info;
import com.deliverik.framework.workflow.prr.model.IG933Info;
import com.deliverik.framework.workflow.prr.model.condition.IG003SearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG160SearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG677SearchCond;

public class IGSVC07DTO extends BaseDTO {
	
	private static final long serialVersionUID = 1L;
	
	
	
	/**�¼���¼ID*/
	protected Integer prid;
	
	/**�¼��û�ID*/
	protected String userid;
	
	/**�¼��û�����*/
	protected String username;
	
	/**�¼���ɫID*/
	protected Integer roleid;
	
	/**�¼���ɫ����*/
	protected String rolename;
	
	/**�¼�״̬����Ա״̬*/
	protected String status;
	
	/**���̶���id*/
	protected Integer pdid;
	
	/**���̱���*/
	protected List<IG007Info> processInfoDef;
	
	/**������*/
	protected List<IG337Info> processParticipantList;

	/**��־*/
	protected Map<String, List<IG036Info>> recordLogAttachmentMap;

	/** ��ť */
	protected List<String> actionnameList;
	
	/** ��ɫ */
	protected List<Role> roleList;

	/** �û���ɫ */
	protected List<UserRoleInfo> userRoleList;

	/**�¼�����*/
	protected IG500Info process;
	
	/**�¼�����List*/
	protected List<IG500Info> processList;
	
	/**�����ѯ������¼��*/
	protected int maxSearchCount;

	/**��ҳBean*/
	protected PagingDTO pagingDto;
	
	protected IG677SearchCond processRecordInfoSearchCond;
	
	/**
	 * ���̼�¼��Ϣ�б�
	 */
	private List<IG500Info> processRecordList;
	
	private List<IG677Info> processRecordInfo;
	
	/**
	 * ���û���ѯ�õ������̻�����Ϣ�б�
	 */
	private List<IG160Info> userProcessCountList;
	
	/**
	 * ����ͳ����Ϣ�б�
	 */
	private List<IG003Info> processSummaryList;
	
	/**
	 * ���������б�
	 */
	private List<IG933Info> processGdRecordInfoList;
	
private String initStatusTime;
	
	private String expectStatusTime;
	
	private String expectProcessTime;

	public String getExpectProcessTime() {
		return expectProcessTime;
	}

	public void setExpectProcessTime(String expectProcessTime) {
		this.expectProcessTime = expectProcessTime;
	}

	public String getInitStatusTime() {
		return initStatusTime;
	}

	public void setInitStatusTime(String initStatusTime) {
		this.initStatusTime = initStatusTime;
	}

	public String getExpectStatusTime() {
		return expectStatusTime;
	}

	public void setExpectStatusTime(String expectStatusTime) {
		this.expectStatusTime = expectStatusTime;
	}
	

	/**���̹�ϵ��Ϣ�����б�*/
	protected List<IG512Info> processRecordRelationList;
	
	public IG677SearchCond getProcessRecordInfoSearchCond() {
		return processRecordInfoSearchCond;
	}

	public void setProcessRecordInfoSearchCond(
			IG677SearchCond processRecordInfoSearchCond) {
		this.processRecordInfoSearchCond = processRecordInfoSearchCond;
	}

	public Integer getPrid() {
		return prid;
	}

	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getPdid() {
		return pdid;
	}

	public void setPdid(Integer pdid) {
		this.pdid = pdid;
	}

	public List<IG007Info> getProcessInfoDef() {
		return processInfoDef;
	}

	public void setProcessInfoDef(List<IG007Info> processInfoDef) {
		this.processInfoDef = processInfoDef;
	}

	public List<IG337Info> getProcessParticipantList() {
		return processParticipantList;
	}

	public void setProcessParticipantList(
			List<IG337Info> processParticipantList) {
		this.processParticipantList = processParticipantList;
	}

	public Map<String, List<IG036Info>> getRecordLogAttachmentMap() {
		return recordLogAttachmentMap;
	}

	public void setRecordLogAttachmentMap(
			Map<String, List<IG036Info>> recordLogAttachmentMap) {
		this.recordLogAttachmentMap = recordLogAttachmentMap;
	}

	public List<String> getActionnameList() {
		return actionnameList;
	}

	public void setActionnameList(List<String> actionnameList) {
		this.actionnameList = actionnameList;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	public List<UserRoleInfo> getUserRoleList() {
		return userRoleList;
	}

	public void setUserRoleList(List<UserRoleInfo> userRoleList) {
		this.userRoleList = userRoleList;
	}

	public IG500Info getProcess() {
		return process;
	}

	public void setProcess(IG500Info process) {
		this.process = process;
	}

	public List<IG500Info> getProcessList() {
		return processList;
	}

	public void setProcessList(List<IG500Info> processList) {
		this.processList = processList;
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

	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	private IG160SearchCond userProcessCountSearchCond;
	
	private IG003SearchCond processSummarySearchCond;
	
	private List<IG599Info> processInfo;
	/**�¼���ѯ�ӿ�*/
	protected IG500SearchCond prSearchCond;
	
	public IG500SearchCond getPrSearchCond() {
		return prSearchCond;
	}

	public void setPrSearchCond(IG500SearchCond prSearchCond) {
		this.prSearchCond = prSearchCond;
	}

	public List<IG599Info> getProcessInfo() {
		return processInfo;
	}

	public void setProcessInfo(List<IG599Info> processInfo) {
		this.processInfo = processInfo;
	}

	public IG003SearchCond getProcessSummarySearchCond() {
		return processSummarySearchCond;
	}

	public void setProcessSummarySearchCond(
			IG003SearchCond processSummarySearchCond) {
		this.processSummarySearchCond = processSummarySearchCond;
	}

	public IG160SearchCond getUserProcessCountSearchCond() {
		return userProcessCountSearchCond;
	}

	public void setUserProcessCountSearchCond(
			IG160SearchCond userProcessCountSearchCond) {
		this.userProcessCountSearchCond = userProcessCountSearchCond;
	}

	public List<IG500Info> getProcessRecordList() {
		return processRecordList;
	}

	public void setProcessRecordList(List<IG500Info> processRecordList) {
		this.processRecordList = processRecordList;
	}

	public List<IG677Info> getProcessRecordInfo() {
		return processRecordInfo;
	}

	public void setProcessRecordInfo(List<IG677Info> processRecordInfo) {
		this.processRecordInfo = processRecordInfo;
	}

	public List<IG160Info> getUserProcessCountList() {
		return userProcessCountList;
	}

	public void setUserProcessCountList(List<IG160Info> userProcessCountList) {
		this.userProcessCountList = userProcessCountList;
	}

	public List<IG003Info> getProcessSummaryList() {
		return processSummaryList;
	}

	public void setProcessSummaryList(List<IG003Info> processSummaryList) {
		this.processSummaryList = processSummaryList;
	}
	
	/**
	 * ��ȡ���̹�ϵ��Ϣ�����б�
	 * @return ���̹�ϵ��Ϣ�����б�
	 */
	public List<IG512Info> getProcessRecordRelationList() {
		return processRecordRelationList;
	}

	/**
	 * �������̹�ϵ��Ϣ�����б�
	 * @param processRecordRelationList ���̹�ϵ��Ϣ�����б�
	 */
	public void setProcessRecordRelationList(
			List<IG512Info> processRecordRelationList) {
		this.processRecordRelationList = processRecordRelationList;
	}

	public List<IG933Info> getProcessGdRecordInfoList() {
		return processGdRecordInfoList;
	}

	public void setProcessGdRecordInfoList(List<IG933Info> processGdRecordInfoList) {
		this.processGdRecordInfoList = processGdRecordInfoList;
	}
	
}
