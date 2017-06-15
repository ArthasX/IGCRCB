package com.deliverik.infogovernor.mtp.dto;

import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.infogovernor.mtp.form.IGMTP0101Form;
import com.deliverik.infogovernor.mtp.form.IGMTP0102Form;
import com.deliverik.infogovernor.mtp.form.IGMTP0106Form;
import com.deliverik.infogovernor.mtp.form.IGMTP0107Form;
import com.deliverik.infogovernor.scheduling.model.QuartzJobs;
import com.deliverik.infogovernor.scheduling.model.QuartzProcessRecord;

/**
 * �ճ���ά�ƻ�DTO
 */
public class IGMTP01DTO extends BaseDTO {

	private static final long serialVersionUID = 1L;

	/**
	 * ��ά����
	 */
	private QuartzJobs quartzJobs;
	
	/**
	 * ������Ϣ
	 */
	private QuartzProcessRecord quartzProcessRecord;
	
	/**
	 * ��ά����Ǽ�Form
	 */
	private IGMTP0101Form igmtp0101Form;
	
	/**
	 * ��ά����Ǽ�Form
	 */
	private IGMTP0102Form igmtp0102Form;
	
	
	/**
	 * ��ʱ������
	 */
	private String triggerName;
	
	/**
	 * ���̶�����Ϣ����
	 */
	private List<IG380Info> pdList;
	
	/**
	 * ���̱���������Ϣ����
	 */
	private List<IG007Info> pidList;
	
	/**
	 * ���̱���������Ϣ
	 */
	private IG007Info processInfoDef;
	
	/**
	 * ���̶���ID
	 */
	private Integer pdid;
	
	/**
	 * ��Ҫִ����ά�ƻ������ڼ���
	 */
	private List<String> dateList;
	
	/**
	 * ��ά�����޸�Form
	 */
	private IGMTP0106Form igmtp0106Form;
	
	/**
	 * ��ά�����޸�Form(��������)
	 */
	private IGMTP0107Form igmtp0107Form;
	
	
	/**
	 * ��ά�ƻ�����ID
	 */
	private int qjid;
	
	/**
	 * ��ά�ƻ��޸�ʱ��������ѡ�е����ڼ���
	 */
	private List<String> selectList;
	

	
	public List<String> getSelectList() {
		return selectList;
	}

	public void setSelectList(List<String> selectList) {
		this.selectList = selectList;
	}

	public IGMTP0107Form getIgmtp0107Form() {
		return igmtp0107Form;
	}

	public void setIgmtp0107Form(IGMTP0107Form igmtp0107Form) {
		this.igmtp0107Form = igmtp0107Form;
	}

	public int getQjid() {
		return qjid;
	}

	public void setQjid(int qjid) {
		this.qjid = qjid;
	}

	public IGMTP0106Form getIgmtp0106Form() {
		return igmtp0106Form;
	}

	public void setIgmtp0106Form(IGMTP0106Form igmtp0106Form) {
		this.igmtp0106Form = igmtp0106Form;
	}

	public List<String> getDateList() {
		return dateList;
	}

	public void setDateList(List<String> dateList) {
		this.dateList = dateList;
	}

	public List<IG007Info> getPidList() {
		return pidList;
	}

	public void setPidList(List<IG007Info> pidList) {
		this.pidList = pidList;
	}

	public Integer getPdid() {
		return pdid;
	}

	public void setPdid(Integer pdid) {
		this.pdid = pdid;
	}

	public IG007Info getProcessInfoDef() {
		return processInfoDef;
	}

	public void setProcessInfoDef(IG007Info processInfoDef) {
		this.processInfoDef = processInfoDef;
	}

	public List<IG380Info> getPdList() {
		return pdList;
	}

	public void setPdList(List<IG380Info> pdList) {
		this.pdList = pdList;
	}

	public String getTriggerName() {
		return triggerName;
	}

	public void setTriggerName(String triggerName) {
		this.triggerName = triggerName;
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

	public IGMTP0101Form getIgmtp0101Form() {
		return igmtp0101Form;
	}

	public void setIgmtp0101Form(IGMTP0101Form igmtp0101Form) {
		this.igmtp0101Form = igmtp0101Form;
	}

	public IGMTP0102Form getIgmtp0102Form() {
		return igmtp0102Form;
	}

	public void setIgmtp0102Form(IGMTP0102Form igmtp0102Form) {
		this.igmtp0102Form = igmtp0102Form;
	}


}