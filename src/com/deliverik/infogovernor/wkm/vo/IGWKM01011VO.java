/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.wkm.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.IG259Info;
import com.deliverik.framework.workflow.prr.model.CurrentMonthWorkVWInfo;
import com.deliverik.framework.workflow.prr.model.IG500Info;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程管理_变更管理_查询VO
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGWKM01011VO extends BaseVO implements Serializable {

	/**
	 * 变更对象List
	 */
	
	protected List<IG500Info> processList;
	
	protected Map<String,String> nameURLMap;
	
	protected List<IG259Info> processTemplateList;
	
	protected List<IG380Info> processDefinitionList;
	
	/** 带有当前处理人的本月工作 */
	protected List<CurrentMonthWorkVWInfo> currentManagerList;
	
	/** 三级菜单名称 */
	protected String actlabel;

	/**
	 * 三级菜单名称取得
	 *
	 * @return actlabel 三级菜单名称
	 */
	public String getActlabel() {
		return actlabel;
	}

	/**
	 * 三级菜单名称设定
	 *
	 * @param actlabel 三级菜单名称
	 */
	public void setActlabel(String actlabel) {
		this.actlabel = actlabel;
	}

	public List<IG259Info> getProcessTemplateList() {
		return processTemplateList;
	}

	public void setProcessTemplateList(List<IG259Info> processTemplateList) {
		this.processTemplateList = processTemplateList;
	}
	
	public Map<String, String> getNameURLMap() {
		return nameURLMap;
	}

	public void setNameURLMap(Map<String, String> nameURLMap) {
		this.nameURLMap = nameURLMap;
	}

	/**
	 * 构造方法
	 * @param processList List<ProcessRecord>
	 */
	
	public IGWKM01011VO(List<IG500Info> processList) {
		this.processList = processList;
	}
	
	public IGWKM01011VO() {
	}
	
	public List<IG380Info> getProcessDefinitionList() {
		return processDefinitionList;
	}

	public void setProcessDefinitionList(
			List<IG380Info> processDefinitionList) {
		this.processDefinitionList = processDefinitionList;
	}

	/**
	 * 获取变更对象List
	 * @return List<ProcessRecord>
	 */
	
	public List<IG500Info> getProcessList() {
		return processList;
	}
	
	/**
	 * 带有当前处理人的本月工作取得
	 * @return 带有当前处理人的本月工作
	 */
	public List<CurrentMonthWorkVWInfo> getCurrentManagerList() {
		return currentManagerList;
	}

	/**
	 * 带有当前处理人的本月工作设定
	 * @param currentManagerList 带有当前处理人的本月工作
	 */
	public void setCurrentManagerList(
			List<CurrentMonthWorkVWInfo> currentManagerList) {
		this.currentManagerList = currentManagerList;
	}
}
