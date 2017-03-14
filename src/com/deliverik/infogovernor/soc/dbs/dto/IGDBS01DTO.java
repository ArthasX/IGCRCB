/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */
package com.deliverik.infogovernor.soc.dbs.dto;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.user.model.User;

public class IGDBS01DTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 运维管理
	 */
	protected String operationManagement;
	
	/**
	 * 获得存储饼图all
	 */	
	protected String pieall;
	/**
	 * 获得存储list
	 */
	protected String warninglist;
	/**
	 * 业务运行
	 */
	protected String businessRus;
		
	/**
	 * 流程KPI
	 */
	protected String processKPI;
	
	/**
	 * 运维管理日历
	 */
	protected String valueOfDate;
	/**
	 * 用户信息
	 */
	
	/**
	 * 主机序列号
	 */
	protected String symmid;
	
	/**
	 * 主机选择键0为上，1为下
	 */
	protected String hostchoose;
	
	/**
	 * IOPS、吞吐量xml
	 */
	protected String iopsThroughput;
	
	/**
	 * 功能: 读比率/写比率/缓存命中率
	 */
	protected String readperWriteperHitper;
	
	/**
	 * 主机详细信息
	 */
	protected String hostInfo;
	
	/**
	 * 语言标志
	 */
	protected String language;
	
	/** 存储类型 */
	protected String symm_type;
	
	
	/**
	 * 存储类型取得
	 *
	 * @return symm_type 存储类型
	 */
	
	public String getSymm_type() {
		return symm_type;
	}

	/**
	 * 存储类型设定
	 *
	 * @param symm_type 存储类型
	 */
	
	public void setSymm_type(String symm_type) {
		this.symm_type = symm_type;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	protected User user;
	public String getOperationManagement() {
		return operationManagement;
	}

	public void setOperationManagement(String operationManagement) {
		this.operationManagement = operationManagement;
	}

	public String getValueOfDate() {
		return valueOfDate;
	}

	public void setValueOfDate(String valueOfDate) {
		this.valueOfDate = valueOfDate;
	}

	public String getBusinessRus() {
		return businessRus;
	}

	public void setBusinessRus(String businessRus) {
		this.businessRus = businessRus;
	}
	
	public String getProcessKPI() {
		return processKPI;
	}
	
	public void setProcessKPI(String processKPI) {
		this.processKPI = processKPI;
	}

	/**
	 * 返回用户信息
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * 设置用户信息
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	public String getSymmid() {
		return symmid;
	}

	public void setSymmid(String symmid) {
		this.symmid = symmid;
	}

	public String getHostchoose() {
		return hostchoose;
	}

	public void setHostchoose(String hostchoose) {
		this.hostchoose = hostchoose;
	}

	public String getIopsThroughput() {
		return iopsThroughput;
	}

	public void setIopsThroughput(String iopsThroughput) {
		this.iopsThroughput = iopsThroughput;
	}

	public String getReadperWriteperHitper() {
		return readperWriteperHitper;
	}

	public void setReadperWriteperHitper(String readperWriteperHitper) {
		this.readperWriteperHitper = readperWriteperHitper;
	}

	public String getHostInfo() {
		return hostInfo;
	}

	public void setHostInfo(String hostInfo) {
		this.hostInfo = hostInfo;
	}

	/**
	 * 获得存储饼图all取得
	 *
	 * @return pieall 获得存储饼图all
	 */
	public String getPieall() {
		return pieall;
	}

	/**
	 * 获得存储list取得
	 *
	 * @return warninglist 获得存储list
	 */
	public String getWarninglist() {
		return warninglist;
	}

	/**
	 * 获得存储饼图all设定
	 *
	 * @param pieall 获得存储饼图all
	 */
	public void setPieall(String pieall) {
		this.pieall = pieall;
	}

	/**
	 * 获得存储list设定
	 *
	 * @param warninglist 获得存储list
	 */
	public void setWarninglist(String warninglist) {
		this.warninglist = warninglist;
	}

	
	
	
}