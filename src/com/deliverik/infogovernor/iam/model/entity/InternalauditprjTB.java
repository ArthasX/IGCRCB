/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.iam.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.iam.model.InternalauditprjInfo;

/**
  * 概述: 内审项目实体
  * 功能描述: 内审项目实体
  * 创建记录: 2012/07/19
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="Internalauditprj")
public class InternalauditprjTB extends BaseEntity implements Serializable,
		Cloneable, InternalauditprjInfo {

	/** 无意义自增主键 */
	@Id
	@TableGenerator(
		name="INTERNALAUDITPRJ_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="INTERNALAUDITPRJ_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="INTERNALAUDITPRJ_TABLE_GENERATOR")
	protected Integer iapId;

	/** 审计年度 */
	protected String iapYear;

	/** 审计项目名称 */
	protected String iapName;

	/** 审计项目状态 */
	protected String iapStatus;

	/** 审计对象 */
	protected String iapObject;

	/** 审计方式 */
	protected String iapWay;

	/** 审计人员 */
	protected String iapUserName;

	/** 审计开始日期 */
	protected String iapOpenTime;

	/** 审计结束日期 */
	protected String iapCloseTime;

	/** 审计目标 */
	protected String iapObjective;

	/** 审计范围 */
	protected String iapScope;

	/** 审计依据 */
	protected String iapBasis;

	/** 审计内容及要点 */
	protected String iapDesc;

	/** 审计配合人员 */
	protected String iapCooperator;

	/** 审计建议 */
	protected String iapSuggestion;

	/** 审计项目发起人ID */
	protected String iapCreateUserId;

	/** 审计项目发起时间 */
	protected String iapCreateTime;

	/** 审计项目确认人ID */
	protected String iapConfirmUserId;

	/** 审计项目确认时间 */
	protected String iapConfirmTime;

	/** 审计附件Key */
	protected String iapAttKey;

	/** 审计类型 */
	protected String iapType;
	
	/** 审计检查来源 */
	protected String iapSource;
	
	
	/**
	 * 无意义自增主键取得
	 *
	 * @return 无意义自增主键
	 */
	public Integer getIapId() {
		return iapId;
	}

	/**
	 * 无意义自增主键设定
	 *
	 * @param iapId 无意义自增主键
	 */
	public void setIapId(Integer iapId) {
		this.iapId = iapId;
	}

	/**
	 * 审计年度取得
	 *
	 * @return 审计年度
	 */
	public String getIapYear() {
		return iapYear;
	}

	/**
	 * 审计年度设定
	 *
	 * @param iapYear 审计年度
	 */
	public void setIapYear(String iapYear) {
		this.iapYear = iapYear;
	}

	/**
	 * 审计项目名称取得
	 *
	 * @return 审计项目名称
	 */
	public String getIapName() {
		return iapName;
	}

	/**
	 * 审计项目名称设定
	 *
	 * @param iapName 审计项目名称
	 */
	public void setIapName(String iapName) {
		this.iapName = iapName;
	}

	/**
	 * 审计项目状态取得
	 *
	 * @return 审计项目状态
	 */
	public String getIapStatus() {
		return iapStatus;
	}

	/**
	 * 审计项目状态设定
	 *
	 * @param iapStatus 审计项目状态
	 */
	public void setIapStatus(String iapStatus) {
		this.iapStatus = iapStatus;
	}

	/**
	 * 审计对象取得
	 *
	 * @return 审计对象
	 */
	public String getIapObject() {
		return iapObject;
	}

	/**
	 * 审计对象设定
	 *
	 * @param iapObject 审计对象
	 */
	public void setIapObject(String iapObject) {
		this.iapObject = iapObject;
	}

	/**
	 * 审计方式取得
	 *
	 * @return 审计方式
	 */
	public String getIapWay() {
		return iapWay;
	}

	/**
	 * 审计方式设定
	 *
	 * @param iapWay 审计方式
	 */
	public void setIapWay(String iapWay) {
		this.iapWay = iapWay;
	}

	/**
	 * 审计人员取得
	 *
	 * @return 审计人员
	 */
	public String getIapUserName() {
		return iapUserName;
	}

	/**
	 * 审计人员设定
	 *
	 * @param iapUserName 审计人员
	 */
	public void setIapUserName(String iapUserName) {
		this.iapUserName = iapUserName;
	}

	/**
	 * 审计开始日期取得
	 *
	 * @return 审计开始日期
	 */
	public String getIapOpenTime() {
		return iapOpenTime;
	}

	/**
	 * 审计开始日期设定
	 *
	 * @param iapOpenTime 审计开始日期
	 */
	public void setIapOpenTime(String iapOpenTime) {
		this.iapOpenTime = iapOpenTime;
	}

	/**
	 * 审计结束日期取得
	 *
	 * @return 审计结束日期
	 */
	public String getIapCloseTime() {
		return iapCloseTime;
	}

	/**
	 * 审计结束日期设定
	 *
	 * @param iapCloseTime 审计结束日期
	 */
	public void setIapCloseTime(String iapCloseTime) {
		this.iapCloseTime = iapCloseTime;
	}

	/**
	 * 审计目标取得
	 *
	 * @return 审计目标
	 */
	public String getIapObjective() {
		return iapObjective;
	}

	/**
	 * 审计目标设定
	 *
	 * @param iapObjective 审计目标
	 */
	public void setIapObjective(String iapObjective) {
		this.iapObjective = iapObjective;
	}

	/**
	 * 审计范围取得
	 *
	 * @return 审计范围
	 */
	public String getIapScope() {
		return iapScope;
	}

	/**
	 * 审计范围设定
	 *
	 * @param iapScope 审计范围
	 */
	public void setIapScope(String iapScope) {
		this.iapScope = iapScope;
	}

	/**
	 * 审计依据取得
	 *
	 * @return 审计依据
	 */
	public String getIapBasis () {
		return iapBasis ;
	}

	/**
	 * 审计依据设定
	 *
	 * @param iapBasis  审计依据
	 */
	public void setIapBasis (String iapBasis ) {
		this.iapBasis  = iapBasis ;
	}

	/**
	 * 审计内容及要点取得
	 *
	 * @return 审计内容及要点
	 */
	public String getIapDesc() {
		return iapDesc;
	}

	/**
	 * 审计内容及要点设定
	 *
	 * @param iapDesc 审计内容及要点
	 */
	public void setIapDesc(String iapDesc) {
		this.iapDesc = iapDesc;
	}

	/**
	 * 审计配合人员取得
	 *
	 * @return 审计配合人员
	 */
	public String getIapCooperator() {
		return iapCooperator;
	}

	/**
	 * 审计配合人员设定
	 *
	 * @param iapCooperator 审计配合人员
	 */
	public void setIapCooperator(String iapCooperator) {
		this.iapCooperator = iapCooperator;
	}

	/**
	 * 审计建议取得
	 *
	 * @return 审计建议
	 */
	public String getIapSuggestion() {
		return iapSuggestion;
	}

	/**
	 * 审计建议设定
	 *
	 * @param iapSuggestion 审计建议
	 */
	public void setIapSuggestion(String iapSuggestion) {
		this.iapSuggestion = iapSuggestion;
	}

	/**
	 * 审计项目发起人ID取得
	 *
	 * @return 审计项目发起人ID
	 */
	public String getIapCreateUserId() {
		return iapCreateUserId;
	}

	/**
	 * 审计项目发起人ID设定
	 *
	 * @param iapCreateUserId 审计项目发起人ID
	 */
	public void setIapCreateUserId(String iapCreateUserId) {
		this.iapCreateUserId = iapCreateUserId;
	}

	/**
	 * 审计项目发起时间取得
	 *
	 * @return 审计项目发起时间
	 */
	public String getIapCreateTime() {
		return iapCreateTime;
	}

	/**
	 * 审计项目发起时间设定
	 *
	 * @param iapCreateTime 审计项目发起时间
	 */
	public void setIapCreateTime(String iapCreateTime) {
		this.iapCreateTime = iapCreateTime;
	}

	/**
	 * 审计项目确认人ID取得
	 *
	 * @return 审计项目确认人ID
	 */
	public String getIapConfirmUserId() {
		return iapConfirmUserId;
	}

	/**
	 * 审计项目确认人ID设定
	 *
	 * @param iapConfirmUserId 审计项目确认人ID
	 */
	public void setIapConfirmUserId(String iapConfirmUserId) {
		this.iapConfirmUserId = iapConfirmUserId;
	}

	/**
	 * 审计项目确认时间取得
	 *
	 * @return 审计项目确认时间
	 */
	public String getIapConfirmTime() {
		return iapConfirmTime;
	}

	/**
	 * 审计项目确认时间设定
	 *
	 * @param iapConfirmTime 审计项目确认时间
	 */
	public void setIapConfirmTime(String iapConfirmTime) {
		this.iapConfirmTime = iapConfirmTime;
	}

	/**
	 * 审计附件Key取得
	 *
	 * @return 审计附件Key
	 */
	public String getIapAttKey() {
		return iapAttKey;
	}

	/**
	 * 审计附件Key设定
	 *
	 * @param iapAttKey 审计附件Key
	 */
	public void setIapAttKey(String iapAttKey) {
		this.iapAttKey = iapAttKey;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return iapId;
	}

	/**
	 * 审计类型取得
	 *
	 * @return 审计类型
	 */
	public String getIapType() {
		return iapType;
	}

	/**
	 * 审计类型设定
	 *
	 * @param iapType 审计类型
	 */
	public void setIapType(String iapType) {
		this.iapType = iapType;
	}

	/**
	 * 审计检查来源取得
	 *
	 * @return 审计检查来源
	 */
	public String getIapSource() {
		return iapSource;
	}

	/**
	 * 审计检查来源设定
	 *
	 * @param iapSource 审计检查来源
	 */
	public void setIapSource(String iapSource) {
		this.iapSource = iapSource;
	}

}