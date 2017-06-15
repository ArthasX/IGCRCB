/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.smr.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.smr.model.RegulatoryReportDetailInfo;
import com.deliverik.infogovernor.smr.model.entity.BatchExamineVW;

/**
 * 概述:年报审批
 * 功能描述：年报审批
 * 创建记录： 2013-07-25
 * 修改记录：
 */
@SuppressWarnings("serial")
public class IGSMR04021VO extends BaseVO {

	/** 年报列表 */
	protected List<BatchExamineVW> lst_Report;

	/**
	 * 年报列表取得
	 * 
	 * @return 年报列表
	 */
	public List<BatchExamineVW> getLst_Report() {
		return lst_Report;
	}

	/**
	 * 年报列表设定
	 * 
	 * @param lst_Report 年报列表
	 */
	public void setLst_Report(List<BatchExamineVW> lst_Report) {
		this.lst_Report = lst_Report;
	}
	
}
