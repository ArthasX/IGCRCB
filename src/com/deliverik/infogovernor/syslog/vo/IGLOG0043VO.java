/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.syslog.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.infogovernor.syslog.form.IGLOG0042Form;
import com.deliverik.infogovernor.syslog.model.Mss00003Info;
import com.deliverik.infogovernor.syslog.model.entity.Mss00004TB;

/**
 * 
 * 规则条件模板vo
 *
 * @作者 zhaoyong
 *
 * 2013-4-7
 */
@SuppressWarnings("serial")
public class IGLOG0043VO extends BaseVO implements Serializable{
	
	/** 规则条件模板*/
	protected Mss00004TB mss00004TB;
	
	/** 规则条件form */
	protected IGLOG0042Form igLog0042Form;
	
	/** 规则条件列表 */
	protected List<Mss00003Info> mss00003InfoList;
	
	/** 告警级别列表 */
	protected List<CodeDetail> alarmPrioritiesList;
	
	/** 告警级别列表 */
	protected String alarmPriorities;
	
	/** 使用某个模板的所有IP */
	protected String deviceListString;
	
	
	public String getAlarmPriorities() {
		return alarmPriorities;
	}

	public void setAlarmPriorities(String alarmPriorities) {
		this.alarmPriorities = alarmPriorities;
	}
	public List<CodeDetail> getAlarmPrioritiesList() {
		return alarmPrioritiesList;
	}

	public void setAlarmPrioritiesList(List<CodeDetail> alarmPrioritiesList) {
		this.alarmPrioritiesList = alarmPrioritiesList;
	}
	
	/**
	 * mss00004TB取得
	 */
	public Mss00004TB getMss00004TB() {
		return mss00004TB;
	}

	/**
	 * mss00004TB设定
	 */
	public void setMss00004TB(Mss00004TB mss00004TB) {
		this.mss00004TB = mss00004TB;
	}

	/**
	 * 规则条件form取得
	 */
	public IGLOG0042Form getIgLog0042Form() {
		return igLog0042Form;
	}

	/**
	 * 规则条件form设定
	 */
	public void setIgLog0042Form(IGLOG0042Form igLog0042Form) {
		this.igLog0042Form = igLog0042Form;
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
