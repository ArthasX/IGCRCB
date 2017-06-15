/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.syslog.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.syslog.model.Mss00001Info;
import com.deliverik.infogovernor.syslog.model.Mss00002Info;
import com.deliverik.infogovernor.syslog.model.Mss00004Info;
import com.deliverik.infogovernor.syslog.model.Mss00011Info;
import com.deliverik.infogovernor.syslog.model.entity.Mss00002TB;

/**
 * <p>
 * Title : ��ع���ƽ̨
 * </p>
 * <p>
 * Description: ��ع��� >> ������� >> �澯�������VO
 * </p>
 * 
 * @author wangrongguang@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGLOG0021VO extends BaseVO implements Serializable {

	/**
	 * ����list
	 */
	private List<Mss00002Info> mss00002InfoList;
	
	/** �澯����ʵ���� */
	protected Mss00002TB mss00002TB;

	/** �豸������ͼ�б� */
	protected List<Mss00011Info> deviceTempList;
	
	/** �豸ʵ���� */
	protected Mss00001Info mss00001TB;
	
	/** �豸�б� */
	protected List<Mss00001Info> deviceList;
	
	/** ��������ģ���б� */
	protected List<Mss00004Info> tempList;
	
	/** �豸����ID */
	protected String typeid;
	
	/** ĳ���豸���е�ģ���б� */
	protected List<Mss00004Info> tempListFromDevice;
	
	public List<Mss00011Info> getDeviceTempList() {
		return deviceTempList;
	}

	public void setDeviceTempList(List<Mss00011Info> deviceTempList) {
		this.deviceTempList = deviceTempList;
	}

	/**
	 * ��ȡ
	 * 
	 * @return List<Mss00004Info>
	 */
	public List<Mss00002Info> getMss00002InfoList() {
		return mss00002InfoList;
	}

	public Mss00002TB getMss00002TB() {
		return mss00002TB;
	}

	public void setMss00002TB(Mss00002TB mss00002TB) {
		this.mss00002TB = mss00002TB;
	}

	public void setMss00002InfoList(List<Mss00002Info> mss00002InfoList) {
		this.mss00002InfoList = mss00002InfoList;
	}

	public Mss00001Info getMss00001TB() {
		return mss00001TB;
	}

	public void setMss00001TB(Mss00001Info mss00001TB) {
		this.mss00001TB = mss00001TB;
	}
	
	public List<Mss00001Info> getDeviceList() {
		return deviceList;
	}

	public void setDeviceList(List<Mss00001Info> deviceList) {
		this.deviceList = deviceList;
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

	public String getTypeid() {
		return typeid;
	}

	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}

	public List<Mss00004Info> getTempListFromDevice() {
		return tempListFromDevice;
	}

	public void setTempListFromDevice(List<Mss00004Info> tempListFromDevice) {
		this.tempListFromDevice = tempListFromDevice;
	}
	
	
	
}
