/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prr.dto;

import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.workflow.prr.model.IG483Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.condition.IG483SearchCond;

/**
 * 概述: 流程组DTO
 * 功能描述: 流程组DTO
 * 创建记录: 2015/02/03
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGPRR05DTO extends BaseDTO {
	
	/**允许查询的最大记录数*/
	protected int maxSearchCount;

	/**分页Bean*/
	protected PagingDTO pagingDto;

	/** 流程组查询条件 */
	protected IG483SearchCond ig483SearchCond;
	
	/** 流程组列表 */
	protected List<IG483Info> lst_IG483Info;

	/** 流程组成员列表 */
	protected List<IG500Info> lst_IG500Info;
	
	/** 流程组ID */
	protected Integer pgrid;

	/**
	 * 获取允许查询的最大记录数
	 * @return 允许查询的最大记录数
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * 设置允许查询的最大记录数
	 * @param maxSearchCount 允许查询的最大记录数
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * 获取分页Bean
	 * @return 分页Bean
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * 设置分页Bean
	 * @param pagingDto 分页Bean
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}
	
	/**
	 * 流程组查询条件取得
	 * @return 流程组查询条件
	 */
	public IG483SearchCond getIg483SearchCond() {
		return ig483SearchCond;
	}

	/**
	 * 流程组查询条件设定
	 * @param ig483SearchCond 流程组查询条件
	 */
	public void setIg483SearchCond(IG483SearchCond ig483SearchCond) {
		this.ig483SearchCond = ig483SearchCond;
	}

	/**
	 * 流程组列表取得
	 * @return 流程组列表
	 */
	public List<IG483Info> getLst_IG483Info() {
		return lst_IG483Info;
	}

	/**
	 * 流程组列表设定
	 * @param lst_IG483Info 流程组列表
	 */
	public void setLst_IG483Info(List<IG483Info> lst_IG483Info) {
		this.lst_IG483Info = lst_IG483Info;
	}

	/**
	 * 流程组成员列表取得
	 * @return 流程组成员列表
	 */
	public List<IG500Info> getLst_IG500Info() {
		return lst_IG500Info;
	}

	/**
	 * 流程组成员列表设定
	 * @param lst_IG500Info 流程组成员列表
	 */
	public void setLst_IG500Info(List<IG500Info> lst_IG500Info) {
		this.lst_IG500Info = lst_IG500Info;
	}

	/**
	 * 流程组ID取得
	 * @return 流程组ID
	 */
	public Integer getPgrid() {
		return pgrid;
	}

	/**
	 * 流程组ID设定
	 * @param pgrid 流程组ID
	 */
	public void setPgrid(Integer pgrid) {
		this.pgrid = pgrid;
	}
	
}
