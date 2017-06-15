/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * ��������ģ��vo
 *
 * @���� zhaoyong
 *
 * 2013-4-7
 */
@SuppressWarnings("serial")
public class IGLOG0043VO extends BaseVO implements Serializable{
	
	/** ��������ģ��*/
	protected Mss00004TB mss00004TB;
	
	/** ��������form */
	protected IGLOG0042Form igLog0042Form;
	
	/** ���������б� */
	protected List<Mss00003Info> mss00003InfoList;
	
	/** �澯�����б� */
	protected List<CodeDetail> alarmPrioritiesList;
	
	/** �澯�����б� */
	protected String alarmPriorities;
	
	/** ʹ��ĳ��ģ�������IP */
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
	 * mss00004TBȡ��
	 */
	public Mss00004TB getMss00004TB() {
		return mss00004TB;
	}

	/**
	 * mss00004TB�趨
	 */
	public void setMss00004TB(Mss00004TB mss00004TB) {
		this.mss00004TB = mss00004TB;
	}

	/**
	 * ��������formȡ��
	 */
	public IGLOG0042Form getIgLog0042Form() {
		return igLog0042Form;
	}

	/**
	 * ��������form�趨
	 */
	public void setIgLog0042Form(IGLOG0042Form igLog0042Form) {
		this.igLog0042Form = igLog0042Form;
	}

	/**
	 * ���������б�ȡ��
	 */
	public List<Mss00003Info> getMss00003InfoList() {
		return mss00003InfoList;
	}

	/**
	 * ���������б��趨
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
