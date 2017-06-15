/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */


package com.deliverik.infogovernor.soc.alarm.dto;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.soc.alarm.form.IGALM0101Form;
import com.deliverik.infogovernor.soc.alarm.form.IGALM0102Form;
import com.deliverik.infogovernor.soc.alarm.model.CRM05Info;
import com.deliverik.infogovernor.soc.alarm.model.condition.CRM05SearchCond;


/**
 * IGALM01DTO
 */
@SuppressWarnings("serial")
public class IGALM01DTO extends BaseDTO implements Serializable{
	
	/** ���������� */
	protected int maxSearchCount;

	/** ��ҳ��DTO */
	protected PagingDTO pagingDto;
	
	protected IGALM0101Form igalm0101Form;
	
	protected IGALM0102Form igalm0102Form;
	protected List<CRM05Info> igalm0102List;
	protected CRM05SearchCond crm05SearchCond;

	public IGALM0101Form getIgalm0101Form() {
		return igalm0101Form;
	}

	public void setIgalm0101Form(IGALM0101Form igalm0101Form) {
		this.igalm0101Form = igalm0101Form;
	}

	/**
	 * igalm0102Formȡ��
	 *
	 * @return igalm0102Form igalm0102Form
	 */
	public IGALM0102Form getIgalm0102Form() {
		return igalm0102Form;
	}

	/**
	 * igalm0102Form�趨
	 *
	 * @param igalm0102Form igalm0102Form
	 */
	public void setIgalm0102Form(IGALM0102Form igalm0102Form) {
		this.igalm0102Form = igalm0102Form;
	}

	/**
	 * igalm0102Listȡ��
	 *
	 * @return igalm0102List igalm0102List
	 */
	public List<CRM05Info> getIgalm0102List() {
		return igalm0102List;
	}

	/**
	 * igalm0102List�趨
	 *
	 * @param igalm0102List igalm0102List
	 */
	public void setIgalm0102List(List<CRM05Info> igalm0102List) {
		this.igalm0102List = igalm0102List;
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
	 * crm05SearchCondȡ��
	 *
	 * @return crm05SearchCond crm05SearchCond
	 */
	public CRM05SearchCond getCrm05SearchCond() {
		return crm05SearchCond;
	}

	/**
	 * crm05SearchCond�趨
	 *
	 * @param crm05SearchCond crm05SearchCond
	 */
	public void setCrm05SearchCond(CRM05SearchCond crm05SearchCond) {
		this.crm05SearchCond = crm05SearchCond;
	}
	
	
	
}


