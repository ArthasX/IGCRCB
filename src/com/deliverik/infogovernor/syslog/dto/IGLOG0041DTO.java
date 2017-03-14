package com.deliverik.infogovernor.syslog.dto;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.infogovernor.syslog.form.IGLOG0041Form;
import com.deliverik.infogovernor.syslog.form.IGLOG0042Form;
import com.deliverik.infogovernor.syslog.model.Mss00003Info;
import com.deliverik.infogovernor.syslog.model.Mss00004VWInfo;
import com.deliverik.infogovernor.syslog.model.condition.Mss00004SearchCond;
import com.deliverik.infogovernor.syslog.model.entity.Mss00004TB;

public class IGLOG0041DTO extends BaseDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 分页Bean
	 */
	private PagingDTO pagingDto;
	
	/**
	 * 允许查询的最大记录数
	 */
	private int maxSearchCount;
	
	private Mss00004SearchCond cond;
	
	/** 规则模板表单form */
	protected IGLOG0041Form  igLog0041Form;
	
	/** 规则模板列表 */
	protected List<Mss00004VWInfo> mss00004InfoList;
	
	/** 规则条件模板录入form*/
	protected IGLOG0042Form igLog0042Form;
	
	/** 规则条件模板实体 */
	protected Mss00004TB mss00004TB;
	
	/** 规则条件列表 */
	protected List<Mss00003Info> mss00003InfoList;
	
	/** 告警级别列表 */
	protected String alarmPriorities;
	
	/** 告警级别列表 */
	protected List<CodeDetail> alarmPrioritiesList;
	
	/** 使用某个模板的所有IP */
	protected String deviceListString;
	
	
	public List<CodeDetail> getAlarmPrioritiesList() {
		return alarmPrioritiesList;
	}

	public void setAlarmPrioritiesList(List<CodeDetail> alarmPrioritiesList) {
		this.alarmPrioritiesList = alarmPrioritiesList;
	}

	public String getAlarmPriorities() {
		return alarmPriorities;
	}

	public void setAlarmPriorities(String alarmPriorities) {
		this.alarmPriorities = alarmPriorities;
	}
	
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	public void setCond(Mss00004SearchCond cond) {
		this.cond = cond;
	}

	public Mss00004SearchCond getCond() {
		return cond;
	}

	/**
	 * 规则模板表单form取得
	 */
	public IGLOG0041Form getIgLog0041Form() {
		return igLog0041Form;
	}

	/**
	 * 规则模板表单form设定
	 */
	public void setIgLog0041Form(IGLOG0041Form igLog0041Form) {
		this.igLog0041Form = igLog0041Form;
	}



	/**
	 * 规则模板列表取得
	 */
	public List<Mss00004VWInfo> getMss00004InfoList() {
		return mss00004InfoList;
	}

	/**
	 * 规则模板列表设定
	 */
	public void setMss00004InfoList(List<Mss00004VWInfo> mss00004InfoList) {
		this.mss00004InfoList = mss00004InfoList;
	}

	/**
	 * 规则条件模板录入form取得
	 */
	public IGLOG0042Form getIgLog0042Form() {
		return igLog0042Form;
	}

	/**
	 * 规则条件模板录入form设定
	 */
	public void setIgLog0042Form(IGLOG0042Form igLog0042Form) {
		this.igLog0042Form = igLog0042Form;
	}

	/**
	 * 规则条件模板实体取得
	 */
	public Mss00004TB getMss00004TB() {
		return mss00004TB;
	}

	/**
	 * 规则条件模板实体设定
	 */
	public void setMss00004TB(Mss00004TB mss00004TB) {
		this.mss00004TB = mss00004TB;
	}

	/**
	 * 规则条件列表取得
	 */
	public List<Mss00003Info> getMss00003InfoList() {
		return mss00003InfoList;
	}

	/**
	 * 规则条件列表设定
	 */
	public void setMss00003InfoList(List<Mss00003Info> mss00003InfoList) {
		this.mss00003InfoList = mss00003InfoList;
	}

	public String getDeviceListString() {
		return deviceListString;
	}

	public void setDeviceListString(String deviceListString) {
		this.deviceListString = deviceListString;
	}

	
}
