/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.crc.dto;

import java.util.List;
import com.deliverik.framework.base.BaseDTO;
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
 * Description: 对外服务DTO
 * </p>
 * 
 * @author zhangxinru 2016/02/25
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGCRC30DTO extends BaseDTO{

    protected IGWKM0101Form igwkm0101form;
	

	/** 流程信息集合 */
	protected List<IG500Info> processList;
	
	/** 表单值*/
	protected List<IG599Info> processInfoList;
	/** 参与人*/
	protected List<IG337Info> processParticipantList;
	/** 状态定义*/
	protected List<IG333Info> processStatusDefList;
	

	

	

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
