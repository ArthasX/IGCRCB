/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.igflow.parameter;

import java.util.Map;

/**
 * 流程发起信息
 */
public class ProcessRecord implements ProcessRecordInfo {
	
	/** 流程发起人ID */
	private String crtuserid;

	/** 流程定义ID */
	private String defid;
	
	/** 流程定义状态（0测试，1发布） */
	private String defstatus;
	
	/** 流程描述 */
	private String description;
	
	/** 表单值集合 */
	private Map<String, String> formvalue;

	/** 日志参数信息 */
	private WorkFlowLogInfo logInfo;

	/** 流程发起角色ID */
	private Integer roleid;
	
	/** 流程名称 */
	private String title;

	/** 流程组实例ID */
	public Integer groupID;
	
	/** 流程组定义ID */
	public String groupDefID;

	/**
	 * 构造函数
	 * 
	 * @param logInfo 日志参数信息
	 */
	public ProcessRecord(WorkFlowLogInfo logInfo) {
		this.logInfo = logInfo;
	}

	/**
	 * 流程发起人ID取得
	 * 
	 * @return 流程发起人ID
	 */
	public String getCrtuserid() {
		return crtuserid;
	}

	/**
	 * 流程定义ID取得
	 * 
	 * @return 流程定义ID
	 */
	public String getDefid() {
		return defid;
	}

	/**
	 * 流程定义状态取得
	 * 
	 * @return 流程定义状态
	 */
	public String getDefstatus() {
		return defstatus;
	}

	/**
	 * 流程描述取得
	 * 
	 * @return 流程描述
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 表单值集合取得
	 * 
	 * @return 表单值集合
	 */
	public Map<String, String> getFormvalue() {
		return formvalue;
	}

	/**
	 * 日志参数信息取得
	 * 
	 * @return 日志参数信息
	 */
	public WorkFlowLogInfo getLogInfo() {
		return logInfo;
	}

	/**
	 * 流程发起角色ID取得
	 * 
	 * @return 流程发起角色ID
	 */
	public Integer getRoleid() {
		return roleid;
	}

	/**
	 * 流程名称取得
	 * 
	 * @return 流程名称
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * 流程发起人ID设定
	 * 
	 * @param crtuserid 流程发起人ID
	 */
	public void setCrtuserid(String crtuserid) {
		this.crtuserid = crtuserid;
	}

	/**
	 * 流程定义ID设定
	 * 
	 * @param defid 流程定义ID
	 */
	public void setDefid(String defid) {
		this.defid = defid;
	}
	
	/**
	 * 流程定义状态设定
	 * 
	 * @param defstatus 流程定义状态
	 */
	public void setDefstatus(String defstatus) {
		this.defstatus = defstatus;
	}

	/**
	 * 流程描述设定
	 * 
	 * @param description 流程描述
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 表单值集合取得
	 * 
	 * @param formvalue
	 */
	public void setFormvalue(Map<String, String> formvalue) {
		this.formvalue = formvalue;
	}

	/**
	 * 日志参数信息设定
	 * 
	 * @param logInfo 日志参数信息
	 */
	public void setLogInfo(WorkFlowLogInfo logInfo) {
		this.logInfo = logInfo;
	}

	/**
	 * 流程发起角色ID设定
	 * 
	 * @param roleid 流程发起角色ID
	 */
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	/**
	 * 流程名称设定
	 * 
	 * @param title 流程名称
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 流程组实例ID取得
	 * 
	 * @return 流程组实例ID
	 */
	public Integer getGroupID() {
		if(groupID != null && groupID == 0) {
			return null;
		}
		return groupID;
	}

	/**
	 * 流程组实例ID设定
	 * 
	 * @param groupID 流程组实例ID
	 */
	public void setGroupID(Integer groupID) {
		this.groupID = groupID;
	}

	/**
	 * 流程组定义ID取得
	 * 
	 * @return 流程组定义ID
	 */
	public String getGroupDefID() {
		return groupDefID;
	}

	/**
	 * 流程组定义ID设定
	 * 
	 * @param groupDefID 流程组定义ID
	 */
	public void setGroupDefID(String groupDefID) {
		this.groupDefID = groupDefID;
	}
	
}
