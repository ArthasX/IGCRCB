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
import com.deliverik.infogovernor.crc.model.IGCRC0208VWInfo;
import com.deliverik.infogovernor.crc.model.IgalarmInfo;
import com.deliverik.infogovernor.wkm.form.IGWKM0101Form;

/**
 * 概述:变更管理导出DTO 
 * 创建记录：刁泽旭 2014/07/07
 */
@SuppressWarnings("serial")
public class IGCRC02ExcelDTO extends ExcelDTO {
	/** 流信息集合 */
	protected List<IGCRC0208VWInfo> processList;
	/** 表单值 */
	protected List<IG599Info> processInfoList;
	/** 参与人 */
	protected List<IG337Info> processParticipantList;
	/** 状态定义 */
	protected List<IG333Info> processStatusDefList;
	protected IGWKM0101Form igwkm0101form;
	
	/** 查询数据 */
	private List<IgalarmInfo> IgalarmInfos;
	
	/**
	 * 返回流程信息集合
	 * 
	 * @return
	 */
	public List<IGCRC0208VWInfo> getProcessList() {
		return processList;
	}

	/**
	 * 获取流程信息集合
	 * 
	 * @param processList
	 */
	public void setProcessList(List<IGCRC0208VWInfo> processList) {
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

	/**
	 * @return the igalarmInfos
	 */
	public List<IgalarmInfo> getIgalarmInfos() {
		return IgalarmInfos;
	}

	/**
	 * @param igalarmInfos the igalarmInfos to set
	 */
	public void setIgalarmInfos(List<IgalarmInfo> igalarmInfos) {
		IgalarmInfos = igalarmInfos;
	}

	
}
