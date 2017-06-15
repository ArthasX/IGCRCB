/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.svc.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程管理_问题管理_查询VO
 * </p>
 * 
 * @author yangsn@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSVC11011VO extends BaseVO implements Serializable {

	/**
	 * 问题对象List
	 */
	
	protected List<IG500Info> processList;
	protected String[] detailPgs;
	private Map<String,String> detailPgMap;
	protected List<IG380Info> processDefinitionList;
	
	/**
	 * 获取问题对象List
	 * @return List<ProcessRecord>
	 */
	
	public List<IG500Info> getProcessList() {
		return processList;
	}

	public String[] getDetailPgs() {
		return detailPgs;
	}

	public void setDetailPgs(String[] detailPgs) {
		this.detailPgs = detailPgs;
	}
	public void setDetailPgMap(Map<String,String> detailPgMap) {
		this.detailPgMap = detailPgMap;
	}

	public Map<String, String> getDetailPgMap() {
		return detailPgMap;
	}

	public List<IG380Info> getProcessDefinitionList() {
		return processDefinitionList;
	}

	public void setProcessDefinitionList(
			List<IG380Info> processDefinitionList) {
		this.processDefinitionList = processDefinitionList;
	}

	public void setProcessList(List<IG500Info> processList) {
		this.processList = processList;
	}
}
