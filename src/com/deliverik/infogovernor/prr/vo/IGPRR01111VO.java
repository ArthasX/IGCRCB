/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.prr.vo;

import java.io.Serializable;

import com.deliverik.framework.base.BaseVO;

/**
 * @Description: 流程流程图查看VO
 * @Author  
 * @History 2010-9-13     新建 
 * @Version V1.0
 */
@SuppressWarnings("serial")
public class IGPRR01111VO extends BaseVO implements Serializable{
	
	/** 流程图XML */
	protected String flowChartXml;
	
	/** 流程图高度 */
	protected String xmlheight;
	
	/**
	 * 流程图XML取得
	 * @return 流程图XML
	 */
	public String getFlowChartXml() {
		return flowChartXml;
	}

	/**
	 * 流程图XML设定
	 * @param flowChartXml 流程图XML
	 */
	public void setFlowChartXml(String flowChartXml) {
		this.flowChartXml = flowChartXml;
	}

	/**
	 * 流程图高度取得
	 * @return xmlheight 流程图高度
	 */
	public String getXmlheight() {
		return xmlheight;
	}

	/**
	 * 流程图高度设定
	 * @param xmlheight 流程图高度
	 */
	public void setXmlheight(String xmlheight) {
		this.xmlheight = xmlheight;
	}

}


