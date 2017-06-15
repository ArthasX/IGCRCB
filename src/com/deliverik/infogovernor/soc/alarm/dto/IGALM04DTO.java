/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
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
	
	/** 检索最大件数 */
	protected int maxSearchCount;

	/** 翻页用DTO */
	protected PagingDTO pagingDto;
	
	/** 告警信息查询From*/
	protected IGALM0401Form igalm0401Form;
	
	/** 告警信息查询结果集*/
	protected List<CRM04Info> crm04infoList;
	
	/** 告警级别列表 */
	protected List<CodeDetail> alarmPrioritiesList;
	
	/** 告警级别列表(字符串形式) */
	protected String alarmPrioritiesStr;
	
	/** 实时数据刷新频率 */
	protected String refreshRate;
	
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
	 * igalm0401Form取得
	 */
	public IGALM0401Form getIgalm0401Form() {
		return igalm0401Form;
	}
	
	/**
	 * igalm0401Form设定
	 * @param IGALM0401Form igalm0401Form
	 */
	public void setIgalm0401Form(IGALM0401Form igalm0401Form) {
		this.igalm0401Form = igalm0401Form;
	}
	
	/**
	 * CRM04Info取得
	 */
	public List<CRM04Info> getCrm04infoList() {
		return crm04infoList;
	}
	/**
	 * CRM04Info设定
	 * @param List<CRM04Info> crm04infoList
	 */
	public void setCrm04infoList(List<CRM04Info> crm04infoList) {
		this.crm04infoList = crm04infoList;
	}
	
	/**
	 * alarmPrioritiesList取得
	 */
	public List<CodeDetail> getAlarmPrioritiesList() {
		return alarmPrioritiesList;
	}
	/**
	 * alarmPrioritiesList设定
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


