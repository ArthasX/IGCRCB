/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.risk.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.risk.model.CheckWorkResultInfo;

/**
  * 概述: 检查任务实体
  * 功能描述: 检查任务实体
  * 创建记录: 2014/09/02
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="CheckWorkResult")
public class CheckWorkResultTB extends BaseEntity implements Serializable,
		Cloneable, CheckWorkResultInfo {

	/** 主键 */
	@Id
	@TableGenerator(
		name="CHECKWORKRESULT_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="CHECKWORKRESULT_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="CHECKWORKRESULT_TABLE_GENERATOR")
	protected Integer cwrid;

	/** 检查策略id */
	protected Integer csid;

	/** 检查任务名称 */
	protected String cwrname;

	/** 任务开始时间 */
	protected String cwrplandate;

	/** 任务完成时间 */
	protected String cwrrealtime;

	/** 责任人id */
	protected String cwruserid;

	/** 责任人姓名 */
	protected String cwrusername;

	/** 合作责任人id */
	protected String cwrassetid;

	/** 合作责任人姓名 */
	protected String cwrassetname;

	/** 进度 */
	protected String cwrrate;
	
	/** 检查方式*/
	protected String cwrtestmode;

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getCwrid() {
		return cwrid;
	}

	/**
	 * 主键设定
	 *
	 * @param cwrid 主键
	 */
	public void setCwrid(Integer cwrid) {
		this.cwrid = cwrid;
	}

	/**
	 * 检查策略id取得
	 *
	 * @return 检查策略id
	 */
	public Integer getCsid() {
		return csid;
	}

	/**
	 * 检查策略id设定
	 *
	 * @param csid 检查策略id
	 */
	public void setCsid(Integer csid) {
		this.csid = csid;
	}

	/**
	 * 检查任务名称取得
	 *
	 * @return 检查任务名称
	 */
	public String getCwrname() {
		return cwrname;
	}

	/**
	 * 检查任务名称设定
	 *
	 * @param cwrname 检查任务名称
	 */
	public void setCwrname(String cwrname) {
		this.cwrname = cwrname;
	}

	/**
	 * 任务开始时间取得
	 *
	 * @return 任务开始时间
	 */
	public String getCwrplandate() {
		return cwrplandate;
	}

	/**
	 * 任务开始时间设定
	 *
	 * @param cwrplandate 任务开始时间
	 */
	public void setCwrplandate(String cwrplandate) {
		this.cwrplandate = cwrplandate;
	}

	/**
	 * 任务完成时间取得
	 *
	 * @return 任务完成时间
	 */
	public String getCwrrealtime() {
		return cwrrealtime;
	}

	/**
	 * 任务完成时间设定
	 *
	 * @param cwrrealtime 任务完成时间
	 */
	public void setCwrrealtime(String cwrrealtime) {
		this.cwrrealtime = cwrrealtime;
	}

	/**
	 * 责任人id取得
	 *
	 * @return 责任人id
	 */
	public String getCwruserid() {
		return cwruserid;
	}

	/**
	 * 责任人id设定
	 *
	 * @param cwruserid 责任人id
	 */
	public void setCwruserid(String cwruserid) {
		this.cwruserid = cwruserid;
	}

	/**
	 * 责任人姓名取得
	 *
	 * @return 责任人姓名
	 */
	public String getCwrusername() {
		return cwrusername;
	}

	/**
	 * 责任人姓名设定
	 *
	 * @param cwrusername 责任人姓名
	 */
	public void setCwrusername(String cwrusername) {
		this.cwrusername = cwrusername;
	}

	/**
	 * 合作责任人id取得
	 *
	 * @return 合作责任人id
	 */
	public String getCwrassetid() {
		return cwrassetid;
	}

	/**
	 * 合作责任人id设定
	 *
	 * @param cwrassetid 合作责任人id
	 */
	public void setCwrassetid(String cwrassetid) {
		this.cwrassetid = cwrassetid;
	}

	/**
	 * 合作责任人姓名取得
	 *
	 * @return 合作责任人姓名
	 */
	public String getCwrassetname() {
		return cwrassetname;
	}

	/**
	 * 合作责任人姓名设定
	 *
	 * @param cwrassetname 合作责任人姓名
	 */
	public void setCwrassetname(String cwrassetname) {
		this.cwrassetname = cwrassetname;
	}

	/**
	 * 进度取得
	 *
	 * @return 进度
	 */
	public String getCwrrate() {
		return cwrrate;
	}

	/**
	 * 进度设定
	 *
	 * @param cwrrate 进度
	 */
	public void setCwrrate(String cwrrate) {
		this.cwrrate = cwrrate;
	}

	
	/**
	 * 检查方式取得
	 * 
	 * @return the cwrtestmode
	 */
	public String getCwrtestmode() {
		return cwrtestmode;
	}

	/**
	 * 检查方式设定
	 * 
	 * @param cwrtestmode the cwrtestmode to set
	 */
	public void setCwrtestmode(String cwrtestmode) {
		this.cwrtestmode = cwrtestmode;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return cwrid;
	}

}