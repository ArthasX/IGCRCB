package com.deliverik.infogovernor.syslog.dto;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.syslog.form.IGLOG0021Form;
import com.deliverik.infogovernor.syslog.form.IGLOG0022Form;
import com.deliverik.infogovernor.syslog.model.Mss00001Info;
import com.deliverik.infogovernor.syslog.model.Mss00002Info;
import com.deliverik.infogovernor.syslog.model.Mss00004Info;
import com.deliverik.infogovernor.syslog.model.Mss00011Info;
import com.deliverik.infogovernor.syslog.model.entity.Mss00002TB;

@SuppressWarnings("serial")
public class IGLOG0021DTO  extends BaseDTO implements Serializable{
	
	/** 告警规则查询form */
	protected IGLOG0021Form igLog0021Form;
	
	/** 告警规则录入form */
	protected IGLOG0022Form igLog0022Form;
	
	/** 告警规则实体类 */
	protected Mss00002TB mss00002TB;
	
	protected Mss00001Info mss00001TB;
	
	
	public Mss00001Info getMss00001TB() {
		return mss00001TB;
	}

	public void setMss00001TB(Mss00001Info mss00001TB) {
		this.mss00001TB = mss00001TB;
	}

	/**
	 * 分页Bean
	 */
	private PagingDTO pagingDto;
	
	/**
	 * 允许查询的最大记录数
	 */
	private int maxSearchCount;
	
	/** 条件规则模板列表 */
	protected List<Mss00004Info> tempList;
	
	
	/** 告警规则模板列表 */
	protected List<Mss00002Info> alarmRuleList;
	
	/** 设备列表 */
	protected List<Mss00001Info> deviceList;
	
	/** 设备规则列表 */
	protected List<Mss00011Info> deviceTempList;
	
	/** 某个设备所有的模板列表 */
	protected List<Mss00004Info> tempListFromDevice;
	

	/**
	 * 告警规则查询form取得
	 */
	public IGLOG0021Form getIgLog0021Form() {
		return igLog0021Form;
	}

	/**
	 * 告警规则查询form设定
	 */
	public void setIgLog0021Form(IGLOG0021Form igLog0021Form) {
		this.igLog0021Form = igLog0021Form;
	}

	/**
	 * 分页Bean取得
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * 分页Bean设定
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	/**
	 * 允许查询的最大记录数取得
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * 允许查询的最大记录数设定
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * 条件规则模板列表取得
	 */
	public List<Mss00004Info> getTempList() {
		return tempList;
	}

	/**
	 * 条件规则模板列表设定
	 */
	public void setTempList(List<Mss00004Info> tempList) {
		this.tempList = tempList;
	}

	/**
	 * 告警规则录入form取得
	 */
	public IGLOG0022Form getIgLog0022Form() {
		return igLog0022Form;
	}

	/**
	 * 告警规则录入form设定
	 */
	public void setIgLog0022Form(IGLOG0022Form igLog0022Form) {
		this.igLog0022Form = igLog0022Form;
	}

	public List<Mss00002Info> getAlarmRuleList() {
		return alarmRuleList;
	}

	public void setAlarmRuleList(List<Mss00002Info> alarmRuleList) {
		this.alarmRuleList = alarmRuleList;
	}

	public Mss00002TB getMss00002TB() {
		return mss00002TB;
	}

	public void setMss00002TB(Mss00002TB mss00002TB) {
		this.mss00002TB = mss00002TB;
	}

	public List<Mss00001Info> getDeviceList() {
		return deviceList;
	}

	public void setDeviceList(List<Mss00001Info> deviceList) {
		this.deviceList = deviceList;
	}

	public List<Mss00011Info> getDeviceTempList() {
		return deviceTempList;
	}

	public void setDeviceTempList(List<Mss00011Info> deviceTempList) {
		this.deviceTempList = deviceTempList;
	}
	public List<Mss00004Info> getTempListFromDevice() {
		return tempListFromDevice;
	}

	public void setTempListFromDevice(List<Mss00004Info> tempListFromDevice) {
		this.tempListFromDevice = tempListFromDevice;
	}
}
