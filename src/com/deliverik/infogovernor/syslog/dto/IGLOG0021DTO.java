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
	
	/** �澯�����ѯform */
	protected IGLOG0021Form igLog0021Form;
	
	/** �澯����¼��form */
	protected IGLOG0022Form igLog0022Form;
	
	/** �澯����ʵ���� */
	protected Mss00002TB mss00002TB;
	
	protected Mss00001Info mss00001TB;
	
	
	public Mss00001Info getMss00001TB() {
		return mss00001TB;
	}

	public void setMss00001TB(Mss00001Info mss00001TB) {
		this.mss00001TB = mss00001TB;
	}

	/**
	 * ��ҳBean
	 */
	private PagingDTO pagingDto;
	
	/**
	 * �����ѯ������¼��
	 */
	private int maxSearchCount;
	
	/** ��������ģ���б� */
	protected List<Mss00004Info> tempList;
	
	
	/** �澯����ģ���б� */
	protected List<Mss00002Info> alarmRuleList;
	
	/** �豸�б� */
	protected List<Mss00001Info> deviceList;
	
	/** �豸�����б� */
	protected List<Mss00011Info> deviceTempList;
	
	/** ĳ���豸���е�ģ���б� */
	protected List<Mss00004Info> tempListFromDevice;
	

	/**
	 * �澯�����ѯformȡ��
	 */
	public IGLOG0021Form getIgLog0021Form() {
		return igLog0021Form;
	}

	/**
	 * �澯�����ѯform�趨
	 */
	public void setIgLog0021Form(IGLOG0021Form igLog0021Form) {
		this.igLog0021Form = igLog0021Form;
	}

	/**
	 * ��ҳBeanȡ��
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * ��ҳBean�趨
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	/**
	 * �����ѯ������¼��ȡ��
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * �����ѯ������¼���趨
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * ��������ģ���б�ȡ��
	 */
	public List<Mss00004Info> getTempList() {
		return tempList;
	}

	/**
	 * ��������ģ���б��趨
	 */
	public void setTempList(List<Mss00004Info> tempList) {
		this.tempList = tempList;
	}

	/**
	 * �澯����¼��formȡ��
	 */
	public IGLOG0022Form getIgLog0022Form() {
		return igLog0022Form;
	}

	/**
	 * �澯����¼��form�趨
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
