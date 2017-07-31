/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.wim.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.wim.model.WorkLogInfo;

/**
  * 概述: 工作日志表实体
  * 功能描述: 工作日志表实体
  * 创建记录: 2017/06/09
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="workLog")
public class WorkLogTB extends BaseEntity implements Serializable,
		Cloneable, WorkLogInfo {

	/** 主键 */
	@Id
	@TableGenerator(
		name="WORKLOG_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="WORKLOG_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="WORKLOG_TABLE_GENERATOR")
	protected Integer wlid;

	/** 工作实例表主键 */
	protected Integer wiid;

	/** 执行人 */
	protected String excutorId;
	
	/** 执行人名称 */
	protected String excutorName;

	/** 日期栏日期 */
	protected String titleDate;

	/** 执行时间 （小时）*/
	protected String excuteTime;

	/** 实际处理日期 */
	protected String actualDealwithDate;

	/** 执行情况描述 */
	protected String wlDescription;

	/** 表记录创建日期 */
	protected String crtDate;

	/** 按钮动作 */
	protected String btnAction;
	
	/**
	 * 取得 主键
	 * 
	 * @return wlid
	*/
	public Integer getWlid() {
		return wlid;
	}
	

	/**
	 * 取得 工作实例表主键
	 * 
	 * @return wiid
	*/
	public Integer getWiid() {
		return wiid;
	}
	

	/**
	 * 取得 执行人
	 * 
	 * @return excutorId
	*/
	public String getExcutorId() {
		return excutorId;
	}
	

	/**
	 * 取得 执行人名称
	 * 
	 * @return excutorName
	*/
	public String getExcutorName() {
		return excutorName;
	}
	

	/**
	 * 取得 日期栏日期
	 * 
	 * @return titleDate
	*/
	public String getTitleDate() {
		return titleDate;
	}
	

	/**
	 * 取得 执行时间（小时）
	 * 
	 * @return excuteTime
	*/
	public String getExcuteTime() {
		return excuteTime;
	}
	

	/**
	 * 取得 实际处理日期
	 * 
	 * @return actualDealwithDate
	*/
	public String getActualDealwithDate() {
		return actualDealwithDate;
	}
	

	/**
	 * 取得 执行情况描述
	 * 
	 * @return wlDescription
	*/
	public String getWlDescription() {
		return wlDescription;
	}
	

	/**
	 * 取得 表记录创建日期
	 * 
	 * @return crtDate
	*/
	public String getCrtDate() {
		return crtDate;
	}
	

	/**
	 * 取得 按钮动作
	 * 
	 * @return btnAction
	*/
	public String getBtnAction() {
		return btnAction;
	}


	/**
	 *  主键设定
	 * 
	 * @param wlid
	 */
	public void setWlid(Integer wlid) {
		this.wlid = wlid;
	}
	


	/**
	 *  工作实例表主键设定
	 * 
	 * @param wiid
	 */
	public void setWiid(Integer wiid) {
		this.wiid = wiid;
	}
	


	/**
	 *  执行人设定
	 * 
	 * @param excutorId
	 */
	public void setExcutorId(String excutorId) {
		this.excutorId = excutorId;
	}
	


	/**
	 *  执行人名称设定
	 * 
	 * @param excutorName
	 */
	public void setExcutorName(String excutorName) {
		this.excutorName = excutorName;
	}
	


	/**
	 *  日期栏日期设定
	 * 
	 * @param titleDate
	 */
	public void setTitleDate(String titleDate) {
		this.titleDate = titleDate;
	}
	


	/**
	 *  执行时间（小时）设定
	 * 
	 * @param excuteTime
	 */
	public void setExcuteTime(String excuteTime) {
		this.excuteTime = excuteTime;
	}
	


	/**
	 *  实际处理日期设定
	 * 
	 * @param actualDealwithDate
	 */
	public void setActualDealwithDate(String actualDealwithDate) {
		this.actualDealwithDate = actualDealwithDate;
	}
	


	/**
	 *  执行情况描述设定
	 * 
	 * @param wlDescription
	 */
	public void setWlDescription(String wlDescription) {
		this.wlDescription = wlDescription;
	}
	


	/**
	 *  表记录创建日期设定
	 * 
	 * @param crtDate
	 */
	public void setCrtDate(String crtDate) {
		this.crtDate = crtDate;
	}


	/**
	 *  按钮动作设定
	 * 
	 * @param btnAction
	 */
	public void setBtnAction(String btnAction) {
		this.btnAction = btnAction;
	}
	/**
	 * 取得 主键
	 * 
	 * @return wlid
	*/
	public Integer getPK() {
		return wlid;
	}
	
}