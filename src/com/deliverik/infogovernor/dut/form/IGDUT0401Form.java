/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dut.form;

import java.io.Serializable;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.dut.model.DelayInfo;

/**
 * 
 * 延时解锁登记form
 *
 */
public class IGDUT0401Form extends BaseForm implements DelayInfo {
	
	private static final long serialVersionUID = 1L;

	/** 主键id */
	protected Integer id;

	/** 日期时间 */
	protected String datetime;

	/** 申请单位 */
	protected String orgname;

	/** 申请标题 */
	protected String title;
	
	/** 申请标题数组 */
	protected String[] titles;
	
	/** 行长姓名 */
	protected String hzname;

	/** 行长电话 */
	protected String hztel;
	
	/** 经理姓名 */
	protected String jlname;

	/** 经理电话 */
	protected String jltel;

	/** 备注 */
	protected String remark;

	/** 开始时间 */
	protected String starttime;

	/** 结束时间 */
	protected String endtime;

	/** 操作人 */
	protected String operater;
	
	/** 解锁时间 */
	protected String unlocktime;
	
	/**
	 * 页面标题显示标志0-新增,1-变更
	 */
	protected String mode = "0";

	/**
	 * 主键id取得
	 *
	 * @return 主键id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 主键id设定
	 *
	 * @param id 主键id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 日期时间取得
	 *
	 * @return 日期时间
	 */
	public String getDatetime() {
		return datetime;
	}

	/**
	 * 日期时间设定
	 *
	 * @param delaydate 日期时间
	 */
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	/**
	 * 申请单位取得
	 *
	 * @return 申请单位
	 */
	public String getOrgname() {
		return orgname;
	}

	/**
	 * 申请单位设定
	 *
	 * @param orgname 申请单位
	 */
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	/**
	 * 行长电话取得
	 *
	 * @return 行长电话
	 */
	public String getHztel() {
		return hztel;
	}

	/**
	 * 行长电话设定
	 *
	 * @param hztel 行长电话
	 */
	public void setHztel(String hztel) {
		this.hztel = hztel;
	}

	/**
	 * 经理电话取得
	 *
	 * @return 经理电话
	 */
	public String getJltel() {
		return jltel;
	}

	/**
	 * 经理电话设定
	 *
	 * @param jltel 经理电话
	 */
	public void setJltel(String jltel) {
		this.jltel = jltel;
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
	 * @param comment 备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * 开始时间取得
	 *
	 * @return 开始时间
	 */
	public String getStarttime() {
		return starttime;
	}

	/**
	 * 开始时间设定
	 *
	 * @param starttime 开始时间
	 */
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	/**
	 * 结束时间取得
	 *
	 * @return 结束时间
	 */
	public String getEndtime() {
		return endtime;
	}

	/**
	 * 结束时间设定
	 *
	 * @param endtime 结束时间
	 */
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	/**
	 * 操作人取得
	 *
	 * @return 操作人
	 */
	public String getOperater() {
		return operater;
	}

	/**
	 * 操作人设定
	 *
	 * @param operater 操作人
	 */
	public void setOperater(String operater) {
		this.operater = operater;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return id;
	}

	/**
	 * 行长姓名取得
	 * @return
	 */
	public String getHzname() {
		return hzname;
	}

	/**
	 * 行长姓名设定
	 * @param hzname
	 */
	public void setHzname(String hzname) {
		this.hzname = hzname;
	}

	/**
	 * 经理姓名取得
	 * @return
	 */
	public String getJlname() {
		return jlname;
	}

	/**
	 * 经理姓名设定
	 * @param jlname
	 */
	public void setJlname(String jlname) {
		this.jlname = jlname;
	}

	public String getFingerPrint() {
		return null;
	}

	/**
	 * 新增、变更标识取得
	 */
	public String getMode() {
		return mode;
	}
	
	/**
	 * 新增、变更标识设定
	 * @return mode
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}
	
	/**
	 * 解锁时间取得
	 * @return
	 */
	public String getUnlocktime() {
		return unlocktime;
	}

	/**
	 * 解锁时间设定
	 * @param unlocktime
	 */
	public void setUnlocktime(String unlocktime) {
		this.unlocktime = unlocktime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String[] getTitles() {
		return titles;
	}

	public void setTitles(String[] titles) {
		this.titles = titles;
	}

}
