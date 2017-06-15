/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.crc.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.infogovernor.crc.model.IGCRC2401VWInfo;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 年度工作趋势统计实体
 * </p>
 *
 * @version 1.0
 */
@Entity
public class IGCRC2401VW implements IGCRC2401VWInfo{
	@Id
	protected String mainId;
	
	/** 流程主键*/
	protected Integer prid ;
	//id
	protected String userId;
	//姓名
	protected String userName;
	//开始时间
	protected String startTime;
	//结束事件
	protected String endTime;
	//级别
	protected String grade;
	
	
	//确认时间
	protected String confirmtime;
	
	public IGCRC2401VW() {
		super();
	}
	public IGCRC2401VW(String userId, String userName, String startTime,
			String endTime, String grade,String confirmtime) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.startTime = startTime;
		this.endTime = endTime;
		this.grade = grade;
		this.confirmtime = confirmtime;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getConfirmtime() {
		return confirmtime;
	}
	public void setConfirmtime(String confirmtime) {
		this.confirmtime = confirmtime;
	}
	/**
	 * userId取得
	 * @return userId  userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * userId设定
	 * @param userId  userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @return the mainId
	 */
	public String getMainId() {
		return mainId;
	}
	/**
	 * @param mainId the mainId to set
	 */
	public void setMainId(String mainId) {
		this.mainId = mainId;
	}
	/**
	 * 流程主键获取
	 * @return the prid
	 */
	public Integer getPrid() {
		return prid;
	}
	/**
	 * 流程主键设定
	 * @param prid
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}
}
