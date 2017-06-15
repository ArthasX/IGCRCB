/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.scheduling.dto;

import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.infogovernor.scheduling.form.IGSCH0501Form;
import com.deliverik.infogovernor.scheduling.form.IGSCH0502Form;
import com.deliverik.infogovernor.scheduling.model.QuartzJobs;
import com.deliverik.infogovernor.scheduling.model.QuartzProcessRecord;

/**
 * <p>
 * ��������ά�ƻ���ʱ����DTO
 * </p>
 * <p>
 * ����: ��ʢ�	2010-12-9
 * </p>
 */
public class IGSCH05DTO extends BaseDTO {

	private static final long serialVersionUID = 1L;

	/** ��ʱ������Ϣ */
	private QuartzJobs quartzJobs;
	
	/** ��ʱ����������Ϣ */
	private QuartzProcessRecord quartzProcessRecord;
	
	/** ��ɫ�б� */
	private List<Role> rolelist;
	
	/** quartz�������� */
	private String triggerName;
	
	/** ���������б� */
	private List<IG380Info> pdList;
	
	/** ���̱���Ϣ�б� */
	private List<IG007Info> pidList;
	
	/** ���̱�������Ϣ */
	private IG007Info processInfoDef;
	
	/** ��������ID */
	private Integer pdid;
	
	/** ��ʱ����igsch0501Form��Ϣ */
	private IGSCH0501Form igsch0501Form;
	
	/** ��ʱ����igsch0502Form��Ϣ */
	private IGSCH0502Form igsch0502Form;
	
	/**
	 * ���������б�ȡ��
	 * @return ���������б�
	 */
	public List<IG380Info> getPdList() {
		return pdList;
	}

	/**
	 * ���������б��趨
	 * @param pdList ���������б�
	 */
	public void setPdList(List<IG380Info> pdList) {
		this.pdList = pdList;
	}

	/**
	 * ���̱���Ϣ�б�ȡ��
	 * @return ���̱���Ϣ�б�
	 */
	public List<IG007Info> getPidList() {
		return pidList;
	}

	/**
	 * ���̱���Ϣ�б��趨
	 * @param pidList ���̱���Ϣ�б�
	 */
	public void setPidList(List<IG007Info> pidList) {
		this.pidList = pidList;
	}

	/**
	 * ���̱�������Ϣȡ��
	 * @return ���̱�������Ϣ
	 */
	public IG007Info getProcessInfoDef() {
		return processInfoDef;
	}

	/**
	 * ���̱�������Ϣ�趨
	 * @param processInfoDef ���̱�������Ϣ
	 */
	public void setProcessInfoDef(IG007Info processInfoDef) {
		this.processInfoDef = processInfoDef;
	}

	/**
	 * ��������IDȡ��
	 * @return ��������ID
	 */
	public Integer getPdid() {
		return pdid;
	}

	/**
	 * ��������ID�趨
	 * @param pdid ��������ID
	 */
	public void setPdid(Integer pdid) {
		this.pdid = pdid;
	}

	/**
	 * quartz��������ȡ��
	 * @return quartz��������
	 */
	public String getTriggerName() {
		return triggerName;
	}

	/**
	 * quartz���������趨
	 * @param triggerName quartz��������
	 */
	public void setTriggerName(String triggerName) {
		this.triggerName = triggerName;
	}

	/**
	 * ��ʱ������Ϣȡ��
	 * @return ��ʱ������Ϣ
	 */
	public QuartzJobs getQuartzJobs() {
		return quartzJobs;
	}

	/**
	 * ��ʱ������Ϣ�趨
	 * @param quartzJobs ��ʱ������Ϣ
	 */
	public void setQuartzJobs(QuartzJobs quartzJobs) {
		this.quartzJobs = quartzJobs;
	}

	/**
	 * ��ɫ�б�ȡ��
	 * @return ��ɫ�б�
	 */
	public List<Role> getRolelist() {
		return rolelist;
	}

	/**
	 * ��ɫ�б��趨
	 * @param rolelist ��ɫ�б�
	 */
	public void setRolelist(List<Role> rolelist) {
		this.rolelist = rolelist;
	}

	/**
	 * ��ʱ����������Ϣȡ��
	 * @return ��ʱ����������Ϣ
	 */
	public QuartzProcessRecord getQuartzProcessRecord() {
		return quartzProcessRecord;
	}

	/**
	 * ��ʱ����������Ϣ�趨
	 * @param quartzProcessRecord ��ʱ����������Ϣ
	 */
	public void setQuartzProcessRecord(QuartzProcessRecord quartzProcessRecord) {
		this.quartzProcessRecord = quartzProcessRecord;
	}

	/**
	 * ��ʱ����igsch0501Form��Ϣȡ��
	 * @return ��ʱ����igsch0501Form��Ϣ
	 */
	public IGSCH0501Form getIgsch0501Form() {
		return igsch0501Form;
	}

	/**
	 * ��ʱ����igsch0501Form��Ϣ�趨
	 * @param igsch0501Form ��ʱ����igsch0501Form��Ϣ
	 */
	public void setIgsch0501Form(IGSCH0501Form igsch0501Form) {
		this.igsch0501Form = igsch0501Form;
	}

	/**
	 * ��ʱ����igsch0502Form��Ϣȡ��
	 * @return ��ʱ����igsch0502Form��Ϣ
	 */
	public IGSCH0502Form getIgsch0502Form() {
		return igsch0502Form;
	}

	/**
	 * ��ʱ����igsch0502Form��Ϣ�趨
	 * @param igsch0502Form ��ʱ����igsch0502Form��Ϣ
	 */
	public void setIgsch0502Form(IGSCH0502Form igsch0502Form) {
		this.igsch0502Form = igsch0502Form;
	}

}