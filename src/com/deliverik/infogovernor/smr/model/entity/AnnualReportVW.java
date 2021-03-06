/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.smr.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.infogovernor.smr.model.AnnualReportVWInfo;

/**
 * 概述:年报视图
 * 功能描述：年报视图
 * 创建人：赵梓廷
 * 创建记录： 2013-07-29
 * 修改记录：
 */
@Entity
public class AnnualReportVW implements AnnualReportVWInfo{
	
	@Id
	protected Integer prid;

	protected Integer instanceID;

	/** 组类型 */
	protected String prtype;

	/** 组标识 */
	protected String key;

	/** 填报发起时间 */
	protected String inittime;

	/** 填报结束时间 */
	protected String endtime;

	/** 填报限制时间 */
	protected String limittime;

	/** 备注 */
	protected String remark;

	/** 状态：0开启，1关闭，2中止 */
	protected String status;
	
	/** 发起人ID */
	protected String userid;
	
	/** 发起人姓名 */
	protected String username;
	
	/** 年报说明 */
	protected String reportdesc;
	
	/** 流程名 */
	protected String prtitle;
	
	/** 流程状态名 */
	protected String psdname;
	
	/** 当前状态 */
	protected String prstatus;
	
	/** 是否报送空表标识 */
	protected String flag;
	
	/** 上报报表年份 */
	protected String year;
	
	/** 上报报表季度 */
	protected String quarter;
	
		
	public Integer getPrid() {
		return prid;
	}

	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * 自增ID取得
	 *
	 * @return 自增ID
	 */
	public Integer getInstanceID() {
		return instanceID;
	}

	/**
	 * 自增ID设定
	 *
	 * @param instanceID 自增ID
	 */
	public void setInstanceID(Integer instanceID) {
		this.instanceID = instanceID;
	}

	/**
	 * 组类型取得
	 *
	 * @return 组类型
	 */
	public String getPrtype() {
		return prtype;
	}

	/**
	 * 组类型设定
	 *
	 * @param prtype 组类型
	 */
	public void setPrtype(String prtype) {
		this.prtype = prtype;
	}

	/**
	 * 组标识取得
	 *
	 * @return 组标识
	 */
	public String getKey() {
		return key;
	}

	/**
	 * 组标识设定
	 *
	 * @param key 组标识
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * 填报发起时间取得
	 *
	 * @return 填报发起时间
	 */
	public String getInittime() {
		return inittime;
	}

	/**
	 * 填报发起时间设定
	 *
	 * @param inittime 填报发起时间
	 */
	public void setInittime(String inittime) {
		this.inittime = inittime;
	}

	/**
	 * 填报结束时间取得
	 *
	 * @return 填报结束时间
	 */
	public String getEndtime() {
		return endtime;
	}

	/**
	 * 填报结束时间设定
	 *
	 * @param endtime 填报结束时间
	 */
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	/**
	 * 填报限制时间取得
	 *
	 * @return 填报限制时间
	 */
	public String getLimittime() {
		return limittime;
	}

	/**
	 * 填报限制时间设定
	 *
	 * @param limittime 填报限制时间
	 */
	public void setLimittime(String limittime) {
		this.limittime = limittime;
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
	 * 状态取得
	 *
	 * @return 状态
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * 状态设定
	 *
	 * @param status 状态
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * 发起人ID
	 * 
	 * @return 发起人ID
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * 发起人ID
	 * @param userid 发起人ID
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * 发起人姓名
	 * @return 发起人姓名
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * 发起人姓名
	 * @param username 发起人姓名
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * 年报说明
	 * @return 年报说明
	 */
	public String getReportdesc() {
		return reportdesc;
	}
	/**
	 * 年报说明
	 * @param reportdesc 年报说明
	 */
	public void setReportdesc(String reportdesc) {
		this.reportdesc = reportdesc;
	}
	
	/**
	 * 流程名
	 * @return 流程名
	 */
	public String getPrtitle() {
		return prtitle;
	}
	
	/**
	 * 流程名
	 * @param prtitle 流程名
	 */
	public void setPrtitle(String prtitle) {
		this.prtitle = prtitle;
	}

	/**
	 * 流程状态名取得
	 *
	 * @return psdname 流程状态名
	 */
	public String getPsdname() {
		return psdname;
	}

	/**
	 * 流程状态名设定
	 *
	 * @param psdname 流程状态名
	 */
	public void setPsdname(String psdname) {
		this.psdname = psdname;
	}

	/**
	 * 当前状态取得
	 *
	 * @return prstatus 当前状态
	 */
	public String getPrstatus() {
		return prstatus;
	}

	/**
	 * 当前状态设定
	 *
	 * @param prstatus 当前状态
	 */
	public void setPrstatus(String prstatus) {
		this.prstatus = prstatus;
	}

	/**
	 * 是否报送空表标识取得
	 *
	 * @return flag 是否报送空表标识
	 */
	public String getFlag() {
		return flag;
	}

	/**
	 * 是否报送空表标识设定
	 *
	 * @param flag 是否报送空表标识
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}

	/**
	 * 上报报表年份取得
	 *
	 * @return year 上报报表年份
	 */
	public String getYear() {
		return year;
	}

	/**
	 * 上报报表年份设定
	 *
	 * @param year 上报报表年份
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * 上报报表季度取得
	 *
	 * @return quarter 上报报表季度
	 */
	public String getQuarter() {
		return quarter;
	}

	/**
	 * 上报报表季度设定
	 *
	 * @param quarter 上报报表季度
	 */
	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}

}
