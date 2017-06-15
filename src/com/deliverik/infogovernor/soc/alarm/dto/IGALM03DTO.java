/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */


package com.deliverik.infogovernor.soc.alarm.dto;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.soc.alarm.form.IGALM0301Form;
import com.deliverik.infogovernor.soc.alarm.form.IGALM0302Form;
import com.deliverik.infogovernor.soc.alarm.model.CRM06VWInfo;
import com.deliverik.infogovernor.soc.alarm.model.CRM08Info;
import com.deliverik.infogovernor.soc.alarm.model.CRM09Info;


/**
 * IGALM01DTO
 */
@SuppressWarnings("serial")
public class IGALM03DTO extends BaseDTO implements Serializable{
	
	protected IGALM0301Form igalm0301Form;
	
	protected IGALM0302Form igalm0302Form;
	
	/** ���������� */
	protected int maxSearchCount;

	/** ��ҳ��DTO */
	protected PagingDTO pagingDto;
	
	/** ��ض�����ͼ�б� */
	protected List<CRM06VWInfo> crm06InfoList;
	
	/** �豸�Ѿ�ӵ�й����б� */
	protected List<CRM08Info> ruleTemps;
	
	/** �豸��δӵ�еĹ����б� */
	protected List<CRM08Info> ruleTempsNeed;
	
	/** �������ģ���ϵʵ�� */
	protected CRM09Info crm09Info;

	public CRM09Info getCrm09Info() {
		return crm09Info;
	}

	public void setCrm09Info(CRM09Info crm09Info) {
		this.crm09Info = crm09Info;
	}

	public IGALM0301Form getIgalm0301Form() {
		return igalm0301Form;
	}

	public void setIgalm0301Form(IGALM0301Form igalm0301Form) {
		this.igalm0301Form = igalm0301Form;
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

	public List<CRM06VWInfo> getCrm06InfoList() {
		return crm06InfoList;
	}

	public void setCrm06InfoList(List<CRM06VWInfo> crm06InfoList) {
		this.crm06InfoList = crm06InfoList;
	}

	public IGALM0302Form getIgalm0302Form() {
		return igalm0302Form;
	}

	public void setIgalm0302Form(IGALM0302Form igalm0302Form) {
		this.igalm0302Form = igalm0302Form;
	}

	public List<CRM08Info> getRuleTemps() {
		return ruleTemps;
	}

	public void setRuleTemps(List<CRM08Info> ruleTemps) {
		this.ruleTemps = ruleTemps;
	}

	public List<CRM08Info> getRuleTempsNeed() {
		return ruleTempsNeed;
	}

	public void setRuleTempsNeed(List<CRM08Info> ruleTempsNeed) {
		this.ruleTempsNeed = ruleTempsNeed;
	}
	
}


