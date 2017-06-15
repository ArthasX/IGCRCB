/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.rpt.vo;

import java.util.ArrayList;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.rpt.model.SOC0202Info;
import com.deliverik.infogovernor.rpt.model.SOC0207Info;

/**
 * 概述: 报告模板新增页面
 * 功能描述: 
 * 创建记录: 杨龙全 2012/06/18
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGRPT02051VO extends BaseVO{
	/**模板集合*/
	protected List<SOC0207Info> reportTemplateList;
	/**默认模板类型*/
	protected String rtDateType;
	/**附加集合*/
	private List<SOC0202Info> reportAnnexationList=new ArrayList<SOC0202Info>();

	/**
	 * 模板集合取得
	 *
	 * @return reportTemplateList 模板集合
	 */
	public List<SOC0207Info> getReportTemplateList() {
		return reportTemplateList;
	}
	/**
	 * 模板集合设定
	 *
	 * @param reportTemplateList 模板集合
	 */
	public void setReportTemplateList(List<SOC0207Info> reportTemplateList) {
		this.reportTemplateList = reportTemplateList;
	}
	/**
	 * 默认模板类型取得
	 *
	 * @return rtDateType 默认模板类型
	 */
	public String getRtDateType() {
		return rtDateType;
	}
	/**
	 * 默认模板类型设定
	 *
	 * @param rtDateType 默认模板类型
	 */
	public void setRtDateType(String rtDateType) {
		this.rtDateType = rtDateType;
	}
	/**
	 * 附加集合取得
	 *
	 * @return reportAnnexationList 附加集合
	 */
	public List<SOC0202Info> getReportAnnexationList() {
		return reportAnnexationList;
	}
	/**
	 * 附加集合设定
	 *
	 * @param reportAnnexationList 附加集合
	 */
	public void setReportAnnexationList(
			List<SOC0202Info> reportAnnexationList) {
		this.reportAnnexationList = reportAnnexationList;
	}
	
}
