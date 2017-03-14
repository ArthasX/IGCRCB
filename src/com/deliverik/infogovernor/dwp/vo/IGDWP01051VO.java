/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dwp.vo;

import java.util.List;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prd.model.IG243Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.infogovernor.dwp.model.IGDWP0001Info;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 保存流程信息VO
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGDWP01051VO extends BaseVO{

	/** 计划信息 */
	protected IGDWP0001Info plan;
	
	/** 流程定义信息 */
	protected IG380Info processDefinition;
	
	/** 状态定义信息 */
	protected IG333Info processStatusDef;
	
	/** 下拉列表信息 */
	protected List<LabelValueBean> labelValueBeanList;
	
	/** 流程标题定义信息 */
	protected IG243Info ptdInfo;
	
	/** 流程表单定义信息集合 */
	protected List<IG007Info> processInfoList;

	/**
	 * 计划信息取得
	 * @return plan 计划信息
	 */
	public IGDWP0001Info getPlan() {
		return plan;
	}

	/**
	 * 计划信息设定
	 * @param plan 计划信息
	 */
	public void setPlan(IGDWP0001Info plan) {
		this.plan = plan;
	}

	/**
	 * 流程定义信息取得
	 * @return processDefinition 流程定义信息
	 */
	public IG380Info getProcessDefinition() {
		return processDefinition;
	}

	/**
	 * 流程定义信息设定
	 * @param processDefinition 流程定义信息
	 */
	public void setProcessDefinition(IG380Info processDefinition) {
		this.processDefinition = processDefinition;
	}

	/**
	 * 状态定义信息取得
	 * @return processStatusDef 状态定义信息
	 */
	public IG333Info getProcessStatusDef() {
		return processStatusDef;
	}

	/**
	 * 状态定义信息设定
	 * @param processStatusDef 状态定义信息
	 */
	public void setProcessStatusDef(IG333Info processStatusDef) {
		this.processStatusDef = processStatusDef;
	}

	/**
	 * 下拉列表信息取得
	 * @return labelValueBeanList 下拉列表信息
	 */
	public List<LabelValueBean> getLabelValueBeanList() {
		return labelValueBeanList;
	}

	/**
	 * 下拉列表信息设定
	 * @param labelValueBeanList 下拉列表信息
	 */
	public void setLabelValueBeanList(List<LabelValueBean> labelValueBeanList) {
		this.labelValueBeanList = labelValueBeanList;
	}

	/**
	 * 流程标题定义信息取得
	 * @return ptdInfo 流程标题定义信息
	 */
	public IG243Info getPtdInfo() {
		return ptdInfo;
	}

	/**
	 * 流程标题定义信息设定
	 * @param ptdInfo 流程标题定义信息
	 */
	public void setPtdInfo(IG243Info ptdInfo) {
		this.ptdInfo = ptdInfo;
	}

	/**
	 * 流程表单定义信息集合取得
	 * @return processInfoList 流程表单定义信息集合
	 */
	public List<IG007Info> getProcessInfoList() {
		return processInfoList;
	}

	/**
	 * 流程表单定义信息集合设定
	 * @param processInfoList 流程表单定义信息集合
	 */
	public void setProcessInfoList(List<IG007Info> processInfoList) {
		this.processInfoList = processInfoList;
	}
}
