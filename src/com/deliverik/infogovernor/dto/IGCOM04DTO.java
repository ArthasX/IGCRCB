package com.deliverik.infogovernor.dto;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.security.UserPermission;
import com.deliverik.infogovernor.vo.IGCOM03041VO;

public class IGCOM04DTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	
	private String userId;

	private UserPermission perm;
	 
	private IGCOM03041VO igcom03041VO;
	
	/** 工作数量flex用数据*/
	private String workCountXml;
	
	/** 本月事件数量 */
	protected int currentMouthEventCount;
	
	/** 本月问题数量 */
	protected int currentMouthProblemCount;
	
	/** 流程主题各种类型工作数量 */
	protected String allTypeWorkCount;
	
	/** xml流的字符串 */
	protected String resultXML;
	
	/** 变更计划日历xml */
	protected String changePlanCalender;
	
	/**
	 * 功能：工作数量flex用数据取得
	 * @return workCountXml 工作数量
	 */
	public String getWorkCountXml() {
		return workCountXml;
	}
	/**
	 * 功能：工作数量flex用数据设定
	 * @param workCountXml 工作数量flex用数据
	 */
	public void setWorkCountXml(String workCountXml) {
		this.workCountXml = workCountXml;
	}

	public UserPermission getPerm() {
		return perm;
	}

	public void setPerm(UserPermission perm) {
		this.perm = perm;
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public IGCOM03041VO getIgcom03041VO() {
		return igcom03041VO;
	}

	public void setIgcom03041VO(IGCOM03041VO igcom03041VO) {
		this.igcom03041VO = igcom03041VO;
	}
	/**
	 * 本月事件数量取得
	 * @return currentMouthEventCount 本月事件数量
	 */
	public int getCurrentMouthEventCount() {
		return currentMouthEventCount;
	}
	
	/**
	 * 本月事件数量设定
	 * @param currentMouthEventCount 本月事件数量
	 */
	public void setCurrentMouthEventCount(int currentMouthEventCount) {
		this.currentMouthEventCount = currentMouthEventCount;
	}
	/**
	 * 本月问题数量取得
	 * @return currentMouthProblemCount 本月问题数量
	 */
	public int getCurrentMouthProblemCount() {
		return currentMouthProblemCount;
	}
	/**
	 * 本月问题数量设定
	 * @param currentMouthProblemCount 本月问题数量
	 */
	public void setCurrentMouthProblemCount(int currentMouthProblemCount) {
		this.currentMouthProblemCount = currentMouthProblemCount;
	}
	/**
	 * 流程主题各种类型工作数量取得
	 * @return allTypeWorkCount 流程主题各种类型工作数量
	 */
	public String getAllTypeWorkCount() {
		return allTypeWorkCount;
	}
	/**
	 * 流程主题各种类型工作数量设定
	 * @param allTypeWorkCount 流程主题各种类型工作数量
	 */
	public void setAllTypeWorkCount(String allTypeWorkCount) {
		this.allTypeWorkCount = allTypeWorkCount;
	}
	/**
	 * xml流的字符串取得
	 * @return resultXML xml流的字符串
	 */
	public String getResultXML() {
		return resultXML;
	}
	/**
	 * xml流的字符串设定
	 * @param resultXML xml流的字符串
	 */
	public void setResultXML(String resultXML) {
		this.resultXML = resultXML;
	}
	/**
	 * 变更计划日历xml取得
	 * @return changePlanCalender 变更计划日历xml
	 */
	public String getChangePlanCalender() {
		return changePlanCalender;
	}
	/**
	 * 变更计划日历xml设定
	 * @param changePlanCalender 变更计划日历xml
	 */
	public void setChangePlanCalender(String changePlanCalender) {
		this.changePlanCalender = changePlanCalender;
	}

}
