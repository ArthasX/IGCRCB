/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prr.dto;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.workflow.prd.model.IG110Info;
import com.deliverik.framework.workflow.prd.model.IG111Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.infogovernor.prr.model.condition.ProcessSearchCond;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程查询DTO
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGPRR06DTO extends BaseDTO{
	
	/** 流程定义ID */
	protected String pdid;

	/** 允许查询的最大记录数 */
	protected int maxSearchCount;

	/** 分页Bean */
	protected PagingDTO pagingDto;
	
	/** 查询结果 */
	protected List<Map<String, Object>> result;
	
	/**  流程查询显示列集合 */
	protected List<IG110Info> processQueryShowColumnList;
	
	/** 流程查询条件定义集合 */
	protected List<IG111Info> processQueryList; 
	
	/** 流程查询条件 */
	protected ProcessSearchCond processSearchCond;
	
	/** 状态信息定义集合 */
	protected List<IG333Info> psdList;
	
	/** 响应对象 */
	protected HttpServletResponse response;
	
	/** 流程跳转JSP */
	protected String forwardJsp;
	
	protected User user;

	/**
	 * 流程定义ID取得
	 * @return pdid 流程定义ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * 流程定义ID设定
	 * @param pdid 流程定义ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * 允许查询的最大记录数取得
	 * @return maxSearchCount 允许查询的最大记录数
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * 允许查询的最大记录数设定
	 * @param maxSearchCount 允许查询的最大记录数
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * 分页Bean取得
	 * @return pagingDto 分页Bean
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * 分页Bean设定
	 * @param pagingDto 分页Bean
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	/**
	 * 查询结果取得
	 * @return result 查询结果
	 */
	public List<Map<String, Object>> getResult() {
		return result;
	}

	/**
	 * 查询结果设定
	 * @param result 查询结果
	 */
	public void setResult(List<Map<String, Object>> result) {
		this.result = result;
	}

	/**
	 * 流程查询显示列集合取得
	 * @return processQueryShowColumnList 流程查询显示列集合
	 */
	public List<IG110Info> getProcessQueryShowColumnList() {
		return processQueryShowColumnList;
	}

	/**
	 * 流程查询显示列集合设定
	 * @param processQueryShowColumnList 流程查询显示列集合
	 */
	public void setProcessQueryShowColumnList(
			List<IG110Info> processQueryShowColumnList) {
		this.processQueryShowColumnList = processQueryShowColumnList;
	}

	/**
	 * 流程查询条件定义集合取得
	 * @return processQueryList 流程查询条件定义集合
	 */
	public List<IG111Info> getProcessQueryList() {
		return processQueryList;
	}

	/**
	 * 流程查询条件定义集合设定
	 * @param processQueryList 流程查询条件定义集合
	 */
	public void setProcessQueryList(List<IG111Info> processQueryList) {
		this.processQueryList = processQueryList;
	}

	/**
	 * 流程查询条件取得
	 * @return processSearchCond 流程查询条件
	 */
	public ProcessSearchCond getProcessSearchCond() {
		return processSearchCond;
	}

	/**
	 * 流程查询条件设定
	 * @param processSearchCond 流程查询条件
	 */
	public void setProcessSearchCond(ProcessSearchCond processSearchCond) {
		this.processSearchCond = processSearchCond;
	}

	/**
	 * 状态信息定义集合取得
	 * @return psdList 状态信息定义集合
	 */
	public List<IG333Info> getPsdList() {
		return psdList;
	}

	/**
	 * 状态信息定义集合设定
	 * @param psdList 状态信息定义集合
	 */
	public void setPsdList(List<IG333Info> psdList) {
		this.psdList = psdList;
	}

	/**
	 * 响应对象取得
	 * @return response 响应对象
	 */
	public HttpServletResponse getResponse() {
		return response;
	}

	/**
	 * 响应对象设定
	 * @param response 响应对象
	 */
	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
	/**
	 * 流程跳转JSP取得
	 * @return 流程跳转JSP
	 */
	public String getForwardJsp() {
		return forwardJsp;
	}

	/**
	 * 流程跳转JSP设定
	 * @param forwardJsp流程跳转JSP
	 */
	public void setForwardJsp(String forwardJsp) {
		this.forwardJsp = forwardJsp;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
