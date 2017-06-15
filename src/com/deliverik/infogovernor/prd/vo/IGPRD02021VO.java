/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prd.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程定义简略显示VO
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGPRD02021VO extends BaseVO{

	/** 流程图XML */
	protected String flowChartXML;
	
	/** 流程图高度 */
	protected Integer flowChartHeight;
	
	/** 节点信息集合 */
	protected List<IGPRD02022VO> voList;

	/**
	 * 流程图XML取得
	 * @return flowChartXML 流程图XML
	 */
	public String getFlowChartXML() {
		return flowChartXML;
	}

	/**
	 * 流程图XML设定
	 * @param flowChartXML 流程图XML
	 */
	public void setFlowChartXML(String flowChartXML) {
		this.flowChartXML = flowChartXML;
	}

	/**
	 * 流程图高度取得
	 * @return flowChartHeight 流程图高度
	 */
	public Integer getFlowChartHeight() {
		return flowChartHeight;
	}

	/**
	 * 流程图高度设定
	 * @param flowChartHeight 流程图高度
	 */
	public void setFlowChartHeight(Integer flowChartHeight) {
		this.flowChartHeight = flowChartHeight;
	}

	/**
	 * 节点信息集合取得
	 * @return voList 节点信息集合
	 */
	public List<IGPRD02022VO> getVoList() {
		return voList;
	}

	/**
	 * 节点信息集合设定
	 * @param voList 节点信息集合
	 */
	public void setVoList(List<IGPRD02022VO> voList) {
		this.voList = voList;
	}
}
