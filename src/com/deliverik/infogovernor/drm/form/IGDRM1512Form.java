/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.drm.form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts.upload.FormFile;

import com.deliverik.framework.base.BaseForm;


/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 培训计划、培训任务更新Form
 * </p>
 * 
 * @author zhangying@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGDRM1512Form extends BaseForm {
	
	/** 主键ID */
	protected Integer upTpid;
	
	/**事件名称*/
	protected String upTpname;
	
	/** 发起人id */
	protected String upTpuserid;

	/** 发起人姓名 */
	protected String upTpusername;

	/** 发起部门id */
	protected String upTporgid;

	/** 发起部门名称 */
	protected String upTporgname;

	/** 发起日期 */
	protected String upTptime;

	/** 计划状态 */
	protected String upTstatus;

	
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

	/** 附件 */
	protected Map<Integer, FormFile> fileListMap = new LinkedHashMap<Integer, FormFile>();
	protected String [] attkeys;

	/**
	 * @return the fileListMap
	 */
	public Map<Integer, FormFile> getFileListMap() {
		return this.fileListMap;
	}

	/**
	 * @return the attkeys
	 */
	public String[] getAttkeys() {
		return this.attkeys;
	}

	/**
	 * @param attkeys the attkeys to set
	 */
	public void setAttkeys(String[] attkeys) {
		this.attkeys = attkeys;
	}
	
	/**
	 * 设置附件
	 * @param index 附件数组索引
	 * @param file 附件
	 */
	public void setAttachment(int index, FormFile file) {
		fileListMap.put(index, file);
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

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getUpTpid() {
		return upTpid;
	}

	/**
	 * 主键设定
	 *
	 * @param upTpid 主键
	 */
	public void setUpTpid(Integer upTpid) {
		this.upTpid = upTpid;
	}

	/**
	 * 计划名称取得
	 *
	 * @return 计划名称
	 */
	public String getUpTpname() {
		return upTpname;
	}

	/**
	 * 计划名称设定
	 *
	 * @param upTpname 计划名称
	 */
	public void setUpTpname(String upTpname) {
		this.upTpname = upTpname;
	}

	/**
	 * 发起人id取得
	 *
	 * @return 发起人id
	 */
	public String getUpTpuserid() {
		return upTpuserid;
	}

	/**
	 * 发起人id设定
	 *
	 * @param upTpuserid 发起人id
	 */
	public void setUpTpuserid(String upTpuserid) {
		this.upTpuserid = upTpuserid;
	}

	/**
	 * 发起人姓名取得
	 *
	 * @return 发起人姓名
	 */
	public String getUpTpusername() {
		return upTpusername;
	}

	/**
	 * 发起人姓名设定
	 *
	 * @param upTpusername 发起人姓名
	 */
	public void setUpTpusername(String upTpusername) {
		this.upTpusername = upTpusername;
	}

	/**
	 * 发起部门id取得
	 *
	 * @return 发起部门id
	 */
	public String getUpTporgid() {
		return upTporgid;
	}

	/**
	 * 发起部门id设定
	 *
	 * @param upTporgid 发起部门id
	 */
	public void setUpTporgid(String upTporgid) {
		this.upTporgid = upTporgid;
	}

	/**
	 * 发起部门名称取得
	 *
	 * @return 发起部门名称
	 */
	public String getUpTporgname() {
		return upTporgname;
	}

	/**
	 * 发起部门名称设定
	 *
	 * @param upTporgname 发起部门名称
	 */
	public void setUpTporgname(String upTporgname) {
		this.upTporgname = upTporgname;
	}

	/**
	 * 发起日期取得
	 *
	 * @return 发起日期
	 */
	public String getUpTptime() {
		return upTptime;
	}

	/**
	 * 发起日期设定
	 *
	 * @param upTptime 发起日期
	 */
	public void setUpTptime(String upTptime) {
		this.upTptime = upTptime;
	}

	/**
	 * 计划状态取得
	 *
	 * @return 计划状态
	 */
	public String getUpTstatus() {
		return upTstatus;
	}

	/**
	 * 计划状态设定
	 *
	 * @param upTstatus 计划状态
	 */
	public void setUpTstatus(String upTstatus) {
		this.upTstatus = upTstatus;
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
