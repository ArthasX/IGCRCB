/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.prr.vo;

import java.io.Serializable;

import com.deliverik.framework.base.BaseVO;

/**
 * @Description: ��������ͼ�鿴VO
 * @Author  
 * @History 2010-9-13     �½� 
 * @Version V1.0
 */
@SuppressWarnings("serial")
public class IGPRR01111VO extends BaseVO implements Serializable{
	
	/** ����ͼXML */
	protected String flowChartXml;
	
	/** ����ͼ�߶� */
	protected String xmlheight;
	
	/**
	 * ����ͼXMLȡ��
	 * @return ����ͼXML
	 */
	public String getFlowChartXml() {
		return flowChartXml;
	}

	/**
	 * ����ͼXML�趨
	 * @param flowChartXml ����ͼXML
	 */
	public void setFlowChartXml(String flowChartXml) {
		this.flowChartXml = flowChartXml;
	}

	/**
	 * ����ͼ�߶�ȡ��
	 * @return xmlheight ����ͼ�߶�
	 */
	public String getXmlheight() {
		return xmlheight;
	}

	/**
	 * ����ͼ�߶��趨
	 * @param xmlheight ����ͼ�߶�
	 */
	public void setXmlheight(String xmlheight) {
		this.xmlheight = xmlheight;
	}

}


