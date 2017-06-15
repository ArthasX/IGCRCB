package com.deliverik.infogovernor.scheduling.dto;

import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.model.Attachment;
import com.deliverik.infogovernor.mtp.model.QuartzJobDetails;
import com.deliverik.infogovernor.mtp.model.condition.QuartzJobDetailsSearchCond;
import com.deliverik.infogovernor.scheduling.form.IGSCH0101Form;
import com.deliverik.infogovernor.scheduling.model.QuartzJobs;
import com.deliverik.infogovernor.scheduling.model.QuartzProcessInfo;
import com.deliverik.infogovernor.scheduling.model.QuartzProcessInfoEntity;
import com.deliverik.infogovernor.scheduling.model.QuartzProcessParticipant;
import com.deliverik.infogovernor.scheduling.model.QuartzProcessRecord;
import com.deliverik.infogovernor.scheduling.model.condition.QuartzJobsSearchCond;

public class IGSCH01DTO extends BaseDTO {

	private static final long serialVersionUID = 1L;

	
	private List<QuartzJobs> quartzJobsList;

	private QuartzJobsSearchCond quartzJobsSearchCond;
	
	private QuartzJobs quartzJobs;
	
	private QuartzProcessRecord  quartzProcessRecord;
	
	private List<QuartzProcessInfo> quartzProcessInfoList;
	
	private List <QuartzProcessParticipant> quartzProcessParticipantList;
	
	private List<Attachment> attachmentList;
	
	private List<String> usernameList;
	
	private String einame;
	
	private String cvalue;
	
	private String username;
		//============================>>yangsn
	/** �������ʲ���ϵ */
	private List<QuartzProcessInfoEntity> quartzProcessInfoEntityList;
	
	/** ����ʲ���Ϣ */
	private List<QuartzProcessInfoEntity> quartzPieList;
	
	/** ��ʱ�����ѯ */
	private QuartzJobDetailsSearchCond quartzJobDetailsSearchCond;
	
	/** ��ʱ�����ѯ�б� */
	private List<QuartzJobDetails> quartzJobDetailsList;
	//<<============================yangsn
	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<String> getUsernameList() {
		return usernameList;
	}

	public void setUsernameList(List<String> usernameList) {
		this.usernameList = usernameList;
	}

	public String getEiname() {
		return einame;
	}

	public void setEiname(String einame) {
		this.einame = einame;
	}

	public String getCvalue() {
		return cvalue;
	}

	public void setCvalue(String cvalue) {
		this.cvalue = cvalue;
	}

	public List<Attachment> getAttachmentList() {
		return attachmentList;
	}

	public void setAttachmentList(List<Attachment> attachmentList) {
		this.attachmentList = attachmentList;
	}

	public List<QuartzProcessInfo> getQuartzProcessInfoList() {
		return quartzProcessInfoList;
	}

	public void setQuartzProcessInfoList(
			List<QuartzProcessInfo> quartzProcessInfoList) {
		this.quartzProcessInfoList = quartzProcessInfoList;
	}

	public QuartzProcessRecord getQuartzProcessRecord() {
		return quartzProcessRecord;
	}

	public void setQuartzProcessRecord(QuartzProcessRecord quartzProcessRecord) {
		this.quartzProcessRecord = quartzProcessRecord;
	}

	public QuartzJobs getQuartzJobs() {
		return quartzJobs;
	}

	public void setQuartzJobs(QuartzJobs quartzJobs) {
		this.quartzJobs = quartzJobs;
	}

	/**
	 * �����ѯ������¼��
	 */
	
	private int maxSearchCount;

	/**
	 * ��ҳBean
	 */
	
	private PagingDTO pagingDto;
	
	/**
	 * ɾ������
	 */
	
	private int qjid;
	
	/**
	 * ����û�����Ϣ
	 */
	private IGSCH0101Form igsch0101Form;

	public QuartzJobsSearchCond getQuartzJobsSearchCond() {
		return quartzJobsSearchCond;
	}

	public void setQuartzJobsSearchCond(QuartzJobsSearchCond quartzJobsSearchCond) {
		this.quartzJobsSearchCond = quartzJobsSearchCond;
	}


	public List<QuartzJobs> getQuartzJobsList() {
		return quartzJobsList;
	}

	public void setQuartzJobsList(List<QuartzJobs> quartzJobsList) {
		this.quartzJobsList = quartzJobsList;
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

	public IGSCH0101Form getIgsch0101Form() {
		return igsch0101Form;
	}

	public void setIgsch0101Form(IGSCH0101Form igsch0101Form) {
		this.igsch0101Form = igsch0101Form;
	}

	public int getQjid() {
		return qjid;
	}

	public void setQjid(int qjid) {
		this.qjid = qjid;
	}
	
	//============================>>yangsn
	/**
	 * �������ʲ���ϵȡ��
	 * @return �������ʲ���ϵ
	 */
	public List<QuartzProcessInfoEntity> getQuartzProcessInfoEntityList() {
		return quartzProcessInfoEntityList;
	}

	/**
	 * �������ʲ���ϵ�趨
	 * @param quartzProcessInfoEntityList �������ʲ���ϵ
	 */
	public void setQuartzProcessInfoEntityList(
			List<QuartzProcessInfoEntity> quartzProcessInfoEntityList) {
		this.quartzProcessInfoEntityList = quartzProcessInfoEntityList;
	}

	/**
	 * ����ʲ���Ϣȡ��
	 * @return ����ʲ���Ϣ
	 */
	public List<QuartzProcessInfoEntity> getQuartzPieList() {
		return quartzPieList;
	}

	/**
	 * ����ʲ���Ϣ�趨
	 * @param pieList ����ʲ���Ϣ
	 */
	public void setQuartzPieList(List<QuartzProcessInfoEntity> quartzPieList) {
		this.quartzPieList = quartzPieList;
	}

	/**
	 * ��ʱ�����ѯȡ��
	 * @return ��ʱ�����ѯ
	 */
	public QuartzJobDetailsSearchCond getQuartzJobDetailsSearchCond() {
		return quartzJobDetailsSearchCond;
	}

	/**
	 * ��ʱ�����ѯ�趨
	 * @param quartzJobDetailsSearchCond ��ʱ�����ѯ
	 */
	public void setQuartzJobDetailsSearchCond(
			QuartzJobDetailsSearchCond quartzJobDetailsSearchCond) {
		this.quartzJobDetailsSearchCond = quartzJobDetailsSearchCond;
	}

	/**
	 * ��ʱ�����ѯ�б�ȡ��
	 * @return ��ʱ�����ѯ�б�
	 */
	public List<QuartzJobDetails> getQuartzJobDetailsList() {
		return quartzJobDetailsList;
	}

	/**
	 * ��ʱ�����ѯ�б��趨
	 * @param quartzJobDetailsList ��ʱ�����ѯ�б�
	 */
	public void setQuartzJobDetailsList(List<QuartzJobDetails> quartzJobDetailsList) {
		this.quartzJobDetailsList = quartzJobDetailsList;
	}
	
	//<<============================yangsn

	public List<QuartzProcessParticipant> getQuartzProcessParticipantList() {
		return quartzProcessParticipantList;
	}

	public void setQuartzProcessParticipantList(
			List<QuartzProcessParticipant> quartzProcessParticipantList) {
		this.quartzProcessParticipantList = quartzProcessParticipantList;
	}

}