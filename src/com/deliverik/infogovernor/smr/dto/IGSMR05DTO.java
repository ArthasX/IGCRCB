/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.smr.dto;

import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.infogovernor.smr.form.IGSMR0501Form;
import com.deliverik.infogovernor.smr.form.IGSMR0502Form;
import com.deliverik.infogovernor.smr.model.ReportHistoryVWInfo;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 报表相关业务逻辑处理dto
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGSMR05DTO extends BaseDTO{
	
	/** 历史数据信息查询form */
	protected IGSMR0501Form igsmr0501Form;
	
	/** 填报说明form */
	protected IGSMR0502Form igsmr0502Form;
	
	/** 分组信息集合 */
	protected List<ReportHistoryVWInfo> reportHistoryVWInfoList;

	/**
	 * 历史数据信息查询form取得
	 * @return igsmr0501Form 历史数据信息查询form
	 */
	public IGSMR0501Form getIgsmr0501Form() {
		return igsmr0501Form;
	}

	/**
	 * 历史数据信息查询form设定
	 * @param igsmr0501Form 历史数据信息查询form
	 */
	public void setIgsmr0501Form(IGSMR0501Form igsmr0501Form) {
		this.igsmr0501Form = igsmr0501Form;
	}

	/**
	 * 分组信息集合取得
	 * @return reportHistoryVWInfoList 分组信息集合
	 */
	public List<ReportHistoryVWInfo> getReportHistoryVWInfoList() {
		return reportHistoryVWInfoList;
	}

	/**
	 * 分组信息集合设定
	 * @param reportHistoryVWInfoList 分组信息集合
	 */
	public void setReportHistoryVWInfoList(
			List<ReportHistoryVWInfo> reportHistoryVWInfoList) {
		this.reportHistoryVWInfoList = reportHistoryVWInfoList;
	}

	/**
	 * 填报说明form取得
	 * @return igsmr0502Form 填报说明form
	 */
	public IGSMR0502Form getIgsmr0502Form() {
		return igsmr0502Form;
	}

	/**
	 * 填报说明form设定
	 * @param igsmr0502Form 填报说明form
	 */
	public void setIgsmr0502Form(IGSMR0502Form igsmr0502Form) {
		this.igsmr0502Form = igsmr0502Form;
	}
}
