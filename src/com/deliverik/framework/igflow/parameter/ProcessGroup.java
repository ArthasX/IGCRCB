/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.igflow.parameter;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;


/**
 * 流程组发起信息
 */
public class ProcessGroup implements ProcessGroupInfo {
	
	/** 流程组发起人ID */
	private String crtuserid;

	/** 流程组定义ID */
	private String defid;
	
	/** 流程组定义状态（1测试，2发布） */
	private String defstatus;
	
	/** 流程组描述 */
	private String description;
	
	/** 流程组名称 */
	private String title;
	
	/** 流程实例名称集合 */
	public Map<String, String> processTitle = new HashMap<String, String>();

	/**
	 * 流程组发起人ID取得
	 * 
	 * @return 流程组发起人ID
	 */
	public String getCrtuserid() {
		return crtuserid;
	}

	/**
	 * 流程组定义ID取得
	 * 
	 * @return 流程组定义ID
	 */
	public String getDefid() {
		return defid;
	}

	/**
	 * 流程组定义状态取得
	 * 
	 * @return 流程组定义状态
	 */
	public String getDefstatus() {
		return defstatus;
	}

	/**
	 * 流程组描述取得
	 * 
	 * @return 流程组描述
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 流程组名称取得
	 * 
	 * @return 流程组名称
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * 流程实例名称取得
	 * @param pdid 流程定义ID
	 * @return 流程实例名称
	 */
	public String getProcessTitle(String pdid) {
		if(StringUtils.isEmpty(processTitle.get(pdid))) {
			return "";
		} else {
			return "_" + processTitle.get(pdid);
		}
	}

	/**
	 * 流程组发起人ID设定
	 * 
	 * @param crtuserid 流程组发起人ID
	 */
	public void setCrtuserid(String crtuserid) {
		this.crtuserid = crtuserid;
	}

	/**
	 * 流程组定义ID设定
	 * 
	 * @param defid 流程组定义ID
	 */
	public void setDefid(String defid) {
		this.defid = defid;
	}
	
	/**
	 * 流程组定义状态设定
	 * 
	 * @param defstatus 流程组定义状态
	 */
	public void setDefstatus(String defstatus) {
		this.defstatus = defstatus;
	}

	/**
	 * 流程组描述设定
	 * 
	 * @param description 流程组描述
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 流程组名称设定
	 * 
	 * @param title 流程组名称
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 流程实例名称集合设定
	 * 
	 * @param pdid 流程定义ID
	 * @param processTitle 流程实例名称
	 */
	public void addProcessTitle(String pdid, String processTitle) {
		this.processTitle.put(pdid, processTitle);
	}
	
}
