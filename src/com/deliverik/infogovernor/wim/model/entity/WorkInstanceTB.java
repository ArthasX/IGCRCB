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
import com.deliverik.infogovernor.wim.model.WorkInstanceInfo;

/**
  * 概述: 工作实例表实体
  * 功能描述: 工作实例表实体
  * 创建记录: 2017/06/09
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="workInstance")
public class WorkInstanceTB extends BaseEntity implements Serializable,
		Cloneable, WorkInstanceInfo {

	/** 主键 */
	@Id
	@TableGenerator(
		name="WORKINSTANCE_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="WORKINSTANCE_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="WORKINSTANCE_TABLE_GENERATOR")
	protected Integer wiid;

	/** 工作定义表主键 */
	protected Integer wdid;
	
	/** 工作项名称 */
	protected String wdname;

	/** 工作实例名称 */
	protected String winame;

	/** 工作状态（未执行；执行中；结束；中止；） */
	protected String wistatus;
	
	/** 发起人（userid） */
	protected String initiatorId;

	/** 周期/频率 */
	protected String cycle;

	/** 工作项描述 */
	protected String description;

	/** 开始日期 */
	protected String beginDate;

	/** 负责人 */
	protected String leaderId;
	
	/** 负责人名称 */
	protected String leaderName;
	
	/** 执行人 */
	protected String excutorId;

	/** 执行人名称 */
	protected String excutorName;

	/** 发起类型（1，自动发起；2，手动发起） */
	protected String wiLunchType;

	/** 执行需所时间（小时） */
	protected String excuteTime;
	
	/** 执行情况描述 */
	protected String wiDescription;

	/** 工作确认日期 */
	protected String confirmDate;

	/** 日期栏日期 */
	protected String titleDate;

	/** 表记录创建日期 */
	protected String crtDate;
	
	/**
	 * 取得 主键
	 * 
	 * @return wiid
	*/
	public Integer getPK() {
		return wiid;
	}

	/**
	 * 取得 主键
	 * 
	 * @return wiid
	*/
	public Integer getWiid() {
		return wiid;
	}
	

	/**
	 * 取得 工作定义表主键
	 * 
	 * @return wdid
	*/
	public Integer getWdid() {
		return wdid;
	}
	

	/**
	 * 取得 工作项名称
	 * 
	 * @return wdname
	*/
	public String getWdname() {
		return wdname;
	}
	

	/**
	 * 取得 工作实例名称
	 * 
	 * @return winame
	*/
	public String getWiname() {
		return winame;
	}
	

	/**
	 * 取得 工作状态（未执行；执行中；结束；中止；）
	 * 
	 * @return wistatus
	*/
	public String getWistatus() {
		return wistatus;
	}
	

	/**
	 * 取得 发起人（userid）
	 * 
	 * @return initiatorId
	*/
	public String getInitiatorId() {
		return initiatorId;
	}
	

	/**
	 * 取得 周期频率
	 * 
	 * @return cycle
	*/
	public String getCycle() {
		return cycle;
	}
	

	/**
	 * 取得 工作项描述
	 * 
	 * @return description
	*/
	public String getDescription() {
		return description;
	}
	

	/**
	 * 取得 开始日期
	 * 
	 * @return beginDate
	*/
	public String getBeginDate() {
		return beginDate;
	}
	

	/**
	 * 取得 负责人
	 * 
	 * @return leaderId
	*/
	public String getLeaderId() {
		return leaderId;
	}
	

	/**
	 * 取得 负责人名称
	 * 
	 * @return leaderName
	*/
	public String getLeaderName() {
		return leaderName;
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
	 * 取得 发起类型（1，自动发起；2，手动发起）
	 * 
	 * @return wiLunchType
	*/
	public String getWiLunchType() {
		return wiLunchType;
	}
	

	/**
	 * 取得 执行需所时间（小时）
	 * 
	 * @return excuteTime
	*/
	public String getExcuteTime() {
		return excuteTime;
	}
	

	/**
	 * 取得 执行情况描述
	 * 
	 * @return wiDescription
	*/
	public String getWiDescription() {
		return wiDescription;
	}
	

	/**
	 * 取得 工作确认日期
	 * 
	 * @return confirmDate
	*/
	public String getConfirmDate() {
		return confirmDate;
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
	 * 取得 时间戳
	 * 
	 * @return fingerPrint
	*/
	public String getFingerPrint() {
		return fingerPrint;
	}

	/**
	 *  主键设定
	 * 
	 * @param wiid
	 */
	public void setWiid(Integer wiid) {
		this.wiid = wiid;
	}
	

	/**
	 *  工作定义表主键设定
	 * 
	 * @param wdid
	 */
	public void setWdid(Integer wdid) {
		this.wdid = wdid;
	}
	

	/**
	 *  工作项名称设定
	 * 
	 * @param wdname
	 */
	public void setWdname(String wdname) {
		this.wdname = wdname;
	}
	

	/**
	 *  工作实例名称设定
	 * 
	 * @param winame
	 */
	public void setWiname(String winame) {
		this.winame = winame;
	}
	

	/**
	 *  工作状态（未执行；执行中；结束；中止；）设定
	 * 
	 * @param wistatus
	 */
	public void setWistatus(String wistatus) {
		this.wistatus = wistatus;
	}
	

	/**
	 *  发起人（userid）设定
	 * 
	 * @param initiatorId
	 */
	public void setInitiatorId(String initiatorId) {
		this.initiatorId = initiatorId;
	}
	

	/**
	 *  周期频率设定
	 * 
	 * @param cycle
	 */
	public void setCycle(String cycle) {
		this.cycle = cycle;
	}
	

	/**
	 *  工作项描述设定
	 * 
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	

	/**
	 *  开始日期设定
	 * 
	 * @param beginDate
	 */
	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}
	

	/**
	 *  负责人设定
	 * 
	 * @param leaderId
	 */
	public void setLeaderId(String leaderId) {
		this.leaderId = leaderId;
	}
	

	/**
	 *  负责人名称设定
	 * 
	 * @param leaderName
	 */
	public void setLeaderName(String leaderName) {
		this.leaderName = leaderName;
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
	 *  发起类型（1，自动发起；2，手动发起）设定
	 * 
	 * @param wiLunchType
	 */
	public void setWiLunchType(String wiLunchType) {
		this.wiLunchType = wiLunchType;
	}
	

	/**
	 *  执行需所时间（小时）设定
	 * 
	 * @param excuteTime
	 */
	public void setExcuteTime(String excuteTime) {
		this.excuteTime = excuteTime;
	}
	

	/**
	 *  执行情况描述设定
	 * 
	 * @param wiDescription
	 */
	public void setWiDescription(String wiDescription) {
		this.wiDescription = wiDescription;
	}
	

	/**
	 *  工作确认日期设定
	 * 
	 * @param confirmDate
	 */
	public void setConfirmDate(String confirmDate) {
		this.confirmDate = confirmDate;
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
	 * 表记录创建日期取得
	 * @return 表记录创建日期
	 */
	public String getCrtDate() {
		return crtDate;
	}

	/**
	 * 表记录创建日期设定
	 * @param 表记录创建日期
	 */
	public void setCrtDate(String crtDate) {
		this.crtDate = crtDate;
	}
	
}