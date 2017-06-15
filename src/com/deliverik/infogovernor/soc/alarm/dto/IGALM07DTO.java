/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.soc.alarm.dto;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.soc.alarm.form.IGALM0501Form;
import com.deliverik.infogovernor.soc.alarm.model.CRM10Info;
import com.deliverik.infogovernor.soc.alarm.model.CRMVW01Info;
import com.deliverik.infogovernor.soc.alarm.model.condition.CRM10SearchCond;

/**
 * IGALM01DTO
 */
@SuppressWarnings("serial")
public class IGALM07DTO extends BaseDTO implements Serializable {

	/** ���������� */
	protected int maxSearchCount;
	/** ʵʱ����ˢ��Ƶ�� */
	protected String refreshRate;
	/** ��ҳ��DTO */
	protected PagingDTO pagingDto;

	protected IGALM0501Form igalm0501Form;

	public String getRefreshRate() {
		return refreshRate;
	}

	public void setRefreshRate(String refreshRate) {
		this.refreshRate = refreshRate;
	}


	protected List<CRM10Info> igalm0501List;
	protected List<CRMVW01Info> igalm0501VWList;
	protected CRM10SearchCond crm10SearchCond;

	public List<CRMVW01Info> getIgalm0501VWList() {
		return igalm0501VWList;
	}

	public void setIgalm0501VWList(List<CRMVW01Info> igalm0501VWList) {
		this.igalm0501VWList = igalm0501VWList;
	}

	public IGALM0501Form getIgalm0501Form() {
		return igalm0501Form;
	}

	/**
	 * igalm0501Form�趨
	 * 
	 * @param igalm0501Form
	 *            igalm0501Form
	 */
	public void setIgalm0501Form(IGALM0501Form igalm0501Form) {
		this.igalm0501Form = igalm0501Form;
	}

	
	public List<CRM10Info> getIgalm0501List() {
		return igalm0501List;
	}

	
	public void setIgalm0501List(List<CRM10Info> igalm0501List) {
		this.igalm0501List = igalm0501List;
	}

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
	 * @param maxSearchCount
	 *            maxSearchCount
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * pagingDto�趨
	 * 
	 * @param pagingDto
	 *            pagingDto
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	
	public CRM10SearchCond getCrm10SearchCond() {
		return crm10SearchCond;
	}

	
	public void setCrm10SearchCond(CRM10SearchCond crm10SearchCond) {
		this.crm10SearchCond = crm10SearchCond;
	}

}
