/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.smr.form;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 填报说明显示form
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGSMR0502Form extends BaseForm{

	/** 流程定义主键 */
	protected String pdid;
	/** 填报说明 */
	protected String reportdesc;
	/**
	 * 流程定义主键取得
	 * @return pdid 流程定义主键
	 */
	public String getPdid() {
		return pdid;
	}
	/**
	 * 流程定义主键设定
	 * @param pdid 流程定义主键
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}
	/**
	 * 填报说明取得
	 * @return reportdesc 填报说明
	 */
	public String getReportdesc() {
		return reportdesc;
	}
	/**
	 * 填报说明设定
	 * @param reportdesc 填报说明
	 */
	public void setReportdesc(String reportdesc) {
		this.reportdesc = reportdesc;
	}
	
}
