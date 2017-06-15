/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
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
 * Title : 监控管理平台
 * </p>
 * <p>
 * Description: 监控管理 >> 监控配置 >> 告警规则管理VO
 * </p>
 * 
 * @author wangrongguang@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGLOG0021VO extends BaseVO implements Serializable {

	/**
	 * 规则list
	 */
	private List<Mss00002Info> mss00002InfoList;
	
	/** 告警规则实体类 */
	protected Mss00002TB mss00002TB;

	/** 设备规则视图列表 */
	protected List<Mss00011Info> deviceTempList;
	
	/** 设备实体类 */
	protected Mss00001Info mss00001TB;
	
	/** 设备列表 */
	protected List<Mss00001Info> deviceList;
	
	/** 条件规则模板列表 */
	protected List<Mss00004Info> tempList;
	
	/** 设备类型ID */
	protected String typeid;
	
	/** 某个设备所有的模板列表 */
	protected List<Mss00004Info> tempListFromDevice;
	
	public List<Mss00011Info> getDeviceTempList() {
		return deviceTempList;
	}

	public void setDeviceTempList(List<Mss00011Info> deviceTempList) {
		this.deviceTempList = deviceTempList;
	}

	/**
	 * 获取
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
