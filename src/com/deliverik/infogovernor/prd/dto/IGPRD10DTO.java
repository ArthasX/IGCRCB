/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prd.dto;

import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.workflow.prd.model.IG380Info;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程定义DTO
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGPRD10DTO extends BaseDTO{

	/** 最大检索件数 */
	protected int maxSearchCount;

	/** 分页用DTO */
	protected PagingDTO pagingDto;
	
	/** 流程定义信息检索结果集 */
	protected List<IG380Info> processDefinitionList;
	
	/** ajax结果 */
	protected String ajaxResult;

	/**
	 * 最大检索件数取得
	 * @return maxSearchCount 最大检索件数
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * 最大检索件数设定
	 * @param maxSearchCount 最大检索件数
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * 分页用DTO取得
	 * @return pagingDto 分页用DTO
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * 分页用DTO设定
	 * @param pagingDto 分页用DTO
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	/**
	 * 流程定义信息检索结果集取得
	 * @return processDefinitionList 流程定义信息检索结果集
	 */
	public List<IG380Info> getProcessDefinitionList() {
		return processDefinitionList;
	}

	/**
	 * 流程定义信息检索结果集设定
	 * @param processDefinitionList 流程定义信息检索结果集
	 */
	public void setProcessDefinitionList(List<IG380Info> processDefinitionList) {
		this.processDefinitionList = processDefinitionList;
	}

	/**
	 * ajax结果取得
	 * @return ajaxResult ajax结果
	 */
	public String getAjaxResult() {
		return ajaxResult;
	}

	/**
	 * ajax结果设定
	 * @param ajaxResult ajax结果
	 */
	public void setAjaxResult(String ajaxResult) {
		this.ajaxResult = ajaxResult;
	}
}
