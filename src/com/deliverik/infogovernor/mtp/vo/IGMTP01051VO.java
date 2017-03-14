/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.mtp.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.model.Attachment;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.mtp.model.QuartzJobDetails;
import com.deliverik.infogovernor.scheduling.model.QuartzJobs;
import com.deliverik.infogovernor.scheduling.model.QuartzProcessInfo;
import com.deliverik.infogovernor.scheduling.model.QuartzProcessInfoEntity;
import com.deliverik.infogovernor.scheduling.model.QuartzProcessRecord;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �������_�������_��ѯVO
 * </p>
 * 
 * @author zhaoyunli@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGMTP01051VO extends BaseVO implements Serializable {

	private List<QuartzJobs> quartzJobsList;

	private User user;
	
	private QuartzJobs quartzJobs;
	
	private QuartzProcessRecord quartzProcessRecord;

	private List<QuartzProcessInfo> quartzProcessInfoList;
	
	private List<Attachment> attachmentList;
	
	private String einame;
	
	private String cvalue;

	//============================>>yangsn
	/** �������ʲ���ϵ */
	private List<QuartzProcessInfoEntity> quartzProcessInfoEntityList;
	
	/** ����ʲ���� */
	private List<QuartzProcessInfoEntity> quartzPieList;
	
	/** ��ʱ�����ѯ��Ϣ���� */
	private List<QuartzJobDetails> quartzJobDetailsList;
	//<<============================yangsn
	
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<QuartzJobs> getQuartzJobsList() {
		return quartzJobsList;
	}

	public void setQuartzJobsList(List<QuartzJobs> quartzJobsList) {
		this.quartzJobsList = quartzJobsList;
	}

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
	 * ����ʲ����ȡ��
	 * @return ����ʲ����
	 */
	public List<QuartzProcessInfoEntity> getQuartzPieList() {
		return quartzPieList;
	}

	/**
	 * ����ʲ�����趨
	 * @param quartzPieList ����ʲ����
	 */
	public void setQuartzPieList(List<QuartzProcessInfoEntity> quartzPieList) {
		this.quartzPieList = quartzPieList;
	}

	/**
	 * ��ʱ�����ѯ��Ϣ����ȡ��
	 * @return ��ʱ�����ѯ��Ϣ����
	 */
	public List<QuartzJobDetails> getQuartzJobDetailsList() {
		return quartzJobDetailsList;
	}

	/**
	 * ��ʱ�����ѯ��Ϣ�����趨
	 * @param quartzJobDetailsList ��ʱ�����ѯ��Ϣ����
	 */
	public void setQuartzJobDetailsList(List<QuartzJobDetails> quartzJobDetailsList) {
		this.quartzJobDetailsList = quartzJobDetailsList;
	}

	
	
}
