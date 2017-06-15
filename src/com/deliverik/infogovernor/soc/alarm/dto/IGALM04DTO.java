/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */


package com.deliverik.infogovernor.soc.alarm.dto;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.infogovernor.soc.alarm.form.IGALM0401Form;
import com.deliverik.infogovernor.soc.alarm.model.CRM04Info;


/**
 * IGALM01DTO
 */
@SuppressWarnings("serial")
public class IGALM04DTO extends BaseDTO implements Serializable{
	
	/** ���������� */
	protected int maxSearchCount;

	/** ��ҳ��DTO */
	protected PagingDTO pagingDto;
	
	/** �澯��Ϣ��ѯFrom*/
	protected IGALM0401Form igalm0401Form;
	
	/** �澯��Ϣ��ѯ�����*/
	protected List<CRM04Info> crm04infoList;
	
	/** �澯�����б� */
	protected List<CodeDetail> alarmPrioritiesList;
	
	/** �澯�����б�(�ַ�����ʽ) */
	protected String alarmPrioritiesStr;
	
	/** ʵʱ����ˢ��Ƶ�� */
	protected String refreshRate;
	
	/**
	 * maxSearchCountȡ��
	 *
	 * @return maxSearchCount maxSearchCount
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * pagingDtoȡ��
	 *
	 * @return pagingDto pagingDto
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * maxSearchCount�趨
	 *
	 * @param maxSearchCount maxSearchCount
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * pagingDto�趨
	 *
	 * @param pagingDto pagingDto
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}
	
	/**
	 * igalm0401Formȡ��
	 */
	public IGALM0401Form getIgalm0401Form() {
		return igalm0401Form;
	}
	
	/**
	 * igalm0401Form�趨
	 * @param IGALM0401Form igalm0401Form
	 */
	public void setIgalm0401Form(IGALM0401Form igalm0401Form) {
		this.igalm0401Form = igalm0401Form;
	}
	
	/**
	 * CRM04Infoȡ��
	 */
	public List<CRM04Info> getCrm04infoList() {
		return crm04infoList;
	}
	/**
	 * CRM04Info�趨
	 * @param List<CRM04Info> crm04infoList
	 */
	public void setCrm04infoList(List<CRM04Info> crm04infoList) {
		this.crm04infoList = crm04infoList;
	}
	
	/**
	 * alarmPrioritiesListȡ��
	 */
	public List<CodeDetail> getAlarmPrioritiesList() {
		return alarmPrioritiesList;
	}
	/**
	 * alarmPrioritiesList�趨
	 * @param List<CodeDetail> alarmPrioritiesList
	 */
	public void setAlarmPrioritiesList(List<CodeDetail> alarmPrioritiesList) {
		this.alarmPrioritiesList = alarmPrioritiesList;
	}
	
	public String getAlarmPrioritiesStr() {
		return alarmPrioritiesStr;
	}

	public void setAlarmPrioritiesStr(String alarmPrioritiesStr) {
		this.alarmPrioritiesStr = alarmPrioritiesStr;
	}
	
	public String getRefreshRate() {
		return refreshRate;
	}

	public void setRefreshRate(String refreshRate) {
		this.refreshRate = refreshRate;
	}
}


