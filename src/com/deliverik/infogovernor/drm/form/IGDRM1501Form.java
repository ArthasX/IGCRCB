/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.drm.form;

import java.util.List;
import java.util.Map;

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
public class IGDRM1501Form extends BaseForm {

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
	
	/** 发起时间开始时间 */
	protected String startTimeBegin;
	
	/** 发起时间结束时间 */
	protected String startTimeEnd;

	/** 删除培训计划对象 */
	protected String[] deleteTpid;
	
	/**
	 * 删除培训计划对象取得
	 * @return 删除培训计划对象
	 */
	public String[] getDeleteTpid() {
		return deleteTpid;
	}

	/**
	 * 删除培训计划对象设定
	 * @param deleteEiid 删除培训计划对象
	 */
	public void setDeleteTpid(String[] deleteTpid) {
		this.deleteTpid = deleteTpid;
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
	 * 发起时间开始时间取得
	 *
	 * @return 发起时间开始时间
	 */
	public String getStartTimeBegin() {
		return startTimeBegin;
	}

	/**
	 * 发起时间开始时间设定
	 *
	 * @return startTimeBegin 发起时间开始时间
	 */
	public void setStartTimeBegin(String startTimeBegin) {
		this.startTimeBegin = startTimeBegin;
	}

	/**
	 * 发起时间结束时间取得
	 *
	 * @return 发起时间结束时间
	 */
	public String getStartTimeEnd() {
		return startTimeEnd;
	}

	/**
	 * 发起时间结束时间设定
	 *
	 * @return startTimeEnd 发起时间结束时间
	 */
	public void setStartTimeEnd(String startTimeEnd) {
		this.startTimeEnd = startTimeEnd;
	}
	
	/**
	 * 结果集
	 */
	private List<Map<String, Object>> resultList;


	/**
	 * 结果集取得
	 * @return resultList 结果集
	 */
	public List<Map<String, Object>> getResultList() {
		return resultList;
	}

	/**
	 * 结果集设定
	 * @param resultList 结果集
	 */
	public void setResultList(List<Map<String, Object>> resultList) {
		this.resultList = resultList;
	}
	
}
