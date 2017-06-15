/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prd.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���̶��������ʾVO
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGPRD02021VO extends BaseVO{

	/** ����ͼXML */
	protected String flowChartXML;
	
	/** ����ͼ�߶� */
	protected Integer flowChartHeight;
	
	/** �ڵ���Ϣ���� */
	protected List<IGPRD02022VO> voList;

	/**
	 * ����ͼXMLȡ��
	 * @return flowChartXML ����ͼXML
	 */
	public String getFlowChartXML() {
		return flowChartXML;
	}

	/**
	 * ����ͼXML�趨
	 * @param flowChartXML ����ͼXML
	 */
	public void setFlowChartXML(String flowChartXML) {
		this.flowChartXML = flowChartXML;
	}

	/**
	 * ����ͼ�߶�ȡ��
	 * @return flowChartHeight ����ͼ�߶�
	 */
	public Integer getFlowChartHeight() {
		return flowChartHeight;
	}

	/**
	 * ����ͼ�߶��趨
	 * @param flowChartHeight ����ͼ�߶�
	 */
	public void setFlowChartHeight(Integer flowChartHeight) {
		this.flowChartHeight = flowChartHeight;
	}

	/**
	 * �ڵ���Ϣ����ȡ��
	 * @return voList �ڵ���Ϣ����
	 */
	public List<IGPRD02022VO> getVoList() {
		return voList;
	}

	/**
	 * �ڵ���Ϣ�����趨
	 * @param voList �ڵ���Ϣ����
	 */
	public void setVoList(List<IGPRD02022VO> voList) {
		this.voList = voList;
	}
}
