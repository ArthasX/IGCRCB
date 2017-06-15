/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */

package com.deliverik.infogovernor.soc.prm.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.IG259Info;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 查询流程类型DTO 
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGPRM00DTO extends BaseDTO implements Serializable {
	
	/**用户ID*/
	private String userid;
	
	/**流程类型*/
	private String processType;
	
	/**任务调度标识（p 个人任务 e 指派任务）*/
	private String ptqrtzflag;
	
	/**流程定义树*/
	private Map<String,TreeNode> treeNodeMap;
	
	/**工作定义集合*/
	private Map<IG259Info,List<IG380Info>> templateDefinitionMap;
	
	/**页面来源*/
	private String page;
	
	/**标准流程模板**/
	private IG259Info gpt;
	
	/**自定义流程模板**/
	private IG259Info spt;
	
	protected Locale locale;

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}
	public String getPtqrtzflag() {
		return ptqrtzflag;
	}

	public void setPtqrtzflag(String ptqrtzflag) {
		this.ptqrtzflag = ptqrtzflag;
	}

	/**
	 * 获取流程类型
	 * @return 流程类型
	 */
	public String getProcessType() {
		return processType;
	}

	/**
	 * 设置流程类型
	 * @param processType 流程类型
	 */
	public void setProcessType(String processType) {
		this.processType = processType;
	}

	/**
	 * 获取流程定义树
	 * @return 流程定义树
	 */
	public Map<String, TreeNode> getTreeNodeMap() {
		return treeNodeMap;
	}

	/**
	 * 设置流程定义树
	 * @param treeNodeMap 流程定义树
	 */
	public void setTreeNodeMap(Map<String, TreeNode> treeNodeMap) {
		this.treeNodeMap = treeNodeMap;
	}

	/**
	 * 获取工作定义集合
	 * @return 工作定义集合
	 */
	public Map<IG259Info, List<IG380Info>> getTemplateDefinitionMap() {
		return templateDefinitionMap;
	}
	

	/**
	 * 设置工作定义集合
	 * @param map 工作定义集合
	 */
	public void setTemplateDefinitionMap(Map<IG259Info, List<IG380Info>> templateDefinitionMap) {
		this.templateDefinitionMap = templateDefinitionMap;
	}
	
	/**
	 * 获取用户ID
	 * @return 用户ID
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * 设置用户ID
	 * @param userid 用户ID
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public IG259Info getGpt() {
		return gpt;
	}

	public void setGpt(IG259Info gpt) {
		this.gpt = gpt;
	}

	public IG259Info getSpt() {
		return spt;
	}

	public void setSpt(IG259Info spt) {
		this.spt = spt;
	}
	
}