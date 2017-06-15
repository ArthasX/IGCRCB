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
	 * ��ҳBean
	 */
	private PagingDTO pagingDto;
	
	/**
	 * �����ѯ������¼��
	 */
	private int maxSearchCount;
	
	private Mss00004SearchCond cond;
	
	/** ����ģ���form */
	protected IGLOG0041Form  igLog0041Form;
	
	/** ����ģ���б� */
	protected List<Mss00004VWInfo> mss00004InfoList;
	
	/** ��������ģ��¼��form*/
	protected IGLOG0042Form igLog0042Form;
	
	/** ��������ģ��ʵ�� */
	protected Mss00004TB mss00004TB;
	
	/** ���������б� */
	protected List<Mss00003Info> mss00003InfoList;
	
	/** �澯�����б� */
	protected String alarmPriorities;
	
	/** �澯�����б� */
	protected List<CodeDetail> alarmPrioritiesList;
	
	/** ʹ��ĳ��ģ�������IP */
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
	 * ����ģ���formȡ��
	 */
	public IGLOG0041Form getIgLog0041Form() {
		return igLog0041Form;
	}

	/**
	 * ����ģ���form�趨
	 */
	public void setIgLog0041Form(IGLOG0041Form igLog0041Form) {
		this.igLog0041Form = igLog0041Form;
	}



	/**
	 * ����ģ���б�ȡ��
	 */
	public List<Mss00004VWInfo> getMss00004InfoList() {
		return mss00004InfoList;
	}

	/**
	 * ����ģ���б��趨
	 */
	public void setMss00004InfoList(List<Mss00004VWInfo> mss00004InfoList) {
		this.mss00004InfoList = mss00004InfoList;
	}

	/**
	 * ��������ģ��¼��formȡ��
	 */
	public IGLOG0042Form getIgLog0042Form() {
		return igLog0042Form;
	}

	/**
	 * ��������ģ��¼��form�趨
	 */
	public void setIgLog0042Form(IGLOG0042Form igLog0042Form) {
		this.igLog0042Form = igLog0042Form;
	}

	/**
	 * ��������ģ��ʵ��ȡ��
	 */
	public Mss00004TB getMss00004TB() {
		return mss00004TB;
	}

	/**
	 * ��������ģ��ʵ���趨
	 */
	public void setMss00004TB(Mss00004TB mss00004TB) {
		this.mss00004TB = mss00004TB;
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
