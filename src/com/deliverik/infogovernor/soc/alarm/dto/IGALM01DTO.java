/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
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
	
	/** 检索最大件数 */
	protected int maxSearchCount;

	/** 翻页用DTO */
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
	 * igalm0102Form取得
	 *
	 * @return igalm0102Form igalm0102Form
	 */
	public IGALM0102Form getIgalm0102Form() {
		return igalm0102Form;
	}

	/**
	 * igalm0102Form设定
	 *
	 * @param igalm0102Form igalm0102Form
	 */
	public void setIgalm0102Form(IGALM0102Form igalm0102Form) {
		this.igalm0102Form = igalm0102Form;
	}

	/**
	 * igalm0102List取得
	 *
	 * @return igalm0102List igalm0102List
	 */
	public List<CRM05Info> getIgalm0102List() {
		return igalm0102List;
	}

	/**
	 * igalm0102List设定
	 *
	 * @param igalm0102List igalm0102List
	 */
	public void setIgalm0102List(List<CRM05Info> igalm0102List) {
		this.igalm0102List = igalm0102List;
	}

	/**
	 * maxSearchCount取得
	 *
	 * @return maxSearchCount maxSearchCount
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * pagingDto取得
	 *
	 * @return pagingDto pagingDto
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * maxSearchCount设定
	 *
	 * @param maxSearchCount maxSearchCount
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * pagingDto设定
	 *
	 * @param pagingDto pagingDto
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	/**
	 * crm05SearchCond取得
	 *
	 * @return crm05SearchCond crm05SearchCond
	 */
	public CRM05SearchCond getCrm05SearchCond() {
		return crm05SearchCond;
	}

	/**
	 * crm05SearchCond设定
	 *
	 * @param crm05SearchCond crm05SearchCond
	 */
	public void setCrm05SearchCond(CRM05SearchCond crm05SearchCond) {
		this.crm05SearchCond = crm05SearchCond;
	}
	
	
	
}


