/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.crc.dto;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.infogovernor.crc.form.IGCRC2301Form;
import com.deliverik.infogovernor.crc.model.IGCRC2301VWInfo;
import com.deliverik.infogovernor.crc.model.condition.IGCRC2301Cond;

/**	
 * 概述:程序开发统计查询用DTO
 * 创建记录：yukexin    2014-8-15 下午5:15:49	
 * 修改记录：null
 */	
@SuppressWarnings("serial")
public class IGCRC2301DTO extends BaseDTO implements Serializable{
	
	
	/** 程序开发统计查询画面FORM */
	private IGCRC2301Form igcrc2301Form;
	
	/** 程序开发统计信息检索条件 */
	protected IGCRC2301Cond entityItemVWSearchCond;

	/** 翻页用DTO */
	protected PagingDTO pagingDto;
	
	/** 流程信息集合 */
	protected List<IG500Info> processList;

	/** 程序开发统计检索结果 不带合计 */
	protected List<IGCRC2301VWInfo> entityItemVWInfoList;
	
	/** 检索最大件数 */
	protected int maxSearchCount;

	/**
	 * 翻页用DTO取得
	 * @return 翻页用DTO
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * 翻页用DTO设定
	 *
	 * @param pagingDto 翻页用DTO
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	/**
	 * 程序开发统计信息检索结果取得
	 * @return 程序开发统计信息检索结果
	 */
	public List<IGCRC2301VWInfo> getEntityItemVWInfoList() {
		return entityItemVWInfoList;
	}

	/**
	 * 程序开发统计信息检索结果设定
	 *
	 * @param entityItemVWInfoList 程序开发统计信息检索结果
	 */
	public void setEntityItemVWInfoList(List<IGCRC2301VWInfo> entityItemVWInfoList) {
		this.entityItemVWInfoList = entityItemVWInfoList;
	}

	public IGCRC2301Form getIgcrc2301Form() {
		return igcrc2301Form;
	}

	public void setIgcrc2301Form(IGCRC2301Form igcrc2301Form) {
		this.igcrc2301Form = igcrc2301Form;
	}

	
	/**
	 * @return the processList
	 */
	public List<IG500Info> getProcessList() {
		return processList;
	}

	/**
	 * @param processList the processList to set
	 */
	public void setProcessList(List<IG500Info> processList) {
		this.processList = processList;
	}

	/**
	 * 程序开发统计信息检索条件取得
	 * @return 程序开发统计信息检索条件
	 */
	public IGCRC2301Cond getEntityItemVWSearchCond() {
		return entityItemVWSearchCond;
	}

	/**
	 * 程序开发统计信息检索条件设定
	 *
	 * @param entityItemVWSearchCond 程序开发统计信息检索条件
	 */
	public void setEntityItemVWSearchCond(IGCRC2301Cond entityItemVWSearchCond) {
		this.entityItemVWSearchCond = entityItemVWSearchCond;
	}

	/**
	 * @return the maxSearchCount
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * @param maxSearchCount the maxSearchCount to set
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	
}
