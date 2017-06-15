package com.deliverik.infogovernor.syslog.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Locale;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.infogovernor.syslog.form.IGLOG0001Form;
import com.deliverik.infogovernor.syslog.form.IGLOG0002Form;
import com.deliverik.infogovernor.syslog.model.Mss00005Info;
import com.deliverik.infogovernor.syslog.vo.IGLOG0003VO;

@SuppressWarnings("serial")
public class IGLOG00DTO extends BaseDTO implements Serializable{
	
	/** 实时告警信息Form */
	protected IGLOG0001Form iglog0001Form;
	
	/** 历史告警信息Form */
	protected IGLOG0002Form iglog0002Form;
	
	/** 检索最大件数 */
	protected int maxSearchCount;
	
	/** 翻页用DTO */
	protected PagingDTO pagingDto;
	
	/** 国际化信息 */
	protected Locale locale;
	
	/** 设备实时告警信息列表 */
	protected List<Mss00005Info> SysLogAlarmList;
	
	/** 设备历史告警信息列表 */
	protected List HistorySysLogAlarmList;//因为会在两个表中获得数据，因而不规定范型
	
	/**告警总数*/
	protected Integer totalcount;
	
	/** 设备实时告警信息列表(带流程) */
	protected List<IGLOG0003VO> list_vo;
	
	/** 实时数据刷新频率 */
	protected String refreshRate;
	
	
	public String getRefreshRate() {
		return refreshRate;
	}

	public void setRefreshRate(String refreshRate) {
		this.refreshRate = refreshRate;
	}

	/** 告警级别列表 */
	protected List<CodeDetail> alarmPrioritiesList;
	
	/** 告警级别列表(字符串形式) */
	protected String alarmPrioritiesStr;
	
	
	public String getAlarmPrioritiesStr() {
		return alarmPrioritiesStr;
	}

	public void setAlarmPrioritiesStr(String alarmPrioritiesStr) {
		this.alarmPrioritiesStr = alarmPrioritiesStr;
	}

	public List<CodeDetail> getAlarmPrioritiesList() {
		return alarmPrioritiesList;
	}

	public void setAlarmPrioritiesList(List<CodeDetail> alarmPrioritiesList) {
		this.alarmPrioritiesList = alarmPrioritiesList;
	}

	public IGLOG0001Form getIglog0001Form() {
		return iglog0001Form;
	}

	public void setIglog0001Form(IGLOG0001Form iglog0001Form) {
		this.iglog0001Form = iglog0001Form;
	}


	public List<Mss00005Info> getSysLogAlarmList() {
		return SysLogAlarmList;
	}

	public void setSysLogAlarmList(List<Mss00005Info> sysLogAlarmList) {
		SysLogAlarmList = sysLogAlarmList;
	}

	public IGLOG0002Form getIglog0002Form() {
		return iglog0002Form;
	}

	public void setIglog0002Form(IGLOG0002Form iglog0002Form) {
		this.iglog0002Form = iglog0002Form;
	}

	public List getHistorySysLogAlarmList() {
		return HistorySysLogAlarmList;
	}

	public void setHistorySysLogAlarmList(List historySysLogAlarmList) {
		HistorySysLogAlarmList = historySysLogAlarmList;
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

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	/**
	 * 告警总数取得
	 */
	public Integer getTotalcount() {
		return totalcount;
	}

	/**
	 * 告警总数设定
	 */
	public void setTotalcount(Integer totalcount) {
		this.totalcount = totalcount;
	}
	/**
	 * 设备实时告警信息列表(带流程)取得
	 */
	public List<IGLOG0003VO> getList_vo() {
		return list_vo;
	}

	/**
	 * 设备实时告警信息列表(带流程)设定
	 */
	public void setList_vo(List<IGLOG0003VO> list_vo) {
		this.list_vo = list_vo;
	}

}
