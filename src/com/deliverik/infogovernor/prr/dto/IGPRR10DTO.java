/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prr.dto;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.workflow.prd.model.IG380Info;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程导入DTO
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGPRR10DTO extends BaseDTO{

	/** 流程定义信息集合 */
	protected List<IG380Info> processDefinitionList;
	
	/** 响应对象 */
	protected HttpServletResponse response;

	/**
	 * 流程定义信息集合取得
	 * @return processDefinitionList 流程定义信息集合
	 */
	public List<IG380Info> getProcessDefinitionList() {
		return processDefinitionList;
	}

	/**
	 * 流程定义信息集合设定
	 * @param processDefinitionList 流程定义信息集合
	 */
	public void setProcessDefinitionList(List<IG380Info> processDefinitionList) {
		this.processDefinitionList = processDefinitionList;
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
}
