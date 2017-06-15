/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.crc.dto;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserInfo;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.infogovernor.wkm.form.IGWKM0101Form;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 问题处理DTO
 * </p>
 * 
 * @author 史凯龙@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGCRC03DTO extends BaseDTO{

	/** 用户信息 */
	protected User user;
	
	protected IGWKM0101Form igwkm0101form;
	
	/** 流程信息集合 */
	protected List<IG500Info> processList;
	
	/** 分派信息 */
	protected Map<IG333Info, Map<Role, List<UserInfo>>> assignInfo;
	
	/** 表单定义查询条件map */
	protected Map<String, IG007Info> processInfoQueryMap;

	/** 表单值*/
	protected List<IG599Info> processInfoList;
	/** 参与人*/
	protected List<IG337Info> processParticipantList;
	/** 状态定义*/
	protected List<IG333Info> processStatusDefList;
	
	/**
	 * 用户信息取得
	 * @return user 用户信息
	 */
	public User getUser() {
		return user;
	}

	/**
	 * 用户信息设定
	 * @param user 用户信息
	 */
	public void setUser(User user) {
		this.user = user;
	}

	
	/**
	 * @return the igwkm0101form
	 */
	public IGWKM0101Form getIgwkm0101form() {
		return igwkm0101form;
	}

	/**
	 * @param igwkm0101form the igwkm0101form to set
	 */
	public void setIgwkm0101form(IGWKM0101Form igwkm0101form) {
		this.igwkm0101form = igwkm0101form;
	}

	/**
	 * 流程信息集合取得
	 * @return processList 流程信息集合
	 */
	public List<IG500Info> getProcessList() {
		return processList;
	}

	/**
	 * 流程信息集合设定
	 * @param processList 流程信息集合
	 */
	public void setProcessList(List<IG500Info> processList) {
		this.processList = processList;
	}

	/**
	 * 分派信息取得
	 * @return assignInfo 分派信息
	 */
	public Map<IG333Info, Map<Role, List<UserInfo>>> getAssignInfo() {
		return assignInfo;
	}

	/**
	 * 分派信息设定
	 * @param assignInfo 分派信息
	 */
	public void setAssignInfo(Map<IG333Info, Map<Role, List<UserInfo>>> assignInfo) {
		this.assignInfo = assignInfo;
	}

	/**
	 * 表单定义查询条件map取得
	 * @return processInfoQueryMap 表单定义查询条件map
	 */
	public Map<String, IG007Info> getProcessInfoQueryMap() {
		return processInfoQueryMap;
	}

	/**
	 * 表单定义查询条件map设定
	 * @param processInfoQueryMap 表单定义查询条件map
	 */
	public void setProcessInfoQueryMap(Map<String, IG007Info> processInfoQueryMap) {
		this.processInfoQueryMap = processInfoQueryMap;
	}

	public List<IG599Info> getProcessInfoList() {
		return processInfoList;
	}

	public void setProcessInfoList(List<IG599Info> processInfoList) {
		this.processInfoList = processInfoList;
	}

	public List<IG337Info> getProcessParticipantList() {
		return processParticipantList;
	}

	public void setProcessParticipantList(List<IG337Info> processParticipantList) {
		this.processParticipantList = processParticipantList;
	}

	public List<IG333Info> getProcessStatusDefList() {
		return processStatusDefList;
	}

	public void setProcessStatusDefList(List<IG333Info> processStatusDefList) {
		this.processStatusDefList = processStatusDefList;
	}
}
