/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.plugin.change.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.plugin.change.model.InitiateChangLogInfo;

/**
  * 概述: 发起变更流程日志实体
  * 功能描述: 发起变更流程日志实体
  * 创建记录: 2015/07/02
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="initiateChang_Log")
public class InitiateChangLogTB extends BaseEntity implements Serializable,
		Cloneable, InitiateChangLogInfo {

	/** 主键 */
	@Id
	@TableGenerator(
		name="INITIATECHANGLOG_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="INITIATECHANGLOG_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="INITIATECHANGLOG_TABLE_GENERATOR")
	protected Integer icid;

	/** 发送时间 */
	protected String sendTime;

	/** 发布时间 */
	protected String publishTime;

	/** 流程id */
	protected Integer prid;

	/** 发布状态 */
	protected String publishStatus;

	/** 备注 */
	protected String remark;

	/** 发起人id */
	protected String pruserId;

	/** 发起人角色id */
	protected String prroleId;

	/** 变更名称 */
	protected String changeName;

	/** 变更描述 */
	protected String changeDescription;

	/** 计划执行开始时间 */
	protected String beginTime;

	/** 计划执行结束时间 */
	protected String endTime;

	/** 变更类型 */
	protected String changeType;

	/** 变更类别 */
	protected String changeCategory;

	/** 所选变更类型 */
	protected String selectedChangeType;

	/** 变更分类 */
	protected String changeClassify;

	/** 更新平台 */
	protected String updatePlatform;

	/** 变更原因分类 */
	protected String changeReasonClassify;

	/** 变更原因 */
	protected String changeReason;

	/** 变更内容 */
	protected String changeContent;

	/** 相关项目编号 */
	protected String prjid;

	/** 相关项目名称 */
	protected String prjtitle;

	/** 是否影响业务 */
	protected String isBusiness;

	/** 是业务影响范围 */
	protected String businessScope;

	/** 计划影响业务时长(分钟) */
	protected String businessTime;

	/** 执行计划 */
	protected String deliveryProgram;

	/** 回退计划 */
	protected String rollbackProgram;

	/** 验证计划 */
	protected String verificationProgram;

	/** 相关程序开发流程 */
	protected String relatedPrid;
	
	/** 附件key*/
	protected String attkey;
	
	/**PMS 系统工单ID*/
	protected String ticketid;

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getIcid() {
		return icid;
	}

	/**
	 * 主键设定
	 *
	 * @param icid 主键
	 */
	public void setIcid(Integer icid) {
		this.icid = icid;
	}

	/**
	 * 发送时间取得
	 *
	 * @return 发送时间
	 */
	public String getSendTime() {
		return sendTime;
	}

	/**
	 * 发送时间设定
	 *
	 * @param sendTime 发送时间
	 */
	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}

	/**
	 * 发布时间取得
	 *
	 * @return 发布时间
	 */
	public String getPublishTime() {
		return publishTime;
	}

	/**
	 * 发布时间设定
	 *
	 * @param publishTime 发布时间
	 */
	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}

	/**
	 * 流程id取得
	 *
	 * @return 流程id
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * 流程id设定
	 *
	 * @param prid 流程id
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * 发布状态取得
	 *
	 * @return 发布状态
	 */
	public String getPublishStatus() {
		return publishStatus;
	}

	/**
	 * 发布状态设定
	 *
	 * @param publishStatus 发布状态
	 */
	public void setPublishStatus(String publishStatus) {
		this.publishStatus = publishStatus;
	}

	/**
	 * 备注取得
	 *
	 * @return 备注
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 备注设定
	 *
	 * @param remark 备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * 发起人id取得
	 *
	 * @return 发起人id
	 */
	public String getPruserId() {
		return pruserId;
	}

	/**
	 * 发起人id设定
	 *
	 * @param pruserId 发起人id
	 */
	public void setPruserId(String pruserId) {
		this.pruserId = pruserId;
	}

	/**
	 * 发起人角色id取得
	 *
	 * @return 发起人角色id
	 */
	public String getPrroleId() {
		return prroleId;
	}

	/**
	 * 发起人角色id设定
	 *
	 * @param prroleId 发起人角色id
	 */
	public void setPrroleId(String prroleId) {
		this.prroleId = prroleId;
	}

	/**
	 * 变更名称取得
	 *
	 * @return 变更名称
	 */
	public String getChangeName() {
		return changeName;
	}

	/**
	 * 变更名称设定
	 *
	 * @param changeName 变更名称
	 */
	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}

	/**
	 * 变更描述取得
	 *
	 * @return 变更描述
	 */
	public String getChangeDescription() {
		return changeDescription;
	}

	/**
	 * 变更描述设定
	 *
	 * @param changeDescription 变更描述
	 */
	public void setChangeDescription(String changeDescription) {
		this.changeDescription = changeDescription;
	}

	/**
	 * 计划执行开始时间取得
	 *
	 * @return 计划执行开始时间
	 */
	public String getBeginTime() {
		return beginTime;
	}

	/**
	 * 计划执行开始时间设定
	 *
	 * @param beginTime 计划执行开始时间
	 */
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	/**
	 * 计划执行结束时间取得
	 *
	 * @return 计划执行结束时间
	 */
	public String getEndTime() {
		return endTime;
	}

	/**
	 * 计划执行结束时间设定
	 *
	 * @param endTime 计划执行结束时间
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	/**
	 * 变更类型取得
	 *
	 * @return 变更类型
	 */
	public String getChangeType() {
		return changeType;
	}

	/**
	 * 变更类型设定
	 *
	 * @param changeType 变更类型
	 */
	public void setChangeType(String changeType) {
		this.changeType = changeType;
	}

	/**
	 * 变更类别取得
	 *
	 * @return 变更类别
	 */
	public String getChangeCategory() {
		return changeCategory;
	}

	/**
	 * 变更类别设定
	 *
	 * @param changeCategory 变更类别
	 */
	public void setChangeCategory(String changeCategory) {
		this.changeCategory = changeCategory;
	}

	/**
	 * 所选变更类型取得
	 *
	 * @return 所选变更类型
	 */
	public String getSelectedChangeType() {
		return selectedChangeType;
	}

	/**
	 * 所选变更类型设定
	 *
	 * @param selectedChangeType 所选变更类型
	 */
	public void setSelectedChangeType(String selectedChangeType) {
		this.selectedChangeType = selectedChangeType;
	}

	/**
	 * 变更分类取得
	 *
	 * @return 变更分类
	 */
	public String getChangeClassify() {
		return changeClassify;
	}

	/**
	 * 变更分类设定
	 *
	 * @param changeClassify 变更分类
	 */
	public void setChangeClassify(String changeClassify) {
		this.changeClassify = changeClassify;
	}

	/**
	 * 更新平台取得
	 *
	 * @return 更新平台
	 */
	public String getUpdatePlatform() {
		return updatePlatform;
	}

	/**
	 * 更新平台设定
	 *
	 * @param updatePlatform 更新平台
	 */
	public void setUpdatePlatform(String updatePlatform) {
		this.updatePlatform = updatePlatform;
	}

	/**
	 * 变更原因分类取得
	 *
	 * @return 变更原因分类
	 */
	public String getChangeReasonClassify() {
		return changeReasonClassify;
	}

	/**
	 * 变更原因分类设定
	 *
	 * @param changeReasonClassify 变更原因分类
	 */
	public void setChangeReasonClassify(String changeReasonClassify) {
		this.changeReasonClassify = changeReasonClassify;
	}

	/**
	 * 变更原因取得
	 *
	 * @return 变更原因
	 */
	public String getChangeReason() {
		return changeReason;
	}

	/**
	 * 变更原因设定
	 *
	 * @param changeReason 变更原因
	 */
	public void setChangeReason(String changeReason) {
		this.changeReason = changeReason;
	}

	/**
	 * 变更内容取得
	 *
	 * @return 变更内容
	 */
	public String getChangeContent() {
		return changeContent;
	}

	/**
	 * 变更内容设定
	 *
	 * @param changeContent 变更内容
	 */
	public void setChangeContent(String changeContent) {
		this.changeContent = changeContent;
	}

	/**
	 * 相关项目编号取得
	 *
	 * @return 相关项目编号
	 */
	public String getPrjid() {
		return prjid;
	}

	/**
	 * 相关项目编号设定
	 *
	 * @param prjid 相关项目编号
	 */
	public void setPrjid(String prjid) {
		this.prjid = prjid;
	}

	/**
	 * 相关项目名称取得
	 *
	 * @return 相关项目名称
	 */
	public String getPrjtitle() {
		return prjtitle;
	}

	/**
	 * 相关项目名称设定
	 *
	 * @param prjtitle 相关项目名称
	 */
	public void setPrjtitle(String prjtitle) {
		this.prjtitle = prjtitle;
	}

	/**
	 * 是否影响业务取得
	 *
	 * @return 是否影响业务
	 */
	public String getIsBusiness() {
		return isBusiness;
	}

	/**
	 * 是否影响业务设定
	 *
	 * @param isBusiness 是否影响业务
	 */
	public void setIsBusiness(String isBusiness) {
		this.isBusiness = isBusiness;
	}

	/**
	 * 是业务影响范围取得
	 *
	 * @return 是业务影响范围
	 */
	public String getBusinessScope() {
		return businessScope;
	}

	/**
	 * 是业务影响范围设定
	 *
	 * @param businessScope 是业务影响范围
	 */
	public void setBusinessScope(String businessScope) {
		this.businessScope = businessScope;
	}

	/**
	 * 计划影响业务时长(分钟)取得
	 *
	 * @return 计划影响业务时长(分钟)
	 */
	public String getBusinessTime() {
		return businessTime;
	}

	/**
	 * 计划影响业务时长(分钟)设定
	 *
	 * @param businessTime 计划影响业务时长(分钟)
	 */
	public void setBusinessTime(String businessTime) {
		this.businessTime = businessTime;
	}

	/**
	 * 执行计划取得
	 *
	 * @return 执行计划
	 */
	public String getDeliveryProgram() {
		return deliveryProgram;
	}

	/**
	 * 执行计划设定
	 *
	 * @param deliveryProgram 执行计划
	 */
	public void setDeliveryProgram(String deliveryProgram) {
		this.deliveryProgram = deliveryProgram;
	}

	/**
	 * 回退计划取得
	 *
	 * @return 回退计划
	 */
	public String getRollbackProgram() {
		return rollbackProgram;
	}

	/**
	 * 回退计划设定
	 *
	 * @param rollbackProgram 回退计划
	 */
	public void setRollbackProgram(String rollbackProgram) {
		this.rollbackProgram = rollbackProgram;
	}

	/**
	 * 验证计划取得
	 *
	 * @return 验证计划
	 */
	public String getVerificationProgram() {
		return verificationProgram;
	}

	/**
	 * 验证计划设定
	 *
	 * @param verificationProgram 验证计划
	 */
	public void setVerificationProgram(String verificationProgram) {
		this.verificationProgram = verificationProgram;
	}

	/**
	 * 相关程序开发流程取得
	 *
	 * @return 相关程序开发流程
	 */
	public String getRelatedPrid() {
		return relatedPrid;
	}

	/**
	 * 相关程序开发流程设定
	 *
	 * @param relatedPrid 相关程序开发流程
	 */
	public void setRelatedPrid(String relatedPrid) {
		this.relatedPrid = relatedPrid;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return icid;
	}

	/**
	 * 附件key获取
	 * @return the attkey
	 */
	public String getAttkey() {
		return attkey;
	}

	/**
	 * 附件key设定
	 * @param attkey
	 */
	public void setAttkey(String attkey) {
		this.attkey = attkey;
	}

	/**
	 * PMS系统工单ID取得
	 * @return ticketid PMS系统工单ID
	 */
	
	public String getTicketid() {
		return ticketid;
	}

	/**
	 * PMS系统工单ID设定
	 * @param ticketid PMS系统工单ID
	 */
	public void setTicketid(String ticketid) {
		this.ticketid = ticketid;
	}
}