/*	
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。	
 */
package com.deliverik.infogovernor.crc.dto;

import java.util.List;

import com.deliverik.framework.base.ExcelDTO;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.IG599Info;

/**
 * 概述:变更管理导出DTO 
 * 创建记录：刁泽旭 2014/07/07
 */
public class IGCRC09ExcelDTO extends ExcelDTO {
	/** 流信息集合 */
	protected List<IG500Info> processList;
	/** 表单值 */
	protected List<IG599Info> processInfoList;
	/** 参与人 */
	protected List<IG337Info> processParticipantList;
	/** 状态定义 */
	protected List<IG333Info> processStatusDefList;

	/**
	 * 返回流程信息集合
	 * 
	 * @return
	 */
	public List<IG500Info> getProcessList() {
		return processList;
	}

	/**
	 * 获取流程信息集合
	 * 
	 * @param processList
	 */
	public void setProcessList(List<IG500Info> processList) {
		this.processList = processList;
	}

	/**
	 * 返回表单信息集合
	 * 
	 * @return
	 */
	public List<IG599Info> getProcessInfoList() {
		return processInfoList;
	}

	/**
	 * 获取表单信息集合
	 * 
	 * @param processInfoList
	 */
	public void setProcessInfoList(List<IG599Info> processInfoList) {
		this.processInfoList = processInfoList;
	}

	/**
	 * 返回参与人集合
	 * 
	 * @return
	 */
	public List<IG337Info> getProcessParticipantList() {
		return processParticipantList;
	}

	/**
	 * 获取参与人集合
	 * 
	 * @param processParticipantList
	 */
	public void setProcessParticipantList(List<IG337Info> processParticipantList) {
		this.processParticipantList = processParticipantList;
	}

	/**
	 * 返回状态定义集合
	 * 
	 * @return
	 */
	public List<IG333Info> getProcessStatusDefList() {
		return processStatusDefList;
	}

	/**
	 * 获取状态定义集合
	 * 
	 * @param processStatusDefList
	 */
	public void setProcessStatusDefList(List<IG333Info> processStatusDefList) {
		this.processStatusDefList = processStatusDefList;
	}

}
