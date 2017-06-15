/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.mnt.form;

import com.deliverik.framework.base.BaseForm;

/**
 * debug监控任务FORM
 * IGMNT0107Form ActionForm
 */
public class IGMNT0107Form extends BaseForm {

	private static final long serialVersionUID = 1L;
	/** 对象id */
	protected Integer moId;
	
	/** 任务id */
	protected Integer mtId;

	/** 存储序列号 */
	protected String mtSsn;

	/** 组件名称 */
	protected String mtCname;
	/** kpi */
	protected String mtKpi;
	/** 采集间隔 */
	protected String mtInterval;

	/** 采集次数 */
	protected Integer mtNum;

	/** 开始时间 */
	protected String mtStartTime;

	/** 结束时间 */
	protected String mtStopTime;

	/** 预计结束时间 */
	protected String mtPStopTime;

	/** 任务状态 */
	protected String mtStatus;

	/** 记录时间 */
	protected String mtRecordTime;

	/** 记录用户id */
	protected String mtUserId;

	/** 用户部门ID */
	protected String mtOrgId;
	
	/**对象id*/
	protected String[] selectedid;
	
	/**组件类别标识*/
	protected String cnameIdent;
	
	/**kpi标识*/
	protected String kpiIdent;
	
	/**时间间隔标识*/
	protected String intervalIdent;
	/**时间默认*/
	protected String interValDefault;
	
	/**checkbox限制条件*/
	protected String checkedCount;
	/**
	 * 任务id取得
	 *
	 * @return mtId 任务id
	 */
	public Integer getMtId() {
		return mtId;
	}

	/**
	 * 任务id设定
	 *
	 * @param mtId 任务id
	 */
	public void setMtId(Integer mtId) {
		this.mtId = mtId;
	}

	/**
	 * 存储序列号取得
	 *
	 * @return mtSsn 存储序列号
	 */
	public String getMtSsn() {
		return mtSsn;
	}

	/**
	 * 存储序列号设定
	 *
	 * @param mtSsn 存储序列号
	 */
	public void setMtSsn(String mtSsn) {
		this.mtSsn = mtSsn;
	}

	/**
	 * 组件名称取得
	 *
	 * @return mtCname 组件名称
	 */
	public String getMtCname() {
		return mtCname;
	}

	/**
	 * 组件名称设定
	 *
	 * @param mtCname 组件名称
	 */
	public void setMtCname(String mtCname) {
		this.mtCname = mtCname;
	}

	/**
	 * kpi取得
	 *
	 * @return mtKpi kpi
	 */
	public String getMtKpi() {
		return mtKpi;
	}

	/**
	 * kpi设定
	 *
	 * @param mtKpi kpi
	 */
	public void setMtKpi(String mtKpi) {
		this.mtKpi = mtKpi;
	}

	/**
	 * 采集间隔取得
	 *
	 * @return mtInterval 采集间隔
	 */
	public String getMtInterval() {
		return mtInterval;
	}

	/**
	 * 采集间隔设定
	 *
	 * @param mtInterval 采集间隔
	 */
	public void setMtInterval(String mtInterval) {
		this.mtInterval = mtInterval;
	}

	/**
	 * 采集次数取得
	 *
	 * @return mtNum 采集次数
	 */
	public Integer getMtNum() {
		return mtNum;
	}

	/**
	 * 采集次数设定
	 *
	 * @param mtNum 采集次数
	 */
	public void setMtNum(Integer mtNum) {
		this.mtNum = mtNum;
	}

	/**
	 * 开始时间取得
	 *
	 * @return mtStartTime 开始时间
	 */
	public String getMtStartTime() {
		return mtStartTime;
	}

	/**
	 * 开始时间设定
	 *
	 * @param mtStartTime 开始时间
	 */
	public void setMtStartTime(String mtStartTime) {
		this.mtStartTime = mtStartTime;
	}

	/**
	 * 结束时间取得
	 *
	 * @return mtStopTime 结束时间
	 */
	public String getMtStopTime() {
		return mtStopTime;
	}

	/**
	 * 结束时间设定
	 *
	 * @param mtStopTime 结束时间
	 */
	public void setMtStopTime(String mtStopTime) {
		this.mtStopTime = mtStopTime;
	}

	/**
	 * 预计结束时间取得
	 *
	 * @return mtPStopTime 预计结束时间
	 */
	public String getMtPStopTime() {
		return mtPStopTime;
	}

	/**
	 * 预计结束时间设定
	 *
	 * @param mtPStopTime 预计结束时间
	 */
	public void setMtPStopTime(String mtPStopTime) {
		this.mtPStopTime = mtPStopTime;
	}

	/**
	 * 任务状态取得
	 *
	 * @return mtStatus 任务状态
	 */
	public String getMtStatus() {
		return mtStatus;
	}

	/**
	 * 任务状态设定
	 *
	 * @param mtStatus 任务状态
	 */
	public void setMtStatus(String mtStatus) {
		this.mtStatus = mtStatus;
	}

	/**
	 * 记录时间取得
	 *
	 * @return mtRecordTime 记录时间
	 */
	public String getMtRecordTime() {
		return mtRecordTime;
	}

	/**
	 * 记录时间设定
	 *
	 * @param mtRecordTime 记录时间
	 */
	public void setMtRecordTime(String mtRecordTime) {
		this.mtRecordTime = mtRecordTime;
	}

	/**
	 * 记录用户id取得
	 *
	 * @return mtUserId 记录用户id
	 */
	public String getMtUserId() {
		return mtUserId;
	}

	/**
	 * 记录用户id设定
	 *
	 * @param mtUserId 记录用户id
	 */
	public void setMtUserId(String mtUserId) {
		this.mtUserId = mtUserId;
	}

	/**
	 * 用户部门ID取得
	 *
	 * @return mtOrgId 用户部门ID
	 */
	public String getMtOrgId() {
		return mtOrgId;
	}

	/**
	 * 用户部门ID设定
	 *
	 * @param mtOrgId 用户部门ID
	 */
	public void setMtOrgId(String mtOrgId) {
		this.mtOrgId = mtOrgId;
	}

	/**
	 * 对象id取得
	 *
	 * @return moId 对象id
	 */
	public Integer getMoId() {
		return moId;
	}

	/**
	 * 对象id设定
	 *
	 * @param moId 对象id
	 */
	public void setMoId(Integer moId) {
		this.moId = moId;
	}

	/**
	 * 对象id取得
	 *
	 * @return selectedid 对象id
	 */
	public String[] getSelectedid() {
		return selectedid;
	}

	/**
	 * 对象id设定
	 *
	 * @param selectedid 对象id
	 */
	public void setSelectedid(String[] selectedid) {
		this.selectedid = selectedid;
	}

	/**
	 * 组件类别标识取得
	 *
	 * @return cnameIdent 组件类别标识
	 */
	public String getCnameIdent() {
		return cnameIdent;
	}

	/**
	 * 组件类别标识设定
	 *
	 * @param cnameIdent 组件类别标识
	 */
	public void setCnameIdent(String cnameIdent) {
		this.cnameIdent = cnameIdent;
	}

	/**
	 * kpi标识取得
	 *
	 * @return kpiIdent kpi标识
	 */
	public String getKpiIdent() {
		return kpiIdent;
	}

	/**
	 * kpi标识设定
	 *
	 * @param kpiIdent kpi标识
	 */
	public void setKpiIdent(String kpiIdent) {
		this.kpiIdent = kpiIdent;
	}

	/**
	 * 时间间隔标识取得
	 *
	 * @return intervalIdent 时间间隔标识
	 */
	public String getIntervalIdent() {
		return intervalIdent;
	}

	/**
	 * 时间间隔标识设定
	 *
	 * @param intervalIdent 时间间隔标识
	 */
	public void setIntervalIdent(String intervalIdent) {
		this.intervalIdent = intervalIdent;
	}

	/**
	 * checkbox限制条件取得
	 *
	 * @return checkedCount checkbox限制条件
	 */
	public String getCheckedCount() {
		return checkedCount;
	}

	/**
	 * checkbox限制条件设定
	 *
	 * @param checkedCount checkbox限制条件
	 */
	public void setCheckedCount(String checkedCount) {
		this.checkedCount = checkedCount;
	}

	/**
	 * 时间默认取得
	 *
	 * @return interValDefault 时间默认
	 */
	public String getInterValDefault() {
		return interValDefault;
	}

	/**
	 * 时间默认设定
	 *
	 * @param interValDefault 时间默认
	 */
	public void setInterValDefault(String interValDefault) {
		this.interValDefault = interValDefault;
	}
	
}
