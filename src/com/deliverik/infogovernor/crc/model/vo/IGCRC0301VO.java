/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.crc.model.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prd.model.IG259Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prr.model.CurrentMonthWorkVWInfo;
import com.deliverik.infogovernor.crc.model.IGCRC0208VWInfo;
import com.deliverik.infogovernor.crc.model.IGCRC0301VWInfo;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程管理_事件查询_查询VO
 * </p>
 * 
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGCRC0301VO extends BaseVO implements Serializable {

	/**
	 * 问题对象List
	 */
	
	protected List<IGCRC0301VWInfo> problemproList;
	
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
	
	public IGCRC0301VO(List<IGCRC0301VWInfo> problemproList) {
		this.problemproList = problemproList;
	}
	
	public IGCRC0301VO() {
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
	
	public List<IGCRC0301VWInfo> getProblemproList() {
		return problemproList;
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
