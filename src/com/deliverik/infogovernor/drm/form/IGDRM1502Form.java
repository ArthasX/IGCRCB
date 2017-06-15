/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.drm.form;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author zhangying@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGDRM1502Form extends BaseForm {

	/** 主键 */
	protected  Integer tpid;

	/** 计划名称 */
	protected String tpname;

	/** 发起人id */
	protected String tpuserid;

	/** 发起人姓名 */
	protected String tpusername;

	/** 发起部门id */
	protected String tporgid;

	/** 发起部门名称 */
	protected String tporgname;

	/** 发起日期 */
	protected String tptime;

	/** 计划状态 */
	protected String tpstatus;
	
	/** 培训课程 */
	protected String[] tmcourse;

	/** 培训机构 */
	protected String[] tmorg;

	/** 培训时间 */
	protected String[] tmtime;

	/** 培训对象 */
	protected String[] tmtarget;

	/** 附件 */
	protected String[] tmatt;
	/**
	 * 发起时间
	 */
	private String startTime;

	/**
	 * @return the startTime
	 */
	public String getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getTpid() {
		return tpid;
	}

	/**
	 * 主键设定
	 *
	 * @param tpid 主键
	 */
	public void setTpid(Integer tpid) {
		this.tpid = tpid;
	}

	/**
	 * 计划名称取得
	 *
	 * @return 计划名称
	 */
	public String getTpname() {
		return tpname;
	}

	/**
	 * 计划名称设定
	 *
	 * @param tpname 计划名称
	 */
	public void setTpname(String tpname) {
		this.tpname = tpname;
	}

	/**
	 * 发起人id取得
	 *
	 * @return 发起人id
	 */
	public String getTpuserid() {
		return tpuserid;
	}

	/**
	 * 发起人id设定
	 *
	 * @param tpuserid 发起人id
	 */
	public void setTpuserid(String tpuserid) {
		this.tpuserid = tpuserid;
	}

	/**
	 * 发起人姓名取得
	 *
	 * @return 发起人姓名
	 */
	public String getTpusername() {
		return tpusername;
	}

	/**
	 * 发起人姓名设定
	 *
	 * @param tpusername 发起人姓名
	 */
	public void setTpusername(String tpusername) {
		this.tpusername = tpusername;
	}

	/**
	 * 发起部门id取得
	 *
	 * @return 发起部门id
	 */
	public String getTporgid() {
		return tporgid;
	}

	/**
	 * 发起部门id设定
	 *
	 * @param tporgid 发起部门id
	 */
	public void setTporgid(String tporgid) {
		this.tporgid = tporgid;
	}

	/**
	 * 发起部门名称取得
	 *
	 * @return 发起部门名称
	 */
	public String getTporgname() {
		return tporgname;
	}

	/**
	 * 发起部门名称设定
	 *
	 * @param tporgname 发起部门名称
	 */
	public void setTporgname(String tporgname) {
		this.tporgname = tporgname;
	}

	/**
	 * 发起日期取得
	 *
	 * @return 发起日期
	 */
	public String getTptime() {
		return tptime;
	}

	/**
	 * 发起日期设定
	 *
	 * @param tptime 发起日期
	 */
	public void setTptime(String tptime) {
		this.tptime = tptime;
	}

	/**
	 * 计划状态取得
	 *
	 * @return 计划状态
	 */
	public String getTpstatus() {
		return tpstatus;
	}

	/**
	 * 计划状态设定
	 *
	 * @param tpstatus 计划状态
	 */
	public void setTpstatus(String tpstatus) {
		this.tpstatus = tpstatus;
	}
	
	/**
	 * 培训课程取得
	 *
	 * @return 培训课程
	 */
	public String[] getTmcourse() {
		return tmcourse;
	}

	/**
	 * 培训课程设定
	 *
	 * @param tmcourse 培训课程
	 */
	public void setTmcourse(String[] tmcourse) {
		this.tmcourse = tmcourse;
	}

	/**
	 * 培训机构取得
	 *
	 * @return 培训机构
	 */
	public String[] getTmorg() {
		return tmorg;
	}

	/**
	 * 培训机构设定
	 *
	 * @param tmorg 培训机构
	 */
	public void setTmorg(String[] tmorg) {
		this.tmorg = tmorg;
	}

	/**
	 * 培训时间取得
	 *
	 * @return 培训时间
	 */
	public String[] getTmtime() {
		return tmtime;
	}

	/**
	 * 培训时间设定
	 *
	 * @param tmtime 培训时间
	 */
	public void setTmtime(String[] tmtime) {
		this.tmtime = tmtime;
	}

	/**
	 * 培训对象取得
	 *
	 * @return 培训对象
	 */
	public String[] getTmtarget() {
		return tmtarget;
	}

	/**
	 * 培训对象设定
	 *
	 * @param tmtarget 培训对象
	 */
	public void setTmtarget(String[] tmtarget) {
		this.tmtarget = tmtarget;
	}

	/**
	 * 附件取得
	 *
	 * @return 附件
	 */
	public String[] getTmatt() {
		return tmatt;
	}

	/**
	 * 附件设定
	 *
	 * @param tmatt 附件
	 */
	public void setTmatt(String[] tmatt) {
		this.tmatt = tmatt;
	}
	
	
}
