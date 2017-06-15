/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.syslog.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.syslog.model.Mss00003Info;
import com.deliverik.infogovernor.syslog.model.Mss00004VWInfo;

/**
 * <p>
 * Title : 监控管理平台
 * </p>
 * <p>
 * Description: 监控配置_告警规则模板管理_查询VO
 * </p>
 * 
 * @author wangrongguang@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGLOG0041VO extends BaseVO implements Serializable {

	/**
	 * 模板list
	 */
	private List<Mss00004VWInfo> mss00004InfoList;
	
	/** 自定义规则模板列表 */
	protected List<Mss00003Info> myTempList;
	
	/** 告警级别列表 */
	protected String alarmPriorities;
	
	protected String couldReturn;
	
	
	public String getCouldReturn() {
		return couldReturn;
	}

	public void setCouldReturn(String couldReturn) {
		this.couldReturn = couldReturn;
	}
	
	public String getAlarmPriorities() {
		return alarmPriorities;
	}

	public void setAlarmPriorities(String alarmPriorities) {
		this.alarmPriorities = alarmPriorities;
	}

	/**
	 * 构造方法
	 * 
	 * @param mss00004InfoList
	 */
	public IGLOG0041VO(){}
	
	public IGLOG0041VO(List<Mss00004VWInfo> mss00004InfoList) {
		this.mss00004InfoList = mss00004InfoList;
	}

	/**
	 * 获取
	 * 
	 * @return List<Mss00004Info>
	 */
	public List<Mss00004VWInfo> getMss00004InfoList() {
		return mss00004InfoList;
	}

	/**
	 * 自定义规则模板列表取得
	 */
	public List<Mss00003Info> getMyTempList() {
		return myTempList;
	}

	/**
	 * 自定义规则模板列表设定
	 */
	public void setMyTempList(List<Mss00003Info> myTempList) {
		this.myTempList = myTempList;
	}

	/**
	 * 模板list设定
	 */
	public void setMss00004InfoList(List<Mss00004VWInfo> mss00004InfoList) {
		this.mss00004InfoList = mss00004InfoList;
	}
	
}
